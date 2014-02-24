/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>TextChangeEvent</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class TextChangeEventUnitTests extends TestCase {

    /** <code>TextChangeEvent</code> instance for testing. */
    private TextChangeEvent event;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        event = new TextChangeEvent(new TextField(new GraphNode()), "some old text", "some new text");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        event = null;
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>textField</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullTextField() {
        try {
            new TextChangeEvent(null, "some old text", "some new text");
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>oldText</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullOldText() {
        try {
            new TextChangeEvent(new TextField(new GraphNode()), null, "some new text");
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>newText</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullNewText() {
        try {
            new TextChangeEvent(new TextField(new GraphNode()), "some old text", null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", event);
    }

    /**
     * <p>
     * Accuracy test of method <code>getOldText()</code>.
     * Should return the proper old text.
     * </p>
     */
    public void testGetOldText() {
        assertEquals("Should return the proper old text.", "some old text", event.getOldText());
    }

    /**
     * <p>
     * Accuracy test of method <code>getNewText()</code>.
     * Should return the proper new text.
     * </p>
     */
    public void testGetNewText() {
        assertEquals("Should return the proper new text.", "some new text", event.getNewText());
    }

}
