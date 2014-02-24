/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout.DefaultEdgeLayoutStrategy;

/**
 * <p>
 * Failure test cases for DefaultEdgeLayoutStrategy.
 * </p>
 *
 * @author kaqi072821
 * @version 1.1
 * @since 1.1
 */
public class DefaultEdgeLayoutStrategyFailureTest extends TestCase {
    /**
     * <p>
     * The instance of DefaultEdgeLayoutStrategy instance under test.
     * </p>
     */
    private DefaultEdgeLayoutStrategy instance;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        instance = new DefaultEdgeLayoutStrategy();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        instance = null;
    }

    /**
     * <p>
     * Failure Test of constructor.
     * </p>
     */
    public void testCtorFailure() {
        try {
            new DefaultEdgeLayoutStrategy(0);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }

        try {
            new DefaultEdgeLayoutStrategy(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for layout method when edges is null.
     * </p>
     *
     * @throws Exception to junit
     */
    public void testLayout_edgesNull() throws Exception {
        List<SequenceEdge> edges = FailureTestHelper.getEdges();
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = FailureTestHelper.getEdgeNodeMapping(edges);

        try {
            instance.layout(null, edgeNodeMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for layout method when edges contains null.
     * </p>
     *
     * @throws Exception to junit
     */
    public void testLayout_edgesContainsNull() throws Exception {
        List<SequenceEdge> edges = FailureTestHelper.getEdges();
        edges.set(0, null);
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = FailureTestHelper.getEdgeNodeMapping(edges);

        try {
            instance.layout(edges, edgeNodeMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for layout method when edgeNodeMapping is null.
     * </p>
     *
     * @throws Exception to junit
     */
    public void testLayout_edgeNodeMappingNull() throws Exception {
        List<SequenceEdge> edges = FailureTestHelper.getEdges();

        try {
            instance.layout(edges, null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for layout method when edges is null.The provided map is doesn't contain an entry for any edge from
     * the list.
     * </p>
     *
     * @throws Exception to junit
     */
    public void testLayout_missMap() throws Exception {
        List<SequenceEdge> edges = FailureTestHelper.getEdges();
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = FailureTestHelper.getEdgeNodeMapping(edges);
        edgeNodeMapping.remove(edges.get(0));
        try {
            instance.layout(edges, edgeNodeMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for layout method.The provided map contains null value.
     * </p>
     *
     * @throws Exception to junit
     */
    public void testLayout_mapValueNull() throws Exception {
        List<SequenceEdge> edges = FailureTestHelper.getEdges();
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = FailureTestHelper.getEdgeNodeMapping(edges);
        edgeNodeMapping.remove(edges.get(0));
        edgeNodeMapping.put(edges.get(0), null);
        try {
            instance.layout(edges, edgeNodeMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for layout method.The provided map contains a value of array of length 1.
     * </p>
     *
     * @throws Exception to junit
     */
    public void testLayout_valueLenWrong() throws Exception {
        List<SequenceEdge> edges = FailureTestHelper.getEdges();
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = FailureTestHelper.getEdgeNodeMapping(edges);
        edgeNodeMapping.remove(edges.get(0));
        edgeNodeMapping.put(edges.get(0), new ObjectNode[] { FailureTestHelper.createObjectNode() });
        try {
            instance.layout(edges, edgeNodeMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for layout method.The provided map contains a value of array which contains null.
     * </p>
     *
     * @throws Exception to junit
     */
    public void testLayout_valueContainsNull() throws Exception {
        List<SequenceEdge> edges = FailureTestHelper.getEdges();
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = FailureTestHelper.getEdgeNodeMapping(edges);
        edgeNodeMapping.remove(edges.get(0));
        edgeNodeMapping.put(edges.get(0), new ObjectNode[] { FailureTestHelper.createObjectNode(), null });
        try {
            instance.layout(edges, edgeNodeMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure Test of setEdgeSpace method. IllegalArgumentException expected when edgeSpace is 0 or negative.
     */
    public void testSetEdgeSpaceFailure() {
        try {
            instance.setEdgeSpace(-2);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }

        try {
            instance.setEdgeSpace(0);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }
}