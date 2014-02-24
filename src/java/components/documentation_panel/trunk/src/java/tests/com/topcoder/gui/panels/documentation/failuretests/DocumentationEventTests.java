/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.uml.model.core.AttributeImpl;

import junit.framework.TestCase;


/**
 * Test case for the class DocumentationEvent.
 *
 * @author waits
 * @version 1.0
 */
public class DocumentationEventTests extends TestCase {
    /**
     * Test the ctor with null element, iae exepected.
     */
    public void testCtor_nullElement() {
        try {
            new DocumentationEvent(null, "previous", "current");
            fail("The element should not be null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test the ctor with both null documents, iae exepected.
     */
    public void testCtor_nullDocuments() {
        try {
            new DocumentationEvent(new AttributeImpl(), null, null);
            fail("The documents should not be null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test the ctor with null current document. It is accuracy here.
     */
    public void testCtor_nullDocument() {
        new DocumentationEvent(new AttributeImpl(), "previous", null);
    }
}
