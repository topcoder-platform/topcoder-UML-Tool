/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author daiwb
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * Stress test suite.
     * @return stress test suite.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        return suite;
    }
}
