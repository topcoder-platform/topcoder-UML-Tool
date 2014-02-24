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
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;

/**
 * <p>
 * This class provides a GUI for <code>Guard</code> property panel.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with a label <b>Guard</b> and a <code>JFormattedTextPane</code>
 * containing the <code>Guard</code>.
 * </p>
 *
 * <p>
 * The class also provides the logic to update the <code>Guard</code> property of <code>Transition</code>.
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
public class GuardPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The text field for <code>Guard</code> property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not change afterwards.
     * </p>
     *
     * <p>
     * Will never be null.
     * </p>
     */
    private final JFormattedTextField textGuard;

    /**
     * <p>
     * Creates a new <code>GuardPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the <code>PropertiesPanel</code> instance that owns this panel
     * @throws IllegalArgumentException if argument is null
     */
    public GuardPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.GUARD), propertiesPanel);

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 280, 24);

        panel.setLayout(new GridBagLayout());

        addTextLableWithColon(panel, "Guard", 75, 40, 20);

        DefaultFormatter formatter = new DefaultFormatter();
        formatter.setOverwriteMode(false);
        textGuard = new JFormattedTextField(new DefaultFormatterFactory(formatter));
        // Adds a property change listener which will be invoked when the enter key is pressed
        textGuard.addPropertyChangeListener("value", new PropertyChangeListener() {
            /**
             * <p>
             * This method gets called when a bound property is changed.
             * </p>
             *
             * <p>
             * When the text field for the guard property receives an enter key, this method will be
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
        constraints.insets = new Insets(2, 2, 2, 35);
        constraints.fill = GridBagConstraints.NONE;
        Util.setFixedSize(textGuard, 168, 20);
        panel.add(textGuard, constraints);
    }

    /**
     * <p>
     * Executes the logic to update guard of <code>Transition</code> instance when the guard property
     * value in the panel is modified.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.GUARD, PropertyOperation.MODIFY,
                    textGuard.getValue());
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

        List<ModelElement> modelElements = getConfiguredModelElements();
        if (modelElements.size() == 1) {
            String text = getBooleanExpressionValue((Transition) modelElements.iterator().next());
            this.textGuard.setText(text);
            this.textGuard.setValue(text);
        } else {
            this.textGuard.setText("");
            this.textGuard.setValue("");
        }
    }

    /**
     * <p>
     * Gets the guard property value for the given <code>Transition</code> instance.
     * </p>
     *
     * <p>
     * Empty string will be returned if the guard property value cannot be got successfully.
     * </p>
     *
     * @param transition the <code>Transition</code> instance
     * @return the guard property value for the given <code>Transition</code> instance.
     */
    private String getBooleanExpressionValue(Transition transition) {
        Guard guard = transition.getGuard();
        if (guard != null) {
            BooleanExpression expression = guard.getExpression();
            if (expression != null) {
                return expression.getBody();
            }
        }

        return "";
    }
}
