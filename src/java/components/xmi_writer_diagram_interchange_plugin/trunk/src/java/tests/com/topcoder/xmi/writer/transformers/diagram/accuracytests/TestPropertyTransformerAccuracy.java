/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.topcoder.diagraminterchange.Property;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>PolylineTransformer</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestPropertyTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new PropertyTransformer();

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
		Property element  = new Property();
		element.setKey("key");
		element.setValue("value");

		Element node = (Element) transformer.transform(element, document, caller);

        assertEquals("the node name should  be UML:Property", node.getNodeName(), "UML:Property");

        assertEquals("Equal is expected.", node.getAttributes().getLength(), 2);
        assertEquals("Equal is expected.", node.getAttribute("key"), element.getKey());
        assertEquals("Equal is expected.", node.getAttribute("value"), element.getValue());
	}
}