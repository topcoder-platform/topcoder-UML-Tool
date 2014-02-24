/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>The mock implementation of <code>GUIEventListener</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockGUIEventListener implements GUIEventListener {
    /** A name used to identify the instance. */
    private String name = null;

    /** Records all performed EventObject. */
    private Set<EventObject> performedRecords = new HashSet<EventObject>();

/**
     * Creates a new MockGUIEventListener object.
     *
     * @param name the name used to identify the instance
     */
    public MockGUIEventListener(String name) {
        this.name = name;
    }

    /**
     * Mock implementation, just register this event.
     *
     * @param event the non null event has been performed
     *
     * @throws IllegalArgumentException if the event is null
     */
    public void actionPerformed(EventObject event) {
        // Record the performance
        performedRecords.add(event);
    }

    /**
     * Get the instance name.
     *
     * @return the name of the instance
     */
    public String getName() {
        return name;
    }

    /**
     * Get the performed records.
     *
     * @return the performed records
     */
    public Set<EventObject> getPerformedRecords() {
        return performedRecords;
    }
}
