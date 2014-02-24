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
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>DiagramTransformer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */

public class TestDiagramTransformerAccuracy extends TestCase {

	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new DiagramTransformer();

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
		Diagram d = new Diagram();
		Point p = new Point();
		p.setX(1);
		p.setY(10);

		d.setName("accuracy");
		d.setViewport(p);
		d.setSize(new Dimension());
		d.setZoom(100);

		Element node = (Element) transformer.transform(d, document, caller);
		assertEquals("Equal is expected.", "UML:Diagram", node.getNodeName());
		assertNotNull("The xmi.id shoud not be null.", node.getAttributes().getNamedItem("xmi.id").getNodeValue());

		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttributes().getNamedItem("zoom")
				.getNodeValue()));
		assertTrue("True is expected.", Boolean.valueOf(node.getAttribute("visible")));
		assertEquals("Equal is expected.", "accuracy", node.getAttribute("name"));

		NodeList list = node.getChildNodes();
		assertEquals("Equal is expected.", 2, list.getLength());

		Node subNode1 = list.item(0);
		assertEquals("Equal is expected.", "UML:Diagram.viewport", subNode1.getNodeName());

		Node ssN = subNode1.getChildNodes().item(0);
		assertEquals("Equal is expected.", 2, ssN.getAttributes().getLength());
		assertTrue("True is expected.", 1 == Double.parseDouble(ssN.getAttributes().getNamedItem("x").getNodeValue()));
		assertTrue("True is expected.", 10 == Double.parseDouble(ssN.getAttributes().getNamedItem("y").getNodeValue()));

		Node subNode2 = list.item(1);

		Node n = subNode2.getChildNodes().item(0);

		assertTrue("True is expected.", 0 == Double
				.parseDouble(n.getAttributes().getNamedItem("height").getNodeValue()));
		assertTrue("True is expected.", 0 == Double.parseDouble(n.getAttributes().getNamedItem("width").getNodeValue()));
	}

	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
	public void testTransform_2() throws Exception {
		Diagram d = new Diagram();

		d.setName("accuracy");
		d.setZoom(100);
		d.addContained(new Ellipse());
		Element node = (Element) transformer.transform(d, document, caller);
		assertEquals("Equal is expected.", "UML:Diagram", node.getNodeName());
		assertNotNull("The xmi.id shoud not be null.", node.getAttributes().getNamedItem("xmi.id").getNodeValue());

		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttributes().getNamedItem("zoom")
				.getNodeValue()));
		assertTrue("True is expected.", Boolean.valueOf(node.getAttribute("visible")));
		assertEquals("Equal is expected.", "accuracy", node.getAttribute("name"));

		Node subNode = node.getChildNodes().item(0);
		Node ellipse = subNode.getChildNodes().item(0);
		assertEquals("Equal is expected.", "UML:Ellipse", ellipse.getNodeName());
	}

	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
	public void testTransform_3() throws Exception {
		Diagram d = new Diagram();

		d.setName("accuracy");
		d.setZoom(100);
		SemanticModelBridge bridge = new SimpleSemanticModelElement();
		bridge.setPresentation("p");

		d.setOwner(bridge);

		d.addContained(new Ellipse());
		Element node = (Element) transformer.transform(d, document, caller);
		assertEquals("Equal is expected.", "UML:Diagram", node.getNodeName());
		assertNotNull("The xmi.id shoud not be null.", node.getAttributes().getNamedItem("xmi.id").getNodeValue());

		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttributes().getNamedItem("zoom")
				.getNodeValue()));
		assertTrue("True is expected.", Boolean.valueOf(node.getAttribute("visible")));
		assertEquals("Equal is expected.", "accuracy", node.getAttribute("name"));

		Node n = node.getChildNodes().item(0);
		Node semanticModel = n.getFirstChild();
		assertEquals("Equal is expected.", "UML:SimpleSemanticModelElement", semanticModel.getNodeName());
		assertEquals("Equal is expected.", "p", semanticModel.getAttributes().getNamedItem("presentation")
				.getNodeValue());

		Node subNode = node.getChildNodes().item(1);
		Node ellipse = subNode.getChildNodes().item(0);
		assertEquals("Equal is expected.", "UML:Ellipse", ellipse.getNodeName());
	}


	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
	public void testTransform_4() throws Exception {
		Diagram d = new Diagram();

		d.setName("accuracy");
		d.setZoom(100);

		d.addContained(new Ellipse());
		d.addContained(new Ellipse());
		d.addContained(new Ellipse());

		// add 2 DiagramLink instance.
		d.addDiagramLink(new DiagramLink());
		d.addDiagramLink(new DiagramLink());

		Element node = (Element) transformer.transform(d, document, caller);
		assertEquals("Equal is expected.", "UML:Diagram", node.getNodeName());
		assertNotNull("The xmi.id shoud not be null.", node.getAttributes().getNamedItem("xmi.id").getNodeValue());

		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttributes().getNamedItem("zoom")
				.getNodeValue()));
		assertTrue("True is expected.", Boolean.valueOf(node.getAttribute("visible")));
		assertEquals("Equal is expected.", "accuracy", node.getAttribute("name"));

		Node subNode = node.getElementsByTagName("UML:Ellipse").item(0);
		assertEquals("Equal is expected.", "UML:Ellipse", subNode.getNodeName());

		// now we check for the diagramLink instances.

		int number = node.getElementsByTagName("UML:DiagramLink").getLength();

		if (number == d.getDiagramLinks().size()) {
			/*
             * <UML:DiagramLink> DiagramLink1 </UML:DiagramLink>
             * <UML:DiagramLink> DiagramLink2 </DiagramLink>
             */
			NodeList list1 = node.getElementsByTagName("UML:DiagramLink");
			for (int i = 0; i < list1.getLength(); i++) {
				Node eachElement = list1.item(i);
				assertEquals("Equal is expected.", "UML:DiagramLink", eachElement.getNodeName());
			}
		} else {

			/*
             * The structure should be
             * <UML:DiagramLink>
             *   UML:DiagramLink 1 UML:DiagramLink 2 ...
             * </UML:DiagramLink>
             */
			Node nodes = node.getElementsByTagName("UML:DiagramLink").item(0);

			assertTrue("Should be only one node.",
					node.getElementsByTagName("UML:DiagramElement.reference").getLength() == 1);

			assertEquals("Equal is expected.", d.getDiagramLinks().size(),
					 nodes .getChildNodes().getLength());
		}
	}
}
