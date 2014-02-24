package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import javax.swing.TransferHandler;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;

import junit.framework.TestCase;

/**
 * Failure tests for PackageNode class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class PackageNodeFailureTests extends TestCase {
    /**
     * The PackageNode instance to test against.
     */
    private PackageNode packageNode;

    /**
     * The GraphNode instance for testing.
     */
    private GraphNode graphNode;

    /**
     * The properties for testing.
     */
    private Map<String, String> properties;

    /**
     * The TransferHandler instance for testing.
     */
    private TransferHandler handler;

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        graphNode = FailureTestHelper.createPackageGraphNode(new Point(50, 50), new Dimension(20, 20));
        graphNode.setContainer(new GraphNode());
        handler = new TransferHandler(null);

        properties = FailureTestHelper.createProperties();

        packageNode = new PackageNode(graphNode, properties, handler);
    }

    /**
     * Tests the constructor PackageNode(GraphNode, Map&lt;String, String&gt;) with null graphNode, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullGraphNode() throws Exception {
        try {
            new PackageNode(null, properties, handler);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor PackageNode(GraphNode, Map&lt;String, String&gt;) with null properties, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullProperties() throws Exception {
        try {
            new PackageNode(graphNode, null, handler);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor PackageNode(GraphNode, Map&lt;String, String&gt;) with null handler, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullHandler() throws Exception {
        try {
            new PackageNode(graphNode, properties, null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor PackageNode(GraphNode, Map&lt;String, String&gt;) with null element properties, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullElementProperties() throws Exception {
        properties.put("null", null);
        try {
            new PackageNode(graphNode, properties, handler);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor PackageNode(GraphNode, Map&lt;String, String&gt;) with empty element properties, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_EmptyElementProperties() throws Exception {
        properties.put("empty", "");
        try {
            new PackageNode(graphNode, properties, handler);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the method setTransferHandler(TransferHandler) with null handler, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testSetTransferHandler_NullHandler() {
        try {
            packageNode.setTransferHandler(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
