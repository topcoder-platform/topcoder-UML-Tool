/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

import com.topcoder.diagraminterchange.Diagram;

public class DiagramNamePanel extends JPanel implements PropertyChangeListener {

    private Diagram diagram;

    private JLabel nameLabel;

    private JTextField nameTextField;

    private final PropertiesPanel propertiesPanel;

    public DiagramNamePanel(PropertiesPanel propertiesPanel) {
        super(new GridBagLayout());

        this.propertiesPanel = propertiesPanel;

        init();
    }

    private void init() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        add(getNameLabel(), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(getNameTextField(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(new JPanel(), constraints);
    }

    public JTextField getNameTextField() {
        if (nameTextField == null) {
            DefaultFormatter formatter = new DefaultFormatter();
            formatter.setOverwriteMode(false);
            nameTextField = new JFormattedTextField(new DefaultFormatterFactory(formatter));
            nameTextField.addPropertyChangeListener("value", this);
        }
        return nameTextField;
    }

    public JLabel getNameLabel() {
        if (nameLabel == null) {
            nameLabel = new JLabel("Diagram Name: ");
        }
        return nameLabel;
    }

    public void configureDiagram(Diagram diagram) {
        this.diagram = diagram;

        getNameTextField().setText(diagram.getName());
    }

    public void propertyChange(PropertyChangeEvent evt) {
        diagram.setName((String) evt.getNewValue());

        propertiesPanel.fireDiagramChangeEvent(diagram);
    }

}
