/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.event;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TestUtil;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of <code>TextInputTrigger</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextInputTriggerTest extends TestCase {

    /** An instance of <code>TextInputTrigger</code> for testing. */
    private TextInputTrigger trigger;

    /** <code>TextField</code> of this <code>TextInputTrigger</code> for testing. */
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
        GraphNode graphNode = TestUtil.createGraphNodeForActivityNode(new PseudostateImpl());
        textField = new TextField(graphNode);
        trigger = new TextInputTrigger(textField);
    }

    /**
     * Test method for 'TextInputTrigger(TextField)'. The instance should be created successfully.
     */
    public void testTextInputTrigger_Accuracy() {
        assertNotNull("Test method for 'TextInputTrigger(TextField)' failed.", trigger);
    }

    /**
     * Test method for 'TextInputTrigger(TextField)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testTextInputTrigger_null() {
        try {
            new TextInputTrigger(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }
}
