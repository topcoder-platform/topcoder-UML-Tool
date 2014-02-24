/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JTextArea;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.event.AddNewElementEvent;
import com.topcoder.gui.diagramviewer.event.AddNewElementListener;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.DecisionNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FlowFinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ForkNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.JoinNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.MergeNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.SendSignalAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.EnumClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ExceptionNode;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.AddAbstractionEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddAcceptEventActionAction;
import com.topcoder.umltool.deploy.actions.undoable.AddActionStateAction;
import com.topcoder.umltool.deploy.actions.undoable.AddActorNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddAssociationEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddClassNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddCommentLinkEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddCommentNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddDecisionNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddDependencyEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddEnumClassNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddExceptionNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddExtendEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddFinalNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddFlowFinalNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddForkNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddFreeTextNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddGeneralizationEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddIncludeEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddInitialNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddInterfaceNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddJoinNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddMergeNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddObjectFlowNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddObjectNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddPackageNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddPolylineAction;
import com.topcoder.umltool.deploy.actions.undoable.AddSendSignalActionAction;
import com.topcoder.umltool.deploy.actions.undoable.AddSequenceEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.AddSubsystemNodeContainerAction;
import com.topcoder.umltool.deploy.actions.undoable.AddTransitionAction;
import com.topcoder.umltool.deploy.actions.undoable.AddUseCaseNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;

/**
 * <p>
 * This implementation of AddNewElementListener will add elements to current diagram view, and update document
 * tree, type panel, properties panel and documentation panel in the main frame.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddElementHandler implements AddNewElementListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>AddElementHandler</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     */
    public AddElementHandler(MainFrame mainframe) {
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Adds the new element to the DiagramView.
     * </p>
     *
     * @param event
     *            the AddNewElementEvent
     */
    public void addNewElement(AddNewElementEvent event) {
        DiagramView view = (DiagramView) event.getSource();
        Class<?> type = event.getNewElementType();
        Rectangle bound = event.getNewElementBounds();
        JComponent addedComponent = null;

        if (Node.class.isAssignableFrom(type)) {
            Node node = null;
            if (type.equals(UseCaseNode.class)) {
                node = addUseCaseNode(view, bound);
            } else if (type.equals(ActorNode.class)) {
                node = addActorNode(view, bound);
            } else if (type.equals(SubsystemNodeContainer.class)) {
                node = addSubsystemNode(view, bound);
            } else if (type.equals(ObjectNode.class)) {
                node = addObjectNode(view, bound);
            } else if (type.equals(InitialNode.class)) {
                node = addInitialNode(view, bound);
            } else if (type.equals(AcceptEventAction.class)) {
                node = addAcceptEventAction(view, bound);
            } else if (type.equals(ActionState.class)) {
                node = addActionState(view, bound);
            } else if (type.equals(DecisionNode.class)) {
                node = addDecisionNode(view, bound);
            } else if (type.equals(FinalNode.class)) {
                node = addFinalNode(view, bound);
            } else if (type.equals(FlowFinalNode.class)) {
                node = addFlowFinalNode(view, bound);
            } else if (type.equals(ForkNode.class)) {
                node = addForkNode(view, bound);
            } else if (type.equals(JoinNode.class)) {
                node = addJoinNode(view, bound);
            } else if (type.equals(MergeNode.class)) {
                node = addMergeNode(view, bound);
            } else if (type.equals(ObjectFlowNode.class)) {
                node = addObjectFlowNode(view, bound);
            } else if (type.equals(SendSignalAction.class)) {
                node = addSendSignalAction(view, bound);
            } else if (type.equals(CommentNode.class)) {
                node = addCommentNode(view, bound);
            } else if (type.equals(FreeTextNode.class)) {
                node = addFreeTextNode(view, bound);
            } else if (type.equals(PolylineNode.class)) {
                node = addPolylineNode(view, bound);
            } else if (type.equals(PackageNode.class)) {
                node = addPackageNode(view, bound);
            } else if (type.equals(ClassNode.class)) {
                node = addClassNode(view, bound);
            } else if (type.equals(InterfaceNode.class)) {
                node = addInterfaceNode(view, bound);
            } else if (type.equals(ExceptionNode.class)) {
                node = addExceptionNode(view, bound);
            } else if (type.equals(EnumClassNode.class)) {
                node = addEnumClassNode(view, bound);
            }
            if (node != null) {
                DeployHelper.clearSelected(view.getViewer());
                view.getViewer().addSelectedElement(node);
                node.notifySelected();
                addedComponent = node;
            }
        } else if (Edge.class.isAssignableFrom(type)) {
            Edge edge = null;
            if (type.equals(IncludeEdge.class)) {
                edge = addIncludeEdge(view, bound);
            } else if (type.equals(ExtendEdge.class)) {
                edge = addExtendEdge(view, bound);
            } else if (type.equals(CreateMessageEdge.class) || type.equals(SynchronousMessageEdge.class)
                || type.equals(AsynchronousMessageEdge.class) || type.equals(SendSignalMessageEdge.class)
                || type.equals(ReturnMessageEdge.class)) {
                edge = addSequenceEdge(view, bound, type);
            } else if (type.equals(Transition.class)) {
                edge = addTransition(view, bound);
            } else if (type.equals(AssociationEdge.class)) {
                edge = addAssociationEdge(view, bound);
            } else if (type.equals(GeneralizationEdge.class)) {
                edge = addGeneralizationEdge(view, bound);
            } else if (type.equals(DependencyEdge.class)) {
                edge = addDependencyEdge(view, bound);
            } else if (type.equals(AbstractionEdge.class)) {
                edge = addAbstractionEdge(view, bound);
            } else if (type.equals(CommentLinkEdge.class)) {
                edge = addCommentLinkEdge(view, bound);
            }
            if (edge != null) {
                DeployHelper.clearSelected(view.getViewer());
                view.getViewer().addSelectedElement(edge);
                edge.notifySelected();
                edge.getParent().setComponentZOrder(edge, 0);
                addedComponent = edge;
            }
        }
        mainFrame.updateDiagramView();

        if (!mainFrame.isSwiftCreation()) {
            view.getViewer().setState(DiagramState.SELECT_ELEMENT);
            DeployHelper.setViewCursor(view, Cursor.getDefaultCursor());
            mainFrame.getToolPanel().UnselectElement();
        }

        mainFrame.getDocumentTree().updateTree();
        DeployHelper.notifySelectionChanged(mainFrame, view);
        if (addedComponent != null) {
            addedComponent.requestFocus();
        }

        TextInputBox box = view.getViewer().getTextInputBox();
        if (box.isVisible()) {
            JTextArea area = (JTextArea) box.getComponent(0);
            area.requestFocus();
            area.selectAll();
        }
    }

    /**
     * <p>
     * Adds an UseCaseNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private UseCaseNode addUseCaseNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddUseCaseNodeAction action = null;
        if (component instanceof NodeContainer) {
            NodeContainer nodeContainer = (NodeContainer) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddUseCaseNodeAction(mainFrame, view, position, HandlerHelper.DEFAULT_USECASE_SIZE,
                    "Use Case", nodeContainer);
        } else {
            action =
                new AddUseCaseNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_USECASE_SIZE,
                    "Use Case");
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add UseCase Node");
        if (component instanceof NodeContainer) {
            DeployHelper.updateZOrder((NodeContainer) component);
        }
        UseCaseNode node = (UseCaseNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds an ActorNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private ActorNode addActorNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddActorNodeAction action = null;
        if (component instanceof NodeContainer) {
            NodeContainer nodeContainer = (NodeContainer) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddActorNodeAction(mainFrame, view, position, HandlerHelper.DEFAULT_ACTOR_SIZE, "Actor",
                    nodeContainer);
        } else {
            action =
                new AddActorNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_ACTOR_SIZE,
                    "Actor");
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add Actor Node");
        if (component instanceof NodeContainer) {
            DeployHelper.updateZOrder((NodeContainer) component);
        }
        ActorNode node = (ActorNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a SubsystemNodeContainer to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node container
     */
    private SubsystemNodeContainer addSubsystemNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddSubsystemNodeContainerAction action = null;
        if (component instanceof PackageNode) {
            NodeContainer nodeContainer = (NodeContainer) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddSubsystemNodeContainerAction(mainFrame, view, position,
                    HandlerHelper.DEFAULT_SUBSYSTEM_SIZE, "Subsystem", nodeContainer);
        } else {
            action =
                new AddSubsystemNodeContainerAction(mainFrame, view, bound.getLocation(),
                    HandlerHelper.DEFAULT_SUBSYSTEM_SIZE, "Subsystem");
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add Subsystem NodeContainer");
        if (component instanceof PackageNode) {
            DeployHelper.updateZOrder((NodeContainer) component);
        }
        SubsystemNodeContainer node = (SubsystemNodeContainer) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds an IncludeEdge to given DiagramView, the edge's start and end position is contained in bound argument.
     * </p>
     * <p>
     * An IncludeEdge should place between two UseCaseNodes. If this edge doesn't start from an UseCaseNode, it
     * will not be created. If it start from an UseCaseNode, but don't stop at another UseCaseNode, a new
     * UseCaseNode will be created at the edge end first.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            this rectangle's left-up corner means edge's start position, the right-bottom corner means edge's
     *            end position
     * @return the new created edge
     */
    private IncludeEdge addIncludeEdge(DiagramView view, Rectangle bound) {
        Point start = bound.getLocation();
        Point end = new Point(bound.x + bound.width, bound.y + bound.height);

        Component component = view.getComponentAt(start);
        if (component == null) {
            return null;
        }
        if (component instanceof UseCaseNode) {
            UseCaseNode node = (UseCaseNode) component;
            component = view.getComponentAt(end);
            UseCaseNode targetNode = null;
            NodeContainer targetContainer = null;
            AddUseCaseNodeAction addUseCaseNodeAction = null;
            if (component instanceof UseCaseNode) {
                targetNode = (UseCaseNode) component;
            } else if (component instanceof NodeContainer) {
                targetContainer = (NodeContainer) component;
            }
            if (targetNode == null) {
                // Create a new UseCaseNode
                Point location = new Point(end);
                if (targetContainer != null) {
                    Point position = DeployHelper.getAbsoluteGraphNodePosition(targetContainer.getGraphNode());
                    location.x -= position.x;
                    location.y -= position.y;
                }
                addUseCaseNodeAction =
                    new AddUseCaseNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_USECASE_SIZE,
                        "Use Case", targetContainer);
            }
            AddIncludeEdgeAction action;
            if (targetNode != null) {
                action = new AddIncludeEdgeAction(mainFrame, view, start, end, "", node, targetNode);
            } else {
                action = new AddIncludeEdgeAction(mainFrame, view, start, end, "", node, addUseCaseNodeAction);
            }
            if (addUseCaseNodeAction != null) {
                UpdateNodeContainerAction compositeAction =
                    new UpdateNodeContainerAction(action, view, "Add Include Edge");
                mainFrame.handleActionEvent(compositeAction, view, "Add Include Edge");
                targetNode = (UseCaseNode) addUseCaseNodeAction.getNode();
                triggerDoubleClick(targetNode.getNameCompartment());
            } else {
                mainFrame.handleActionEvent(action, view, "Add Include Edge");
            }
            return (IncludeEdge) action.getEdge();
        }
        return null;
    }

    /**
     * <p>
     * Adds an ExtendEdge to given DiagramView, the edge's start and end position is contained in bound argument.
     * </p>
     * <p>
     * An ExtendEdge should place between two UseCaseNodes. If this edge doesn't start from an UseCaseNode, it will
     * not be created. If it starts from an UseCaseNode, but don't stop at another UseCaseNode, a new UseCaseNode
     * will be created at the edge end first.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            this rectangle's left-up corner means edge's start position, the right-bottom corner means edge's
     *            end position
     * @return the new created edge
     */
    private ExtendEdge addExtendEdge(DiagramView view, Rectangle bound) {
        Point start = bound.getLocation();
        Point end = new Point(bound.x + bound.width, bound.y + bound.height);

        Component component = view.getComponentAt(start);
        if (component == null) {
            return null;
        }
        if (component instanceof UseCaseNode) {
            UseCaseNode node = (UseCaseNode) component;
            component = view.getComponentAt(end);
            UseCaseNode targetNode = null;
            NodeContainer targetContainer = null;
            AddUseCaseNodeAction addUseCaseNodeAction = null;
            if (component instanceof UseCaseNode) {
                targetNode = (UseCaseNode) component;
            } else if (component instanceof NodeContainer) {
                targetContainer = (NodeContainer) component;
            }
            if (targetNode == null) {
                // Create a new UseCaseNode
                Point location = new Point(end);
                if (targetContainer != null) {
                    Point position = DeployHelper.getAbsoluteGraphNodePosition(targetContainer.getGraphNode());
                    location.x -= position.x;
                    location.y -= position.y;
                }
                addUseCaseNodeAction =
                    new AddUseCaseNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_USECASE_SIZE,
                        "Use Case", targetContainer);
            }
            AddExtendEdgeAction action;
            if (targetNode != null) {
                action = new AddExtendEdgeAction(mainFrame, view, start, end, "", node, targetNode);
            } else {
                action = new AddExtendEdgeAction(mainFrame, view, start, end, "", node, addUseCaseNodeAction);
            }
            if (addUseCaseNodeAction != null) {
                UpdateNodeContainerAction compositeAction =
                    new UpdateNodeContainerAction(action, view, "Add Extend Edge");
                mainFrame.handleActionEvent(compositeAction, view, "Add Extend Edge");
                targetNode = (UseCaseNode) addUseCaseNodeAction.getNode();
                triggerDoubleClick(targetNode.getNameCompartment());
            } else {
                mainFrame.handleActionEvent(action, view, "Add Extend Edge");
            }
            return (ExtendEdge) action.getEdge();
        }
        return null;
    }

    /**
     * <p>
     * Adds an ObjectNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created object node
     */
    private ObjectNode addObjectNode(DiagramView view, Rectangle bound) {
        Point position = bound.getLocation();

        AddObjectNodeAction addObjectNodeAction = new AddObjectNodeAction(mainFrame, view, position);
        mainFrame.handleActionEvent(addObjectNodeAction, view, addObjectNodeAction.getPresentationName());

        return (ObjectNode) addObjectNodeAction.getNode();
    }

    /**
     * <p>
     * Adds sequence edges to given DiagramView.
     * </p>
     * <p>
     * If in need, return edge is also created.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            edge's location is defined by this rectangle
     * @param edgeClass
     *            class type of sequence edges that to be added
     * @return the created sequence edge.
     */
    private SequenceEdge addSequenceEdge(DiagramView view, Rectangle bound, Class<?> edgeClass) {
        // get start and end position
        Point startPoint = bound.getLocation();
        Point endPoint = new Point(bound.x + bound.width, bound.y + bound.height);

        ObjectNode startNode = getOjbectNodeAt(view, startPoint);
        ObjectNode endNode = getOjbectNodeAt(view, endPoint);

        // edge between different nodes, set the y of start point to the same of
        // end point
        if (endNode != startNode) {
            startPoint.y = endPoint.y;
        }

        // check validity of edge position
        if (startNode == null) {
            return null;
        }

        AddSequenceEdgeAction addSequenceEdgeAction =
            new AddSequenceEdgeAction(mainFrame, view, startPoint, endPoint, startNode, endNode, edgeClass);
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(startNode, "Add Sequence Edge");
        compositeAction.put(addSequenceEdgeAction, view);
        mainFrame.handleActionEvent(compositeAction, view, addSequenceEdgeAction.getPresentationName());
        return addSequenceEdgeAction.getSequenceEdge();
    }

    /**
     * <p>
     * Gets an top most ObjectNode at a given position in diagram view.
     * </p>
     *
     * @param view
     *            diagram view where the object node to find
     * @param point
     *            the point to find the object node
     * @return the object node if found; null if no object node is found
     */
    private ObjectNode getOjbectNodeAt(DiagramView view, Point point) {
        int componentCount = view.getComponentCount();
        int index;

        for (index = 0; index < componentCount; index++) {
            Component component = view.getComponent(index);
            if (component instanceof ObjectNode) {
                ObjectNode node = (ObjectNode) component;
                if (node.getLocation().x <= point.x && node.getLocation().x + node.getWidth() >= point.x
                    && node.getLocation().y <= point.y) {
                    return node;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Adds an InitialNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private InitialNode addInitialNode(DiagramView view, Rectangle bound) {
        AddInitialNodeAction action =
            new AddInitialNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_INITIAL_SIZE,
                "InitialNode");
        mainFrame.handleActionEvent(action, view, "Add InitialNode");
        InitialNode node = (InitialNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds an AcceptEventAction to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private AcceptEventAction addAcceptEventAction(DiagramView view, Rectangle bound) {
        AddAcceptEventActionAction action =
            new AddAcceptEventActionAction(mainFrame, view, bound.getLocation(),
                HandlerHelper.DEFAULT_ACCEPTEVENT_SIZE, "AcceptEventAction");
        mainFrame.handleActionEvent(action, view, "Add AcceptEventAction");
        AcceptEventAction node = (AcceptEventAction) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds an ActionState to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private ActionState addActionState(DiagramView view, Rectangle bound) {
        AddActionStateAction action =
            new AddActionStateAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_ACTIONSTATE_SIZE,
                "ActionState");
        mainFrame.handleActionEvent(action, view, "Add ActionState");
        ActionState node = (ActionState) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a DecisionNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private DecisionNode addDecisionNode(DiagramView view, Rectangle bound) {
        AddDecisionNodeAction action =
            new AddDecisionNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_DECISION_SIZE,
                "DecisionNode");
        mainFrame.handleActionEvent(action, view, "Add DecisionNode");
        DecisionNode node = (DecisionNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a FinalNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private FinalNode addFinalNode(DiagramView view, Rectangle bound) {
        AddFinalNodeAction action =
            new AddFinalNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_FINAL_SIZE,
                "FinalNode");
        mainFrame.handleActionEvent(action, view, "Add FinalNode");
        FinalNode node = (FinalNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a FlowFinalNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private FlowFinalNode addFlowFinalNode(DiagramView view, Rectangle bound) {
        AddFlowFinalNodeAction action =
            new AddFlowFinalNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_FLOWFINAL_SIZE,
                "FlowFinalNode");
        mainFrame.handleActionEvent(action, view, "Add FlowFinalNode");
        FlowFinalNode node = (FlowFinalNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a ForkNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private ForkNode addForkNode(DiagramView view, Rectangle bound) {
        AddForkNodeAction action =
            new AddForkNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_FORK_SIZE,
                "ForkNode");
        mainFrame.handleActionEvent(action, view, "Add ForkNode");
        ForkNode node = (ForkNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a JoinNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private JoinNode addJoinNode(DiagramView view, Rectangle bound) {
        AddJoinNodeAction action =
            new AddJoinNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_JOIN_SIZE,
                "JoinNode");
        mainFrame.handleActionEvent(action, view, "Add JoinNode");
        JoinNode node = (JoinNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a MergeNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private MergeNode addMergeNode(DiagramView view, Rectangle bound) {
        AddMergeNodeAction action =
            new AddMergeNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_MERGE_SIZE,
                "MergeNode");
        mainFrame.handleActionEvent(action, view, "Add MergeNode");
        MergeNode node = (MergeNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds an ObjectFlowNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private ObjectFlowNode addObjectFlowNode(DiagramView view, Rectangle bound) {
        AddObjectFlowNodeAction action =
            new AddObjectFlowNodeAction(mainFrame, view, bound.getLocation(),
                HandlerHelper.DEFAULT_OBJECTFLOW_SIZE, "ObjectFlowNode");
        mainFrame.handleActionEvent(action, view, "Add ObjectFlowNode");
        ObjectFlowNode node = (ObjectFlowNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a SendSignalAction to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private SendSignalAction addSendSignalAction(DiagramView view, Rectangle bound) {
        AddSendSignalActionAction action =
            new AddSendSignalActionAction(mainFrame, view, bound.getLocation(),
                HandlerHelper.DEFAULT_SENDSIGNAL_SIZE, "SendSignalAction");
        mainFrame.handleActionEvent(action, view, "Add SendSignalAction");
        SendSignalAction node = (SendSignalAction) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds an Transition edge to given DiagramView, the edge's start and end position is contained in bound
     * argument.
     * </p>
     * <p>
     * A Transition edge should place between two UseCaseNodes. If this edge doesn't start from an UseCaseNode, it
     * will not be created. If it start from an UseCaseNode, but don't stop at another UseCaseNode, a new
     * UseCaseNode will be created at the edge end first.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            this rectangle's left-up corner means edge's start position, the right-bottom corner means edge's
     *            end position
     * @return the new created edge
     */
    private Transition addTransition(DiagramView view, Rectangle bound) {
        Point start = bound.getLocation();
        Point end = new Point(bound.x + bound.width, bound.y + bound.height);

        Component component = view.getComponentAt(start);
        if (component == null) {
            return null;
        }
        if (component instanceof BaseNode) {
            BaseNode node = (BaseNode) component;
            component = view.getComponentAt(end);
            BaseNode targetNode = null;
            AddActionStateAction addActionStateAction = null;
            if (component == null || !(component instanceof BaseNode)) {
                // Create a new ActionState
                addActionStateAction =
                    new AddActionStateAction(mainFrame, view, end, HandlerHelper.DEFAULT_ACTIONSTATE_SIZE,
                        "Action State");
            } else {
                targetNode = (BaseNode) component;
            }
            AddTransitionAction action;
            if (targetNode != null) {
                action = new AddTransitionAction(mainFrame, view, start, end, "", node, targetNode);
            } else {
                action = new AddTransitionAction(mainFrame, view, start, end, "", node, addActionStateAction);
            }
            if (addActionStateAction != null) {
                UpdateNodeContainerAction compositeAction =
                    new UpdateNodeContainerAction(node, "Add Transition Edge");
                compositeAction.put(action, view);
                mainFrame.handleActionEvent(compositeAction, view, "Add Transition Edge");
                targetNode = (ActionState) addActionStateAction.getNode();
                triggerDoubleClick(targetNode.getNameCompartment());
            } else {
                mainFrame.handleActionEvent(action, view, "Add Transition Edge");
            }
            return (Transition) action.getEdge();
        }
        return null;
    }

    /**
     * <p>
     * Adds an AssociationEdge edge to given DiagramView, the edge's start and end position is contained in bound
     * argument.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            this rectangle's left-up corner means edge's start position, the right-bottom corner means edge's
     *            end position
     * @return the new created edge
     */
    private AssociationEdge addAssociationEdge(DiagramView view, Rectangle bound) {
        Point start = bound.getLocation();
        Point end = new Point(bound.x + bound.width, bound.y + bound.height);

        Component component = view.getComponentAt(start);
        if (component == null) {
            return null;
        }
        Node startNode = null;
        if (component instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
            startNode = (com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) component;
        } else if (component instanceof SubsystemNodeContainer) {
            startNode = (SubsystemNodeContainer) component;
        } else if (component instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            startNode = (com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) component;
        } else {
            return null;
        }
        component = view.getComponentAt(end);
        Node targetNode = null;
        NodeContainer targetContainer = null;
        AddNodeAction addNodeAction = null;
        if (component instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
            targetNode = (Node) component;
        } else if (component instanceof SubsystemNodeContainer) {
            targetNode = (SubsystemNodeContainer) component;
        } else if (component instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            targetNode = (Node) component;
        } else if (component instanceof PackageNode) {
            targetContainer = (NodeContainer) component;
        }
        if (targetNode == null) {
            Point location = new Point(end);
            if (targetContainer != null) {
                Point position = DeployHelper.getAbsoluteGraphNodePosition(targetContainer.getGraphNode());
                location.x -= position.x;
                location.y -= position.y;
            }
            if (DeployHelper.getTypeInfo(view.getDiagram()).equals(
                DeployHelper.DIAGRAM_TYPEINFO[DiagramType.CLASS.ordinal()])) {
                // Create a new ClassNode
                addNodeAction =
                    new AddClassNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_CLASS_SIZE, null,
                        targetContainer);
            } else {
                // Create a new UseCaseNode
                addNodeAction =
                    new AddUseCaseNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_USECASE_SIZE,
                        "Use Case", targetContainer);
            }
        }
        AddAssociationEdgeAction action;
        if (targetNode != null) {
            action = new AddAssociationEdgeAction(mainFrame, view, start, end, "", startNode, targetNode);
        } else {
            action = new AddAssociationEdgeAction(mainFrame, view, start, end, "", startNode, addNodeAction);
        }
        if (addNodeAction != null) {
            UpdateNodeContainerAction compositeAction =
                new UpdateNodeContainerAction(action, view, "Add Association Edge");
            mainFrame.handleActionEvent(compositeAction, view, "Add Association Edge");
            targetNode = addNodeAction.getNode();
            triggerDoubleClick(DeployHelper.getEditableComponent(targetNode));
        } else {
            mainFrame.handleActionEvent(action, view, "Add Association Edge");
        }
        return (AssociationEdge) action.getEdge();
    }

    /**
     * <p>
     * Adds a GeneralizationEdge edge to given DiagramView, the edge's start and end position is contained in bound
     * argument.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            this rectangle's left-up corner means edge's start position, the right-bottom corner means edge's
     *            end position
     * @return the new created edge
     */
    private GeneralizationEdge addGeneralizationEdge(DiagramView view, Rectangle bound) {
        Point start = bound.getLocation();
        Point end = new Point(bound.x + bound.width, bound.y + bound.height);

        Component component = view.getComponentAt(start);
        if (component == null) {
            return null;
        }
        Node startNode = null;
        if (component instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
            startNode = (com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) component;
        } else if (component instanceof SubsystemNodeContainer) {
            startNode = (SubsystemNodeContainer) component;
        } else if (component instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            startNode = (com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) component;
        } else if (component instanceof PackageNode) {
            startNode = (PackageNode) component;
        } else {
            return null;
        }
        component = view.getComponentAt(end);

        Node targetNode = null;
        NodeContainer targetContainer = null;
        AddNodeAction addNodeAction = null;
        if (component instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
            targetNode = (com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) component;
        } else if (component instanceof SubsystemNodeContainer) {
            if (startNode instanceof SubsystemNodeContainer) {
                targetNode = (SubsystemNodeContainer) component;
            } else {
                targetContainer = (NodeContainer) component;
            }
        } else if (component instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            targetNode = (com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) component;
        } else if (component instanceof PackageNode) {
            if (startNode instanceof PackageNode) {
                targetNode = (PackageNode) component;
            } else {
                targetContainer = (NodeContainer) component;
            }
        }
        if (targetNode != null && !(component.getClass().equals(startNode.getClass()))) {
            return null;
        }

        if (targetNode == null) {
            // Create a same kind Node
            Point location = new Point(end);
            if (targetContainer != null) {
                Point position = DeployHelper.getAbsoluteGraphNodePosition(targetContainer.getGraphNode());
                location.x -= position.x;
                location.y -= position.y;
            }
            if (startNode instanceof UseCaseNode) {
                addNodeAction =
                    new AddUseCaseNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_USECASE_SIZE,
                        "Use Case", targetContainer);
            } else if (startNode instanceof ActorNode) {
                addNodeAction =
                    new AddActorNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_ACTOR_SIZE, "Actor",
                        targetContainer);
            } else if (startNode instanceof SubsystemNodeContainer) {
                addNodeAction =
                    new AddSubsystemNodeContainerAction(mainFrame, view, location,
                        HandlerHelper.DEFAULT_SUBSYSTEM_SIZE, "Subsystem", targetContainer);
            } else if (startNode instanceof InterfaceNode) {
                addNodeAction =
                    new AddInterfaceNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_CLASS_SIZE, null,
                        targetContainer);
            } else if (startNode instanceof ClassNode) {
                addNodeAction =
                    new AddClassNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_CLASS_SIZE, null,
                        targetContainer);
            } else if (startNode instanceof PackageNode) {
                addNodeAction =
                    new AddPackageNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_PACKAGE_SIZE, null,
                        targetContainer);
            }
        }
        AddGeneralizationEdgeAction action;
        if (targetNode != null) {
            action = new AddGeneralizationEdgeAction(mainFrame, view, start, end, "", startNode, targetNode);
        } else {
            action = new AddGeneralizationEdgeAction(mainFrame, view, start, end, "", startNode, addNodeAction);
        }
        if (addNodeAction != null) {
            UpdateNodeContainerAction compositeAction =
                new UpdateNodeContainerAction(action, view, "Add Generalization Edge");
            mainFrame.handleActionEvent(compositeAction, view, "Add Generalization Edge");
            targetNode = addNodeAction.getNode();
            triggerDoubleClick(DeployHelper.getEditableComponent(targetNode));
        } else {
            mainFrame.handleActionEvent(action, view, "Add Generalization Edge");
        }
        return (GeneralizationEdge) action.getEdge();
    }

    /**
     * <p>
     * Adds a DependencyEdge edge to given DiagramView, the edge's start and end position is contained in bound
     * argument.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            this rectangle's left-up corner means edge's start position, the right-bottom corner means edge's
     *            end position
     * @return the new created edge
     */
    private DependencyEdge addDependencyEdge(DiagramView view, Rectangle bound) {
        Point start = bound.getLocation();
        Point end = new Point(bound.x + bound.width, bound.y + bound.height);

        Component component = view.getComponentAt(start);
        if (component == null) {
            return null;
        }
        Node startNode = null;
        if (component instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
            startNode = (com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) component;
        } else if (component instanceof SubsystemNodeContainer) {
            startNode = (SubsystemNodeContainer) component;
        } else if (component instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            startNode = (com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) component;
        } else if (component instanceof PackageNode) {
            startNode = (PackageNode) component;
        } else {
            return null;
        }
        component = view.getComponentAt(end);
        Node targetNode = null;
        AddNodeAction addNodeAction = null;
        if (component instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
            targetNode = (com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) component;
        } else if (component instanceof SubsystemNodeContainer) {
            targetNode = (SubsystemNodeContainer) component;
        } else if (component instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            targetNode = (com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) component;
        } else if (component instanceof PackageNode) {
            targetNode = (PackageNode) component;
        } else {
            if (DeployHelper.getTypeInfo(view.getDiagram()).equals("ClassDiagram")) {
                // Create a new ClassNode
                addNodeAction =
                    new AddClassNodeAction(mainFrame, view, end, HandlerHelper.DEFAULT_CLASS_SIZE, (String) null);
            } else {
                // Create a new UseCaseNode
                addNodeAction =
                    new AddUseCaseNodeAction(mainFrame, view, end, HandlerHelper.DEFAULT_USECASE_SIZE, "Use Case");
            }
        }
        AddDependencyEdgeAction action;
        if (targetNode != null) {
            action = new AddDependencyEdgeAction(mainFrame, view, start, end, "", startNode, targetNode);
        } else {
            action = new AddDependencyEdgeAction(mainFrame, view, start, end, "", startNode, addNodeAction);
        }
        if (addNodeAction != null) {
            UpdateNodeContainerAction compositeAction =
                new UpdateNodeContainerAction(action, view, "Add Dependency Edge");
            mainFrame.handleActionEvent(compositeAction, view, "Add Dependency Edge");
            targetNode = addNodeAction.getNode();
            triggerDoubleClick(DeployHelper.getEditableComponent(targetNode));
        } else {
            mainFrame.handleActionEvent(action, view, "Add Dependency Edge");
        }
        return (DependencyEdge) action.getEdge();
    }

    /**
     * <p>
     * Adds an AbstractionEdge to given DiagramView, the edge's start and end position is contained in bound
     * argument.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            this rectangle's left-up corner means edge's start position, the right-bottom corner means edge's
     *            end position
     * @return the new created edge
     */
    private AbstractionEdge addAbstractionEdge(DiagramView view, Rectangle bound) {
        Point start = bound.getLocation();
        Point end = new Point(bound.x + bound.width, bound.y + bound.height);

        Component component = view.getComponentAt(start);
        if (component == null) {
            return null;
        }
        Node startNode = null;
        if (component instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            startNode = (com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) component;
        } else {
            return null;
        }
        component = view.getComponentAt(end);
        Node targetNode = null;
        NodeContainer targetContainer = null;
        AddNodeAction addNodeAction = null;
        if (component instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            targetNode = (com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) component;
        } else if (component instanceof PackageNode) {
            targetContainer = (NodeContainer) component;
        }
        if (targetNode == null) {
            // Create a new InterfaceNode
            Point location = new Point(end);
            if (targetContainer != null) {
                Point position = DeployHelper.getAbsoluteGraphNodePosition(targetContainer.getGraphNode());
                location.x -= position.x;
                location.y -= position.y;
            }
            addNodeAction =
                new AddInterfaceNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_CLASS_SIZE, null,
                    targetContainer);
        }
        AddAbstractionEdgeAction action;
        if (targetNode != null) {
            action = new AddAbstractionEdgeAction(mainFrame, view, start, end, "", startNode, targetNode);
        } else {
            action = new AddAbstractionEdgeAction(mainFrame, view, start, end, "", startNode, addNodeAction);
        }
        if (addNodeAction != null) {
            UpdateNodeContainerAction compositeAction =
                new UpdateNodeContainerAction(action, view, "Add Abstraction Edge");
            mainFrame.handleActionEvent(compositeAction, view, "Add Abstraction Edge");
            targetNode = (InterfaceNode) addNodeAction.getNode();
            triggerDoubleClick(((InterfaceNode) targetNode).getNameCompartment());
        } else {
            mainFrame.handleActionEvent(action, view, "Add Abstraction Edge");
        }
        return (AbstractionEdge) action.getEdge();
    }

    /**
     * <p>
     * Adds a CommentNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private CommentNode addCommentNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddCommentNodeAction action = null;
        if (component instanceof NodeContainer) {
            NodeContainer nodeContainer = (NodeContainer) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddCommentNodeAction(mainFrame, view, position, HandlerHelper.DEFAULT_COMMENT_SIZE,
                    "CommentNode", nodeContainer);
        } else {
            action =
                new AddCommentNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_COMMENT_SIZE,
                    "CommentNode");
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add UseCase Node");
        if (component instanceof NodeContainer) {
            DeployHelper.updateZOrder((NodeContainer) component);
        }
        CommentNode node = (CommentNode) action.getNode();
        node.notifyUpdate();

        // To trigger mouse double click for this node, diagram state have to be set as SELECT_ELEMENT first,
        // otherwise
        // the mouse event will be pass behind
        DiagramViewer viewer = view.getViewer();
        DiagramState state = viewer.getState();
        viewer.setState(DiagramState.SELECT_ELEMENT);
        triggerDoubleClick(node);
        // Restore diagram state
        viewer.setState(state);

        return node;
    }

    /**
     * <p>
     * Adds a FreeTextNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private FreeTextNode addFreeTextNode(DiagramView view, Rectangle bound) {
        AddFreeTextNodeAction action =
            new AddFreeTextNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_FREETEXT_SIZE,
                "FreeTextNode");

        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add FreeTextNode");

        FreeTextNode node = (FreeTextNode) action.getNode();
        DeployHelper.moveNodeToFront(view, node);
        node.notifyUpdate();

        // To trigger mouse double click for this node, diagram state have to be set as SELECT_ELEMENT first,
        // otherwise
        // the mouse event will be pass behind
        DiagramViewer viewer = view.getViewer();
        DiagramState state = viewer.getState();
        viewer.setState(DiagramState.SELECT_ELEMENT);
        triggerDoubleClick(node);
        // Restore diagram state
        viewer.setState(state);

        return node;
    }

    /**
     * <p>
     * Adds a PolylineNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private PolylineNode addPolylineNode(DiagramView view, Rectangle bound) {
        if (bound.width == 0 && bound.height == 0) {
            bound.setSize(HandlerHelper.DEFAULT_SHAPE_SIZE);
        }
        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(DeployHelper.createPoint(bound.getLocation()));
        graphEdge.addWaypoint(DeployHelper.createPoint(bound.x + bound.width, bound.y));
        graphEdge.addWaypoint(DeployHelper.createPoint(bound.x + bound.width, bound.y + bound.height));
        graphEdge.addWaypoint(DeployHelper.createPoint(bound.x, bound.y + bound.height));
        graphEdge.addWaypoint(DeployHelper.createPoint(bound.getLocation()));

        AddPolylineAction action = new AddPolylineAction(mainFrame, view, graphEdge);

        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add PolylineNode");

        PolylineNode node = (PolylineNode) action.getNode();
        return node;
    }

    /**
     * <p>
     * Adds a CommentLinkEdge edge to given DiagramView, the edge's start and end position is contained in bound
     * argument.
     * </p>
     *
     * @param view
     *            diagram view where this edge is added
     * @param bound
     *            this rectangle's left-up corner means edge's start position, the right-bottom corner means edge's
     *            end position
     * @return the new created edge
     */
    private CommentLinkEdge addCommentLinkEdge(DiagramView view, Rectangle bound) {
        Point start = bound.getLocation();
        Point end = new Point(bound.x + bound.width, bound.y + bound.height);

        Component component = view.getComponentAt(start);
        if (component == null) {
            return null;
        }
        Node startNode = null;
        if (component instanceof Node) {
            startNode = (Node) component;
        } else {
            return null;
        }
        component = view.getComponentAt(end);
        Node targetNode = null;
        NodeContainer targetContainer = null;
        AddCommentNodeAction addCommentNodeAction = null;
        if (component instanceof NodeContainer) {
            targetContainer = (NodeContainer) component;
        }
        if (component instanceof Node) {
            targetNode = (Node) component;
        }

        if (targetNode instanceof CommentNode && startNode instanceof CommentNode) {
            return null;
        }

        if ((targetNode == null || targetContainer != null) && !(startNode instanceof CommentNode)) {
            // Create a new CommentNode
            Point location = new Point(end);
            if (targetContainer != null) {
                Point position = DeployHelper.getAbsoluteGraphNodePosition(targetContainer.getGraphNode());
                location.x -= position.x;
                location.y -= position.y;
            }
            addCommentNodeAction =
                new AddCommentNodeAction(mainFrame, view, location, HandlerHelper.DEFAULT_COMMENT_SIZE,
                    "Comment Node", targetContainer);
            targetNode = null;
        }
        if ((targetNode != null && !(targetNode instanceof CommentNode))) {
            if (startNode instanceof CommentNode) {
                // Swap, make the target node always a CommentNode
                Node temp = targetNode;
                targetNode = startNode;
                startNode = temp;
                Point swap = start;
                start = end;
                end = swap;
            } else {
                return null;
            }
        }

        AddCommentLinkEdgeAction action;
        if (targetNode != null) {
            action = new AddCommentLinkEdgeAction(mainFrame, view, start, end, startNode, targetNode);
        } else {
            action = new AddCommentLinkEdgeAction(mainFrame, view, start, end, startNode, addCommentNodeAction);
        }
        if (addCommentNodeAction != null) {
            UpdateNodeContainerAction compositeAction =
                new UpdateNodeContainerAction(action, view, "Add CommentLink Edge");
            mainFrame.handleActionEvent(compositeAction, view, "Add CommentLink Edge");
            targetNode = addCommentNodeAction.getNode();

            // To trigger mouse double click for this node, diagram state have to be set as SELECT_ELEMENT first,
            // otherwise
            // the mouse event will be pass behind
            DiagramViewer viewer = view.getViewer();
            DiagramState state = viewer.getState();
            viewer.setState(DiagramState.SELECT_ELEMENT);
            triggerDoubleClick(targetNode);
            // Restore diagram state
            viewer.setState(state);
        } else {
            mainFrame.handleActionEvent(action, view, "Add CommentLink Edge");
        }
        return (CommentLinkEdge) action.getEdge();
    }

    /**
     * <p>
     * Adds a PackageNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node container
     */
    private PackageNode addPackageNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddPackageNodeAction action = null;
        if (component instanceof PackageNode) {
            PackageNode nodeContainer = (PackageNode) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddPackageNodeAction(mainFrame, view, position, HandlerHelper.DEFAULT_PACKAGE_SIZE, null,
                    nodeContainer);
        } else {
            action =
                new AddPackageNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_PACKAGE_SIZE,
                    (String) null);
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add Package Node");
        if (component instanceof PackageNode) {
            view.setComponentZOrder(action.getNode(), 0);
        }
        PackageNode node = (PackageNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds a ClassNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private ClassNode addClassNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddClassNodeAction action = null;
        if (component instanceof PackageNode) {
            PackageNode nodeContainer = (PackageNode) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddClassNodeAction(mainFrame, view, position, HandlerHelper.DEFAULT_CLASS_SIZE, null,
                    nodeContainer);
        } else {
            action =
                new AddClassNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_CLASS_SIZE,
                    (String) null);
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add Class Node");
        if (component instanceof PackageNode) {
            view.setComponentZOrder(action.getNode(), 0);
        }
        ClassNode node = (ClassNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds an ExceptionNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private ExceptionNode addExceptionNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddExceptionNodeAction action = null;
        if (component instanceof PackageNode) {
            PackageNode nodeContainer = (PackageNode) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddExceptionNodeAction(mainFrame, view, position, HandlerHelper.DEFAULT_CLASS_SIZE, null,
                    nodeContainer);
        } else {
            action =
                new AddExceptionNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_CLASS_SIZE,
                    null);
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        ExceptionNode node = (ExceptionNode) action.getNode();

        GraphNode graphNode = node.getGraphNode();
        Classifier classifier = (Classifier) DeployHelper.getElement(graphNode);

        // add constructors automatically
        List<Operation> constructors = new ArrayList<Operation>();
        String stringType = "String";
        String causeType = "Throwable";

        boolean isCSharp = UMLModelManager.getInstance().getProjectLanguage().equals("CSharp");
        if (isCSharp) {
            stringType = "string";
            causeType = "Exception";
            // Creates two extra constructors for .Net exceptions
            constructors.add(createDefaultConstructor(classifier));
        }

        constructors.add(createConstructor(classifier.getName(), "message", stringType));
        constructors.add(createSencondConstructor(classifier, stringType, causeType));

        if (isCSharp) {
            constructors.add(createThirdConstructor(classifier));
        }

        // create stereotype
        Stereotype stereotype = DeployHelper.getStereotype(mainFrame, "create", OperationImpl.class);
        Set<Stereotype> newStereotypes = new HashSet<Stereotype>();
        newStereotypes.add(stereotype);
        mainFrame.getPropertiesPanel().addStereotypes(newStereotypes, constructors.get(0).getClass());

        for (Operation ctor : constructors) {
            // FIXME remove this code after AddOperationAction is fixed
            ctor.setOwner(classifier);

            ctor.addStereotype(stereotype);

            // add two constructors
            AddOperationAction addOperationAction =
                new AddOperationAction((Classifier) DeployHelper.getElement(graphNode), ctor);
            compositeAction.put(addOperationAction, node);
        }

        mainFrame.handleActionEvent(compositeAction, view, "Add Exception Node");
        if (component instanceof PackageNode) {
            view.setComponentZOrder(node, 0);
        }
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Adds an EnumClassNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private EnumClassNode addEnumClassNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddEnumClassNodeAction action = null;
        if (component instanceof PackageNode) {
            PackageNode nodeContainer = (PackageNode) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddEnumClassNodeAction(mainFrame, view, position, HandlerHelper.DEFAULT_CLASS_SIZE, null,
                    nodeContainer);
        } else {
            action =
                new AddEnumClassNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_CLASS_SIZE,
                    null);
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        EnumClassNode node = (EnumClassNode) action.getNode();

        mainFrame.handleActionEvent(compositeAction, view, "Add Enum Class Node");
        if (component instanceof PackageNode) {
            view.setComponentZOrder(node, 0);
        }
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Creates the default constructor for an exception node.
     * </p>
     *
     * @param classifier
     *            the classifier to create constructor
     * @return the created constructor
     */
    private Operation createDefaultConstructor(Classifier classifier) {
        Operation constructor = new OperationImpl();
        constructor.setName(classifier.getName());
        constructor.setConcurrency(CallConcurrencyKind.SEQUENTIAL);
        constructor.setVisibility(VisibilityKind.PUBLIC);
        return constructor;
    }

    /**
     * <p>
     * Creates the second constructor for an exception node. It has two parameters, the first is a String parameter
     * named message, the other is an Exception parameter named cause.
     * </p>
     *
     * @param classifier
     *            the classifier to create constructor
     * @param stringType
     *            string type
     * @param causeType
     *            cause type
     * @return the created constructor
     */
    private Operation createSencondConstructor(Classifier classifier, String stringType, String causeType) {
        List<String> parameterNames = new ArrayList<String>();
        List<String> parameterTypes = new ArrayList<String>();
        parameterNames.add("message");
        parameterTypes.add(stringType);
        parameterNames.add("cause");
        parameterTypes.add(causeType);
        Operation ctor = createConstructor(classifier.getName(), parameterNames, parameterTypes);
        return ctor;
    }

    /**
     * <p>
     * Creates the third constructor for an exception node in .Net project. It has two parameters, the first is a
     * SerializationInfo parameter named info, the other is a StreamingContext parameter named context. This
     * constructor is protected.
     * </p>
     *
     * @param classifier
     *            the classifier to create constructor
     * @return the created constructor
     */
    private Operation createThirdConstructor(Classifier classifier) {
        List<String> parameterNames = new ArrayList<String>();
        List<String> parameterTypes = new ArrayList<String>();
        parameterNames.add("info");
        parameterTypes.add("SerializationInfo");
        parameterNames.add("context");
        parameterTypes.add("StreamingContext");
        Operation ctor = createConstructor(classifier.getName(), parameterNames, parameterTypes);
        ctor.setVisibility(VisibilityKind.PROTECTED);
        return ctor;
    }

    /**
     * <p>
     * Creates an constructor operation with given name and parameters.
     * </p>
     *
     * @param name
     *            operation name
     * @param parameterNames
     *            list containing parameter names
     * @param parameterTypes
     *            list containing parameter types
     * @return the created operation
     */
    private Operation createConstructor(String name, List<String> parameterNames, List<String> parameterTypes) {
        Operation constructor = new OperationImpl();
        constructor.setName(name);
        constructor.setConcurrency(CallConcurrencyKind.SEQUENTIAL);
        constructor.setVisibility(VisibilityKind.PUBLIC);

        int size = parameterNames.size();
        for (int i = 0; i < size; i++) {
            Parameter parameter = new ParameterImpl();
            parameter.setName(parameterNames.get(i));
            parameter.setType(DeployHelper.findType(parameterTypes.get(i), mainFrame));
            parameter.setKind(ParameterDirectionKind.IN);
            parameter.setBehavioralFeature(constructor);

            constructor.addParameter(parameter);
        }

        return constructor;
    }

    /**
     * <p>
     * Creates an constructor operation with given name and one parameter.
     * </p>
     *
     * @param name
     *            operation name
     * @param parameterNames
     *            parameter name
     * @param parameterTypes
     *            parameter type
     * @return the created operation
     */
    private Operation createConstructor(String name, String parameterName, String parameterType) {
        List<String> parameterNames = new ArrayList<String>();
        parameterNames.add(parameterName);
        List<String> parameterTypes = new ArrayList<String>();
        parameterTypes.add(parameterType);

        return createConstructor(name, parameterNames, parameterTypes);
    }

    /**
     * <p>
     * Adds an InterfaceNode to given DiagramView, the node's location is contained in bound argument.
     * </p>
     *
     * @param view
     *            diagram view where this node is added
     * @param bound
     *            node's location is defined by this rectangle
     * @return the new created node
     */
    private InterfaceNode addInterfaceNode(DiagramView view, Rectangle bound) {
        Component component = view.getComponentAt(bound.x, bound.y);
        AddInterfaceNodeAction action = null;
        if (component instanceof PackageNode) {
            PackageNode nodeContainer = (PackageNode) component;
            Point position = DeployHelper.getAbsoluteGraphNodePosition(nodeContainer.getGraphNode());
            position.x = bound.x - position.x;
            position.y = bound.y - position.y;
            action =
                new AddInterfaceNodeAction(mainFrame, view, position, HandlerHelper.DEFAULT_CLASS_SIZE, null,
                    nodeContainer);
        } else {
            action =
                new AddInterfaceNodeAction(mainFrame, view, bound.getLocation(), HandlerHelper.DEFAULT_CLASS_SIZE,
                    (String) null);
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(action, view, "Node added");
        mainFrame.handleActionEvent(compositeAction, view, "Add Interface Node");
        if (component instanceof PackageNode) {
            view.setComponentZOrder(action.getNode(), 0);
        }
        InterfaceNode node = (InterfaceNode) action.getNode();
        triggerDoubleClick(node.getNameCompartment());
        return node;
    }

    /**
     * <p>
     * Triggers a mouse double click event on given component.
     * </p>
     *
     * @param component
     *            the component to double click
     */
    private void triggerDoubleClick(Component component) {
        if (component != null && component.isShowing()) {
            MouseEvent event =
                new MouseEvent(component, MouseEvent.MOUSE_CLICKED, 1000, MouseEvent.ALT_DOWN_MASK, component
                    .getWidth() / 2, component.getHeight() / 2, 2, false, MouseEvent.BUTTON1);
            component.dispatchEvent(event);
        }
    }
}
