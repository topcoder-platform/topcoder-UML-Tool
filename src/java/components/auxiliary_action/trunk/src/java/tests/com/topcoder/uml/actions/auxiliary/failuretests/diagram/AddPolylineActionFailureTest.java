/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AddPolylineActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.actions.auxiliary.diagram.AddPolylineAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;

/**
 * <p>
 * This is a failure tests for <code>AddPolylineAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AddPolylineActionFailureTest extends TestCase {

    /**Polyline GraphEdge that is used for testing.*/
    private GraphEdge polylineGraphEdge;

    /**Diagram GraphNode that is used for testing.*/
    private GraphNode diagram;

    /**UMLModelManager instance that is used for testing.*/
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        Helper.clearNamespace();
        Helper.initNamespace();

        polylineGraphEdge = new GraphEdge();
        diagram = new GraphNode();
        umlModelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Tear down.
     * </p>
     *
     * @throws Exception exception
     */
    public void tearDown() throws Exception {
        Helper.clearNamespace();
    }

    /**
     * <p>
     * Tests constructor AddPolylineAction(polylineGraphEdge, diagram, umlModelManager) if
     * polylineGraphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPolylineGraphEdgeNull() {
        try {
            new AddPolylineAction(null, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because polylineGraphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddPolylineAction(polylineGraphEdge, diagram, umlModelManager) if
     * diagram is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDiagramNull() {
        try {
            polylineGraphEdge.addContained(new Polyline());
            new AddPolylineAction(polylineGraphEdge, null, umlModelManager);
            fail("IllegalArgumentException is expected because diagram cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddPolylineAction(polylineGraphEdge, diagram, umlModelManager) if
     * umlModelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfModelManagerNull() {
        try {
            polylineGraphEdge.addContained(new Polyline());
            new AddPolylineAction(polylineGraphEdge, diagram, null);
            fail("IllegalArgumentException is expected because umlModelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddPolylineAction(polylineGraphEdge, diagram, umlModelManager) if
     * polylineGraphEdge doesn't contain a Polyline object in its contained attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPolylineGraphEdgeNotContainedPolylineObject() {
        try {
            new AddPolylineAction(polylineGraphEdge, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because polylineGraphEdge must contain a Polyline "
                    + "object in its contained attribute.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}