/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;

/**
 * <p>
 * This class provides a property panel GUI for concurrency property of <code>Operation</code>
 * <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with one checkbox, <b>concurrency</b>.
 * </p>
 *
 * <p>
 * This class also provides the logic for updating the concurrency property of the configured
 * <code>ModelElement</code> when the user modifies the concurrency value in the panel.
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
public class ConcurrencyPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JCheckBox</code> to indicate concurrency.
     * </p>
     *
     * <p>
     * Created in the constructor, and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     */
    private final JCheckBox checkboxConcurrency;

    /**
     * <p>
     * Creates a new <code>ConcurrencyPropertyPanel</code> instance.
     * </p>
     *
     * @param propertiesPanel the <code>PropertiesPanel</code> instance that owns this panel
     * @throws IllegalArgumentException if argument is null
     */
    public ConcurrencyPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.CONCURRENCY), propertiesPanel);

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());

        checkboxConcurrency = new JCheckBox("Concurrency");

        // Creates an ItemListener instance and assign it to the check box
        checkboxConcurrency.addItemListener(new ItemListener() {
            /**
             * <p>
             * Invoked when an item has been selected or deselected by the user.
             * </p>
             *
             * <p>
             * When the concurrency check box is selected or deselected, this method will be invoked.
             * </p>
             *
             * @param e a semantic event which indicates that an item was selected or deselected.
             */
            public void itemStateChanged(ItemEvent e) {
                CallConcurrencyKind kind;
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    kind = CallConcurrencyKind.GUARDED;
                } else {
                    kind = CallConcurrencyKind.SEQUENTIAL;
                }

                // notify the listeners about the change
                for (ModelElement element : getConfiguredModelElements()) {
                    getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.CONCURRENCY,
                        PropertyOperation.MODIFY, kind);
                }
            }
        });

        addTitledPanelItems(new JComponent[] { checkboxConcurrency });

        panel.setBorder(BorderFactory.createTitledBorder("Concurrency"));
    }

    /**
     * <p>
     * Executes the logic when the kind property value changes.
     * </p>
     *
     * <p>
     * As all the logic is embedded directly into the anonymous item listener, this method does nothing.
     * </p>
     */
    public void execute() {
        // empty
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * If all the configured <code>ModelElement</code> have the same concurrency, the checkbox will be
     * selected or deselected based on the concurrency value. Otherwise, the checkbox will by default
     * remains deselected.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<Boolean> concurrentValues = new HashSet<Boolean>();
        for (ModelElement element : getConfiguredModelElements()) {
            boolean isConcurrent = !CallConcurrencyKind.SEQUENTIAL.equals(((Operation) element).getConcurrency());
            concurrentValues.add(isConcurrent);
        }

        if (concurrentValues.size() == 1) {
            // All the model elements have the same concurrent
            boolean value = concurrentValues.iterator().next();
            checkboxConcurrency.setSelected(value);
        } else {
            // This happens when some model elements have different concurrent
            checkboxConcurrency.setSelected(false);
        }
    }
}
