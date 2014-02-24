/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.topcoder.diagraminterchange.Dimension;

import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DimensionTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>DimensionTransformer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestDimensionTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new DimensionTransformer();

	/**
     * Represents the document instance for testing.
     */
	private Document document;

	/**
     * Represents the Diagram2XMITransformer instance for testing.
     */
	private static Diagram2XMITransformer trans = null;

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
	public void testTransform() throws Exception {
		Dimension d = new Dimension();
		d.setHeight(10.45);
		d.setWidth(0);

		Element node = (Element) transformer.transform(d, document, trans);

		assertEquals("The node name should be 'UML:Dimension'", "UML:Dimension", node.getNodeName());
		assertEquals("There should be 2 attributes.", 2, node.getAttributes().getLength());
		assertTrue("The height value should be 10.45", Double.parseDouble(node.getAttribute("height")) == 10.45);
		assertTrue("The width value should be 0.", Double.parseDouble(node.getAttribute("width")) == 0);
	}
}
