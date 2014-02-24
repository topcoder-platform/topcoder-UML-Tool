/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * This class represents a Diagram that is a special GraphNode, its super class. This is the topmost
 * GraphElement of any graph or diagram. If the semanticModel of the Diagram does not reference an UML Element
 * that has a namespace, then one must be set as owner.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class Diagram extends GraphNode {

    /**
     * <p>
     * Represents the name of this Diagram. Can be null. Can be empty. Default to null.
     * </p>
     */
    private String name;

    /**
     * <p>
     * Represents the scale factor of this Diagram. Default to 0.0.
     * </p>
     */
    private double zoom;

    /**
     * <p>
     * Represents the top-left corner of the current visible part of the Diagram. Can be null. Default to
     * null.
     * </p>
     */
    private Point viewport;

    /**
     * <p>
     * Represents the owner SemanticModelBridge of this Diagram. Can be null. Default to null.
     * </p>
     */
    private SemanticModelBridge owner;

    /**
     * <p>
     * Represents the DiagramLinks associated to this Diagram. Can never be null. Can be empty. Elements
     * cannot be null. There can be duplicated elements. Default to empty.
     * </p>
     */
    private final Collection<DiagramLink> diagramLinks = new ArrayList<DiagramLink>();

    /**
     * <p>
     * Creates an instance of Diagram.
     * </p>
     */
    public Diagram() {
        super();
    }

    /**
     * <p>
     * Gets the name of this Diagram.
     * </p>
     *
     * @return the name of this Diagram
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * Sets the name of this Diagram. Can be null. Can be empty.
     * </p>
     *
     * @param name the new name for this Diagram
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>
     * Gets the scale factor of this Diagram.
     * </p>
     *
     * @return the scale factor of this Diagram
     */
    public double getZoom() {
        return zoom;
    }

    /**
     * <p>
     * Sets the scale factor of this Diagram.
     * </p>
     *
     * @param zoom the new scale factor for this Diagram
     */
    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    /**
     * <p>
     * Gets the top-left corner of the current visible part of the Diagram.
     * </p>
     *
     * @return the top-left corner of the current visible part of the Diagram
     */
    public Point getViewport() {
        return viewport;
    }

    /**
     * <p>
     * Sets the top-left corner of the current visible part of the Diagram. Can be null.
     * </p>
     *
     * @param viewport the new top-left corner of the current visible part for this Diagram
     */
    public void setViewport(Point viewport) {
        this.viewport = viewport;
    }

    /**
     * <p>
     * Gets the owner SemanticModelBridge of this Diagram.
     * </p>
     *
     * @return the owner SemanticModelBridge of this Diagram
     */
    public SemanticModelBridge getOwner() {
        return owner;
    }

    /**
     * <p>
     * Sets the owner SemanticModelBridge of this Diagram. Can be null.
     * </p>
     *
     * @param owner the new owner SemanticModelBridge for this Diagram
     */
    public void setOwner(SemanticModelBridge owner) {
        this.owner = owner;
    }

    /**
     * <p>
     * Appends a DiagramLink to this Diagram at the end.
     * </p>
     *
     * @param diagramLink the DiagramLink to be appended
     * @throws IllegalArgumentException if diagramLink is null
     */
    public void addDiagramLink(DiagramLink diagramLink) {
        if (diagramLink == null) {
            throw new IllegalArgumentException("the diagramLink can not be null");
        }
        diagramLinks.add(diagramLink);
    }

    /**
     * <p>
     * Removes the DiagramLink from this Diagram. If the DiagramLink is a duplicated element, only the first
     * one is removed. Returns true if the DiagramLink is removed, false otherwise.
     * </p>
     *
     * @param diagramLink the DiagramLink to be removed
     * @return true if the DiagramLink is removed, false otherwise
     * @throws IllegalArgumentException if diagramLink is null
     */
    public boolean removeDiagramLink(DiagramLink diagramLink) {
        if (diagramLink == null) {
            throw new IllegalArgumentException("the diagramLink can not be null");
        }
        return diagramLinks.remove(diagramLink);
    }

    /**
     * <p>
     * Removes all the DiagramLinks from this Diagram.
     * </p>
     */
    public void clearDiagramLinks() {
        diagramLinks.clear();
    }

    /**
     * <p>
     * Returns a copy of the DiagramLinks of this Diagram.
     * </p>
     *
     * @return a copy of the DiagramLinks of this Diagram
     */
    public Collection<DiagramLink> getDiagramLinks() {
        return new ArrayList<DiagramLink>(diagramLinks);
    }

    /**
     * <p>
     * Returns true if the DiagramLink is in this Diagram, false otherwise.
     * </p>
     *
     * @param diagramLink the DiagramLink to be checked for inclusion
     * @return true if the DiagramLink is in this Diagram, false otherwise
     * @throws IllegalArgumentException if diagramLink is null
     */
    public boolean containsDiagramLink(DiagramLink diagramLink) {
        if (diagramLink == null) {
            throw new IllegalArgumentException("the diagramLink can not be null");
        }
        return diagramLinks.contains(diagramLink);
    }

    /**
     * <p>
     * Returns the number of the DiagramLinks of this Diagram.
     * </p>
     *
     * @return the number of the DiagramLinks of this Diagram
     */
    public int countDiagramLinks() {
        return diagramLinks.size();
    }
}