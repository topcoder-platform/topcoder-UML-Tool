/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.stresstests;

import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

import com.topcoder.util.config.ConfigManager;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.eventdata.JTextComponentMouseEventData;
import junit.extensions.jfcunit.eventdata.StringEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import junit.framework.Test;
import junit.framework.TestSuite;

import java.awt.event.FocusEvent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * <p>This class tests the <code>DefaultDocumentationEditor</code> class for stress. This
 * stress tests addresses the functionality provided by the
 * <code>DefaultDocumentationEditor</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class DefaultDocumentationEditorStressTest extends JFCTestCase {
    /**
     * <p>The default config file path of <code>DefaultDocumentationEditor</code> for test.</p>
     */
    private static final String DOC_EDITOR_CONFIG_FILE = "stresstests/DocEditorConfig.xml";

    /**
     * <p>The config namespace of <code>DefaultDocumentationEditor</code> for test.</p>
     */
    private static final String DOC_EDITOR_WITHWARP_NAMESPACE = "DocEditor_WithWrap";

    /**
     * <p>The config namespace of <code>DefaultDocumentationEditor</code> for test.</p>
     */
    private static final String DOC_EDITOR_WITHOUTWARP_NAMESPACE = "DocEditor_WithoutWrap";

    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 10;

    /**
     * <p>The list of <code>SimpleDocumentationListener</code> for test.</p>
     */
    private List<SimpleDocumentationListener> listeners = new ArrayList<SimpleDocumentationListener>();

    /**
     * <p>The instance of <code>ModelElement</code> for test.</p>
     */
    private ModelElement element = null;

    /**
     * <p>The instance of <code>TaggedValue</code> for test.</p>
     */
    private TaggedValue taggedValue = null;

    /**
     * <p>The instance of <code>DefaultDocumentationEditor</code> for test.</p>
     */
    private DefaultDocumentationEditor docEditor = null;

    /**
     * <p>Return test suite of <code>DefaultDocumentationEditorStressTest</code>.</p>
     *
     * @return Test suite of <code>DefaultDocumentationEditorStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(DefaultDocumentationEditorStressTest.class);
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
        cm.add(DOC_EDITOR_CONFIG_FILE);

        // choose the text Helper and uses the AWT Event Queue.
        super.setUp();
        setHelper(new JFCTestHelper());

        // create the model element here.
        element = new SimpleModelElement();
        taggedValue = StressTestHelper.getTaggedValue("documentation", "Object documentation goes here...");

        element.addTaggedValue(taggedValue);

        // create five listeners here.
        for (int i = 0; i < 5; i++) {
            listeners.add(new SimpleDocumentationListener());
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
     * <p>Basic stress test of <code>DefaultDocumentationEditor</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testCtor_WithWarp() throws Exception {
        docEditor = new DefaultDocumentationEditor(DOC_EDITOR_WITHWARP_NAMESPACE);

        // add the doc editor into a frame.
        JFrame frame = new JFrame();
        frame.add(docEditor);
        frame.setVisible(true);

        // get the JTextArea and test it.
        assertEquals("The DefaultDocumentationEditor is incorrect.", 1,
            docEditor.getComponentCount());

        // set name for the JTextArea component.
        JScrollPane scrollPane = (JScrollPane) docEditor.getComponent(0);
        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
        textArea.setName("JTextArea");

        // using finder to find this JTextArea and test it.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTextArea");
        JTextArea getTextArea = (JTextArea) finder.find(docEditor, 0);
        assertNotNull("Could not find the JTextArea.", getTextArea);
        assertTrue("The text area is not setted incorrect.", getTextArea.getLineWrap());
        assertEquals("The text area is not setted incorrect.", "", getTextArea.getText());

        // set the target and test it.
        for (int i = 0; i < LOOPTIMES; i++) {
            String dataValue = "Object# " + i + " documentation goes here...";
            taggedValue.setDataValue(dataValue);
            docEditor.setTarget(element);
            assertEquals("The text area is not setted incorrect.", dataValue, getTextArea.getText());
        }
    }

    /**
     * <p>Basic stress test of <code>DefaultDocumentationEditor</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testCtor_WithoutWarp() throws Exception {
        docEditor = new DefaultDocumentationEditor(DOC_EDITOR_WITHOUTWARP_NAMESPACE);

        // add the doc editor into a frame.
        JFrame frame = new JFrame();
        frame.add(docEditor);
        frame.setVisible(true);

        // get the JTextArea and test it.
        assertEquals("The DefaultDocumentationEditor is incorrect.", 1,
            docEditor.getComponentCount());

        // set name for the JTextArea component.
        JScrollPane scrollPane = (JScrollPane) docEditor.getComponent(0);
        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
        textArea.setName("JTextArea");

        // using finder to find this JTextArea and test it.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTextArea");
        JTextArea getTextArea = (JTextArea) finder.find(docEditor, 0);
        assertNotNull("Could not find the JTextArea.", getTextArea);
        assertFalse("The text area is not setted incorrect.", getTextArea.getLineWrap());
        assertEquals("The text area is not setted incorrect.", "", getTextArea.getText());

        // set the target and test it.
        for (int i = 0; i < LOOPTIMES; i++) {
            String dataValue = "Object# " + i + " documentation goes here...";
            taggedValue.setDataValue(dataValue);
            docEditor.setTarget(element);
            assertEquals("The text area is not setted incorrect.", dataValue, getTextArea.getText());
        }
    }

    /**
     * <p>Basic stress test of <code>focusLost(FocusEvent e)</code> method.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testMethod_focusLost() throws Exception {
        docEditor = new DefaultDocumentationEditor(DOC_EDITOR_WITHWARP_NAMESPACE);
        docEditor.setTarget(element);

        // add some listeners here.
        for (int i = 0; i < listeners.size(); i++) {
            docEditor.addDocumentationListener(listeners.get(i));
        }

        // add the doc editor into a frame.
        JFrame frame = new JFrame();
        frame.add(docEditor);
        frame.setVisible(true);

        // get the JTextArea and test it.
        assertEquals("The DefaultDocumentationEditor is incorrect.", 1,
            docEditor.getComponentCount());

        // set name for the JTextArea component.
        JScrollPane scrollPane = (JScrollPane) docEditor.getComponent(0);
        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
        textArea.setName("JTextArea");

        // using finder to find this JTextArea and test it.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "JTextArea");
        JTextArea getTextArea = (JTextArea) finder.find(docEditor, 0);
        assertNotNull("Could not find the JTextArea.", getTextArea);
        assertTrue("The text area is not setted incorrect.", getTextArea.getLineWrap());
        assertEquals("The text area is not setted incorrect.", "Object documentation goes here...",
            getTextArea.getText());

        // change the text area many times.
        StringBuffer buffer = new StringBuffer("Object documentation goes here...");
        String content = "\ndocumentation on line#";

        for (int i = 0; i < LOOPTIMES; i++) {
            // make foucus on the text area.
            pauseAWT();
            frame.dispatchEvent(new FocusEvent(getTextArea, FocusEvent.FOCUS_GAINED));
            flushAWT();

            // clean the text area here.
            getTextArea.selectAll();
            getTextArea.replaceSelection("");

            // check the text area.
            assertEquals("The text area is not setted incorrect.", "", getTextArea.getText());

            // make foucus off the text area.
            pauseAWT();
            frame.dispatchEvent(new FocusEvent(getTextArea, FocusEvent.FOCUS_LOST));
            flushAWT();

            // check the deleting event here.
            for (int j = 0; j < listeners.size(); j++) {
                DocumentationEvent deletedEvent = listeners.get(j).getDocumentationDeletedEvent();
                assertNotNull("Could not fire the deleted event.", deletedEvent);
                assertEquals("The focusLost method is incorrect.", buffer.toString(),
                    deletedEvent.getPreviousDocumentation());
                assertNull("The focusLost method is incorrect.",
                    deletedEvent.getCurrentDocumentation());
                assertEquals("The focusLost method is incorrect.", element,
                    deletedEvent.getModelElement());
            }

            // create the text area.
            getHelper().sendString(new StringEventData(this, getTextArea, buffer.toString()));

            // check the text area.
            assertEquals("The text area is not setted incorrect.", buffer.toString(),
                getTextArea.getText());

            // make foucus off the text area.
            pauseAWT();
            frame.dispatchEvent(new FocusEvent(getTextArea, FocusEvent.FOCUS_LOST));
            flushAWT();

            // check the updatding event here.
            for (int j = 0; j < listeners.size(); j++) {
                DocumentationEvent createdEvent = listeners.get(j).getDocumentationCreatedEvent();
                assertNull("The focusLost method is incorrect.",
                    createdEvent.getPreviousDocumentation());
                assertEquals("The focusLost method is incorrect.", buffer.toString(),
                    createdEvent.getCurrentDocumentation());
                assertEquals("The focusLost method is incorrect.", element,
                    createdEvent.getModelElement());
            }

            // set the text area.
            String nowContent = buffer.toString() + content + i;
            JTextComponentMouseEventData mouseEvent = new JTextComponentMouseEventData(this,
                    getTextArea, 1);
            mouseEvent.setOffset(buffer.toString().length());
            getHelper().enterClickAndLeave(mouseEvent);
            getHelper().sendString(new StringEventData(this, getTextArea, content + i));

            // check the text area.
            assertEquals("The text area is not setted incorrect.", nowContent, getTextArea.getText());

            // make foucus off the text area.
            pauseAWT();
            frame.dispatchEvent(new FocusEvent(getTextArea, FocusEvent.FOCUS_LOST));
            flushAWT();

            // check the updating event here.
            for (int j = 0; j < listeners.size(); j++) {
                DocumentationEvent updatedEvent = listeners.get(j).getDocumentationUpdatedEvent();
                assertEquals("The focusLost method is incorrect.", buffer.toString(),
                    updatedEvent.getPreviousDocumentation());
                assertEquals("The focusLost method is incorrect.", nowContent,
                    updatedEvent.getCurrentDocumentation());
                assertEquals("The focusLost method is incorrect.", element,
                    updatedEvent.getModelElement());
            }

            buffer.append(content + i);
        }
    }
}
