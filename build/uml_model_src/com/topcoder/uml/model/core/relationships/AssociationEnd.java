/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;

import java.util.Collection;
import java.util.List;

/**
 * This interface defines the contract for an association end. An association end is an endpoint of an association,
 * which connects the association to a classifier. Each association end is part of one association. It extends
 * ModelElement interface and add more specific methods that apply to an association end. Implementations are not
 * required to be thread safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public interface AssociationEnd extends ModelElement {
    /**
     * Sets whether or not the association and is navigable.
     *
     * @param isNavigable this parameter says whether the association is navigable or not.
     */
    public void setNavigable(boolean isNavigable);

    /**
     * Tells the user if the association is navigable.
     *
     * @return true if the association is navigable, false otherwise.
     */
    public boolean isNavigable();

    /**
     * Sets the ordering.Null is a valid value.
     *
     * @param ordering the new ordering to be set.
     */
    public void setOrdering(OrderingKind ordering);

    /**
     * Gets the ordering.
     *
     * @return the ordering of the current object.
     */
    public OrderingKind getOrdering();

    /**
     * Sets the aggregation.Null is a valid value.
     *
     * @param aggregation the new aggregation to be set.
     */
    public void setAggregation(AggregationKind aggregation);

    /**
     * Gets the aggregation.
     *
     * @return the aggregation of the current object.
     */
    public AggregationKind getAggregation();

    /**
     * Sets the target kind. Null is a valid value.
     *
     * @param targetKind the new targetKind to be set.
     */
    public void setTargetKind(ScopeKind targetKind);

    /**
     * Gets the target kind.
     *
     * @return the target kind of the current object.
     */
    public ScopeKind getTargetKind();

    /**
     * Sets multiplicity. Null is a valid value.
     *
     * @param multiplicity the new multiplicity to be set.
     */
    public void setMultiplicity(Multiplicity multiplicity);

    /**
     * Gets multiplicity.
     *
     * @return the multiplicity of the current object.
     */
    public Multiplicity getMultiplicity();

    /**
     * Sets the changeability. Null is a valid value.
     *
     * @param changeability the new changeability to be set.
     */
    public void setChangeability(ChangeableKind changeability);

    /**
     * Gets the changeability.
     *
     * @return the changeability of the current object.
     */
    public ChangeableKind getChangeability();

    /**
     * Sets the association. Null is a valid value.
     *
     * @param association the new association to be set.
     */
    public void setAssociation(Association association);

    /**
     * Gets the association.
     *
     * @return the association of the current object.
     */
    public Association getAssociation();

    /**
     * Adds a qualifier into the current objects.
     *
     * @param qualifier the qualifier to be added.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void addQualifier(Attribute qualifier);

    /**
     * Adds a qualifier at the specified index.
     *
     * @param index the index of the qualifier to be added.
     * @param qualifier the qualifier to be added.
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > the size of the qualifiers
     *             list).
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void addQualifier(int index, Attribute qualifier);

    /**
     * Replaces the qualifier at the specified position with the specified element.
     *
     * @param index the index of the qualifier to be set.
     * @param qualifier the qualifier to be set.
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= the size of the qualifiers
     *             list).
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void setQualifier(int index, Attribute qualifier);

    /**
     * Removes the qualifier at the specified index.
     *
     * @return the qualifier at the specified index.
     * @param index the index of qualifier to be removed.
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= the size of the qualifiers
     *             list).
     */
    public Attribute removeQualifier(int index);

    /**
     * Removes the specified qualifier.
     *
     * @return true if the qualifier has been removed, false otherwise.
     * @param qualifier the qualifier to be removed.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean removeQualifier(Attribute qualifier);

    /**
     * Clears the qualifiers.
     */
    public void clearQualifiers();

    /**
     * Retrieves the qualifiers.
     *
     * @return a shallow copy of qualifiers.
     */
    public List<Attribute> getQualifiers();

    /**
     * Checks whether the specified qualifier is contained.
     *
     * @return true if the qualifier is contained,false otherwise.
     * @param qualifier the qualifier to be checked.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean containsQualifier(Attribute qualifier);

    /**
     * Gets the index of the specified qualifier.
     *
     * @return the index of the qualifier or -1 if not found.
     * @param qualifier the qualifier to be found.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public int indexOfQualifier(Attribute qualifier);

    /**
     * Retrieves the quantity of qualifiers.
     *
     * @return the quantity of qualifiers.
     */
    public int countQualifiers();

    /**
     * Sets the participant. Null is a valid value.
     *
     * @param participant the new participant to be set.
     */
    public void setParticipant(Classifier participant);

    /**
     * Gets the participant.
     *
     * @return the participant of the current object.
     */
    public Classifier getParticipant();

    /**
     * Adds a specification to the end of the specifications collection.
     *
     * @param specification the specification to be added.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void addSpecification(Classifier specification);

    /**
     * Removes the specified specification.
     *
     * @return true if the specification has been removed, false otherwise.
     * @param specification the specification to be removed.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean removeSpecification(Classifier specification);

    /**
     * Clears the specifications.
     */
    public void clearSpecifications();

    /**
     * Retrieves the specifications.
     *
     * @return a shallow copy of specifications.
     */
    public Collection<Classifier> getSpecifications();

    /**
     * Checks whether the specified specification is contained.
     *
     * @return true if the specification is contained, false otherwise.
     * @param specification the specification to be checked.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean containsSpecification(Classifier specification);

    /**
     * Retrieves the quantity of specifications.
     *
     * @return the quantity of specifications.
     */
    public int countSpecifications();
}
