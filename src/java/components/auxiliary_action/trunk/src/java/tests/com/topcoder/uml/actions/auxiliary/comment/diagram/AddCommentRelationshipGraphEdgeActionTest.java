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
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Unit tests on class <code>AddCommentRelationshipGraphEdgeAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AddCommentRelationshipGraphEdgeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>AddCommentRelationshipGraphEdgeAction</code> used in this test.
     * </p>
     */
    private AddCommentRelationshipGraphEdgeAction action;
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
     * Instance of <code>UMLModelManager</code> used in this test.
     */
    private UMLModelManager manager;

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
        this.manager = new UMLModelManager();
        this.manager.setProjectConfigurationManager(new ProjectConfigurationManager(this.manager));
        this.action = new AddCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.diagram, this.manager);
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
     * Test constructor <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with null commentGraphEdge,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphEdge() {
        try {
            new AddCommentRelationshipGraphEdgeAction(null, this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with null diagram,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullDiagram() {
        try {
            new AddCommentRelationshipGraphEdgeAction(this.commentGraphEdge, null, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with null commentGraphEdge,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullModelManager() {
        try {
            new AddCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.diagram, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with invalid commentGraphEdge without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new AddCommentRelationshipGraphEdgeAction(new GraphEdge(), this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with invalid commentGraphEdge with illegal semantic model
     * (non-SimpleSemanticModelElement),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(new Uml1SemanticModelBridge());
        try {
            new AddCommentRelationshipGraphEdgeAction(edge, this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with invalid commentGraphEdge with illegal semantic model
     * (illegal typeInfo),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphEdge edge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        edge.setSemanticModel(ssme);
        try {
            new AddCommentRelationshipGraphEdgeAction(edge, this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
     * UMLModelManager modelManager)</code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new AddCommentRelationshipGraphEdgeAction(this.commentGraphEdge, this.diagram, this.manager));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Add Comment Relationship GraphEdge", this.action.getPresentationName());
    }
}
