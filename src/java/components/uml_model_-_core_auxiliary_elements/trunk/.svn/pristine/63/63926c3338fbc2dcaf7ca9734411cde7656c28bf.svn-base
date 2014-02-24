/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * Accuracy test for CommentImpl class.
 *
 * @author oodinary
 * @version 1.0
 */
public class CommentImplAccuracyTest extends TestCase {

    /**
     * Private instance used for test.
     */
    private Comment comment = null;

    /**
     * Sets up.
     */
    protected void setUp() {
    	comment = new CommentImpl();
    }

    /**
     * Tests inheritance of CommentImpl.
     */
    public void testCommentImplInherit1() {
        assertTrue("CommentImpl should inherit from ModelElementAbstractImpl.",
        		comment instanceof ModelElementAbstractImpl);
    }

    /**
     * Tests inheritance of CommentImpl.
     */
    public void testCommentImplInherit2() {
        assertTrue("CommentImpl should inherit from Comment.",
        		comment instanceof Comment);
    }

    /**
     * Tests CommentImpl().
     */
    public void testCommentImpl() {
        assertEquals("AnnotatedElements should be set correctly.", 0, comment.getAnnotatedElements().size());
        assertNull("Body should be set correctly.", comment.getBody());
    }
    
    /**
     * Tests get/set body.
     */
    public void testGetSetBody1() {
    	comment.setBody(null);
        assertNull("Body should be set correctly.", comment.getBody());
    }
    
    /**
     * Tests get/set body.
     */
    public void testGetSetBody2() {
    	comment.setBody("");
        assertEquals("Body should be set correctly.", "", comment.getBody());
    }
    
    /**
     * Tests get/set body.
     */
    public void testGetSetBody3() {
    	comment.setBody("body");
        assertEquals("Body should be set correctly.", "body", comment.getBody());
    }
    
    /**
     * Tests addAnnotatedElement().
     */
    public void testAddAnnotatedElement1() {
    	ModelElement e = new CommentImpl();
    	comment.addAnnotatedElement(e);
        assertEquals("Element should be added correctly.", 1, comment.countAnnotatedElements());
        assertEquals("Element should be added correctly.", e, comment.getAnnotatedElements().toArray()[0]);
    }
    
    /**
     * Tests addAnnotatedElement().
     */
    public void testAddAnnotatedElement2() {
    	ModelElement e = new CommentImpl();
    	comment.addAnnotatedElement(e);
    	comment.addAnnotatedElement(e);
        assertEquals("Element should be added correctly.", 2, comment.countAnnotatedElements());
        assertEquals("Element should be added correctly.", e, comment.getAnnotatedElements().toArray()[0]);
        assertEquals("Element should be added correctly.", e, comment.getAnnotatedElements().toArray()[1]);
    }
    
    /**
     * Tests addAnnotatedElements().
     */
    public void testAddAnnotatedElements() {
    	ModelElement e1 = new CommentImpl();
    	ModelElement e2 = new CommentImpl();
    	Collection<ModelElement> c = new ArrayList<ModelElement>();
    	c.add(e1);
    	c.add(e2);
    	c.add(e1);
    	    	
    	comment.addAnnotatedElements(c);
        assertEquals("Element should be added correctly.", 3, comment.countAnnotatedElements());
        assertEquals("Element should be added correctly.", e1, comment.getAnnotatedElements().toArray()[0]);
        assertEquals("Element should be added correctly.", e2, comment.getAnnotatedElements().toArray()[1]);
        assertEquals("Element should be added correctly.", e1, comment.getAnnotatedElements().toArray()[2]);
    }
    
    /**
     * Tests removeAnnotatedElement().
     */
    public void testRemoveAnnotatedElement1() {
    	ModelElement e1 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e1);
    	
    	assertTrue("Element should be removed correctly.", comment.removeAnnotatedElement(e1));
    	
    	assertEquals("Element should be removed correctly.", 1, comment.countAnnotatedElements());
        assertEquals("Element should be removed correctly.", e1, comment.getAnnotatedElements().toArray()[0]);        
    }
    
    
    /**
     * Tests removeAnnotatedElement().
     */
    public void testRemoveAnnotatedElement2() {
    	ModelElement e1 = new CommentImpl();
    	ModelElement e2 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e1);
    	
    	assertFalse("Element should not be removed.", comment.removeAnnotatedElement(e2));
    	
    	assertEquals("Element should not be removed.", 2, comment.countAnnotatedElements());
        assertEquals("Element should not be removed.", e1, comment.getAnnotatedElements().toArray()[0]);        
        assertEquals("Element should not be removed.", e1, comment.getAnnotatedElements().toArray()[1]);
    }
    
    /**
     * Tests removeAnnotatedElements().
     */
    public void testRemoveAnnotatedElements1() {
    	ModelElement e1 = new CommentImpl();
    	ModelElement e2 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e2);
    	comment.addAnnotatedElement(e1);
    	
    	Collection<ModelElement> c = new ArrayList<ModelElement>();
    	c.add(e1);
    	c.add(e1);
    	c.add(e2);
    	
    	assertTrue("Elements should be removed.", comment.removeAnnotatedElements(c));
    	
    	assertEquals("Element should be removed correctly.", 0, comment.countAnnotatedElements());        
    }
    
    /**
     * Tests removeAnnotatedElements().
     */
    public void testRemoveAnnotatedElements2() {
    	ModelElement e1 = new CommentImpl();
    	ModelElement e2 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e2);
    	comment.addAnnotatedElement(e1);
    	
    	Collection<ModelElement> c = new ArrayList<ModelElement>();
    	c.add(e1);
    	
    	assertTrue("Elements should be removed.", comment.removeAnnotatedElements(c));
    	
    	assertEquals("Element should be removed correctly.", 2, comment.countAnnotatedElements());
        assertEquals("Element should be removed correctly.", e2, comment.getAnnotatedElements().toArray()[0]);
        assertEquals("Element should be removed correctly.", e1, comment.getAnnotatedElements().toArray()[1]);
    }
    
    /**
     * Tests removeAnnotatedElements().
     */
    public void testRemoveAnnotatedElements3() {
    	ModelElement e1 = new CommentImpl();
    	ModelElement e2 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e1);
    	
    	Collection<ModelElement> c = new ArrayList<ModelElement>();
    	c.add(e2);
    	
    	assertFalse("Elements should be removed.", comment.removeAnnotatedElements(c));
    	
    	assertEquals("Element should be removed correctly.", 2, comment.countAnnotatedElements());
        assertEquals("Element should be removed correctly.", e1, comment.getAnnotatedElements().toArray()[0]);        
        assertEquals("Element should be removed correctly.", e1, comment.getAnnotatedElements().toArray()[1]);
    }
    
    /**
     * Tests clearAnnotatedElement().
     */
    public void testClearAnnotatedElement() {
    	ModelElement e1 = new CommentImpl();
    	ModelElement e2 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e2);
    	comment.addAnnotatedElement(e1);
    	
    	comment.clearAnnotatedElements();    	
    	
    	assertEquals("Element should be removed correctly.", 0, comment.countAnnotatedElements());  
    }
    
    /**
     * Tests containsAnnotatedElement().
     */
    public void testContainsAnnotatedElement1() {
    	ModelElement e1 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	    	
    	assertTrue("Element should be added.", comment.containsAnnotatedElement(e1));  
    }
    
    /**
     * Tests containsAnnotatedElement().
     */
    public void testContainsAnnotatedElement2() {
    	ModelElement e1 = new CommentImpl();
    	    	
    	assertFalse("Element should be not added.", comment.containsAnnotatedElement(e1));  
    }
    
    
    /**
     * Tests countAnnotatedElements().
     */
    public void testCountAnnotatedElements() {
    	ModelElement e1 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e1);
    	    	
    	assertEquals("Element should be not added.", 2, comment.countAnnotatedElements());  
    }
    
    /**
     * Tests getAnnotatedElements().
     */
    public void testGetAnnotatedElements1() {
    	ModelElement e1 = new CommentImpl();
    	ModelElement e2 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e2);
    	
    	Collection<ModelElement> c = comment.getAnnotatedElements();
    	        	
    	assertEquals("Element should be removed correctly.", 2, c.size());
        assertEquals("Element should be removed correctly.", e1, c.toArray()[0]);        
        assertEquals("Element should be removed correctly.", e2, c.toArray()[1]);
    }
    
    /**
     * Tests getAnnotatedElements().
     */
    public void testGetAnnotatedElements2() {
    	ModelElement e1 = new CommentImpl();
    	ModelElement e2 = new CommentImpl();
    	comment.addAnnotatedElement(e1);
    	comment.addAnnotatedElement(e2);
    	
    	Collection<ModelElement> c = comment.getAnnotatedElements();
    	c.clear();
    	        	
    	assertEquals("Element should be removed correctly.", 2, comment.countAnnotatedElements());
        assertEquals("Element should be removed correctly.", e1, comment.getAnnotatedElements().toArray()[0]);        
        assertEquals("Element should be removed correctly.", e2, comment.getAnnotatedElements().toArray()[1]);
    }

    
}


