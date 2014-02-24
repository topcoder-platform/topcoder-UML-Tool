/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

/**
 * <p>
 * This class represents a name changed event.
 * </p>
 *
 * <p>
 * This event is raised when the name of a node of the tree is changed by the user.
 * </p>
 *
 * <p>
 * Thread Safety: This class is thread safe as it is immutable.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class NameChangedEvent {
    /**
     * <p>
     * This variable represents the tree node whose name was changed.
     * </p>
     *
     * <p>
     * It is frozen as it will not be changed after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and got by the getTreeNode method.
     * </p>
     *
     * <p>
     * It will never be null.
     * </p>
     */
    private final DocumentTreeNode treeNode;

    /**
     * <p>
     * This variable represents the new name to which the name was changed.
     * </p>
     *
     * <p>
     * It is frozen as it will not be changed after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and got by the getNewName method.
     * </p>
     *
     * <p>
     * It will never be null, possibly empty.
     * </p>
     */
    private final String newName;

    /**
     * <p>
     * Constructs this name changed event with the given tree node and new name.
     * </p>
     *
     * @param treeNode The node whose name changed. Must not be null.
     * @param newName The name to which its name was changed. Must not be null, possibly empty.
     *
     * @throws IllegalArgumentException If either argument is null.
     */
    public NameChangedEvent(DocumentTreeNode treeNode, String newName) {
        Util.checkNull(treeNode, "treeNode");
        Util.checkNull(newName, "newName");

        this.treeNode = treeNode;
        this.newName = newName;
    }

    /**
     * <p>
     * Returns the tree node whose name was changed.
     * </p>
     *
     * @return The tree node whose name was changed
     */
    public DocumentTreeNode getTreeNode() {
        return this.treeNode;
    }

    /**
     * <p>
     * Returns the new name of the tree node.
     * </p>
     *
     * @return The new name of the tree node
     */
    public String getNewName() {
        return this.newName;
    }
}
