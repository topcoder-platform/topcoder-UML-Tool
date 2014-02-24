/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all stress test cases.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class StressTests extends TestCase {
    /**
     * Returns the test suite of all stress test cases.
     *
     * @return the test suite of all stress test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(new TestSuite(CommentImplStressTest.class));
        suite.addTest(new TestSuite(TemplateArgumentImplStressTest.class));
        suite.addTest(new TestSuite(TemplateParameterImplStressTest.class));
        return suite;
    }
}
