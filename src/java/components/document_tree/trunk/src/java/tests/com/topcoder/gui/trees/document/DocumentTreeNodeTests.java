/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.statemachines.GuardImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreeNode.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class DocumentTreeNodeTests extends TestCase {
    /**
     * <p>
     * The DocumentTreeNode instance for testing.
     * </p>
     */
    private DocumentTreeNode node;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        node = new DocumentTreeNode("name");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        node = null;
        super.tearDown();
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeNodeTests.class);
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNode#DocumentTreeNode(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created DocumentTreeNode instance should not be null.
     * </p>
     */
    public void testCtor1() {
        ModelElement element = new GuardImpl();
        assertNotNull("Failed to create a new DocumentTreeNode instance.", new DocumentTreeNode(element));
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNode#DocumentTreeNode(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullModelElement() {
        try {
            new DocumentTreeNode((ModelElement) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNode#DocumentTreeNode(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created DocumentTreeNode instance should not be null.
     * </p>
     */
    public void testCtor2() {
        GraphElement element = new GraphNode();
        assertNotNull("Failed to create a new DocumentTreeNode instance.", new DocumentTreeNode(element));
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNode#DocumentTreeNode(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullGraphElement() {
        try {
            new DocumentTreeNode((GraphElement) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNode#DocumentTreeNode(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created DocumentTreeNode instance should not be null.
     * </p>
     */
    public void testCtor3() {
        assertNotNull("Failed to create a new DocumentTreeNode instance.", node);
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNode#DocumentTreeNode(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when diagramCategoryName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor3_NullDiagramCategoryName() {
        try {
            new DocumentTreeNode((String) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNode#DocumentTreeNode(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when diagramCategoryName is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor3_EmptyDiagramCategoryName() {
        try {
            new DocumentTreeNode(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeNode#getNodeObject() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeNode#getNodeObject() is correct.
     * </p>
     */
    public void testGetNodeObject() {
        assertEquals("Failed to get the node object correctly.", "name", node.getNodeObject());
    }

    /**
     * <p>
     * Tests DocumentTreeNode#hashCode() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeNode#hashCode() is correct.
     * </p>
     */
    public void testHashCode() {
        assertEquals("Failed to get the hash code correctly.", 3373707, node.hashCode());
    }

    /**
     * <p>
     * Tests DocumentTreeNode#equals(Object) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when object is equal to this node object and returns true.
     * </p>
     */
    public void testEquals_true() {
        assertTrue("Failed to return the value correctly.", node.equals(node));
    }

    /**
     * <p>
     * Tests DocumentTreeNode#equals(Object) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when object is equal to this node object and returns false.
     * </p>
     */
    public void testEquals_false() {
        assertFalse("Failed to return the value correctly.", node.equals("test"));
    }

    /**
     * <p>
     * Tests DocumentTreeNode#equals(Object) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when object is null and returns false.
     * </p>
     */
    public void testEquals_NullObject() {
        assertFalse("Failed to return the value correctly.", node.equals(null));
    }

    /**
     * <p>
     * Tests DocumentTreeNode#toString() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the node is for diagram category and verifies
     * DocumentTreeNode#toString() is correct.
     * </p>
     */
    public void testToString_DiagramCategoryNode() {
        assertEquals("Failed to return the value correctly.", "name", node.toString());
    }

    /**
     * <p>
     * Tests DocumentTreeNode#toString() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the node is for model element and verifies
     * DocumentTreeNode#toString() is correct.
     * </p>
     */
    public void testToString_ModelElementNode() {
        Class clasz = new ClassImpl();
        clasz.setName("ModelPackage");
        node = new DocumentTreeNode(clasz);

        assertEquals("Failed to return the value correctly.", "ModelPackage", node.toString());
    }

    /**
     * <p>
     * Tests DocumentTreeNode#toString() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the node is for graph element and verifies
     * DocumentTreeNode#toString() is correct.
     * </p>
     */
    public void testToString_GraphElementNode() {
        Diagram diagram = new Diagram();
        diagram.setName("UseCaseDiagram");
        node = new DocumentTreeNode(diagram);

        assertEquals("Failed to return the value correctly.", "UseCaseDiagram", node.toString());
    }

    /**
     * <p>
     * Tests DocumentTreeNode#toString() for failure.
     * </p>
     *
     * <p>
     * Semantic model of the graph element is not of Uml1SemanticModelBridge and expects IllegalStateException.
     * </p>
     */
    public void testToString_NonUml1SemanticModelBridge() {
        node = new DocumentTreeNode(new GraphEdge());

        try {
            node.toString();
            fail("IllegalStateException Expected.");
        } catch (IllegalStateException e) {
            // goo
        }
    }

    /**
     * <p>
     * Tests DocumentTreeNode#toString() for failure.
     * </p>
     *
     * <p>
     * The element of the semantic model is not of ModelElement type when the type is GRAPH_ELEMENT and
     * not Diagram, expects IllegalStateException.
     * </p>
     */
    public void testToString_NonModelElement() {
        GraphElement graphElement = new GraphEdge();
        graphElement.setSemanticModel(new Uml1SemanticModelBridge());
        node = new DocumentTreeNode(graphElement);

        try {
            node.toString();
            fail("IllegalStateException Expected.");
        } catch (IllegalStateException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeNode#getType() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeNode#getType() is correct.
     * </p>
     */
    public void testGetType() {
        assertEquals("Failed to get the type correctly.", DocumentTreeNodeType.DIAGRAM_CATEGORY, node.getType());
    }

}