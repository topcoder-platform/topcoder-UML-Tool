/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import java.awt.Component;

import junit.framework.TestCase;

import com.topcoder.swing.print.PrintManager;

/**
 * This class tests the overall printing accuracy of the component.
 * 
 * @author ch_music
 * @version 1.0
 */
public class OverallPrintingAccuracyTests extends TestCase {

    /**
     * The PrintManager to be tested.
     */
    private PrintManager test;

    /**
     * The component to be printed.
     */
    private Component component = new PrintTestComponent();

    /**
     * Sets up testing environment.
     * 
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.NAMESPACE, AccuracyTestHelper.CONFIGPATH);
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.NAMESPACE_OF, AccuracyTestHelper.CONFIGPATH_OF);
        test = new PrintManager(AccuracyTestHelper.NAMESPACE);
    }

    /**
     * Tears down testing environment.
     * 
     * @throws Exception to JUnit
     */
    public void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests FitSinglePage printing.
     * 
     * @throws Exception to JUnit
     */
    public void testPrintSinglePage() throws Exception {
        test.specifyPrintFormat();
        System.setProperty(MockPrintFormatRetriever.PRINT_SINGLE_PAGE_SYSTEM_PROPERTY, "true");
        try {
            test.print(component);
        } finally {
            System.clearProperty(MockPrintFormatRetriever.PRINT_SINGLE_PAGE_SYSTEM_PROPERTY);
        }
    }

    /**
     * Tests ScalingPrint. Scale factor 1.0.
     * 
     * @throws Exception to JUnit
     */
    public void testScalingPrint_Scale__1_0() throws Exception {
        test.specifyPrintFormat();
        System.setProperty(MockPrintFormatRetriever.SCALE_FACTOR_SYSTEM_PROPERTY, "1.0");
        try {
            test.print(component);
        } finally {
            System.clearProperty(MockPrintFormatRetriever.SCALE_FACTOR_SYSTEM_PROPERTY);
        }
    }

    /**
     * Tests ScalingPrint. Scale factor 2.0.
     * 
     * @throws Exception to JUnit
     */
    public void testScalingPrint_Scale__2_0() throws Exception {
        test.specifyPrintFormat();
        System.setProperty(MockPrintFormatRetriever.SCALE_FACTOR_SYSTEM_PROPERTY, "2.0");
        try {
            test.print(component);
        } finally {
            System.clearProperty(MockPrintFormatRetriever.SCALE_FACTOR_SYSTEM_PROPERTY);
        }
    }

    /**
     * Tests ScalingPrint. Scale factor 0.5.
     * 
     * @throws Exception to JUnit
     */
    public void testScalingPrint_Scale__0_5() throws Exception {
        test.specifyPrintFormat();
        System.setProperty(MockPrintFormatRetriever.SCALE_FACTOR_SYSTEM_PROPERTY, "0.5");
        try {
            test.print(component);
        } finally {
            System.clearProperty(MockPrintFormatRetriever.SCALE_FACTOR_SYSTEM_PROPERTY);
        }
    }
}
