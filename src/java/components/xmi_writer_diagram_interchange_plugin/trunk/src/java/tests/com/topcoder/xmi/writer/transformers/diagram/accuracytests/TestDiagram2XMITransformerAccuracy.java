/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>Diagram2XMITransformer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestDiagram2XMITransformerAccuracy extends TestCase {
	/**
     * Represents the Diagram2XMITransformer instance for testing.
     */
	private Diagram2XMITransformer caller = null;

	/**
     * The transformers map for XMIWriter object.
     */
	private final Map<TransformerType, XMITransformer> transformerMap = new HashMap<TransformerType, XMITransformer>();

	/**
     * Set up the environment.
     *
     * @throws Exception
     *             to junit.
     */
	public void setUp() throws Exception {
		caller = Util.createDiagram2XMITransformer();

		transformerMap.put(TransformerType.Diagram, caller);
		transformerMap.put(TransformerType.Model, caller);
		transformerMap.put(TransformerType.ActivityGraph, caller);
		transformerMap.put(TransformerType.Header, caller);

		caller.setXMIWriter(new XMIWriter(new UMLModelManager(), transformerMap));

	}

	/**
     * Tear down the environment.
     *
     * @throws Exception
     *             to junit.
     */
	public void tearDown() throws Exception {
		caller = null;
	}

	/**
     * Test constructor <code>
	 * Diagram2XMITransformer(Map <String, DiagramInterchangeElementTransformer> transformers,
	 *  Map <String, String> tagNameMappings) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testDiagram2XMITransformerCtro1() throws Exception {
		assertNotNull("Should not be null.", new Diagram2XMITransformer(Util.createTransMap(), Util
				.createTagNameMapping()));
	}

	/**
     * Test the second constructor.
     *
     * @throws Exception
     *             to junit.
     */
	public void testDiagram2XMITransformerCtr2() throws Exception {
		assertNotNull("Should not be null.", new Diagram2XMITransformer(Util.createTransMap(), Util
				.createTagNameMapping(), TransformerFactory.newInstance().newTransformer(), true));
	}

	/**
     * Test method <code> transform(Object element, PrintStream out) </code>.
     *
     * <p>
     * Please refer to test cases for each elementtransformers class.
     * </p>
     *
     * @throws Exception
     *             to junit.
     *
     */
	public void testTransformObjectPrintStream() throws Exception {
		GraphElement element = new GraphNode();
		element.addProperty(new Property());
		element.addReference(new Reference());
		element.addLink(new DiagramLink());
		element.addContained(new GraphNode());
		element.addAnchorage(new GraphConnector());
		element.setVisible(false);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(out);

		caller.transform(element, stream);

		assertTrue("True is expected.", stream.toString().length() > 0);

		out.close();
	}

	/**
     * Test method <code>Node transform(Object element, Document document) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransformObjectDocument() throws Exception {
		Point p = new Point();
		p.setX(1);
		p.setY(100);

		Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

		Element node = (Element) caller.transform(p, d);

		assertNotNull("Should not be null.", node);
		assertEquals("Equal is expected.", "UML:Point", node.getNodeName());
		assertTrue("True is expected.", 1 == Double.parseDouble(node.getAttribute("x")));
		assertTrue("True is expected.", 100 == Double.parseDouble(node.getAttribute("y")));
	}

	/**
     * Test method <code>String resolveID(Object element) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testResolveID_1() throws Exception {
		caller = Util.createDiagram2XMITransformer();

		transformerMap.put(TransformerType.Diagram, caller);
		transformerMap.put(TransformerType.Model, caller);
		transformerMap.put(TransformerType.ActivityGraph, caller);
		transformerMap.put(TransformerType.Header, caller);

		GraphNode node = new GraphNode();

		XMIWriter writer = new XMIWriter(new UMLModelManager(), transformerMap);
		writer.putElementId(node, "id");
		caller.setXMIWriter(writer);

		String ret = caller.resolveID(node);

		assertEquals("Equal is expected.", "id", ret);
	}

	/**
     * Test method <code>String resolveID(Object element) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testResolveID_2() throws Exception {

		GraphNode node = new GraphNode();

		String ret = caller.resolveID(node);

		assertNotNull("The id should be got.", ret);
	}

	/**
     * Test method <code>boolean isWithExceptions() </code>.
     *
     */
	public void testIsWithExceptions() {
		assertTrue("The default value should be true.", caller.isWithExceptions());
	}

	/**
     * Test method <code>void setWithExceptions(boolean noSuppress) </code>.
     *
     */
	public void testSetWithExceptions() {
		caller.setWithExceptions(false);
		assertFalse("It is set to false now.", caller.isWithExceptions());

		caller.setWithExceptions(true);
		assertTrue("It is set to true now.", caller.isWithExceptions());
	}

	/**
     * Test method <code>Transformer getXMLTransformer() </code>.
     *
     */
	public void testGetXMLTransformer() {
		assertNotNull("Should not be null.", caller.getXMLTransformer());
	}

	/**
     * Test method <code>Transformer getXMLTransformer() </code>.
     *
     */
	public void testGetElementTransformer() {
		assertNotNull("Should not be null.", caller.getElementTransformers());
	}

	/**
     * Test method <code>DiagramInterchangeElementTransformer getElementTransformer(String className) </code>.
     *
     * @throws Exception
     *             to junit.
     */
	public void testGetElementTransformers() throws Exception {
		Map map = Util.createTransMap();
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Entry) iter.next();

			String key = entry.getKey().toString();

			String value = entry.getValue().getClass().getName();

			String ret = caller.getElementTransformer(key).getClass().getName();

			assertEquals("Equal is expected.", value, ret);
		}
	}

	/**
	 * Test method <code>String getTagName(String classname) </code>.
	 *
	 * @throws Exception to junit.
	 */
	public void testGetTagName() throws Exception {
		Map map = Util.createTagNameMapping();
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Entry) iter.next();

			String key = entry.getKey().toString();

			String value = entry.getValue().toString();

			String ret = caller.getTagName(key).toString();

			assertEquals("Equal is expected.", value, ret);
		}

	}

}
