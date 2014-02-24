/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import com.topcoder.gui.diagramviewer.uml.activityelements.RectangleConnector;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link RectangleConnector}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RectangleConnectorFailureTests extends TestCase {

    /**
     * <p>
     * Represents the RectangleConnector instance.
     * </p>
     */
    private RectangleConnector rectangleConnector = new RectangleConnector();

    /**
     * <p>
     * Failure test for {@link RectangleConnector#getConnectionPoint(java.awt.Point)} method.
     * </p>
     */
    public void testGetConnectionPointNullPoint() {
        try {
            rectangleConnector.getConnectionPoint(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }

    }
}
