/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.failuretests;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.DebugGraphics;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.*;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>TextNode</code>.
 * </p>
 *
 * @author Hacker_QC
 * @version 1.0
 */
public class TextNodeFailureTest extends TestCase {
    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE = "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * The GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The Uml1SemanticModelBridge instance for helping testing.
     * </p>
     */
    private Uml1SemanticModelBridge usmb;

    /**
     * <p>
     * The text node for testing.
     * </p>
     */
    private MockTextNode textNode;

    /**
     * <p>
     * The offset point for testing.
     * </p>
     */
    private Graphics graphics = new DebugGraphics();

    /**
     * <p>
     * The offset point for testing.
     * </p>
     */
    private Point offset = new Point(0, 0);

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        graphNode = new GraphNode();
        usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        graphNode.setSemanticModel(usmb);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        textNode = new MockTextNode(graphNode, mapping);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        mapping = null;
        graphNode = null;
        usmb = null;
        textNode = null;
    }

    /**
     * <p>
     * Tests constructor TextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTextNodeCtor1() throws Exception {
        try {
            new MockTextNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor TextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTextNodeCtor2() throws Exception {
        try {
            new MockTextNode(graphNode, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor TextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTextNodeCtor3() throws Exception {
        try {
            new MockTextNode(new GraphNode(), null);
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method paintText(Graphics g, Point offset) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaintText1() throws Exception {
        try {
            textNode.paintText(null, offset);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }
    
    /**
     * <p>
     * Tests method paintText(Graphics g, Point offset) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaintText2() throws Exception {
        try {
            textNode.paintText(graphics, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * This mock class is used in the test.
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class MockTextNode extends TextNode {

        /**
         * <p>
         * Constructs an <code>MockAbstractPrint</code> instance.
         * </p>
         *
         * @param graphNode - the graphNode corresponding to this Node
         * @param properties - the porperty mappings.(See corresponding variable doc for details)
         * @throws IllegalArgumentException - if any arg is null
         */
        public MockTextNode(GraphNode graphNode, PropertyMapping properties) {
            super(graphNode, properties);
        }

        /**
         * <p>
         * Get the text to dispaly. It should be implemented by concrete <code>Node</code>.
         * </p>
         *
         * @return the text to be display.
         */
        public String getText() {
            return null;
        }

        /**
         * <p>
         * This method is used to calculate the preferred size if the text is changed to given
         * value. It should be implemented by concrete Node.
         * </p>
         *
         * <p>
         * <code>Null</code> wil be treated as empty string.
         * </p>
         *
         * @return the preferred node size for given text.
         *
         * @param text - the new text to be used.
         */
        public Dimension getPreferredSize(String text) {
            return null;
        }

        /**
         * <p>
         * Notify the <code>graphNode</code> or its contained value is changed. Maybe the node
         * should be resized.
         * </p>
         *
         * @throws IllegalGraphNodeException - if the graphNode is illegal to update.
         */
        public void notifyUpdate() throws IllegalGraphNodeException {
        }

        /**
         * <p>
         * Paint text on the graphics, the left up corner is defined by offset. This is method can
         * be used by subclass to paint the node.
         * </p>
         *
         * @param g - the graphics to paint on
         * @param offset - the offest value.
         *
         * @throws IllegalArgumentException - if any arg is null.
         */
        public void paintText(Graphics g, Point offset) {
            super.paintText(g, offset);
        }
    }
}
