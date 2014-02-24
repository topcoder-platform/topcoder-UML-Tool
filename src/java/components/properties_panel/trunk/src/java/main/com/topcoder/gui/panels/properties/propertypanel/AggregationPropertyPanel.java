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
import com.topcoder.uml.model.datatypes.AggregationKind;

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
 * This class provides a property panel GUI for <code>Aggregation</code> property value of <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with 3 mutually exclusive radio buttons, namely <b>None</b>,
 * <b>Aggregation</b>, and <b>Composition</b>.
 * </p>
 *
 * <p>
 * This class also provides the logic to update the <code>ModelElement</code> whenever the property value
 * is modified in the panel.
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
public class AggregationPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JRadioButton</code> for <b>None</b> option.
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
    private final JRadioButton radioNone;

    /**
     * <p>
     * The <code>JRadioButton</code> for <b>Aggregation</b> option.
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
    private final JRadioButton radioAggregation;

    /**
     * <p>
     * The <code>JRadioButton</code> for <b>Composition</b> option.
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
    private final JRadioButton radioComposition;

    /**
     * <p>
     * Creates a new <code>AggregationPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel that owns this panel
     * @throws IllegalArgumentException if argument is null
     */
    public AggregationPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.AGGREGATION), propertiesPanel);

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());

        radioNone = new JRadioButton("None");
        radioAggregation = new JRadioButton("Aggregation");
        radioComposition = new JRadioButton("Composition");

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
            public void actionPerformed(ActionEvent event) {
                execute();
            }
        };

        radioNone.addActionListener(listener);
        radioAggregation.addActionListener(listener);
        radioComposition.addActionListener(listener);

        // Add all the radio buttons into buttonGroup
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioNone);
        buttonGroup.add(radioAggregation);
        buttonGroup.add(radioComposition);

        addTitledPanelItems(new JComponent[] { radioNone, radioAggregation, radioComposition });

        panel.setBorder(BorderFactory.createTitledBorder("Aggregation"));
    }

    /**
     * <p>
     * Executes the logic to update the aggregation property of <code>ModelElement</code>
     * when the aggregation property value in the panel is modified.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            // determine which radio button is selected
            AggregationKind kind;
            if (radioNone.isSelected()) {
                kind = AggregationKind.NONE;
            } else if (radioAggregation.isSelected()) {
                kind = AggregationKind.AGGREGATE;
            } else {
                kind = AggregationKind.COMPOSITE;
            }

            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.AGGREGATION,
                    PropertyOperation.MODIFY, kind);
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

        Set<AggregationKind> kinds = new HashSet<AggregationKind>();
        for (ModelElement element : getConfiguredModelElements()) {
            kinds.add(((AssociationEnd) element).getAggregation());
        }

        if (kinds.size() == 1) {
            // All the model elements have the same aggregation kind
            AggregationKind kind = kinds.iterator().next();
            radioNone.setSelected(AggregationKind.NONE.equals(kind));
            radioAggregation.setSelected(AggregationKind.AGGREGATE.equals(kind));
            radioComposition.setSelected(AggregationKind.COMPOSITE.equals(kind));
        } else {
            // This happens when some model elements have different aggregation kinds
            radioNone.setSelected(false);
            radioAggregation.setSelected(false);
            radioComposition.setSelected(false);
        }
    }
}
