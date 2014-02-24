/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import javax.swing.JPanel;

/**
 * <p>
 * This interface lays the contract for representing a single document tree whose
 * view can be changed to any of the views enumerated by <code>DocumentTreeViewType</code>
 * enum.
 * </p>
 *
 * <p>
 * Thread Safety: Implementations are not required to be thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public interface DocumentTreePanel {
    /**
     * <p>
     * Returns the parent tabbed pane holding this document tree panel.
     * </p>
     *
     * @return The parent tabbed pane holding this document tree panel.
     */
    public DocumentTreeTabbedPane getParent();

    /**
     * <p>
     * Returns the panel that contains the current tree view and other controls
     * for switching the tree view (if any).
     * </p>
     *
     * @return The panel that contains the current tree view and other controls for
     * switching the tree view (if any).
     */
    public JPanel getPanel();

    /**
     * <p>
     * Returns the tree view visible currently in the panel.
     * </p>
     *
     * @return The tree view visible currently in the panel.
     */
    public DocumentTreeView getCurrentView();

    /**
     * <p>
     * Sets the tree view visible in the panel.
     * </p>
     *
     * @param viewType The tree view type which should be made visible in the panel.
     *
     * @throws IllegalArgumentException if viewType is null or it is not configured in this tree panel
     * @throws UnsupportedOperationException if implementation not supposed to change view type
     */
    public void setCurrentView(DocumentTreeViewType viewType);

    /**
     * <p>
     * Returns all tree views possible in this panel.
     * </p>
     *
     * @return All tree views possible in this panel.
     * Will not be null, possibly empty.
     */
    public DocumentTreeView[] getAllViews();
}
