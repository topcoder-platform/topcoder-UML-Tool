/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import java.util.Collection;

import com.topcoder.uml.model.core.Classifier;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface AssociationEnd extends com.topcoder.uml.model.core.ModelElement {
    /**
     * Sets wether or not the association and is navigable.
     *
     * @param isNavigable
     *            this parameter says wether the association is navigable or not
     */
    public void setNavigable(boolean isNavigable);

    /**
     * Tells the user if the association is navigable.
     *
     * @return true if the association is navigable, false otherwise
     */
    public boolean isNavigable();

    /**
     * Sets the association.Null is a valid value.
     *
     * @param association
     *            the association
     */
    public void setAssociation(com.topcoder.uml.model.core.relationships.Association association);

    /**
     * Gets the association.
     *
     * @return the association
     */
    public com.topcoder.uml.model.core.relationships.Association getAssociation();

    /**
     * Clears the qualifiers.
     */
    public void clearQualifiers();

    /**
     * Retrieves the number of qualifiers.
     *
     * @return the number of qualifiers
     */
    public int countQualifiers();

    /**
     * Sets the participant.Null is a valid value.
     *
     * @param participant
     *            the participant
     */
    public void setParticipant(com.topcoder.uml.model.core.Classifier participant);

    /**
     * Gets the participant.
     *
     * @return the participant
     */
    public com.topcoder.uml.model.core.Classifier getParticipant();

    /**
     * Adds a specification.
     *
     * @param specification
     *            the specification
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void addSpecification(com.topcoder.uml.model.core.Classifier specification);

    /**
     * Removes the specified specification.
     *
     * @return true if the specification has been removed, false otherwise
     * @param specification
     *            the specification
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public boolean removeSpecification(com.topcoder.uml.model.core.Classifier specification);

    /**
     * Clears the specifications.
     */
    public void clearSpecifications();

    /**
     * Retrieves the specifications.
     *
     * @return a collection of specifications
     */
    public Collection<Classifier> getSpecifications();

    /**
     * Checks wether the specified specification is contained.
     *
     * @return true if the specification is contained, false otherwise
     * @param specification
     *            the specification
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public boolean containsSpecification(com.topcoder.uml.model.core.Classifier specification);

    /**
     * Retrieves the number of specifications.
     *
     * @return the number of specifications
     */
    public int countSpecifications();
}