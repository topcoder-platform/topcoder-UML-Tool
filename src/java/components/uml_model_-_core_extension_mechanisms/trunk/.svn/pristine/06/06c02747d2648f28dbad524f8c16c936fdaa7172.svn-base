/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 *
 * @author justforplay
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * Test all stress test cases.
     *
     * @return instance of Test.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(new TestSuite(StereotypeImplStressTest.class));

        suite.addTest(new TestSuite(TagDefinitionImplStressTest.class));

        suite.addTest(new TestSuite(TagValueImplStressTest.class));

        return suite;
    }
}
