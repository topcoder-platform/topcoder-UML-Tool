/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used to add a Transition to the diagram view. It will create model element and graph element, then add
 * them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddTransitionAction extends AddEdgeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Transition Edge";

    /**
     * <p>
     * Represents the uml model manager.
     * </p>
     */
    private UMLModelManager modelManager;

    /**
     * <p>
     * Start position of the graph edge for this edge.
     * </p>
     */
    private Point start;

    /**
     * <p>
     * End position of the graph edge for this edge.
     * </p>
     */
    private Point end;

    /**
     * <p>
     * Name of the model element for this edge.
     * </p>
     */
    private String name;

    /**
     * <p>
     * Model element for this edge.
     * </p>
     */
    private com.topcoder.uml.model.statemachines.Transition transition;

    /**
     * <p>
     * Graph edge for this edge.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Creates an instance of <code>AddTransitionAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new edge
     * @param start
     *            start position of the graph edge for added edge
     * @param end
     *            end position of the graph edge for added edge
     * @param name
     *            name of the model element for added edge
     * @param startNode
     *            start node of the added edge
     * @param targetNode
     *            target node of the added edge
     */
    public AddTransitionAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
        BaseNode startNode, BaseNode targetNode) {
        super(PRESENTATION_NAME, mainFrame, view, startNode, targetNode);
        this.start = start;
        this.end = end;
        this.name = name;

        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Creates an instance of <code>AddTransitionAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new edge
     * @param start
     *            start position of the graph edge for added edge
     * @param end
     *            end position of the graph edge for added edge
     * @param name
     *            name of the model element for added edge
     * @param startNode
     *            start node of the added edge
     * @param addActionStateAction
     *            action to create the target node
     */
    public AddTransitionAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
        BaseNode startNode, AddActionStateAction addActionStateAction) {
        super(PRESENTATION_NAME, mainFrame, view, startNode, addActionStateAction);
        this.start = start;
        this.end = end;
        this.name = name;

        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Creates the model element for new edge.
     * </p>
     */
    protected void createModelElement() {
        transition = new TransitionImpl();
        transition.setName(name);
        Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) getDiagramView().getDiagram().getOwner();
        setAddModelElementAction(new com.topcoder.uml.actions.model.activity.AddTransitionAction(transition,
                (ActivityGraph) bridge.getElement(), modelManager));
    }

    /**
     * <p>
     * Creates the graph edge for new edge.
     * </p>
     */
    protected void createGraphEdge() {
        BaseNode startNode = (BaseNode) getStartNode();
        BaseNode targetNode = (BaseNode) getTargetNode();
        List<Point> wayPoints = new ArrayList<Point>();
        if (startNode != targetNode) {
            // Relocate the start and end position
            end = targetNode.getConnector().getConnectionPoint(start);
            start = startNode.getConnector().getConnectionPoint(end);

            wayPoints.add(start);
            wayPoints.add(end);
        } else {
            // Self-connected
            wayPoints = DeployHelper.createSelfConnectedWayPoints(startNode);
        }
        graphEdge = DeployHelper.createGraphEdgeForTransition(transition, wayPoints);

        setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphEdge, modelManager
                .getProjectConfigurationManager()));
    }

    /**
     * <p>
     * Creates a new Transition edge.
     * </p>
     */
    protected void createEdge() {
        // Connect graph edge with nodes' graph node
        BaseNode startNode = (BaseNode) getStartNode();
        BaseNode targetNode = (BaseNode) getTargetNode();
        DeployHelper.connectEdgeWithNodes(graphEdge, startNode.getGraphNode(), targetNode.getGraphNode());

        Transition edge = DeployHelper.createTransitionEdge(getMainFrame(), getDiagramView(), graphEdge);

        // Set the edge's connectors
        edge.setLeftConnector(startNode.getConnector());
        edge.setRightConnector(targetNode.getConnector());

        setEdge(edge);
    }

}
