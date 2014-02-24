/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ MockTagListener.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.gui.panels.documentation.event.TagListener;


/**
 * This mock class implements TagListener interface, It can return the event happens.
 * This class is used for accuracytest only.
 *
 * @author still
 * @version 1.0
 */
class MockTagListener implements TagListener {
    /**
     * <p>
     * Represents the created event of this Listener.
     * </p>
     */
    public TagEvent eventCreated;

    /**
     * <p>
     * Represents the updated event of this Listener.
     * </p>
     */
    public TagEvent eventUpdated;

    /**
    * <p>
    * Represents the deleted event of this Listener.
    * </p>
    */
    public TagEvent eventDeleted;

    /**
     * <p>
     * Creates the <code>MockDoListener</code> instance.
     * </p>
     */
    public MockTagListener() {
    }

    /**
     * <p>
     * Listener method called whenever the panel creates initial tag for an element.
     * </p>
     *
     * @param event TagEvent containing the element, and its new tag.
     */
    public void tagCreated(TagEvent event) {
        eventCreated = event;
    }

    /**
     * <p>
     * Listener method called whenever the panel modifies the tag for an element.
     * </p>
     *
     * @param event TagEvent containing the element, and its previous and new tag.
     */
    public void tagUpdated(TagEvent event) {
        eventUpdated = event;
    }

    /**
     * <p>
     * Listener method called whenever the panel deletes tag for an element.
     * </p>
     *
     * @param event TagEvent containing the element, and its previous tag.
     */
    public void tagDeleted(TagEvent event) {
        eventDeleted = event;
    }
}
