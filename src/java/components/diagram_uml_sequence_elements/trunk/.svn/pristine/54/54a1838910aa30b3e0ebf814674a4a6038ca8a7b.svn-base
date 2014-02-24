/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of <code>TextChangedEvent</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 */
public class TextChangedEventTest extends TestCase {

    /**
     * An instance of <code>TextChangedEvent</code> for testing.
     */
    private TextChangedEvent event;

    /**
     * Old text of <code>TextChangedEvent</code>.
     */
    private String oldText = "old";

    /**
     * New text of <code>TextChangedEvent</code>.
     */
    private String newText = "new";

    /**
     * <code>TextField</code> of this <code>TextChangedEvent</code> for testing.
     */
    private TextField textField;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {

        SequenceEdge edge = TestHelper.createCorrectSequeceEdge();
        textField = edge.getNameCompartment();
        event = new TextChangedEvent(textField, oldText, newText);
    }

    /**
     * Test method for 'TextChangedEvent(TextField, String, String)'. The instance should be created successfully.
     */
    public void testTextChangedEvent_Accuracy() {
        assertNotNull("Test method for 'TextChangedEvent(TextField, String, String)' failed.", event);
    }

    /**
     * Test method for 'TextChangedEvent(TextField, String, String)'. The source is null, IllegalArgumentException
     * should be thrown.
     */
    public void testTextChangedEvent_null_1() {
        try {
            new TextChangedEvent(null, oldText, newText);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'TextChangedEvent(TextField, String, String)'. The old text is null, IllegalArgumentException
     * should be thrown.
     */
    public void testTextChangedEvent_null_2() {
        try {
            new TextChangedEvent(textField, null, newText);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'TextChangedEvent(TextField, String, String)'. The new text is null, IllegalArgumentException
     * should be thrown.
     */
    public void testTextChangedEvent_null_3() {
        try {
            new TextChangedEvent(textField, oldText, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getOldText()', old text should be got correctly.
     */
    public void testGetOldText() {
        assertEquals("Old text should be got correctly.", event.getOldValue(), oldText);
    }

    /**
     * Test method for 'getNewText()', new text should be got correctly.
     */
    public void testGetNewText() {
        assertEquals("New text should be got correctly.", event.getNewValue(), newText);
    }

}
