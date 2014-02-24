/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.activitygraphs.failuretests;

import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Test ObjectFlowStateImpl class.
 *
 * @author King_Bette
 *
 */
public class ObjectFlowStateImplTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private ObjectFlowStateImpl objectFlowState = new ObjectFlowStateImpl();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ObjectFlowStateImplTest.class);
    }

    /**
     * Test setSynch()/isSynch() methods.
     */
    public void testObjectFlowStateImplSynch() {
        assertFalse("isSynch default must be false.", objectFlowState.isSynch());
        objectFlowState.setSynch(false);
        assertFalse("isSynch now must be false.", objectFlowState.isSynch());
        objectFlowState.setSynch(true);
        assertTrue("isSynch now must be true.", objectFlowState.isSynch());
        objectFlowState.setSynch(false);
        assertFalse("isSynch now must be false.", objectFlowState.isSynch());
    }
}
