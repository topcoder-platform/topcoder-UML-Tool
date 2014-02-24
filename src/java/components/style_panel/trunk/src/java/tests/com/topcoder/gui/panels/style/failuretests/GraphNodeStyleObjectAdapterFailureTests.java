/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link GraphNodeStyleObjectAdapter}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class GraphNodeStyleObjectAdapterFailureTests extends TestCase {
    /**
     * <p>
     * Represents the {@link GraphNodeStyleObjectAdapter} instance used in tests.
     * </p>
     */
    private GraphNodeStyleObjectAdapter graphNodeStyleObjectAdapter = new GraphNodeStyleObjectAdapter(new GraphNode());

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#GraphNodeStyleObjectAdapter(GraphNode)}</code>
     * constructor.
     * </p>
     */
    public void testGraphNodeStyleObjectAdapterNullGraphNode() {
        try {
            new GraphNodeStyleObjectAdapter(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getHeight()}</code> method.
     * </p>
     */
    public void testGetHeightFaiureTest() {
        try {
            graphNodeStyleObjectAdapter.getHeight();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getWidth()}</code> method.
     * </p>
     */
    public void testGetWidthFaiureTest() {
        try {
            graphNodeStyleObjectAdapter.getWidth();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getX()}</code> method.
     * </p>
     */
    public void testGetXIllegalStateException() {
        try {
            graphNodeStyleObjectAdapter.getX();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getY()}</code> method.
     * </p>
     */
    public void testGetYIllegalStateException() {
        try {
            graphNodeStyleObjectAdapter.getY();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getFontName()}</code> method.
     * </p>
     */
    public void testGetFontNameIllegalStateException() {
        try {
            graphNodeStyleObjectAdapter.getFontName();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getFontSize()}</code> method.
     * </p>
     */
    public void testGetFontSizeIllegalStateException() {
        try {
            graphNodeStyleObjectAdapter.getFontSize();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getFillColor()}</code> method.
     * </p>
     */
    public void testGetFillColorFaiureTest() {
        try {
            graphNodeStyleObjectAdapter.getFillColor();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getOutlineColor)}</code> method.
     * </p>
     */
    public void testGetOutlineColorIllegalStateException() {
        try {
            graphNodeStyleObjectAdapter.getOutlineColor();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link GraphNodeStyleObjectAdapter#getTextColor)}</code> method.
     * </p>
     */
    public void testGetTextColorIllegalStateException() {
        try {
            graphNodeStyleObjectAdapter.getTextColor();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }
}
