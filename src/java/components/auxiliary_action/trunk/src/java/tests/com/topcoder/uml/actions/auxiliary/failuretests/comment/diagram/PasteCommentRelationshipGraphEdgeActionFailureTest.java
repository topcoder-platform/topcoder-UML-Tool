/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * PasteCommentRelationshipGraphEdgeActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import junit.framework.TestCase;

/**
 * <p>
 * This is a failure tests for <code>PasteCommentRelationshipGraphEdgeAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class PasteCommentRelationshipGraphEdgeActionFailureTest extends TestCase {

    /**Content object that is used for testing.*/
    private Object commentGraphEdge;

    /**Diagram GraphNode that is used for testing.*/
    private GraphNode diagram;

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
     * Tests constructor PasteCommentRelationshipGraphEdgeAction(content, diagram) if content is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentGraphEdgeNull() {
        try {
            new PasteCommentRelationshipGraphEdgeAction(null, diagram);
            fail("IllegalArgumentException is expected because content cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentRelationshipGraphEdgeAction(content, diagram) if diagram is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDiagramNull() {
        try {
            new PasteCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
            fail("IllegalArgumentException is expected because diagram cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentRelationshipGraphEdgeAction(content, diagram) if content is not
     * instance of GraphEdge.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfModelManagerNull() {
        try {
            new PasteCommentRelationshipGraphEdgeAction(new Object(), diagram);
            fail("IllegalArgumentException is expected because content is not instance of GraphEdge.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentRelationshipGraphEdgeAction(content, diagram) if
     * content graph edge doesn't contain a semanticModel attribute (SimpleSemanticModelElement object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNotContainSemanticModelAttribute() {
        try {
            new PasteCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram);
            fail("IllegalArgumentException is expected because content graph edge doesn't contain a semanticModel "
                    + "attribute (SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentRelationshipGraphEdgeAction(content, diagram) if
     * content graph edge contains a semanticModel attribute, but not SimpleSemanticModelElement object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentContainInvalidSemanticModelAttribute() {
        try {
            ((GraphEdge) commentGraphEdge).setSemanticModel(new Uml1SemanticModelBridge());
            new PasteCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram);
            fail("IllegalArgumentException is expected because content graph edge contains invalid semanticModel "
                    + "attribute (non-SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentRelationshipGraphEdgeAction(content, diagram) if
     * content graph edge contains a semanticModel attribute (SimpleSemanticModelElement object), but
     * its typeInfo attribute is not equal to "CommentLink" - type info is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeHasInvalidTypeInfoNull() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            ((GraphEdge) commentGraphEdge).setSemanticModel(semanticModelBridge);
            new PasteCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentRelationshipGraphEdgeAction(content, diagram) if
     * content graph edge contains a semanticModel attribute (SimpleSemanticModelElement object), but
     * its typeInfo attribute is not equal to "CommentLink".
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeHasInvalidTypeInfo() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("invalid_type_info");
            ((GraphEdge) commentGraphEdge).setSemanticModel(semanticModelBridge);
            new PasteCommentRelationshipGraphEdgeAction(commentGraphEdge, diagram);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is not equal "
                    + "to 'CommentLink'.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}