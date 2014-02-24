/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

/**
 * <p>
 * Mock class which implements <code>DocumentationListener</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class MockDocumentationListener implements DocumentationListener {
    /**
     * <p>
     * <code>DocumentationEvent</code> fired.
     * </p>
     */
    private DocumentationEvent event;

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
     * Get <code>DocumentationEvent</code> currently fired.
     * </p>
     *
     * @return event currently fired.
     */
    public DocumentationEvent getFiredEvent() {
        return this.event;
    }
    /**
     * <p>
     * Mock implementation of <code>documentationCreated()</code>.
     * </p>
     *
     * @param event <code>DocumentationEvent</code>
     */
    public void documentationCreated(DocumentationEvent event) {
        this.event = event;
        this.eventType = "created";
    }

    /**
     * <p>
     * Mock implementation of <code>documentationDeleted()</code>.
     * </p>
     *
     * @param event <code>DocumentationEvent</code>
     */
    public void documentationDeleted(DocumentationEvent event) {
        this.event = event;
        this.eventType = "deleted";
    }

    /**
     * <p>
     * Mock implementation of <code>documentationUpdated()</code>.
     * </p>
     *
     * @param event <code>DocumentationEvent</code>
     */
    public void documentationUpdated(DocumentationEvent event) {
        this.event = event;
        this.eventType = "updated";
    }
}
