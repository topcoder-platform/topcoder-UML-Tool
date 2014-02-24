/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.transform;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import com.topcoder.gui.panels.zoom.Helper;
import com.topcoder.gui.panels.zoom.UnitTestHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AffineZoomTransform's simple methods. It will test all its functions.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AffineZoomTransformUnitTest extends TestCase {

    /**
     * AffineZoomTransform instance to be tested. Created in setUp.
     */
    private AffineZoomTransform transform;

    /**
     * Sets up testing environment.
     *
     * @throws Exception
     *             when error occurs
     */
    protected void setUp() throws Exception {
        transform = new AffineZoomTransform();
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
     * @throws Exception when error occurs
     */
    public void testDefaultCtorAccuracy() throws Exception {
        assertNotNull("constructor failed", new AffineZoomTransform());
    }

    /**
     * <p>
     * Test of one parameter constructor for accuracy.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void test1ParamCtorAccuracy() throws Exception {
        assertNotNull("constructor failed", new AffineZoomTransform(2.0));
    }

    /**
     * <p>
     * Test of AffineZoomTransform(double zoomFactor) for failure.
     * With zero passed in IllegalArgumentException is expected.
     * </p>
     */
    public void testDoubleCtorFailWithZero() {
        try {
            new AffineZoomTransform(0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of AffineZoomTransform(double zoomFactor) for failure.
     * With negative passed in IllegalArgumentException is expected.
     * </p>
     */
    public void testDoubleCtorFailWithNegative() {
        try {
            new AffineZoomTransform(-3.0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of AffineZoomTransform(AffineTransform transform) for accuracy.
     * <p>
     *
     * @throws Exception when error occurs
     */
    public void testAffineTransformCtorAccuracy() throws Exception {
        assertNotNull("constructor failed", new AffineZoomTransform(AffineTransform.getScaleInstance(1.0, 1.0)));
    }

    /**
     * <p>
     * Test of AffineZoomTransform(AffineTransform transform) for failure.
     * With null passed in IllegalArgumentException is expected.
     * </p>
     */
    public void testAffineTransformCtorFailWithNull() {
        try {
            new AffineZoomTransform(null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of setZoomFactor for accuracy.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetZoomFactorAccuracy() throws Exception {
        for (int i = 1; i < 10; i++) {
            transform.setZoomFactor(i);
            assertEquals("the two values should be equal", i, transform.getZoomFactor(), Helper.EPSILON);
        }
    }

    /**
     * <p>
     * Test of setZoomFactor for failure.
     * With zero passed in IllegalArgumentException is expected.
     * </p>
     */
    public void testSetZoomFactorFailWithZero() {
        try {
            new AffineZoomTransform(0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of setZoomFactor for failure.
     * With negative passed in IllegalArgumentException is expected.
     * </p>
     */
    public void testSetZoomFactorFailWithNegative() {
        try {
            new AffineZoomTransform(-3.0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of getZoomFactor for accuracy.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetZoomFactorAccuracy() throws Exception {
        transform.setZoomFactor(2);
        assertEquals("the two values should be equal", 2, transform.getZoomFactor(), Helper.EPSILON);
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
        int x = 2;
        int y = 3;
        double zoomFactor = 2.0;
        transform.setZoomFactor(zoomFactor);
        MouseEvent me = transform.applyInverseTransform(new MouseEvent(new Component() { } , 0, 0, 0,
                x, y, 0, false));
        assertNotNull("apply inverse transform failed", me);
        assertEquals("x should be equal", 1, me.getX());
        assertEquals("x should be equal", 1, me.getY());
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

    /**
     * <p>
     * Test of setTransform for accuracy.
     * </p>
     */
    public void testSetTransformAccuracy() {
        for (int i = 1; i < 10; i++) {
            AffineTransform expected = AffineTransform.getScaleInstance(i, i);
            transform.setTransform(expected);
            assertEquals("the two values should be equal", expected, transform.getTransform());
        }
    }

    /**
     * <p>
     * Test of setTransform for failure.
     * With null passed in IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTransformFailWithNull() {
        try {
            transform.setTransform(null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of getTransform for accuracy.
     * </p>
     */
    public void testGetTransformAccuracy() {
        AffineTransform expected = AffineTransform.getScaleInstance(5, 5);
        transform.setTransform(expected);
        assertEquals("the two values should be equal", expected, transform.getTransform());
    }
}
