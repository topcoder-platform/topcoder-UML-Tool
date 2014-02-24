/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>GraphConnector</code> class.
 * </p>
 * <p>
 * <code>GraphConnectorTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code> interface.
 * It is used to convert the instance of the <code>GraphConnector</code> class into their XMI representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:GraphConnector xmi.id=&quot;41cbdd4d-ff1e-4470-8537-97dffd819398&quot;&gt;
 *     &lt;UML:GraphConnector.position&gt;
 *         &lt;UML:Point x=&quot;0.0&quot; y=&quot;0.0&quot;/&gt;
 *     &lt;/UML:GraphConnector.position&gt;
 *     &lt;UML:GraphConnector.graphEdge&gt;
 *         &lt;UML:GraphEdge xmi.idref=&quot;14f29884-48b4-41d6-9357-1963eda4bc1f&quot;&gt;
 *             ...
 *         &lt;/UML:GraphEdge&gt;
 *         &lt;UML:GraphEdge xmi.idref=&quot;d6671500-a094-45e9-a550-f1dc9f875fb4&quot;&gt;
 *             ...
 *         &lt;/UML:GraphEdge&gt;
 *         ...
 *     &lt;/UML:GraphConnector.graphEdge&gt;
 * &lt;/UML:GraphConnector&gt;
 * </pre>
 * </p>
 * <p>
 * <b>Thread-safety:</b>
 * This class does not handle its own thread safety, it is possible the document and element objects may be altered
 * by other threads during execution. It does however not modify the element in any way, and only uses the document to
 * create XML elements.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public class GraphConnectorTransformer implements DiagramInterchangeElementTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public GraphConnectorTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>GraphConnector</code> class into their XMI representation.
     * The element given must be able to be cast to a non-null <code>GraphConnector</code>, otherwise an exception is
     * thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:GraphConnector xmi.id=&quot;41cbdd4d-ff1e-4470-8537-97dffd819398&quot;&gt;
     *     &lt;UML:GraphConnector.position&gt;
     *         &lt;UML:Point x=&quot;0.0&quot; y=&quot;0.0&quot;/&gt;
     *     &lt;/UML:GraphConnector.position&gt;
     *     &lt;UML:GraphConnector.graphEdge&gt;
     *         &lt;UML:GraphEdge xmi.idref=&quot;14f29884-48b4-41d6-9357-1963eda4bc1f&quot;&gt;
     *             ...
     *         &lt;/UML:GraphEdge&gt;
     *         &lt;UML:GraphEdge xmi.idref=&quot;d6671500-a094-45e9-a550-f1dc9f875fb4&quot;&gt;
     *             ...
     *         &lt;/UML:GraphEdge&gt;
     *         ...
     *     &lt;/UML:GraphConnector.graphEdge&gt;
     * &lt;/UML:GraphConnector&gt;
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
     * @throws ClassCastException if the element parameter cannot be cast to a GraphConnector
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        GraphConnector graphConnector = (GraphConnector) element;
        StructureXMLNode node = new StructureXMLNode("UML:GraphConnector", document, caller);
        node.setXmiId(graphConnector);
        // append the position node
        node.appendChild("UML:GraphConnector.position", graphConnector.getPosition());
        // append the GraphEdges as reference nodes
        node.appendRefChildren("UML:GraphConnector.graphEdge", "UML:GraphEdge", graphConnector.getGraphEdges());
        return node.getNode();
    }
}
