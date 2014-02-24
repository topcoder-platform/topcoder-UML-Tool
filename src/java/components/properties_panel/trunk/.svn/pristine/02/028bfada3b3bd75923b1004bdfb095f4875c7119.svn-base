/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for TransitionListItem.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TransitionListItemTests extends TestCase {
    /**
     * <p>
     * The TransitionListItem instance for testing.
     * </p>
     */
    private TransitionListItem item;

    /**
     * <p>
     * The Transition instance for testing.
     * </p>
     */
    private Transition transition;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        StateVertex source = new SimpleStateImpl();
        source.setName("source");
        StateVertex target = new SimpleStateImpl();
        target.setName("target");

        transition = new TransitionImpl();
        transition.setSource(source);
        transition.setTarget(target);

        item = new TransitionListItem(transition);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        item = null;
        transition = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TransitionListItemTests.class);
    }

    /**
     * <p>
     * Tests TransitionListItem#toString(Transition) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created TransitionListItem instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new TransitionListItem instance.", item);
    }

    /**
     * <p>
     * Tests ctor TransitionListItem#toString(Transition) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transition is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullTransition() {
        try {
            new TransitionListItem(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests TransitionListItem#toString() for accuracy.
     * </p>
     *
     * <p>
     * It verifies TransitionListItem#toString() is correct.
     * </p>
     */
    public void testToString() {
        assertEquals("Failed to get the value correctly.", "source->target", item.toString());
    }

    /**
     * <p>
     * Tests TransitionListItem#getTransition() for accuracy.
     * </p>
     *
     * <p>
     * It verifies TransitionListItem#getTransition() is correct.
     * </p>
     */
    public void testGetTransition() {
        assertSame("Failed to get the transition correctly.", this.transition, item.getTransition());
    }

}