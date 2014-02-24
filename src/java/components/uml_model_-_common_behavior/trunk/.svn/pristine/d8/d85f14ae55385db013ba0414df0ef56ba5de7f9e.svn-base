/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.links;

import com.topcoder.uml.model.commonbehavior.CollectionVariableTest;
import com.topcoder.uml.model.commonbehavior.ValueVariableTest;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>LinkImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LinkImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private LinkImpl linkImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(LinkImplTest.class);
        suite.addTest(new CollectionVariableTest("dummy", LinkImpl.class, "Connection", "Connections", LinkEnd.class,
                LinkEndImpl.class).getSuite());
        suite.addTest(new CollectionVariableTest("dummy", LinkImpl.class, "Stimulus", "Stimuli", Stimulus.class,
                StimulusImpl.class).getSuite());
        suite.addTest(new ValueVariableTest("dummy", LinkImpl.class, "Owner", Instance.class,
                new Object[] {null, new ObjectImpl()}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        linkImpl = new LinkImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        linkImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>LinkImpl</code>.
     * <code>LinkImpl</code> should inherit from <code>ModelElementAbstractImpl</code>.
     * </p>
     */
    public void testLinkImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("LinkImpl should inherit from ModelElementAbstractImpl.",
            linkImpl instanceof ModelElementAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>LinkImpl</code>.
     * <code>LinkImpl</code> should inherit from <code>Link</code>.
     * </p>
     */
    public void testLinkImplAccuracyInheritLink() {
        assertTrue("LinkImpl should inherit from Link.", linkImpl instanceof Link);
    }

    /**
     * <p>
     * Tests accuracy of <code>LinkImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testLinkImplAccuracy() {
        assertEquals("Variable should be set correctly.", 0, linkImpl.getConnections().size());
        assertEquals("Variable should be set correctly.", 0, linkImpl.getStimuli().size());
        assertNull("Variable should be set correctly.", linkImpl.getOwner());
    }
}
