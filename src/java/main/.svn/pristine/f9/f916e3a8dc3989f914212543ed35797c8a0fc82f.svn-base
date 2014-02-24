/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.Object;

import javax.swing.JComponent;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyCommentAction;
import com.topcoder.uml.actions.diagram.RemoveActivityDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveClassDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveSequenceDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveUseCaseDiagramAction;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;
import com.topcoder.uml.actions.diagram.elements.CopyDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.ElementCloneException;
import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
import com.topcoder.uml.actions.model.activity.CopyAcceptEventActionAction;
import com.topcoder.uml.actions.model.activity.CopyActionStateAction;
import com.topcoder.uml.actions.model.activity.CopyDecisionNodeAction;
import com.topcoder.uml.actions.model.activity.CopyFinalNodeAction;
import com.topcoder.uml.actions.model.activity.CopyFlowFinalNodeAction;
import com.topcoder.uml.actions.model.activity.CopyForkNodeAction;
import com.topcoder.uml.actions.model.activity.CopyInitialNodeAction;
import com.topcoder.uml.actions.model.activity.CopyJoinNodeAction;
import com.topcoder.uml.actions.model.activity.CopyMergeNodeAction;
import com.topcoder.uml.actions.model.activity.CopyObjectFlowStateAction;
import com.topcoder.uml.actions.model.activity.CopySendSignalActionAction;
import com.topcoder.uml.actions.model.activity.CopyTransitionAction;
import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.CopyAbstractionAction;
import com.topcoder.uml.actions.model.classifiers.CopyAssociationAction;
import com.topcoder.uml.actions.model.classifiers.CopyClassAction;
import com.topcoder.uml.actions.model.classifiers.CopyDependencyAction;
import com.topcoder.uml.actions.model.classifiers.CopyGeneralizationAction;
import com.topcoder.uml.actions.model.classifiers.CopyInterfaceAction;
import com.topcoder.uml.actions.model.classifiers.CopyPackageAction;
import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.actions.model.sequence.CopyAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.CopyCreateMessageAction;
import com.topcoder.uml.actions.model.sequence.CopyObjectAction;
import com.topcoder.uml.actions.model.sequence.CopyReturnMessageAction;
import com.topcoder.uml.actions.model.sequence.CopySendSignalMessageAction;
import com.topcoder.uml.actions.model.sequence.CopySynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.actions.model.usecase.CopyActorAction;
import com.topcoder.uml.actions.model.usecase.CopyExtendAction;
import com.topcoder.uml.actions.model.usecase.CopyIncludeAction;
import com.topcoder.uml.actions.model.usecase.CopySubsystemAction;
import com.topcoder.uml.actions.model.usecase.CopyUseCaseAction;
import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.StructuralFeature;
import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveCollaborationAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveObjectNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveSequenceEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveStereotypeTextFieldAction;
import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * Util class for copy and paste.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class CopyPasteCutUtil {

    /**
     * <p>
     * Offset for pasted elements.
     * </p>
     */
    private final static java.awt.Point DEFAULT_OFFSET = new java.awt.Point(10, 10);

    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private CopyPasteCutUtil() {
        // Does nothing
    }

    /**
     * <P>
     * Copies the representation of elements.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param copyObjects
     *            set of objects to be copied
     */
    static void copyRepresentation(MainFrame mainFrame, Set<Object> copyObjects) {

        mainFrame.getClipboardMap().clear();

        for (Object object : copyObjects) {
            if (object instanceof Diagram) {
                copyDiagram(mainFrame, (Diagram) object);
            } else if (object instanceof Collaboration) {
                // TODO
            } else if (object instanceof PolylineNode) {
                copyPolylineNode(mainFrame, (PolylineNode) object);
            } else if (object instanceof Edge) {
                copyGraphElement(mainFrame, object, ((Edge) object).getGraphEdge());
            } else if (object instanceof Node) {
                copyNode(mainFrame, (Node) object);
            } else if (object instanceof StereotypeTextField) {
                copyStereotypeTextField(mainFrame, (StereotypeTextField) object);
            } else {
                // TODO
            }
        }
    }

    private static void copyStereotypeTextField(MainFrame mainFrame, StereotypeTextField stereotypeTextField) {
        Clipboard clipboard = new Clipboard("CopyStereotypeTextField");
        GraphNode graphNode = stereotypeTextField.getGraphNode();
        try {
            new CopyDiagramElementAction(graphNode, clipboard).execute();
        } catch (ElementCloneException ece) {
            DeployHelper
                .handleException(mainFrame, ece, "Clone stereotype text field failed: " + ece.getMessage());
        } catch (ActionExecutionException e) {
            DeployHelper.handleException(mainFrame, e, "Copy failed: " + e.getMessage());
        }
        mainFrame.getClipboardMap().put(stereotypeTextField, clipboard);
    }

    private static void copyDiagram(MainFrame mainFrame, Diagram object) {

    }

    /**
     * <p>
     * Copies the representation and model element of elements.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param copyObjects
     *            set of objects to be copied
     */
    static void copyComplete(MainFrame mainFrame, Set<Object> copyObjects) {
        // copies representations
        copyRepresentation(mainFrame, copyObjects);

        for (Object object : copyObjects) {
            if (object instanceof Node || object instanceof Edge) {
                if (!(object instanceof PolylineNode)) {
                    GraphElement graphElement = (GraphElement) getCloneDiagramElement(mainFrame, object);
                    // offsets the pasted elements
                    addPastedOffset(graphElement);
                }
            }
        }

        // copies model elements
        Map<Object, Clipboard> modelElementMap = new HashMap<Object, Clipboard>();
        for (Object object : mainFrame.getClipboardMap().keySet()) {
            if (object instanceof Node || object instanceof Edge) {
                Clipboard clipboard = new Clipboard("CopyModelElement");
                ModelElement modelElement = DeployHelper.getElement((JComponent) object);
                if (modelElement != null) {
                    copyModelElement(mainFrame, modelElement, clipboard);

                    // resets model element in clone graph element
                    GraphElement graphElement = (GraphElement) getCloneDiagramElement(mainFrame, object);
                    DeployHelper.setElement(graphElement, getCloneModelElement(mainFrame, modelElement, clipboard
                        .getContents(mainFrame)));

                    // sets clone features in clone class node
                    if (object instanceof ClassNode) {
                        resetFeature(graphElement);
                    } else if (object instanceof AssociationEdge) {
                        resetAssociationEnds(graphElement);
                    }

                    // adds to model element transferable data map
                    modelElementMap.put(modelElement, clipboard);
                }
            }
        }

        // merges two transferable data maps
        mainFrame.getClipboardMap().putAll(modelElementMap);
    }

    /**
     * <p>
     * Adds offset for given pasted graph element.
     * </p>
     *
     * @param graphElement
     *            the graph element to be pasted
     */
    private static void addPastedOffset(GraphElement graphElement) {
        ModelElement modelElement = DeployHelper.getElement(graphElement);
        int xOff = DEFAULT_OFFSET.x;
        int yOff =
            modelElement instanceof com.topcoder.uml.model.commonbehavior.instances.Object ? 0 : DEFAULT_OFFSET.y;
        if (graphElement instanceof GraphNode) {
            com.topcoder.diagraminterchange.Point oldPosition = graphElement.getPosition();
            if (oldPosition != null) {
                com.topcoder.diagraminterchange.Point newPosition = new com.topcoder.diagraminterchange.Point();
                newPosition.setX(oldPosition.getX() + xOff);
                newPosition.setY(oldPosition.getY() + yOff);
                graphElement.setPosition(newPosition);
            }
        } else if (graphElement instanceof GraphEdge) {
            GraphEdge graphEdge = (GraphEdge) graphElement;
            int size = graphEdge.getWaypoints().size();
            for (int i = 0; i < size; i++) {
                com.topcoder.diagraminterchange.Point oldWayPoint = graphEdge.getWaypoints().get(i);
                com.topcoder.diagraminterchange.Point newWayPoint = new com.topcoder.diagraminterchange.Point();
                newWayPoint.setX(oldWayPoint.getX() + xOff);
                newWayPoint.setY(oldWayPoint.getY() + yOff);
                graphEdge.setWaypoint(i, newWayPoint);
            }

            // UML-561: Copy and paste in sequence diagrams
            for (DiagramElement diagramElement : graphEdge.getContaineds()) {
                if (diagramElement instanceof GraphNode || diagramElement instanceof GraphEdge) {
                    addPastedOffset((GraphElement) diagramElement);
                }
            }
        }
    }

    /**
     * <p>
     * Copies the graph element in component.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param object
     *            object that contains the graph element
     * @param graphElement
     *            graph element to be copied
     */
    static void copyGraphElement(MainFrame mainFrame, Object object, GraphElement graphElement) {
        try {
            if (!mainFrame.getClipboardMap().containsKey(object)) {
                Clipboard clipboard = new Clipboard("CopyGraphElement");
                CopyDiagramElementAction action = new CopyDiagramElementAction(graphElement, clipboard);
                action.execute();
                mainFrame.getClipboardMap().put(object, clipboard);
                if (DeployHelper.getElement(graphElement) == null
                    && DeployHelper.getTypeInfo(graphElement).equals("FreeText")) {
                    cloneTextElement(mainFrame, object);
                }
                if (object instanceof ClassNode) {
                    cloneClassNode(mainFrame, object);
                } else if (object instanceof AssociationEdge) {
                    cloneAssociationEdge(mainFrame, object);
                } else if (object instanceof NodeContainer) {
                    GraphNode newGraphNode = null;
                    ModelElement element = DeployHelper.getElement((NodeContainer) object);
                    if (object instanceof PackageNode) {
                        newGraphNode =
                            DeployHelper.createGraphNodeForPackage(element, new java.awt.Point(),
                                new java.awt.Dimension());
                    } else if (object instanceof SubsystemNodeContainer) {
                        newGraphNode =
                            DeployHelper.createGraphNodeForSubsystem(element, new java.awt.Point(),
                                new java.awt.Dimension());
                    }
                    if (newGraphNode != null) {
                        GraphNode newBody = (GraphNode) newGraphNode.getContaineds().get(1);
                        GraphNode graphNode = (GraphNode) getCloneDiagramElement(mainFrame, object);
                        GraphNode body = (GraphNode) graphNode.getContaineds().get(1);
                        for (DiagramElement diagramElement : body.getContaineds()) {
                            newBody.addContained(diagramElement);
                        }
                        graphNode.clearContaineds();
                        for (DiagramElement diagramElement : newGraphNode.getContaineds()) {
                            graphNode.addContained(diagramElement);
                            diagramElement.setContainer(graphNode);
                        }
                    }
                }

            }
        } catch (ElementCloneException ece) {
            DeployHelper.handleException(mainFrame, ece, "Clone graph element failed: " + ece.getMessage());
        } catch (ActionExecutionException e) {
            DeployHelper.handleException(mainFrame, e, "Copy failed: " + e.getMessage());
        }
    }

    /**
     * <p>
     * Copies the node and components contained by it.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            the node to be copied
     */
    static void copyNode(MainFrame mainFrame, Node node) {
        GraphNode graphNode = node.getGraphNode();
        copyGraphElement(mainFrame, node, graphNode);
        if (node instanceof NodeContainer) {
            NodeContainer container = (NodeContainer) node;
            for (Node containedNode : DeployHelper.getNodes(container)) {
                copyNode(mainFrame, containedNode);
            }
            Set<Edge> edges = getContainedEdges(container);
            for (Edge edge : edges) {
                copyGraphElement(mainFrame, edge, edge.getGraphEdge());
            }
        }
    }

    /**
     * <p>
     * Copies the model element.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param modelElement
     *            model element to be copied
     * @param clipboard
     *            clipboard used for copy
     */
    static void copyModelElement(MainFrame mainFrame, ModelElement modelElement, Clipboard clipboard) {
        Action action = null;
        if (modelElement instanceof Actor) {
            action = new CopyActorAction((Actor) modelElement, clipboard);
        } else if (modelElement instanceof UseCase) {
            action = new CopyUseCaseAction((UseCase) modelElement, clipboard);
        } else if (modelElement instanceof Subsystem) {
            action = new CopySubsystemAction((Subsystem) modelElement, clipboard);
        } else if (modelElement instanceof Include) {
            action = new CopyIncludeAction((Include) modelElement, clipboard);
        } else if (modelElement instanceof Extend) {
            action = new CopyExtendAction((Extend) modelElement, clipboard);
        } else if (modelElement instanceof ActionState) {
            action = new CopyActionStateAction((ActionState) modelElement, clipboard);
        } else if (modelElement instanceof Pseudostate) {
            action = createCopyPseudostateAction((Pseudostate) modelElement, clipboard);
        } else if (modelElement instanceof FinalState) {
            if (DeployHelper.isFlowFinal((FinalState) modelElement)) {
                action = new CopyFlowFinalNodeAction((FinalState) modelElement, clipboard);
            } else {
                action = new CopyFinalNodeAction((FinalState) modelElement, clipboard);
            }
        } else if (modelElement instanceof ObjectFlowState) {
            action = new CopyObjectFlowStateAction((ObjectFlowState) modelElement, clipboard);
        } else if (modelElement instanceof SimpleState) {
            if (DeployHelper.isSendSignal((SimpleState) modelElement)) {
                action = new CopySendSignalActionAction((SimpleState) modelElement, clipboard);
            } else {
                action = new CopyAcceptEventActionAction((SimpleState) modelElement, clipboard);
            }
        } else if (modelElement instanceof Transition) {
            action = new CopyTransitionAction((Transition) modelElement, clipboard);
        } else if (modelElement instanceof Association) {
            action = new CopyAssociationAction((Association) modelElement, clipboard);
        } else if (modelElement instanceof Abstraction) {
            action = new CopyAbstractionAction((Abstraction) modelElement, clipboard);
        } else if (modelElement instanceof Dependency) {
            action = new CopyDependencyAction((Dependency) modelElement, clipboard);
        } else if (modelElement instanceof Generalization) {
            action = new CopyGeneralizationAction((Generalization) modelElement, clipboard);
        } else if (modelElement instanceof Comment) {
            action = new CopyCommentAction((Comment) modelElement, clipboard);
        } else if (modelElement instanceof com.topcoder.uml.model.core.classifiers.Class) {
            action = new CopyClassAction((com.topcoder.uml.model.core.classifiers.Class) modelElement, clipboard);
        } else if (modelElement instanceof Interface) {
            action = new CopyInterfaceAction((Interface) modelElement, clipboard);
        } else if (modelElement instanceof com.topcoder.uml.model.modelmanagement.Package) {
            action =
                new CopyPackageAction((com.topcoder.uml.model.modelmanagement.Package) modelElement, clipboard);
        } else if (modelElement instanceof com.topcoder.uml.model.commonbehavior.instances.Object) {
            action =
                new CopyObjectAction((com.topcoder.uml.model.commonbehavior.instances.Object) modelElement,
                    clipboard);
        } else if (modelElement instanceof Link) {
            action = createCopyLinkAction((Link) modelElement, clipboard);
        } else if (modelElement instanceof Actor) {
            action = new CopyActorAction((Actor) modelElement, clipboard);
        }

        if (action != null) {
            try {
                action.execute();
            } catch (ActionExecutionException e) {
                DeployHelper.handleException(mainFrame, e, "Copy model element failed ");
            }
        }
    }

    /**
     * <p>
     * Copies the polylineNode.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param polylineNode
     *            the node to be copied
     */
    public static void copyPolylineNode(MainFrame mainFrame, PolylineNode polylineNode) {
        Polyline polyline = polylineNode.getPolyline();
        GraphEdge graphEdge = new GraphEdge();
        Polyline copiedPolyline = new Polyline();
        for (com.topcoder.diagraminterchange.Point point : polyline.getWaypoints()) {
            com.topcoder.diagraminterchange.Point newPoint = new com.topcoder.diagraminterchange.Point();
            newPoint.setX(point.getX());
            newPoint.setY(point.getY());
            copiedPolyline.addWaypoint(newPoint);
        }
        copiedPolyline.setClosed(true);
        for (Property property : polylineNode.getPolyline().getProperties()) {
            Property newProperty = new Property();
            newProperty.setKey(property.getKey());
            newProperty.setValue(property.getValue());
            copiedPolyline.addProperty(newProperty);
        }
        graphEdge.addContained(copiedPolyline);
        if (!mainFrame.getClipboardMap().containsKey(polyline)) {
            Clipboard clipboard = new Clipboard("CopyPolylineNode");
            try {
                CopyDiagramElementAction action = new CopyDiagramElementAction(graphEdge, clipboard);
                action.execute();
            } catch (ElementCloneException ece) {
                DeployHelper.handleException(mainFrame, ece, "Clone polyline node failed: " + ece.getMessage());
            } catch (ActionExecutionException e) {
                DeployHelper.handleException(mainFrame, e, "Copy failed: " + e.getMessage());
            }
            mainFrame.getClipboardMap().put(polyline, clipboard);
        }
    }

    /**
     * <p>
     * Gets the cloned diagram element in copy list.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param object
     *            object that is copied
     * @return the cloned diagram element in transferable data
     */
    static DiagramElement getCloneDiagramElement(MainFrame mainFrame, Object object) {
        Transferable transferable = mainFrame.getClipboardMap().get(object).getContents(mainFrame);
        CopiedElement copiedElement = (CopiedElement) transferable;
        DataFlavor dataFlavor = copiedElement.getTransferDataFlavors()[0];
        return (DiagramElement) copiedElement.getTransferData(dataFlavor);
    }

    /**
     * <p>
     * Gets the clone model element in the given clipboard.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param modelElement
     *            model element copied
     * @param transferable
     *            the transferable used for copy
     * @return the clone model element
     */
    static ModelElement getCloneModelElement(MainFrame mainFrame, ModelElement modelElement,
        Transferable transferable) {
        ModelElement cloneModelElement = null;
        try {
            if (modelElement instanceof Actor) {
                cloneModelElement = (ModelElement) transferable.getTransferData(ModelTransfer.ACTOR_FLAVOR);
            } else if (modelElement instanceof UseCase) {
                cloneModelElement = (ModelElement) transferable.getTransferData(ModelTransfer.USECASE_FLAVOR);
            } else if (modelElement instanceof Subsystem) {
                cloneModelElement = (ModelElement) transferable.getTransferData(ModelTransfer.SUBSYSTEM_FLAVOR);
            } else if (modelElement instanceof Include) {
                cloneModelElement = (ModelElement) transferable.getTransferData(ModelTransfer.INCLUDE_FLAVOR);
            } else if (modelElement instanceof Extend) {
                cloneModelElement = (ModelElement) transferable.getTransferData(ModelTransfer.EXTEND_FLAVOR);
            } else if (modelElement instanceof ActionState) {
                cloneModelElement = (ModelElement) transferable.getTransferData(ActivityDataFlavor.ACTION_STATE);
            } else if (modelElement instanceof Pseudostate) {
                cloneModelElement = getClonePseudostate((Pseudostate) modelElement, transferable);
            } else if (modelElement instanceof FinalState) {
                if (DeployHelper.isFlowFinal((FinalState) modelElement)) {
                    cloneModelElement =
                        (ModelElement) transferable.getTransferData(ActivityDataFlavor.FLOW_FINAL_NODE);
                } else {
                    cloneModelElement = (ModelElement) transferable.getTransferData(ActivityDataFlavor.FINAL_NODE);
                }
            } else if (modelElement instanceof ObjectFlowState) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(ActivityDataFlavor.OBJECT_FLOW_STATE);
            } else if (modelElement instanceof SimpleState) {
                if (DeployHelper.isSendSignal((SimpleState) modelElement)) {
                    cloneModelElement =
                        (ModelElement) transferable.getTransferData(ActivityDataFlavor.SEND_SIGNAL_ACTION);
                } else {
                    cloneModelElement =
                        (ModelElement) transferable.getTransferData(ActivityDataFlavor.ACCEPT_EVENT_ACTION);
                }
            } else if (modelElement instanceof Transition) {
                cloneModelElement = (ModelElement) transferable.getTransferData(ActivityDataFlavor.TRANSITION);
            } else if (modelElement instanceof Association) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(ClassElementsTransfer.ASSOCIATION_FLAVOR);
            } else if (modelElement instanceof Abstraction) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(ClassElementsTransfer.ABSTRACTION_FLAVOR);
            } else if (modelElement instanceof Dependency) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(ClassElementsTransfer.DEPENDENCY_FLAVOR);
            } else if (modelElement instanceof Generalization) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(ClassElementsTransfer.GENERALIZATION_FLAVOR);
            } else if (modelElement instanceof Comment) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(AuxiliaryElementDataFlavor.COMMENT);
            } else if (modelElement instanceof com.topcoder.uml.model.core.classifiers.Class) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(ClassElementsTransfer.CLASS_FLAVOR);
            } else if (modelElement instanceof Interface) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(ClassElementsTransfer.INTERFACE_FLAVOR);
            } else if (modelElement instanceof com.topcoder.uml.model.modelmanagement.Package) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(ClassElementsTransfer.PACKAGE_FLAVOR);
            } else if (modelElement instanceof com.topcoder.uml.model.commonbehavior.instances.Object) {
                cloneModelElement =
                    (ModelElement) transferable.getTransferData(CollaborationTransfer.OBJECT_FLAVOR);
            } else if (modelElement instanceof Link) {
                cloneModelElement = (ModelElement) getCloneLink((Link) modelElement, transferable);
            } else if (modelElement instanceof Actor) {
                cloneModelElement = (ModelElement) transferable.getTransferData(ModelTransfer.ACTOR_FLAVOR);
            }
        } catch (Exception e) {
            DeployHelper.handleException(mainFrame, e, "Get clone model element failed. ");
        }
        return cloneModelElement;
    }

    /**
     * <p>
     * Gets the clone pseudo state.
     * </p>
     *
     * @param pseudostate
     *            model element of Pseudostate type
     * @param transferable
     *            transferable used for paste
     * @return the clone pseudo state
     * @throws IOException
     *             if any I/O error
     * @throws UnsupportedFlavorException
     *             not supported data flavor
     */
    private static ModelElement getClonePseudostate(Pseudostate pseudostate, Transferable transferable)
        throws UnsupportedFlavorException, IOException {
        ModelElement modelElement = null;
        if (pseudostate.getKind() == PseudostateKind.CHOICE) {
            modelElement = (ModelElement) transferable.getTransferData(ActivityDataFlavor.DECISION_NODE);
        } else if (pseudostate.getKind() == PseudostateKind.FORK) {
            modelElement = (ModelElement) transferable.getTransferData(ActivityDataFlavor.FORK_NODE);
        } else if (pseudostate.getKind() == PseudostateKind.INITIAL) {
            modelElement = (ModelElement) transferable.getTransferData(ActivityDataFlavor.INITIAL_NODE);
        } else if (pseudostate.getKind() == PseudostateKind.JOIN) {
            modelElement = (ModelElement) transferable.getTransferData(ActivityDataFlavor.JOIN_NODE);
        } else if (pseudostate.getKind() == PseudostateKind.JUNCTION) {
            modelElement = (ModelElement) transferable.getTransferData(ActivityDataFlavor.MERGE_NODE);
        }
        return modelElement;
    }

    /**
     * <p>
     * Creates the copy pseudo state action.
     * </p>
     *
     * @param pseudostate
     *            model element of Pseudostate type
     * @param clipboard
     *            clipboard used for paste
     * @return the created copy pseudostate action
     */
    private static Action createCopyPseudostateAction(Pseudostate pseudostate, Clipboard clipboard) {
        Action action = null;
        if (pseudostate.getKind() == PseudostateKind.CHOICE) {
            action = new CopyDecisionNodeAction(pseudostate, clipboard);
        } else if (pseudostate.getKind() == PseudostateKind.FORK) {
            action = new CopyForkNodeAction(pseudostate, clipboard);
        } else if (pseudostate.getKind() == PseudostateKind.INITIAL) {
            action = new CopyInitialNodeAction(pseudostate, clipboard);
        } else if (pseudostate.getKind() == PseudostateKind.JOIN) {
            action = new CopyJoinNodeAction(pseudostate, clipboard);
        } else if (pseudostate.getKind() == PseudostateKind.JUNCTION) {
            action = new CopyMergeNodeAction(pseudostate, clipboard);
        }
        return action;
    }

    /**
     * <p>
     * Gets the clone link.
     * </p>
     *
     * @param link
     *            model element of Link type
     * @param transferable
     *            transferable used for paste
     * @return the clone link
     * @throws IOException
     * @throws UnsupportedFlavorException
     *             not supported data flavor
     */
    private static ModelElement getCloneLink(Link link, Transferable transferable)
        throws UnsupportedFlavorException, IOException {
        ModelElement modelElement = null;
        Stimulus stimulus = link.getStimuli().iterator().next();
        Procedure procedure = stimulus.getDispatchAction();
        if (procedure != null) {
            com.topcoder.uml.model.actions.Action action = procedure.getAction();
            if (action instanceof CallOperationAction) {
                if (((CallOperationAction) action).isAsynchronous()) {
                    modelElement =
                        (ModelElement) transferable
                            .getTransferData(CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
                } else {
                    modelElement =
                        (ModelElement) transferable
                            .getTransferData(CollaborationTransfer.SYNCHRONOUS_MESSAGE_FLAVOR);
                }
            } else if (action instanceof CreateObjectAction) {
                modelElement =
                    (ModelElement) transferable.getTransferData(CollaborationTransfer.CREATE_MESSAGE_FLAVOR);
            } else if (action instanceof com.topcoder.uml.model.actions.messagingactions.SendSignalAction) {
                modelElement =
                    (ModelElement) transferable.getTransferData(CollaborationTransfer.SEND_SIGNAL_MESSAGE_FLAVOR);
            } else if (action == null) {
                modelElement =
                    (ModelElement) transferable.getTransferData(CollaborationTransfer.RETURN_MESSAGE_FLAVOR);
            }
        }
        return modelElement;
    }

    /**
     * <p>
     * Creates the copy link action.
     * </p>
     *
     * @param link
     *            model element of Link type
     * @param clipboard
     *            clipboard used for paste
     * @return the created copy link action
     */
    private static Action createCopyLinkAction(Link link, Clipboard clipboard) {
        Action copyAction = null;
        Stimulus stimulus = link.getStimuli().iterator().next();
        Procedure procedure = stimulus.getDispatchAction();
        if (procedure != null) {
            com.topcoder.uml.model.actions.Action action = procedure.getAction();
            try {

                if (action instanceof CallOperationAction) {
                    if (((CallOperationAction) action).isAsynchronous()) {
                        copyAction = new CopyAsynchronousMessageAction(stimulus, clipboard);
                    } else {
                        copyAction = new CopySynchronousMessageAction(stimulus, clipboard);
                    }
                } else if (action instanceof CreateObjectAction) {
                    copyAction = new CopyCreateMessageAction(stimulus, clipboard);
                } else if (action instanceof com.topcoder.uml.model.actions.messagingactions.SendSignalAction) {
                    copyAction = new CopySendSignalMessageAction(stimulus, clipboard);
                } else if (action == null) {
                    copyAction = new CopyReturnMessageAction(stimulus, clipboard);
                }
            } catch (SequenceConfigurationException e) {
                // TODO
            }
        }
        return copyAction;
    }

    /**
     * <p>
     * Cuts the graph element in component.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param object
     *            object that contains the graph element
     * @param graphElement
     *            graph element to be copied
     * @param compositeAction
     *            composite action to be add to
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    static void cutGraphElement(MainFrame mainFrame, Object object, GraphElement graphElement,
        CompositeUndoableAction compositeAction, boolean isComplete) {
        copyGraphElement(mainFrame, object, graphElement);
        if (object instanceof Node) {
            deleteNode(mainFrame, (Node) object, compositeAction, isComplete);
        } else if (object instanceof Edge) {
            deleteEdge(mainFrame, (Edge) object, compositeAction, isComplete);
        }
    }

    /**
     * <p>
     * Cuts the node and components contained by it.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            the node to be copied
     * @param compositeAction
     *            composite action to be add to
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    static void cutNode(MainFrame mainFrame, Node node, CompositeUndoableAction compositeAction, boolean isComplete) {
        GraphNode graphNode = node.getGraphNode();
        cutGraphElement(mainFrame, node, graphNode, compositeAction, isComplete);
        if (node instanceof NodeContainer) {
            NodeContainer container = (NodeContainer) node;
            for (Node containedNode : DeployHelper.getNodes(container)) {
                cutNode(mainFrame, containedNode, compositeAction, isComplete);
            }
            /*
             * for (DiagramElement diagramElement : graphNode.getContaineds()) { if (diagramElement instanceof
             * GraphElement) { JComponent component = DeployHelper.getComponent((GraphElement) diagramElement,
             * mainFrame); if (component instanceof Node) { cutNode(mainFrame, (Node) component, compositeAction,
             * isComplete); } } }
             */
            Set<Edge> edges = getContainedEdges((NodeContainer) node);
            for (Edge edge : edges) {
                cutGraphElement(mainFrame, edge, edge.getGraphEdge(), compositeAction, isComplete);
            }
        }
    }

    /**
     * <p>
     * Deletes a diagram.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagram
     *            the diagram to delete
     * @param compositeAction
     *            CompositeUndaobleAction to put the delete actions
     */
    static void deleteDiagram(MainFrame mainFrame, Diagram diagram, CompositeUndoableAction compositeAction) {
        String typeinfo = DeployHelper.getTypeInfo(diagram);
        UndoableAction action = null;
        if (typeinfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.CLASS.ordinal()])) {
            action = new RemoveClassDiagramAction(diagram);
        } else if (typeinfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.USECASE.ordinal()])) {
            action = new RemoveUseCaseDiagramAction(diagram);
        } else if (typeinfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.SEQUENCE.ordinal()])) {
            action = new RemoveSequenceDiagramAction(diagram);
        } else if (typeinfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.ACTIVITY.ordinal()])) {
            action = new RemoveActivityDiagramAction(diagram);
        }
        compositeAction.put(action, diagram);
    }

    /**
     * <p>
     * Deletes a collaboration.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param collaboration
     *            the collaboration to delete
     * @param compositeAction
     *            CompositeUndaobleAction to put the delete actions
     */
    static void deleteCollaboration(MainFrame mainFrame, Collaboration collaboration,
        CompositeUndoableAction compositeAction) {
        List<Diagram> diagrams = UMLModelManager.getInstance().getDiagrams();
        UndoableAction action = null;
        for (Diagram diagram : diagrams) {
            Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram.getOwner();
            if ((Collaboration) bridge.getElement() == collaboration) {
                action = new RemoveSequenceDiagramAction(diagram);
                compositeAction.put(action, diagram);
            }
        }
        action = new RemoveCollaborationAction(mainFrame, collaboration);
        compositeAction.put(action, collaboration);
    }

    /**
     * <p>
     * Deletes an edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param edge
     *            the edge to delete
     * @param compositeAction
     *            CompositeUndaobleAction to put the delete actions
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    static void deleteEdge(MainFrame mainFrame, Edge edge, CompositeUndoableAction compositeAction,
        boolean isComplete) {
        UndoableAction action = null;
        if (edge instanceof SequenceEdge) {
            action = new RemoveSequenceEdgeAction(mainFrame, (SequenceEdge) edge, isComplete);
        } else {
            action = DeployHelper.createRemoveEdgeAction(mainFrame, edge, isComplete);
        }
        compositeAction.put(action, edge);
    }

    /**
     * <p>
     * Deletes a node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            the node to delete
     * @param compositeAction
     *            CompositeUndaobleAction to put the delete actions
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    static void deleteNode(MainFrame mainFrame, Node node, CompositeUndoableAction compositeAction,
        boolean isComplete) {
        UndoableAction action = null;
        if (node instanceof ObjectNode) {
            action = new RemoveObjectNodeAction(mainFrame, (ObjectNode) node, isComplete);
        } else {
            action = DeployHelper.createRemoveNodeAction(node, mainFrame, isComplete);
        }
        compositeAction.put(action, node);
    }

    /**
     * <p>
     * Deletes a stereo type text field in class node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param textField
     *            stereo text field to be removed
     * @param compositeAction
     *            CompositeUndaobleAction to put the delete actions
     */
    static void deleteStereotypeTextField(MainFrame mainFrame, StereotypeTextField textField,
        CompositeUndoableAction compositeAction) {
        UndoableAction action = new RemoveStereotypeTextFieldAction(mainFrame, textField);
        compositeAction.put(action, textField);
    }

    /**
     * <p>
     * Filters copy operations with same model element.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     */
    static void filterCopyGraphElement(MainFrame mainFrame) {
        Set<ModelElement> isCopiedMap = new HashSet<ModelElement>();
        Map<Object, Clipboard> transferableMap = mainFrame.getClipboardMap();
        Map<Object, Clipboard> cloneMap = new HashMap<Object, Clipboard>(transferableMap);
        for (Object object : cloneMap.keySet()) {
            if (object instanceof JComponent) {
                ModelElement modelElement = DeployHelper.getElement((JComponent) object);
                if (isCopiedMap.contains(modelElement)) {
                    transferableMap.remove(object);
                } else {
                    isCopiedMap.add(modelElement);
                }
            }
        }
    }

    /**
     * <p>
     * Clones text element.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param object
     *            component object related to text element
     */
    private static void cloneTextElement(MainFrame mainFrame, Object object) {
        GraphElement graphElement = (GraphElement) getCloneDiagramElement(mainFrame, object);
        TextElement originalTextElement = (TextElement) graphElement.getContaineds().get(0);
        graphElement.clearContaineds();
        TextElement textElement = new TextElement();
        textElement.setText(originalTextElement.getText());
        graphElement.addContained(textElement);
        textElement.setContainer(graphElement);
    }

    /**
     * <p>
     * Clones a class node for given graph element.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param object
     *            object that contains the graph element
     */
    private static void cloneClassNode(MainFrame mainFrame, Object object) {
        GraphNode cloneGraphElement = (GraphNode) getCloneDiagramElement(mainFrame, object);
        ModelElement modelElement = DeployHelper.getElement(cloneGraphElement);
        Classifier classifier = (Classifier) modelElement;
        GraphNode tempGraphNode = DeployHelper.createGraphNodeForClass(modelElement, new Point(), new Dimension());
        GraphNode attributeGraphNode = (GraphNode) tempGraphNode.getContaineds().get(2);
        attributeGraphNode.setVisible(DeployHelper.getCompartmentVisibility(cloneGraphElement,
            "AttributeCompartment"));
        GraphNode attributeSection = (GraphNode) attributeGraphNode.getContaineds().get(0);
        GraphNode operationGraphNode = (GraphNode) tempGraphNode.getContaineds().get(4);
        operationGraphNode.setVisible(DeployHelper.getCompartmentVisibility(cloneGraphElement,
            "OperationCompartment"));
        GraphNode operationSection = (GraphNode) operationGraphNode.getContaineds().get(0);
        for (Feature feature : classifier.getFeatures()) {
            GraphElement graphElement = DeployHelper.createGraphElement(feature);
            if (feature instanceof Attribute) {
                attributeSection.addContained(graphElement);
                graphElement.setContainer(attributeSection);
            } else if (feature instanceof Operation) {
                operationSection.addContained(graphElement);
                graphElement.setContainer(operationSection);
            }
        }
        cloneGraphElement.removeContained(2);
        cloneGraphElement.addContained(2, attributeGraphNode);
        attributeGraphNode.setContainer(cloneGraphElement);
        cloneGraphElement.removeContained(4);
        cloneGraphElement.addContained(4, operationGraphNode);
        operationGraphNode.setContainer(cloneGraphElement);
        com.topcoder.diagraminterchange.Dimension size = ((GraphNode) cloneGraphElement).getSize();
        com.topcoder.diagraminterchange.Dimension newSize = new com.topcoder.diagraminterchange.Dimension();
        newSize.setHeight(size.getHeight());
        newSize.setWidth(size.getWidth());

        cloneGraphElement.setSize(newSize);
    }

    /**
     * <p>
     * Clones an association edge for given graph element.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param object
     *            object that contains the graph element
     */
    private static void cloneAssociationEdge(MainFrame mainFrame, Object object) {
        GraphElement cloneGraphElement = (GraphElement) getCloneDiagramElement(mainFrame, object);
        ModelElement modelElement = DeployHelper.getElement(cloneGraphElement);
        Association association = (Association) modelElement;
        GraphEdge tempGraphEdge =
            DeployHelper.createGraphEdgeForAssociation(association, new ArrayList<Point>(), association.getName());
        GraphNode leftGraphNode = (GraphNode) tempGraphEdge.getContaineds().get(0);
        GraphNode rightGraphNode = (GraphNode) tempGraphEdge.getContaineds().get(1);
        cloneGraphElement.removeContained(0);
        cloneGraphElement.addContained(0, leftGraphNode);
        leftGraphNode.setContainer(cloneGraphElement);
        cloneGraphElement.removeContained(1);
        cloneGraphElement.addContained(1, rightGraphNode);
        rightGraphNode.setContainer(cloneGraphElement);
    }

    /**
     * <p>
     * Resets the model element of features compartments.
     * </p>
     *
     * @param graphElement
     *            graph element which contains the cloned classifier
     */
    private static void resetFeature(GraphElement graphElement) {
        Classifier classifier = (Classifier) DeployHelper.getElement(graphElement);
        GraphNode attributeGraphNode = (GraphNode) graphElement.getContaineds().get(2);
        GraphNode attributeSection = (GraphNode) attributeGraphNode.getContaineds().get(0);
        GraphNode operationGraphNode = (GraphNode) graphElement.getContaineds().get(4);
        GraphNode operationSection = (GraphNode) operationGraphNode.getContaineds().get(0);
        int attributeIndex = 0;
        int operationIndex = 0;
        for (Feature feature : classifier.getFeatures()) {
            if (feature instanceof Attribute) {
                DeployHelper.setElement((GraphElement) attributeSection.getContaineds().get(attributeIndex),
                    feature);
            } else if (feature instanceof Operation) {
                DeployHelper.setElement((GraphElement) operationSection.getContaineds().get(operationIndex),
                    feature);
            }
        }
    }

    /**
     * <p>
     * Resets the association ends.
     * </p>
     *
     * @param graphElement
     *            graph element which contains the cloned association
     */
    private static void resetAssociationEnds(GraphElement graphElement) {
        Association association = (Association) DeployHelper.getElement(graphElement);
        GraphNode leftNode = (GraphNode) graphElement.getContaineds().get(0);
        GraphNode rightNode = (GraphNode) graphElement.getContaineds().get(1);
        DeployHelper.setElement(leftNode, association.getConnections().get(0));
        DeployHelper.setElement(rightNode, association.getConnections().get(1));
    }

    /**
     * <p>
     * Finds edges in node container.
     * </p>
     *
     * @param node
     *            node container contains the edges
     * @return the set of edges contained in the node container
     */
    private static Set<Edge> getContainedEdges(NodeContainer node) {
        DiagramView diagramView = (DiagramView) node.getParent();
        GraphNode graphNode = (GraphNode) node.getGraphNode().getContaineds().get(1);
        Component[] components = diagramView.getComponents();
        Set<Edge> edges = new HashSet<Edge>();
        for (Component component : components) {
            if (component instanceof Edge) {
                Edge edge = (Edge) component;
                GraphElement startGraphNode = edge.getGraphEdge().getAnchors().get(0).getGraphElement();
                GraphElement endGraphNode = edge.getGraphEdge().getAnchors().get(1).getGraphElement();
                if (startGraphNode.getContainer() == graphNode && endGraphNode.getContainer() == graphNode) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    public static void cutStereotypeTextField(MainFrame mainFrame, StereotypeTextField stereotypeTextField,
        CompositeUndoableAction compositeAction, boolean isComplete) {
        Clipboard clipboard = new Clipboard("CopyStereotypeTextField");
        GraphNode graphNode = stereotypeTextField.getGraphNode();
        try {
            new CopyDiagramElementAction(graphNode, clipboard).execute();
        } catch (ElementCloneException ece) {
            DeployHelper
                .handleException(mainFrame, ece, "Clone stereotype text field failed: " + ece.getMessage());
        } catch (ActionExecutionException e) {
            DeployHelper.handleException(mainFrame, e, "Copy failed: " + e.getMessage());
        }
        mainFrame.getClipboardMap().put(stereotypeTextField, clipboard);
        Element element =
            ((Uml1SemanticModelBridge) stereotypeTextField.getGraphNode().getSemanticModel()).getElement();
        if (element instanceof Feature) {
            Classifier clasz = ((Feature) element).getOwner();
            clasz.removeFeature((Feature) element);
            if (element instanceof StructuralFeature) {
                StructuralFeatureAbstractImpl.setType((StructuralFeature) element, null);
            }
            for (JComponent comp : DeployHelper.getComponent(clasz, mainFrame)) {
                DeployHelper.nodeNotifyChange((Node) comp, "cut feature", mainFrame);
            }
        }
    }

    public static Operation copyOperation(Operation op1, Operation op2) {
        op2.setName(op1.getName());
        op2.clearParameters();
        for (Parameter parameter : op1.getParameters()) {
            ParameterImpl param = new ParameterImpl();
            param.setName(parameter.getName());
            ParameterImpl.setType(param, parameter.getType());
            param.setKind(parameter.getKind());
            op2.addParameter(param);
            param.clearTaggedValues();
            for (TaggedValue taggedValue : parameter.getTaggedValues()) {
                TaggedValueImpl t = new TaggedValueImpl();
                t.setName(taggedValue.getName());
                t.setDataValue(taggedValue.getDataValue());
                t.setType(taggedValue.getType());
                t.setModelElement(op2);
                param.addTaggedValue(t);
            }

        }
        op2.setVisibility(op1.getVisibility());
        op2.setConcurrency(op1.getConcurrency());
        op2.clearStereotypes();
        for (Stereotype stereotype : op1.getStereotypes()) {
            StereotypeImpl s = new StereotypeImpl();
            s.setName(stereotype.getName());
            op2.addStereotype(s);
        }
        op2.clearTaggedValues();
        for (TaggedValue taggedValue : op1.getTaggedValues()) {
            TaggedValueImpl t = new TaggedValueImpl();
            t.setName(taggedValue.getName());
            t.setDataValue(taggedValue.getDataValue());
            t.setType(taggedValue.getType());
            t.setModelElement(op2);
            op2.addTaggedValue(t);
        }
        return op2;
    }

    public static Operation copyOperation(Operation op) {
        return copyOperation(op, new OperationImpl());
    }

}
