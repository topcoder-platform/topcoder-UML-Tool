package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassConnector;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;

import junit.framework.TestCase;

/**
 * Failure tests for ClassConnector class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class ClassConnectorFailureTests extends TestCase {
    /**
     * The ClassConnector instance to test against.
     */
    private ClassConnector classConnector;

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        GraphNode graphNode = FailureTestHelper.createClassGraphNode(new Point(50, 50), new Dimension(20, 20), false,
                false);
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = FailureTestHelper.createProperties();

        ClassNode classNode = new ClassNode(graphNode, properties);

        classConnector = new ClassConnector(classNode);
    }

    /**
     * Tests the constructor ClassConnector(ClassNode) with null parent, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullParent() throws Exception {
        try {
            new ClassConnector(null);
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
            classConnector.getConnectionPoint(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
