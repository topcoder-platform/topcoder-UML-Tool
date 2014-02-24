/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link TextChangedEvent}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class TextChangedEventFailureTests extends TestCase {

    /**
     * <p>
     * Represents the text field.
     * </p>
     */
    private TextField textField;

    /**
     * <p>
     * Set up the testing environment. prepare data for it.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();

        textField = new TextField(new Diagram());
    }

    /**
     * <p>
     * Failure test for <code>{@link TextChangedEvent#TextChangedEvent(TextField, String, String)}</code>
     * </p>
     */
    public void testTextChangedEventNullTextField() {
        try {
            new TextChangedEvent(null, "", "");
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link TextChangedEvent#TextChangedEvent(TextField, String, String)}</code> method.
     * </p>
     */
    public void testTextChangedEventNullOldValue() {
        try {
            new TextChangedEvent(textField, null, "");
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link TextChangedEvent#TextChangedEvent(TextField, String, String)}</code> method.
     * </p>
     */
    public void testTextChangedEventNullNewValue() {
        try {
            new TextChangedEvent(textField, "", null);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
