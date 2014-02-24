/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.Reference;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>Reference</code> class.
 * </p>
 * <p>
 * <code>ReferenceTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code> interface.
 * It is used to convert the instance of the <code>Reference</code> class into their XMI representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:Reference isIndividualRepresentation=&quot;false&quot;
 *      xmi.id=&quot;f02d498c-7ae1-42b3-9668-62aea91440f6&quot;&gt;
 *      &lt;UML:DiagramLink.referenced&gt;
 *          &lt;UML:DiagramElement xmi.idref=&quot;ead6ee03-51f1-451b-bca3-f98a738b09c1&quot;&gt;
 *          ....
 *          &lt;/UML:DiagramElement&gt;
 *      &lt;/UML:DiagramLink.referenced&gt;
 * &lt;/UML:Reference&gt;
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
public class ReferenceTransformer extends DiagramElementTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public  ReferenceTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>Reference</code> class into their XMI representation. The
     * element given must be able to be cast to a non-null <code>Reference</code>, otherwise an exception is thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:Reference isIndividualRepresentation=&quot;false&quot;
     *      xmi.id=&quot;f02d498c-7ae1-42b3-9668-62aea91440f6&quot;&gt;
     *      &lt;UML:DiagramLink.referenced&gt;
     *          &lt;UML:DiagramElement xmi.idref=&quot;ead6ee03-51f1-451b-bca3-f98a738b09c1&quot;&gt;
     *          ....
     *          &lt;/UML:DiagramElement&gt;
     *      &lt;/UML:DiagramLink.referenced&gt;
     * &lt;/UML:Reference&gt;
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
     * @throws ClassCastException if the element parameter cannot be cast to a Reference
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        Reference reference = (Reference) element;
        // create a XML Node
        StructureXMLNode node = new StructureXMLNode("UML:Reference", document, caller);
        // set the attributes
        node.setXmiId(reference);
        node.setAttribute("isIndividualRepresentation", String.valueOf(reference.isIndividualRepresentation()));
        // append the referenced element
        node.appendRefChild("UML:DiagramLink.referenced", "UML:DiagramElement", reference.getReferenced());
        // append nodes from the superclass node's children
        node.appendChildren(super.transform(element, document, caller));
        // return the XML Node
        return node.getNode();
    }
}
