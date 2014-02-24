/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.stresstests;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>This class tests the <code>GraphEdge</code> class for stress. This stress tests addresses
 * the functionality provided by the <code>GraphEdge</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class GraphEdgeStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The instance of <code>GraphEdge</code> for test.</p>
     */
    private GraphEdge graphEdge = null;

    /**
     * <p>Return test suite of <code>GraphEdgeStressTest</code>.</p>
     *
     * @return Test suite of <code>GraphEdgeStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(GraphEdgeStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        graphEdge = new GraphEdge();
    }

    /**
     * <p>Basic stress test of <code>addWaypoint()</code>, <code>setWaypoint()</code>,
     * <code>removeWaypoint()</code>, <code>clearWaypoints()</code>, <code>getWaypoints()</code>,
     * <code>containsWaypoint()</code>, <code>indexOfWaypoint()</code>,
     * <code>countWaypoints()</code> methods.</p>
     */
    public void testMethod_Waypoint() {
        List<Point> wayPoints = new ArrayList<Point>();

        for (int i = 0; i < LOOPTIMES; i++) {
            Point waypoint = new Point();
            graphEdge.addWaypoint(waypoint);

            // check the way point.
            assertTrue("The containsProperty method is incorrect.",
                graphEdge.containsWaypoint(waypoint));
            assertEquals("The indexOfWaypoint method is incorrect.", i,
                graphEdge.indexOfWaypoint(waypoint));
            assertEquals("The countWaypoints method is incorrect.", i + 1,
                graphEdge.countWaypoints());

            // set a new way point.
            Point newWaypoint = new Point();

            graphEdge.setWaypoint(i, newWaypoint);
            wayPoints.add(newWaypoint);

            // check the result here.
            assertFalse("The setWaypoint method is incorrect.", graphEdge.containsWaypoint(waypoint));
            assertTrue("The setWaypoint method is incorrect.",
                graphEdge.containsWaypoint(newWaypoint));
            assertEquals("The indexOfWaypoint method is incorrect.", i,
                graphEdge.indexOfWaypoint(newWaypoint));
            assertEquals("The setWaypoint method is incorrect.", i + 1, graphEdge.countWaypoints());

            // get all way points and test it.
            List<Point> getWayPoints = graphEdge.getWaypoints();
            assertEquals("The getWaypoints method is incorrect.", i + 1, getWayPoints.size());
            assertTrue("The getWaypoints method is incorrect.", wayPoints.containsAll(getWayPoints));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            Point removed = graphEdge.removeWaypoint(i);
            assertEquals("The removeWaypoint method is incorrect.", LOOPTIMES - i - 1,
                graphEdge.countWaypoints());
            assertFalse("The removeWaypoint method is incorrect.",
                graphEdge.containsWaypoint(removed));
        }

        graphEdge.clearWaypoints();
        assertEquals("The clearWaypoints method is incorrect.", 0, graphEdge.countWaypoints());
    }

    /**
     * <p>Basic stress test of <code>addAnchor()</code>, <code>setAnchor()</code>,
     * <code>removeAnchor()</code>, <code>clearAnchors()</code>, <code>getAnchors()</code>,
     * <code>containsAnchor()</code>, <code>indexOfAnchor()</code>, <code>countAnchors()</code>
     * methods.</p>
     */
    public void testMethod_Anchor() {
        for (int i = 0; i < LOOPTIMES; i++) {
            // add two anchor here.
            for (int j = 0; j < 2; j++) {
                GraphConnector anchor = new GraphConnector();
                graphEdge.addAnchor(anchor);

                // check the anchor.
                assertTrue("The containsAnchor method is incorrect.",
                    graphEdge.containsAnchor(anchor));
                assertEquals("The indexOfAnchor method is incorrect.", j,
                    graphEdge.indexOfAnchor(anchor));
                assertEquals("The countAnchors method is incorrect.", j + 1,
                    graphEdge.countAnchors());

                // set a new anchor and test it.
                GraphConnector newAnchor = new GraphConnector();
                graphEdge.setAnchor(j, newAnchor);

                // check the anchor.
                assertFalse("The setAnchor method is incorrect.", graphEdge.containsAnchor(anchor));
                assertTrue("The setAnchor method is incorrect.", graphEdge.containsAnchor(newAnchor));
                assertEquals("The indexOfAnchor method is incorrect.", j,
                    graphEdge.indexOfAnchor(newAnchor));
                assertEquals("The setAnchor method is incorrect.", j + 1, graphEdge.countAnchors());
            }

            // remove anchor and test it.
            for (int j = 0; j < 2; j++) {
                GraphConnector removed = graphEdge.removeAnchor(0);
                assertEquals("The removeAnchor method is incorrect.", 1 - j,
                    graphEdge.countAnchors());
                assertFalse("The removeAnchor method is incorrect.",
                    graphEdge.containsAnchor(removed));
            }
        }
    }
}
