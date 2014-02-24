/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author lyt
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(ActionStressTests.class);
        suite.addTestSuite(ExtractorStressTests.class);
        return suite;
    }

}
