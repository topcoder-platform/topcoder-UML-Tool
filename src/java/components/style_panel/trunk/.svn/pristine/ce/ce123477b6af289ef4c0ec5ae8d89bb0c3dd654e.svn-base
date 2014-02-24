/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.styleobject;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for GraphNodeStyleObjectAdapter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphNodeStyleObjectAdapterTests extends TestCase {

    /**
     * <p>
     * The GraphNodeStyleObjectAdapter instance for testing.
     * </p>
     */
    private GraphNodeStyleObjectAdapter adapter;

    /**
     * <p>
     * The StylePanel instance for testing.
     * </p>
     */
    private StylePanel stylePanel;

    /**
     * <p>
     * The GraphNode instance for testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        graphNode = new GraphNode();
        graphNode.setPosition(new Point());
        graphNode.setSize(new Dimension());
        stylePanel = new StylePanel();
        adapter = new GraphNodeStyleObjectAdapter(graphNode);
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
        graphNode = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(GraphNodeStyleObjectAdapterTests.class);
    }

    /**
     * <p>
     * Tests ctor GraphNodeStyleObjectAdapter#GraphNodeStyleObjectAdapter(GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created GraphNodeStyleObjectAdapter instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new GraphNodeStyleObjectAdapter instance.", adapter);
    }

    /**
     * <p>
     * Tests ctor GraphNodeStyleObjectAdapter#GraphNodeStyleObjectAdapter(GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphNode() {
        try {
            new GraphNodeStyleObjectAdapter(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFillColor() returns
     * the using fill color.
     * </p>
     */
    public void testGetFillColor() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getFillColorKey(), "#F256D8"));
        assertEquals("The return value is not correct.", "#F256D8", adapter.getFillColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFillColor() returns the
     * default fill color WHITE when the fill color property is missing.
     * </p>
     */
    public void testGetFillColor_MissingProperty() {
        assertEquals("The return value is not correct.", "#FFFFFF", adapter.getFillColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFillColor() returns the
     * default fill color WHITE when the fill color property is invalid.
     * </p>
     */
    public void testGetFillColor_InvalidColor() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getFillColorKey(), "TEST"));
        assertEquals("The return value is not correct.", "#FFFFFF", adapter.getFillColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFillColor() for failure.
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
     * Tests GraphNodeStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getOutlineColor() returns
     * the using outline color.
     * </p>
     */
    public void testGetOutlineColor() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "#F256D8"));
        assertEquals("The return value is not correct.", "#F256D8", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getOutlineColor() returns the
     * default outline color BLACK when the outline color property is missing.
     * </p>
     */
    public void testGetOutlineColor_MissingProperty() {
        assertEquals("The return value is not correct.", "#000000", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getOutlineColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getOutlineColor() returns the
     * default outline color BLACK when the outline color property is invalid.
     * </p>
     */
    public void testGetOutlineColor_InvalidColor() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "TEST"));
        assertEquals("The return value is not correct.", "#000000", adapter.getOutlineColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getOutlineColor() for failure.
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
     * Tests GraphNodeStyleObjectAdapter#getTextColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getTextColor() returns the
     * using text color.
     * </p>
     */
    public void testGetTextColor() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getTextColorKey(), "#F256D8"));
        assertEquals("The return value is not correct.", "#F256D8", adapter.getTextColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getTextColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getTextColor() returns the
     * default text color BLACK when the text color property is missing.
     * </p>
     */
    public void testGetTextColor_MissingProperty() {
        assertEquals("The return value is not correct.", "#000000", adapter.getTextColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getTextColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getTextColor() returns the
     * default text color BLACK when the text color property is value.
     * </p>
     */
    public void testGetTextColor_InvalidColor() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getTextColorKey(), "TEST"));
        assertEquals("The return value is not correct.", "#000000", adapter.getTextColor());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getTextColor() for failure.
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
     * Tests GraphNodeStyleObjectAdapter#getHeight() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getHeight() returns the
     * using height.
     * </p>
     */
    public void testGetHeight() {
        graphNode.getSize().setHeight(15.0);
        assertEquals("The return value is not correct.", 15.0, adapter.getHeight());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getHeight() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getHeight() returns zero when
     * the height property is missing.
     * </p>
     */
    public void testGetHeight_MissingProperty() {
        assertEquals("The return value is not correct.", 0.0, adapter.getHeight());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getHeight() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getHeight() returns zero when
     * the height property is invalid.
     * </p>
     */
    public void testGetHeight_InvalidHeight() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getHeightKey(), "TEST"));
        assertEquals("The return value is not correct.", 0.0, adapter.getHeight());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getHeight() for failure.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetHeight_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getHeight();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getWidth() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getWidth() returns the
     * using width.
     * </p>
     */
    public void testGetWidth() {
        graphNode.getSize().setWidth(15.0);
        assertEquals("The return value is not correct.", 15.0, adapter.getWidth());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getWidth() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getWidth() returns zero when
     * the width property is missing.
     * </p>
     */
    public void testGetWidth_MissingProperty() {
        assertEquals("The return value is not correct.", 0.0, adapter.getWidth());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getWidth() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getWidth() returns zero when
     * the width property is invalid.
     * </p>
     */
    public void testGetWidth_InvalidWidth() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getWidthKey(), "TEST"));
        assertEquals("The return value is not correct.", 0.0, adapter.getWidth());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getWidth() for failure.
     * </p>
     *
     * <p>
     * It tests the style panel is not set and Expects IllegalStateException.
     * </p>
     */
    public void testGetWidth_NotSetPanel() {
        adapter.setStylePanel(null);
        try {
            adapter.getWidth();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getX() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getX() returns the
     * using x-position of the graphNode.
     * </p>
     */
    public void testGetX() {
        graphNode.getPosition().setX(15.0);
        assertEquals("The return value is not correct.", 15.0, adapter.getX());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getX() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getX() returns zero
     * when the x-position property is missing.
     * </p>
     */
    public void testGetX_MissingProperty() {
        assertEquals("The return value is not correct.", 0.0, adapter.getX());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getX() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getX() returns zero
     * when the x-position property is invalid.
     * </p>
     */
    public void testGetX_InvalidX() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getXKey(), "TEST"));
        assertEquals("The return value is not correct.", 0.0, adapter.getX());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getX() for failure.
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
     * Tests GraphNodeStyleObjectAdapter#getY() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getY() returns the
     * using y-position of the graphNode.
     * </p>
     */
    public void testGetY() {
        graphNode.getPosition().setY(15.0);
        assertEquals("The return value is not correct.", 15.0, adapter.getY());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getY() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getY() returns zero
     * when the y-position property is missing.
     * </p>
     */
    public void testGetY_MissingProperty() {
        assertEquals("The return value is not correct.", 0.0, adapter.getY());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getY() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getY() returns zero
     * when the y-position property is invalid.
     * </p>
     */
    public void testGetY_InvalidY() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getYKey(), "TEST"));
        assertEquals("The return value is not correct.", 0.0, adapter.getY());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getY() for failure.
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
     * Tests GraphNodeStyleObjectAdapter#getFontName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFontName() returns the
     * using font name.
     * </p>
     */
    public void testGetFontName() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getFontNameKey(), "Arial"));
        assertEquals("The return value is not correct.", "Arial", adapter.getFontName());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFontName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFontName() returns "Default" when
     * the font name property is missing.
     * </p>
     */
    public void testGetFontName_MissingProperty() {
        assertEquals("The return value is not correct.", "Default", adapter.getFontName());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFontName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFontName() returns "Default" when
     * the font name property is invalid.
     * </p>
     */
    public void testGetFontName_InvalidName() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getFontNameKey(), "font"));
        assertEquals("The return value is not correct.", "Default", adapter.getFontName());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFontName() for failure.
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
     * Tests GraphNodeStyleObjectAdapter#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFontSize() returns the
     * using font size.
     * </p>
     */
    public void testGetFontSize() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getFontSizeKey(), "18"));
        assertEquals("The return value is not correct.", 18, adapter.getFontSize());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFontSize() returns ten when
     * the font size property is missing.
     * </p>
     */
    public void testGetFontSize_MissingProperty() {
        assertEquals("The return value is not correct.", 10, adapter.getFontSize());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphNodeStyleObjectAdapter#getFontSize() returns ten when
     * the font size property is invalid.
     * </p>
     */
    public void testGetFontSize_InvalidSize() {
        graphNode.addProperty(TestHelper.createProperty(stylePanel.getFontSizeKey(), "size"));
        assertEquals("The return value is not correct.", 10, adapter.getFontSize());
    }

    /**
     * <p>
     * Tests GraphNodeStyleObjectAdapter#getFontSize() for accuracy.
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