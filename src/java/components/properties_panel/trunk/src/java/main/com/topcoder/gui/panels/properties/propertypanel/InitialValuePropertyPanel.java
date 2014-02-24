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

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;

/**
 * <p>
 * This class provides a GUI to display the initial value property.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> consisting of a <code>JLabel</code> "Initial Value"
 * and a <code>JFormattedTextField</code> containing the initial value.
 * </p>
 *
 * <p>
 * The class also provides the logic to update the initial value property of the registered
 * <code>ModelElement</code>.
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
public class InitialValuePropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The text field containing the initial value.
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
    private final JFormattedTextField textInitialValue;

    /**
     * <p>
     * Creates a new <code>InitialValuePropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the argument is null
     */
    public InitialValuePropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.INITIAL_VALUE), propertiesPanel);

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 210, 24);
        panel.setLayout(new GridBagLayout());

        addTextLableWithColon(panel, "Initial Value", 75, 70, 20);

        textInitialValue = new JFormattedTextField();

        // Adds a property change listener which will be invoked when the enter key is pressed
        textInitialValue.addPropertyChangeListener("value", new PropertyChangeListener() {
            /**
             * <p>
             * This method gets called when a bound property is changed.
             * </p>
             *
             * <p>
             * When the text field for the initial value property receives an enter key, this method will be
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
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.NONE;
        Util.setFixedSize(textInitialValue, 130, 20);
        panel.add(textInitialValue, constraints);

    }

    /**
     * <p>
     * Executes the logic to update the initial value property of the registered <code>ModelElement</code>
     * when the property value changes.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.INITIAL_VALUE,
                    PropertyOperation.MODIFY, textInitialValue.getValue());
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
     * If the initial value of all the registered <code>ModelElement</code> is the same, it will be
     * displayed in the text field, otherwise, it won't be displayed.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<String> initialValues = new HashSet<String>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Attribute) {
                Expression expression = ((Attribute) element).getInitialValue();
                if (expression == null) {
                    initialValues.add("");
                } else {
                    initialValues.add(expression.getBody());
                }
            } else {
                // for AssociationEnd model element
                initialValues.addAll(retrieveTaggedValue(element));
            }
        }

        if (initialValues.size() == 1) {
            String value = initialValues.iterator().next();
            this.textInitialValue.setText(value);
            this.textInitialValue.setValue(value);
        } else {
            this.textInitialValue.setText("");
            this.textInitialValue.setValue("");
        }
    }

    /**
     * <p>
     * Gets the <b>initialValue</b> property values from the stereotypes of the given model element.
     * </p>
     *
     * @param element the model element to get its <b>initialValue</b> property value
     *
     * @return the <b>initialValue</b> property values from the stereotypes of the given model element
     */
    private Set<String> retrieveTaggedValue(ModelElement element) {
        Set<String> initialValues = new HashSet<String>();

        for (TaggedValue taggedValue : element.getTaggedValues()) {
            TagDefinition tagDefinition = taggedValue.getType();
            if ("initialValue".equals(tagDefinition.getTagType())) {
                initialValues.add(taggedValue.getDataValue());
            }
        }

        return initialValues;
    }
}
