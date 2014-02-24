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
 * Unit tests on class <code>PasteCommentRelationshipGraphEdgeAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class PasteCommentRelationshipGraphEdgeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>PasteCommentRelationshipGraphEdgeAction</code> used in this test.
     * </p>
     */
    private PasteCommentRelationshipGraphEdgeAction action;
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
        this.action = new PasteCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.diagram);
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
     * Test constructor <code>PasteCommentRelationshipGraphEdgeAction(Object content, GraphNode diagram)</code>
     * for failure with null content,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphEdge() {
        try {
            new PasteCommentRelationshipGraphEdgeAction(null, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentRelationshipGraphEdgeAction(Object content, GraphNode diagram)</code>
     * for failure with non-GraphEdge content,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NonGraphEdgeContent() {
        try {
            new PasteCommentRelationshipGraphEdgeAction("String", this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentRelationshipGraphEdgeAction(Object content, GraphNode diagram)</code>
     * for failure with invalid commentGraphEdge without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new PasteCommentRelationshipGraphEdgeAction(new GraphEdge(), this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentRelationshipGraphEdgeAction(Object content, GraphNode diagram)</code>
     * for failure with invalid commentGraphEdge with illegal semantic model
     * (non-SimpleSemanticModelElement),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(new Uml1SemanticModelBridge());
        try {
            new PasteCommentRelationshipGraphEdgeAction(edge, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentRelationshipGraphEdgeAction(Object content, GraphNode diagram)</code>
     * for failure with invalid commentGraphEdge with illegal semantic model
     * (illegal typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphEdge edge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        edge.setSemanticModel(ssme);
        try {
            new PasteCommentRelationshipGraphEdgeAction(edge, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentRelationshipGraphEdgeAction(Object content, GraphNode diagram)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new PasteCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.diagram));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Paste Comment Relationship GraphEdge", this.action.getPresentationName());
    }
}
