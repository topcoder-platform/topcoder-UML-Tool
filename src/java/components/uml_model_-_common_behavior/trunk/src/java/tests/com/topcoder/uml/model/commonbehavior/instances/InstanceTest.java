/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import com.topcoder.uml.model.core.ModelElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>Instance</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InstanceTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(InstanceTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>Instance</code>.
     * <code>Instance</code> should inherit from <code>ModelElement</code>.
     * </p>
     */
    public void testInstanceAccuracyInheritModelElement() {
        assertTrue("Instance should inherit from ModelElement",
            Instance.class.getInterfaces()[0].equals(ModelElement.class));
    }
}
