/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>ObjectImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ObjectImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private ObjectImpl objectImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(ObjectImplTest.class);

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        objectImpl = new ObjectImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        objectImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>ObjectImpl</code>.
     * <code>ObjectImpl</code> should inherit from <code>InstanceAbstractImpl</code>.
     * </p>
     */
    public void testObjectImplAccuracyInheritInstanceAbstractImpl() {
        assertTrue("ObjectImpl should inherit from InstanceAbstractImpl.", objectImpl instanceof InstanceAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>ObjectImpl</code>.
     * <code>ObjectImpl</code> should inherit from <code>Object</code>.
     * </p>
     */
    public void testObjectImplAccuracyInheritObject() {
        assertTrue("ObjectImpl should inherit from Object.", objectImpl instanceof Object);
    }

    /**
     * <p>
     * Tests accuracy of <code>ObjectImpl()</code>.
     * Object should be created.
     * </p>
     */
    public void testObjectImplAccuracy() {
        assertNotNull("Object should be created.", objectImpl);
    }
}
