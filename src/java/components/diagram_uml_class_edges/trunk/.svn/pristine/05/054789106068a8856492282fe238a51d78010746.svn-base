/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeEvent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>TextChangeEvent</code> class.
 *
 *
 * @author still
 * @version 1.0
 */
public class TextChangeEventFailureTest extends TestCase {

    /**
     * Test suite of TextChangeEvent.
     *
     * @return Test suite of TextChangeEvent.
     */
    public static Test suite() {
        return new TestSuite(TextChangeEventFailureTest.class);
    }


    /**
     * <p>
     * Test of TextChangeEvent(TextField, String, String) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null TextField.
     */
    public void testTextChangeEventForException1() {
        try {
            new TextChangeEvent(null, "old", "new");
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of TextChangeEvent(TextField, String, String) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null oldText.
     */
    public void testTextChangeEventForException2() {
        try {
            new TextChangeEvent(new TextField(new GraphNode()), null, "new");
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of TextChangeEvent(TextField, String, String) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null newText.
     */
    public void testTextChangeEventForException3() {
        try {
            new TextChangeEvent(new TextField(new GraphNode()), "old", null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

}
