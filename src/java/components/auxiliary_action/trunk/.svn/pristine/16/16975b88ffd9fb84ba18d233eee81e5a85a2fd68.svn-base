/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CutCommentGraphNodeActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;
import junit.framework.TestCase;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This is a failure tests for <code>CutCommentGraphNodeAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CutCommentGraphNodeActionFailureTest extends TestCase {

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
        commentGraphNode.setContainer(new GraphElement() {});
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
     * Tests constructor CutCommentGraphNodeAction(commentGraphNode, clipboard) if commentGraphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentGraphNodeNull() {
        try {
            new CutCommentGraphNodeAction(null, null);
            fail("IllegalArgumentException is expected because commentGraphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutCommentGraphNodeAction(commentGraphNode, clipboard) if
     * commentGraphNode doesn't contain a semanticModel attribute (Uml1SemanticModelBridge object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNotContainSemanticModelAttribute() {
        try {
            new CutCommentGraphNodeAction(commentGraphNode, null);
            fail("IllegalArgumentException is expected because commentGraphNode doesn't contain a semanticModel"
                    + "attribute (Uml1SemanticModelBridge object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutCommentGraphNodeAction(commentGraphNode, clipboard) if
     * commentGraphNode contains a semanticModel attribute, but not Uml1SemanticModelBridge object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentContainInvalidSemanticModelAttribute() {
        try {
            commentGraphNode.setSemanticModel(new SimpleSemanticModelElement());
            new CutCommentGraphNodeAction(commentGraphNode, null);
            fail("IllegalArgumentException is expected because commentGraphNode contains invalid semanticModel"
                    + "attribute (non-Uml1SemanticModelBridge object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutCommentGraphNodeAction(commentGraphNode, clipboard) if
     * commentGraphNode contains a semanticModel attribute (Uml1SemanticModelBridge object), but it
     * does not contain a Comment object as its element attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeNonCommentType() {
        try {
            Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
            semanticModelBridge.setElement(new Element() {});
            commentGraphNode.setSemanticModel(semanticModelBridge);
            new CutCommentGraphNodeAction(commentGraphNode, null);
            fail("IllegalArgumentException is expected because semanticModel's element attribute is "
                    + " non-Comment.");
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
        Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
        semanticModelBridge.setElement(new CommentImpl());
        commentGraphNode.setSemanticModel(semanticModelBridge);
        CutCommentGraphNodeActionImpl action = new CutCommentGraphNodeActionImpl(commentGraphNode, null);
        try {
            action.copyToClipboard(null, null);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * This class is used so that to access method copyToClipboard.
     * </p>
     */
    private class CutCommentGraphNodeActionImpl extends CutCommentGraphNodeAction {

        /**
         * <p>
         * Constructs a CutCommentGraphNodeAction.
         * </p>
         *
         * @param commentGraphNode the comment graph node.
         * @param clipboard the clipboard to copy the data.
         *
         * @throws IllegalArgumentException if the commentGraphNode argument is null,
         *                                  or the commentGraphNode doesn't contains a semanticModel attribute
         *                                  (Uml1SemanticModelBridge object), which in turn should contain a Comment
         *                                  object as its element attribute.
         */
        public CutCommentGraphNodeActionImpl(GraphNode commentGraphNode, Clipboard clipboard) {
            super(commentGraphNode, clipboard);
        }

        /**
         * <p>
         * Copy the comment graph node to the clipboard.
         * </p>
         *
         * @param node      the comment graph node to copy.
         * @param clipboard the clipboard to copy the data.
         * @throws IllegalArgumentException if the node argument is null.
         * @throws ActionExecutionException if the copy to clipboard operation fails.
         */
        public void copyToClipboard(GraphElement node, Clipboard clipboard) throws ActionExecutionException {
            super.copyToClipboard(node, clipboard);
        }
    }
}