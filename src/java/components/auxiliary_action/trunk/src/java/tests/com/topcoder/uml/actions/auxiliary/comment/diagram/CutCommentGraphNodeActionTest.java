/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>CutCommentGraphNodeAction</code>.
 * </p>
 *
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CutCommentGraphNodeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CutCommentGraphNodeAction</code> used in this test.
     * </p>
     */
    private CutCommentGraphNodeAction action;

    /**
     * <p>
     * Comment graph node.
     * </p>
     */
    private GraphNode commentGraphNode;

    /**
     * <p>
     * The parent diagram.
     * </p>
     */
    private Diagram parent;

    /**
     * <p>
     * Instance of <code>Clipboard</code> used in this test.
     * </p>
     */
    private Clipboard clipboard;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.commentGraphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        this.commentGraphNode.setSemanticModel(usmb);
        this.parent = new Diagram();
        this.parent.addContained(this.commentGraphNode);
        this.commentGraphNode.setContainer(this.parent);
        this.clipboard = new Clipboard("CutCommentGraphNodeActionTest");
        this.action = new CutCommentGraphNodeAction(this.commentGraphNode, this.clipboard);
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
     * Test constructor
     * <code>CutCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for failure with null commentGraphNode,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphNode() {
        try {
            new CutCommentGraphNodeAction(null, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor
     * <code>CutCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for failure with commentGraphNode without parent,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutParent() {
        this.commentGraphNode.setContainer(null);
        try {
            new CutCommentGraphNodeAction(this.commentGraphNode, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor
     * <code>CutCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for failure with invalid commentGraphNode without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new CutCommentGraphNodeAction(new GraphNode(), this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor
     * <code>CutCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for failure with invalid commentGraphNode that contains illegal semantic
     * model(non-Uml1SemanticModelBridge), <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        try {
            new CutCommentGraphNodeAction(node, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor
     * <code>CutCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for failure with invalid commentGraphNode that contains illegal semantic
     * model(without Comment element), <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        node.setSemanticModel(usmb);
        try {
            new CutCommentGraphNodeAction(node, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor
     * <code>CutCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!", new CutCommentGraphNodeAction(this.commentGraphNode,
                this.clipboard));
    }

    /**
     * <p>
     * Test method <code>copyToClipboard(GraphElement node, Clipboard clipboard)</code> for failure with
     * null node, <code>IllegalArgumentException</code> is expected.
     * </p>
     * @throws ActionExecutionException to JUnit
     * @throws AuxiliaryElementCloneException to JUnit
     */
    public void testCopyToClipboard_NullNode() throws AuxiliaryElementCloneException, ActionExecutionException {
        try {
            this.action.copyToClipboard(null, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>copyToClipboard(GraphElement node, Clipboard clipboard)</code> for failure with
     * null node, <code>IllegalArgumentException</code> is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCopyToClipboard_Accuracy() throws Exception {
        this.action.copyToClipboard(this.commentGraphNode, this.clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE);
        assertNotNull("Failed to copy!", obj);
        assertTrue("Failed to copy!", obj instanceof GraphNode);
        UnitTestHelper.assertEquals(this.commentGraphNode, (GraphNode) obj, "Failed to execute the action!");
    }

}
