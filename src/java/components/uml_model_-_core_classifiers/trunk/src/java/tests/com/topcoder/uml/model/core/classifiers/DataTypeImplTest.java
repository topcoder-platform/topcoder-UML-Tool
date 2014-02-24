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
 * Unit test for <code>DataTypeImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DataTypeImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private DataTypeImpl dataTypeImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(DataTypeImplTest.class);

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        dataTypeImpl = new DataTypeImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        dataTypeImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>DataTypeImpl</code>.
     * <code>DataTypeImpl</code> should inherit from <code>ClassifierAbstractImpl</code>.
     * </p>
     */
    public void testDataTypeImplAccuracyInheritClassifierAbstractImpl() {
        assertTrue("DataTypeImpl should inherit from ClassifierAbstractImpl.",
            dataTypeImpl instanceof ClassifierAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>DataTypeImpl</code>.
     * <code>DataTypeImpl</code> should inherit from <code>DataType</code>.
     * </p>
     */
    public void testDataTypeImplAccuracyInheritDataType() {
        assertTrue("DataTypeImpl should inherit from DataType.", dataTypeImpl instanceof DataType);
    }

    /**
     * <p>
     * Tests accuracy of <code>DataTypeImpl()</code>.
     * Object should be created.
     * </p>
     */
    public void testDataTypeImplAccuracy() {
        assertNotNull("Object should be created.", dataTypeImpl);
    }
}
