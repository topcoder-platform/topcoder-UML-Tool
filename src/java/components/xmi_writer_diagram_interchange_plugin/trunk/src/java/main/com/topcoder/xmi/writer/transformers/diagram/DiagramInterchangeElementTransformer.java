/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.xmi.writer.XMITransformException;

/**
 * <p>
 * Interface that defines the contract for specific Element transformers within the Diagram Interchange writer
 * component.
 * </p>
 * <p>
 * Classes that implement this interface are used to convert objects of a single type of class into their XMI
 * representation. This is performed by the transform method, taking the element and XML document, and returning a Node
 * of XML that conforms to the XSD for the given object.
 * </p>
 * <p><b>Thread-safety:</b>
 * Implementations of this class are not required to be threadsafe.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public interface DiagramInterchangeElementTransformer {
    /**
     * <p>
     * Transforms a given element into an XML Node, given the element and document the node is to be from.
     * </p>
     * <p>
     * This is performed by taking the element and XML document, and returning a Node of XML that conforms to the XSD
     * for the given object.
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
        throws XMITransformException;
}


