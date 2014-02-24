/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>DiagramLink</code> class.
 * </p>
 * <p>
 * <code>DiagramLinkTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code> interface.
 * It is used to convert the instance of the <code>DiagramLink</code> class into their XMI representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:DiagramLink xmi.id=&quot;2c85a625-bb61-4e55-a15d-0787d260e583&quot; zoom=&quot;100.0&quot;&gt;
 *      &lt;UML:DiagramLink.viewport&gt;
 *          &lt;UML:Point x=&quot;0.0&quot; y=&quot;0.0&quot;/&gt;
 *      &lt;/UML:DiagramLink.viewport&gt;
 *      &lt;UML:DiagramLink.diagram&gt;
 *          &lt;UML:Diagram xmi.idref=&quot;63be443a-60e0-4d68-b1e3-f908320ac925&quot;/&gt;
 *      &lt;/UML:DiagramLink.diagram&gt;
 *      ...
 * &lt;/UML:DiagramLink&gt;
 * </pre>
 * </p>
 * <p>
 * <b>Thread-safety:</b>
 * This class does not handle its own thread safety, it is possible the document and element
 * objects may be altered by other threads during execution. It does however not modify the element in any way, and
 * only uses the document to create XML elements.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public class DiagramLinkTransformer implements DiagramInterchangeElementTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public DiagramLinkTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>DiagramLink</code> class into their XMI representation.
     * The element given must be able to be cast to a non-null <code>DiagramLink</code>, otherwise an exception is
     * thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:DiagramLink xmi.id=&quot;2c85a625-bb61-4e55-a15d-0787d260e583&quot; zoom=&quot;100.0&quot;&gt;
     *      &lt;UML:DiagramLink.viewport&gt;
     *          &lt;UML:Point x=&quot;0.0&quot; y=&quot;0.0&quot;/&gt;
     *      &lt;/UML:DiagramLink.viewport&gt;
     *      &lt;UML:DiagramLink.diagram&gt;
     *          &lt;UML:Diagram xmi.idref=&quot;63be443a-60e0-4d68-b1e3-f908320ac925&quot;/&gt;
     *      &lt;/UML:DiagramLink.diagram&gt;
     *      ...
     * &lt;/UML:DiagramLink&gt;
     * </pre>
     * </p>
     * @param element DiagramInterchange Element to transform to a node of XMI. It should not be null.
     * @param document XML Document the Node is to be created from
     * @param caller The Diagram2XMITransformer instance calling this transformer's method
     *
     * @return XML Node containing XMI representation of the given element
     *
     * @throws IllegalArgumentException if either input object is null
     * @throws ClassCastException if the element parameter cannot be cast to a DiagramLink
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkNotNull(element, "The Element to transform to its XML representation.");
        DiagramLink diagramLink = (DiagramLink) element;
        // create a new XML Node
        StructureXMLNode node = new StructureXMLNode("UML:DiagramLink", document, caller);
        // set the attributes
        node.setXmiId(diagramLink);
        node.setAttribute("zoom", String.valueOf(diagramLink.getZoom()));

        // append diagramLink's viewport
        node.appendChild("UML:DiagramLink.viewport", diagramLink.getViewport());

        // append diagramLink's diagram
        node.appendRefChild("UML:DiagramLink.diagram", "UML:Diagram", diagramLink.getDiagram());

        // return the XML Node
        return node.getNode();
    }
}
