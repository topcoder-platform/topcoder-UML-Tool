/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.failuretests;

import com.topcoder.diagraminterchange.DiagramElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for DiagramElement class.
 *
 * @author iamajia
 * @version 1.0
 */
public class DiagramElementFailureTest extends TestCase {
    /**
     * Represents a {@link DiagramElement} instance that is used in the test.
     */
    private DiagramElement diagramElement = new DiagramElement() {
    };
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DiagramElementFailureTest.class);
    }

    /**
     * Failure test of <code>addProperty(Property property)</code> method.
     *
     * <p>
     * property is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddPropertyFailureNullProperty() throws Exception {
        try {
            diagramElement.addProperty(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeProperty(Property property)</code> method.
     *
     * <p>
     * property is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemovePropertyFailureNullProperty() throws Exception {
        try {
            diagramElement.removeProperty(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsProperty(Property property)</code> method.
     *
     * <p>
     * property is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsPropertyFailureNullProperty() throws Exception {
        try {
            diagramElement.containsProperty(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addReference(Reference reference)</code> method.
     *
     * <p>
     * reference is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddReferenceFailureNullReference() throws Exception {
        try {
            diagramElement.addReference(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeReference(Reference reference)</code> method.
     *
     * <p>
     * reference is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveReferenceFailureNullReference() throws Exception {
        try {
            diagramElement.removeReference(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsReference(Reference reference)</code> method.
     *
     * <p>
     * reference is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsReferenceFailureNullReference() throws Exception {
        try {
            diagramElement.containsReference(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
