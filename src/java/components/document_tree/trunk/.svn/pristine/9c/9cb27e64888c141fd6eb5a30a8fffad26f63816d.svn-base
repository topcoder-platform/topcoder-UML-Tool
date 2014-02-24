/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class represents a node of the document tree for users of this component.
 * </p>
 *
 * <p>
 * It wraps around all three possible types of nodes:
 * <ul>
 * <li>model elements</li>
 * <li>graph elements</li>
 * <li>diagram categories</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note, it is not a <code>TreeNode</code> of the <code>javax.swing.tree</code> package and
 * implementations of the <code>DocumentTreeView</code> are expected to map objects of this
 * class to a visual node.
 * </p>
 *
 * <p>
 * Thread Safety: This class is thread safe as it is immutable.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class DocumentTreeNode {
    /**
     * <p>
     * This variable represents the type of this node.
     * </p>
     *
     * <p>
     * It is frozen as it does not change after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and got by the getType method.
     * </p>
     *
     * <p>
     * It will never be null.
     * </p>
     */
    private final DocumentTreeNodeType type;

    /**
     * <p>
     * This variable represents the underlying object held by this node.
     * </p>
     *
     * <p>
     * The value can be either a <code>ModelElement</code>, <code>GraphElement</code> or a <code>String</code>,
     * hence it is held as an <code>Object</code>.
     * </p>
     *
     * <p>
     * It is frozen as it does not change after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and got by the getNodeObject method. It is also referenced by the toString method.
     * </p>
     *
     * <p>
     * It will never be null.
     * </p>
     */
    private final Object nodeObject;

    /**
     * <p>
     * Constructs a <code>DocumentTreeNode</code> with the underlying object being a graph element.
     * </p>
     *
     * @param graphElement The underlying graph element. Must not be null.
     *
     * @throws IllegalArgumentException If graphElement is null
     */
    public DocumentTreeNode(GraphElement graphElement) {
        this(graphElement, "graphElement", DocumentTreeNodeType.GRAPH_ELEMENT);
    }

    /**
     * <p>
     * Constructs a <code>DocumentTreeNode</code> with the underlying object being a model element.
     * </p>
     *
     * @param modelElement The underlying model element. Must not be null.
     *
     * @throws IllegalArgumentException If modelElement is null
     */
    public DocumentTreeNode(ModelElement modelElement) {
        this(modelElement, "modelElement", DocumentTreeNodeType.MODEL_ELEMENT);
    }

    /**
     * <p>
     * Constructs a <code>DocumentTreeNode</code> with the underlying object being a diagram category name.
     * </p>
     *
     * @param diagramCategoryName The underlying diagram category name. Must not be null.
     *
     * @throws IllegalArgumentException If diagramCategoryName is null or empty.
     */
    public DocumentTreeNode(String diagramCategoryName) {
        this(diagramCategoryName, "diagramCategoryName", DocumentTreeNodeType.DIAGRAM_CATEGORY);
    }

    /**
     * <p>
     * Constructs a <code>DocumentTreeNode</code> instance with the arguments given.
     * </p>
     *
     * <p>
     * This is a private constructor and it is used for reduce code redundancy.
     * </p>
     *
     * @param nodeObject the node object value
     * @param name the name of the node object argument
     * @param type the document tree node type
     *
     * @throws IllegalArgumentException If nodeObject is null or it is empty when it is a string.
     */
    private DocumentTreeNode(Object nodeObject, String name, DocumentTreeNodeType type) {
        Util.checkNull(nodeObject, name);
        if (nodeObject instanceof String) {
            if (((String) nodeObject).trim().length() == 0) {
                throw new IllegalArgumentException("The given " + name + " is empty string.");
            }
        }

        this.nodeObject = nodeObject;
        this.type = type;
    }

    /**
     * <p>
     * Gets the type of this node's node object.
     * </p>
     *
     * @return The type of this node's node object.
     */
    public DocumentTreeNodeType getType() {
        return type;
    }

    /**
     * <p>
     * Gets this node's node object.
     * </p>
     *
     * @return the node's node object.
     */
    public Object getNodeObject() {
        return this.nodeObject;
    }

    /**
     * <p>
     * Gets the string representation of this <code>DocumentTreeNode</code> object.
     * </p>
     *
     * <p>
     * If the node object is <code>DIAGRAM_CATEGORY</code>, the diagram category name will be returned,
     * if the node object is <code>MODEL_ELEMENT</code>, the name of the model element will be returned,
     * if the node object is <code>GRAPH_ELEMENT</code>, if it is a diagram, then the diagram name will
     * be returned, otherwise the name of the model element contained in the uml semantic model will be
     * returned.
     * </p>
     *
     * @return The string representation of this object.
     *
     * @throws IllegalStateException if the semantic model of the graph element is not of Uml1SemanticModelBridge,
     * or the element of the semantic model is not of ModelElement type when the type is GRAPH_ELEMENT and the
     * graph element is not of Diagram type.
     */
    public String toString() {
        switch (type) {
        case DIAGRAM_CATEGORY: {
            return (String) nodeObject;
        }
        case MODEL_ELEMENT: {
            return ((ModelElement) nodeObject).getName();
        }
        case GRAPH_ELEMENT: {
            if (nodeObject instanceof Diagram) {
                return ((Diagram) nodeObject).getName();
            } else {
                SemanticModelBridge bridge = ((GraphElement) nodeObject).getSemanticModel();
                // The semantic model should be of Uml1SemanticModelBridge type
                if (bridge instanceof Uml1SemanticModelBridge) {
                    Element element = ((Uml1SemanticModelBridge) bridge).getElement();
                    // The element should be of ModelElement type
                    if (element instanceof ModelElement) {
                        return ((ModelElement) element).getName();
                    } else {
                        // not of ModelElement type
                        throw new IllegalStateException(
                            "The element of the uml semantic model of the graph element is "
                                + "not of ModelElement type, it may be null.");
                    }
                } else {
                    // not a Uml1SemanticModelBridge
                    throw new IllegalStateException(
                        "The semantic model of the graph element is not of Uml1SemanticModelBridge "
                            + "type, it may be null.");
                }
            }
        }
        default: {
            return nodeObject.toString();
        }
        }
    }

    /**
     * <p>
     * Returns whether the given object is equal to this object.
     * </p>
     *
     * <p>
     * The two objects are considered as equal if and only if the given object is an instance of
     * <code>DocumentTreeNode</code> and the node objects contained are equal.
     * If the given object is null or is not an instance of <code>DocumentTreeNode</code>,
     * then these two objects are not considered as equal.
     * </p>
     *
     * @param object The given object. Possibly null.
     * @return <code>true</code> if this object is equal to the object argument, <code>false</code>
     * otherwise.
     */
    public boolean equals(Object object) {
        if (object instanceof DocumentTreeNode) {
            return nodeObject.equals(((DocumentTreeNode) object).nodeObject);
        }

        return false;
    }

    /**
     * <p>
     * Returns the hash code value for this object.
     * </p>
     *
     * @return the hash code value for this object.
     */
    public int hashCode() {
        return nodeObject.hashCode();
    }
}
