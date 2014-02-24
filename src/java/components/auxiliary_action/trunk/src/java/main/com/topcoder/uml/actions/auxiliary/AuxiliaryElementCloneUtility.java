/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.util.Collection;
import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.modelmanagement.ElementImport;

/**
 * <p>
 * This is a utility class, it provides method to clone the auxiliary model
 * object for the cut/copy actions.
 * </p>
 * <p>
 * Thread-safety: This class is stateless and thread-safe.
 * </p>
 *
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
class AuxiliaryElementCloneUtility {
    /**
     * <p>
     * Constant for text "CommentLink".
     * </p>
     */
    private static final String COMMENT_LINK = "CommentLink";

    /**
     * <p>
     * Constant for text "FreeText".
     * </p>
     */
    private static final String FREE_TEXT = "FreeText";

    /**
     * <p>
     * Empty constructor.
     * </p>
     *
     */
    private AuxiliaryElementCloneUtility() {
    }

    /**
     * <p>
     * Clone the <code>Comment</code> object.
     * </p>
     *
     * @param comment
     *            the Comment object to clone.
     * @return the cloned Comment object.
     * @throws IllegalArgumentException
     *             If the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    public static Comment cloneComment(Comment comment) throws AuxiliaryElementCloneException {
        Comment clone = (Comment) cloneModelElement(comment);
        // Set the body
        clone.setBody(comment.getBody());
        return clone;
    }

    /**
     * <p>
     * Clone the <code>GraphNode</code> for comment.
     * </p>
     *
     * @param node
     *            the graph node to clone.
     * @return the cloned graph node.
     * @throws IllegalArgumentException
     *             If the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    public static GraphNode cloneCommentGraphNode(GraphNode node) throws AuxiliaryElementCloneException {
        // Validate the comment graph node
        validateGraphNodeForComment(node);
        // Clone it
        GraphNode clone = cloneGraphNode(node);
        Uml1SemanticModelBridge usmb = (Uml1SemanticModelBridge) node.getSemanticModel();
        usmb.setElement(cloneComment((Comment) usmb.getElement()));
        clone.setSemanticModel(usmb);
        return clone;
    }

    /**
     * <p>
     * Clone the <code>GraphEdge</code> for comment.
     * </p>
     *
     * @param edge
     *            the graph edge to clone
     * @return the cloned graph edge.
     * @throws IllegalArgumentException
     *             If the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    public static GraphEdge cloneCommentRelationshipGraphEdge(GraphEdge edge) throws AuxiliaryElementCloneException {
        // Validate the comment relationship graph edge
        validateGraphEdgeForCommentRelationship(edge);
        // Clone it
        return cloneGraphEdge(edge);
    }

    /**
     * <p>
     * Clone the <code>GraphNode</code> for free text.
     * </p>
     *
     * @param node
     *            the graph node to clone.
     * @return the cloned graph node.
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    public static GraphNode cloneFreeTextGraphNode(GraphNode node) throws AuxiliaryElementCloneException {
        // Validate the free text graph node
        validateGraphNodeForFreeTextAction(node);
        // Clone it
        return cloneGraphNode(node);
    }

    /**
     * <p>
     * Clone the <code>GraphEdge</code> for polyline.
     * </p>
     *
     * @param edge
     *            the graph edge to clone.
     * @return the cloned graph edge.
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    public static GraphEdge clonePolylineGraphEdge(GraphEdge edge) throws AuxiliaryElementCloneException {
        // Validate the polyline graph edge
        validateGraphEdgeForPolylineAction(edge);
        // Clone it
        return cloneGraphEdge(edge);
    }

    /**
     * <p>
     * Clone the graph edge.
     * </p>
     *
     * @param edge
     *            the graph edge to clone
     * @return the cloned graph edge.
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    private static GraphEdge cloneGraphEdge(GraphEdge edge) throws AuxiliaryElementCloneException {
        // Clone it
        GraphEdge clone = (GraphEdge) cloneGraphElement(edge);
        // Clone anchors
        for (GraphConnector gc : edge.getAnchors()) {
            clone.addAnchor(gc);
        }
        // Clone waypoints
        for (Point p : edge.getWaypoints()) {
            clone.addWaypoint(p);
        }
        return clone;
    }

    /**
     * <p>
     * Clone the graph node.
     * </p>
     *
     * @param node
     *            the graph node to clone
     * @return the cloned graph node
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    private static GraphNode cloneGraphNode(GraphNode node) throws AuxiliaryElementCloneException {
        // Clone it
        GraphNode clone = (GraphNode) cloneGraphElement(node);
        // Set the size
        clone.setSize(node.getSize());
        return clone;
    }

    /**
     * <p>
     * Clone the <code>GraphElement</code>.
     * </p>
     *
     * @param graphElement
     *            the graph element to clone
     * @return the cloned graph element
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    private static GraphElement cloneGraphElement(GraphElement graphElement) throws AuxiliaryElementCloneException {
        if (graphElement == null) {
            throw new IllegalArgumentException("graphElement cannot be null!");
        }
        GraphElement clone;
        try {
            clone = graphElement.getClass().newInstance();
        } catch (IllegalArgumentException e) {
            throw new AuxiliaryElementCloneException("IllegalArgumentException occurs while instantiating class "
                    + graphElement.getClass() + " using default constructor.", e);
        } catch (SecurityException e) {
            throw new AuxiliaryElementCloneException("SecurityException occurs while instantiating class "
                    + graphElement.getClass() + " using default constructor.", e);
        } catch (InstantiationException e) {
            throw new AuxiliaryElementCloneException("InstantiationException occurs while instantiating class "
                    + graphElement.getClass() + " using default constructor.", e);
        } catch (IllegalAccessException e) {
            throw new AuxiliaryElementCloneException("IllegalAccessException occurs while instantiating class "
                    + graphElement.getClass() + " using default constructor.", e);
        }
        for (GraphConnector gc : graphElement.getAnchorages()) {
            clone.addAnchorage(gc);
        }
        for (DiagramElement de : graphElement.getContaineds()) {
            clone.addContained(de);
        }
        for (DiagramLink dl : graphElement.getLinks()) {
            clone.addLink(dl);
        }
        clone.setPosition(graphElement.getPosition());
        for (Property p : graphElement.getProperties()) {
            clone.addProperty(p);
        }
        for (Reference r : graphElement.getReferences()) {
            clone.addReference(r);
        }
        clone.setSemanticModel(graphElement.getSemanticModel());
        clone.setVisible(graphElement.isVisible());
        return clone;
    }

    /**
     * <p>
     * Clone the given <code>ModelElement</code> object.
     * </p>
     * <exception> throw IllegalArgumentException if the argument is null throw
     * ActivityObjectCloneException if the clone operation fails. </exception>
     *
     *
     * @param modelElement
     *            the ModelElement object to clone.
     * @return the cloned ModelElement object.
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails.
     */
    private static ModelElement cloneModelElement(ModelElement modelElement) throws AuxiliaryElementCloneException {
        if (modelElement == null) {
            throw new IllegalArgumentException("modelElement cannot be null!");
        }
        ModelElement clonedElement;
        try {
            clonedElement = modelElement.getClass().newInstance();
        } catch (IllegalArgumentException e) {
            throw new AuxiliaryElementCloneException("IllegalArgumentException occurs while instantiating class "
                    + modelElement.getClass() + " using default constructor.", e);
        } catch (SecurityException e) {
            throw new AuxiliaryElementCloneException("SecurityException occurs while instantiating class "
                    + modelElement.getClass() + " using default constructor.", e);
        } catch (InstantiationException e) {
            throw new AuxiliaryElementCloneException("InstantiationException occurs while instantiating class "
                    + modelElement.getClass() + " using default constructor.", e);
        } catch (IllegalAccessException e) {
            throw new AuxiliaryElementCloneException("IllegalAccessException occurs while instantiating class "
                    + modelElement.getClass() + " using default constructor.", e);
        }

        // simple attributes
        clonedElement.setName(modelElement.getName());
        clonedElement.setVisibility(modelElement.getVisibility());
        clonedElement.setSpecification(modelElement.isSpecification());

        // add the stereotypes, no clone because the relationship is not a
        // composite
        Collection<Stereotype> stereotypes = modelElement.getStereotypes();
        for (Stereotype stereotype : stereotypes) {
            clonedElement.addStereotype(stereotype);
        }

        // add the tagged values, composite relationship so clone is done
        Collection<TaggedValue> taggedValues = modelElement.getTaggedValues();
        for (TaggedValue taggedValue : taggedValues) {
            clonedElement.addTaggedValue(cloneTaggedValue(taggedValue));
        }

        // add the reference tags, no clone because the relationship is not a
        // composite
        Collection<TaggedValue> referenceTags = modelElement.getReferenceTags();
        for (TaggedValue taggedValue : referenceTags) {
            clonedElement.addReferenceTag(taggedValue);
        }

        // set the namespace, no clone because the relationship is not a
        // composite
        clonedElement.setNamespace(modelElement.getNamespace());

        // set the parameter template, no clone because the relationship is not
        // a composite
        clonedElement.setParameterTemplate(modelElement.getParameterTemplate());

        // add the default parameters, no clone because the relationship is not
        // a composite
        Collection<TemplateParameter> defaultParameters = modelElement.getDefaultParameters();
        for (TemplateParameter tp : defaultParameters) {
            clonedElement.addDefaultParameter(tp);
        }

        // add the template parameters, no clone because the relationship is not
        // a composite
        List<TemplateParameter> templateParameters = modelElement.getTemplateParameters();
        for (TemplateParameter tp : templateParameters) {
            clonedElement.addTemplateParameter(tp);
        }

        // add the template arguments, no clone because the relationship is not
        // a composite
        Collection<TemplateArgument> templateArguments = modelElement.getTemplateArguments();
        for (TemplateArgument ta : templateArguments) {
            clonedElement.addTemplateArgument(ta);
        }

        // add the element imports, no clone because the relationship is not a
        // composite
        Collection<ElementImport> elementImports = modelElement.getElementImports();
        for (ElementImport elemnetImport : elementImports) {
            clonedElement.addElementImport(elemnetImport);
        }

        return clonedElement;
    }

    /**
     * <p>
     * Clone the given TaggedValue object.
     * </p>
     *
     * @param taggedValue
     *            the TaggedValue object to clone.
     * @return the cloned TaggedValue object
     *
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws AuxiliaryElementCloneException
     *             if the clone operation fails
     */
    private static TaggedValue cloneTaggedValue(TaggedValue taggedValue) throws AuxiliaryElementCloneException {
        TaggedValue clonedTaggedValue = (TaggedValue) cloneModelElement(taggedValue);

        // set the data value
        clonedTaggedValue.setDataValue(taggedValue.getDataValue());

        // set the tag type, no clone because the relationship is not a
        // composite
        clonedTaggedValue.setType(taggedValue.getType());

        // set the model element, no clone because the relationship is not a
        // composite
        clonedTaggedValue.setModelElement(taggedValue.getModelElement());

        // add all the reference values, no clone because the relationship is
        // not a composite
        Collection<ModelElement> referenceValues = taggedValue.getReferenceValues();
        for (ModelElement element : referenceValues) {
            clonedTaggedValue.addReferenceValue(element);
        }

        return clonedTaggedValue;
    }

    /**
     * <p>
     * Validate if the freeTextGraphNode is valid for actions that relates to
     * Free Text graph nodes.
     * </p>
     *
     * @param freeTextGraphNode
     *            the freeTextGraphNode to validate
     * @throws AuxiliaryElementCloneException
     *             If or the freeTextGraphNode doesn't contain a semanticModel
     *             attribute (<code>SimpleSemanticModelElement</code> object)
     *             with typeInfo attribute equal to "FreeText", or it doesn't
     *             contain a <code>TextElement</code> object in its contained
     *             attribute.
     * @throws IllegalArgumentException
     *             If freeTextGraphNode is null
     */
    private static void validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode)
        throws AuxiliaryElementCloneException {
        if (freeTextGraphNode == null) {
            throw new IllegalArgumentException("freeTextGraphNode cannot be null!");
        }
        // Validate the SemanticModel
        SemanticModelBridge smb = freeTextGraphNode.getSemanticModel();
        if (!(smb instanceof SimpleSemanticModelElement)) {
            throw new AuxiliaryElementCloneException(
                    "SemanticModel of the freeTextGraphNode should be SimpleSemanticModelElement!");
        }
        SimpleSemanticModelElement ssme = (SimpleSemanticModelElement) smb;
        if (!FREE_TEXT.equals(ssme.getTypeInfo())) {
            throw new AuxiliaryElementCloneException("typeInfo of freeTextGraphNode's SemanticModel should be '"
                    + FREE_TEXT + "'!");
        }
        // Validate if the freeTextGraphNode contains a TextElement
        boolean valid = false;
        for (DiagramElement de : freeTextGraphNode.getContaineds()) {
            if (de instanceof TextElement) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new AuxiliaryElementCloneException("freeTextGraphNode should contain a TextElement!");
        }
    }

    /**
     * <p>
     * Validate if the polylineGraphEdge is valid for actions that relates to
     * Polyline graph nodes.
     * </p>
     *
     * @param polylineGraphEdge
     *            The polylineGraphEdge to validate
     * @throws AuxiliaryElementCloneException
     *             If the polylineGraphEdge doesn't contain a
     *             <code>Polyline</code> object in its contained attribute.
     * @throws IllegalArgumentException
     *             if polylineGraphEdge is null
     *
     */
    private static void validateGraphEdgeForPolylineAction(GraphEdge polylineGraphEdge)
        throws AuxiliaryElementCloneException {
        if (polylineGraphEdge == null) {
            throw new IllegalArgumentException("polylineGraphEdge cannot be null!");
        }
        // Validate if polylineGraphEdge contains a Polyline
        boolean valid = false;
        for (DiagramElement de : polylineGraphEdge.getContaineds()) {
            if (de instanceof Polyline) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new AuxiliaryElementCloneException("polylineGraphEdge should contain a Polyline!");
        }
    }

    /**
     * <p>
     * Validate if the commentGraphNode is valid for actions that relates to
     * Comment graph nodes.
     * </p>
     *
     * @param commentGraphNode
     *            the commentGraphNode to validate.
     * @throws AuxiliaryElementCloneException
     *             If the commentGraphNode doesn't contains a semanticModel
     *             attribute (Uml1SemanticModelBridge object), which in turn
     *             should contain a Comment object as its element attribute.
     * @throws IllegalArgumentException
     *             if any argument is null
     *
     */
    private static void validateGraphNodeForComment(GraphNode commentGraphNode) throws AuxiliaryElementCloneException {
        if (commentGraphNode == null) {
            throw new IllegalArgumentException("commentGraphNode cannot be null!");
        }
        // Validate the SemanticModel
        SemanticModelBridge smb = commentGraphNode.getSemanticModel();
        if (!(smb instanceof Uml1SemanticModelBridge)) {
            throw new AuxiliaryElementCloneException(
                    "SemanticModel of the commentGraphNode should be Uml1SemanticModelBridge!");
        }
        Uml1SemanticModelBridge usmb = (Uml1SemanticModelBridge) smb;
        // Validate if the Uml1SemanticModelBridge contains a Comment as its
        // element attribute.
        if (usmb.getElement() == null || !(usmb.getElement() instanceof Comment)) {
            throw new AuxiliaryElementCloneException(
                    "The Uml1SemanticModelBridge of the commentGraphNode should contain a Comment as its element!");
        }
    }

    /**
     * <p>
     * Validate if the commentGraphEdge is valid for actions that relates to
     * Comment Relationship graph nodes.
     * </p>
     *
     * @param commentGraphEdge
     *            the commentGraphEdge to validate.
     * @throws IllegalArgumentException
     *             If commentGraphEdge is null.
     * @throws AuxiliaryElementCloneException
     *             If the commentGraphEdge doesn't contains a semanticModel
     *             attribute (SimpleSemanticModelElement object) with its
     *             typeInfo attribute equal to "CommentLink".
     */
    private static void validateGraphEdgeForCommentRelationship(GraphEdge commentGraphEdge)
        throws AuxiliaryElementCloneException {
        if (commentGraphEdge == null) {
            throw new IllegalArgumentException("commentGraphEdge cannot be null!");
        }
        // Validate the SemanticModel
        SemanticModelBridge smb = commentGraphEdge.getSemanticModel();
        if (!(smb instanceof SimpleSemanticModelElement)) {
            throw new AuxiliaryElementCloneException(
                    "SemanticModel of the commentGraphEdge should be SimpleSemanticModelElement!");
        }
        SimpleSemanticModelElement ssme = (SimpleSemanticModelElement) smb;
        if (!COMMENT_LINK.equals(ssme.getTypeInfo())) {
            throw new AuxiliaryElementCloneException("typeInfo of commentGraphEdge's SemanticModel should be '"
                    + COMMENT_LINK + "'!");
        }
    }
}
