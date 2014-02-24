/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;

/**
 * <p>
 * Unit tests on class <code>RemoveFreeTextAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class RemoveFreeTextActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>RemoveFreeTextAction</code> used in this test.
     * </p>
     */
    private RemoveFreeTextAction action;

    /**
     * <p>
     * Free text graph node..
     * </p>
     */
    private GraphNode freeTextGraphNode;
    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.freeTextGraphNode = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        this.freeTextGraphNode.setSemanticModel(ssme);
        this.freeTextGraphNode.addContained(new TextElement());
        this.freeTextGraphNode.setContainer(new GraphNode());
        this.action = new RemoveFreeTextAction(this.freeTextGraphNode);
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
     * Test constructor <code>RemoveFreeTextAction(GraphNode freeTextGraphNode</code>
     * for failure with null freeTextGraphNode,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullFreeTextGraphNode() {
        try {
            new RemoveFreeTextAction(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode which has no semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithoutSemanticModel() {
        GraphNode node = new GraphNode();
        node.addContained(new TextElement());
        node.setContainer(new GraphNode());
        try {
            new RemoveFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode which has
     * non-SimpleSemanticModelElement semantic model, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new Uml1SemanticModelBridge());
        node.addContained(new TextElement());
        node.setContainer(new GraphNode());
        try {
            new RemoveFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode has bad
     * SimpleSemanticModelElement semantic model(no typeInfo), <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        node.addContained(new TextElement());
        node.setContainer(new GraphNode());
        try {
            new RemoveFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode has bad
     * SimpleSemanticModelElement semantic model(bad typeInfo), <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel3() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("NonFreeText");
        node.setSemanticModel(ssme);
        node.addContained(new TextElement());
        node.setContainer(new GraphNode());
        try {
            new RemoveFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode has no TextElement,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithoutTextElement() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        node.setSemanticModel(ssme);
        node.setContainer(new GraphNode());
        try {
            new RemoveFreeTextAction(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveFreeTextAction(GraphNode freeTextGraphNode)</code>
     * for failure with freeTextGraphNode has no container,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithoutContainer() {
        this.freeTextGraphNode.setContainer(null);
        try {
            new RemoveFreeTextAction(this.freeTextGraphNode);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>RemoveFreeTextAction(GraphNode freeTextGraphNode)</code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
            new RemoveFreeTextAction(this.freeTextGraphNode));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Remove Free Text", this.action.getPresentationName());
    }
}
