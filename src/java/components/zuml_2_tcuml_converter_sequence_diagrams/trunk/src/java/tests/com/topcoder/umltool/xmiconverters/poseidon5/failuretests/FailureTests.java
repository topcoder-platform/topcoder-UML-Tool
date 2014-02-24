/**
 *
 * Copyright (c) 2007, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        suite.addTestSuite(InteractionImplFailureTest.class);
        suite.addTestSuite(MessageImplFailureTest.class);
        suite.addTestSuite(XMISequenceDiagramConverterUtilFailureTest.class);
        
        return suite;
    }

}
