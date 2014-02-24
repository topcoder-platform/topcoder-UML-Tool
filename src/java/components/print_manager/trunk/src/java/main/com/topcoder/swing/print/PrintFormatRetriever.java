/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.print.PageFormat;


/**
 * <p>
 * This is the interface used by PrintManager to retrieve user's preference of print page format and print
 * scaling type.
 * </p>
 * <p>
 * The retrievePrintFormat() method will do the main job to retrieve user's preference of print page format and print
 * scaling type. Implementation should implements it by its own manner to retrieve these information. For instance, it
 * can prompt user a dialog to retrieve these information or it can read these information from configuration file.
 * </p>
 * <p>
 * Currently, it has one implementation <c>DefaultPrintFormatRetriever</c> which will prompt user a dialog.
 * </p>
 * <p>
 * There is no need for implementation to be thread-safe..
 * </p>
 * @author Xuchen, TCSDEVELOPER
 * @version 1.0
 */
public interface PrintFormatRetriever {
    /**
     * <p>It will return PageFormat instance which represents user's preference for page format.</p>
     *
     * @return PageFormat instance represents user's preference for page format.
     * @throw IllegalStateException if the pageFormat is not already set
     */
    public PageFormat getPageFormat();

    /**
     * <p>If isFitSinglePage() return false, it will return the scale factor user prefers to scale. Otherwise,
     * the result returned from this method is meaningless.</p>
     *
     * @return the scale factor
     * @throw IllegalStateException if the scaleFactor is not already set
     */
    public double getScaleFactor();

    /**
     * <p>Returns the flag representing whether print given component into single page which maybe required to
     * make component small enough to fit in single page if it is true. Otherwise if it is false, then it means that
     * the given component will be scaled by scaling factor (returned from getScaleFactor() method), and be split into
     * simple grids before being printed into several pages.</p>
     *
     * @return the fitSinglePage flag
     * @throw IllegalStateException if the fitSinglePage flag is not already set
     */
    public boolean isFitSinglePage();

    /**
     * <p>It should retrieve user's preference of print page format and print scaling type.</p>
     * @throws PrintFormatRetrieveException if any error occurs when retrieving user's preference for print
     * format and scaling style
     */
    public void retrievePrintFormat() throws PrintFormatRetrieveException;
}
