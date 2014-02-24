/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>CutFreeTextAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CutFreeTextActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CutFreeTextAction</code> used in this test.
     * </p>
     */
    private CutFreeTextAction action;

    /**
     * <p>
     * Free text graph node.
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
        this.action = new CutFreeTextAction(this.freeTextGraphNode,
                Toolkit.getDefaultToolkit().getSystemClipboard());
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
     * Test constructor <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with null freeTextGraphNode, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullFreeTextGraphNode() {
        try {
            new CutFreeTextAction(null, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with null freeTextGraphNode which has no semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithoutSemanticModel() {
        GraphNode node = new GraphNode();
        node.addContained(new TextElement());
        node.setContainer(new GraphNode());
        try {
            new CutFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with freeTextGraphNode has non-SimpleSemanticModelElement semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new Uml1SemanticModelBridge());
        node.addContained(new TextElement());
        node.setContainer(new GraphNode());
        try {
            new CutFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with freeTextGraphNode has bad SimpleSemanticModelElement semantic model(no typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        node.addContained(new TextElement());
        node.setContainer(new GraphNode());
        try {
            new CutFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
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
        node.setContainer(new GraphNode());
        try {
            new CutFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
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
            new CutFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with freeTextGraphNode has no container,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithoutContainer() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        node.setSemanticModel(ssme);
        try {
            new CutFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for accuracy with valid freeTextGraphNode.
     * </p>
     */
    public void testCtor_Accuracy1() {
        assertNotNull("Failed to create the action!",
                new CutFreeTextAction(this.freeTextGraphNode, null));
    }
    /**
     * <p>
     * Test method <code>CutFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for accuracy with valid freeTextGraphNode.
     * </p>
     */
    public void testCtor_Accuracy2() {
        assertNotNull("Failed to create the action!",
                new CutFreeTextAction(this.freeTextGraphNode, Toolkit.getDefaultToolkit().getSystemClipboard()));
    }

    /**
     * <p>
     * Test method <code>copyToClipboard(GraphElement node, Clipboard clipboard)</code>
     * for failure with null node, <code>IllegalArgumentException</code>.
     * </p>
     * @throws ActionExecutionException to JUnit
     * @throws AuxiliaryElementCloneException to JUnit
     */
    public void testCopyToClipboard_NullNode() throws AuxiliaryElementCloneException, ActionExecutionException {
        try {
            this.action.copyToClipboard(null, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>copyToClipboard(GraphElement node, Clipboard clipboard)</code>
     * for failure with null node, <code>IllegalArgumentException</code>.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCopyToClipboard_Accuracy() throws Exception {
        Clipboard clipboard = new Clipboard("Test");
        this.action.copyToClipboard(this.freeTextGraphNode, clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.FREE_TEXT);
        assertNotNull("Failed to copy the node!", obj);
        assertTrue("Failed to copy the node!", obj instanceof GraphNode);
        UnitTestHelper.assertEquals(this.freeTextGraphNode, (GraphNode) obj, "Failed to copy!");
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Cut Free Text", this.action.getPresentationName());
    }
}
