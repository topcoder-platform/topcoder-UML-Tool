/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>ActivityGraphImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActivityGraphImplUnitTest extends TestCase {
    /**
     * <p>
     * Tests the constructor of ActivityGraphImpl class.
     * </p>
     *
     * <p>
     * Verifies an instance of the ActivityGraphImpl class could be successfully
     * created.
     * </p>
     */
    public void testActivityGraphImpl() {
        assertNotNull("failed to instantiate ActivityGraphImpl.",
                new ActivityGraphImpl());
    }
}
