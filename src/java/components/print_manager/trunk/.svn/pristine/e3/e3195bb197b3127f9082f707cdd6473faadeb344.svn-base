/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import junit.framework.TestCase;

import java.awt.Component;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.List;


/**
 * Test case for PrintManager.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrintManagerTest extends TestCase {
    /** Default PrintManager used in this test. */
    private PrintManager printMgr;

    /** Default PrintFormatRetriever used in this test. */
    private PrintFormatRetriever formatRetriever;

    /** A list of frames that contain the components can be printed. */
    private List<PrintFrame> frames;

    /** A list of components that can be printed in this test. */
    private List<Component> components;

    /** A list of rectangles that specify the printing area. */
    private List<Rectangle> rectangles;

    /**
     * Sets up PrintManager, printing component, rectangles.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfig();
        
        //initiatelizes PrintManager
        printMgr = new PrintManager();
        formatRetriever = new MockPrintFormatRetriever();
        printMgr.setPrintFormatRetriever(formatRetriever);
        printMgr.setComponentVisibleMaker(new MockComponentVisibleMaker());

        //initiatelizes components to be printed
        components = new ArrayList<Component>();
        frames = new ArrayList<PrintFrame>();

        PrintFrame frame = new PrintFrame(400, 400, "PrintManagerTest_frame1", true);
        frames.add(frame);
        components.add(frame.getPrintingComponent());

        frame = new PrintFrame(400, 400, "PrintManagerTest_frame2", true);
        frames.add(frame);
        components.add(frame.getPrintingComponent());

        //initiatelizes rectangles
        rectangles = new ArrayList<Rectangle>();
        rectangles.add(new Rectangle(0, 0, 100, 100));
        rectangles.add(new Rectangle(0, 0, 200, 200));
    }

    /**
     * Clears test environment.
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        for (int i = 0; i < frames.size(); i++) {
            frames.get(i).dispose();
        }
        
        TestHelper.clearConfig();
    }

    /**
     * Test the ctor().
     */
    public void testPrintManager() {
        assertNotNull(printMgr);

        //success
    }

    /**
     * Test ctor(namespace) with valid config. It should be instantiated successfully.
     *
     * @throws Exception to junit
     */
    public void testPrintManagerString() throws Exception {
        new PrintManager("valid");

        //success
    }

    /**
     * Test ctor(namespace) with invalid config. "objectFactoryNamespace" is missing and ConfigurationException
     * is expected
     *
     * @throws Exception to junit
     */
    public void testPrintManagerStringMissing_objectFactoryNamespace()
        throws Exception {
        try {
            new PrintManager("missing_objectFactoryNamespace");
            fail("config is invalid, objectFactoryNamespace is missing and ConfigurationException is expected");
        } catch (ConfigurationException e) {
            //success
        }
    }

    /**
     * Test ctor(namespace) with invalid config. "componentVisibleMaker" is missing and ConfigurationException
     * is expected
     *
     * @throws Exception to junit
     */
    public void testPrintManagerStringMissing_componentVisibleMaker()
        throws Exception {
        try {
            new PrintManager("missing_componentVisibleMaker");
            fail("config is invalid, componentVisibleMaker is missing and ConfigurationException is expected");
        } catch (ConfigurationException e) {
            //success
        }
    }

    /**
     * Test ctor(namespace) with invalid config. "printFormatRetriever" is missing and ConfigurationException
     * is expected
     *
     * @throws Exception to junit
     */
    public void testPrintManagerStringMissing_printFormatRetriever()
        throws Exception {
        try {
            new PrintManager("missing_printFormatRetriever");
            fail("config is invalid, printFormatRetriever is missing and ConfigurationException is expected");
        } catch (ConfigurationException e) {
            //success
        }
    }

    /**
     * Test ctor(namespace) with valid config. "hasPrintDialog" is optional and missing.
     *
     * @throws Exception to junit
     */
    public void testPrintManagerStringMissing_hasPrintDialog()
        throws Exception {
        new PrintManager("missing_hasPrintDialog");
        //success
    }

    /**
     * Test {@link PrintManager#print(Component)}, check the print result whether the function is correct.
     */
    public void testPrintComponent() {
        printMgr.print(components.get(0));

        //check the print result whether the function is correct
    }

    /**
     * Test {@link PrintManager#print(Component)} with null component, IAE is expected.
     */
    public void testPrintNullComponent() {
        try {
            printMgr.print((Component) null);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#print(Component, Rectangle)} with valid argument, check the print result
     * whether the function is correct.
     */
    public void testPrintComponentRectangle() {
        printMgr.print(components.get(0), rectangles.get(0));

        //check the print result whether the function is correct
    }

    /**
     * Test {@link PrintManager#print(Component, Rectangle)} given with null component, IAE is expected.
     */
    public void testPrintNullComponentRectangle() {
        try {
            printMgr.print((Component) null, rectangles.get(0));
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#print(Component, Rectangle)} given with null rectangle, IAE is expected.
     */
    public void testPrintComponentNullRectangle() {
        try {
            printMgr.print(components.get(0), null);
            fail("rectangle is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#print(List)} with valid argument, check the print result whether the function
     * is correct.
     */
    public void testPrintListOfComponent() {
        printMgr.print(components);

        //      check the print result whether the function is correct
    }

    /**
     * Test {@link PrintManager#print(List)} with null list, IAE is expected.
     */
    public void testPrintListOfComponentNull() {
        try {
            printMgr.print((List<Component>) null);
            fail("components is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#print(List)} with empty list, IAE is expected.
     */
    public void testPrintListOfComponentEmpty() {
        try {
            printMgr.print(new ArrayList<Component>());
            fail("components is empty and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#print(List, List)} with valid arguments, check the print result whether the
     * function is correct.
     */
    public void testPrintListOfComponentListOfRectangle() {
        printMgr.print(components, rectangles);

        //      check the print result whether the function is correct
    }

    /**
     * Test {@link PrintManager#print(List, List)} with null components, IAE is expected.
     */
    public void testPrintNullListOfComponentListOfRectangle() {
        try {
            printMgr.print(null, rectangles);
            fail("components is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#print(List, List)} with null rectangles, IAE is expected.
     */
    public void testPrintListOfComponentNullListOfRectangle() {
        try {
            printMgr.print(components, null);
            fail("rectangles is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#print(List, List)} given components and rectangles unequal lengths, IAE is
     * expected.
     */
    public void testPrintListOfComponentListOfRectangleInvalid() {
        rectangles.remove(0);

        try {
            printMgr.print(components, rectangles);
            fail("rectangles and components do not have the equal size and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#specifyPrintFormat()}.
     * @throws Exception to junit
     */
    public void testSpecifyPrintFormat() throws Exception{
        printMgr.specifyPrintFormat();
    }

    /**
     * Test {@link PrintManager#setComponentVisibleMaker(ComponentVisibleMaker)}.
     */
    public void testSetComponentVisibleMaker() {
        printMgr.setComponentVisibleMaker(new MockComponentVisibleMaker());

        //success
    }

    /**
     * Test {@link PrintManager#setComponentVisibleMaker(ComponentVisibleMaker)} with null, IAE is expected.
     */
    public void testSetNullComponentVisibleMaker() {
        try {
            printMgr.setComponentVisibleMaker(null);
            fail("componentVisibleMaker is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#setPrintFormatRetriever(PrintFormatRetriever)}.
     */
    public void testSetPrintFormatRetriever() {
        printMgr.setPrintFormatRetriever(new MockPrintFormatRetriever());

        //success
    }

    /**
     * Test {@link PrintManager#setPrintFormatRetriever(PrintFormatRetriever)} will null, IAE is expected.
     */
    public void testSetNullPrintFormatRetriever() {
        try {
            printMgr.setPrintFormatRetriever(null);
            fail("printFormatRetriever is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link PrintManager#setHasPrintDialog(boolean)}.
     */
    public void testSetHasPrintDialog() {
        printMgr.setHasPrintDialog(true);

        //success
    }
}
