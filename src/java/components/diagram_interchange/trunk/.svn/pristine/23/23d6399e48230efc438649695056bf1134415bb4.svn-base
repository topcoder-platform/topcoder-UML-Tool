/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.io.Serializable;

/**
 * <p>
 * This class is used to link GraphElements with Diagrams. Every DiagramLink links one GraphElement to one
 * Diagram. Zoom and viewport of the linked diagram can be specified.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class DiagramLink implements Serializable {

    /**
     * <p>
     * Represents the zoom applied to the linked Diagram. Default to 0.0.
     * </p>
     */
    private double zoom;

    /**
     * <p>
     * Represents the top-left corner of the current visible part of the linked Diagram. Can be null. Default
     * to null.
     * </p>
     */
    private Point viewport;

    /**
     * <p>
     * Represents the GraphElement of this DiagramLink. Can be null. Default to null.
     * </p>
     */
    private GraphElement graphElement;

    /**
     * <p>
     * Represents the linked Diagram. Can be null. Default to null.
     * </p>
     */
    private Diagram diagram;

    /**
     * <p>
     * Creates an instance of DiagramLink.
     * </p>
     */
    public DiagramLink() {
        // empty constructor
    }

    /**
     * <p>
     * Gets the zoom applied to the linked Diagram.
     * </p>
     *
     * @return the zoom applied to the linked Diagram
     */
    public double getZoom() {
        return zoom;
    }

    /**
     * <p>
     * Sets the zoom applied to the linked Diagram.
     * </p>
     *
     * @param zoom the new zoom applied to the linked Diagram
     */
    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    /**
     * <p>
     * Gets the top-left corner of the current visible part of the linked Diagram.
     * </p>
     *
     * @return the top-left corner of the current visible part of the linked Diagram
     */
    public Point getViewport() {
        return viewport;
    }

    /**
     * <p>
     * Sets the top-left corner of the current visible part of the linked Diagram. Can be null.
     * </p>
     *
     * @param viewport the new top-left corner of the current visible part of the linked Diagram
     */
    public void setViewport(Point viewport) {
        this.viewport = viewport;
    }

    /**
     * <p>
     * Gets the GraphElement of this DiagramLink.
     * </p>
     *
     * @return the GraphElement of this DiagramLink
     */
    public GraphElement getGraphElement() {
        return graphElement;
    }

    /**
     * <p>
     * Sets the GraphElement of this DiagramLink. Can be null.
     * </p>
     *
     * @param graphElement the new GraphElement of this DiagramLink
     */
    public void setGraphElement(GraphElement graphElement) {
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Gets the linked Diagram of this DiagramLink.
     * </p>
     *
     * @return the linked Diagram of this DiagramLink
     */
    public Diagram getDiagram() {
        return diagram;
    }

    /**
     * <p>
     * Sets the linked Diagram of this DiagramLink. Can be null.
     * </p>
     *
     * @param diagram the new linked Diagram of this DiagramLink
     */
    public void setDiagram(Diagram diagram) {
        this.diagram = diagram;
    }
}