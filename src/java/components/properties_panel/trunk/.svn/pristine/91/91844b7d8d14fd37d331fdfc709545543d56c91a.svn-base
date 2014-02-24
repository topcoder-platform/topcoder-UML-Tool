/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

/**
 * <p>
 * This class provides a property panel GUI and logic for <code>stereotype</code> list property of
 * <code>Operation</code>.
 * </p>
 *
 * <p>
 * The class displays the <code>Stereotype</code> in a <code>JTable</code> with a delete button
 * next to each <code>Stereotype</code>.
 * </p>
 *
 * <p>
 * There is also an add new <code>Stereotype</code> button, when it is clicked, a new dialog will
 * pop-up for adding/removing stereotypes.
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
public class StereotypeListPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>CustomTableModel</code> containing the <code>Stereotype</code>.
     * </p>
     *
     * <p>
     * Created in the constructor, the reference will not change, will not be null.
     * </p>
     */
    private final CustomTableModel tableModel;

    /**
     * <p>
     * The <code>JTable</code> containing the <code>Stereotype</code>.
     * </p>
     *
     * <p>
     * Created in the constructor, the reference will not change, will not be null.
     * </p>
     */
    private final JTable jTable;

    /**
     * <p>
     * The add button to add stereotype.
     * </p>
     *
     * <p>
     * Created in the constructor, will not be changed afterwards, will not be null.
     * </p>
     */
    private final JButton buttonAddStereotype;

    /**
     * <p>
     * The delete icon for the delete button.
     * </p>
     *
     * <p>
     * Set in the constructor, its reference will not change afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final Icon deleteIcon;

    /**
     * <p>
     * Creates a new <code>StereotypeListPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel The PropertiesPanel that owns this panel
     * @param addIcon the icon for the add button
     * @param deleteIcon the icon for the delete button
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public StereotypeListPropertyPanel(PropertiesPanel propertiesPanel, Icon addIcon, Icon deleteIcon) {
        super(Collections.singletonList(PropertyKind.STEREOTYPES), propertiesPanel);

        Util.checkNull(deleteIcon, "deleteIcon");
        Util.checkNull(addIcon, "addIcon");

        this.deleteIcon = deleteIcon;

        tableModel = new CustomTableModel();
        jTable = new JTable(tableModel);

        // Add a MouseListener to the table
        jTable.addMouseListener(new MouseAdapter() {
            /**
             * <p>
             * Invoked when the mouse has been clicked on a component.
             * </p>
             *
             * <p>
             * When the <code>JTable</code> is clicked, this method will be invoked
             * </p>
             *
             * @param e an event which indicates that a mouse action occurred in a component
             */
            public void mouseClicked(MouseEvent e) {
                int column = jTable.getSelectedColumn();
                int row = jTable.getSelectedRow();

                //  no selection, return directly
                if (column == -1 || row == -1) {
                    return;
                }

                StereotypeItem item = (StereotypeItem) tableModel.getValueAt(row, 0);
                Stereotype stereotype = item.getStereotype();
                if (column == 1) {
                    // remove the Stereotype
                    tableModel.removeRow(row);

                    // notify the listeners about the change
                    for (ModelElement element : getConfiguredModelElements()) {
                        getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.STEREOTYPES,
                            PropertyOperation.REMOVE, stereotype);
                    }
                }
            }
        });

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());

        buttonAddStereotype = new JButton(addIcon);

        buttonAddStereotype.setToolTipText("Add/Remove Stereotypes");

        // Creates an ActionListener instance and assign it to the button
        buttonAddStereotype.addActionListener(new ActionListener() {
            /**
             * <p>
             * Invoked when an action occurs.
             * </p>
             *
             * <p>
             * When the button is clicked, this method will be invoked.
             * </p>
             *
             * @param event a semantic event which indicates that a component-defined action occurred.
             */
            public void actionPerformed(ActionEvent e) {
                ModelElement element = getConfiguredModelElements().get(0);

                List<Stereotype> standardStereotypes = getPropertiesPanel().getStereotypes(element.getClass());
                Set<Stereotype> selectedStereotypes = new HashSet<Stereotype>(element.getStereotypes());

                //BUGR-115 make intersection of all selected elements stereotypes
                for (ModelElement el : getConfiguredModelElements()) {
                	selectedStereotypes.retainAll(el.getStereotypes());
                }
                
                JDialog dialog = new AddStereotypeJDialog(standardStereotypes, selectedStereotypes);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });

        populateTabelPanel(panel, "Stereotype", buttonAddStereotype, new JTable[]{ jTable });

    }

    /**
     * <p>
     * Executes the logic.
     * </p>
     *
     * <p>
     * This method does nothing as the logic is implemented in the corresponding listeners.
     * </p>
     */
    public void execute() {
        // empty
    }

    /**
     * <p>
     * Refreshes the panel to reflect the most up to date data from <code>ModelElement</code>.
     * </p>
     * <p>
     * V1.1 Change Note: the new layout is used as the prototype.
     * </p>
     **/
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        ModelElement element = getConfiguredModelElements().get(0);
        Set<Stereotype> selectedStereotypes = new HashSet<Stereotype>(element.getStereotypes());
        tableModel.removeAllRow();
        
        //BUGR-115 make intersection of all selected elements stereotypes
        for (ModelElement el : getConfiguredModelElements()) {
        	selectedStereotypes.retainAll(el.getStereotypes());
        }

        // Add all the stereotypes to the table
        for (Stereotype stereotype : selectedStereotypes) {
            List<Object> list = new ArrayList<Object>();
            list.add(new StereotypeItem(stereotype));
            list.add(deleteIcon);
            tableModel.addRow(list);
        }
        setDeleteColumnWidth(jTable);
    }

    /**
     * <p>
     * Updates the configured ModelElement's stereotypes properties with the given Set of stereotypes.
     * </p>
     *
     * @param newStereotypes the set of new stereotypes to be added
     * @throws IllegalArgumentException if newStereotypes is null or contains null element
     */
    private void notifyListeners(Set<Stereotype> newStereotypes) {
        ModelElement modelElement = getConfiguredModelElements().get(0);
        getPropertiesPanel().addStereotypes(newStereotypes, modelElement.getClass());
        for (ModelElement element : getConfiguredModelElements()) {
            getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.STEREOTYPES, PropertyOperation.MODIFY,
                newStereotypes);
        }

        refreshPanel();
    }

    /**
     * <p>
     * This class provides a modal <code>JDialog</code> to select stereotypes.
     * </p>
     *
     * <p>
     * The <code>JDialog</code> will provide a GUI for user to enter new stereotype and remove
     * stereotypes for the configured <code>ModelElement</code> instances.
     * </p>
     *
     * <p>
     * Thread-safety: this class is not thread-safe as it contains mutable data.
     * </p>
     *
     * @author ch_music, TCSDEVELOPER
     * @version 1.0
     */
    private class AddStereotypeJDialog extends JDialog {
        /**
         * <p>
         * The list of currently selected stereotype.
         * </p>
         *
         * <p>
         * Created in the constructor, the reference will not be modified afterwards.
         * </p>
         *
         * <p>
         * It will not be null. May be empty.
         * </p>
         */
        private final Set<Stereotype> currentSelectedStereotypes = new LinkedHashSet<Stereotype>();

        /**
         * <p>
         * The list of new added stereotype.
         * </p>
         * <p>
         * Created in the constructor, the reference will not be modified afterwards.
         * </p>
         * <p>
         * It will not be null. May be empty.
         * </p>
         */
        private final Set<Stereotype> newStereotypes = new LinkedHashSet<Stereotype>();


        /**
         * <p>
         * The <code>JCheckBox</code> used to indicate whether a custom stereotype should be
         * added as a selected stereotype or unselected.
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
        private final JCheckBox checkboxAddCustomStereotype;

        /**
         * <p>
         * The text field to specify the name of a custom stereotype to be created.
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
        private final JFormattedTextField textAddCustomStereotype;

        /**
         * <p>
         * The <code>CustomTableModel</code> used to display the stereotypes.
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
        private final CustomTableModel tableModelAddStereotype;

        /**
         * <p>
         * The <code>JTable</code> used to display the stereotypes.
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
        private final JTable tableAddStereotype;

        /**
         * <p>
         * Creates a new <code>AddStereotypeJDialog</code>.
         * </p>
         *
         * @param standardStereotypes the standard stereotypes to be displayed
         * @param selectedStereotypes the stereotypes that should be displayed as selected
         *
         * @throws IllegalArgumentException if any argument is null
         */
        public AddStereotypeJDialog(List<Stereotype> standardStereotypes, Collection<Stereotype> selectedStereotypes) {
            super((Frame) null, "Add/Remove stereotypes");
            Util.checkNull(standardStereotypes, "standardStereotypes");
            Util.checkNull(selectedStereotypes, "selectedStereotypes");

            setModal(true);
            setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 4;
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(new JLabel("Available stereotypes:"), constraints);

            // Creates the new JTable for displaying all the available stereotypes
            tableModelAddStereotype = new SteoreotypeCustomTableModel();
            initializeStereotypeTableModel(standardStereotypes, selectedStereotypes);
            tableAddStereotype = new JTable(tableModelAddStereotype);

            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 4;
            constraints.gridheight = 4;
            constraints.weightx = 1;
            constraints.weighty = 1;
            constraints.fill = GridBagConstraints.BOTH;
            tableAddStereotype.getTableHeader().setVisible(false);
            // wrap the JTable in a JScrollPane and add it to this JDialog.
            add(new JScrollPane(tableAddStereotype), constraints);

            // Initializes the GUI for adding of custom stereotype.
            // The check box to identify whether the new stereotype should be selected
            checkboxAddCustomStereotype = new JCheckBox();
            checkboxAddCustomStereotype.setSelected(true);
            constraints.gridx = 0;
            constraints.gridy = 5;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.NONE;
            add(checkboxAddCustomStereotype, constraints);

            // the JFormattedTextField to let user to enter the new stereotype name
            textAddCustomStereotype = new JFormattedTextField();
            constraints.gridx = 1;
            constraints.gridy = 5;
            constraints.gridwidth = 2;
            constraints.weightx = 1;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(textAddCustomStereotype, constraints);

            // the JButton to let user to submit the new stereotype
            JButton buttonAddCustomStereotype = createAddButton();
            constraints.gridx = 3;
            constraints.gridy = 5;
            constraints.gridwidth = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.NONE;
            add(buttonAddCustomStereotype, constraints);

            // Add Cancel and Accept buttons.
            JButton buttonCancel = createCancleButton();
            constraints.gridx = 2;
            constraints.gridy = 6;
            constraints.gridwidth = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.LINE_END;
            add(buttonCancel, constraints);

            JButton buttonAccept = createAcceptButton();
            constraints.gridx = 3;
            constraints.gridy = 6;
            constraints.gridwidth = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.NONE;
            add(buttonAccept, constraints);

            pack();
        }

        /**
         * <p>
         * This method creates the <b>Accept</b> button for this <code>JDialog</code>.
         * </p>
         *
         * @return the <b>Accept</b> button for this <code>JDialog</code>.
         */
        private JButton createAcceptButton() {
            JButton buttonAccept = new JButton("Accept");

            // Creates an ActionListener instance and assign it to the button
            buttonAccept.addActionListener(new ActionListener() {
                /**
                 * <p>
                 * Invoked when an action occurs.
                 * </p>
                 *
                 * <p>
                 * When the button is clicked, this method will be invoked.
                 * </p>
                 *
                 * @param event a semantic event which indicates that a component-defined action occurred.
                 */
                public void actionPerformed(ActionEvent e) {
                    ModelElement modelElement = getConfiguredModelElements().get(0);
                    getPropertiesPanel().addStereotypes(newStereotypes, modelElement.getClass());
                    // the modification is committed
                    notifyListeners(currentSelectedStereotypes);

                    // hide the dialog
                    setVisible(false);
                    dispose();
                }
            });

            return buttonAccept;
        }

        /**
         * <p>
         * This method creates the <b>Cancel</b> button for this <code>JDialog</code>.
         * </p>
         *
         * @return the <b>Cancel</b> button for this <code>JDialog</code>.
         */
        private JButton createCancleButton() {
            JButton buttonCancel = new JButton("Cancel");
            // Creates an ActionListener instance and assign it to the button
            buttonCancel.addActionListener(new ActionListener() {
                /**
                 * <p>
                 * Invoked when an action occurs.
                 * </p>
                 *
                 * <p>
                 * When the button is clicked, this method will be invoked.
                 * </p>
                 *
                 * @param event a semantic event which indicates that a component-defined action occurred.
                 */
                public void actionPerformed(ActionEvent e) {
                    // hide the dialog
                    setVisible(false);
                    dispose();
                }
            });

            return buttonCancel;
        }

        /**
         * <p>
         * This method creates the <b>Add</b> button for this <code>JDialog</code>.
         * </p>
         *
         * @return the <b>Add</b> button for this <code>JDialog</code>.
         */
        private JButton createAddButton() {
            JButton buttonAddCustomStereotype = new JButton("Add");

            // Creates an ActionListener instance and assign it to the button
            buttonAddCustomStereotype.addActionListener(new ActionListener() {
                /**
                 * <p>
                 * Invoked when an action occurs.
                 * </p>
                 *
                 * <p>
                 * When the button is clicked, this method will be invoked.
                 * </p>
                 *
                 * @param event a semantic event which indicates that a component-defined action occurred.
                 */
                public void actionPerformed(ActionEvent e) {
                    String name = textAddCustomStereotype.getText();
                    if (name.trim().equals("")) {
                        return;
                    }
                    for (int i = 0; i < tableModelAddStereotype.getRowCount(); ++i) {
                        if (((StereotypeItem) tableModelAddStereotype.getValueAt(i, 1)).toString().equals(name)) {
                            return;
                        }
                    }

                    Stereotype stereotype = new StereotypeImpl();
                    stereotype.setName(textAddCustomStereotype.getText());

                    // Add a new stereotype
                    List<Object> row = new ArrayList<Object>();
                    if (checkboxAddCustomStereotype.isSelected()) {
                        row.add(true);
                        currentSelectedStereotypes.add(stereotype);
                    } else {
                        row.add(false);
                    }
                    stereotype.setBaseClass(getPropertiesPanel().getMappingString(
                            getConfiguredModelElements().get(0).getClass()));
                    newStereotypes.add(stereotype);

                    row.add(new StereotypeItem(stereotype));
                    tableModelAddStereotype.addRow(row);
                    textAddCustomStereotype.setValue("");
                    checkboxAddCustomStereotype.setSelected(true);
                }
            });

            return buttonAddCustomStereotype;
        }

        /**
         * <p>
         * This method initializes the table model with all the available stereotypes.
         * </p>
         *
         * @param standardStereotypes the standard stereotypes to be displayed
         * @param selectedStereotypes the stereotypes that should be displayed as selected
         */
        private void initializeStereotypeTableModel(List<Stereotype> standardStereotypes,
            Collection<Stereotype> selectedStereotypes) {
            for (Stereotype stereotype : standardStereotypes) {
                List<Object> row = new ArrayList<Object>();
                if (isMatch(stereotype, selectedStereotypes)) {
                    row.add(true);
                    currentSelectedStereotypes.add(stereotype);
                } else {
                    row.add(false);
                }
                StereotypeItem item = new StereotypeItem(stereotype);
                row.add(item);
                tableModelAddStereotype.addRow(row);
            }
        }

        /**
         * <p>
         * Compares the name of the stereotype with all the names of the stereotype in
         * <code>selectedStereotypes</code>.
         * </p>
         *
         * <p>
         * If any match is found (two stereotypes with same name), then this method returns
         * true, otherwise false.
         * </p>
         *
         * @param stereotype the given <code>Stereotype</code> to do the match
         * @param selectedStereotypes the selected <code>Stereotype</code> collection
         * @return true if any <code>Stereotype</code> in the given <code>selectedStereotypes</code>
         * matches the given <code>stereotype</code>, false otherwise
         */
        private boolean isMatch(Stereotype stereotype, Collection<Stereotype> selectedStereotypes) {
            // Compare the name of the stereotype with
            // all the names of the stereotype in selectedStereotypes:
            String name = stereotype.getName();
            if (name == null) {
                return false;
            }

            for (Stereotype s : selectedStereotypes) {
                if (name.equals(s.getName())) {
                    return true;
                }
            }

            return false;
        }

        /**
         * <p>
         * This is an inner class and it extends <code>CustomTableModel</code> class to be acted
         * as a table model for the <code>tableAddStereotype</code>.
         * </p>
         *
         * <p>
         * Thread Safety : this is not thread safe as its super class is not thread safe.
         * </p>
         *
         * @author ch_music, TCSDEVELOPER
         * @version 1.0
         */
        private class SteoreotypeCustomTableModel extends CustomTableModel {
            /**
             * <p>
             * Returns whether the cell is editable.
             * </p>
             *
             * <p>
             * The cells for the first column in this table model are editable, other cells are not editable.
             * </p>
             *
             *  @param row the row being queried
             *  @param col the column being queried
             *  @return true if its the cells for the first column, false for other cells.
             */
            public boolean isCellEditable(int row, int col) {
                return col == 0;
            }

            /**
             * <p>
             * This method is invoked when the value for the given cell is changed.
             * </p>
             *
             * <p>
             * Only the cells for the first column in this table model are editable and
             * the value must be of <code>Boolean</code> type.
             * </p>
             *
             * @param value value to assign to cell, must be of <code>Boolean</code> type
             * @param row row of cell
             * @param col column of cell
             */
            public void setValueAt(Object value, int row, int col) {
                List<Object> rowData = getInternalDataStorage().get(row);

                // only col == 0 is editable, update the cell value
                rowData.remove(0);
                rowData.add(0, value);

                // store the changes
                StereotypeItem item = (StereotypeItem) rowData.get(1);
                if (value.equals(false)) {
                    currentSelectedStereotypes.remove(item.getStereotype());
                } else {
                    currentSelectedStereotypes.add(item.getStereotype());
                }
            }
        };
    }
}

