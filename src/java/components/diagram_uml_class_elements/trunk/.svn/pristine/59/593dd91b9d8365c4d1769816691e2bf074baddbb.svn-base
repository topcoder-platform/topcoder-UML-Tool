/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Dimension;
import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.TestUtil;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;

/**
 * <p>
 * Test the functionality of <code>TextChangedEvent</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextChangedEventTest extends TestCase {

    /**
     * The absolute position of the visual node. Used for testing only.
     */
    private static final Point POSITION = new Point(100, 150);

    /**
     * The size of the visual node. Used for testing only.
     */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>TextChangedEvent</code> for testing. */
    private TextChangedEvent event;

    /** Old text of <code>TextChangedEvent</code>. */
    private String oldText = "old";

    /** New text of <code>TextChangedEvent</code>. */
    private String newText = "new";

    /** <code>TextField</code> of this <code>TextChangedEvent</code> for testing. */
    private TextField textField;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        GraphNode graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        textField = new TextField(graphNode);
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
        assertEquals("Old text should be got correctly.", event.getOldText(), oldText);
    }

    /**
     * Test method for 'getNewText()', new text should be got correctly.
     */
    public void testGetNewText() {
        assertEquals("New text should be got correctly.", event.getNewText(), newText);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        event = null;

        oldText = null;

        newText = null;

        textField = null;
    }
}
