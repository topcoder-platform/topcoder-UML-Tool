/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.activitygraphs.accuracytests;

import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

import junit.framework.TestCase;


/**
 * Accuracy test for ObjectFlowStateImpl class.
 * @author waits
 * @version 1.0
 */
public class ObjectFlowStateImplAccTests extends TestCase {
    /** This instance is used in the test. */
    private boolean isSynch;

    /** This instance is used in the test. */
    private ObjectFlowStateImpl objectFlowStateImpl = null;

    /**
     * SetUp for each test: initialize the fields.
     */
    protected void setUp() {
      isSynch = true;
        this.objectFlowStateImpl = new ObjectFlowStateImpl();
    }

    /**
     * Test for ObjectFlowStateImpl, constructor ObjectFlowStateImpl(). It tests that the super() is correctly
     * called.
     */
    public void testObjectFlowStateImplConstructor1() {
        ObjectFlowStateImpl objectFlowStateImpl1 = new ObjectFlowStateImpl();
        assertTrue("the ctor of ActionStateImpl works incorrectly.", objectFlowStateImpl1 instanceof SimpleStateImpl);
        assertEquals("the ctor of ActionStateImpl works incorrectly.", null, objectFlowStateImpl1.getType());
        assertEquals("the ctor of ActionStateImpl works incorrectly.", false, objectFlowStateImpl1.isSynch());
    }

    /**
     * Test for ObjectFlowStateImpl, constructor ObjectFlowStateImpl(Classifier type). It tests whether the field
     * type is set correctly.
     */
    public void testObjectFlowStateImplConstructor2() {
        // check whether null is accepted
        objectFlowStateImpl = new ObjectFlowStateImpl(null);
        assertTrue("the ctor of ActionStateImpl works incorrectly.", objectFlowStateImpl instanceof SimpleStateImpl);
        assertEquals("the ctor of ActionStateImpl works incorrectly.", null, objectFlowStateImpl.getType());
        assertEquals("the ctor of ActionStateImpl works incorrectly.", false, objectFlowStateImpl.isSynch());
    }

    /**
     * Accuracy test of <code>setSynch(boolean isSynch)</code> method.
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testSetSynchAccuracy() throws Exception {
        // accuracy test when isSynch is false
        isSynch = false;
        objectFlowStateImpl.setSynch(isSynch);
        assertEquals("the setSynch method works incorrectly.", isSynch, objectFlowStateImpl.isSynch());

        // accuracy test when isSynch is true
        isSynch = true;
        objectFlowStateImpl.setSynch(isSynch);
        assertEquals("the setSynch method works incorrectly.", isSynch, objectFlowStateImpl.isSynch());
    }

    /**
     * Accuracy test of <code>isSynch()</code> method.
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testIsSynchAccuracy() throws Exception {
        // accuracy test when isSynch is false
        objectFlowStateImpl.setSynch(true);
        assertEquals("the isSynch method works incorrectly.", true, objectFlowStateImpl.isSynch());

        // accuracy test when isSynch is true
        objectFlowStateImpl.setSynch(false);
        assertEquals("the isSynch method works incorrectly.", false, objectFlowStateImpl.isSynch());
    }

    /**
     * Accuracy test of <code>setType(Classifier type)</code> method.
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testSetTypeAccuracy() throws Exception {
        // accuracy test when type is null
        objectFlowStateImpl.setType(null);
        assertEquals("the setType method works incorrectly.", null, objectFlowStateImpl.getType());
    }

    /**
     * Accuracy test of <code>getType()</code> method.
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testGetTypeAccuracy() throws Exception {
        // accuracy test when type is null
        objectFlowStateImpl.setType(null);
        assertEquals("the getType method works incorrectly.", null, objectFlowStateImpl.getType());
    }
}
