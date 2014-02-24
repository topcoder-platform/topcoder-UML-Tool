/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class provides a property panel GUI for the operation property of <code>ModelElement</code>.
 * </p>
 * <p>
 * The GUI consists of a <code>JButton</code> used to add operation.
 * </p>
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
public class OperationPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * Creates a new <code>QperationPropertyPanel</code>.
     * </p>
     * @param propertiesPanel
     *            the PropertiesPanel instance that owners this panel
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public OperationPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.OPERATION), propertiesPanel);

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());
        Util.setFixedSize(panel, 130, 24);

        JButton addButton = new JButton("Add Operation");
        Util.setFixedSize(addButton, 130, 20);

        // Creates an MouseListener instance and assign it to the button
        addButton.addMouseListener(new MouseAdapter() {
            /**
             * <p>
             * Invoked when the mouse has been clicked on a component.
             * </p>
             * <p>
             * When the <code>JLabel</code> is clicked, this method will be invoked
             * </p>
             * @param e
             *            an event which indicates that a mouse action occurred in a component
             */
            public void mouseClicked(MouseEvent e) {
                execute();
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 2, 0, 2);
        panel.add(addButton, constraints);
    }

    /**
     * <p>
     * Executes the add logic when the button is pressed.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.OPERATION, PropertyOperation.ADD,
                        null);
            }
        }
    }

    /**
     * <p>
     * Refreshes the panel data to the most up-to-date information from the
     * list of configured <code>ModelElement</code>.
     * </p>
     */
    public void refreshPanel() {
    }
}
