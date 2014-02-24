/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Class_Edges Version 1.0 StressTest.
 *
 * @ NoArrowStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.classedges.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Point;
import java.awt.geom.AffineTransform;


/**
 * <p>
 * This class tests the <code>NoArrow</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>NoArrow</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class NoArrowStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 360;

    /**
     * <p>The instance of <code>NoArrow</code> for test.</p>
     */
    private NoArrow arrow = null;

    /**
     * <p>Return test suite of <code>NoArrowStressTest</code>.</p>
     *
     * @return Test suite of <code>NoArrowStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(NoArrowStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        // create some GraphNode here.
        GraphNode node1 = new GraphNode();
        GraphNode node2 = new GraphNode();
        // create arrow arrow here.
        arrow = new NoArrow(new TextField(node1), new TextField(node2));
    }

    /**
     * <p>
     * Basic stress test of <code>contains(int x, int y)</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testNoArrow_contains() throws Exception {
        arrow.setEndingPoint(new Point(30, 30));

        // rotate the arrow 0 -270 degree.
        for (int i = 0; i < 270; i++) {
            double angle = (Math.PI * i) / LOOPTIMES;
            arrow.setAngle(angle);

            for (int j = 20; j < 100; j++) {
                assertTrue("The contains method is incorrect.",
                    StressTestHelper.checkForEqual(arrow.contains(j, j + 10),
                        contains(j, j + 10, 30, 30, angle)));
            }
        }
    }

    /**
     * <p>
     * Helper method used to check the given point cintains in the arrow or not.
     * </p>
     *
     * @param x the x coordinate value.
     * @param y the y coordinate value.
     * @param endingX the x coordinate value of the ending point.
     * @param endingY the y coordinate value of the ending point.
     * @param angle the specified angle of the arrow.
     *
     * @return true if the point is contained, false otherwise.
     *
     * @throws Exception if if any exception occurs when testing.
     */
    private boolean contains(int x, int y, int endingX, int endingY,
        double angle) throws Exception {
        // translate the point
        AffineTransform tx = AffineTransform.getRotateInstance(angle, endingX,
            endingY);
        java.awt.Point ptSrc = new java.awt.Point(x, y);
        java.awt.Point ptDst = new java.awt.Point();
        tx.inverseTransform(ptSrc, ptDst);

        // Determine whether the new point is in rectangle, ending point is treated as right-top point
        int lengthX = (int) arrow.getEndingPoint().getX() - ptDst.x;
        int lengthY = (int) arrow.getEndingPoint().getY() - ptDst.y;

        if ((lengthX > 10) || (lengthX < 0) || (lengthY > 10) || (lengthY < 0)) {
            return false;
        }

        return true;
    }
}
