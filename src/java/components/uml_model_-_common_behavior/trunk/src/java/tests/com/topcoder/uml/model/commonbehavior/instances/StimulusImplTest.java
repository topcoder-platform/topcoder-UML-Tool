/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import com.topcoder.uml.model.commonbehavior.ValueVariableTest;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.Object;


/**
 * <p>
 * Unit test for <code>StimulusImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StimulusImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private StimulusImpl stimulusImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(StimulusImplTest.class);
        suite.addTest(new ValueVariableTest("dummy", StimulusImpl.class, "Receiver", Instance.class,
                new Object[] {null, new ObjectImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", StimulusImpl.class, "CommunicationLink", Link.class,
                new Object[] {null, new LinkImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", StimulusImpl.class, "Sender", Instance.class,
                new Object[] {null, new ObjectImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", StimulusImpl.class, "DispatchAction", Procedure.class,
                new Object[] {null, new ProcedureImpl()}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        stimulusImpl = new StimulusImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        stimulusImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>StimulusImpl</code>.
     * <code>StimulusImpl</code> should inherit from <code>ModelElementAbstractImpl</code>.
     * </p>
     */
    public void testStimulusImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("StimulusImpl should inherit from ModelElementAbstractImpl.",
            stimulusImpl instanceof ModelElementAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>StimulusImpl</code>.
     * <code>StimulusImpl</code> should inherit from <code>Stimulus</code>.
     * </p>
     */
    public void testStimulusImplAccuracyInheritStimulus() {
        assertTrue("StimulusImpl should inherit from Stimulus.", stimulusImpl instanceof Stimulus);
    }

    /**
     * <p>
     * Tests accuracy of <code>StimulusImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testStimulusImplAccuracy() {
        assertNull("Variable should be set correctly.", stimulusImpl.getReceiver());
        assertNull("Variable should be set correctly.", stimulusImpl.getCommunicationLink());
        assertNull("Variable should be set correctly.", stimulusImpl.getSender());
        assertNull("Variable should be set correctly.", stimulusImpl.getDispatchAction());
    }
}
