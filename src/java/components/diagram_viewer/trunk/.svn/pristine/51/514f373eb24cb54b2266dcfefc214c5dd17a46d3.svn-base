/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>TextInputEvent</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class TextInputEventAccuracyTests extends TestCase {

    /**
     * Represent the instance of <c>TextInputEvent</c> used for test.
     */
    private TextInputEvent event;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {

        event = new TextInputEvent(new TextInputBox(), "test");
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>TextInputEvent</code>. The instance of <code>TextInputEvent</code>
     * should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of TextInputEvent should be created", event);
    }

    /**
     * <p>
     * Accuracy test for the method <code>GetText</code> The Text should be returned.
     * </p>
     */
    public void testGetTextAccuracy() {
        try {
            assertEquals("the Text should be returned", "test", event.getText());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
