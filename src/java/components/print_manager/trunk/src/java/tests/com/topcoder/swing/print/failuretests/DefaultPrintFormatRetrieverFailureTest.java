/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.failuretests;

import junit.framework.TestCase;

import com.topcoder.swing.print.impl.DefaultPrintFormatRetriever;

/**
 * <p>
 * Failure test for <code>DefaultPrintFormatRetriever</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DefaultPrintFormatRetrieverFailureTest extends TestCase {

    /**
     * <p>
     * The DefaultPrintFormatRetriever instance created for failure testing.
     * </p>
     */
    private DefaultPrintFormatRetriever retriever = new DefaultPrintFormatRetriever();

    /**
     * <p>
     * Failure test for <code>getPageFormat()</code>.
     * </p>
     * <p>
     * The pageFormat is not set, IllegalStateException is expected.
     * </p>
     */
    public void testGetPageFormat() {
        try {
            retriever.getPageFormat();
            fail("the pageFormat is not set, IllegalStateException is expected.");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>isFitSinglePage()</code>.
     * </p>
     * <p>
     * The pageFormat is not set, IllegalStateException is expected.
     * </p>
     */
    public void testIsFitSinglePage() {
        try {
            retriever.isFitSinglePage();
            fail("the pageFormat is not set, IllegalStateException is expected.");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>getScaleFactor()</code>.
     * </p>
     * <p>
     * The pageFormat is not set, IllegalStateException is expected.
     * </p>
     */
    public void testGetScaleFactor() {
        try {
            retriever.getScaleFactor();
            fail("the pageFormat is not set, IllegalStateException is expected.");
        } catch (IllegalStateException e) {
            // expected
        }
    }
}
