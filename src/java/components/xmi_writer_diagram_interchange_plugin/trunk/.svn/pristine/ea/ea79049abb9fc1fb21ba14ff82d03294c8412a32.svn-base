/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.CoreSemanticModelBridge;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.CoreSemanticModelBridgeTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>CoreSemanticModelBridgeTransformer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestCoreSemanticModelBridgeTransformerAccuracy extends TestCase {

	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new CoreSemanticModelBridgeTransformer();

	/**
     * Represents the document instance for testing.
     */
	private Document document;

	/**
     * Represents the Diagram2XMITransformer instance for testing.
     */
	private static Diagram2XMITransformer trans = null;

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
		trans = Util.createDiagram2XMITransformer();

		transformerMap.put(TransformerType.Diagram, trans);
		transformerMap.put(TransformerType.Model, trans);
		transformerMap.put(TransformerType.ActivityGraph, trans);
		transformerMap.put(TransformerType.Header, trans);

		trans.setXMIWriter(new XMIWriter(new UMLModelManager(), transformerMap));
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
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_1() throws Exception {
		CoreSemanticModelBridge modelBridge = new CoreSemanticModelBridge();
		modelBridge.setPresentation("review");

		Node ret = transformer.transform(modelBridge, document, trans);

		assertEquals("The name should be 'UML:CoreSemanticModelBridge'", "UML:CoreSemanticModelBridge", ret
				.getNodeName());

		NamedNodeMap map = ret.getAttributes();
		// the id should be generated.
		assertNotNull("The id should be generated.", map.getNamedItem("xmi.id").getNodeValue());
		assertEquals("The presentation should be 'review'", "review", map.getNamedItem("presentation").getNodeValue());
	}


	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_2() throws Exception {


		CoreSemanticModelBridge modelBridge = new CoreSemanticModelBridge();
		modelBridge.setPresentation("review");

		trans = Util.createDiagram2XMITransformer();

		transformerMap.put(TransformerType.Diagram, trans);
		transformerMap.put(TransformerType.Model, trans);
		transformerMap.put(TransformerType.ActivityGraph, trans);
		transformerMap.put(TransformerType.Header, trans);

		XMIWriter writer = new XMIWriter(new UMLModelManager(), transformerMap);
		writer.putElementId(modelBridge, "MyId");
		trans.setXMIWriter(writer);


		Node ret = transformer.transform(modelBridge, document, trans);

		assertEquals("The name should be 'UML:CoreSemanticModelBridge'", "UML:CoreSemanticModelBridge", ret
				.getNodeName());

		NamedNodeMap map = ret.getAttributes();
		assertNotNull("The id should be generated.", map.getNamedItem("xmi.id").getNodeValue());
		assertEquals("The id should be 'MyId'", "MyId", map.getNamedItem("xmi.id").getNodeValue());
		assertEquals("The presentation should be 'review'", "review", map.getNamedItem("presentation").getNodeValue());
	}
}
