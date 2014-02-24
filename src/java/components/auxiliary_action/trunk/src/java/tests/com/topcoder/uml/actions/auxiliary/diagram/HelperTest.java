/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

/**
 * <p>
 * Unit tests on class <code>Helper</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class HelperTest extends TestCase {

    /**
     * <p>
     * Test method <code>validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with null freeTextGraphNode, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForFreeTextAction_NullFreeTextGraphNode() {
        try {
            Helper.validateGraphNodeForFreeTextAction(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode which has no semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForFreeTextAction_FreeTextGraphNodeWithoutSemanticModel() {
        GraphNode node = new GraphNode();
        node.addContained(new TextElement());
        try {
            Helper.validateGraphNodeForFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode has non-SimpleSemanticModelElement semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForFreeTextAction_FreeTextGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new Uml1SemanticModelBridge());
        node.addContained(new TextElement());
        try {
            Helper.validateGraphNodeForFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode has bad SimpleSemanticModelElement semantic model(no typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForFreeTextAction_FreeTextGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        node.addContained(new TextElement());
        try {
            Helper.validateGraphNodeForFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode has bad SimpleSemanticModelElement semantic model(bad typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForFreeTextAction_FreeTextGraphNodeWithIllegalSemanticModel3() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("NonFreeText");
        node.setSemanticModel(ssme);
        node.addContained(new TextElement());
        try {
            Helper.validateGraphNodeForFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode has no TextElement,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForFreeTextAction_FreeTextGraphNodeWithoutTextElement() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        node.setSemanticModel(ssme);
        try {
            Helper.validateGraphNodeForFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for accuracy with valid freeTextGraphNode.
     * </p>
     */
    public void testValidateGraphNodeForFreeTextAction_Valid() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        node.setSemanticModel(ssme);
        node.addContained(new TextElement());
        Helper.validateGraphNodeForFreeTextAction(node);
    }

    /**
     * <p>
     * Test method <code>validateGraphEdgeForPolylineAction(GraphEdge polylineGraphEdge)</code>
     * for failure with null polylineGraphEdge, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphEdgeForPolylineAction_NullPolylineGraphEdge() {
        try {
            Helper.validateGraphEdgeForPolylineAction(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphEdgeForPolylineAction(GraphEdge polylineGraphEdge)</code>
     * for failure with polylineGraphEdge has no Polyline, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphEdgeForPolylineAction_IllegalPolylineGraphEdge() {
        try {
            Helper.validateGraphEdgeForPolylineAction(new GraphEdge());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphEdgeForPolylineAction(GraphEdge polylineGraphEdge)</code>
     * for accuracy with valid polylineGraphEdge.
     * </p>
     */
    public void testValidateGraphEdgeForPolylineAction_Valid() {
        GraphEdge edge = new GraphEdge();
        edge.addContained(new Polyline());
        Helper.validateGraphEdgeForPolylineAction(edge);
    }

}
