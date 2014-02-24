/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.stresstests;

import junit.framework.TestCase;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;

/**
 * This is the stress tests for <code>ProcedureImpl</code> class.
 *
 * @author KKD
 * @version 1.0
 */
public class ProcedureImplStressTests extends TestCase {
    /**
     * <p>
     * An instance of <code>ProcedureImpl</code> which is tested.
     * </p>
     */
    private ProcedureImpl target = null;

    /**
     * <p>
     * setUp() routine. Creates test ProcedureImpl instance using
     * <code>ProcedureImpl()</code>.
     * </p>
     */
    protected void setUp() {
        target = new ProcedureImpl();
    }

    /**
     * <p>
     * Stress test. Tests the <code>addStimulus(Stimulus)</code> for proper
     * behavior.
     * </p>
     *
     * <pre>
     *    -------------------------aim-------------------------------
     *    test that this method works at extreme load.
     *    -------------------------input-----------------------------
     *    1000 Stimuli is added
     *    -------------------------output----------------------------
     *    1000 Stimuli added correctly.
     * </pre>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testAddStimulus_1_stress() throws Exception {
        final int load = 1000;
        Stimulus stimulus = new StimulusImpl();
        System.out
                .println("----- Start testing ProcedureImpl#addStimulus(Stimulus) -----");
        long start = System.currentTimeMillis();
        for (int i = 0; i < load - 1; i++) {
            target.addStimulus(new StimulusImpl());
        }
        target.addStimulus(stimulus);
        long end = System.currentTimeMillis();
        System.out.println("----- Add " + load + " Stimuli to Instance taking "
                + (end - start) + " ms -----");
        assertTrue("Stimulus should be added correctly.", target
                .containsStimulus(stimulus));
        assertEquals(load + " should be added.", load, target.countStimuli());
    }
}
