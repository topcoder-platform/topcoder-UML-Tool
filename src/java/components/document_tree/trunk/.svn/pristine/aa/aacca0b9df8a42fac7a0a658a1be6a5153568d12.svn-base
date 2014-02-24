/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import com.topcoder.gui.trees.document.ViewChangedEvent;
import com.topcoder.gui.trees.document.DocumentTreeEventListener;
import com.topcoder.gui.trees.document.NameChangedEvent;
import com.topcoder.gui.trees.document.SelectionChangedEvent;

/**
 * <p>
 * This class implements DocumentTreeEventListener interface and is used for testing purpose.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class SimpleDocumentTreeEventListener implements DocumentTreeEventListener {
    /**
     * <p>
     * Represent the last name changed event sent to this listener.
     * </p>
     */
    private NameChangedEvent nameEvent;

    /**
     * <p>
     * Represent the last selection changed event sent to this listener.
     * </p>
     */
    private SelectionChangedEvent selectionEvent;

    /**
     * <p>
     * Save the coming name changed event for testing purpose.
     * </p>
     *
     * @param event the name changed event
     */
    public void treeNodeNameChanged(NameChangedEvent event) {
        this.nameEvent = event;
    }

    /**
     * <p>
     * Save the coming selection changed event for testing purpose.
     * </p>
     *
     * @param event the selection changed event
     */
    public void treeNodeSelectionChanged(SelectionChangedEvent event) {
        this.selectionEvent = event;
    }

    /**
     * <p>
     * Get the last name changed event sent to this listener.
     * </p>
     *
     * @return the last name changed event sent to this listener.
     */
    public NameChangedEvent getLastNameEvent() {
        return nameEvent;
    }

    /**
     * <p>
     * Get the last selection changed event sent to this listener.
     * </p>
     *
     * @return the last selection changed event sent to this listener.
     */
    public SelectionChangedEvent getLastSelectionEvent() {
        return selectionEvent;
    }

    /**
     * <p>
     * This method is called to indicate to the listener that the view type has changed.
     * </p>
     *
     * @param event The event denoting the change of view type. Will not be null.
     */
    public void treeViewChanged(ViewChangedEvent event) {
        // nothing
    }
}
