/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.datatypes.PseudostateKind;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <c>PseudostateImpl</c>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class PseudostateImplUnitTests extends TestCase {

    /**
     * Represent the instance of <c>PseudostateImpl</c> used for test.
     */
    private PseudostateImpl pseudostate;

    /**
     * Represent the instance of <c>PseudostateKind</c> used for test.
     */
    private PseudostateKind testKind = PseudostateKind.JOIN;

    /**
     * Represent the instance of <c>PseudostateKind</c> used for test.
     */
    private CompositeState testContainer = new CompositeStateImpl();

    /**
     * Represent the instance of <c>Collection</c> used for test.
     */
    private Collection<Transition> testTransitions = new ArrayList<Transition>();

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *             if any error occurs when set up
     */
    protected void setUp() throws Exception {
        pseudostate = new PseudostateImpl();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>PseudostateImpl()</code>. The instance of <code>PseudostateImpl</code>
     * should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of PseudostateImpl should be created", new PseudostateImpl());
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>PseudostateImpl(CompositeState,Collection,Collection,PseudostateKind)</code>. The instance of
     * <code>PseudostateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy1() {
        assertNotNull("instance of PseudostateImpl should be created", new PseudostateImpl(testContainer,
                testTransitions, testTransitions, testKind));
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>PseudostateImpl(CompositeState,Collection,Collection,PseudostateKind)</code> with null testContainer, The
     * instance of <code>PseudostateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy2() {
        assertNotNull("instance of PseudostateImpl should be created", new PseudostateImpl(null, testTransitions,
                testTransitions, testKind));
    }

    /**
     * <p>
     * Test the constructor <code>PseudostateImpl(CompositeState,Collection,Collection,PseudostateKind)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions() {
        try {
            new PseudostateImpl(testContainer, null, testTransitions, testKind);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>PseudostateImpl(CompositeState,Collection,Collection,PseudostateKind)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull() {
        try {
            testTransitions.add(null);
            new PseudostateImpl(testContainer, testTransitions, new ArrayList<Transition>(), testKind);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>PseudostateImpl(CompositeState,Collection,Collection,PseudostateKind)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions2() {
        try {
            new PseudostateImpl(testContainer, testTransitions, null, testKind);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>PseudostateImpl(CompositeState,Collection,Collection,PseudostateKind)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull2() {
        try {
            testTransitions.add(null);
            new PseudostateImpl(testContainer, new ArrayList<Transition>(), testTransitions, testKind);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setKind</code> with null, the <c>kind</c> field should be set correctly.
     * </p>
     */
    public void testSetKindAccuracyWithNull() {
        try {
            pseudostate.setKind(null);
            assertNull("The kind field should be set correctly", pseudostate.getKind());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setKind</code>, the <c>kind</c> field should be set correctly.
     * </p>
     */
    public void testSetKindAccuracy() {
        try {
            pseudostate.setKind(testKind);
            assertEquals("The kind field should be set correctly", testKind, pseudostate.getKind());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getKind</code>, the <c>kind</c> field should be returned correctly.
     * </p>
     */
    public void testGetKindAccuracy() {
        try {
            pseudostate.setKind(testKind);
            assertEquals("The kind field should be returned correctly", testKind, pseudostate.getKind());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
