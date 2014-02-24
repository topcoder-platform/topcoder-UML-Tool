/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link DocumentTreeNode} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class DocumentTreeNodeFailureTest extends TestCase {

    /**
     * DocumentTreeNode for testing.
     */
    private DocumentTreeNode documentTreeNode = null;

    /**
     * <p>
     * Sets up the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        documentTreeNode = new DocumentTreeNode(new GraphEdge());
    }

    /**
     * <p>
     * Tears down the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        documentTreeNode = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeNodeFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeNode#DocumentTreeNode(GraphElement)} constructor with graphElement as
     * null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeNode() throws Exception {
        try {
            new DocumentTreeNode((GraphElement) null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeNode#DocumentTreeNode(ModelElement)} constructor with modelElement as
     * null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeNode1() throws Exception {
        try {
            new DocumentTreeNode((ModelElement) null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeNode#DocumentTreeNode(String)} constructor with diagramCategoryName
     * as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeNode2() throws Exception {
        try {
            new DocumentTreeNode((String) null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeNode#DocumentTreeNode(String)} constructor with diagramCategoryName
     * as Empty string.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeNode3() throws Exception {
        try {
            new DocumentTreeNode("");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeNode#DocumentTreeNode(String)} constructor with diagramCategoryName
     * as Empty string with only spaces.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeNode4() throws Exception {
        try {
            new DocumentTreeNode("  ");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeNode#toString()} method.
     * </p>
     * <p>
     * Semantic model of the graph element is not of Uml1SemanticModelBridge
     * </p>
     * <p>
     * {@link IllegalStateException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuretoString() throws Exception {
        try {
            documentTreeNode.toString();
            fail("IllegalStateException Expected.");
        } catch (IllegalStateException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeNode#toString()} method.
     * </p>
     * <p>
     * The element of the semantic model is not of ModelElement type when the type is GRAPH_ELEMENT and
     * not {@link Diagram}
     * </p>
     * <p>
     * {@link IllegalStateException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuretoString1() throws Exception {
        try {
            GraphElement graphElement = new GraphEdge();
            graphElement.setSemanticModel(new Uml1SemanticModelBridge());
            new DocumentTreeNode(graphElement).toString();
            fail("IllegalStateException Expected.");
        } catch (IllegalStateException e) {
            // As expected.
        }
    }
}
