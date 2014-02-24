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
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.OrderingKind;

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
 * This class provides a property panel GUI for ordering property of <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with three mutually exclusive radio buttons, namely <b>Ordered</b>,
 * <b>Unordered</b> and <b>Unspecified</b>.
 * </p>
 *
 * <p>
 * The class also provides the logic to handle updating of ordering property of <code>ModelElement</code>
 * when the user modifies the value in the panel.
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
public class OrderingPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The radio button for <b>Ordered</b> option.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     */
    private final JRadioButton radioOrdered;

    /**
     * <p>
     * The radio button for <b>Unordered</b> option.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     */
    private final JRadioButton radioUnordered;

    /**
     * <p>
     * The radio button for <b>Unspecified</b> option.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     */
    private final JRadioButton radioUnspecified;

    /**
     * <p>
     * Creates a new <code>OrderingPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public OrderingPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.ORDERING), propertiesPanel);

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());

        // Create all the 3 radio buttons.
        radioOrdered = new JRadioButton("Ordered");
        radioUnordered = new JRadioButton("Unordered");
        radioUnspecified = new JRadioButton("Unspecified");

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

        radioOrdered.addActionListener(listener);
        radioUnordered.addActionListener(listener);
        radioUnspecified.addActionListener(listener);

        ButtonGroup buttonGroup = new ButtonGroup();

        // Add all the radio buttons into buttonGroup.
        buttonGroup.add(radioOrdered);
        buttonGroup.add(radioUnordered);
        buttonGroup.add(radioUnspecified);

        addTitledPanelItems(new JComponent[] {radioOrdered, radioUnordered, radioUnspecified });

        panel.setBorder(BorderFactory.createTitledBorder("Ordering"));
    }

    /**
     * <p>
     * Executes the logic to update the ordering property of all the configured <code>ModelElement</code>
     * when the ordering property value is changed in the panel.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            OrderingKind kind;
            if (radioOrdered.isSelected()) {
                kind = OrderingKind.ORDERED;
            } else if (radioUnordered.isSelected()) {
                kind = OrderingKind.UNORDERED;
            } else {
                kind = null;
            }

            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.ORDERING, PropertyOperation.MODIFY,
                    kind);
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
     * If all the configured <code>ModelElement</code> have the same ordering property values,
     * the corresponding radio button will be selected. Otherwise, all the radio buttons will
     * remain deselected.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<OrderingKind> kinds = new HashSet<OrderingKind>();

        for (ModelElement element : getConfiguredModelElements()) {
            kinds.add(((AssociationEnd) element).getOrdering());
        }

        if (kinds.size() == 1) {
            // All the model elements have the same ordering kind
            OrderingKind kind = kinds.iterator().next();
            radioOrdered.setSelected(OrderingKind.ORDERED.equals(kind));
            radioUnordered.setSelected(OrderingKind.UNORDERED.equals(kind));
            radioUnspecified.setSelected(kind == null);
        } else {
            // This happens when some model elements have different ordering kinds
            radioOrdered.setSelected(false);
            radioUnordered.setSelected(false);
            radioUnspecified.setSelected(false);
        }
    }
}
