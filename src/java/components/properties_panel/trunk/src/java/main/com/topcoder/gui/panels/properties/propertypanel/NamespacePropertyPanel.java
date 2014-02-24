/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboPopup;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * This class provides a property panel GUI for the namespace property of <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> consisting of a <code>JLabel</code> <b>Namespace</b>, a
 * <code>JComboBox</code> containing all the available namespaces in the model and a button
 * that provides a link to the namespace properties.
 * </p>
 *
 * <p>
 * This class also provides a logic to update the namespace property of <code>ModelElement</code> when
 * user modifies the value in the panel.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 * <p>
 * V1.1 Change Note: the new layout is used as the prototype.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class NamespacePropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JComboBox</code> containing all the namespace in the model.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards. Will not be null.
     * </p>
     */
    private final JComboBox comboNamespace;

    /**
     * <p>
     * The <code>JButton</code> providing a link to the selected namespace.
     * </p>
     *
     * <p>
     * Created in the constructor and its reference will not be modified afterwards. Will not be null.
     * </p>
     */
    private final JButton buttonLink;

    private final Set<String> namespaceSet=new HashSet<String>();

    /**
     * <p>
     * Creates a new <code>NamespacePropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @param icon the icon for the link button
     *
     * @throws IllegalArgumentException if either argument is null
     */
    public NamespacePropertyPanel(PropertiesPanel propertiesPanel, Icon icon) {
        super(Collections.singletonList(PropertyKind.NAMESPACE), propertiesPanel);

        Util.checkNull(icon, "icon");

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 280, 24);
        panel.setLayout(new GridBagLayout());

        addTextLableWithColon(panel, "Namespace", 75, 70, 20);

        comboNamespace = new JComboBox();

        comboNamespace.setPrototypeDisplayValue(new String("       "));

        // add an ActionListener to the combo box
        comboNamespace.addActionListener(new ActionListener() {
            /**
             * <p>
             * Invoked when an action occurs.
             * </p>
             *
             * <p>
             * When the current item of the combo box is changed, then this method will be invoked.
             * </p>
             *
             * @param event a semantic event which indicates that a component-defined action occurred.
             */
            public void actionPerformed(ActionEvent e) {
                execute();
            }
        });

        buttonLink = new JButton(icon);

        buttonLink.setToolTipText("Go to Selected Namespace");

        // add an ActionListener to the button
        buttonLink.addActionListener(new ActionListener() {
            /**
             * <p>
             * Invoked when an action occurs.
             * </p>
             *
             * <p>
             * When the button is clicked, then this method will be invoked.
             * </p>
             *
             * @param event a semantic event which indicates that a component-defined action occurred.
             */
            public void actionPerformed(ActionEvent e) {
                Object item = comboNamespace.getSelectedItem();

                // The empty string item is selected, return directly
                if (!(item instanceof NamespaceItem)) {
                    return;
                }

                // configure the properties panel with the namespace
                Namespace namespace = ((NamespaceItem) item).getNamespace();
                getPropertiesPanel().configurePanel(namespace);
                getPropertiesPanel().fireSelectionChangeEvent(namespace);
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        Util.setFixedSize(comboNamespace, 168, 20);
        panel.add(comboNamespace, constraints);

        constraints.gridx = 3;
        constraints.insets = new Insets(2, 6, 2, 2);
        Util.setFixedSize(buttonLink, 26, 20);
        constraints.weightx = 0;
        constraints.fill = GridBagConstraints.NONE;
        panel.add(buttonLink, constraints);
    }

    /**
     * <p>
     * Executes the logic to update the namespace of all the active <code>ModelElement</code> when the namespace
     * value is modified in the panel.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            Object item = comboNamespace.getSelectedItem();

            // The empty item is selected, does nothing
            if (!(item instanceof NamespaceItem)) {
                return;
            }

            // notify all the listeners about the change
            Namespace newNS = ((NamespaceItem) item).getNamespace();
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.NAMESPACE, PropertyOperation.MODIFY,
                    newNS);
            }
        }
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * If all the ModelElement has the same namespace, the <code>JComboBox</code> will show this namespace,
     * otherwise, it will display nothing.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }
         namespaceSet.clear();
        Set<Namespace> namespaces = new HashSet<Namespace>();
        for (ModelElement element : getConfiguredModelElements()) {
            namespaces.add(element.getNamespace());
        }

        Namespace curNamespace = null;
        if (namespaces.size() == 1) {
            curNamespace = namespaces.iterator().next();
        }

        comboNamespace.removeAllItems();

        // An empty item will be added when all the model elements don't have a same namespace or the
        // namespace is null
        if (curNamespace == null) {
            comboNamespace.addItem("");
            comboNamespace.setSelectedIndex(0);
        }

        // All the namespaces got form the model
        UMLModelManager manager = getPropertiesPanel().getUMLModelManager();

        NamespaceItem item = new NamespaceItem(manager.getModel());
        comboNamespace.addItem(item);
        if (curNamespace != null) {
            if (curNamespace.equals(manager.getModel())) {
                comboNamespace.setSelectedItem(item);
            }
        }

        for (ModelElement element : manager.getModel().getOwnedElements()) {

            if (element instanceof Package
                    && !getPropertiesPanel().getConfiguredModelElements().contains(element)) {
                addNamespace(curNamespace, (Namespace) element);

            }
        }

        //BUGR-150 add standard namespaces
        /*
        ProjectConfigurationManager configManager = manager.getProjectConfigurationManager();
        String language = manager.getProjectLanguage();
        if (language != null && language.trim().length() != 0) {
            for (Namespace element : configManager.getStandardNamespaces(language)) {
                if (element instanceof Package
                        && !getPropertiesPanel().getConfiguredModelElements().contains(element)) {

                    if(element.getNamespace()==null){
                        element.setNamespace(manager.getModel());
                        manager.getModel().addOwnedElement(element);
                    }
                    addNamespace(curNamespace, (Namespace) element);
                }
            }
        }
        */

        updatePopupSize();
    }

    /**
     * <p>
     * Adds the namespaces got from the given namespace to the combobox.
     * </p>
     * @param curNamespace
     *            the current namespace
     * @param namespace
     *            the namespace
     */
    private void addNamespace(Namespace curNamespace, Namespace namespace) {
        NamespaceItem item;
        item = new NamespaceItem((Namespace) namespace);
        /*
        if(!namespaceSet.contains(item.toString())){
            namespaceSet.add(item.toString());
            comboNamespace.addItem(item);
        }
        */
        comboNamespace.addItem(item);

        if (curNamespace != null) {
            if (curNamespace.equals(namespace)) {
                comboNamespace.setSelectedItem(item);
            }
        }
        for (ModelElement element : namespace.getOwnedElements()) {
            if (element instanceof Package
                    && !getPropertiesPanel().getConfiguredModelElements().contains(element)) {
                addNamespace(curNamespace, (Namespace) element);
            }
        }
    }

    /**
     * <p>
     * Updates the popup size.
     * </p>
     */
    private void updatePopupSize() {
        FontMetrics fm = comboNamespace.getFontMetrics(comboNamespace.getFont());
        int size = 0;
        for (int i = 0; i < comboNamespace.getItemCount(); i++) {
            String sds = (String) comboNamespace.getItemAt(i).toString();
            if ((sds != null) && (size < fm.stringWidth(sds))) {
                size = fm.stringWidth(sds);
            }
        }
        int width = comboNamespace.getSize().width;
        if (size < width) {
            size = width - 5;
        }
        BasicComboPopup popup = (BasicComboPopup) comboNamespace.getUI().getAccessibleChild(retrievePanel(), 0);
        popup.setPreferredSize(new Dimension(size + 5, popup.getPreferredSize().height));
        Component scrollpane = popup.getComponent(0);
        popup.setLayout(new BorderLayout());
        popup.add(scrollpane, BorderLayout.CENTER);
    }
}
