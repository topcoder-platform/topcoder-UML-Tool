/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.styleobject;

import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.panels.style.StyleNotSupportedException;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PolylineStyleObjectAdapter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PolylineStyleObjectAdapterTests extends TestCase {

    /**
     * <p>
     * The PolylineStyleObjectAdapter instance for testing.
     * </p>
     */
    private PolylineStyleObjectAdapter adapter;

    /**
     * <p>
     * The StylePanel instance for testing.
     * </p>
     */
    private StylePanel stylePanel;

    /**
     * <p>
     * The Polyline instance for testing.
     * </p>
     */
    private Polyline polyline;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        polyline = new Polyline();
        stylePanel = new StylePanel();
        adapter = new PolylineStyleObjectAdapter(polyline);
        adapter.setStylePanel(stylePanel);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        adapter = null;
        stylePanel = null;
        polyline = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PolylineStyleObjectAdapterTests.class);
    }

    /**
     * <p>
     * Tests ctor PolylineStyleObjectAdapter#PolylineStyleObjectAdapter(Polyline) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PolylineStyleObjectAdapter instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new PolylineStyleObjectAdapter instance.", adapter);
    }

    /**
     * <p>
     * Tests ctor PolylineStyleObjectAdapter#PolylineStyleObjectAdapter(Polyline) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when polyline is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPolyline() {
        try {
            new PolylineStyleObjectAdapter(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineStyleObjectAdapter#getFillColor() returns
     * the using fill color.
     * </p>
     */
    public void testGetFillColor() {
        polyline.addProperty(TestHelper.createProperty(stylePanel.getFillColorKey(), "#F256D8"));
        assertEquals("The return value is not correct.", "#F256D8", adapter.getFillColor());
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineStyleObjectAdapter#getFillColor() returns the
     * default fill color WHITE when the fill color property is missing.
     * </p>
     */
    public void testGetFillColor_MissingProperty() {
        assertEquals("The return value is not correct.", "#FFFFFF", adapter.getFillColor());
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineStyleObjectAdapter#getFillColor() returns the
     * default fill color WHITE when the fill color property is invalid.
     * </p>
     */
    public void testGetFillColor_InvalidColor() {
        polyline.addProperty(TestHelper.createProperty(stylePanel.getFillColorKey(), "TEST"));
        assertEquals("The return value is not correct.", "#FFFFFF", adapter.getFillColor());
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getFillColor() for failure.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetFillColor_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getFillColor();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineStyleObjectAdapter#getOutlineColor() returns
     * the using outline color.
     * </p>
     */
    public void testGetOutlineColor() {
        polyline.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "#F256D8"));
        assertEquals("The return value is not correct.", "#F256D8", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineStyleObjectAdapter#getOutlineColor() returns the
     * default outline color BLACK when the outline color property is missing.
     * </p>
     */
    public void testGetOutlineColor_MissingProperty() {
        assertEquals("The return value is not correct.", "#000000", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineStyleObjectAdapter#getOutlineColor() returns the
     * default outline color BLACK when the outline color property is invalid.
     * </p>
     */
    public void testGetOutlineColor_InvalidColor() {
        polyline.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "TEST"));
        assertEquals("The return value is not correct.", "#000000", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getOutlineColor() for failure.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetOutlineColor_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getOutlineColor();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getTextColor() for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testGetTextColor_StyleNotSupportedException() {
        try {
            adapter.getTextColor();
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getHeight() for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testGetHeight_StyleNotSupportedException() {
        try {
            adapter.getHeight();
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getWidth() for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testGetWidth_StyleNotSupportedException() {
        try {
            adapter.getWidth();
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getX() for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testGetX_StyleNotSupportedException() {
        try {
            adapter.getX();
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getY() for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testGetY_StyleNotSupportedException() {
        try {
            adapter.getY();
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getFontName() for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testGetFontName_StyleNotSupportedException() {
        try {
            adapter.getFontName();
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PolylineStyleObjectAdapter#getFontSize() for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testGetFontSize_StyleNotSupportedException() {
        try {
            adapter.getFontSize();
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }
}