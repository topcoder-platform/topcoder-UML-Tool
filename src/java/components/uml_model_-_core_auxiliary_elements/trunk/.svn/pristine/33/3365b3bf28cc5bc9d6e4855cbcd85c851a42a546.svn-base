/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements.failuretests;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Unit tests for CommentImpl class.
 * @author crackme
 * @version 1.0
 */
public class TestCommentImpl extends TestCase {
	
	/**
	 * CommentImpl used to test.
	 */
    private CommentImpl coment = new CommentImpl();

    /**
     * Tests addAnnotatedElement(ModelElement annotatedElement) method with null ModelElement annotatedElement,
     * Expected IllegalArgumentException.
     */
    public void testAddAnnotatedElement_NullAnnotatedElement() {
        try {
            coment.addAnnotatedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests addAnnotatedElements(Collection) method with null annotatedElements,
     * Expected IllegalArgumentException.
     */
    public void testAddAnnotatedElements_NullAnnotatedElements() {
        try {
            coment.addAnnotatedElements(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests addAnnotatedElements(Collection) method with null annotatedElements,
     * Expected IllegalArgumentException.
     */
    public void testAddAnnotatedElements_NullWithAnnotatedElements() {
        Collection<ModelElement> elements = new ArrayList<ModelElement>();
        elements.add(null);

        try {
            coment.addAnnotatedElements(elements);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeAnnotatedElement(ModelElement annotatedElement) method with null ModelElement annotatedElement,
     * Expected IllegalArgumentException.
     */
    public void testRemoveAnnotatedElement_NullAnnotatedElement() {
        try {
            coment.removeAnnotatedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeAnnotatedElements(annotatedElements) method with null annotatedElements,
     * Expected IllegalArgumentException.
     */
    public void testRemoveAnnotatedElements_NullAnnotatedElements() {
        try {
            coment.removeAnnotatedElements(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeAnnotatedElements(annotatedElements) method with null with annotatedElements,
     * Expected IllegalArgumentException.
     */
    public void testRemoveAnnotatedElements_NullWithAnnotatedElements() {
        Collection<ModelElement> elements = new ArrayList<ModelElement>();
        elements.add(null);

        try {
            coment.removeAnnotatedElements(elements);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests containsAnnotatedElement(ModelElement annotatedElement) method with null ModelElement annotatedElement,
     * Expected IllegalArgumentException.
     */
    public void testContainsAnnotatedElement_NullAnnotatedElement() {
        try {
        	coment.containsAnnotatedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }
}
