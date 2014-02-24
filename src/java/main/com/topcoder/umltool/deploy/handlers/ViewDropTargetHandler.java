/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeNodeArrayTransferable;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.AddAcceptEventActionAction;
import com.topcoder.umltool.deploy.actions.undoable.AddActionStateAction;
import com.topcoder.umltool.deploy.actions.undoable.AddActorNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddClassNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddCommentNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddDecisionNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddFinalNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddFlowFinalNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddForkNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddInitialNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddInterfaceNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddJoinNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddMergeNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddObjectFlowNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddObjectNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddPackageNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddSendSignalActionAction;
import com.topcoder.umltool.deploy.actions.undoable.AddSubsystemNodeContainerAction;
import com.topcoder.umltool.deploy.actions.undoable.AddUseCaseNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateDiagramAction;

public class ViewDropTargetHandler implements DropTargetListener {

    private static final Map<String, Set<Class>> DIAGRAM_ELEMENTS_MAP = new HashMap<String, Set<Class>>();

    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * This is a static constructor for this class.
     * </p>
     * <p>
     * Initialize the DIAGRAM_ELEMENTS_MAP.
     * </p>
     */
    static {
        Set<Class> classElements = new HashSet<Class>();
        classElements.add(Actor.class);
        classElements.add(Package.class);
        classElements.add(com.topcoder.uml.model.core.classifiers.Class.class);
        classElements.add(Interface.class);
        classElements.add(Enumeration.class);
        classElements.add(Comment.class);

        Set<Class> useCaseElements = new HashSet<Class>();
        useCaseElements.add(Actor.class);
        useCaseElements.add(Package.class);
        useCaseElements.add(Subsystem.class);
        useCaseElements.add(UseCase.class);
        useCaseElements.add(Comment.class);

        Set<Class> sequenceElements = new HashSet<Class>();
        sequenceElements.add(Object.class);
        sequenceElements.add(Comment.class);

        Set<Class> activityElements = new HashSet<Class>();
        activityElements.add(SimpleState.class);
        activityElements.add(Pseudostate.class);
        activityElements.add(FinalState.class);
        activityElements.add(Comment.class);

        DIAGRAM_ELEMENTS_MAP.put("ClassDiagram", classElements);
        DIAGRAM_ELEMENTS_MAP.put("UseCaseDiagram", useCaseElements);
        DIAGRAM_ELEMENTS_MAP.put("SequenceDiagram", sequenceElements);
        DIAGRAM_ELEMENTS_MAP.put("ActivityDiagram", activityElements);
    }

    /**
     * <p>
     * Constructs this handler.
     * </p>
     * @param mainFrame
     *            main frame window
     * @throws IllegalArgumentException
     *             If mainFrame is null.
     */
    public ViewDropTargetHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Called while a drag operation is ongoing, when the mouse pointer enters the operable part of the drop site for
     * the <code>DropTarget</code> registered with this listener.
     * </p>
     * <p>
     * Accept drag if coming from document tree.
     * </p>
     * @param dtde
     *            the <code>DropTargetDragEvent</code>
     */
    public void dragEnter(DropTargetDragEvent dtde) {
        if (dtde.isDataFlavorSupported(DocumentTreeNodeArrayTransferable.DATA_FLAVOR)) {
            dtde.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
        }
    }

    /**
     * <p>
     * Called when a drag operation is ongoing, while the mouse pointer is still over the operable part of the drop site
     * for the <code>DropTarget</code> registered with this listener.
     * </p>
     * @param dtde
     *            the <code>DropTargetDragEvent</code>
     */

    public void dragOver(DropTargetDragEvent dtde) {
        // empty
    }

    /**
     * <p>
     * Called if the user has modified the current drop gesture.
     * </P>
     * @param dtde
     *            the <code>DropTargetDragEvent</code>
     */
    public void dropActionChanged(DropTargetDragEvent dtde) {
        // empty
    }

    /**
     * <p>
     * Called while a drag operation is ongoing, when the mouse pointer has exited the operable part of the drop site
     * for the <code>DropTarget</code> registered with this listener.
     * </p>
     * @param dte
     *            the <code>DropTargetEvent</code>
     */

    public void dragExit(DropTargetEvent dte) {
        // empty
    }

    /**
     * <p>
     * Adding the valid dragged elements to diagram when dropped.
     * </p>
     * @param dtde
     *            the <code>DropTargetDropEvent</code>
     */
    public void drop(DropTargetDropEvent dtde) {
        Transferable t = dtde.getTransferable();

        DocumentTreeNode[] treeNodes = null;
        try {
            treeNodes = (DocumentTreeNode[]) t.getTransferData(DocumentTreeNodeArrayTransferable.DATA_FLAVOR);
        } catch (Exception e) {
            DeployHelper.logException(e);
        }

        if (treeNodes == null) {
            return;
        }

        Point location = dtde.getLocation();

        DiagramView view = DeployHelper.getDiagramView(mainFrame);

        Diagram diagram = view.getDiagram();

        UpdateDiagramAction compositeAction = new UpdateDiagramAction(view, "Add elements to diagram");

        for (DocumentTreeNode treeNode : treeNodes) {
            java.lang.Object object = treeNode.getNodeObject();
            ModelElement modelElement = null;
            if (object instanceof GraphNode) {
                modelElement = DeployHelper.getElement((GraphElement) object);
            } else if (object instanceof ModelElement) {
                modelElement = (ModelElement) object;
            }

            if (modelElement != null && isSupportedModelElement(modelElement, diagram)) {
                compositeAction.put(getAddNodeAction(view, modelElement, location), view);
            }
        }

        mainFrame.handleActionEvent(compositeAction, view, "Add dragged elements");
        mainFrame.getDocumentTree().updateTree();
        DeployHelper.notifySelectionChanged(mainFrame, view);
    }

    /**
     * <p>
     * Gets the AddNodeAction for given model element.
     * </p>
     * @param view
     *            diagram view to add node
     * @param modelElement
     *            model element to be added
     * @param location
     *            the location of new added node
     * @return the corresponding AddNodeAction
     */
    private AddNodeAction getAddNodeAction(DiagramView view, ModelElement modelElement, Point location) {
        AddNodeAction action = null;
        if (modelElement instanceof UseCase) {
            action = new AddUseCaseNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_USECASE_SIZE,
                    (UseCase) modelElement);
        } else if (modelElement instanceof Actor) {
            action = new AddActorNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_ACTOR_SIZE,
                    (Actor) modelElement);
        } else if (modelElement instanceof Subsystem) {
            action = new AddSubsystemNodeContainerAction(mainFrame, view, location,
                    HandlerHelper.DEFAULT_SUBSYSTEM_SIZE, (Subsystem) modelElement);
        } else if (modelElement instanceof SimpleState) {
            if (modelElement instanceof com.topcoder.uml.model.activitygraphs.ActionState) {
                action = new AddActionStateAction(mainFrame, view, location, HandlerHelper.DEFAULT_ACTIONSTATE_SIZE,
                        (com.topcoder.uml.model.activitygraphs.ActionState) modelElement);
            } else if (modelElement instanceof ObjectFlowState) {
                action = new AddObjectFlowNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_OBJECTFLOW_SIZE,
                        (ObjectFlowState) modelElement);
            } else {
                SimpleState state = (SimpleState) modelElement;
                if (DeployHelper.isSendSignal(state)) {
                    action = new AddSendSignalActionAction(mainFrame, view, location,
                            HandlerHelper.DEFAULT_SENDSIGNAL_SIZE, (SimpleState) modelElement);
                } else {
                    action = new AddAcceptEventActionAction(mainFrame, view, location,
                            HandlerHelper.DEFAULT_ACCEPTEVENT_SIZE, (SimpleState) modelElement);
                }
            }
        } else if (modelElement instanceof Pseudostate) {
            Pseudostate state = (Pseudostate) modelElement;
            if (state.getKind() == PseudostateKind.CHOICE) {
                action = new AddDecisionNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_DECISION_SIZE,
                        (Pseudostate) modelElement);
            } else if (state.getKind() == PseudostateKind.FORK) {
                action = new AddForkNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_FORK_SIZE,
                        (Pseudostate) modelElement);
            } else if (state.getKind() == PseudostateKind.INITIAL) {
                action = new AddInitialNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_INITIAL_SIZE,
                        (Pseudostate) modelElement);
            } else if (state.getKind() == PseudostateKind.JOIN) {
                action = new AddJoinNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_JOIN_SIZE,
                        (Pseudostate) modelElement);
            } else if (state.getKind() == PseudostateKind.JUNCTION) {
                action = new AddMergeNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_MERGE_SIZE,
                        (Pseudostate) modelElement);
            }
        } else if (modelElement instanceof FinalState) {
            FinalState state = (FinalState) modelElement;
            if (DeployHelper.isFlowFinal(state)) {
                action = new AddFlowFinalNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_FLOWFINAL_SIZE,
                        (FinalState) modelElement);
            } else {
                action = new AddFinalNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_FINAL_SIZE,
                        (FinalState) modelElement);
            }
        } else if (modelElement instanceof Object) {
            action = new AddObjectNodeAction(mainFrame, view, location, (Object) modelElement);
        } else if (modelElement instanceof Comment) {
            action = new AddCommentNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_COMMENT_SIZE,
                    (Comment) modelElement);
        } else if (modelElement instanceof Package) {
            action = new AddPackageNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_PACKAGE_SIZE,
                    (Package) modelElement);
        } else if (modelElement instanceof Interface) {
            action = new AddInterfaceNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_CLASS_SIZE,
                    (Interface) modelElement);
        } else if (modelElement instanceof com.topcoder.uml.model.core.classifiers.Class) {
            action = new AddClassNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_CLASS_SIZE,
                    (com.topcoder.uml.model.core.classifiers.Class) modelElement);
        }
        return action;
    }

    /**
     * <p>
     * Checks whether the model element is supported by given diagram.
     * </p>
     * @param modelElement
     *            model element to be added
     * @param diagram
     *            diagram to add model element
     * @return ture if supported, false otherwise
     */
    private boolean isSupportedModelElement(ModelElement modelElement, Diagram diagram) {
        Set<Class> allowedElements = DIAGRAM_ELEMENTS_MAP.get(DeployHelper.getTypeInfo(diagram));
        for (Class<?> class1 : allowedElements) {
            if (class1.isAssignableFrom(modelElement.getClass())) {
                return true;
            }
        }
        return false;
    }

}
