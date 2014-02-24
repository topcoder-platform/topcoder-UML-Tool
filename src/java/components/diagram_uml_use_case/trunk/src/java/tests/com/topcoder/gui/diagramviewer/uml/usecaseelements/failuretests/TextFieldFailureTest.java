/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TextFieldFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.edges.AnchorType;

/**
 * <p>
 * This is a failure tests for <code>TextField</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class TextFieldFailureTest extends TestCase {

    /**GraphNode instance that is used for testing.*/
    private GraphNode graphNode;

    /**TextField instance that will be tested.*/
    private TextField textField;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        graphNode = new GraphNode();
        textField = new TextField(graphNode);
    }

    /**
     * <p>
     * Tests constructor TextField(graphNode) if graphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfGraphNodeNull() {
        try {
            new TextField(null);
            fail("IllegalArgumentException is expected because graphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor TextField(graphNode, anchorType) if graphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfGraphNodeNull() {
        try {
            new TextField(null, AnchorType.Line);
            fail("IllegalArgumentException is expected because graphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor TextField(graphNode, anchorType) if anchorType is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfAnchorTypeNull() {
        try {
            new TextField(graphNode, null);
            fail("IllegalArgumentException is expected because anchorType cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method measureSize(text) if text is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testMeasureSizeIfTextNull() {
        try {
            textField.measureSize(null);
            fail("IllegalArgumentException is expected becase text cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}