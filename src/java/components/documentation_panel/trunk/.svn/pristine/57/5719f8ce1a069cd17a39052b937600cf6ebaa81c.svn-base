/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

/**
 * <p>
 * Mock class which implements <code>TagListener</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class MockTagListener implements TagListener {
    /**
     * <p>
     * <code>TagEvent</code> fired.
     * </p>
     */
    private TagEvent event;

    /**
     * <p>
     * Type of event.
     * </p>
     */
    private String eventType;

    /**
     * <p>
     * Get type of event fired.
     * </p>
     *
     * @return event type
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * <p>
     * Get <code>TagEvent</code> currently fired.
     * </p>
     *
     * @return event currently fired.
     */
    public TagEvent getFiredEvent() {
        return this.event;
    }
    /**
     * <p>
     * Mock implementation of <code>tagCreated()</code>.
     * </p>
     *
     * @param event <code>TagEvent</code>
     */
    public void tagCreated(TagEvent event) {
        this.event = event;
        this.eventType = "created";
    }

    /**
     * <p>
     * Mock implementation of <code>tagDeleted()</code>.
     * </p>
     *
     * @param event <code>TagEvent</code>
     */
    public void tagDeleted(TagEvent event) {
        this.event = event;
        this.eventType = "deleted";
    }

    /**
     * <p>
     * Mock implementation of <code>tagUpdated()</code>.
     * </p>
     *
     * @param event <code>TagEvent</code>
     */
    public void tagUpdated(TagEvent event) {
        this.event = event;
        this.eventType = "updated";
    }
}
