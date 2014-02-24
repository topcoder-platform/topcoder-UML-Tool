/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.transform;

import java.awt.Component;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;

import com.topcoder.gui.panels.zoom.Helper;
import com.topcoder.gui.panels.zoom.UnitTestHelper;

/**
 * <p>
 * Unit test cases for class NatureZoomTransform's simple methods. It will test all its functions.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NatureZoomTransformUnitTest extends TestCase {

    /**
     * NatureZoomTransform object to be tested. Created in setUp.
     */
    private NatureZoomTransform transform;

    /**
     * Sets up testing environment.
     *
     * @throws Exception
     *             when error occurs
     */
    protected void setUp() throws Exception {
        transform = new NatureZoomTransform();
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception
     *             when error occurs
     */
    protected void tearDown() throws Exception {
        transform = null;
    }

    /**
     * <p>
     * Test of default constructor for accuracy.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testDefaultCtorAccuracy() throws Exception {
        assertNotNull("constructor failed.", new NatureZoomTransform());
    }

    /**
     * <p>
     * Test of constructor with one param for accuracy.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void test1ParamCtorAccuracy() throws Exception {
        assertNotNull("constructor failed", new NatureZoomTransform(2.0));
    }

    /**
     * <p>
     * Test of constructor with one param with zero. IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void test1ParamCtorWithZero() throws Exception {
        try {
            new NatureZoomTransform(0);
            fail("should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of constructor with one param with negative double. IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void test1ParamCtorWithNegative() throws Exception {
        try {
            new NatureZoomTransform(-1.0);
            fail("should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of setZoomFactor for accuracy.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetZoomFactorAccuracy() throws Exception {
        for (int i = 1; i < 10; i++) {
            transform.setZoomFactor(i);
            assertEquals("the two value should be equal", i, transform.getZoomFactor(), Helper.EPSILON);
        }
    }

    /**
     * <p>
     * Test of setZoomFactor with none-positive value. IllegalArgumentException is expected.
     * </p>
     */
    public void testSetZoomFactorWithNonePositive() {
        try {
            new NatureZoomTransform(-1.0);
            fail("should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of getZoomFactor for accuracy.
     * </p>
     */
    public void testGetZoomFactorAccuracy() {
        transform.setZoomFactor(2.0);
        assertEquals("the two value should be equal", 2.0, transform.getZoomFactor(), Helper.EPSILON);
    }

    /**
     * <p>
     * Test of applyTransform for accuracy.
     * </p>
     */
    public void testApplyTransformAccuracy() {
        transform.applyTransform(UnitTestHelper.getGraphics2D());
    }

    /**
     * <p>
     * Test of applyTransform with null. IllegalArgumentException is expected.
     * </p>
     */
    public void testApplyTransformWithNull() {
        try {
            transform.applyTransform(null);
            fail("should throw IllegalArgumentException when argument is null.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of applyInverseTransform for accuracy.
     * </p>
     */
    @SuppressWarnings("serial")
    public void testApplyInverseTransformAccuracy() {
        int x = 3;
        int y = 3;
        double zoomFactor = 3.0;
        transform.setZoomFactor(zoomFactor);
        MouseEvent me = transform.applyInverseTransform(new MouseEvent(new Component() { } , 0, 0, 0,
                x, y, 0, false));
        assertNotNull("apply inverse transform failed", me);
        assertEquals("x should be equal", (int) (x / zoomFactor), me.getX());
        assertEquals("x should be equal", (int) (y / zoomFactor), me.getY());
    }

    /**
     * <p>
     * Test of applyInverseTransform with null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testApplyInverseTransformWithNull() {
        try {
            transform.applyInverseTransform(null);
            fail("should throw IllegalArgumentException when argument is null.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of isNoZoom for accuracy.
     * As the default zoomFactor is 1.0, the isNoZoom should be true by default.
     * </p>
     */
    public void testIsNoZoomAccuracy1() {
        assertTrue("should be true in default", transform.isNoZoom());
    }

    /**
     * <p>
     * Test of isNoZoom for accuracy.
     * Set the zoomFactor to 2.0, then the isNoZoom should be false.
     * </p>
     */
    public void testIsNoZoomAccuracy2() {
        transform.setZoomFactor(2.0);
        assertFalse("should be false after setting new zoomFactor which is not 1.0", transform.isNoZoom());
    }
}
