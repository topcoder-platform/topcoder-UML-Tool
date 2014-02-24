/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.comment.model.PasteCommentAction;
import com.topcoder.uml.actions.diagram.elements.PasteDiagramElementAction;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
import com.topcoder.uml.actions.model.activity.PasteAcceptEventActionAction;
import com.topcoder.uml.actions.model.activity.PasteActionStateAction;
import com.topcoder.uml.actions.model.activity.PasteDecisionNodeAction;
import com.topcoder.uml.actions.model.activity.PasteFinalNodeAction;
import com.topcoder.uml.actions.model.activity.PasteFlowFinalNodeAction;
import com.topcoder.uml.actions.model.activity.PasteForkNodeAction;
import com.topcoder.uml.actions.model.activity.PasteInitialNodeAction;
import com.topcoder.uml.actions.model.activity.PasteJoinNodeAction;
import com.topcoder.uml.actions.model.activity.PasteMergeNodeAction;
import com.topcoder.uml.actions.model.activity.PasteObjectFlowStateAction;
import com.topcoder.uml.actions.model.activity.PasteSendSignalActionAction;
import com.topcoder.uml.actions.model.activity.PasteTransitionAction;
import com.topcoder.uml.actions.model.classifiers.PasteAbstractionAction;
import com.topcoder.uml.actions.model.classifiers.PasteAssociationAction;
import com.topcoder.uml.actions.model.classifiers.PasteClassAction;
import com.topcoder.uml.actions.model.classifiers.PasteDependencyAction;
import com.topcoder.uml.actions.model.classifiers.PasteGeneralizationAction;
import com.topcoder.uml.actions.model.classifiers.PasteInterfaceAction;
import com.topcoder.uml.actions.model.classifiers.PastePackageAction;
import com.topcoder.uml.actions.model.sequence.PasteAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.PasteCreateMessageAction;
import com.topcoder.uml.actions.model.sequence.PasteObjectAction;
import com.topcoder.uml.actions.model.sequence.PasteReturnMessageAction;
import com.topcoder.uml.actions.model.sequence.PasteSendSignalMessageAction;
import com.topcoder.uml.actions.model.sequence.PasteSynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.actions.model.usecase.PasteActorAction;
import com.topcoder.uml.actions.model.usecase.PasteExtendAction;
import com.topcoder.uml.actions.model.usecase.PasteIncludeAction;
import com.topcoder.uml.actions.model.usecase.PasteSubsystemAction;
import com.topcoder.uml.actions.model.usecase.PasteUseCaseAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.GeneralizableElement;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;
import com.topcoder.umltool.deploy.actions.undoable.PasteComponentAction;
import com.topcoder.umltool.deploy.actions.undoable.PastePolylineNodeAction;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * Action to paste elements.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class PasteAction extends AbstractAction {
    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -2873752707169317598L;

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "Paste";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Paste.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/Paste_16.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY =
        KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/Paste.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Reference to uml model manager.
     * </p>
     */
    private UMLModelManager modelManager;

    /**
     * <p>
     * Constructs an instance of paste element action.
     * <p>
     *
     * @param mainFrame
     *            main frame of uml tool
     */
    public PasteAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(PasteAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(PasteAction.class
            .getResource(TOOLBAR_ICON_FILE_NAME)));

        this.mainFrame = mainFrame;
        this.modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     *
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        if (mainFrame.getClipboardMap().isEmpty()) {
            return;
        }

        DiagramView diagramView = DeployHelper.getDiagramView(mainFrame);
        if (diagramView == null) {
            return;
        }

        CompositeUndoableAction compositeAction = new CompositeUndoableAction(mainFrame, "Paste");

        Diagram diagram = diagramView.getDiagram();

        filterByDiagram(diagram);

        pasteToDiagram(diagram, compositeAction);

        Dimension newSize = getPreferredNewDiagramSize(diagramView);
        if (newSize.getWidth() != diagramView.getDiagram().getSize().getWidth()
            || newSize.getHeight() != diagramView.getDiagram().getSize().getHeight()) {
            ChangeSizeAction resizeAction = new ChangeSizeAction(diagramView.getDiagram(), newSize);
            compositeAction.put(resizeAction, diagramView);
        }

        mainFrame.handleActionEvent(compositeAction, mainFrame, compositeAction.getPresentationName());

        connectEdges(diagram);
        setContainer(diagram);

        if (DeployHelper.getTypeInfo(diagram)
            .equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.SEQUENCE.ordinal()])) {
            DeployHelper.layoutSequenceEdges(mainFrame, diagramView);
        }

        mainFrame.getClipboardMap().clear();
    }

    /**
     * <p>
     * Does the paste operation for one diagram.
     * </p>
     *
     * @param diagram
     *            the diagram to be pasted to
     * @param compositeAction
     *            composite action that each single paste action to be added to
     */
    private void pasteToDiagram(Diagram diagram, CompositeUndoableAction compositeAction) {
        Map<Object, Clipboard> clipboardMap = mainFrame.getClipboardMap();
        for (Object object : clipboardMap.keySet()) {
            Transferable transferable = clipboardMap.get(object).getContents(mainFrame);
            UndoableAction action;
            if (object instanceof JComponent) {
                // paste graph element in diagram
                action = new PasteDiagramElementAction(transferable, diagram);
                compositeAction.put(action, object);

                // paste component in diagram view
                if (object instanceof AssociationEdge) {
                    action = createPasteAssociationAction(diagram, (AssociationEdge) object);
                } else if (object instanceof GeneralizationEdge) {
                    action = createPasteGeneralizationAction(diagram, (GeneralizationEdge) object);
                } else {
                    action =
                        new PasteComponentAction(mainFrame, (GraphElement) CopyPasteCutUtil
                            .getCloneDiagramElement(mainFrame, object), diagram);
                }
                compositeAction.put(action, object);
            } else if (object instanceof ModelElement) {
                action = createPasteModelElementAction(diagram, transferable, (ModelElement) object);
                compositeAction.put(action, object);
            } else if (object instanceof Polyline) {
                action = new PastePolylineNodeAction(mainFrame, transferable, diagram);
                compositeAction.put(action, transferable);
            } else {
                // TODO
            }
        }
    }

    /**
     * <p>
     * Creates a paste model element action with the given model element.
     * </p>
     *
     * @param diagram
     *            diagram to be pasted to
     * @param transferable
     *            transferable to get data
     * @param modelElement
     *            model element to be copied
     * @return the created paste model element action
     */
    private UndoableAction createPasteModelElementAction(Diagram diagram, Transferable transferable,
        ModelElement modelElement) {
        UndoableAction action = null;
        ActivityGraph activityGraph = getActivityGraph(diagram);
        Collaboration collaboration = getCollaboration(diagram);
        try {
            if (modelElement instanceof Actor) {
                action = new PasteActorAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof UseCase) {
                action = new PasteUseCaseAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof Subsystem) {
                action = new PasteSubsystemAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof Include) {
                action = new PasteIncludeAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof Extend) {
                action = new PasteExtendAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof ActionState) {
                Object object = transferable.getTransferData(ActivityDataFlavor.ACTION_STATE);
                action = new PasteActionStateAction(object, activityGraph);
            } else if (modelElement instanceof Pseudostate) {
                action = createPastePseudostateAction(activityGraph, (Pseudostate) modelElement, transferable);
            } else if (modelElement instanceof FinalState) {
                if (DeployHelper.isFlowFinal((FinalState) modelElement)) {
                    Object object = transferable.getTransferData(ActivityDataFlavor.FLOW_FINAL_NODE);
                    action = new PasteFlowFinalNodeAction(object, activityGraph);
                } else {
                    Object object = transferable.getTransferData(ActivityDataFlavor.FINAL_NODE);
                    action = new PasteFinalNodeAction(object, activityGraph);
                }
            } else if (modelElement instanceof ObjectFlowState) {
                Object object = transferable.getTransferData(ActivityDataFlavor.OBJECT_FLOW_STATE);
                action = new PasteObjectFlowStateAction(object, activityGraph);
            } else if (modelElement instanceof SimpleState) {
                if (DeployHelper.isSendSignal((SimpleState) modelElement)) {
                    Object object = transferable.getTransferData(ActivityDataFlavor.SEND_SIGNAL_ACTION);
                    action = new PasteSendSignalActionAction(object, activityGraph);
                } else {
                    Object object = transferable.getTransferData(ActivityDataFlavor.ACCEPT_EVENT_ACTION);
                    action = new PasteAcceptEventActionAction(object, activityGraph);
                }
            } else if (modelElement instanceof com.topcoder.uml.model.statemachines.Transition) {
                Object object = transferable.getTransferData(ActivityDataFlavor.TRANSITION);
                action = new PasteTransitionAction(object, activityGraph);
            } else if (modelElement instanceof Association) {
                action = new PasteAssociationAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof Abstraction) {
                action = new PasteAbstractionAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof Dependency) {
                action = new PasteDependencyAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof Generalization) {
                action = new PasteGeneralizationAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof Comment) {
                action =
                    new PasteCommentAction(transferable.getTransferData(AuxiliaryElementDataFlavor.COMMENT),
                        modelManager);
            } else if (modelElement instanceof com.topcoder.uml.model.core.classifiers.Class) {
                action = new PasteClassAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof Interface) {
                action = new PasteInterfaceAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof com.topcoder.uml.model.modelmanagement.Package) {
                action = new PastePackageAction(transferable, modelManager.getModel());
            } else if (modelElement instanceof com.topcoder.uml.model.commonbehavior.instances.Object) {
                action = new PasteObjectAction(transferable, collaboration);
            } else if (modelElement instanceof Link) {
                action = createPasteLinkAction(collaboration, (Link) modelElement, transferable);
            } else if (modelElement instanceof Actor) {
                action = new PasteActorAction(transferable, modelManager.getModel());
            }
        } catch (Exception e) {
            DeployHelper.handleException(mainFrame, e, "Create paste model element action failed. ");
        }
        return action;
    }

    /**
     * <p>
     * Creates the paste action to paste association.
     * </p>
     *
     * @param diagram
     *            the diagram to paste association
     * @param associationEdge
     *            the association edge to paste
     * @return the action created
     */
    private UndoableAction createPasteAssociationAction(Diagram diagram, AssociationEdge associationEdge) {
        // gets clone association model element
        GraphEdge graphEdge = (GraphEdge) CopyPasteCutUtil.getCloneDiagramElement(mainFrame, associationEdge);

        return new PasteComponentAction(mainFrame, graphEdge, diagram);
    }

    /**
     * <p>
     * Creates the paste action to paste generalization.
     * </p>
     *
     * @param diagram
     *            the diagram to paste association
     * @param generalizationEdge
     *            the generalization edge to paste
     * @return the action created
     */
    private UndoableAction createPasteGeneralizationAction(Diagram diagram, GeneralizationEdge generalizationEdge) {
        // gets clone generalization model element
        GraphEdge graphEdge = (GraphEdge) CopyPasteCutUtil.getCloneDiagramElement(mainFrame, generalizationEdge);
        Generalization generalization = (Generalization) DeployHelper.getElement(graphEdge);
        GraphElement startNode = graphEdge.getAnchors().get(0).getGraphElement();
        GraphElement endNode = graphEdge.getAnchors().get(1).getGraphElement();

        // if available, sets the parent and child for generalization
        if (startNode != null && endNode != null) {
            generalization.setParent((GeneralizableElement) DeployHelper.getElement(startNode));
            generalization.setChild((GeneralizableElement) DeployHelper.getElement(endNode));
        }

        return new PasteComponentAction(mainFrame, graphEdge, diagram);
    }

    /**
     * <p>
     * Creates the paste pseudo state actioin.
     * </p>
     *
     * @param activityGraph
     *            the activity graph to be added to
     * @param pseudostate
     *            model element of Pseudostate type
     * @param transferable
     *            transferable used for paste
     * @return the created paste pseudostate action
     * @throws IOException
     *             if any I/O error
     * @throws UnsupportedFlavorException
     *             if not supported
     */
    private static UndoableAction createPastePseudostateAction(ActivityGraph activityGraph,
        Pseudostate pseudostate, Transferable transferable) throws UnsupportedFlavorException, IOException {
        UndoableAction action = null;
        if (pseudostate.getKind() == PseudostateKind.CHOICE) {
            Object object = transferable.getTransferData(ActivityDataFlavor.DECISION_NODE);
            return new PasteDecisionNodeAction(object, activityGraph);
        } else if (pseudostate.getKind() == PseudostateKind.FORK) {
            Object object = transferable.getTransferData(ActivityDataFlavor.FORK_NODE);
            return new PasteForkNodeAction(object, activityGraph);
        } else if (pseudostate.getKind() == PseudostateKind.INITIAL) {
            Object object = transferable.getTransferData(ActivityDataFlavor.INITIAL_NODE);
            return new PasteInitialNodeAction(object, activityGraph);
        } else if (pseudostate.getKind() == PseudostateKind.JOIN) {
            Object object = transferable.getTransferData(ActivityDataFlavor.JOIN_NODE);
            return new PasteJoinNodeAction(object, activityGraph);
        } else if (pseudostate.getKind() == PseudostateKind.JUNCTION) {
            Object object = transferable.getTransferData(ActivityDataFlavor.MERGE_NODE);
            return new PasteMergeNodeAction(object, activityGraph);
        }
        return action;
    }

    /**
     * <p>
     * Creates the paste link actioin.
     * </p>
     *
     * @param collaboration
     *            the collaboration to be added to
     * @param link
     *            model element of Link type
     * @param transferable
     *            transferable used for paste
     * @return the created paste link action
     * @throws SequenceConfigurationException
     *             if configuration exception happens
     * @throws IOException
     * @throws UnsupportedFlavorException
     */
    private static UndoableAction createPasteLinkAction(Collaboration collaboration, Link link,
        Transferable transferable) throws SequenceConfigurationException, UnsupportedFlavorException, IOException {
        Stimulus stimulus = link.getStimuli().iterator().next();
        Procedure procedure = stimulus.getDispatchAction();

        if (procedure != null) {
            com.topcoder.uml.model.actions.Action action = procedure.getAction();
            if (action instanceof CallOperationAction) {
                if (((CallOperationAction) action).isAsynchronous()) {
                    return new PasteAsynchronousMessageAction(transferable, collaboration);
                } else {
                    return new PasteSynchronousMessageAction(transferable, collaboration);
                }
            } else if (action instanceof CreateObjectAction) {
                return new PasteCreateMessageAction(transferable, collaboration);
            } else if (action instanceof com.topcoder.uml.model.actions.messagingactions.SendSignalAction) {
                return new PasteSendSignalMessageAction(transferable, collaboration);
            } else if (action == null) {
                return new PasteReturnMessageAction(transferable, collaboration);
            }
        }
        return null;
    }

    /**
     * <p>
     * Filters the nodes and edges not match to diagram type, already existed nodes, and invalid edges.
     * </p>
     *
     * @param diagram
     *            diagram to be pasted to
     */
    private void filterByDiagram(Diagram diagram) {
        Map<Object, Clipboard> clipboardMap = mainFrame.getClipboardMap();
        Map<Object, Clipboard> cloneMap = new HashMap<Object, Clipboard>(clipboardMap);

        for (Object object : cloneMap.keySet()) {
            ModelElement modelElement = null;

            // gets the model element
            if (object instanceof ModelElement) {
                modelElement =
                    CopyPasteCutUtil.getCloneModelElement(mainFrame, (ModelElement) object, clipboardMap.get(
                        object).getContents(mainFrame));
            } else if (object instanceof JComponent) {
                GraphElement graphElement =
                    (GraphElement) CopyPasteCutUtil.getCloneDiagramElement(mainFrame, object);
                modelElement = DeployHelper.getElement(graphElement);
            }

            // check whether can be added to the diagram
            if (modelElement != null && !isAddable(diagram, modelElement)) {
                clipboardMap.remove(object);
            }

            if (object instanceof StereotypeTextField) {
                List<Object> nodes = DeployHelper.getFilteredSelectedNodes(mainFrame);
                for (Object node : nodes) {
                    if (!(node instanceof ClassNode)) {
                        clipboardMap.remove(node);
                    }
                }
            } else {
                // filter already existed graph elements
                GraphElement graphElement = DeployHelper.getGraphElement(modelElement, diagram);
                if (graphElement != null) {
                    clipboardMap.remove(object);
                    clipboardMap.remove(graphElement);
                }
            }
        }

        // filter invalid edges
        filterEdgesByDiagram(diagram);
    }

    /**
     * <p>
     * Filters invalid edges from the transferable data map.
     * </p>
     * <p>
     * Edges with two nodes are allowed to be paste. For copy representation, nodes could be find in both copy list
     * and copy to diagram. For copy complete, nodes could be find only in copy lists.
     * </p>
     *
     * @param diagram
     *            diagram to be pasted to
     */
    private void filterEdgesByDiagram(Diagram diagram) {
        Map<Object, Clipboard> clipboardMap = mainFrame.getClipboardMap();
        Map<Object, Clipboard> cloneMap = new HashMap<Object, Clipboard>(clipboardMap);

        for (Object object : cloneMap.keySet()) {
            if (object instanceof Edge) {
                GraphEdge originalGraphEdge = ((Edge) object).getGraphEdge();
                GraphEdge graphEdge = (GraphEdge) CopyPasteCutUtil.getCloneDiagramElement(mainFrame, object);

                boolean isCopyComplete =
                    DeployHelper.getElement(originalGraphEdge) != DeployHelper.getElement(graphEdge);

                // gets original start graph node
                GraphElement originalStartNode = graphEdge.getAnchors().get(0).getGraphElement();
                GraphNode startNode = getCloneGraphNode(clipboardMap, originalStartNode);
                if (startNode == null && !isCopyComplete) {
                    startNode =
                        (GraphNode) DeployHelper.getGraphElement(DeployHelper.getElement(originalStartNode),
                            diagram);
                }

                // gets original end graph node of the graph edge
                GraphElement originalEndNode = graphEdge.getAnchors().get(1).getGraphElement();
                GraphNode endNode = getCloneGraphNode(clipboardMap, originalEndNode);
                if (endNode == null && !isCopyComplete) {
                    endNode =
                        (GraphNode) DeployHelper
                            .getGraphElement(DeployHelper.getElement(originalEndNode), diagram);
                }

                // one node is not exist, filters the edge
                if (startNode == null || endNode == null) {
                    clipboardMap.remove(object);
                    ModelElement modelElement = DeployHelper.getElement(originalGraphEdge);
                    clipboardMap.remove(modelElement);
                }
            }
        }
    }

    /**
     * <p>
     * Gets the cloned graph node of the given graph element.
     * </p>
     *
     * @param clipboardMap
     *            the clipboard data map to find the cloned graph node
     * @param graphElement
     *            the graph element to be cloned
     * @return the cloned graph node if found, otherwise return null
     */
    private GraphNode getCloneGraphNode(Map<Object, Clipboard> clipboardMap, GraphElement graphElement) {
        ModelElement modelElement = DeployHelper.getElement(graphElement);
        for (Object object : clipboardMap.keySet()) {
            if (object instanceof Node && DeployHelper.getElement((JComponent) object) == modelElement) {
                return (GraphNode) CopyPasteCutUtil.getCloneDiagramElement(mainFrame, object);
            }
        }
        return null;
    }

    /**
     * <p>
     * Checks whether a model element is allowed to add to a diagram.
     * </p>
     *
     * @param diagram
     *            the diagram to be added to
     * @param modelElement
     *            the model element to be added
     * @return true if it is allowed to add the model element to the diagram, otherwise false
     */
    private boolean isAddable(Diagram diagram, ModelElement modelElement) {
        // auxiliary elements
        if (modelElement instanceof Comment) {
            return true;
        }

        SimpleSemanticModelElement element = (SimpleSemanticModelElement) diagram.getSemanticModel();
        String type = element.getTypeInfo();
        if (type.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.CLASS.ordinal()])) {
            if (modelElement instanceof com.topcoder.uml.model.core.classifiers.Class
                || modelElement instanceof Interface
                || modelElement instanceof com.topcoder.uml.model.modelmanagement.Package
                || modelElement instanceof Actor || modelElement instanceof Generalization
                || modelElement instanceof Dependency || modelElement instanceof Association
                || modelElement instanceof Abstraction || modelElement instanceof Package
                || modelElement instanceof Attribute || modelElement instanceof Operation) {
                return true;
            }
        } else if (type.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.USECASE.ordinal()])) {
            if (modelElement instanceof UseCase || modelElement instanceof Actor
                || modelElement instanceof Subsystem || modelElement instanceof Include
                || modelElement instanceof Extend || modelElement instanceof Association
                || modelElement instanceof Dependency || modelElement instanceof Generalization
                || modelElement instanceof Package) {
                return true;
            }
        } else if (type.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.SEQUENCE.ordinal()])) {
            if (modelElement instanceof com.topcoder.uml.model.commonbehavior.instances.Object
                || modelElement instanceof Stimulus || modelElement instanceof Link) {
                return true;
            }
        } else if (type.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.ACTIVITY.ordinal()])) {
            if (modelElement instanceof SimpleState || modelElement instanceof Pseudostate
                || modelElement instanceof State
                || modelElement instanceof com.topcoder.uml.model.statemachines.Transition) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>
     * Connects the pasted edges with nodes.
     * </p>
     *
     * @param diagram
     *            the diagram to be pasted to
     */
    private void connectEdges(Diagram diagram) {
        Map<Object, Clipboard> clipboardMap = mainFrame.getClipboardMap();
        for (Object object : clipboardMap.keySet()) {
            if (object instanceof Edge) {
                // gets the pasted edge
                GraphEdge graphEdge = (GraphEdge) CopyPasteCutUtil.getCloneDiagramElement(mainFrame, object);

                GraphNode originalStartNode = (GraphNode) graphEdge.getAnchors().get(0).getGraphElement();
                GraphNode originalEndNode = (GraphNode) graphEdge.getAnchors().get(1).getGraphElement();

                // gets the graph node of the nodes connected with pasted edge
                GraphNode startNode = getCloneGraphNode(clipboardMap, originalStartNode);
                GraphNode endNode = getCloneGraphNode(clipboardMap, originalEndNode);
                if (startNode == null) {
                    startNode =
                        (GraphNode) DeployHelper.getGraphElement(DeployHelper.getElement(originalStartNode),
                            diagram);
                }
                if (endNode == null) {
                    endNode =
                        (GraphNode) DeployHelper
                            .getGraphElement(DeployHelper.getElement(originalEndNode), diagram);
                }

                connectEdge(graphEdge, startNode, endNode);
            }
        }
    }

    /**
     * <p>
     * Connects the graph edge with two graph nodes.
     * </p>
     *
     * @param graphEdge
     *            the graph edge to connect
     * @param startNode
     *            the start graph node to connect
     * @param endNode
     *            the end graph node to connect
     */
    private void connectEdge(GraphEdge graphEdge, GraphNode startNode, GraphNode endNode) {
        graphEdge.clearAnchors();
        DeployHelper.connectEdgeWithNodes(graphEdge, startNode, endNode);

        // gets the components of pasted graph elements
        Edge edge = (Edge) DeployHelper.getComponent(graphEdge, mainFrame);
        Node start = (Node) DeployHelper.getComponent(startNode, mainFrame);
        Node end = (Node) DeployHelper.getComponent(endNode, mainFrame);

        // gets and sets the connector of the pasted edge
        Connector leftConnector = DeployHelper.getConnector(start);
        Connector rightConnector = DeployHelper.getConnector(end);
        edge.setLeftConnector(leftConnector);
        edge.setRightConnector(rightConnector);

        // updates the waypoints of the pasted edge
        Point point = graphEdge.getWaypoints().get(1);
        graphEdge.setWaypoint(0, DeployHelper.createPoint(leftConnector.getConnectionPoint(new java.awt.Point(
            (int) point.getX(), (int) point.getY()))));
        point = graphEdge.getWaypoints().get(graphEdge.getWaypoints().size() - 2);
        graphEdge.setWaypoint(graphEdge.getWaypoints().size() - 1, DeployHelper.createPoint(rightConnector
            .getConnectionPoint(new java.awt.Point((int) point.getX(), (int) point.getY()))));

        DeployHelper.updateEdgeWayPoint(edge, mainFrame);
    }

    /**
     * <p>
     * Gets the activity graph of the given diagram.
     * </p>
     *
     * @param diagram
     *            diagram to get activity graph
     * @return if diagram is activity diagram, then activity graph is returned, otherwise null
     */
    private ActivityGraph getActivityGraph(Diagram diagram) {
        SimpleSemanticModelElement element = (SimpleSemanticModelElement) diagram.getSemanticModel();
        if (element.getTypeInfo().equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.ACTIVITY.ordinal()])) {
            Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram.getOwner();
            return (ActivityGraph) bridge.getElement();
        } else {
            return null;
        }
    }

    /**
     * <p>
     * Gets the collaboration of the given diagram.
     * </p>
     *
     * @param diagram
     *            diagram to get collaboration
     * @return if diagram is sequence diagram, then collaboration is returned, otherwise null
     */
    private Collaboration getCollaboration(Diagram diagram) {
        SimpleSemanticModelElement element = (SimpleSemanticModelElement) diagram.getSemanticModel();
        if (element.getTypeInfo().equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.SEQUENCE.ordinal()])) {
            Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram.getOwner();
            return (Collaboration) bridge.getElement();
        } else {
            return null;
        }
    }

    /**
     * <p>
     * Resets the container nodes.
     * </p>
     *
     * @param diagram
     *            diagram to be copied to
     */
    private void setContainer(Diagram diagram) {
        for (Object object : mainFrame.getClipboardMap().keySet()) {
            if (object instanceof NodeContainer) {
                GraphNode graphNode = (GraphNode) CopyPasteCutUtil.getCloneDiagramElement(mainFrame, object);
                NodeContainer container = (NodeContainer) DeployHelper.getComponent(graphNode, mainFrame);
                GraphNode bodyCompartment = (GraphNode) graphNode.getContaineds().get(1);

                // for each graph element contained in it
                for (DiagramElement originalDiagramElement : new ArrayList<DiagramElement>(bodyCompartment
                    .getContaineds())) {
                    ModelElement originalModelElement =
                        DeployHelper.getElement((GraphElement) originalDiagramElement);
                    if (originalModelElement != null) {
                        // the diagram element has corresponding component
                        // gets the clone diagram element
                        DiagramElement diagramElement =
                            getCloneGraphNode(mainFrame.getClipboardMap(), (GraphElement) originalDiagramElement);

                        if (diagramElement != null) {
                            // resets container
                            diagramElement.getContainer().removeContained(diagramElement);
                            diagramElement.setContainer(bodyCompartment);
                            bodyCompartment.removeContained(originalDiagramElement);
                            bodyCompartment.addContained(diagramElement);
                            Node node = (Node) DeployHelper.getComponent((GraphElement) diagramElement, mainFrame);
                            container.addNode(DeployHelper.BODY_COMPARTMENT, node);
                            DeployHelper.addToOwner(node);
                            DeployHelper.nodeNotifyChange(node, "PASTE", mainFrame);
                            DeployHelper.updateZOrder(container);
                            mainFrame.getDocumentTree().updateTree();
                        }

                    }
                }
            }
        }
    }

    /**
     * <p>
     * Calculates a preferred size for the diagram after pasting.
     * </p>
     *
     * @param view
     *            the diagram view containing the diagram
     * @return a preferred size
     */
    private Dimension getPreferredNewDiagramSize(DiagramView view) {
        Dimension preferredSize = new Dimension();
        DiagramViewer viewer = view.getViewer();
        int viewerGap = viewer.getDiagramViewGap();
        Dimension defaultDiagramSize = new Dimension();
        defaultDiagramSize.setWidth(viewer.getWidth() - viewerGap * 2);
        defaultDiagramSize.setHeight(viewer.getHeight() - viewerGap * 2);
        double width = defaultDiagramSize.getWidth();
        double height = defaultDiagramSize.getHeight();

        Map<Object, Clipboard> clipboardMap = mainFrame.getClipboardMap();
        for (Object object : clipboardMap.keySet()) {
            if (object instanceof Node) {
                Node node = (Node) object;
                GraphNode cloneGraphNode = (GraphNode) CopyPasteCutUtil.getCloneDiagramElement(mainFrame, object);

                java.awt.Point position = node.getLocation();
                position.x += (cloneGraphNode.getPosition().getX() - node.getGraphNode().getPosition().getX());
                position.y += (cloneGraphNode.getPosition().getY() - node.getGraphNode().getPosition().getY());

                java.awt.Dimension size = node.getSize();
                size.width += (cloneGraphNode.getSize().getWidth() - node.getGraphNode().getSize().getWidth());
                size.height += (cloneGraphNode.getSize().getHeight() - node.getGraphNode().getSize().getHeight());

                width = Math.max(width, position.getX() + size.getWidth());
                height = Math.max(height, position.getY() + size.getHeight());
            }
        }

        preferredSize.setWidth(width);
        preferredSize.setHeight(height);
        return preferredSize;
    }
}
