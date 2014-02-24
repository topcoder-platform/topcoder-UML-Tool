/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>GraphElement</code> class.
 * </p>
 * <p>
 * <code>GraphElementTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code> interface.
 * It is used to convert the instance of the <code>GraphElement</code> class into their XMI representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:GraphElement visible=&quot;false&quot; xmi.id=&quot;2c61afea-d9cb-4dbd-82b0-f2a22071f590&quot;&gt;
 *     &lt;UML:GraphElement.position&gt;
 *         &lt;UML:Point x=&quot;10.0&quot; y=&quot;100.0&quot;/&gt;
 *     &lt;/UML:GraphElement.position&gt;
 *     &lt;UML:GraphElement.anchorage&gt;
 *         &lt;UML:GraphConnector xmi.id=&quot;e9d02967-524d-44c2-84ba-3d39eafa42c5&quot;&gt;
 *             ...
 *         &lt;/UML:GraphConnector&gt;
 *         &lt;UML:GraphConnector xmi.id=&quot;a044517c-3565-4f8c-bf2b-5803788e2324&quot;&gt;
 *             ...
 *         &lt;/UML:GraphConnector&gt;
 *         ...
 *     &lt;/UML:GraphElement.anchorage&gt;
 *     &lt;UML:GraphElement.contained&gt;
 *         &lt;UML:DiagramElement visible=&quot;true&quot; xmi.id=&quot;a722d3b0-704c-44e1-a482-c62c0f6afc4c&quot;&gt;
 *             ...
 *         &lt;/UML:DiagramElement&gt;
 *         &lt;UML:DiagramElement visible=&quot;true&quot; xmi.id=&quot;a28d450e-90ae-4075-b214-6339e2d72ab9&quot;&gt;
 *             ...
 *         &lt;/UML:DiagramElement&gt;
 *         ...
 *     &lt;/UML:GraphElement.contained&gt;
 *     &lt;UML:GraphElement.semanticModel&gt;
 *         &lt;UML:SimpleSemanticModelElement xmi.id=&quot;6eb9e52c-0557-4f74-9353-e292fa2c4282&quot;/&gt;
 *     &lt;/UML:GraphElement.semanticModel&gt;
 *     &lt;UML:GraphElement.link&gt;
 *         &lt;UML:DiagramLink xmi.id=&quot;6e515f4a-2224-49ef-beb4-a882eab49dad&quot; zoom=&quot;0.0&quot;&gt;
 *             ...
 *         &lt;/UML:DiagramLink&gt;
 *         &lt;UML:DiagramLink xmi.id=&quot;662064be-6901-43b2-ba8e-ba53a714f39a&quot; zoom=&quot;0.0&quot;&gt;
 *             ...
 *         &lt;/UML:DiagramLink&gt;
 *         ...
 *     &lt;/UML:GraphElement.link&gt;
 *     ...
 * &lt;/UML:GraphElement&gt;
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
public class GraphElementTransformer extends DiagramElementTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public  GraphElementTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>GraphElement</code> class into their XMI representation.
     * The element given must be able to be cast to a non-null <code>GraphElement</code>, otherwise an exception is
     * thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:GraphElement visible=&quot;false&quot; xmi.id=&quot;2c61afea-d9cb-4dbd-82b0-f2a22071f590&quot;&gt;
     *     &lt;UML:GraphElement.position&gt;
     *         &lt;UML:Point x=&quot;10.0&quot; y=&quot;100.0&quot;/&gt;
     *     &lt;/UML:GraphElement.position&gt;
     *     &lt;UML:GraphElement.anchorage&gt;
     *         &lt;UML:GraphConnector xmi.id=&quot;e9d02967-524d-44c2-84ba-3d39eafa42c5&quot;&gt;
     *             ...
     *         &lt;/UML:GraphConnector&gt;
     *         &lt;UML:GraphConnector xmi.id=&quot;a044517c-3565-4f8c-bf2b-5803788e2324&quot;&gt;
     *             ...
     *         &lt;/UML:GraphConnector&gt;
     *         ...
     *     &lt;/UML:GraphElement.anchorage&gt;
     *     &lt;UML:GraphElement.contained&gt;
     *         &lt;UML:DiagramElement visible=&quot;true&quot;
     *              xmi.id=&quot;a722d3b0-704c-44e1-a482-c62c0f6afc4c&quot;&gt;
     *             ...
     *         &lt;/UML:DiagramElement&gt;
     *         &lt;UML:DiagramElement visible=&quot;true&quot;
     *              xmi.id=&quot;a28d450e-90ae-4075-b214-6339e2d72ab9&quot;&gt;
     *             ...
     *         &lt;/UML:DiagramElement&gt;
     *         ...
     *     &lt;/UML:GraphElement.contained&gt;
     *     &lt;UML:GraphElement.semanticModel&gt;
     *         &lt;UML:SimpleSemanticModelElement xmi.id=&quot;6eb9e52c-0557-4f74-9353-e292fa2c4282&quot;/&gt;
     *     &lt;/UML:GraphElement.semanticModel&gt;
     *     &lt;UML:GraphElement.link&gt;
     *         &lt;UML:DiagramLink xmi.id=&quot;6e515f4a-2224-49ef-beb4-a882eab49dad&quot; zoom=&quot;0.0&quot;&gt;
     *             ...
     *         &lt;/UML:DiagramLink&gt;
     *         &lt;UML:DiagramLink xmi.id=&quot;662064be-6901-43b2-ba8e-ba53a714f39a&quot; zoom=&quot;0.0&quot;&gt;
     *             ...
     *         &lt;/UML:DiagramLink&gt;
     *         ...
     *     &lt;/UML:GraphElement.link&gt;
     *     ...
     * &lt;/UML:GraphElement&gt;
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
     * @throws ClassCastException if the element parameter cannot be cast to a GraphElement
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        GraphElement graphElement = (GraphElement) element;
        // create a new StructureXMLNode Node
        StructureXMLNode node = new StructureXMLNode("UML:GraphElement", document, caller);
        // set the attributes
        node.setXmiId(graphElement);
        node.setAttribute("visible", String.valueOf(graphElement.isVisible()));
         // append the position node.
        node.appendChild("UML:GraphElement.position", graphElement.getPosition());
        // append the anchorage node
        node.appendChildren("UML:GraphElement.anchorage", graphElement.getAnchorages());
        // append the DiagramElements contained in this GraphElement
        node.appendChildren("UML:GraphElement.contained", graphElement.getContaineds());
        // append the SemanticModelBridge node if it is not null
        node.appendChild("UML:GraphElement.semanticModel", graphElement.getSemanticModel());
        // append the DiagramLinks of this GraphElement
        node.appendChildren("UML:GraphElement.link", graphElement.getLinks());
        // append nodes from the superclass node's children
        node.appendChildren(super.transform(graphElement, document, caller));
        // return the XML Node.
        return node.getNode();
    }
}
