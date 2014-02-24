/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.panels.style.StyleNotSupportedException;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link PolylineStyleObjectAdapter}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class PolylineStyleObjectAdapterFailureTests extends TestCase {

    /**
     * <p>
     * Represents the {@link PolylineStyleObjectAdapter} instance used in tests.
     * </p>
     */
    private PolylineStyleObjectAdapter polylineStyleObjectAdapter = new PolylineStyleObjectAdapter(new Polyline());

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#PolylineStyleObjectAdapter(GraphEdge)}</code>
     * constructor.
     * </p>
     */
    public void testPolylineStyleObjectAdapterNullGraphEdge() {
        try {
            new PolylineStyleObjectAdapter(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getHeight()}</code> method.
     * </p>
     */
    public void testGetHeightFaiureTest() {
        try {
            polylineStyleObjectAdapter.getHeight();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getWidth()}</code> method.
     * </p>
     */
    public void testGetWidthFaiureTest() {
        try {
            polylineStyleObjectAdapter.getWidth();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getX()}</code> method.
     * </p>
     */
    public void testGetXIllegalStateException() {
        try {
            polylineStyleObjectAdapter.getX();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getY()}</code> method.
     * </p>
     */
    public void testGetYIllegalStateException() {
        try {
            polylineStyleObjectAdapter.getY();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getFontName()}</code> method.
     * </p>
     */
    public void testGetFontNameIllegalStateException() {
        try {
            polylineStyleObjectAdapter.getFontName();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getFontSize()}</code> method.
     * </p>
     */
    public void testGetFontSizeIllegalStateException() {
        try {
            polylineStyleObjectAdapter.getFontSize();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getFillColor()}</code> method.
     * </p>
     */
    public void testGetFillColorFaiureTest() {
        try {
            polylineStyleObjectAdapter.getFillColor();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getOutlineColor)}</code> method.
     * </p>
     */
    public void testGetOutlineColorIllegalStateException() {
        try {
            polylineStyleObjectAdapter.getOutlineColor();
            fail("expect throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link PolylineStyleObjectAdapter#getTextColor)}</code> method.
     * </p>
     */
    public void testGetTextColorIllegalStateException() {
        try {
            polylineStyleObjectAdapter.getTextColor();
            fail("expect throw StyleNotSupportedException");
        } catch (StyleNotSupportedException e) {
            // expected
        }
    }
}
