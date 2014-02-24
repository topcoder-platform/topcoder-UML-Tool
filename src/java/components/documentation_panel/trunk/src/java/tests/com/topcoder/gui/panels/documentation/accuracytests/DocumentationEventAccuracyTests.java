/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ DocumentationEventAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.event.DocumentationEvent;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The <code>DocumentationEvent</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>DocumentationEvent</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class DocumentationEventAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>DocumentationEvent</code> for test.
     * </p>
     */
    private DocumentationEvent event = null;

    /**
     * <p>
     * The instance of <code>ModelElement</code> for test.
     * </p>
     */
    private ModelElement element = null;

    /**
     * <p>
     * Test suite of <code>DocumentationEventAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DocumentationEventAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DocumentationEventAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    protected void setUp() throws Exception {
        element = new OperationImpl();
    }

    /**
     * <p>
     * Accuracy Test of the <code>DocumentationEvent(ModelElement, String, String)</code> constructor.
     * </p>
     */
    public void testconstructor() {
        event = new DocumentationEvent(element, "previous", "current");

        // creat a new instance.
        assertNotNull("Constructor should work well.", event);

        // get the element to check the constructor.
        assertEquals("The element expected to be equal", element,
            event.getModelElement());

        // get the previousDoc to check the constructor.
        assertEquals("The previousDoc expected to be equal", "previous",
            event.getPreviousDocumentation());

        // get the currentDoc to check the constructor.
        assertEquals("The currentDoc expected to be equal", "current",
            event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getModelElement()</code> method,
     * <code>getPreviousDocumentation()</code> method, <code>getCurrentDocumentation()</code> method.
     * </p>
     */
    public void testGetOperation() {
        // use a null to set the previousDoc.
        event = new DocumentationEvent(element, null, "current");

        // creat a new instance.
        assertNotNull("Constructor should work well.", event);

        // get the previousDoc to check the constructor.
        assertNull("The previousDoc expected to be null",
            event.getPreviousDocumentation());

        // get the currentDoc to check the constructor.
        assertEquals("The currentDoc expected to be equal", "current",
            event.getCurrentDocumentation());

        // use an empty string to set currentDoc.
        event = new DocumentationEvent(element, "previous", "");

        // creat a new instance.
        assertNotNull("Constructor should work well.", event);

        // get the previousDoc to check the constructor.
        assertEquals("The previousDoc expected to be equal", "previous",
            event.getPreviousDocumentation());

        // get the currentDoc to check the constructor.
        assertEquals("The currentDoc expected to be empty", "",
            event.getCurrentDocumentation());
    }
}
