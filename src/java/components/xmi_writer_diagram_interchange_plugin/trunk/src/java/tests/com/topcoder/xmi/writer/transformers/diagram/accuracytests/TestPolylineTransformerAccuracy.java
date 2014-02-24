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

import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PolylineTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>PolylineTransformer</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestPolylineTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new PolylineTransformer();

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
		Polyline element = new Polyline();
		element.setClosed(false);
		element.setVisible(true);
		Point p1 = new Point();
		p1.setX(1);
		p1.setY(2);

		Point p2 = new Point();
		p2.setX(2);
		p2.setY(1000);

		element.addWaypoint(p1);
		element.addWaypoint(p2);
		element.addProperty(new Property());

		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("the node name should  be UML:Polyline", "UML:Polyline", node.getNodeName());
		assertTrue("the xmi.id should be set", node.getAttribute("xmi.id").length() > 0);

		assertEquals("the visible attribute should be set", node.getAttribute("visible"), Boolean.toString(element
				.isVisible()));
		assertEquals("the closed attribute should be set", node.getAttribute("closed"), Boolean.toString(element
				.isClosed()));

		Node n1 = node.getChildNodes().item(0);
		assertEquals("Should be 2 child.",2, n1.getChildNodes().getLength());

		Element p1N = (Element) n1.getFirstChild();
		assertTrue("Should be 1.0.", 1.0 == Double.parseDouble(p1N.getAttribute("x")));
		assertTrue("Should be 2.0.", 2.0 == Double.parseDouble(p1N.getAttribute("y")));

		Element p2N = (Element) n1.getLastChild();
		assertTrue("Should be 2.0.", 2.0 == Double.parseDouble(p2N.getAttribute("x")));
		assertTrue("Should be 1000.0.", 1000.0 == Double.parseDouble(p2N.getAttribute("y")));
	}
}