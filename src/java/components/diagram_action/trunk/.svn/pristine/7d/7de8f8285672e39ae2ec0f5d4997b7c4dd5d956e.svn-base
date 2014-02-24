/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.actions.diagram.failuretests.FailureTestHelper;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link CreateDiagramAction} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class CreateDiagramActionFailureTest extends TestCase {

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
        return new TestSuite(CreateDiagramActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link CreateDiagramAction#CreateDiagramAction(String, Element, String)} constructor.
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
    public void testFailureCreateDiagramAction() throws Exception {
        System.setProperty("throwException", "ProjectConfigurationException");
        try {
            new MockCreateDiagramAction("type", new ClassImpl(), "name");
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            // as expected
        } finally {
            System.clearProperty("throwException");
        }
    }

    /**
     * <p>
     * Tests the {@link CreateDiagramAction#CreateDiagramAction(String, Element, String)} constructor with
     * type as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureCreateDiagramAction1() throws Exception {
        try {
            new MockCreateDiagramAction(null, new ClassImpl(), "name");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link CreateDiagramAction#CreateDiagramAction(String, Element, String)} constructor with
     * type as Empty string.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureCreateDiagramAction2() throws Exception {
        try {
            new MockCreateDiagramAction("", new ClassImpl(), "name");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link CreateDiagramAction#CreateDiagramAction(String, Element, String)} constructor with
     * type as Empty string with only spaces.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureCreateDiagramAction3() throws Exception {
        try {
            new MockCreateDiagramAction("  ", new ClassImpl(), "name");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
