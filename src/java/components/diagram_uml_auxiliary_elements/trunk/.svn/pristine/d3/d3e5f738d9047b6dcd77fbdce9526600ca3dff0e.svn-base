/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.*;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>BaseNode</code>.
 * </p>
 *
 * @author Hacker_QC
 * @version 1.0
 */
public class BaseNodeFailureTest extends TestCase {
    
    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();
    
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
    }
    
    /**
     * <p>
     * Tests constructor BaseNode#BaseNode(GraphNode graphNode, PropertyMapping properties) for
     * failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBaseNodeCtor1() throws Exception {
        try {
            new MockBaseNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }
    
    /**
     * <p>
     * Tests constructor BaseNode#BaseNode(GraphNode graphNode, PropertyMapping properties) for
     * failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBaseNodeCtor2() throws Exception {
        try {
            new MockBaseNode(graphNode, null);
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
    private class MockBaseNode extends BaseNode {
        
        /**
         * <p>
         * Constructs an <code>MockAbstractPrint</code> instance.
         * </p>
         *
         * @param graphNode - the graphNode corresponding to this Node
         * @param properties - the porperty mappings.(See corresponding variable doc for details)
         * @throws IllegalArgumentException - if any arg is null
         */
        public MockBaseNode(GraphNode graphNode, PropertyMapping properties) {
            super(graphNode, properties);
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
    }
}
