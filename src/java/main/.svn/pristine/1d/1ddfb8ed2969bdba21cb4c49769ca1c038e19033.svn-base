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
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.model.classifiers.AddAbstractionAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action is used to add a AbstractionEdge to the diagram view. It will create model element and graph
 * element, then add them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddAbstractionEdgeAction extends AddEdgeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Abstraction Edge";

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
    private Abstraction abstraction;

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

    private AutoMethodGenerationAction action;

    /**
     * <p>
     * Creates an instance of <code>AddAbstractionEdgeAction</code>.
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
    public AddAbstractionEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
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
    public AddAbstractionEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
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
        abstraction = new AbstractionImpl();
        abstraction.addClient(DeployHelper.getElement(getStartNode().getGraphNode()));
        abstraction.addSupplier(DeployHelper.getElement(getTargetNode().getGraphNode()));
        abstraction.setName(name);
        setAddModelElementAction(new AddAbstractionAction(abstraction, modelManager));
    }

    /**
     * <p>
     * Creates the graph edge for new edge.
     * </p>
     */
    protected void createGraphEdge() {
        BaseNode startNode = (BaseNode) getStartNode();
        BaseNode targetNode = (BaseNode) getTargetNode();
        leftConnector = startNode.getConnector();
        rightConnector = targetNode.getConnector();
        List<Point> wayPoints = new ArrayList<Point>();
        if (startNode != targetNode) {
            // Relocate the start and end position
            end = rightConnector.getConnectionPoint(start);
            start = leftConnector.getConnectionPoint(end);

            wayPoints.add(start);
            wayPoints.add(end);
        } else {
            // Self-connected
            wayPoints = DeployHelper.createSelfConnectedWayPoints(startNode);
        }
        graphEdge = DeployHelper.createGraphEdgeForClass(abstraction, wayPoints);

        setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphEdge,
            modelManager.getProjectConfigurationManager()));
    }

    /**
     * <p>
     * Creates a new AbstractionEdge edge.
     * </p>
     */
    protected void createEdge() {
        // Connect graph edge with edges' graph edge
        DeployHelper
            .connectEdgeWithNodes(graphEdge, getStartNode().getGraphNode(), getTargetNode().getGraphNode());
        AbstractionEdge edge = DeployHelper.createAbstractionEdge(getMainFrame(), getDiagramView(), graphEdge);
        edge.setLeftConnector(leftConnector);
        edge.setRightConnector(rightConnector);
        setEdge(edge);
    }

    public void executeAction() throws ActionExecutionException {
        super.executeAction();

        if (getMainFrame().isAutoGenerateMethods()) {
            ModelElement parent = abstraction.getSuppliers().iterator().next();
            ModelElement child = abstraction.getClients().iterator().next();
            if (parent instanceof Classifier && child instanceof Classifier) {
                action =
                    new AutoMethodGenerationAction(getMainFrame(), (Classifier) parent, (Classifier) child,
                        getStartNode(), getMainFrame().getUmlModelManager().getProjectLanguage());
                action.executeAction();
            }
        }
    }

    public void undoAction() {
        super.undoAction();
        action.undoAction();
    }

    public void redoAction() {
        super.redoAction();
        action.redoAction();
    }
}
