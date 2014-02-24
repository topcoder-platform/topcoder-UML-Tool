/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>PrimitiveImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrimitiveImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private PrimitiveImpl primitiveImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(PrimitiveImplTest.class);

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        primitiveImpl = new PrimitiveImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        primitiveImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>PrimitiveImpl</code>.
     * <code>PrimitiveImpl</code> should inherit from <code>DataTypeImpl</code>.
     * </p>
     */
    public void testPrimitiveImplAccuracyInheritDataTypeImpl() {
        assertTrue("PrimitiveImpl should inherit from DataTypeImpl.", primitiveImpl instanceof DataTypeImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>PrimitiveImpl</code>.
     * <code>PrimitiveImpl</code> should inherit from <code>Primitive</code>.
     * </p>
     */
    public void testPrimitiveImplAccuracyInheritPrimitive() {
        assertTrue("PrimitiveImpl should inherit from Primitive.", primitiveImpl instanceof Primitive);
    }

    /**
     * <p>
     * Tests accuracy of <code>PrimitiveImpl()</code>.
     * Object should be created.
     * </p>
     */
    public void testPrimitiveImplAccuracy() {
        assertNotNull("Object should be created.", primitiveImpl);
    }
}
