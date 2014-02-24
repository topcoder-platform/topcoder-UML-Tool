/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import com.topcoder.umltool.xmiconverters.poseidon5.model.EventOccurrence;
import com.topcoder.umltool.xmiconverters.poseidon5.model.ExecutionOccurrence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>EventOccurrenceImpl</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class EventOccurrenceImplUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(EventOccurrenceImplUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>EventOccurrenceImpl()</code>.
     * </p>
     */
    public void testCtor() {
        EventOccurrence eo = new EventOccurrenceImpl();
        assertNotNull("Unable to create EventOccurrenceImpl class.", eo);
    }

    /**
     * <p>
     * Accuracy test for <code>getStartExec(ExecutionOccurrence)</code>.
     * </p>
     */
    public void testGetStartExec() {
        EventOccurrence eo = new EventOccurrenceImpl();

        ExecutionOccurrence exec = eo.getStartExec();
        assertNull("The startExec is initialized as null.", exec);

        exec = new ExecutionOccurrenceImpl();
        eo.setStartExec(exec);

        assertEquals("The startExec should match.", exec, eo.getStartExec());
    }

    /**
     * <p>
     * Accuracy test for <code>setStartExec(ExecutionOccurrence)</code>.
     * </p>
     */
    public void testSetStartExec() {
        EventOccurrence eo = new EventOccurrenceImpl();

        ExecutionOccurrence exec = new ExecutionOccurrenceImpl();
        eo.setStartExec(exec);
        assertEquals("The startExec should match.", exec, eo.getStartExec());

        eo.setStartExec(null);
        assertNull("The startExec should be null.", eo.getStartExec());
    }

    /**
     * <p>
     * Accuracy test for <code>getFinishExec(ExecutionOccurrence)</code>.
     * </p>
     */
    public void testGetFinishExec() {
        EventOccurrence eo = new EventOccurrenceImpl();

        ExecutionOccurrence exec = eo.getFinishExec();
        assertNull("The finishExec is initialized as null.", exec);

        exec = new ExecutionOccurrenceImpl();
        eo.setFinishExec(exec);

        assertEquals("The finishExec should match.", exec, eo.getFinishExec());
    }

    /**
     * <p>
     * Accuracy test for <code>setFinishExec(ExecutionOccurrence)</code>.
     * </p>
     */
    public void testSetFinishExec() {
        EventOccurrence eo = new EventOccurrenceImpl();

        ExecutionOccurrence exec = new ExecutionOccurrenceImpl();
        eo.setFinishExec(exec);
        assertEquals("The finishExec should match.", exec, eo.getFinishExec());

        eo.setFinishExec(null);
        assertNull("The finishExec should be null.", eo.getFinishExec());
    }
}
