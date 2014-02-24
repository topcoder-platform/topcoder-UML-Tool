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
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;

/**
 * <p>
 * Unit tests on class <code>CopyFreeTextAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CopyFreeTextActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CopyFreeTextAction</code> used in this test.
     * </p>
     */
    private CopyFreeTextAction action;

    /**
     * <p>
     * Free text graph node.
     * </p>
     */
    private GraphNode freeTextGraphNode;
    /**
     * <p>
     * Clipboard.
     * </p>
     */
    private Clipboard clipboard;
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
        this.clipboard = new Clipboard("CopyFreeTextActionTest");
        this.action = new CopyFreeTextAction(this.freeTextGraphNode,
                this.clipboard);
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
     * Test constructor <code>CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with null freeTextGraphNode, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullFreeTextGraphNode() {
        try {
            new CopyFreeTextAction(null, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with null freeTextGraphNode which has no semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithoutSemanticModel() {
        GraphNode node = new GraphNode();
        node.addContained(new TextElement());
        try {
            new CopyFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with freeTextGraphNode has non-SimpleSemanticModelElement semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new Uml1SemanticModelBridge());
        node.addContained(new TextElement());
        try {
            new CopyFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for failure with freeTextGraphNode has bad SimpleSemanticModelElement semantic model(no typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_FreeTextGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        node.addContained(new TextElement());
        try {
            new CopyFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
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
            new CopyFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
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
            new CopyFreeTextAction(node, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for accuracy with valid freeTextGraphNode.
     * </p>
     */
    public void testCtor_Accuracy1() {
        assertNotNull("Failed to create the action!",
                new CopyFreeTextAction(this.freeTextGraphNode, null));
    }
    /**
     * <p>
     * Test method <code>CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard)</code>
     * for accuracy with valid freeTextGraphNode.
     * </p>
     */
    public void testCtor_Accuracy2() {
        assertNotNull("Failed to create the action!",
                new CopyFreeTextAction(this.freeTextGraphNode, Toolkit.getDefaultToolkit().getSystemClipboard()));
    }
    /**
     * <p>
     * Test method <code>execute()</code> for accuracy.
     * </p>
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        // execute the action
        this.action.execute();
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.FREE_TEXT);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof GraphNode);
        UnitTestHelper.assertEquals(this.freeTextGraphNode, (GraphNode) obj, "Failed to copy!");
    }

}
