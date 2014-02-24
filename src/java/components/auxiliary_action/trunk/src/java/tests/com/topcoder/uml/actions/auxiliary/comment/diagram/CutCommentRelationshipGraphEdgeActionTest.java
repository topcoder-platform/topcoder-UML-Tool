/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>CutCommentRelationshipGraphEdgeAction</code>.
 * </p>
 *
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CutCommentRelationshipGraphEdgeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CutCommentRelationshipGraphEdgeAction</code> used in this test.
     * </p>
     */
    private CutCommentRelationshipGraphEdgeAction action;
    /**
     * <p>
     * Comment graph edge.
     * </p>
     */
    private GraphEdge commentGraphEdge;

    /**
     * <p>
     * Parent diagram.
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
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.commentGraphEdge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("CommentLink");
        this.commentGraphEdge.setSemanticModel(ssme);
        this.parent = new Diagram();
        this.parent.addContained(this.commentGraphEdge);
        this.commentGraphEdge.setContainer(this.parent);
        this.clipboard = new Clipboard("CutCommentRelationshipGraphEdgeActionTest");
        this.action = new CutCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.clipboard);
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
     * Test constructor <code>CutCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for failure with null commentGraphEdge,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphEdge() {
        try {
            new CutCommentRelationshipGraphEdgeAction(null, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CutCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for failure with commentGraphEdge without parent,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphEdgeWithoutParent() {
        this.commentGraphEdge.setContainer(null);
        try {
            new CutCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CutCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for failure with invalid commentGraphEdge without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new CutCommentRelationshipGraphEdgeAction(new GraphEdge(), this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CutCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for failure with invalid commentGraphEdge with illegal semantic model
     * (non-SimpleSemanticModelElement),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(new Uml1SemanticModelBridge());
        try {
            new CutCommentRelationshipGraphEdgeAction(edge, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CutCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for failure with invalid commentGraphEdge with illegal semantic model
     * (illegal typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphEdge edge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        edge.setSemanticModel(ssme);
        try {
            new CutCommentRelationshipGraphEdgeAction(edge, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CutCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new CutCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.clipboard));
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
        this.action.copyToClipboard(this.commentGraphEdge, this.clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE);
        assertNotNull("Failed to copy!", obj);
        assertTrue("Failed to copy!", obj instanceof GraphEdge);
        UnitTestHelper.assertEquals(this.commentGraphEdge, (GraphEdge) obj, "Failed to execute the action!");
    }
}
