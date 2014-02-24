/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ResizeEvent;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link ResizeEvent}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ResizeEventFailureTests extends TestCase {

    /**
     * <p>
     * Represents the <code>{@link ObjectNode}</code> instance.
     * </p>
     */
    private ObjectNode objectNode;

    /**
     * <p>
     * Represents the reason.
     * </p>
     */
    private String reason;

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
        reason = "Good Reason";
    }

    /**
     * <p>
     * Failure test for <code>{@link ResizeEvent#ResizeEvent(ObjectNode, String)}</code> constructor.
     * </p>
     */
    public void testResizeEvent_NullObject() {
        objectNode = null;
        assertConstruction();
    }

    /**
     * <p>
     * Failure test for <code>{@link ResizeEvent#ResizeEvent(ObjectNode, String)}</code> contructor.
     * </p>
     */
    public void testResizeEvent_NullReason() {
        reason = null;

        assertConstruction();
    }

    /**
     * <p>
     * Failure test for <code>{@link ResizeEvent#ResizeEvent(ObjectNode, String)}</code> contructor.
     * </p>
     */
    public void testResizeEvent_EmptyReason() {
        reason = "";

        assertConstruction();
    }

    /**
     * <p>
     * Failure test for <code>{@link ResizeEvent#ResizeEvent(ObjectNode, String)}</code> contructor.
     * </p>
     */
    public void testResizeEvent_TrimmedEmptyReason() {
        reason = "  ";

        assertConstruction();
    }

    /**
     * <p>
     * assert the constructor of <code>ResizeEvent</code>.
     * </p>
     */
    public void assertConstruction() {
        try {
            new ResizeEvent(objectNode, reason);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}