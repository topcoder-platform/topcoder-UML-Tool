/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AddCommentGraphNodeActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.core.Element;
import junit.framework.TestCase;

/**
 * <p>
 * This is a failure tests for <code>AddCommentGraphNodeAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AddCommentGraphNodeActionFailureTest extends TestCase {

    /**Comment GraphNode that is used for testing.*/
    private GraphNode commentGraphNode;

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

        commentGraphNode = new GraphNode();
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
     * Tests constructor AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager) if
     * commentGraphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentGraphNodeNull() {
        try {
            new AddCommentGraphNodeAction(null, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because commentGraphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager) if
     * diagram is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDiagramNull() {
        try {
            new AddCommentGraphNodeAction(commentGraphNode, null, umlModelManager);
            fail("IllegalArgumentException is expected because diagram cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager) if
     * umlModelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfModelManagerNull() {
        try {
            new AddCommentGraphNodeAction(commentGraphNode, diagram, null);
            fail("IllegalArgumentException is expected because umlModelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager) if
     * commentGraphNode doesn't contain a semanticModel attribute (Uml1SemanticModelBridge object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNotContainSemanticModelAttribute() {
        try {
            new AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because commentGraphNode doesn't contain a semanticModel"
                    + "attribute (Uml1SemanticModelBridge object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager) if
     * commentGraphNode contains a semanticModel attribute, but not Uml1SemanticModelBridge object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentContainInvalidSemanticModelAttribute() {
        try {
            commentGraphNode.setSemanticModel(new SimpleSemanticModelElement());
            new AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because commentGraphNode contains invalid semanticModel"
                    + "attribute (non-Uml1SemanticModelBridge object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager) if
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
            new AddCommentGraphNodeAction(commentGraphNode, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because semanticModel's element attribute is "
                    + " non-Comment.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}