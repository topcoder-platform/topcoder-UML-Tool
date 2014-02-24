/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>EnumerationLiteralImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationLiteralImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private EnumerationLiteralImpl enumerationLiteralImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(EnumerationLiteralImplTest.class);
        suite.addTest(new ValueVariableTest("dummy", EnumerationLiteralImpl.class, "Enumeration", Enumeration.class,
                new Object[] {null, new EnumerationImpl()}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        enumerationLiteralImpl = new EnumerationLiteralImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        enumerationLiteralImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>EnumerationLiteralImpl</code>.
     * <code>EnumerationLiteralImpl</code> should inherit from <code>ModelElementAbstractImpl</code>.
     * </p>
     */
    public void testEnumerationLiteralImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("EnumerationLiteralImpl should inherit from ModelElementAbstractImpl.",
            enumerationLiteralImpl instanceof ModelElementAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>EnumerationLiteralImpl</code>.
     * <code>EnumerationLiteralImpl</code> should inherit from <code>EnumerationLiteral</code>.
     * </p>
     */
    public void testEnumerationLiteralImplAccuracyInheritEnumerationLiteral() {
        assertTrue("EnumerationLiteralImpl should inherit from EnumerationLiteral.",
            enumerationLiteralImpl instanceof EnumerationLiteral);
    }

    /**
     * <p>
     * Tests accuracy of <code>EnumerationLiteralImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testEnumerationLiteralImplAccuracy() {
        assertNull("Variable should be set correctly.", enumerationLiteralImpl.getEnumeration());
    }
}
