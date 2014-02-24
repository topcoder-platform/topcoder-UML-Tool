/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * This test case contains accuracy tests for
 * <code>DocumentationEvent</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DocumentationEventTestAcc extends TestCase {

    /**
     * <p>
     * Documentation event used in the test case.
     * </p>
     */
    private DocumentationEvent docEvent = null;

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
        docEvent = new DocumentationEvent(element
            , "previousDoc", "currentDoc");
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        docEvent = null;
        element = null;
        super.tearDown();
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationEvent()</code>.
     * </p>
     */
    public void testDocumentationEvent1() {
        assertNotNull(docEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Current documentation is not empty, previous documentation
     * is allowed to be null.
     * </p>
     */
    public void testDocumentationEvent2() {
        docEvent = new DocumentationEvent(element
            , null, "currentDoc");
        assertNotNull(docEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Current documentation is not empty, previous documentation
     * is allowed to be empty.
     * </p>
     */
    public void testDocumentationEvent3() {
        docEvent = new DocumentationEvent(element
            , "", "currentDoc");
        assertNotNull(docEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Current documentation is not empty, previous documentation
     * is allowed to be empty after trimming.
     * </p>
     */
    public void testDocumentationEvent4() {
        docEvent = new DocumentationEvent(element
            , " ", "currentDoc");
        assertNotNull(docEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous documentation is not empty, current documentation
     * is allowed to be null.
     * </p>
     */
    public void testDocumentationEvent5() {
        docEvent = new DocumentationEvent(element
            , "previousDoc", null);
        assertNotNull(docEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous documentation is not empty, current documentation
     * is allowed to be empty.
     * </p>
     */
    public void testDocumentationEvent6() {
        docEvent = new DocumentationEvent(element
            , "previousDoc", "");
        assertNotNull(docEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationEvent()</code>.
     * </p>
     *
     * <p>
     * Previous documentation is not empty, current documentation
     * is allowed to be empty after trimming.
     * </p>
     */
    public void testDocumentationEvent7() {
        docEvent = new DocumentationEvent(element
            , "previousDoc", " ");
        assertNotNull(docEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>getModelElement()</code>.
     * </p>
     */
    public void testGetModelElement() {
        assertEquals(this.docEvent.getModelElement(), this.element);
    }

    /**
     * <p>
     * Test accuracy of method <code>getPreviousDocumentation()</code>.
     * </p>
     */
    public void testGetPreviousDocumentation() {
        assertEquals(this.docEvent.getPreviousDocumentation(), "previousDoc");
    }

    /**
     * <p>
     * Test accuracy of method <code>getCurrentDocumentation()</code>.
     * </p>
     */
    public void testGetCurrentDocumentation() {
        assertEquals(this.docEvent.getCurrentDocumentation(), "currentDoc");
    }
}
