/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.failuretests;

import java.awt.Color;
import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

/**
 * <p>
 * This class aggregates failure tests for SelectionCorner class.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class SelectionCornerFailureTests extends TestCase {

    /**
     * A SelectionCorner object for testing purposes.
     */
    private SelectionCorner test;

    /**
     * A Point object for testing purposes.
     */
    private Point center = new Point(1, 1);

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        test = new SelectionCorner(SelectionCornerType.EAST, center);
    }

    /**
     * Tests 2-argument constructor with null type argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerSelectionCornerTypePoint_NullTypeArgument() {
        try {
            new SelectionCorner(null, center);
            fail("Did not throw IAE with null type argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests 2-argument constructor with null center argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerSelectionCornerTypePoint_NullCenterArgument() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, null);
            fail("Did not throw IAE with null center argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests 5-argument constructor with null type argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerSelectionCornerTypePointIntColorColor_NullTypeArgument() {
        try {
            new SelectionCorner(null, center, 1, Color.BLACK, Color.WHITE);
            fail("Did not throw IAE with null type argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests 5-argument constructor with null center argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerSelectionCornerTypePointIntColorColor_NullCenterArgument() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, null, 1, Color.BLACK, Color.WHITE);
            fail("Did not throw IAE with null center argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests 5-argument constructor with radius = 0 argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerSelectionCornerTypePointIntColorColor_ZeroRadiusArgument() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, center, 0, Color.BLACK, Color.WHITE);
            fail("Did not throw IAE with radius = 0 argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests 5-argument constructor with radius = -1 argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerSelectionCornerTypePointIntColorColor_NegativeRadiusArgument() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, center, -1, Color.BLACK, Color.WHITE);
            fail("Did not throw IAE with radius = -1 argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests 5-argument constructor with null strokeColor argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerSelectionCornerTypePointIntColorColor_NullStrokeColorArgument() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, center, 1, null, Color.WHITE);
            fail("Did not throw IAE with null strokeColor argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests 5-argument constructor with null fillColor argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerSelectionCornerTypePointIntColorColor_NullFillColorArgument() {
        try {
            new SelectionCorner(SelectionCornerType.EAST, center, 1, Color.BLACK, null);
            fail("Did not throw IAE with null fillColor argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests setType method with null type argument. IllegalArgumentException is expected.
     */
    public void testSetType_NullTypeArgument() {
        try {
            test.setType(null);
            fail("Did not throw IAE with null type argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests setRadius method with radius = 0 argument. IllegalArgumentException is expected.
     */
    public void testSetRadius_ZeroRadiusArgument() {
        try {
            test.setRadius(0);
            fail("Did not throw IAE with radius = 0 argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests setRadius method with radius = -1 argument. IllegalArgumentException is expected.
     */
    public void testSetRadius_NegativeRadiusArgument() {
        try {
            test.setRadius(-1);
            fail("Did not throw IAE with radius = -1 argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests setCenter method with null center argument. IllegalArgumentException is expected.
     */
    public void testSetCenter_NullCenterArgument() {
        try {
            test.setCenter(null);
            fail("Did not throw IAE with null center argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests setStrokeColor method with null strokeColor argument. IllegalArgumentException is expected.
     */
    public void testSetStrokeColor_NullStrokeColorArgument() {
        try {
            test.setStrokeColor(null);
            fail("Did not throw IAE with null strokeColor argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests setFillColor method with null fillColor argument. IllegalArgumentException is expected.
     */
    public void testSetFillColor_NullFillColorArgument() {
        try {
            test.setFillColor(null);
            fail("Did not throw IAE with null fillColor argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }
}
