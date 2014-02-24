/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.failuretests;

import com.topcoder.diagraminterchange.BezierPoint;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for BezierPoint class.
 *
 * @author iamajia
 * @version 1.0
 */
public class BezierPointFailureTest extends TestCase {
    /**
     * Represents a {@link BezierPoint} instance that is used in the test.
     */
    private BezierPoint bezierPoint = new BezierPoint();
    /**
     * Represents a control point that is used in the test.
     */
    private Point control = new Point();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(BezierPointFailureTest.class);
    }

    /**
     * Failure test of <code>addControl(Point control)</code> method.
     *
     * <p>
     * control is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddControl1FailureNullControl() throws Exception {
        try {
            bezierPoint.addControl(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addControl(Point control)</code> method.
     *
     * <p>
     * controls already contains 2 elements.
     * </p>
     *
     * <p>
     * Expect IllegalStateException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddControl1FailureControlsAlreadyContains2Elements() throws Exception {
        bezierPoint.addControl(control);
        bezierPoint.addControl(control);
        try {
            bezierPoint.addControl(control);
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addControl(int index, Point control)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddControl2FailureNegativeIndex() throws Exception {
        try {
            bezierPoint.addControl(-1, control);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addControl(int index, Point control)</code> method.
     *
     * <p>
     * index is greater than list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddControl2FailureIndexGreaterThanSize() throws Exception {
        try {
            bezierPoint.addControl(1, control);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addControl(int index, Point control)</code> method.
     *
     * <p>
     * control is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddControl2FailureNullControl() throws Exception {
        try {
            bezierPoint.addControl(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addControl(int index, Point control)</code> method.
     *
     * <p>
     * controls already contains 2 elements.
     * </p>
     *
     * <p>
     * Expect IllegalStateException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddControl2FailureControlsAlreadyContains2Elements() throws Exception {
        bezierPoint.addControl(0, control);
        bezierPoint.addControl(0, control);
        try {
            bezierPoint.addControl(0, control);
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>setControl(int index, Point control)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetControlFailureNegativeIndex() throws Exception {
        try {
            bezierPoint.setControl(-1, control);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setControl(int index, Point control)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetControlFailureIndexEqualToSize() throws Exception {
        try {
            bezierPoint.setControl(0, control);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setControl(int index, Point control)</code> method.
     *
     * <p>
     * control is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetControlFailureNullControl() throws Exception {
        bezierPoint.addControl(control);
        try {
            bezierPoint.setControl(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeControl(int index)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveControlFailureNegativeIndex() throws Exception {
        try {
            bezierPoint.removeControl(-1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeControl(int index)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveControlFailureIndexEqualToSize() throws Exception {
        try {
            bezierPoint.removeControl(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeControl(Point control)</code> method.
     *
     * <p>
     * control is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveControlFailureNullControl() throws Exception {
        try {
            bezierPoint.removeControl(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsControl(Point control)</code> method.
     *
     * <p>
     * control is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsControlFailureNullControl() throws Exception {
        try {
            bezierPoint.containsControl(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>indexOfControl(Point control)</code> method.
     *
     * <p>
     * control is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfControlFailureNullControl() throws Exception {
        try {
            bezierPoint.containsControl(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
