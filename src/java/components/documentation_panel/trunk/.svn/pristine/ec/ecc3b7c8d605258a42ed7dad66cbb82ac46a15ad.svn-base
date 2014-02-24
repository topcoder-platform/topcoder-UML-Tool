/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import java.awt.event.FocusEvent;

import javax.swing.JTextArea;

import junit.framework.TestCase;

import com.topcoder.gui.panels.documentation.TestHelper;
import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.event.MockDocumentationListener;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;


/**
 * <p>
 * This test case contains accuracy tests for
 * <code>DefaultDocumentationEditor</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultDocumentationEditorTestAcc extends TestCase {

    /**
     * <p>
     * <code>DefaultDocumentationEditor</code> used in this test case.
     * </p>
     */
    private DefaultDocumentationEditor docEditor = null;

    /**
     * <p>
     * Model element used in this test case.
     * </p>
     */
    private ModelElement element = null;

    /**
     * <p>
     * Documentation listener used in this test case.
     * </p>
     */
    private MockDocumentationListener listener = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.addConfig("UnitTest/docEditor.xml");
        docEditor = new DefaultDocumentationEditor("defaultDocEditor_1");
        element = new OperationImpl();
        listener = new MockDocumentationListener();
        docEditor.addDocumentationListener(listener);
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        listener = null;
        element = null;
        docEditor = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Initialize a <code>DefaultDocumentationEditor</code>
     * with given namespace.
     * </p>
     *
     * @param namespace of document editor
     *
     * @throws Exception to JUnit
     */
    private void assertInit(String namespace) throws Exception {
        docEditor = new DefaultDocumentationEditor(namespace);
        assertNotNull("initialized", docEditor);
    }

    /**
     * <p>
     * Get <code>JTextArea</code> used in <code>DefaultDocumentationEditor</code>.
     * </p>
     *
     * @return <code>JTextArea</code> used in documentation editor
     *
     * @throws Exception to JUnit
     */
    private JTextArea getJTextArea() throws Exception {
        return (JTextArea) TestHelper.getField(docEditor, "content");
    }

    /**
     * <p>
     * Set text on <code>JTextArea</code>.
     * </p>
     *
     * @param text to set
     *
     * @throws Exception to JUnit
     */
    private void setJTextAreaText(String text) throws Exception {
        getJTextArea().setText(text);
    }
    /**
     * <p>
     * Assert whether the <code>JTextArea</code> is line wrapped.
     * </p>
     *
     * @param lineWrap expected whether the text area is line wrapped
     *
     * @throws Exception to JUnit
     */
    private void assertLineWrap(boolean lineWrap) throws Exception {
        JTextArea textArea = getJTextArea();
        assertEquals("Line wrap is " + lineWrap, textArea.getLineWrap(), lineWrap);
    }

    /**
     * <p>
     * Assert the text of <code>JTextArea</code> equals the desired text.
     * </p>
     *
     * @param text desired text
     *
     * @throws Exception to JUnit
     */
    private void assertText(String text) throws Exception {
        JTextArea textArea = getJTextArea();
        assertEquals("Text is " + text, text, textArea.getText());
    }

    /**
     * <p>
     * Assert the previous documentation of <code>DefaultDocumentationEditor</code>
     * equals the desired documentation.
     * </p>
     *
     * @param doc desired previous documentation
     *
     * @throws Exception to JUnit
     */
    private void assertPreviousDoc(String doc) throws Exception {
        String preDoc = (String) TestHelper.getField(docEditor, "previousDocumentation");
        assertEquals("Previous document is " + doc, doc, preDoc);
    }

    /**
     * <p>
     * Test accuracy of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Property "wordwrap" value is "yes", true is expected for line wrap.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultDocumentationEditor1() throws Exception {
        assertInit("defaultDocEditor_1");
        assertLineWrap(true);
    }

    /**
     * <p>
     * Test accuracy of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Property "wordwrap" value is "no", false is expected for line wrap.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultDocumentationEditor2() throws Exception {
        assertInit("defaultDocEditor_2");
        assertLineWrap(false);
    }

    /**
     * <p>
     * Test accuracy of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Property "wordwrap" value is "Yes", true is expected for line wrap.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultDocumentationEditor3() throws Exception {
        assertInit("defaultDocEditor_3");
        assertLineWrap(true);
    }
    /**
     * <p>
     * Test accuracy of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Property "wordwrap" value is "YES", true is expected for line wrap.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultDocumentationEditor4() throws Exception {
        assertInit("defaultDocEditor_4");
        assertLineWrap(true);
    }
    /**
     * <p>
     * Test accuracy of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Property "wordwrap" value is empty, false is expected for line wrap.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultDocumentationEditor5() throws Exception {
        assertInit("defaultDocEditor_5");
        assertLineWrap(false);
    }
    /**
     * <p>
     * Test accuracy of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Property "wordwrap" value is null, false is expected for line wrap.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultDocumentationEditor6() throws Exception {
        assertInit("defaultDocEditor_6");
        assertLineWrap(false);
    }
    /**
     * <p>
     * Test accuracy of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Property "wordwrap" value is empty, false is expected for line wrap.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultDocumentationEditor7() throws Exception {
        assertInit("defaultDocEditor_7");
        assertLineWrap(false);
    }
    /**
     * <p>
     * Test accuracy of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Property "wordwrap" value is null, false is expected for line wrap.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultDocumentationEditor8() throws Exception {
        assertInit("defaultDocEditor_8");
        assertLineWrap(false);
    }
    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>TaggedValue</code> has no definition, text of <code>JTextArea</code>
     * and previous documentation should both be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget1() throws Exception {
        TaggedValue tv = TestHelper.getTaggedValueWithNullDefinition();
        element.addTaggedValue(tv);
        docEditor.setTarget(element);
        assertText("");
        assertPreviousDoc("");
    }

    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>ModelElement</code> has no <code>TaggedValue</code> attached,
     * text of <code>JTextArea</code> and previous documentation should
     * both be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget2() throws Exception {
        docEditor.setTarget(element);
        assertText("");
        assertPreviousDoc("");
    }

    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>TaggedValue</code> has no tag type, text of <code>JTextArea</code>
     * and previous documentation should both be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget3() throws Exception {
        TaggedValue tv = TestHelper.getTaggedValueWithNullTagType();
        element.addTaggedValue(tv);
        docEditor.setTarget(element);
        assertText("");
        assertPreviousDoc("");
    }

    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>TaggedValue</code> has desired tag type but the documentation of tag is null,
     * text of <code>JTextArea</code> and previous documentation should both be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget4() throws Exception {
        TaggedValue tv = TestHelper.getTaggedValueWithTagType(TestHelper.DOCUMENTATION);
        element.addTaggedValue(tv);
        docEditor.setTarget(element);
        assertText("");
        assertPreviousDoc("");
    }

    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>TaggedValue</code> has desired tag type and non-null documentation of tag,
     * text of <code>JTextArea</code> and previous documentation should both be the
     * non-null documentation of tag.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget5() throws Exception {
        TaggedValue tv = TestHelper.getTaggedValueWithTagType(TestHelper.DOCUMENTATION);
        tv.setDataValue("tagDocumentation");
        element.addTaggedValue(tv);
        docEditor.setTarget(element);
        assertText("tagDocumentation");
        assertPreviousDoc("tagDocumentation");
    }

    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>TaggedValue</code> has tag type but it's not desired,
     * text of <code>JTextArea</code> and previous documentation should both be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget6() throws Exception {
        TaggedValue tv = TestHelper.getTaggedValueWithTagType("NotDesiredTagType");
        element.addTaggedValue(tv);
        docEditor.setTarget(element);
        assertText("");
        assertPreviousDoc("");
    }
    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>TaggedValue</code> has tag type but it's not desired,
     * text of <code>JTextArea</code> and previous documentation should both be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget7() throws Exception {
        TaggedValue tv = TestHelper.getTaggedValueWithTagType(TestHelper.DOCUMENTATION + "#");
        element.addTaggedValue(tv);
        docEditor.setTarget(element);
        assertText("");
        assertPreviousDoc("");
    }
    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The related component of event is not the <code>JTextArea</code>
     * of document editor, previous document should be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost1() throws Exception {
        FocusEvent e = new FocusEvent(new JTextArea(), FocusEvent.FOCUS_LOST);
        docEditor.focusLost(e);
        assertPreviousDoc("");
    }

    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The related component of event is not the <code>JTextArea</code>
     * of document editor, previous document should be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost2() throws Exception {
        this.setJTextAreaText("xxxxx");
        FocusEvent e = new FocusEvent(new JTextArea(), FocusEvent.FOCUS_LOST);
        docEditor.focusLost(e);
        assertPreviousDoc("");
    }

    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The related component of event is not the <code>JTextArea</code>
     * of document editor, previous document should not change.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost3() throws Exception {
        testSetTarget5();
        this.setJTextAreaText("xxxxx");
        FocusEvent e = new FocusEvent(new JTextArea(), FocusEvent.FOCUS_LOST);
        docEditor.focusLost(e);
        assertPreviousDoc("tagDocumentation");
    }

    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The event type is not <code>FocusEvent.FOCUS_LOST</code>
     * , previous document should be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost4() throws Exception {
        FocusEvent e = new FocusEvent(this.getJTextArea(), FocusEvent.FOCUS_GAINED);
        docEditor.focusLost(e);
        assertPreviousDoc("");
    }

    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The event type is not <code>FocusEvent.FOCUS_LOST</code>
     * , previous document should be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost5() throws Exception {
        this.setJTextAreaText("xxxxx");
        FocusEvent e = new FocusEvent(this.getJTextArea(), FocusEvent.FOCUS_GAINED);
        docEditor.focusLost(e);
        assertPreviousDoc("");
    }

    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The event type is not <code>FocusEvent.FOCUS_LOST</code>
     * , previous document should not change.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost6() throws Exception {
        testSetTarget5();
        this.setJTextAreaText("xxxxx");
        FocusEvent e = new FocusEvent(this.getJTextArea(), FocusEvent.FOCUS_GAINED);
        docEditor.focusLost(e);
        assertPreviousDoc("tagDocumentation");
    }

    /**
     * <p>
     * Assert two <code>DocumentationEvent</code> equals.
     * </p>
     *
     * @param e1 one <code>DocumentationEvent</code>
     * @param e2 another <code>DocumentationEvent</code>
     */
    private void assertDocumentationEvent(DocumentationEvent e1, DocumentationEvent e2) {
        assertEquals(e1.getModelElement(), e2.getModelElement());
        assertEquals(e1.getCurrentDocumentation(), e2.getCurrentDocumentation());
        assertEquals(e1.getPreviousDocumentation(), e2.getPreviousDocumentation());
    }

    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The related component is the <code>JTextArea</code>
     * of document editor, and event type is <code>FocusEvent.FOCUS_LOST</code>
     * .Previous document and current document are both not empty, updated
     * event should be fired.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost7() throws Exception {
        testSetTarget5();
        this.setJTextAreaText("xxxxx");
        FocusEvent e = new FocusEvent(this.getJTextArea(), FocusEvent.FOCUS_LOST);
        docEditor.focusLost(e);
        assertPreviousDoc("xxxxx");
        DocumentationEvent event = new DocumentationEvent(this.element, "tagDocumentation", "xxxxx");
        assertDocumentationEvent(event, this.listener.getFiredEvent());
        assertEquals("updated event", this.listener.getEventType(), "updated");
    }

    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The related component is the <code>JTextArea</code>
     * of document editor, and event type is <code>FocusEvent.FOCUS_LOST</code>
     * .Previous document is not empty, current document is empty, delete event
     * should be fired.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost8() throws Exception {
        testSetTarget5();
        this.setJTextAreaText(null);
        FocusEvent e = new FocusEvent(this.getJTextArea(), FocusEvent.FOCUS_LOST);
        docEditor.focusLost(e);
        assertPreviousDoc("");
        DocumentationEvent event = new DocumentationEvent(this.element, "tagDocumentation", null);
        assertDocumentationEvent(event, this.listener.getFiredEvent());
        assertEquals("deleted event", this.listener.getEventType(), "deleted");
    }
    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The related component is the <code>JTextArea</code>
     * of document editor, and event type is <code>FocusEvent.FOCUS_LOST</code>
     * . Previous document is empty, current document is not empty, create event
     * should be fired.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost9() throws Exception {
        testSetTarget4();
        this.setJTextAreaText("xxxxx");
        FocusEvent e = new FocusEvent(this.getJTextArea(), FocusEvent.FOCUS_LOST);
        docEditor.focusLost(e);
        assertPreviousDoc("xxxxx");
        DocumentationEvent event = new DocumentationEvent(this.element, null, "xxxxx");
        assertDocumentationEvent(event, this.listener.getFiredEvent());
        assertEquals("created event", this.listener.getEventType(), "created");
    }
    /**
     * <p>
     * Test accuracy of method <code>FocusLost()</code>.
     * </p>
     *
     * <p>
     * The related component is the <code>JTextArea</code>
     * of document editor, and event type is <code>FocusEvent.FOCUS_LOST</code>
     * .Previous document equals current document, nothing should happen.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost10() throws Exception {
        testSetTarget5();
        this.setJTextAreaText("tagDocumentation");
        FocusEvent e = new FocusEvent(this.getJTextArea(), FocusEvent.FOCUS_LOST);
        docEditor.focusLost(e);
        assertPreviousDoc("tagDocumentation");
        assertNull("no event fired", this.listener.getFiredEvent());
        assertNull("no event type", this.listener.getEventType());
    }
}
