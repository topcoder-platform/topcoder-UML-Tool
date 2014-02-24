/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases.stresstests;

import java.util.Date;


/**
 * Stress test helper methods.
 *
 * @author mgmg
 * @version 1.0
 */
final class StressTestHelper {
    /**
     * The test count.
     */
    static final int testCount = 1000;

    /**
     * Record the start time.
     */
    private static long startTime = 0;

    /**
     * Private constructor.
     */
    private StressTestHelper() {
    }

    /**
     * Start to record time.
     *
     */
    static long startTimer() {
        startTime = new Date().getTime();

        return startTime;
    }

    /**
     * Get the absolutely time.
     *
     */
    static long getAbsolutelyTimer() {
        return new Date().getTime() - startTime;
    }

    /**
     * Print the time used to the console.
     *
     */
    static void printTime(String method, int times) {
        System.out.println(method + " for " + ((times < 0) ? testCount : times) + " times will take "
            + getAbsolutelyTimer() + " ms");
    }

    /**
     * Print the time used to the console.
     *
     */
    static void printTime(String method) {
        System.out.println(method + " will take " + getAbsolutelyTimer() + " ms");
    }
}
