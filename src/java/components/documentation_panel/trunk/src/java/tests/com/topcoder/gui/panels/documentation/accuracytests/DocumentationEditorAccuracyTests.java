/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ DocumentationEditorAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.DocumentationEditor;
import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.event.DocumentationListener;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * The <code>DocumentationEditor</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>DocumentationEditor</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class DocumentationEditorAccuracyTests extends TestCase {
    /**
    * <p>
    * The instance of <code>DocumentationListener</code> for test.
    * </p>
    */
    private DocumentationListener docListener = null;

    /**
     * <p>
     * The instance of <code>DocumentationEditor</code> for test.
     * </p>
     */
    private MockDocEditor docEditor = null;

    /**
     * <p>
     * The instance of <code>ModelElement</code> for test.
     * </p>
     */
    private ModelElement element = null;

    /**
     * <p>
     * Test suite of <code>DocumentationEditorAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DocumentationEditorAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DocumentationEditorAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    protected void setUp() throws Exception {
        docListener = new MockDocListener();
        element = new OperationImpl();
        docEditor = new MockDocEditor();
        docEditor.setTarget(element);
    }

    /**
     * <p>
     * Accuracy Test of the <code>setTarget(ModelElement)</code> method.
     * </p>
     */
    public void testsetTarget() {

        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        // creat a doc.
        docEditor.fireDocumentationCreated("Created");

        // get the docListener.
        MockDocListener listener = (MockDocListener) docEditor.getDocumentationListeners()
                                                              .get(0);

        // get the created envent.
        DocumentationEvent event = listener.eventCreated;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());
    }

    /**
     * <p>
     * Accuracy Test of the <code>addDocumentationListener(DocumentationListener)</code> method.
     * </p>
     */
    public void testaddDocumentationListener() {
        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        //get the listeners.
        List <DocumentationListener> listeners = docEditor.getDocumentationListeners();

        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", docListener,
            listeners.get(0));
    }

    /**
     * <p>
     * Accuracy Test of the <code>removeDocumentationListener(DocumentationListener)</code> method.
     * </p>
     */
    public void testremoveDocumentationListener() {
        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        // get the listeners.
        List <DocumentationListener> listeners = docEditor.getDocumentationListeners();

        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", docListener,
            listeners.get(0));

        // remove null element, nothin happens.
        docEditor.removeDocumentationListener(null);
        listeners = docEditor.getDocumentationListeners();
        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", docListener,
            listeners.get(0));

        // remove non-exist element, nothin happens.
        docEditor.removeDocumentationListener(new MockDocListener());
        listeners = docEditor.getDocumentationListeners();
        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", docListener,
            listeners.get(0));

        // remove exist element.
        docEditor.removeDocumentationListener(docListener);
        listeners = docEditor.getDocumentationListeners();
        // get the listener to check the method.
        assertEquals("The listeners expected to have 0 element", 0,
            listeners.size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getDocumentationListeners()</code> method.
     * </p>
     */
    public void testgetDocumentationListeners() {
        // add the Listener.
        docEditor.addDocumentationListener(docListener);
        docEditor.addDocumentationListener(new MockDocListener());

        // get the listeners.
        List <DocumentationListener> listeners = docEditor.getDocumentationListeners();

        // get the listener to check the method.
        assertEquals("The listeners expected to have 2 elements", 2,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", docListener,
            listeners.get(0));

        // remove exist element.
        docEditor.removeDocumentationListener(docListener);
        // get the listeners.
        listeners = docEditor.getDocumentationListeners();
        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>fireDocumentationCreated(String)</code> method.
     * </p>
     */
    public void testfireDocumentationCreated() {
        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        // creat a doc.
        docEditor.fireDocumentationCreated("Created");

        // get the docListener.
        MockDocListener listener = (MockDocListener) docEditor.getDocumentationListeners()
                                                              .get(0);

        // get the created envent.
        DocumentationEvent event = listener.eventCreated;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the previousDoc to check the method.
        assertNull("The previousDoc expected to be null",
            event.getPreviousDocumentation());

        // get the currentDoc to check the method.
        assertEquals("The currentDoc expected to be equal", "Created",
            event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>fireDocumentationUpdated(String, String)</code> method.
     * </p>
     */
    public void testfireDocumentationUpdated() {
        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        // creat a doc.
        docEditor.fireDocumentationUpdated("previous", "current");

        // get the docListener.
        MockDocListener listener = (MockDocListener) docEditor.getDocumentationListeners()
                                                              .get(0);

        // get the created envent.
        DocumentationEvent event = listener.eventUpdated;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the previousDoc to check the method.
        assertEquals("The previousDoc expected to be equal", "previous",
            event.getPreviousDocumentation());

        // get the currentDoc to check the method.
        assertEquals("The currentDoc expected to be equal", "current",
            event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>fireDocumentationDeleted(String)</code> method.
     * </p>
     */
    public void testfireDocumentationDeleted() {
        // add the docListener.
        docEditor.addDocumentationListener(docListener);

        // creat a doc.
        docEditor.fireDocumentationDeleted("Deleted");

        // get the docListener.
        MockDocListener listener = (MockDocListener) docEditor.getDocumentationListeners()
                                                              .get(0);

        // get the created envent.
        DocumentationEvent event = listener.eventDeleted;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the previousDoc to check the method.
        assertEquals("The previousDoc expected to be equal", "Deleted",
            event.getPreviousDocumentation());

        // get the currentDoc to check the method.
        assertNull("The currentDoc expected to be null",
            event.getCurrentDocumentation());
    }
}


/**
 * The mock class used for test only.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
class MockDocEditor extends DocumentationEditor {
    /**
    * <p>
    * Wrap the method to make it visible for accuracy tests.
    * </p>
    *
    * @param current current doc
    */
    public void fireDocumentationCreated(String current) {
        super.fireDocumentationCreated(current);
    }

    /**
     * <p>
     * Wrap the method to make it visible for accuracy tests.
     * </p>
     *
     * @param current current doc
     * @param previous previous doc
     */
    public void fireDocumentationUpdated(String previous, String current) {
        super.fireDocumentationUpdated(previous, current);
    }

    /**
     * <p>
     * Wrap the method to make it visible for accuracy tests.
     * </p>
     *
     * @param previous previous doc
     */
    public void fireDocumentationDeleted(String previous) {
        super.fireDocumentationDeleted(previous);
    }
}
