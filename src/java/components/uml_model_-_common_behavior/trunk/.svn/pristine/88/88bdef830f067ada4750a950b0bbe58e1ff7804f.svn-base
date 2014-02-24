/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import com.topcoder.uml.model.commonbehavior.CollectionVariableTest;
import com.topcoder.uml.model.commonbehavior.ValueVariableTest;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.Object;


/**
 * <p>
 * Unit test for <code>InstanceAbstractImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InstanceAbstractImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private InstanceAbstractImpl instanceAbstractImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(InstanceAbstractImplTest.class);
        suite.addTest(new CollectionVariableTest("dummy", MockInstanceAbstractImpl.class, "ReceiveStimulus",
                "ReceiveStimuli", Stimulus.class, StimulusImpl.class).getSuite());
        suite.addTest(new CollectionVariableTest("dummy", MockInstanceAbstractImpl.class, "OwnedLink", "OwnedLinks",
                Link.class, LinkImpl.class).getSuite());
        suite.addTest(new ValueVariableTest("dummy", MockInstanceAbstractImpl.class, "Classifier", Classifier.class,
                new Object[] {null, new ActorImpl()}).getSuite());
        suite.addTest(new CollectionVariableTest("dummy", MockInstanceAbstractImpl.class, "SendStimulus",
                "SendStimuli", Stimulus.class, StimulusImpl.class).getSuite());
        suite.addTest(new CollectionVariableTest("dummy", MockInstanceAbstractImpl.class, "LinkEnd", "LinkEnds",
                LinkEnd.class, LinkEndImpl.class).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        instanceAbstractImpl = new MockInstanceAbstractImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        instanceAbstractImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>InstanceAbstractImpl</code>.
     * <code>InstanceAbstractImpl</code> should inherit from <code>ModelElementAbstractImpl</code>.
     * </p>
     */
    public void testInstanceAbstractImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("InstanceAbstractImpl should inherit from ModelElementAbstractImpl.",
            instanceAbstractImpl instanceof ModelElementAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>InstanceAbstractImpl</code>.
     * <code>InstanceAbstractImpl</code> should inherit from <code>Instance</code>.
     * </p>
     */
    public void testInstanceAbstractImplAccuracyInheritInstance() {
        assertTrue("InstanceAbstractImpl should inherit from Instance.", instanceAbstractImpl instanceof Instance);
    }

    /**
     * <p>
     * Tests accuracy of <code>InstanceAbstractImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testInstanceAbstractImplAccuracy() {
        assertEquals("Variable should be set correctly.", 0, instanceAbstractImpl.getReceiveStimuli().size());
        assertEquals("Variable should be set correctly.", 0, instanceAbstractImpl.getOwnedLinks().size());
        assertNull("Variable should be set correctly.", instanceAbstractImpl.getClassifier());
        assertEquals("Variable should be set correctly.", 0, instanceAbstractImpl.getSendStimuli().size());
        assertEquals("Variable should be set correctly.", 0, instanceAbstractImpl.getLinkEnds().size());
    }
}
