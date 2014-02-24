/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.topcoder.gui.configurationmanager.accuracytests.componentgenerators.CheckBoxPropertyComponentGeneratorTests;
import com.topcoder.gui.configurationmanager.accuracytests.componentgenerators.DropDownPropertyComponentGeneratorTests;
import com.topcoder.gui.configurationmanager.accuracytests.componentgenerators.FreeTextPropertyComponentGeneratorTests;
import com.topcoder.gui.configurationmanager.accuracytests.componentgenerators.RadioButtonsPropertyComponentGeneratorTests;

/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * <p>
     * Returns a suite which aggregates all accuracy test cases.
     * </p>
     *
     * @return a suite of accuracy tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ConfigurationExceptionTests.class);
        suite.addTestSuite(ConfigurationManagerEditorPanelExceptionTests.class);
        suite.addTestSuite(InsufficientDataExceptionTests.class);
        suite.addTestSuite(NotValidNamespaceExceptionTests.class);
        suite.addTestSuite(SavingExceptionTests.class);
        suite.addTestSuite(ValidationExceptionTests.class);

        suite.addTestSuite(ConfigurationManagerEditorPanelExceptionTests.class);
        suite.addTestSuite(ValidationResultTests.class);
        suite.addTestSuite(ValidationResultSetTests.class);
        suite.addTestSuite(PropertyTypeTests.class);
        suite.addTestSuite(PropertyDefinitionTests.class);

        suite.addTestSuite(CheckBoxPropertyComponentGeneratorTests.class);
        suite.addTestSuite(DropDownPropertyComponentGeneratorTests.class);
        suite.addTestSuite(FreeTextPropertyComponentGeneratorTests.class);
        suite.addTestSuite(RadioButtonsPropertyComponentGeneratorTests.class);

        suite.addTestSuite(ConfigurationManagerEditorPanelTests.class);

        return suite;
    }
}