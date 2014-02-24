/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.Util;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.gui.trees.document.DocumentTreePanel;

/**
 * <p>
 * This class implements the DocumentTreeView interface to show a tree view
 * that is package centric.
 * </p>
 *
 * <p>
 * This view has the model as root (level 0), with all other namespace elements arranged hierarchically
 * along with the classes and interfaces under a namespace. Activity graphs and collaborations are also
 * considered to be under the model.
 * </p>
 *
 * <p>
 * Sample configuration:
 * &lt;Property name=&quot;activity_graphs_category_name&quot;&gt;
 *     &lt;Value&gt;Activity Graphs&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;collaborations_category_name&quot;&gt;
 *     &lt;Value&gt;Collaborations&lt;/Value&gt;
 * &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as its base class is not thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class PackageCentricDocumentTreeView extends BaseDocumentTreeView {
    /**
     * <p>
     * This variable represents the tree model of this tree view.
     * </p>
     */
    private final DefaultTreeModel treeModel;

    /**
     * <p>
     * This variable represents the name of the category under which activity
     * graphs are stored in the tree.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is set by the constructor,
     * either through arguments or through configuration properties. It is used by the tree
     * construction methods.
     * </p>
     */
    private final String activityGraphsCategoryName;

    /**
     * <p>
     * This variable represents the name of the category under which collaborations are
     * stored in the tree.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is set by the constructor,
     * either through arguments or through configuration properties. It is used by the tree
     * construction methods.
     * </p>
     */
    private final String collaborationsCategoryName;

    /**
     * <p>
     * Constructs this object with the given parent and configuration properties from
     * the given namespace.
     * </p>
     *
     * @param parent The parent document tree panel. Must not be null.
     * @param namespace The namespace containing configuration properties. Must not be null or empty.
     *
     * @throws IllegalArgumentException If parent is null or namespace is null or empty.
     * @throws DocumentTreeConfigurationException If there is an error reading configuration properties.
     */
    public PackageCentricDocumentTreeView(DocumentTreePanel parent, String namespace) {
        super(parent, DocumentTreeViewType.PACKAGE_CENTRIC);
        Util.checkString(namespace, "namespace");

        this.activityGraphsCategoryName = DocumentTreeViewHelper.getPropertyValue(namespace,
            "activity_graphs_category_name");
        this.collaborationsCategoryName = DocumentTreeViewHelper.getPropertyValue(namespace,
            "collaborations_category_name");

        treeModel = (DefaultTreeModel) tree.getModel();

        updateTree();
    }

    /**
     * <p>
     * Adds the given node to the tree.
     * </p>
     *
     * @param treeNode The node to add. Must not be null.
     *
     * @throws IllegalArgumentException If treeNode is null.
     */
    public void addTreeNode(DocumentTreeNode treeNode) {
        DocumentTreeViewHelper.addTreeNode(this, treeNode);
    }

    /**
     * <p>
     * Updates the given node in the tree.
     * </p>
     *
     * @param treeNode The node to update. Must not be null. Must be a node in the tree.
     *
     * @throws IllegalArgumentException If treeNode is null or does not exist in the tree.
     */
    public void updateTreeNode(DocumentTreeNode treeNode) {
        DocumentTreeViewHelper.updateTreeNode(this, treeNode);
    }

    /**
     * <p>
     * Removes the given node from the tree.
     * </p>
     *
     * @param treeNode The node to removed. Must not be null. Must be a node in the tree.
     *
     * @throws IllegalArgumentException If treeNode is null or does not exist in the tree.
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

        DefaultMutableTreeNode rootTreeNode = DocumentTreeViewHelper.createPackageTree(this, manager,
            activityGraphsCategoryName, collaborationsCategoryName);

        treeModel.setRoot(rootTreeNode);
    }
}
