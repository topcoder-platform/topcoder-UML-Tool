/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.Util;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * This class provides a property panel GUI for incoming transitions property.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> containing a list of all the incoming transitions.
 * </p>
 *
 * <p>
 * Each item in the list acts as a link to the properties of the incoming transition.
 * The transitions are represented by <code>Transition.getSource().getName() + "->" +
 * Transition.getTarget().getName()</code>.
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
public class IncomingTransitionPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>DefaultListModel</code> containing the <code>TransitionListItem</code>.
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
    private DefaultListModel listModelIncomingTransitions;

    /**
     * <p>
     * The <code>JList</code> for the <code>Transition</code> links.
     * </p>
     *
     * <p>
     * Created in the constructor, the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will never be null.
     * </p>
     */
    private JList listIncomingTransitions;

    /**
     * <p>
     * Creates a new <code>IncomingTransitionPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if argument is null
     */
    public IncomingTransitionPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.INCOMING_TRANSITIONS), propertiesPanel);

        listModelIncomingTransitions = new DefaultListModel();
        listIncomingTransitions = new JList(listModelIncomingTransitions);
        listIncomingTransitions.setVisibleRowCount(3);
        listIncomingTransitions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Creates an MouseListener instance and assign it to the list
        listIncomingTransitions.addMouseListener(new MouseAdapter() {
            /**
             * <p>
             * Invoked when the mouse has been clicked on a component.
             * </p>
             *
             * <p>
             * When the <code>JList</code> is clicked, this method will be invoked
             * </p>
             *
             * @param e an event which indicates that a mouse action occurred in a component
             */
            public void mouseClicked(MouseEvent e) {
                execute();
            }
        });

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 247, 60);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 3, 3, 3);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;

        // JScrollPane is used
        panel.add(new JScrollPane(listIncomingTransitions), constraints);
        panel.setBorder(BorderFactory.createTitledBorder("Incoming Transitions"));
    }

    /**
     * <p>
     * Executes the logic to show the properties of the selected incoming transition when it is clicked.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            TransitionListItem item = (TransitionListItem) listIncomingTransitions.getSelectedValue();

            // No item is selected, return directly
            if (item == null) {
                return;
            }

            // configure the properties panel with the Transition instance
            Transition transition = item.getTransition();
            getPropertiesPanel().configurePanel(transition);
            getPropertiesPanel().fireSelectionChangeEvent(transition);
        }
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * It will only show incoming transition when one supported <code>ModelElement</code> is configured.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        listModelIncomingTransitions.removeAllElements();

        List<ModelElement> modelElements = getConfiguredModelElements();
        // it will only show incoming transition when one supported model element is configured
        if (modelElements.size() == 1) {
            Collection<Transition> transitions = ((StateVertex) modelElements.get(0)).getIncomingTransitions();
            for (Transition transition : transitions) {
                listModelIncomingTransitions.addElement(new TransitionListItem(transition));
            }
        }
    }
}
