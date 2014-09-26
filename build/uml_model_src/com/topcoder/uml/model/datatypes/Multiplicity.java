/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * Simple, base interface. In the metamodel, a Multiplicity defines a non-empty set of non-negative
 * integers. A set which only contains zero ({0}) is not considered a valid Multiplicity. Every
 * Multiplicity has at least one corresponding String representation.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public interface Multiplicity extends Serializable {

    /**
     * <p>
     * Adds the MultiplicityRange into the ranges collection. It allows duplicates. Null values are
     * not allowed.
     * </p>
     *
     * @param range
     *            The MultiplicityRange to add to this collection
     * @throws IllegalArgumentException
     *             if range is null
     */
    public void addRange(MultiplicityRange range);

    /**
     * <p>
     * Adds the MultiplicityRange instances into the ranges collection. It allows duplicates. The
     * collection must not be null or contain null elements.
     * </p>
     *
     * @param ranges
     *            Collection of MultiplicityRange instances to add to the contained collection
     * @throws IllegalArgumentException
     *             if ranges is null or it contains null elements
     */
    public void addRanges(Collection<MultiplicityRange> ranges);

    /**
     * <p>
     * Removes the first instance, by reference, of the passed MultiplicityRange, from the ranges
     * collection. Since this is a collection, this operation does not guarantee which instance of
     * the referenced MultiplicityRange will be removed if there are multiple references to the same
     * instance in the collection.
     * </p>
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     *         was not removed, or did not exist in the collection
     * @param range
     *            The MultiplicityRange to remove from this collection
     * @throws IllegalArgumentException
     *             if range is null
     */
    public boolean removeRange(MultiplicityRange range);

    /**
     * <p>
     * Removes the first instance, by reference, of each passed MultiplicityRange from the contained
     * ranges collection. Since this is a collection, this operation does not guarantee which
     * instance of the referenced MultiplicityRange will be removed if there are multiple references
     * to the same instance in the collection. This equally applies to the case if there are
     * multiple duplicates in the passed collection.
     * </p>
     *
     * @return boolean True if the state of the contained ranges collection has changed, false
     *         otherwise.
     * @param ranges
     *            Collection of MultiplicityRange instances to remove from the contained collection
     * @throws IllegalArgumentException
     *             if ranges is null or it contains null elements
     */
    public boolean removeRanges(Collection<MultiplicityRange> ranges);

    /**
     * <p>
     * Removes all elements from the ranges collection.
     * </p>
     */
    public void clearRanges();

    /**
     * <p>
     * Returns a shallow copy of the ranges collection.
     * </p>
     *
     * @return shallow copy of the ranges collection
     */
    public Collection<MultiplicityRange> getRanges();

    /**
     * <p>
     * Checks if the MultiplicityRange is contained in the ranges collection. The check is done by
     * reference.
     * </p>
     *
     * @return true if the MultiplicityRange is in the collection, false otherwise
     * @param range
     *            The MultiplicityRange to check for its presence in this collection
     * @throws IllegalArgumentException
     *             if range is null
     */
    public boolean containsRange(MultiplicityRange range);

    /**
     * <p>
     * Returns the size of the ranges collection.
     * </p>
     *
     * @return the number of elements in the collection
     */
    public int countRanges();
}
