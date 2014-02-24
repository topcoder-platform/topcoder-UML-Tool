/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * Failure test cases.
     *
     * @return Test into JUnit
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(DefaultDocumentationEditorTests.class);
        suite.addTestSuite(DefaultTagEditorTests.class);
        suite.addTestSuite(DefaultTagTableModelTests.class);
        suite.addTestSuite(DocumentationEventTests.class);
        suite.addTestSuite(DocumentationPanelTests.class);
        suite.addTestSuite(TagEventTests.class);
        suite.addTestSuite(TagOptionManagerTests.class);

        return suite;
    }
}
