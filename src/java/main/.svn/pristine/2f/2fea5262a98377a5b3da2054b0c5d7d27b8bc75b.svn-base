/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.model.classifiers.AddGeneralizationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.GeneralizableElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action is used to add a GeneralizationEdge to the diagram view. It will create model element and graph
 * element, then add them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class AddGeneralizationEdgeAction extends AddEdgeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Generalization Edge";

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
    private Generalization generalization;

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
     * Creates an instance of <code>AddGeneralizationEdgeAction</code>.
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
    public AddGeneralizationEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
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
    public AddGeneralizationEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
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
        generalization = new GeneralizationImpl();
        generalization.setChild((GeneralizableElement) DeployHelper.getElement(getStartNode().getGraphNode()));
        generalization.setParent((GeneralizableElement) DeployHelper.getElement(getTargetNode().getGraphNode()));
        generalization.setName(name);
        setAddModelElementAction(new AddGeneralizationAction(generalization, modelManager));
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
        graphEdge = DeployHelper.createGraphEdgeForClass(generalization, wayPoints);

        setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphEdge,
            modelManager.getProjectConfigurationManager()));
    }

    /**
     * <p>
     * Creates a new GeneralizationEdge edge.
     * </p>
     */
    protected void createEdge() {
        // Connect graph edge with edges' graph edge
        DeployHelper
            .connectEdgeWithNodes(graphEdge, getStartNode().getGraphNode(), getTargetNode().getGraphNode());
        GeneralizationEdge edge =
            DeployHelper.createGeneralizationEdge(getMainFrame(), getDiagramView(), graphEdge);
        edge.setLeftConnector(leftConnector);
        edge.setRightConnector(rightConnector);
        setEdge(edge);
    }

    public void executeAction() throws ActionExecutionException {
        super.executeAction();

        if (getMainFrame().isAutoGenerateMethods()) {
            GeneralizableElement parent = generalization.getParent();
            GeneralizableElement child = generalization.getChild();
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
