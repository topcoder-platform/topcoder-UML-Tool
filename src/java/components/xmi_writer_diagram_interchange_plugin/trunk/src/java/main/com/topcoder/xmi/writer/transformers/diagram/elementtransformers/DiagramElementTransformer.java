/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>DiagramElement</code> class.
 * </p>
 * <p>
 * <code>DiagramElementTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code> interface.
 * It is used to convert the instance of the <code>DiagramElement</code> class into their XMI representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:DiagramElement visible=&quot;false&quot; xmi.id=&quot;8addb0e2-8716-4cd7-9c1a-b0f50ae7fe3a&quot;&gt;
 *      &lt;UML:DiagramElement.property&gt;
 *          &lt;UML:Property key=&quot;propertyKey&quot; value=&quot;propertyValue&quot;/&gt;
 *          &lt;UML:Property key=&quot;propertyKey&quot; value=&quot;propertyValue&quot;/&gt;
 *          ...
 *      &lt;/UML:DiagramElement.property&gt;
 *      &lt;UML:DiagramElement.reference&gt;
 *          &lt;UML:Reference isIndividualRepresentation=&quot;false&quot; xmi.id=&quot;5af26e2-a4f5-4350-95&quot;&gt;
 *              ...
 *          &lt;/UML:Reference&gt;
 *          &lt;UML:Reference isIndividualRepresentation=&quot;false&quot; xmi.id=&quot;5af26e2-a4f5-4350-96&quot;/&gt;
 *              ...
 *          &lt;/UML:Reference&gt;
 *          ...
 *      &lt;/UML:DiagramElement.reference&gt;
 * &lt;/UML:DiagramElement&gt;
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
public class DiagramElementTransformer implements DiagramInterchangeElementTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public  DiagramElementTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>DiagramElement</code> class into their XMI representation.
     * The element given must be able to be cast to a non-null <code>DiagramElement</code>, otherwise an exception is
     * thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:DiagramElement visible=&quot;false&quot; xmi.id=&quot;8addb0e2-8716-4cd7-9c1a-b0f50ae7fe3a&quot;&gt;
     *      &lt;UML:DiagramElement.property&gt;
     *          &lt;UML:Property key=&quot;propertyKey&quot; value=&quot;propertyValue&quot;/&gt;
     *          &lt;UML:Property key=&quot;propertyKey&quot; value=&quot;propertyValue&quot;/&gt;
     *          ...
     *      &lt;/UML:DiagramElement.property&gt;
     *      &lt;UML:DiagramElement.reference&gt;
     *          &lt;UML:Reference isIndividualRepresentation=&quot;false&quot;
     *              xmi.id=&quot;5af26e2-a4f5-4350-95&quot;&gt;
     *              ...
     *          &lt;/UML:Reference&gt;
     *          &lt;UML:Reference isIndividualRepresentation=&quot;false&quot;
     *              xmi.id=&quot;5af26e2-a4f5-4350-96&quot;/&gt;
     *              ...
     *          &lt;/UML:Reference&gt;
     *          ...
     *      &lt;/UML:DiagramElement.reference&gt;
     * &lt;/UML:DiagramElement&gt;
     * </pre>
     * </p>
     * @param element DiagramInterchange Element to transform to a node of XMI. It should not be null.
     * @param document XML Document the Node is to be created from
     * @param caller The Diagram2XMITransformer instance calling this transformer's method
     *
     * @return XML Node containing XMI representation of the given element
     *
     * @throws IllegalArgumentException if either input object is null
     * @throws ClassCastException if the element parameter cannot be cast to a DiagramElement
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        DiagramElement diagramElement = (DiagramElement) element;
        StructureXMLNode node = new StructureXMLNode("UML:DiagramElement", document, caller);
        // set the xmi.id
        node.setXmiId(diagramElement);
        node.setAttribute("visible", String.valueOf(diagramElement.isVisible()));
        // transform diagramElement's Properties
        node.appendChildren("UML:DiagramElement.property", diagramElement.getProperties());

        // transform diagramElement's References
        node.appendChildren("UML:DiagramElement.reference", diagramElement.getReferences());

        // return the XML Node.
        return node.getNode();
    }
}
