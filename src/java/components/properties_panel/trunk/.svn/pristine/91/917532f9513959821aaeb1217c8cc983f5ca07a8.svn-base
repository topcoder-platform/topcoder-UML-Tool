/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.Util;

/**
 * <p>
 * This class provides a property panel GUI for Association Ends property values.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with two clickable links (they are <code>JLabel</code>) that
 * link to the properties of each of the two association ends.
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
public class AssociationEndsPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JLabel</code> that acts as a link towards the first association end.
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
    private JLabel labelAssociationEnd1;

    /**
     * <p>
     * The <code>JLabel</code> that acts as a link towards the second association end.
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
    private JLabel labelAssociationEnd2;

    /**
     * <p>
     * Creates a new <code>AssociationEndsPropertyPanel</code> instance.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     *
     * @throws IllegalArgumentException if the argument is null
     */
    public AssociationEndsPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.ASSOCIATION_ENDS_LINK), propertiesPanel);

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 230, 50);

        panel.setLayout(new GridBagLayout());

        // initializes the two labels for the two association ends
        // the foreground colors are set to BLUE and the cursors are set to hand cursor
        labelAssociationEnd1 = new JLabel();
        labelAssociationEnd1.setForeground(new Color(4, 87, 162));
        labelAssociationEnd1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelAssociationEnd2 = new JLabel();
        labelAssociationEnd2.setForeground(new Color(4, 87, 162));
        labelAssociationEnd2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.setBorder(BorderFactory.createTitledBorder("Association Ends"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(-5, 40, 0, 0);
        panel.add(labelAssociationEnd1, constraints);
        constraints.gridx = 1;
        constraints.insets = new Insets(-5, 0, 0, 0);
        panel.add(labelAssociationEnd2, constraints);

        // Creates an MouseListener instance and assign it to the two labels for association ends
        MouseListener listener = new MouseAdapter() {
            /**
             * <p>
             * Invoked when the mouse has been clicked on a component.
             * </p>
             *
             * <p>
             * When the <code>JLabel</code> is clicked, this method will be invoked
             * </p>
             *
             * @param e an event which indicates that a mouse action occurred in a component
             */
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();

                // The logic will be executed only when all the configured model elements have
                // the same first and second association ends
                if (label.getText().length() > 0) {
                    Association association = (Association) getConfiguredModelElements().get(0);
                    List<AssociationEnd> ends = association.getConnections();

                    if (label == labelAssociationEnd1) {
                        // configure the panel with the first association end
                        if (ends.size() > 0) {
                            //getPropertiesPanel().fireSelectionChangeEvent(association);
                            getPropertiesPanel().configurePanel(ends.get(0));
                            getPropertiesPanel().fireSelectionChangeEvent(ends.get(0));

                            // set it visible back, since listeners may hide it
                            getPropertiesPanel().setVisible(true);
                        }
                    } else {
                        // configure the panel with the second association end
                        if (ends.size() > 1) {
                            getPropertiesPanel().configurePanel(ends.get(1));
                            getPropertiesPanel().fireSelectionChangeEvent(ends.get(1));

                            // set it visible back, since listeners may hide it
                            getPropertiesPanel().setVisible(true);
                        }
                    }
                }
            }
        };

        // install the mouse listener to the two labels
        labelAssociationEnd1.addMouseListener(listener);
        labelAssociationEnd2.addMouseListener(listener);
    }

    /**
     * <p>
     * Executes panel logic.
     * </p>
     *
     * <p>
     * This method does nothing as all the logic is contained within the anonymous mouse listener.
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
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<AssociationEnd> firstAssociationEnds = new HashSet<AssociationEnd>();
        Set<AssociationEnd> secondAssociationEnds = new HashSet<AssociationEnd>();

        for (ModelElement element : getConfiguredModelElements()) {
            List<AssociationEnd> ends = ((Association) element).getConnections();
            int size = ends.size();

            // If the AssociationEnd instance cannot be got, then null will be used
            firstAssociationEnds.add(size > 0 ? ends.get(0) : null);
            secondAssociationEnds.add(size > 1 ? ends.get(1) : null);
        }

        if (firstAssociationEnds.size() == 1) {
            labelAssociationEnd1.setText("Start");
        } else {
            labelAssociationEnd1.setText("");
        }

        if (secondAssociationEnds.size() == 1) {
            labelAssociationEnd2.setText("End");
 		} else {
	        labelAssociationEnd1.setText("");
	    }
	}
}