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
 * Unit test for <code>Interface</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InterfaceTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(InterfaceTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>Interface</code>.
     * <code>Interface</code> should inherit from <code>Classifier</code>.
     * </p>
     */
    public void testInterfaceAccuracyInheritClassifier() {
        assertTrue("Interface should inherit from Classifier",
            Interface.class.getInterfaces()[0].equals(Classifier.class));
    }
}
