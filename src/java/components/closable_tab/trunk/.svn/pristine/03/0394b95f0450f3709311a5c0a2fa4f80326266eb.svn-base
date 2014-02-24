/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import com.topcoder.util.errorhandling.ExceptionUtils;

/**
 * <p>
 * A helper method used in ClosableTabbedPane component. Please do NOT access this class from outside package.
 * </p>
 * <p>
 * Thread Safety: Safe.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class ClosableTabbedPaneHelper {
    /**
     * Prevent outside construction.
     */
    private ClosableTabbedPaneHelper() {
        // Does nothing.
    }

    /**
     * This method will check if events is null or empty, or contains null.
     * @param events
     *            the events to be checked
     * @throws IllegalArgumentException
     *             if events is null or empty, or contains null.
     */
    public static void checkArray(ClosableTabbedPaneEvent[] events) {
        ExceptionUtils.checkNull(events, null, null, "ClosableTabbedPaneEvent[] events must not be null");
        if (events.length == 0) {
            throw new IllegalArgumentException("ClosableTabbedPaneEvent[] events must not be empty");
        }
        for (ClosableTabbedPaneEvent e : events) {
            if (e == null) {
                throw new IllegalArgumentException("ClosableTabbedPaneEvent[] events must not contain null");
            }
        }
    }
}
