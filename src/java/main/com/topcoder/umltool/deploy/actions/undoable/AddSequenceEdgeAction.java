/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodeConnector;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.actions.model.sequence.AddAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.AddCreateMessageAction;
import com.topcoder.uml.actions.model.sequence.AddReturnMessageAction;
import com.topcoder.uml.actions.model.sequence.AddSendSignalMessageAction;
import com.topcoder.uml.actions.model.sequence.AddSynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.actions.messagingactions.SendSignalActionImpl;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.handlers.ElementSelectionHandler;
import com.topcoder.umltool.deploy.handlers.SequenceEdgeNameChangedHandler;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This action is used for add sequence edges to the diagram view.
 * </p>
 * <p>
 * AddMessageAction and AddDiagramElementAction are used.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddSequenceEdgeAction extends UndoableAbstractAction {
    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Sequence Edge";

    /**
     * <p>
     * Reference to UMLModelManager. Used for create predefined actions.
     * </p>
     */
    private UMLModelManager modelManager;

    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Reference to diagram view.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * Start position to add the sequence edge.
     * </p>
     */
    private Point startPoint;

    /**
     * <p>
     * End position to add the sequence edge.
     * </p>
     */
    private Point endPoint;

    /**
     * <p>
     * Start node of the adding sequence edge.
     * </p>
     */
    private ObjectNode startNode;

    /**
     * <p>
     * End node of the adding sequence edge.
     * </p>
     */
    private ObjectNode endNode;

    /**
     * <p>
     * Stimulus used for create message edge and graph edge.
     * </p>
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Graph edge for created edges.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Created sequence edge.
     * </p>
     */
    private SequenceEdge sequenceEdge;

    /**
     * <p>
     * Edge type of the adding sequence edge.
     * </p>
     */
    private Class edgeClass;

    /**
     * <p>
     * Action to add an object node.
     * </p>
     */
    private AddObjectNodeAction addObjectNodeAction = null;

    /**
     * <p>
     * Action to add message edge.
     * </p>
     */
    private UndoableAction addMessageAction;

    /**
     * <p>
     * Action to add the graph edge to the diagram.
     * </p>
     */
    private AddDiagramElementAction addDiagramElementAction;

    /**
     * <p>
     * Action to add the return edge to the diagram.
     * </p>
     */
    private AddSequenceEdgeAction addReturnEdgeAction;

    /**
     * <p>
     * Action to layout sequence edges.
     * </p>
     */
    private LayoutSequenceEdgeAction layoutEdgeAction;

    /**
     * <p>
     * Creates an instance of AddSequenceEdge action and creates object, graph node, ObjectNode.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param view
     *            reference to diagram view
     * @param startPoint
     *            start point to add the sequence edge
     * @param endPoint
     *            end point to add the sequence edge
     * @param startNode
     *            start node for the adding sequence edge
     * @param endNode
     *            end node for the adding sequence edge
     * @param edgeClass
     *            sequence edge type
     */
    public AddSequenceEdgeAction(MainFrame mainFrame, DiagramView view, Point startPoint, Point endPoint,
        ObjectNode startNode, ObjectNode endNode, Class edgeClass) {
        super(PRESENTATION_NAME);

        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(view, "view");
        DeployHelper.checkNotNull(startPoint, "startPoint");
        DeployHelper.checkNotNull(endPoint, "endPoint");
        DeployHelper.checkNotNull(startNode, "startNode");
        DeployHelper.checkNotNull(edgeClass, "edgeClass");

        // if end node not exist, add an AddObjectNodeAction and get the object
        // node.
        if (endNode == null) {
            addObjectNodeAction = new AddObjectNodeAction(mainFrame, view, endPoint);
            endNode = (ObjectNode) addObjectNodeAction.getNode();
        }

        this.mainFrame = mainFrame;
        this.diagramView = view;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startNode = startNode;
        this.endNode = endNode;
        this.edgeClass = edgeClass;
        this.addReturnEdgeAction = null;

        modelManager = UMLModelManager.getInstance();

        createAddMessageAction();
        createGraphEdge();
        createSequenceEdge();
    }

    /**
     * <p>
     * Gets the create sequence edge of the out direction.
     * </p>
     * @return the created sequence edge.
     */
    public SequenceEdge getSequenceEdge() {
        return sequenceEdge;
    }

    /**
     * <p>
     * Creates the stimulus according to the edge class type.
     * </p>
     * @param edgeClass
     *            class type of the sequence edge
     * @return the created stimulus
     */
    private Stimulus createStimulus(Class edgeClass) {
        Link link = new LinkImpl();
        LinkEnd linkEnd = new LinkEndImpl();
        linkEnd.setLink(link);
        link.addConnection(linkEnd);

        Stimulus stimulusImpl = new StimulusImpl();
        stimulusImpl.setCommunicationLink(link);
        link.addStimulus(stimulusImpl);

        Procedure procedure = new ProcedureImpl();
        if (edgeClass == AsynchronousMessageEdge.class) {
            CallOperationActionImpl callOperationAction = new CallOperationActionImpl();
            callOperationAction.setAsynchronous(true);
            procedure.setAction(callOperationAction);
        } else if (edgeClass == SynchronousMessageEdge.class) {
            CallOperationActionImpl callOperationAction = new CallOperationActionImpl();
            callOperationAction.setAsynchronous(false);
            procedure.setAction(callOperationAction);
        } else if (edgeClass == CreateMessageEdge.class) {
            Stereotype stereotype = DeployHelper.getStereotype(mainFrame, "create", link.getClass());
            if (stereotype == null) {
                stereotype = new StereotypeImpl();
                stereotype.setName("create");
                stereotype.setBaseClass(link.getClass().getName());
                Set<Stereotype> set = new HashSet<Stereotype>();
                set.add(stereotype);
                mainFrame.getPropertiesPanel().addStereotypes(set, link.getClass());
            }
            link.addStereotype(stereotype);
            CreateObjectActionImpl createObjectAction = new CreateObjectActionImpl();
            procedure.setAction(createObjectAction);
        } else if (edgeClass == SendSignalMessageEdge.class) {
            SendSignalActionImpl sendSignalAction = new SendSignalActionImpl();
            procedure.setAction(sendSignalAction);
        } else if (edgeClass == ReturnMessageEdge.class) {
            procedure.setAction(null);
        }

        stimulusImpl.setDispatchAction(procedure);
        return stimulusImpl;
    }

    /**
     * <p>
     * Creates the AddMessageEdgeAction for the given direction edge direction.
     * </p>
     */
    private void createAddMessageAction() {
        Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagramView.getDiagram().getOwner();
        Collaboration collaboration = (Collaboration) bridge.getElement();
        Class currentEdgeClass = edgeClass;

        stimulus = createStimulus(currentEdgeClass);
        addMessageAction = null;
        try {
            if (currentEdgeClass == AsynchronousMessageEdge.class) {
                addMessageAction = new AddAsynchronousMessageAction(stimulus, collaboration, modelManager);
            } else if (currentEdgeClass == SynchronousMessageEdge.class) {
                addMessageAction = new AddSynchronousMessageAction(stimulus, collaboration, modelManager);
            } else if (currentEdgeClass == CreateMessageEdge.class) {
                addMessageAction = new AddCreateMessageAction(stimulus, collaboration, modelManager);
            } else if (currentEdgeClass == SendSignalMessageEdge.class) {
                addMessageAction = new AddSendSignalMessageAction(stimulus, collaboration, modelManager);
            } else if (currentEdgeClass == ReturnMessageEdge.class) {
                addMessageAction = new AddReturnMessageAction(stimulus, collaboration, modelManager);
            }
        } catch (SequenceConfigurationException e) {
            DeployHelper.handleException(mainFrame, e, "create add message action failed");
        }
    }

    /**
     * <p>
     * Creates the graph edge and the AddDiagramElementAction.
     * </p>
     */
    private void createGraphEdge() {
        List<Point> wayPoints = new ArrayList<Point>();
        wayPoints.add(startPoint);
        wayPoints.add(endPoint);

        graphEdge = DeployHelper.createGraphEdgeForUseCase(stimulus.getCommunicationLink(), wayPoints, "");

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphNode name = new GraphNode();
        DeployHelper.setTypeInfo(name, "Name");
        DeployHelper.addContained(graphEdge, name);

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        GraphNode stereotypeCompartment = DeployHelper.createStereotypeCompartment(null, false);
        DeployHelper.addContained(graphEdge, stereotypeCompartment);

        addDiagramElementAction = new AddDiagramElementAction(diagramView.getDiagram(), graphEdge, modelManager
                .getProjectConfigurationManager());
    }

    /**
     * <p>
     * Creates the sequence edge of given edge direction.
     * </p>
     */
    private void createSequenceEdge() {
        sequenceEdge = DeployHelper.createSequenceEdge(mainFrame, diagramView, graphEdge);
    }

    /**
     * <p>
     * Adds the sequence edge to diagram view and set graph edge.
     * </p>
     * @param start
     *            start point of the sequence edge
     * @param end
     *            end point of the sequence edge
     * @param startNode
     *            start node of the sequence edge
     * @param endNode
     *            end node of the sequence edge
     */
    private void addSequenceEdge(Point start, Point end, ObjectNode startNode, ObjectNode endNode) {
        // connect graph nodes and graph edge
        DeployHelper.connectEdgeWithNodes(graphEdge, startNode.getGraphNode(), endNode.getGraphNode());

        // adjust waypoints and position of graph edge
        graphEdge.clearWaypoints();
        graphEdge.addWaypoint(0, DeployHelper.createPoint(start));
        graphEdge.addWaypoint(1, DeployHelper.createPoint(end));

        // graphEdge.setPosition(DeployHelper.createPoint(start));

        // update waypoints of sequence edge
        sequenceEdge.notifyChangeWayPoint(0, sequenceEdge.getWayPoints().get(0).getCenter());
        sequenceEdge.notifyChangeWayPoint(1, sequenceEdge.getWayPoints().get(1).getCenter());

        // set the edge's name
        ModelElement modelElement = DeployHelper.getElement(graphEdge);
        modelElement.setName("anonymous");

        // Set the edge's connectors
        sequenceEdge.setLeftConnector(new ObjectNodeConnector(startNode));
        sequenceEdge.setRightConnector(new ObjectNodeConnector(endNode));

        sequenceEdge.notifyGraphEdgeChange();
        sequenceEdge.addMouseListener(new ElementSelectionHandler(mainFrame));
        sequenceEdge.getNameCompartment().addTextChangedListener(new SequenceEdgeNameChangedHandler(mainFrame));
        diagramView.add(sequenceEdge);
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        List<SequenceEdge> oldEdgeList = DeployHelper.getSequenceEdges(diagramView);

        try {
            if (addObjectNodeAction != null) {
                addObjectNodeAction.execute();
            }
            addMessageAction.execute();
            addDiagramElementAction.execute();
        } catch (ActionExecutionException e) {
            DeployHelper.handleException(mainFrame, e, "Adding sequence edge failed");
        }
        addSequenceEdge(startPoint, endPoint, startNode, endNode);

        List<SequenceEdge> newEdgeList = DeployHelper.getSequenceEdges(diagramView);
        layoutEdgeAction = new LayoutSequenceEdgeAction(mainFrame, oldEdgeList, newEdgeList);
        layoutEdgeAction.execute();

        mainFrame.updateDiagramView();
        mainFrame.getDocumentTree().updateTree();

        if (edgeClass == SynchronousMessageEdge.class || edgeClass == CreateMessageEdge.class
                || edgeClass == SendSignalMessageEdge.class) {
            Point returnStartPoint = new Point((int) graphEdge.getWaypoints().get(1).getX(), (int) graphEdge
                    .getWaypoints().get(1).getY() + 1);
            Point returnEndPoint = new Point((int) graphEdge.getWaypoints().get(0).getX(), (int) graphEdge
                    .getWaypoints().get(0).getY() + 1);
            addReturnEdgeAction = new AddSequenceEdgeAction(mainFrame, diagramView, returnStartPoint, returnEndPoint,
                    endNode, startNode, ReturnMessageEdge.class);
            try {
                addReturnEdgeAction.execute();
            } catch (ActionExecutionException e) {
                DeployHelper.handleException(mainFrame, e, "Adding sequence edge failed");
            }
        }
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        if (addReturnEdgeAction != null) {
            addReturnEdgeAction.undo();
        }

        layoutEdgeAction.undo();

        // disconnect graphnode and graph edge, remove the added segment
        startNode.getGraphNode().removeAnchorage(graphEdge.getAnchors().get(0));
        endNode.getGraphNode().removeAnchorage(graphEdge.getAnchors().get(1));
        graphEdge.clearAnchors();

        diagramView.remove(sequenceEdge);
        addDiagramElementAction.undo();
        addMessageAction.undo();
        if (addObjectNodeAction != null) {
            addObjectNodeAction.undo();
        }

        mainFrame.updateDiagramView();
        mainFrame.getDocumentTree().updateTree();
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        if (addObjectNodeAction != null) {
            addObjectNodeAction.redo();
        }
        addMessageAction.redo();
        addDiagramElementAction.redo();
        DeployHelper.connectEdgeWithNodes(graphEdge, startNode.getGraphNode(), endNode.getGraphNode());
        diagramView.add(sequenceEdge);

        layoutEdgeAction.redo();

        mainFrame.updateDiagramView();
        mainFrame.getDocumentTree().updateTree();

        if (addReturnEdgeAction != null) {
            addReturnEdgeAction.redo();
        }
    }
}
