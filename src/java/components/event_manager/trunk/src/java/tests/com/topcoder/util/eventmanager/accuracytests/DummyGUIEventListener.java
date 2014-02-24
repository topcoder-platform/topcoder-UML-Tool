/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.accuracytests;

import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;

import com.topcoder.util.eventmanager.GUIEventListener;

/**
 * Dummy implementation of <code>GUIEventListener</code>.
 *
 * @author daiwb
 * @version 1.0
 */
public class DummyGUIEventListener implements GUIEventListener {

    /**
     * N/A.
     */
    private String name;

    /**
     * N/A.
     */
    Set<EventObject> actions = new HashSet<EventObject>();

    /**
     * N/A.
     *
     * @param name
     *            N/A.
     */
    DummyGUIEventListener(String name) {
        this.name = name;
    }

    /**
     * N/A.
     *
     * @param event
     *            N/A.
     */
    public void actionPerformed(EventObject event) {
        actions.add(event);
    }

    /**
     * N/A.
     *
     * @return N/A.
     */
    public String getName() {
        return name;
    }

    /**
     * N/A.
     *
     * @return N/A.
     */
    public Set<EventObject> getActions() {
        return actions;
    }

}
