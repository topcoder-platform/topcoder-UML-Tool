/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.stresstests;

/**
 * Utility class which providing time service.
 * 
 * @author CoInitialize
 * @version 1.0
 */
public final class StopWatch {

    /**
     * A long value represents System.currentTimeMillis() when start() is last called.
     */
    private long lastStartTime;

    /**
     * Start the stopwatch.
     */
    public void start() {
        lastStartTime = System.currentTimeMillis();
    }

    /**
     * Stop the stopwatch.
     * 
     * @return Time interval between start() and stop() in milliseconds.
     */
    public long stop() {
        return System.currentTimeMillis() - lastStartTime;
    }
}
