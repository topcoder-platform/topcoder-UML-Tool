/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.Serializable;


/**
 * <p>
 * Unit test for <code>TemplateArgument</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TemplateArgumentTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(TemplateArgumentTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>TemplateArgument</code>.
     * <code>TemplateArgument</code> should inherit from <code>Serializable</code>.
     * </p>
     */
    public void testTemplateArgumentAccuracyInheritSerializable() {
        assertTrue("TemplateArgument should inherit from Serializable",
            TemplateArgument.class.getInterfaces()[0].equals(Serializable.class));
    }
}
