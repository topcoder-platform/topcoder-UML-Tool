/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * GraphConnector links GraphElement instances. This class allows linking of a GraphEdge with a GraphNode or
 * another GraphEdge; GraphConnector does not permit two GraphNode instances to be linked.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class GraphConnector implements Serializable {

    /**
     * <p>
     * Represents the position of this GraphConnector. Can be null. Default to null.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * Represents the GraphElement anchored to this GraphConnector. Can be null. Default to null.
     * </p>
     */
    private GraphElement graphElement;

    /**
     * <p>
     * Represents the GraphEdges that have a reference to this GraphConnector. Can never be null. Can be
     * empty. Elements cannot be null. There can be duplicated elements. Default to empty.
     * </p>
     */
    private final Collection<GraphEdge> graphEdges = new ArrayList<GraphEdge>();

    /**
     * <p>
     * Creates an instance of GraphConnector.
     * </p>
     */
    public GraphConnector() {
        // empty constructor
    }

    /**
     * <p>
     * Gets the position of this GraphConnector.
     * </p>
     *
     * @return the position of this GraphConnector
     */
    public Point getPosition() {
        return position;
    }

    /**
     * <p>
     * Sets the position of this GraphConnector. Can be null.
     * </p>
     *
     * @param position the new position of this GraphConnector
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * <p>
     * Gets the GraphElement anchored to this GraphConnector.
     * </p>
     *
     * @return the GraphElement anchored to this GraphConnector
     */
    public GraphElement getGraphElement() {
        return graphElement;
    }

    /**
     * <p>
     * Sets the GraphElement anchored to this GraphConnector. Can be null.
     * </p>
     *
     * @param graphElement the new GraphElement anchored to this GraphConnector
     */
    public void setGraphElement(GraphElement graphElement) {
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Appends a graphEdge to this GraphConnector at the end.
     * </p>
     *
     * @param graphEdge the graphEdge to be appended
     * @throws IllegalArgumentException if graphEdge is null
     */
    public void addGraphEdge(GraphEdge graphEdge) {
        if (graphEdge == null) {
            throw new IllegalArgumentException("the graphEdge can not be null");
        }
        graphEdges.add(graphEdge);
    }

    /**
     * <p>
     * Removes the graphEdge from this GraphConnector. If graphEdge is a duplicated element, only the first
     * one is removed. Returns true if the graphEdge is removed, false otherwise.
     * </p>
     *
     * @param graphEdge the graphEdge to be removed
     * @return true if the graphEdge is removed, false otherwise
     * @throws IllegalArgumentException if graphEdge is null
     */
    public boolean removeGraphEdge(GraphEdge graphEdge) {
        if (graphEdge == null) {
            throw new IllegalArgumentException("the graphEdge can not be null");
        }
        return graphEdges.remove(graphEdge);
    }

    /**
     * <p>
     * Removes all the graphEdges of this GraphConnector.
     * </p>
     */
    public void clearGraphEdges() {
        graphEdges.clear();
    }

    /**
     * <p>
     * Returns a copy of the graphEdges of this GraphConnector.
     * </p>
     *
     * @return a copy of the graphEdges of this GraphConnector
     */
    public Collection<GraphEdge> getGraphEdges() {
        return new ArrayList<GraphEdge>(graphEdges);
    }

    /**
     * <p>
     * Returns true if the graphEdge is in this GraphConnector, false otherwise.
     * </p>
     *
     * @param graphEdge the graphEdge to be checked for inclusion
     * @return true if the graphEdge is in this GraphConnector, false otherwise
     * @throws IllegalArgumentException if graphEdge is null
     */
    public boolean containsGraphEdge(GraphEdge graphEdge) {
        if (graphEdge == null) {
            throw new IllegalArgumentException("the graphEdge can not be null");
        }
        return graphEdges.contains(graphEdge);
    }

    /**
     * <p>
     * Returns the number of the graphEdges of this GraphConnector.
     * </p>
     *
     * @return the number of the graphEdges of this GraphConnector
     */
    public int countGraphEdges() {
        return graphEdges.size();
    }
}