/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used to add an Polyline to the diagram view. It will create model element and graph element, then add
 * them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 * @author ly
 * @version 1.0
 */
public class AddPolylineAction extends AddNodeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Polyline";

    /**
     * <p>
     * Graph edge for this polyline.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Polyline instance.
     * </p>
     */
    private Polyline polyline;

    /**
     * <p>
     * Creates an instance of <code>AddPolylineAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new node
     * @param graphEdge
     *            graph edge for this polyline
     */
    public AddPolylineAction(MainFrame mainFrame, DiagramView view, GraphEdge graphEdge) {
        this(mainFrame, view, graphEdge, null);
    }

    /**
     * <p>
     * Creates an instance of <code>AddPolylineAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new node
     * @param graphEdge
     *            graph edge for this polyline
     * @param nodeContainer
     *            the NodeContainer which the new node should add to
     */
    public AddPolylineAction(MainFrame mainFrame, DiagramView view, GraphEdge graphEdge, NodeContainer nodeContainer) {
        super(PRESENTATION_NAME, mainFrame, view, nodeContainer);
        this.graphEdge = graphEdge;

        createModelElement();
        createGraphNode();
        createNode();
    }

    /**
     * <p>
     * Creates the model element for new node.
     * </p>
     */
    protected void createModelElement() {
        polyline = new Polyline();
        for (Point wayPoint : graphEdge.getWaypoints()) {
            polyline.addWaypoint(wayPoint);
        }
        polyline.setClosed(true);
        DeployHelper.addContained(getDiagramView().getDiagram(), polyline);
    }

    /**
     * <p>
     * Creates the graph node for new node.
     * </p>
     */
    protected void createGraphNode() {
    }

    /**
     * <p>
     * Creates a new Polyline node.
     * </p>
     */
    protected void createNode() {
        PolylineNode node = DeployHelper.createPolylineNode(getMainFrame(), polyline);
        node.getGraphNode().setContainer(getDiagramView().getDiagram());
        setNode(node);
    }
}
