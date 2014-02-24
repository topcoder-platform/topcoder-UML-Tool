/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.*;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>FreeTextNode</code>.
 * </p>
 *
 * @author Hacker_QC
 * @version 1.0
 */
public class FreeTextNodeFailureTest extends TestCase {

    /**
     * <p>
     * Constant for text "FreeText".
     * </p>
     */
    private static final String FREE_TEXT = "FreeText";

    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The FreeTextNode instance for helping testing.
     * </p>
     */
    private FreeTextNode node;

    /**
     * <p>
     * The com.topcoder.diagraminterchange.Dimension instance for helping testing.
     * </p>
     */
    private com.topcoder.diagraminterchange.Dimension dimension;

    /**
     * <p>
     * The GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The SimpleSemanticModelElement instance for helping testing.
     * </p>
     */
    private SimpleSemanticModelElement ssme;

    /**
     * <p>
     * The TextElement instance for helping testing.
     * </p>
     */
    private TextElement textElement;

    /**
     * <p>
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        graphNode = new GraphNode();
        ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo(FREE_TEXT);
        graphNode.setSemanticModel(ssme);
        textElement = new TextElement();
        textElement.setText("FreeTextNode\ntest");
        graphNode.addContained(textElement);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(300);
        dimension.setHeight(100);
        graphNode.setSize(dimension);
        node = new FreeTextNode(graphNode, mapping);
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
        textElement = null;
        ssme = null;
        dimension = null;
        node = null;
    }

    /**
     * <p>
     * Tests constructor FreeTextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFreeTextNodeCtor1() throws Exception {
        try {
            new FreeTextNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor FreeTextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFreeTextNodeCtor2() throws Exception {
        try {
            new FreeTextNode(graphNode, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor FreeTextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFreeTextNodeCtor3() throws Exception {
        try {
            new FreeTextNode(new GraphNode(), mapping);
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method getPreferredSize(String text) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testgetPreferredSize1() throws Exception {
        try {
            this.node.getPreferredSize(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }
}
