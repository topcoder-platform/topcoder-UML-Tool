/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ DiagramLinkAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>DiagramLink</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>DiagramLink</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class DiagramLinkAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>DiagramLink</code> used for tests.
     * </p>
     */
    private DiagramLink test = null;

    /**
     * <p>
     * Test suite of <code>DiagramLinkAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DiagramLinkAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DiagramLinkAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new DiagramLink();
    }

    /**
     * <p>
     * Accuracy Test of the <code>DiagramLink()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new DiagramLink());

        // get the original value of viewport to check the constructor
        assertNull("The viewport expected to be null", test.getViewport());

        // get the original value of graphElement to check the constructor
        assertNull("The graphElement expected to be null",
            test.getGraphElement());

        // get the original value of diagram to check the constructor
        assertNull("The diagram expected to be null", test.getDiagram());

        // get the original value of zoom to check the constructor
        assertEquals("The zoom expected to be 0.0", 0.0, test.getZoom());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setZoom(double)</code> method and
     * <code>getZoom()</code>.
     * </p>
     */
    public void testZoom_Operation() {
        // set the zoom.
        test.setZoom(5.34);

        // get the zoom.
        assertEquals("The zoom expected to be equal", 5.34, test.getZoom());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setViewport(Point)</code> method and
     * <code>getViewport()</code>.
     * </p>
     */
    public void testViewport_Operation() {
        // creat a new Point.
        Point point = new Point();

        // set the viewport.
        test.setViewport(point);

        // get the viewport.
        assertEquals("The viewport expected to be equal", point,
            test.getViewport());

        // set the viewport to null.
        test.setViewport(null);

        // get the viewport.
        assertNull("The viewport expected to be null", test.getViewport());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setGraphElement(GraphElement)</code> method and
     * <code>getGraphElement()</code>.
     * </p>
     */
    public void testGraphElement_Operation() {
        // creat a new GraphElement.
        GraphElement element = new GraphEdge();

        // set the graphElement.
        test.setGraphElement(element);

        // get the graphElement.
        assertEquals("The graphElement expected to be equal", element,
            test.getGraphElement());

        // set the graphElement to null.
        test.setGraphElement(null);

        // get the graphElement.
        assertNull("The graphElement expected to be null",
            test.getGraphElement());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setDiagram(Diagram)</code> method and
     * <code>getDiagram()</code>.
     * </p>
     */
    public void testDiagram_Operation() {
        // creat a new Diagram.
        Diagram diagram = new Diagram();

        // set the diagram.
        test.setDiagram(diagram);

        // get the diagram.
        assertEquals("The diagram expected to be equal", diagram,
            test.getDiagram());

        // set the diagram to null.
        test.setDiagram(null);

        // get the diagram.
        assertNull("The diagram expected to be null", test.getDiagram());
    }
}
