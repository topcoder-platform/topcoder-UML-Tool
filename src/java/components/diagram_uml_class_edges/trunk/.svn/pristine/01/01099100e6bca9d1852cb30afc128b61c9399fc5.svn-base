/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Class_Edges Version 1.0 StressTest.
 *
 * @ OpenArrowStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.classedges.stresstests;

import com.topcoder.gui.diagramviewer.uml.classedges.OpenArrow;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Point;


/**
 * <p>
 * This class tests the <code>OpenArrow</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>OpenArrow</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class OpenArrowStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 360;

    /**
     * <p>The instance of <code>OpenArrow</code> for test.</p>
     */
    private OpenArrow arrow = null;

    /**
     * <p>Return test suite of <code>OpenArrowStressTest</code>.</p>
     *
     * @return Test suite of <code>OpenArrowStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(OpenArrowStressTest.class);
    }

    /**
     * <p>
     * Basic stress test of <code>contains(int x, int y)</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testOpenArrow_contains() throws Exception {
        // create OpenArrow here.
        arrow = new OpenArrow();
        arrow.setEndingPoint(new Point(30, 25));

        // rotate the arrow 0 -270 degree.
        for (int i = 0; i < 270; i++) {
            double angle = (Math.PI * i) / LOOPTIMES;
            arrow.setAngle(angle);

            for (int j = 20; j < 100; j++) {
                assertTrue("The contains method is incorrect.",
                    StressTestHelper.checkForEqual(arrow.contains(j, j + 10),
                        StressTestHelper.arrowContains(j, j + 10, 30, 25, angle, 0)));
            }
        }
    }
}
