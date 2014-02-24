/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import java.util.Collection;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;

/**
 * <p>
 * This is an XML node for a transformer based on the XMI structure.
 * </p>
 *
 * <p>
 * The main purpose of this class is to make generating an XMI node more easier. It encapsulates the complex
 * operations, such setting an attribute, adding a child node, and also it handles the exceptions within the
 * operations by wrapping the exceptions to XMITransformException.
 * </p>
 *
 * <p>
 * Note, this class is package private and so it is only used to the classes under the
 * same package and is private for other packages.
 * </p>
 *
 * <p>
 * Thread Safety : this class is mutable and so is not thread safe.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class StructureXMLNode {

    /**
     * <p>
     * Represent the root element of this XML node.
     * </p>
     *
     * <p>
     * It can not be null, and will be initialized on the constructor.
     * </p>
     */
    private final Element root;

    /**
     * <p>
     * Represent the document that the node is to be created from
     * </p>
     *
     * <p>
     * It can not be null, and will be initialized on the constructor.
     * </p>
     */
    private final Document document;

    /**
     * <p>
     * The Diagram2XMITransformer instance calling the transformer's method
     * </p>
     *
     * <p>
     * It can not be null, and will be initialized on the constructor.
     * </p>
     */
    private final Diagram2XMITransformer caller;

    /**
     * <p>
     * Create a StructureXMLNode instance with its tagName and the document that it is to be created from specified.
     * </p>
     * <p>
     * Either given object can not be null.
     * </p>
     * <p>
     * Note, this constructor is package private.
     * </p>
     *
     * @param tagName the name of the rootElemnt of this XML node
     * @param document XML Document the Node is to be created from
     * @param caller The Diagram2XMITransformer instance calling this transformer's method
     *
     * @throws XMITransformException if fail to create a new XML node
     * @throws IllegalArgumentException if either given object is null
     */
    StructureXMLNode(String tagName, Document document, Diagram2XMITransformer caller) throws XMITransformException {
        Helper.checkNotNull(tagName, "The name of element.");
        Helper.checkNotNull(document, "The XML Document the Node is to be created from.");
        Helper.checkNotNull(caller, "The Diagram2XMITransformer instance.");
        this.document = document;
        this.caller = caller;
        try {
            root = document.createElement(tagName);
        } catch (DOMException de) {
            // wrap DOMException to an XMITransformException and throw it
            throw new XMITransformException("Fail to create a new XML node caused by " + de.getMessage(), de);
        }
    }

    /**
     * <p>
     * Add a attribute of the node.
     * </p>
     * <p>
     * If the value is null, simply return.
     * </p>
     * <p>
     * Note, this method is package private.
     * </p>
     *
     * @param name The name of the attribute to set.
     * @param value Value to set in string form, it cannot not be null
     *
     * @throws XMITransformException if any exception occurs while setting the attribute
     */
    void setAttribute(String name, String value) throws XMITransformException {
        if (value == null) {
            return;
        }
        // add the attributes.
        try {
            root.setAttribute(name, value);
        } catch (DOMException de) {
            // wrap DOMException to an XMITransformException and throw it
            throw new XMITransformException("Fail to set the attribute - '" + name + "' caused by "
                    + de.getMessage(), de);
        }
    }

    /**
     * <p>
     * Set the 'xmi.id' attribute of the node using the id resolved of the element.
     *
     * </p>
     * <p>
     * It uses <code>resolveID(element)</code> method of the Diagram2XMITransformer instance of this StructureXMLNode.
     * If the 'xmi.id' of the element could not be obtained, an XMITransformException will be thrown.
     * </p>
     * <p>
     * Note, this method is package private.
     * </p>
     *
     * @param element Element used to get the xmi.id
     *
     * @throws XMITransformException if any exception occurs while setting the attribute or if the 'xmi.id' of the
     *      element could not be obtained
     */
    void setXmiId(Object element) throws XMITransformException {
        String xmiId = caller.resolveID(element);
        if (xmiId == null) {
            throw new XMITransformException("Fail to obtain the xmi.id for the element.");
        }
        // add the attributes.
        try {
            root.setAttribute("xmi.id", xmiId);
        } catch (DOMException de) {
            // wrap DOMException to an XMITransformException and throw it
            throw new XMITransformException("Fail to set the attribute : 'xmi.id', caused by "
                    + de.getMessage(), de);
        }
    }

    /**
     * <p>
     * Append the object element as a child node with its tagName specified.
     * </p>
     * <p>
     * It will create a new Element using the tagName provided, and append the XML node which transforms from
     * the element provided using the Diagram2XMITransformer instance to the root node.
     * If the element is null, simply return null.
     * </p>
     * <p>
     * Note, this method is package private.
     * </p>
     * @param tagName a string representing the name of the child node
     * @param element the object element to add as the child node
     *
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    void appendChild(String tagName, Object element) throws XMITransformException {
        if (element == null) {
            return;
        }
        // append it
        try {
            Element tmp = document.createElement(tagName);
            tmp.appendChild(createChildNode(element));
            root.appendChild(tmp);
        } catch (DOMException de) {
            // wrap DOMException to an XMITransformException and throw it
            throw new XMITransformException("Fail to append the child caused by : " + de.getMessage(), de);
        }
    }


    /**
     * <p>
     * Append a list of the elements as the child nodes to a child node created using the tagName specified.
     * </p>
     * <p>
     * It will first create a new Node with the tagName specified, and append every element of the list
     * to the it, and at last append it to the root node.
     * </p>
     * <p>
     * If the elementList is null or empty, simply return. or if the elementList contains a null value,
     * an XMITransformException will be thrown.
     * </p>
     * <p>
     * Note, this method is package private.
     * </p>
     * @param tagName a string representing the name of the child node
     * @param elementList a list containing the elements(non-null) to add
     *
     * @throws XMITransformException if there are problems writing the XMI information to a Node, or if the
     *      elementList contains null value
     */
    void appendChildren(String tagName, Collection elementList) throws XMITransformException {
        // simply return if no element to add
        if (elementList == null || elementList.isEmpty()) {
            return;
        }
        // the elements to add are always not null
        checkCollectionContainNotNull(elementList);
        try {
            Element tmp = document.createElement(tagName);
            // append the list
            for (Object element : elementList) {
                tmp.appendChild(createChildNode(element));
            }
            root.appendChild(tmp);
        } catch (DOMException de) {
            // wrap DOMException to an XMITransformException and throw it
            throw new XMITransformException("Fail to append the child caused by : " + de.getMessage(), de);
        }
    }

    /**
     * <p>
     * Create a XML node instance using the object element.
     * </p>
     * <p>
     * It will create an XML node which transforms from the element provided using the Diagram2XMITransformer instance.
     * </p>
     * <p>
     * Note, this method is private.
     * </p>
     *
     * @param element the object element used to create the XML node, should not be null
     *
     * @return the XML node created
     *
     * @throws XMITransformException if there are problems in creating the Node
     */
    private Node createChildNode(Object element) throws XMITransformException {
        // append it
        try {
            // create a new XML node
            Node node = caller.transform(element, document);
            if (node == null) {
                throw new XMITransformException("Fail to transform the element to its XML representation.");
            }
            return node;
        } catch (UnknownElementException ue) {
            // wrap UnknownElementException to an XMITransformException and throw it
            throw new XMITransformException("There is no xmi-id defined for the requested element object : "
                    + ue.getElement(), ue);
        }
    }

    /**
     * <p>
     * Create a Node instance from the object element and the tagName. The node is a reference to another node and
     * contains a xmi.idref attribute.
     * </p>
     * <p>
     * It will create an XML node using the tagName, and set its xmi.idref attribute using the element.
     * The element should not be null.
     * </p>
     * <p>
     * Note, this method is private.
     * </p>
     *
     * @param tagName the name of the node to be created
     * @param element the object element used to set the 'xmi.idref' attribute of the node created.
     *
     * @return Node the XML node created
     *
     * @throws XMITransformException if fail to resolve the element
     * @throws DOMException if there are problems in creating the Node
     */
    private Node createRefChildNode(String tagName, Object element) throws XMITransformException {
        // append it
        Element docRef = document.createElement(tagName);
        // set the xmi.idref attribute and append it
        String id = caller.resolveID(element);
        // if fail to get the id for this element, an XMITransformException is thrown
        if (id == null) {
            throw new XMITransformException("Fail to resolve the id.");
        }
        docRef.setAttribute("xmi.idref", id);
        return docRef;
    }

    /**
     * <p>
     * Append the object element as a child node with the tagName of its parent not and its refTagName specified.
     * The child node is a reference to the element.
     * </p>
     * <p>
     * It will create a new element using the tagName provided and a new refElement using the refTagName, set the
     * xmi.idref attribute of the refElement and append the refElement to the element. At last let the element to
     * be a child node of the root node.
     * </p>
     * <p>
     * If the element is null, simply return.
     * </p>
     * <p>
     * Note, this method is package private.
     * </p>
     * @param tagName a string representing the name of the child node
     * @param refTagName a string representing the name of the grandchild node
     * @param element the object element to add as the child node
     *
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    void appendRefChild(String tagName, String refTagName, Object element) throws XMITransformException {
        if (element == null) {
            return;
        }
        try {
            // create a new XML node
            Element tmp = document.createElement(tagName);
            tmp.appendChild(createRefChildNode(refTagName, element));
            root.appendChild(tmp);
        } catch (DOMException de) {
            // wrap DOMException to an XMITransformException and throw it
            throw new XMITransformException("Some problems occur in appending the child caused by : "
                    + de.getMessage(), de);
        }
    }

    /**
     * <p>
     * Append a list of the element as the grandchild nodes with the tagName of their parent node and their refTagName
     * specified.
     * </p>
     * <p>
     * It will first create a Element using the tagName, and append every element of the list to it as child nodes
     * which are references to the element using the same refTagName, at last append it to the root node.
     * If the elementList is null or empty, simply return;
     * </p>
     * <p>
     * Note, this method is package private.
     * </p>
     * @param tagName a string representing the name of the child node
     * @param refTagName a string representing the name of the child node of the node to add
     * @param elementList the list of elements to add as the grandchild nodes
     *
     * @throws XMITransformException if there are problems writing the XMI information to a Node, or the elementList
     *                            contains null value
     */
    void appendRefChildren(String tagName, String refTagName, Collection elementList) throws XMITransformException {
        if (elementList == null || elementList.isEmpty()) {
            return;
        }
        // the elements to add are always not null
        checkCollectionContainNotNull(elementList);
        // append the list
        try {
            // create a new XML node
            Element tmp = document.createElement(tagName);
            for (Object element : elementList) {
                tmp.appendChild(createRefChildNode(refTagName, element));
            }
            root.appendChild(tmp);
        } catch (DOMException de) {
            // wrap DOMException to an XMITransformException and throw it
            throw new XMITransformException("Some problems occur in appending the child caused by : "
                    + de.getMessage(), de);
        }
    }


    /**
     * <p>
     * Append all the child nodes from another node specified.
     * </p>
     * <p>
     * Note that all the child nodes to add will be removed from their original parent node.
     * </p>
     * <p>
     * Note, this method is package private.
     * </p>
     * @param parentNode the node whose child nodes to add
     *
     * @throws XMITransformException if there are problems appending the child nodes.
     */
    void appendChildren(Node parentNode) throws XMITransformException {
        Node node = parentNode.getFirstChild();
        // since If the new node is already in the tree, it is first removed,
        // so we only need to add its first child node.
        try {
            while (node != null) {
                root.appendChild(node);
                node = parentNode.getFirstChild();
            }
        } catch (DOMException de) {
            // wrap DOMException to an XMITransformException and throw it
            throw new XMITransformException("Some problems occur in appending the child caused by : "
                    + de.getMessage(), de);
        }
    }

    /**
     * <p>
     * Check the collection contains no null value, otherwise an XMITransformException will be thrown.
     * </p>
     *
     * @param list the collection to check
     *
     * @throws XMITransformException if the list contains null value
     */
    private void checkCollectionContainNotNull(Collection list) throws XMITransformException {
        if (list.contains(null)) {
            throw new XMITransformException("The list should not contain null object.");
        }
    }

    /**
     * <p>
     * Get the root node of this StructureXMLNode instance.
     * </p>
     * <p>
     * Note, this method is package private.
     * </p>
     * @return Node the internal root node of this StructureXMLNode
     */
    Node getNode() {
        return root;
    }
}
