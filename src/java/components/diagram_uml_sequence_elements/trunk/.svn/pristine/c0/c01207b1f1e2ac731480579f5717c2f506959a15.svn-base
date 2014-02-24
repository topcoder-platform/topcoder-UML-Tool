/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SetNameEvent;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link SetNameEvent}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class SetNameEventFailureTests extends TestCase {
    /**
     * <p>
     * Represents the <code>{@link ObjectNode}</code> instance.
     * </p>
     */
    private ObjectNode objectNode;

    /**
     * <p>
     * Represents the old name.
     * </p>
     */
    private String oldName;

    /**
     * <p>
     * Represents the new name.
     * </p>
     */
    private String newName;

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

        oldName = "Old Name";
        newName = "New Name";
    }

    /**
     * <p>
     * Failure test for <code>{@link SetNameEvent#SetNameEvent(String, String, ObjectNode)}</code> constructor.
     * </p>
     */
    public void testSetNameEvent_NullOldName() {
        oldName = null;
        assertSetNameEventCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SetNameEvent#SetNameEvent(String, String, ObjectNode)}</code> constructor.
     * </p>
     */
    public void testSetNameEvent_NullNewName() {
        newName = null;
        assertSetNameEventCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SetNameEvent#SetNameEvent(String, String, ObjectNode)}</code> constructor.
     * </p>
     */
    public void testSetNameEvent_NullObjectNode() {
        objectNode = null;
        assertSetNameEventCtor();
    }

    /**
     * <p>
     * assert the constructor of <code>{@link SetNameEvent}</code>.
     * </p>
     */
    private void assertSetNameEventCtor() {
        try {
            new SetNameEvent(oldName, newName, objectNode);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}