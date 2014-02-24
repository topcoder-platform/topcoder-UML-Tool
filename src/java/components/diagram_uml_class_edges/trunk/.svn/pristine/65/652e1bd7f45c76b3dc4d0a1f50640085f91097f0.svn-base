/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Point;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>NoArrow</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class NoArrowUnitTests extends TestCase {

    /** <code>NoArrow</code> instance used for testing. */
    private NoArrow edgeEnding;

    /** <code>TextField</code> instance representing name compartment. */
    private TextField name;

    /** <code>TextField</code> instance representing multiplicity compartment. */
    private TextField multiplicity;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        name = UnitTestsHelper.createTextFiled("name");
        multiplicity = UnitTestsHelper.createTextFiled("1..n");
        edgeEnding = new NoArrow(name, multiplicity);
        edgeEnding.setAngle(Math.toRadians(90));
        edgeEnding.setEndingPoint(new Point(20, 20));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        name = null;
        multiplicity = null;
        edgeEnding = null;
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>name</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullName() {
        try {
            new NoArrow(null, multiplicity);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>multiplicity</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullMultiplicity() {
        try {
            new NoArrow(name, null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of constructor .
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Should create the instance successfully.", edgeEnding);
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With the three vertex of triangle.
     * Should return true.
     * </p>
     */
    public void testContainsIn_Vertex() {
        assertTrue("Should return true.", edgeEnding.contains(20, 20));
        assertTrue("Should return true.", edgeEnding.contains(20, 10));
        assertTrue("Should return true.", edgeEnding.contains(25, 20));
        assertTrue("Should return true.", edgeEnding.contains(25, 10));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With points in bound.
     * Should return true.
     * </p>
     */
    public void testContainsIn_InBound() {
        assertTrue("Should return true.", edgeEnding.contains(22, 20));
        assertTrue("Should return true.", edgeEnding.contains(20, 15));
        assertTrue("Should return true.", edgeEnding.contains(21, 10));
        assertTrue("Should return true.", edgeEnding.contains(25, 15));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With points in side.
     * Should return true.
     * </p>
     */
    public void testContainsIn_InSide() {
        assertTrue("Should return true.", edgeEnding.contains(23, 16));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With point not contains in.
     * Should return false.
     * </p>
     */
    public void testContainsIn_Out() {
        assertFalse("Should return false.", edgeEnding.contains(18, 16));
        assertFalse("Should return false.", edgeEnding.contains(26, 16));
        assertFalse("Should return false.", edgeEnding.contains(22, 8));
        assertFalse("Should return false.", edgeEnding.contains(19, 28));
    }

}
