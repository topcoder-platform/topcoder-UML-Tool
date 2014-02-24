/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>OpenArrow</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class OpenArrowUnitTests extends TestCase {

    /** <code>OpenArrow</code> instance used for testing. */
    private OpenArrow arrow;


    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        arrow = new OpenArrow();
        arrow.setAngle(Math.toRadians(90));
        arrow.setEndingPoint(new Point(20, 20));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        arrow = null;
    }

    /**
     * <p>
     * Accuracy test of constructor <code>OpenArrow()</code>.
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", arrow);
    }

    /**
     * <p>
     * Accuracy test of method <code>paintComponent(Graphics)</code>.
     * With null <code>g</code>.
     * Should return directly.
     * </p>
     */
    public void testPaintComponent_NullGraphics() {
        arrow.paintComponent(null);
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

        frame.add(arrow);
        arrow.paintComponent(g);
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
        assertTrue("Should return true.", arrow.contains(20, 20));
        assertTrue("Should return true.", arrow.contains(10, 10));
        assertTrue("Should return true.", arrow.contains(30, 10));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With points in bound.
     * Should return true.
     * </p>
     */
    public void testContainsIn_InBound() {
        assertTrue("Should return true.", arrow.contains(20, 10));
        assertTrue("Should return true.", arrow.contains(15, 15));
        assertTrue("Should return true.", arrow.contains(25, 15));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With points in side.
     * Should return true.
     * </p>
     */
    public void testContainsIn_InSide() {
        assertTrue("Should return true.", arrow.contains(20, 15));
    }

    /**
     * <p>
     * Accuracy test of method <code>contains(int, int)</code>.
     * With point not contains in.
     * Should return false.
     * </p>
     */
    public void testContainsIn_Out() {
        assertFalse("Should return false.", arrow.contains(15, 16));
        assertFalse("Should return false.", arrow.contains(20, 22));
        assertFalse("Should return false.", arrow.contains(18, 8));
        assertFalse("Should return false.", arrow.contains(25, 18));
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        OpenArrow arrow = new OpenArrow();

        arrow.setBackground(Color.red);
        arrow.setBounds(new Rectangle(1, 2, 3, 5));
        arrow.setBorder(new LineBorder(Color.red));
        arrow.setVisible(true);

        arrow.setAngle(Math.PI * 0.5);
        arrow.setEndingPoint(new Point(200, 100));
        arrow.setSize(2, 5);

        JFrame frame = new JFrame();
        frame.setTitle("[Demo]OpenArrow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(arrow);
        frame.setSize(new Dimension(400, 200));
        frame.setVisible(true);
    }
}
