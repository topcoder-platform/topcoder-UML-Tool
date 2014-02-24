/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import junit.framework.TestCase;

import com.topcoder.swing.print.PrintManager;
import com.topcoder.swing.print.impl.DefaultComponentVisibleMaker;

/**
 * This class aggregates accuracy tests for PrintManager class.
 * 
 * @author ch_music
 * @version 1.0
 */
public class PrintManagerAccuracyTests extends TestCase {

    /**
     * A placeholder for PrintManager instance.
     */
    private PrintManager test;

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        test = new PrintManager();
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testPrintManager() {
        assertNotNull("Constructor fails to create instance.", test);
    }

    /**
     * Tests constructor(String) for accuracy.
     * 
     * @throws Exception to JUnit
     */
    public void testPrintManagerString() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.NAMESPACE, AccuracyTestHelper.CONFIGPATH);
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.NAMESPACE_OF, AccuracyTestHelper.CONFIGPATH_OF);
        try {
            assertNotNull("Constructor fails to create instance.", new PrintManager(AccuracyTestHelper.NAMESPACE));
        } finally {
            AccuracyTestHelper.tearConfig();
        }
    }

    /**
     * Tests setComponentVisibleMaker for accuracy.
     *
     */
    public void testSetComponentVisibleMaker() {
        test.setComponentVisibleMaker(new DefaultComponentVisibleMaker());
    }

    /**
     * Tests setPrintFormatRetriever for accuracy.
     */
    public void testSetPrintFormatRetriever() {
        test.setPrintFormatRetriever(new MockPrintFormatRetriever());
    }

    /**
     * Tests setHasPrintDialog method for accuracy.
     */
    public void testSetHasPrintDialog() {
        test.setHasPrintDialog(false);
    }
}
