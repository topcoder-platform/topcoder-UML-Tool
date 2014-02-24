/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.model.classifiers.AddDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used to add a DependencyEdge to the diagram view. It will create model element and graph element,
 * then add them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddDependencyEdgeAction extends AddEdgeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Dependency Edge";

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
    private Dependency dependency;

    /**
     * <p>
     * Graph edge for this edge.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Left connector of the edge.
     * </p>
     */
    private Connector leftConnector;

    /**
     * <p>
     * Right connector of the edge.
     * </p>
     */
    private Connector rightConnector;

    /**
     * <p>
     * Creates an instance of <code>AddDependencyEdgeAction</code>.
     * </p>
     *
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
    public AddDependencyEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
        Node startNode, Node targetNode) {
        super(PRESENTATION_NAME, mainFrame, view, startNode, targetNode);
        this.start = start;
        this.end = end;
        this.name = name;

        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Creates an instance of <code>AddDependencyEdgeAction</code>.
     * </p>
     *
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
     * @param addNodeAction
     *            action to create the target node
     */
    public AddDependencyEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
        Node startNode, AddNodeAction addNodeAction) {
        super(PRESENTATION_NAME, mainFrame, view, startNode, addNodeAction);
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
        dependency = new DependencyImpl();
        dependency.setName(name);
        dependency.addClient(DeployHelper.getElement(getStartNode().getGraphNode()));
        dependency.addSupplier(DeployHelper.getElement(getTargetNode().getGraphNode()));
        setAddModelElementAction(new AddDependencyAction(dependency, modelManager));
    }

    /**
     * <p>
     * Creates the graph edge for new edge.
     * </p>
     */
    protected void createGraphEdge() {
        Node startNode = getStartNode();
        Node targetNode = getTargetNode();
        if (startNode instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
            leftConnector =
                ((com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) startNode).getConnector();
        } else if (startNode instanceof SubsystemNodeContainer) {
            leftConnector = ((SubsystemNodeContainer) startNode).getConnector();
        } else if (startNode instanceof BaseNode) {
            leftConnector = ((BaseNode) startNode).getConnector();
        } else if (startNode instanceof PackageNode) {
            leftConnector = ((PackageNode) startNode).getConnector();
        }

        List<Point> wayPoints = new ArrayList<Point>();

        if (startNode != targetNode) {
            if (targetNode instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
                rightConnector =
                    ((com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) targetNode).getConnector();
            } else if (targetNode instanceof SubsystemNodeContainer) {
                rightConnector = ((SubsystemNodeContainer) targetNode).getConnector();
            } else if (targetNode instanceof BaseNode) {
                rightConnector = ((BaseNode) targetNode).getConnector();
            } else if (targetNode instanceof PackageNode) {
                rightConnector = ((PackageNode) targetNode).getConnector();
            }
            // Relocate the start and end position
            end = rightConnector.getConnectionPoint(start);
            start = leftConnector.getConnectionPoint(end);
            wayPoints.add(start);
            wayPoints.add(end);
        } else {
            // Self-connected
            rightConnector = leftConnector;
            wayPoints = DeployHelper.createSelfConnectedWayPoints(startNode);
        }
        graphEdge = DeployHelper.createGraphEdgeForClass(dependency, wayPoints);

        setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphEdge,
            modelManager.getProjectConfigurationManager()));
    }

    /**
     * <p>
     * Creates a new DependencyEdge edge.
     * </p>
     */
    protected void createEdge() {
        // Connect graph edge with edges' graph edge
        DeployHelper
            .connectEdgeWithNodes(graphEdge, getStartNode().getGraphNode(), getTargetNode().getGraphNode());
        DependencyEdge edge = DeployHelper.createDependencyEdge(getMainFrame(), getDiagramView(), graphEdge);
        edge.setLeftConnector(leftConnector);
        edge.setRightConnector(rightConnector);
        setEdge(edge);
    }

}
