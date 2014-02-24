/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.actions.diagram.CreateClassDiagramAction;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link CreateClassDiagramAction} class.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class CreateClassDiagramActionFailureTest extends TestCase {
    
    /**
     * <p>
     * Sets up the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        FailureTestHelper.setUp();
    }

    /**
     * <p>
     * Tears down the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.tearDown();
    }
    
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CreateClassDiagramActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the  {@link CreateClassDiagramAction#CreateClassDiagramAction(Element, String)} constructor.
     * </p>
     * <p>
     * Checks whether IllegalStateException is thrown if the diagram cannot be formatted.
     * </p>
     * <p>
     * {@link IllegalStateException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureCreateClassDiagramAction() throws Exception {
        try {
            UMLModelManager.getInstance().setProjectLanguage(null);
            new CreateClassDiagramAction(new ClassImpl(), "test");
            fail("IllegalStateException Expected.");
        } catch (IllegalStateException e) {
            //As expected.
        }
    }
}
