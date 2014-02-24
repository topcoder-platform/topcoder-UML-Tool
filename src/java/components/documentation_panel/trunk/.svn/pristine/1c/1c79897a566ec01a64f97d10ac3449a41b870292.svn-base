/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.stresstests;

import com.topcoder.gui.panels.documentation.DocumentationPanel;


import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

import com.topcoder.util.config.ConfigManager;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;

import junit.extensions.jfcunit.finder.NamedComponentFinder;

import junit.framework.Test;
import junit.framework.TestSuite;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


/**
 * <p>This class tests the <code>DocumentationPanel</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>DocumentationPanel</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class DocumentationPanelStressTest extends JFCTestCase {
    /**
     * <p>The default config file path of <code>DefaultDocumentationEditor</code> for test.</p>
     */
    private static final String DOC_PANEL_CONFIG_FILE = "stresstests/DocPanelConfig.xml";

    /**
     * <p>The config namespace of <code>DocumentationPanel</code> for test.</p>
     */
    private static final String DOC_PANEL_NAMESPACE = "DocPanel_Namespace";

    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 10;

    /**
     * <p>The instance of <code>Operation</code> for test.</p>
     */
    private Operation operation = null;

    /**
     * <p>The instance of <code>ModelElement</code> for test.</p>
     */
    private ModelElement methodImpl = null;

    /**
     * <p>The instance of <code>TaggedValue</code> for test.</p>
     */
    private TaggedValue opDoc = null;

    /**
     * <p>The instance of <code>TaggedValue</code> for test.</p>
     */
    private TaggedValue methodDoc = null;

    /**
     * <p>The list of <code>SimpleTagListener</code> for test.</p>
     */
    private List<SimpleTagListener> tagListeners = new ArrayList<SimpleTagListener>();

    /**
     * <p>The list of <code>SimpleDocumentationListener</code> for test.</p>
     */
    private List<SimpleDocumentationListener> docListeners = new ArrayList<SimpleDocumentationListener>();

    /**
     * <p>The instance of <code>DocumentationPanel</code> for test.</p>
     */
    private DocumentationPanel docPanel = null;

    /**
     * <p>Return test suite of <code>DocumentationPanelStressTest</code>.</p>
     *
     * @return Test suite of <code>DocumentationPanelStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(DocumentationPanelStressTest.class);
    }

    /**
     * <p>Set up the accuracy testing envionment.</p>
     *
     * @throws Exception if any exception occurs when setting.
     */
    protected void setUp() throws Exception {
        // clear all namespaces here.
        StressTestHelper.clearNamespace();

        ConfigManager cm = ConfigManager.getInstance();

        // load config files.
        cm.add(DOC_PANEL_CONFIG_FILE);

        // choose the text Helper and uses the AWT Event Queue.
        super.setUp();
        setHelper(new JFCTestHelper());

        // create the model element here.
        operation = new OperationImpl();

        // add null and empty parameter name here, should be ingnored in setTarget() method.
        operation.addParameter(StressTestHelper.getParameter("documentation", "param doc", null));
        operation.addParameter(StressTestHelper.getParameter("documentation", "param doc", "  "));
        operation.addTaggedValue(StressTestHelper.getTaggedValue("documentation#throws",
                "Exception if any exception occurs."));
        opDoc = StressTestHelper.getTaggedValue("documentation",
                "Operation documentation goes here...");
        operation.addTaggedValue(opDoc);

        // create the model element here.
        methodImpl = new MethodImpl();
        methodDoc = StressTestHelper.getTaggedValue("documentation",
                "Method documentation goes here...");
        methodImpl.addTaggedValue(methodDoc);

        // create five listeners here.
        for (int i = 0; i < 5; i++) {
            tagListeners.add(new SimpleTagListener());
            docListeners.add(new SimpleDocumentationListener());
        }
    }

    /**
     * <p>Clean the accuracy test environment.</p>
     *
     * @throws Exception if any exception occurs when setting.
     */
    protected void tearDown() throws Exception {
        // clear all namespaces.
        StressTestHelper.clearNamespace();

        // clean jfc test helper here.
        JFCTestHelper.cleanUp(this);
        super.tearDown();
    }

    /**
     * <p>Basic stress test of <code>DocumentationPanel</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testCtor_Default() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            docPanel = new DocumentationPanel(DOC_PANEL_NAMESPACE);
            docPanel.showWholeEditor(true);

            // add the doc panel into a frame.
            JFrame frame = new JFrame();
            frame.add(docPanel);
            frame.setVisible(true);

            // set name for the JTable and JTextArea component.
            JSplitPane splitPane = (JSplitPane) docPanel.getComponent(0);

            JPanel docEditor = (JPanel) splitPane.getLeftComponent();
            JScrollPane leftPane = (JScrollPane) docEditor.getComponent(0);
            JTextArea textArea = (JTextArea) leftPane.getViewport().getView();
            textArea.setName("JTextArea");

            JPanel tagEditor = (JPanel) splitPane.getRightComponent();
            JScrollPane rightPane = (JScrollPane) tagEditor.getComponent(0);
            JTable tagTable = (JTable) rightPane.getViewport().getView();
            tagTable.setName("JTable");

            // set target, then JTextArea and JTable is visible.
            docPanel.setTarget(new MethodImpl());

            // using finder to find this JTextArea and test it.
            NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTextArea");
            JTextArea getTextArea = (JTextArea) finder.find(docPanel, 0);
            assertNotNull("Could not find the JTextArea.", getTextArea);
            assertTrue("The text area is not setted incorrect.", getTextArea.getLineWrap());
            assertEquals("The text area is not setted incorrect.", "", getTextArea.getText());

            // using finder to find this JTable and test it.
            finder = new NamedComponentFinder(JComponent.class, "JTable");

            JTable getTagTable = (JTable) finder.find(docPanel, 0);
            assertNotNull("Could not find the JTable.", getTagTable);
        }
    }

    /**
     * <p>Basic stress test of <code>setTarget(ModelElement element)</code> method.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testMethod_setTarget_Operation() throws Exception {
        docPanel = new DocumentationPanel(DOC_PANEL_NAMESPACE);
        docPanel.showWholeEditor(true);

        // add the doc panel into a frame.
        JFrame frame = new JFrame();
        frame.add(docPanel);
        frame.setVisible(true);

        // set name for the JTable and JTextArea component.
        JSplitPane splitPane = (JSplitPane) docPanel.getComponent(0);

        JPanel docEditor = (JPanel) splitPane.getLeftComponent();
        JScrollPane leftPane = (JScrollPane) docEditor.getComponent(0);
        JTextArea textArea = (JTextArea) leftPane.getViewport().getView();
        textArea.setName("JTextArea");

        JPanel tagEditor = (JPanel) splitPane.getRightComponent();
        JScrollPane rightPane = (JScrollPane) tagEditor.getComponent(0);
        JTable tagTable = (JTable) rightPane.getViewport().getView();
        tagTable.setName("JTable");

        // set target, then JTextArea and JTable is visible.
        docPanel.setTarget(new MethodImpl());

        // using finder to find this JTextArea and test it.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTextArea");
        JTextArea getTextArea = (JTextArea) finder.find(docPanel, 0);
        assertNotNull("Could not find the JTextArea.", getTextArea);
        assertTrue("The text area is not setted incorrect.", getTextArea.getLineWrap());
        assertEquals("The text area is not setted incorrect.", "", getTextArea.getText());

        // using finder to find this JTable and test it.
        finder = new NamedComponentFinder(JComponent.class, "JTable");

        JTable getTagTable = (JTable) finder.find(docPanel, 0);
        assertNotNull("Could not find the JTable.", getTagTable);

        // add parameters and set target.
        for (int i = 0; i < LOOPTIMES; i++) {
            operation.addParameter(StressTestHelper.getParameter("documentation",
                    " param#" + i + "'s doc", " parameter#" + i));

            String dataValue = "Operation# " + i + " documentation goes here...";
            opDoc.setDataValue(dataValue);

            docPanel.setTarget(operation);

            // test text area.
            assertEquals("The text area is not setted incorrect.", dataValue, getTextArea.getText());

            // check the JTable here.
            assertEquals("The tag table is not setted incorrect.", 2,
                getTagTable.getColumnModel().getColumnCount());
            assertEquals("The tag table is not setted incorrect.", i + 3, getTagTable.getRowCount());
            assertEquals("The tag table is not setted incorrect.", "Test_Tag",
                getTagTable.getColumnName(0));
            assertEquals("The tag table is not setted incorrect.", "Test_Documentation",
                getTagTable.getColumnName(1));

            // check each(row, col) in table.
            for (int row = 0; row < i; row++) {
                String tag = getTagTable.getValueAt(row, 0).toString();
                assertTrue("The tag table is not setted incorrect.",
                    tag.startsWith("@param") && (tag.indexOf("parameter#" + row) != -1));
                assertEquals("The tag table is not setted incorrect.", " param#" + row + "'s doc",
                    getTagTable.getValueAt(row, 1));
            }

            assertTrue("The tag table is not setted incorrect.",
                getTagTable.getValueAt(i + 1, 0).toString().endsWith("throws"));
            assertEquals("The tag table is not setted incorrect.",
                "Exception if any exception occurs.", getTagTable.getValueAt(i + 1, 1));
        }
    }

    /**
     * <p>Basic stress test of <code>setTarget(ModelElement element)</code> method.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testMethod_setTarget_ModelElement() throws Exception {
        docPanel = new DocumentationPanel(DOC_PANEL_NAMESPACE);
        docPanel.showWholeEditor(true);

        // add the doc panel into a frame.
        JFrame frame = new JFrame();
        frame.add(docPanel);
        frame.setVisible(true);

        // set name for the JTable and JTextArea component.
        JSplitPane splitPane = (JSplitPane) docPanel.getComponent(0);

        JPanel docEditor = (JPanel) splitPane.getLeftComponent();
        JScrollPane leftPane = (JScrollPane) docEditor.getComponent(0);
        JTextArea textArea = (JTextArea) leftPane.getViewport().getView();
        textArea.setName("JTextArea");

        JPanel tagEditor = (JPanel) splitPane.getRightComponent();
        JScrollPane rightPane = (JScrollPane) tagEditor.getComponent(0);
        JTable tagTable = (JTable) rightPane.getViewport().getView();
        tagTable.setName("JTable");

        // set target, then JTextArea and JTable is visible.
        docPanel.setTarget(new MethodImpl());

        // using finder to find this JTextArea and test it.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTextArea");
        JTextArea getTextArea = (JTextArea) finder.find(docPanel, 0);
        assertNotNull("Could not find the JTextArea.", getTextArea);
        assertTrue("The text area is not setted incorrect.", getTextArea.getLineWrap());
        assertEquals("The text area is not setted incorrect.", "", getTextArea.getText());

        // using finder to find this JTable and test it.
        finder = new NamedComponentFinder(JComponent.class, "JTable");

        JTable getTagTable = (JTable) finder.find(docPanel, 0);
        assertNotNull("Could not find the JTable.", getTagTable);

        // add parameters and set target.
        for (int i = 0; i < LOOPTIMES; i++) {
            methodImpl.addTaggedValue(StressTestHelper.getTaggedValue("documentation#param",
                    "param#" + i + " The param's doc."));

            String dataValue = "Method# " + i + " documentation goes here...";
            methodDoc.setDataValue(dataValue);

            docPanel.setTarget(methodImpl);

            // test text area.
            assertEquals("The text area is not setted incorrect.", dataValue, getTextArea.getText());

            // check the JTable here.
            assertEquals("The tag table is not setted incorrect.", 2,
                getTagTable.getColumnModel().getColumnCount());
            assertEquals("The tag table is not setted incorrect.", i + 2, getTagTable.getRowCount());
            assertEquals("The tag table is not setted incorrect.", "Test_Tag",
                getTagTable.getColumnName(0));
            assertEquals("The tag table is not setted incorrect.", "Test_Documentation",
                getTagTable.getColumnName(1));

            // check each(row, col) in table.
            for (int row = 0; row < i; row++) {
                assertTrue("The tag table is not setted incorrect.",
                    getTagTable.getValueAt(row, 0).toString().endsWith("param"));
                assertEquals("The tag table is not setted incorrect.",
                    "param#" + row + " The param's doc.", getTagTable.getValueAt(row, 1));
            }
        }
    }
}
