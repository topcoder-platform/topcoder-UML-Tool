/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import java.io.Serializable;

/**
 * <p>
 * Simple, base interface. In the metamodel, a MultiplicityRange defines a range of integers. The upper
 * bound of the range cannot be below the lower bound. The lower bound must be a nonnegative integer. The
 * upper bound must be a nonnegative integer.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * Implementations do not have to be thread-safe. In fact, method synchronization is discouraged. Thread
 * safety will be provided by the application using these implementations.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public interface MultiplicityRange extends Serializable {

    /**
     * <p>
     * Gets the int lower field value.
     * </p>
     *
     * @return lower field value
     */
    public int getLower();

    /**
     * <p>
     * Sets the int lower field value.
     * </p>
     *
     * @param lower
     *            lower field value
     *
     * @throws IllegalArgumentException
     *             If lower &lt; 0.
     */
    public void setLower(int lower);

    /**
     * <p>
     * Gets the int upper field value.
     * </p>
     *
     * @return upper field value
     */
    public int getUpper();

    /**
     * <p>
     * Sets the int upper field value.
     * </p>
     *
     * @param upper
     *            upper field value
     *
     * @throws IllegalArgumentException
     *             If upper &lt; 0.
     */
    public void setUpper(int upper);

    /**
     * <p>
     * Gets the Multiplicity multiplicity field value. It could be null.
     * </p>
     *
     * @return multiplicity field value
     */
    public Multiplicity getMultiplicity();

    /**
     * <p>
     * Sets the Multiplicity multiplicity field value. Null is allowed.
     * </p>
     *
     * @param multiplicity
     *            multiplicity field value
     */
    public void setMultiplicity(Multiplicity multiplicity);
}
