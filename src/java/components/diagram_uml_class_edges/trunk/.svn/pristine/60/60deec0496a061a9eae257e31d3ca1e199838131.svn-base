/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>TextInputListener</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class TextInputListenerUnitTests extends TestCase {

    /** <code>TextInputListener</code> instance for testing. */
    private TextInputListener listener;

    /** <code>TextField</code> instance for testing. */
    private TextField textField;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        textField = new TextField(new GraphNode());
        listener = new TextInputListener(textField);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        textField = null;
        listener = null;
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>textField</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure() {
        try {
            new TextInputListener(null);
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
        assertNotNull("Should create the instance successfully.", listener);
    }

    /**
     * <p>
     * Accuracy test of method <code>textEntered(TextInputEvent)</code>.
     * With null <code>TextInputEvent</code>.
     * Should return directly.
     * </p>
     */
    public void testOnEntered_NullEvent() {
        listener.textEntered(null);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>textCancelled(TextInputEvent)</code>.
     * With null <code>TextInputEvent</code>.
     * Should return directly.
     * </p>
     */
    public void testOnCancelled_NullEvent() {
        listener.textCancelled(null);
        //return directly
    }

}
