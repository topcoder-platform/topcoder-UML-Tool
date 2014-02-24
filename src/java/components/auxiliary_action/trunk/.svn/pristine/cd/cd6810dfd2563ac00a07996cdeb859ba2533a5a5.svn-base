/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Unit tests on class <code>PasteCommentGraphNodeAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class PasteCommentGraphNodeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>PasteCommentGraphNodeAction</code> used in this test.
     * </p>
     */
    private PasteCommentGraphNodeAction action;
    /**
     * <p>
     * Comment graph node.
     * </p>
     */
    private GraphNode commentGraphNode;
    /**
     * <p>
     * Diagram node used in this test.
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
        this.commentGraphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        this.commentGraphNode.setSemanticModel(usmb);
        this.diagram = new Diagram();
        this.action = new PasteCommentGraphNodeAction(this.commentGraphNode, this.diagram);
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
     * Test constructor <code>PasteCommentGraphNodeAction(Object content, GraphNode diagram)</code>
     * for failure with null commentGraphNode,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphNode() {
        try {
            new PasteCommentGraphNodeAction(null, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentGraphNodeAction(Object content, GraphNode diagram)</code>
     * for failure with non-GraphNode commentGraphNode,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NonGraphNodeContent() {
        try {
            new PasteCommentGraphNodeAction("String", this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentGraphNodeAction(Object content, GraphNode diagram)</code>
     * for failure with invalid commentGraphNode without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new PasteCommentGraphNodeAction(new GraphNode(), this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentGraphNodeAction(Object content, GraphNode diagram)</code>
     * for failure with invalid commentGraphNode that contains
     * illegal semantic model(non-Uml1SemanticModelBridge),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        try {
            new PasteCommentGraphNodeAction(node, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentGraphNodeAction(Object content, GraphNode diagram)</code>
     * for failure with invalid commentGraphNode that contains
     * illegal semantic model(without Comment element),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        node.setSemanticModel(usmb);
        try {
            new PasteCommentGraphNodeAction(node, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentGraphNodeAction(Object content, GraphNode diagram)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new PasteCommentGraphNodeAction(this.commentGraphNode, this.diagram));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Paste Comment GraphNode", this.action.getPresentationName());
    }
}
