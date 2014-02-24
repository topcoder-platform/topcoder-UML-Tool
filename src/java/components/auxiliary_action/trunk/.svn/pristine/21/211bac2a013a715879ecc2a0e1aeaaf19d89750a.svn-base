/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;

/**
 * <p>
 * Unit tests on class <code>CopyCommentRelationshipGraphEdgeAction</code>.
 * </p>
 *
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CopyCommentRelationshipGraphEdgeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CopyCommentRelationshipGraphEdgeAction</code> used in this test.
     * </p>
     */
    private CopyCommentRelationshipGraphEdgeAction action;
    /**
     * <p>
     * Comment graph edge.
     * </p>
     */
    private GraphEdge commentGraphEdge;
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
        this.clipboard = new Clipboard("CopyCommentRelationshipGraphEdgeActionTest");
        this.action = new CopyCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.clipboard);
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
     * Test constructor <code>CopyCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for failure with null commentGraphEdge,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphEdge() {
        try {
            new CopyCommentRelationshipGraphEdgeAction(null, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CopyCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for failure with invalid commentGraphEdge without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new CopyCommentRelationshipGraphEdgeAction(new GraphEdge(), this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CopyCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for failure with invalid commentGraphEdge with illegal semantic model
     * (non-SimpleSemanticModelElement),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(new Uml1SemanticModelBridge());
        try {
            new CopyCommentRelationshipGraphEdgeAction(edge, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CopyCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
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
            new CopyCommentRelationshipGraphEdgeAction(edge, this.clipboard);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CopyCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new CopyCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.clipboard));
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
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof GraphEdge);
        UnitTestHelper.assertEquals(this.commentGraphEdge, (GraphEdge) obj, "Failed to execute the action!");
    }
}
