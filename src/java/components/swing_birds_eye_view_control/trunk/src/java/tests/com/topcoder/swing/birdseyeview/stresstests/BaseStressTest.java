/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview.stresstests;

import junit.framework.TestCase;

/**
 * Base class for stress test cases.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BaseStressTest extends TestCase {

    /**
     * Represents the start time of the test.
     */
    private long startTime = 0;

    /**
     * Represents the stop time of the test.
     */
    private long stopTime = 0;

    /**
     * Represents whether the test is running or not.
     */
    private boolean running = false;

    /**
     * Start the stop watch.
     * 
     * @throws IllegalStateException
     *             if the test is already running.
     */
    protected void start() {
        if (running) {
            throw new IllegalStateException(
                    "The test is running, stop it first.");
        } else {
            running = true;
            startTime = System.currentTimeMillis();
        }
    }

    /**
     * Stop the stop watch.
     * 
     * @throws IllegalStateException
     *             if the test is not running.
     */
    protected void stop() {
        if (!running) {
            throw new IllegalStateException(
                    "The test is not running, start it first.");
        } else {
            running = false;
            stopTime = System.currentTimeMillis();
        }
    }

    /**
     * Get the test duration.
     * 
     * @return the test duration in milliseconds.
     */
    protected long getMilliseconds() {
        return stopTime - startTime;
    }
}
