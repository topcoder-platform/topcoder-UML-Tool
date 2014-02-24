/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.EnumMap;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelinePropertyType;

/**
 * <p>
 * This is the stress test cases for Lifeline.
 * </p>
 *
 * @author littleken
 * @version 1.1
 */
public class LifelineTestStress extends TestCase {

    /**
     * An instance of <code>MockLifeLine</code> which is used for testing as
     * an instance of LifeLine.
     */
    private MockLifeLine lifeline;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        GraphEdge graphEdge = StressTestsHelper.createGraphEdge();
        EnumMap<LifelinePropertyType, String> propertyNameMapping = StressTestsHelper.createLifelinePropertyNameMapping();
        this.lifeline = new MockLifeLine(graphEdge, propertyNameMapping);

    }

    /**
     * Tear down the test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        this.lifeline = null;
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

            MouseEvent event = new MouseEvent(lifeline, 0, 0, 0, 0, 0, 0, false);
            this.lifeline.consumeEvent(event);
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

            MouseEvent event = new MouseEvent(lifeline, 0, 0, 0, 0, 0, 0, false);
            this.lifeline.processMouseEvent(event);
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

            TestImagePrinter printer = new TestImagePrinter("test_files/stress_test_lifeline.jpg");
            lifeline.setRenderScheme(RenderScheme.TopCoderScheme);
            lifeline.setSize(100, 100);
            lifeline.setShadowColor(Color.BLACK);
            lifeline.setStrokeColor(Color.RED);
            lifeline.setShadowLength(2);
            lifeline.paintComponent(printer.initImage());
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
                    this.lifeline.contains(j, k);
                }
            }
        }
        // output the time used.
        long endTime = System.currentTimeMillis();
        System.out.println("Run " + StressTestsHelper.RUN_TIMES + " LifeLine#contains(int x, int y) method takes "
                + (endTime - startTime) + "ms");

    }

}
