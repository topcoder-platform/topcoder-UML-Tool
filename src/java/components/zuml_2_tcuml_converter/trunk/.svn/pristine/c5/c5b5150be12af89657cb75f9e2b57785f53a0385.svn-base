/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverterChainFailureTests;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterHandlerFailureTests;

/**
 * This test case aggregates all failure test cases.
 * @author Thinfox
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * Aggregates all failure test cases.
     * @return the aggregated failure test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(DefaultXMIConverterChainFailureTests.class);
        suite.addTestSuite(DiagramSizeConverterFailureTests.class);
        suite.addTestSuite(DiagramTitleConverterFailureTests.class);
        suite.addTestSuite(GraphPropertiesConverterFailureTests.class);
        suite.addTestSuite(RegexToLowerPropertyValueTransformerFailureTests.class);
        suite.addTestSuite(RenameConverterFailureTests.class);
        suite.addTestSuite(XMIConvertersUtilFailureTests.class);
        suite.addTestSuite(ZUMLHeaderHandlerFailureTests.class);
        suite.addTestSuite(XMIConverterHandlerFailureTests.class);
        return suite;
    }
}
