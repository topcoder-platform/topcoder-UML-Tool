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
 * This test case contains exception tests for <code>TagEvent</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class TagEventTestExp extends TestCase {
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
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Namespace is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testTagEvent1() {
        try {
            new TagEvent(null, taggedObject, "tagName", "previousDoc", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose tag being modified should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Tag name is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testTagEvent2() {
        try {
            new TagEvent(element, taggedObject, null, "previousDoc", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "tag name which being modified should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Tag name is empty, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testTagEvent3() {
        try {
            new TagEvent(element, taggedObject, "", "previousDoc", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "tag name which being modified should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Tag name is empty on trimming, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testTagEvent4() {
        try {
            new TagEvent(element, taggedObject, " ", "previousDoc", "currentDoc");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "tag name which being modified should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Both previous document and current document are null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent5() {
        try {
            new TagEvent(element, taggedObject, "tagName", null, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Both previous document and current document are empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent6() {
        try {
            new TagEvent(element, taggedObject, "tagName", "", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Both previous document and current document are empty on trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent7() {
        try {
            new TagEvent(element, taggedObject, "tagName", " ", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is null, current document is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent8() {
        try {
            new TagEvent(element, taggedObject, "tagName", null, "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is null, current document is empty on trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent9() {
        try {
            new TagEvent(element, taggedObject, "tagName", null, " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty, current document is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent10() {
        try {
            new TagEvent(element, taggedObject, "tagName", "", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty, current document is empty on trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent11() {
        try {
            new TagEvent(element, taggedObject, "tagName", "", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty on trimming, current document is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent12() {
        try {
            new TagEvent(element, taggedObject, "tagName", " ", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagEvent()</code>.
     * </p>
     *
     * <p>
     * Previous document is empty on trimming, current document is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testTagEvent13() {
        try {
            new TagEvent(element, taggedObject, "tagName", " ", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }
}
