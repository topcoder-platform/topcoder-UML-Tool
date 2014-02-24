/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>SemanticModelBridge</code> class.
 * </p>
 * <p>
 * <code>SemanticModelBridgeTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code>
 * interface. It is used to convert the instance of the <code>SemanticModelBridge</code> class into their XMI
 * representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:SemanticModelElement presentation=&quot;presentation&quot; xmi.id=&quot;65c02597-5d73-4a99&quot;/&gt;
 * </pre>
 * </p>
 * <p>
 * In addition, the default no-arg constructor is provided.
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
public class SemanticModelBridgeTransformer implements DiagramInterchangeElementTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public  SemanticModelBridgeTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>SemanticModelBridge</code> class into their XMI representation.
     * The element given must be able to be cast to a non-null <code>SemanticModelBridge</code>, otherwise an
     * exception is thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:SemanticModelBridge presentation="presentation" xmi.id="d5783986-0a1b-45f0-b164-e1dc2f3c50a7"/&gt;
     * </pre>
     * </p>
     * @param element DiagramInterchange Element to transform to a node of XMI. It should not be null.
     * @param document XML Document the Node is to be created from
     * @param caller The Diagram2XMITransformer instance calling this transformer's method
     *
     * @return XML Node containing XMI representation of the given element
     *
     * @throws IllegalArgumentException if either input object is null
     * @throws ClassCastException if the element parameter cannot be cast to a SemanticModelBridge
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        SemanticModelBridge semanticModel = (SemanticModelBridge) element;
        // create a new XML Node
        StructureXMLNode node = new StructureXMLNode("UML:SemanticModelBridge", document, caller);
        // set the attributes
        node.setXmiId(semanticModel);
        node.setAttribute("presentation", semanticModel.getPresentation());

        // return the XML Node
        return node.getNode();

    }
}
