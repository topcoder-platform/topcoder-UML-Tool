/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CutFreeTextActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.*;
import com.topcoder.uml.actions.auxiliary.diagram.CutFreeTextAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.util.actionmanager.ActionExecutionException;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This is a failure tests for <code>CutFreeTextAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CutFreeTextActionFailureTest extends TestCase {

    /**Free text GraphNode that is used for testing.*/
    private GraphNode freeTextGraphNode;

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
        freeTextGraphNode.setContainer(new GraphElement() {});
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
     * Tests constructor CutFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeNull() {
        try {
            new CutFreeTextAction(null, null);
            fail("IllegalArgumentException is expected because freeTextGraphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode doesn't
     * contain a semanticModel attribute (SimpleSemanticModelElement object).
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeNotContainSemanticModelAttribute() {
        try {
            freeTextGraphNode.addContained(new TextElement());
            new CutFreeTextAction(freeTextGraphNode, null);
            fail("IllegalArgumentException is expected because freeTextGraphNode doesn't contain a semanticModel"
                    + "attribute (SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode contains
     * a semanticModel attribute, but not SimpleSemanticModelElement object.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNodeContainInvalidSemanticModelAttribute() {
        try {
            freeTextGraphNode.addContained(new TextElement());
            freeTextGraphNode.setSemanticModel(new Uml1SemanticModelBridge());
            new CutFreeTextAction(freeTextGraphNode, null);
            fail("IllegalArgumentException is expected because freeTextGraphNode contains invalid semanticModel"
                    + "attribute (non-SimpleSemanticModelElement object).");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode contains
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
            new CutFreeTextAction(freeTextGraphNode, null);
            fail("IllegalArgumentException is expected because semanticModel's typeInfo is not equal "
                    + "to 'FreeText'.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutFreeTextAction(freeTextGraphNode, clipboard) if freeTextGraphNode
     * doesn't contain a TextElement object in its contained attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfFreeTextNotContainedTextElementObject() {
        try {
            SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
            semanticModelBridge.setTypeInfo("FreeText");
            freeTextGraphNode.setSemanticModel(semanticModelBridge);
            new CutFreeTextAction(freeTextGraphNode, null);
            fail("IllegalArgumentException is expected because freeTextGraphNode must contain a TextElement "
                    + "object in its contained attribute.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method copyToClipboard(node, clipboard) if node is null.
     * IllegalArgumentException is expected
     * </p>
     *
     * @throws Exception exception
     */
    public void testCopyToClipboardIfNodeNull() throws Exception {
        SimpleSemanticModelElement semanticModelBridge = new SimpleSemanticModelElement();
        semanticModelBridge.setTypeInfo("FreeText");
        freeTextGraphNode.setSemanticModel(semanticModelBridge);
        freeTextGraphNode.addContained(new TextElement());
        CutFreeTextActionExt cutFreeTextAction = new CutFreeTextActionExt(freeTextGraphNode, null);
        try {
            cutFreeTextAction.copyToClipboard(null, null);
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
    private class CutFreeTextActionExt extends CutFreeTextAction {
        /**
         * <p>
         * Constructs CutFreeTextAction.
         * </p>
         *
         * @param freeTextGraphNode the free text graph node.
         * @param clipboard         the clipboard to copy.
         * @throws IllegalArgumentException if the freeTextGraphNode argument is null,
         *                                  or the freeTextGraphNode doesn't contain a semanticModel attribute
         *                                 (SimpleSemanticModelElement object) with typeInfo attribute equal to
         *                                 &quot;FreeText&quot;, or it doesn't contain a TextElement
         *                                 object in its contained attribute.
         */
        public CutFreeTextActionExt(GraphNode freeTextGraphNode, Clipboard clipboard) {
            super(freeTextGraphNode, clipboard);
        }

        /**
         * <p>
         * Copy the free text graph node to the clipboard.
         * </p>
         *
         * @param node      the free text graph node.
         * @param clipboard the clipboard to copy.
         * @throws IllegalArgumentException if the node argument is null.
         * @throws ActionExecutionException if the copy to clipboard operation fails.
         */
        protected void copyToClipboard(GraphElement node, Clipboard clipboard) throws ActionExecutionException {
            super.copyToClipboard(node, clipboard);
        }
    }
}