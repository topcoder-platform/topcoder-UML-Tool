/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;

/**
 * <p>
 * Unit test cases for TextChangeEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextChangeEventTests extends TestCase {
    /**
     * <p>
     * TextChangeEvent instance for testing.
     * </p>
     */
    private TextChangeEvent event;

    /**
     * <p>
     * TextField instance for testing.
     * </p>
     */
    private TextField source;

    /**
     * <p>
     * String instance for testing.
     * </p>
     */
    private String oldText = "old text";

    /**
     * <p>
     * String instance for testing.
     * </p>
     */
    private String newText = "new text";

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        source = TestHelper.createTextField();
        event = new TextChangeEvent(source, oldText, newText);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        source = null;
        event = null;
    }

    /**
     * <p>
     * Tests TextChangeEvent#TextChangeEvent(TextField, String, String) for accuracy.
     * </p>
     * <p>
     * It verifies he newly created TextChangeEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a NodeAddEvent instance.", event);
    }

    /**
     * <p>
     * Tests TextChangeEvent#TextChangeEvent(TextField, String, String) for failure.
     * </p>
     * <p>
     * It tests the case that when source is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullSource() {
        try {
            new TextChangeEvent(null, oldText, newText);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests TextChangeEvent#TextChangeEvent(TextField, String, String) for failure.
     * </p>
     * <p>
     * It tests the case that when oldText is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullOldText() {
        try {
            new TextChangeEvent(source, null, newText);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests TextChangeEvent#TextChangeEvent(TextField, String, String) for failure.
     * </p>
     * <p>
     * It tests the case that when newText is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNewText() {
        try {
            new TextChangeEvent(source, oldText, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests TextChangeEvent#getSource() for accuracy.
     * </p>
     * <p>
     * It verifies TextChangeEvent#getSource() is correct.
     * </p>
     */
    public void testGetSource() {
        assertSame("Failed to get the source correctly.", source, event.getSource());
        assertTrue("Failed to get the source correctly.", event.getSource() instanceof TextField);
    }

    /**
     * <p>
     * Tests TextChangeEvent#getOldText() for accuracy.
     * </p>
     * <p>
     * It verifies TextChangEvent#getOldText() is correct.
     * </p>
     */
    public void testGetOldText() {
        assertEquals("Failed to get old text correctly.", oldText, event.getOldText());
    }

    /**
     * <p>
     * Tests TextChangeEvent#getNewText() for accuracy.
     * </p>
     * <p>
     * It verifies TextChangeEvent#getNewText() is correct.
     */
    public void testGetNewText() {
        assertEquals("Failed to get new text correctly.", newText, event.getNewText());
    }
}
