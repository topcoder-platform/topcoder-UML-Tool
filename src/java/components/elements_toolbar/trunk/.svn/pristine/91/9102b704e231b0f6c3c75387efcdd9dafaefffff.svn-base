/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import com.topcoder.gui.toolbars.elements.mock.MockElementSelectedListener;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The unit test for <code>SectionPanel</code>.
 *
 * @author enefem21
 * @version 1.0
 */
public class SectionPanelTest extends TestCase {

    /** Look and Feel class that is used in the parametric constructor. */
    private static final String LNF_CLASS_NAME_PARAMETRIC = UIManager.getSystemLookAndFeelClassName();

    /** Look and Feel class that is used in the configuration constructor. */
    private static final String LNF_CLASS_NAME_NAMESPACE = "javax.swing.plaf.metal.MetalLookAndFeel";

    /** Image icons used in the unit test. */
    private static final ImageIcon[] IMAGE_ICONS =
        new ImageIcon[] {new ImageIcon("icon/jurnelles.gif"), new ImageIcon("icon/loupe-black.gif")};

    /** Unit under test. */
    private SectionPanel sectionPanel;

    /**
     * <p>
     * Creates a test suite of the tests contained in this class.
     * </p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(SectionPanelTest.class);
    }

    /**
     * Sets the unit test up.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        sectionPanel =
            new SectionPanel("title", Color.WHITE, new String[] {"buttonName1", "buttonName2"}, IMAGE_ICONS,
                LNF_CLASS_NAME_PARAMETRIC);

    }

    /**
     * Tears the unit test down.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearNamespaces();

        sectionPanel = null;

        super.tearDown();
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: sectionText is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersNullSectionText() {
        try {
            new SectionPanel(null, Color.WHITE, new String[] {"buttonName1", "buttonName2"}, IMAGE_ICONS,
                LNF_CLASS_NAME_PARAMETRIC);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: sectionText is an empty string. Expect:
     * no exception, instead a section panel without any buttons should be created.
     */
    public void testSectionPanelParametersEmptyStringSectionText() {
        SectionPanel panel =
            new SectionPanel("", Color.WHITE, new String[] {"buttonName1", "buttonName2"}, IMAGE_ICONS,
                LNF_CLASS_NAME_PARAMETRIC);

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_PARAMETRIC, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.WHITE, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 2, panelButtons.getComponentCount());

        // make sure all components are a JToggleButton
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: backgroundColor is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersNullBackgroundColor() {
        try {
            new SectionPanel("Section Text", null, new String[] {"buttonName1", "buttonName2"}, IMAGE_ICONS,
                LNF_CLASS_NAME_PARAMETRIC);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: buttonNames is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersNullButtonNames() {
        try {
            new SectionPanel("Section Text", Color.WHITE, null, IMAGE_ICONS, LNF_CLASS_NAME_PARAMETRIC);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: buttonNames contains null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersContainNullButtonNames() {
        try {
            new SectionPanel("Section Text", Color.WHITE, new String[] {"buttonName1", null}, IMAGE_ICONS,
                LNF_CLASS_NAME_PARAMETRIC);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: buttonNames contains empty string.
     * Expect: <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersContainEmptyStringButtonNames() {
        try {
            new SectionPanel("Section Text", Color.WHITE, new String[] {"buttonName1", "   \n"}, IMAGE_ICONS,
                LNF_CLASS_NAME_PARAMETRIC);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: imageIcons is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersNullImageIcons() {
        try {
            new SectionPanel("Section Text", Color.WHITE, new String[] {"buttonName1", "buttonName2"}, null,
                LNF_CLASS_NAME_PARAMETRIC);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: imageIcons contains null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersContainNullImageIcons() {
        try {
            new SectionPanel("Section Text", Color.WHITE, new String[] {"buttonName1", "buttonName2"},
                new ImageIcon[] {new ImageIcon("icon/jurnelles.png"), null}, LNF_CLASS_NAME_PARAMETRIC);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: look is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersNullLook() {
        try {
            new SectionPanel("Section Text", Color.WHITE, new String[] {"buttonName1", "buttonName2"},
                IMAGE_ICONS, null);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: look is an empty string. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersEmptyStringLook() {
        try {
            new SectionPanel("Section Text", Color.WHITE, new String[] {"buttonName1", "buttonName2"},
                IMAGE_ICONS, "");
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor. Condition: the number of elements in imageIcons and
     * buttonNames is not equal. Expect: <code>IllegalArgumentException</code>.
     */
    public void testSectionPanelParametersLengthNotEqual() {
        try {
            new SectionPanel("Section Text", Color.WHITE, new String[] {"buttonName1", "buttonName2",
                "buttonName3"}, IMAGE_ICONS, LNF_CLASS_NAME_PARAMETRIC);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> parametric constructor for accuracy. Condition: normal. Expect: no
     * exception, section panel with all properties should be created.
     */
    public void testSectionPanelParametersAccuracy() {
        SectionPanel panel =
            new SectionPanel("Section Text", Color.WHITE, new String[] {"buttonName1", "buttonName2"},
                IMAGE_ICONS, LNF_CLASS_NAME_PARAMETRIC);

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_PARAMETRIC, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.WHITE, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "Section Text", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 2, panelButtons.getComponentCount());

        // make sure all components are a JToggleButton
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: namespace is null. Expect:
     * <code>IllegalArgumentException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceNull() throws Exception {

        try {
            new SectionPanel(null);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: namespace is an empty string.
     * Expect: <code>IllegalArgumentException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceEmptyString() throws Exception {

        try {
            new SectionPanel("   \t ");
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: namespace is unknown. Expect:
     * <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceUnknownNamespace() throws Exception {

        try {
            new SectionPanel("unknownNamespace");
            fail("Should raise SectionPanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: there is no look property in
     * the namespace. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceNoLook() throws Exception {
        TestHelper.loadConfiguration("no_look_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the look property in the
     * namespace is an empty string. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceEmptyStringLook() throws Exception {
        TestHelper.loadConfiguration("empty_string_look_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: there is no sectionText
     * property in the namespace. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceNoSectionText() throws Exception {
        TestHelper.loadConfiguration("no_section_text_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: sectionText is an empty string.
     * Expect: no exception, panel is created with empty label.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceEmptyStringSectionText() throws Exception {

        TestHelper.loadConfiguration("empty_string_section_text_configuration.xml");

        SectionPanel panel = new SectionPanel("com.topcoder.gui.toolbars.elements");

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_NAMESPACE, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.YELLOW, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 2, panelButtons.getComponentCount());

        // make sure all components are a JToggleButton
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);
        }

    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: backgroundColor is null.
     * Expect: no exception, panel is created with Color.LIGHT_GRAY as the color of the section text panel.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceNoBackgroundColor() throws Exception {
        TestHelper.loadConfiguration("no_background_color_configuration.xml");

        SectionPanel panel = new SectionPanel("com.topcoder.gui.toolbars.elements");

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_NAMESPACE, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.LIGHT_GRAY, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "connectors", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 2, panelButtons.getComponentCount());

        // make sure all components are a JToggleButton
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the background color property
     * is an empty string. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceEmptyStringBackgroundColor() throws Exception {
        TestHelper.loadConfiguration("empty_string_background_color_configuration.xml");

        SectionPanel panel = new SectionPanel("com.topcoder.gui.toolbars.elements");

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_NAMESPACE, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.LIGHT_GRAY, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "connectors", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 2, panelButtons.getComponentCount());

        // make sure all components are a JToggleButton
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the background color property
     * is not a valid color string. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceNotValidBackgroundColor() throws Exception {
        TestHelper.loadConfiguration("not_valid_background_color_configuration.xml");

        SectionPanel panel = new SectionPanel("com.topcoder.gui.toolbars.elements");

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_NAMESPACE, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.LIGHT_GRAY, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "connectors", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 2, panelButtons.getComponentCount());

        // make sure all components are a JToggleButton
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: there is no buttonsName
     * property but there is imageLocations property. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceNoButtonsName() throws Exception {
        TestHelper.loadConfiguration("no_buttons_name_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the buttonsName property is
     * empty but there is imageLocations property. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceEmptyButtonsName() throws Exception {
        TestHelper.loadConfiguration("empty_buttons_name_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the buttonsName property is not
     * empty but there is an element that is an empty string. Expect:
     * <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceButtonsNameContainsEmptyString() throws Exception {
        TestHelper.loadConfiguration("buttons_name_contain_empty_string_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: there is no imageLocations
     * property but there is some elements of buttonsName property. Expect:
     * <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceNoImageLocations() throws Exception {
        TestHelper.loadConfiguration("no_image_locations_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the imageLocations property is
     * empty but there is some elements of buttonsName property. Expect:
     * <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceEmptyImageLocations() throws Exception {
        TestHelper.loadConfiguration("empty_image_locations_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the imageLocations property is
     * not empty but there is an element that is an empty string. Expect:
     * <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceImageLocationsContainsEmptyString() throws Exception {
        TestHelper.loadConfiguration("image_locations_contain_empty_string_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the imageLocations contains
     * non-exist filename. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceImageLocationsContainsUnexistFilename() throws Exception {
        TestHelper.loadConfiguration("image_locations_contain_unexist_filename_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the look class is unknown.
     * Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceUnknownClassLook() throws Exception {
        TestHelper.loadConfiguration("unknown_class_look_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the look class is not a look
     * and feel class. Expect: <code>SectionPanelConfigurationException</code>.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceClassCasrLook() throws Exception {
        TestHelper.loadConfiguration("class_cast_look_configuration.xml");

        try {
            new SectionPanel("com.topcoder.gui.toolbars.elements");
            fail("Should raise StylePanelConfigurationException");
        } catch (SectionPanelConfigurationException e) {
            // expected
        }
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: there is no imageLocations
     * property and there is no buttonsName property. Expect: no exception, panel is created with no button.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceNoButtonsNameAndImageLocations() throws Exception {
        TestHelper.loadConfiguration("no_buttons_name_image_locations_configuration.xml");

        SectionPanel panel = new SectionPanel("com.topcoder.gui.toolbars.elements");

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_NAMESPACE, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.YELLOW, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "connectors", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 0, panelButtons.getComponentCount());

    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor. Condition: the imageLocations property is
     * empty and the buttonsName property is empty. Expect: no exception, panel is created with no button.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceEmptyButtonsNameAndImageLocations() throws Exception {
        TestHelper.loadConfiguration("empty_buttons_name_image_locations_configuration.xml");

        SectionPanel panel = new SectionPanel("com.topcoder.gui.toolbars.elements");

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_NAMESPACE, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.YELLOW, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "connectors", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 0, panelButtons.getComponentCount());
    }

    /**
     * Test <code>SectionPanel</code> configuration-based constructor for accuracy. Condition: normal. Expect: no
     * exception, panel is created and all properties are checked.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSectionPanelNamespaceAccuracy() throws Exception {
        TestHelper.loadConfiguration("standard_configuration.xml");

        SectionPanel panel = new SectionPanel("com.topcoder.gui.toolbars.elements");

        assertEquals("look and feel is not as expected", LNF_CLASS_NAME_NAMESPACE, UIManager.getLookAndFeel()
            .getClass().getName());

        assertEquals("Number of components is not as expected", 2, panel.getComponentCount());

        // retrieve the section text panel
        JPanel panelSectionText = (JPanel) panel.getComponent(0);

        assertEquals("The background color is not as expected", Color.YELLOW, panelSectionText.getBackground());

        // retrieve the label
        JLabel label = (JLabel) panelSectionText.getComponent(0);

        assertEquals("Number of components is not as expected", "connectors", label.getText());

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) panel.getComponent(1);

        assertEquals("Number of buttons is not as expected", 2, panelButtons.getComponentCount());

        // make sure all components are a JToggleButton
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);
        }
    }

    /**
     * Test <code>unselectButton</code>. Condition: buttonName is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testUnselectButtonNullButtonName() {
        try {
            sectionPanel.unselectButton(null);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>unselectButton</code>. Condition: buttonName is an empty string. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testUnselectButtonEmptyStringButtonName() {
        try {
            sectionPanel.unselectButton("   ");
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>unselectButton</code> for accuracy. Condition: normal, button is on the panel. Expect: button
     * with 'buttonName2' as the text should be unselected.
     */
    public void testUnselectButtonAccuracy() {
        sectionPanel.unselectButton("buttonName2");

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        JToggleButton button = null;

        // find the button in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            if (temp.getName().equals("buttonName2")) {
                button = temp;
                break;
            }
        }

        // check that the button is unselected
        if (button == null) {
            fail("buttonName2 can't be found");
        } else {
            assertFalse("buttonName2 is not unselected", button.isSelected());
        }
    }

    /**
     * Test <code>unselectButton</code> for accuracy. Condition: normal, button is not on the panel. Expect:
     * nothing to do.
     */
    public void testUnselectButtonAccuracy2() {
        sectionPanel.unselectButton("unknownButton");

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        JToggleButton button = null;

        // find the button in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            if (temp.getText().equals("unknownButton")) {
                button = temp;
                break;
            }
        }

        // check that the button is unselected
        if (button == null) {
            // success
        } else {
            fail("unknownButton should be not found");
        }
    }

    /**
     * Test <code>addElementSelectedListener</code>. Condition: buttonName is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddElementSelectedListenerNullButtonName() {
        try {
            sectionPanel.addElementSelectedListener(null, new MockElementSelectedListener());
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addElementSelectedListener</code>. Condition: buttonName is an empty string. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddElementSelectedListenerEmptyStringButtonName() {
        try {
            sectionPanel.addElementSelectedListener("", new MockElementSelectedListener());
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addElementSelectedListener</code>. Condition: elementSelectedListener is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddElementSelectedListenerNullListener() {
        try {
            sectionPanel.addElementSelectedListener("buttonName", null);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addElementSelectedListener</code> for accuracy. Condition: normal, add a listener to a button.
     * Expect: listener should be added.
     */
    public void testAddElementSelectedListenerAccuracy() {
        MockElementSelectedListener listener = new MockElementSelectedListener();
        sectionPanel.addElementSelectedListener("buttonName2", listener);

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        JToggleButton button = null;

        // find the button in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            if (temp.getName().equals("buttonName2")) {
                button = temp;
                button.doClick();
                break;
            }
        }

        if (!listener.isExecuted()) {
            fail("listener should be notified on selected event");
        }
    }

    /**
     * Test <code>addElementSelectedListener</code> for accuracy. Condition: normal, add a listener two times to
     * a button. Expect: listener should be added only one time.
     */
    public void testAddElementSelectedListenerAccuracy2() {
        MockElementSelectedListener listener = new MockElementSelectedListener();
        sectionPanel.addElementSelectedListener("buttonName2", listener);
        sectionPanel.addElementSelectedListener("buttonName2", listener);

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        JToggleButton button = null;

        // find the button in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            if (temp.getName().equals("buttonName2")) {
                button = temp;
                button.doClick();
                break;
            }
        }

        if (!listener.isExecuted()) {
            fail("listener should be notified on selected event");
        }

        assertEquals("Listener should only be notified one time", 1, listener.getNumberOfExecution());
    }

    /**
     * Test <code>addElementSelectedListener</code> for accuracy. Condition: normal, variation. Expect: listener
     * should be notified accordingly.
     */
    public void testAddElementSelectedListenerAccuracy3() {
        MockElementSelectedListener listener = new MockElementSelectedListener();
        sectionPanel.addElementSelectedListener("buttonName2", listener);
        MockElementSelectedListener listener2 = new MockElementSelectedListener();
        sectionPanel.addElementSelectedListener("buttonName2", listener2);
        MockElementSelectedListener listener3 = new MockElementSelectedListener();
        sectionPanel.addElementSelectedListener("buttonName", listener3);

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        JToggleButton button = null;

        // find the button in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            if (temp.getName().equals("buttonName2")) {
                button = temp;
                button.doClick();
                break;
            }
        }

        if (!listener.isExecuted()) {
            fail("listener should be notified on selected event");
        }

        if (!listener2.isExecuted()) {
            fail("listener should be notified on selected event");
        }

        if (listener3.isExecuted()) {
            fail("listener should not be notified on selected event");
        }
    }

    /**
     * Test <code>removeElementSelectedListener</code>. Condition: buttonName is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testRemoveElementSelectedListenerNullButtonName() {
        try {
            sectionPanel.removeElementSelectedListener(null, new MockElementSelectedListener());
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>removeElementSelectedListener</code>. Condition: buttonName is an empty string. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testRemoveElementSelectedListenerEmptyStringButtonName() {
        try {
            sectionPanel.removeElementSelectedListener("", new MockElementSelectedListener());
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>removeElementSelectedListener</code>. Condition: elementSelectedListener is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testRemoveElementSelectedListenerNullListener() {
        try {
            sectionPanel.removeElementSelectedListener("buttonName", null);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>removeElementSelectedListener</code> for accuracy. Condition: normal, remove an exist listener.
     * Expect: listener should not be notified.
     */
    public void testRemoveElementSelectedListenerAccuracy() {
        MockElementSelectedListener listener = new MockElementSelectedListener();
        sectionPanel.addElementSelectedListener("buttonName2", listener);
        sectionPanel.removeElementSelectedListener("buttonName2", listener);

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        JToggleButton button = null;

        // find the button in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            if (temp.getName().equals("buttonName2")) {
                button = temp;
                button.doClick();
                break;
            }
        }

        if (listener.isExecuted()) {
            fail("listener should not be notified on selected event");
        }
    }

    /**
     * Test <code>removeElementSelectedListener</code> for accuracy. Condition: normal, remove an non-exist
     * listener. Expect: listener should not be notified.
     */
    public void testRemoveElementSelectedListenerAccuracy2() {
        MockElementSelectedListener listener = new MockElementSelectedListener();
        sectionPanel.removeElementSelectedListener("buttonName2", listener);

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        JToggleButton button = null;

        // find the button in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            if (temp.getName().equals("buttonName2")) {
                button = temp;
                button.doClick();
                break;
            }
        }

        if (listener.isExecuted()) {
            fail("listener should not be notified on selected event");
        }
    }

    /**
     * Test <code>addListenerForAllButtons</code>. Condition: listener is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddListenerForAllButtonsNullListener() {
        try {
            sectionPanel.addListenerForAllButtons(null);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addListenerForAllButtons</code> for accuracy. Condition: normal. Expect: listener should be
     * notified for any button action.
     */
    public void testAddListenerForAllButtonsAccuracy() {
        MockElementSelectedListener listener = new MockElementSelectedListener();
        sectionPanel.addListenerForAllButtons(listener);

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        // click all buttons in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            temp.doClick();
        }

        if (!listener.isExecuted()) {
            fail("listener should be notified on selected event");
        }

        assertEquals("Listener should be notified two times", 2, listener.getNumberOfExecution());
    }

    /**
     * Test <code>addListenerForAllButtons</code> for accuracy. Condition: normal. Expect: listener should be
     * notified for any button action.
     */
    public void testAddListenerForAllButtonsAccuracy2() {
        MockElementSelectedListener listener = new MockElementSelectedListener();
        sectionPanel.addListenerForAllButtons(listener);

        // retrieve the buttons panel
        JPanel panelButtons = (JPanel) sectionPanel.getComponent(1);

        JToggleButton button = null;

        // find the button in the panel
        for (Component component : panelButtons.getComponents()) {
            assertTrue("This is not a JToggleButton", component instanceof JToggleButton);

            JToggleButton temp = (JToggleButton) component;

            if (temp.getName().equals("buttonName2")) {
                button = temp;
                button.doClick();
                break;
            }
        }

        if (!listener.isExecuted()) {
            fail("listener should be notified on selected event");
        }

        assertEquals("Listener should be notified one time", 1, listener.getNumberOfExecution());
    }

}
