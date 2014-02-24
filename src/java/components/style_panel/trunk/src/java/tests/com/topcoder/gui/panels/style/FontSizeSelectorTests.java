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
 * Unit test cases for FontSizeSelector.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FontSizeSelectorTests extends TestCase {
    /**
     * <p>
     * Represents the default font size list.
     * </p>
     */
    private static final int[] DEFAULT_LIST_FONT_SIZE = new int[] {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 20, 22,
        24, 26, 28, 32, 36, 40, 44, 48, 54, 60, 66, 72, 80, 88, 96};

    /**
     * <p>
     * FontSizeSelector instance for testing.
     * </p>
     */
    private FontSizeSelector selector;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to jUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        selector = new FontSizeSelector();
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
        return new TestSuite(FontSizeSelectorTests.class);
    }

    /**
     * <p>
     * Tests ctor FontSizeSelector#FontSizeSelector(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created FontSizeSelector instance should not be null.
     * </p>
     */
    public void testCtor1() {
        selector = new FontSizeSelector(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new FontSizeSelector instance.", selector);

        Set<Object> expectedSizes = new HashSet<Object>();
        expectedSizes.add("");
        expectedSizes.add(8);
        expectedSizes.add(6);
        expectedSizes.add(10);

        Set<Object> items = new HashSet<Object>();
        int count = selector.getItemCount();
        for (int i = 0; i < count; i++) {
            items.add(selector.getItemAt(i));
        }

        assertEquals("The items are not set correctly.", expectedSizes, items);
    }

    /**
     * <p>
     * Tests ctor FontSizeSelector#FontSizeSelector(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the fontSize property is missing and expects success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_FontSizeMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator + "config_NoFontSize.xml");

        selector = new FontSizeSelector(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new FontSizeSelector instance.", selector);

        // verify the default font sizes are used
        Set<Object> expectedSizes = new HashSet<Object>();
        expectedSizes.add("");
        for (int fontSize : DEFAULT_LIST_FONT_SIZE) {
            expectedSizes.add(fontSize);
        }

        Set<Object> items = new HashSet<Object>();
        int count = selector.getItemCount();
        for (int i = 0; i < count; i++) {
            items.add(selector.getItemAt(i));
        }

        assertEquals("The items are not set correctly.", expectedSizes, items);
    }

    /**
     * <p>
     * Tests ctor FontSizeSelector#FontSizeSelector(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the default fontSize property is missing and expects success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_DefaultFontSizeMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, "test_files" + File.separator
            + "config_NoDefaultFontSize.xml");

        selector = new FontSizeSelector(TestHelper.NAMESPACE);
        assertNotNull("Failed to create a new FontSizeSelector instance.", selector);

        // verify the default font sizes are used
        Set<Object> expectedSizes = new HashSet<Object>();
        expectedSizes.add("");
        expectedSizes.add(10);
        expectedSizes.add(8);
        expectedSizes.add(6);

        Set<Object> items = new HashSet<Object>();
        int count = selector.getItemCount();
        for (int i = 0; i < count; i++) {
            items.add(selector.getItemAt(i));
        }

        assertEquals("The items are not set correctly.", expectedSizes, items);
    }

    /**
     * <p>
     * Tests ctor FontSizeSelector#FontSizeSelector(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new FontSizeSelector(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor FontSizeSelector#FontSizeSelector(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new FontSizeSelector(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor FontSizeSelector#FontSizeSelector() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created FontSizeSelector instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new FontSizeSelector instance.", selector);

        Set<Object> expectedSizes = new HashSet<Object>();
        expectedSizes.add("");
        for (int fontSize : DEFAULT_LIST_FONT_SIZE) {
            expectedSizes.add(fontSize);
        }

        Set<Object> items = new HashSet<Object>();
        int count = selector.getItemCount();
        for (int i = 0; i < count; i++) {
            items.add(selector.getItemAt(i));
        }

        assertEquals("The items are not set correctly.", expectedSizes, items);
    }

    /**
     * <p>
     * Tests FontSizeSelector#getListFontSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : FontSizeSelector#getListFontSize() is correct.
     * </p>
     */
    public void testGetListFontSize() {
        List<Integer> listFontSize = new ArrayList<Integer>();
        listFontSize.add(5);
        listFontSize.add(18);

        selector.setListFontSize(listFontSize);

        assertEquals("Failed to get the correct font size list.", 2, selector.getListFontSize().size());
        assertTrue("Failed to get the correct font size list.", selector.getListFontSize().containsAll(listFontSize));
    }

    /**
     * <p>
     * Tests FontSizeSelector#setListFontSize(List) for accuracy.
     * </p>
     *
     * <p>
     * Verify : FontSizeSelector#setListFontSize(List) is correct.
     * </p>
     */
    public void testSetListFontSize() {
        List<Integer> listFontSize = new ArrayList<Integer>();
        listFontSize.add(5);
        listFontSize.add(18);

        selector.setListFontSize(listFontSize);

        assertEquals("Failed to get the correct font size list.", 2, selector.getListFontSize().size());
        assertTrue("Failed to get the correct font size list.", selector.getListFontSize().containsAll(listFontSize));
    }

    /**
     * <p>
     * Tests FontSizeSelector#setListFontSize(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listFontSize is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetListFontSize_NullListFontSize() {
        try {
            selector.setListFontSize(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontSizeSelector#setListFontSize(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listFontSize is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetListFontSize_EmptyListFontSize() {
        List<Integer> listFontSize = new ArrayList<Integer>();
        try {
            selector.setListFontSize(listFontSize);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontSizeSelector#setListFontSize(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listFontSize contains null
     * element and expects IllegalArgumentException.
     * </p>
     */
    public void testSetListFontSize_NullInListFontSize() {
        List<Integer> listFontSize = new ArrayList<Integer>();
        listFontSize.add(null);
        try {
            selector.setListFontSize(listFontSize);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontSizeSelector#setListFontSize(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listFontSize contains non-positive
     * integer and expects IllegalArgumentException.
     * </p>
     */
    public void testSetListFontSize_NonPositive() {
        List<Integer> listFontSize = new ArrayList<Integer>();
        listFontSize.add(-5);
        try {
            selector.setListFontSize(listFontSize);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontSizeSelector#setDefaultFontSize(int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : FontSizeSelector#setDefaultFontSize(int) is correct.
     * </p>
     */
    public void testSetDefaultFontSize() {
        selector.setDefaultFontSize(8);
        assertEquals("Failed to return the correct default size of font.", 8, selector.getDefaultFontSize());
    }

    /**
     * <p>
     * Tests FontSizeSelector#setDefaultFontSize(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when defaultFontSize is non-positive
     * integer and expects IllegalArgumentException.
     * </p>
     */
    public void testSetDefaultFontSize_NonPositive() {
        try {
            selector.setDefaultFontSize(-8);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests FontSizeSelector#getDefaultFontSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : FontSizeSelector#getDefaultFontSize() is correct.
     * </p>
     */
    public void testGetDefaultFontSize() {
        selector.setDefaultFontSize(8);
        assertEquals("Failed to return the correct default size of font.", 8, selector.getDefaultFontSize());
    }
}