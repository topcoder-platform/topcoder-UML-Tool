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
 * Unit test for <code>Class</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(ClassTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>Class</code>.
     * <code>Class</code> should inherit from <code>Classifier</code>.
     * </p>
     */
    public void testClassAccuracyInheritClassifier() {
        assertTrue("Class should inherit from Classifier", Class.class.getInterfaces()[0].equals(Classifier.class));
    }
}
