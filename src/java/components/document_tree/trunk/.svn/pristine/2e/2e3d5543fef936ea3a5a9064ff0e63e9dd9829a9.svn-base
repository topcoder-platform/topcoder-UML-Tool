/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import javax.swing.JTree;

/**
 * <p>
 * This interface lays the contract for a document tree view.
 * </p>
 *
 * <p>
 * It is responsible for generating a <code>JTree</code> that shows the tree view of a
 * UML Model in a particular view type.
 * </p>
 *
 * <p>
 * The contract also specifies methods to notify this object of changes to the model as
 * well as methods to set and get the selected elements of the view.
 * </p>
 *
 * <p>
 * Note, Implementations of this interface should provide the constructor accepting
 * <code>DocumentTreePanel</code> and <code>String</code> two arguments.
 * </p>
 *
 * <p>
 * Thread Safety: Implementations are not required to be thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public interface DocumentTreeView {
    /**
     * <p>
     * Returns the parent document panel of this tree.
     * </p>
     *
     * @return The parent document panel of this tree.
     */
    public DocumentTreePanel getParent();

    /**
     * <p>
     * Returns the JTree used to display this tree.
     * </p>
     *
     * @return The JTree used to display this tree.
     */
    public JTree getTree();

    /**
     * <p>
     * Returns the view type of this tree.
     * </p>
     *
     * @return The view type of this tree.
     */
    public DocumentTreeViewType getViewType();

    /**
     * <p>
     * Adds the given node to the tree.
     * </p>
     *
     * @param treeNode The node to add. Must not be null.
     *
     * @throws IllegalArgumentException If treeNode is null.
     */
    public void addTreeNode(DocumentTreeNode treeNode);

    /**
     * <p>
     * Updates the given node in the tree.
     * </p>
     *
     * @param treeNode The node to update. Must not be null. Must be a node in the tree.
     *
     * @throws IllegalArgumentException If treeNode is null or does not exist in the tree.
     */
    public void updateTreeNode(DocumentTreeNode treeNode);

    /**
     * <p>
     * Removes the given node from the tree.
     * </p>
     *
     * @param treeNode The node to removed. Must not be null. Must be a node in the tree.
     *
     * @throws IllegalArgumentException If treeNode is null or does not exist in the tree.
     */
    public void removeTreeNode(DocumentTreeNode treeNode);

    /**
     * <p>
     * Updates the entire tree by reconstructing it from the UML model.
     * </p>
     */
    public void updateTree();

    /**
     * <p>
     * Gets the nodes currently selected in the tree view.
     * </p>
     *
     * @return The array of nodes currently selected. Will not be null, possibly empty.
     */
    public DocumentTreeNode[] getSelectedTreeNodes();

    /**
     * <p>
     * Sets the nodes currently selected in the tree view.
     * </p>
     *
     * @param selectedTreeNodes The nodes to be selected. Must not be null or contain null elements.
     *
     * @throws IllegalArgumentException If the array of nodes is null or contains null elements.
     */
    public void setSelectedTreeNodes(DocumentTreeNode[] selectedTreeNodes);

    /**
     * <p>
     * Sets the nodes currently expanded in the tree view.
     * </p>
     *
     * @param expandedTreeNodes The nodes to be expanded. Must not be null or contain null elements.
     * @throws IllegalArgumentException If the array of nodes is null or contains null elements.
     */
    public void setExpandedTreeNodes(DocumentTreeNode[] expandedTreeNodes);
}
