/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.VisibilityKind;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;

/**
 * <p>
 * This class provides a GUI for visibility property panel.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> containing four mutually exclusive radio buttons: <b>Public</b>,
 * <b>Protected</b>, <b>Package</b> and <b>Private</b>.
 * </p>
 *
 * <p>
 * The class also provides the logic for updating the visibility property of the registered
 * <code>ModelElement</code> when the panel's property value is modified.
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
public class VisibilityPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JRadioButton</code> representing public visibility.
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
    private final JRadioButton radioPublic;

    /**
     * <p>
     * The <code>JRadioButton</code> representing protected visibility.
     * </p>
     *
     * <p>
     * Created in the constructor and its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JRadioButton radioProtected;

    /**
     * <p>
     * The <code>JRadioButton</code> representing package visibility.
     * </p>
     *
     * <p>
     * Created in the constructor and its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JRadioButton radioPackage;

    /**
     * <p>
     * The <code>JRadioButton</code> representing private visibility.
     * </p>
     *
     * <p>
     * Created in the constructor and its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JRadioButton radioPrivate;

    /**
     * <p>
     * Creates a new <code>VisibilityPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if argument is null
     */
    public VisibilityPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.VISIBILITY), propertiesPanel);

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());

        // Create all the 4 radio buttons with the text set as Public, Protected, Package, and Private respectively.
        radioPublic = new JRadioButton("Public");
        radioProtected = new JRadioButton("Protected");
        radioPackage = new JRadioButton("Package");
        radioPrivate = new JRadioButton("Private");

        // Creates an ActionListener instance and assign it to all radio buttons
        ActionListener listener = new ActionListener() {
            /**
             * <p>
             * Invoked when an action occurs.
             * </p>
             *
             * <p>
             * When the radio button is selected, this method will be invoked
             * </p>
             *
             * @param event a semantic event which indicates that a component-defined action occurred.
             */
            public void actionPerformed(ActionEvent e) {
                execute();
            }
        };

        radioPublic.addActionListener(listener);
        radioProtected.addActionListener(listener);
        radioPackage.addActionListener(listener);
        radioPrivate.addActionListener(listener);

        // Add all the radio buttons into buttonGroup.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioPublic);
        buttonGroup.add(radioProtected);
        buttonGroup.add(radioPackage);
        buttonGroup.add(radioPrivate);

        panel.setBorder(BorderFactory.createTitledBorder("Visibility"));

        addTitledPanelItems(new JComponent[] { radioPublic, radioProtected, radioPackage, radioPrivate });

    }

    /**
     * <p>
     * Executes the logic to update the visibility property value of the registered <code>ModelElement</code>
     * when the visibility property value is modified.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            // determine which radio button is selected
            VisibilityKind visibility;
            if (radioPublic.isSelected()) {
                visibility = VisibilityKind.PUBLIC;
            } else if (radioProtected.isSelected()) {
                visibility = VisibilityKind.PROTECTED;
            } else if (radioPackage.isSelected()) {
                visibility = VisibilityKind.PACKAGE;
            } else {
                visibility = VisibilityKind.PRIVATE;
            }

            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.VISIBILITY,
                    PropertyOperation.MODIFY, visibility);
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
     * If the visibility properties of all the configured <code>ModelElement</code> is the same, the
     * corresponding radio button is selected, otherwise no radio button is selected.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<VisibilityKind> kinds = new HashSet<VisibilityKind>();

        for (ModelElement element : getConfiguredModelElements()) {
            kinds.add(element.getVisibility());
        }

        if (kinds.size() == 1) {
            // All the model elements have the visibility kind
            VisibilityKind kind = kinds.iterator().next();
            if (kind == null) {
                for (ModelElement element : getConfiguredModelElements()) {
                    element.setVisibility(VisibilityKind.PUBLIC);
                }
                kind = VisibilityKind.PUBLIC;
            }
            radioPublic.setSelected(VisibilityKind.PUBLIC.equals(kind));
            radioProtected.setSelected(VisibilityKind.PROTECTED.equals(kind));
            radioPackage.setSelected(VisibilityKind.PACKAGE.equals(kind));
            radioPrivate.setSelected(VisibilityKind.PRIVATE.equals(kind));
        } else {
            // This happens when some model elements have different visibility kinds
            radioPublic.setSelected(false);
            radioProtected.setSelected(false);
            radioPackage.setSelected(false);
            radioPrivate.setSelected(false);
        }
    }
}
