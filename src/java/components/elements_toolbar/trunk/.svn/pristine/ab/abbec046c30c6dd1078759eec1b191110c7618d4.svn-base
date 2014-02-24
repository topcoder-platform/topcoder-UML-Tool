/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.accuracytests;

import com.topcoder.gui.toolbars.elements.SectionPanelConfigurationException;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link SectionPanelConfigurationException}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class SectionPanelConfigurationExceptionAccuracyTests extends TestCase {

    /**
     * Represents a string with a detail message.
     */
    private static final String DETAIL_MESSAGE = "detail";

    /**
     * Represents a throwable cause.
     */
    private static final Exception CAUSE = new Exception();

    /**
     * Tests accuracy of <code>SectionPanelConfigurationException(String)</code> constructor. The detail error message
     * should be correct.
     */
    public void testSectionPanelConfigurationExceptionStringAccuracy() {
        // Construct SectionPanelConfigurationException with a detail message
        SectionPanelConfigurationException exception = new SectionPanelConfigurationException(DETAIL_MESSAGE);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message should be identical.", DETAIL_MESSAGE, exception.getMessage());
    }

    /**
     * Tests accuracy of <code>SectionPanelConfigurationException(String, Throwable)</code> constructor. The detail
     * error message and the original cause of error should be correct.
     */
    public void testSectionPanelConfigurationExceptionStringThrowableAccuracy() {
        // Construct SectionPanelConfigurationException with a detail message and a cause
        SectionPanelConfigurationException exception = new SectionPanelConfigurationException(DETAIL_MESSAGE, CAUSE);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message with cause should be correct.", DETAIL_MESSAGE + ", caused by null",
            exception.getMessage());

        // Verify that there is a cause
        assertNotNull("Should have cause.", exception.getCause());
        assertTrue("Cause should be identical.", CAUSE == exception.getCause());
    }
}
