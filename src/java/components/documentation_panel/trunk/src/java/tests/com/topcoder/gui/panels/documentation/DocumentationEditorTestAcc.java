/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import java.util.List;

import com.topcoder.gui.panels.documentation.event.MockDocumentationListener;
import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.event.DocumentationListener;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains accuracy tests for <code>DocumentationEditor</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DocumentationEditorTestAcc extends TestCase {
    /**
     * <p>
     * <code>DocumentationEditor</code> used in this test case.
     * </p>
     */
    private DocumentationEditor documentationEditor = null;

    /**
     * <p>
     * Documentation listener used in this test case.
     * </p>
     */
    private MockDocumentationListener listener1 = null;

    /**
     * <p>
     * Documentation listener used in this test case.
     * </p>
     */
    private MockDocumentationListener listener2 = null;

    /**
     * <p>
     * Model element used in this test case.
     * </p>
     */
    private ModelElement target = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        this.documentationEditor = new MockDocumentationEditor();
        listener1 = new MockDocumentationListener();
        listener2 = new MockDocumentationListener();
        target = new OperationImpl();
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        target = null;
        listener1 = null;
        listener2 = null;
        this.documentationEditor = null;
        super.tearDown();
    }

    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    public void testSetTarget() throws UnknownElementTypeException {
        addTarget();
        assertEquals("same target", target, this.documentationEditor.getTarget());
    }

    /**
     * <p>
     * Add a target to tag editor.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    private void addTarget() throws UnknownElementTypeException {
        this.documentationEditor.setTarget(target);
    }
    /**
     * <p>
     * Test accuracy of method <code>addDocumentationListener()</code>.
     * </p>
     */
    public void testAddDocumentationListener() {
        addListeners();
        assertListeners();
    }

    /**
     * <p>
     * Test accuracy of method <code>removeDocumentationListener()</code>.
     * </p>
     *
     * <p>
     * Remove a null listener, the currently attached listeners should
     * not change.
     * </p>
     */
    public void testRemoveDocumentationListener1() {
        addListeners();

        this.documentationEditor.removeDocumentationListener(null);

        assertListeners();
    }
    /**
     * <p>
     * Test accuracy of method <code>removeDocumentationListener()</code>.
     * </p>
     *
     * <p>
     * Remove a listener which is not currently attached, the
     * attached listeners should not change.
     * </p>
     */
    public void testRemoveDocumentationListener2() {
        addListeners();

        this.documentationEditor.removeDocumentationListener(new MockDocumentationListener());

        assertListeners();
    }
    /**
     * <p>
     * Test accuracy of method <code>removeDocumentationListener()</code>.
     * </p>
     *
     * <p>
     * Remove a listener which is currently attached, the
     * attached listeners should change.
     * </p>
     */
    public void testRemoveDocumentationListener3() {
        addListeners();

        this.documentationEditor.removeDocumentationListener(listener1);

        List < DocumentationListener > listeners = this.documentationEditor.getDocumentationListeners();
        assertEquals("size of listeners is 1", 1, listeners.size());
        assertEquals("same listener", listener2, listeners.get(0));
    }
    /**
     * <p>
     * Test accuracy of method <code>getDocumentationListeners()</code>.
     * </p>
     */
    public void testGetDocumentationListeners() {
        addListeners();

        assertListeners();
    }

    /**
     * <p>
     * Attach listeners to tag editor.
     * </p>
     */
    private void addListeners() {
        this.documentationEditor.addDocumentationListener(listener1);
        this.documentationEditor.addDocumentationListener(listener2);
    }
    /**
     * <p>
     * Assert current listeners attached to tag editor.
     * </p>
     */
    private void assertListeners() {
        List < DocumentationListener > listeners = this.documentationEditor.getDocumentationListeners();

        assertEquals("size of listeners is 2", 2, listeners.size());
        assertEquals("same listener", listener1, listeners.get(0));
        assertEquals("same listener", listener2, listeners.get(1));
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
     * Test accuracy of method <code>fireDocumentationCreated()</code>.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    public void testFireDocumentationCreated() throws UnknownElementTypeException {
        addListeners();
        addTarget();

        this.documentationEditor.fireDocumentationCreated("currentDoc");

        DocumentationEvent e = new DocumentationEvent(this.target, null, "currentDoc");

        for (DocumentationListener listener : documentationEditor.getDocumentationListeners()) {
            assertDocumentationEvent(e, ((MockDocumentationListener) listener).getFiredEvent());
            assertEquals("created event", ((MockDocumentationListener) listener).getEventType(), "created");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>fireDocumentationUpdated()</code>.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    public void testFireDocumentationUpdated() throws UnknownElementTypeException {
        addListeners();
        addTarget();

        this.documentationEditor.fireDocumentationUpdated("previousDoc", "currentDoc");

        DocumentationEvent e = new DocumentationEvent(this.target, "previousDoc", "currentDoc");

        for (DocumentationListener listener : documentationEditor.getDocumentationListeners()) {
            assertDocumentationEvent(e, ((MockDocumentationListener) listener).getFiredEvent());
            assertEquals("updated event", ((MockDocumentationListener) listener).getEventType(), "updated");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>fireDocumentationDeleted()</code>.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    public void testFireDocumentationDeleted() throws UnknownElementTypeException {
        addListeners();
        addTarget();

        this.documentationEditor.fireDocumentationDeleted("previousDoc");

        DocumentationEvent e = new DocumentationEvent(this.target, "previousDoc", null);

        for (DocumentationListener listener : documentationEditor.getDocumentationListeners()) {
            assertDocumentationEvent(e, ((MockDocumentationListener) listener).getFiredEvent());
            assertEquals("deleted event", ((MockDocumentationListener) listener).getEventType(), "deleted");
        }
    }
}
