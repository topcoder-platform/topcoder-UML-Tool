/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Point;
import java.awt.Polygon;


/**
 * <p>
 * Unit test cases for AuxiliaryElementsHelper.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AuxiliaryElementsHelperTests extends TestCase {
    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * Constant for vertex number.
     * </p>
     */
    private static final int VERTEX_NUMBER = 5;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(AuxiliaryElementsHelperTests.class);
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#checkNotNull(Object obj, String name) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#checkNotNull(Object obj, String name) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNotNull() throws Exception {
        try {
            AuxiliaryElementsHelper.checkNotNull(null, "nullObject");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#checkNotNullAndNotEmptyString(String str, String name) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#checkNotNullAndNotEmptyString(String str, String name) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNotNullAndNotEmptyString_NullString() throws Exception {
        try {
            AuxiliaryElementsHelper.checkNotNullAndNotEmptyString(null, "nullString");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#checkNotNullAndNotEmptyString(String str, String name) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#checkNotNullAndNotEmptyString(String str, String name) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNotNullAndNotEmptyString_EmptyString() throws Exception {
        try {
            AuxiliaryElementsHelper.checkNotNullAndNotEmptyString("", "emptyString");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#determineConnectionPoint(Point wayPoint, Polygon polygon) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#determineConnectionPoint(Point wayPoint, Polygon polygon) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDetermineConnectionPoint() throws Exception {
        // Construct a polygon.
        int[] xpoints = new int[VERTEX_NUMBER];
        int[] ypoints = new int[VERTEX_NUMBER];
        xpoints[0] = 0;
        ypoints[0] = 0;
        xpoints[1] = 15;
        ypoints[1] = 0;
        xpoints[2] = 20;
        ypoints[2] = 5;
        xpoints[3] = 20;
        ypoints[3] = 10;
        xpoints[4] = 0;
        ypoints[4] = 10;
        Polygon polygon = new Polygon(xpoints, ypoints, VERTEX_NUMBER);

        // The wayPoint.
        Point wayPoint = new Point(30, 7);

        assertEquals("The connection point of waypoint should be (20, 7).",
                AuxiliaryElementsHelper.determineConnectionPoint(wayPoint, polygon).x, 20);
        assertEquals("The connection point of waypoint should be (20, 7).",
                AuxiliaryElementsHelper.determineConnectionPoint(wayPoint, polygon).y, 7);

        wayPoint = new Point(40, 23);
        assertEquals("The connection point of waypoint should be (20, 10).",
                AuxiliaryElementsHelper.determineConnectionPoint(wayPoint, polygon).x, 20);
        assertEquals("The connection point of waypoint should be (20, 10).",
                AuxiliaryElementsHelper.determineConnectionPoint(wayPoint, polygon).y, 10);
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#dot(Point a, Point b, Point c) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#dot(Point a, Point b, Point c) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDot() throws Exception {
        Point a = new Point(0, 10);
        Point b = new Point(10, 0);
        Point c = new Point(0, 0);

        assertEquals("The dot value of ab and ac should be -100.", AuxiliaryElementsHelper.dot(a, b, c), -100);
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#cross(Point a, Point b, Point c) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#cross(Point a, Point b, Point c) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCross() throws Exception {
        Point a = new Point(0, 10);
        Point b = new Point(10, 0);
        Point c = new Point(0, 0);

        assertEquals("The cross value of ab and ac should be -100.", AuxiliaryElementsHelper.cross(a, b, c), -100);
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#getNearestPoint(Point a, Point b, Point c) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#getNearestPoint(Point a, Point b, Point c) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetNearestPoint() throws Exception {
        Point a = new Point(0, 10);
        Point b = new Point(10, 0);
        Point c = new Point(0, 0);

        assertEquals("The nearest point in ab to c should be (5, 5).",
                AuxiliaryElementsHelper.getNearestPoint(a, b, c).getX(), 5.0);
        assertEquals("The nearest point in ab to c should be (5), 5).",
                AuxiliaryElementsHelper.getNearestPoint(a, b, c).getY(), 5.0);
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#parseColor(GraphNode graphNode, String colorString) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#parseColor(GraphNode graphNode, String colorString) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testParseColor() throws Exception {
        String colorString = "0x010af0";
        assertEquals("The red value of this color should be 1.",
                AuxiliaryElementsHelper.parseColor(new GraphNode(), colorString).getRed(), 1);
        assertEquals("The green value of this color should be 10.",
                AuxiliaryElementsHelper.parseColor(new GraphNode(), colorString).getGreen(), 10);
        assertEquals("The blue value of this color should be 240.",
                AuxiliaryElementsHelper.parseColor(new GraphNode(), colorString).getBlue(), 240);
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#parseColor(GraphNode graphNode, String colorString) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when colorString is invalid and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testParseColor_InvalidColorString() throws Exception {
        try {
            AuxiliaryElementsHelper.parseColor(new GraphNode(), "invalid");
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException ige) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#validateGraphNodeForTextNode(GraphNode graphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#validateGraphNodeForTextNode(GraphNode graphNode) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateGraphNodeForTextNode() throws Exception {
        try {
            AuxiliaryElementsHelper.validateGraphNodeForTextNode(new GraphNode());
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException ige) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#validateGraphNodeForFreeTextNode(GraphNode graphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#validateGraphNodeForFreeTextNode(GraphNode graphNode) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateGraphNodeForFreeTextNode() throws Exception {
        try {
            AuxiliaryElementsHelper.validateGraphNodeForFreeTextNode(new GraphNode());
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException ige) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#validateGraphNodeForCommentNode(GraphNode graphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#validateGraphNodeForCommentNode(GraphNode graphNode) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateGraphNodeForCommentNode() throws Exception {
        try {
            AuxiliaryElementsHelper.validateGraphNodeForCommentNode(new GraphNode());
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException ige) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#getStringPropertyValue(String namespace, String name, boolean required)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : AuxiliaryElementsHelper#getStringPropertyValue(String namespace, String name, boolean required)
     * is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetStringPropertyValue() throws Exception {
        assertEquals("The property value of PropertyMapping.STROKE_COLOR should be stroke_color.",
                AuxiliaryElementsHelper.getStringPropertyValue(VALID_NAMESPACE, PropertyMapping.STROKE_COLOR, true),
                "stroke_color");
        assertEquals("The property value of PropertyMapping.FILL_COLOR should be fillColor.",
                AuxiliaryElementsHelper.getStringPropertyValue(VALID_NAMESPACE, PropertyMapping.FILL_COLOR, true),
                "fillColor");
        assertEquals("The property value of PropertyMapping.FONT_FAMILY should be FontFamily.",
                AuxiliaryElementsHelper.getStringPropertyValue(VALID_NAMESPACE, PropertyMapping.FONT_FAMILY, true),
                "FontFamily");
        assertEquals("The property value of PropertyMapping.FONT_SIZE should be Font_Size.",
                AuxiliaryElementsHelper.getStringPropertyValue(VALID_NAMESPACE, PropertyMapping.FONT_SIZE, true),
                "Font_Size");
        assertEquals("The property value of PropertyMapping.FONT_COLOR should be FontColorProperty.",
                AuxiliaryElementsHelper.getStringPropertyValue(VALID_NAMESPACE, PropertyMapping.FONT_COLOR, true),
                "FontColorProperty");
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#getStringPropertyValue(String namespace, String name, boolean required)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetStringPropertyValue_NullNamespace() throws Exception {
        try {
            AuxiliaryElementsHelper.getStringPropertyValue(null, "name", true);
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#getStringPropertyValue(String namespace, String name, boolean required)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetStringPropertyValue_EmptyNamespace() throws Exception {
        try {
            AuxiliaryElementsHelper.getStringPropertyValue("", "name", true);
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#getStringPropertyValue(String namespace, String name, boolean required)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is invalid and expects ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetStringPropertyValue_InvalidNamespace() throws Exception {
        try {
            AuxiliaryElementsHelper.getStringPropertyValue("invalidnamespace", "name", true);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException ce) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#getStringPropertyValue(String namespace, String name, boolean required)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetStringPropertyValue_NullName() throws Exception {
        try {
            AuxiliaryElementsHelper.getStringPropertyValue(VALID_NAMESPACE, null, true);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException ce) {
            // good
        }
    }

    /**
     * <p>
     * Tests AuxiliaryElementsHelper#getStringPropertyValue(String namespace, String name, boolean required)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetStringPropertyValue_EmptyName() throws Exception {
        try {
            AuxiliaryElementsHelper.getStringPropertyValue(VALID_NAMESPACE, "", true);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException ce) {
            // good
        }
    }
}
