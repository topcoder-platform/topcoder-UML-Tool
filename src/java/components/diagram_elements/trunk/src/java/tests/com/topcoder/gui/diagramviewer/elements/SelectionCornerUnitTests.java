/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DebugGraphics;
import javax.swing.JComponent;

import junit.framework.TestCase;

/**
 * Unit test for the <code>SelectionCorner</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SelectionCornerUnitTests extends TestCase {

    /**
     * Represents the mock selection corner class used for test.
     */
    private class MockSelectionCorner extends SelectionCorner {

        /**
         * The default constructor.
         */
        public MockSelectionCorner() {
            super(SelectionCornerType.EAST, new Point(100, 200), 10, Color.RED, Color.BLUE);
        }

        /**
         * <p>
         * Paints this component.
         * </p>
         * <p>
         * No restriction on the given value, null is acceptable.
         * </p>
         *
         * @param g
         *            the graphics to paint on
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }

    /**
     * Represents the mock graphics class used for test.
     */
    private class MockGraphics extends DebugGraphics {

        /**
         * Represents the command sequence.
         */
        private List<String> commandSequence = new ArrayList<String>();

        /**
         * The default constructor.
         */
        public MockGraphics() {
            super();
        }

        /**
         * Sets the color of graphics.
         *
         * @param color
         *            the new color
         */
        public void setColor(Color color) {
            commandSequence.add(color.toString());
        }

        /**
         * Gets the color of graphics.
         *
         * @return always black
         */
        public Color getColor() {
            return Color.BLACK;
        }

        /**
         * Fills the oval.
         *
         * @param x
         *            the x coordinate of point
         * @param y
         *            the y coordinate of point
         * @param width
         *            the width of the oval
         * @param height
         *            the height of the oval
         */
        public void fillOval(int x, int y, int width, int height) {
            commandSequence.add("fill:" + x + "," + y + "," + width + "," + height);
        }

        /**
         * Draws the oval.
         *
         * @param x
         *            the x coordinate of point
         * @param y
         *            the y coordinate of point
         * @param width
         *            the width of the oval
         * @param height
         *            the height of the oval
         */
        public void drawOval(int x, int y, int width, int height) {
            commandSequence.add("draw:" + x + "," + y + "," + width + "," + height);
        }

        /**
         * Gets the command sequence.
         *
         * @return the command sequence
         */
        public List<String> getCommandSequence() {
            return commandSequence;
        }
    }

    /**
     * Represents the <code>SelectionCorner</code> instance used to test against.
     */
    private SelectionCorner corner = null;

    /**
     * Represents the <code>MockSelectionCorner</code> instance used to test against.
     */
    private MockSelectionCorner mockCorner = new MockSelectionCorner();

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        corner = new SelectionCorner(SelectionCornerType.EAST, new Point(100, 200), 10, Color.RED, Color.BLUE);
    }

    /**
     * Test for the inheritance, <code>SelectionCorner</code> class should extend from the <code>JComponent</code>
     * class.
     */
    public void testInheritanceFromJComponent() {
        assertTrue("SelectionCorner class should extend from the JComponent class.",
            JComponent.class.isAssignableFrom(SelectionCorner.class));
    }

    /**
     * Test the constructor <code>SelectionCorner(SelectionCornerType, Point)</code> with null <code>type</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullType1() {
        try {
            new SelectionCorner(null, new Point());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>SelectionCorner(SelectionCornerType, Point)</code> with null <code>center</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullCenter1() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the constructor <code>SelectionCorner(SelectionCornerType, Point)</code>, instance should be
     * created, radius and colors are set to default.
     */
    public void testConstructorAccuracy1() {
        SelectionCorner c = new SelectionCorner(SelectionCornerType.EAST, new Point(100, 200));
        assertNotNull("SelectionCorner instance should be created.", c);
        assertTrue("The type field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, c, "type").equals(SelectionCornerType.EAST));
        assertTrue("The center field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, c, "center").equals(new Point(100, 200)));
        assertTrue("The radius field should be set to default",
            TestHelper.getPrivateField(SelectionCorner.class, c, "radius").toString().equals("5"));
        assertTrue("The strokeColor field should be set to default",
            TestHelper.getPrivateField(SelectionCorner.class, c, "strokeColor").equals(Color.BLACK));
        assertTrue("The fillColor field should be set to default",
            TestHelper.getPrivateField(SelectionCorner.class, c, "fillColor").equals(Color.YELLOW));
    }

    /**
     * Test the constructor <code>SelectionCorner(SelectionCornerType, Point, int, Color, Color)</code> with null
     * <code>type</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullType2() {
        try {
            new SelectionCorner(null, new Point(), 10, Color.RED, Color.BLUE);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>SelectionCorner(SelectionCornerType, Point, int, Color, Color)</code> with null
     * <code>center</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullCenter2() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, null, 10, Color.RED, Color.BLUE);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>SelectionCorner(SelectionCornerType, Point, int, Color, Color)</code> with zero
     * <code>radius</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithZeroRadius() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, new Point(), 0, Color.RED, Color.BLUE);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>SelectionCorner(SelectionCornerType, Point, int, Color, Color)</code> with negative
     * <code>radius</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNegativeRadius() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, new Point(), -1, Color.RED, Color.BLUE);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>SelectionCorner(SelectionCornerType, Point, int, Color, Color)</code> with null
     * <code>strokeColor</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullStrokeColor() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, new Point(), 10, null, Color.BLUE);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>SelectionCorner(SelectionCornerType, Point, int, Color, Color)</code> with null
     * <code>fillColor</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullFillColor() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, new Point(), 10, Color.RED, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for <code>SelectionCorner(SelectionCornerType, Point, int, Color, Color)</code>, instance should
     * be created, all fields should be set.
     */
    public void testConstructorAccuracy2() {
        SelectionCorner c
            = new SelectionCorner(SelectionCornerType.EAST, new Point(100, 200), 10, Color.RED, Color.BLUE);
        assertNotNull("SelectionCorner instance should be created.", c);
        assertTrue("The type field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, c, "type").equals(SelectionCornerType.EAST));
        assertTrue("The center field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, c, "center").equals(new Point(100, 200)));
        assertTrue("The radius field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, c, "radius").toString().equals("10"));
        assertTrue("The strokeColor field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, c, "strokeColor").equals(Color.RED));
        assertTrue("The fillColor field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, c, "fillColor").equals(Color.BLUE));
    }

    /**
     * Accuracy test for the method <code>getType()</code>, the value of <code>type</code> field should be returned.
     */
    public void testGetTypeAccuracy() {
        assertTrue("The returned value should be SelectionCornerType.EAST.",
            corner.getType().equals(SelectionCornerType.EAST));
    }

    /**
     * Test the method <code>setType(SelectionCornerType)</code> with null <code>type</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testSetTypeWithNullType() {
        try {
            corner.setType(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>setType(SelectionCornerType)</code>, the value of <code>type</code> field
     * should be set.
     */
    public void testSetTypeAccuracy() {
        corner.setType(SelectionCornerType.WEST);
        assertTrue("The type field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, corner, "type").equals(SelectionCornerType.WEST));
    }

    /**
     * Accuracy test for the method <code>getRadius()</code>, the value of <code>radius</code> field should be returned.
     */
    public void testGetRadiusAccuracy() {
        assertTrue("The returned value should be 10.", corner.getRadius() == 10);
    }

    /**
     * Test the method <code>setRadius(int)</code> with zero radius, IllegalArgumentException should be thrown.
     */
    public void testSetRadiusWithZeroRadius() {
        try {
            corner.setRadius(0);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>setRadius(int)</code> with negative radius, IllegalArgumentException should be thrown.
     */
    public void testSetRadiusWithNegativeRadius() {
        try {
            corner.setRadius(-1);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>setRadius(int)</code>, the value of <code>radius</code> field should be
     * set.
     */
    public void testSetRadiusAccuracy() {
        corner.setRadius(20);
        assertTrue("The radius field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, corner, "radius").toString().equals("20"));
    }

    /**
     * Accuracy test for the method <code>getCenter()</code>, the value of <code>center</code> field should be
     * returned.
     */
    public void testGetCenterAccuracy() {
        assertTrue("The returned value should be (100, 200).", corner.getCenter().equals(new Point(100, 200)));
    }

    /**
     * Test the method <code>setCenter(Point)</code> with null <code>center</code>, IllegalArgumentException should
     * be thrown.
     */
    public void testSetCenterWithNullCenter() {
        try {
            corner.setCenter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>setCenter(Point)</code>, the value of <code>center</code> field should be
     * set.
     */
    public void testSetCenterAccuracy() {
        corner.setCenter(new Point(-100, -200));
        assertTrue("The center field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, corner, "center").equals(new Point(-100, -200)));
    }

    /**
     * Accuracy test for the method <code>getStrokeColor()</code>, the value of <code>strokeColor</code> field should
     * be returned.
     */
    public void testGetStrokeColorAccuracy() {
        assertTrue("The returned value should be RED.", corner.getStrokeColor().equals(Color.RED));
    }

    /**
     * Test the method <code>setStrokeColor(Color)</code> with null <code>strokeColor</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testSetStrokeColorWithNullColor() {
        try {
            corner.setStrokeColor(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>setStrokeColor(Color)</code>, the value of <code>strokeColor</code> field
     * should be set.
     */
    public void testSetStrokeColorAccuracy() {
        corner.setStrokeColor(Color.GREEN);
        assertTrue("The strokeColor field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, corner, "strokeColor").equals(Color.GREEN));
    }

    /**
     * Accuracy test for the method <code>getFillColor()</code>, the value of <code>fillColor</code> field should be
     * returned.
     */
    public void testGetFillColorAccuracy() {
        assertTrue("The returned value should be BLUE.", corner.getFillColor().equals(Color.BLUE));
    }

    /**
     * Test the method <code>setFillColor(Color)</code> with null <code>fillColor</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testSetFillColorWithNullColor() {
        try {
            corner.setFillColor(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>setFillColor(Color)</code>, the value of <code>fillColor</code> field should
     * be set.
     */
    public void testSetFillColorAccuracy() {
        corner.setFillColor(Color.GREEN);
        assertTrue("The fillColor field should be set.",
            TestHelper.getPrivateField(SelectionCorner.class, corner, "fillColor").equals(Color.GREEN));
    }

    /**
     * Accuracy test for the method <code>contains(int, int)</code>, the correct result should be returned.
     */
    public void testContainsAccuracy() {
        /*
         * BugFix: UML-9867
         * The circle center should be (radius, radius).
         */
        // old code
//        assertTrue("True should be returned.", corner.contains(100, 209));
//        assertTrue("True should be returned.", corner.contains(100, 210));
        assertFalse("False should be returned.", corner.contains(100, 211));
    }

    /**
     * Accuracy test for the method <code>paintComponent(Graphics)</code> with null, nothing should be done.
     */
    public void testPaintComponentWithNullAccuracy() {
        mockCorner.paintComponent(null);
    }

    /**
     * Accuracy test for the method <code>paintComponent(Graphics)</code> with graphics, corner should be painted.
     */
    public void testPaintComponentWithGraphicsAccuracy() {
        MockGraphics g = new MockGraphics();
        mockCorner.paintComponent(g);
        List<String> commandSequence = g.getCommandSequence();
        assertTrue("The command count should be 4", commandSequence.size() == 5);
        /*
         * BugFix: UML-9866
         * This method should paint the selection
         * corner in its own relative coordinate system.
         */
        // old code
//        assertTrue("The command should be correct.", commandSequence.get(0).equals("java.awt.Color[r=0,g=0,b=255]"));
//        assertTrue("The command should be correct.", commandSequence.get(1).equals("fill:90,190,20,20"));
//        assertTrue("The command should be correct.", commandSequence.get(2).equals("java.awt.Color[r=255,g=0,b=0]"));
//        assertTrue("The command should be correct.", commandSequence.get(3).equals("draw:90,190,20,20"));
//        assertTrue("The command should be correct.", commandSequence.get(4).equals("java.awt.Color[r=0,g=0,b=0]"));
        assertTrue("The command should be correct.", commandSequence.get(0).equals("java.awt.Color[r=0,g=0,b=255]"));
        assertTrue("The command should be correct.", commandSequence.get(1).equals("fill:0,0,20,20"));
        assertTrue("The command should be correct.", commandSequence.get(2).equals("java.awt.Color[r=255,g=0,b=0]"));
        assertTrue("The command should be correct.", commandSequence.get(3).equals("draw:0,0,19,19"));
        assertTrue("The command should be correct.", commandSequence.get(4).equals("java.awt.Color[r=0,g=0,b=0]"));
    }
}
