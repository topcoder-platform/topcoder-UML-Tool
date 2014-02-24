/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SetNameEvent;

/**
 * This class aggregates accuracy tests for SetNameEvent class.
 *
 * @author ch_music
 * @version 1.0
 */
public class SetNameEventAccuracyTests extends TestCase {

    /**
     * An SetNameEvent for testing.
     */
    private SetNameEvent test;

    /**
     * The old name.
     */
    private String oldName = "oldname";

    /**
     * The new name.
     */
    private String newName = "newname";

    /**
     * An ObjectNode.
     */
    private ObjectNode node;

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        node = AccuracyTestHelper.createObjectNode();
        test = new SetNameEvent(oldName, newName, node);
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testSetNameEvent() {
        assertNotNull("Constructor fails to create instance.", test);
    }

    /**
     * Tests getOldName method for accuracy.
     */
    public void testGetOldName() {
        assertEquals("getPosition method fails to return correct value.", oldName, test.getOldName());
    }

    /**
     * Tests getNewName method for accuracy.
     */
    public void testGetNewName() {
        assertEquals("getName method fails to return correct value.", newName, test.getNewName());
    }

    /**
     * Tests getNode method for accuracy.
     */
    public void testGetNode() {
        assertEquals("getNode method fails to return correct value.", node, test.getNode());
    }
}
