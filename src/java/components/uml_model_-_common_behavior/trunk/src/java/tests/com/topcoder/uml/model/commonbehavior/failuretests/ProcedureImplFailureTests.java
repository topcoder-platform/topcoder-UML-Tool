/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;

import junit.framework.TestCase;

/**
 * Failure tests for <code>ProcedureImpl</code>.
 *
 * @author mayi
 * @version 1.0
 */
public class ProcedureImplFailureTests extends TestCase {
    /**
     * A <code>ProcedureImpl</code> instance to test.
     */
    private ProcedureImpl procedure = null;

    /**
     * Create the procedure instance to test.
     */
    protected void setUp() throws Exception {
        procedure = new ProcedureImpl();
    }

    /**
     * Test <code>addStimulus</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimulus_Null() {
        try {
            procedure.addStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimuli_Null() {
        try {
            procedure.addStimuli((Collection<Stimulus>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addStimuli</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimuli_NullElement() {
        Collection<Stimulus> stimuli = new ArrayList<Stimulus>();
        stimuli.add(new StimulusImpl());
        stimuli.add(null);

        try {
            procedure.addStimuli(stimuli);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("stimuli collection shouldn't be changed.",
                    0, procedure.countStimuli());
        }
    }

    /**
     * Test <code>removeStimulus</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStimulus_Null() {
        try {
            procedure.removeStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStimuli_Null() {
        try {
            procedure.removeStimuli((Collection<Stimulus>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeStimuli</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStimuli_NullElement() {
        Stimulus stimulus = new StimulusImpl();
        procedure.addStimulus(stimulus);

        Collection<Stimulus> stimuli = new ArrayList<Stimulus>();
        stimuli.add(stimulus);
        stimuli.add(null);

        try {
            procedure.removeStimuli(stimuli);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("stimuli collection shouldn't be changed.",
                    1, procedure.countStimuli());
        }
    }

    /**
     * Test <code>containsStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsStimuli_Null() {
        try {
            procedure.containsStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

}
