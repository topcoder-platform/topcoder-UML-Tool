/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;


/**
 * <p>
 * This test case contains exception tests for <code>TagEditor</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TagEditorTestExp extends TestCase {
    /**
     * <p>
     * <code>TagEditor</code> used in this test case.
     * </p>
     */
    private TagEditor tagEditor = null;

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
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        this.tagEditor = null;
        super.tearDown();
    }

    /**
     * <p>
     * Test exception of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * Target is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws UnknownElementTypeException to JUnit
     */
    public void testSetTarget() throws UnknownElementTypeException {
        try {
            this.tagEditor.setTarget(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose tag to be managed should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>addTagListener()</code>.
     * </p>
     *
     * <p>
     * Listener is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testAddTagListener() {
        try {
            this.tagEditor.addTagListener(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "TagListener to be attached should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagCreated()</code>.
     * </p>
     *
     * <p>
     * Document being created is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagCreated1() {
        try {
            this.tagEditor.fireTagCreated(new TaggedValueImpl(), "tagName", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current tag documentation being created should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagCreated()</code>.
     * </p>
     *
     * <p>
     * Document being created is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagCreated2() {
        try {
            this.tagEditor.fireTagCreated(new TaggedValueImpl(), "tagName", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current tag documentation being created should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagCreated()</code>.
     * </p>
     *
     * <p>
     * Document being created is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagCreated3() {
        try {
            this.tagEditor.fireTagCreated(new TaggedValueImpl(), "tagName", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current tag documentation being created should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagCreated()</code>.
     * </p>
     *
     * <p>
     * Tag name is being created null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagCreated4() {
        try {
            this.tagEditor.fireTagCreated(new TaggedValueImpl(), null, "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being created should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagCreated()</code>.
     * </p>
     *
     * <p>
     * Tag name being created is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagCreated5() {
        try {
            this.tagEditor.fireTagCreated(new TaggedValueImpl(), "", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being created should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagCreated()</code>.
     * </p>
     *
     * <p>
     * Tag name being created is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagCreated6() {
        try {
            this.tagEditor.fireTagCreated(new TaggedValueImpl(), " ", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being created should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Previous document is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated1() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), "tagName", null, "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous tag documentation being updated should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated2() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), "tagName", "", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous tag documentation being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated3() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), "tagName", " ", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous tag documentation being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Current document is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated4() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), "tagName", "previousDoc", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current tag documentation being updated should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Current document is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated5() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), "tagName", "previousDoc", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current tag documentation being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Current document is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated6() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), "tagName", "previousDoc", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current tag documentation being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Tag name being updated is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated7() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), null, "previousDoc", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being updated should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Tag name being updated is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated8() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), "", "previousDoc", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagUpdated()</code>.
     * </p>
     *
     * <p>
     * Tag name being updated is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagUpdated9() {
        try {
            this.tagEditor.fireTagUpdated(new TaggedValueImpl(), " ", "previousDoc", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagDeleted()</code>.
     * </p>
     *
     * <p>
     * Document being deleted is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagDeleted1() {
        try {
            this.tagEditor.fireTagDeleted(new TaggedValueImpl(), "tagName", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous tag documentation being deleted should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagDeleted()</code>.
     * </p>
     *
     * <p>
     * Document being deleted is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagDeleted2() {
        try {
            this.tagEditor.fireTagDeleted(new TaggedValueImpl(), "tagName", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous tag documentation being deleted should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagDeleted()</code>.
     * </p>
     *
     * <p>
     * Document being deleted is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagDeleted3() {
        try {
            this.tagEditor.fireTagDeleted(new TaggedValueImpl(), "tagName", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous tag documentation being deleted should not be empty (trimmed).");
        }
    }
    /**
     * <p>
     * Test exception of method <code>fireTagDeleted()</code>.
     * </p>
     *
     * <p>
     * Tag name being deleted is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagDeleted4() {
        try {
            this.tagEditor.fireTagDeleted(new TaggedValueImpl(), null, "previousDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being deleted should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagDeleted()</code>.
     * </p>
     *
     * <p>
     * Tag name being deleted is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagDeleted5() {
        try {
            this.tagEditor.fireTagDeleted(new TaggedValueImpl(), "", "previousDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being deleted should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireTagDeleted()</code>.
     * </p>
     *
     * <p>
     * Tag name being deleted is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireTagDeleted6() {
        try {
            this.tagEditor.fireTagDeleted(new TaggedValueImpl(), " ", "previousDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name being deleted should not be empty (trimmed).");
        }
    }
}
