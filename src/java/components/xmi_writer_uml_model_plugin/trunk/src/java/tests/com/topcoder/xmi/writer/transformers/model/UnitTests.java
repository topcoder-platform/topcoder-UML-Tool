/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.xmi.writer.transformers.model.xmidescription.ReflectedXMIDescriptionTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AttributeDescriptionTests.class);
        suite.addTestSuite(ChildDescriptionTests.class);
        suite.addTestSuite(ConfigurationExceptionTests.class);
        suite.addTestSuite(DescriptionRetrievalExceptionTests.class);
        suite.addTestSuite(DuplicateElementExceptionTests.class);
        suite.addTestSuite(Model2XMITransformerTests.class);
        suite.addTestSuite(NodeDescriptionTests.class);
        suite.addTestSuite(NodeValueRetrievalExceptionTests.class);
        suite.addTestSuite(UnknownElementTypeExceptionTests.class);
        suite.addTestSuite(XMIElementDescriptionTests.class);
        suite.addTestSuite(ReflectedXMIDescriptionTests.class);
        suite.addTestSuite(Demo.class);
        return suite;
    }

}
