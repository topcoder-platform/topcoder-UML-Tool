/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.tree.TreeCellRenderer;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeEventListener;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.NameChangedEvent;
import com.topcoder.gui.trees.document.SelectionChangedEvent;
import com.topcoder.gui.trees.document.Util;
import com.topcoder.gui.trees.document.ViewChangedEvent;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

/**
 * <p>
 * This class is a direct implementation of the DocumentTreeTabbedPane interface.
 * </p>
 *
 * <p>
 * It uses DocumentTreePanel to accomplish the actual tree view panels and simply provides a tabbed pane to switch
 * between tabs. It also holds properties common to all panels and tree views such as the listeners, cell renderer
 * and so on.
 * </p>
 *
 * <p>
 * Sample configuration: &lt;Property name=&quot;config_manager_specification_factory_namespace&quot;&gt;
 * &lt;Value&gt;com.topcoder.gui.trees.document.impl.objectfactory&lt;/Value&gt; &lt;/Property&gt; &lt;Property
 * name=&quot;tree_cell_renderer&quot;&gt; &lt;Value&gt;cell_render&lt;/Value&gt; &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Changes in 1.1: new DocumentTreePanel implementation supported (SimpleDocumentTreePanel). For this purpose
 * changes were made in constructor. First it will look for new style configuration. If default_tabs is not found
 * or empty, it will try old style. If old configuration root (view_types) missed too, it will create two default
 * (class-centric and diagram-centric, as it specified in RS) tabs (such behaviour required by PM).
 * </p>
 *
 * <p>
 * Sample of new configuration. All items listed above still presented and default_tabs root added: <Property
 * name="default_tabs"> <Value>com.topcoder.gui.trees.document.impl.ClassCentricDocumentTreeView</Value>
 * <Value>com.topcoder.gui.trees.document.impl.DiagramCentricDocumentTreeView</Value>
 * <Value>com.topcoder.gui.trees.document.impl.PackageCentricDocumentTreeView</Value> </Property>
 * </p>
 *
 * <p>
 * Also tab names can be specified explicitly instead of using default values. Just add default_tab_names property.
 * <Property name="default_tab_names"> <Value>ClassCentric</Value> <Value>name2</Value> <Value>name3</Value>
 * </Property>
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as its state is mutable despite having frozen variables.
 * </p>
 *
 * @author humblefool, biotrail, Orange_Cloud
 * @since 1.0
 * @version 1.1
 */
public class DocumentTreeTabbedPaneImpl implements DocumentTreeTabbedPane {
    /**
     * <p>
     * This variable represents the <b>tree_cell_renderer</b> property name.
     * </p>
     */
    private static final String TREE_CELL_RENDERER = "tree_cell_renderer";

    /**
     * <p>
     * This variable represents the <b>config_manager_specification_factory_namespace</b> property name.
     * </p>
     */
    private static final String CONFIG_MANAGER_SPECIFICATION_FACTORY_NAMESPACE =
        "config_manager_specification_factory_namespace";

    /**
     * Configuration parameter storing information about tabs opened by default (for 1.1 implementation).
     *
     * @since 1.1
     */
    private static final String DEFAULT_TABS = "default_tabs";

    /**
     * Configuration parameter storing information about names for the tabs defined by DEFAULT_TABS parameter.
     *
     * @since 1.1
     */
    private static final String DEFAULT_TAB_NAMES = "default_tab_names";

    /**
     * <p>
     * This variable holds the configuration namespace.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is set by the constructor and passed by this
     * object to its child objects when they are created. It will never be null or empty.
     * </p>
     */
    private final String namespace;

    /**
     * <p>
     * This variable holds the model manager whose model is shown in the tree views.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is set by the constructor and retrieved by
     * getModelManager. It will never be null.
     * </p>
     */
    private final UMLModelManager modelManager;

    /**
     * <p>
     * This variable holds the tree cell renderer used to render the tree cells.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is set by the constructor and retrieved by
     * getTreeCellRenderer. It will never be null.
     * </p>
     */
    private final TreeCellRenderer treeCellRenderer;

    /**
     * <p>
     * This variable holds the tabbed pane which holds the different document panels.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is initialized to an empty tabbed pane and
     * retrieved by getTabbedPane method. It will never be null.
     * </p>
     */
    private final JTabbedPane tabbedPane;

    /**
     * <p>
     * This variable holds the mapping between a JPanel and the DoucmentTreePanel that contains it.
     * </p>
     *
     * <p>
     * It is frozen as its reference will not change after initialization. Neither keys nor values will be null.
     * </p>
     */
    private final Map<JPanel, DocumentTreePanel> treePanels = new HashMap<JPanel, DocumentTreePanel>();

    /**
     * <p>
     * This variable holds the listeners listening to document tree events.
     * </p>
     *
     * <p>
     * It is frozen as its reference will not change after initialization. It is initialized to an empty array list
     * and modified by the add and remove listener methods. It is also referenced by the getAllListeners method. It
     * will never contain null or duplicate elements.
     * </p>
     */
    private final List<DocumentTreeEventListener> listeners = new ArrayList<DocumentTreeEventListener>();

    /**
     * <p>
     * Constructs this object from the given model manager and configuration namespace. Can use both old (1.0) and
     * new (1.1) configuration models.
     * </p>
     *
     * @param modelManager
     *            The model manager. Must not be null
     * @param namespace
     *            The configuration namespace. Must not be null or empty.
     *
     * @throws IllegalArgumentException
     *             If any argument is null or namespace is empty string
     * @throws DocumentTreeConfigurationException
     *             if there is an error reading configuration properties or while using the object factory.
     */
    public DocumentTreeTabbedPaneImpl(UMLModelManager modelManager, String namespace) {
        Util.checkNull(modelManager, "modelManager");
        Util.checkString(namespace, "namespace");

        this.namespace = namespace;
        this.modelManager = modelManager;
        this.tabbedPane = new JTabbedPane();

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        ObjectFactory of = createObjectFactory(namespace, CONFIG_MANAGER_SPECIFICATION_FACTORY_NAMESPACE);
        String key = DocumentTreeViewHelper.getPropertyValue(namespace, TREE_CELL_RENDERER);
        this.treeCellRenderer = (TreeCellRenderer) createObject(of, key, TreeCellRenderer.class);

        initializePanel();
    }

    /**
     * Initializes the panels of the document tree.
     */
    public void initializePanel() {
        // check if new (1.1) configuration presented
        String[] tabViews = null;
        ConfigManager cm = ConfigManager.getInstance();
        try {
            tabViews = cm.getStringArray(namespace, DEFAULT_TABS);
        } catch (UnknownNamespaceException ex) {
            // in fact, this already checked above and will never occur
            throw new DocumentTreeConfigurationException("Unable to access namespace [" + namespace + "].", ex);
        }

        if (tabViews == null || tabViews.length == 0) {
            if (!DocumentTreePanelImpl.isConfigured(namespace)) {
                // if old style config omitted too, set tabs to default
                tabViews =
                    new String[] {DiagramCentricDocumentTreeView.class.getName(),
                        ClassCentricDocumentTreeView.class.getName()};
            } else {
                tabViews = null;
            }
        }

        if (tabViews != null) {
            // use new look (since 1.1)

            // retrieve desired tab names, if any
            String[] tabNames;
            try {
                tabNames = cm.getStringArray(namespace, DEFAULT_TAB_NAMES);
            } catch (UnknownNamespaceException ex) {
                // in fact, this already checked above and will never occur
                throw new DocumentTreeConfigurationException("Unable to access namespace [" + namespace + "].", ex);
            }
            if (tabNames != null && tabNames.length != tabViews.length) {
                throw new DocumentTreeConfigurationException(DEFAULT_TABS + " and " + DEFAULT_TAB_NAMES
                    + " parameters must have equal sizes (if both presented).");
            }

            // create tabs from configuration
            for (int i = 0; i < tabViews.length; ++i) {
                DocumentTreePanel treePanel = new SimpleDocumentTreePanel(this, namespace, tabViews[i]);

                JPanel panel = treePanel.getPanel();
                treePanels.put(panel, treePanel);
                String tabName =
                    (tabNames == null) ? treePanel.getCurrentView().getViewType().name() : tabNames[i];
                tabbedPane.addTab(tabName, panel);
                if (i == 0) {
                    setCurrentPanel(treePanel);
                }
            }
        } else {
            // create a new panel in old style, corresponding configuration must
            // be presented
            createNewPanel();
        }
    }

    /**
     * <p>
     * Returns the tabbed pane used by this object to depict a tabbed document tree.
     * </p>
     *
     * @return The tabbed pane used by this object to depict a tabbed document tree.
     */
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    /**
     * <p>
     * Returns the UML Model manager on which this document tree tabbed pane is based.
     * </p>
     *
     * @return The UML Model manager on which this document tree tabbed pane is based.
     */
    public UMLModelManager getModelManager() {
        return modelManager;
    }

    /**
     * <p>
     * Returns the tree cell renderer used to render individual tree cells.
     * </p>
     *
     * @return The tree cell renderer used to render individual tree cells.
     */
    public TreeCellRenderer getTreeCellRenderer() {
        return this.treeCellRenderer;
    }

    /**
     * <p>
     * Creates a panel in a new tab in this tabbed pane.
     * </p>
     *
     * <p>
     * Please note: currently this method only able to create panels for the old layout. Panel type added in
     * version 1.1 must be created through configuration.
     * </p>
     *
     * @return The document tree panel in newly created tab.
     *
     * @throws DocumentTreeConfigurationException
     *             If there is an error reading configuration properties or while using the object factory for the
     *             <code>DocumentTreePanelImpl</code>.
     */
    public DocumentTreePanel createNewPanel() {
        DocumentTreePanel treePanel = new DocumentTreePanelImpl(this, namespace);

        JPanel panel = treePanel.getPanel();
        this.treePanels.put(panel, treePanel);

        // add a new tab
        this.tabbedPane.addTab(treePanel.getCurrentView().getViewType().name(), panel);

        return treePanel;
    }

    /**
     * <p>
     * Gets the document tree panel currently active in this tabbed pane.
     * </p>
     *
     * <p>
     * This method will never return null value.
     * </p>
     *
     * @return The document tree panel currently visible in this tabbed pane.
     */
    public DocumentTreePanel getCurrentPanel() {
        return treePanels.get(tabbedPane.getSelectedComponent());
    }

    /**
     * <p>
     * Gets the document tree panels in this tabbed pane.
     * </p>
     *
     * <p>
     * This method will never return null value.
     * </p>
     *
     * @return The document tree panels in this tabbed pane.
     */
    public Collection<DocumentTreePanel> getPanels() {
        return treePanels.values();
    }

    /**
     * <p>
     * Sets the document tree panel currently active in this tabbed pane.
     * </p>
     *
     * @param panel
     *            The document tree panel that should be visible in this tabbed pane. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If the panel argument is null or is not a tab of this panel.
     */
    public void setCurrentPanel(DocumentTreePanel panel) {
        Util.checkNull(panel, "panel");

        // if the panel is not a tab, setSelectedComponent method will throw
        // IllegalArgumentException
        tabbedPane.setSelectedComponent(panel.getPanel());
    }

    /**
     * <p>
     * Removes the given document tree panel from this tabbed pane.
     * </p>
     *
     * @param panel
     *            The document tree panel that should be removed from this tabbed pane. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If the panel argument is null.
     */
    public void removePanel(DocumentTreePanel panel) {
        Util.checkNull(panel, "panel");

        if (tabbedPane.getTabCount() > 1) {
            tabbedPane.remove(panel.getPanel());
        }
    }

    /**
     * <p>
     * Adds the given listener to the listeners of this object listening to document tree events.
     * </p>
     *
     * @param listener
     *            The listener to add. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If the listener argument is null.
     */
    public void addDocumentTreeEventListener(DocumentTreeEventListener listener) {
        Util.checkNull(listener, "listener");

        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * <p>
     * Removes the given listener from the listeners of this object listening to document tree events.
     * </p>
     *
     * @param listener
     *            The listener to remove. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If the listener argument is null.
     */
    public void removeDocumentTreeEventListener(DocumentTreeEventListener listener) {
        Util.checkNull(listener, "listener");

        listeners.remove(listener);
    }

    /**
     * <p>
     * Gets all listeners of this object listening to document tree events.
     * </p>
     *
     * @return All listeners of this object listening to document tree events.
     */
    public DocumentTreeEventListener[] getAllDocumentTreeEventListeners() {
        return listeners.toArray(new DocumentTreeEventListener[listeners.size()]);
    }

    /**
     * <p>
     * Notifies all listeners of a selection changed event.
     * </p>
     *
     * @param event
     *            The selection changed event. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If event is null.
     */
    public void fireSelectionChangedEvent(SelectionChangedEvent event) {
        Util.checkNull(event, "event");

        // System.out.println(" DTTPI#fireSelectionChangedEvent");
        for (DocumentTreeEventListener listener : listeners) {
            // System.out.println(" " + listener);
            listener.treeNodeSelectionChanged(event);
        }
    }

    /**
     * <p>
     * Notifies all listeners of a name changed event.
     * </p>
     *
     * @param event
     *            The name changed event. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If event is null.
     */
    public void fireNameChangedEvent(NameChangedEvent event) {
        Util.checkNull(event, "event");

        for (DocumentTreeEventListener listener : listeners) {
            listener.treeNodeNameChanged(event);
        }
    }

    /**
     * <p>
     * Notifies all listeners of a view changed event.
     * </p>
     *
     * @param event
     *            The view changed event. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If event is null.
     */
    public void fireViewChangedEvent(ViewChangedEvent event) {
        Util.checkNull(event, "event");

        for (DocumentTreeEventListener listener : listeners) {
            listener.treeViewChanged(event);
        }
    }

    /**
     * <p>
     * Adds the given node to all the trees of this object.
     * </p>
     *
     * @param treeNode
     *            The node to add. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If treeNode is null.
     */
    public void addTreeNode(DocumentTreeNode treeNode) {
        Util.checkNull(treeNode, "treeNode");

        for (DocumentTreePanel treePanel : treePanels.values()) {
            for (DocumentTreeView view : treePanel.getAllViews()) {
                view.addTreeNode(treeNode);
            }
        }
    }

    /**
     * <p>
     * Updates the given node in all the trees of this object.
     * </p>
     *
     * @param treeNode
     *            The node to update. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If treeNode is null.
     */
    public void updateTreeNode(DocumentTreeNode treeNode) {
        Util.checkNull(treeNode, "treeNode");

        for (DocumentTreePanel treePanel : treePanels.values()) {
            for (DocumentTreeView view : treePanel.getAllViews()) {
                view.updateTreeNode(treeNode);
            }
        }
    }

    /**
     * <p>
     * Removes the given node from all the trees of this object.
     * </p>
     *
     * @param treeNode
     *            The node to removed. Must not be null.
     *
     * @throws IllegalArgumentException
     *             If treeNode is null.
     */
    public void removeTreeNode(DocumentTreeNode treeNode) {
        Util.checkNull(treeNode, "treeNode");

        for (DocumentTreePanel treePanel : treePanels.values()) {
            for (DocumentTreeView view : treePanel.getAllViews()) {
                view.removeTreeNode(treeNode);
            }
        }
    }

    /**
     * <p>
     * Updates the entire tree for all trees of this object by reconstructing it from the UML model.
     * </p>
     */
    public void updateTree() {
        for (DocumentTreePanel treePanel : treePanels.values()) {
            for (DocumentTreeView view : treePanel.getAllViews()) {
                view.updateTree();
            }
        }
    }

    /**
     * <p>
     * Gets the nodes currently selected in the tree view of the current tab.
     * </p>
     *
     * @return The array of nodes currently selected. Will not be null, possibly empty.
     */
    public DocumentTreeNode[] getSelectedTreeNodes() {
        return getCurrentPanel().getCurrentView().getSelectedTreeNodes();
    }

    /**
     * <p>
     * Sets the nodes currently selected in the tree view of the current tab.
     * </P>
     *
     * @param selectedTreeNodes
     *            The nodes to be selected. Must not be null or contain null elements.
     *
     * @throws IllegalArgumentException
     *             If the array of nodes is null or contains null elements.
     */
    public void setSelectedTreeNodes(DocumentTreeNode[] selectedTreeNodes) {
        Util.checkArray(selectedTreeNodes, "selectedTreeNodes");

        getCurrentPanel().getCurrentView().setSelectedTreeNodes(selectedTreeNodes);
    }

    /**
     * <p>
     * Returns the tree view type of the tree view currently visible.
     * </p>
     *
     * @return The tree view type of the tree view visible currently .
     */
    public DocumentTreeViewType getCurrentViewType() {
        return getCurrentPanel().getCurrentView().getViewType();
    }

    /**
     * <p>
     * Sets the tree view visible in the panel of the current tab.
     * </p>
     *
     * @param viewType
     *            The tree view type which should be made visible in the panel of the current tab.
     *
     * @throws IllegalArgumentException
     *             if viewType is null or it is not configured in this tree panel
     * @throws UnsupportedOperationException
     *             if underlying panel implementation not supposed to change view type
     */
    public void setCurrentViewType(DocumentTreeViewType viewType) {
        getCurrentPanel().setCurrentView(viewType);
    }

    /**
     * <p>
     * Create an ObjectFactory instance.
     * </p>
     *
     * <p>
     * The namespace for the object factory is got from the given namespace under the given key.
     * </p>
     *
     * @param namespace
     *            the namespace to get the configuration value
     * @param key
     *            the object factory namespace property name
     * @return the ObjectFactory instance
     *
     * @throws DocumentTreeConfigurationException
     *             if the object factory namespace property is missing or fail to create the ObjectFactory instance
     */
    private ObjectFactory createObjectFactory(String namespace, String key) {
        String ofNamespace = DocumentTreeViewHelper.getPropertyValue(namespace, key);

        try {
            return new ObjectFactory(new ConfigManagerSpecificationFactory(ofNamespace));
        } catch (SpecificationConfigurationException e) {
            throw new DocumentTreeConfigurationException("SpecificationConfigurationException occurs "
                + "while creating ObjectFactory instance using namespace " + ofNamespace, e);
        } catch (IllegalReferenceException e) {
            throw new DocumentTreeConfigurationException("IllegalReferenceException occurs "
                + "while creating ObjectFactory instance using namespace " + ofNamespace, e);
        }
    }

    /**
     * <p>
     * Create an object from the given object factory and the key.
     * </p>
     *
     * <p>
     * The type of the object to create is given as well, it is for validation purpose.
     * </p>
     *
     * @param of
     *            the object factory instance to create object
     * @param key
     *            the key of the object to create in the configuration file
     * @param type
     *            the class type of the object to create, it is for validation purpose
     * @return the object created from the given object factory and the key
     *
     * @throws DocumentTreeConfigurationException
     *             if fail to create the object or the created object is an instance of the given type
     */
    private Object createObject(ObjectFactory of, String key, java.lang.Class type) {
        try {
            Object value = of.createObject(key);

            // verify the class type of the created object
            if (!type.isInstance(value)) {
                throw new DocumentTreeConfigurationException("The configured object for key [" + key
                    + "] is an instance of " + type.getName());
            }

            return value;
        } catch (InvalidClassSpecificationException e) {
            throw new DocumentTreeConfigurationException(
                "InvalidClassSpecificationException occurs while creating object with key [" + key
                    + "] using object factory.", e);
        }
    }
}
