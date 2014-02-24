/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class provides a property panel GUI for the name property of <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI consists of a <code>JPanel</code> with a label <b>Name</b> and a <code>JFormattedTextField</code>
 * where the name property will be displayed.
 * </p>
 *
 * <p>
 * The class also provides a logic for updating the <code>ModelElement</code> when the user modifies the panel.
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
public class NamePropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The text field that will contain the name property.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be changed afterwards. Will not be null.
     * </p>
     */
    private final JFormattedTextField textName;

    /**
     * <p>
     * Creates a new <code>NamePropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owners this panel
     * @throws IllegalArgumentException if the argument is null
     */
    public NamePropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.NAME), propertiesPanel);

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 280, 24);
        panel.setLayout(new GridBagLayout());

        addTextLableWithColon(panel, "Name", 75, 40, 20);

        DefaultFormatter formatter = new DefaultFormatter();
        formatter.setOverwriteMode(false);
        textName = new JFormattedTextField(new DefaultFormatterFactory(formatter));
        Util.setFixedSize(textName, 168, 20);

        // Adds a property change listener which will be invoked when the enter key is pressed
        textName.addPropertyChangeListener("value", new PropertyChangeListener() {
            /**
             * <p>
             * This method gets called when a bound property is changed.
             * </p>
             *
             * <p>
             * When the text field for the name property receives an enter key, this method will be
             * invoked.
             * </p>
             *
             * @param e A <code>PropertyChangeEvent</code> object describing the event source
             *      and the property that has changed.
             */
            public void propertyChange(PropertyChangeEvent e) {
                execute();
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 35);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textName, constraints);
    }

    /**
     * <p>
     * Executes the update logic when the name property value changes.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.NAME, PropertyOperation.MODIFY,
                    textName.getValue());
            }
        }
    }

    /**
     * <p>
     * Refreshes the panel data to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * If all the <code>ModelElement</code> has the same name, the <code>JFormattedTextField</code>
     * will display this name, otherwise it displays nothing.
     * </p>
     */
    public void refreshPanel() {
        //  only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<String> names = new HashSet<String>();

        for (ModelElement element : getConfiguredModelElements()) {
            names.add(element.getName());
        }

        if (names.size() == 1) {
            String name = names.iterator().next();
            this.textName.setText(name);
            this.textName.setValue(name);
        } else {
            this.textName.setText("");
            this.textName.setValue("");
        }
    }
}
