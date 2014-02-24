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

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboPopup;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;

/**
 * <p>
 * This class provides a GUI for type property panel.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> containing a label <b>Type</b>, a <code>JComboBox</code> with
 * the list of types and a button that links to the selected type.
 * </p>
 *
 * <p>
 * This class provides the logic to update the type of ModelElement when user modifies the panel's property value.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its superclass is not thread-safe.
 * </p>
 * <p>
 * V1.1 Change Note: the new layout is used as the prototype.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class TypePropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JComboBox</code> containing all the type contained in the <code>Model</code>.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JComboBox comboType;

    /**
     * <p>
     * The <code>JButton</code> to provide a link to the selected type.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JButton buttonLink;

    /**
     * <p>The valid classifier types.
     * </p>
     */
    private Set<String> modelClassifiers = new HashSet<String>();

    /**
     * <p>
     * Creates a new <code>TypePropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the owner of this panel
     * @param icon the icon for the link button
     *
     * @throws IllegalArgumentException if argument is null
     */
    public TypePropertyPanel(PropertiesPanel propertiesPanel, Icon icon) {
        super(Collections.singletonList(PropertyKind.TYPE), propertiesPanel);

        Util.checkNull(icon, "icon");

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 280, 24);

        panel.setLayout(new GridBagLayout());

        addTextLableWithColon(panel, "Type", 75, 40, 20);

        comboType = new JComboBox();

        comboType.setPrototypeDisplayValue(new String("       "));

        comboType.setEditable(true);
        // add an ActionListener to the combo box
        comboType.addActionListener(new ActionListener() {
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
        buttonLink.setToolTipText("Go to Selected Type");
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
                NamespaceItem item = (NamespaceItem) comboType.getSelectedItem();

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
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        Util.setFixedSize(comboType, 168, 20);
        panel.add(comboType, constraints);

        constraints.gridx = 3;
        constraints.weightx = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(2, 6, 2, 2);
        Util.setFixedSize(buttonLink, 26, 20);
        panel.add(buttonLink, constraints);

    }

    /**
     * <p>
     * Executes the logic to update the ModelElement when the type property value is modified.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            NamespaceItem item = null;
            java.lang.Object object = comboType.getSelectedItem();
            if (object instanceof NamespaceItem) {
                item = (NamespaceItem) object;
            } else {
                String str = (String) object;
                for (int i = 0; i < comboType.getItemCount(); ++i) {
                    NamespaceItem it = (NamespaceItem) comboType.getItemAt(i);
                    if (it.toString().equals(str) || it.getNamespace().getName().equals(str)) {
                        item = it;
                        comboType.setSelectedIndex(i);
                        break;
                    }
                }
                if ((item == null) && (str != null && !str.trim().equals(""))) {
                    Namespace namespace = createNewType(str);
                    item = new NamespaceItem(namespace);
                    comboType.addItem(item);
                    modelClassifiers.add(namespace.getName());
                    comboType.setSelectedItem(item);
                }
            }

            // no selection, return directly
            if (item == null) {
                return;
            }

            // notify all the listeners about the change
            Classifier newType = (Classifier) item.getNamespace();
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.TYPE, PropertyOperation.MODIFY,
                    newType);
            }
        }
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<Classifier> classifiers = new HashSet<Classifier>();
        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Attribute) {
                classifiers.add(((Attribute) element).getType());
            } else if (element instanceof Parameter) {
                classifiers.add(((Parameter) element).getType());
            } else if (element instanceof AssociationEnd) {
                classifiers.add(((AssociationEnd) element).getParticipant());
            } else {
                classifiers.add(((Object) element).getClassifier());
            }
        }

        Classifier classifier = null;
        if (classifiers.size() == 1) {
            classifier = classifiers.iterator().next();
        }

        comboType.removeAllItems();
        modelClassifiers.clear();

        // add all the possible types
        UMLModelManager manager = getPropertiesPanel().getUMLModelManager();
        for (ModelElement element : manager.getModel().getOwnedElements()) {
            if (element instanceof Namespace) {
                if (element instanceof Classifier && !(element instanceof UseCase)) {
                    NamespaceItem item = new NamespaceItem((Namespace) element);
                    comboType.addItem(item);
                    modelClassifiers.add(element.getName());

                    if (classifier != null && classifier.getName().equals(element.getName())) {
                        comboType.setSelectedItem(item);
                    }
                } else {
                    addTypeItem((Namespace) element, classifier);
                }
            }
        }

        ProjectConfigurationManager configManager = manager.getProjectConfigurationManager();
        String language = manager.getProjectLanguage();
        if (language != null && language.trim().length() != 0) {
            for (Namespace namespace : configManager.getStandardNamespaces(language)) {
                if ((namespace instanceof Classifier) && (!modelClassifiers.contains(namespace.getName()))) {
                    NamespaceItem item = new NamespaceItem((Classifier) namespace);
                    comboType.addItem(item);

                    if (classifier != null && classifier.getName().equals(namespace.getName())) {
                        comboType.setSelectedItem(item);
                    }
                } else {
                    addTypeItem(namespace, classifier);
                }
            }
        }

        updatePopupSize();
    }

    /**
     * <p>
     * Adds all the <code>Classifier</code> instances under the given <code>Namespace</code>
     * as items to the type combo box.
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
    private void addTypeItem(Namespace namespace, Classifier classifier) {
        for (ModelElement modelElement : namespace.getOwnedElements()) {
            if ((modelElement instanceof Classifier) && !(modelElement instanceof UseCase)
                    && (!modelClassifiers.contains(modelElement.getName()))) {
                NamespaceItem item = new NamespaceItem((Classifier) modelElement);
                comboType.addItem(item);
                modelClassifiers.add(modelElement.getName());

                if (classifier != null && classifier.getName().equals(modelElement.getName())) {
                    comboType.setSelectedItem(item);
                }
            } else if (modelElement instanceof Namespace) {
                addTypeItem((Namespace) modelElement, classifier);
            }
        }
    }

    /**
     * <p>
     * Creates a new type with the name.
     * </p>
     * @param str
     *            the type's name
     * @return the new type
     */
    private Classifier createNewType(String str) {
        Classifier type = new DataTypeImpl();
        type.setName(str);
        UMLModelManager manager = UMLModelManager.getInstance();
        Model root = manager.getModel();
        root.addOwnedElement(type);
        type.setNamespace(root);
        return type;
    }

    /**
     * <p>
     * Updates the popup size.
     * </p>
     */
    private void updatePopupSize() {
        FontMetrics fm = comboType.getFontMetrics(comboType.getFont());
        int size = 0;
        for (int i = 0; i < comboType.getItemCount(); i++) {
            String sds = (String) comboType.getItemAt(i).toString();
            if ((sds != null) && (size < fm.stringWidth(sds))) {
                size = fm.stringWidth(sds);
            }
        }
        int width = comboType.getSize().width;
        if (size < width) {
            size = width - 5;
        }
        BasicComboPopup popup = (BasicComboPopup) comboType.getUI().getAccessibleChild(retrievePanel(), 0);
        popup.setPreferredSize(new Dimension(size + 5, popup.getPreferredSize().height));
        Component scrollpane = popup.getComponent(0);
        popup.setLayout(new BorderLayout());
        popup.add(scrollpane, BorderLayout.CENTER);
    }
}
