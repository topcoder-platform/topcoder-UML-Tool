/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TextChangeEventFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeEvent;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This is a failure tests for <code>TextChangeEvent</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class TextChangeEventFailureTest extends TestCase {

    /**Old text string.*/
    private static final String OLD_TEXT = "old_text";

    /**New text string.*/
    private static final String NEW_TEXT = "new_text";

    /**TextField instance that is used for testing.*/
    private TextField source;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        source = new TextField(new GraphNode());
    }

    /**
     * <p>
     * Tests constructor TextChangeEvent(source, oldText, newText) if source is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfSourceNull() {
        try {
            new TextChangeEvent(null, OLD_TEXT, NEW_TEXT);
            fail("IllegalArgumentException is expected because source cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor TextChangeEvent(source, oldText, newText) if oldText is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfOldTextNull() {
        try {
            new TextChangeEvent(source, null, NEW_TEXT);
            fail("IllegalArgumentException is expected because oldText cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor TextChangeEvent(source, oldText, newText) if newText is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNewTextNull() {
        try {
            new TextChangeEvent(source, OLD_TEXT, null);
            fail("IllegalArgumentException is expected because newText cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}