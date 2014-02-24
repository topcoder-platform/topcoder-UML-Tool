/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceElementsConfigurationException;

/**
 * This class aggregates accuracy tests for SequenceElementsConfigurationException class.
 *
 * @author ch_music
 * @version 1.0
 */
public class SequenceElementsConfigurationExceptionAccuracyTests extends TestCase {

    /**
     * The SequenceElementsConfigurationException for testing.
     */
    private SequenceElementsConfigurationException test;

    /**
     * Tests no-argument constructor for accuracy.
     */
    public void testSequenceElementsConfigurationException() {
        test = new SequenceElementsConfigurationException();
        assertNotNull("Constructor fails to create instance.", test);
        assertNull("Constructor fails to set message.", test.getMessage());
        assertNull("Constructor fails to set cause.", test.getCause());
    }

    /**
     * Tests single-argument constructor for accuracy.
     */
    public void testSequenceElementsConfigurationExceptionString() {
        test = new SequenceElementsConfigurationException("test");
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set message.", "test", test.getMessage());
        assertNull("Constructor fails to set cause.", test.getCause());
    }

    /**
     * Tests two-argument constructor for accuracy.
     */
    public void testSequenceElementsConfigurationExceptionStringException() {
        Exception e = new IllegalArgumentException();
        test = new SequenceElementsConfigurationException("test", e);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set message.", "test", test.getMessage().substring(0, 4));
        assertEquals("Constructor fails to set cause.", e, test.getCause());
    }
}
