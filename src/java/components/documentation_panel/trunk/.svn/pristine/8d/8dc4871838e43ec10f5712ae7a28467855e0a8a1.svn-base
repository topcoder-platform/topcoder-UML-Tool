/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.stresstests;

import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagEditor;

import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;

import com.topcoder.util.config.ConfigManager;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import junit.framework.Test;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * <p>This class tests the <code>DefaultTagEditor</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>DefaultTagEditor</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class DefaultTagEditorStressTest extends JFCTestCase {
    /**
     * <p>The default config file path of <code>DefaultTagEditor</code> for test.</p>
     */
    private static final String TAG_EDITOR_CONFIG_FILE = "stresstests/TagEditorConfig.xml";

    /**
     * <p>The config namespace of <code>DefaultTagEditor</code> for test.</p>
     */
    private static final String TAG_EDITOR_DEFAULT_NAMESPACE = "TagEditor_Default";

    /**
     * <p>The config namespace of <code>DefaultTagEditor</code> for test.</p>
     */
    private static final String TAG_EDITOR_TEST_NAMESPACE = "TagEditor_Test";

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
     * <p>The list of <code>SimpleTagListener</code> for test.</p>
     */
    private List<SimpleTagListener> listeners = new ArrayList<SimpleTagListener>();

    /**
     * <p>The instance of <code>DefaultTagEditor</code> for test.</p>
     */
    private DefaultTagEditor tagEditor = null;

    /**
     * <p>Return test suite of <code>DefaultTagEditorStressTest</code>.</p>
     *
     * @return Test suite of <code>DefaultTagEditorStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(DefaultTagEditorStressTest.class);
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
        cm.add(TAG_EDITOR_CONFIG_FILE);

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

        // create the model element here.
        methodImpl = new MethodImpl();

        // create five listeners here.
        for (int i = 0; i < 5; i++) {
            listeners.add(new SimpleTagListener());
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
     * <p>Basic stress test of <code>DefaultTagEditor</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testCtor_Default() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            tagEditor = new DefaultTagEditor(TAG_EDITOR_DEFAULT_NAMESPACE);

            // add the tag editor into a frame.
            JFrame frame = new JFrame();
            frame.add(tagEditor);
            frame.setVisible(true);

            // get the tag editor and test it.
            assertEquals("The DefaultTagEditor is incorrect.", 1, tagEditor.getComponentCount());

            // set name for the JTable component.
            JScrollPane scrollPane = (JScrollPane) tagEditor.getComponent(0);
            JTable tagTable = (JTable) scrollPane.getViewport().getView();
            tagTable.setName("JTable");

            // using finder to find this JTable and test it.
            NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTable");
            JTable getTagTable = (JTable) finder.find(tagEditor, 0);
            assertNotNull("Could not find the JTable.", getTagTable);

            // check the JTable here.
            assertEquals("The tag table is not setted incorrect.", 2,
                getTagTable.getColumnModel().getColumnCount());
            assertEquals("The tag table is not setted incorrect.", "Tag",
                getTagTable.getColumnName(0));
            assertEquals("The tag table is not setted incorrect.", "Documentation",
                getTagTable.getColumnName(1));
            assertEquals("The tag table is not setted incorrect.", "Insert new tag...",
                getTagTable.getValueAt(0, 0));
            assertEquals("The tag table is not setted incorrect.", "", getTagTable.getValueAt(0, 1));
        }
    }

    /**
     * <p>Basic stress test of <code>DefaultTagEditor</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testCtor_Test() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            tagEditor = new DefaultTagEditor(TAG_EDITOR_TEST_NAMESPACE);

            // add the tag editor into a frame.
            JFrame frame = new JFrame();
            frame.add(tagEditor);
            frame.setVisible(true);

            // get the tag editor and test it.
            assertEquals("The DefaultTagEditor is incorrect.", 1, tagEditor.getComponentCount());

            // set name for the JTable component.
            JScrollPane scrollPane = (JScrollPane) tagEditor.getComponent(0);
            JTable tagTable = (JTable) scrollPane.getViewport().getView();
            tagTable.setName("JTable");

            // using finder to find this JTable and test it.
            NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTable");
            JTable getTagTable = (JTable) finder.find(tagEditor, 0);
            assertNotNull("Could not find the JTable.", getTagTable);

            // check the JTable here.
            assertEquals("The tag table is not setted incorrect.", 2,
                getTagTable.getColumnModel().getColumnCount());
            assertEquals("The tag table is not setted incorrect.", "Test_Tag",
                getTagTable.getColumnName(0));
            assertEquals("The tag table is not setted incorrect.", "Test_Documentation",
                getTagTable.getColumnName(1));
            assertEquals("The tag table is not setted incorrect.", "Insert new test tag...",
                getTagTable.getValueAt(0, 0));
            assertEquals("The tag table is not setted incorrect.", "", getTagTable.getValueAt(0, 1));
        }
    }

    /**
     * <p>Basic stress test of <code>setTarget(ModelElement element)</code> method.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testMethod_setTarget_Operation() throws Exception {
        tagEditor = new DefaultTagEditor(TAG_EDITOR_DEFAULT_NAMESPACE);

        // add some listeners here.
        for (int i = 0; i < listeners.size(); i++) {
            tagEditor.addTagListener(listeners.get(i));
        }

        // add the tag editor into a frame.
        JFrame frame = new JFrame();
        frame.add(tagEditor);
        frame.setVisible(true);

        // set name for the JTable component.
        JScrollPane scrollPane = (JScrollPane) tagEditor.getComponent(0);
        JTable tagTable = (JTable) scrollPane.getViewport().getView();
        tagTable.setName("JTable");

        // using finder to find this JTable and test it.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTable");
        JTable getTagTable = (JTable) finder.find(tagEditor, 0);
        assertNotNull("Could not find the JTable.", getTagTable);

        // add parameters and set target.
        for (int i = 0; i < LOOPTIMES; i++) {
            operation.addParameter(StressTestHelper.getParameter("documentation",
                    " param#" + i + "'s doc", " parameter#" + i));
            tagEditor.setTarget(operation);

            // check the JTable here.
            assertEquals("The tag table is not setted incorrect.", 2,
                getTagTable.getColumnModel().getColumnCount());
            assertEquals("The tag table is not setted incorrect.", i + 3, getTagTable.getRowCount());
            assertEquals("The tag table is not setted incorrect.", "Tag",
                getTagTable.getColumnName(0));
            assertEquals("The tag table is not setted incorrect.", "Documentation",
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

        // check the combo box.
        DefaultCellEditor editor = (DefaultCellEditor) getTagTable.getColumnModel().getColumn(0)
                                                                  .getCellEditor();
        JComboBox comboBox = (JComboBox) editor.getComponent();
        assertEquals("The tag table is not setted incorrect.", 5, comboBox.getItemCount());

        for (int j = 0; j < comboBox.getItemCount(); j++) {
            int originRowCount = getTagTable.getRowCount();
            String tagName = comboBox.getItemAt(j).toString();
            String tagValue = tagName + "'s doc";

            // create a new tag.
            int newTagIndex = originRowCount - 1;
            getTagTable.getModel().setValueAt(tagName, newTagIndex, 0);
            tagEditor.refresh();

            assertEquals("The tag table is not setted incorrect.", originRowCount + 1,
                getTagTable.getRowCount());
            assertTrue("The tag table is not setted incorrect.",
                getTagTable.getValueAt(newTagIndex, 0).toString().endsWith(tagName));
            assertEquals("The tag table is not setted incorrect.", "new value",
                getTagTable.getValueAt(newTagIndex, 1));

            // check the creating event here.
            for (int m = 0; m < listeners.size(); m++) {
                TagEvent createdEvent = listeners.get(m).getTagnCreatedEvent();
                assertNotNull("Could not fire the deleted event.", createdEvent);
                assertEquals("The deleted event is incorrect.", tagName, createdEvent.getTagName());
                assertNull("The deleted event is incorrect.",
                    createdEvent.getPreviousDocumentation());
                assertEquals("The deleted event is incorrect.", "new value",
                    createdEvent.getCurrentDocumentation());
                assertEquals("The deleted event is incorrect.", operation,
                    createdEvent.getModelElement());
            }

            // update a new tag.
            getTagTable.getModel().setValueAt(tagValue, newTagIndex, 1);
            tagEditor.refresh();

            assertEquals("The tag table is not setted incorrect.", originRowCount + 1,
                getTagTable.getRowCount());
            assertTrue("The tag table is not setted incorrect.",
                getTagTable.getValueAt(newTagIndex, 0).toString().endsWith(tagName));
            assertEquals("The tag table is not setted incorrect.", tagValue,
                getTagTable.getValueAt(newTagIndex, 1));

            // check the deleting event here.
            for (int m = 0; m < listeners.size(); m++) {
                TagEvent updatedEvent = listeners.get(m).getTagUpdatedEvent();
                assertNotNull("Could not fire the updated event.", updatedEvent);
                assertTrue("The updated event is incorrect.",
                    updatedEvent.getTagName().endsWith(tagName));
                assertEquals("The updated event is incorrect.", "new value",
                    updatedEvent.getPreviousDocumentation());
                assertEquals("The updated event is incorrect.", tagValue,
                    updatedEvent.getCurrentDocumentation());
                assertEquals("The updated event is incorrect.", operation,
                    updatedEvent.getModelElement());
            }

            // delete a new tag.
            getTagTable.getModel().setValueAt("", newTagIndex, 1);
            tagEditor.refresh();

            assertEquals("The tag table is not setted incorrect.", originRowCount,
                getTagTable.getRowCount());
            assertEquals("The tag table is not setted incorrect.", "Insert new tag...",
                getTagTable.getValueAt(newTagIndex, 0));
            assertEquals("The tag table is not setted incorrect.", "",
                getTagTable.getValueAt(newTagIndex, 1));

            // check the deleting event here.
            for (int m = 0; m < listeners.size(); m++) {
                TagEvent deletedEvent = listeners.get(m).getTagDeletedEvent();
                assertNotNull("Could not fire the deleted event.", deletedEvent);
                assertTrue("The deleted event is incorrect.",
                    deletedEvent.getTagName().endsWith(tagName));
                assertEquals("The deleted event is incorrect.", tagValue,
                    deletedEvent.getPreviousDocumentation());
                assertNull("The deleted event is incorrect.", deletedEvent.getCurrentDocumentation());
                assertEquals("The deleted event is incorrect.", operation,
                    deletedEvent.getModelElement());
            }
        }
    }

    /**
     * <p>Basic stress test of <code>setTarget(ModelElement element)</code> method.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testMethod_setTarget_ModelElement() throws Exception {
        tagEditor = new DefaultTagEditor(TAG_EDITOR_TEST_NAMESPACE);

        // add some listeners here.
        for (int i = 0; i < listeners.size(); i++) {
            tagEditor.addTagListener(listeners.get(i));
        }

        // add the tag editor into a frame.
        JFrame frame = new JFrame();
        frame.add(tagEditor);
        frame.setVisible(true);

        // set name for the JTable component.
        JScrollPane scrollPane = (JScrollPane) tagEditor.getComponent(0);
        JTable tagTable = (JTable) scrollPane.getViewport().getView();
        tagTable.setName("JTable");

        // using finder to find this JTable and test it.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTable");
        JTable getTagTable = (JTable) finder.find(tagEditor, 0);
        assertNotNull("Could not find the JTable.", getTagTable);

        // add parameters and set target.
        for (int i = 0; i < LOOPTIMES; i++) {
            methodImpl.addTaggedValue(StressTestHelper.getTaggedValue("documentation#param",
                    "param#" + i + " The param's doc."));
            tagEditor.setTarget(methodImpl);

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

        // check the combo box.
        DefaultCellEditor editor = (DefaultCellEditor) getTagTable.getColumnModel().getColumn(0)
                                                                  .getCellEditor();
        JComboBox comboBox = (JComboBox) editor.getComponent();
        assertEquals("The tag table is not setted incorrect.", 3, comboBox.getItemCount());

        for (int j = 0; j < comboBox.getItemCount(); j++) {
            int originRowCount = getTagTable.getRowCount();
            String tagName = comboBox.getItemAt(j).toString();
            String tagValue = tagName + "'s doc";

            // create a new tag.
            int newTagIndex = originRowCount - 1;
            getTagTable.getModel().setValueAt(tagName, newTagIndex, 0);
            tagEditor.refresh();

            ///sleep(5000);
            assertEquals("The tag table is not setted incorrect.", originRowCount + 1,
                getTagTable.getRowCount());
            assertTrue("The tag table is not setted incorrect.",
                getTagTable.getValueAt(newTagIndex, 0).toString().endsWith(tagName));
            assertEquals("The tag table is not setted incorrect.", "new test value",
                getTagTable.getValueAt(newTagIndex, 1));

            // check the creating event here.
            for (int m = 0; m < listeners.size(); m++) {
                TagEvent createdEvent = listeners.get(m).getTagnCreatedEvent();
                assertNotNull("Could not fire the deleted event.", createdEvent);
                assertEquals("The deleted event is incorrect.", tagName, createdEvent.getTagName());
                assertNull("The deleted event is incorrect.",
                    createdEvent.getPreviousDocumentation());
                assertEquals("The deleted event is incorrect.", "new test value",
                    createdEvent.getCurrentDocumentation());
                assertEquals("The deleted event is incorrect.", methodImpl,
                    createdEvent.getModelElement());
            }

            // update a new tag.
            getTagTable.getModel().setValueAt(tagValue, newTagIndex, 1);
            tagEditor.refresh();

            assertEquals("The tag table is not setted incorrect.", originRowCount + 1,
                getTagTable.getRowCount());
            assertTrue("The tag table is not setted incorrect.",
                getTagTable.getValueAt(newTagIndex, 0).toString().endsWith(tagName));
            assertEquals("The tag table is not setted incorrect.", tagValue,
                getTagTable.getValueAt(newTagIndex, 1));

            // check the deleting event here.
            for (int m = 0; m < listeners.size(); m++) {
                TagEvent updatedEvent = listeners.get(m).getTagUpdatedEvent();
                assertNotNull("Could not fire the updated event.", updatedEvent);
                assertTrue("The updated event is incorrect.", updatedEvent.getTagName().endsWith(tagName));
                assertEquals("The updated event is incorrect.", "new test value",
                    updatedEvent.getPreviousDocumentation());
                assertEquals("The updated event is incorrect.", tagValue,
                    updatedEvent.getCurrentDocumentation());
                assertEquals("The updated event is incorrect.", methodImpl,
                    updatedEvent.getModelElement());
            }

            // delete a new tag.
            getTagTable.getModel().setValueAt("", newTagIndex, 1);
            tagEditor.refresh();

            assertEquals("The tag table is not setted incorrect.", originRowCount,
                getTagTable.getRowCount());
            assertEquals("The tag table is not setted incorrect.", "Insert new test tag...",
                getTagTable.getValueAt(newTagIndex, 0));
            assertEquals("The tag table is not setted incorrect.", "",
                getTagTable.getValueAt(newTagIndex, 1));

            // check the deleting event here.
            for (int m = 0; m < listeners.size(); m++) {
                TagEvent deletedEvent = listeners.get(m).getTagDeletedEvent();
                assertNotNull("Could not fire the deleted event.", deletedEvent);
                assertTrue("The deleted event is incorrect.", deletedEvent.getTagName().endsWith(tagName));
                assertEquals("The deleted event is incorrect.", tagValue,
                    deletedEvent.getPreviousDocumentation());
                assertNull("The deleted event is incorrect.", deletedEvent.getCurrentDocumentation());
                assertEquals("The deleted event is incorrect.", methodImpl,
                    deletedEvent.getModelElement());
            }
        }
    }
}
