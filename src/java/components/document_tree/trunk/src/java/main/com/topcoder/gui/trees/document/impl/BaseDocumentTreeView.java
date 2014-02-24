/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeViewTransferHandler;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.NameChangedEvent;
import com.topcoder.gui.trees.document.SelectionChangedEvent;
import com.topcoder.gui.trees.document.Util;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionListener;

import java.util.HashMap;
import java.util.Map;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JTree;
import com.topcoder.gui.trees.document.DocumentTreeView;

/**
 * <p>
 * This base class is abstract and implements the <code>DocumentTreeView</code> interface.
 * </p>
 *
 * <p>
 * It provides base functionality and handles the selection and name change events. The actual construction of the
 * tree and handling addition, removal and update of nodes is handled by the sub-class.
 * </p>
 *
 * <p>
 * Note, Implementations of this abstract class should provide the constructor accepting
 * <code>DocumentTreePanel</code> and <code>String</code> two arguments.
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as many method calls result in changes in the state of the maps as
 * well as the state of the <code>JTree</code>.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public abstract class BaseDocumentTreeView implements DocumentTreeView {
    /**
     * <p>
     * This variable represents the <code>JTree</code> used to display this tree view.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and got by the getTree method.
     * </p>
     *
     * <p>
     * It's underlying tree model is modified by various method calls of the sub-classes of this component,
     * therefore it is protected.
     * </p>
     */
    protected final JTree tree;

    /**
     * <p>
     * This variable maps the <code>DocumentTreeNode</code> objects to <code>DefaultMutableTreeNodes</code> objects
     * which are the tree nodes used by the <code>JTree</code> in its model.
     * </p>
     *
     * <p>
     * It is frozen as its reference will never change. It is manipulated by sub-classes as they construct the
     * tree.
     * </p>
     *
     * <p>
     * Both keys and values of this map will never be null.
     * </p>
     *
     * <p>
     * This map is required to convert document nodes to <code>JTree</code> nodes.
     * </p>
     */
    protected final Map<DocumentTreeNode, DefaultMutableTreeNode> documentNodeToTreeNodeMap;

    /**
     * <p>
     * This variable maps the <code>DefaultMutableTreeNode</code> objects which are the tree nodes used by the
     * <code>JTree</code> in its model to <code>DocumentTreeNode</code> objects.
     * </p>
     *
     * <p>
     * It is frozen as its reference will never change. It is manipulated by sub-classes as they construct the
     * tree.
     * </p>
     *
     * <p>
     * Both keys and values of this map will never be null.
     * </p>
     *
     * <p>
     * This map is required to reset the user objects of DefaultMutableTreeNodes as editing by users sets the user
     * object to a string.
     * </p>
     */
    protected final Map<DefaultMutableTreeNode, DocumentTreeNode> treeNodeToDocumentNodeMap;

    /**
     * <p>
     * This variable represents the parent panel of this tree view.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and got by the getParent method.
     * </p>
     *
     * <p>
     * It will never be null.
     * </p>
     */
    private final DocumentTreePanel parent;

    /**
     * <p>
     * This variable represents the view type of this tree view.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and got by the getViewType method.
     * </p>
     *
     * <p>
     * It will never be null.
     * </p>
     */
    private final DocumentTreeViewType viewType;

    /**
     * <p>
     * Constructs this document tree view with the given parent document pane and view type.
     * </p>
     *
     * <p>
     * Note, the underlying <code>JTree</code> will be editable and draggable.
     * </p>
     *
     * <p>
     * Two listeners - <code>TreeModelListener</code> and <code>TreeSelectionListener</code> - are installed to the
     * underlying <code>JTree</code> to handle the selection and name change events.
     * </p>
     *
     * @param parent
     *            The parent document pane. Must not be null.
     * @param viewType
     *            The view type of this document tree view. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If the parent or viewType is null
     */
    protected BaseDocumentTreeView(DocumentTreePanel parent, DocumentTreeViewType viewType) {
        Util.checkNull(parent, "parent");
        Util.checkNull(viewType, "viewType");

        this.parent = parent;
        this.viewType = viewType;

        tree = new JTree();

        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);

        DocumentTreeTabbedPane pane = parent.getParent();
        tree.setCellRenderer(pane.getTreeCellRenderer());

        // can be dragged
        tree.setDragEnabled(true);

        // can be edited
        tree.setEditable(true);

        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);

        // install a transfer handler
        tree.setTransferHandler(new DocumentTreeViewTransferHandler(pane));

        // install the listeners
        tree.getModel().addTreeModelListener(new DocumentTreeModelListener());
        tree.addTreeSelectionListener(new DocumentTreeSelectionListener());

        documentNodeToTreeNodeMap = new HashMap<DocumentTreeNode, DefaultMutableTreeNode>();
        treeNodeToDocumentNodeMap = new HashMap<DefaultMutableTreeNode, DocumentTreeNode>();
    }

    /**
     * <p>
     * Returns the parent document panel of this tree.
     * </p>
     *
     * @return The parent document panel of this tree.
     */
    public DocumentTreePanel getParent() {
        return this.parent;
    }

    /**
     * <p>
     * Returns the <code>JTree</code> used to display this tree.
     * </p>
     *
     * @return The <code>JTree</code> used to display this tree.
     */
    public JTree getTree() {
        return this.tree;
    }

    /**
     * <p>
     * Returns the view type of this tree.
     * </p>
     *
     * @return The view type of this tree.
     */
    public DocumentTreeViewType getViewType() {
        return this.viewType;
    }

    /**
     * <p>
     * Adds the given node to the tree.
     * </p>
     *
     * @param treeNode
     *            The node to add. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If treeNode is null.
     */
    public abstract void addTreeNode(DocumentTreeNode treeNode);

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
    public abstract void updateTreeNode(DocumentTreeNode treeNode);

    /**
     * <p>
     * Removes the given node from the tree.
     * </p>
     *
     * @param treeNode
     *            The node to remove. Must not be null. Must be a node in the tree.
     *
     * @throws IllegalArgumentException
     *             If treeNode is null or does not exist in the tree.
     */
    public abstract void removeTreeNode(DocumentTreeNode treeNode);

    /**
     * <p>
     * Updates the entire tree by reconstructing it from the UML model.
     * </p>
     */
    public abstract void updateTree();

    /**
     * <p>
     * Gets the nodes currently selected in the tree view.
     * </p>
     *
     * <p>
     * Note, the return array will never be null, but may be empty.
     * </p>
     *
     * @return The array of nodes currently selected. Will not be null, possibly empty.
     */
    public DocumentTreeNode[] getSelectedTreeNodes() {
        return getDocumentTreeNodes(tree.getSelectionPaths());
    }

    /**
     * <p>
     * Converts the tree paths from <code>TreePath</code> array to <code>DocumentTreeNode</code>.
     * </p>
     *
     * <p>
     * Note, if the <code>paths</code> is null, then an empty array will be returned.
     * </p>
     *
     * @param paths
     *            the tree paths
     *
     * @return the corresponding <code>DocumentTreeNode</code> converted from the given tree paths
     */
    private DocumentTreeNode[] getDocumentTreeNodes(TreePath[] paths) {
        if (paths == null) {
            return new DocumentTreeNode[0];
        }

        DocumentTreeNode[] nodes = new DocumentTreeNode[paths.length];
        for (int i = 0; i < paths.length; i++) {
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) paths[i].getLastPathComponent();
            nodes[i] = (DocumentTreeNode) treeNode.getUserObject();
        }

        return nodes;
    }

    /**
     * <p>
     * Sets the nodes currently selected in the tree view.
     * </p>
     *
     * <p>
     * All the tree nodes in the <code>JTree</code> that have the given <code>DocumentTreeNode</code> instances as
     * user object will be set to selected.
     * </p>
     *
     * @param selectedTreeNodes
     *            The nodes to be selected. Must not be null or contain null elements, any element in the array
     *            must be present in the tree.
     *
     * @throws IllegalArgumentException
     *             If the array of nodes is null or contains null elements, or any element in the given array
     *             doesn't exist in the tree.
     */
    public void setSelectedTreeNodes(DocumentTreeNode[] selectedTreeNodes) {
        Util.checkArray(selectedTreeNodes, "selectedTreeNodes");

        TreePath[] paths = new TreePath[selectedTreeNodes.length];
        for (int i = 0; i < selectedTreeNodes.length; i++) {
            DefaultMutableTreeNode treeNode = this.documentNodeToTreeNodeMap.get(selectedTreeNodes[i]);
            if (treeNode == null) {
                throw new IllegalArgumentException("One of the given tree nodes does not exist in the tree.");
            }

            paths[i] = new TreePath(treeNode.getPath());
        }

        tree.setSelectionPaths(paths);
    }

    /**
     * <p>
     * Sets the nodes currently selected in the tree view.
     * </p>
     * <p>
     * All the tree nodes in the <code>JTree</code> that have the given <code>DocumentTreeNode</code> instances as
     * user object will be set to selected.
     * </p>
     *
     * @param expandedTreeNodes
     *            The nodes to be selected. Must not be null or contain null elements, any element in the array
     *            must be present in the tree.
     * @throws IllegalArgumentException
     *             If the array of nodes is null or contains null elements, or any element in the given array
     *             doesn't exist in the tree.
     */
    public void setExpandedTreeNodes(DocumentTreeNode[] expandedTreeNodes) {
        Util.checkArray(expandedTreeNodes, "expandedTreeNodes");
        for (int i = 0; i < expandedTreeNodes.length; i++) {
            DefaultMutableTreeNode treeNode = this.documentNodeToTreeNodeMap.get(expandedTreeNodes[i]);
            if (treeNode == null) {
                throw new IllegalArgumentException("One of the given tree nodes does not exist in the tree.");
            }
            tree.expandPath(new TreePath(treeNode.getPath()));
        }
    }

    /**
     * <p>
     * This class implements <code>TreeModelListener</code> interface and is used to listen to tree model events.
     * </p>
     *
     * <p>
     * Thread Safety: This class is thread safe as it has no state.
     * </p>
     *
     * @author humblefool, biotrail
     * @version 1.0
     */
    private class DocumentTreeModelListener implements TreeModelListener {
        /**
         * <p>
         * This method is called to indicate that one or more nodes of the tree have changed in some way.
         * </p>
         *
         * <p>
         * This method will be invoked due to the fact that either the user or the outer class has changed the name
         * of a single node.
         * </p>
         *
         * @param e
         *            The <code>TreeModelEvent</code> representing the change. Must not be null.
         *
         * @throws IllegalArgumentException
         *             If the tree model event is null.
         */
        public void treeNodesChanged(TreeModelEvent e) {
            Util.checkNull(e, "tree model event");

            TreePath path = e.getTreePath();
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) path.getLastPathComponent();

            // If the event lists children, then the changed node is the child of the node we've already
            // gotten. Otherwise, the changed node and the specified node are the same.
            int[] indices = e.getChildIndices();
            if (indices != null && indices.length > 0) {
                treeNode = (DefaultMutableTreeNode) (treeNode.getChildAt(indices[0]));
            }

            String newName = treeNode.getUserObject().toString();

            DocumentTreeNode node = treeNodeToDocumentNodeMap.get(treeNode);
            treeNode.setUserObject(node);

            if (newName != null) {
                getParent().getParent().fireNameChangedEvent(new NameChangedEvent(node, newName));
            }
        }

        /**
         * <p>
         * This method is called to indicate that one or more nodes of the tree have been inserted.
         * </p>
         *
         * <p>
         * It does nothing in the current implementation.
         * </p>
         *
         * @param e
         *            The TreeModelEvent representing the insertion. Must not be null.
         *
         * @throws IllegalArgumentException
         *             If the tree model event is null.
         */
        public void treeNodesInserted(TreeModelEvent e) {
            Util.checkNull(e, "tree model event");

            // does nothing
        }

        /**
         * <p>
         * This method is called to indicate that one or more nodes of the tree have been removed.
         * </p>
         *
         * <p>
         * It does nothing in the current implementation.
         * </p>
         *
         * @param e
         *            The TreeModelEvent representing the removal. Must not be null.
         *
         * @throws IllegalArgumentException
         *             If the tree model event is null
         */
        public void treeNodesRemoved(TreeModelEvent e) {
            Util.checkNull(e, "tree model event");

            // does nothing
        }

        /**
         * <p>
         * This method is called to indicate that the tree structure has changed.
         * </p>
         *
         * <p>
         * It does nothing in the current implementation.
         * </p>
         *
         * @param e
         *            The TreeModelEvent representing the structural change. Must not be null.
         *
         * @throws IllegalArgumentException
         *             If the tree event model is null.
         */
        public void treeStructureChanged(TreeModelEvent e) {
            Util.checkNull(e, "tree model event");

            // does nothing
        }
    }

    /**
     * <p>
     * This class implements <code>TreeSelectionListener</code> interface and is used to listen to tree selection
     * events.
     * </p>
     *
     * <p>
     * Thread Safety: This class is thread safe as it has no state.
     * </p>
     *
     * @author humblefool, biotrail
     * @version 1.0
     */
    private class DocumentTreeSelectionListener implements TreeSelectionListener {
        /**
         * <p>
         * This method is called to indicate that the selection of tree nodes has changed.
         * </p>
         *
         * @param e
         *            The TreeSelectionEvent representing the selection change. Must not be null.
         *
         * @throws IllegalArgumentException
         *             If tree selection event is null.
         */
        public void valueChanged(TreeSelectionEvent e) {
            Util.checkNull(e, "tree selection event");

            DocumentTreeNode[] nodes = getDocumentTreeNodes(e.getPaths());

            boolean[] areNew = new boolean[nodes.length];
            for (int i = 0; i < nodes.length; ++i) {
                areNew[i] = e.isAddedPath(i);
            }
            getParent().getParent().fireSelectionChangedEvent(new SelectionChangedEvent(nodes, areNew));
        }
    }
}
