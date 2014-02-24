/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import junit.framework.TestCase;

import com.topcoder.swing.birdseyeview.event.ViewPortEvent;
/**
 * <p>
 * Unit test of ViewPortEvent class.
 * </p>
 *
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ViewPortEventTest extends TestCase {

    /**
     * <p>
     * Test the constructor of ViewPortEvent class.
     * </p>
     */
    public void testConstructor() {
        ViewPortEvent e = new ViewPortEvent(1, 2);
        assertEquals("The x value should be 1.", 1, e.getInputObjectViewX());
        assertEquals("The y value should be 2.", 2, e.getInputObjectViewY());
    }

    /**
     * <p>
     * Test the inputObjectViewX attribute of ViewPortEvent class.
     * </p>
     */
    public void testInputObjectViewX() {
        ViewPortEvent e = new ViewPortEvent(123, 2);
        assertEquals("The x value should be 123.", 123, e.getInputObjectViewX());
    }

    /**
     * <p>
     * Test the inputObjectViewX of ViewPortEvent class.
     * </p>
     */
    public void testInputObjectViewY() {
        ViewPortEvent e = new ViewPortEvent(1, 999);
        assertEquals("The y value should be 999.", 999, e.getInputObjectViewY());
    }

}
