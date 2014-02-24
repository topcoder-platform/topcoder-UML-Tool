/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ MockDocListener.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.event.DocumentationListener;


/**
 * This mock class implements DocumentationListener interface, It can return the event happens.
 * This class is used for accuracy test only.
 *
 * @author still
 * @version 1.0
 */
class MockDocListener implements DocumentationListener {
    /**
     * <p>
     * Represents the created event of this Listener.
     * </p>
     */
    public DocumentationEvent eventCreated;

    /**
     * <p>
     * Represents the updated event of this Listener.
     * </p>
     */
    public DocumentationEvent eventUpdated;

    /**
    * <p>
    * Represents the deleted event of this Listener.
    * </p>
    */
    public DocumentationEvent eventDeleted;

    /**
     * <p>
     * Creates the <code>MockDoListener</code> instance.
     * </p>
     */
    public MockDocListener() {
    }

    /**
     * <p>
     * Listener method called whenever the panel creates initial documentation for an element.
     * </p>
     *
     * @param event DocumentationEvent containing the element, and its new documentation.
     */
    public void documentationCreated(DocumentationEvent event) {
        eventCreated = event;
    }

    /**
     * <p>
     * Listener method called whenever the panel modifies the documentation for an element.
     * </p>
     *
     * @param event DocumentationEvent containing the element, and its previous and new documentation.
     */
    public void documentationUpdated(DocumentationEvent event) {
        eventUpdated = event;
    }

    /**
     * <p>
     * Listener method called whenever the panel deletes documentation for an element.
     * </p>
     *
     * @param event DocumentationEvent containing the element, and its previous documentation.
     */
    public void documentationDeleted(DocumentationEvent event) {
        eventDeleted = event;
    }
}
