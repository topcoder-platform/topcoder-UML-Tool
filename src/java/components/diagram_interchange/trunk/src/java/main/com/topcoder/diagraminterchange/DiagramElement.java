/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * This is the base class of GraphElement, LeafElement and Reference. A DiagramElement can have a container
 * GraphElement. The appearance is specified by the Properties. Every DiagramElement can contain any number of
 * References to other DiagramElements.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is abstract but has no abstract methods. This class is mutable and is not
 * thread-safe, since thread safety is not required. Instead, the calling application is required to ensure
 * thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public abstract class DiagramElement implements Serializable {

    /**
     * <p>
     * Represents the temporary visibility. Default to true.
     * </p>
     */
    private boolean isVisible;

    /**
     * <p>
     * Represents the container GraphElement. Can be null. Default to null.
     * </p>
     */
    private GraphElement container;

    /**
     * <p>
     * Represents the properties. Can never be null. Can be empty. Elements cannot be null. There can be
     * duplicated elements. Default to empty.
     * </p>
     */
    private final Collection<Property> properties = new ArrayList<Property>();

    /**
     * <p>
     * Represents the references. Can never be null. Can be empty. Elements cannot be null. There can be
     * duplicated elements. Default to empty.
     * </p>
     */
    private final Collection<Reference> references = new ArrayList<Reference>();

    /**
     * <p>
     * Creates an instance of DiagramElement. This constructor is called by subtypes.
     * </p>
     */
    protected DiagramElement() {
        isVisible = true;
    }

    /**
     * <p>
     * Gets the value of temporary visibility of this DiagramElement. Returns true if it is visible, false
     * otherwise.
     * </p>
     *
     * @return the temporary visibility of this DiagramElement
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * <p>
     * Sets the value of temporary visibility of this DiagramElement.
     * </p>
     *
     * @param isVisible the new value of temporary visibility for this DiagramElement
     */
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    /**
     * <p>
     * Gets the container GraphElement of this DiagramElement.
     * </p>
     *
     * @return the container GraphElement of this DiagramElement
     */
    public GraphElement getContainer() {
        return container;
    }

    /**
     * <p>
     * Sets the container GraphElement of this DiagramElement. Can be null.
     * </p>
     *
     * @param container the new container GraphElement for this DiagramElement
     */
    public void setContainer(GraphElement container) {
        this.container = container;
    }

    /**
     * <p>
     * Appends a property to this DiagramElement at the end.
     * </p>
     *
     * @param property the Property to be appended
     * @throws IllegalArgumentException if property is null
     */
    public void addProperty(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("the property can not be null");
        }
        properties.add(property);
    }

    /**
     * <p>
     * Removes the property from this DiagramElement. If the property is a duplicated element, only the first
     * one is removed. Returns true if the property is removed, false otherwise.
     * </p>
     *
     * @param property the property to be removed
     * @return true if the property is removed, false otherwise
     * @throws IllegalArgumentException if property is null
     */
    public boolean removeProperty(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("the property can not be null");
        }
        return properties.remove(property);
    }

    /**
     * <p>
     * Removes all the properties from this DiagramElement.
     * </p>
     */
    public void clearProperties() {
        properties.clear();
    }

    /**
     * <p>
     * Returns a copy of all the properties of this DiagramElement.
     * </p>
     *
     * @return a copy of all the properties of this DiagramElement
     */
    public Collection<Property> getProperties() {
        return new ArrayList<Property>(properties);
    }

    /**
     * <p>
     * Returns true if the property is in this DiagramElement, false otherwise.
     * </p>
     *
     * @param property the property to be checked for inclusion
     * @return true if the property is in this DiagramElement, false otherwise
     * @throws IllegalArgumentException if property is null
     */
    public boolean containsProperty(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("the property can not be null");
        }
        return properties.contains(property);
    }

    /**
     * <p>
     * Returns the number of properties of this DiagramElement.
     * </p>
     *
     * @return the number of properties of this DiagramElement
     */
    public int countProperties() {
        return properties.size();
    }

    /**
     * <p>
     * Appends a reference to this DiagramElement at the end.
     * </p>
     *
     * @param reference the reference to be appended
     * @throws IllegalArgumentException if reference is null
     */
    public void addReference(Reference reference) {
        if (reference == null) {
            throw new IllegalArgumentException("the reference can not be null");
        }
        references.add(reference);
    }

    /**
     * <p>
     * Removes the reference from this DiagramElement. If reference is a duplicated element, only the first
     * one is removed. Returns true if the reference is removed, false otherwise.
     * </p>
     *
     * @param reference the Reference to be removed
     * @return true if the reference is removed, false otherwise
     * @throws IllegalArgumentException if reference is null
     */
    public boolean removeReference(Reference reference) {
        if (reference == null) {
            throw new IllegalArgumentException("the reference can not be null");
        }
        return references.remove(reference);
    }

    /**
     * <p>
     * Removes all the references from this DiagramElement.
     * </p>
     */
    public void clearReferences() {
        references.clear();
    }

    /**
     * <p>
     * Returns a copy of the references of this DiagramElement.
     * </p>
     *
     * @return a copy of the references of this DiagramElement
     */
    public Collection<Reference> getReferences() {
        return new ArrayList<Reference>(references);
    }

    /**
     * <p>
     * Returns true if the reference is in this DiagramElement, false otherwise.
     * </p>
     *
     * @param reference the reference to be checked for inclusion
     * @return true if the reference is in this DiagramElement, false otherwise
     * @throws IllegalArgumentException if reference is null
     */
    public boolean containsReference(Reference reference) {
        if (reference == null) {
            throw new IllegalArgumentException("the reference can not be null");
        }
        return references.contains(reference);
    }

    /**
     * <p>
     * Returns the number of the references of this DiagramElement.
     * </p>
     *
     * @return the number of the references of this DiagramElement
     */
    public int countReferences() {
        return references.size();
    }
}