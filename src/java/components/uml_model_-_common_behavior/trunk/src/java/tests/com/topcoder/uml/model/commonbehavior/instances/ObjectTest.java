/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>Object</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ObjectTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(ObjectTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>Object</code>.
     * <code>Object</code> should inherit from <code>Instance</code>.
     * </p>
     */
    public void testObjectAccuracyInheritInstance() {
        assertTrue("Object should inherit from Instance", Object.class.getInterfaces()[0].equals(Instance.class));
    }
}
