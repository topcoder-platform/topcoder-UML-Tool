/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ TagEventAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.event.TagEvent;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The <code>TagEvent</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>TagEvent</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class TagEventAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>TagEvent</code> for test.
     * </p>
     */
    private TagEvent event = null;

    /**
     * <p>
     * The instance of <code>ModelElement</code> for test.
     * </p>
     */
    private ModelElement element = null;

    /**
     * <p>
     * Test suite of <code>TagEventAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>TagEventAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(TagEventAccuracyTests.class);
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
     * Accuracy Test of the <code>TagEvent(ModelElement, String, String, String)</code> constructor.
     * </p>
     */
    public void testconstructor() {
        TaggedValue taggedObject = new TaggedValueImpl();
        event = new TagEvent(element, taggedObject, "tagName", "previous", "current");

        // creat a new instance.
        assertNotNull("Constructor should work well.", event);

        // get the element to check the constructor.
        assertEquals("The element expected to be equal", element,
            event.getModelElement());

        // get the tagged object to check the constructor.
        assertEquals("The tagged object expected to be equal", taggedObject,
            event.getTagObject());

        // get the tagName to check the constructor.
        assertEquals("The tagName expected to be equal", "tagName",
            event.getTagName());

        // get the previousDoc to check the constructor.
        assertEquals("The previousDoc expected to be equal", "previous",
            event.getPreviousDocumentation());

        // get the currentDoc to check the constructor.
        assertEquals("The currentDoc expected to be equal", "current",
            event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getModelElement()</code> method, <code>getTagName()</code> method,
     * <code>getPreviousDocumentation()</code> method, <code>getCurrentDocumentation()</code> method.
     * </p>
     */
    public void testGetOperation() {
        TaggedValue taggedObject = new TaggedValueImpl();
        // use a null to set the previousDoc.
        event = new TagEvent(element, taggedObject, "tagName", null, "current");

        // creat a new instance.
        assertNotNull("Constructor should work well.", event);

        // get the tagged object to check the constructor.
        assertEquals("The tagged object expected to be equal", taggedObject,
            event.getTagObject());

        // get the tagName to check the constructor.
        assertEquals("The tagName expected to be equal", "tagName",
            event.getTagName());

        // get the previousDoc to check the constructor.
        assertNull("The previousDoc expected to be null",
            event.getPreviousDocumentation());

        // get the currentDoc to check the constructor.
        assertEquals("The currentDoc expected to be equal", "current",
            event.getCurrentDocumentation());

        // use an empty string to set currentDoc.
        event = new TagEvent(element, taggedObject, "tagName", "previous", "");

        // creat a new instance.
        assertNotNull("Constructor should work well.", event);

        // get the tagged object to check the constructor.
        assertEquals("The tagged object expected to be equal", taggedObject,
            event.getTagObject());

        // get the tagName to check the constructor.
        assertEquals("The tagName expected to be equal", "tagName",
            event.getTagName());

        // get the previousDoc to check the constructor.
        assertEquals("The previousDoc expected to be equal", "previous",
            event.getPreviousDocumentation());

        // get the currentDoc to check the constructor.
        assertEquals("The currentDoc expected to be empty", "",
            event.getCurrentDocumentation());
    }
}
