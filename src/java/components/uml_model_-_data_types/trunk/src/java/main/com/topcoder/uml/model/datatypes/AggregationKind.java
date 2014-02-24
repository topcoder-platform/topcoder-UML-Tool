/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

/**
 * <p>
 * An enumeration that denotes what kind of aggregation an Association is. When placed on a target
 * end, specifies the relationship of the target end to the source end.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public enum AggregationKind {

    /**
     * <p>
     * The end is not an aggregate.
     * </p>
     */
    NONE,

    /**
     * <p>
     * The end is an aggregate; therefore, the other end is a part and must have the aggregation
     * value of none. The part may be contained in other aggregates.
     * </p>
     */
    AGGREGATE,

    /**
     * <p>
     * The end is a composite; therefore, the other end is a part and must have the aggregation
     * value of none. The part is strongly owned by the composite and may not be part of any other
     * composite.
     * </p>
     */
    COMPOSITE
}
