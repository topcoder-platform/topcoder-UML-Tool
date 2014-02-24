/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout.DefaultEdgeLayoutStrategy;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;


/**
 * <p>
 * Accuracy tests for the <code>DefaultEdgeLayoutStrategy</code> class.
 * </p>
 *
 * @author RachaelLCook
 * @version 1.1
 */


public class DefaultEdgeLayoutStrategyAccuracyTests extends TestCase {


    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
        protected void setUp() throws Exception {


                this.layoutStrategy = new DefaultEdgeLayoutStrategy();

                edgeNodeMapping = new HashMap<SequenceEdge,ObjectNode[]>();

                edges = TestUtil.createSimpleSequnceEdgeAndAssociation(edgeNodeMapping);
        }


    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
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
        return new TestSuite(DefaultEdgeLayoutStrategyAccuracyTests.class);
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
        public void testCtor_Default(){

                DefaultEdgeLayoutStrategy defaultStrategy = new DefaultEdgeLayoutStrategy();
                assertNotNull("Fail to call the default constructor",defaultStrategy);
                assertEquals("Fail to set the member variables in default constuctor",
                                20,defaultStrategy.getEdgeSpace());
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
        public void testCtor_Config() throws Exception{

                TestHelper.loadXMLConfig("test_files/LifelineAccuracyTests.xml");
                DefaultEdgeLayoutStrategy defaultStrategy = new DefaultEdgeLayoutStrategy();
                TestHelper.clearConfig();
                assertNotNull("Fail to call the default constructor",defaultStrategy);
                assertEquals("Fail to set the member variables in default constuctor",
                                10,defaultStrategy.getEdgeSpace());

        }





        /**
         * <p>
         * Test the constructor DefaultEdgeLayoutStrategy(int edgeSpace) for accuracy.
         * </p>
         *
         */
        public void testCtor_Accuracy(){

                DefaultEdgeLayoutStrategy defaultStrategy = new DefaultEdgeLayoutStrategy(40);
                assertNotNull("Fail to call the constructor",defaultStrategy);
                assertEquals("Fail to set the member variables in the constuctor",
                                40,defaultStrategy.getEdgeSpace());
        }




    /**
     * <p>
     * Test the setter method setEdgeSpace for accuracy.
     * </p>
     *
     */
    public void testSetEdgeSpace_Accuracy(){

        layoutStrategy.setEdgeSpace(70);
        assertEquals("Fail to set the edgeSpace correctly",70,layoutStrategy.getEdgeSpace());
    }


    /**
     * <p>
     * Test the getter method getEdgeSpace for accuracy.
     * </p>
     *
     */
    public void testGetEdgeSpace(){

        layoutStrategy.setEdgeSpace(25);
        assertEquals("Fail to get the edgeSpace correctly",25,layoutStrategy.getEdgeSpace());
    }



    /**
     * <p>
     * Test the layout method for accuracy.
     * </p>
     *
     */
    public void testLayout_Accuracy() throws Exception {

        List<LifelineSegment> lsList = null;
                lsList = layoutStrategy.layout(edges, edgeNodeMapping);

                assertEquals("fail to generate the LifelineSegments correctly",5,lsList.size());

                //check the layout of LifelineSegments
                LifelineSegment llseg = lsList.get(0);
                Rectangle rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",20,rect.height);

                llseg = lsList.get(1);
                rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",40,rect.height);

                llseg = lsList.get(2);
                rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",20,rect.height);

                llseg = lsList.get(3);
                rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",20,rect.height);

                llseg = lsList.get(4);
                rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",20,rect.height);

                //check the layout of the edge
                SequenceEdge edge = edges.get(0);
                com.topcoder.diagraminterchange.Point left = edge.getGraphEdge().getWaypoints().get(0);
                com.topcoder.diagraminterchange.Point right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(155, 235),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(215, 235),
                        new Point((int) right.getX(), (int) right.getY()));

                edge = edges.get(1);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(215, 255),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(275, 255),
                        new Point((int) right.getX(), (int) right.getY()));

                edge = edges.get(2);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(215, 275),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(335, 275),
                        new Point((int) right.getX(), (int) right.getY()));

                edge = edges.get(3);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(335, 295),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(215, 295),
                        new Point((int) right.getX(), (int) right.getY()));

                edge = edges.get(4);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(215, 315),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(155, 315),
                        new Point((int) right.getX(), (int) right.getY()));
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
    public void testLayout_AccuracySameObjNode() throws Exception {

        List<LifelineSegment> lsList = null;

                edgeNodeMapping = new HashMap<SequenceEdge,ObjectNode[]>();
                edges = TestUtil.createSequnceEdgeAndAssociationSameObjNodes(edgeNodeMapping);

                lsList = layoutStrategy.layout(edges, edgeNodeMapping);

                assertEquals("fail to generate the LifelineSegments correctly",5,lsList.size());

                //check the layout of LifelineSegments
                LifelineSegment llseg = lsList.get(0);
                Rectangle rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",60,rect.height);

                llseg = lsList.get(1);
                rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",20,rect.height);

                llseg = lsList.get(2);
                rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",20,rect.height);

                llseg = lsList.get(3);
                rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",20, rect.height);

                llseg = lsList.get(4);
                rect = llseg.getSelectionBound();
                assertEquals("fail to layout the LifelineSegments correctly",20,rect.height);

                //check the layout of the edge
                SequenceEdge edge = edges.get(0);
                com.topcoder.diagraminterchange.Point left = edge.getGraphEdge().getWaypoints().get(0);
                com.topcoder.diagraminterchange.Point right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(155, 235),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(215, 235),
                        new Point((int) right.getX(), (int) right.getY()));

                edge = edges.get(1);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(155, 255),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(215, 255),
                        new Point((int) right.getX(), (int) right.getY()));

                edge = edges.get(2);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(155, 275),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(275, 275),
                        new Point((int) right.getX(), (int) right.getY()));

                //edge starts and ends with the same ObjectNode
                edge = edges.get(3);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(275, 295),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(285, 295),
                        new Point((int) right.getX(), (int) right.getY()));

            //edge starts and ends with the same ObjectNode
                edge = edges.get(4);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(275, 315),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(285, 315),
                        new Point((int) right.getX(), (int) right.getY()));

                edge = edges.get(5);
                left = edge.getGraphEdge().getWaypoints().get(0);
                right = edge.getGraphEdge().getWaypoints().get(1);
                assertEquals("fail to layout the SequenceEdge correctly",new Point(275, 335),
                        new Point((int) left.getX(), (int) left.getY()));
                assertEquals("fail to layout the SequenceEdge correctly",new Point(155, 335),
                        new Point((int) right.getX(), (int) right.getY()));
    }





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
        private Map<SequenceEdge,ObjectNode[]> edgeNodeMapping;
}
