/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used to add an CommentLinkEdge to the diagram view. It will create model element and graph element,
 * then add them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddCommentLinkEdgeAction extends AddEdgeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add CommentLink Edge";

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
     * Graph edge for this edge.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Creates an instance of <code>AddCommentLinkEdgeAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new edge
     * @param start
     *            start position of the graph edge for added edge
     * @param end
     *            end position of the graph edge for added edge
     * @param startNode
     *            start node of the added edge
     * @param targetNode
     *            target node of the added edge
     */
    public AddCommentLinkEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, Node startNode,
        Node targetNode) {
        super(PRESENTATION_NAME, mainFrame, view, startNode, targetNode);
        this.start = start;
        this.end = end;

        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Creates an instance of <code>AddCommentLinkEdgeAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new edge
     * @param start
     *            start position of the graph edge for added edge
     * @param end
     *            end position of the graph edge for added edge
     * @param startNode
     *            start node of the added edge
     * @param addCommentNodeAction
     *            action to create the target node
     */
    public AddCommentLinkEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, Node startNode,
        AddCommentNodeAction addCommentNodeAction) {
        super(PRESENTATION_NAME, mainFrame, view, startNode, addCommentNodeAction);
        this.start = start;
        this.end = end;

        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Creates the model element for new edge. Empty since there's no model element for this edge.
     * </p>
     */
    protected void createModelElement() {
    }

    /**
     * <p>
     * Creates the graph edge for new edge.
     * </p>
     */
    protected void createGraphEdge() {
        Node startNode = getStartNode();
        Node targetNode = getTargetNode();
        List<Point> wayPoints = new ArrayList<Point>();
        if (startNode != targetNode) {
            // Relocate the start and end position
            end = DeployHelper.getConnector(targetNode).getConnectionPoint(start);
            start = DeployHelper.getConnector(startNode).getConnectionPoint(end);

            wayPoints.add(start);
            wayPoints.add(end);
        } else {
            // Self-connected
            wayPoints = DeployHelper.createSelfConnectedWayPoints(startNode);
        }
        graphEdge = DeployHelper.createGraphEdgeForCommentLink(wayPoints);

        setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphEdge, modelManager
                .getProjectConfigurationManager()));
    }

    /**
     * <p>
     * Creates a new CommentLinkEdge edge.
     * </p>
     */
    protected void createEdge() {
        Node startNode = getStartNode();
        Node targetNode = getTargetNode();

        // Connect graph edge with nodes' graph node
        DeployHelper.connectEdgeWithNodes(graphEdge, startNode.getGraphNode(), targetNode.getGraphNode());

        CommentLinkEdge edge = DeployHelper.createCommentLinkEdge(getMainFrame(), getDiagramView(), graphEdge);

        // Set the edge's connectors
        edge.setLeftConnector(DeployHelper.getConnector(startNode));
        edge.setRightConnector(DeployHelper.getConnector(targetNode));

        setEdge(edge);
    }
}
