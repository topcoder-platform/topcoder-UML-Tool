/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.stresstests;

import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.event.DocumentationListener;


/**
 * <p>This class implements the <code>DocumentationListener</code> interface. It used for
 * stress test only.</p>
 *
 * @author icyriver
 * @version 1.0
 */
class SimpleDocumentationListener implements DocumentationListener {
    /**
     * <p>This variable represents the created event of this listener.</p>
     */
    private DocumentationEvent createdEvent = null;

    /**
     * <p>This variable represents the updated event of this listener.</p>
     */
    private DocumentationEvent updatedEvent = null;

    /**
     * <p>This variable represents the deleted event of this listener.</p>
     */
    private DocumentationEvent deletedEvent = null;

    /**
     * <p>Creates the <code>SimpleDocumentationListener</code> instance.</p>
     */
    public SimpleDocumentationListener() {
    }

    /**
     * <p>The listener method called whenever the panel creates initial documentation for
     * an element.</p>
     *
     * @param event The event containing the element and its new documentation.
     */
    public void documentationCreated(DocumentationEvent event) {
        createdEvent = event;
    }

    /**
     * <p>The listener method called whenever the panel modifies the documentation for an
     * element.</p>
     *
     * @param event The event containing the element and its previous and new documentation.
     */
    public void documentationUpdated(DocumentationEvent event) {
        updatedEvent = event;
    }

    /**
     * <p>The listener method called whenever the panel deletes documentation for an
     * element.</p>
     *
     * @param event The event containing the element and its previous documentation.
     */
    public void documentationDeleted(DocumentationEvent event) {
        deletedEvent = event;
    }

    /**
     * <p>This method will get the documentation creating event.</p>
     *
     * @return The documentation creating event.
     */
    public DocumentationEvent getDocumentationCreatedEvent() {
        return createdEvent;
    }

    /**
     * <p>This method will get the documentation updating event.</p>
     *
     * @return The documentation updating event.
     */
    public DocumentationEvent getDocumentationUpdatedEvent() {
        return updatedEvent;
    }

    /**
     * <p>This method will get the documentation deleting event.</p>
     *
     * @return The documentation deleting event.
     */
    public DocumentationEvent getDocumentationDeletedEvent() {
        return deletedEvent;
    }
}
