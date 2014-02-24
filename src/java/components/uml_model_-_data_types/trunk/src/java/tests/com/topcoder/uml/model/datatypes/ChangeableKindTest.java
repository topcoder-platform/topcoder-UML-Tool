/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>ChangeableKind</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class ChangeableKindTest extends TestCase {

    /**
     * <p>
     * Tests accuracy of <code>ChangeableKind.CHANGEABLE</code>.
     * </p>
     * <p>
     * Value should not be null.
     * </p>
     */
    public void testChangeableKind_CHANGEABLE_Accuracy() {
        assertNotNull(ChangeableKind.CHANGEABLE);
    }

    /**
     * <p>
     * Tests accuracy of <code>ChangeableKind.FROZEN</code>.
     * </p>
     * <p>
     * Value should not be null.
     * </p>
     */
    public void testChangeableKind_FROZEN_Accuracy() {
        assertNotNull(ChangeableKind.FROZEN);
    }

    /**
     * <p>
     * Tests accuracy of <code>ChangeableKind.ADD_ONLY</code>.
     * </p>
     * <p>
     * Value should not be null.
     * </p>
     */
    public void testChangeableKind_ADD_ONLY_Accuracy() {
        assertNotNull(ChangeableKind.ADD_ONLY);
    }

}
