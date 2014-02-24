/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>CallStateImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CallStateImplUnitTest extends TestCase {
    /**
     * <p>
     * Tests the constructor of CallStateImpl class.
     * </p>
     *
     * <p>
     * Verifies an instance of the CallStateImpl class could be successfully
     * created.
     * </p>
     */
    public void testCallStateImpl() {
        assertNotNull("failed to instantiate CallStateImpl.",
                new CallStateImpl());
    }
}
