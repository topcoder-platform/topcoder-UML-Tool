/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CopyFreeTextActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.uml.actions.auxiliary.diagram.CopyFreeTextAction;
import junit.framework.TestCase;

/**
 * <p>
 * This is a failure tests for <code>CopyFreeTextAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CopyFreeTextActionFailureTest extends TestCase {

    /**Free text GraphNode that is used for testing.*/
    private GraphNode freeTextGraphNode;

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        freeTextGraphNode = new GraphNode();
    }

    /**
     * <p>
     * Tests constructor CopyFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeNull() {
        try {
            new CopyFreeTextAction(null, null);
            fail("IllegalArgumentException is expected because freeTextGraphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CopyFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode doesn't
     * contain a semanticModel attribute (SimpleSemanticModelElement object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeNotContainSemanticModelAttribute() {
        try {
            freeTextGraphNode.addContained(new TextElement());
            new CopyFreeTextAction(freeTextGraphNode, null);
            fail("IllegalArgumentException is expected because freeTextGraphNode doesn't contain a semanticModel"
                    + "attribute (SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CopyFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode contains
     * a semanticModel attribute, but not SimpleSemanticModelElement object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeContainInvalidSemanticModelAttribute() {
        try {
            freeTextGraphNode.addContained(new TextElement());
            freeTextGraphNode.setSemanticModel(new Uml1SemanticModelBridge());
            new CopyFreeTextAction(freeTextGraphNode, null);
            fail("IllegalArgumentException is expected because freeTextGraphNode contains invalid semanticModel"
                    + "attribute (non-SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CopyFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode contains
     * a semanticModel attribute (SimpleSemanticModelElement object), but its typeInfo attribute is not
     * equal to "FreeText".
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorITypeInfoInvalid() {
        try {
            freeTextGraphNode.addContained(new TextElement());
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("invalid_type_info");
            freeTextGraphNode.setSemanticModel(semanticModelBridge);
            new CopyFreeTextAction(freeTextGraphNode, null);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is not equal "
                    + "to 'FreeText'.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CopyFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode
     * doesn't contain a TextElement object in its contained attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNotContainedTextElementObject() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("FreeText");
            freeTextGraphNode.setSemanticModel(semanticModelBridge);
            new CopyFreeTextAction(freeTextGraphNode, null);
            fail("IllegalArgumentException is expected because freeTextGraphNode must contain a TextElement "
                    + "object in its contained attribute.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}