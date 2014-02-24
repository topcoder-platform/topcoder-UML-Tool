/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

/**
 * <p>
 * This class provides a GUI for multiplicity property value of <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with a <code>JLabel</code> <b>Multiplicity</b> and an
 * editable <code>JComboBox</code> containing the standard (configurable) set of multiplicities.
 * </p>
 *
 * <p>
 * The logic to update the multiplicity of configured <code>ModelElement</code> is also provided.
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
public class MultiplicityPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>JComboBox</code> to register multiplicity.
     * </p>
     *
     * <p>
     * Created in the constructor, the reference will not change.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JComboBox comboMultiplicity;

    /**
     * <p>
     * The last selected combo box item when the JComboBox is to be edited.
     * </p>
     *
     * <p>
     * It is set when the editor of the combo box gains the focus.
     * </p>
     */
    private Object oldItem;

    /**
     * <p>
     * The list of default multiplicities.
     * </p>
     *
     * <p>
     * Set in the constructor, the reference will not change afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final List<Multiplicity> defaultMultiplicities = new ArrayList<Multiplicity>();

    /**
     * <p>
     * Creates a new <code>MultiplicityPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @param multiplicities the list of multiplicities
     *
     * @throws IllegalArgumentException if argument is null, or multiplicities contains null element or
     * Multiplicity instance which contains invalid MultiplicityRange instance
     */
    public MultiplicityPropertyPanel(PropertiesPanel propertiesPanel, List<Multiplicity> multiplicities) {
        super(Collections.singletonList(PropertyKind.MULTIPLICITY), propertiesPanel);

        Util.checkCollection(multiplicities, "multiplicities");

        // Check all the MultiplicityRange instances for each Multiplicity
        for (Multiplicity multiplicity : multiplicities) {
            for (MultiplicityRange range : multiplicity.getRanges()) {
                if (range.getLower() > range.getUpper()) {
                    throw new IllegalArgumentException("The multiplicities contains Multiplicity instance "
                        + "which contains invalid MultiplicityRange instance.");
                }
            }
        }

        defaultMultiplicities.addAll(multiplicities);

        JPanel panel = retrievePanel();
        Util.setFixedSize(panel, 210, 24);

        panel.setLayout(new GridBagLayout());

        addTextLableWithColon(panel, "Multiplicity", 75, 70, 20);

        comboMultiplicity = new JComboBox();
        comboMultiplicity.setEditable(true);

        // add an ActionListener to the combo box
        comboMultiplicity.addActionListener(new ActionListener() {
            /**
             * <p>
             * Invoked when an action occurs.
             * </p>
             *
             * <p>
             * When the current item of the combo box is changed, then this method will be invoked.
             * </p>
             *
             * @param event a semantic event which indicates that a component-defined action occurred.
             */
            public void actionPerformed(ActionEvent e) {
                // we only care about the comboBoxChanged action
                if ("comboBoxChanged".equals(e.getActionCommand())) {
                    execute();
                }
            }
        });

        // add an FocusAdapter to the editor of the combo box
        comboMultiplicity.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            /**
             * <p>
             * Invoked when a component gains the keyboard focus.
             * </p>
             *
             * @param e A low-level event which indicates that a Component has gained the
             * input focus
             */
            public void focusGained(FocusEvent e) {
                oldItem = comboMultiplicity.getSelectedItem();
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.NONE;
        Util.setFixedSize(comboMultiplicity, 130, 20);
        panel.add(comboMultiplicity, constraints);
    }

    /**
     * <p>
     * Executes the logic when the multiplicity property value changes.
     * </p>
     *
     * <p>
     * A new Multiplicity instance may be entered by the user input.
     * A multiplicity range will be in the form : <b>*</b> or <b>number</b> or <b>lowerBound..*</b>
     * or <b>lowerBound..upperBound</b>, each multiplicity range will be separated by a comma.
     * </p>
     */
    public void execute() {
        if (isConfigured()) {
            Object multiplicitySelected = comboMultiplicity.getSelectedItem();

            MultiplicityItem item;
            Multiplicity multiplicity;
            if (multiplicitySelected instanceof MultiplicityItem) {
                item = (MultiplicityItem) multiplicitySelected;
                multiplicity = new MultiplicityImpl();
                for (MultiplicityRange range : item.getMultiplicity().getRanges()) {
                    MultiplicityRange newRange = new MultiplicityRangeImpl();
                    newRange.setMultiplicity(multiplicity);
                    newRange.setLower(range.getLower());
                    newRange.setUpper(range.getUpper());
                    multiplicity.addRange(newRange);
                }
            } else {
                // The user enter a new Multiplicity
                multiplicity = parseMultiplicity(multiplicitySelected.toString());

                // If the string entered is not valid, then nothing will happen and the old item
                // will be re-selected.
                if (multiplicity == null) {
                    if (oldItem != null) {
                        comboMultiplicity.setSelectedItem(oldItem);
                    }

                    return;
                }

                // create a new item to the combo box
                item = new MultiplicityItem(multiplicity);
                comboMultiplicity.addItem(item);
            }

            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.MULTIPLICITY,
                        PropertyOperation.MODIFY, multiplicity);
            }
        }
    }

    /**
     * <p>
     * Parses the given text to a <code>Multiplicity</code> instance.
     * </p>
     *
     * <p>
     * A <code>Multiplicity</code> is represented by a serials of <code>MultiplicityRange</code>.
     * A <code>MultiplicityRange</code> will be in the form : <b>*</b> or <b>number</b> or
     * <b>lowerBound..*</b> or <b>lowerBound..upperBound</b>, each multiplicity range will be
     * separated by a comma.
     * </p>
     *
     * @param text the text to be parsed to be a <code>Multiplicity</code> instance
     *
     * @return the <code>Multiplicity</code> instance converted from the given text, if the text is
     * not well-formed, then null will be returned.
     */
    private Multiplicity parseMultiplicity(String text) {
        // Empty string is not valid
        if (text.trim().length() == 0) {
            return null;
        }

        String[] rangeValues = text.split(",");

        Multiplicity multiplicity = new MultiplicityImpl();

        // Creates all the MultiplicityRange instance for the Multiplicity instance
        for (String rangeValue : rangeValues) {
            MultiplicityRange range = parseMultiplicityRange(rangeValue);
            // The text is not well-formed, then null will be returned
            if (range == null) {
                return null;
            } else {
                multiplicity.addRange(range);
            }
        }

        return multiplicity;
    }

    /**
     * <p>
     * Parses the given text to a <code>MultiplicityRange</code> instance.
     * </p>
     *
     * <p>
     * A <code>MultiplicityRange</code> will be in the form : <b>*</b> or <b>number</b> or
     * <b>lowerBound..*</b> or <b>lowerBound..upperBound</b>.
     * </p>
     *
     * @param text the text to be parsed to be a <code>MultiplicityRange</code> instance
     *
     * @return the <code>MultiplicityRange</code> instance converted from the given text, if the text is
     * not well-formed, then null will be returned.
     */
    private MultiplicityRange parseMultiplicityRange(String text) {
        // Empty string is not valid
        if (text.trim().length() == 0) {
            return null;
        }

        MultiplicityRange range = new MultiplicityRangeImpl();

        if ("*".equals(text)) {
            // only a star character
            range.setLower(0);
            range.setUpper(Integer.MAX_VALUE);
        } else {
            String[] values = text.split("[.]{2,2}");

            if (values.length == 1) {

                // only a digital
                try {
                    int value = Integer.parseInt(values[0]);
                    if (value < 0) {
                        return null;
                    }

                    range.setLower(value);
                    range.setUpper(value);
                } catch (NumberFormatException e) {
                    return null;
                }
            } else if (values.length == 2) {
                // in the form of [lower..upper]
                // the upper can be a star character

                // parse the lower bound
                try {
                    int lower = Integer.parseInt(values[0]);
                    if (lower < 0) {
                        return null;
                    }

                    range.setLower(lower);
                } catch (NumberFormatException e) {
                    return null;
                }

                // parse the upper bound
                if ("*".equals(values[1])) {
                    range.setUpper(Integer.MAX_VALUE);
                } else {
                    try {
                        int upper = Integer.parseInt(values[1]);
                        if (upper < range.getLower()) {
                            return null;
                        }

                        range.setUpper(upper);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
            } else {
                // The range string is not well-formed
                return null;
            }
        }

        return range;
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

        comboMultiplicity.removeAllItems();

        // Add the default multiplicity items
        for (Multiplicity multiplicity : defaultMultiplicities) {
            MultiplicityItem item = new MultiplicityItem(multiplicity);
            comboMultiplicity.addItem(item);
        }

        Set<Multiplicity> multiplicities = new HashSet<Multiplicity>();

        for (ModelElement modelElement : getConfiguredModelElements()) {
            if (modelElement instanceof Attribute) {
                multiplicities.add(((Attribute) modelElement).getMultiplicity());
            } else {
                multiplicities.add(((AssociationEnd) modelElement).getMultiplicity());
            }
        }

        if (multiplicities.size() == 1) {
            Multiplicity multiplicity = multiplicities.iterator().next();
            if (multiplicity != null) {
                // the multiplicity for the configured model element will be added as well
                MultiplicityItem item = new MultiplicityItem(multiplicity);
                comboMultiplicity.addItem(item);
                comboMultiplicity.setSelectedItem(item);
            }
        }
    }

    /**
     * <p>
     * This inner class of <code>MultiplicityPropertyPanel</code> provides a wrapper to wrap
     * <code>Multiplicity</code> object.
     * </p>
     *
     * <p>
     * This enables <code>Multiplicity</code> object to be displayed as plain text while retrieval
     * of corresponding <code>Multiplicity</code> object can be kept simple.
     * </p>
     *
     * <p>
     * Thread-safety: this class is thread-safe as it is immutable.
     * </p>
     *
     * @author ch_music, TCSDEVELOPER
     * @version 1.0
     */
    private class MultiplicityItem {
        /**
         * <p>
         * The presentation name.
         * </p>
         *
         * <p>
         * Created in the constructor, will not change afterwards, will never be null.
         * </p>
         */
        private final String presentationName;

        /**
         * <p>
         * The multiplicity to be wrapped.
         * </p>
         *
         * <p>
         * Assigned in the constructor, will not change afterwards, will never be null.
         * </p>
         */
        private final Multiplicity multiplicity;

        /**
         * <p>
         * Creates a new <code>MultiplicityItem</code>.
         * </p>
         *
         * @param multiplicity the multiplicity instance to be wrapped
         * @throws IllegalArgumentException if the given argument is null
         */
        public MultiplicityItem(Multiplicity multiplicity) {
            Util.checkNull(multiplicity, "multiplicity");

            this.multiplicity = multiplicity;

            // get the presentation name for the given Multiplicity
            StringBuilder sb = new StringBuilder();
            for (MultiplicityRange range : multiplicity.getRanges()) {
                sb.append(encodeMultiplicityRange(range));
                sb.append(",");
            }

            int len = sb.length();
            if (len > 0) {
                // remove the last comma
                sb.deleteCharAt(len - 1);
            }

            this.presentationName = sb.toString();
        }

        /**
         * <p>
         * This method encodes the given <code>MultiplicityRange</code> in <code>String</code> representation.
         * </p>
         *
         * @param range the <code>MultiplicityRange</code> to encode
         *
         * @return the <code>String</code> representation of the <code>MultiplicityRange</code>
         */
        private String encodeMultiplicityRange(MultiplicityRange range) {
            int lower = range.getLower();
            int upper = range.getUpper();

            if (lower == upper) {
                return String.valueOf(lower);
            } else if (lower == 0 && upper == Integer.MAX_VALUE) {
                return "*";
            } else {
                return lower + ".." + (Integer.MAX_VALUE == upper ? "*" : upper);
            }
        }

        /**
         * <p>
         * Retrieves the wrapped multiplicity.
         * </p>
         *
         * @return the wrapped multiplicity
         */
        public Multiplicity getMultiplicity() {
            return multiplicity;
        }

        /**
         * <p>
         * Returns the string representation of this item.
         * </p>
         *
         * @return the string representation of this item
         */
        public String toString() {
            return presentationName;
        }
    }
}
