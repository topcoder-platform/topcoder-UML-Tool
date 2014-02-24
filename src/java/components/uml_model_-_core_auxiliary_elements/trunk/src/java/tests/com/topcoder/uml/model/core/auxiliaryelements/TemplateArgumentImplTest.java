/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.Binding;
import com.topcoder.uml.model.core.dependencies.BindingImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>TemplateArgumentImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TemplateArgumentImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private TemplateArgumentImpl templateArgumentImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(TemplateArgumentImplTest.class);
        suite.addTest(new ValueVariableTest("dummy", TemplateArgumentImpl.class, "ModelElement", ModelElement.class,
                new Object[] {null, new ModelImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", TemplateArgumentImpl.class, "Binding", Binding.class,
                new Object[] {null, new BindingImpl()}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        templateArgumentImpl = new TemplateArgumentImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        templateArgumentImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>TemplateArgumentImpl</code>.
     * <code>TemplateArgumentImpl</code> should inherit from <code>TemplateArgument</code>.
     * </p>
     */
    public void testTemplateArgumentImplAccuracyInheritTemplateArgument() {
        assertTrue("TemplateArgumentImpl should inherit from TemplateArgument.",
            templateArgumentImpl instanceof TemplateArgument);
    }

    /**
     * <p>
     * Tests accuracy of <code>TemplateArgumentImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testTemplateArgumentImplAccuracy() {
        assertNull("Variable should be set correctly.", templateArgumentImpl.getModelElement());
        assertNull("Variable should be set correctly.", templateArgumentImpl.getBinding());
    }
}
