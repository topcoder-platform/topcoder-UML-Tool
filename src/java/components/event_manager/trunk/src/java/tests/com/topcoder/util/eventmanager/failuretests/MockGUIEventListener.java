/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.failuretests;

import java.util.EventObject;

import com.topcoder.util.eventmanager.GUIEventListener;

/**
 * <p>
 * The mock implementation of <code>GUIEventListener</code> class.
 * </p>
 *
 * @author King_Bette
 * @version 1.0
 */
public class MockGUIEventListener implements GUIEventListener {

    /**
     * Creates a new MockGUIEventListener object.
     */
    public MockGUIEventListener() {
        // do nothing.
    }

    /**
     * Mock implementation, do nothing.
     *
     * @param event the event object to be performed.
     * @throws IllegalArgumentException
     *             if the event is null
     */
    public void actionPerformed(EventObject event) {
        // do nothing.
    }
}
