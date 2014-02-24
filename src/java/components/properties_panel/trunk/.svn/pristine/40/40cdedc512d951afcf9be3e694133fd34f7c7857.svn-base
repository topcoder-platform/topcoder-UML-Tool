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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.modelmanager.UMLModelManager;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboPopup;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;

/**
 * <p>
 * This class provides a GUI for <code>Owner</code> property panel.
 * </p>
 *
 * <p>
 * The GUI is a JPanel containing a <code>JLabel</code> <b>Owner</b>, a <code>JComboBox</code> containing
 * all the possible owners in the model, and a <code>JButton</code> that links to the properties of the
 * selected owner.
 * </p>
 *
 * <p>
 * This class also provides the logic to update the owner of each registered <code>ModelElement</code> when
 * user modifies the panel's property value.
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
public class OwnerPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JComboBox</code> to display the list of owner.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will never change afterwards. Will not be null.
     * </p>
     */
    private final JComboBox comboOwner;

    /**
     * <p>
     * The <code>JButton</code> to provide a link to the selected owner.
     * </p>
     *
     * <p>
     * Created in the constructor and will never be changed afterwards. Will not be null.
     * </p>
     */
    private final JButton buttonLink;

    /**
     * <p>
     * Creates a new <code>OwnerPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @param icon the icon for link button
     * @throws IllegalArgumentException if either argument is null
     */
    public OwnerPropertyPanel(PropertiesPanel propertiesPanel, Icon icon) {
        super(Collections.singletonList(PropertyKind.OWNER), propertiesPanel);

        Util.checkNull(icon, "icon");

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 280, 24);

        panel.setLayout(new GridBagLayout());

        addTextLableWithColon(panel, "Owner", 75, 40, 20);

        comboOwner = new JComboBox();

        comboOwner.setPrototypeDisplayValue(new String("       "));

        // add an ActionListener to the combo box
        comboOwner.addActionListener(new ActionListener() {
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

        buttonLink.setToolTipText("Go to Selected Owner");

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
                NamespaceItem item = (NamespaceItem) comboOwner.getSelectedItem();

                // no selection, return directly
                if (item == null) {
                    return;
                }

                // configure the properties panel with the namespace
                Namespace namespace = item.getNamespace();
                getPropertiesPanel().configurePanel(namespace);
                getPropertiesPanel().fireSelectionChangeEvent(namespace);
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.NONE;
        Util.setFixedSize(comboOwner, 168, 20);
        panel.add(comboOwner, constraints);

        constraints.gridx = 3;
        constraints.insets = new Insets(2, 6, 2, 2);
        Util.setFixedSize(buttonLink, 26, 20);
        panel.add(buttonLink, constraints);

    }

    /**
     * <p>
     * Executes the logic to update the <code>ModelElement</code> when the owner property value changes.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            NamespaceItem item = (NamespaceItem) comboOwner.getSelectedItem();

            // no selection, return directly
            if (item == null) {
                return;
            }

            // notify all the listeners about the change
            Classifier newOwner = (Classifier) item.getNamespace();
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.OWNER, PropertyOperation.MODIFY,
                    newOwner);
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
     * If all the <code>ModelElement</code> has the same owner, the JComboBox will show the owner,
     * otherwise it displays nothing.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<Classifier> classifiers = new HashSet<Classifier>();
        for (ModelElement element : getConfiguredModelElements()) {
            classifiers.add(((Operation) element).getOwner());
        }

        Classifier classifier = null;
        if (classifiers.size() == 1) {
            classifier = classifiers.iterator().next();
        }

        comboOwner.removeAllItems();

        // add all the possible owners
        UMLModelManager manager = getPropertiesPanel().getUMLModelManager();
        for (ModelElement element : manager.getModel().getOwnedElements()) {
            if (element instanceof Namespace) {
                if (element instanceof Class || element instanceof Interface) {
                    NamespaceItem item = new NamespaceItem((Namespace) element);
                    comboOwner.addItem(item);
                    if (classifier != null && classifier.equals(element)) {
                        comboOwner.setSelectedItem(item);
                    }
                } else {
                    addOwnerItem((Namespace) element, classifier);
                }
            }
        }

        updatePopupSize();
    }

    /**
     * <p>
     * Adds all the <code>Classifier</code> instances under the given <code>Namespace</code>
     * as items to the owner combo box.
     * </p>
     *
     * <p>
     * If any <code>Classifier</code> instance under the given <code>Namespace</code> equals to
     * the given <code>classifier</code>, then the item will be selected.
     * </p>
     *
     * @param namespace the <code>Namespace</code> to get all the owning <code>Classifier</code> instances
     * @param classifier the current <code>Classifier</code> instance
     */
    private void addOwnerItem(Namespace namespace, Classifier classifier) {
        for (ModelElement modelElement : namespace.getOwnedElements()) {
            if (modelElement instanceof Class || modelElement instanceof Interface) {
                NamespaceItem item = new NamespaceItem((Classifier) modelElement);
                comboOwner.addItem(item);

                // check whether the newly added item is the current classifier
                if (classifier != null && classifier.equals(modelElement)) {
                    comboOwner.setSelectedItem(item);
                }
            } else if (modelElement instanceof Namespace) {
                addOwnerItem((Namespace) modelElement, classifier);
            }
        }
    }

    /**
     * <p>
     * Updates the popup size.
     * </p>
     */
    private void updatePopupSize() {
        FontMetrics fm = comboOwner.getFontMetrics(comboOwner.getFont());
        int size = 0;
        for (int i = 0; i < comboOwner.getItemCount(); i++) {
            String sds = (String) comboOwner.getItemAt(i).toString();
            if ((sds != null) && (size < fm.stringWidth(sds))) {
                size = fm.stringWidth(sds);
            }
        }
        int width = comboOwner.getSize().width;
        if (size < width) {
            size = width - 5;
        }
        BasicComboPopup popup = (BasicComboPopup) comboOwner.getUI().getAccessibleChild(retrievePanel(), 0);
        popup.setPreferredSize(new Dimension(size + 5, popup.getPreferredSize().height));
        Component scrollpane = popup.getComponent(0);
        popup.setLayout(new BorderLayout());
        popup.add(scrollpane, BorderLayout.CENTER);
    }
}
