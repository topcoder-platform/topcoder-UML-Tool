/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * PasteCommentGraphNodeActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.Element;
import junit.framework.TestCase;

/**
 * <p>
 * This is a failure tests for <code>PasteCommentGraphNodeAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class PasteCommentGraphNodeActionFailureTest extends TestCase {

    /**Content object that is used for testing.*/
    private Object content;

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

        content = new GraphNode();
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
     * Tests constructor PasteCommentGraphNodeAction(content, diagram) if content is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentGraphNodeNull() {
        try {
            new PasteCommentGraphNodeAction(null, diagram);
            fail("IllegalArgumentException is expected because content cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentGraphNodeAction(content, diagram) if diagram is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDiagramNull() {
        try {
            new PasteCommentGraphNodeAction(content, null);
            fail("IllegalArgumentException is expected because diagram cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentGraphNodeAction(content, diagram) if content is not instance of GraphNode.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentNonGraphNode() {
        try {
            new PasteCommentGraphNodeAction(new Object(), diagram);
            fail("IllegalArgumentException is expected because content must be instance of GraphNode.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentGraphNodeAction(content, diagram) if content graph node
     * doesn't contain a semanticModel attribute (Uml1SemanticModelBridge object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNotContainSemanticModelAttribute() {
        try {
            new PasteCommentGraphNodeAction(content, diagram);
            fail("IllegalArgumentException is expected because  content graph node doesn't contain a semanticModel"
                    + " attribute (Uml1SemanticModelBridge object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentGraphNodeAction(content, diagram) if content graph node
     * contains a semanticModel attribute, but not Uml1SemanticModelBridge object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentContainInvalidSemanticModelAttribute() {
        try {
            ((GraphNode) content).setSemanticModel(new SimpleSemanticModelElement());
            new PasteCommentGraphNodeAction(content, diagram);
            fail("IllegalArgumentException is expected because content graph node contains invalid semanticModel"
                    + " attribute (non-Uml1SemanticModelBridge object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentGraphNodeAction(content, diagram) if
     * commentGraphNode contains a semanticModel attribute (Uml1SemanticModelBridge object), but it
     * does not contain a Comment object as its element attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorISemanticModelAttributeNonCommentType() {
        try {
            Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
            semanticModelBridge.setElement(new Element() {});
            ((GraphNode) content).setSemanticModel(semanticModelBridge);
            new PasteCommentGraphNodeAction(content, diagram);
            fail("IllegalArgumentException is expected because semanticModel's element attribute is"
                    + " non-Comment.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}