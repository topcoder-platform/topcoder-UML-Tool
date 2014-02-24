/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.topcoder.diagraminterchange.Image;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ImageTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>ImageTransformer</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestImageTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new ImageTransformer();

	/**
     * Represents the document instance for testing.
     */
	private Document document;

	/**
     * Represents the Diagram2XMITransformer instance for testing.
     */
	private static Diagram2XMITransformer caller = null;

	/**
     * The transformers map for XMIWriter object.
     */
	private final Map<TransformerType, XMITransformer> transformerMap = new HashMap<TransformerType, XMITransformer>();

	/**
     * Sets up the fixture.
     *
     * @throws Exception
     *             throws to junit.
     * @see junit.framework.TestCase#setUp()
     */
	public void setUp() throws Exception {
		caller = Util.createDiagram2XMITransformer();

		transformerMap.put(TransformerType.Diagram, caller);
		transformerMap.put(TransformerType.Model, caller);
		transformerMap.put(TransformerType.ActivityGraph, caller);
		transformerMap.put(TransformerType.Header, caller);

		caller.setXMIWriter(new XMIWriter(new UMLModelManager(), transformerMap));
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	/**
     * Tear down the environment.
     *
     * @throws Exception
     *             to junit.
     */
	public void tearDown() throws Exception {
		caller = null;
		document = null;
	}

	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_1() throws Exception {
		Image element = new Image();
		element.addProperty(new Property());

		element.setMimeType("minType");
		element.setUri("uri");
		element.setVisible(true);

		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("the node name should  be UML:Image", "UML:Image", node.getNodeName());
		assertTrue("The xmi id should not be null.", node.getAttribute("xmi.id").length() > 0);
		assertEquals("Equal is expected.", node.getAttribute("visible"), Boolean.toString(element.isVisible()));
		assertEquals("the url attribute should be set", node.getAttribute("url"), element.getUri());
		assertEquals("the mimeType attribute should be set", node.getAttribute("mimeType"), element.getMimeType());

		assertEquals("One one property existing", 1, node.getElementsByTagName("UML:Property").getLength());

	}

	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_2() throws Exception {
		Image element = new Image();
		Property p1 = new Property();
		p1.setKey("key");
		p1.setValue("value");

		Property p2 = new Property();
		p2.setKey("topcoder");
		p2.setValue("tc");

		element.addProperty(p1);
		element.addProperty(p2);

		element.setMimeType("minType");
		element.setUri("uri");
		element.setVisible(true);

		System.out.println();
		System.out.println("Printing out the xml result for element:");
		System.out.println("Image element = new Image();");
		System.out.println("Property p1 = new Property();");
		System.out.println("p1.setKey(\"key\");");
		System.out.println("p1.setValue(\"value\");");
		System.out.println("Property p2 = new Property();");
		System.out.println("p2.setKey(\"topcoder\");");
		System.out.println("p2.setValue(\"tc\");");
		System.out.println("element.addProperty(p1);");
		System.out.println("element.addProperty(p2);");
		System.out.println("element.setUri(\"uri\");");
		System.out.println("element.setVisible(true);");
		System.out.println();

		caller.transform(element, System.out);
		System.out.println("Ending for printing the xml result of this element.");
		System.out.println();

		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("the node name should  be UML:Image", "UML:Image", node.getNodeName());
		assertTrue("The xmi id should not be null.", node.getAttribute("xmi.id").length() > 0);
		assertEquals("Equal is expected.", node.getAttribute("visible"), Boolean.toString(element.isVisible()));
		assertEquals("the url attribute should be set", node.getAttribute("url"), element.getUri());
		assertEquals("the mimeType attribute should be set", node.getAttribute("mimeType"), element.getMimeType());

		assertEquals("Equal is expected", element.getProperties().size(), node.getElementsByTagName(
				"UML:Property").getLength());
	}
}