/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;
import java.awt.Font;

import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * <p>
 * Change for v1.1: add corresponding testing methods for new method in Util v1.1 class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @author TCSDEVELOPER
 *
 * @version 1.1
 * @since 1.0
 */
public class UtilTests extends TestCase {
    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
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
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UtilTests.class);
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for accuracy.
     * </p>
     */
    public void testCheckNull() {
        Util.checkNull(" ", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullArg() {
        try {
            Util.checkNull(null, "test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for accuracy.
     * </p>
     */
    public void testCheckString() {
        Util.checkString("test", "test");
    }

    /**
     * <p>
     * Tests Util#checkInt_NegativeOrNil(int,String) for accuracy.
     * </p>
     *
     * @since 1.1
     */
    public void checkInt_NegativeOrNil() {
        Util.checkInt_NegativeOrNil(4, "4");
    }

    /**
     * <p>
     * Tests Util#checkInt_NegativeOrNil(int,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is nil and expects IllegalArgumentException.
     * </p>
     *
     * @since 1.1
     */
    public void checkInt_NegativeOrNil_ArgNil() {
        try {
            Util.checkInt_NegativeOrNil(0, "0");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkInt_NegativeOrNil(int,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is negative and expects IllegalArgumentException.
     * </p>
     *
     * @since 1.1
     */
    public void checkInt_NegativeOrNil_ArgNegative() {
        try {
            Util.checkInt_NegativeOrNil(-5, "-5");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkInt_Negative(int,String) for accuracy.
     * </p>
     *
     * @since 1.1
     */
    public void checkInt_Negative() {

        Util.checkInt_Negative(4, "4");
        Util.checkInt_Negative(0, "0");
    }

    /**
     * <p>
     * Tests Util#checkInt_Negative(int,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is negative and expects IllegalArgumentException.
     * </p>
     *
     * @since 1.1
     */
    public void checkInt_Negative_ArgNegative() {

        Util.checkInt_Negative(-5, "-5");
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_NullArg() {
        try {
            Util.checkString(null, "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_EmptyArg() {
        try {
            Util.checkString(" ", "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#readStringProperty(DiagramElement,String,String,String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testReadStringProperty() {
        String value = Util.readStringProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "NodeFillColor", "value");

        assertEquals("Failed to get the string property value.", "Color.BLACK", value);
    }

    /**
     * <p>
     * Tests Util#readStringProperty(DiagramElement,String,String,String,Color) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects default value is returned.
     * </p>
     */
    public void testReadStringProperty_Unknown() {
        String value = Util.readStringProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "value", "value");

        assertEquals("Failed to get the string property value.", "value", value);
    }

    /**
     * <p>
     * Tests Util#readColorProperty(DiagramElement,String,String,String,Color) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testReadColorProperty() {
        Color value = Util.readColorProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "NodeFillColor", Color.BLUE);

        assertEquals("Failed to get the color property value.", Color.BLACK, value);
    }

    /**
     * <p>
     * Tests Util#readColorProperty(DiagramElement,String,String,String,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects the value is correct.
     * </p>
     */
    public void testReadColorProperty_Unknown() {
        Color value = Util.readColorProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "value", Color.BLUE);

        assertEquals("Failed to get the color property value.", Color.BLUE, value);
    }

    /**
     * <p>
     * Tests Util#readIntegerProperty(DiagramElement,String,String,String,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testReadIntegerProperty() {
        int value = Util.readIntegerProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "NodeFontSize", 40);

        assertEquals("Failed to get the int property value.", 15, value);
    }

    /**
     * <p>
     * Tests Util#readIntegerProperty(DiagramElement,String,String,String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects the value is correct.
     * </p>
     */
    public void testReadIntegerProperty_Unknown() {
        int value = Util.readIntegerProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "value", 40);

        assertEquals("Failed to get the int property value.", 40, value);
    }

    /**
     * <p>
     * Tests Util#parseColorProperty(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseColorPropertyFromNamespace() {
        Color value = Util.parseColorProperty("com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode",
                "NodeFillColor");

        assertEquals("Failed to get the color property value.", Color.BLACK, value);
    }

    /**
     * <p>
     * Tests Util#parseColorProperty(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects null.
     * </p>
     */
    public void testparseColorPropertyFromNamespace_Unknown() {
        Color value = Util
                .parseColorProperty("com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "value");

        assertNull("Failed to get the color property value.", value);
    }

    /**
     * <p>
     * Tests Util#parseStringProperty(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseStringPropertyFromNamespace() {
        String value = Util.parseStringProperty("com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode",
                "NodeFillColor");

        assertEquals("Failed to get the string property value.", "Color.BLACK", value);
    }

    /**
     * <p>
     * Tests Util#parseStringProperty(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects null.
     * </p>
     */
    public void testParseStringPropertyFromNamespace_Unknown() {
        String value = Util.parseStringProperty("com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode",
                "value");

        assertNull("Failed to get the string property value.", value);
    }

    /**
     * <p>
     * Tests Util#parseIntegerProperty(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseIntegerPropertyFromNamespace() {
        Integer value = Util.parseIntegerProperty("com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode",
                "NodeWidth");

        assertEquals("Failed to get the int property value.", new Integer(150), value);
    }

    /**
     * <p>
     * Tests Util#parseIntegerProperty(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects null.
     * </p>
     */
    public void testParseIntegerPropertyFromNamespace_Unknown() {
        Integer value = Util.parseIntegerProperty("com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode",
                "value");

        assertNull("Failed to get the int property value.", value);
    }

    /**
     * <p>
     * Tests Util#parseColorProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseColorPropertyFromDiagramElement() {
        Color value = Util.parseColorProperty(TestHelper.createGraphNode(), "color");

        assertEquals("Failed to get the color property value.", new Color(85, 85, 85), value);
    }

    /**
     * <p>
     * Tests Util#parseColorProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects null.
     * </p>
     */
    public void testparseColorPropertyFromDiagramElement_Unknown() {
        Color value = Util.parseColorProperty(TestHelper.createGraphNode(), "value");

        assertNull("Failed to get the color property value.", value);
    }

    /**
     * <p>
     * Tests Util#parseStringProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseStringPropertyFromDiagramElement() {
        String value = Util.parseStringProperty(TestHelper.createGraphNode(), "color");

        assertEquals("Failed to get the string property value.", "#555555", value);
    }

    /**
     * <p>
     * Tests Util#parseStringProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects null.
     * </p>
     */
    public void testParseStringPropertyFromDiagramElement_Unknown() {
        String value = Util.parseStringProperty(TestHelper.createGraphNode(), "value");

        assertNull("Failed to get the string property value.", value);
    }

    /**
     * <p>
     * Tests Util#parseIntegerProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseIntegerPropertyFromDiagramElement() {
        Integer value = Util.parseIntegerProperty(TestHelper.createGraphNode(), "shadow");

        assertEquals("Failed to get the integer property value.", new Integer(23), value);
    }

    /**
     * <p>
     * Tests Util#parseIntegerProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects null.
     * </p>
     */
    public void testParseIntegerPropertyFromDiagramElement_Unknown() {
        Integer value = Util.parseIntegerProperty(TestHelper.createGraphNode(), "value");

        assertNull("Failed to get the integer property value.", value);
    }

    /**
     * <p>
     * Tests Util#parseReaderSchemeProperty(DiagramElement,String,String,String,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseReaderSchemeProperty() {
        RenderScheme scheme = Util.parseReaderSchemeProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "NodeRenderScheme", 1);

        assertEquals("Failed to get the render scheme.", RenderScheme.TopCoderScheme, scheme);
    }

    /**
     * <p>
     * Tests Util#parseReaderSchemeProperty(DiagramElement,String,String,String,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects the value is correct.
     * </p>
     */
    public void testParseReaderSchemeProperty_Unknown() {
        RenderScheme scheme = Util.parseReaderSchemeProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "value", 0);

        assertEquals("Failed to get the render scheme.", RenderScheme.SimpleScheme, scheme);
    }

    /**
     * <p>
     * Tests Util#parseFontStyleProperty(DiagramElement,String,String,String,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseFontStyleProperty() {
        int fontStyle = Util.parseFontStyleProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "NodeFontStyle", Font.PLAIN);

        assertEquals("Failed to get the font style.", Font.ITALIC, fontStyle);
    }

    /**
     * <p>
     * Tests Util#parseFontStyleProperty(DiagramElement,String,String,String,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects the value is correct.
     * </p>
     */
    public void testParseFontStyleProperty_Unknown() {
        int fontStyle = Util.parseFontStyleProperty(new GraphNode(), "value",
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode", "value", Font.PLAIN);

        assertEquals("Failed to get the font style.", Font.PLAIN, fontStyle);
    }
}
