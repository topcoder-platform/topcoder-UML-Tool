/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CutCommentRelationshipGraphEdgeActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.actions.auxiliary.failuretests.impls.CutCommentRelationshipGraphEdgeActionImpl;
import junit.framework.TestCase;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This is a failure tests for <code>CutCommentRelationshipGraphEdgeAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CutCommentRelationshipGraphEdgeActionFailureTest extends TestCase {

    /**Comment GraphEdge that is used for testing.*/
    private GraphEdge commentGraphEdge;

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
        commentGraphEdge.setContainer(new GraphElement() {});
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
     * Tests constructor CutCommentRelationshipGraphEdgeAction(commentGraphEdge, clipboard) if
     * commentGraphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentGraphEdgeNull() {
        try {
            new CutCommentRelationshipGraphEdgeAction(null, null);
            fail("IllegalArgumentException is expected because commentGraphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutCommentRelationshipGraphEdgeAction(commentGraphEdge, clipboard) if
     * commentGraphEdge contains a semanticModel attribute, but not SimpleSemanticModelElement object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentContainInvalidSemanticModelAttribute() {
        try {
            commentGraphEdge.setSemanticModel(new Uml1SemanticModelBridge());
            new CutCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
            fail("IllegalArgumentException is expected because commentGraphEdge contains invalid semanticModel"
                    + "attribute (non-SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutCommentRelationshipGraphEdgeAction(commentGraphEdge, clipboard) if
     * commentGraphEdge contains a semanticModel attribute (SimpleSemanticModelElement object), but
     * its typeInfo attribute is not equal to "CommentLink" - type info is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeHasInvalidTypeInfoNull() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            commentGraphEdge.setSemanticModel(semanticModelBridge);
            new CutCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutCommentRelationshipGraphEdgeAction(commentGraphEdge, clipboard) if
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
            new CutCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is not equal "
                    + "to 'CommentLink'.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method copyToClipboard(node, clipboard) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCopyToClipboardIfNodeNull() throws Exception {
        SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
        semanticModelBridge.setTypeInfo("CommentLink");
        commentGraphEdge.setSemanticModel(semanticModelBridge);
        CutCommentRelationshipGraphEdgeActionImpl action =
                new CutCommentRelationshipGraphEdgeActionImpl(commentGraphEdge, null);
        try {
            action.copyToClipboard(null, null);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}