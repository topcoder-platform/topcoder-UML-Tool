/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>InterfaceImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InterfaceImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private InterfaceImpl interfaceImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(InterfaceImplTest.class);

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        interfaceImpl = new InterfaceImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        interfaceImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>InterfaceImpl</code>.
     * <code>InterfaceImpl</code> should inherit from <code>ClassifierAbstractImpl</code>.
     * </p>
     */
    public void testInterfaceImplAccuracyInheritClassifierAbstractImpl() {
        assertTrue("InterfaceImpl should inherit from ClassifierAbstractImpl.",
            interfaceImpl instanceof ClassifierAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>InterfaceImpl</code>.
     * <code>InterfaceImpl</code> should inherit from <code>Interface</code>.
     * </p>
     */
    public void testInterfaceImplAccuracyInheritInterface() {
        assertTrue("InterfaceImpl should inherit from Interface.", interfaceImpl instanceof Interface);
    }

    /**
     * <p>
     * Tests accuracy of <code>InterfaceImpl()</code>.
     * Object should be created.
     * </p>
     */
    public void testInterfaceImplAccuracy() {
        assertNotNull("Object should be created.", interfaceImpl);
    }
}
