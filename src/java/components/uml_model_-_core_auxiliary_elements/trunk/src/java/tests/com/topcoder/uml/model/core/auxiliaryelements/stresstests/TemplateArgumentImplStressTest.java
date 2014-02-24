/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements.stresstests;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.dependencies.Binding;

import static org.easymock.EasyMock.createMock;

import junit.framework.TestCase;

/**
 * Stress tests for TemplateArgumentImpl class.
 *
 * @author still
 * @version 1.0
 */
public class TemplateArgumentImplStressTest extends TestCase {
    /** instance of TemplateArgumentImpl used in this test.*/
    private TemplateArgumentImpl instance;

    /**
     * Sets up the test environment.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        instance = new TemplateArgumentImpl();
    }

    /**
     * Tests for <code>TemplateArgumentImpl()</code> method.
     */
    public void testCreateTemplateArgumentImpl() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            TemplateArgumentImpl object = new TemplateArgumentImpl();
            assertNotNull("failed to create a TemplateArgumentImpl instance.", object);
            assertTrue("class TemplateArgumentImpl should implement TemplateArgument interface.",
                object instanceof TemplateArgument);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Creating " + (StressTestHelper.RUN_TIMES)
            + " TemplateParameterImpl objects takes " + (endTime - startTime) + " ms.");
    }

    /**
     * Tests for <code>getModelElement()</code> and <code>setModelElement(ModelElement)</code> methods.
     */
    public void testModelElementOperation() {

        ModelElement testModelElement = createMock(ModelElement.class);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            instance.setModelElement(testModelElement);
            assertEquals("should be equal.", testModelElement, instance.getModelElement());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Do 'setModelElement' and 'getModelElement' operations of TemplateArgumentImpl "
            + (StressTestHelper.RUN_TIMES) + " times takes " + (endTime - startTime) + " ms.");
    }

    /**
     * Tests for <code>getBinding()</code> and <code>setBinding(Binding)</code> methods.
     */
    public void testBindingOperation() {

        Binding testBinding = createMock(Binding.class);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            instance.setBinding(testBinding);
            assertEquals("should be equal.", testBinding, instance.getBinding());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Do 'setBinding' and 'getBinding' operations of TemplateArgumentImpl "
            + (StressTestHelper.RUN_TIMES) + " times takes " + (endTime - startTime) + " ms.");
    }
}
