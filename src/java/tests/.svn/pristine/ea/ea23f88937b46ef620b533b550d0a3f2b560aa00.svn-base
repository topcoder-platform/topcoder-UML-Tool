/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import com.topcoder.umltool.deploy.actions.undoable.UndoableUnitTests;
import com.topcoder.umltool.deploy.elements.ElementTests;
import com.topcoder.umltool.deploy.handlers.HandlerUnitTests;
import com.topcoder.umltool.deploy.zumlimport.test.ZumlImportTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all test cases.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AllTests extends TestCase {

    /**
     * Aggregates all test cases.
     *
     * @return the aggregated test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // suite.addTest(ElementTests.suite());
        // suite.addTest(UndoableUnitTests.suite());
        // suite.addTest(HandlerUnitTests.suite());
        // suite.addTest(ZumlImportTests.suite());
        suite.addTest(com.topcoder.umltool.deploy.codegen.test.AllTests.suite());

        return suite;
    }

}
