/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.Util;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This class implements the DocumentTreeView interface to show a tree view that is diagram centric.
 * </p>
 *
 * <p>
 * This view has the model as root (level 0), with diagram categories at level 1, diagrams at level 2, and elements
 * of diagrams at level 3.
 * </p>
 *
 * <p>
 * Sample configuration: &lt;Property name=&quot;diagram_categories&quot;&gt; &lt;Property name=&quot;Use
 * Case&quot;&gt; &lt;Value&gt;Use Case Diagram&lt;/Value&gt; &lt;/Property&gt; &lt;Property
 * name=&quot;Class&quot;&gt; &lt;Value&gt;Class Diagram&lt;/Value&gt; &lt;/Property&gt; &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as its base class is not thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class DiagramCentricDocumentTreeView extends BaseDocumentTreeView implements ActionListener {
    private final class CustomPopupMenu extends JPopupMenu {
        private TreePath lastPath;

        public TreePath getLastPath() {
            return lastPath;
        }

        public void setLastPath(TreePath lastPath) {
            this.lastPath = lastPath;
        }
    }

    /**
     * <p>
     * Represents the <b>diagram_categories</b> property name.
     * </p>
     */
    private static final String DIAGRAM_CATEGORIES = "diagram_categories";

    /**
     * <p>
     * Represents the <b>show_child_diagram_view</b> property name.
     * </p>
     */
    private static final String SHOW_CHILD_DIAGRAM_VIEW = "show_child_diagram_view";

    /**
     * <p>
     * This variable represents the tree model of this tree view.
     * </p>
     */
    private final DefaultTreeModel treeModel;

    /**
     * <p>
     * This variable maps the typeInfo property of a diagram's semantic bridge onto a category name.
     * </p>
     *
     * <p>
     * The key gives the typeInfo value and the value gives the diagramCategoryName. Both keys and values will
     * never be null or empty.
     * </p>
     *
     * <p>
     * This variable is frozen and is stored as an unmodifiable map. It will never be null. It is referenced by
     * most methods of this class while constructing trees.
     * </p>
     */
    private final Map<String, String> diagramCategoryNames;

    /** Whether the child of diagram shown or not. */
    private boolean showChild;

    private Action addActivityDiagramAction;

    private Action addClassDiagramAction;

    private Action addSequenceDiagramAction;

    private Action addUseCaseDiagramAction;

    private Action deleteDiagramAction;

    private Action duplicateDiagramAction;

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
     * @throws DocumentTreeConfigurationException
     *             If there is an error reading configuration properties.
     */
    public DiagramCentricDocumentTreeView(DocumentTreePanel parent, String namespace) {
        super(parent, DocumentTreeViewType.DIAGRAM_CENTRIC);
        Util.checkString(namespace, "namespace");

        treeModel = (DefaultTreeModel) tree.getModel();
        diagramCategoryNames = getDiagramCategoryMapping(namespace);
        try {
            String showChildString =
                (String) ConfigManager.getInstance().getProperty(namespace, SHOW_CHILD_DIAGRAM_VIEW);
            showChild = showChildString.equals("true") ? true : false;
        } catch (ConfigManagerException e) {
            throw new DocumentTreeConfigurationException("UnknownNamespaceException occurs "
                + "when accessing ConfigManager.", e);
        }

        final JPopupMenu popup = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Add Activity Diagram");
        menuItem.addActionListener(this);
        popup.add(menuItem);
        menuItem = new JMenuItem("Add Class Diagram");
        menuItem.addActionListener(this);
        popup.add(menuItem);
        menuItem = new JMenuItem("Add Use Case Diagram");
        menuItem.addActionListener(this);
        popup.add(menuItem);
        menuItem = new JMenuItem("Add Sequence Diagram");
        menuItem.addActionListener(this);
        popup.add(menuItem);

        final CustomPopupMenu popupDiagram = new CustomPopupMenu();
        menuItem = new JMenuItem("Add Activity Diagram");
        menuItem.addActionListener(this);
        popupDiagram.add(menuItem);
        menuItem = new JMenuItem("Add Class Diagram");
        menuItem.addActionListener(this);
        popupDiagram.add(menuItem);
        menuItem = new JMenuItem("Add Use Case Diagram");
        menuItem.addActionListener(this);
        popupDiagram.add(menuItem);
        menuItem = new JMenuItem("Add Sequence Diagram");
        menuItem.addActionListener(this);
        popupDiagram.add(menuItem);
        menuItem = new JMenuItem("Delete");
        menuItem.addActionListener(this);
        popupDiagram.add(menuItem);
        menuItem = new JMenuItem("Rename");
        menuItem.addActionListener(this);
        popupDiagram.add(menuItem);

        // removed until it is better architected
        // menuItem = new JMenuItem("Duplicate");
        // menuItem.addActionListener(this);
        // popupDiagram.add(menuItem);

        getTree().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {

                    TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                    Object userObject = ((DefaultMutableTreeNode) selPath.getLastPathComponent()).getUserObject();
                    if (selPath != null && userObject instanceof DocumentTreeNode
                        && ((DocumentTreeNode) userObject).getNodeObject() instanceof Diagram) {
                        popupDiagram.setLastPath(selPath);
                        popupDiagram.show(e.getComponent(), e.getX(), e.getY());
                    } else {
                        popup.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });

        updateTree();

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

        DefaultMutableTreeNode rootTreeNode =
            DocumentTreeViewHelper.createDiagramTree(this, manager, this.diagramCategoryNames, showChild);

        treeModel.setRoot(rootTreeNode);
    }

    /**
     * <p>
     * Gets the diagram category map with the given namespace specified.
     * </p>
     *
     * @param namespace
     *            the namespace containing configuration properties.
     *
     * @return the diagram category map with the given namespace specified.
     */
    private Map<String, String> getDiagramCategoryMapping(String namespace) {
        Map<String, String> mappings = new HashMap<String, String>();
        ConfigManager cm = ConfigManager.getInstance();

        try {
            Property diagramProp = cm.getPropertyObject(namespace, DIAGRAM_CATEGORIES);

            if (diagramProp == null) {
                throw new DocumentTreeConfigurationException("The diagram_categories property is missing.");
            }

            // get all the child property
            for (Object obj : diagramProp.list()) {
                Property prop = (Property) obj;

                String name = prop.getName();

                prop = prop.getProperty("display");
                String value = prop.getValue();
                if (value == null || value.trim().length() == 0) {
                    throw new DocumentTreeConfigurationException("The property value for [" + name
                        + "] property is null or empty.");
                }

                // put the property name and value to the map
                mappings.put(name, value);
            }

            return mappings;

        } catch (UnknownNamespaceException e) {
            throw new DocumentTreeConfigurationException("UnknownNamespaceException occurs "
                + "when accessing ConfigManager.", e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Activity Diagram")) {
            addActivityDiagramAction.actionPerformed(e);
        } else if (e.getActionCommand().equals("Add Class Diagram")) {
            addClassDiagramAction.actionPerformed(e);
        } else if (e.getActionCommand().equals("Add Use Case Diagram")) {
            addUseCaseDiagramAction.actionPerformed(e);
        } else if (e.getActionCommand().equals("Add Sequence Diagram")) {
            addSequenceDiagramAction.actionPerformed(e);
        } else if (e.getActionCommand().equals("Rename")) {
            tree.startEditingAtPath(((CustomPopupMenu) ((JMenuItem) e.getSource()).getParent()).getLastPath());
        } else if (e.getActionCommand().equals("Delete")) {
            tree.setSelectionPath(((CustomPopupMenu) ((JMenuItem) e.getSource()).getParent()).getLastPath());
            deleteDiagramAction.actionPerformed(e);
        } else if (e.getActionCommand().equals("Duplicate")) {
            tree.setSelectionPath(((CustomPopupMenu) ((JMenuItem) e.getSource()).getParent()).getLastPath());
            duplicateDiagramAction.actionPerformed(e);
        }
    }

    public void setAddActivityDiagramAction(Action action) {
        this.addActivityDiagramAction = action;
    }

    public void setAddClassDiagramAction(Action action) {
        this.addClassDiagramAction = action;
    }

    public void setAddSequenceDiagramAction(Action action) {
        this.addSequenceDiagramAction = action;
    }

    public void setAddUseCaseDiagramAction(Action action) {
        this.addUseCaseDiagramAction = action;
    }

    public void setDeleteDiagramAction(Action action) {
        this.deleteDiagramAction = action;
    }

    public void setDuplicateDiagramAction(Action duplicateDiagramAction) {
        this.duplicateDiagramAction = duplicateDiagramAction;
    }
}
