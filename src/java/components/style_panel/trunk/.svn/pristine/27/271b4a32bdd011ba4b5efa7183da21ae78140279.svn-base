/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.panels.style.styleobject.MockAbstractStyleObject;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UtilTests extends TestCase {

    /**
     * <p>
     * The DiagramElement instance for testing.
     * </p>
     */
    private DiagramElement element;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        element = new GraphEdge();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        element = null;
    }

    /**
     * <p>
     * Return all tests.
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
            //good
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
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getStylePanel(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getStylePanel(StyleObject) is correct.
     * </p>
     */
    public void testGetStylePanel() {
        StyleObject styleObject = new MockAbstractStyleObject();
        StylePanel stylePanel = new StylePanel();
        styleObject.setStylePanel(stylePanel);

        assertSame("Failed to return the correct value.", stylePanel, Util.getStylePanel(styleObject));
    }

    /**
     * <p>
     * Tests Util#getStylePanel(StyleObject) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the style panel for the style object is
     * not set and expects IllegalStateException.
     * </p>
     */
    public void testGetStylePanel_NullStyleObject() {
        StyleObject styleObject = new MockAbstractStyleObject();
        try {
            Util.getStylePanel(styleObject);
            fail("IllegalStateException expected.");
        } catch (IllegalStateException ise) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getDoubleProperty(DiagramElement,String) for accuracy.
     * </p>
     * <p>
     * Verify : Util#getDoubleProperty(DiagramElement,String) returns the correct value when the key is contained in
     * property.
     * </p>
     */
    public void testGetDoubleProperty() {
        GraphNode graphNode = new GraphNode();
        Dimension dimension = new Dimension();
        dimension.setWidth(10.0);
        dimension.setHeight(5.0);
        graphNode.setSize(dimension);

        assertEquals("Failed to return the correct value.", 10.0, Util.getDoubleProperty(graphNode, "width"), 1e-5);
        assertEquals("Failed to return the correct value.", 5.0, Util.getDoubleProperty(graphNode, "height"), 1e-5);
    }

    /**
     * <p>
     * Tests Util#getDoubleProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getDoubleProperty(DiagramElement,String) returns zero
     * when the key is not contained in property.
     * </p>
     */
    public void testGetDoubleProperty_NoKey() {
        assertEquals("Failed to return the correct value.", 0.0, Util.getDoubleProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getDoubleProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getDoubleProperty(DiagramElement,String) returns zero
     * when the value of property is not number format.
     * </p>
     */
    public void testGetDoubleProperty_WrongValue() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("value");
        element.addProperty(property);

        assertEquals("Failed to return the correct value.", 0.0, Util.getDoubleProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getColorProperty(DiagramElement,String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getColorProperty(DiagramElement,String,String) returns the value
     * of property when the key is contained in the property and the value of property
     * matches the color format.
     * </p>
     */
    public void testGetColorProperty() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("#000000");
        element.addProperty(property);

        assertEquals("Failed to return the correct value.", "#000000",
            Util.getColorProperty(element, "key", "#FFFFFF"));
    }

    /**
     * <p>
     * Tests Util#getColorProperty(DiagramElement,String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getColorProperty(DiagramElement,String,String) returns the value
     * of property when the key is not contained in the property.
     * </p>
     */
    public void testGetColorProperty_NoKey() {
        assertEquals("Failed to return the correct value.", "#FFFFFF",
            Util.getColorProperty(element, "key", "#FFFFFF"));
    }

    /**
     * <p>
     * Tests Util#getColorProperty(DiagramElement,String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getColorProperty(DiagramElement,String,String) returns the default value
     * when the key is contained in the property, but the value of property does not match the
     * color format.
     * </p>
     */
    public void testGetColorProperty_WrongValue() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("TEST");
        element.addProperty(property);

        assertEquals("Failed to return the correct value.", "#FFFFFF",
            Util.getColorProperty(element, "key", "#FFFFFF"));
    }

    /**
     * <p>
     * Tests Util#getFontSizeProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getFontSizeProperty(DiagramElement,String) returns the correct
     * value when the key is contained in the property.
     * </p>
     */
    public void testGetFontSizeProperty() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("15");
        element.addProperty(property);

        assertEquals("Failed to return the correct value.", 15, Util.getFontSizeProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getFontSizeProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getFontSizeProperty(DiagramElement,String) returns ten
     * when the key is contained in the property,but the value of property
     * is non-positive.
     * </p>
     */
    public void testGetFontSizeProperty_WrongValue() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("-5");
        element.addProperty(property);

        assertEquals("Failed to return the correct value.", 10, Util.getFontSizeProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getFontSizeProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getFontSizeProperty(DiagramElement,String) returns ten
     * when the key is contained in the property,but the value of property
     * is not an integer.
     * </p>
     */
    public void testGetFontSizeProperty_WrongFormat() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("test");
        element.addProperty(property);

        assertEquals("Failed to return the correct value.", 10, Util.getFontSizeProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getFontSizeProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getFontSizeProperty(DiagramElement,String) returns ten
     * when the key is not contained in the property.
     * </p>
     */
    public void testGetFontSizeProperty_NoKey() {
        assertEquals("Failed to return the correct value.", 10, Util.getFontSizeProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getFontNameProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getFontNameProperty(DiagramElement,String) returns "Arial"
     * when the key is contained in the property and the font name is exist in
     * the system.
     * </p>
     */
    public void testGetFontNameProperty() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("Arial");
        element.addProperty(property);

        assertEquals("Failed to return the correct value.", "Arial", Util.getFontNameProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getFontNameProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getFontNameProperty(DiagramElement,String) returns "Default"
     * when the key is not contained in the property.
     * </p>
     */
    public void testGetFontNameProperty_NoKey() {
        assertEquals("Failed to return the correct value.", "Default", Util.getFontNameProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getFontNameProperty(DiagramElement,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getFontNameProperty(DiagramElement,String) returns "Default"
     * when the key is contained in the property, but the font name is not exist
     * in the system.
     * </p>
     */
    public void testGetFontNameProperty_NoExist() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("test");
        element.addProperty(property);

        assertEquals("Failed to return the correct value.", "Default", Util.getFontNameProperty(element, "key"));
    }

    /**
     * <p>
     * Tests Util#getAllFontNames() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getAllFontNames() returns all the font name in the system.
     * </p>
     */
    public void testGetAllFontNames() {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        Set<String> set = Util.getAllFontNames();
        assertEquals("Failed to return the correct value.", fontNames.length, set.size());
        for (String fontName : fontNames) {
            assertTrue("Failed to return the correct value.", set.contains(fontName));
        }
    }

    /**
     * <p>
     * Tests Util#convertInteger(String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#convertInteger(String,String) returns correct value
     * when the value is an non-positive integer.
     * </p>
     */
    public void testConvertInteger() {
        assertEquals("Failed to return the correct value.", 15, Util.convertInteger("15", "propName"));
    }

    /**
     * <p>
     * Tests Util#convertInteger(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is negative integer and
     * expects StylePanelConfigurationException.
     * </p>
     */
    public void testConvertInteger_Negative() {
        try {
            Util.convertInteger("-5", "propName");
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#convertInteger(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is not an integer
     * and expects StylePanelConfigurationException.
     * </p>
     */
    public void testConvertInteger_EmptyValue() {
        try {
            Util.convertInteger("test", "propName");
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getPropertyMap(String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getPropertyMap(String,String) is correct.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testGetPropertyMap() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        try {
            Map<String, String> map = Util.getPropertyMap(TestHelper.NAMESPACE, "fontSize");

            assertEquals("Failed to return the correct value.", 4, map.size());
            assertEquals("Failed to return the correct value.", "8", map.get("small"));
            assertEquals("Failed to return the correct value.", "6", map.get("smaller"));
            assertEquals("Failed to return the correct value.", "10", map.get("normal"));
            assertEquals("Failed to return the correct value.", "10", map.get("default"));
        } finally {
            TestHelper.clearConfigFile(TestHelper.NAMESPACE);
        }
    }

    /**
     * <p>
     * Tests Util#getPropertyMap(String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getPropertyMap(String,String) returns null
     * when the property name is missing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyMap_MissingProperty() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        try {
            assertNull("Failed to return the correct value.", Util.getPropertyMap(TestHelper.NAMESPACE, "test"));
        } finally {
            TestHelper.clearConfigFile(TestHelper.NAMESPACE);
        }
    }

    /**
     * <p>
     * Tests Util#getPropertyMap(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is unknown and
     * expects StylePanelConfigurationException.
     * </p>
     */
    public void testGetPropertyMap_UnKnownNamespace() {
        try {
            Util.getPropertyMap("test", "fontSize");
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getPropertyMap(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when an property value is null and
     * expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyMap_NullValue() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files"
            + File.separator + "config_FontSizeNoValue.xml");
        try {
            Util.getPropertyMap(TestHelper.NAMESPACE, "fontSize");
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(TestHelper.NAMESPACE);
        }
    }

    /**
     * <p>
     * Tests Util#convertColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#convertColor(Color) returns correct value.
     * </p>
     */
    public void testConvertColor1() {
        Color color = new Color(255, 255, 255);
        assertEquals("Failed to return the correct value.", "#FFFFFF", Util.convertColor(color));
    }

    /**
     * <p>
     * Tests Util#convertColor(String,Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#convertColor(String,Color) the correct value
     * when the colorString matches the color format.
     * </p>
     */
    public void testConvertColor2() {
        Color defaultColor = new Color(255, 255, 255);
        Color color = new Color(0, 0, 0);
        assertEquals("Failed to return the correct value.", color, Util.convertColor("#000000", defaultColor));
    }

    /**
     * <p>
     * Tests Util#convertColor(String,Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#convertColor(String,Color) the correct value
     * when the colorString does not match the color format.
     * </p>
     */
    public void testConvertColor2_DefultColor() {
        Color defaultColor = new Color(255, 255, 255);
        assertEquals("Failed to return the correct value.", defaultColor, Util.convertColor("test", defaultColor));
    }

    /**
     * <p>
     * Tests Util#checkList(List,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#checkList(List,String) is correct.
     * </p>
     */
    public void testCheckList() {
        List<String> list = new ArrayList<String>();
        Util.checkList(list, "name");
    }

    /**
     * <p>
     * Tests Util#checkList(List,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when list is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckList_NullList() {
        try {
            Util.checkList(null, "name");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkList(List,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when list contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckList_NullInList() {
        List<String> list = new ArrayList<String>();
        list.add(null);
        try {
            Util.checkList(list, "name");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}