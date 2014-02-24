/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.EditNameEvent;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;

/**
 * This class aggregates accuracy tests for EditNameEvent class.
 *
 * @author ch_music
 * @version 1.0
 */
public class EditNameEventAccuracyTests extends TestCase {

    /**
     * An EditNameEvent for testing.
     */
    private EditNameEvent test;

    /**
     * A Point.
     */
    private Point position = new Point(1, 0);

    /**
     * A name.
     */
    private String name = "name";

    /**
     * An ObjectNode.
     */
    private ObjectNode node;

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        node = AccuracyTestHelper.createObjectNode();
        test = new EditNameEvent(position, name, node);
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testEditNameEvent() {
        assertNotNull("Constructor fails to create instance.", test);
    }

    /**
     * Tests getPosition method for accuracy.
     */
    public void testGetPosition() {
        assertEquals("getPosition method fails to return correct value.", position, test.getPosition());
    }

    /**
     * Tests getName method for accuracy.
     */
    public void testGetName() {
        assertEquals("getName method fails to return correct value.", name, test.getName());
    }

    /**
     * Tests getNode method for accuracy.
     */
    public void testGetNode() {
        assertEquals("getNode method fails to return correct value.", node, test.getNode());
    }
}
