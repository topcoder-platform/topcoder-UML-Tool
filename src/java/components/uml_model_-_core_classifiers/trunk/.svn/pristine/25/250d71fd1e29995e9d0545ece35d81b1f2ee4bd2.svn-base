/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>EnumerationImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private EnumerationImpl enumerationImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(EnumerationImplTest.class);
        suite.addTest(new CollectionVariableTest("dummy", EnumerationImpl.class, "Literal", "Literals",
                EnumerationLiteral.class, EnumerationLiteralImpl.class).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        enumerationImpl = new EnumerationImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        enumerationImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>EnumerationImpl</code>.
     * <code>EnumerationImpl</code> should inherit from <code>DataTypeImpl</code>.
     * </p>
     */
    public void testEnumerationImplAccuracyInheritDataTypeImpl() {
        assertTrue("EnumerationImpl should inherit from DataTypeImpl.", enumerationImpl instanceof DataTypeImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>EnumerationImpl</code>.
     * <code>EnumerationImpl</code> should inherit from <code>Enumeration</code>.
     * </p>
     */
    public void testEnumerationImplAccuracyInheritEnumeration() {
        assertTrue("EnumerationImpl should inherit from Enumeration.", enumerationImpl instanceof Enumeration);
    }

    /**
     * <p>
     * Tests accuracy of <code>EnumerationImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testEnumerationImplAccuracy() {
        assertEquals("Variable should be set correctly.", 0, enumerationImpl.getLiterals().size());
    }
}
