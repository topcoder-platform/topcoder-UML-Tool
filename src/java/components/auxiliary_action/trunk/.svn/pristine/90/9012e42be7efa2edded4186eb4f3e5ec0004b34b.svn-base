/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Unit tests on class <code>CopyCommentGraphNodeAction</code>.
 * </p>
 *
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CopyCommentGraphNodeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CopyCommentGraphNodeAction</code> used in this test.
     * </p>
     */
    private CopyCommentGraphNodeAction action;

    /**
     * <p>
     * Comment graph node.
     * </p>
     */
    private GraphNode commentGraphNode;

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
        this.clipboard = new Clipboard("CopyCommentGraphNodeActionTest");
        this.action = new CopyCommentGraphNodeAction(this.commentGraphNode, this.clipboard);
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
     * <code>CopyCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for failure with null commentGraphNode,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphNode() {
        try {
            new CopyCommentGraphNodeAction(null, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor
     * <code>CopyCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for failure with invalid commentGraphNode without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new CopyCommentGraphNodeAction(new GraphNode(), this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor
     * <code>CopyCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for failure with invalid commentGraphNode that contains illegal semantic
     * model(non-Uml1SemanticModelBridge), <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        try {
            new CopyCommentGraphNodeAction(node, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor
     * <code>CopyCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
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
            new CopyCommentGraphNodeAction(node, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor
     * <code>CopyCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!", new CopyCommentGraphNodeAction(this.commentGraphNode,
                this.clipboard));
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
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof GraphNode);
        UnitTestHelper.assertEquals(this.commentGraphNode, (GraphNode) obj, "Failed to execute the action!");
    }
}
