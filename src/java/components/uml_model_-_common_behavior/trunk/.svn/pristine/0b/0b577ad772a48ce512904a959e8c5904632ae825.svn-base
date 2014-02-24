/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.links;

import com.topcoder.uml.model.commonbehavior.ValueVariableTest;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>LinkEndImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LinkEndImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private LinkEndImpl linkEndImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(LinkEndImplTest.class);
        suite.addTest(new ValueVariableTest("dummy", LinkEndImpl.class, "Instance", Instance.class,
                new Object[] {null, new ObjectImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", LinkEndImpl.class, "Link", Link.class,
                new Object[] {null, new LinkImpl()}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        linkEndImpl = new LinkEndImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        linkEndImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>LinkEndImpl</code>.
     * <code>LinkEndImpl</code> should inherit from <code>ModelElementAbstractImpl</code>.
     * </p>
     */
    public void testLinkEndImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("LinkEndImpl should inherit from ModelElementAbstractImpl.",
            linkEndImpl instanceof ModelElementAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>LinkEndImpl</code>.
     * <code>LinkEndImpl</code> should inherit from <code>LinkEnd</code>.
     * </p>
     */
    public void testLinkEndImplAccuracyInheritLinkEnd() {
        assertTrue("LinkEndImpl should inherit from LinkEnd.", linkEndImpl instanceof LinkEnd);
    }

    /**
     * <p>
     * Tests accuracy of <code>LinkEndImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testLinkEndImplAccuracy() {
        assertNull("Variable should be set correctly.", linkEndImpl.getInstance());
        assertNull("Variable should be set correctly.", linkEndImpl.getLink());
    }
}
