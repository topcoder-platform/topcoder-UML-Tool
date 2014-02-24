/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ColorPalettePanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class ColorPalettePanelTests extends TestCase {
    /**
     * <p>
     * The Color array used for the palette when it is created using the default constructor.
     * </p>
     */
    private static final Color[][] DEFAULT_COLORS = new Color[][] {
    // row 1
        {new Color(255, 255, 255), new Color(204, 255, 255), new Color(204, 204, 255), new Color(204, 204, 255),
            new Color(204, 204, 255), new Color(204, 204, 255), new Color(204, 204, 255), new Color(204, 204, 255),
            new Color(204, 204, 255), new Color(204, 204, 255), new Color(204, 204, 255), new Color(255, 204, 255),
            new Color(255, 204, 204), new Color(255, 204, 204), new Color(255, 204, 204), new Color(255, 204, 204),
            new Color(255, 204, 204), new Color(255, 204, 204), new Color(255, 204, 204), new Color(255, 204, 204),
            new Color(255, 204, 204), new Color(255, 255, 204), new Color(204, 255, 204), new Color(204, 255, 204),
            new Color(204, 255, 204), new Color(204, 255, 204), new Color(204, 255, 204), new Color(204, 255, 204),
            new Color(204, 255, 204), new Color(204, 255, 204), new Color(204, 255, 204)},
        // row 2
        {new Color(204, 204, 204), new Color(153, 255, 255), new Color(153, 204, 255), new Color(153, 153, 255),
            new Color(153, 153, 255), new Color(153, 153, 255), new Color(153, 153, 255), new Color(153, 153, 255),
            new Color(153, 153, 255), new Color(153, 153, 255), new Color(204, 153, 255), new Color(255, 153, 255),
            new Color(255, 153, 204), new Color(255, 153, 153), new Color(255, 153, 153), new Color(255, 153, 153),
            new Color(255, 153, 153), new Color(255, 153, 153), new Color(255, 153, 153), new Color(255, 153, 153),
            new Color(255, 204, 153), new Color(255, 255, 153), new Color(204, 255, 153), new Color(153, 255, 153),
            new Color(153, 255, 153), new Color(153, 255, 153), new Color(153, 255, 153), new Color(153, 255, 153),
            new Color(153, 255, 153), new Color(153, 255, 153), new Color(153, 255, 204)},
        // row 3
        {new Color(204, 204, 204), new Color(102, 255, 255), new Color(102, 204, 255), new Color(102, 153, 255),
            new Color(102, 102, 255), new Color(102, 102, 255), new Color(102, 102, 255), new Color(102, 102, 255),
            new Color(102, 102, 255), new Color(153, 102, 255), new Color(204, 102, 255), new Color(255, 102, 255),
            new Color(255, 102, 204), new Color(255, 102, 153), new Color(255, 102, 102), new Color(255, 102, 102),
            new Color(255, 102, 102), new Color(255, 102, 102), new Color(255, 102, 102), new Color(255, 153, 102),
            new Color(255, 204, 102), new Color(255, 255, 102), new Color(204, 255, 102), new Color(153, 255, 102),
            new Color(102, 255, 102), new Color(102, 255, 102), new Color(102, 255, 102), new Color(102, 255, 102),
            new Color(102, 255, 102), new Color(102, 255, 153), new Color(102, 255, 204)},
        // row 4
        {new Color(153, 153, 153), new Color(51, 255, 255), new Color(51, 204, 255), new Color(51, 153, 255),
            new Color(51, 102, 255), new Color(51, 51, 255), new Color(51, 51, 255), new Color(51, 51, 255),
            new Color(102, 51, 255), new Color(153, 51, 255), new Color(204, 51, 255), new Color(255, 51, 255),
            new Color(255, 51, 204), new Color(255, 51, 153), new Color(255, 51, 102), new Color(255, 51, 51),
            new Color(255, 51, 51), new Color(255, 51, 51), new Color(255, 102, 51), new Color(255, 153, 51),
            new Color(255, 204, 51), new Color(255, 255, 51), new Color(204, 255, 51), new Color(153, 244, 51),
            new Color(102, 255, 51), new Color(51, 255, 51), new Color(51, 255, 51), new Color(51, 255, 51),
            new Color(51, 255, 102), new Color(51, 255, 153), new Color(51, 255, 204)},
        // row 5
        {new Color(153, 153, 153), new Color(0, 255, 255), new Color(0, 204, 255), new Color(0, 153, 255),
            new Color(0, 102, 255), new Color(0, 51, 255), new Color(0, 0, 255), new Color(51, 0, 255),
            new Color(102, 0, 255), new Color(153, 0, 255), new Color(204, 0, 255), new Color(255, 0, 255),
            new Color(255, 0, 204), new Color(255, 0, 153), new Color(255, 0, 102), new Color(255, 0, 51),
            new Color(255, 0, 0), new Color(255, 51, 0), new Color(255, 102, 0), new Color(255, 153, 0),
            new Color(255, 204, 0), new Color(255, 255, 0), new Color(204, 255, 0), new Color(153, 255, 0),
            new Color(102, 255, 0), new Color(51, 255, 0), new Color(0, 255, 0), new Color(0, 255, 51),
            new Color(0, 255, 102), new Color(0, 255, 153), new Color(0, 255, 204)},
        // row 6
        {new Color(102, 102, 102), new Color(0, 204, 204), new Color(0, 204, 204), new Color(0, 153, 204),
            new Color(0, 102, 204), new Color(0, 51, 204), new Color(0, 0, 204), new Color(51, 0, 204),
            new Color(102, 0, 204), new Color(153, 0, 204), new Color(204, 0, 204), new Color(204, 0, 204),
            new Color(204, 0, 204), new Color(204, 0, 153), new Color(204, 0, 102), new Color(204, 0, 51),
            new Color(204, 0, 0), new Color(204, 51, 0), new Color(204, 102, 0), new Color(204, 153, 0),
            new Color(204, 204, 0), new Color(204, 204, 0), new Color(204, 204, 0), new Color(153, 204, 0),
            new Color(102, 204, 0), new Color(51, 204, 0), new Color(0, 204, 0), new Color(0, 204, 51),
            new Color(0, 204, 102), new Color(0, 204, 153), new Color(0, 204, 204)},
        // row 7
        {new Color(102, 102, 102), new Color(0, 153, 153), new Color(0, 153, 153), new Color(0, 153, 153),
            new Color(0, 102, 153), new Color(0, 51, 153), new Color(0, 0, 153), new Color(51, 0, 153),
            new Color(102, 0, 153), new Color(153, 0, 153), new Color(153, 0, 153), new Color(153, 0, 153),
            new Color(153, 0, 153), new Color(153, 0, 153), new Color(153, 0, 102), new Color(153, 0, 51),
            new Color(153, 0, 0), new Color(153, 51, 0), new Color(153, 102, 0), new Color(153, 153, 0),
            new Color(153, 153, 0), new Color(153, 153, 0), new Color(153, 153, 0), new Color(153, 153, 0),
            new Color(102, 153, 0), new Color(51, 153, 0), new Color(0, 153, 0), new Color(0, 153, 51),
            new Color(0, 153, 102), new Color(0, 153, 153), new Color(0, 153, 153)},
        // row 8
        {new Color(51, 51, 51), new Color(0, 102, 102), new Color(0, 102, 102), new Color(0, 102, 102),
            new Color(0, 102, 102), new Color(0, 51, 102), new Color(0, 0, 102), new Color(51, 0, 102),
            new Color(102, 0, 102), new Color(102, 0, 102), new Color(102, 0, 102), new Color(102, 0, 102),
            new Color(102, 0, 102), new Color(102, 0, 102), new Color(102, 0, 102), new Color(102, 0, 51),
            new Color(102, 0, 0), new Color(102, 51, 0), new Color(102, 102, 0), new Color(102, 102, 0),
            new Color(102, 102, 0), new Color(102, 102, 0), new Color(102, 102, 0), new Color(102, 102, 0),
            new Color(102, 102, 0), new Color(51, 102, 0), new Color(0, 102, 0), new Color(0, 102, 51),
            new Color(0, 102, 102), new Color(0, 102, 102), new Color(0, 102, 102)},
        //  row 9
        {new Color(0, 0, 0), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51),
            new Color(0, 51, 51), new Color(0, 0, 51), new Color(51, 0, 51), new Color(51, 0, 51),
            new Color(51, 0, 51), new Color(51, 0, 51), new Color(51, 0, 51), new Color(51, 0, 51),
            new Color(51, 0, 51), new Color(51, 0, 51), new Color(51, 0, 51), new Color(51, 0, 0),
            new Color(51, 51, 0), new Color(51, 51, 0), new Color(51, 51, 0), new Color(51, 51, 0),
            new Color(51, 51, 0), new Color(51, 51, 0), new Color(51, 51, 0), new Color(51, 51, 0),
            new Color(0, 51, 0), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51),
            new Color(0, 51, 51), new Color(51, 51, 51)}};

    /**
     * <p>
     * The Color array used for the palette when it is created using the constructor with namespace specified.
     * </p>
     */
    private static final Color[][] CONFIG_COLORS = new Color[][] {
    // row 1
        {new Color(0, 0, 0), new Color(0, 255, 0)},
        // row 2
        {new Color(0, 0, 255), new Color(255, 0, 0)}};

    /**
     * <p>
     * ColorPalettePanel instance for testing.
     * </p>
     *
     * <p>
     * Note, this instance is created without namespace.
     * </p>
     */
    private ColorPalettePanel palette;

    /**
     * <p>
     * ColorPalettePanel instance for testing.
     * </p>
     *
     * <p>
     * Note, this instance is created with namespace.
     * </p>
     */
    private ColorPalettePanel configedPalette;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);

        palette = new ColorPalettePanel();
        configedPalette = new ColorPalettePanel(TestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(TestHelper.NAMESPACE);
        palette = null;
        configedPalette = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ColorPalettePanelTests.class);
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ColorPalettePanel instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new ColorPalettePanel instance.", configedPalette);

        assertEquals("Failed to get correct tool tip.", "", configedPalette.getToolTipText());
        assertTrue("The Opaque should be true.", configedPalette.isOpaque());
        assertEquals("Failed to get correct background color.", Color.WHITE, configedPalette.getBackground());
        assertFalse("The request focus enabled should be false.", configedPalette.isRequestFocusEnabled());
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new ColorPalettePanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new ColorPalettePanel("  ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is missing and expects StylePanelConfigurationException.
     * </p>
     */
    public void testCtor1_MissingNamespace() {
        try {
            new ColorPalettePanel("test");
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when palette property is missing and expects the
     * default value used.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_PaletteMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_NoPalette.xml");

        configedPalette = new ColorPalettePanel(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new ColorPalettePanel instance.", configedPalette);

        assertEquals("Failed to get correct tool tip.", "", configedPalette.getToolTipText());
        assertTrue("The Opaque should be true.", configedPalette.isOpaque());
        assertEquals("Failed to get correct background color.", Color.WHITE, configedPalette.getBackground());
        assertFalse("The request focus enabled should be false.", configedPalette.isRequestFocusEnabled());
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when width property is missing but height property is present
     * and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_WidthMissingHeightPresent() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_NoWidth.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when height property is missing but width property is present
     * and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_WidthPresentHeightMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_NoHeight.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when height property and width property are missing
     * and expects success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_WidthMissingHeightMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_NoWidthAndHeight.xml");

        configedPalette = new ColorPalettePanel(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new ColorPalettePanel instance.", configedPalette);

        // the default width and height are used
        Dimension size = palette.getPreferredSize();
        assertEquals("Failed to get the correct width.", 309, size.width);
        assertEquals("Failed to get the correct height.", 98, size.height);
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when width property is invalid and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InvalidWidth() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_InvalidWidth.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when height property is invalid and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InvalidHeight() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files"
            + File.separator + "config_InvalidHeight.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when rows property is missing but columns property is present
     * and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_RowsMissingColumnsPresent() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_NoRows.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when rows property is present but columns property is missing
     * and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_RowsPresentColumnsMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_NoColumns.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when rows property and columns property are missing
     * and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_RowsMissingColumnsMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_NoRowsAndColumns.xml");

        configedPalette = new ColorPalettePanel(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new ColorPalettePanel instance.", configedPalette);

        // the default rows and columns are used
        Dimension size = palette.getPreferredSize();

        assertEquals("Failed to get the correct width.", 309, size.width);
        assertEquals("Failed to get the correct height.", 98, size.height);
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when rows property is invalid and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InvalidRows() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_InvalidRows.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when columns property is invalid and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InvalidColumns() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_InvalidColumns.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when colors property is missing and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_ColorsMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_NoPaletteColor.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when some color is missing and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_ColorMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_ColorMissing.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when some color string is invalid and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InvalidColor() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_ColorInvalid.xml");
        try {
            new ColorPalettePanel(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorPalettePanel#ColorPalettePanel() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ColorPalettePanel instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new ColorPalettePanel instance.", palette);

        assertEquals("Failed to get correct tool tip.", "", palette.getToolTipText());
        assertTrue("The Opaque should be true.", palette.isOpaque());
        assertEquals("Failed to get correct background color.", Color.WHITE, palette.getBackground());
        assertFalse("The request focus enabled should be false.", palette.isRequestFocusEnabled());
    }

    /**
     * <p>
     * Tests ColorPalettePanel#getPreferredSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorPalettePanel#getPreferredSize() is correct.
     * </p>
     */
    public void testGetPreferredSize() {
        Dimension size = palette.getPreferredSize();

        assertEquals("Failed to get the correct width.", 309, size.width);
        assertEquals("Failed to get the correct height.", 98, size.height);
    }

    /**
     * <p>
     * Tests ColorPalettePanel#getPreferredSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorPalettePanel#getPreferredSize() is correct.
     * </p>
     */
    public void testGetPreferredSize2() {
        Dimension size = configedPalette.getPreferredSize();

        assertEquals("Failed to get the correct width.", 21, size.width);
        assertEquals("Failed to get the correct height.", 21, size.height);
    }

    /**
     * <p>
     * Tests ColorPalettePanel#getColorForLocation(int,int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorPalettePanel#getColorForLocation(int,int) is correct.
     * </p>
     */
    public void testGetColorForLocation() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 31; j++) {
                // Get the x and y values for the (i, j) palette
                int posX = 10 * j + 5;
                int posY = 11 * i + 5;
                assertEquals("Failed to get the correct color.", DEFAULT_COLORS[i][j], palette.getColorForLocation(
                    posX, posY));
            }
        }
    }

    /**
     * <p>
     * Tests ColorPalettePanel#getColorForLocation(int,int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorPalettePanel#getColorForLocation(int,int) is correct.
     * </p>
     */
    public void testGetColorForLocation2() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                // Get the x and y values for the (i, j) palette
                int posX = 11 * j + 5;
                int posY = 11 * i + 5;
                assertEquals("Failed to get the correct color.", CONFIG_COLORS[i][j],
                    configedPalette.getColorForLocation(posX, posY));

            }
        }
    }

    /**
     * <p>
     * Tests ColorPalettePanel#getColorForLocation(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the x value is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testGetColorForLocation_NegativeX() {
        try {
            palette.getColorForLocation(-5, 5);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests ColorPalettePanel#getColorForLocation(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the x value is larger than the width and expects IllegalArgumentException.
     * </p>
     */
    public void testGetColorForLocation_TooLargeX() {
        try {
            configedPalette.getColorForLocation(150, 5);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests ColorPalettePanel#getColorForLocation(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the y value is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testGetColorForLocation_NegativeY() {
        try {
            palette.getColorForLocation(5, -5);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests ColorPalettePanel#getColorForLocation(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the y value is larger than height and expects IllegalArgumentException.
     * </p>
     */
    public void testGetColorForLocation_TooLargeY() {
        try {
            configedPalette.getColorForLocation(5, 400);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests ColorPalettePanel#isFocusTraversable() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorPalettePanel#isFocusTraversable() returns false.
     * </p>
     */
    public void testIsFocusTraversable() {
        assertFalse("isFocusTraversable() should return false.", palette.isFocusTraversable());
    }

    /**
     * <p>
     * Tests ColorPalettePanel#paintComponent(Graphics) for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorPalettePanel#paintComponent(Graphics) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponent() throws Exception {
        JFrame frame = new JFrame();
        frame.getContentPane().add(palette);
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
     * Tests ColorPalettePanel#getToolTipText(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorPalettePanel#getToolTipText(MouseEvent) is correct.
     * </p>
     */
    public void testGetToolTipText() {
        // the position is the (2, 1) palette
        MouseEvent event = new MouseEvent(palette, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        assertEquals("The tool tip should be \"204, 204, 204\".", "204, 204, 204", palette.getToolTipText(event));
    }
}