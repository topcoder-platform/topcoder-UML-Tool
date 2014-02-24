/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>OrderingKind</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class OrderingKindTest extends TestCase {

    /**
     * <p>
     * Tests accuracy of <code>OrderingKind.UNORDERED</code>.
     * </p>
     * <p>
     * Value should not be null.
     * </p>
     */
    public void testOrderingKind_UNORDERED_Accuracy() {
        assertNotNull(OrderingKind.UNORDERED);
    }

    /**
     * <p>
     * Tests accuracy of <code>OrderingKind.ORDERED</code>.
     * </p>
     * <p>
     * Value should not be null.
     * </p>
     */
    public void testOrderingKind_ORDERED_Accuracy() {
        assertNotNull(OrderingKind.ORDERED);
    }

}
