/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TestHelper;

/**
 * <p>
 * This is the Stress test cases for <code>LifelineSegment</code>.
 * </p>
 *
 * @author littleken
 * @version 1.1
 */
public class LifelineSegmentTestStress extends TestCase {

    /** An instance of <code>LifelineSegment</code> for testing. */
    private MockLifelineSegment lifelineSegment;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        String strokeColor = "#100000";
        String fillColor = "#200000";
        String shadowColor = "#300000";
        int shadowLength = 4;
        int minimumWidth = 50;
        int minimumHeight = 60;
        int width = 70;
        int height = 80;
        RenderScheme renderScheme = RenderScheme.TopCoderScheme;

        GraphNode graphNode = TestHelper.createGraphNode();
        graphNode.addProperty(TestHelper.createProperty("STROKE_COLOR", strokeColor));
        graphNode.addProperty(TestHelper.createProperty("FILL_COLOR", fillColor));
        graphNode.addProperty(TestHelper.createProperty("SHADOW_COLOR", shadowColor));
        graphNode.addProperty(TestHelper.createProperty("WIDTH", "" + width));
        graphNode.addProperty(TestHelper.createProperty("HEIGHT", "" + height));
        graphNode.addProperty(TestHelper.createProperty("MINIMUM_WIDTH", "" + minimumWidth));
        graphNode.addProperty(TestHelper.createProperty("MINIMUM_HEIGHT", "" + minimumHeight));
        graphNode.addProperty(TestHelper.createProperty("SHADOW_LENGTH", "" + shadowLength));
        graphNode.addProperty(TestHelper.createProperty("RENDER_SCHEME", "" + renderScheme.ordinal()));

        this.lifelineSegment = new MockLifelineSegment(graphNode, new Point(), new Rectangle(), StressTestsHelper
                .createLifelineSegmentPropertyNameMapping());

    }

    /**
     * Tears down test environment .
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        this.lifelineSegment = null;
    }

    /**
     * This is the stress test for method: consumeEvent(MouseEvent event).
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConsumeEvent_Stress() throws Exception {

        // the test start time.
        long startTime = System.currentTimeMillis();

        // run the test for RUN_TIMES times.
        for (int i = 0; i < StressTestsHelper.RUN_TIMES; i++) {

            MouseEvent event = new MouseEvent(lifelineSegment, 0, 0, 0, 0, 0, 0, false);
            this.lifelineSegment.consumeEvent(event);
        }

        // output the time used.
        long endTime = System.currentTimeMillis();
        System.out.println("Run " + StressTestsHelper.RUN_TIMES + " LifeLine#consumeEvent(event) method takes "
                + (endTime - startTime) + "ms");

    }

    /**
     * This is the stress test for the method: processMouseEvent(MouseEvent e).
     *
     * @throws Exception
     *             to JUnit
     */
    public void testProcessMouseEvent_Stress() throws Exception {
        // the test start time.
        long startTime = System.currentTimeMillis();
        // run the test for RUN_TIMES times.
        for (int i = 0; i < StressTestsHelper.RUN_TIMES; i++) {

            MouseEvent event = new MouseEvent(lifelineSegment, 0, 0, 0, 0, 0, 0, false);
            this.lifelineSegment.processMouseEvent(event);
        }
        // output the time used.
        long endTime = System.currentTimeMillis();
        System.out.println("Run " + StressTestsHelper.RUN_TIMES
                + " LifeLine#processMouseEvent(MouseEvent e) method takes " + (endTime - startTime) + "ms");

    }

    /**
     * This is the stress test for the method: paintComponent(Graphics g).
     *
     * @throws Exception
     *             to JUnit
     */
    public void testPaintComponent_Stress() throws Exception {
        // the test start time.
        long startTime = System.currentTimeMillis();

        // run the test for RUN_TIMES times.
        for (int i = 0; i < StressTestsHelper.RUN_TIMES; i++) {

            TestImagePrinter printer = new TestImagePrinter("test_files/stress_test_lifelineSegment.jpg");
            lifelineSegment.setRenderScheme(RenderScheme.TopCoderScheme);
            lifelineSegment.setSize(100, 100);
            lifelineSegment.setShadowColor(Color.BLACK);
            lifelineSegment.setStrokeColor(Color.RED);
            lifelineSegment.setShadowLength(2);
            lifelineSegment.paintComponent(printer.initImage());
            printer.print();
        }
        // output the time used.
        long endTime = System.currentTimeMillis();
        System.out.println("Run " + StressTestsHelper.RUN_TIMES + " LifeLine#paintComponent(Graphics g) method takes "
                + (endTime - startTime) + "ms");

    }

    /**
     * This is the stress test for the method: contains(int x, int y).
     *
     * @throws Exception
     *             to JUnit
     */
    public void testContain_Stress() throws Exception {
        // the test start time.
        long startTime = System.currentTimeMillis();
        // run the test for RUN_TIMES times.
        for (int i = 0; i < StressTestsHelper.RUN_TIMES; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 50; k++) {
                    this.lifelineSegment.contains(j, k);
                }
            }
        }
        // output the time used.
        long endTime = System.currentTimeMillis();
        System.out.println("Run " + StressTestsHelper.RUN_TIMES
                + " LifelineSegment#contains(int x, int y) method takes " + (endTime - startTime) + "ms");

    }
}
