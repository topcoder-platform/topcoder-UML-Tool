/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;


/**
 * Test cases for the class TagEvent.
 *
 * @author waits
 * @version 1.0
 */
public class TagEventTests extends TestCase {
    /**
     * Test the ctor with null element, iae exepected.
     */
    public void testCtor_nullElement() {
        try {
            new TagEvent(null, new TaggedValueImpl(), "exception", "previous", "current");
            fail("The element should not be null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test the ctor with null name, iae exepected.
     */
    public void testCtor_nullDocuments() {
        try {
            new TagEvent(new AttributeImpl(), new TaggedValueImpl(), null, null, null);
            fail("The name should not be null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test the ctor with both null documents. iae expected.
     */
    public void testCtor_nullDocument() {
        try {
            new TagEvent(new AttributeImpl(), new TaggedValueImpl(), "Exception", null, null);
            fail("The both null documents should not be null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Accuracy test case.
     */
    public void testCtor() {
        new TagEvent(new AttributeImpl(), new TaggedValueImpl(), "Exception", "previous", null);
        new TagEvent(new AttributeImpl(), new TaggedValueImpl(), "Exception", null, "current");
    }
}
