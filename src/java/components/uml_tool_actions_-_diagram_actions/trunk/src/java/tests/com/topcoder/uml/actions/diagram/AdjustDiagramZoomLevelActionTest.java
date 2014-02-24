/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.util.actionmanager.TransientAction;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for {@link AdjustDiagramZoomLevelAction}. It tests the constructor and the <code>execute</code> method.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AdjustDiagramZoomLevelActionTest extends TestCase {

    /**
     * <p>
     * AdjustDiagramZoomLevelAction instance used for testing.
     * </p>
     */
    private AdjustDiagramZoomLevelAction action;

    /**
     * <p>
     * Double variable representing the zoom level.
     * </p>
     */
    private Double zoomLevel = 1.0;


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
        return new TestSuite(AdjustDiagramZoomLevelActionTest.class);
    }

    /**
     * <p>
     * Sets up environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void setUp() throws Exception {
        diagram = new Diagram();
        action = new AdjustDiagramZoomLevelAction(diagram, zoomLevel);
    }

    /**
     * <p>
     * Tears Down environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void tearDown() throws Exception {
        diagram = null;
        action = null;
    }

    /**
     * <p>
     * Tests constructor for 'AdjustDiagramZoomLevelAction(Diagram, Double)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that AdjustDiagramZoomLevelAction(Diagram, Double) is correct and the instance should not be null.
     * </p>
     */
    public void testAdjustDiagramZoomLevelAction() {
        assertNotNull("AdjustDiagramZoomLevelAction instance should not be null.", action);
    }

    /**
     * <p>
     * Tests constructor for 'AdjustDiagramZoomLevelAction(Diagram, Double)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that AdjustDiagramZoomLevelAction(Diagram, Double) is correct and the instance should be a subclass of
     * TransientAction.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionForInheritace() {
        assertTrue("AdjustDiagramZoomLevelAction instance should be a subclass of TransientAction.",
                action instanceof TransientAction);
    }

    /**
     * <p>
     * Tests constructor for 'AdjustDiagramZoomLevelAction(Diagram, Double)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionWithNullDiagram() {
        try {
            new AdjustDiagramZoomLevelAction(null, zoomLevel);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }

    }

    /**
     * <p>
     * Tests constructor for 'AdjustDiagramZoomLevelAction(Diagram, Double)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the zoomLevel is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionWithNegativeZoomLevel() {
        try {
            new AdjustDiagramZoomLevelAction(diagram, -1.0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor for 'AdjustDiagramZoomLevelAction(Diagram, Double)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the zoomLevel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionWithNullZoomLevel() {
        try {
            new AdjustDiagramZoomLevelAction(diagram, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'AdjustDiagramZoomLevelAction.execute()' for accuracy
     * </p>
     *
     * <p>
     * Verify that AdjustDiagramZoomLevelAction.execute() is correct.
     * </p>
     */
    public void testExecute() {
        action.execute();
        assertEquals("The zoomLevel of the diagram should be 1.0", zoomLevel, diagram.getZoom());
    }

}
