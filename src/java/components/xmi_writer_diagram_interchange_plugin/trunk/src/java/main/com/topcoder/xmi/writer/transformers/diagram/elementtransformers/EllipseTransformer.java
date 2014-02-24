/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;

/**
 * <p>
 * Provides the XMI transformation strategy for instances of the <code>Ellipse</code> class.
 * </p>
 * <p>
 * <code>EllipseTransformer</code> implements the <code>DiagramInterchangeElementTransformer</code> interface.
 * It is used to convert the instance of the <code>Ellipse</code> class into their XMI representation.
 * </p>
 * <p>
 * This is performed by the transform method, taking the element and XML document, and returning a Node of XML that
 * conforms to the XSD for the given object.
 * </p>
 * <p>
 * The XMI representation of the node will have the similar structure below: <br>
 * <pre>
 * &lt;UML:Ellipse endAngle=&quot;0.0&quot; radiusX=&quot;0.0&quot; radiusY=&quot;0.0&quot; rotation=&quot;0.0&quot;
 *    startAngle=&quot;0.0&quot; visible=&quot;true&quot; xmi.id=&quot;594f699d-591a-4e5c-8e57-14736ff0fc09&quot;&gt;
 *     &lt;UML:Ellipse.center&gt;
 *         &lt;UML:Point x=&quot;0.0&quot; y=&quot;0.0&quot;/&gt;
 *     &lt;/UML:Ellipse.center&gt;
 *     &lt;UML:DiagramElement.property&gt;
 *         &lt;UML:Property key=&quot;propertyKey&quot; value=&quot;propertyValue&quot;/&gt;
 *         ...
 *     &lt;/UML:DiagramElement.property&gt;
 *     &lt;UML:DiagramElement.reference&gt;
 *         &lt;UML:Reference isIndividualRepresentation=&quot;false&quot;
 *              xmi.id=&quot;50fcb538-5043-4778-b1c7-d9adeaef6d57&quot;/&gt;
 *         ...
 *     &lt;/UML:DiagramElement.reference&gt;
 *    ...
 * &lt;/UML:Ellipse&gt;
 * </pre>
 * </p>
 * <p>
 * <b>Thread-safety:</b>
 * This class does not handle its own thread safety, it is possible the document and element objects may be altered by
 * other threads during execution. It does however not modify the element in any way, and only uses the document to
 * create XML elements.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public class EllipseTransformer extends GraphicPrimitiveTransformer {

    /**
     * <p>
     * Default, no-arg constructor.
     * </p>
     */
    public EllipseTransformer() {
        // do nothing
    }

    /**
     * <p>
     * Transform the given element into its XMI representation.
     * </p>
     * <p>
     * It is used to convert the instance of the <code>Ellipse</code> class into their XMI representation.
     * The element given must be able to be cast to a non-null <code>Ellipse</code>, otherwise an exception is thrown.
     * </p>
     * <p>
     * The XMI representation of the node will have the similar structure below: <br>
     * <pre>
     * &lt;UML:Ellipse endAngle=&quot;0.0&quot; radiusX=&quot;0.0&quot; radiusY=&quot;0.0&quot; rotation=&quot;0.0&quot;
     *     startAngle=&quot;0.0&quot; visible=&quot;true&quot;
     *         xmi.id=&quot;594f699d-591a-4e5c-8e57-14736ff0fc09&quot;&gt;
     *     &lt;UML:Ellipse.center&gt;
     *         &lt;UML:Point x=&quot;0.0&quot; y=&quot;0.0&quot;/&gt;
     *     &lt;/UML:Ellipse.center&gt;
     *     &lt;UML:DiagramElement.property&gt;
     *         &lt;UML:Property key=&quot;propertyKey&quot; value=&quot;propertyValue&quot;/&gt;
     *         ...
     *     &lt;/UML:DiagramElement.property&gt;
     *     &lt;UML:DiagramElement.reference&gt;
     *         &lt;UML:Reference isIndividualRepresentation=&quot;false&quot;
     *             xmi.id=&quot;50fcb538-5043-4778-b1c7-d9adeaef6d57&quot;/&gt;
     *         ...
     *     &lt;/UML:DiagramElement.reference&gt;
     *     ...
     * &lt;/UML:Ellipse&gt;
     * </pre>
     * </p>
     * @param element DiagramInterchange Element to transform to a node of XMI. It should not be null.
     * @param document XML Document the Node is to be created from
     * @param caller The Diagram2XMITransformer instance calling this transformer's method
     *
     * @return XML Node containing XMI representation of the given element
     *
     * @throws IllegalArgumentException if either input object is null
     * @throws ClassCastException if the element parameter cannot be cast to a Ellipse
     * @throws XMITransformException if there are problems writing the XMI information to a Node
     */
    public Node transform(Object element, Document document, Diagram2XMITransformer caller)
        throws XMITransformException {
        Helper.checkElementNotNull(element);
        Ellipse ellipse = (Ellipse) element;
        // create a new XML Node
        StructureXMLNode node = new StructureXMLNode("UML:Ellipse", document, caller);
        // set the attributes
        node.setXmiId(ellipse);
        node.setAttribute("visible", String.valueOf(ellipse.isVisible()));
        node.setAttribute("radiusX", String.valueOf(ellipse.getRadiusX()));
        node.setAttribute("radiusY", String.valueOf(ellipse.getRadiusY()));
        node.setAttribute("rotation", String.valueOf(ellipse.getRotation()));
        node.setAttribute("startAngle", String.valueOf(ellipse.getStartAngle()));
        node.setAttribute("endAngle",  String.valueOf(ellipse.getEndAngle()));
        // append the center of  this Ellipse
        node.appendChild("UML:Ellipse.center", ellipse.getCenter());
        // append nodes from the superclass node's children
        node.appendChildren(super.transform(ellipse, document, caller));

        return node.getNode();
    }
}
