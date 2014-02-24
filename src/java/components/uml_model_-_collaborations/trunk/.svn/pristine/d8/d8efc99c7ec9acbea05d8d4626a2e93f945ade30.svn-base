/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.collaborations.stresstests;

import com.topcoder.uml.model.collaborations.collaborationroles.Message;
import com.topcoder.uml.model.collaborations.collaborationroles.MessageImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.MockStimulus;

import junit.framework.TestCase;

/**
 * This class will test <code>MessageImpl</code> class under large scale situation.
 *
 * @author slion
 * @version 1.0
 */
public class StressTestMessageImpl extends TestCase {
    /**
     * Represents the scale of processing the operation.
     */
    private static final int TOTAL_ITERATION = 10000;

    /**
     * Represents the Message instance for testing.
     */
    private Message message = null;

    /**
     * Set up environment.
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        message = new MessageImpl();
    }

    /**
     * Tear down.
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        message = null;
    }

    /**
     * Test for creating instances under large scale.
     * @throws Exception to JUnit.
     */
    public void testCtorLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertNotNull("Fail to create MessageImpl instance.",
                    new MessageImpl());
        }
        System.out.println("Creating " + TOTAL_ITERATION + " MessageImpl instances"
                + " with the first constructor costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling setConformingStimulus(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testSetConformingStimulusLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Stimulus stimulus = new MockStimulus();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            message.setConformingStimulus(stimulus);
        }
        System.out.println("Calling " + TOTAL_ITERATION + "times setConformingStimulus method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling GetConformingStimulus() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testGetConformingStimulusLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Stimulus stimulus = new MockStimulus();
        message.setConformingStimulus(stimulus);
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            message.getConformingStimulus();
        }
        System.out.println("Calling " + TOTAL_ITERATION + "times getConformingStimulus method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }
}
