/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.lang.reflect.Field;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeNodeType;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>DocumentTreeNode</code>.
 * 
 * @author enefem21
 * @version 1.0
 */
public class DocumentTreeNodeTest extends TestCase {

    /** Unit under test. */
    private DocumentTreeNode documentTreeNode1;

    /** Unit under test. */
    private DocumentTreeNode documentTreeNode2;

    /** Unit under test. */
    private DocumentTreeNode documentTreeNode3;

    /** Diagram used in the unit test. */
    private Diagram diagram;

    /** Class used in the unit test. */
    private com.topcoder.uml.model.core.classifiers.Class clasz;

    /** Diagram name used in the unit test. */
    private String diagramName;
    
    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     *
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeNodeTest.class);
    }

    /**
     * Sets the unit test up.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        diagram = new Diagram();
        diagram.setName("testDiagramName");
        documentTreeNode1 = new DocumentTreeNode(diagram);

        clasz = new ClassImpl();
        clasz.setName("testClassName");
        documentTreeNode2 = new DocumentTreeNode(clasz);

        diagramName = "diagramName";
        documentTreeNode3 = new DocumentTreeNode(diagramName);

    }

    /**
     * Tears the unit test down.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        documentTreeNode1 = null;
        documentTreeNode2 = null;
        documentTreeNode3 = null;

        super.tearDown();
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: all states are as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testDocumentTreeNodeGraphElement() throws Exception {
        Diagram diagram = new Diagram();
        DocumentTreeNode documentTreeNode = new DocumentTreeNode(diagram);

        // check the nodeObject fields
        Field nodeObjectField = DocumentTreeNode.class.getDeclaredField("nodeObject");
        nodeObjectField.setAccessible(true);
        assertEquals("The field is not set as expected", diagram, nodeObjectField.get(documentTreeNode));

        // check the type fields
        Field typeField = DocumentTreeNode.class.getDeclaredField("type");
        typeField.setAccessible(true);
        assertEquals("The field is not set as expected", DocumentTreeNodeType.GRAPH_ELEMENT, typeField
            .get(documentTreeNode));
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: all states are as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testDocumentTreeNodeModelElement() throws Exception {
        com.topcoder.uml.model.core.classifiers.Class clasz = new ClassImpl();
        DocumentTreeNode documentTreeNode = new DocumentTreeNode(clasz);

        // check the nodeObject fields
        Field nodeObjectField = DocumentTreeNode.class.getDeclaredField("nodeObject");
        nodeObjectField.setAccessible(true);
        assertEquals("The field is not set as expected", clasz, nodeObjectField.get(documentTreeNode));

        // check the type fields
        Field typeField = DocumentTreeNode.class.getDeclaredField("type");
        typeField.setAccessible(true);
        assertEquals("The field is not set as expected", DocumentTreeNodeType.MODEL_ELEMENT, typeField
            .get(documentTreeNode));
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: all states are as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testDocumentTreeNodeString() throws Exception {
        DocumentTreeNode documentTreeNode = new DocumentTreeNode("diagramName");

        // check the nodeObject fields
        Field nodeObjectField = DocumentTreeNode.class.getDeclaredField("nodeObject");
        nodeObjectField.setAccessible(true);
        assertEquals("The field is not set as expected", "diagramName", nodeObjectField.get(documentTreeNode));

        // check the type fields
        Field typeField = DocumentTreeNode.class.getDeclaredField("type");
        typeField.setAccessible(true);
        assertEquals("The field is not set as expected", DocumentTreeNodeType.DIAGRAM_CATEGORY, typeField
            .get(documentTreeNode));
    }

    /**
     * Test <code>getType</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetType1() {
        assertEquals("Returned value is not as expected", DocumentTreeNodeType.GRAPH_ELEMENT, documentTreeNode1
            .getType());
    }

    /**
     * Test <code>getType</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetType2() {
        assertEquals("Returned value is not as expected", DocumentTreeNodeType.MODEL_ELEMENT, documentTreeNode2
            .getType());
    }

    /**
     * Test <code>getType</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetType3() {
        assertEquals("Returned value is not as expected", DocumentTreeNodeType.DIAGRAM_CATEGORY, documentTreeNode3
            .getType());
    }

    /**
     * Test <code>getNodeObject</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetNodeObject1() {
        assertEquals("Returned value is not as expected", diagram, documentTreeNode1.getNodeObject());
    }

    /**
     * Test <code>getNodeObject</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetNodeObject2() {
        assertEquals("Returned value is not as expected", clasz, documentTreeNode2.getNodeObject());
    }

    /**
     * Test <code>getNodeObject</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetNodeObject3() {
        assertEquals("Returned value is not as expected", diagramName, documentTreeNode3.getNodeObject());
    }

    /**
     * Test <code>toString</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testToString1() {
        assertEquals("Returned value is not as expected", "testDiagramName", documentTreeNode1.toString());
    }

    /**
     * Test <code>toString</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testToString2() {
        assertEquals("Returned value is not as expected", "testClassName", documentTreeNode2.toString());
    }

    /**
     * Test <code>toString</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testToString3() {
        assertEquals("Returned value is not as expected", "diagramName", documentTreeNode3.toString());
    }

    /**
     * Test <code>equals</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testEqualsObject1() {
        assertTrue("Returned value is not as expected", documentTreeNode3.equals(new DocumentTreeNode(
            "diagramName")));
    }

    /**
     * Test <code>equals</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testEqualsObject2() {
        assertFalse("Returned value is not as expected", documentTreeNode3.equals(new DocumentTreeNode(
            "differentNodeObject")));
    }

    /**
     * Test <code>hashCode</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testHashCode1() {
        assertTrue("Returned value is not as expected", documentTreeNode3.hashCode() == new DocumentTreeNode(
            "diagramName").hashCode());
    }

    /**
     * Test <code>hashCode</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testHashCode2() {
        assertTrue("Returned value is not as expected", documentTreeNode3.hashCode() != new DocumentTreeNode(
            "differentNodeObject").hashCode());
    }

}
