/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.EnumMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestImagePrinter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.TestUtil;


/**
 * <p>
 * Unit TestCases for LifelineSegment class.
 * </p>
 *
 * @author RachaelLCook
 * @version 1.1
 */

public class LifelineSegmentAccuracyTest extends TestCase {


        /**
         * <p>
         * The default rectangle bounds argument to construct the LifelineSegment instance.
         * </p>
         */
        static private Rectangle DEFAULT_BOUNDS = new Rectangle(100,100,30,90);


        /**
         * <p>
         * The default position argument to construct the LifelineSegment instance.
         * </p>
         */
        static private Point DEFAULT_POSITION = new Point(0,0);



        /**
         * <p>
         * LifelineSegment instance for tesing.
         * </p>
         *
         * <p>
         * Note:It is constructed in the setUp method and before TestHelper.loadXMLConfig().
         * </p>
         *
         * <p>
         * The member instance variables in the lifeline is loaded using the default value.
         * </p>
         */
        private LifelineSegment lifeLineSeg;



         /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(LifelineSegmentAccuracyTest.class);
    }



    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
        protected void setUp() throws Exception {

                GraphNode graphnode = new GraphNode();

        EnumMap<LifelineSegmentPropertyType,String> properties = TestUtil.createLifelineSegmentSomeProperties();
                lifeLineSeg = new LifelineSegment(graphnode,DEFAULT_POSITION,DEFAULT_BOUNDS,properties);

                TestHelper.loadXMLConfig("test_files/LifelineAccuracyTests.xml");
                super.setUp();
        }


    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
        protected void tearDown() throws Exception {

                TestHelper.clearConfig();
                super.tearDown();
        }

    /**
     * <p>
         * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
         * EnumMap<LifelineSegmentPropertyType,String> propertyNameMapping) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded from the GraphNode instance.
     * </p>
     *
     */
    public void testCtor_FromGraphNode(){

        GraphNode graphnode = TestUtil.createGraphNodeWithProperties();
                EnumMap<LifelineSegmentPropertyType,String> properties = TestUtil.createLifelineSegmentProperties();

                try{
                        LifelineSegment lifelineseg = new LifelineSegment(graphnode,DEFAULT_POSITION,DEFAULT_BOUNDS,properties);

                        assertEquals("Fail to load the fillcolor",new Color(16,16,16),lifelineseg.getFillColor());
                        assertEquals("Fail to load the shadowcolor",new Color(32,32,32),lifelineseg.getShadowColor());
                        assertEquals("Fail to load the strokecolor",new Color(112,112,112),lifelineseg.getStrokeColor());
                        assertEquals("Fail to load the height",16,lifelineseg.getHeight());
                        assertEquals("Fail to load the width",8,lifelineseg.getWidth());
                        assertEquals("Fail to load the renderscheme",RenderScheme.SimpleScheme,lifelineseg.getRenderScheme());
                        assertEquals("Fail to load the shadowlength",4,lifelineseg.getShadowLength());
                }
                catch(IllegalArgumentException e){
                        fail("Should not throw IllegalArgumentException");
                }
    }

    /**
     * <p>
         * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
         * EnumMap<LifelineSegmentPropertyType,String> propertyNameMapping) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded using the ConfigManager.
     * </p>
     *
     */
    public void testCtor_FromConfigManager(){

        GraphNode graphNode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType,String> properties = TestUtil.createLifelineSegmentProperties();

        try{
                LifelineSegment lifelineseg = new LifelineSegment(graphNode,DEFAULT_POSITION,DEFAULT_BOUNDS,properties);

                        assertEquals("Fail to load the fillcolor",Color.GREEN,lifelineseg.getFillColor());
                        assertEquals("Fail to load the shadowcolor",Color.GRAY,lifelineseg.getShadowColor());
                        assertEquals("Fail to load the strokecolor",Color.BLACK,lifelineseg.getStrokeColor());
                        assertEquals("Fail to load the height",16,lifelineseg.getHeight());
                        assertEquals("Fail to load the width",6,lifelineseg.getWidth());
                        assertEquals("Fail to load the renderscheme",RenderScheme.SimpleScheme,lifelineseg.getRenderScheme());
                        assertEquals("Fail to load the shadowlength",6,lifelineseg.getShadowLength());
        }
        catch(IllegalArgumentException e){
                fail("Should not throw IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
         * EnumMap<LifelineSegmentPropertyType,String> propertyNameMapping) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded using the default value.
     * </p>
     *
     */
    public void testCtor_FromDefault(){

        assertNotNull("The LifelineSegment instance should not be null",lifeLineSeg);

        assertEquals("Fail to load the fillcolor",Color.WHITE,lifeLineSeg.getFillColor());
                assertEquals("Fail to load the shadowcolor",Color.BLACK,lifeLineSeg.getShadowColor());
                assertEquals("Fail to load the strokecolor",Color.BLACK,lifeLineSeg.getStrokeColor());
                assertEquals("Fail to load the height",15,lifeLineSeg.getHeight());
                assertEquals("Fail to load the width",5,lifeLineSeg.getWidth());
                assertEquals("Fail to load the renderscheme",RenderScheme.TopCoderScheme,lifeLineSeg.getRenderScheme());
                assertEquals("Fail to load the shadowlength",5,lifeLineSeg.getShadowLength());
    }

    /**
     * <p>
     * Tests paintComponent method for accuracy.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponentGraphics() throws Exception {

        GraphNode graphNode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType,String> properties = TestUtil.createLifelineSegmentProperties();

        LifelineSegment lifelineseg = new LifelineSegment(graphNode,DEFAULT_POSITION,DEFAULT_BOUNDS,properties);

        //Set the ShadowColor and ShadowLength
        lifelineseg.setShadowColor(Color.GRAY);
        lifelineseg.setShadowLength(4);

        //Set the RenderScheme
        lifelineseg.setRenderScheme(RenderScheme.TopCoderScheme);

        //Set the Strock Color
        lifelineseg.setStrokeColor(Color.BLACK);

        //Set the fill Color
        lifelineseg.setFillColor(Color.YELLOW);

        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter(
                "test_files/accuracy_tests/Lifeline_Segment.jpg");
        lifelineseg.paintComponent(printer.initImage());
        printer.print();
    }



    /**
     * <p>
     * Test the getter method getPropertyNameMappingElement for accuracy.
     * </p>
     *
     */
    public void testGetPropertyNameMappingElement_Accuracy(){

        String value = lifeLineSeg.getPropertyNameMappingElement(LifelineSegmentPropertyType.FILL_COLOR);
        assertEquals("Fail to get the mapping element correctly","fillcolor",value);

        value = lifeLineSeg.getPropertyNameMappingElement(LifelineSegmentPropertyType.RENDER_SCHEME);
        assertTrue("Fail to get the mapping element correctly",null == value);
    }

    /**
     * <p>
     * Test the setter method setPropertyNameMappingElement for accuracy.
     * </p>
     *
     */
    public void testSetPropertyNameMappingElement_Accuracy(){

        //insert
        lifeLineSeg.setPropertyNameMappingElement(LifelineSegmentPropertyType.HEIGHT, "height");
        String value = lifeLineSeg.getPropertyNameMappingElement(LifelineSegmentPropertyType.HEIGHT);
        assertEquals("Fail to set the name mapping element correctly","height",value);

        //replace
        lifeLineSeg.setPropertyNameMappingElement(LifelineSegmentPropertyType.WIDTH, "SegWidth");
        value = lifeLineSeg.getPropertyNameMappingElement(LifelineSegmentPropertyType.WIDTH);
        assertEquals("Fail to set the name mapping element correctly","SegWidth",value);
    }



    /**
     * <p>
     * Test the method getBounds.
     * </p>
     */
    public void testGetBounds(){
        Rectangle rect = lifeLineSeg.getBounds();
        assertNotNull("Fail to call the method getBounds",rect);
    }

    /**
     * <p>
     * Test the setter method setFillColor for accuracy.
     * </p>
     *
     */
    public void testSetFillColor_Accuracy(){

        lifeLineSeg.setFillColor(new Color(0,0,100));
        assertEquals("Fail to set the fillcolor correctly",new Color(0,0,100),lifeLineSeg.getFillColor());
    }


    /**
     * <p>
     * Test the getter method getStrokeColor for accuracy.
     * </p>
     *
     */
    public void testGetStrokeColor(){

        lifeLineSeg.setStrokeColor(new Color(18,18,18));
        assertEquals("Fail to get the strokecolor correctly",new Color(18,18,18),lifeLineSeg.getStrokeColor());
    }

    /**
     * <p>
     * Test the getter method getShadowLength for accuracy.
     * </p>
     *
     */
    public void testGetShadowLength(){

        lifeLineSeg.setShadowLength(0);
        assertEquals("Fail to set the shadowLength correctly.",0,lifeLineSeg.getShadowLength());
        lifeLineSeg.setShadowLength(9);
        assertEquals("Fail to set the shadowLength correctly.",9,lifeLineSeg.getShadowLength());
    }


    /**
     * <p>
     * Test the setter method setShadowLength for accuracy.
     * </p>
     *
     */
    public void testSetShadowLength_Accuracy(){

        lifeLineSeg.setShadowLength(0);
        assertEquals("Fail to set the shadowLength correctly.",0,lifeLineSeg.getShadowLength());
        lifeLineSeg.setShadowLength(8);
        assertEquals("Fail to set the shadowLength correctly.",8,lifeLineSeg.getShadowLength());
    }



    /**
     * <p>
     * Test the setter method setStrokeColor for accuracy.
     * </p>
     *
     */
    public void testSetStrokeColor_Accuracy(){

        lifeLineSeg.setStrokeColor(new Color(128,128,128));
        assertEquals("Fail to set the strokecolor correctly.",new Color(128,128,128),lifeLineSeg.getStrokeColor());
    }


    /**
     * <p>
     * Test the getter method getShadowColor for accuracy.
     * </p>
     *
     */
    public void testGetShadowColor(){

        lifeLineSeg.setShadowColor(new Color(12,12,12));
        assertEquals("Fail to get the shadowcolor correctly",new Color(12,12,12),lifeLineSeg.getShadowColor());
    }


    /**
     * <p>
     * Test the getter method getRenderScheme for accuracy.
     * </p>
     *
     */
    public void testGetRenderScheme(){

        lifeLineSeg.setRenderScheme(RenderScheme.TopCoderScheme);
        assertEquals("Fail to get the renderScheme correctly",RenderScheme.TopCoderScheme,lifeLineSeg.getRenderScheme());
    }


    /**
     * <p>
     * Test the getter method getFillColor for accuracy.
     * </p>
     *
     */
    public void testGetFillColor(){

        lifeLineSeg.setFillColor(new Color(12,12,12));
        assertEquals("Fail to get the fillColor correctly",new Color(12,12,12),lifeLineSeg.getFillColor());
    }



    /**
     * <p>
     * Test the setter method setShadowColor for accuracy.
     * </p>
     *
     */
    public void testSetShadowColor_Accuracy(){

        lifeLineSeg.setShadowColor(new Color(0,0,0));
        assertEquals("Fail to set the shadowcolor correctly",new Color(0,0,0),lifeLineSeg.getShadowColor());
    }





    /**
     * <p>
     * Test the setter method setRenderScheme for accuracy.
     * </p>
     *
     */
    public void testSetRenderScheme_Accuracy(){

        lifeLineSeg.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Fail to set the renderScheme correctly.",RenderScheme.SimpleScheme,lifeLineSeg.getRenderScheme());
    }


    /**
     * <p>
     * Test the getter method getPopup for accuracy.
     * </p>
     *
     */
    public void testGetPopup(){

        JPopupMenu popup = new JPopupMenu();
        lifeLineSeg.setPopup(popup);
        assertSame("getPopup fails to get correctly",popup,lifeLineSeg.getPopup());

    }


    /**
     * <p>
     * Test the setter method setPopup for accuracy.
     * </p>
     *
     */
    public void testSetPopup_Accuracy(){

        JPopupMenu popup = new JPopupMenu();
        lifeLineSeg.setPopup(popup);
        assertSame("setPopup fails to set correctly",popup,lifeLineSeg.getPopup());
    }


        /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * <p>
     * This demo prgram create a DiagramViewer and add a LifelineSegment to the DiagramViewer.
     * Since the LifelineSegment's process on LeftClick MouseEvent need to work with the parent DiagramViewer,
     * a DiagramViewer instance is needed.
     * </p>
     *
     * <p>
     * Dependencies on creating a DiagramViewer:
     * memory_usage 2.0, simple_cache, object_factory 2.0.1,zoom_panel 1.0,MockForTest.jar
     * </p>
     *
     * @param args the arguments
         * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);

        //Create a LifelineSegement
        EnumMap<LifelineSegmentPropertyType,String> properties =
                new EnumMap<LifelineSegmentPropertyType,String>(LifelineSegmentPropertyType.class);
        properties.put(LifelineSegmentPropertyType.FILL_COLOR, "fillcolor");
        LifelineSegment lifelineseg = new LifelineSegment(new GraphNode(),new Point(0,0),
                        new Rectangle(100,200,20,80),properties);

        //Create a DiagramViewer
        DiagramViewer viewer = TestUtil.createDV();

        //Add the Popup
        JPopupMenu popup = new JPopupMenu();
        popup.add("test");
        lifelineseg.setPopup(popup);

         JPanel panel = new JPanel();

         //Create a viewer and add it to the Frame
         JFrame frame = new JFrame();
         frame.add(viewer);
         //Add the lifeline to the viewer
         viewer.add(lifelineseg);

         frame.setSize(new Dimension(500, 500));
         frame.setVisible(true);
         TestHelper.clearConfig();
    }
}
