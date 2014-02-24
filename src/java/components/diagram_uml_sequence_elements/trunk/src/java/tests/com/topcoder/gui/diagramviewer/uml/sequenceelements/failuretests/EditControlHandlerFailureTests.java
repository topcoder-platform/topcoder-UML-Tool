/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.EditControlHandler;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;

/**
 * <p>
 * Failure test for <code>{@link EditControlHandler}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class EditControlHandlerFailureTests extends TestCase {
    /**
     * <p>
     * Failure test for <code>{@link EditControlHandler#EditControlHandler(ObjectNode)}</code> constructor.
     * </p>
     */
    public void testEditControlHandler_NullObjectNode() {
        try {
            new EditControlHandler(null);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for textEntered(TextInputEvent event) when the parameter is null.
     * </p>
     */
    public void testtextEntered_NullEditControlEvent() {
        EditControlHandler editControlHandler = new EditControlHandler(FailureTestHelper.createObjectNode());

        try {
            editControlHandler.textEntered(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * <p>
     * Failure test for textCancelled(TextInputEvent event) when the parameter is null.
     * </p>
     */
    public void testtextCancelled_NullEvent() {
        EditControlHandler editControlHandler = new EditControlHandler(FailureTestHelper.createObjectNode());

        try {
            editControlHandler.textCancelled(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }
}