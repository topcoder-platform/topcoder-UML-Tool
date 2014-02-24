package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;

/**
 * Failure tests for TextField class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class TextFieldFailureTests extends TestCase {
    /**
     * The TextField instance to test against.
     */
    private TextField textField;

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

        textField = new TextField(graphNode);
    }

    /**
     * Test the constructor TextField(GraphNode) with null graphNode, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullGraphNode() throws Exception {
        try {
            new TextField(null);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor TextField(GraphNode, AnchorType) with null graphNode, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullGraphNode2() throws Exception {
        try {
            new TextField(null, AnchorType.Line);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor TextField(GraphNode, AnchorType) with null anchorType, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullAnchorType() throws Exception {
        try {
            new TextField(graphNode, null);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method measureSize(String) with null text, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testMeasureSize_NullText() throws Exception {
        try {
            textField.measureSize(null);
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
