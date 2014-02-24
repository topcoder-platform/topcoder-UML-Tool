/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>CompositionBiDirectional</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class CompositionBiDirectionalUnitTests extends TestCase {

    /** <code>CompositionBiDirectional</code> instance used for testing. */
    private CompositionBiDirectional edgeEnding;

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
        edgeEnding = new CompositionBiDirectional(name, multiplicity);
        edgeEnding.setAngle(0);
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
            new CompositionBiDirectional(null, multiplicity);
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
            new CompositionBiDirectional(name, null);
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
     * Accuracy test of method <code>paintComponent(Graphics)</code>.
     * With null <code>g</code>.
     * Should return directly.
     * </p>
     */
    public void testPaintComponent_NullGraphics() {
        edgeEnding.paintComponent(null);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>paintComponent(Graphics)</code>.
     * With not null <code>g</code>.
     * Should paint the component.
     * </p>
     */
    public void testPaintComponent_NotNullGraphics() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Graphics g = frame.getGraphics();

        frame.add(edgeEnding);

        edgeEnding.paintComponent(g);

        frame.setVisible(false);
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
        assertTrue("Should return true.", edgeEnding.contains(10, 30));
        assertTrue("Should return true.", edgeEnding.contains(0, 20));
        assertTrue("Should return true.", edgeEnding.contains(10, 10));
        assertTrue("Should return true.", edgeEnding.contains(-10, 30));
        assertTrue("Should return true.", edgeEnding.contains(-10, 10));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With points in bound.
     * Should return true.
     * </p>
     */
    public void testContainsIn_InBound() {
        assertTrue("Should return true.", edgeEnding.contains(5, 15));
        assertTrue("Should return true.", edgeEnding.contains(5, 25));
        assertTrue("Should return true.", edgeEnding.contains(15, 15));
        assertTrue("Should return true.", edgeEnding.contains(15, 25));
        assertTrue("Should return true.", edgeEnding.contains(-5, 15));
        assertTrue("Should return true.", edgeEnding.contains(-5, 25));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With points in side.
     * Should return true.
     * </p>
     */
    public void testContainsIn_InSide() {
        assertTrue("Should return true.", edgeEnding.contains(10, 20));
        assertTrue("Should return true.", edgeEnding.contains(-5, 20));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With point not contains in.
     * Should return false.
     * </p>
     */
    public void testContainsIn_Out() {
        assertFalse("Should return false.", edgeEnding.contains(0, 18));
        assertFalse("Should return false.", edgeEnding.contains(0, 22));
        assertFalse("Should return false.", edgeEnding.contains(18, 28));
        assertFalse("Should return false.", edgeEnding.contains(15, 12));
        assertFalse("Should return false.", edgeEnding.contains(-12, 20));
        assertFalse("Should return false.", edgeEnding.contains(-5, 28));
        assertFalse("Should return false.", edgeEnding.contains(-5, 10));
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        // create the CompositionBiDirectional instance
        CompositionBiDirectional edgeEnding = UnitTestsHelper.createCompositionBiDirectional();
        edgeEnding.setBorder(new LineBorder(Color.red));

        // set up the JFrame instance and show it
        JFrame frame = new JFrame();
        frame.setTitle("[Demo]CompositionBiDirectional");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JLabel("  right click the arrow and diamond inside to show popup menu ;)"), "North");
        frame.add(edgeEnding, "Center");

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
