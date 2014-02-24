/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;

/**
 * <p>
 * Unit tests on class <code>PasteFreeTextAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class PasteFreeTextActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>PasteFreeTextAction</code> used in this test.
     * </p>
     */
    private PasteFreeTextAction action;

    /**
     * <p>
     * Free text graph node.
     * </p>
     */
    private GraphNode freeTextGraphNode;
    /**
     * <p>
     * Diagram.
     * </p>
     */
    private GraphNode diagram;
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
        this.diagram = new Diagram();
        this.action = new PasteFreeTextAction(this.freeTextGraphNode, this.diagram);
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
     * Test constructor <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for failure with null freeTextGraphNode, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullFreeTextGraphNode() {
        try {
            new PasteFreeTextAction(null, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for failure with non-GraphNode content, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NonGraphNodeContent() {
        try {
            new PasteFreeTextAction("String", this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for failure with null freeTextGraphNode which has no semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithoutSemanticModel() {
        GraphNode node = new GraphNode();
        node.addContained(new TextElement());
        try {
            new PasteFreeTextAction(node, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for failure with freeTextGraphNode has non-SimpleSemanticModelElement semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new Uml1SemanticModelBridge());
        node.addContained(new TextElement());
        try {
            new PasteFreeTextAction(node, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for failure with freeTextGraphNode has bad SimpleSemanticModelElement semantic model(no typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        node.addContained(new TextElement());
        try {
            new PasteFreeTextAction(node, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for failure with freeTextGraphNode has bad SimpleSemanticModelElement semantic model(bad typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel3() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("NonFreeText");
        node.setSemanticModel(ssme);
        node.addContained(new TextElement());
        try {
            new PasteFreeTextAction(node, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for failure with freeTextGraphNode has no TextElement,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithoutTextElement() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        node.setSemanticModel(ssme);
        try {
            new PasteFreeTextAction(node, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for failure with null diagram,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullDiagram() {
        try {
            new PasteFreeTextAction(this.freeTextGraphNode, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>PasteFreeTextAction(Object content, GraphNode diagram)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new PasteFreeTextAction(this.freeTextGraphNode, this.diagram));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Paste Free Text", this.action.getPresentationName());
    }
}
