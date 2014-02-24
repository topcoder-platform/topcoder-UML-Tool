/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Unit tests on class <code>AddPolylineAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AddPolylineActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>AddPolylineAction</code> used in this test.
     * </p>
     */
    private AddPolylineAction action;
    /**
     * <p>
     * Polyline GraphEdge.
     * </p>
     */
    private GraphEdge polylineGraphEdge;
    /**
     * <p>
     * Diagram node used in this test.
     * </p>
     */
    private GraphNode diagram;
    /**
     * <p>
     * Instance of <code>UMLModelManager</code> used in this test.
     */
    private UMLModelManager manager;
    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.polylineGraphEdge = new GraphEdge();
        this.polylineGraphEdge.addContained(new Polyline());
        this.diagram = new Diagram();
        this.manager = new UMLModelManager();
        this.manager.setProjectConfigurationManager(new ProjectConfigurationManager(this.manager));
        this.action = new AddPolylineAction(this.polylineGraphEdge, this.diagram, this.manager);
    }

    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }
    /**
     * <p>
     * Test constructor <code>AddPolylineAction(GraphEdge polylineGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with null polylineGraphEdge,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullPolylineGraphEdge() {
        try {
            new AddPolylineAction(null, this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AddPolylineAction(GraphEdge polylineGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with polylineGraphEdge that has no Polyline,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_PolylineGraphEdgeWithoutPolyline() {
        GraphEdge node = new GraphEdge();
        try {
            new AddPolylineAction(node, this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddPolylineAction(GraphEdge polylineGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure null diagram,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullDiagram() {
        try {
            new AddPolylineAction(this.polylineGraphEdge, null, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddPolylineAction(GraphEdge polylineGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure null model manager,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullModelManager() {
        try {
            new AddPolylineAction(this.polylineGraphEdge, this.diagram, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AddPolylineAction(GraphEdge polylineGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
            new AddPolylineAction(this.polylineGraphEdge, this.diagram, this.manager));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Add Polyline", this.action.getPresentationName());
    }

}
