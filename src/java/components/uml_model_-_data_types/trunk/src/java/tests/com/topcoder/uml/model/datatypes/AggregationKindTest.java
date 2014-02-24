/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>AggregationKind</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class AggregationKindTest extends TestCase {

    /**
     * <p>
     * Tests accuracy of <code>AggregationKind.NONE</code>.
     * </p>
     * <p>
     * Value should not be null.
     * </p>
     */
    public void testAggregationKind_NONE_Accuracy() {
        assertNotNull(AggregationKind.NONE);
    }

    /**
     * <p>
     * Tests accuracy of <code>AggregationKind.AGGREGATE</code>.
     * </p>
     * <p>
     * Value should not be null.
     * </p>
     */
    public void testAggregationKind_AGGREGATE_Accuracy() {
        assertNotNull(AggregationKind.AGGREGATE);
    }

    /**
     * <p>
     * Tests accuracy of <code>AggregationKind.COMPOSITE</code>.
     * </p>
     * <p>
     * Value should not be null.
     * </p>
     */
    public void testAggregationKind_COMPOSITE_Accuracy() {
        assertNotNull(AggregationKind.COMPOSITE);
    }
}
