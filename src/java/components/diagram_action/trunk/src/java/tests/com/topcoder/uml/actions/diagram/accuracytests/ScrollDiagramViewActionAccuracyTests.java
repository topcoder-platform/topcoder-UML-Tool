/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ ScrollDiagramViewActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Point;

import com.topcoder.uml.actions.diagram.ScrollDiagramViewAction;

import com.topcoder.util.actionmanager.TransientAction;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>ScrollDiagramViewAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>ScrollDiagramViewAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class ScrollDiagramViewActionAccuracyTests extends TestCase {
    /**
    * <p>
    * Represents an instance of <code>ScrollDiagramViewAction</code> uses for accuracy tests.
    * </p>
    */
    private ScrollDiagramViewAction test = null;

    /**
     * <p>
     * Represents an instance of <code>Diagram</code> uses for accuracy tests.
     * </p>
     */
    private Diagram diagram = null;

    /**
     * <p>
     * Test suite of <code>ScrollDiagramViewActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>ScrollDiagramViewActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(ScrollDiagramViewActionAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        // clean the ConfigManager.
        TestHelper.clearConfig();
        TestHelper.loadLogFile();
        diagram = new Diagram();

        Point point = new Point();
        point.setX(3.2);
        point.setY(5.4);
        test = new ScrollDiagramViewAction(diagram, point);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // clean the ConfigManager.
        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Accuracy Test of the <code>ScrollDiagramViewAction(Diagram, Point)</code>
     * constructor and execute() method.
     * </p>
     */
    public void testScrollDiagramViewActionCtor_Basic() {
        // check for creating successful.
        assertNotNull("Create failed.", test);
        // adjust the diagram's viewpoint.
        test.execute();
        // check new viewpoint here.
        assertEquals("The viewpoint should at (3.2, 5.4).", 3.2,
            diagram.getViewport().getX());
        assertEquals("The viewpoint should at (3.2, 5.4).", 5.4,
            diagram.getViewport().getY());
    }

    /**
     * <p>
     * Accuracy Test of the <code>ScrollDiagramViewAction(Diagram, Double)</code>
     * constructor and execute() method.
     * It tests this methods with different values.
     * </p>
     */
    public void testScrollDiagramViewActionCtor_Times() {
        // creat some point.
        Point point1 = new Point();
        point1.setX(3.2);
        point1.setY(5.4);

        Point point2 = new Point();
        point2.setX(5.7);
        point2.setY(9.3);

        Point[] points = new Point[] {point1, point2};

        for (Point point : points) {
            test = new ScrollDiagramViewAction(diagram, point);
            // check for creating successful.
            assertNotNull("Create failed.", test);
            // adjust the diagram's viewpoint.
            test.execute();
            // check new viewpoint here.
            assertEquals("Equal viewpoint expected.", point,
                diagram.getViewport());
        }
    }

    /**
     * <p>
     * Accuracy Test of the <code>ScrollDiagramViewAction</code> calss.
     * It tests class inheritance.
     * </p>
     */
    public void testInheritance() {
        // test class inheritance.
        assertTrue("This class should extend from TransientAction",
            test instanceof TransientAction);
    }
}
