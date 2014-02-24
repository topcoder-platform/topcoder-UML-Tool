/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * Helper.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.relationships.RelationshipAbstractImpl;

/**
 * <p>
 * This class contains some helper methods, that are used for testing.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class Helper {

    /**
     * <p>
     * Creates GraphNode with all necessary information for ActorNode class.
     * </p>
     *
     * @return graph node
     */
    public static GraphNode createGrapchNodeForActorNode() {
        GraphNode graphNode = new GraphNode();
        graphNode.addContained(new GraphNode());
        graphNode.addContained(new GraphNode());
        graphNode.addContained(new GraphNode());
        graphNode.setPosition(createPoint(40, 50));
        graphNode.setSize(createDimension(30, 20));
        return graphNode;
    }

    /**
     * <p>
     * Creates GraphNode with all necessary information for UseCaseNode class.
     * </p>
     *
     * @return graph node
     */
    public static GraphNode createGrapchNodeForUseCaseNode() {
        GraphNode graphNode = new GraphNode();

        graphNode.setPosition(createPoint(40, 50));
        graphNode.setSize(createDimension(30, 20));

        GraphElement graphElement = new GraphElement() {};
        graphElement.addContained(new GraphNode());
        graphElement.addContained(new GraphNode());
        graphElement.addContained(new GraphNode());

        graphNode.addContained(graphElement);
        return graphNode;
    }

    /**
     * <p>
     * Creates GraphNode with all necessary information for SubystemNodeContainer class.
     * </p>
     *
     * @return graph node
     */
    public static GraphNode createGrapchNodeForSubsystemNodeContainer() {
        GraphNode graphNode = new GraphNode();

        GraphNode contained1 = new GraphNode();
        contained1.addContained(new GraphNode());
        contained1.addContained(new GraphNode());
        contained1.addContained(new GraphNode());
        GraphNode contained2 = new GraphNode();

        graphNode.addContained(contained1);
        graphNode.addContained(contained2);

        graphNode.setPosition(createPoint(40, 50));
        graphNode.setSize(createDimension(30, 20));
        return graphNode;
    }

    /**
     * <p>
     * Creates GraphEdge with all necessary information.
     * </p>
     *
     * @return graph edge
     */
    public static GraphEdge createGraphEdge() {
        GraphEdge graphEdge = new GraphEdge();
        GraphNode contained1 = new GraphNode();
        contained1.setPosition(createPoint(100, 200));
        contained1.setSize(createDimension(45, 35));
        GraphNode contained2 = new GraphNode();
        contained2.setPosition(createPoint(200, 300));
        contained2.setSize(createDimension(55, 40));

        graphEdge.addContained(contained1);
        graphEdge.addContained(contained2);

        graphEdge.addWaypoint(createPoint(40, 50));
        graphEdge.addWaypoint(createPoint(50, 60));

        Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
        semanticModelBridge.setElement(new RelationshipAbstractImpl() {});
        graphEdge.setSemanticModel(semanticModelBridge);

        return graphEdge;
    }

    /**
     * <p>
     * Creates Point with specified coordinates.
     * </p>
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return point with specified coordinates
     */
    private static Point createPoint(int x, int y) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        return point;
    }

    /**
     * <p>
     * Returns dimension with specified width and height.
     * </p>
     *
     * @param w width
     * @param h height
     * @return dimension with specified width and height
     */
    private static Dimension createDimension(int w, int h) {
        Dimension dimension = new Dimension();
        dimension.setWidth(w);
        dimension.setHeight(h);
        return dimension;
    }
}
