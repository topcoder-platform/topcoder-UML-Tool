/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>Enumeration</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(EnumerationTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>Enumeration</code>.
     * <code>Enumeration</code> should inherit from <code>DataType</code>.
     * </p>
     */
    public void testEnumerationAccuracyInheritDataType() {
        assertTrue("Enumeration should inherit from DataType",
            Enumeration.class.getInterfaces()[0].equals(DataType.class));
    }
}
