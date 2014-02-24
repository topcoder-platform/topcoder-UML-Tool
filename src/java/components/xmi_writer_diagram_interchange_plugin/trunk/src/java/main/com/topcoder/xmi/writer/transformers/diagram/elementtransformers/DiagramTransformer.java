/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>Diagram</code> class.
 * </p>
 * <p>
 * <code>DiagramTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code> interface.
 * It is used to convert the instance of the <code>Diagram</code> class into their XMI representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:Diagram name=&quot;name&quot; visible=&quot;false&quot;
 *      xmi.id=&quot;72ee062d-bd41-4ca8-bfe1-2e099c8a745e&quot; zoom=&quot;10.0&quot;&gt;
 *     &lt;UML:Diagram.viewport&gt;
 *         &lt;UML:Point x=&quot;10.0&quot; y=&quot;100.0&quot;/&gt;
 *     &lt;/UML:Diagram.viewport&gt;
 *     &lt;UML:Diagram.owner&gt;
 *         &lt;UML:SemanticModelBridge presentation=&quot;semanticPresentation&quot;
 *              xmi.id=&quot;2be0967f-3c68-47e5-b10e-607e804bb85a&quot;/&gt;
 *     &lt;/UML:Diagram.owner&gt;
 *     &lt;UML:GraphElement.link&gt;
 *         &lt;UML:DiagramLink xmi.id=&quot;ae88ca3f-f616-4b98-81b0-4b0b79081577&quot; zoom=&quot;0.0&quot;&gt;
 *             ...
 *         &lt;/UML:DiagramLink&gt;
 *         &lt;UML:DiagramLink xmi.id=&quot;c9031982-2b61-4534-83d5-0c5f36953f2b&quot; zoom=&quot;0.0&quot;&gt;
 *             ...
 *         &lt;/UML:DiagramLink&gt;
 *         ...
 *     &lt;/UML:GraphElement.link&gt;
 *     ...
 * &lt;/UML:Diagram&gt;
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
public class DiagramTransformer extends GraphNodeTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public  DiagramTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>Diagram</code> class into their XMI representation.
     * The element given must be able to be cast to a non-null <code>Diagram</code>, otherwise an exception is thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:Diagram name=&quot;name&quot; visible=&quot;false&quot;
     *      xmi.id=&quot;72ee062d-bd41-4ca8-bfe1-2e099c8a745e&quot; zoom=&quot;10.0&quot;&gt;
     *     &lt;UML:Diagram.viewport&gt;
     *         &lt;UML:Point x=&quot;10.0&quot; y=&quot;100.0&quot;/&gt;
     *     &lt;/UML:Diagram.viewport&gt;
     *     &lt;UML:Diagram.owner&gt;
     *         &lt;UML:SemanticModelBridge presentation=&quot;semanticPresentation&quot;
     *              xmi.id=&quot;2be0967f-3c68-47e5-b10e-607e804bb85a&quot;/&gt;
     *     &lt;/UML:Diagram.owner&gt;
     *     &lt;UML:GraphElement.link&gt;
     *         &lt;UML:DiagramLink xmi.id=&quot;ae88ca3f-f616-4b98-81b0-4b0b79081577&quot; zoom=&quot;0.0&quot;&gt;
     *             ...
     *         &lt;/UML:DiagramLink&gt;
     *         &lt;UML:DiagramLink xmi.id=&quot;c9031982-2b61-4534-83d5-0c5f36953f2b&quot; zoom=&quot;0.0&quot;&gt;
     *             ...
     *         &lt;/UML:DiagramLink&gt;
     *         ...
     *     &lt;/UML:GraphElement.link&gt;
     *     ...
     * &lt;/UML:Diagram&gt;
     * </pre>
     * </p>
     *
     * @param element DiagramInterchange Element to transform to a node of XMI. It should not be null.
     * @param document XML Document the Node is to be created from
     * @param caller The Diagram2XMITransformer instance calling this transformer's method
     *
     * @return XML Node containing XMI representation of the given element
     *
     * @throws IllegalArgumentException if either input object is null
     * @throws ClassCastException if the element parameter cannot be cast to a Diagram
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        Diagram diagram = (Diagram) element;
        StructureXMLNode node = new StructureXMLNode("UML:Diagram", document, caller);
        // set the attributes
        node.setXmiId(diagram);
        node.setAttribute("visible", String.valueOf(diagram.isVisible()));
        node.setAttribute("name", diagram.getName());
        node.setAttribute("zoom", String.valueOf(diagram.getZoom()));
        // append the viewport node
        node.appendChild("UML:Diagram.viewport", diagram.getViewport());
        // append the owner node
        node.appendChild("UML:Diagram.owner", diagram.getOwner());
        // append the diagraimLink nodes
        node.appendRefChildren("UML:Diagram.diagramLink", "UML:DiagramLink", diagram.getDiagramLinks());
        // append nodes from the superclass node's children
        node.appendChildren(super.transform(diagram, document, caller));

        // return the XML Node
        return node.getNode();
    }
}
