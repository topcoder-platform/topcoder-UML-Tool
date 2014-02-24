/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for FontFamilySelector.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FontFamilySelectorTests extends TestCase {
    /**
     * <p>
     * FontFamilySelector instance for testing.
     * </p>
     */
    private FontFamilySelector selector;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        selector = new FontFamilySelector();
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
        selector = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(FontFamilySelectorTests.class);
    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created FontFamilySelector instance should not be null.
     * </p>
     */
    public void testCtor1() {
        selector = new FontFamilySelector(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new FontFamilySelector instance.", selector);

        Set<String> expectedFonts = new HashSet<String>();
        expectedFonts.add("");
        expectedFonts.add("Arial");
        expectedFonts.add("Times New Roman");
        expectedFonts.add("Verdana");

        Set<String> items = new HashSet<String>();
        int count = selector.getItemCount();
        for (int i = 0; i < count; i++) {
            items.add((String) selector.getItemAt(i));
        }

        assertEquals("The items are not set correctly.", expectedFonts, items);
    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the fontFamily property is missing and expects success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_FontFamilyMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_NoFontFamily.xml");

        selector = new FontFamilySelector(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new FontFamilySelector instance.", selector);

        // verify the default font names are used
        Set<String> systemFonts = Util.getAllFontNames();
        systemFonts.add("");

        Set<String> items = new HashSet<String>();
        int count = selector.getItemCount();
        for (int i = 0; i < count; i++) {
            items.add((String) selector.getItemAt(i));
        }

        assertEquals("The items are not set correctly.", systemFonts, items);
    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the default property is missing and expects success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_DefaultFontMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_NoDefaultFontfamily.xml");
        selector = new FontFamilySelector(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new FontFamilySelector instance.", selector);

        Set<String> expectedFonts = new HashSet<String>();
        expectedFonts.add("");
        expectedFonts.add("Default");
        expectedFonts.add("Arial");
        expectedFonts.add("Times New Roman");
        expectedFonts.add("Verdana");

        Set<String> items = new HashSet<String>();
        int count = selector.getItemCount();
        for (int i = 0; i < count; i++) {
            items.add((String) selector.getItemAt(i));
        }

        assertEquals("The items are not set correctly.", expectedFonts, items);

    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new FontFamilySelector(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new FontFamilySelector(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is missing and expects StylePanelConfigurationException.
     * </p>
     */
    public void testCtor1_NamespaceMissing() {
        try {
            new FontFamilySelector("test");
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the default font name in the configuration file is not valid and expects
     * StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InvalidDefaultFontName() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_InvalidDefaultFontName.xml");
        try {
            new FontFamilySelector(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the some font name in the configuration file is not valid and expects
     * StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InvalidFontName() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_InvalidFontName.xml");
        try {
            new FontFamilySelector(TestHelper.NAMESPACE);
            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor FontFamilySelector#FontFamilySelector() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created FontFamilySelector instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new FontFamilySelector instance.", selector);

        Set<String> systemFonts = Util.getAllFontNames();
        systemFonts.add("");

        Set<String> items = new HashSet<String>();
        int count = selector.getItemCount();
        for (int i = 0; i < count; i++) {
            items.add((String) selector.getItemAt(i));
        }

        assertEquals("The items are not set correctly.", systemFonts, items);
    }

    /**
     * <p>
     * Tests FontFamilySelector#getListFontFamily() for accuracy.
     * </p>
     *
     * <p>
     * Verify : FontFamilySelector#getListFontFamily() is correct.
     * </p>
     */
    public void testGetListFontFamily() {
        Set<String> systemFonts = Util.getAllFontNames();

        List<String> fonts = selector.getListFontFamily();

        assertEquals("Failed to get the size of the fonts.", systemFonts.size(), fonts.size());
        for (String font : fonts) {
            assertTrue("Failed to get the correct font list.", systemFonts.contains(font));
        }
    }

    /**
     * <p>
     * Tests FontFamilySelector#getDefaultFontFamily() for accuracy.
     * </p>
     *
     * <p>
     * Verify : FontFamilySelector#getDefaultFontFamily() is correct.
     * </p>
     */
    public void testGetDefaultFontFamily() {
        assertEquals("Failed to get correct default font name.", "Default", selector.getDefaultFontFamily());
    }

    /**
     * <p>
     * Tests FontFamilySelector#setListFontFamily(List) for accuracy.
     * </p>
     *
     * <p>
     * Verify : FontFamilySelector#setListFontFamily(List) is correct.
     * </p>
     */
    public void testSetListFontFamily() {
        List<String> fonts = new ArrayList<String>();
        fonts.add("Arial");

        selector.setListFontFamily(fonts);

        fonts = selector.getListFontFamily();
        assertEquals("The font list should have one fonts.", 1, selector.getListFontFamily().size());
        assertEquals("Failed to set the font list.", "Arial", selector.getListFontFamily().get(0));
        assertEquals("There should be one item in the combo box.", 2, selector.getItemCount());
        assertEquals("The combo box is not updated.", "", selector.getItemAt(0));
        assertEquals("The combo box is not updated.", "Arial", selector.getItemAt(1));
    }

    /**
     * <p>
     * Tests FontFamilySelector#setListFontFamily(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listFontFamily is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetListFontFamily_NullListFontFamily() {
        try {
            selector.setListFontFamily(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontFamilySelector#setListFontFamily(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listFontFamily is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetListFontFamily_EmptyListFontFamily() {
        try {
            selector.setListFontFamily(new ArrayList<String>());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontFamilySelector#setListFontFamily(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listFontFamily contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testSetListFontFamily_NullInListFontFamily() {
        List<String> fonts = new ArrayList<String>();
        fonts.add(null);

        try {
            selector.setListFontFamily(fonts);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontFamilySelector#setDefaultFontFamily(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : FontFamilySelector#setDefaultFontFamily(String) is correct.
     * </p>
     */
    public void testSetDefaultFontFamily() {
        selector.setDefaultFontFamily("Times");

        assertEquals("Failed to set the default font name.", "Times", selector.getDefaultFontFamily());
    }

    /**
     * <p>
     * Tests FontFamilySelector#setDefaultFontFamily(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when defaultFontFamily is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetDefaultFontFamily_NullDefaultFontFamily() {
        try {
            selector.setDefaultFontFamily(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontFamilySelector#setDefaultFontFamily(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when defaultFontFamily is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetDefaultFontFamily_EmptyDefaultFontFamily() {
        try {
            selector.setDefaultFontFamily("  ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}