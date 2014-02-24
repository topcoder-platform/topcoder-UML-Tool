/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.Component;
import java.awt.Rectangle;

import junit.framework.TestCase;


/**
 * Test case for ScalingPrint. In this test, ImagePrinter is used for the purpose of printing the component to a
 * jpg file, to simulate the printing result.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ScalingPrintTest extends TestCase {
    /** Default component used in this test. */
    private PrintFrame frame;

    /** Component to be printed. */
    private Component component;

    /** Default Rectangle used in this test. */
    private Rectangle rectangle;

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        frame = new PrintFrame(400, 400, "abcdefghijklmnopqrst", true);
        component = frame.getPrintingComponent();
        rectangle = new Rectangle(0, 0, 200, 200);
    }

    /**
     * Clears test environment, disposing the component created during the test.
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        frame.dispose();
    }

    /**
     * Test printing the component with the ScalingPrint strategy. ImagePrinter is used to simulate the
     * printing result. This will test {@link ScalingPrint#print(Graphics, PageFormat, int)} indirectly. In this test,
     * component will be printed with scale = 2.
     *
     * @throws Exception to junit
     */
    public void testPrintWithoutRectangleScale2() throws Exception {
        ScalingPrint print = new ScalingPrint(component, 2);

        //use ScalingPrint to print the given component into a jpg file
        new ImagePrinter().print(print, "ScalingPrintTest#testPrintWithoutRectangleScale2");
    }

    /**
     * Test printing the component with the ScalingPrint strategy. ImagePrinter is used to simulate the
     * printing result. This will test {@link ScalingPrint#print(Graphics, PageFormat, int)} indirectly. In this test,
     * component will be printed with scale = 1.
     *
     * @throws Exception to junit
     */
    public void testPrintWithoutRectangleScale1() throws Exception {
        ScalingPrint print = new ScalingPrint(component, 1);

        //use ScalingPrint to print the given component into a jpg file
        new ImagePrinter().print(print, "ScalingPrintTest#testPrintWithoutRectangleScale1");
    }

    /**
     * Test printing the component with the ScalingPrint strategy. ImagePrinter is used to simulate the
     * printing result. This will test {@link ScalingPrint#print(Graphics, PageFormat, int)} indirectly. In this test,
     * component inside the given rectangle will be printed with scale = 1.
     *
     * @throws Exception to junit
     */
    public void testPrintWithRectangleScale1() throws Exception {
        ScalingPrint print = new ScalingPrint(component, rectangle, 1);

        //use ScalingPrint to print the given component into a jpg file
        new ImagePrinter().print(print, "ScalingPrintTest#testPrintWithRectangleScale1");
    }

    /**
     * Test printing the component with the ScalingPrint strategy. ImagePrinter is used to simulate the
     * printing result. This will test {@link ScalingPrint#print(Graphics, PageFormat, int)} indirectly. In this test,
     * component inside the given rectangle will be printed with scale = 2.
     *
     * @throws Exception to junit
     */
    public void testPrintWithRectangleScale2() throws Exception {
        ScalingPrint print = new ScalingPrint(component, rectangle, 2);

        //use ScalingPrint to print the given component into a jpg file
        new ImagePrinter().print(print, "ScalingPrintTest#testPrintWithRectangleScale2");
    }

    /**
     * Test {@link ScalingPrint#ScalingPrint(java.awt.Component, double)} with valid arguments.
     */
    public void testScalingPrintComponentDouble() {
        new ScalingPrint(component, 2.0);

        //success
    }

    /**
     * Test {@link ScalingPrint#ScalingPrint(java.awt.Component, double)} with null component, IAE is expected.
     */
    public void testScalingPrintNullComponentDouble() {
        try {
            new ScalingPrint(null, 2.0);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ScalingPrint#ScalingPrint(java.awt.Component, double)} with invalid scaleFactor, IAE is
     * expected.
     */
    public void testScalingPrintComponentNotPositiveDouble() {
        try {
            new ScalingPrint(component, 0);
            fail("scaleFactor is not positive and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ScalingPrint#ScalingPrint(java.awt.Component, Rectangle, double)} with valid arguments.
     */
    public void testScalingPrintComponentRectangleDouble() {
        new ScalingPrint(component, rectangle, 1);

        //success
    }

    /**
     * Test {@link ScalingPrint#ScalingPrint(java.awt.Component, Rectangle, double)} with null component, IAE
     * is expected.
     */
    public void testScalingPrintNullComponentRectangleDouble() {
        try {
            new ScalingPrint(null, rectangle, 1);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ScalingPrint#ScalingPrint(java.awt.Component, Rectangle, double)} with null rectangle, IAE
     * is expected.
     */
    public void testScalingPrintComponentNullRectangleDouble() {
        try {
            new ScalingPrint(component, null, 1);
            fail("rectangle is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ScalingPrint#ScalingPrint(java.awt.Component, Rectangle, double)} with invalid scaleFactor,
     * IAE is expected.
     */
    public void testScalingPrintComponentRectangleNotPositiveDouble() {
        try {
            new ScalingPrint(component, rectangle, 0);
            fail("scaleFactor is not positive and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ScalingPrint#getScaleFactor()}, obtaining the scaleFactor set in ctor.
     */
    public void testGetScaleFactor() {
        double scale = 2.0;
        ScalingPrint print = new ScalingPrint(component, rectangle, scale);
        assertEquals("getScaleFactor() should return", scale, print.getScaleFactor());

        print = new ScalingPrint(component, 2);
        assertEquals("getScaleFactor() should return", scale, print.getScaleFactor());
    }
}
