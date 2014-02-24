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
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Unit tests on class <code>AddCommentGraphNodeAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AddCommentGraphNodeActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>AddCommentGraphNodeAction</code> used in this test.
     * </p>
     */
    private AddCommentGraphNodeAction action;
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
        this.commentGraphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        this.commentGraphNode.setSemanticModel(usmb);
        this.diagram = new Diagram();
        this.manager = new UMLModelManager();
        this.manager.setProjectConfigurationManager(new ProjectConfigurationManager(this.manager));
        this.action = new AddCommentGraphNodeAction(this.commentGraphNode, this.diagram, this.manager);
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
     * Test constructor <code>AddCommentGraphNodeAction(GraphNode commentGraphNode, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with null commentGraphNode,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullCommentGraphNode() {
        try {
            new AddCommentGraphNodeAction(null, this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentGraphNodeAction(GraphNode commentGraphNode, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with null diagram,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullDiagram() {
        try {
            new AddCommentGraphNodeAction(this.commentGraphNode, null, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentGraphNodeAction(GraphNode commentGraphNode, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with null modelManager,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullModelManager() {
        try {
            new AddCommentGraphNodeAction(this.commentGraphNode, this.diagram, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentGraphNodeAction(GraphNode commentGraphNode, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with invalid commentGraphNode without semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithoutSemanticModel() {
        try {
            new AddCommentGraphNodeAction(new GraphNode(), this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentGraphNodeAction(GraphNode commentGraphNode, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with invalid commentGraphNode that contains
     * illegal semantic model(non-Uml1SemanticModelBridge),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        try {
            new AddCommentGraphNodeAction(node, this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentGraphNodeAction(GraphNode commentGraphNode, GraphNode diagram,
     * UMLModelManager modelManager)</code> for failure with invalid commentGraphNode that contains
     * illegal semantic model(without Comment element),
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        node.setSemanticModel(usmb);
        try {
            new AddCommentGraphNodeAction(node, this.diagram, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentGraphNodeAction(GraphNode commentGraphNode, GraphNode diagram,
     * UMLModelManager modelManager)</code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new AddCommentGraphNodeAction(this.commentGraphNode, this.diagram, this.manager));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Add Comment GraphNode", this.action.getPresentationName());
    }
}
