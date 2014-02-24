/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.Util;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * <p>
 * This is simple implementation of DocumentTreePanel interface. It has only one view (set during creation) which
 * can't be changed. It doesn't provide any additional stuff (like buttons) for user, just show tree.
 * </p>
 *
 * <p>
 * This class doesn't require any configuration itself, but configuration namespace required to create default
 * view.
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as it's internal fields are mutable (can change their state).
 * </p>
 *
 * @author Orange_Cloud
 * @version 1.1
 */
public class SimpleDocumentTreePanel implements DocumentTreePanel {
    /**
     * <p>
     * This variable represents the parent document tree tabbed pane of this tree view.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is set by the constructor
     * and got by the getParent method. It will never be null.
     * </p>
     */
    private final DocumentTreeTabbedPane parent;

    /**
     * <p>
     * This variable represents the panel used by this object to display the tree and
     * other controls.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is got by the
     * getPanel method.
     * </p>
     */
    private final JPanel panel;

    /**
     * <p>
     * This is the only tree view used in this object. It's initialized in constructor and
     * </p>
     */
    private final DocumentTreeView treeView;

    /**
     * <p>
     * Constructs this object from the given parent and configuration namespace and sets it's view as instance
     * of viewClassName class.
     * </p>
     *
     * @param parent The parent tabbed pane. Must not be null.
     * @param namespace The configuration namespace. Must not be null or empty.
     * @param viewClassName The fully qualified class name - implementation of DocumentTreeView interface.
     * @throws IllegalArgumentException If any argument is null or any String is empty.
     * @throws DocumentTreeConfigurationException If there is an error while instantiating default view
     *         (no such class found, for example)
     */
    public SimpleDocumentTreePanel(DocumentTreeTabbedPane parent, String namespace, String viewClassName) {
        Util.checkNull(parent, "parent");
        Util.checkString(namespace, "namespace");
        Util.checkString(viewClassName, "viewClassName");

        this.parent = parent;

        // create layout, like it's done in the DocumentTreePanelImpl, but without additional stuff
        treeView = Util.createTreeView(viewClassName, this, namespace);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JScrollPane treePane = new JScrollPane(treeView.getTree());

        panel.add(treePane, BorderLayout.CENTER);
    }

    /**
     * <p>
     * Returns the parent tabbed pane holding this document tree panel.
     * </p>
     *
     * @return The parent tabbed pane holding this document tree panel.
     */
    public DocumentTreeTabbedPane getParent() {
        return parent;
    }

    /**
     * <p>
     * Returns the panel that contains the current tree view and other controls for switching the tree view (if any).
     * </p>
     *
     * @return The panel that contains the current tree view and other controls for switching the tree view (if any).
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * <p>
     * Returns the tree view visible currently in the panel. Once implementation uses exactly one view,
     * will be returned element created in constructor.
     * </p>
     *
     * @return The tree view visible currently in the panel.
     */
    public DocumentTreeView getCurrentView() {
        return treeView;
    }

    /**
     * <p>
     * This method supposed to sets the tree view visible in the panel. But this operation not supported
     * for this type of tree panel, thus UnsupportedOperationException will be thrown.
     * </p>
     *
     * @param viewType The tree view type which should be made visible in the panel, currently unused.
     * @throws UnsupportedOperationException always
     */
    public void setCurrentView(DocumentTreeViewType viewType) {
        throw new UnsupportedOperationException(
                "In this type of panel (SimpleDocumentTreePanel) you can't alter views.");
    }

    /**
     * <p>
     * Returns all tree views possible in this panel. Since implementation allows exactly one view,
     * collection of one element will be returned.
     * </p>
     *
     * @return All tree views possible in this panel, contains exactly one element
     */
    public DocumentTreeView[] getAllViews() {
        return new DocumentTreeView[] {getCurrentView()};
    }
}
