/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AddCommentRelationshipGraphEdgeActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.modelmanager.UMLModelManager;
import junit.framework.TestCase;

/**
 * <p>
 * This is a failure tests for <code>AddCommentRelationshipGraphEdgeAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AddCommentRelationshipGraphEdgeActionFailureTest extends TestCase {

    /**Comment GraphEdge that is used for testing.*/
    private GraphEdge commentGraphEdge;

    /**Diagram GraphNode that is used for testing.*/
    private GraphNode diagram;

    /**UMLModelManager instance that is used for testing.*/
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        Helper.clearNamespace();
        Helper.initNamespace();

        commentGraphEdge = new GraphEdge();
        diagram = new GraphNode();
        umlModelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Tear down.
     * </p>
     *
     * @throws Exception exception
     */
    public void tearDown() throws Exception {
        Helper.clearNamespace();
    }

    /**
     * <p>
     * Tests constructor AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager) if
     * commentGraphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentGraphEdgeNull() {
        try {
            new AddCommentRelationshipGraphEdgeAction(null, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because commentGraphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager) if
     * diagram is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDiagramNull() {
        try {
            new AddCommentRelationshipGraphEdgeAction(commentGraphEdge, null, umlModelManager);
            fail("IllegalArgumentException is expected because diagram cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager) if
     * umlModelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfModelManagerNull() {
        try {
            new AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, null);
            fail("IllegalArgumentException is expected because umlModelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager) if
     * commentGraphEdge doesn't contain a semanticModel attribute (SimpleSemanticModelElement object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNotContainSemanticModelAttribute() {
        try {
            new AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because commentGraphEdge doesn't contain a semanticModel"
                    + "attribute (SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager) if
     * commentGraphEdge contains a semanticModel attribute, but not SimpleSemanticModelElement object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentContainInvalidSemanticModelAttribute() {
        try {
            commentGraphEdge.setSemanticModel(new Uml1SemanticModelBridge());
            new AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because commentGraphEdge contains invalid semanticModel"
                    + "attribute (non-SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager) if
     * commentGraphEdge contains a semanticModel attribute (SimpleSemanticModelElement object), but
     * its typeInfo attribute is not equal to "CommentLink" - type info is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeHasInvalidTypeInfoNull() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            commentGraphEdge.setSemanticModel(semanticModelBridge);
            new AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager) if
     * commentGraphEdge contains a semanticModel attribute (SimpleSemanticModelElement object), but
     * its typeInfo attribute is not equal to "CommentLink".
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeHasInvalidTypeInfo() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("invalid_type_info");
            commentGraphEdge.setSemanticModel(semanticModelBridge);
            new AddCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is not equal "
                    + "to 'CommentLink'.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}