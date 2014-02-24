/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Point;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Collection;


/**
 * <p>This class tests the <code>SelectionBoundEvent</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>SelectionBoundEvent</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class SelectionBoundEventStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode graphNode = new GraphNode();

    /**
     * <p>The <code>Point</code> instance used for test.</p>
     */
    private Point position = new Point(100, 100);

    /**
     * <p>The <code>Rectangle</code> instance used for test.</p>
     */
    private Rectangle bound = new Rectangle(50, 150, 100, 100);

    /**
     * <p>The <code>SelectionCornerType</code> collection used for test.</p>
     */
    private Collection<SelectionCornerType> corners = null;

    /**
     * <p>The <code>Node</code> instance used for test.</p>
     */
    private Node node = null;

    /**
     * <p>The <code>Rectangle</code> used for test.</p>
     */
    private Rectangle oldBound = new Rectangle(10, 20, 300, 100);

    /**
     * <p>The instance of <code>SelectionBoundEvent</code> for test.</p>
     */
    private SelectionBoundEvent event = null;

    /**
     * <p>Return test suite of <code>SelectionBoundEventStressTest</code>.</p>
     *
     * @return Test suite of <code>SelectionBoundEventStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(SelectionBoundEventStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        // create the SelectionCorner type here.
        corners = new ArrayList<SelectionCornerType>();
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.SOUTH);
        corners.add(SelectionCornerType.WEST);
        corners.add(SelectionCornerType.NORTH);

        // create a node here.
        node = new SimpleNode(graphNode, position, bound, corners);
    }

    /**
     * <p>Basic stress test of <code>getXXXOffset()</code> methods.</p>
     */
    public void testMethod_getXXXOffset() {
        // add some compartment nodes here.
        for (int i = 0; i < LOOPTIMES; i++) {
            Rectangle newBound = new Rectangle(oldBound.x - i, oldBound.y + i, oldBound.width,
                    oldBound.height - i);

            event = new SelectionBoundEvent(node, oldBound, newBound);

            // check the getXXXOffset here.
            assertEquals("The getEastOffset method is incorrect.", -i, event.getEastOffset());
            assertEquals("The getNorthOffset method is incorrect.", i, event.getNorthOffset());
            assertEquals("The getSouthOffset method is incorrect.", 0, event.getSouthOffset());
            assertEquals("The getWestOffset method is incorrect.", -i, event.getWestOffset());
        }
    }
}
