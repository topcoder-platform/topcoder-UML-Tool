/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * This class is an action class that will be called to change one participant of an edge.
 *
 * @author enefem21
 * @version 1.2.2
 */
public class ChangeEdgeParticipant extends UndoableAbstractAction {

    private final Edge edge;

    private final ClassNode detachedNode;

    private final ClassNode attachedNode;

    private final Point oldPoint;

    private final java.awt.Point newPoint;

    private final int movedWayPointIndex;

    private final DiagramView view;

    private final MainFrame mainFrame;

    public ChangeEdgeParticipant(Edge edge, ClassNode detachedNode, ClassNode attachedNode, Point oldPoint,
        java.awt.Point newPoint, int movedWayPointIndex, DiagramView view, MainFrame mainFrame) {
        super("Change Edge Participant");
        this.edge = edge;
        this.detachedNode = detachedNode;
        this.attachedNode = attachedNode;
        this.oldPoint = new Point();
        this.oldPoint.setX(oldPoint.getX());
        this.oldPoint.setY(oldPoint.getY());
        this.newPoint = new java.awt.Point(newPoint.x, newPoint.y);
        this.movedWayPointIndex = movedWayPointIndex;
        this.view = view;
        this.mainFrame = mainFrame;
    }

    @Override
    public void executeAction() {
        java.awt.Point end = attachedNode.getConnector().getConnectionPoint(newPoint);
        changeEdgeParticipant(detachedNode, attachedNode, end.getX(), end.getY());
    }

    @Override
    public void redoAction() {
        executeAction();
    }

    @Override
    public void undoAction() {
        changeEdgeParticipant(attachedNode, detachedNode, oldPoint.getX(), oldPoint.getY());
    }

    private void changeEdgeParticipant(ClassNode detached, ClassNode attached, double x, double y) {
        GraphEdge graphEdge = edge.getGraphEdge();

        // gets the previously related class nodes
        List<Node> connectedNodes = DeployHelper.getConnectedNodes(view, edge);

        // removes the detached edge from the diagram interchange model
        DeployHelper.removeEdgeBetweenNodes(graphEdge, connectedNodes.get(0).getGraphNode(), connectedNodes.get(1)
            .getGraphNode());

        // removes detached node from the list
        connectedNodes.remove(detached);

        Element element = DeployHelper.getElement(graphEdge);
        Classifier d = (Classifier) DeployHelper.getElement(detached);
        Classifier oldAttached = (Classifier) DeployHelper.getElement(connectedNodes.get(0));
        Classifier newAttached = (Classifier) DeployHelper.getElement(attached);
        if (element instanceof Association) {
            Association association = (Association) element;
            AssociationEnd end;
            if (association.getConnections().get(0).getParticipant() == oldAttached) {
                end = association.getConnections().get(1);
            } else {
                end = association.getConnections().get(0);
            }
            d.removeAssociation(end);
            newAttached.addAssociation(end);
            end.setParticipant(newAttached);

        } else if (element instanceof Generalization) {
            Generalization generalization = (Generalization) element;
            if (generalization.getParent() == oldAttached) {
                d.removeGeneralization(generalization);
                newAttached.addGeneralization(generalization);
                generalization.setChild(newAttached);
            } else if (generalization.getChild() == oldAttached) {
                d.removeSpecialization(generalization);
                newAttached.addSpecialization(generalization);
                generalization.setParent(newAttached);
            }
        } else if (element instanceof Dependency) {
            Dependency dependency = (Dependency) element;
            if (dependency.getSuppliers().iterator().next() == oldAttached) {
                d.removeClientDependency(dependency);
                newAttached.addClientDependency(dependency);
                dependency.removeClient(d);
                dependency.addClient(newAttached);
            } else if (dependency.getClients().iterator().next() == oldAttached) {
                d.removeSupplierDependency(dependency);
                newAttached.addSupplierDependency(dependency);
                dependency.removeSupplier(d);
                dependency.addSupplier(newAttached);
            }
        }

        graphEdge.getWaypoints().get(movedWayPointIndex).setX(x);
        graphEdge.getWaypoints().get(movedWayPointIndex).setY(y);

        if (edge.getLeftConnector() != ((ClassNode) connectedNodes.get(0)).getConnector()) {
            edge.setLeftConnector(attached.getConnector());
            DeployHelper.connectEdgeWithNodes(graphEdge, attached.getGraphNode(), connectedNodes.get(0)
                .getGraphNode());
        } else if (edge.getRightConnector() != ((ClassNode) connectedNodes.get(0)).getConnector()) {
            edge.setRightConnector(attached.getConnector());
            DeployHelper.connectEdgeWithNodes(graphEdge, connectedNodes.get(0).getGraphNode(), attached
                .getGraphNode());
        }

        DeployHelper.updateEdgeWayPoint(edge, mainFrame);
        mainFrame.updateDiagramView();
    }

}
