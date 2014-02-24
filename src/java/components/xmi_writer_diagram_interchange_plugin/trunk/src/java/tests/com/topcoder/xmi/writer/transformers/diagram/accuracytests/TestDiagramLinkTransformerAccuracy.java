/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramLinkTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>DiagramLinkTransformer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */

public class TestDiagramLinkTransformerAccuracy extends TestCase {

	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new DiagramLinkTransformer();

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
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
	public void testTransform_1() throws Exception {
		DiagramLink link = new DiagramLink();
		Point p = new Point();
		p.setX(1);
		p.setY(10);

		link.setViewport(p);

		link.setZoom(100);

		Node node = transformer.transform(link, document, caller);
		assertEquals("Equal is expected.", "UML:DiagramLink", node.getNodeName());
		assertNotNull("The xmi.id shoud not be null.", node.getAttributes().getNamedItem("xmi.id").getNodeValue());

		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttributes().getNamedItem("zoom")
				.getNodeValue()));

		NodeList list = node.getChildNodes();
		Node subNode = list.item(0);

		Element pointNode = (Element) subNode.getFirstChild();
		assertTrue("True is expected.", 1.0 == Double.parseDouble(pointNode.getAttribute("x")));
		assertTrue("True is expected.", 10.0 == Double.parseDouble(pointNode.getAttribute("y")));
	}


	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
	public void testTransform_2() throws Exception {
		DiagramLink link = new DiagramLink();

		Diagram diagram = new Diagram();
		diagram.setName("accuracy");
		diagram.setZoom(1);

		link.setDiagram(diagram);

		link.setZoom(100);

		caller = Util.createDiagram2XMITransformer();

		transformerMap.put(TransformerType.Diagram, caller);
		transformerMap.put(TransformerType.Model, caller);
		transformerMap.put(TransformerType.ActivityGraph, caller);
		transformerMap.put(TransformerType.Header, caller);

		XMIWriter writer = new XMIWriter(new UMLModelManager(), transformerMap);
		writer.putElementId(link, "link");
		caller.setXMIWriter(writer);


		Element node = (Element) transformer.transform(link, document, caller);
		assertEquals("Equal is expected.", "UML:DiagramLink", node.getNodeName());
		assertNotNull("The xmi.id shoud not be null.", node.getAttributes().getNamedItem("xmi.id").getNodeValue());
		assertEquals("Equal is expected.", "link", node.getAttribute("xmi.id"));

		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttributes().getNamedItem("zoom")
				.getNodeValue()));
		assertEquals("Equal is expected.", 1, node.getElementsByTagName("UML:Diagram").getLength());
		Element d = (Element) node.getElementsByTagName("UML:Diagram").item(0);

		assertNotNull("The xmi.idref for diagram should not be null.", d.getAttribute("xmi.idref"));
	}


	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
	public void testTransform_3() throws Exception {
		DiagramLink link = new DiagramLink();

		Diagram diagram = new Diagram();
		diagram.setName("accuracy");
		diagram.setZoom(1);

		link.setDiagram(diagram);

		link.setZoom(100);

		Element node = (Element) transformer.transform(link, document, caller);
		assertEquals("Equal is expected.", "UML:DiagramLink", node.getNodeName());
		assertNotNull("The xmi.id shoud not be null.", node.getAttributes().getNamedItem("xmi.id").getNodeValue());

		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttributes().getNamedItem("zoom")
				.getNodeValue()));
		assertEquals("Equal is expected.", 1, node.getElementsByTagName("UML:Diagram").getLength());
		Element d = (Element) node.getElementsByTagName("UML:Diagram").item(0);

		assertNotNull("The xmi.idref for diagram should not be null.", d.getAttribute("xmi.idref"));
	}


	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
	public void testTransform_4() throws Exception {
		DiagramLink link = new DiagramLink();
		Point p = new Point();
		p.setX(1);
		p.setY(10);

		link.setGraphElement(new GraphNode());
		link.setViewport(p);

		link.setZoom(100);

		Element node = (Element) transformer.transform(link, document, caller);
		assertEquals("Equal is expected.", "UML:DiagramLink", node.getNodeName());
		assertNotNull("The xmi.id shoud not be null.", node.getAttributes().getNamedItem("xmi.id").getNodeValue());

		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttributes().getNamedItem("zoom")
				.getNodeValue()));

		NodeList list = node.getChildNodes();
		Node subNode = list.item(0);

		Element pointNode = (Element) subNode.getFirstChild();
		assertTrue("True is expected.", 1.0 == Double.parseDouble(pointNode.getAttribute("x")));
		assertTrue("True is expected.", 10.0 == Double.parseDouble(pointNode.getAttribute("y")));
	}
}
