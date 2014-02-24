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
import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.classedges.Aggregation;
import com.topcoder.gui.diagramviewer.uml.classedges.AggregationBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.Composition;
import com.topcoder.gui.diagramviewer.uml.classedges.CompositionBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.DirectedAssociation;
import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.model.classifiers.AddAssociationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used to add an AssociationEdge to the diagram view. It will create model element and graph
 * element, then add them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class AddAssociationEdgeAction extends AddEdgeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Association Edge";

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
    private Association association;

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
     * Left association end.
     * </p>
     */
    private AssociationEnd leftAssociationEnd;

    /**
     * <p>
     * Right association end.
     * </p>
     */
    private AssociationEnd rightAssociationEnd;

    /**
     * <p>
     * Creates an instance of <code>AddAssociationEdgeAction</code>.
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
    public AddAssociationEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
        Node startNode, Node targetNode) {
        super(PRESENTATION_NAME, mainFrame, view, startNode, targetNode);
        this.start = start;
        this.end = end;
        this.name = name;

        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Creates an instance of <code>AddAssociationEdgeAction</code>.
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
    public AddAssociationEdgeAction(MainFrame mainFrame, DiagramView view, Point start, Point end, String name,
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
        association = new AssociationImpl();
        association.setName(name);

        Class<? extends ActiveEdgeEnding> associationType = getMainFrame().getAssociationType();
        leftAssociationEnd = new AssociationEndImpl();
        if (associationType.equals(NoArrow.class)) {
            leftAssociationEnd.setAggregation(AggregationKind.NONE);
            leftAssociationEnd.setNavigable(true);
        } else if (associationType.equals(DirectedAssociation.class)) {
            leftAssociationEnd.setAggregation(AggregationKind.NONE);
            leftAssociationEnd.setNavigable(false);
        } else if (associationType.equals(Aggregation.class)) {
            leftAssociationEnd.setAggregation(AggregationKind.AGGREGATE);
            leftAssociationEnd.setNavigable(true);
        } else if (associationType.equals(AggregationBiDirectional.class)) {
            leftAssociationEnd.setAggregation(AggregationKind.AGGREGATE);
            leftAssociationEnd.setNavigable(false);
        } else if (associationType.equals(Composition.class)) {
            leftAssociationEnd.setAggregation(AggregationKind.COMPOSITE);
            leftAssociationEnd.setNavigable(true);
        } else if (associationType.equals(CompositionBiDirectional.class)) {
            leftAssociationEnd.setAggregation(AggregationKind.COMPOSITE);
            leftAssociationEnd.setNavigable(false);
        }
        leftAssociationEnd.setName("");
        leftAssociationEnd.setAssociation(association);
        leftAssociationEnd.setParticipant((Classifier) DeployHelper.getElement(getStartNode()));
        association.addConnection(leftAssociationEnd);

        rightAssociationEnd = new AssociationEndImpl();
        rightAssociationEnd.setAggregation(AggregationKind.NONE);
        rightAssociationEnd.setNavigable(true);
        rightAssociationEnd.setName("");
        rightAssociationEnd.setAssociation(association);
        rightAssociationEnd.setParticipant((Classifier) DeployHelper.getElement(getTargetNode()));
        association.addConnection(rightAssociationEnd);

        setAddModelElementAction(new AddAssociationAction(association, modelManager));
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
        graphEdge = DeployHelper.createGraphEdgeForAssociation(association, wayPoints, name);

        setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphEdge,
            modelManager.getProjectConfigurationManager()));
    }

    /**
     * <p>
     * Creates a new AssociationEdge edge.
     * </p>
     */
    protected void createEdge() {
        // Connect graph edge with edges' graph edge
        DeployHelper
            .connectEdgeWithNodes(graphEdge, getStartNode().getGraphNode(), getTargetNode().getGraphNode());
        AssociationEdge edge = DeployHelper.createAssociationEdge(getMainFrame(), getDiagramView(), graphEdge);
        edge.setLeftConnector(leftConnector);
        edge.setRightConnector(rightConnector);
        setEdge(edge);
    }

}
