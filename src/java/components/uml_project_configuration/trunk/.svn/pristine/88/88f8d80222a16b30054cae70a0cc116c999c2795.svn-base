/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This test case aggregates all stress test cases.
 *
 * @author vividmxx
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * Aggregates all Stress test cases.
     *
     * @return the aggregated stress test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(JavaExceptionElementFormatterStressTests.class);
        suite.addTestSuite(Java14EnumElementFormatterStressTests.class);
        suite.addTestSuite(CSharpExceptionElementFormatterStressTests.class);
        suite.addTestSuite(XMLStereotypeLoaderStressTests.class);
        suite.addTestSuite(PropertyTemplateDiagramElementFormatterStressTests.class);
        return suite;
    }
}
