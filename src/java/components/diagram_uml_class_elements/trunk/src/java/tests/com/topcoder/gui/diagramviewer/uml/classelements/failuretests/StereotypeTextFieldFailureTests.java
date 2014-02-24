package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;

/**
 * Failure tests for StereotypeTextField class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class StereotypeTextFieldFailureTests extends TestCase {
    /**
     * The GraphNode instance for testing.
     */
    private GraphNode graphNode;

    /**
     * Sets up the test environment.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        graphNode = FailureTestHelper.createClassGraphNode(new Point(50, 50), new Dimension(20, 20), false, false);
        graphNode.setContainer(new GraphNode());
    }

    /**
     * Test the constructor StereotypeTextField(GraphNode) with null graphNode, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullGraphNode() throws Exception {
        try {
            new StereotypeTextField(null);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor StereotypeTextField(GraphNode, AnchorType) with null graphNode, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullGraphNode2() throws Exception {
        try {
            new StereotypeTextField(null, AnchorType.Line);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor StereotypeTextField(GraphNode, AnchorType) with null anchorType, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullAnchorType() throws Exception {
        try {
            new StereotypeTextField(graphNode, null);
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
