package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.gui.panels.documentation.plugins.html.toolbars.DefaultHTMLDocumentationEditorToolBarTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>Run test suits.</p>
     *
     * @return test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(HelperTest.suite());
        suite.addTest(HTMLDocumentationEditorExceptionTest.suite());
        suite.addTest(HTMLDocumentationEditorToolBarTest.suite());
        suite.addTest(DefaultHTMLDocumentationEditorToolBarTest.suite());
        suite.addTest(UndoHandlerTest.suite());
        suite.addTest(UndoActionTest.suite());
        suite.addTest(RedoActionTest.suite());
        suite.addTest(HTMLDocumentationEditorTest.suite());

        return suite;
    }
}
