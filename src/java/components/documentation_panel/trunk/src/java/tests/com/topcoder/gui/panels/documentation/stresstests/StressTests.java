/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all stress test cases.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class StressTests extends TestCase {
    /**
     * <p>The method aggregates all stress test cases.</p>
     *
     * @return the test suite of the stress test.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(DefaultDocumentationEditorStressTest.suite());
        suite.addTest(DefaultTagEditorStressTest.suite());
        suite.addTest(DocumentationPanelStressTest.suite());

        return suite;
    }
}
