/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextInputListener;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link TextInputListener}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class TextInputListenerFailureTests extends TestCase {
    /**
     * <p>
     * Failure test for
     * <code>{@link TextInputListener#TextInputListener(com.topcoder.gui.diagramviewer.uml.activityelements.TextField)}</code>
     * constructor.
     * </p>
     */
    public void testTextInputListenerNullTextField() {
        try {
            new TextInputListener(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
