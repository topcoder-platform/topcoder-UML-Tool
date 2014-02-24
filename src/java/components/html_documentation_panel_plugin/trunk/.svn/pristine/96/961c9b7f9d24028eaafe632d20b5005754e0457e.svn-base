package com.topcoder.gui.panels.documentation.plugins.html;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.panels.documentation.plugins.html.accuracytests.AccuracyTests;
import com.topcoder.gui.panels.documentation.plugins.html.failuretests.FailureTests;
import com.topcoder.gui.panels.documentation.plugins.html.stresstests.StressTests;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 * @author peony
 * @version 1.0
 */
public class AllTests extends TestCase {
    /**
     * <p>
     * Run test suits.
     * </p>
     * @return test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(UnitTests.suite());
        suite.addTest(FailureTests.suite());
        suite.addTest(StressTests.suite());
        suite.addTest(AccuracyTests.suite());

        return suite;
    }
}
