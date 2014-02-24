/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.Util;
import com.topcoder.gui.trees.document.ViewChangedEvent;
import com.topcoder.util.config.Property;

/**
 * <p>
 * This class is a direct implementation of the DocumentTreePanel interface.
 * </p>
 *
 * <p>
 * It uses DocuentTreeView to accomplish the actual tree view and provides a combo-box to switch views. It also
 * provides buttons to create a new tab in the parent document as also close this tab.
 * </p>
 *
 * <p>
 * Sample configuration:
 *
 * <pre>
 * &lt;Property name=&quot;view_types&quot;&gt;
 *     &lt;Property name=&quot;DIAGRAM_CENTRIC&quot;&gt;
 *         &lt;Property name=&quot;view_class&quot;&gt;
 *             &lt;Value&gt;com.topcoder.gui.trees.document.impl.DiagramCentricDocumentTreeView&lt;/Value&gt;
 *         &lt;/Property&gt;
 *         &lt;Property name=&quot;view_text&quot;&gt;
 *             &lt;Value&gt;Diagram-Centric&lt;/Value&gt;
 *         &lt;/Property&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name=&quot;CLASS_CENTRIC&quot;&gt;
 *         &lt;Property name=&quot;view_class&quot;&gt;
 *             &lt;Value&gt;com.topcoder.gui.trees.document.impl.ClassCentricDocumentTreeView&lt;/Value&gt;
 *         &lt;/Property&gt;
 *         &lt;Property name=&quot;view_text&quot;&gt;
 *             &lt;Value&gt;Class-Centric&lt;/Value&gt;
 *         &lt;/Property&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name=&quot;PACKAGE_CENTRIC&quot;&gt;
 *         &lt;Property name=&quot;view_class&quot;&gt;
 *             &lt;Value&gt;com.topcoder.gui.trees.document.impl.PackageCentricDocumentTreeView&lt;/Value&gt;
 *         &lt;/Property&gt;
 *         &lt;Property name=&quot;view_text&quot;&gt;
 *             &lt;Value&gt;Package-Centric&lt;/Value&gt;
 *         &lt;/Property&gt;
 *     &lt;/Property&gt;
 * &lt;/Property&gt;
 * </pre>
 *
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as it is mutable.
 * </p>
 *
 * @author humblefool, biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class DocumentTreePanelImpl implements DocumentTreePanel {
    /**
     * <p>
     * Represents the <b>view_text</b> property name.
     * </p>
     */
    private static final String VIEW_TEXT = "view_text";

    /**
     * <p>
     * Represents the <b>view_class</b> property name.
     * </p>
     */
    private static final String VIEW_CLASS = "view_class";

    /**
     * <p>
     * Represents the <b>view_types</b> property name.
     * </p>
     */
    private static final String VIEW_TYPES = "view_types";

    /**
     * <p>
     * Represents the string value of <b>Types</b> used in this component.
     * </p>
     */
    private static final String COMBO_BOX_NAME = "Types";

    /**
     * <p>
     * Represents the string value of <b>Add</b> used in this component.
     * </p>
     */
    private static final String ADD_BTN_NAME = "Add";

    /**
     * <p>
     * Represents the string value of <b>Close</b> used in this component.
     * </p>
     */
    private static final String CLOSE_BTN_NAME = "Close";

    /**
     * <p>
     * This variable stores all possible tree views in this object's panel, indexed by view type.
     * </p>
     *
     * <p>
     * This variable is frozen as the map will not change after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and referred to by the getCurrentView, setCurrentView and getAllViews methods.
     * </p>
     *
     * <p>
     * Both keys and values will never be null.
     * </p>
     */
    private final Map<DocumentTreeViewType, DocumentTreeView> treeViews;

    /**
     * <p>
     * This variable stores all possible tree view types in this object's panel, indexed by their name in the
     * combo-box.
     * </p>
     *
     * <p>
     * This variable is frozen as the map will not change after initialization. It is set by the constructor and
     * referred to by the anonymous inner class which listens to combo-box selection events.
     * </p>
     *
     * <p>
     * Both keys and values will never be null. Keys will also never be empty.
     * </p>
     */
    private final Map<String, DocumentTreeViewType> viewTypeNames;

    /**
     * <p>
     * This variable stores the view type of the current tree view in this object's panel.
     * </p>
     *
     * <p>
     * This variable is mutable as the current view can change, via the setCurrentView method. It is referenced by
     * the getCurrentView method. It is initialized by the constructor.
     * </p>
     */
    private DocumentTreeViewType currentViewType;

    /**
     * <p>
     * This variable represents the parent document tree tabbed pane of this tree view.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is set by the constructor and got by the
     * getParent method. It will never be null.
     * </p>
     */
    private final DocumentTreeTabbedPane parent;

    /**
     * <p>
     * This variable represents the panel used by this object to display the tree and other controls.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization. It is got by the getPanel method.
     * </p>
     */
    private final JPanel panel;

    /**
     * <p>
     * This variable represents the scroll pane used by this object to display the tree. *
     * </p>
     * <p>
     * It is frozen as it will not change after initialization.
     * </p>
     */
    private final JScrollPane treePane;

    /**
     * <p>
     * Constructs this object from the given parent and configuration namespace.
     * </p>
     *
     * @param parent
     *            The parent tabbed pane. Must not be null.
     * @param namespace
     *            The configuration namespace. Must not be null or empty.
     *
     * @throws IllegalArgumentException
     *             If any argument is null or namespace is empty.
     * @throws DocumentTreeConfigurationException
     *             If there is an error reading configuration properties or while using the object factory.
     */
    public DocumentTreePanelImpl(DocumentTreeTabbedPane parent, String namespace) {
        Util.checkNull(parent, "parent");
        Util.checkString(namespace, "namespace");

        this.parent = parent;

        this.treeViews = new EnumMap<DocumentTreeViewType, DocumentTreeView>(DocumentTreeViewType.class);
        this.viewTypeNames = new HashMap<String, DocumentTreeViewType>();
        loadConfiguration(namespace);

        this.currentViewType = DocumentTreeViewType.DIAGRAM_CENTRIC;
        DocumentTreeView currentView = treeViews.get(DocumentTreeViewType.DIAGRAM_CENTRIC);
        if (currentView == null) {
            throw new DocumentTreeConfigurationException("The DIAGRAM_CENTRIC view type is not configured.");
        }

        DocumentTreeButtonsListener listener = new DocumentTreeButtonsListener();

        this.panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // the combo box to select different view types
        JComboBox comboBox = new JComboBox();

        for (Entry<String, DocumentTreeViewType> entry : viewTypeNames.entrySet()) {
            String text = entry.getKey();
            comboBox.addItem(text);

            // set the current item of the combo box to the current view type
            if (currentViewType.equals(entry.getValue())) {
                comboBox.setSelectedItem(text);
            }
        }

        northPanel.add(comboBox);

        // install the listeners
        comboBox.addActionListener(listener);

        comboBox.setName(COMBO_BOX_NAME);
        comboBox.setActionCommand(COMBO_BOX_NAME);

        // the add button to add a new tab page
        JButton addBtn = new JButton(ADD_BTN_NAME);
        addBtn.addActionListener(listener);
        addBtn.setName(ADD_BTN_NAME);
        addBtn.setActionCommand(ADD_BTN_NAME);
        northPanel.add(addBtn);

        // the close button to close a tab page
        JButton closeBtn = new JButton(CLOSE_BTN_NAME);
        closeBtn.addActionListener(listener);
        closeBtn.setName(CLOSE_BTN_NAME);
        closeBtn.setActionCommand(CLOSE_BTN_NAME);
        northPanel.add(closeBtn);

        panel.add(northPanel, BorderLayout.NORTH);
        treePane = new JScrollPane(currentView.getTree());
        treePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        treePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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
     * Returns the panel that contains the current tree view and other controls for switching the tree view.
     * </p>
     *
     * @return The panel that contains the current tree view and other controls for switching the tree view.
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * <p>
     * Returns the tree view visible currently in the panel.
     * </p>
     *
     * @return The tree view visible currently in the panel.
     */
    public DocumentTreeView getCurrentView() {
        return treeViews.get(this.currentViewType);
    }

    /**
     * <p>
     * Sets the tree view visible in the panel.
     * </p>
     *
     * @param viewType
     *            The tree view type which should be made visible in the panel.
     *
     * @throws IllegalArgumentException
     *             if viewType is null or it is not configured in this tree panel
     */
    public void setCurrentView(DocumentTreeViewType viewType) {
        Util.checkNull(viewType, "viewType");
        DocumentTreeView view = treeViews.get(viewType);
        if (view == null) {
            throw new IllegalArgumentException("The view type is not configured for this tree panel.");
        }

        // we only make modification when the new and old view types are not equal
        if (!currentViewType.equals(viewType)) {
            DocumentTreeView currentView = treeViews.get(currentViewType);
            treePane.setViewportView(view.getTree());

            this.parent.getTabbedPane().setTitleAt(this.parent.getTabbedPane().indexOfComponent(panel),
                viewType.name());

            currentViewType = viewType;

            this.parent.getTabbedPane().repaint();

            this.parent.fireViewChangedEvent(new ViewChangedEvent(currentView, view));
        }
    }

    /**
     * <p>
     * Returns all tree views possible in this panel.
     * </p>
     *
     * @return All tree views possible in this panel. Will not be null, possibly empty.
     */
    public DocumentTreeView[] getAllViews() {
        return treeViews.values().toArray(new DocumentTreeView[treeViews.size()]);
    }

    /**
     * <p>
     * This anonymous inner class is used to listen to button clicks as well as combo box selections.
     * </p>
     *
     * <p>
     * An instance of this class will be added to the listeners of the two buttons to open a new tab and close the
     * current tab as well as the combo-box of the parent class.
     * </p>
     *
     * <p>
     * Thread Safety: This class is thread safe as it has no state.
     * </p>
     */
    private class DocumentTreeButtonsListener implements ActionListener {
        /**
         * <p>
         * This method is called to indicate that a button has been clicked or a selection has been made in the
         * combo-box.
         * </p>
         *
         * @param e
         *            The ActionEvent representing the action. Must not be null.
         *
         * @throws IllegalArgumentException
         *             If e is null.
         */
        public void actionPerformed(ActionEvent e) {
            Util.checkNull(e, "action event");

            String action = e.getActionCommand();
            if (COMBO_BOX_NAME.equals(action)) {
                JComboBox comboBox = (JComboBox) e.getSource();
                DocumentTreeViewType type = viewTypeNames.get((String) comboBox.getSelectedItem());
                setCurrentView(type);
            } else if (ADD_BTN_NAME.equals(action)) {
                getParent().createNewPanel();
            } else if (CLOSE_BTN_NAME.equals(action)) {
                getParent().removePanel(DocumentTreePanelImpl.this);
            }
        }
    }

    /**
     * <p>
     * Loads the properties from the XML file with the given namespace specified.
     * </p>
     *
     * @param namespace
     *            the namespace containing configuration properties.
     *
     * @throws DocumentTreeConfigurationException
     *             if the view_types property is missing or the namespace is unknown.
     */
    private void loadConfiguration(String namespace) {
        Property viewTypesProperty = DocumentTreeViewHelper.getRequiredProperty(namespace, VIEW_TYPES);

        for (Object obj : viewTypesProperty.list()) {
            Property prop = (Property) obj;

            String name = prop.getName();

            DocumentTreeViewType type;

            // check the value for type
            try {
                type = DocumentTreeViewType.valueOf(name);
            } catch (IllegalArgumentException e) {
                throw new DocumentTreeConfigurationException("The configured document tree view type [" + name
                    + "] is unknown.", e);
            }

            String viewClass = prop.getValue(VIEW_CLASS);
            if (viewClass == null || viewClass.trim().length() == 0) {
                throw new DocumentTreeConfigurationException("The view_class property value is null or empty.");
            }

            // create a document tree view with the given value from the file
            DocumentTreeView view = Util.createTreeView(viewClass, this, namespace);

            String value = prop.getValue(VIEW_TEXT);
            if (value == null || value.trim().length() == 0) {
                throw new DocumentTreeConfigurationException("The view_text property value is null or empty.");
            }

            this.treeViews.put(type, view);
            this.viewTypeNames.put(value, type);
        }
    }

    /**
     * <p>
     * This method checks if instance of this class can be created with specified config namespace. Please note,
     * method just check presented configuration root (view_types) or not, 'true' result doesn't guarantee what
     * class have been configured properly.
     * </p>
     *
     * @param namespace
     *            namespace to look for config, can't be null
     * @return true if configuration root for this class have been found, false otherwise
     * @since 1.1
     */
    static boolean isConfigured(String namespace) {
        try {
            DocumentTreeViewHelper.getRequiredProperty(namespace, VIEW_TYPES);
            return true;
        } catch (DocumentTreeConfigurationException ex) {
            return false;
        }
    }
}
