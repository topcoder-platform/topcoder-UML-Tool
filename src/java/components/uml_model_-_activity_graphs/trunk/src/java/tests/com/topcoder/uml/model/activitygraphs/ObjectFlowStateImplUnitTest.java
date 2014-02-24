/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * <p>
 * Unit test cases for <code>ObjectFlowStateImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ObjectFlowStateImplUnitTest extends TestCase {
    /**
     * <p>
     * The ObjectFlowStateImpl instance to test against.
     * </p>
     */
    private ObjectFlowStateImpl state;

    /**
     * <p>
     * The Classifier instance used for testing.
     * </p>
     */
    private Classifier type;

    /**
     * <p>
     * Creates the ObjectFlowStateImpl instance for testing.
     * </p>
     */
    protected void setUp() {
        state = new ObjectFlowStateImpl();
        type = new ClassImpl();
    }

    /**
     * <p>
     * Tests the constructor -- <code>ObjectFlowStateImpl()</code>.
     * </p>
     *
     * <p>
     * Verifies an instance of the ObjectFlowStateImpl class could be
     * successfully created.
     * </p>
     */
    public void testObjectFlowStateImpl1() {
        assertNotNull("failed to instantiate ObjectFlowStateImpl.", state);
    }

    /**
     * <p>
     * Tests the constructor -- <code>ObjectFlowStateImpl(Classifier)</code>
     * with a non-null Classifier instance.
     * </p>
     *
     * <p>
     * Verifies an instance of the ObjectFlowStateImpl class could be
     * successfully created and the type is successfully set.
     * </p>
     */
    public void testObjectFlowStateImpl2() {
        ObjectFlowStateImpl stateImpl = new ObjectFlowStateImpl(type);
        assertNotNull("failed to instantiate ObjectFlowStateImpl.", stateImpl);
        assertEquals("the type was not correctly set", type, stateImpl
                .getType());
    }

    /**
     * <p>
     * Tests the constructor -- <code>ObjectFlowStateImpl(Classifier)</code>
     * with a null Classifier instance.
     * </p>
     *
     * <p>
     * Verifies null argument is allowed and an instance of the
     * ObjectFlowStateImpl class could be successfully created.
     * </p>
     */
    public void testObjectFlowStateImpl3() {
        try {
            ObjectFlowStateImpl stateImpl = new ObjectFlowStateImpl(null);
            assertNotNull("failed to instantiate ObjectFlowStateImpl.",
                    stateImpl);
            assertEquals("the type was not correctly set", null, stateImpl
                    .getType());
        } catch (Exception e) {
            fail("No exception should be thrown since null type is allowed.");
        }
    }

    /**
     * <p>
     * Tests the method -- <code>setSynch(boolean)</code>.
     * </p>
     *
     * <p>
     * Verifies the <code>isSynch</code> field in
     * <code>ObjectFlowStateImpl</code> class is correctly set.
     * </p>
     */
    public void testSetSynch() {
        state.setSynch(false);
        assertFalse("the isSynch field should have been set to false", state
                .isSynch());

        state.setSynch(true);
        assertTrue("the isSynch field should have been set to true", state
                .isSynch());
    }

    /**
     * <p>
     * Tests the method -- <code>isSynch()</code>.
     * </p>
     *
     * <p>
     * Verifies the value of the <code>isSynch</code> field in
     * <code>ObjectFlowStateImpl</code> class is correctly returned.
     * </p>
     */
    public void testIsSynch() {
        state.setSynch(false);
        assertFalse("should have returned false for the isSynch field", state
                .isSynch());

        state.setSynch(true);
        assertTrue("should have returned true for the isSynch field", state
                .isSynch());
    }

    /**
     * <p>
     * Tests the method -- <code>setType(Classifier)</code> with non-null
     * Classifier instances.
     * </p>
     *
     * <p>
     * Verifies the <code>type</code> field in
     * <code>ObjectFlowStateImpl</code> class is correctly set.
     * </p>
     */
    public void testSetType1() {
        state.setType(type);
        assertEquals("the type field was not set to the correct value", type,
                state.getType());

        // set to another type
        Classifier newType = new ClassImpl();
        state.setType(newType);
        assertEquals("the type field was not set to the correct value",
                newType, state.getType());
    }

    /**
     * <p>
     * Tests the method -- <code>setType(Classifier)</code> with a null
     * Classifier instance.
     * </p>
     *
     * <p>
     * Verifies no exception is thrown and the <code>type</code> field in
     * <code>ObjectFlowStateImpl</code> class is correctly set.
     * </p>
     */
    public void testSetType2() {
        try {
            state.setType(null);
            assertNull("the type field should have been set to null.", state
                    .getType());
        } catch (Exception e) {
            fail("No exception should be thrown since null type is allowed.");
        }
    }

    /**
     * <p>
     * Tests the method -- <code>getType()</code>.
     * </p>
     *
     * <p>
     * Verifies the value of the <code>type</code> field in
     * <code>ObjectFlowStateImpl</code> class is correctly returned.
     * </p>
     */
    public void testGetType() {
        state.setType(type);
        assertEquals("the returned type is incorrect", type, state.getType());

        // set to another type
        Classifier newType = new ClassImpl();
        state.setType(newType);
        assertEquals("the returned type is incorrect", newType, state.getType());
    }
}
