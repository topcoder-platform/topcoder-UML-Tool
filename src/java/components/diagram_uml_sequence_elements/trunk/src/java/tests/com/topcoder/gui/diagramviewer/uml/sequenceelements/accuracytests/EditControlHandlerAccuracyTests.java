/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.EditControlHandler;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;

/**
 * <p>
 * This class aggregates accuracy tests for EditControlHandler class.
 * </p>
 *
 * @author ch_music
 * @version 1.0
 */
public class EditControlHandlerAccuracyTests extends TestCase {

    /**
     * <p>
     * The EditControlHandler instance used for testing.
     * </p>
     */
    private EditControlHandler test;

    /**
     * <p>
     * The ObjectNode instance.
     * </p>
     */
    private ObjectNode node;

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        node = AccuracyTestHelper.createObjectNode();
        test = new EditControlHandler(node);
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testEditControlHandler() {
        assertNotNull("Constructor fails to create instance.", test);
    }

    /**
     * Tests getNode method for accuracy.
     */
    public void testGetNode() {
        assertEquals("getNode fails to return correct node.", node, test.getNode());
    }
}
