/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>TextField</code> class.
 *
 * @author still
 * @version 1.0
 */
public class TextFieldFailureTest extends TestCase {
    /** TextField instance used in this test. */
    private TextField instance;

    /**
     * Test suite of TextField.
     *
     * @return Test suite of TextField.
     */
    public static Test suite() {
        return new TestSuite(TextFieldFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new TextField(new GraphNode(), "testField", AnchorType.LeftEnding);
    }


    /**
     * Test of TextField(GraphNode, String, AnchorType) for IllegalArgumentException.
     */
    public void testTextFieldForException_NullGraphNode() {
        try {
            new TextField(null, "testField", AnchorType.LeftEnding);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of TextField(GraphNode, String, AnchorType) for IllegalArgumentException.
     */
    public void testTextFieldForException_NullText() {
        try {
            new TextField(new GraphNode(), null, AnchorType.LeftEnding);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of TextField(GraphNode, String, AnchorType) for IllegalArgumentException.
     */
    public void testTextFieldForException_NullAnchorType() {
        try {
            new TextField(new GraphNode(), "testField", null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setAnchorage(Point) for IllegalArgumentException.
     */
    public void testSetAnchorageForException() {
        try {
            instance.setAnchorage(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

}
