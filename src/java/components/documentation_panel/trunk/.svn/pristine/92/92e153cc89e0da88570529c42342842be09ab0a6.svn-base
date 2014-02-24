/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ DefaultDocumentationEditorAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.event.DocumentationListener;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

import com.topcoder.util.config.ConfigManager;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import junit.framework.Test;
import junit.framework.TestSuite;

import java.awt.event.FocusEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * <p>
 * The <code>DefaultDocumentationEditor</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>DefaultDocumentationEditor</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class DefaultDocumentationEditorAccuracyTests extends JFCTestCase {
    /**
    * <p>
    * Represents the config file used for test by the ConfigManager.
    * </p>
    */
    private static final String CONFIG_FILE = "accuracytests/defaultDocEditor.xml";

    /**
    * <p>
    * Represents the property <code>namespace</code> of DefaultDocumentationEditor.
    * It is used for getting the value under the <code>namespace</code> by the ConfigManager.
    * </p>
    */
    private static final String NAMESPACE = "defaultDocEditor";

    /**
     * <p>
     * The instance of <code>DefaultDocumentationEditor</code> for test.
     * </p>
     */
    private DefaultDocumentationEditor docEditor = null;

    /**
     * <p>
     * The instance of <code>DocumentationListener</code> for test.
     * </p>
     */
    private DocumentationListener docListener = null;

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
     * Test suite of <code>DefaultDocumentationEditorAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DefaultDocumentationEditorAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DefaultDocumentationEditorAccuracyTests.class);
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
        docListener = new MockDocListener();
    }

    /**
     * <p>
     * Accuracy Test of the <code>DefaultDocumentationEditor(String)</code> constructor.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testconstructor_True() throws Exception {
        docEditor = new DefaultDocumentationEditor(NAMESPACE);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(docEditor);

        // check the JTextArea.
        assertNotNull("The JTextArea should exist.", textArea);

        // check the line wrapping policy of the text area
        assertTrue("The text area is set to true.", textArea.getLineWrap());

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "", textArea.getText());
    }

    /**
     * <p>
     * Accuracy Test of the <code>DefaultDocumentationEditor(String)</code> constructor.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testconstructor_False() throws Exception {
        TestHelper.clearConfig();

        // load XML file used to creat DefaultDocumentationEditor.
        cm.add("accuracytests/defaultDocEditor_False.xml");
        docEditor = new DefaultDocumentationEditor(NAMESPACE);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(docEditor);

        // check the JTextArea.
        assertNotNull("The JTextArea should exist.", textArea);

        // check the line wrapping policy of the text area
        assertFalse("The text area is set to false.", textArea.getLineWrap());

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "", textArea.getText());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setTarget(ModelElement)</code> method.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testsetTarget() throws Exception {
        docEditor = new DefaultDocumentationEditor(NAMESPACE);
        element.addTaggedValue(TestHelper.getTaggedValueWithTagType(
                "documentation", "Accuracy Tests"));

        // set the ModelElement.
        docEditor.setTarget(element);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(docEditor);

        // check the JTextArea.
        assertNotNull("The JTextArea should exist.", textArea);

        // check the line wrapping policy of the text area
        assertTrue("The text area is set to True.", textArea.getLineWrap());

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "Accuracy Tests",
            textArea.getText());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setTarget(ModelElement)</code> method.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testsetTarget_Null() throws Exception {
        docEditor = new DefaultDocumentationEditor(NAMESPACE);
        element.addTaggedValue(TestHelper.getTaggedValueWithTagType(
                "documentation", null));

        // set the ModelElement.
        docEditor.setTarget(element);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(docEditor);

        // check the JTextArea.
        assertNotNull("The JTextArea should exist.", textArea);

        // check the line wrapping policy of the text area
        assertTrue("The text area is set to True.", textArea.getLineWrap());

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "",
            textArea.getText());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setTarget(ModelElement)</code> method.
     * It tests when the TaggedValue not found.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testsetTarget_NonDoc() throws Exception {
        docEditor = new DefaultDocumentationEditor(NAMESPACE);
        element.addTaggedValue(TestHelper.getTaggedValueWithTagType("non-doc",
                "Accuracy Tests"));

        //  set the ModelElement.
        docEditor.setTarget(element);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(docEditor);

        // check the JTextArea.
        assertNotNull("The JTextArea should exist.", textArea);

        // check the line wrapping policy of the text area
        assertTrue("The text area is set to True.", textArea.getLineWrap());

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "", textArea.getText());
    }

    /**
     * <p>
     * Accuracy Test of the <code>focusLost(FocusEvent)</code> method.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testfocusLost_Updated() throws Exception {
        docEditor = new DefaultDocumentationEditor(NAMESPACE);
        element.addTaggedValue(TestHelper.getTaggedValueWithTagType(
                "documentation", "Accuracy Tests"));

        // set the ModelElement.
        docEditor.setTarget(element);

        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(docEditor);
        textArea.setText("new Text");
        docEditor.focusLost(new FocusEvent(textArea, FocusEvent.FOCUS_LOST));

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "new Text",
            textArea.getText());

        MockDocListener listener = (MockDocListener) docEditor.getDocumentationListeners()
                                                              .get(0);

        // get the updated envent.
        DocumentationEvent event = listener.eventUpdated;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the previousDoc to check the method.
        assertEquals("The previousDoc expected to be equal", "Accuracy Tests",
            event.getPreviousDocumentation());

        // get the currentDoc to check the method.
        assertEquals("The currentDoc expected to be equal", "new Text",
            event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>focusLost(FocusEvent)</code> method.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testfocusLost_Create() throws Exception {
        docEditor = new DefaultDocumentationEditor(NAMESPACE);
        // set the ModelElement.
        docEditor.setTarget(element);

        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(docEditor);
        textArea.setText("new Text");
        docEditor.focusLost(new FocusEvent(textArea, FocusEvent.FOCUS_LOST));

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "new Text",
            textArea.getText());

        MockDocListener listener = (MockDocListener) docEditor.getDocumentationListeners()
                                                              .get(0);

        // get the updated envent.
        DocumentationEvent event = listener.eventCreated;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the previousDoc to check the method.
        assertNull("The previousDoc expected to be null", event.getPreviousDocumentation());

        // get the currentDoc to check the method.
        assertEquals("The currentDoc expected to be equal", "new Text",
            event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>focusLost(FocusEvent)</code> method.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testfocusLost_Deleted() throws Exception {
        docEditor = new DefaultDocumentationEditor(NAMESPACE);
        element.addTaggedValue(TestHelper.getTaggedValueWithTagType(
                "documentation", "Accuracy Tests"));

        // set the ModelElement.
        docEditor.setTarget(element);

        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        // using the helper method to find the JTextArea.
        JTextArea textArea = getTextArea(docEditor);
        textArea.setText("");
        docEditor.focusLost(new FocusEvent(textArea, FocusEvent.FOCUS_LOST));

        // check the contains of the text area.
        assertEquals("The text area is init to empty.", "",
            textArea.getText());

        MockDocListener listener = (MockDocListener) docEditor.getDocumentationListeners()
                                                              .get(0);

        // get the updated envent.
        DocumentationEvent event = listener.eventDeleted;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the previousDoc to check the method.
        assertEquals("The previousDoc expected to be equal", "Accuracy Tests",
            event.getPreviousDocumentation());

        // get the currentDoc to check the method.
        assertNull("The currentDoc expected to be null", event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Helper method uesd to get the JTextArea from the given DefaultDocumentationEditor.
     * </p>
     *
     * @param docEditor DefaultDocumentationEditor contains the JTextArea.
     *
     * @return the JTextArea in the given DefaultDocumentationEditor.
     */
    public JTextArea getTextArea(DefaultDocumentationEditor docEditor) {
        // add the docEditor into a frame.
        JFrame frame = new JFrame();
        frame.add(docEditor);

        // set the JFrame
        frame.setVisible(true);

        // find the JTextArea.
        JScrollPane scroll = (JScrollPane) docEditor.getComponent(0);
        JTextArea textArea = (JTextArea) scroll.getViewport().getView();

        // set name for the JTextArea component.
        textArea.setName("myTextArea");

        // using finder to find the JTextArea.
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class,
                "myTextArea");
        JTextArea getTextArea = (JTextArea) finder.find(docEditor, 0);

        return getTextArea;
    }
}
