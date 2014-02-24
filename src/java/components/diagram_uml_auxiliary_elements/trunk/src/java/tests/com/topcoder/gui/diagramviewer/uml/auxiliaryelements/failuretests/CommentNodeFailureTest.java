/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.*;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>CommentNode</code>.
 * </p>
 *
 * @author Hacker_QC
 * @version 1.0
 */
public class CommentNodeFailureTest extends TestCase {

    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE = "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The CommentNode instance for helping testing.
     * </p>
     */
    private CommentNode node;

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
     * The Uml1SemanticModelBridge instance for helping testing.
     * </p>
     */
    private Uml1SemanticModelBridge usmb;

    /**
     * <p>
     * The Comment instance for helping testing.
     * </p>
     */
    private Comment comment;

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
        usmb = new Uml1SemanticModelBridge();
        comment = new CommentImpl();
        comment.setBody("CommentNode\ntest");
        usmb.setElement(comment);
        graphNode.setSemanticModel(usmb);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(300);
        dimension.setHeight(100);
        graphNode.setSize(dimension);
        node = new CommentNode(graphNode, mapping);
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
        dimension = null;
        comment = null;
        usmb = null;
        node = null;
    }

    /**
     * <p>
     * Tests constructor CommentNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCommentNodeCtor1() throws Exception {
        try {
            new CommentNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor CommentNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCommentNodeCtor2() throws Exception {
        try {
            new CommentNode(graphNode, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor CommentNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCommentNodeCtor3() throws Exception {
        try {
            new CommentNode(new GraphNode(), mapping);
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException iae) {
            // everything is good
        }
    }
}
