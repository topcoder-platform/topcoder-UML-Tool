/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.topcoder.diagraminterchange.BezierPoint;
import com.topcoder.diagraminterchange.Point;

import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.BezierPointTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>BezierPointTransformer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestBezierPointTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new BezierPointTransformer();

	/**
     * Represents the document instance for testing.
     */
	private Document document;

	/**
     * Represents the Diagram2XMITransformer instance for testing.
     */
	private static Diagram2XMITransformer trans = null;

	/**
     * DiagramInterchange Element to transform to a node of XMI.
     */
	private BezierPoint point;

	/**
     * Sets up the fixture.
     *
     * @throws Exception
     *             throws to junit.
     * @see junit.framework.TestCase#setUp()
     */
	public void setUp() throws Exception {
		trans = Util.createDiagram2XMITransformer();
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	/**
     * Tear down the environment.
     *
     * @throws Exception
     *             to junit.
     */
	public void tearDown() throws Exception {
		trans = null;
		document = null;
	}

	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_1() throws Exception {
		point = new BezierPoint();
		point.setX(10.45);
		point.setY(0);

		Element node = (Element) transformer.transform(point, document, trans);

		assertEquals("The node name should be 'UML:BezierPoint'", "UML:BezierPoint", node.getNodeName());
		assertEquals("There should be 2 attributes.", 2, node.getAttributes().getLength());
		assertTrue("The x value should be 10.45", Double.parseDouble(node.getAttribute("x")) == 10.45);
		assertTrue("The y value should be 0.", Double.parseDouble(node.getAttribute("y")) == 0);
	}

	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_2() throws Exception {
		point = new BezierPoint();
		point.setX(0.00000);
		point.setY(1111.000000000000000000011111);

		Point p1 = new Point();
		p1.setX(1);
		p1.setY(10);

		point.addControl(p1);

		Element node = (Element) transformer.transform(point, document, trans);

		assertEquals("The node name should be 'UML:BezierPoint'", "UML:BezierPoint", node.getNodeName());
		assertEquals("There should be 2 attributes.", 2, node.getAttributes().getLength());
		assertTrue("The x value should be 10.45", Double.parseDouble(node.getAttribute("x")) == 0);
		assertTrue("The y value should be 1111.000000000000000000011111.",
				Double.parseDouble(node.getAttribute("y")) == 1111.000000000000000000011111);

		NodeList controls = node.getElementsByTagName("UML:BezierPoint.controls");

		assertEquals("There should be 2 child nodes.", 1, controls.getLength());

		Element subElement = (Element) controls.item(0).getFirstChild();
		assertTrue("The x attribute of the control point is 1.", 1 == Double.parseDouble(subElement.getAttribute("x")));
		assertTrue("The y attribute of control point is 10.", 10.0 == Double.parseDouble(subElement.getAttribute("y")));
	}

	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_3() throws Exception {
		point = new BezierPoint();
		point.setX(0.00000);
		point.setY(1111.000000000000000000011111);

		Point p1 = new Point();
		p1.setX(1);
		p1.setY(10);

		point.addControl(p1);

		Point p2 = new Point();
		p2.setX(2);
		p2.setY(20);

		point.addControl(p2);

		Element node = (Element) transformer.transform(point, document, trans);

		assertEquals("The node name should be 'UML:BezierPoint'", "UML:BezierPoint", node.getNodeName());
		assertEquals("There should be 2 attributes.", 2, node.getAttributes().getLength());
		assertTrue("The x value should be 10.45", Double.parseDouble(node.getAttribute("x")) == 0);
		assertTrue("The y value should be 1111.000000000000000000011111.",
				Double.parseDouble(node.getAttribute("y")) == 1111.000000000000000000011111);

		NodeList controls = node.getElementsByTagName("UML:BezierPoint.controls");

		assertEquals("There should be 1 child nodes.", 1, node.getChildNodes().getLength());

		Element subElement = (Element) controls.item(0).getFirstChild();
		assertTrue("The x attribute of the control point is 1.", 1 == Double.parseDouble(subElement.getAttribute("x")));
		assertTrue("The y attribute of control point is 10.", 10.0 == Double.parseDouble(subElement.getAttribute("y")));

		Element subElement2 = (Element) controls.item(0).getLastChild();
		assertTrue("The x attribute of the control point is 2.", 2 == Double.parseDouble(subElement2.getAttribute("x")));
		assertTrue("The y attribute of control point is 20.", 20.0 == Double.parseDouble(subElement2.getAttribute("y")));
	}
}