/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextInputTrigger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>EditBoxTrigger</code> class.
 *
 * @author still
 * @version 1.0
 */
public class TextInputTriggerFailureTest extends TestCase {
    /** EditBoxTrigger instance used in this failure test. */
    private TextInputTrigger trigger;
    /**
     * Test suite of EditBoxTrigger.
     *
     * @return Test suite of EditBoxTrigger.
     */
    public static Test suite() {
        return new TestSuite(TextInputTriggerFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        // set up for test
        trigger = new TextInputTrigger(new TextField(new GraphNode()));
    }


    /**
     * <p>
     * Test of EditBoxTrigger(TextField) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null textField.
     */
    public void testEditBoxTriggerForException() {
        try {
            new TextInputTrigger(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of mouseClicked(MouseEvent) for ignoring null event.
     * </p>
     *
     * No exception should be thrown when encountering null event.
     */
    public void testMouseClickedForIgnoreNullEvent() {

        try {
            // should not throw any exception
            trigger.mouseClicked(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }
}
