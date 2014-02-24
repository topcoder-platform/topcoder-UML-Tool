/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.stresstests;

import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.gui.panels.documentation.event.TagListener;


/**
 * <p>This class implements the <code>TagListener</code> interface. It used for stress test
 * only.</p>
 *
 * @author icyriver
 * @version 1.0
 */
class SimpleTagListener implements TagListener {
    /**
     * <p>This variable represents the created event of this listener.</p>
     */
    private TagEvent createdEvent = null;

    /**
     * <p>This variable represents the updated event of this listener.</p>
     */
    private TagEvent updatedEvent = null;

    /**
     * <p>This variable represents the deleted event of this listener.</p>
     */
    private TagEvent deletedEvent = null;

/**
     * <p>
     * Creates the <code>SimpleTagListener</code> instance.
     * </p>
     */
    public SimpleTagListener() {
    }

    /**
     * <p>The listener method called whenever the panel creates a new tag to be attached to
     * the element.</p>
     *
     * @param event The creating event containing the element, tag name, and its new documentation.
     */
    public void tagCreated(TagEvent event) {
        createdEvent = event;
    }

    /**
     * <p>The listener method called whenever the panel modifies the documentation for a
     * tag attached to the element.</p>
     *
     * @param event The updating event containing the element, tag name, and its previous and new
     *        documentation.
     */
    public void tagUpdated(TagEvent event) {
        updatedEvent = event;
    }

    /**
     * <p>The listener method called whenever the panel removes a tag, to be removed from
     * the element.</p>
     *
     * @param event The deleting event containing the element, tag name, and its previous
     *        documentation.
     */
    public void tagDeleted(TagEvent event) {
        deletedEvent = event;
    }

    /**
     * <p>This method will get the tag creating event.</p>
     *
     * @return The tag creating event.
     */
    public TagEvent getTagnCreatedEvent() {
        return createdEvent;
    }

    /**
     * <p>This method will get the tag updating event.</p>
     *
     * @return The tag updating event.
     */
    public TagEvent getTagUpdatedEvent() {
        return updatedEvent;
    }

    /**
     * <p>This method will get the tag deleting event.</p>
     *
     * @return The tag deleting event.
     */
    public TagEvent getTagDeletedEvent() {
        return deletedEvent;
    }
}
