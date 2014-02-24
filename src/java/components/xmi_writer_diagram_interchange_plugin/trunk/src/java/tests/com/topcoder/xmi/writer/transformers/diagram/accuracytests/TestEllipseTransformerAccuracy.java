/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.EllipseTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>EllipseTransformer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestEllipseTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new EllipseTransformer();

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
		Ellipse ellipse = new Ellipse();
		Point p = new Point();
		p.setX(5);
		p.setY(55);

		ellipse.setCenter(p);

		Element e = (Element) transformer.transform(ellipse, document, caller);

		assertEquals("Should be 1.", 1, e.getChildNodes().getLength());
		Element node = (Element) e.getChildNodes().item(0).getFirstChild();

		assertTrue("True is expected.", 5 == Double.parseDouble(node.getAttribute("x")));
		assertTrue("True is expected.", 55 == Double.parseDouble(node.getAttribute("y")));
	}

	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_2() throws Exception {
		Ellipse ellipse = new Ellipse();

		ellipse.setEndAngle(100);
		ellipse.setVisible(false);
		ellipse.setRotation(200);

		Point p = new Point();
		p.setX(5);
		p.setY(55);

		ellipse.setCenter(p);

		Element e = (Element) transformer.transform(ellipse, document, caller);

		assertFalse("Visible should be false.", Boolean.valueOf(e.getAttribute("visible")));
		assertNotNull("The xmi.id should not be null.", e.getAttribute("xmi.id"));
		assertTrue("True is expected.", 100 == Double.parseDouble(e.getAttribute("endAngle")));

		assertEquals("Should be 1.", 1, e.getChildNodes().getLength());
		Element node = (Element) e.getChildNodes().item(0).getFirstChild();

		assertTrue("True is expected.", 5 == Double.parseDouble(node.getAttribute("x")));
		assertTrue("True is expected.", 55 == Double.parseDouble(node.getAttribute("y")));
	}
}
