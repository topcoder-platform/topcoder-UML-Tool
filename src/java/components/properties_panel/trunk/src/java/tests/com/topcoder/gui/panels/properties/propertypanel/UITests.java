/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.SwingDemo;
import com.topcoder.gui.panels.properties.TestHelper;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.eventdata.JTableMouseEventData;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.AbstractButtonFinder;
import junit.extensions.jfcunit.finder.ComponentFinder;
import junit.extensions.jfcunit.finder.DialogFinder;
import junit.extensions.jfcunit.finder.JLabelFinder;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for UI related stuff in this component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UITests extends JFCTestCase {
    /**
     * <p>
     * The SwingDemo instance for helping testing.
     * </p>
     */
    private SwingDemo frame;

    /**
     * <p>
     * The configure JButton for helping testing.
     * </p>
     */
    private JButton configureBtn;

    /**
     * <p>
     * The PropertiesPanel instance for helping testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfigurations();

        frame = new SwingDemo();
        frame.pack();
        frame.setVisible(true);

        configureBtn = frame.getConfigureButton();
        propertiesPanel = frame.getPropertiesPanel();

        flushAWT();
        setHelper(new JFCTestHelper());
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();

        frame.setVisible(false);
        frame.dispose();
        frame = null;
        configureBtn = null;
        propertiesPanel = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(UITests.class);
    }

    /**
     * <p>
     * This test case clicks the add button for the StereotypeListPropertyPanel.
     * </p>
     *
     * <p>
     * A pop-up dialog should be shown.
     * </p>
     */
    public void testStereotypeListPropertyPanel_NewButton() {
        JCheckBox checkBox = frame.getCheckBoxes()[0];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JButton addBtn = (JButton) new ComponentFinder(JButton.class).find(panel, 0);

        getHelper().enterClickAndLeave(new MouseEventData(this, addBtn));

        List dialogs = new DialogFinder(null).findAll();
        assertEquals("The dialog should be displayed.", 1, dialogs.size());

        JFCTestHelper.disposeWindow((JDialog) dialogs.get(0), this);
    }

    /**
     * <p>
     * This test case clicks the accept button inside new stereotype dialog.
     * </p>
     *
     * <p>
     * The pop-up dialog should be hidden and the event should be sent out.
     * </p>
     */
    public void testNewStereotypeDialog_AcceptButton() {
        JCheckBox checkBox = frame.getCheckBoxes()[0];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JButton addBtn = (JButton) new ComponentFinder(JButton.class).find(panel, 0);

        getHelper().enterClickAndLeave(new MouseEventData(this, addBtn));

        List dialogs = new DialogFinder(null).findAll();
        assertEquals("The dialog should be displayed.", 1, dialogs.size());
        JDialog dialog = (JDialog) dialogs.get(0);

        JButton acceptBtn = (JButton) new AbstractButtonFinder("Accept").find(dialog, 0);

        getHelper().enterClickAndLeave(new MouseEventData(this, acceptBtn));
    }

    /**
     * <p>
     * This test case clicks the cancel button inside new stereotype dialog.
     * </p>
     *
     * <p>
     * The pop-up dialog should be hidden and no event will be sent out.
     * </p>
     */
    public void testNewStereotypeDialog_CancleButton() {
        JCheckBox checkBox = frame.getCheckBoxes()[0];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JButton addBtn = (JButton) new ComponentFinder(JButton.class).find(panel, 0);

        getHelper().enterClickAndLeave(new MouseEventData(this, addBtn));

        List dialogs = new DialogFinder(null).findAll();
        assertEquals("The dialog should be displayed.", 1, dialogs.size());
        JDialog dialog = (JDialog) dialogs.get(0);

        JButton cancelBtn = (JButton) new AbstractButtonFinder("Cancel").find(dialog, 0);

        getHelper().enterClickAndLeave(new MouseEventData(this, cancelBtn));
    }

    /**
     * <p>
     * This test case clicks the add button inside new stereotype dialog.
     * </p>
     *
     * <p>
     * A new stereotype should be added and the corresponding event should be sent.
     * </p>
     */
    public void testNewStereotypeDialog_AddButton() {
        JCheckBox checkBox = frame.getCheckBoxes()[0];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JButton addBtn = (JButton) new ComponentFinder(JButton.class).find(panel, 0);

        getHelper().enterClickAndLeave(new MouseEventData(this, addBtn));

        List dialogs = new DialogFinder(null).findAll();
        assertEquals("The dialog should be displayed.", 1, dialogs.size());
        JDialog dialog = (JDialog) dialogs.get(0);

        JButton btn = (JButton) new AbstractButtonFinder("Add").find(dialog, 0);
        JFormattedTextField textField = (JFormattedTextField) new ComponentFinder(JFormattedTextField.class).find(
            dialog, 0);
        JCheckBox cb = (JCheckBox) new ComponentFinder(JCheckBox.class).find(dialog, 0);

        // test the case when the check box is selected
        cb.setSelected(true);
        textField.setText("new_stereotype_selected");
        getHelper().enterClickAndLeave(new MouseEventData(this, btn));

        // test the case when the check box is un-selected
        cb.setSelected(false);
        textField.setText("new_stereotype_unselected");
        getHelper().enterClickAndLeave(new MouseEventData(this, btn));

        JFCTestHelper.disposeWindow(dialog, this);
    }

    /**
     * <p>
     * This test case clicks the delete button for the StereotypeListPropertyPanel.
     * </p>
     *
     * <p>
     * The stereotype should be removed.
     * </p>
     */
    public void testStereotypeListPropertyPanel_DeleteButton() {
        JCheckBox checkBox = frame.getCheckBoxes()[0];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JTable table = (JTable) new ComponentFinder(JTable.class).find(panel, 0);

        getHelper().enterClickAndLeave(new JTableMouseEventData(this, table, 0, 1, 1));

        assertEquals("The stereotype should be removed.", 0, table.getRowCount());

    }

    /**
     * <p>
     * This test case adds a valid item for the MultiplicityPropertyPanel.
     * </p>
     *
     * <p>
     * The item should be added.
     * </p>
     */
    public void testMultiplicityPropertyPanel_ValidNewRangeValue() {
        JCheckBox checkBox = frame.getCheckBoxes()[5];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(0);
        JComboBox comboBox = (JComboBox) new ComponentFinder(JComboBox.class).find(panel, 1);

        comboBox.setSelectedItem("3..5,*,5");

        assertEquals("Failed to update the combo box.", 2, comboBox.getItemCount());
    }

    /**
     * <p>
     * This test case adds a invalid item for the MultiplicityPropertyPanel.
     * </p>
     *
     * <p>
     * The item should not be added.
     * </p>
     */
    public void testMultiplicityPropertyPanel_InValidNewRangeValue() {
        JCheckBox checkBox = frame.getCheckBoxes()[5];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(0);
        JComboBox comboBox = (JComboBox) new ComponentFinder(JComboBox.class).find(panel, 1);

        comboBox.setSelectedItem("5s");

        assertEquals("Failed to update the combo box.", 1, comboBox.getItemCount());
    }

    /**
     * <p>
     * This test case clicks the new button for the ParameterListPropertyPanel.
     * </p>
     *
     * <p>
     * A new parameter should be created and the corresponding event should be sent out.
     * </p>
     */
    public void testParameterListPropertyPanel_NewParameter() {
        JCheckBox checkBox = frame.getCheckBoxes()[6];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JButton addBtn = (JButton) new ComponentFinder(JButton.class).find(panel, 0);

        getHelper().enterClickAndLeave(new MouseEventData(this, addBtn));
    }

    /**
     * <p>
     * This test case clicks the delete button for the ParameterListPropertyPanel.
     * </p>
     *
     * <p>
     * The parameter should be removed and the corresponding event should be sent out.
     * </p>
     */
    public void testParameterListPropertyPanel_DeleteParameter() {
        JCheckBox checkBox = frame.getCheckBoxes()[6];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JTable table = (JTable) new ComponentFinder(JTable.class).find(panel, 1);

        getHelper().enterClickAndLeave(new JTableMouseEventData(this, table, 0, 1, 1));

        assertEquals("The parameter should be removed.", 0, table.getRowCount());
    }

    /**
     * <p>
     * This test case clicks the delete return value button for the ParameterListPropertyPanel.
     * </p>
     *
     * <p>
     * A confirm box should be displayed.
     * </p>
     * @since 1.1
     */
    public void testParameterListPropertyPanel_DeleteReturnValueDialog() {
        JCheckBox checkBox = frame.getCheckBoxes()[6];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JTable table = (JTable) new ComponentFinder(JTable.class).find(panel, 0);

        // click delete return value
        getHelper().enterClickAndLeave(new JTableMouseEventData(this, table, 0, 1, 1));

        // A confirm box should be displayed.
        List dialogs = new DialogFinder(null).findAll();
        assertEquals("The dialog should be displayed.", 1, dialogs.size());

    }

    /**
     * <p>
     * This test case clicks the delete return value button for the ParameterListPropertyPanel.
     * </p>
     *
     * <p>
     * If user clicks 'Yes', the return parameter should be delete.
     * </p>
     * @since 1.1
     */
    public void testParameterListPropertyPanel_DeleteReturnValueYes() {
        JCheckBox checkBox = frame.getCheckBoxes()[6];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JTable table = (JTable) new ComponentFinder(JTable.class).find(panel, 0);

        // click delete return value
        getHelper().enterClickAndLeave(new JTableMouseEventData(this, table, 0, 1, 1));

        // get the confirm dialog
        JDialog dialog = (JDialog) new DialogFinder(null).findAll().get(0);
        // get the yes button
        JButton yesButton = (JButton) new AbstractButtonFinder((String) null).find(dialog, 0);
        // click yes button
        getHelper().enterClickAndLeave(new MouseEventData(this, yesButton));

        // return parameter should be removed
        assertEquals("The return parameter should be removed.", 0, table.getRowCount());
    }

    /**
     * <p>
     * This test case clicks the delete return value button for the ParameterListPropertyPanel.
     * </p>
     *
     * <p>
     * If user clicks 'No', the return parameter should not be delete.
     * </p>
     * @since 1.1
     */
    public void testParameterListPropertyPanel_DeleteReturnValueNo() {
        JCheckBox checkBox = frame.getCheckBoxes()[6];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(1);
        JTable table = (JTable) new ComponentFinder(JTable.class).find(panel, 0);

        // click delete return value
        getHelper().enterClickAndLeave(new JTableMouseEventData(this, table, 0, 1, 1));

        // get the confirm dialog
        JDialog dialog = (JDialog) new DialogFinder(null).findAll().get(0);
        // get the yes button
        JButton noButton = (JButton) new AbstractButtonFinder((String) null).find(dialog, 1);
        // click no button
        getHelper().enterClickAndLeave(new MouseEventData(this, noButton));

        // return parameter should not be removed
        assertEquals("The return parameter should not be removed.", 1, table.getRowCount());
    }

    /**
     * <p>
     * This test case shows the use case view.
     * </p>
     *
     * <p>
     * The name property should be correct.
     * </p>
     * @since 1.1
     */
    public void testUseCasePanel() {
        JCheckBox checkBox = frame.getCheckBoxes()[14];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(0);

        JFormattedTextField nameField =
            (JFormattedTextField) new ComponentFinder(JFormattedTextField.class).find(panel, 0);
        assertEquals("The name property is wrong",
            "Properties Panel UseCase", nameField.getText());

    }

    /**
     * <p>
     * This test case selects multiple elements.
     * </p>
     *
     * <p>
     * Only the common property panel should be displayed.
     * </p>
     * @since 1.1
     */
    public void testMultipleSelection() {
        // select the package, interface and class
        frame.getCheckBoxes()[0].setSelected(true);
        frame.getCheckBoxes()[1].setSelected(true);
        frame.getCheckBoxes()[2].setSelected(true);

        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(0);

        JFormattedTextField nameField =
            (JFormattedTextField) new ComponentFinder(JFormattedTextField.class).find(panel, 0);
        assertEquals("the name property should be empty", "", nameField.getText());

    }

    /**
     * <p>
     * This test case clicks the two association end labels inside AssociationEndsPropertyPanel.
     * </p>
     *
     * <p>
     * The properties panel should be configured with the association end model element and
     * the corresponding event should be sent out.
     * </p>
     */
    public void testAssociationEndsPropertyPanel() {
        JCheckBox checkBox = frame.getCheckBoxes()[11];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(0);

        // click the first association end
        JLabel lable = (JLabel) new JLabelFinder("Start").find(panel, 0);
        getHelper().enterClickAndLeave(new MouseEventData(this, lable));

        // configure the panel with the Association model element again
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        // click the second association end
        lable = (JLabel) new JLabelFinder("End").find(panel, 0);
        getHelper().enterClickAndLeave(new MouseEventData(this, lable));

    }

    /**
     * <p>
     * This test case clicks all the check boxes inside ModifiersPropertyPanel.
     * </p>
     *
     * <p>
     * The corresponding event should be sent out.
     * </p>
     */
    public void testModifiersPropertyPanel() {
        JCheckBox checkBox = frame.getCheckBoxes()[2];

        checkBox.setSelected(true);
        getHelper().enterClickAndLeave(new MouseEventData(this, configureBtn));

        JPanel panel = (JPanel) propertiesPanel.getComponent(0);
        JPanel modifierPanel = (JPanel) panel.getComponent(1);
        List modifierCheckBoxes = new ComponentFinder(JCheckBox.class).findAll(modifierPanel);

        for (Object comp : modifierCheckBoxes) {
            JCheckBox modifierCheckBox = (JCheckBox) comp;
            modifierCheckBox.setSelected(true);
            modifierCheckBox.setSelected(false);
        }
    }
}

