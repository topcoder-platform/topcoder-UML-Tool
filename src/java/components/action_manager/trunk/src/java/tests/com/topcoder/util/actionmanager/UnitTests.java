/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

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
    /**
     * <p>
     * This method aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // tests for package com.topcoder.util.actionmanager
        suite.addTest(ActionManagerConfigurationExceptionTests.suite());
        suite.addTest(UtilTests.suite());
        suite.addTest(ActionExecutionExceptionTests.suite());
        suite.addTest(ActionManagerTests.suite());
        suite.addTest(UndoActionExecutionExceptionTests.suite());
        suite.addTest(RedoActionExecutionExceptionTests.suite());
        suite.addTest(CompoundUndoableActionTests.suite());
        suite.addTest(TransientUndoableActionTests.suite());

        suite.addTest(Demo.suite());

        return suite;
    }

}
