/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ResizeEvent;

/**
 * <p>
 * This class aggregates accuracy tests for ResizeEvent class.
 * </p>
 *
 * @author ch_music
 * @version 1.0
 */
public class ResizeEventAccuracyTests extends TestCase {

    /**
     * A ResizeEvent instance for testing.
     */
    private ResizeEvent test;

    /**
     * An ObjectNode instance.
     */
    private ObjectNode node;

    /**
     * A String instance.
     */
    private String reason = "reason";

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        node = AccuracyTestHelper.createObjectNode();
        test = new ResizeEvent(node, reason);
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testResizeEvent() {
        assertNotNull("Constructor fails to create instance.", test);
    }

    /**
     * Tests getNode method for accuracy.
     */
    public void testGetNode() {
        assertEquals("getNode fails to return correct instance.", node, test.getNode());
    }

    /**
     * Tests getReason method for accuracy.
     */
    public void testGetReason() {
        assertEquals("getReason fails to return correct instance.", reason, test.getReason());
    }
}
