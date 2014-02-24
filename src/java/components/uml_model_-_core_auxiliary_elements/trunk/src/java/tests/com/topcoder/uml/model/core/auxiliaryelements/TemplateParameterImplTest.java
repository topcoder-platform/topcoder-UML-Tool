/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>TemplateParameterImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TemplateParameterImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private TemplateParameterImpl templateParameterImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(TemplateParameterImplTest.class);
        suite.addTest(new ValueVariableTest("dummy", TemplateParameterImpl.class, "Template", ModelElement.class,
                new Object[] {null, new ModelImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", TemplateParameterImpl.class, "DefaultElement",
                ModelElement.class, new Object[] {null, new ModelImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", TemplateParameterImpl.class, "Parameter", ModelElement.class,
                new Object[] {null, new ModelImpl()}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        templateParameterImpl = new TemplateParameterImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        templateParameterImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>TemplateParameterImpl</code>.
     * <code>TemplateParameterImpl</code> should inherit from <code>TemplateParameter</code>.
     * </p>
     */
    public void testTemplateParameterImplAccuracyInheritTemplateParameter() {
        assertTrue("TemplateParameterImpl should inherit from TemplateParameter.",
            templateParameterImpl instanceof TemplateParameter);
    }

    /**
     * <p>
     * Tests accuracy of <code>TemplateParameterImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testTemplateParameterImplAccuracy() {
        assertNull("Variable should be set correctly.", templateParameterImpl.getTemplate());
        assertNull("Variable should be set correctly.", templateParameterImpl.getDefaultElement());
        assertNull("Variable should be set correctly.", templateParameterImpl.getParameter());
    }
}
