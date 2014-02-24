/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ DefaultTagEditorAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.plugins.DefaultTagEditor;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

import com.topcoder.util.config.ConfigManager;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import junit.framework.Test;
import junit.framework.TestSuite;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * <p>
 * The <code>DefaultTagEditor</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>DefaultTagEditor</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class DefaultTagEditorAccuracyTests extends JFCTestCase {
    /**
    * <p>
    * Represents the config file used for test by the ConfigManager.
    * </p>
    */
    private static final String CONFIG_FILE = "accuracytests/defaultTagEditor.xml";

    /**
    * <p>
    * Represents the property <code>namespace</code> of DefaultDocumentationEditor.
    * It is used for getting the value under the <code>namespace</code> by the ConfigManager.
    * </p>
    */
    private static final String NAMESPACE = "defaultTagEditor";

    /**
     * <p>
     * The instance of <code>DefaultTagEditor</code> for test.
     * </p>
     */
    private DefaultTagEditor tagEditor = null;

    /**
     * <p>
     * The instance of <code>ModelElement</code> for test.
     * </p>
     */
    private ModelElement element = null;

    /**
     * <p>
     * The instance of <code>ConfigManager</code> for test.
     * </p>
     */
    private ConfigManager cm = null;

    /**
     * <p>
     * Test suite of <code>DefaultTagEditorAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DefaultTagEditorAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DefaultTagEditorAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    protected void setUp() throws Exception {
        // choose the text Helper.
        super.setUp();
        setHelper(new JFCTestHelper());
        TestHelper.clearConfig();
        cm = ConfigManager.getInstance();

        // load XML file used to creat DefaultDocumentationEditor.
        cm.add(CONFIG_FILE);
        element = new OperationImpl();
    }

    /**
     * <p>
     * Accuracy Test of the <code>DefaultTagEditor(String)</code> constructor.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testconstructor() throws Exception {
        tagEditor = new DefaultTagEditor(NAMESPACE);

        // using the helper method to find the JTextArea.
        JTable table = getTagTable(tagEditor);

        // get the row number to check the constructor.
        assertEquals("The tag table has 1 row.", 1, table.getRowCount());

        // get the row name to check the constructor.
        assertEquals("The row name excepted to be equal.", "Tag",
            table.getColumnName(0));
        assertEquals("The tag table is not setted incorrect.", "Documentation",
            table.getColumnName(1));
    }

    /**
     * <p>
     * Accuracy Test of the <code>DefaultTagEditor(String)</code> constructor.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testconstructor_Config() throws Exception {
        TestHelper.clearConfig();

        // load XML file used to creat DefaultTagEditor.
        cm.add("accuracytests/defaultTagEditor_Config.xml");
        tagEditor = new DefaultTagEditor(NAMESPACE);

        // using the helper method to find the JTextArea.
        JTable table = getTagTable(tagEditor);

        // get the row number to check the constructor.
        assertEquals("The tag table has 1 row.", 1, table.getRowCount());

        // get the row name to check the constructor.
        assertEquals("The row name excepted to be equal.", "my new tag",
            table.getColumnName(0));
        assertEquals("The tag table is not setted incorrect.", "my new doc",
            table.getColumnName(1));
    }

    /**
     * <p>
     * Accuracy Test of the <code>setTarget(ModelElement)</code> method.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testsetTarget() throws Exception {
        tagEditor = new DefaultTagEditor(NAMESPACE);
        element.addTaggedValue(TestHelper.getTaggedValueWithTagType(
                "documentation#newTag", "Accuracy Tests"));

        // set the ModelElement.
        tagEditor.setTarget(element);

        // using the helper method to find the JTable.
        JTable table = getTagTable(tagEditor);

        // get the row number to check the constructor.
        assertEquals("The tag table has 1 row.", 2, table.getRowCount());

        // get the row name to check the constructor.
        assertEquals("The row name excepted to be equal.", "Tag",
            table.getColumnName(0));
        assertEquals("The tag table is not setted incorrect.", "Documentation",
            table.getColumnName(1));

        // check the combo box.
        DefaultCellEditor editor = (DefaultCellEditor) table.getColumnModel().getColumn(0)
                                                                  .getCellEditor();
        JComboBox comboBox = (JComboBox) editor.getComponent();
        assertEquals("The comboBox has 5 items.", 5, comboBox.getItemCount());
    }


    /**
     * <p>
     * Helper method uesd to get the JTable from the given DefaultTagEditor.
     * </p>
     *
     * @param tagEditor DefaultTagEditor contains the JTable.
     *
     * @return the JTable in the given DefaultTagEditor.
     */
    public JTable getTagTable(DefaultTagEditor tagEditor) {
        // add the docEditor into a frame.
        JFrame frame = new JFrame();
        frame.add(tagEditor);

        // set the JFrame
        frame.setVisible(true);

        // find the JTextArea.
        JScrollPane scroll = (JScrollPane) tagEditor.getComponent(0);
        JTable tagTable = (JTable) scroll.getViewport().getView();

        // set name for the JTable component.
        tagTable.setName("myTable");

        // using finder to find the JTextArea.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class,
                "myTable");
        JTable getTagTable = (JTable) finder.find(tagEditor, 0);

        return getTagTable;
    }
}
