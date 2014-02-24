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

import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphElementTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>GraphElementTransformer</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestGraphElementTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new GraphElementTransformer();

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
		GraphElement element = new GraphNode();
		element.addAnchorage(new GraphConnector());
		element.addAnchorage(new GraphConnector());
		element.addContained(new GraphNode());
		element.addLink(new DiagramLink());
		Point p = new Point();
		p.setX(1);
		p.setY(100);

		element.setPosition(p);

		System.out.println("Printing out the xml result for element:");
		System.out.println("GraphElement element = new GraphNode();");
		System.out.println("element.addAnchorage(new GraphConnector());");
		System.out.println("element.addAnchorage(new GraphConnector());");
		System.out.println("element.addContained(new GraphNode());");
		System.out.println("element.addLink(new DiagramLink());");
		System.out.println("Point p = new Point();");
		System.out.println("p.setX(1);");
		System.out.println("p.setY(100);");
		System.out.println("element.setPosition(p);");
		System.out.println();
		caller.transform(element, System.out);
		System.out.println("End for printing this element in xml format.");

		element.setSemanticModel(new SimpleSemanticModelElement());
		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("the node name should  be UML:GraphElement", "UML:GraphElement", node.getNodeName());
		assertTrue("the xmi.id should be set", node.getAttribute("xmi.id").length() > 0);

		assertEquals("the return should be 1", 1, node.getElementsByTagName("UML:GraphElement.position").getLength());
		Element n = (Element) node.getElementsByTagName("UML:GraphElement.position").item(0).getFirstChild();
		assertTrue("True is expected.", 1 == Double.parseDouble(n.getAttribute("x")));
		assertTrue("True is expected.", 100 == Double.parseDouble(n.getAttribute("y")));

		assertEquals("There must be one contained element.", 1, node.getElementsByTagName("UML:GraphElement.contained")
				.getLength());

		Node containedNode = node.getElementsByTagName("UML:GraphElement.contained").item(0);

		assertEquals("Equal is expected.", element.getContaineds().size(), containedNode.getChildNodes().getLength());


		int number = node.getElementsByTagName("UML:GraphElement.anchorage").getLength();
		if (number == element.getAnchorages().size()) {

			/*
			 * The format is
			 * <p>
			 * <UML:GraphElement.anchorage>
			 *   anchorage1
			 * </UML:GraphElement.anchorage>
			 * <UML:GraphElement.anchorage>
			 *   anchorage2
			 * </UML:GraphElement.anchorage>
			 * </p>
			 *
			 */
			NodeList list1 = node.getElementsByTagName("UML:GraphElement.anchorage");

			for (int i = 0; i < list1.getLength(); i++) {
				assertEquals("Equal is expected.", "GraphConnector", list1.item(i).getNodeName());
			}
		} else  {
			/*
			 * The format is
			 * <p>
			 * <UML:GraphElement.anchorage>
			 *   anchorage1
			 *   anchorage2
			 *   anchorage3
			 *   ...
			 * </UML:GraphElement.anchorage>
			 * </p>
			 */

			assertEquals("Equal is expected.", 1, node.getElementsByTagName("UML:GraphElement.anchorage").getLength());

			NodeList list2 = node.getElementsByTagName("UML:GraphElement.anchorage");
			NodeList subNodeList = list2.item(0).getChildNodes();

			assertEquals("Equal is expected.", element.getAnchorages().size(), subNodeList.getLength());
		}

		assertEquals("Equal is expected.", 1, node.getElementsByTagName("UML:GraphElement.link").getLength());
	}

	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_2() throws Exception {
		GraphElement element = new GraphNode();
		element.addAnchorage(new GraphConnector());
		element.addAnchorage(new GraphConnector());
		element.addAnchorage(new GraphConnector());

		element.addContained(new GraphNode());
		element.addContained(new GraphNode());
		element.addContained(new GraphEdge());

		element.addLink(new DiagramLink());
		element.addLink(new DiagramLink());
		element.addLink(new DiagramLink());

		Point p = new Point();
		p.setX(1);
		p.setY(100);

		element.setPosition(p);

		element.setSemanticModel(new SimpleSemanticModelElement());
		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("the node name should  be UML:GraphElement", "UML:GraphElement", node.getNodeName());
		assertTrue("the xmi.id should be set", node.getAttribute("xmi.id").length() > 0);

		assertEquals("the return should be 1", 1, node.getElementsByTagName("UML:GraphElement.position").getLength());
		Element n = (Element) node.getElementsByTagName("UML:GraphElement.position").item(0).getFirstChild();
		assertTrue("True is expected.", 1 == Double.parseDouble(n.getAttribute("x")));
		assertTrue("True is expected.", 100 == Double.parseDouble(n.getAttribute("y")));

		assertEquals("There must be one contained element.", 1, node.getElementsByTagName("UML:GraphElement.contained")
				.getLength());

		Node containedNode = node.getElementsByTagName("UML:GraphElement.contained").item(0);

		assertEquals("Equal is expected.", element.getContaineds().size(), containedNode.getChildNodes().getLength());

		int number = node.getElementsByTagName("UML:GraphElement.anchorage").getLength();
		if (number == element.getAnchorages().size()) {

			/*
			 * The format is
			 * <p>
			 * <UML:GraphElement.anchorage>
			 *   anchorage1
			 * </UML:GraphElement.anchorage>
			 * <UML:GraphElement.anchorage>
			 *   anchorage2
			 * </UML:GraphElement.anchorage>
			 * </p>
			 *
			 */
			NodeList list1 = node.getElementsByTagName("UML:GraphElement.anchorage");

			for (int i = 0; i < list1.getLength(); i++) {
				assertEquals("Equal is expected.", "GraphConnector", list1.item(i).getNodeName());
			}
		} else  {
			/*
			 * The format is
			 * <p>
			 * <UML:GraphElement.anchorage>
			 *   anchorage1
			 *   anchorage2
			 *   anchorage3
			 *   ...
			 * </UML:GraphElement.anchorage>
			 * </p>
			 */

			assertEquals("Equal is expected.", 1, node.getElementsByTagName("UML:GraphElement.anchorage").getLength());

			NodeList list2 = node.getElementsByTagName("UML:GraphElement.anchorage");
			NodeList subNodeList = list2.item(0).getChildNodes();

			assertEquals("Equal is expected.", element.getAnchorages().size(), subNodeList.getLength());
		}

	    number = node.getElementsByTagName("UML:GraphElement.link").getLength();
		if (number == element.getAnchorages().size()) {

			/*
			 * The format is
			 * <p>
			 * <UML:GraphElement.link>
			 *   link1
			 * </UML:GraphElement.link>
			 * <UML:GraphElement.link>
			 *   link2
			 * </UML:GraphElement.link>
			 * </p>
			 *
			 */
			NodeList list1 = node.getElementsByTagName("UML:GraphElement.link");

			for (int i = 0; i < list1.getLength(); i++) {
				assertEquals("Equal is expected.", "UML:DiagramLink", list1.item(i).getNodeName());
			}
		} else  {
			/*
			 * The format is
			 * <p>
			 * <UML:GraphElement.anchorage>
			 *   anchorage1
			 *   anchorage2
			 *   anchorage3
			 *   ...
			 * </UML:GraphElement.anchorage>
			 * </p>
			 */
			assertEquals("Equal is expected.", 1, node.getElementsByTagName("UML:GraphElement.link").getLength());

			NodeList list2 = node.getElementsByTagName("UML:GraphElement.link");
			NodeList subNodeList = list2.item(0).getChildNodes();

			assertEquals("Equal is expected.", element.getLinks().size(), subNodeList.getLength());

			for (int i = 0; i < subNodeList.getLength(); i++) {
				assertEquals("Equal is expected.", "UML:DiagramLink", subNodeList.item(i).getNodeName());
			}
		}
	}
}