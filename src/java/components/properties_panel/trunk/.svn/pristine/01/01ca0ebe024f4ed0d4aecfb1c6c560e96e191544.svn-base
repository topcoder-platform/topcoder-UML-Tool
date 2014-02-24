/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * This class provides a property panel GUI for displaying of <code>Parameter</code> list.
 * </p>
 *
 * <p>
 * The class displays the <code>Parameter</code> in a <code>JTable</code> with a delete button
 * next to each parameter.
 * </p>
 *
 * <p>
 * There is also an add new <code>Parameter</code> button.
 * </p>
 *
 * <p>
 * The class handles all the logic for adding and deleting <code>Parameter</code>.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 * <p>
 * V1.1 Change Note: the new layout is used as the prototype.
 * Note that the "Return" value is separated from the rest of the elements in the grid.
 * This is needed to differentiate the return value from the rest of the parameters.
 * The only difference is that when clicking this "X", instead of immediately deleting the return value,
 * a confirmation dialog is displayed that states
 * "Are you sure you want to delete the return value for this operation?"
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class ParameterListPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * The <code>CustomTableModel</code> containing the <code>Parameter</code> data.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     *
     * @since 1.1
     */
    private final CustomTableModel parameterTableModel;

    /**
     * <p>
     * The <code>CustomTableModel</code> containing the return parameter data.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     *
     * @since 1.1
     */
    private final CustomTableModel returnTableModel;

    /**
     * <p>
     * The <code>JTable</code> containing the <code>Parameter</code>.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     *
     * @since 1.1
     */
    private final JTable parameterTable;


    /**
     * <p>
     * The <code>JTable</code> containing the return parameter.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     *
     * @since 1.1
     */
    private final JTable returnTable;

    /**
     * <p>
     * The add button to add new <code>Parameter</code>.
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
    private final JButton buttonAddParameter;

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
     * Creates a new <code>ParametersListPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this class
     * @param deleteIcon the icon used for the delete button
     * @param addIcon the icon used for the add button
     *
     * @throws IllegalArgumentException if any of the argument is null
     */
    public ParameterListPropertyPanel(PropertiesPanel propertiesPanel, Icon deleteIcon, Icon addIcon) {
        super(Collections.singletonList(PropertyKind.PARAMETERS), propertiesPanel);

        Util.checkNull(deleteIcon, "deleteIcon");
        Util.checkNull(addIcon, "addIcon");

        this.deleteIcon = deleteIcon;

        returnTableModel = new CustomTableModel();
        returnTable = new JTable(returnTableModel);

        parameterTableModel = new CustomTableModel();
        parameterTable = new JTable(parameterTableModel);

        // Add MouseListener to the tables
        returnTable.addMouseListener(new TableMouseAdapter(returnTable, returnTableModel));
        parameterTable.addMouseListener(new TableMouseAdapter(parameterTable, parameterTableModel));

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());

        buttonAddParameter = new JButton(addIcon);
        buttonAddParameter.setToolTipText("Add Parameter");

        // Creates an ActionListener instance and assign it to the button
        buttonAddParameter.addActionListener(new ActionListener() {
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
                // Create a new parameter
                Parameter param = new ParameterImpl();
                int paramNum = 1;
                for (Parameter parameter : ((Operation) getConfiguredModelElements().get(0)).getParameters()) {
                    if (parameter.getKind() != ParameterDirectionKind.RETURN) {
                        paramNum++;
                    }
                }
                param.setName("param" + paramNum);

                Classifier classifier = null;
                UMLModelManager manager = UMLModelManager.getInstance();
                ProjectConfigurationManager configManager = manager.getProjectConfigurationManager();
                Model root = manager.getModel();

                // traverse all the model elements owned by the root model
                for (ModelElement modelElement : root.getOwnedElements()) {
                    if (modelElement instanceof Classifier) {
                        if (modelElement.getName().equals("int")) {
                            classifier = (Classifier) modelElement;
                            break;
                        }
                    }
                }

                if (classifier == null) {
                    String language = manager.getProjectLanguage();
                    if (language != null && language.trim().length() != 0) {
                        for (Namespace namespace : configManager.getStandardNamespaces(language)) {
                            if (namespace instanceof Classifier) {
                                if (namespace.getName().equals("int")) {
                                    classifier = (Classifier) namespace;
                                }
                            }
                        }
                    }
                }
                param.setType(classifier);

                param.setKind(ParameterDirectionKind.INOUT);
                param.setBehavioralFeature((Operation) getConfiguredModelElements().get(0));

                // notify the listeners about the change
                for (ModelElement element : getConfiguredModelElements()) {
                    getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.PARAMETERS,
                        PropertyOperation.ADD, param);
                }

                // configure the properties with the new Parameter
                getPropertiesPanel().configurePanel(param);
                getPropertiesPanel().fireSelectionChangeEvent(param);
            }
        });

        populateTabelPanel(panel, "Parameters", buttonAddParameter, new JTable[]{  parameterTable, returnTable });

    }

    /**
     * <p>
     * Executes the logic for <code>ParametersListPropertyPanel</code>.
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
     *
     **/
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        List<Parameter> parameters = ((Operation) getConfiguredModelElements().get(0)).getParameters();
        parameterTableModel.removeAllRow();
        returnTableModel.removeAllRow();

        // Add all the parameters to the tables
        for (Parameter param : parameters) {
            List<Object> list = new ArrayList<Object>();
            list.add(new ParameterItem(param));
            list.add(deleteIcon);
            if (param.getKind() == ParameterDirectionKind.RETURN) {
                returnTableModel.addRow(list);
            } else {
                parameterTableModel.addRow(list);
            }

        }

        setDeleteColumnWidth(returnTable);
        setDeleteColumnWidth(parameterTable);


    }

    /**
     * <p>
     * This class provides wrapper over <code>Parameter</code> class so that it can easily be displayed
     * in a <code>JList</code> while maintaining the ease of retrieval of the corresponding
     * <code>Parameter</code> instance.
     * </p>
     *
     * <p>
     * Thread-safety: This class is immutable, therefore it is thread-safe.
     * </p>
     *
     * @author ch_music, TCSDEVELOPER
     * @version 1.0
     */
    private class ParameterItem {
        /**
         * <p>
         * The wrapped <code>Parameter</code> instance.
         * </p>
         *
         * <p>
         * Set in the constructor and will not be changed afterwards.
         * </p>
         *
         * <p>
         * Will not be null.
         * </p>
         */
        private final Parameter parameter;

        /**
         * <p>
         * The text to be displayed in the <code>JList</code>.
         * </p>
         *
         * <p>
         * Set in the constructor and will not be modified afterwards. Will not be null.
         * </p>
         */
        private final String presentationName;

        /**
         * <p>
         * Creates a new <code>ParameterItem</code> to wrap the given <code>Parameter</code> instance.
         * </p>
         *
         * @param parameter the parameter to be wrapped
         * @throws IllegalArgumentException if parameter is null
         */
        public ParameterItem(Parameter parameter) {
            Util.checkNull(parameter, "parameter");

            this.parameter = parameter;
            this.presentationName = parameter.getName();
        }

        /**
         * <p>
         * Retrieves the wrapped <code>Parameter</code> object.
         * </p>
         *
         * @return the wrapped Parameter object
         */
        public Parameter getParameter() {
            return parameter;
        }

        /**
         * <p>
         * Returns the string representation of the wrapped <code>Parameter</code>.
         * </p>
         *
         * @return the string representation of the wrapped Parameter
         */
        public String toString() {
            return presentationName;
        }
    }


    /**
     * <p>
     * This adapter receives the mouse event from a <code>JTable</code> instance.
     * Parameters could be selected or deleted.
     * </p>
     * @author TCSDEVELOPER
     * @version 1.1
     */
    private class TableMouseAdapter extends MouseAdapter {

        /**
         * <p>The <code>JTable</code> instance that receives the event.</p>
         */
        private final JTable table;

        /**
         * <p>The <code>CustomTableModel</code> behind the table.</p>
         */
        private final CustomTableModel tableModel;

        /**
         * <p>
         * Constructor with table and table model.
         * </p>
         * @param table The <code>JTable</code> instance that receives the event.
         * @param tableModel The <code>CustomTableModel</code> behind the table.
         */
        public TableMouseAdapter(JTable table, CustomTableModel tableModel) {
            this.table = table;
            this.tableModel = tableModel;
        }

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
            int column = table.getSelectedColumn();
            int row = table.getSelectedRow();

            // no selection, return directly
            if (column == -1 || row == -1) {
                return;
            }

            ParameterItem item = (ParameterItem) tableModel.getValueAt(row, 0);
            Parameter param = item.getParameter();
            if (column == 1) {
                // a confirm message box is pop up when deleting a return value.
                if (param.getKind() != ParameterDirectionKind.RETURN
                    || JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
                        table.getRootPane(),
                        "Are you sure you want to delete the\nreturn value for this operation?",
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE)) {

                    // notify the listeners about the change
                    for (ModelElement element : getConfiguredModelElements()) {
                        getPropertiesPanel().firePropertyChangeEvent(element, PropertyKind.PARAMETERS,
                            PropertyOperation.REMOVE, param);
                    }
                    // remove the Parameter
                    tableModel.removeRow(row);
                }
            } else {
                // configure the properties with the selected Parameter
                getPropertiesPanel().configurePanel(param);
                //getPropertiesPanel().fireSelectionChangeEvent(param);
            }
        }

    }
}