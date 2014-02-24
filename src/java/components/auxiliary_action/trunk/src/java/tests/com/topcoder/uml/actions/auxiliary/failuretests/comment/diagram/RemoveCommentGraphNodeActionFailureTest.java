/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * RemoveCommentGraphNodeActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.Element;
import junit.framework.TestCase;

/**
 * <p>
 * This is a failure tests for <code>RemoveCommentGraphNodeAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class RemoveCommentGraphNodeActionFailureTest extends TestCase {

    /**Comment GraphNode that is used for testing.*/
    private GraphNode commentGraphNode;

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

        commentGraphNode = new GraphNode();
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
     * Tests constructor RemoveCommentGraphNodeAction(commentGraphNode) if commentGraphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentGraphNodeNull() {
        try {
            new RemoveCommentGraphNodeAction(null);
            fail("IllegalArgumentException is expected because commentGraphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor RemoveCommentGraphNodeAction(commentGraphNode) if commentGraphNode doesn't
     * contain a semanticModel attribute (Uml1SemanticModelBridge object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNotContainSemanticModelAttribute() {
        try {
            new RemoveCommentGraphNodeAction(commentGraphNode);
            fail("IllegalArgumentException is expected because commentGraphNode doesn't contain a semanticModel"
                    + "attribute (Uml1SemanticModelBridge object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor RemoveCommentGraphNodeAction(commentGraphNode) if commentGraphNode contains a
     * semanticModel attribute, but not Uml1SemanticModelBridge object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentContainInvalidSemanticModelAttribute() {
        try {
            commentGraphNode.setSemanticModel(new SimpleSemanticModelElement());
            new RemoveCommentGraphNodeAction(commentGraphNode);
            fail("IllegalArgumentException is expected because commentGraphNode contains invalid semanticModel"
                    + "attribute (non-Uml1SemanticModelBridge object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor RemoveCommentGraphNodeAction(commentGraphNode) if commentGraphNode contains a
     * semanticModel attribute (Uml1SemanticModelBridge object), but it does not contain a Comment object
     * as its element attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeNonCommentType() {
        try {
            Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
            semanticModelBridge.setElement(new Element() {});
            commentGraphNode.setSemanticModel(semanticModelBridge);
            new RemoveCommentGraphNodeAction(commentGraphNode);
            fail("IllegalArgumentException is expected because semanticModel's element attribute is "
                    + " non-Comment.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}