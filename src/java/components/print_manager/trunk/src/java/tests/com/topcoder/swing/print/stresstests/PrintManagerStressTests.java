/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.stresstests;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.io.File;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.topcoder.swing.print.FitInPagePrint;
import com.topcoder.swing.print.PrintManager;
import com.topcoder.swing.print.ScalingPrint;
import com.topcoder.swing.print.impl.DefaultComponentVisibleMaker;
import com.topcoder.swing.print.impl.DefaultPrintFormatRetriever;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The stress test of print manager component.
 * </P>
 *
 * @author victorsam
 * @version 1.0
 */
public class PrintManagerStressTests extends TestCase {
    /**
     * This constant represents the test count used for testing.
     */
    private static final int NUMBER = 10000;

    /**
     * This constant represents the current time used for testing.
     */
    private static long current = -1;

    /**
     * The Rectangle instance used for testing.
     */
    private Rectangle rectangle;

    /**
     * The JFrame instance used for testing.
     */
    private JFrame component;

    /**
     * Set up test environment.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        component = new JFrame();
        component.setPreferredSize(new Dimension(300, 250));
        component.getContentPane().add(new JTextField("The component for testing"));
        component.pack();

        rectangle = new Rectangle(200, 200);

    }

    /**
     * Tears down test environment.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {

    }

    /**
     * This is the stress tests for FitInPagePrint constructor with the given component.
     */
    public void testFitInPagePrint1() {
        start();

        for (int i = 0; i < NUMBER; i++) {
            FitInPagePrint print = new FitInPagePrint(component);
            assertNotNull("Failed to create the new FitInPagePrint instance.", print);
        }

        printResult("testFitInPagePrint1");

    }

    /**
     * This is the stress tests for FitInPagePrint constructor with the given component
     * and the rectangle.
     */
    public void testFitInPagePrint2() {
        start();

        for (int i = 0; i < NUMBER; i++) {
            FitInPagePrint print = new FitInPagePrint(component, rectangle);
            assertNotNull("Failed to create the new FitInPagePrint instance.", print);
        }

        printResult("testFitInPagePrint2");

    }

    /**
     * This is the stress tests for the print method of FitInPagePrint.
     *
     */
    public void testFitInPagePrintOfPrint() {
        FitInPagePrint print = new FitInPagePrint(component, rectangle);
        PageFormat pageFormat = new PageFormat();

        start();

        for (int i = 0; i < NUMBER; i++) {
            assertEquals("Failed to return the correct value.", 0, print.print(component.getGraphics(), pageFormat, 0));
        }

        printResult("testFitInPagePrintOfPrint");

    }

    /**
     * This is the stress tests for ScalingPrint constructor with the given component
     * and the scaleFactor.
     *
     */
    public void testScalingPrint1() {
        start();

        for (int i = 0; i < NUMBER; i++) {
            ScalingPrint print = new ScalingPrint(component, 0.05);
            assertNotNull("Failed to create the new ScalingPrint instance.", print);
        }

        printResult("testScalingPrint1");

    }

    /**
     * This is the stress tests for ScalingPrint constructor with the given component,
     * the rectangle and the scaleFactor.
     *
     */
    public void testScalingPrint2() {
        start();

        for (int i = 0; i < NUMBER; i++) {
            ScalingPrint print = new ScalingPrint(component, rectangle, 0.05);
            assertNotNull("Failed to create the new ScalingPrint instance.", print);
        }

        printResult("testScalingPrint2");

    }

    /**
     * This is the stress tests for the print method of ScalingPrint.
     *
     */
    public void testScalingPrintOfPrint() {
        ScalingPrint print = new ScalingPrint(component, rectangle, 0.05);
        PageFormat pageFormat = new PageFormat();

        start();

        for (int i = 0; i < NUMBER; i++) {
            assertEquals("Failed to return the correct value.", 0, print.print(component.getGraphics(), pageFormat, 0));
        }

        printResult("testScalingPrintOfPrint");

    }

    /**
     * This is the stress tests for the constructor of DefaultPrintFormatRetriever.
     *
     */
    public void testDefaultPrintFormatRetriever() {
        start();

        for (int i = 0; i < NUMBER / 100; i++) {
            DefaultPrintFormatRetriever retriever = new DefaultPrintFormatRetriever();
            assertNotNull("Failed to create the new DefaultPrintFormatRetriever instance.", retriever);
        }

        printResult("testDefaultPrintFormatRetriever");
    }

    /**
     * This is the stress tests for the constructor of DefaultComponentVisibleMaker.
     *
     */
    public void testDefaultComponentVisibleMaker() {
        start();

        for (int i = 0; i < NUMBER; i++) {
            DefaultComponentVisibleMaker maker = new DefaultComponentVisibleMaker();
            assertNotNull("Failed to create the new DefaultComponentVisibleMaker instance.", maker);
        }

        printResult("testDefaultComponentVisibleMaker");
    }

    /**
     * This is the stress tests for the default constructor of PrintManager.
     *
     */
    public void testPrintManager1() {
        start();

        for (int i = 0; i < NUMBER / 200; i++) {
            PrintManager manager = new PrintManager();
            assertNotNull("Failed to create the new DefaultPrintFormatRetriever instance.", manager);
        }

        printResult("testPrintManager1");
    }

    /**
     * This is the stress tests for the PrintManager constructor with the namespace specified.
     *
     * @throws Exception to JUnit
     */
    public void testPrintManager2() throws Exception {
        this.loadXMLConfig("test_files/stresstests/config.xml");

        start();

        for (int i = 0; i < NUMBER / 200; i++) {
            PrintManager manager = new PrintManager("configNamespace");
            assertNotNull("Failed to create the new DefaultPrintFormatRetriever instance.", manager);
        }

        printResult("testPrintManager2");

        this.clearConfig();
    }

    /**
     * Return all tests.
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PrintManagerStressTests.class);
    }

    /**
     * Start to count time.
     */
    private static void start() {
        current = System.currentTimeMillis();
    }

    /**
     * Print test result.
     *
     * @param name the test name
     */
    private static void printResult(String name) {
        System.out.println("The test " + name + " running " + NUMBER + " times, took time: "
            + (System.currentTimeMillis() - current) + " ms");
    }

    /**
     * Use the given file to config the configuration manager.
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    private void loadXMLConfig(String fileName) throws Exception {
        clearConfig();

        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        config.add(file.getCanonicalPath());
    }

    /**
     * Clear all the namespaces from the configuration manager.
     *
     * @throws Exception to JUnit.
     */
    private void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }
}
