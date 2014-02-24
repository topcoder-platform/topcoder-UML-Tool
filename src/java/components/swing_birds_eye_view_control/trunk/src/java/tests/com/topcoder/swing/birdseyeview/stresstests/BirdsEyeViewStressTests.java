/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview.stresstests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.topcoder.swing.birdseyeview.BirdsEyeView;

/**
 * Stress tests for implementation of <code>BirdsEyeView</code>.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BirdsEyeViewStressTests extends BaseStressTest {
    /**
     * The first load to test.
     */
    private static final int LOAD1 = 100;

    /**
     * The second load to test.
     */
    private static final int LOAD2 = 500;

    /**
     * ViewPort instance to test.
     */
    private BirdsEyeView target;

    /**
     * Create test instance.
     * 
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        Dimension inputObjectViewDimension = new Dimension(1000, 1000);
        Point inputObjectViewPosition = new Point(500, 500);
        target = new BirdsEyeView(new JPanel(), inputObjectViewDimension, inputObjectViewPosition);
        target.setSize(100, 100);
    }

    /**
     * Stress test method for <code>BirdsEyeView#mousePressed(MouseEvent event)</code> with low
     * burden.
     */
    public void test_mouseDragged_1() {
        MouseEvent event = new MouseEvent(new JButton(), 1, 1, 1, 10, 20, 1, false);
        this.start();
        for (int i = 0; i < LOAD1; i++) {
            target.mousePressed(event);
        }
        this.stop();
        // print execute info
        System.out.println("Run BirdsEyeView#mousePressed(MouseEvent) method  " + "for " + LOAD1
                + " times consumes " + getMilliseconds() + " milliseconds.");
    }

    /**
     * Stress test method for <code>BirdsEyeView#mousePressed(MouseEvent event)</code> with high
     * burden.
     */
    public void test_mouseDragged_2() {
        MouseEvent event = new MouseEvent(new JButton(), 1, 1, 1, 10, 20, 1, false);
        this.start();
        for (int i = 0; i < LOAD2; i++) {
            target.mousePressed(event);
        }
        this.stop();
        // print execute info
        System.out.println("Run BirdsEyeView#mousePressed(MouseEvent) method  " + "for " + LOAD2
                + " times consumes " + getMilliseconds() + " milliseconds.");
    }
}
