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
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphEdgeTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>GraphEdgeTransformer</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestGraphEdgeTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new GraphEdgeTransformer();

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
	public void testTransform() throws Exception {
		GraphEdge edge = new GraphEdge();
		for (int i = 0; i < 2; i++) {
			edge.addAnchor(new GraphConnector());
		}
		Point p = new Point();
		p.setX(1);
		p.setY(100);
		edge.setPosition(p);

		edge.setVisible(true);
		edge.addWaypoint(p);

		Element node = (Element) transformer.transform(edge, document, caller);

		assertEquals("the node name should  be UML:GraphEdge", "UML:GraphEdge", node.getNodeName());
		assertTrue("the xmi.id should be set", node.getAttribute("xmi.id").length() > 0);
		assertEquals("the return should be 1", 1, node.getElementsByTagName("UML:GraphEdge.waypoints").getLength());
		assertEquals("the return should be 2", 2, node.getElementsByTagName("UML:GraphConnector").getLength());

		assertEquals("the return should be 2", 2, node.getElementsByTagName("UML:Point").getLength());

		NodeList list = node.getChildNodes();

		Node n1 = list.item(0).getChildNodes().item(0);

		assertTrue("True is expected.", 1 == Double.parseDouble(n1.getAttributes().getNamedItem("x").getNodeValue()));
		assertTrue("True is expected.", 100 == Double.parseDouble(n1.getAttributes().getNamedItem("y").getNodeValue()));
	}


	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_2() throws Exception {
		GraphEdge edge = new GraphEdge();
		for (int i = 0; i < 2; i++) {
			edge.addAnchor(new GraphConnector());
		}
		Point p = new Point();
		p.setX(1);
		p.setY(100);
		edge.setPosition(p);

		edge.setVisible(true);


		edge.addWaypoint(p);
		edge.addWaypoint(new Point());
		edge.addWaypoint(new Point());

		Element node = (Element) transformer.transform(edge, document, caller);

		assertEquals("the node name should  be UML:GraphEdge", "UML:GraphEdge", node.getNodeName());
		assertTrue("the xmi.id should be set", node.getAttribute("xmi.id").length() > 0);
		assertEquals("the return should be 1", 1, node.getElementsByTagName("UML:GraphEdge.waypoints").getLength());

		NodeList pointList = node.getElementsByTagName("UML:GraphEdge.waypoints");
		assertEquals("Equal is expected.", 1, pointList.getLength());
		assertEquals("Equal is expected.", 3, pointList.item(0).getChildNodes().getLength());

		assertEquals("the return should be 2", 2, node.getElementsByTagName("UML:GraphConnector").getLength());

		NodeList list = node.getChildNodes();

		Node n1 = list.item(0).getChildNodes().item(0);

		assertTrue("True is expected.", 1 == Double.parseDouble(n1.getAttributes().getNamedItem("x").getNodeValue()));
		assertTrue("True is expected.", 100 == Double.parseDouble(n1.getAttributes().getNamedItem("y").getNodeValue()));
	}
}