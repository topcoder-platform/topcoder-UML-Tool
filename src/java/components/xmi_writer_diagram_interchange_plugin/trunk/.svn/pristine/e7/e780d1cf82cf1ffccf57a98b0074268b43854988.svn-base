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

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphConnectorTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>GraphConnectorTransformer</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestGraphConnectorTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new GraphConnectorTransformer();

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
	 * @throws Exception to junit.
	 */
	public void testTransform() throws Exception {
		GraphConnector element  = new GraphConnector();
		element.addGraphEdge(new GraphEdge());
		element.setPosition(new Point());


		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("Equal is expected.", "UML:GraphConnector", node.getNodeName());
		assertNotNull("The id should not be null.", node.getAttribute("xmi.id"));

		NodeList list = node.getChildNodes();
		assertEquals("Equal is expected.", 2, list.getLength());

		Node node1 = list.item(0);

		Node n1 = node1.getFirstChild();
		assertTrue("True is expected.", 0 == Double.parseDouble(n1.getAttributes().getNamedItem("x").getNodeValue()));
		assertTrue("True is expected.", 0 == Double.parseDouble(n1.getAttributes().getNamedItem("y").getNodeValue()));

		Node n2 = list.item(1).getFirstChild();
		assertNotNull("The idref should not be null.", n2.getAttributes().getNamedItem("xmi.idref").getNodeValue());
	}

	/**
	 * Test the method transform.
	 * @throws Exception to junit.
	 */
	public void testTransform_1() throws Exception {
		GraphConnector element  = new GraphConnector();

		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("Equal is expected.", "UML:GraphConnector", node.getNodeName());
		assertNotNull("The id should not be null.", node.getAttribute("xmi.id"));

		NodeList list = node.getChildNodes();
		assertEquals("Equal is expected.", 0, list.getLength());
	}


	/**
	 * Test the method transform.
	 * @throws Exception to junit.
	 */
	public void testTransform_2() throws Exception {
		GraphConnector element  = new GraphConnector();
		element.addGraphEdge(new GraphEdge());
		element.addGraphEdge(new GraphEdge());
		element.addGraphEdge(new GraphEdge());


		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("Equal is expected.", "UML:GraphConnector", node.getNodeName());
		assertNotNull("The id should not be null.", node.getAttribute("xmi.id"));

		NodeList list = node.getElementsByTagName("UML:GraphConnector.graphEdge");

		if (list.getLength() == element.getGraphEdges().size()) {
			/*
			 * The format is
			 * <UML:GraphConnector.graphEdge>
			 * <UML:GraphEdge>
			 *  edge1
			 * </UML:GraphEdge>
			 * </UML:GraphConnector.graphEdge>
			 * <UML:GraphConnector.graphEdge>
			 * <UML:GraphEdge>
			 *  edge2
			 * </UML:GraphEdge>
			 * </UML:GraphConnector.graphEdge>
			 *
			 */
			for (int i = 0; i < list.getLength(); i++) {
				Node subNode = list.item(i);
				assertEquals("Equal is expected.", "UML:GraphConnector.graphEdge", subNode.getNodeName());
				Node edgeNode = subNode.getChildNodes().item(0);
				assertEquals("Equal is expected.", "UML:GraphEdge", edgeNode.getNodeName());

			}
		} else {
			/*
			 * The format is
			 * <UML:GraphConnector.graphEdge>
			 *  <UML:GraphEdge>
			 *  </UML:GraphEdge>
			 *  <UML:GraphEdge>
			 *  </UML:GraphEdge>
			 * <UML:GraphConnector.graphEdge>
			 */

			assertEquals("Should be 1 subElement.", 1, list.getLength());

			NodeList subNodes = list.item(0).getChildNodes();
			assertEquals("Equal is expected.", 3, subNodes.getLength());

			for (int i = 0; i < subNodes.getLength(); i++) {

				assertEquals("Equal is expected.", "UML:GraphEdge", subNodes.item(i).getNodeName());
			}
		}
	}
}
