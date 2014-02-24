/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;

/**
 * <p>
 * Unit tests on class <code>RemoveCommentRelationshipGraphEdgeAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class RemoveCommentRelationshipGraphEdgeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>RemoveCommentRelationshipGraphEdgeAction</code> used in this test.
     * </p>
     */
    private RemoveCommentRelationshipGraphEdgeAction action;
    /**
     * <p>
     * Comment graph edge.
     * </p>
     */
    private GraphEdge commentGraphEdge;
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
        this.commentGraphEdge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("CommentLink");
        this.commentGraphEdge.setSemanticModel(ssme);
        this.diagram = new Diagram();
        this.diagram.addContained(this.commentGraphEdge);
        this.commentGraphEdge.setContainer(this.diagram);
        this.action = new RemoveCommentRelationshipGraphEdgeAction(this.commentGraphEdge);
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
     * Test constructor <code>RemoveCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge)</code>
     * for failure with null commentGraphEdge,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphEdge() {
        try {
            new RemoveCommentRelationshipGraphEdgeAction(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge)</code>
     * for failure with commentGraphEdge without parent,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphEdgeWithoutParent() {
        try {
            new RemoveCommentRelationshipGraphEdgeAction(new GraphEdge());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge)</code>
     * for failure with invalid commentGraphEdge without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new RemoveCommentRelationshipGraphEdgeAction(new GraphEdge());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge)</code>
     * for failure with invalid commentGraphEdge with illegal semantic model
     * (non-SimpleSemanticModelElement),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(new Uml1SemanticModelBridge());
        try {
            new RemoveCommentRelationshipGraphEdgeAction(edge);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge)</code>
     * for failure with invalid commentGraphEdge with illegal semantic model
     * (illegal typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphEdge edge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("CommentLink");
        edge.setSemanticModel(ssme);
        try {
            new RemoveCommentRelationshipGraphEdgeAction(edge);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new RemoveCommentRelationshipGraphEdgeAction(this.commentGraphEdge));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Remove Comment Relationship GraphEdge", this.action.getPresentationName());
    }
}
