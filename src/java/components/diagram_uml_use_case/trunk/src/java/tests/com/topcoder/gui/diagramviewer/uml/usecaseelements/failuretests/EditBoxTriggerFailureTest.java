/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * EditBoxTriggerFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxTrigger;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This is a failure tests for <code>EditBoxTrigger</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class EditBoxTriggerFailureTest extends TestCase {

    /**TextField instance that is used for testing.*/
    private TextField textField;

    /**EditBoxTrigger instance that will be tested.*/
    private EditBoxTrigger editBoxTrigger;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        textField = new TextField(new GraphNode());
        editBoxTrigger = new EditBoxTrigger(textField);
    }

    /**
     * <p>
     * Tests constructor EditBoxTrigger(textField) if textField is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfTextFieldNull() {
        try {
            new EditBoxTrigger(null);
            fail("IllegalArgumentException is excpected because textField cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method mouseClicked(mouseEvent) if mouseEvent is null.
     * No exception should be thrown.
     * </p>
     */
    public void testMouseClickedIfMouseEventNull() {
        try {
            editBoxTrigger.mouseClicked(null);
        } catch (Exception e) {
            fail("No exception is excpected.");
        }
    }
}