/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author hfx
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * The suite to aggregates all failure tests.
     *
     * @return The suite to aggregates all failure tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(JVerticalLabelFailureTests.class);
        return suite;
    }

}