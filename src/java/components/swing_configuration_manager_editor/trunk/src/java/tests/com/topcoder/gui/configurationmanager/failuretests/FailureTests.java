/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * <p>This test case aggregates all failure tests for the component.</p>
     *
     * @return the failure test suite for the component
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(ValidationResultFailureTests.suite());
        suite.addTest(ValidationResultSetFailureTests.suite());
        suite.addTest(ConfigurationManagerEditorPanelFailureTests.suite());
        suite.addTest(PropertyDefinitionFailureTests.suite());
        suite.addTest(FreeTextPropertyComponentGeneratorFailureTests.suite());
        suite.addTest(DropDownPropertyComponentGeneratorFailureTests.suite());
        suite.addTest(CheckBoxPropertyComponentGeneratorFailureTests.suite());
        suite.addTest(RadioButtonsPropertyComponentGeneratorFailureTests.suite());

        return suite;
    }

}
