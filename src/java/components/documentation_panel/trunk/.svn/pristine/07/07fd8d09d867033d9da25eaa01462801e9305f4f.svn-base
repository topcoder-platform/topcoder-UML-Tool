/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import java.util.List;

import com.topcoder.gui.panels.documentation.event.MockTagListener;
import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.gui.panels.documentation.event.TagListener;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains accuracy tests for <code>TagEditor</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TagEditorTestAcc extends TestCase {
    /**
     * <p>
     * <code>TagEditor</code> used in this test case.
     * </p>
     */
    private TagEditor tagEditor = null;

    /**
     * <p>
     * Tag listener used in this test case.
     * </p>
     */
    private MockTagListener listener1 = null;

    /**
     * <p>
     * Tag listener used in this test case.
     * </p>
     */
    private MockTagListener listener2 = null;

    /**
     * <p>
     * Model element used in this test case.
     * </p>
     */
    private ModelElement target = null;

    /*
     * BugFix: UML-11417
     */
    /**
     * <p>
     * Tagged object used in this test case.
     * </p>
     */
    private TaggedValue taggedObject = new TaggedValueImpl();

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        this.tagEditor = new MockTagEditor();
        listener1 = new MockTagListener();
        listener2 = new MockTagListener();
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
        this.tagEditor = null;
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
        assertEquals("same target", target, this.tagEditor.getTarget());
    }

    /**
     * <p>
     * Add a target to tag editor.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    private void addTarget() throws UnknownElementTypeException {
        this.tagEditor.setTarget(target);
    }
    /**
     * <p>
     * Test accuracy of method <code>addTagListener()</code>.
     * </p>
     */
    public void testAddTagListener() {
        addListeners();
        assertListeners();
    }

    /**
     * <p>
     * Test accuracy of method <code>removeTagListener()</code>.
     * </p>
     *
     * <p>
     * Remove a null listener, the currently attached listeners should
     * not change.
     * </p>
     */
    public void testRemoveTagListener1() {
        addListeners();

        this.tagEditor.removeTagListener(null);

        assertListeners();
    }
    /**
     * <p>
     * Test accuracy of method <code>removeTagListener()</code>.
     * </p>
     *
     * <p>
     * Remove a listener which is not currently attached, the
     * attached listeners should not change.
     * </p>
     */
    public void testRemoveTagListener2() {
        addListeners();

        this.tagEditor.removeTagListener(new MockTagListener());

        assertListeners();
    }
    /**
     * <p>
     * Test accuracy of method <code>removeTagListener()</code>.
     * </p>
     *
     * <p>
     * Remove a listener which is currently attached, the
     * attached listeners should change.
     * </p>
     */
    public void testRemoveTagListener3() {
        addListeners();

        this.tagEditor.removeTagListener(listener1);

        List < TagListener > listeners = this.tagEditor.getTagListeners();
        assertEquals("size of listeners is 1", 1, listeners.size());
        assertEquals("same listener", listener2, listeners.get(0));
    }
    /**
     * <p>
     * Test accuracy of method <code>getTagListeners()</code>.
     * </p>
     */
    public void testGetTagListeners() {
        addListeners();

        assertListeners();
    }

    /**
     * <p>
     * Attach listeners to tag editor.
     * </p>
     */
    private void addListeners() {
        this.tagEditor.addTagListener(listener1);
        this.tagEditor.addTagListener(listener2);
    }
    /**
     * <p>
     * Assert current listeners attached to tag editor.
     * </p>
     */
    private void assertListeners() {
        List < TagListener > listeners = this.tagEditor.getTagListeners();

        assertEquals("size of listeners is 2", 2, listeners.size());
        assertEquals("same listener", listener1, listeners.get(0));
        assertEquals("same listener", listener2, listeners.get(1));
    }

    /**
     * <p>
     * Assert two <code>TagEvent</code> equals.
     * </p>
     *
     * @param e1 one <code>TagEvent</code>
     * @param e2 another <code>TagEvent</code>
     */
    private void assertTagEvent(TagEvent e1, TagEvent e2) {
        assertEquals(e1.getModelElement(), e2.getModelElement());
        assertEquals(e1.getTagObject(), e2.getTagObject());
        assertEquals(e1.getCurrentDocumentation(), e2.getCurrentDocumentation());
        assertEquals(e1.getPreviousDocumentation(), e2.getPreviousDocumentation());
        assertEquals(e1.getTagName(), e2.getTagName());
    }
    /**
     * <p>
     * Test accuracy of method <code>fireTagCreated()</code>.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    public void testFireTagCreated() throws UnknownElementTypeException {
        addListeners();
        addTarget();

        this.tagEditor.fireTagCreated(taggedObject, "tagName", "currentDoc");

        TagEvent e = new TagEvent(this.target, taggedObject, "tagName", null, "currentDoc");

        for (TagListener listener : tagEditor.getTagListeners()) {
            assertTagEvent(e, ((MockTagListener) listener).getFiredEvent());
            assertEquals("created event", ((MockTagListener) listener).getEventType(), "created");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    public void testFireTagUpdated() throws UnknownElementTypeException {
        addListeners();
        addTarget();

        this.tagEditor.fireTagUpdated(taggedObject, "tagName", "previousDoc", "currentDoc");

        TagEvent e = new TagEvent(this.target, taggedObject, "tagName", "previousDoc", "currentDoc");

        for (TagListener listener : tagEditor.getTagListeners()) {
            assertTagEvent(e, ((MockTagListener) listener).getFiredEvent());
            assertEquals("updated event", ((MockTagListener) listener).getEventType(), "updated");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>fireTagDeleted()</code>.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    public void testFireTagDeleted() throws UnknownElementTypeException {
        addListeners();
        addTarget();

        this.tagEditor.fireTagDeleted(taggedObject, "tagName", "previousDoc");

        TagEvent e = new TagEvent(this.target, taggedObject, "tagName", "previousDoc", null);

        for (TagListener listener : tagEditor.getTagListeners()) {
            assertTagEvent(e, ((MockTagListener) listener).getFiredEvent());
            assertEquals("deleted event", ((MockTagListener) listener).getEventType(), "deleted");
        }
    }
}
