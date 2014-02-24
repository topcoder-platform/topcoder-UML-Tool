/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramElementTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>DiagramElementTransformer </code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class TestDiagramElementTransformerAccuracy extends TestCase {

	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new DiagramElementTransformer();

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
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_1() throws Exception {
		GraphNode graphNode = new GraphNode();
		graphNode.setVisible(true);

		Dimension d = new Dimension();
		d.setHeight(11.1);
		d.setWidth(10.1);

		graphNode.setSize(d);

		Element ret = (Element) transformer.transform(graphNode, document, caller);

		assertEquals("The name should be 'UML:DiagramElement'", "UML:DiagramElement", ret.getNodeName());
		NamedNodeMap map = ret.getAttributes();
		assertNotNull("The id should not be null.", map.getNamedItem("xmi.id"));
		assertEquals("Incorrect visible attribute", "true", map.getNamedItem("visible").getNodeValue());
	}

	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_2() throws Exception {
		GraphNode graphNode = new GraphNode();
		graphNode.setVisible(true);

		Property property = new Property();
		property.setKey("key");
		property.setValue("value");

		graphNode.addProperty(property);

		Element ret = (Element) transformer.transform(graphNode, document, caller);

		assertEquals("The name should be 'UML:DiagramElement'", "UML:DiagramElement", ret.getNodeName());
		NamedNodeMap map = ret.getAttributes();
		assertNotNull("The id should not be null.", map.getNamedItem("xmi.id"));
		assertEquals("Incorrect visible attribute", "true", map.getNamedItem("visible").getNodeValue());

		Node node = ret.getChildNodes().item(0);

		assertEquals("The name should be 'UML:DiagramElement.property'", "UML:DiagramElement.property", node
				.getNodeName());

		Node subNode = node.getChildNodes().item(0);

		map = subNode.getAttributes();
		assertEquals("There should be 2 attributes.", 2, map.getLength());
		assertTrue("The key should be 'key'", map.getNamedItem("key").toString().contains("key"));
		assertTrue("The value should be 'value'", map.getNamedItem("value").toString().contains("value"));
	}

	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_3() throws Exception {
		GraphNode graphNode = new GraphNode();
		graphNode.setVisible(true);

		Reference reference = new Reference();
		reference.setVisible(true);

		graphNode.addReference(reference);

		Element ret = (Element) transformer.transform(graphNode, document, caller);

		assertEquals("The name should be 'UML:DiagramElement'", "UML:DiagramElement", ret.getNodeName());
		NamedNodeMap map = ret.getAttributes();
		assertNotNull("The id should not be null.", map.getNamedItem("xmi.id"));
		assertEquals("Incorrect visible attribute", "true", map.getNamedItem("visible").getNodeValue());

		Node node = ret.getElementsByTagName("UML:DiagramElement.reference").item(0);

		Node subNode = node.getChildNodes().item(0);

		assertEquals("The name should be 'UML:Reference'", "UML:Reference", subNode.getNodeName());
	}

	/**
     * Test method <code>Node transform(Object element, Document document, Diagram2XMITransformer caller) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_4() throws Exception {
		GraphNode graphNode = new GraphNode();
		graphNode.setVisible(true);

		Reference reference = new Reference();
		reference.setVisible(true);

		graphNode.addReference(reference);
		graphNode.addReference(new Reference());

		graphNode.addProperty(new Property());
		graphNode.addProperty(new Property());

		Element ret = (Element) transformer.transform(graphNode, document, caller);

		assertEquals("The name should be 'UML:DiagramElement'", "UML:DiagramElement", ret.getNodeName());
		NamedNodeMap map = ret.getAttributes();
		assertNotNull("The id should not be null.", map.getNamedItem("xmi.id"));
		assertEquals("Incorrect visible attribute", "true", map.getNamedItem("visible").getNodeValue());

		Node node = ret.getElementsByTagName("UML:DiagramElement.reference").item(0);

		Node subNode = node.getChildNodes().item(0);

		assertEquals("The name should be 'UML:Reference'", "UML:Reference", subNode.getNodeName());

		System.out.println("Printing the result for:");
		System.out.println("GraphNode graphNode = new GraphNode();");
		System.out.println("graphNode.setVisible(true);");
		System.out.println("Reference reference = new Reference();");
		System.out.println("reference.setVisible(true);");
		System.out.println("graphNode.addReference(new Reference());");
		System.out.println("graphNode.addProperty(new Property())");
		System.out.println("graphNode.addProperty(new Property())");
		System.out.println("");
		caller.transform(graphNode, System.out);
		System.out.println("End of printing the result in xml format!");
		System.out.println();

		int number = ret.getElementsByTagName("UML:DiagramElement.reference").getLength();

		if (number == graphNode.getReferences().size()) {
			/*
             * <UML:DiagramElement.reference> reference1 </UML:DiagramElement.reference>
             * <UML:DiagramElement.reference> reference2 </UML:DiagramElement.reference>
             */
			NodeList list1 = ret.getElementsByTagName("UML:DiagramElement.reference");
			for (int i = 0; i < list1.getLength(); i++) {
				Node eachElement = list1.item(i);
				assertEquals("Equal is expected.", "UML:Reference", eachElement.getNodeName());
			}
		} else {

			/*
             * The structure should be
             * <UML:DiagramElement.reference>
             *   Reference 1 Reference 2 ...
             * </UML:DiagramElement.reference>
             */
			Node referenceNodes = ret.getElementsByTagName("UML:DiagramElement.reference").item(0);

			assertTrue("Should be only one node.",
					ret.getElementsByTagName("UML:DiagramElement.reference").getLength() == 1);

			assertEquals("Equal is expected.", graphNode.getReferences().size(),
					referenceNodes.getChildNodes().getLength());
		}
	}
}
