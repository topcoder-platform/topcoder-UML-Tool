/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.style.FontFamilySelector;
import com.topcoder.gui.panels.style.StylePanelConfigurationException;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link FontFamilySelector}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FontFamilySelectorFailureTests extends TestCase {
    /**
     * <p>
     * Represents the configurations for FontFamilySelector testing.
     * </p>
     */
    private static final String FONT_FAMILY_SELECTOR_CONFIG = "failuretests" + File.separator
        + "FontFamilySelector.xml";

    /**
     * <p>
     * Represents the <code>{@link FontFamilySelector}</code> instance used in tests.
     * </p>
     */
    private FontFamilySelector fontFamilySelector = new FontFamilySelector();

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
        FailureTestHelper.loadNamesapces(FONT_FAMILY_SELECTOR_CONFIG);
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
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringNullNamespace() {
        try {
            new FontFamilySelector(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringEmptyNamespace() {
        try {
            new FontFamilySelector("");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringTrimmedEmptyNamespace() {
        try {
            new FontFamilySelector("  ");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringUnknownNamespace() {
        try {
            new FontFamilySelector("Unknown");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringNullFontFamily() {
        try {
            new FontFamilySelector("com.topcoder.gui.panels.style.failuretests.FontFamilySelectorFailureTests.NullFont");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringEmptyFontFamily() {
        try {
            new FontFamilySelector(
                "com.topcoder.gui.panels.style.failuretests.FontFamilySelectorFailureTests.EmptyFont");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringDuplicatedFontName() {
        try {
            new FontFamilySelector(
                "com.topcoder.gui.panels.style.failuretests.FontFamilySelectorFailureTests.DuplicatedFontName");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringDefaultFontNameNotFound() {
        try {
            new FontFamilySelector(
                "com.topcoder.gui.panels.style.failuretests.FontFamilySelectorFailureTests.DefaultFontNameNotFound");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#FontFamilySelector(String)}</code> constructor.
     * </p>
     */
    public void testFontFamilySelectorStringFontNotSupported() {
        try {
            new FontFamilySelector(
                "com.topcoder.gui.panels.style.failuretests.FontFamilySelectorFailureTests.FontNotSupported");
            fail("Should throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#setListFontFamily(java.util.List)}</code> method.
     * </p>
     */
    public void testSetListFontFamilyNullList() {
        try {
            fontFamilySelector.setListFontFamily(null);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#setListFontFamily(java.util.List)}</code> method.
     * </p>
     */
    public void testSetListFontFamilyEmptyList() {
        try {
            fontFamilySelector.setListFontFamily(new ArrayList<String>());
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#setListFontFamily(java.util.List)}</code> method.
     * </p>
     */
    public void testSetListFontFamilyListContainsNull() {
        List<String> list = new ArrayList<String>();
        list.add(null);
        try {
            fontFamilySelector.setListFontFamily(list);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#setDefaultFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetDefaultFontFamilyNullFontFamily() {
        try {
            fontFamilySelector.setDefaultFontFamily(null);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#setDefaultFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetDefaultFontFamilyEmptyFontFamily() {
        try {
            fontFamilySelector.setDefaultFontFamily("");
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link FontFamilySelector#setDefaultFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetDefaultFontFamilyTrimmedEmptyFontFamily() {
        try {
            fontFamilySelector.setDefaultFontFamily("   ");
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
