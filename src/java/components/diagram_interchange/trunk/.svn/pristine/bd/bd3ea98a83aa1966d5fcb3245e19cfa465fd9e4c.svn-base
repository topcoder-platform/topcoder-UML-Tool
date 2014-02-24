/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.stresstests;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * <p>This class tests the <code>GraphConnector</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>GraphConnector</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class GraphConnectorStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The instance of <code>GraphConnector</code> for test.</p>
     */
    private GraphConnector conn = null;

    /**
     * <p>Return test suite of <code>GraphConnectorStressTest</code>.</p>
     *
     * @return Test suite of <code>GraphConnectorStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(GraphConnectorStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        conn = new GraphConnector();
    }

    /**
     * <p>Basic stress test of <code>getXXX()</code> and <code>setXXX()</code> methods.</p>
     */
    public void testMethod_getset() {
        for (int i = 0; i < LOOPTIMES; i++) {
            // test getPosition and setPosition method
            Point position = new Point();
            conn.setPosition(position);
            assertEquals("The getPosition method is incorrect.", position, conn.getPosition());

            // test getGraphElement and setGraphElement method
            GraphElement graphElement = new GraphNode();
            conn.setGraphElement(graphElement);
            assertEquals("The getGraphElement method is incorrect.", graphElement,
                conn.getGraphElement());
        }
    }

    /**
     * <p>Basic stress test of <code>addGraphEdge()</code>, <code>removeGraphEdge()</code>,
     * <code>clearGraphEdges()</code>, <code>getGraphEdges()</code>,
     * <code>containsGraphEdge()</code>, <code>countGraphEdges()</code> methods.</p>
     */
    public void testMethod_GraphEdge() {
        List<GraphEdge> graphEdges = new ArrayList<GraphEdge>();

        for (int i = 0; i < LOOPTIMES; i++) {
            GraphEdge graphEdge = new GraphEdge();
            conn.addGraphEdge(graphEdge);
            graphEdges.add(graphEdge);

            // check the result here.
            assertTrue("The containsGraphEdge method is incorrect.",
                conn.containsGraphEdge(graphEdge));
            assertEquals("The countGraphEdges method is incorrect.", i + 1, conn.countGraphEdges());

            Collection<GraphEdge> getGraphEdges = conn.getGraphEdges();
            assertEquals("The getGraphEdges method is incorrect.", i + 1, getGraphEdges.size());
            assertTrue("The getGraphEdges method is incorrect.",
                graphEdges.containsAll(getGraphEdges));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            assertTrue("The removeGraphEdge method is incorrect." + i,
                conn.removeGraphEdge(graphEdges.get(i)));
            assertEquals("The removeGraphEdge method is incorrect.", LOOPTIMES - i - 1,
                conn.countGraphEdges());
            assertFalse("The removeGraphEdge method is incorrect.",
                conn.containsGraphEdge(graphEdges.get(i)));
        }

        // clear all diagram links and test it.
        conn.clearGraphEdges();
        assertEquals("The clearGraphEdges method is incorrect.", 0, conn.countGraphEdges());
    }
}
