/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

/**
 * <p>
 * This class represents a view changed event.
 * </p>
 * <p>
 * This event is raised when the view is changed by the user.
 * </p>
 * <p>
 * Thread Safety: This class is thread safe as it is immutable.
 * </p>
 * @author ly, ly
 * @version 1.0
 */
public class ViewChangedEvent {
    /**
     * <p>
     * This variable represents the old view.
     * </p>
     */
    private final DocumentTreeView oldView;

    /**
     * <p>
     * This variable represents the new view.
     * </p>
     */
    private final DocumentTreeView newView;

    /**
     * <p>
     * Constructs this view changed event with the given old view and new view.
     * </p>
     * @param oldView
     *            the old view.Must not be null.
     * @param newView
     *            the new view.Must not be null.
     * @throws IllegalArgumentException
     *             If either argument is null.
     */
    public ViewChangedEvent(DocumentTreeView oldView, DocumentTreeView newView) {
        Util.checkNull(oldView, "oldView");
        Util.checkNull(newView, "newView");
        this.oldView = oldView;
        this.newView = newView;
    }

    /**
     * <p>
     * Returns the old view.
     * </p>
     * @return the old view
     */
    public DocumentTreeView getOldView() {
        return this.oldView;
    }

    /**
     * <p>
     * Returns the new view.
     * </p>
     * @return the new view
     */
    public DocumentTreeView getNewView() {
        return this.newView;
    }
}
