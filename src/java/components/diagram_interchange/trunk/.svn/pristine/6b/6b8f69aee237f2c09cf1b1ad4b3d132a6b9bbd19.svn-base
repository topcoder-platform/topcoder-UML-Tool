/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

/**
 * <p>
 * This demo shows how to use the API to instantiate a class of this component and how to access its simple
 * attributes, collection attributes and list attributes.
 * </p>
 * <p>
 * For this purpose, GraphEdge is taken as example, but the same API is used for all attributes of this
 * component classes.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTest extends TestCase {

    /**
     * Demo 1: Instantiate a class.
     */
    public void testDemo1() {
        // create a new instance
        GraphEdge edge = new GraphEdge();
    }

    /**
     * Demo 2: Access simple attributes.
     */
    public void testDemo2() {
        // assuming we have got a Point
        Point position = new Point();

        // create a new instance
        GraphEdge edge = new GraphEdge();

        // set the new position
        edge.setPosition(position);

        // get the current position
        Point edgePosition = edge.getPosition();
    }

    /**
     * Demo 3: Access collection attributes.
     */
    public void testDemo3() {
        // assuming we have got two DiagramLinks
        DiagramLink diagramLink1 = new DiagramLink();
        DiagramLink diagramLink2 = new DiagramLink();

        // create a new instance
        GraphEdge edge = new GraphEdge();

        // append element 1 and 2
        edge.addLink(diagramLink1);
        edge.addLink(diagramLink2);

        // remove element 1
        boolean hasBeenRemoved = edge.removeLink(diagramLink1);

        // get a copy of all the elements
        Collection<DiagramLink> edgeLinks = edge.getLinks();

        // check element 2 for inclusion
        boolean isIn = edge.containsLink(diagramLink2);

        // count the number of elements
        int howMany = edge.countLinks();

        // remove all the elements
        edge.clearLinks();
    }

    /**
     * Demo 4: Access list attributes.
     */
    public void testDemo4() {
        // Assuming we have got four BezierPoints
        BezierPoint bezierPoint1 = new BezierPoint();
        BezierPoint bezierPoint2 = new BezierPoint();
        BezierPoint bezierPoint3 = new BezierPoint();
        BezierPoint bezierPoint4 = new BezierPoint();

        // create a new instance
        GraphEdge edge = new GraphEdge();

        // append element 2 and 3
        edge.addWaypoint(bezierPoint2);
        edge.addWaypoint(bezierPoint3);

        // insert element 4 at position 2
        edge.addWaypoint(2, bezierPoint4);

        // replace the element at position 0 with element 1
        edge.setWaypoint(0, bezierPoint1);

        // remove the element at position 1
        Point removed = edge.removeWaypoint(1);

        // remove the element 4
        boolean hasBeenRemoved = edge.removeWaypoint(bezierPoint4);

        // get a copy of all the elements
        List<Point> edgeWaypoints = edge.getWaypoints();

        // check element 1 for inclusion
        boolean isIn = edge.containsWaypoint(bezierPoint1);

        // get the index of element 1
        int index = edge.indexOfWaypoint(bezierPoint1);

        // get the number of elements
        int howMany = edge.countWaypoints();

        // remove all the elements
        edge.clearWaypoints();
    }
}