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

import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.Uml1SemanticModelBridgeTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>Uml1SemanticModelBridgeTransformer</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestUml1SemanticModelBridgeTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new Uml1SemanticModelBridgeTransformer();

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
		Uml1SemanticModelBridge element = new Uml1SemanticModelBridge();
		element.setPresentation("p");

		element.setElement(new LinkImpl());

		Element node = (Element) transformer.transform(element, document, caller);

		assertEquals("the node name should  be UML:Uml1SemanticModelBridge", node.getNodeName(),
				"UML:Uml1SemanticModelBridge");
		assertNotNull("Should not be null.", node.getAttribute("xmi.id"));

		assertEquals("Equal is expected.", "p", node.getAttribute("presentation"));

		Node n = node.getChildNodes().item(0);
		assertEquals("Equal is expected.", "UML:Uml1SemanticModelBridge.element", n.getNodeName());
		assertEquals("Equal is expected.", 1, n.getChildNodes().getLength());

		Node subNode = n.getFirstChild();

		assertEquals("Equal is expected.", "UML:LinkImpl", subNode.getNodeName());
	}
}