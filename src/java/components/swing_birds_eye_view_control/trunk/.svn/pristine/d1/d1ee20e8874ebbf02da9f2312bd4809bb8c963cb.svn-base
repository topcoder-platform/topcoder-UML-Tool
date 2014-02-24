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
import com.topcoder.swing.birdseyeview.ViewPort;

/**
 * Stress tests for implementation of <code>ViewPort</code>.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ViewPortStressTests extends BaseStressTest {
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
    private MockViewPort target;

    /**
     * Mock class for test purpose.
     */
    class MockViewPort extends ViewPort {
        /**
         * <p>
         * A simple setter method for the "dragging" internal field. Please refer to the related
         * field for more information.
         * </p>
         * 
         * @param dragging
         *            the new value of the control flag, defining whether the dragging action with
         *            the view port is going on (true value), or not - like finished or not started
         *            yet (false value). It can be any value.
         */
        protected void setDragging(boolean dragging) {
            super.setDragging(dragging);
        }
    }

    /**
     * Create test instance.
     * 
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        target = new MockViewPort();
        Dimension inputObjectViewDimension = new Dimension(1000, 1000);
        Point inputObjectViewPosition = new Point(500, 500);
        BirdsEyeView parent = new BirdsEyeView(new JPanel(), inputObjectViewDimension,
                inputObjectViewPosition);
        parent.add(target);
        parent.setSize(100, 100);
    }

    /**
     * Stress test method for <code>ViewPort#mouseDragged(MouseEvent event)</code> with low
     * burden.
     */
    public void test_mouseDragged_1() {
        MouseEvent event = new MouseEvent(new JButton(), 1, 1, 1, 10, 20, 1, false);
        target.setDragging(true);
        this.start();
        for (int i = 0; i < LOAD1; i++) {
            target.mouseDragged(event);
        }
        this.stop();
        // print execute info
        System.out.println("Run ViewPort#mouseDragged(MouseEvent) method  " + "for " + LOAD1
                + " times consumes " + getMilliseconds() + " milliseconds.");
    }
    
    /**
     * Stress test method for <code>ViewPort#mouseDragged(MouseEvent event)</code> with high
     * burden.
     */
    public void test_mouseDragged_2() {
        MouseEvent event = new MouseEvent(new JButton(), 1, 1, 1, 10, 20, 1, false);
        target.setDragging(true);
        this.start();
        for (int i = 0; i < LOAD2; i++) {
            target.mouseDragged(event);
        }
        this.stop();
        // print execute info
        System.out.println("Run ViewPort#mouseDragged(MouseEvent) method  " + "for " + LOAD2
                + " times consumes " + getMilliseconds() + " milliseconds.");
    }
}
