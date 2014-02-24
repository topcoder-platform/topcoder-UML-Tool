/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CopyCommentRelationshipGraphEdgeActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentRelationshipGraphEdgeAction;
import junit.framework.TestCase;

/**
 * <p>
 * This is a failure tests for <code>CopyCommentRelationshipGraphEdgeAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CopyCommentRelationshipGraphEdgeActionFailureTest extends TestCase {

    /**Comment GraphEdge that is used for testing.*/
    private GraphEdge commentGraphEdge;

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        commentGraphEdge = new GraphEdge();
    }

    /**
     * <p>
     * Tests constructor CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, clipboard) if
     * commentGraphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentGraphEdgeNull() {
        try {
            new CopyCommentRelationshipGraphEdgeAction(null, null);
            fail("IllegalArgumentException is expected because commentGraphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, clipboard) if
     * commentGraphEdge contains a semanticModel attribute, but not SimpleSemanticModelElement object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentContainInvalidSemanticModelAttribute() {
        try {
            commentGraphEdge.setSemanticModel(new Uml1SemanticModelBridge());
            new CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
            fail("IllegalArgumentException is expected because commentGraphEdge contains invalid semanticModel"
                    + "attribute (non-SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, clipboard) if
     * commentGraphEdge contains a semanticModel attribute (SimpleSemanticModelElement object), but
     * its typeInfo attribute is not equal to "CommentLink" - type info is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeHasInvalidTypeInfoNull() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            commentGraphEdge.setSemanticModel(semanticModelBridge);
            new CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, clipboard) if
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
            new CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is not equal "
                    + "to 'CommentLink'.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}