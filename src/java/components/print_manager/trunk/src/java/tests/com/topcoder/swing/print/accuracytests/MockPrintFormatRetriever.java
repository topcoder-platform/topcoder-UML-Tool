/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

import com.topcoder.swing.print.PrintFormatRetriever;

/**
 * Mock PrintFormat Retriever.
 * 
 * @author ch_music
 * @version 1.0
 */
public class MockPrintFormatRetriever implements PrintFormatRetriever {

    /**
     * The system property name to be set to true when printing in single page.
     */
    public static final String PRINT_SINGLE_PAGE_SYSTEM_PROPERTY = "PrintManagerPrintSinglePage";

    /**
     * The system property name for scale factor.
     */
    public static final String SCALE_FACTOR_SYSTEM_PROPERTY = "PrintManagerScaleFactor";

    /**
     * Gets page format.
     * 
     * @return page format.
     */
    public PageFormat getPageFormat() {
        return PrinterJob.getPrinterJob().defaultPage();
    }

    /**
     * Gets scale factor.
     * 
     * @return scale factor
     */
    public double getScaleFactor() {
        String prop = System.getProperty(SCALE_FACTOR_SYSTEM_PROPERTY);
        return (prop == null) ? 1.0 : Double.parseDouble(System.getProperty(SCALE_FACTOR_SYSTEM_PROPERTY));
    }

    /**
     * Whether fit to single page is chosen.
     * 
     * @return whether fit to single page is chosen
     */
    public boolean isFitSinglePage() {
        return (System.getProperty(PRINT_SINGLE_PAGE_SYSTEM_PROPERTY) != null);
    }

    /**
     * Retrieves print format.
     */
    public void retrievePrintFormat() {
        // do nothing.
    }
}
