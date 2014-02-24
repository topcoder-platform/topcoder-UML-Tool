/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.panels.style.StyleNotSupportedException;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link GraphEdgeStyleObjectAdapter}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class GraphEdgeStyleObjectAdapterFailureTests extends TestCase {

    /**
     * <p>
     * Represents the {@link GraphEdgeStyleObjectAdapter} instance used in tests.
     * </p>
     */
    private GraphEdgeStyleObjectAdapter graphEdgeStyleObjectAdapter = new GraphEdgeStyleObjectAdapter(new GraphEdge());

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#GraphEdgeStyleObjectAdapter(GraphEdge)}</code>
     * constructor.
     * </p>
     */
    public void testGraphEdgeStyleObjectAdapterNullGraphEdge() {
        try {
            new GraphEdgeStyleObjectAdapter(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getHeight()}</code> method.
     * </p>
     */
    public void testGetHeightFaiureTest() {
        try {
            graphEdgeStyleObjectAdapter.getHeight();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getWidth()}</code> method.
     * </p>
     */
    public void testGetWidthFaiureTest() {
        try {
            graphEdgeStyleObjectAdapter.getWidth();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getX()}</code> method.
     * </p>
     */
    public void testGetXIllegalStateException() {
        try {
            graphEdgeStyleObjectAdapter.getX();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getY()}</code> method.
     * </p>
     */
    public void testGetYIllegalStateException() {
        try {
            graphEdgeStyleObjectAdapter.getY();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getFontName()}</code> method.
     * </p>
     */
    public void testGetFontNameIllegalStateException() {
        try {
            graphEdgeStyleObjectAdapter.getFontName();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getFontSize()}</code> method.
     * </p>
     */
    public void testGetFontSizeIllegalStateException() {
        try {
            graphEdgeStyleObjectAdapter.getFontSize();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getFillColor()}</code> method.
     * </p>
     */
    public void testGetFillColorFaiureTest() {
        try {
            graphEdgeStyleObjectAdapter.getFillColor();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getOutlineColor)}</code> method.
     * </p>
     */
    public void testGetOutlineColorIllegalStateException() {
        try {
            graphEdgeStyleObjectAdapter.getOutlineColor();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphEdgeStyleObjectAdapter#getTextColor)}</code> method.
     * </p>
     */
    public void testGetTextColorIllegalStateException() {
        try {
            graphEdgeStyleObjectAdapter.getTextColor();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }
}
