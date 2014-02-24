/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import junit.framework.TestCase;

import java.awt.Rectangle;


/**
 * Test case for FitInPagePrint. In this test, ImagePrinter is used for the purpose of printing the component to a
 * jpg file, to simulate the printing result.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FitInPagePrintTest extends TestCase {
    /** Default component used in this test. */
    private PrintFrame component;

    /** Default Rectangle used in this test. */
    private Rectangle rectangle;

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        component = new PrintFrame(400, 400, "abcdefghijklmnopqrst", true);
        rectangle = new Rectangle(0, 0, 200, 200);
    }

    /**
     * Clears test environment, disposing the component created during the test.
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        component.dispose();
    }

    /**
     * Test printing the component with the FitInPagePrint strategy. ImagePrinter is used to simulate the
     * printing result.
     *
     * @throws Exception to junit
     */
    public void testPrintWithoutRectangle() throws Exception {
        FitInPagePrint print = new FitInPagePrint(component);

        //use FitInPagePrint to print the given component into a jpg file
        new ImagePrinter().print(print, "FitInPagePrintTest#testPrintWithoutRectangle");
    }

    /**
     * Test printing the component with the FitInPagePrint strategy, a rectangle is given to restrict the
     * printing area. ImagePrinter is used to simulate the printing result.
     *
     * @throws Exception to junit
     */
    public void testPrintWithRectangle() throws Exception {
        FitInPagePrint print = new FitInPagePrint(component, rectangle);

        //use FitInPagePrint to print the given component into a jpg file
        new ImagePrinter().print(print, "FitInPagePrintTest#testPrintWithRectangle");
    }

    /**
     * Test ctor(Component), should be instantiated successfully.
     */
    public void testFitInPagePrintComponent() {
        new FitInPagePrint(component);

        //success
    }

    /**
     * Test ctor(null), IAE is expected.
     */
    public void testFitInPagePrintNullComponent() {
        try {
            new FitInPagePrint(null);
            fail("IAE is expected since component is null");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test ctor(Component, Rectangle), should be instantiated successfully.
     */
    public void testFitInPagePrintComponentRectangle() {
        new FitInPagePrint(component, rectangle);

        //success
    }

    /**
     * Test ctor(null, Rectangle), IAE is expected.
     */
    public void testFitInPagePrintNullComponentRectangle() {
        try {
            new FitInPagePrint(null, rectangle);
            fail("IAE is expected since component is null");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test ctor(Component, null), IAE is expected.
     */
    public void testFitInPagePrintComponentNullRectangle() {
        try {
            new FitInPagePrint(component, null);
            fail("IAE is expected since rectangle is null");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
