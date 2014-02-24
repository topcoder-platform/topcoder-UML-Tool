/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.Classifier;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>DataType</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DataTypeTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(DataTypeTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>DataType</code>.
     * <code>DataType</code> should inherit from <code>Classifier</code>.
     * </p>
     */
    public void testDataTypeAccuracyInheritClassifier() {
        assertTrue("DataType should inherit from Classifier",
            DataType.class.getInterfaces()[0].equals(Classifier.class));
    }
}
