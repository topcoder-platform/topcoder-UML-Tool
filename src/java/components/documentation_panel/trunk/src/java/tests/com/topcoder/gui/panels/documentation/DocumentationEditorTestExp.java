/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains exception tests for <code>DocumentationEditor</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DocumentationEditorTestExp extends TestCase {
    /**
     * <p>
     * <code>DocumentationEditor</code> used in this test case.
     * </p>
     */
    private DocumentationEditor documentationEditor = null;

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
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        this.documentationEditor = null;
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
            this.documentationEditor.setTarget(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose documentation to be managed should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>addDocumentationListener()</code>.
     * </p>
     *
     * <p>
     * Listener is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testAddDocumentationListener() {
        try {
            this.documentationEditor.addDocumentationListener(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "DocumentationListener to be attached should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationCreated()</code>.
     * </p>
     *
     * <p>
     * Document being created is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationCreated1() {
        try {
            this.documentationEditor.fireDocumentationCreated(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current documentation being created should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationCreated()</code>.
     * </p>
     *
     * <p>
     * Document being created is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationCreated2() {
        try {
            this.documentationEditor.fireDocumentationCreated("");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current documentation being created should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationCreated()</code>.
     * </p>
     *
     * <p>
     * Document being created is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationCreated3() {
        try {
            this.documentationEditor.fireDocumentationCreated(" ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current documentation being created should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationUpdated()</code>.
     * </p>
     *
     * <p>
     * Previous document is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationUpdated1() {
        try {
            this.documentationEditor.fireDocumentationUpdated(null, "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous documentation being updated should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationUpdated()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationUpdated2() {
        try {
            this.documentationEditor.fireDocumentationUpdated("", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous documentation being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationUpdated()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationUpdated3() {
        try {
            this.documentationEditor.fireDocumentationUpdated(" ", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous documentation being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationUpdated()</code>.
     * </p>
     *
     * <p>
     * Current document is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationUpdated4() {
        try {
            this.documentationEditor.fireDocumentationUpdated("previousDoc", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current documentation being updated should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationUpdated()</code>.
     * </p>
     *
     * <p>
     * Current document is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationUpdated5() {
        try {
            this.documentationEditor.fireDocumentationUpdated("previousDoc", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current documentation being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationUpdated()</code>.
     * </p>
     *
     * <p>
     * Current document is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationUpdated6() {
        try {
            this.documentationEditor.fireDocumentationUpdated("previousDoc", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Current documentation being updated should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationDeleted()</code>.
     * </p>
     *
     * <p>
     * Document being deleted is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationDeleted1() {
        try {
            this.documentationEditor.fireDocumentationDeleted(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous documentation being deleted should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationDeleted()</code>.
     * </p>
     *
     * <p>
     * Document being deleted is empty, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationDeleted2() {
        try {
            this.documentationEditor.fireDocumentationDeleted("");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous documentation being deleted should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>fireDocumentationDeleted()</code>.
     * </p>
     *
     * <p>
     * Document being deleted is empty on trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testFireDocumentationDeleted3() {
        try {
            this.documentationEditor.fireDocumentationDeleted(" ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Previous documentation being deleted should not be empty (trimmed).");
        }
    }
}
