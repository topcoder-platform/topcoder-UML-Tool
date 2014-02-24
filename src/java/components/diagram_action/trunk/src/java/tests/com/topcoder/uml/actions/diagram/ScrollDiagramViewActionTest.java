/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.util.actionmanager.TransientAction;


/**
 * <p>
 * Unit tests for {@link ScrollDiagramViewAction}. It tests the constructor and the <code>execute</code> method.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ScrollDiagramViewActionTest extends TestCase {

    /**
     * <p>
     * ScrollDiagramViewAction instance used for testing.
     * </p>
     */
    private ScrollDiagramViewAction action;

    /**
     * <p>
     * Point variable representing viewport of the diagram.
     * </p>
     */
    private Point viewport;


    /**
     * <p>
     * Diagram instance used for testing.
     * </p>
     */
    private Diagram diagram;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ScrollDiagramViewActionTest.class);
    }

    /**
     * <p>
     * Sets up environment.
     * </p>
     */
    public void setUp() {
        diagram = new Diagram();
        viewport = new Point();
        action = new ScrollDiagramViewAction(diagram, viewport);
    }

    /**
     * <p>
     * Tears Down environment.
     * </p>
     */
    public void tearDown() {
        diagram = null;
        action = null;
        viewport = null;
    }

    /**
     * <p>
     * Tests constructor for 'ScrollDiagramViewAction(Diagram, Double)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that ScrollDiagramViewAction(Diagram, Double) is correct and the instance should not be null.
     * </p>
     */
    public void testAdjustDiagramZoomLevelAction() {
        assertNotNull("ScrollDiagramViewAction instance should not be null.", action);
    }

    /**
     * <p>
     * Tests constructor for 'ScrollDiagramViewAction(Diagram, Double)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that ScrollDiagramViewAction(Diagram, Double) is correct and the instance should be a subclass of
     * TransientAction.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionForInheritace() {
        assertTrue("ScrollDiagramViewAction instance should be a subclass of TransientAction.",
                action instanceof TransientAction);
    }

    /**
     * <p>
     * Tests constructor for 'ScrollDiagramViewAction(Diagram, Double)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionWithNullDiagram() {
        try {
            new ScrollDiagramViewAction(null, viewport);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor for 'ScrollDiagramViewAction(Diagram, Double)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the zoomLevel is null and expects no IllegalArgumentException.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionWithNullViewPort() {
        try {
            new ScrollDiagramViewAction(diagram, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'ScrollDiagramViewAction.execute()' for accuracy
     * </p>
     *
     * <p>
     * Verify that ScrollDiagramViewAction.execute() is correct.
     * </p>
     */
    public void testExecute() {
        action.execute();
        assertEquals("The viewport is incorrect.", viewport, diagram.getViewport());
    }
}
