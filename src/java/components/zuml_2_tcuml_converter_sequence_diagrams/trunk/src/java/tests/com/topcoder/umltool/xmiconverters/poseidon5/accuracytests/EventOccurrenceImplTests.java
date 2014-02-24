/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.core.ModelElement;

import com.topcoder.umltool.xmiconverters.poseidon5.model.EventOccurrence;
import com.topcoder.umltool.xmiconverters.poseidon5.model.ExecutionOccurrence;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.EventOccurrenceImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.ExecutionOccurrenceImpl;

import junit.framework.TestCase;

/**
 * Accuracy tests for <code>EventOccurrenceImpl</code>.
 *
 * @author RachaelLCook
 * @version 1.0
 */

public class EventOccurrenceImplTests extends TestCase {
    /**
     * <p>Testing of EventOccurrenceImpl constructor.</p>
     * <p>Class will be used in XMIReader. So it must implement ModelElement interface.</p>
     */
    public void test_Ctor() {
        EventOccurrenceImpl eo = new EventOccurrenceImpl();
        assertTrue("ModelElement interface is not implemented", eo instanceof ModelElement);
        // Initial properties values
        assertNull("'startExec' property is not null initially", eo.getStartExec());
        assertNull("'finishExec' property is not null initially", eo.getFinishExec());
    }

    /**
     * Testing of setStartExec method.
     */
    public void test_setStartExec() {
        EventOccurrence evo = new EventOccurrenceImpl();
        ExecutionOccurrence exo1 = new ExecutionOccurrenceImpl();
        evo.setStartExec(exo1);
        assertTrue("setStartExec failed to set the value", evo.getStartExec() == exo1);
        ExecutionOccurrence exo2 = new ExecutionOccurrenceImpl();
        evo.setStartExec(exo2);
        assertTrue("setStartExec failed to change the value", evo.getStartExec() == exo2);
        evo.setStartExec(null);
        assertNull("setStartExec failed to reset the value to null", evo.getStartExec());
    }

    /**
     * Testing of setFinishExec method.
     */
    public void test_setFinishExec() {
        EventOccurrence evo = new EventOccurrenceImpl();
        ExecutionOccurrence exo1 = new ExecutionOccurrenceImpl();
        evo.setFinishExec(exo1);
        assertTrue("setFinishExec failed to set the value", evo.getFinishExec() == exo1);
        ExecutionOccurrence exo2 = new ExecutionOccurrenceImpl();
        evo.setFinishExec(exo2);
        assertTrue("setFinishExec failed to change the value", evo.getFinishExec() == exo2);
        evo.setFinishExec(null);
        assertNull("setFinishExec failed to reset the value to null", evo.getFinishExec());
    }
}
