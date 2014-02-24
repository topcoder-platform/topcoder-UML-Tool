/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>GraphEdge</code> class.
 * </p>
 * <p>
 * <code>GraphEdgeTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code> interface.
 * It is used to convert the instance of the <code>GraphEdge</code> class into their XMI representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:GraphEdge visible=&quot;false&quot; xmi.id=&quot;6a9eeab4-16cc-43eb-8b73-da9c56d9541a&quot;&gt;
 *     &lt;UML:GraphEdge.waypoints&gt;
 *         &lt;UML:Point x=&quot;10.0&quot; y=&quot;100.0&quot;/&gt;
 *     &lt;/UML:GraphEdge.waypoints&gt;
 *     &lt;UML:GraphEdge.anchor&gt;
 *         &lt;UML:GraphConnector xmi.idref=&quot;1f2b2c85-362e-45fd-ad19-6a5dc4d77ce6&quot;&gt;
 *             ...
 *         &lt;/UML:GraphConnector&gt;
 *         &lt;UML:GraphConnector xmi.idref=&quot;8d2916a8-e6f3-42d2-914d-2eefafbb9feb&quot;&gt;
 *             ...
 *         &lt;/UML:GraphConnector&gt;
 *         ...
 *     &lt;/UML:GraphEdge.anchor&gt;
 *     ...
 * &lt;/UML:GraphEdge&gt;
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
public class GraphEdgeTransformer extends GraphElementTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public  GraphEdgeTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>GraphEdge</code> class into their XMI representation.
     * The element given must be able to be cast to a non-null <code>GraphEdge</code>, otherwise an exception is
     * thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:GraphEdge visible=&quot;false&quot; xmi.id=&quot;6a9eeab4-16cc-43eb-8b73-da9c56d9541a&quot;&gt;
     *     &lt;UML:GraphEdge.waypoints&gt;
     *         &lt;UML:Point x=&quot;10.0&quot; y=&quot;100.0&quot;/&gt;
     *     &lt;/UML:GraphEdge.waypoints&gt;
     *     &lt;UML:GraphEdge.anchor&gt;
     *         &lt;UML:GraphConnector xmi.idref=&quot;1f2b2c85-362e-45fd-ad19-6a5dc4d77ce6&quot;&gt;
     *             ...
     *         &lt;/UML:GraphConnector&gt;
     *         &lt;UML:GraphConnector xmi.idref=&quot;8d2916a8-e6f3-42d2-914d-2eefafbb9feb&quot;&gt;
     *             ...
     *         &lt;/UML:GraphConnector&gt;
     *         ...
     *     &lt;/UML:GraphEdge.anchor&gt;
     *     ...
     * &lt;/UML:GraphEdge&gt;
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
     * @throws ClassCastException if the element parameter cannot be cast to a GraphEdge
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        GraphEdge graphEdge = (GraphEdge) element;
        // create a new XML Node
        StructureXMLNode node = new StructureXMLNode("UML:GraphEdge", document, caller);
        // set the attribute
        node.setXmiId(graphEdge);
        node.setAttribute("visible", String.valueOf(graphEdge.isVisible()));
        // append the waypoints from this GraphEdge
        node.appendChildren("UML:GraphEdge.waypoints", graphEdge.getWaypoints());
        // append the anchors of this GraphEdge as references
        node.appendRefChildren("UML:GraphEdge.anchor", "UML:GraphConnector", graphEdge.getAnchors());
        // append nodes from the superclass node's children
        node.appendChildren(super.transform(graphEdge, document, caller));
        // return the XML Node.
        return node.getNode();
    }
}
