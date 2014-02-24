/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * <p>
     * Aggregates all accuracy test cases.
     * </p>
     *
     * @return test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        //suite.addTest(XXX.suite());
        // suite.addTest(DocumentationPanelAccuracyTests.suite());
        suite.addTest(ExceptionAccuracyTests.suite());
        suite.addTest(TagOptionManagerAccuracyTests.suite());
        suite.addTest(DocumentationEventAccuracyTests.suite());
        suite.addTest(TagEventAccuracyTests.suite());
        suite.addTest(DocumentationEditorAccuracyTests.suite());
        suite.addTest(TagEditorAccuracyTests.suite());
        suite.addTest(DefaultTagTableModelAccuracyTests.suite());
        suite.addTest(DefaultDocumentationEditorAccuracyTests.suite());
        suite.addTest(DefaultTagEditorAccuracyTests.suite());
        suite.addTest(DocumentationPanelAccuracyTests.suite());

        return suite;
    }
}
