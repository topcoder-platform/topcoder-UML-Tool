package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import javax.swing.TransferHandler;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNodeConnector;

import junit.framework.TestCase;

/**
 * Failure tests for PackageNodeConnector class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class PackageNodeConnectorFailureTests extends TestCase {
    /**
     * The PackageNodeConnector instance to test against.
     */
    private PackageNodeConnector packageNodeConnector;

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        GraphNode graphNode = FailureTestHelper.createPackageGraphNode(new Point(50, 50), new Dimension(20, 20));
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = FailureTestHelper.createProperties();

        PackageNode packageNode = new PackageNode(graphNode, properties, new TransferHandler(null));

        packageNodeConnector = new PackageNodeConnector(packageNode);
    }

    /**
     * Tests the constructor PackageNodeConnector(ClassNode) with null parent, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullParent() throws Exception {
        try {
            new PackageNodeConnector(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the method getConnectionPoint(Point) with null wayPoint, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testGetConnectionPoint_NullWayPoint() throws Exception {
        try {
            packageNodeConnector.getConnectionPoint(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
