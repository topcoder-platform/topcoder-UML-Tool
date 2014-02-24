/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains exception tests for <code>DocumentationEvent</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DocumentationEventTestExp extends TestCase {
    /**
     * <p>
     * Model element used in this test case.
     * </p>
     */
    private ModelElement element = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new OperationImpl();
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        this.element = null;
        super.tearDown();
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Model element is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testDocumentationEvent1() {
        try {
            new DocumentationEvent(null, "previousDoc", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose documentation being modified should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Both previous document and current document are null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent2() {
        try {
            new DocumentationEvent(element, null, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Both previous document and current document are empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent3() {
        try {
            new DocumentationEvent(element, "", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Both previous document and current document are empty on trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent4() {
        try {
            new DocumentationEvent(element, " ", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is null, current document is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent5() {
        try {
            new DocumentationEvent(element, null, "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is null, current document is empty on trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent6() {
        try {
            new DocumentationEvent(element, null, " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty, current document is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent7() {
        try {
            new DocumentationEvent(element, "", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty, current document is empty on trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent8() {
        try {
            new DocumentationEvent(element, "", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty on trimming, current document is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent9() {
        try {
            new DocumentationEvent(element, " ", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty on trimming, current document is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDocumentationEvent10() {
        try {
            new DocumentationEvent(element, " ", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }
}
