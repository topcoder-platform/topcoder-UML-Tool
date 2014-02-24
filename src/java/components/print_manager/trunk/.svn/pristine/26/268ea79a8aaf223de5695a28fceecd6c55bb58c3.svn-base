/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.print.PageFormat;


/**
 * Mock implement of {@link PrintFormatRetriever} for test purpose.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockPrintFormatRetriever implements PrintFormatRetriever {
    /** fitSinglePage. */
    private boolean fitSinglePage = false;

    /** scale factor. */
    private double scale = 1;

    /**
     * Return default PageFormat.
     *
     * @return default PageFormat
     */
    public PageFormat getPageFormat() {
        return new PageFormat();
    }

    /**
     * return scale factor.
     *
     * @return scale factor
     */
    public double getScaleFactor() {
        return scale;
    }

    /**
     * return fitSinglePage.
     *
     * @return fitSinglePage
     */
    public boolean isFitSinglePage() {
        return fitSinglePage;
    }

    /**
     * does nothing.
     */
    public void retrievePrintFormat() {
    }

    /**
     * Set fitSinglePage.
     *
     * @param bool boolean
     */
    public void setFitSinglePage(boolean bool) {
        fitSinglePage = bool;
    }

    /**
     * Set scale factor.
     *
     * @param scale scale factor
     */
    public void setScaleFactor(double scale) {
        this.scale = scale;
    }
}
