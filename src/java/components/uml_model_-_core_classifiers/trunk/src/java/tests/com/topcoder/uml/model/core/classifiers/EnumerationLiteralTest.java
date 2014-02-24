/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.ModelElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>EnumerationLiteral</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationLiteralTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(EnumerationLiteralTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>EnumerationLiteral</code>.
     * <code>EnumerationLiteral</code> should inherit from <code>ModelElement</code>.
     * </p>
     */
    public void testEnumerationLiteralAccuracyInheritModelElement() {
        assertTrue("EnumerationLiteral should inherit from ModelElement",
            EnumerationLiteral.class.getInterfaces()[0].equals(ModelElement.class));
    }
}
