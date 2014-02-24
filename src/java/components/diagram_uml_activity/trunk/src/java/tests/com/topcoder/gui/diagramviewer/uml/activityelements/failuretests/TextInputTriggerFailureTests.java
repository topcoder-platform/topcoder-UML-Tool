/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextInputTrigger;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link TextInputTrigger}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class TextInputTriggerFailureTests extends TestCase {
    /**
     * <p>
     * Failure test for
     * <code>{@link TextInputTrigger#TextInputTrigger(com.topcoder.gui.diagramviewer.uml.activityelements.TextField)}</code>
     * constructor.
     * </p>
     */
    public void testTextInputTriggerNullTextField() {
        try {
            new TextInputTrigger(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
