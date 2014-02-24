/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

/**
 * <p>
 * This interface lays the contract for listening to events that occur in the document tree.
 * </p>
 *
 * <p>
 * Two types of events need to be handled :
 * <ul>
 * <li>selection events - involving selection of one or more tree nodes</li>
 * <li>name change events - involving the change of name of a single tree node.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Thread Safety: Implementations are not required to be thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public interface DocumentTreeEventListener {
    /**
     * <p>
     * This method is called to indicate to the listener that the selection of nodes has changed.
     * </p>
     *
     * @param event The event denoting the selection. Will not be null
     *
     * @throws IllegalArgumentException If event is null
     */
    public void treeNodeSelectionChanged(SelectionChangedEvent event);

    /**
     * <p>
     * This method is called to indicate to the listener that the name of a node has changed.
     * </p>
     *
     * @param event The event denoting the change of name. Will not be null.
     *
     * @throws IllegalArgumentException If event is null
     */
    public void treeNodeNameChanged(NameChangedEvent event);

    /**
     * <p>
     * This method is called to indicate to the listener that the view type has changed.
     * </p>
     *
     * @param event The event denoting the change of view type. Will not be null.
     *
     * @throws IllegalArgumentException If event is null
     */
    public void treeViewChanged(ViewChangedEvent event);
}
