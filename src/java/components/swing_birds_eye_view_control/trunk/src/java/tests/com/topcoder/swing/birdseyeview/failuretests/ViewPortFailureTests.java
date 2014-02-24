/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview.failuretests;

import com.topcoder.swing.birdseyeview.ViewPort;

import junit.framework.TestCase;


/**
 * <p>Failure tests for <code>ViewPort</code> class.</p>
 *
 * @author telly12
 * @version 1.0
 */
public class ViewPortFailureTests extends TestCase {
    /**
     * The ViewPort instance used for failure test.
     */
    private ViewPort instance = new ViewPort();

    /**
     * <p>
     * The failure test for method <code>setOpacity(opacity)</code>,
     * fail for the opacity less than 0,
     * IllegalArgumentException should be thrown.
     * </p>
     *
     */
    public void test_setOpacity_failure1() {
        try {
            instance.setOpacity(-0.000001d);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * The failure test for method <code>setOpacity(opacity)</code>,
     * fail for the opacity larger than 1,
     * IllegalArgumentException should be thrown.
     * </p>
     *
     */
    public void test_setOpacity_failure2() {
        try {
            instance.setOpacity(1.0000001d);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    /**
     * <p>
     * The failure test for method <code>setZoomFactor(opacity)</code>,
     * fail for the ZoomFactor is less than 0,
     * IllegalArgumentException should be thrown.
     * </p>
     *
     */
    public void test_setZoomFactor_failure() {
        try {
            instance.setZoomFactor(-0.00001);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    /**
     * <p>
     * The failure test for method <code>addViewPortListener</code>,
     * fail for the Listener is null,
     * IllegalArgumentException should be thrown.
     * </p>
     *
     */
    public void test_addViewPortListener_failure() {
        try {
            instance.addViewPortListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
    /**
     * <p>
     * The failure test for method <code>removeViewPortListener</code>,
     * fail for the Listener is null,
     * IllegalArgumentException should be thrown.
     * </p>
     *
     */
    public void test_removeViewPortListener_failure() {
        try {
            instance.removeViewPortListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
