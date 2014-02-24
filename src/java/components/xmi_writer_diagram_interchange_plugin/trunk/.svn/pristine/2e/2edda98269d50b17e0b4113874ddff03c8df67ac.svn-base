/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.Element;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>Uml1SemanticModelBridge</code> class.
 * </p>
 * <p>
 * <code>Uml1SemanticModelBridgeTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code>
 * interface. It is used to convert the instance of the <code>Uml1SemanticModelBridge</code> class into their XMI
 * representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:Uml1SemanticModelBridge presentation=&quot;presentation&quot; xmi.id=&quot;9fcfd4c0-eba9-45aa&quot;&gt;
 *      &lt;UML:Uml1SemanticModelBridge.element&gt;
 *          &lt;UML:SampleElement xmi.idref=&quot;26b0c7e9-1ba0-48a5-86b5-ae795c0cc326&quot;/&gt;
 *      &lt;/UML:Uml1SemanticModelBridge.element&gt;
 * &lt;/UML:Uml1SemanticModelBridge&gt;
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
public class Uml1SemanticModelBridgeTransformer extends SemanticModelBridgeTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public  Uml1SemanticModelBridgeTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>Uml1SemanticModelBridge</code> class into their XMI
     * representation.The element given must be able to be cast to a non-null <code>Uml1SemanticModelBridge</code>,
     * otherwise an exception is thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:Uml1SemanticModelBridge presentation=&quot;presentation&quot; xmi.id=&quot;9fcfd4c0-eba9-45aa&quot;&gt;
     *      &lt;UML:Uml1SemanticModelBridge.element&gt;
     *          &lt;UML:SampleElement xmi.idref=&quot;26b0c7e9-1ba0-48a5-86b5-ae795c0cc326&quot;/&gt;
     *      &lt;/UML:Uml1SemanticModelBridge.element&gt;
     * &lt;/UML:Uml1SemanticModelBridge&gt;
     * </pre>
     * </p>
     * @param element DiagramInterchange Element to transform to a node of XMI. It should not be null.
     * @param document XML Document the Node is to be created from
     * @param caller The Diagram2XMITransformer instance calling this transformer's method
     *
     * @return XML Node containing XMI representation of the given element
     *
     * @throws IllegalArgumentException if either input object is null
     * @throws ClassCastException if the element parameter cannot be cast to a Uml1SemanticModelBridge
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        Uml1SemanticModelBridge umlModelElement = (Uml1SemanticModelBridge) element;
        // create a new XML Node
        StructureXMLNode node = new StructureXMLNode("UML:Uml1SemanticModelBridge", document, caller);
        // set the attributes
        node.setXmiId(umlModelElement);
        node.setAttribute("presentation", umlModelElement.getPresentation());
        String tagName;
        Element elt = umlModelElement.getElement();
        // currently we get the tagName of the element from caller.getTagName(String className)
        if (elt != null) {
            try {
                tagName = caller.getTagName(elt.getClass().getName());
            } catch (UnknownElementException e) {
                throw new XMITransformException("Unknown element, Could not find its tagName.");
            }
            if (tagName == null) {
                throw new XMITransformException("Errors occur silently while getting the tagName for the element.");
            }
            node.appendRefChild("UML:Uml1SemanticModelBridge.element", tagName, elt);
        }
        // append the child nodes from super class
        node.appendChildren(super.transform(element, document, caller));
        // return the XML Node
        return node.getNode();
    }
}
