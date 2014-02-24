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
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;

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
 * This class provides a property panel GUI for the kind property value of <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with four mutually exclusive <code>JRadioButton</code>, namely
 * <b>In/Out</b>, <b>In</b>, <b>Out</b> and <b>Return</b>.
 * </p>
 *
 * <p>
 * This class also provides the logic to update the configured <code>ModelElement</code> when the
 * user modifies the kind property value in the panel.
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
public class KindPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JRadioButton</code> for <b>In/Out</b> kind.
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
    private final JRadioButton radioInOut;

    /**
     * <p>
     * The <code>JRadioButton</code> for <b>In</b> kind.
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
    private final JRadioButton radioIn;

    /**
     * <p>
     * The <code>JRadioButton</code> for <b>Out</b> kind.
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
    private final JRadioButton radioOut;

    /**
     * <p>
     * The <code>JRadioButton</code> for <b>Return</b> kind.
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
    private final JRadioButton radioReturn;

    /**
     * <p>
     * Creates a new <code>KindPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if argument is null
     */
    public KindPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.KIND), propertiesPanel);

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());

        // Create all the 4 radio buttons with the text set as "In/Out", "In", "Out", "Return" respectively.
        this.radioInOut = new JRadioButton("In/Out");
        this.radioIn = new JRadioButton("In");
        this.radioOut = new JRadioButton("Out");
        this.radioReturn = new JRadioButton("Return");

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

        radioInOut.addActionListener(listener);
        radioIn.addActionListener(listener);
        radioOut.addActionListener(listener);
        radioReturn.addActionListener(listener);

        // Add all the radio buttons into buttonGroup.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioInOut);
        buttonGroup.add(radioIn);
        buttonGroup.add(radioOut);
        buttonGroup.add(radioReturn);

        addTitledPanelItems(new JComponent[] { radioInOut, radioIn, radioOut, radioReturn });

        panel.setBorder(BorderFactory.createTitledBorder("Kind"));
    }

    /**
     * <p>
     * Executes the logic to update the configured ModelElement when the kind property value changes.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            // determine which radio button is selected
            ParameterDirectionKind kind;
            if (radioInOut.isSelected()) {
                kind = ParameterDirectionKind.INOUT;
            } else if (radioIn.isSelected()) {
                kind = ParameterDirectionKind.IN;
            } else if (radioOut.isSelected()) {
                kind = ParameterDirectionKind.OUT;
            } else {
                kind = ParameterDirectionKind.RETURN;
            }

            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.KIND,
                    PropertyOperation.MODIFY, kind);
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
     * If all the configured <code>ModelElement</code> is of the same kind, the corresponding radio button
     * is then selected. Otherwise, nothing is selected.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<ParameterDirectionKind> kinds = new HashSet<ParameterDirectionKind>();

        for (ModelElement element : getConfiguredModelElements()) {
            kinds.add(((Parameter) element).getKind());
        }

        if (kinds.size() == 1) {
            // All the model elements have the same kind
            ParameterDirectionKind kind = kinds.iterator().next();
            radioInOut.setSelected(ParameterDirectionKind.INOUT.equals(kind));
            radioIn.setSelected(ParameterDirectionKind.IN.equals(kind));
            radioOut.setSelected(ParameterDirectionKind.OUT.equals(kind));
            radioReturn.setSelected(ParameterDirectionKind.RETURN.equals(kind));
        } else {
            // This happens when some model elements have different kinds
            radioInOut.setSelected(false);
            radioIn.setSelected(false);
            radioOut.setSelected(false);
            radioReturn.setSelected(false);
        }
    }
}