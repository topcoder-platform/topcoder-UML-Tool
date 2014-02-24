/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ TagEditorAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.TagEditor;
import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.gui.panels.documentation.event.TagListener;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * The <code>TagEditor</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>TagEditor</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class TagEditorAccuracyTests extends TestCase {
    /**
    * <p>
    * The instance of <code>TagListener</code> for test.
    * </p>
    */
    private TagListener tagListener = null;

    /**
     * <p>
     * The instance of <code>TagEditor</code> for test.
     * </p>
     */
    private MockTagEditor tagEditor = null;

    /**
     * <p>
     * The instance of <code>ModelElement</code> for test.
     * </p>
     */
    private ModelElement element = null;

    /**
     * <p>
     * Test suite of <code>TagEditorAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>TagEditorAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(TagEditorAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    protected void setUp() throws Exception {
        tagListener = new MockTagListener();
        element = new OperationImpl();
        tagEditor = new MockTagEditor();
        tagEditor.setTarget(element);
    }

    /**
     * <p>
     * Accuracy Test of the <code>setTarget(ModelElement)</code> method.
     * </p>
     */
    public void testsetTarget() {

        // add the tagListener.
        tagEditor.addTagListener(tagListener);

        // creat a tag.
        tagEditor.fireTagCreated(new TaggedValueImpl(), "tagName", "Created");

        // get the tagListener.
        MockTagListener listener = (MockTagListener) tagEditor.getTagListeners()
                                                              .get(0);

        // get the created envent.
        TagEvent event = listener.eventCreated;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());
    }

    /**
     * <p>
     * Accuracy Test of the <code>addTagListener(TagListener)</code> method.
     * </p>
     */
    public void testaddTagListener() {
        // add the tagListener.
        tagEditor.addTagListener(tagListener);

        //get the listeners.
        List <TagListener> listeners = tagEditor.getTagListeners();

        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", tagListener,
            listeners.get(0));
    }

    /**
     * <p>
     * Accuracy Test of the <code>removeTagListener(TagListener)</code> method.
     * </p>
     */
    public void testremoveTagListener() {
        // add the tagListener.
        tagEditor.addTagListener(tagListener);

        // get the listeners.
        List <TagListener> listeners = tagEditor.getTagListeners();

        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", tagListener,
            listeners.get(0));

        // remove null element, nothin happens.
        tagEditor.removeTagListener(null);
        listeners = tagEditor.getTagListeners();
        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", tagListener,
            listeners.get(0));

        // remove non-exist element, nothin happens.
        tagEditor.removeTagListener(new MockTagListener());
        listeners = tagEditor.getTagListeners();
        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", tagListener,
            listeners.get(0));

        // remove exist element.
        tagEditor.removeTagListener(tagListener);
        listeners = tagEditor.getTagListeners();
        // get the listener to check the method.
        assertEquals("The listeners expected to have 0 element", 0,
            listeners.size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getTagListeners()</code> method.
     * </p>
     */
    public void testgetTagListeners() {
        // add the Listener.
        tagEditor.addTagListener(tagListener);
        tagEditor.addTagListener(new MockTagListener());

        // get the listeners.
        List <TagListener> listeners = tagEditor.getTagListeners();

        // get the listener to check the method.
        assertEquals("The listeners expected to have 2 elements", 2,
            listeners.size());

        // get the listener to check the method.
        assertEquals("The listener expected to be equal", tagListener,
            listeners.get(0));

        // remove exist element.
        tagEditor.removeTagListener(tagListener);
        // get the listeners.
        listeners = tagEditor.getTagListeners();
        // get the listener to check the method.
        assertEquals("The listeners expected to have 1 element", 1,
            listeners.size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>fireTagCreated(String)</code> method.
     * </p>
     */
    public void testfireTagCreated() {
        // add the tagListener.
        tagEditor.addTagListener(tagListener);

        // creat a tag.
        tagEditor.fireTagCreated(new TaggedValueImpl(), "tagName", "Created");

        // get the tagListener.
        MockTagListener listener = (MockTagListener) tagEditor.getTagListeners()
                                                              .get(0);

        // get the created envent.
        TagEvent event = listener.eventCreated;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the tagName to check the method.
        assertEquals("The tagName expected to be equal", "tagName",
            event.getTagName());

        // get the previousDoc to check the method.
        assertNull("The previousDoc expected to be null",
            event.getPreviousDocumentation());

        // get the currentDoc to check the method.
        assertEquals("The currentDoc expected to be equal", "Created",
            event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>fireTagUpdated(String, String)</code> method.
     * </p>
     */
    public void testfireTagUpdated() {
        // add the tagListener.
        tagEditor.addTagListener(tagListener);

        // creat a tag.
        tagEditor.fireTagUpdated(new TaggedValueImpl(), "tagName", "previous", "current");

        // get the tagListener.
        MockTagListener listener = (MockTagListener) tagEditor.getTagListeners()
                                                              .get(0);

        // get the created envent.
        TagEvent event = listener.eventUpdated;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the tagName to check the method.
        assertEquals("The tagName expected to be equal", "tagName",
            event.getTagName());

        // get the previousDoc to check the method.
        assertEquals("The previousDoc expected to be equal", "previous",
            event.getPreviousDocumentation());

        // get the currentDoc to check the method.
        assertEquals("The currentDoc expected to be equal", "current",
            event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>fireTagDeleted(String)</code> method.
     * </p>
     */
    public void testfireTagDeleted() {
        // add the tagListener.
        tagEditor.addTagListener(tagListener);

        // creat a tag.
        tagEditor.fireTagDeleted(new TaggedValueImpl(), "tagName", "Deleted");

        // get the tagListener.
        MockTagListener listener = (MockTagListener) tagEditor.getTagListeners()
                                                              .get(0);

        // get the created envent.
        TagEvent event = listener.eventDeleted;

        // get the ModelElement to check the method.
        assertEquals("The ModelElement expected to be equal", element,
            event.getModelElement());

        // get the tagName to check the method.
        assertEquals("The tagName expected to be equal", "tagName",
            event.getTagName());

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
class MockTagEditor extends TagEditor {
    /**
    * <p>
    * Wrap the method to make it visible for accuracy tests.
    * </p>
    *
    * @param tagObject The object to be created
    * @param tagName tag name
    * @param current current doc
    */
    public void fireTagCreated(TaggedValue tagObject, String tagName, String current) {
        super.fireTagCreated(tagObject, tagName, current);
    }

    /**
     * <p>
     * Wrap the method to make it visible for accuracy tests.
     * </p>
     *
     * @param tagObject The object to be updated
     * @param tagName tag name
     * @param previous previous doc
     * @param current current doc
     */
    public void fireTagUpdated(TaggedValue tagObject, String tagName, String previous, String current) {
        super.fireTagUpdated(tagObject, tagName, previous, current);
    }

    /**
     * <p>
     * Wrap the method to make it visible for accuracy tests.
     * </p>
     *
     * @param tagObject The object to be deleted
     * @param tagName tag name
     * @param previous previous doc
     */
    public void  fireTagDeleted(TaggedValue tagObject, String tagName, String previous) {
        super.fireTagDeleted(tagObject, tagName, previous);
    }
}
