/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.style.FontSizeSelector;
import com.topcoder.gui.panels.style.StylePanelConfigurationException;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link FontSizeSelector}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FontSizeSelectorFailureTests extends TestCase {
    /**
     * <p>
     * Represents the configurations for FontSizeSelector testing.
     * </p>
     */
    private static final String FONT_SIZE_SELECTOR_CONFIG = "failuretests" + File.separator + "FontSizeSelector.xml";

    /**
     * <p>
     * Represents the <code>{@link FontSizeSelector}</code> instance used in tests.
     * </p>
     */
    private FontSizeSelector fontSizeSelector = new FontSizeSelector();

    /**
     * <p>
     * Set up the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        FailureTestHelper.clearNamespaces();
        FailureTestHelper.loadNamesapces(FONT_SIZE_SELECTOR_CONFIG);
    }

    /**
     * <p>
     * tear down the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        FailureTestHelper.clearNamespaces();
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringNullNamespace() {
        try {
            new FontSizeSelector(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringEmptyNamespace() {
        try {
            new FontSizeSelector("");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringTrimmedEmptyNamespace() {
        try {
            new FontSizeSelector("  ");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringUnknownNamespace() {
        try {
            new FontSizeSelector("Unknown");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringEmptyFontSize() {
        try {
            new FontSizeSelector(
                "com.topcoder.gui.panels.style.failuretests.FontSizeSelectorFailureTests.EmptyFontSize");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringInvalidFontSize1() {
        try {
            new FontSizeSelector(
                "com.topcoder.gui.panels.style.failuretests.FontSizeSelectorFailureTests.InvalidFontSize1");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringInvalidFontSize2() {
        try {
            new FontSizeSelector(
                "com.topcoder.gui.panels.style.failuretests.FontSizeSelectorFailureTests.InvalidFontSize2");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringDuplicatedFontSize() {
        try {
            new FontSizeSelector(
                "com.topcoder.gui.panels.style.failuretests.FontSizeSelectorFailureTests.DuplicatedFontSize");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#FontSizeSelector(String)}</code> constructor.
     * </p>
     */
    public void testFontSizeSelectorStringNotFoundDefaultFontSize() {
        try {
            new FontSizeSelector(
                "com.topcoder.gui.panels.style.failuretests.FontSizeSelectorFailureTests.NotFoundDefaultFontSize");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#setListFontSize(java.util.List)}</code> method.
     * </p>
     */
    public void testSetListFontSizeNullList() {
        try {
            fontSizeSelector.setListFontSize(null);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#setListFontSize(java.util.List)}</code> method.
     * </p>
     */
    public void testSetListFontSizeEmptyList() {
        try {
            fontSizeSelector.setListFontSize(new ArrayList<Integer>());
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#setListFontSize(java.util.List)}</code> method.
     * </p>
     */
    public void testSetListFontSizeListContainsNull() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(null);
        try {
            fontSizeSelector.setListFontSize(list);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#setListFontSize(java.util.List)}</code> method.
     * </p>
     */
    public void testSetListFontSizeListContainsZero() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        try {
            fontSizeSelector.setListFontSize(list);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#setListFontSize(java.util.List)}</code> method.
     * </p>
     */
    public void testSetListFontSizeListContainsNegative() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        try {
            fontSizeSelector.setListFontSize(list);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#setDefaultFontSize(int)}</code> method.
     * </p>
     */
    public void testSetDefaultFontSizeZeroFontSize() {
        try {
            fontSizeSelector.setDefaultFontSize(0);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontSizeSelector#setDefaultFontSize(int)}</code> method.
     * </p>
     */
    public void testSetDefaultFontSizeNegativeFontSize() {
        try {
            fontSizeSelector.setDefaultFontSize(-1);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
