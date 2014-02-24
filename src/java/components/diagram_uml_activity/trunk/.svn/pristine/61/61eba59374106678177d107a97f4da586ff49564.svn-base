/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import com.topcoder.gui.diagramviewer.uml.activityelements.EllipseConnector;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link EllipseConnector}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class EllipseConnectorFailureTests extends TestCase {

    /**
     * <p>
     * Represents the EllipseConnector instance.
     * </p>
     */
    private EllipseConnector ellipseConnector = new EllipseConnector();

    /**
     * <p>
     * Failure test for {@link EllipseConnector#getConnectionPoint(java.awt.Point)} method.
     * </p>
     */
    public void testGetConnectionPointNullPoint() {
        try {
            ellipseConnector.getConnectionPoint(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }

    }
}
