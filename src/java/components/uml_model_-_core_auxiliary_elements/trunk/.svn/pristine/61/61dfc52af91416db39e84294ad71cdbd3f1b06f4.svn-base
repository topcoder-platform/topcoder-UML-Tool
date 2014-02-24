/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements.stresstests;

import junit.framework.TestCase;
import static org.easymock.EasyMock.createMock;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;

/**
 * Stress tests for TemplateParameterImpl class.
 *
 * @author still
 * @version 1.0
 */
public class TemplateParameterImplStressTest extends TestCase {
    /** instance of TemplateParameterImpl used in this test.*/
    private TemplateParameterImpl instance;

    /**
     * Sets up the test environment.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        instance = new TemplateParameterImpl();
    }

    /**
     * Tests for <code>TemplateParameterImpl()</code> method.
     */
    public void testCreateTemplateParameterImpl() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            TemplateParameterImpl object = new TemplateParameterImpl();
            assertNotNull("failed to create a TemplateParameterImpl instance.", object);
            assertTrue("class TemplateParameterImpl should implement TemplateParameter interface.",
                object instanceof TemplateParameter);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Creating " + (StressTestHelper.RUN_TIMES)
            + " TemplateParameterImpl objects takes " + (endTime - startTime) + " ms.");
    }

    /**
     * Tests for <code>getTemplate()</code> and <code>setTemplate(ModelElement)</code> methods.
     */
    public void testTemplateOperation() {

        ModelElement testTemplate = createMock(ModelElement.class);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {

            instance.setTemplate(testTemplate);
            assertEquals("should be equal.", testTemplate, instance.getTemplate());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Do 'setTemplate' and 'getTemplate' operations of TemplateParameterImpl "
             + (StressTestHelper.RUN_TIMES) + " times takes " + (endTime - startTime) + " ms.");
    }

    /**
     * Tests for <code>getParameter()</code> and <code>setParameter(ModelElement)</code> methods.
     */
    public void testParameterOperation() {

        ModelElement testParameter = createMock(ModelElement.class);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            instance.setParameter(testParameter);
            assertEquals("should be equal.", testParameter, instance.getParameter());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Do 'setParameter' and 'getParameter' operations of TemplateParameterImpl "
            + (StressTestHelper.RUN_TIMES) + " times takes " + (endTime - startTime) + " ms.");
    }

    /**
     * Tests for <code>getDefaultElement()</code> and <code>setDefaultElement(ModelElement)</code> methods.
     */
    public void testDefaultElementOperation() {

        ModelElement testDefaultElement = createMock(ModelElement.class);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            instance.setDefaultElement(testDefaultElement);
            assertEquals("should be equal.", testDefaultElement, instance.getDefaultElement());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Do 'setDefaultElement' and 'getDefaultElement' operations of TemplateParameterImpl "
            + (StressTestHelper.RUN_TIMES) + " times takes " + (endTime - startTime) + " ms.");
    }
}
