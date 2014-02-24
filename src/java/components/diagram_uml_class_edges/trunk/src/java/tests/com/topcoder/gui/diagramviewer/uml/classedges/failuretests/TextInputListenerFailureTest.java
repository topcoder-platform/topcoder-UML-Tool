/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextInputListener;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>EditBoxListener</code> class.
 *
 * @author still
 * @version 1.0
 */
public class TextInputListenerFailureTest extends TestCase {

    /**
     * Test suite of EditBoxListener.
     *
     * @return Test suite of EditBoxListener.
     */
    public static Test suite() {
        return new TestSuite(TextInputListenerFailureTest.class);
    }

    /**
     * <p>
     * Test of EditBoxListener(TextField) for IllegalArgumentException.
     * </p>
     *
     * IllegalArgumentException must be thrown when encountering null textField.
     */
    public void testEditBoxListenerForException() {
        try {
            new TextInputListener(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of onEntered(EditBoxEvent) for ignoring null event.
     * </p>
     *
     * No exception should be thrown when encountering null event.
     */
    public void testOnEnteredForIgnoreNullEditBoxEvent() {
        TextField textField = new TextField(new GraphNode());
        // should ignore null EditBoxEvent
        new TextInputListener(textField).textEntered(null);
    }

    /**
     * <p>
     * Test of onCancelled(EditBoxEvent) for ignoring null event.
     * </p>
     *
     * No exception should be thrown when encountering null event.
     */
    public void testOnCancelledForIgnoreNullEditBoxEvent() {
        TextField textField = new TextField(new GraphNode());
        // should ignore null EditBoxEvent
        new TextInputListener(textField).textCancelled(null);
    }
}
