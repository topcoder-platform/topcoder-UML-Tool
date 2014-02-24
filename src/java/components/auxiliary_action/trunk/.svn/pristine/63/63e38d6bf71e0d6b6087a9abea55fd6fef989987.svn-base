/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AddFreeTextActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.actions.auxiliary.diagram.AddFreeTextAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;

/**
 * <p>
 * This is a failure tests for <code>AddFreeTextAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AddFreeTextActionFailureTest extends TestCase {

    /**Free text GraphNode that is used for testing.*/
    private GraphNode freeTextGraphNode;

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

        freeTextGraphNode = new GraphNode();
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
     * Tests constructor AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager) if
     * freeTextGraphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeNull() {
        try {
            new AddFreeTextAction(null, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because freeTextGraphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager) if
     * diagram is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDiagramNull() {
        try {
            new AddFreeTextAction(freeTextGraphNode, null, umlModelManager);
            fail("IllegalArgumentException is expected because diagram cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager) if
     * umlModelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfModelManagerNull() {
        try {
            new AddFreeTextAction(freeTextGraphNode, diagram, null);
            fail("IllegalArgumentException is expected because umlModelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager) if
     * freeTextGraphNode doesn't contain a semanticModel attribute (SimpleSemanticModelElement object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeNotContainSemanticModelAttribute() {
        try {
            new AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because freeTextGraphNode doesn't contain a semanticModel"
                    + "attribute (SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager) if
     * freeTextGraphNode contains a semanticModel attribute, but not SimpleSemanticModelElement object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeContainInvalidSemanticModelAttribute() {
        try {
            freeTextGraphNode.setSemanticModel(new Uml1SemanticModelBridge());
            new AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because freeTextGraphNode contains invalid semanticModel"
                    + "attribute (non-SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager) if
     * freeTextGraphNode contains a semanticModel attribute (SimpleSemanticModelElement object), but its
     * typeInfo attribute is not equal to "FreeText".
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorITypeInfoInvalid() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("invalid_type_info");
            freeTextGraphNode.setSemanticModel(semanticModelBridge);
            new AddFreeTextAction(freeTextGraphNode, diagram, umlModelManager);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is not equal "
                    + "to 'FreeText'.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}