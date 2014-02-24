/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.awt.Point;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.EditNameEvent;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link EditNameEvent}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class EditNameEventFailureTests extends TestCase {
    /**
     * <p>
     * Represents the <code>{@link ObjectNode}</code> instance.
     * </p>
     */
    private ObjectNode objectNode;

    /**
     * <p>
     * Represents the position.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * Represents the name.
     * </p>
     */
    private String name;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        objectNode = FailureTestHelper.createObjectNode();
        position = new Point();
        name = "Name";
    }

    /**
     * <p>
     * Failure test for <code>{@link EditNameEvent#EditNameEvent(ObjectNode, Point, String)}</code> constructor.
     * </p>
     */
    public void testEditNameEvent_NullObjectNode() {
        objectNode = null;

        assertEditNameEventCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link EditNameEvent#EditNameEvent(ObjectNode, Point, String)}</code> constructor.
     * </p>
     */
    public void testEditNameEvent_NullPosition() {
        position = null;

        assertEditNameEventCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link EditNameEvent#EditNameEvent(ObjectNode, Point, String)}</code> constructor.
     * </p>
     */
    public void testEditNameEvent_NullName() {
        name = null;

        assertEditNameEventCtor();
    }

    /**
     * <p>
     * Assert the constructor of <code>EditNameEvent</code>.
     * </p>
     */
    private void assertEditNameEventCtor() {
        try {
            new EditNameEvent(position, name, objectNode);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}