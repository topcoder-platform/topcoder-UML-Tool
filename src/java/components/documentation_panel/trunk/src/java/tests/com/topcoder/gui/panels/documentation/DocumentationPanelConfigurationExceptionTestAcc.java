/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for class <code>DocumentationPanelConfigurationException</code>.
 * All constructors are tested.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DocumentationPanelConfigurationExceptionTestAcc extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the
     * <code>DocumentationPanelConfigurationException</code>.
     * </p>
     */
    private final Exception cause = new Exception();

    /**
     * <p>
     * Test constructor1 : <code>DocumentationPanelConfigurationException(String)</code>,
     * with correct message. The message can be retrieved correctly later.
     * </p>
     */
    public void testCtor1() {
        DocumentationPanelConfigurationException dpce = new DocumentationPanelConfigurationException(ERROR_MESSAGE);

        assertNotNull("Successfully to instantiate DocumentationPanelConfigurationException.", dpce);
        assertEquals("Error message is properly propagated to super class.", ERROR_MESSAGE,
                dpce.getMessage());
    }
    /**
     * <p>
     * Test constructor2: <code>DocumentationPanelConfigurationException(String, Throwable)</code>,
     * with correct error message and cause. The message and cause can be retrieved correctly later.
     * </p>
     */
    public void testCtor2() {
        DocumentationPanelConfigurationException dpce =
            new DocumentationPanelConfigurationException(ERROR_MESSAGE, cause);

        assertNotNull("Successfully to instantiate DocumentationPanelConfigurationException.", dpce);
        assertTrue("Error message is properly propagated to super class.",
                dpce.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("The inner exception should match.", cause, dpce.getCause());
    }
}
