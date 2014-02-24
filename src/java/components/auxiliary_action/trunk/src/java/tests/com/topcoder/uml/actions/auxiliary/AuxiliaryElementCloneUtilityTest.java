/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;

/**
 * <p>
 * Unit tests on class <code>AuxiliaryElementCloneUtility</code>.
 * </p>
 *
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AuxiliaryElementCloneUtilityTest extends TestCase {
    /**
     * <p>
     * Test method <code>cloneComment(Comment comment)</code> for failure with
     * null comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCloneComment_NullComment() throws AuxiliaryElementCloneException {
        try {
            AuxiliaryElementCloneUtility.cloneComment(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneComment(Comment comment)</code> for accuracy.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCloneComment_Accuracy() throws AuxiliaryElementCloneException {
        Comment comment = new CommentImpl();
        initModelElement(comment);
        comment.setBody("Text");
        UnitTestHelper.assertEquals(comment, AuxiliaryElementCloneUtility.cloneComment(comment), "Failed to clone!");
    }

    /**
     * <p>
     * Test method <code>cloneCommentGraphNode(GraphNode graphNode)</code> for
     * failure with null graphNode, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCloneCommentGraphNode_NullGraphNode() throws AuxiliaryElementCloneException {
        try {
            AuxiliaryElementCloneUtility.cloneCommentGraphNode(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneCommentGraphNode(GraphNode graphNode)</code> for
     * failure with invalid commentGraphNode without semantic model,
     * <code>AuxiliaryElementCloneException</code> is expected.
     * </p>
     */
    public void testCloneCommentGraphNode_CommentGraphNodeWithoutSemanticModel() {
        try {
            AuxiliaryElementCloneUtility.cloneCommentGraphNode(new GraphNode());
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneCommentGraphNode(GraphNode graphNode)</code> for
     * failure with invalid commentGraphNode that contains illegal semantic
     * model(non-Uml1SemanticModelBridge),
     * <code>AuxiliaryElementCloneException</code> is expected.
     * </p>
     */
    public void testCloneCommentGraphNode_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        try {
            AuxiliaryElementCloneUtility.cloneCommentGraphNode(node);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneCommentGraphNode(GraphNode graphNode)</code> for
     * failure with invalid commentGraphNode that contains illegal semantic
     * model(without Comment element),
     * <code>AuxiliaryElementCloneException</code> is expected.
     * </p>
     */
    public void testCloneCommentGraphNode_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        node.setSemanticModel(usmb);
        try {
            AuxiliaryElementCloneUtility.cloneCommentGraphNode(node);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneCommentGraphNode(GraphNode graphNode)</code> for
     * accuracy.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCloneCommentGraphNode_Accuracy() throws AuxiliaryElementCloneException {
        GraphNode commentGraphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        commentGraphNode.setSemanticModel(usmb);
        UnitTestHelper.assertEquals(commentGraphNode, AuxiliaryElementCloneUtility
                .cloneCommentGraphNode(commentGraphNode), "Failed to clone!");
    }

    /**
     * <p>
     * Test method
     * <code>cloneCommentRelationshipGraphEdge(GraphEdge edge)</code> for
     * failure with null edge, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCloneCommentRelationshipGraphEdge_NullEdge() throws AuxiliaryElementCloneException {
        try {
            AuxiliaryElementCloneUtility.cloneCommentRelationshipGraphEdge(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>cloneCommentRelationshipGraphEdge(GraphEdge edge)</code> for
     * failure with null invalid commentGraphEdge without semantic model,
     * <code>AuxiliaryElementCloneException</code> is expected.
     * </p>
     */
    public void testCloneCommentRelationshipGraphEdge_CommentGraphNodeWithoutSemanticModel() {
        try {
            AuxiliaryElementCloneUtility.cloneCommentRelationshipGraphEdge(new GraphEdge());
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>cloneCommentRelationshipGraphEdge(GraphEdge edge)</code> for
     * failure with null invalid commentGraphEdge with illegal semantic model
     * (non-SimpleSemanticModelElement),
     * <code>AuxiliaryElementCloneException</code> is expected.
     * </p>
     */
    public void testCloneCommentRelationshipGraphEdge_CommentGraphNodeWithIllegalSemanticModel1() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(new Uml1SemanticModelBridge());
        try {
            AuxiliaryElementCloneUtility.cloneCommentRelationshipGraphEdge(edge);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>cloneCommentRelationshipGraphEdge(GraphEdge edge)</code> for
     * failure with null invalid commentGraphEdge with illegal semantic model
     * (illegal typeInfo), <code>AuxiliaryElementCloneException</code> is
     * expected.
     * </p>
     */
    public void testCloneCommentRelationshipGraphEdge_CommentGraphNodeWithIllegalSemanticModel2() {
        GraphEdge edge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        edge.setSemanticModel(ssme);
        try {
            AuxiliaryElementCloneUtility.cloneCommentRelationshipGraphEdge(edge);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>cloneCommentRelationshipGraphEdge(GraphEdge edge)</code> for
     * accuracy.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCloneCommentRelationshipGraphEdge_Accuracy() throws AuxiliaryElementCloneException {
        GraphEdge commentGraphEdge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("CommentLink");
        commentGraphEdge.setSemanticModel(ssme);
        UnitTestHelper.assertEquals(commentGraphEdge, AuxiliaryElementCloneUtility
                .cloneCommentRelationshipGraphEdge(commentGraphEdge), "Failed to clone!");
    }

    /**
     * <p>
     * Test method <code>cloneFreeTextGraphNode(GraphNode node)</code> for
     * failure with null node, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCloneFreeTextGraphNode_NullNode() throws AuxiliaryElementCloneException {
        try {
            AuxiliaryElementCloneUtility.cloneFreeTextGraphNode(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneFreeTextGraphNode(GraphNode node)</code> for
     * failure with null freeTextGraphNode which has no semantic model,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCloneFreeTextGraphNode_FreeTextGraphNodeWithoutSemanticModel() {
        GraphNode node = new GraphNode();
        node.addContained(new TextElement());
        try {
            AuxiliaryElementCloneUtility.cloneFreeTextGraphNode(node);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneFreeTextGraphNode(GraphNode node)</code> for
     * failure with null freeTextGraphNode has non-SimpleSemanticModelElement
     * semantic model, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCloneFreeTextGraphNode_FreeTextGraphNodeWithIllegalSemanticModel1() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new Uml1SemanticModelBridge());
        node.addContained(new TextElement());
        try {
            AuxiliaryElementCloneUtility.cloneFreeTextGraphNode(node);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneFreeTextGraphNode(GraphNode node)</code> for
     * failure with null ffreeTextGraphNode has bad SimpleSemanticModelElement
     * semantic model(no typeInfo), <code>AuxiliaryElementCloneException</code>
     * is expected.
     * </p>
     */
    public void testCloneFreeTextGraphNode_FreeTextGraphNodeWithIllegalSemanticModel2() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(new SimpleSemanticModelElement());
        node.addContained(new TextElement());
        try {
            AuxiliaryElementCloneUtility.cloneFreeTextGraphNode(node);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneFreeTextGraphNode(GraphNode node)</code> for
     * failure with null freeTextGraphNode has bad SimpleSemanticModelElement
     * semantic model(bad typeInfo), <code>AuxiliaryElementCloneException</code>
     * is expected.
     * </p>
     */
    public void testCloneFreeTextGraphNode_FreeTextGraphNodeWithIllegalSemanticModel3() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("NonFreeText");
        node.setSemanticModel(ssme);
        node.addContained(new TextElement());
        try {
            AuxiliaryElementCloneUtility.cloneFreeTextGraphNode(node);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneFreeTextGraphNode(GraphNode node)</code> for
     * failure with null freeTextGraphNode has no TextElement,
     * <code>AuxiliaryElementCloneException</code> is expected.
     * </p>
     */
    public void testCloneFreeTextGraphNode_FreeTextGraphNodeWithoutTextElement() {
        GraphNode node = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        node.setSemanticModel(ssme);
        try {
            AuxiliaryElementCloneUtility.cloneFreeTextGraphNode(node);
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>cloneFreeTextGraphNode(GraphNode node)</code> for
     * accuracy.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCloneFreeTextGraphNode_Accuracy() throws AuxiliaryElementCloneException {
        GraphNode freeTextGraphNode = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        freeTextGraphNode.setSemanticModel(ssme);
        freeTextGraphNode.addContained(new TextElement());
        UnitTestHelper.assertEquals(freeTextGraphNode, AuxiliaryElementCloneUtility
                .cloneFreeTextGraphNode(freeTextGraphNode), "Failed to clone!");
    }

    /**
     * <p>
     * Test method <code>clonePolylineGraphEdge(GraphEdge edge)</code> for
     * failure with null edge, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testClonePolylineGraphEdge_NullEdge() throws AuxiliaryElementCloneException {
        try {
            AuxiliaryElementCloneUtility.clonePolylineGraphEdge(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>clonePolylineGraphEdge(GraphEdge edge)</code> for
     * failure with polylineGraphEdge has no Polyline,
     * <code>AuxiliaryElementCloneException</code> is expected.
     * </p>
     */
    public void testClonePolylineGraphEdge_IllegalPolylineGraphEdge() {
        try {
            AuxiliaryElementCloneUtility.clonePolylineGraphEdge(new GraphEdge());
            fail("AuxiliaryElementCloneException is expected!");
        } catch (AuxiliaryElementCloneException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>clonePolylineGraphEdge(GraphEdge edge)</code> for
     * accuracy.
     * </p>
     *
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testClonePolylineGraphEdge_Accuracy() throws AuxiliaryElementCloneException {
        GraphEdge polylineGraphEdge = new GraphEdge();
        polylineGraphEdge.addContained(new Polyline());
        UnitTestHelper.assertEquals(polylineGraphEdge, AuxiliaryElementCloneUtility
                .clonePolylineGraphEdge(polylineGraphEdge), "Failed to clone!");
    }

    /**
     * <p>
     * Initial a model element.
     * </p>
     *
     * @param element
     *            the model element.
     */
    private void initModelElement(ModelElement element) {
        element.addDefaultParameter(new TemplateParameterImpl());
        element.addElementImport(new ElementImportImpl());
        element.addReferenceTag(new TaggedValueImpl());
        element.addStereotype(new StereotypeImpl());
        element.addTaggedValue(new TaggedValueImpl());
        element.addTemplateArgument(new TemplateArgumentImpl());
        element.addTemplateParameter(new TemplateParameterImpl());
        element.setName("Name");
        element.setNamespace(new NamespaceAbstractImpl() {
        });
        element.setSpecification(true);
        element.setVisibility(VisibilityKind.PACKAGE);
    }
}
