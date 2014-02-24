/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

/**
 * <p>
 * This class represents a selection changed event.
 * </p>
 *
 * <p>
 * This event is raised when the selected nodes of a tree change.
 * </p>
 *
 * <p>
 * This means that this event will not be raised for example if a user
 * clicks on the same node twice.
 * </p>
 *
 * <p>
 * Thread Safety: This class is thread safe as it is immutable.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class SelectionChangedEvent {
    /**
     * <p>
     * This variable represents the list of selected nodes at the end of this
     * selection changed event.
     * </p>
     *
     * <p>
     * It is frozen as it will not be changed after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and got by the getSelectedTreeNodes method.
     * </p>
     *
     * <p>
     * It will never be null or contain null elements.
     * </p>
     */
    private final DocumentTreeNode[] selectedTreeNodes;

    /**
     * <p>
     * For each tree node identifies if that tree node is in fact new.
     * </p>
     *
     * <p>
     * It is frozen as it will not be changed after initialization.
     * </p>
     *
     * <p>
     * It will never be null, and the length of this array must be equals to the length of
     * <code>selectedTreeNodes</code>.
     * </p>
     */
    private final boolean[] areNew;

    /**
     * <p>
     * Constructs this selection changed event with the given array of selected nodes.
     * </p>
     *
     * <p>
     * Note, the given <code>selectedTreeNodes</code> is cloned.
     * </p>
     *
     * @param selectedTreeNodes The array of selected tree nodes. Must not be null or
     *        contain null elements.
     * @param areNew array for each tree node identifying if that tree node is in fact new.
     *
     * @throws IllegalArgumentException If selectedTreeNodes is null or contains null references, or
     *         areNew is null, or the size of the two arrays are not equals
     */
    public SelectionChangedEvent(DocumentTreeNode[] selectedTreeNodes, boolean[] areNew) {
        Util.checkArray(selectedTreeNodes, "selectedTreeNodes");
        Util.checkNull(areNew, "areNew");
        if (selectedTreeNodes.length != areNew.length) {
            throw new IllegalArgumentException("The given two arrays should be the same size.");
        }

        this.selectedTreeNodes = selectedTreeNodes.clone();
        this.areNew = areNew.clone();
    }

    /**
     * <p>
     * Returns the selected nodes at the end of this election event.
     * </p>
     *
     * <p>
     * Note, the <code>selectedTreeNodes</code> is cloned before returning.
     * </p>
     *
     * @return The selected nodes at the end of this election event.
     */
    public DocumentTreeNode[] getSelectedTreeNodes() {
        return selectedTreeNodes.clone();
    }

    /**
     * <p>
     * Returns whether the nodes are new added at the end of this selection event.
     * </p>
     *
     * <p>
     * Note, the <code>areNew</code> is cloned before returning.
     * </p>
     *
     * @return array for each tree node identifying if that tree node is in fact new.
     */
    public boolean[] getAreNew() {
        return areNew.clone();
    }
}
