/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.styleobject;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.panels.style.StyleNotSupportedException;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for GraphEdgeStyleObjectAdapter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphEdgeStyleObjectAdapterTests extends TestCase {

    /**
     * <p>
     * The GraphEdgeStyleObjectAdapter instance for testing.
     * </p>
     */
    private GraphEdgeStyleObjectAdapter adapter;

    /**
     * <p>
     * The StylePanel instance for testing.
     * </p>
     */
    private StylePanel stylePanel;

    /**
     * <p>
     * The GraphEdge instance for testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        graphEdge = new GraphEdge();
        Point point = new Point();
        graphEdge.setPosition(point);
        stylePanel = new StylePanel();
        adapter = new GraphEdgeStyleObjectAdapter(graphEdge);
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
        graphEdge = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(GraphEdgeStyleObjectAdapterTests.class);
    }

    /**
     * <p>
     * Tests ctor GraphEdgeStyleObjectAdapter#GraphEdgeStyleObjectAdapter(GraphEdge) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created GraphEdgeStyleObjectAdapter instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new GraphEdgeStyleObjectAdapter instance.", adapter);
    }

    /**
     * <p>
     * Tests ctor GraphEdgeStyleObjectAdapter#GraphEdgeStyleObjectAdapter(GraphEdge) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphEdge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphEdge() {
        try {
            new GraphEdgeStyleObjectAdapter(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFillColor() for failure.
     * </p>
     *
     * <p>
     * Expects StyleNotSupportedException.
     * </p>
     */
    public void testGetFillColor_StyleNotSupportedException() {
        try {
            adapter.getFillColor();
            fail("StyleNotSupportedException expected.");
        } catch (StyleNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getOutlineColor() returns the using
     * outline color.
     * </p>
     */
    public void testGetOutlineColor() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "#F256D8"));
        assertEquals("The return value is not correct.", "#F256D8", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getOutlineColor() returns the default
     * outline color when the outline color property is missing.
     * </p>
     */
    public void testGetOutlineColor_MissingProperty() {
        assertEquals("The return value is not correct.", "#000000", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getOutlineColor() returns the default
     * outline color when the outline color property is invalid.
     * </p>
     */
    public void testGetOutlineColor_InvalidColor() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "HELLO"));
        assertEquals("The return value is not correct.", "#000000", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getOutlineColor() for failure.
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
     * Tests GraphEdgeStyleObjectAdapter#getTextColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getTextColor() returns the using
     * text color.
     * </p>
     */
    public void testGetTextColor() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getTextColorKey(), "#75FE36"));
        assertEquals("The return value is not correct.", "#75FE36", adapter.getTextColor());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getTextColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getTextColor() returns the default
     * text color when the text color property is missing.
     * </p>
     */
    public void testGetTextColor_MissingProperty() {
        assertEquals("The return value is not correct.", "#000000", adapter.getTextColor());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getTextColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getTextColor() returns the default
     * text color when the text color property is invalid.
     * </p>
     */
    public void testGetTextColor_InvalidColor() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getTextColorKey(), "TEXT"));
        assertEquals("The return value is not correct.", "#000000", adapter.getTextColor());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getTextColor() for failure.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetTextColor_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getTextColor();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getHeight() for failure.
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
     * Tests GraphEdgeStyleObjectAdapter#getWidth() for failure.
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
     * Tests GraphEdgeStyleObjectAdapter#getX() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getX() returns the
     * x-position of the graphEdge.
     * </p>
     */
    public void testGetX() {
        Point point = new Point();
        point.setX(15.0);
        graphEdge.setPosition(point);
        assertEquals("The return value is not correct.", 15.0, adapter.getX());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getX() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getX() returns zero
     * when the x-position property is missing.
     * </p>
     */
    public void testGetX_MissingProperty() {
        assertEquals("The return value is not correct.", 0.0, adapter.getX());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getX() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getX() returns zero
     * when the x-position property is invalid.
     * </p>
     */
    public void testGetX_InvalidX() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getXKey(), "test"));
        assertEquals("The return value is not correct.", 0.0, adapter.getX());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getX() for failure.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetX_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getX();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getY() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getY() returns the
     * y-position of the graphEdge.
     * </p>
     */
    public void testGetY() {
        graphEdge.getPosition().setY(15.0);
        assertEquals("The return value is not correct.", 15.0, adapter.getY());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getY() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getY() returns zero
     * when the y-position property is missing.
     * </p>
     */
    public void testGetY_MissingProperty() {
        assertEquals("The return value is not correct.", 0.0, adapter.getY());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getY() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getY() returns zero
     * when the y-position property is invalid.
     * </p>
     */
    public void testGetY_InvalidY() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getYKey(), "test"));
        assertEquals("The return value is not correct.", 0.0, adapter.getY());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getY() for failure.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetY_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getY();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFontName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getFontName() returns the
     * using font name.
     * </p>
     */
    public void testGetFontName() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getFontNameKey(), "Arial"));
        assertEquals("The return value is not correct.", "Arial", adapter.getFontName());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFontName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getFontName() returns "Default" when
     * the font name property is missing.
     * </p>
     */
    public void testGetFontName_MissingProperty() {
        assertEquals("The return value is not correct.", "Default", adapter.getFontName());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFontName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getFontName() returns "Default" when
     * the font name property is invalid.
     * </p>
     */
    public void testGetFontName_InvalidName() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getFontNameKey(), "font"));
        assertEquals("The return value is not correct.", "Default", adapter.getFontName());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFontName() for failure.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetFontName_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getFontName();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getFontSize() returns the
     * using font size.
     * </p>
     */
    public void testGetFontSize() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getFontSizeKey(), "18"));
        assertEquals("The return value is not correct.", 18, adapter.getFontSize());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getFontSize() returns ten when
     * the font size property is missing.
     * </p>
     */
    public void testGetFontSize_MissingProperty() {
        assertEquals("The return value is not correct.", 10, adapter.getFontSize());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphEdgeStyleObjectAdapter#getFontSize() returns ten when
     * the font size property is invalid.
     * </p>
     */
    public void testGetFontSize_InvalidSize() {
        graphEdge.addProperty(TestHelper.createProperty(stylePanel.getFontSizeKey(), "size"));
        assertEquals("The return value is not correct.", 10, adapter.getFontSize());
    }

    /**
     * <p>
     * Tests GraphEdgeStyleObjectAdapter#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetFontSize_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getFontSize();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }
}