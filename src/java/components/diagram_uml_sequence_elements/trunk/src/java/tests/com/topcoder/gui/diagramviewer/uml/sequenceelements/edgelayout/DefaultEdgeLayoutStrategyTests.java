/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.EdgeLayoutException;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.TestUtil;

/**
 * <p>
 * Unit TestCases for DefaultEdgeLayoutStrategy class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 */

public class DefaultEdgeLayoutStrategyTests extends TestCase {


    /**
     *
     * <p>
     * DefaultEdgeLayoutStrategy instance for tesing.
     * </p>
     *
     */
    private DefaultEdgeLayoutStrategy layoutStrategy;

    /**
     * <p>
     * The edges for testing use.
     * </p>
     */
    private List<SequenceEdge> edges;

    /**
     * <p>
     * The edge to nodes mapping for testing use.
     * </p>
     */
    private Map<SequenceEdge, ObjectNode[]> edgeNodeMapping;


    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {

        this.layoutStrategy = new DefaultEdgeLayoutStrategy();

        edgeNodeMapping = new HashMap<SequenceEdge, ObjectNode[]>();

        edges = TestUtil.createSimpleSequnceEdgeAndAssociation(edgeNodeMapping);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {

        this.layoutStrategy = null;
    }

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultEdgeLayoutStrategyTests.class);
    }

    /**
     * <p>
     * Test the default constructor.
     * </p>
     *
     * <P>
     * Test when the edgeSpace is loaded from default.
     * </p>
     *
     */
    public void testCtor_Default() {

        DefaultEdgeLayoutStrategy defaultStrategy = new DefaultEdgeLayoutStrategy();
        assertNotNull("Fail to call the default constructor", defaultStrategy);
        assertEquals("Fail to set the member variables in default constuctor", 20, defaultStrategy.getEdgeSpace());
    }

    /**
     * <p>
     * Test the default constructor.
     * </p>
     *
     * <P>
     * Test when the edgeSpace is loaded from ConfigManager.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    public void testCtor_Config() throws Exception {

        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        DefaultEdgeLayoutStrategy defaultStrategy = new DefaultEdgeLayoutStrategy();
        TestHelper.clearConfig();
        assertNotNull("Fail to call the default constructor", defaultStrategy);
        assertEquals("Fail to set the member variables in default constuctor", 10, defaultStrategy.getEdgeSpace());

    }

    /**
     * <p>
     * Test the constructor DefaultEdgeLayoutStrategy(int edgeSpace) for failure.
     * </p>
     *
     * <p>
     * It tests when edgeSpace argument is 0 or negative and expects the IllegalArgumentException.
     * </p>
     */
    public void testCtor_Failure() {

        try {

            new DefaultEdgeLayoutStrategy(0);
            fail("Should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good;
        }
        try {

            new DefaultEdgeLayoutStrategy(-8);
            fail("Should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good;
        }
    }

    /**
     * <p>
     * Test the constructor DefaultEdgeLayoutStrategy(int edgeSpace) for accuracy.
     * </p>
     *
     */
    public void testCtor_Accuracy() {

        DefaultEdgeLayoutStrategy defaultStrategy = new DefaultEdgeLayoutStrategy(40);
        assertNotNull("Fail to call the constructor", defaultStrategy);
        assertEquals("Fail to set the member variables in the constuctor", 40, defaultStrategy.getEdgeSpace());
    }

    /**
     * <p>
     * Test the setter method setEdgeSpace for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is 0 or negative,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetEdgeSpace_Fail() {

        try {
            layoutStrategy.setEdgeSpace(0);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
        try {
            layoutStrategy.setEdgeSpace(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setEdgeSpace for accuracy.
     * </p>
     *
     */
    public void testSetEdgeSpace_Accuracy() {

        layoutStrategy.setEdgeSpace(70);
        assertEquals("Fail to set the edgeSpace correctly", 70, layoutStrategy.getEdgeSpace());
    }

    /**
     * <p>
     * Test the getter method getEdgeSpace for accuracy.
     * </p>
     *
     */
    public void testGetEdgeSpace() {

        layoutStrategy.setEdgeSpace(25);
        assertEquals("Fail to get the edgeSpace correctly", 25, layoutStrategy.getEdgeSpace());
    }

    /**
     * <p>
     * Test the layout method for failure.
     * </p>
     *
     * <p>
     * It tests when the edges argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testLayout_NullEdges() {

        try {
            layoutStrategy.layout(null, edgeNodeMapping);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        } catch (EdgeLayoutException e) {
            fail("should get IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the layout method for failure.
     * </p>
     *
     * <p>
     * It tests when the edgeNodeMapping argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testLayout_NullEdgeNodeMapping() {

        try {
            layoutStrategy.layout(edges, null);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        } catch (EdgeLayoutException e) {
            fail("should get IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the layout method for failure.
     * </p>
     *
     * <p>
     * It tests when the element in the edges argument is null,and expects the
     * IllegalArgumentException.
     * </p>
     */
    public void testLayout_NullElementEdge() {

        try {
            edges.set(2, null);
            layoutStrategy.layout(edges, edgeNodeMapping);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        } catch (EdgeLayoutException e) {
            fail("should get IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the layout method for failure.
     * </p>
     *
     * <p>
     * It tests when no value for edge key in the mapping and expects the IllegalArgumentException.
     * </p>
     */
    public void testLayout_NullElementMapping1() {

        try {
            SequenceEdge edge = edges.get(3);
            edgeNodeMapping.remove(edge);
            layoutStrategy.layout(edges, edgeNodeMapping);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        } catch (EdgeLayoutException e) {
            fail("should get IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the layout method for failure.
     * </p>
     *
     * <p>
     * It tests when the value for edge key in the mapping is null and expects the
     * IllegalArgumentException.
     * </p>
     */
    public void testLayout_NullElementMapping2() {

        try {
            SequenceEdge edge = edges.get(3);
            edgeNodeMapping.put(edge, null);
            layoutStrategy.layout(edges, edgeNodeMapping);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        } catch (EdgeLayoutException e) {
            fail("should get IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the layout method for failure.
     * </p>
     *
     * <p>
     * It tests when the number of the ObjectNode in ObjectNode[] is not equal to 2 , and expects
     * the IllegalArgumentException.
     * </p>
     */
    public void testLayout_InvalidElementMapping1() {

        try {
            SequenceEdge edge = edges.get(1);
            edgeNodeMapping.put(edge, TestUtil.createObjectNodes(3));
            layoutStrategy.layout(edges, edgeNodeMapping);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        } catch (EdgeLayoutException e) {
            fail("should get IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the layout method for failure.
     * </p>
     *
     * <p>
     * It tests when the element of the ObjectNode in ObjectNode[] is null, and expects the
     * IllegalArgumentException.
     * </p>
     */
    public void testLayout_InvalidElementMapping2() {

        try {
            SequenceEdge edge = edges.get(1);
            ObjectNode[] nodes = TestUtil.createObjectNodes(2);
            nodes[1] = null;
            edgeNodeMapping.put(edge, nodes);
            layoutStrategy.layout(edges, edgeNodeMapping);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        } catch (EdgeLayoutException e) {
            fail("should get IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the layout method for accuracy.
     * </p>
     *
     */
    public void testLayout_Accuracy() {

        List<LifelineSegment> lsList = null;
        try {

            lsList = layoutStrategy.layout(edges, edgeNodeMapping);

            assertEquals("fail to generate the LifelineSegments correctly", 5, lsList.size());

            // check the layout of LifelineSegments
            LifelineSegment llseg = lsList.get(0);
            Rectangle rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 20, rect.height);

            llseg = lsList.get(1);
            rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 40, rect.height);

            llseg = lsList.get(2);
            rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 20, rect.height);

            llseg = lsList.get(3);
            rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 20, rect.height);

            llseg = lsList.get(4);
            rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 20, rect.height);

            // check the layout of the edge
            SequenceEdge edge = edges.get(0);
            com.topcoder.diagraminterchange.Point left = edge.getGraphEdge().getWaypoints().get(0);
            com.topcoder.diagraminterchange.Point right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(155, 235),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(215, 235),
                    new Point((int) right.getX(), (int) right.getY()));

            edge = edges.get(1);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(215, 255),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(275, 255),
                    new Point((int) right.getX(), (int) right.getY()));

            edge = edges.get(2);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(215, 275),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(335, 275),
                    new Point((int) right.getX(), (int) right.getY()));

            edge = edges.get(3);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(335, 295),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(215, 295),
                    new Point((int) right.getX(), (int) right.getY()));

            edge = edges.get(4);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(215, 315),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(155, 315),
                    new Point((int) right.getX(), (int) right.getY()));
        } catch (EdgeLayoutException e) {
            fail("should get no Exception");
        }
    }

    /**
     * <p>
     * Test the layout method for accuracy.
     * </p>
     *
     * <p>
     * Test the cases when a SequenceEdge start and end at the same ObjectNode
     * </p>
     *
     */
    public void testLayout_AccuracySameObjNode() {

        List<LifelineSegment> lsList = null;

        edgeNodeMapping = new HashMap<SequenceEdge, ObjectNode[]>();
        edges = TestUtil.createSequnceEdgeAndAssociationSameObjNodes(edgeNodeMapping);
        try {

            lsList = layoutStrategy.layout(edges, edgeNodeMapping);

            assertEquals("fail to generate the LifelineSegments correctly", 5, lsList.size());

            // check the layout of LifelineSegments
            LifelineSegment llseg = lsList.get(0);
            Rectangle rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 60, rect.height);

            llseg = lsList.get(1);
            rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 20, rect.height);

            llseg = lsList.get(2);
            rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 20, rect.height);

            llseg = lsList.get(3);
            rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 20, rect.height);

            llseg = lsList.get(4);
            rect = llseg.getSelectionBound();
            assertEquals("fail to layout the LifelineSegments correctly", 20, rect.height);

            // check the layout of the edge
            SequenceEdge edge = edges.get(0);
            com.topcoder.diagraminterchange.Point left = edge.getGraphEdge().getWaypoints().get(0);
            com.topcoder.diagraminterchange.Point right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(155, 235),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(215, 235),
                    new Point((int) right.getX(), (int) right.getY()));

            edge = edges.get(1);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(155, 255),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(215, 255),
                    new Point((int) right.getX(), (int) right.getY()));

            edge = edges.get(2);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(155, 275),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(275, 275),
                    new Point((int) right.getX(), (int) right.getY()));

            // edge starts and ends with the same ObjectNode
            edge = edges.get(3);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(275, 295),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(285, 295),
                    new Point((int) right.getX(), (int) right.getY()));

            // edge starts and ends with the same ObjectNode
            edge = edges.get(4);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(275, 315),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(285, 315),
                    new Point((int) right.getX(), (int) right.getY()));

            edge = edges.get(5);
            left = edge.getGraphEdge().getWaypoints().get(0);
            right = edge.getGraphEdge().getWaypoints().get(1);
            assertEquals("fail to layout the SequenceEdge correctly", new Point(275, 335),
                    new Point((int) left.getX(), (int) left.getY()));
            assertEquals("fail to layout the SequenceEdge correctly", new Point(155, 335),
                    new Point((int) right.getX(), (int) right.getY()));
        } catch (EdgeLayoutException e) {
            fail("should get no Exception");
        }
    }
}
