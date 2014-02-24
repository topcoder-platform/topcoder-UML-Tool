/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * EditBoxListenerFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxListener;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This is a failure tests for <code>EditBoxListener</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class EditBoxListenerFailureTest extends TestCase {

    /**TextField instance that is used for testing.*/
    private TextField textField;

    /**EditBoxListener instance that will be tested.*/
    private EditBoxListener editBoxListener;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        textField = new TextField(new GraphNode());
        editBoxListener = new EditBoxListener(textField);
    }

    /**
     * <p>
     * Tests constructor EditBoxListener(textField) if textField is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfTextFieldNull() {
        try {
            new EditBoxListener(null);
            fail("IllegalArgumentException is excpected because textField cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method textEntered(eventObject) if eventObject is null.
     * No exception should be thrown.
     * </p>
     */
    public void testTextEnteredIfEventObjectNull() {
        try {
            editBoxListener.textEntered(null);
        } catch (Exception e) {
            fail("No exception is excpected.");
        }
    }

    /**
     * <p>
     * Tests method textCancelled(eventObject) if eventObject is null.
     * No exception should be thrown.
     * </p>
     */
    public void testTextCancelledIfEventObjectNull() {
        try {
            editBoxListener.textCancelled(null);
        } catch (Exception e) {
            fail("No exception is excpected.");
        }
    }
}