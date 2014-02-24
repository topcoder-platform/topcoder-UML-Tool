/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.ComponentFinder;
import junit.extensions.jfcunit.finder.Finder;
import junit.extensions.jfcunit.finder.LabeledComponentFinder;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for StylePanel V11.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 */
public class StylePanelV11Tests extends JFCTestCase {
    /**
     * <p>
     * StylePanel instance for testing.
     * </p>
     */
    private StylePanel stylePanel;

    /**
     * <p>
     * The width text field used in the style panel.
     * </p>
     */
    private JTextField widthTextField;

    /**
     * <p>
     * The height text field used in the style panel.
     * </p>
     */
    private JTextField heightTextField;

    /**
     * <p>
     * The x text field used in the style panel.
     * </p>
     */
    private JTextField xTextField;

    /**
     * <p>
     * The y text field used in the style panel.
     * </p>
     */
    private JTextField yTextField;

    /**
     * <p>
     * The fill color button used in the style panel.
     * </p>
     */
    private JButton fillColorButton;

    /**
     * <p>
     * The outline color button used in the style panel.
     * </p>
     */
    private JButton outlineColorButton;

    /**
     * <p>
     * The text color button used in the style panel.
     * </p>
     */
    private JButton textColorButton;

    /**
     * <p>
     * The font family selector used in the style panel.
     * </p>
     */
    private FontFamilySelector fontFamilySelector;

    /**
     * <p>
     * The font size selector used in the style panel.
     * </p>
     */
    private FontSizeSelector fontSizeSelector;

    /**
     * <p>
     * The JFrame instance for helping testing.
     * </p>
     */
    private JFrame frame;

    /**
     * <p>
     * StyleLister instance for helping testing.
     * </p>
     */
    private StyleListerImpl listener;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        stylePanel = new StylePanel(true);
        listener = new StyleListerImpl();
        stylePanel.addStyleListener(listener);

        frame = new JFrame();
        frame.setPreferredSize(new Dimension(600, 100));
        frame.getContentPane().add(stylePanel);
        frame.pack();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(TestHelper.NAMESPACE);
        frame.setVisible(false);
        stylePanel = null;
        listener = null;
        frame = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(StylePanelV11Tests.class);
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created StylePanel instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new StylePanel instance.", new StylePanel(TestHelper.NAMESPACE, true));
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new StylePanel(null, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new StylePanel("  ", false);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is missing and expects StylePanelConfigurationException.
     * </p>
     */
    public void testCtor1_NamespaceMissing() {
        try {
            new StylePanel("test", true);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the looknfeel is missing and expects success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_LooknfeelMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_NoLooknfeel.xml");

        assertNotNull("Failed to create a new StylePanel instance.", new StylePanel(TestHelper.NAMESPACE, true));
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the propertyKey is missing and expects success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_PropertyKeyMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files"
            + File.separator + "config_NoPropertyKey.xml");

        assertNotNull("Failed to create a new StylePanel instance.", new StylePanel(TestHelper.NAMESPACE, true));
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the preferredWidth less than minimumWidth
     * and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_PreferredWidthLess() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_PreferredWidthLess.xml");
        try {
            new StylePanel(TestHelper.NAMESPACE, true);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the preferredHeight less than minimumHeight
     * and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_PreferredHeightLess() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_PreferredHeightLess.xml");
        try {
            new StylePanel(TestHelper.NAMESPACE, true);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the font name is invalid
     * and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_FontNameInvalid() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_FontNameInvalid.xml");
        try {
            new StylePanel(TestHelper.NAMESPACE, true);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StylePanel#StylePanel() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created StylePanel instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new StylePanel instance.", stylePanel);
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectForXTextField() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        this.xTextField = (JTextField) createFinder("X:").find(frame, 0);
        assertEquals("Failed to set the x text field.", "10.0", xTextField.getText());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectForYTextField() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        this.yTextField = (JTextField) createFinder("Y:").find(frame, 0);
        assertEquals("Failed to set the y text field.", "11.0", yTextField.getText());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectForWidthTextField() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        this.widthTextField = (JTextField) createFinder("W:").find(frame, 0);
        assertEquals("Failed to set the width text field.", "12.0", widthTextField.getText());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void helloSetStyleObjectForHeightTextField() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        this.heightTextField = (JTextField) createFinder("H:").find(frame, 0);
        assertEquals("Failed to set the height text field.", "13.0", heightTextField.getText());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectForFillColor() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        this.fillColorButton = (JButton) createFinder("Fill:").find(frame, 0);
        assertEquals("Failed to set the fill color.", new Color(0, 255, 0), fillColorButton.getBackground());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectForOutlineColor() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        this.outlineColorButton = (JButton) createFinder("Outline:").find(frame, 0);
        assertEquals("Failed to set the outline color.", new Color(255, 0, 0), outlineColorButton.getBackground());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectForTextColor() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        this.textColorButton = (JButton) createFinder("Text:").find(frame, 0);
        assertEquals("Failed to set the text color.", new Color(0, 0, 255), textColorButton.getBackground());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectForFontName() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        this.fontFamilySelector = (FontFamilySelector) createFinder("Fonts:").find(frame, 0);
        assertEquals("Failed to set the font name.", "Arial", fontFamilySelector.getSelectedItem());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObject(StyleObject) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectForFontSize() throws Exception {
        frame.setVisible(true);

        // Set the graphNode style object to the style panel
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());

        stylePanel.setStyleObject(graphNode);

        assertEquals("Failed to set the style object correctly.", 1, stylePanel.getStyleObjectList().size());
        assertEquals("Failed to set the style object correctly.", graphNode, stylePanel.getStyleObjectList().get(0));

        fontSizeSelector = (FontSizeSelector) createFinder("Size:").find(frame, 0);
        assertEquals("Failed to set the font size.", new Integer(8), fontSizeSelector.getSelectedItem());
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObject(StyleObject) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when styleObject is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetStyleObject_NullStyleObject() {
        try {
            stylePanel.setStyleObject(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObjectList(List) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setStyleObjectList(List) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetStyleObjectList() throws Exception {
        setUpStylePanel();

        List<StyleObject> styleObjects = new ArrayList<StyleObject>();
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(createGraphNode());
        GraphEdgeStyleObjectAdapter graphEdge = new GraphEdgeStyleObjectAdapter(createGraphEdge());

        styleObjects.add(graphNode);
        styleObjects.add(graphEdge);
        stylePanel.setStyleObjectList(styleObjects);

        assertEquals("Failed to set the style object list correctly.", styleObjects, stylePanel.getStyleObjectList());

        // verify the widgets for size panel
        // hidden widgets
        assertFalse("The fill color widget should be hidden.", this.fillColorButton.isVisible());
        assertFalse("The width widget should be hidden.", this.widthTextField.isVisible());
        assertFalse("The height widget should be hidden.", this.heightTextField.isVisible());

        // not same values
        assertEquals("Failed to get the x value.", "", this.xTextField.getText());

        // same value
        assertEquals("Failed to get the y value.", "11.0", this.yTextField.getText());
        assertEquals("Failed to set the font name.", "Arial", this.fontFamilySelector.getSelectedItem());
        assertEquals("Failed to set the font size.", new Integer(8), this.fontSizeSelector.getSelectedItem());
        assertEquals("Failed to set the outline color.", new Color(255, 0, 0), outlineColorButton.getBackground());
        assertEquals("Failed to set the text color.", new Color(0, 0, 255), textColorButton.getBackground());

    }

    /**
     * <p>
     * Tests StylePanel#setStyleObjectList(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when styleObjectList is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetStyleObjectList_NullStyleObjectList() {
        try {
            stylePanel.setStyleObjectList(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setStyleObjectList(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when styleObjectList contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testSetStyleObjectList_NullInStyleObjectList() {
        List<StyleObject> styleObjects = new ArrayList<StyleObject>();
        styleObjects.add(null);
        try {
            stylePanel.setStyleObjectList(styleObjects);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#getStyleObjectList() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getStyleObjectList() is correct.
     * </p>
     */
    public void testGetStyleObjectList() {
        List<StyleObject> styleObjects = new ArrayList<StyleObject>();
        GraphNodeStyleObjectAdapter graphNode = new GraphNodeStyleObjectAdapter(new GraphNode());

        styleObjects.add(graphNode);
        stylePanel.setStyleObjectList(styleObjects);

        assertEquals("Failed to set the style object list correctly.", styleObjects, stylePanel.getStyleObjectList());
    }

    /**
     * <p>
     * Tests StylePanel#getHeightKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getHeightKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetHeightKey() {
        assertEquals("Failed to return the height key.", "height", stylePanel.getHeightKey());
    }

    /**
     * <p>
     * Tests StylePanel#getHeightKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getHeightKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetHeightKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the height key.", "height", stylePanel.getHeightKey());
    }

    /**
     * <p>
     * Tests StylePanel#getWidthKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getWidthKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetWidthKey() {
        assertEquals("Failed to return the width key.", "width", stylePanel.getWidthKey());
    }

    /**
     * <p>
     * Tests StylePanel#getWidthKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getWidthKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetWidthKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the width key.", "width", stylePanel.getWidthKey());
    }

    /**
     * <p>
     * Tests StylePanel#getXKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getXKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetXKey() {
        assertEquals("Failed to return the x key.", "x", stylePanel.getXKey());
    }

    /**
     * <p>
     * Tests StylePanel#getXKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getXKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetXKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the x key.", "x", stylePanel.getXKey());
    }

    /**
     * <p>
     * Tests StylePanel#getYKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getYKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetYKey() {
        assertEquals("Failed to return the y key.", "y", stylePanel.getYKey());
    }

    /**
     * <p>
     * Tests StylePanel#getYKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getYKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetYKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the y key.", "y", stylePanel.getYKey());
    }

    /**
     * <p>
     * Tests StylePanel#getFontNameKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getFontNameKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetFontNameKey() {
        assertEquals("Failed to return the font name key.", "fontName", stylePanel.getFontNameKey());
    }

    /**
     * <p>
     * Tests StylePanel#getFontNameKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getFontNameKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetFontNameKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the font name key.", "fontName", stylePanel.getFontNameKey());
    }

    /**
     * <p>
     * Tests StylePanel#getFontSizeKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getFontSizeKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetFontSizeKey() {
        assertEquals("Failed to return the font size key.", "fontSize", stylePanel.getFontSizeKey());
    }

    /**
     * <p>
     * Tests StylePanel#getFontSizeKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getFontSizeKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetFontSizeKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the font size key.", "fontSize", stylePanel.getFontSizeKey());
    }

    /**
     * <p>
     * Tests StylePanel#getFillColorKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getFillColorKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetFillColorKey() {
        assertEquals("Failed to return the fill color key.", "fillColor", stylePanel.getFillColorKey());
    }

    /**
     * <p>
     * Tests StylePanel#getFillColorKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getFillColorKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetFillColorKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the fill color key.", "fillColor", stylePanel.getFillColorKey());
    }

    /**
     * <p>
     * Tests StylePanel#getOutlineColorKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getOutlineColorKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetOutlineColorKey() {
        assertEquals("Failed to return the outline color key.", "outlineColor", stylePanel.getOutlineColorKey());
    }

    /**
     * <p>
     * Tests StylePanel#getOutlineColorKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getOutlineColorKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetOutlineColorKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the outline color key.", "outlineColor", stylePanel.getOutlineColorKey());
    }

    /**
     * <p>
     * Tests StylePanel#getTextColorKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getTextColorKey() returns the default key
     * when the style panel does not construct with namespace specified.
     * </p>
     */
    public void testGetTextColorKey() {
        assertEquals("Failed to return the text color key.", "textColor", stylePanel.getTextColorKey());
    }

    /**
     * <p>
     * Tests StylePanel#getTextColorKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getTextColorKey() returns the config key
     * when the style panel constructs with namespace specified.
     * </p>
     */
    public void testGetTextColorKey_Namespace() {
        stylePanel = new StylePanel(TestHelper.NAMESPACE);
        assertEquals("Failed to return the text color key.", "textColor", stylePanel.getTextColorKey());
    }

    /**
     * <p>
     * Tests StylePanel#setFontFamilyStyle(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setFontFamilyStyle(String) is correct.
     * </p>
     */
    public void testSetFontFamilyStyle() {
        // The graph node supports font name style
        stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(new GraphNode()));

        listener.clear();

        stylePanel.setFontFamilyStyle("Arial");

        assertEquals("The font family style should be changed.", 1, listener.getStyleEvents().size());
    }

    /**
     * <p>
     * Tests StylePanel#setFontFamilyStyle(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontFamily is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontFamilyStyle_NullFontFamily() {
        try {
            stylePanel.setFontFamilyStyle(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setFontFamilyStyle(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontFamily is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontFamilyStyle_EmptyFontFamily() {
        try {
            stylePanel.setFontFamilyStyle(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setFontFamilyStyle(String) for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testSetFontFamilyStyle_StyleNotSupportedException() {
        // The polyline doesn't support font name style
        stylePanel.setStyleObject(new PolylineStyleObjectAdapter(new Polyline()));

        try {
            stylePanel.setFontFamilyStyle("Arial");
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setFontSizeStyle(int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setFontSizeStyle(int) is correct.
     * </p>
     */
    public void testSetFontSizeStyle() {
        // The graph node supports font size style
        stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(new GraphNode()));

        listener.clear();

        stylePanel.setFontSizeStyle(15);

        assertEquals("The font size style should be changed.", 1, listener.getStyleEvents().size());
    }

    /**
     * <p>
     * Tests StylePanel#setFontSizeStyle(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when font size is is non-positive
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontSizeStyle_NonPositive() {
        try {
            stylePanel.setFontSizeStyle(-5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setFontSizeStyle(int) for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testSetFontSizeStyle_StyleNotSupportedException() {
        // The polyline doesn't support font size style
        stylePanel.setStyleObject(new PolylineStyleObjectAdapter(new Polyline()));

        try {
            stylePanel.setFontSizeStyle(20);
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setFillColorStyle(Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setFillColorStyle(Color) is correct.
     * </p>
     */
    public void testSetFillColorStyle() {
        // The graph node supports fill color style
        stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(new GraphNode()));

        listener.clear();

        Color color = new Color(88, 55, 66);
        stylePanel.setFillColorStyle(color);

        assertEquals("The fill color style should be changed.", 1, listener.getStyleEvents().size());
    }

    /**
     * <p>
     * Tests StylePanel#setFillColorStyle(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fillColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFillColorStyle_NullFillColor() {
        try {
            stylePanel.setFillColorStyle(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setFillColorStyle(Color) for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testSetFillColorStyle_StyleNotSupportedException() {
        // The GraphEdge doesn't support font name style
        stylePanel.setStyleObject(new GraphEdgeStyleObjectAdapter(new GraphEdge()));
        try {
            stylePanel.setFillColorStyle(Color.red);
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setOutlineColorStyle(Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setOutlineColorStyle(Color) is correct.
     * </p>
     */
    public void testSetOutlineColorStyle() {
        // The graph node supports outline color style
        stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(new GraphNode()));

        listener.clear();

        Color color = new Color(88, 55, 66);
        stylePanel.setOutlineColorStyle(color);

        assertEquals("The outline color style should be changed.", 1, listener.getStyleEvents().size());
    }

    /**
     * <p>
     * Tests StylePanel#setOutlineColorStyle(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when outlineColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetOutlineColorStyle_NullOutlineColor() {
        try {
            stylePanel.setOutlineColorStyle(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setTextColorStyle(Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setTextColorStyle(Color) is correct.
     * </p>
     */
    public void testSetTextColorStyle() {
        // The graph node supports text color style
        stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(new GraphNode()));

        listener.clear();

        Color color = new Color(88, 55, 66);
        stylePanel.setTextColorStyle(color);

        assertEquals("The text color style should be changed.", 1, listener.getStyleEvents().size());
    }

    /**
     * <p>
     * Tests StylePanel#setTextColorStyle(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when textColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetTextColorStyle_NullTextColor() {
        try {
            stylePanel.setTextColorStyle(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setTextColorStyle(Color) for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testSetTextColorStyle_StyleNotSupportedException() {
        // The polyline doesn't support text color style
        stylePanel.setStyleObject(new PolylineStyleObjectAdapter(new Polyline()));
        try {
            stylePanel.setTextColorStyle(Color.red);
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setPositionStyle(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setPositionStyle(Point) is correct.
     * </p>
     */
    public void testSetPositionStyle() {
        // The graph node supports position style
        GraphNode graphNode = new GraphNode();
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(graphNode));

        listener.clear();

        stylePanel.setPositionStyle(new Point(8, 8));

        assertEquals("The position style should be changed.", 2, listener.getStyleEvents().size());
    }

    /**
     * <p>
     * Tests StylePanel#setPositionStyle(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when position is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPositionStyle_NullPosition() {
        try {
            stylePanel.setPositionStyle(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setPositionStyle(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when x-position is non-positive
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPositionStyle_XPosition() {
        try {
            stylePanel.setPositionStyle(new Point(-5, 8));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setPositionStyle(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when y-position is non-positive
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPositionStyle_YPosition() {
        try {
            stylePanel.setPositionStyle(new Point(8, -8));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setPositionStyle(Point) for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testSetPositionStyle_StyleNotSupportedException() {
        // The polyline doesn't support x-position style and x-position style
        stylePanel.setStyleObject(new PolylineStyleObjectAdapter(new Polyline()));
        try {
            stylePanel.setPositionStyle(new Point(5, 5));
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setSizeStyle(Dimension) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setSizeStyle(Dimension) is correct.
     * </p>
     */
    public void testSetSizeStyle() {
        // The graph node supports size style
        GraphNode graphNode = new GraphNode();
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(graphNode));

        listener.clear();

        stylePanel.setSizeStyle(new Dimension(6, 6));

        assertEquals("The size style should be changed.", 2, listener.getStyleEvents().size());
    }

    /**
     * <p>
     * Tests StylePanel#setSizeStyle(Dimension) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when size is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetSizeStyle_NullSize() {
        try {
            stylePanel.setSizeStyle(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setSizeStyle(Dimension) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the height for the size is
     * non-positive and expects IllegalArgumentException.
     * </p>
     */
    public void testSetSizeStyle_HeightInvalid() {
        try {
            stylePanel.setSizeStyle(new Dimension(6, -6));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setSizeStyle(Dimension) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the width for the size is
     * non-positive and expects IllegalArgumentException.
     * </p>
     */
    public void testSetSizeStyle_WidthInvalid() {
        try {
            stylePanel.setSizeStyle(new Dimension(-6, 6));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#setSizeStyle(Dimension) for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testSetSizeStyle_StyleNotSupportedException() {
        // The polyline doesn't support width style and height style
        stylePanel.setStyleObject(new PolylineStyleObjectAdapter(new Polyline()));
        try {
            stylePanel.setSizeStyle(new Dimension(6, 6));
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StylePanel#getFont() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#getFont() is correct.
     * </p>
     */
    public void testGetFont() {
        Font font = new Font("font", 0, 8);
        stylePanel.setFont(font);

        assertSame("Failed to set the correct font.", font, stylePanel.getFont());
    }

    /**
     * <p>
     * Tests StylePanel#setFont(Font) for accuracy.
     * </p>
     *
     * <p>
     * Verify : StylePanel#setFont(Font) is correct.
     * </p>
     */
    public void testSetFont() {
        Font font = new Font("font", 0, 8);
        stylePanel.setFont(font);

        assertSame("Failed to set the correct font.", font, stylePanel.getFont());
    }

    /**
     * <p>
     * Tests StylePanel#setFont(Font) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when font is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFont_NullFont() {
        try {
            stylePanel.setFont(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests the events when the fill color button is clicked and the color palette is clicked.
     * </p>
     *
     * <p>
     * Verify : The fill color should be updated.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFillColor_Click() throws Exception {
        setUpStylePanel();

        JFCTestHelper helper = new JFCTestHelper();
        MouseEventData data = new MouseEventData(this, this.fillColorButton);

        helper.enterClickAndLeave(data);

        ColorPalettePanel panel = (ColorPalettePanel) new ComponentFinder(ColorPalettePanel.class).find();

        EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();
        // click the (2, 1) palette
        MouseEvent pevent = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);
        MouseEvent revent = new MouseEvent(panel, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        eq.postEvent(pevent);
        eq.postEvent(revent);
        flushAWT();

        assertEquals("The fill color should be updated.", new Color(204, 204, 204),
            this.fillColorButton.getBackground());
    }

    /**
     * <p>
     * Tests the events when the outline color button is clicked and the color palette is clicked.
     * </p>
     *
     * <p>
     * Verify : The outline color should be updated.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testOutlineColor_Click() throws Exception {
        setUpStylePanel();

        JFCTestHelper helper = new JFCTestHelper();
        MouseEventData data = new MouseEventData(this, this.outlineColorButton);

        helper.enterClickAndLeave(data);

        ColorPalettePanel panel = (ColorPalettePanel) new ComponentFinder(ColorPalettePanel.class).find();

        EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();

        // click the (2, 1) palette
        MouseEvent pevent = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);
        MouseEvent revent = new MouseEvent(panel, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        eq.postEvent(pevent);
        eq.postEvent(revent);
        flushAWT();

        assertEquals("The outline color should be updated.", new Color(204, 204, 204),
            this.outlineColorButton.getBackground());
    }

    /**
     * <p>
     * Tests the events when the text color button is clicked and the color palette is clicked.
     * </p>
     *
     * <p>
     * Verify : The text color should be updated.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTextColor_Click() throws Exception {
        setUpStylePanel();

        JFCTestHelper helper = new JFCTestHelper();
        MouseEventData data = new MouseEventData(this, this.textColorButton);

        helper.enterClickAndLeave(data);

        ColorPalettePanel panel = (ColorPalettePanel) new ComponentFinder(ColorPalettePanel.class).find();

        EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();

        // click the (2, 1) palette
        MouseEvent pevent = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);
        MouseEvent revent = new MouseEvent(panel, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        eq.postEvent(pevent);
        eq.postEvent(revent);
        flushAWT();

        assertEquals("The text color should be updated.", new Color(204, 204, 204),
            this.textColorButton.getBackground());
    }

    /**
     * <p>
     * Set up the frame instance and show it.
     * </p>
     *
     * <p>
     * This method also use the functionality of the JFCUnit
     * to find the widgets in the style panel.
     * </p>
     */
    private void setUpStylePanel() {
        frame.setVisible(true);

        // locate the widgets in style panel
        this.fillColorButton = (JButton) createFinder("Fill:").find(frame, 0);
        this.outlineColorButton = (JButton) createFinder("Outline:").find(frame, 0);
        this.textColorButton = (JButton) createFinder("Text:").find(frame, 0);
        this.widthTextField = (JTextField) createFinder("W:").find(frame, 0);
        this.heightTextField = (JTextField) createFinder("H:").find(frame, 0);
        this.xTextField = (JTextField) createFinder("X:").find(frame, 0);
        this.yTextField = (JTextField) createFinder("Y:").find(frame, 0);
        this.fontFamilySelector = (FontFamilySelector) createFinder("Fonts:").find(frame, 0);
        this.fontSizeSelector = (FontSizeSelector) createFinder("Size:").find(frame, 0);

        flushAWT();

    }

    /**
     * <p>
     * Creates a Finder for locating the widgets based on the given text.
     * </p>
     *
     * @param text the text to find the widget
     *
     * @return a Finder instance for locating the widget
     */
    private Finder createFinder(String text) {
        Finder finder = new LabeledComponentFinder(text, true);
        finder.setOperation(Finder.OP_EQUALS);

        return finder;
    }

    /**
     * <p>
     * This method creates the GraphNode instance for testing.
     * </p>
     *
     * @return a GraphNode instance for testing.
     */
    private GraphNode createGraphNode() {
        GraphNode node = new GraphNode();
        com.topcoder.diagraminterchange.Point point = new com.topcoder.diagraminterchange.Point();
        point.setX(10.0);
        point.setY(11.0);
        node.setPosition(point);
        com.topcoder.diagraminterchange.Dimension dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setHeight(13.0);
        dimension.setWidth(12.0);
        node.setSize(dimension);
        node.addProperty(TestHelper.createProperty(stylePanel.getFillColorKey(), "#00FF00"));
        node.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "#FF0000"));
        node.addProperty(TestHelper.createProperty(stylePanel.getTextColorKey(), "#0000FF"));
        node.addProperty(TestHelper.createProperty(stylePanel.getFontNameKey(), "Arial"));
        node.addProperty(TestHelper.createProperty(stylePanel.getFontSizeKey(), "8"));
        return node;
    }

    /**
     * <p>
     * This method creates the GraphNode instance for testing.
     * </p>
     *
     * @return a GraphNode instance for testing.
     */
    private GraphEdge createGraphEdge() {
        GraphEdge edge = new GraphEdge();
        com.topcoder.diagraminterchange.Point point = new com.topcoder.diagraminterchange.Point();
        point.setX(20.0);
        point.setY(11.0);
        edge.setPosition(point);
        edge.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "#FF0000"));
        edge.addProperty(TestHelper.createProperty(stylePanel.getTextColorKey(), "#0000FF"));
        edge.addProperty(TestHelper.createProperty(stylePanel.getFontNameKey(), "Arial"));
        edge.addProperty(TestHelper.createProperty(stylePanel.getFontSizeKey(), "8"));
        return edge;
    }

}