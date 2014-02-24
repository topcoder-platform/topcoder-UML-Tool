/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

/**
 * <p>
 * A simple implementation of Pair. A Pair is a a useful utility to combine two elements, namely first and
 * second.
 * </p>
 *
 * <p>
 * The Pair is used for only testing purpose. The <code>MockActionEventListeners</code> and
 * <code>MockActionEventValidators</code> will use the Pair to record the performance history.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 *
 * @param <T> The type of first element
 * @param <V> The type of second element
 */
public class Pair<T, V> {
    /** The first element of Pair. */
    private T first = null;

    /** The second element of Pair. */
    private V second = null;

    /**
     * Create a new Pair.
     *
     * @param first the first element
     * @param second the second element
     */
    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Get the first element.
     *
     * @return the first element
     */
    public T getFirst() {
        return first;
    }

    /**
     * Get the second element.
     *
     * @return the second element
     */
    public V getSecond() {
        return second;
    }

    /**
     * Returns the hash code value for this Pair.
     *
     * @return the hash code value
     */
    public int hashCode() {
        return first.hashCode() ^ second.hashCode();
    }

    /**
     * Check whether the obj equals to this Pair.
     *
     * @param obj the object to be compared
     *
     * @return true if the obj equals to this Pair, otherwise false
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }

        return ((Pair) obj).getFirst().equals(this.getFirst()) && ((Pair) obj).getSecond().equals(this.getSecond());
    }
}
