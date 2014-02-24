/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Unit tests on class <code>Helper</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class HelperTest extends TestCase {
    /**
     * <p>
     * Test method <code>validateGraphNodeForComment(GraphNode commentGraphNode)</code>
     * for failure with null commentGraphNode, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testValidateGraphNodeForComment_NullCommentGraphNode() {
        try {
            Helper.validateGraphNodeForComment(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>validateGraphNodeForComment(GraphNode commentGraphNode)</code>
     * for failure with invalid commentGraphNode without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForComment_CommentGraphNodeWithoutSemanticModel() {
        try {
            Helper.validateGraphNodeForComment(new GraphNode());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphNodeForComment(GraphNode commentGraphNode)</code>
     * for failure with invalid commentGraphNode that contains
     * illegal semantic model(non-Uml1SemanticModelBridge),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForComment_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        try {
            Helper.validateGraphNodeForComment(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphNodeForComment(GraphNode commentGraphNode)</code>
     * for failure with invalid commentGraphNode that contains
     * illegal semantic model(without Comment element),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphNodeForComment_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        node.setSemanticModel(usmb);
        try {
            Helper.validateGraphNodeForComment(node);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphNodeForComment(GraphNode commentGraphNode)</code>
     * for accuracy.
     * </p>
     */
    public void testValidateGraphNodeForComment_Valid() {
        GraphNode node = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        node.setSemanticModel(usmb);
        Helper.validateGraphNodeForComment(node);
    }

    /**
     * <p>
     * Test method <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with null commentGraphEdge,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphEdgeForCommentRelationship_NullCommentGraphEdge() {
        try {
            Helper.validateGraphEdgeForCommentRelationship(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with invalid commentGraphEdge without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphEdgeForCommentRelationship_CommentGraphNodeWithoutSemanticModel() {
        try {
            Helper.validateGraphEdgeForCommentRelationship(new GraphEdge());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphEdgeForCommentRelationship(GraphEdge commentGraphEdge)</code>
     * for failure with invalid commentGraphEdge with illegal semantic model
     * (non-SimpleSemanticModelElement),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphEdgeForCommentRelationship_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(new Uml1SemanticModelBridge());
        try {
            Helper.validateGraphEdgeForCommentRelationship(edge);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphEdgeForCommentRelationship(GraphEdge commentGraphEdge)</code>
     * for failure with invalid commentGraphEdge with illegal semantic model
     * (illegal typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateGraphEdgeForCommentRelationship_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphEdge edge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        edge.setSemanticModel(ssme);
        try {
            Helper.validateGraphEdgeForCommentRelationship(edge);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>validateGraphEdgeForCommentRelationship(GraphEdge commentGraphEdge)</code> for accuracy.
     * </p>
     */
    public void testValidateGraphEdgeForCommentRelationship_Valid() {
        GraphEdge edge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("CommentLink");
        edge.setSemanticModel(ssme);
        Helper.validateGraphEdgeForCommentRelationship(edge);
    }
}
