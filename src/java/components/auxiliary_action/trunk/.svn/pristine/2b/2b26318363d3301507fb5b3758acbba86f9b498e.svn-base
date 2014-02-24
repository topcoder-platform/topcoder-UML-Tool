/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * PasteFreeTextActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.*;
import com.topcoder.uml.actions.auxiliary.diagram.PasteFreeTextAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;

/**
 * <p>
 * This is a failure tests for <code>PasteFreeTextAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class PasteFreeTextActionFailureTest extends TestCase {

    /**Content object that is used for testing.*/
    private GraphNode content;

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
     * Tests constructor PasteFreeTextAction(content, diagram) if content is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentNull() {
        try {
            new PasteFreeTextAction(null, diagram);
            fail("IllegalArgumentException is expected because content cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteFreeTextAction(content, diagram) if content is not instance of GraphNode.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentNotGraphNode() {
        try {
            new PasteFreeTextAction(new Object(), diagram);
            fail("IllegalArgumentException is expected because content must be instance of GraphNode.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteFreeTextAction(content, diagram) if diagram is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDiagramNull() {
        try {
            content.addContained(new TextElement());
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("FreeText");
            content.setSemanticModel(semanticModelBridge);
            new PasteFreeTextAction(content, null);
            fail("IllegalArgumentException is expected because diagram cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteFreeTextAction(content, diagram) if content doesn't
     * contain a semanticModel attribute (SimpleSemanticModelElement object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentNotContainSemanticModelAttribute() {
        try {
            content.addContained(new TextElement());
            new PasteFreeTextAction(content, null);
            fail("IllegalArgumentException is expected because content doesn't contain a semanticModel"
                    + "attribute (SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteFreeTextAction(content, diagram) if content contains
     * a semanticModel attribute, but not SimpleSemanticModelElement object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentContainInvalidSemanticModelAttribute() {
        try {
            content.addContained(new TextElement());
            content.setSemanticModel(new Uml1SemanticModelBridge());
            new PasteFreeTextAction(content, null);
            fail("IllegalArgumentException is expected because content contains invalid semanticModel"
                    + "attribute (non-SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteFreeTextAction(content, diagram) if content contains
     * a semanticModel attribute (SimpleSemanticModelElement object), but its typeInfo attribute is not
     * equal to "FreeText".
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorITypeInfoInvalid() {
        try {
            content.addContained(new TextElement());
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("invalid_type_info");
            content.setSemanticModel(semanticModelBridge);
            new PasteFreeTextAction(content, null);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is not equal "
                    + "to 'FreeText'.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteFreeTextAction(content, diagram) if content
     * doesn't contain a TextElement object in its contained attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNotContainedTextElementObject() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("FreeText");
            content.setSemanticModel(semanticModelBridge);
            new PasteFreeTextAction(content, null);
            fail("IllegalArgumentException is expected because content must contain a TextElement "
                    + "object in its contained attribute.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}