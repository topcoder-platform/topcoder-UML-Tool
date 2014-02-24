/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * This is a simple, concrete implementation of Multiplicity interface.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * This class is mutable and not thread-safe.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public class MultiplicityImpl implements Multiplicity {

    /**
     * <p>
     * Represents the MultiplicityRanges associated with this multiplicity. It will support
     * MultiplicityRange elements.
     * </p>
     * <p>
     * This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the
     * collection (by reference), counting the number of the elements, and finally clearing and
     * getting the collection. Note that the whole collection getter will only return a copy of the
     * collection. Null values will not be allowed.
     * </p>
     *
     */
    private final Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();

    /**
     * <p>
     * Empty constructor.
     * </p>
     *
     */
    public MultiplicityImpl() {
    }

    /**
     * <p>
     * Adds the MultiplicityRange into the ranges collection. It allows duplicates. Null values are
     * not allowed.
     * </p>
     *
     *
     * @param range
     *            The MultiplicityRange to add to this collection
     * @throws IllegalArgumentException
     *             if range is null
     */
    public void addRange(MultiplicityRange range) {
        Helper.checkNotNull(range, "range");
        ranges.add(range);
    }

    /**
     * <p>
     * Adds the MultiplicityRange instances into the ranges collection. It allows duplicates. The
     * collection must not be null or contain null elements.
     * </p>
     *
     *
     * @param ranges
     *            Collection of MultiplicityRange instances to add to the contained collection
     * @throws IllegalArgumentException
     *             if ranges is null or it contains null elements
     */
    public void addRanges(Collection<MultiplicityRange> ranges) {
        Helper.checkCollection(ranges, "ranges");
        this.ranges.addAll(ranges);
    }

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
    public boolean removeRange(MultiplicityRange range) {
        Helper.checkNotNull(range, "range");
        return ranges.remove(range);
    }

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
    public boolean removeRanges(Collection<MultiplicityRange> ranges) {
        Helper.checkCollection(ranges, "ranges");
        // remove the ranges in collection one by one
        boolean changed = false;
        for (MultiplicityRange range : ranges) {
            if (this.ranges.remove(range)) {
                changed = true;
            }
        }
        return changed;
    }

    /**
     * <p>
     * Removes all elements from the ranges collection.
     * </p>
     */
    public void clearRanges() {
        ranges.clear();
    }

    /**
     * <p>
     * Returns a shallow copy of the ranges collection.
     * </p>
     *
     * @return shallow copy of the ranges collection
     */
    public Collection<MultiplicityRange> getRanges() {
        return new ArrayList<MultiplicityRange>(ranges);
    }

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
    public boolean containsRange(MultiplicityRange range) {
        Helper.checkNotNull(range, "range");
        return ranges.contains(range);
    }

    /**
     * <p>
     * Returns the size of the ranges collection.
     * </p>
     *
     * @return the number of elements in the collection
     */
    public int countRanges() {
        return ranges.size();
    }
}
