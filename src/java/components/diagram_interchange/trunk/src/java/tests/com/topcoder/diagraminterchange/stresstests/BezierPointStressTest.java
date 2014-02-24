/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.stresstests;

import com.topcoder.diagraminterchange.BezierPoint;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>This class tests the <code>BezierPoint</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>BezierPoint</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class BezierPointStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The instance of <code>BezierPoint</code> for test.</p>
     */
    private BezierPoint point = null;

    /**
     * <p>Return test suite of <code>BezierPointStressTest</code>.</p>
     *
     * @return Test suite of <code>BezierPointStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(BezierPointStressTest.class);
    }

    /**
     * <p>Basic stress test of <code>addControl()</code> methods.</p>
     */
    public void testMethod_addControl() {
        // test with the addControl(Point) method.
        for (int i = 0; i < LOOPTIMES; i++) {
            point = new BezierPoint();

            // add two control points.
            for (int j = 0; j < 2; j++) {
                Point control = new Point();
                point.addControl(control);

                // check the control.
                assertTrue("The addControl method is incorrect.", point.containsControl(control));
                assertEquals("The addControl method is incorrect.", j + 1, point.countControls());
            }

            // check the control.
            assertEquals("The addControl method is incorrect.", 2, point.countControls());
        }

        // test with the addControl(int, Point) method.
        for (int i = 0; i < LOOPTIMES; i++) {
            point = new BezierPoint();

            // add two control points.
            for (int j = 0; j < 2; j++) {
                Point control = new Point();
                point.addControl(j, control);

                // check the control.
                assertTrue("The addControl method is incorrect.", point.containsControl(control));
                assertEquals("The addControl method is incorrect.", j + 1, point.countControls());
            }

            // check the control.
            assertEquals("The addControl method is incorrect.", 2, point.countControls());
        }
    }

    /**
     * <p>Basic stress test of <code>setControl()</code> methods.</p>
     */
    public void testMethod_setControl() {
        for (int i = 0; i < LOOPTIMES; i++) {
            point = new BezierPoint();

            // add two control points.
            for (int j = 0; j < 2; j++) {
                Point control = new Point();
                point.addControl(control);

                Point newControl = new Point();
                point.setControl(j, newControl);

                // check the control.
                assertFalse("The setControl method is incorrect.", point.containsControl(control));
                assertTrue("The setControl method is incorrect.", point.containsControl(newControl));
                assertEquals("The setControl method is incorrect.", j + 1, point.countControls());
            }
        }
    }

    /**
     * <p>Basic stress test of <code>removeControl()</code> methods.</p>
     */
    public void testMethod_removeControl() {
        // test with removeControl(Point) method.
        for (int i = 0; i < LOOPTIMES; i++) {
            point = new BezierPoint();

            // add two control points.
            for (int j = 0; j < 2; j++) {
                Point control = new Point();
                point.addControl(control);
            }

            // remove the control and test it.
            List<Point> controls = point.getControls();

            for (int n = 0; n < controls.size(); n++) {
                point.removeControl(controls.get(n));

                // check the result here.
                assertFalse("The removeControl method is incorrect.",
                    point.containsControl(controls.get(n)));
                assertEquals("The removeControl method is incorrect.", controls.size() - n - 1,
                    point.countControls());
            }
        }

        // test with removeControl(int) method.
        for (int i = 0; i < LOOPTIMES; i++) {
            point = new BezierPoint();

            // add two control points.
            for (int j = 0; j < 2; j++) {
                Point control = new Point();
                point.addControl(control);
            }

            // remove the control and test it.
            List<Point> controls = point.getControls();

            for (int n = 0; n < controls.size(); n++) {
                point.removeControl(0);

                // check the result here.
                assertFalse("The removeControl method is incorrect.",
                    point.containsControl(controls.get(n)));
                assertEquals("The removeControl method is incorrect.", controls.size() - n - 1,
                    point.countControls());
            }
        }
    }

    /**
     * <p>Basic stress test of <code>clearControls()</code>, <code>getControls()</code>,
     * <code>containsControl()</code>, <code>indexOfControl()</code> and
     * <code>countControls()</code> methods.</p>
     */
    public void testMethod_simpleMethods() {
        for (int i = 0; i < LOOPTIMES; i++) {
            point = new BezierPoint();

            // add two control points.
            for (int j = 0; j < 2; j++) {
                Point control = new Point();
                point.addControl(control);

                // check the control.
                assertTrue("The addControl method is incorrect.", point.containsControl(control));
                assertEquals("The addControl method is incorrect.", j + 1, point.countControls());
                assertEquals("The indexOfControl method is incorrect.", j,
                    point.indexOfControl(control));
            }

            // check the result here.
            List<Point> controls = point.getControls();
            assertEquals("The getControls method is incorrect.", 2, controls.size());
            assertEquals("The addControl method is incorrect.", 2, point.countControls());
        }
    }
}
