package com.topcoder.gui.panels.documentation.plugins.html.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 * @author peony
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * <p>
     * Run test suits.
     * </p>
     * @return test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(DefaultHTMLDocumentationEditorToolBarFailureTest.suite());
        suite.addTest(HTMLDocumentationEditorFailureTest.suite());
        suite.addTest(HTMLDocumentationEditorToolBarFailureTest.suite());

        return suite;
    }
}
