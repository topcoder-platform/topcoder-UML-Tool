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

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.ChangeableKind;

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
 * This class provides a GUI for changeability property value of <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with 3 mutually exclusive radio button, namely <b>Changeable</b>,
 * <b>Frozen</b>, and <b>AddOnly</b>.
 * </p>
 *
 * <p>
 * The logic to update the changeability of registered ModelElement is also provided.
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
public class ChangeabilityPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JRadioButton</code> representing changeable changeability.
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
    private final JRadioButton radioChangeable;

    /**
     * <p>
     * The <code>JRadioButton</code> representing frozen changeability.
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
    private final JRadioButton radioFrozen;

    /**
     * <p>
     * The <code>JRadioButton</code> representing add only changeability.
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
    private final JRadioButton radioAddOnly;

    /**
     * <p>
     * Creates a new <code>ChangabilityPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel that owns this panel
     * @throws IllegalArgumentException if argument is null
     */
    public ChangeabilityPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.CHANGEABILITY), propertiesPanel);

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());

        radioChangeable = new JRadioButton("Changeable");
        radioFrozen = new JRadioButton("Frozen");
        radioAddOnly = new JRadioButton("Add Only");

        // Creates an ActionListener instance and assign it to all radio buttons
        ActionListener listener = new ActionListener() {
            /**
             * <p>
             * Invoked when an action occurs.
             * </p>
             *
             * <p>
             * When the radio button is selected, this method will be invoked.
             * </p>
             *
             * @param event a semantic event which indicates that a component-defined action occurred.
             */
            public void actionPerformed(ActionEvent e) {
                execute();
            }
        };

        radioChangeable.addActionListener(listener);
        radioFrozen.addActionListener(listener);
        radioAddOnly.addActionListener(listener);

        // Add all the radio buttons into buttonGroup
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioChangeable);
        buttonGroup.add(radioFrozen);
        buttonGroup.add(radioAddOnly);

        addTitledPanelItems(new JComponent[] { radioChangeable, radioFrozen, radioAddOnly });

        panel.setBorder(BorderFactory.createTitledBorder("Changeability"));
    }

    /**
     * <p>
     * Executes the logic to update the configured <code>ModelElement</code> when the changeability
     * property value is modified.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            //  determine which radio button is selected
            ChangeableKind changeability;
            if (radioChangeable.isSelected()) {
                changeability = ChangeableKind.CHANGEABLE;
            } else if (radioFrozen.isSelected()) {
                changeability = ChangeableKind.FROZEN;
            } else {
                changeability = ChangeableKind.ADD_ONLY;
            }

            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.CHANGEABILITY,
                    PropertyOperation.MODIFY, changeability);
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
     * If all the configured <code>ModelElement</code> has the same changeability, the respective
     * radio button will be selected.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<ChangeableKind> kinds = new HashSet<ChangeableKind>();
        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof AssociationEnd) {
                kinds.add(((AssociationEnd) element).getChangeability());
            } else {
                kinds.add(((Attribute) element).getChangeability());
            }
        }

        if (kinds.size() == 1) {
            // All the model elements have the same changeability
            ChangeableKind kind = kinds.iterator().next();
            radioChangeable.setSelected(ChangeableKind.CHANGEABLE.equals(kind));
            radioFrozen.setSelected(ChangeableKind.FROZEN.equals(kind));
            radioAddOnly.setSelected(ChangeableKind.ADD_ONLY.equals(kind));
        } else {
            // This happens when some model elements have different changeability
            radioChangeable.setSelected(false);
            radioFrozen.setSelected(false);
            radioAddOnly.setSelected(false);
        }
    }
}
