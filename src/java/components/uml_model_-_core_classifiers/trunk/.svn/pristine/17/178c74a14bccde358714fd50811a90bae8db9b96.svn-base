/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>Primitive</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrimitiveTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(PrimitiveTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>Primitive</code>.
     * <code>Primitive</code> should inherit from <code>DataType</code>.
     * </p>
     */
    public void testPrimitiveAccuracyInheritDataType() {
        assertTrue("Primitive should inherit from DataType", Primitive.class.getInterfaces()[0].equals(DataType.class));
    }
}
