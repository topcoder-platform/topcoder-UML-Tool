/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

/**
 * <p>
 * This is a simple, concrete implementation of MultiplicityRange interface.
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
public class MultiplicityRangeImpl implements MultiplicityRange {

    /**
     * <p>
     * Represents the lower bound of the range.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Negative values are not acceptable.
     * </p>
     *
     */
    private int lower;

    /**
     * <p>
     * Represents the upper bound of the range.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Negative values are not acceptable.
     * </p>
     *
     */
    private int upper;

    /**
     * <p>
     * Represents Multiplicity that is associated with this range.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.
     * </p>
     *
     */
    private Multiplicity multiplicity;

    /**
     * <p>
     * Empty constructor.
     * </p>
     *
     */
    public MultiplicityRangeImpl() {
    }

    /**
     * <p>
     * Gets the int lower field value.
     * </p>
     *
     * @return lower field value
     */
    public int getLower() {
        return lower;
    }

    /**
     * <p>
     * Sets the int lower field value.
     * </p>
     *
     * @param lower
     *            lower field value
     *
     * @throws IllegalArgumentException
     *             if lower &lt; 0
     */
    public void setLower(int lower) {
        this.lower = Helper.checkNotNegative(lower, "lower");
    }

    /**
     * <p>
     * Gets the int upper field value.
     * </p>
     *
     * @return upper field value
     */
    public int getUpper() {
        return upper;
    }

    /**
     * <p>
     * Sets the int upper field value.
     * </p>
     *
     * @param upper
     *            upper field value
     * @throws IllegalArgumentException
     *             if upper &lt; 0
     */
    public void setUpper(int upper) {
        if (upper == -1) {
            upper = Integer.MAX_VALUE;
        }
        this.upper = Helper.checkNotNegative(upper, "upper");
    }

    /**
     * <p>
     * Gets the Multiplicity multiplicity field value. It could be null.
     * </p>
     *
     * @return multiplicity field value
     */
    public Multiplicity getMultiplicity() {
        return multiplicity;
    }

    /**
     * <p>
     * Sets the Multiplicity multiplicity field value. Null is allowed.
     * </p>
     *
     * @param multiplicity
     *            multiplicity field value
     */
    public void setMultiplicity(Multiplicity multiplicity) {
        this.multiplicity = multiplicity;
    }
}
