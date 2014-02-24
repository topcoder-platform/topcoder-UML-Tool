/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

/**
 * <p>
 * This class allows a DiagramElement to contain references to other diagram element. Reference extends
 * DiagramElement.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class Reference extends DiagramElement {

    /**
     * <p>
     * This flag configures the usage of this Reference. If it is true, the referenced DiagramElement cannot
     * be referenced by any other Reference instance. Default to false.
     * </p>
     */
    private boolean isIndividualRepresentation;

    /**
     * <p>
     * Represents the referenced DiagramElement. Can be null. Default to null.
     * </p>
     */
    private DiagramElement referenced;

    /**
     * <p>
     * Creates an instance of Reference.
     * </p>
     */
    public Reference() {
        super();
    }

    /**
     * <p>
     * Returns true if the referenced DiagramElement cannot be referenced by any other Reference instance,
     * false otherwise.
     * </p>
     *
     * @return true if the referenced DiagramElement cannot be referenced by any other Reference instance,
     *         false otherwise
     */
    public boolean isIndividualRepresentation() {
        return isIndividualRepresentation;
    }

    /**
     * <p>
     * Sets true if the referenced DiagramElement cannot be referenced by any other Reference instance, false
     * otherwise.
     * </p>
     *
     * @param isIndividualRepresentation true tells that the referenced DiagramElement cannot be referenced by
     *        any other Reference instance, false otherwise
     */
    public void setIndividualRepresentation(boolean isIndividualRepresentation) {
        this.isIndividualRepresentation = isIndividualRepresentation;
    }

    /**
     * <p>
     * Gets the referenced DiagramElement.
     * </p>
     *
     * @return the referenced DiagramElement
     */
    public DiagramElement getReferenced() {
        return referenced;
    }

    /**
     * <p>
     * Sets the referenced DiagramElement. Can be null.
     * </p>
     *
     * @param referenced the new referenced DiagramElement
     */
    public void setReferenced(DiagramElement referenced) {
        this.referenced = referenced;
    }
}