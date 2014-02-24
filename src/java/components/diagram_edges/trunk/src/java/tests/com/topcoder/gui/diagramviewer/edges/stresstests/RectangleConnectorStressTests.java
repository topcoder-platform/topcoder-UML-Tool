/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import java.awt.Point;
import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;

import junit.framework.TestCase;

/**
 * Stress test for <code>RectangleConnector</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class RectangleConnectorStressTests extends TestCase {

    /**
     * Represents the <code>RectangleConnector</code> instance used to test against.
     */
    private final RectangleConnector connector = new RectangleConnector(new Rectangle(100, 200, 150, 75));

    /**
     * Stress test for <code>RectangleConnector</code> class.
     */
    public void testRectangleConnectorStress() {
        // record the start time
        TestHelper.startTimer();

        for (int i = 0; i < TestHelper.NUMBER; i++) {
            // get the rectangle
            connector.getRectangle();
            // set the new rectangle
            connector.setRectangle(new Rectangle(1000, 2000, 1500, 750));
            // calculate the connection point
            connector.getConnectionPoint(new Point(i, -i));
        }

        // print the result
        TestHelper.printResultMulTimes("RectangleConnector");
    }
}
