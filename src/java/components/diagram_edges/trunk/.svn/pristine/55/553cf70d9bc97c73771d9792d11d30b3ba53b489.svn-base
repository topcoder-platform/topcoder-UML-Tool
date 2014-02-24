/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import java.awt.Point;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;

import junit.framework.TestCase;

/**
 * Stress test for <code>EdgeEnding</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class EdgeEndingStressTests extends TestCase {

    /**
     * Represents the <code>EdgeEnding</code> instance used to test against.
     */
    private EdgeEnding edgeEnding = new TriangleEdgeEnding();

    /**
     * Stress test for <code>EdgeEnding</code> class.
     */
    public void testLineStyleStress() {
        // record the start time
        TestHelper.startTimer();

        for (int i = 0; i < TestHelper.NUMBER; i++) {
            // get angle
            edgeEnding.getAngle();
            // set new angle
            edgeEnding.setAngle(i);
            // get ending point
            edgeEnding.getEndingPoint();
            // set new ending point
            edgeEnding.setEndingPoint(new Point(i, -i));
        }

        // print the result
        TestHelper.printResultMulTimes("EdgeEnding");
    }
}
