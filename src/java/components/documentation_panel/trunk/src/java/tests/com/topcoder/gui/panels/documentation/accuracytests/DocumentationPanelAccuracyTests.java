/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ DocumentationPanelAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.DocumentationEditor;
import com.topcoder.gui.panels.documentation.DocumentationPanel;
import com.topcoder.gui.panels.documentation.TagEditor;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


/**
 * <p>
 * The <code>DocumentationPanel</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>DocumentationPanel</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class DocumentationPanelAccuracyTests extends JFCTestCase {
    /**
    * <p>
    * Represents the config file used for test by the ConfigManager.
    * </p>
    */
    private static final String CONFIG_FILE = "accuracytests/docPanel.xml";

    /**
    * <p>
    * Represents the property <code>namespace</code> of DocumentationPanel.
    * It is used for getting the value under the <code>namespace</code> by the ConfigManager.
    * </p>
    */
    private static final String NAMESPACE = "docPanelNamespace";

    /**
     * <p>
     * The instance of <code>DocumentationPanel</code> for test.
     * </p>
     */
    private DocumentationPanel panel = null;

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
     * Test suite of <code>DocumentationPanelAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DocumentationPanelAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DocumentationPanelAccuracyTests.class);
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
     * Accuracy Test of the <code>DocumentationPanel(String)</code> constructor.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testconstructor() throws Exception {
        panel = new DocumentationPanel(NAMESPACE);

        JFrame frame = new JFrame();
        frame.add(panel);

        // set the JFrame to visible.
        frame.setVisible(true);

    }

    /**
     * <p>
     * Accuracy Test of the <code>DocumentationPanel(DocumentationEditor, TagEditor)</code> constructor.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testconstructor_Complex() throws Exception {
        TestHelper.clearConfig();

        // load XML file used to creat DocumentationEditor.
        cm.add("accuracytests/defaultDocEditor.xml");

        // load XML file used to creat TagEditor.
        cm.add("accuracytests/defaultTagEditor.xml");

        DocumentationEditor docEditor = new DefaultDocumentationEditor(
                "defaultDocEditor");
        TagEditor tagEditor = new DefaultTagEditor("defaultTagEditor");

        panel = new DocumentationPanel(docEditor, tagEditor);

        JFrame frame = new JFrame();
        frame.add(panel);

        // set the JFrame to visible.
        frame.setVisible(true);

    }

    /**
     * <p>
     * Accuracy Test of the <code>setTarget(ModelElement)</code> method.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testsetTarget() throws Exception {
        panel = new DocumentationPanel(NAMESPACE);
        element.addTaggedValue(TestHelper.getTaggedValueWithTagType(
                "documentation#newTag", "Accuracy Tests"));

        // set the ModelElement.
        panel.setTarget(element);

        JFrame frame = new JFrame();
        frame.add(panel);

        // set the JFrame to visible.
        frame.setVisible(true);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(panel);
        JTable table = getTagTable(panel);

        //check the line wrapping policy of the text area
        assertTrue("The text area is set to true.", textArea.getLineWrap());

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "", textArea.getText());

        // get the row number to check the constructor.
        assertEquals("The tag table has 2 row.", 2, table.getRowCount());

        // get the row name to check the constructor.
        assertEquals("The row name excepted to be equal.", "Tag",
            table.getColumnName(0));
        assertEquals("The tag table is not setted incorrect.", "Documentation",
            table.getColumnName(1));

        // check the combo box.
        DefaultCellEditor editor = (DefaultCellEditor) table.getColumnModel()
                                                            .getColumn(0)
                                                            .getCellEditor();
        JComboBox comboBox = (JComboBox) editor.getComponent();
        assertEquals("The comboBox has 5 items.", 5, comboBox.getItemCount());
    }

    /**
     * <p>
     * Helper method uesd to get the JTextArea from the given DocumentationPanel.
     * </p>
     *
     * @param panel DocumentationPanel contains the JTextArea.
     *
     * @return the JTextArea in the given DocumentationPanel.
     */
    public JTextArea getTextArea(DocumentationPanel panel) {
        //  find the JTextArea.
        JSplitPane splitPane = (JSplitPane) panel.getComponent(0);
        JPanel docEditor = (JPanel) splitPane.getLeftComponent();
        JScrollPane leftPane = (JScrollPane) docEditor.getComponent(0);
        JTextArea textArea = (JTextArea) leftPane.getViewport().getView();

        // set name for the JTextArea component.
        textArea.setName("myTextArea");

        // using finder to find the JTextArea.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class,
                "myTextArea");
        JTextArea getTextArea = (JTextArea) finder.find(docEditor, 0);

        return getTextArea;
    }

    /**
     * <p>
     * Helper method uesd to get the JTable from the given DocumentationPanel.
     * </p>
     *
     * @param panel DocumentationPanel contains the JTable.
     *
     * @return the JTable in the given DocumentationPanel.
     */
    public JTable getTagTable(DocumentationPanel panel) {
        // find the JTable.
        JSplitPane splitPane = (JSplitPane) panel.getComponent(0);
        JPanel tagEditor = (JPanel) splitPane.getRightComponent();
        JScrollPane rightPane = (JScrollPane) tagEditor.getComponent(0);
        JTable tagTable = (JTable) rightPane.getViewport().getView();

        // set name for the JTable component.
        tagTable.setName("myTable");

        // using finder to find the JTextArea.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class,
                "myTable");
        JTable getTagTable = (JTable) finder.find(tagEditor, 0);

        return getTagTable;
    }
}
