/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGeneratorTest;
import com.topcoder.gui.configurationmanager.componentgenerators.DropDownPropertyComponentGeneratorTest;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGeneratorTest;
import com.topcoder.gui.configurationmanager.componentgenerators.RadioButtonsPropertyComponentGeneratorTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>
     * Returns all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(DropDownPropertyComponentGeneratorTest.class);
        suite.addTestSuite(FreeTextPropertyComponentGeneratorTest.class);
        suite.addTestSuite(RadioButtonsPropertyComponentGeneratorTest.class);
        suite.addTestSuite(CheckBoxPropertyComponentGeneratorTest.class);

        suite.addTestSuite(ConfigurationManagerEditorPanelExceptionTests.class);
        suite.addTestSuite(NotValidNamespaceExceptionTests.class);
        suite.addTestSuite(InsufficientDataExceptionTests.class);
        suite.addTestSuite(ConfigurationExceptionTests.class);
        suite.addTestSuite(ValidationExceptionTests.class);
        suite.addTestSuite(ValidationResultSetTest.class);
        suite.addTestSuite(PropertyTypeTest.class);
        suite.addTestSuite(ConfigurationManagerEditorPanelTest.class);
        suite.addTestSuite(ValidationResultTest.class);
        suite.addTestSuite(SavingExceptionTests.class);
        suite.addTestSuite(PropertyDefinitionTest.class);

        suite.addTestSuite(SwingDemo.class);

        return suite;
    }

}
