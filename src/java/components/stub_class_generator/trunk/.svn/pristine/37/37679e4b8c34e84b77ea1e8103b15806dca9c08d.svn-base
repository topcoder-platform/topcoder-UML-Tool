/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Test implementation of the {@link Log} interface.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MyLogger implements Log {
    /**
     * Aggregated log messages.
     */
    private static final List<Object> LOGS = new ArrayList<Object>();

    /**
     * Creates a new instance.
     *
     * @param namespace
     *            is ignored
     */
    public MyLogger(String namespace) {
        // nothing to do
    }

    /**
     * Always returns <code>true</code>.
     *
     * @param level
     *            ignored.
     * @return always <code>true</code>
     */
    public boolean isEnabled(Level level) {
        return true;
    }

    /**
     * Saves the given log message.
     *
     * @param level
     *            ignored
     * @param msg
     *            the log message to be saved.
     */
    public void log(Level level, Object msg) {
        System.out.println(msg);
        LOGS.add(msg);
    }

    /**
     * Clears all aggregated log messages.
     */
    public static void clear() {
        LOGS.clear();
    }

    /**
     * Returns the list of logs.
     *
     * @return the list of logs.
     */
    public static List<Object> getLogs() {
        return LOGS;
    }
}
