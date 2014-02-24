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
 * Unit test for <code>TemplateParameter</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TemplateParameterTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(TemplateParameterTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>TemplateParameter</code>.
     * <code>TemplateParameter</code> should inherit from <code>Serializable</code>.
     * </p>
     */
    public void testTemplateParameterAccuracyInheritSerializable() {
        assertTrue("TemplateParameter should inherit from Serializable",
            TemplateParameter.class.getInterfaces()[0].equals(Serializable.class));
    }
}
