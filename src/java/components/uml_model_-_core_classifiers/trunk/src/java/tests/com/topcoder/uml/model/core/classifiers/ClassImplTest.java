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
 * Unit test for <code>ClassImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private ClassImpl classImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(ClassImplTest.class);
        suite.addTest(new ValueVariableTest("dummy", ClassImpl.class, "Active", boolean.class,
                new Object[] {false, true}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        classImpl = new ClassImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        classImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>ClassImpl</code>.
     * <code>ClassImpl</code> should inherit from <code>ClassifierAbstractImpl</code>.
     * </p>
     */
    public void testClassImplAccuracyInheritClassifierAbstractImpl() {
        assertTrue("ClassImpl should inherit from ClassifierAbstractImpl.",
            classImpl instanceof ClassifierAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>ClassImpl</code>.
     * <code>ClassImpl</code> should inherit from <code>Class</code>.
     * </p>
     */
    public void testClassImplAccuracyInheritClass() {
        assertTrue("ClassImpl should inherit from Class.", classImpl instanceof Class);
    }

    /**
     * <p>
     * Tests accuracy of <code>ClassImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testClassImplAccuracy() {
        assertFalse("Variable should be set correctly.", classImpl.isActive());
    }
}
