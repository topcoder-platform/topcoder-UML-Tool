/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.MockDiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.MockXMITransformer;

/**
 * <p>
 * Unit test cases for StructureXMLNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StructureXMLNodeTest extends TestCase {
    /**
     * <p>
     * Represents the name of the UML node.
     * </p>
     */
    private final String tagName = "UML:Test";

    /**
     * <p>
     * Represents the name of child node of the UML node.
     * </p>
     */
    private final String subTagName = "UML:Test.test";

    /**
     * <p>
     * Represents the name of child node of the UML node as a reference node.
     * </p>
     */
    private final String refTagName = "UML:Test.test.ref";

    /**
     * <p>
     * Document instance used for testing.
     * </p>
     */
    private Document document;

    /**
     * <p>
     * Diagram2XMITransformer instance used for testing.
     * </p>
     */
    private Diagram2XMITransformer d2XMITransformer;

    /**
     * <p>
     * DiagramInterchangeElementTransformer instance used for testing.
     * </p>
     */
    private MockDiagramInterchangeElementTransformer mockTransformer;

    /**
     * <p>
     * Map< String, DiagramInterchangeElementTransformer> instance used for testing.
     * </p>
     */
    private Map < String, DiagramInterchangeElementTransformer > transformers;

    /**
     * <p>
     * Map< String, String> instance used for testing.
     * </p>
     */
    private Map < String, String > tagNameMaping;

    /**
     * <p>
     * XMIWriter used for testing.
     * </p>
     */
    private XMIWriter xmiWriter;

    /**
     * <p>
     * StructureXMLNode node used for testing.
     * </p>
     */
    private StructureXMLNode node;

    /**
     * <p>
     * Object element used for testing.
     * </p>
     */
    private final Object element = new Object();

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(StructureXMLNodeTest.class);
    }

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to Junit
     *
     */
    protected void setUp() throws Exception {
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        transformers = new HashMap < String, DiagramInterchangeElementTransformer >();
        mockTransformer = new MockDiagramInterchangeElementTransformer();
        transformers.put(element.getClass().getName(), mockTransformer);
        tagNameMaping = new HashMap < String, String >();
        d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMaping);
        
        Map<TransformerType, XMITransformer> xmiTransformers = new HashMap < TransformerType, XMITransformer >();
        xmiTransformers.put(TransformerType.Model,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.ActivityGraph,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.Diagram,  new MockXMITransformer());
        
        xmiWriter = new XMIWriter(new UMLModelManager(), xmiTransformers);
        d2XMITransformer.setXMIWriter(xmiWriter);
        node = new StructureXMLNode(tagName, document, d2XMITransformer);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        document = null;
        transformers = null;
        mockTransformer = null;
        xmiWriter = null;
        d2XMITransformer = null;
        node = null;
    }

    /**
     * <p>
     * Test Constructor for 'StructureXMLNode(String, Document, Diagram2XMITransformer)' for accuracy.
     * </p>
     * <p>
     * Verify : StructureXMLNode(String, Document, Diagram2XMITransformer) is correct
     * </p>
     * @throws XMITransformException to Junit
     */
    public void testStructureXMLNode() throws XMITransformException {
        assertNotNull("Fail to create a StructureXMLNode instance", node);
        assertEquals("The tagName is incorrect.", tagName, node.getNode().getNodeName());
    }

    /**
     * <p>
     * Test Constructor for 'StructureXMLNode(String, Document, Diagram2XMITransformer)' for failure.
     * </p>
     * <p>
     * It tests the case that the tagName is empty and expects XMITransformException.
     * </p>
     */
    public void testStructureXMLNodeWithInvalidTagName() {
        try {
            new StructureXMLNode("  ", document, d2XMITransformer);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good.
        }
    }

    /**
     * <p>
     * Test Constructor for 'StructureXMLNode(String, Document, Diagram2XMITransformer)' for failure.
     * </p>
     * <p>
     * It tests the case that the tagName is null and expects IllegalArgumentException.
     * </p>
     * @throws XMITransformException to Junit
     */
    public void testStructureXMLNodeWithNullTagName() throws XMITransformException {
        try {
            new StructureXMLNode(null, document, d2XMITransformer);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * Test Constructor for 'StructureXMLNode(String, Document, Diagram2XMITransformer)' for failure.
     * </p>
     * <p>
     * It tests the case that the document is null and expects IllegalArgumentException.
     * </p>
     * @throws XMITransformException to Junit
     */
    public void testStructureXMLNodeWithNullDocument() throws XMITransformException {
        try {
            new StructureXMLNode(tagName, null, d2XMITransformer);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * Test Constructor for 'StructureXMLNode(String, Document, Diagram2XMITransformer)' for failure.
     * </p>
     * <p>
     * It tests the case that the d2XMITransformer is null and expects IllegalArgumentException.
     * </p>
     * @throws XMITransformException to Junit
     */
    public void testStructureXMLNodeWithNullTransformer() throws XMITransformException {
        try {
            new StructureXMLNode(tagName, document, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * Test method for 'setAttribute(String, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : setAttribute(String, String) is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testSetAttribute() throws Exception {
        node.setAttribute("name", "value");
        Node inode = node.getNode();
        NamedNodeMap attrMap = inode.getAttributes();
        assertEquals("The size of the attributes should be 1.", attrMap.getLength(), 1);
        Node attr = attrMap.getNamedItem("name");
        assertNotNull("The key attribute should not be null.", attr);
        assertEquals("The name of the attribute should not be 'key'.", "name", attr.getNodeName());
        assertEquals("The value of the attribute should not be 'value'.", "value", attr.getNodeValue());
    }

    /**
     * <p>
     * Test method for 'setAttribute(String, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the name is null and expects XMITransformException
     * </p>
     */
    public void testSetAttributeWithNullName() {
        try {
            node.setAttribute(null, "value");
            fail("XMITransformException is expected");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'setAttribute(String, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the value is null and verifies nothing has been done.
     * </p>
     * @throws Exception to Junit
     */
    public void testSetAttributeWithNullValue() throws Exception {
        node.setAttribute("name", null);
        NamedNodeMap attrMap = node.getNode().getAttributes();
        assertEquals("The size of the attributes should be 0.", attrMap.getLength(), 0);
    }


    /**
     * <p>
     * Test method for 'setXmiId(Object)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : setXmiId(Object) is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testSetXmiIdAttribute() throws Exception {
        node.setXmiId(element);
        Node inode = node.getNode();
        NamedNodeMap attrMap = inode.getAttributes();
        assertEquals("The size of the attributes should be 1.", attrMap.getLength(), 1);
        Node attr = attrMap.getNamedItem("xmi.id");
        assertNotNull("The xmi.id attribute should not be null.", attr);
        assertEquals("The xmi.id of the attribute is incorrect.",
                d2XMITransformer.resolveID(element), attr.getNodeValue());
    }

    /**
     * <p>
     * Test method for 'setXmiId(Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the element is null and expects IllegalArgumentException
     * </p>
     * @throws Exception to Junit
     */
    public void testSetXmiIdAttributeWithNullElement() throws Exception {
        try {
            node.setXmiId(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // good
            // withExceptions is true by default, so an IllegalArgumentException should be thrown.
        }
    }

    /**
     * <p>
     * Test method for 'appendChild(String, Object)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : appendChild(String, Object) is correct and a child is appended to the node.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendChild() throws Exception {
        node.appendChild(subTagName, element);
        Node iNode = node.getNode().getFirstChild();
        assertEquals("The tagName is incorrect.", subTagName, iNode.getNodeName());
        // check the transform() method of mockTransformer is invoked.
        assertSame("The two nodes should be the same.", mockTransformer.getNode(), iNode.getFirstChild());
    }

    /**
     * <p>
     * Test method for 'appendChild(String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the transformer could not be found for the element provided and expects
     * XMITransformException.
     * </p>
     */
    public void testAppendChildWithInvalidElement() {
        try {
            node.appendChild(subTagName, new String());
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'appendChild(String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the element is null and expects appendChild(String, Object) does nothing.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendChildWithNullElement() throws Exception {
        node.appendChild(subTagName, null);
        Node iNode = node.getNode().getFirstChild();
        assertNull("The child node should be null.", iNode);
    }

    /**
     * <p>
     * Test method for 'appendChild(String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the tagName is null and expects XMITransformException.
     * </p>
     */
    public void testAppendChildWithNullTagName() {
        try {
            node.appendChild(null, element);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'appendChild(String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the tagName is invalid and expects XMITransformException.
     * </p>
     */
    public void testAppendChildWithInvalidTagName() {
        try {
            node.appendChild("  ", element);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }



    /**
     * <p>
     * Test method for 'appendChildren(String, Collection)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : appendChildren(String, Collection) is correct. It adds a list of the element.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendChildren() throws Exception {
        Collection < Object > collection = new ArrayList < Object >();
        // add two object with different types.
        collection.add(element);
        String element2 = new String();
        MockDiagramInterchangeElementTransformer mockTransformer2 = new MockDiagramInterchangeElementTransformer();
        // associate the element2 with the mockTransformer2
        transformers.put(element2.getClass().getName(), mockTransformer2);
        collection.add(element2);
        node.appendChildren(subTagName, collection);
        NodeList nodeList = node.getNode().getChildNodes();
        assertEquals("The size of the list of node is 1.", 1, nodeList.getLength());
        nodeList = nodeList.item(0).getChildNodes();
        // check the first node.
        // check the transform() method of mockTransformer is invoked.
        assertSame("The two nodes should be the same.", mockTransformer.getNode(), nodeList.item(0));
        // check the second node.
        // check the transform() method of mockTransformer2 is invoked.
        assertSame("The two nodes should be the same.", mockTransformer2.getNode(), nodeList.item(1));
    }

    /**
     * <p>
     * Test method for 'appendChildren(String, Collection)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the collection is null, and verifies that nothing has been done.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendChildrenWithNullCollection() throws Exception {
        node.appendChildren(subTagName, null);
        NodeList nodeList = node.getNode().getChildNodes();
        assertEquals("The size of the nodelist is 0.", 0, nodeList.getLength());
    }

    /**
     * <p>
     * Test method for 'appendChildren(String, Collection)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the collection containing an invalid element and expects XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendChildrenWithInvaidElement() throws Exception {
        Collection < Object > collection = new ArrayList < Object >();
        // add an invalid element
        collection.add(new String());
        try {
            node.appendChildren(subTagName, collection);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'appendRefChild(String, String, Object)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : appendRefChild(String, String, Object) is correct and a child is appended to the node.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendRefChild() throws Exception {
        node.appendRefChild(subTagName, refTagName, element);
        Node iNode = node.getNode().getFirstChild();
        // check the subTagName
        assertEquals("The tagName is incorrect.", subTagName, iNode.getNodeName());
        // check the child node of the iNode is also appended
        iNode = iNode.getFirstChild();
        // check the refTagName
        assertEquals("The tagName is incorrect.", refTagName, iNode.getNodeName());
        // at last check whether the xmi.idref is the same
        assertEquals("The xmi.idref is incorrect.",
                xmiWriter.getElementId(element), iNode.getAttributes().getNamedItem("xmi.idref").getNodeValue());


    }

    /**
     * <p>
     * Test method for 'appendRefChild(String, String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the element is null and expects appendChild(String, Object) does nothing.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendRefChildWithNullElement() throws Exception {
        node.appendRefChild(subTagName, refTagName, null);
        Node iNode = node.getNode().getFirstChild();
        assertNull("The child node should be null.", iNode);
    }

    /**
     * <p>
     * Test method for 'appendRefChild(String, String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the tagName is null and expects XMITransformException.
     * </p>
     */
    public void testAppendRefChildWithNullTagName() {
        try {
            node.appendRefChild(null, refTagName, element);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'appendRefChild(String, String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the tagName is invalid and expects XMITransformException.
     * </p>
     */
    public void testAppendRefChildWithInvalidTagName() {
        try {
            node.appendRefChild("  ", refTagName, element);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'appendRefChild(String, String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the refTagName is null and expects XMITransformException.
     * </p>
     */
    public void testAppendRefChildWithNullRefTagName() {
        try {
            node.appendRefChild(subTagName, null, element);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'appendRefChild(String, String, Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the refTagName is invalid and expects XMITransformException.
     * </p>
     */
    public void testAppendRefChildWithInvalidRefTagName() {
        try {
            node.appendRefChild(subTagName, "  ", element);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'appendRefChildren(String, String, Collection)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : appendRefChildren(String, String, Collection) is correct. It adds a list of the element.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendRefChildren() throws Exception {
        Collection < Object > collection = new ArrayList < Object >();
        collection.add(element);
        Object element2 = new Object();
        collection.add(element2);
        node.appendRefChildren(subTagName, refTagName, collection);
        NodeList nodeList = node.getNode().getChildNodes();
        assertEquals("The size of the nodelist is 1.", 1, nodeList.getLength());
        // check the first element node.
        nodeList = nodeList.item(0).getChildNodes();
        Node iNode = nodeList.item(0);
        assertEquals("The tagName is incorrect.", refTagName, iNode.getNodeName());
        // check whether the xmi.idref is the same
        assertEquals("The xmi.idref is incorrect.",
                xmiWriter.getElementId(element), iNode.getAttributes().getNamedItem("xmi.idref").getNodeValue());
        // check the second element node
        iNode = nodeList.item(1);
        assertEquals("The tagName is incorrect.", refTagName, iNode.getNodeName());
        // check whether the xmi.idref is the same
        assertEquals("The xmi.idref is incorrect.",
                xmiWriter.getElementId(element2), iNode.getAttributes().getNamedItem("xmi.idref").getNodeValue());
    }

    /**
     * <p>
     * Test method for 'appendRefChildren(String, String, Collection)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the collection is null, and verifies that nothing has been done.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendRefChildrenWithNullCollection() throws Exception {
        node.appendRefChildren(subTagName, refTagName, null);
        NodeList nodeList = node.getNode().getChildNodes();
        assertEquals("The size of the nodelist is 0.", 0, nodeList.getLength());
    }

    /**
     * <p>
     * Test method for 'appendChildren(Node)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : appendChildren(Node) is correct. All the child nodes of the node provided is added to the XML node.
     * </p>
     * @throws Exception to Junit
     */
    public void testAppendChildrenNode() throws Exception {
        // create a parentNode with 3 children
        Node parentNode = document.createElement(subTagName);
        parentNode.appendChild(document.createElement(subTagName + ".1"));
        parentNode.appendChild(document.createElement(subTagName + ".2"));
        parentNode.appendChild(document.createElement(subTagName + ".3"));
        // since when we append a node to another node, if the new node is already in the tree, it is first removed.
        // so here we clone the parentNode before appending.
        Node cloneNode = parentNode.cloneNode(true);
        // append it
        node.appendChildren(parentNode);
        NodeList cloneList = cloneNode.getChildNodes();
        NodeList list = node.getNode().getChildNodes();
        // now we check it, here we only check the tagName of the child nodes, as the original nodes is not equal
        // any more after appending.
        assertEquals("The number of the child nodes should be equal.", list.getLength(), cloneList.getLength());
        int len = list.getLength();
        for (int i = 0; i < len; i++) {
            assertEquals("The name of the child node should be the same.",
                list.item(i).getNodeName(), cloneList.item(i).getNodeName());
        }
    }

    /**
     * <p>
     * Test method for 'getNode()' for accuracy.
     * </p>
     *
     * <p>
     * Verify : getNode() is correct.
     * </p>
     */
    public void testGetNode() {
        // the node is not null by default
        Node iNode = node.getNode();
        assertNotNull("The node should not be null by default", iNode);
        // its tagName is the same as 'tagName' by default
        assertEquals("The tagName of the node should be '" + tagName + "'", tagName, iNode.getNodeName());
    }

}
