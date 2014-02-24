/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.uml.modelmanager.UMLModelManager;
import java.util.Collection;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.JTabbedPane;

/**
 * <p>
 * This interface is the primary point of interaction for users of this component.
 * </p>
 *
 * <p>
 * It lays the contract for a multi-tabbed document tree panel.
 * </p>
 *
 * <p>
 * The contract consists of methods to add new panels, remove existing ones, and set the current panel.
 * </p>
 *
 * <p>
 * This interface also acts as a facade for the other parts of this component and has methods for
 * manipulating the document tree in the current tab.
 * It also has methods to be notified of model changes.
 * Lastly, it also supports addition and removal of event listeners which listen to selection and name
 * change events in the document tree.
 * </p>
 *
 * <p>
 * Thread Safety: Implementations are not required to be thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public interface DocumentTreeTabbedPane {
    /**
     * <p>
     * Returns the tabbed pane used by this object to depict a tabbed document tree.
     * </p>
     *
     * @return The tabbed pane used by this object to depict a tabbed document tree.
     */
    public JTabbedPane getTabbedPane();

    /**
     * <p>
     * Returns the UML Model manager on which this document tree tabbed pane is based.
     * </p>
     *
     * @return The UML Model manager on which this document tree tabbed pane is based.
     */
    public UMLModelManager getModelManager();

    /**
     * <p>
     * Returns the tree cell renderer used to render individual tree cells.
     * </p>
     *
     * @return The tree cell renderer used to render individual tree cells.
     */
    public TreeCellRenderer getTreeCellRenderer();

    /**
     * <p>
     * Creates a panel in a new tab in this tabbed pane.
     * </p>
     *
     * @return The document tree panel in newly created tab.
     */
    public DocumentTreePanel createNewPanel();

    /**
     * <p>
     * Gets the document tree panel currently visible in this tabbed pane.
     * </p>
     *
     * @return The document tree panel currently visible in this tabbed pane.
     */
    public DocumentTreePanel getCurrentPanel();

    /**
     * <p>
     * Gets the document tree panels in this tabbed pane.
     * </p>
     *
     * @return The document tree panels in this tabbed pane.
     */
    public Collection<DocumentTreePanel> getPanels();

    /**
     * <p>
     * Sets the document tree panel currently visible in this tabbed pane.
     * </p>
     *
     * @param panel The document tree panel that should be visible in this tabbed pane.
     * Must not be null.
     *
     * @throws IllegalArgumentException If the panel argument is null.
     */
    public void setCurrentPanel(DocumentTreePanel panel);

    /**
     * <p>
     * Removes the given document tree panel from this tabbed pane.
     * </p>
     *
     * @param panel The document tree panel that should be removed from this tabbed pane.
     * Must not be null.
     *
     * @throws IllegalArgumentException If the panel argument is null.
     */
    public void removePanel(DocumentTreePanel panel);

    /**
     * <p>
     * Adds the given listener to the listeners of this object listening to document tree events.
     * </p>
     *
     * @param listener The listener to add. Must not be null.
     *
     * @throws IllegalArgumentException If the listener argument is null.
     */
    public void addDocumentTreeEventListener(DocumentTreeEventListener listener);

    /**
     * <p>
     * Removes the given listener from the listeners of this object listening to document
     * tree events.
     * </p>
     *
     * @param listener The listener to remove. Must not be null.
     *
     * @throws IllegalArgumentException If the listener argument is null.
     */
    public void removeDocumentTreeEventListener(DocumentTreeEventListener listener);

    /**
     * <p>
     * Gets all listeners of this object listening to document tree events.
     * </p>
     *
     * @return All listeners of this object listening to document tree events.
     */
    public DocumentTreeEventListener[] getAllDocumentTreeEventListeners();

    /**
     * <p>
     * Notifies all listeners of a selection changed event.
     * </p>
     *
     * @param event The selection changed event. Must not be null.
     *
     * @throws IllegalArgumentException If event is null.
     */
    public void fireSelectionChangedEvent(SelectionChangedEvent event);

    /**
     * <p>
     * Notifies all listeners of a name changed event.
     * </p>
     *
     * @param event The name changed event. Must not be null.
     *
     * @throws IllegalArgumentException If event is null.
     */
    public void fireNameChangedEvent(NameChangedEvent event);

    /**
     * <p>
     * Notifies all listeners of a view changed event.
     * </p>
     *
     * @param event The view changed event. Must not be null.
     *
     * @throws IllegalArgumentException If event is null.
     */
    public void fireViewChangedEvent(ViewChangedEvent event);

    /**
     * <p>
     * Adds the given node to all the trees of this object.
     * </p>
     *
     * @param treeNode The node to add. Must not be null.
     *
     * @throws IllegalArgumentException If treeNode is null.
     */
    public void addTreeNode(DocumentTreeNode treeNode);

    /**
     * <p>
     * Updates the given node in all the trees of this object.
     * </p>
     *
     * @param treeNode The node to update. Must not be null.
     *
     * @throws IllegalArgumentException If treeNode is null.
     */
    public void updateTreeNode(DocumentTreeNode treeNode);

    /**
     * <p>
     * Removes the given node from all the trees of this object.
     * </p>
     *
     * @param treeNode The node to removed. Must not be null.
     *
     * @throws IllegalArgumentException If treeNode is null.
     */
    public void removeTreeNode(DocumentTreeNode treeNode);

    /**
     * <p>
     * Updates the entire tree for all trees of this object by reconstructing it
     * from the UML model.
     * </p>
     */
    public void updateTree();

    /**
     * <p>
     * Gets the nodes currently selected in the tree view of the current tab.
     * </p>
     *
     * @return The array of nodes currently selected. Will not be null, possibly empty.
     */
    public DocumentTreeNode[] getSelectedTreeNodes();

    /**
     * <p>
     * Sets the nodes currently selected in the tree view of the current tab.
     * </p>
     *
     * @param selectedTreeNodes The nodes to be selected. Must not be null or contain null elements.
     * @throws IllegalArgumentException If the array of nodes is null or contains null elements.
     */
    public void setSelectedTreeNodes(DocumentTreeNode[] selectedTreeNodes);

    /**
     * <p>
     * Returns the tree view type of the tree view currently visible.
     * </p>
     *
     * @return The tree view type of the tree view visible currently.
     */
    public DocumentTreeViewType getCurrentViewType();

    /**
     * <p>
     * Sets the tree view visible in the panel of the current tab.
     * </p>
     *
     * @param viewType The tree view type which should be made visible in the panel of the current tab.
     * @throws IllegalArgumentException if viewType is null or it is not configured in this tree panel
     * @throws UnsupportedOperationException if underlying panel implementation not supposed to change view type
     */
    public void setCurrentViewType(DocumentTreeViewType viewType);
}
