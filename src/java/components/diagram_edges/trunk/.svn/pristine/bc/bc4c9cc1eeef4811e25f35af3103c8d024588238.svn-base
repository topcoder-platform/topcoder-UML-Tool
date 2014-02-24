/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import java.util.Date;

/**
 * This class is a helper class used in stress tests.
 *
 * @author vividmxx
 * @version 1.0
 */
final class TestHelper {

    /**
     * The run time or thread number used in stress test.
     */
    public static final int NUMBER = 10000;

    /**
     * The <code>Date</code> instance used in the test to record the time.
     */
    private static Date timer = null;

    /**
     * The private constructor prevents creation.
     */
    private TestHelper() {
    }

    /**
     * Starts the timer. Simply sets the timer to the current time.
     */
    static void startTimer() {
        timer = new Date();
    }


    /**
     * Prints the test result.
     *
     * @param className
     *            the name of the target class
     */
    static void printResultMulTimes(String className) {
        System.out.println("Operating on " + className + " for " + NUMBER + " times costs "
                + (new Date().getTime() - timer.getTime()) + " milliseconds.");
    }
}
