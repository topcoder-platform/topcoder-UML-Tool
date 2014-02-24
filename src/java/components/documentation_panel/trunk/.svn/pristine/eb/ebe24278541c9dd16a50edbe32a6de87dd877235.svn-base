/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains accuracy tests for
 * <code>TagEvent</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class TagEventTestAcc extends TestCase {

    /**
     * <p>
     * Tag event used in the test case.
     * </p>
     */
    private TagEvent tagEvent = null;

    /**
     * <p>
     * Model element used in this test case.
     * </p>
     */
    private ModelElement element = null;

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
        element = new OperationImpl();
        tagEvent = new TagEvent(element, taggedObject, "tagName"
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
        this.element = null;
        this.tagEvent = null;
        super.tearDown();
    }

    /**
     * <p>
     * Test accuracy of method <code>TagEvent()</code>.
     * </p>
     */
    public void testTagEvent1() {
        assertNotNull(tagEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Current documentation is not empty, previous documentation
     * is allowed to be null.
     * </p>
     */
    public void testTagEvent2() {
        tagEvent = new TagEvent(element, taggedObject, "tagName"
            , null, "currentDoc");
        assertNotNull(tagEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Current documentation is not empty, previous documentation
     * is allowed to be empty.
     * </p>
     */
    public void testTagEvent3() {
        tagEvent = new TagEvent(element, taggedObject, "tagName"
            , "", "currentDoc");
        assertNotNull(tagEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Current documentation is not empty, previous documentation
     * is allowed to be empty after trimming.
     * </p>
     */
    public void testTagEvent4() {
        tagEvent = new TagEvent(element, taggedObject, "tagName"
            , " ", "currentDoc");
        assertNotNull(tagEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous documentation is not empty, current documentation
     * is allowed to be null.
     * </p>
     */
    public void testTagEvent5() {
        tagEvent = new TagEvent(element, taggedObject, "tagName"
            , "previousDoc", null);
        assertNotNull(tagEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous documentation is not empty, current documentation
     * is allowed to be empty.
     * </p>
     */
    public void testTagEvent6() {
        tagEvent = new TagEvent(element, taggedObject, "tagName"
            , "previousDoc", "");
        assertNotNull(tagEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous documentation is not empty, current documentation
     * is allowed to be empty after trimming.
     * </p>
     */
    public void testTagEvent7() {
        tagEvent = new TagEvent(element, taggedObject, "tagName"
            , "previousDoc", " ");
        assertNotNull(tagEvent);
    }

    /**
     * <p>
     * Test accuracy of method <code>getModelElement()</code>.
     * </p>
     */
    public void testGetModelElement() {
        assertEquals(this.tagEvent.getModelElement(), this.element);
    }

    /**
     * <p>
     * Test accuracy of method <code>getTagName()</code>.
     * </p>
     */
    public void testGetTagName() {
        assertEquals(this.tagEvent.getTagName(), "tagName");
    }

    /**
     * <p>
     * Test accuracy of method <code>getPreviousDocumentation()</code>.
     * </p>
     */
    public void testGetPreviousDocumentation() {
        assertEquals(this.tagEvent.getPreviousDocumentation(), "previousDoc");
    }

    /**
     * <p>
     * Test accuracy of method <code>getCurrentDocumentation()</code>.
     * </p>
     */
    public void testGetCurrentDocumentation() {
        assertEquals(this.tagEvent.getCurrentDocumentation(), "currentDoc");
    }
}
