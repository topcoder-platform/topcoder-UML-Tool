/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;

/**
 * <p>
 * Failure test for <code>{@link TextField}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class TextFieldFailureTests extends TestCase {

    /*
     * BugFix: UML-10105
     * Null should be treated as empty string.
     */
    // old code
//    /**
//     * <p>
//     * Represents the text field instance.
//     * </p>
//     */
//    private TextField textField;
//
//    /**
//     * <p>
//     * Set up the testing environment.
//     * </p>
//     */
//    protected void setUp() throws Exception {
//        super.setUp();
//
//        textField = new TextField(new GraphNode());
//    }

    /**
     * <p>
     * Failure test for <code>{@link TextField#TextField(GraphNode)}</code> method.
     * </p>
     */
    public void testTextFieldNullGraphNode() {
        try {
            new TextField(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /*
     * BugFix: UML-10105
     * Null should be treated as empty string.
     */
    // old code
//    /**
//     * <p>
//     * Failure test for <code>{@link TextField#setText(String)}</code> method.
//     * </p>
//     */
//    public void testSetTextNullText() {
//        try {
//            textField.setText(null);
//            fail("expect throw IllegalArgumentException.");
//        } catch (IllegalArgumentException e) {
//            // expected
//        }
//    }
}
