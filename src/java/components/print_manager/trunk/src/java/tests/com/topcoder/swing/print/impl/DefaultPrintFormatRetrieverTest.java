/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.impl;

import junit.framework.TestCase;


/**
 * Test case for DefaultPrintFormatRetriever.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultPrintFormatRetrieverTest extends TestCase {
    /** Default DefaultPrintFormatRetriever used in this test. */
    private DefaultPrintFormatRetriever retriever;

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        retriever = new DefaultPrintFormatRetriever();
    }

    /**
     * Test default ctor.
     */
    public void testDefaultPrintFormatRetriever() {
        assertNotNull(retriever);

        //success;
    }

    /**
     * Test {@link DefaultPrintFormatRetriever#getPageFormat()}, pageFormat should be obtained.
     */
    public void testGetPageFormat() {
        retriever.retrievePrintFormat();

        assertNotNull("pageFormat should not be null", retriever.getPageFormat());
    }

    /**
     * Test {@link DefaultPrintFormatRetriever#isFitSinglePage()}.
     */
    public void testIsFitSinglePage() {
        retriever.retrievePrintFormat();

        retriever.isFitSinglePage();

        //success
    }

    /**
     * Test {@link DefaultPrintFormatRetriever#getScaleFactor()}.
     */
    public void testGetScaleFactor() {
        retriever.retrievePrintFormat();

        retriever.getScaleFactor();

        //success
    }

    /**
     * Test {@link DefaultPrintFormatRetriever#retrievePrintFormat()}.
     */
    public void testRetrievePrintFormat() {
        retriever.retrievePrintFormat();

        //success
    }
}
