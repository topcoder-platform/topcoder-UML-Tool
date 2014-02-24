/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for EditControlHandler.
 * </p>
 *
 *<p>
 * Change for v1.1: The <code>EditControlHandler</code> in v1.1 implement the
 * <code>TextInputListener</code> interface.The testcase will test the new methods
 * in EditControlHandler.The tests for contructor are not changed.
 *</p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class EditControlHandlerTests extends TestCase {
    /**
     * <p>
     * EditControlHandler instance for testing.
     * </p>
     */
    private EditControlHandler handler;

    /**
     * <p>
     * ObjectNode instance for testing.
     * </p>
     */
    private ObjectNode node;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        node = TestHelper.createObjectNode();
        handler = new EditControlHandler(node);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        handler = null;
        node = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(EditControlHandlerTests.class);
    }

    /**
     * <p>
     * Tests ctor EditControlHandler#EditControlHandler(ObjectNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created EditControlHandler instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new EditControlHandler instance.", handler);
    }

    /**
     * <p>
     * Tests ctor EditControlHandler#EditControlHandler(ObjectNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     *
     * @since 1.1
     */
    public void testCtor_NullNode() {
        try {
            new EditControlHandler(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests EditControlHandler#textCancelled(TextInputEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects IllegalArgumentException.
     * </p>
     *
     * @since 1.1
     */
    public void testEditControlCancelled_NullEvent() {
        try {
            handler.textCancelled(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests EditControlHandler#textEntered(TextInputEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects IllegalArgumentException.
     * </p>
     */
    public void testEditControlEntered_NullEvent() {
        try {
            handler.textEntered(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests EditControlHandler#getNode() for accuracy.
     * </p>
     *
     * <p>
     * It verifies EditControlHandler#getNode() is correct.
     * </p>
     */
    public void testGetNode() {
        assertSame("Failed to get the node correctly.", node, handler.getNode());
    }

}
