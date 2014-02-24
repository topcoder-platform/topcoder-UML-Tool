/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.Util;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class implements the DocumentTreeView interface to show a tree view that is class centric.
 * </p>
 *
 * <p>
 * This view has the model as root (level 0), with all other namespace elements arranged hierarchically along with
 * the classes and interfaces under a namespace.
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as its base class is not thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class ClassCentricDocumentTreeView extends BaseDocumentTreeView {
    /**
     * <p>
     * This variable represents the tree model of this tree view.
     * </p>
     */
    private final DefaultTreeModel treeModel;

    /**
     * <p>
     * Constructs this object with the given parent and configuration properties from the given namespace.
     * </p>
     *
     * @param parent
     *            The parent document tree panel. Must not be null.
     * @param namespace
     *            The namespace containing configuration properties. Must not be null or empty.
     *
     * @throws IllegalArgumentException
     *             If parent is null or namespace is null or empty.
     */
    public ClassCentricDocumentTreeView(DocumentTreePanel parent, String namespace) {
        super(parent, DocumentTreeViewType.CLASS_CENTRIC);
        Util.checkString(namespace, "namespace");

        treeModel = (DefaultTreeModel) tree.getModel();
        updateTree();
    }

    /**
     * <p>
     * Adds the given node to the tree.
     * </p>
     *
     * @param treeNode
     *            The node to add. Must not be null
     *
     * @throws IllegalArgumentException
     *             If treeNode is null.
     */
    public void addTreeNode(DocumentTreeNode treeNode) {
        DocumentTreeViewHelper.addTreeNode(this, treeNode);
    }

    /**
     * <p>
     * Updates the given node in the tree.
     * </p>
     *
     * @param treeNode
     *            The node to update. Must not be null. Must be a node in the tree.
     *
     * @throws IllegalArgumentException
     *             If treeNode is null or does not exist in the tree.
     */
    public void updateTreeNode(DocumentTreeNode treeNode) {
        DocumentTreeViewHelper.updateTreeNode(this, treeNode);
    }

    /**
     * <p>
     * Removes the given node from the tree.
     * </p>
     *
     * @param treeNode
     *            The node to removed. Must not be null. Must be a node in the tree.
     *
     * @throws IllegalArgumentException
     *             If treeNode is null or does not exist in the tree.
     */
    public void removeTreeNode(DocumentTreeNode treeNode) {
        DocumentTreeViewHelper.removeTreeNode(this, treeNode);
    }

    /**
     * <p>
     * Updates the entire tree by reconstructing it from the UML model.
     * </p>
     */
    public void updateTree() {
        UMLModelManager manager = this.getParent().getParent().getModelManager();

        DefaultMutableTreeNode rootTreeNode = DocumentTreeViewHelper.createClassTree(this, manager);

        treeModel.setRoot(rootTreeNode);
    }
}
