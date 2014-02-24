package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.EnumerationConnector;
import com.topcoder.gui.diagramviewer.uml.classelements.EnumerationNode;

import junit.framework.TestCase;

/**
 * Failure tests for EnumerationConnector class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class EnumerationConnectorFailureTests extends TestCase {
    /**
     * The EnumerationConnector instance to test against.
     */
    private EnumerationConnector enumerationConnector;

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        GraphNode graphNode = FailureTestHelper.createEnumerationGraphNode(new Point(50, 50), new Dimension(20, 20));
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = FailureTestHelper.createProperties();

        EnumerationNode enumerationNode = new EnumerationNode(graphNode, properties);

        enumerationConnector = new EnumerationConnector(enumerationNode);
    }

    /**
     * Tests the constructor EnumerationConnector(EnumerationNode) with null parent, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullParent() throws Exception {
        try {
            new EnumerationConnector(null);
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
            enumerationConnector.getConnectionPoint(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
