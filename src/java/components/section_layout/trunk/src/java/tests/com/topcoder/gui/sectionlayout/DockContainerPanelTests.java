/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Color;
import java.awt.Rectangle;
import java.lang.reflect.Field;

import javax.swing.JFrame;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>DockContainerPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DockContainerPanelTests extends TestCase {

    /**
     * <p>
     * The Rectangle instance for helping testing.
     * </p>
     */
    private Rectangle rect;

    /**
     * <p>
     * The Color instance for helping testing.
     * </p>
     */
    private Color color;

    /**
     * <p>
     * The DockContainerPanel instance for helping testing.
     * </p>
     */
    private DockContainerPanel panel;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        rect = new Rectangle(10, 10, 70, 60);
        color = Color.blue;
        panel = new DockContainerPanel();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        rect = null;
        color = null;
        panel = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DockContainerPanelTests.class);
    }

    /**
     * <p>
     * Tests DockContainerPanel#DockContainerPanel() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockContainerPanel#DockContainerPanel() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created DockContainerPanel should not be null.", panel);
    }

    /**
     * <p>
     * Tests DockContainerPanel#setGestureRect(Rectangle) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockContainerPanel#setGestureRect(Rectangle) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetGestureRect() throws Exception {
        Field field = DockContainerPanel.class.getDeclaredField("gestureRect");
        field.setAccessible(true);
        assertNull("The gesture rectangle should be null.", field.get(panel));
        panel.setGestureRect(rect);
        assertEquals("The gesture rectangle should be equal.", rect, field.get(panel));
    }

    /**
     * <p>
     * Tests DockContainerPanel#setGestureColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockContainerPanel#setGestureColor(Color) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetGestureColor() throws Exception {
        Field field = DockContainerPanel.class.getDeclaredField("gestureColor");
        field.setAccessible(true);
        assertNull("The gesture color should be null.", field.get(panel));
        panel.setGestureColor(color);
        assertEquals("The gesture color should be equal.", color, field.get(panel));
    }

    /**
     * <p>
     * Tests DockContainerPanel#paint(Graphics) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockContainerPanel#paint(Graphics) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaint_Accuracy1() throws Exception {
        // rectangle is not set, nothing will happen
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests DockContainerPanel#paint(Graphics) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockContainerPanel#paint(Graphics) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaint_Accuracy2() throws Exception {
        // rectangle is set, and color is not set, use default color
        JFrame frame = new JFrame();
        panel.setGestureRect(rect);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests DockContainerPanel#paint(Graphics) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockContainerPanel#paint(Graphics) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaint_Accuracy3() throws Exception {
        // rectangle and color are set
        JFrame frame = new JFrame();
        panel.setGestureRect(rect);
        panel.setGestureColor(color);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
}
