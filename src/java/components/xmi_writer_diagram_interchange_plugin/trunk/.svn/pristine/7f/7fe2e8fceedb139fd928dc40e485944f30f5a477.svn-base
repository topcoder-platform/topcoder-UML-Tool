/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.xmi.writer.XMITransformException;

/**
 * <p>
 * This is a mock implementation of <code>DiagramInterchangeElementTransformer</code> interface used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockDiagramInterchangeElementTransformer implements DiagramInterchangeElementTransformer {
    /**
     * <p>
     * The Node instance used for testing.
     * </p>
     */
    private Node node = null;

    /**
     * <p>
     * Represent the tagName of the Node to transform to.
     * </p>
     */
    private String tagName = "UMLTest";

    /**
     * <p>
     * The Object instance used for testing.
     * </p>
     */
    private Object element;

    /**
     * <p>
     * The Document instance used for testing.
     * </p>
     */
    private Document document;

    /**
     * <p>
     * A boolean indicating whether to throw an XMITransformException.
     * </p>
     */
    private boolean isThrowXMITransformException = false;

    /**
     * <p>
     * A boolean indicating whether to throw a ClassCastException.
     * </p>
     */
    private boolean isThrowClassCastException = false;

    /**
     * <p>
     * Transforms a given element into an XML Node, given the element and document the node is to be from.
     * </p>
     *
     * @param element Element to transform into XMI Node
     * @param document Document that the node is to originate from.
     * @param caller The diagram2XMITransformer instance calling this transformer's method
     *
     * @return A single XML Node containing the element's XMI representation.
     *
     * @throws IllegalArgumentException If null parameters are provided, but disallowed by an implementing class.
     * @throws ClassCastException If the element provided isn't of the right type
     * @throws XMITransformException If there are problems writing the XMI Node.
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        if (element == null) {
            throw new IllegalArgumentException("The element should not be null.");
        }
        if (document == null) {
            throw new IllegalArgumentException("The document should not be null.");
        }
        this.element = element;
        this.document = document;
        if (isThrowXMITransformException) {
            throw new XMITransformException("An XMITransformException is thrown for testing.");
        }
        if (isThrowClassCastException) {
            throw new ClassCastException("A ClassCastException is thrown for testing.");
        }
        node = document.createElement(tagName);
        return node;
    }

    /**
     * <p>
     * Get the Node instance.
     * </p>
     *
     * @return the node instance.
     */
    public Node getNode() {
        return node;
    }

    /**
     * <p>
     * Get the tagName of the node.
     * </p>
     *
     * @return a string representing the tagName of the node.
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * <p>
     * Get the element object.
     * </p>
     *
     * @return the element object.
     */
    public Object getElement() {
        return element;
    }

    /**
     * <p>
     * Set the document.
     * </p>
     *
     * @return the document
     */
    public Object getDocument() {
        return document;
    }

    /**
     * <p>
     * Set whether to throw a ClassCastException.
     * </p>
     *
     * @param isThrow a boolean indicating whether to throw a ClassCastException.
     */
    public void setIsThrowClassCastException(boolean isThrow) {
        isThrowClassCastException = isThrow;
    }

    /**
     * <p>
     * Set whether to throw a XMITransformException.
     * </p>
     *
     * @param isThrow a boolean indicating whether to throw an XMITransformException.
     */
    public void setIsThrowXMITransformException(boolean isThrow) {
        isThrowXMITransformException = isThrow;
    }
}
