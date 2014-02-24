/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.dependencies.Binding;
import com.topcoder.uml.model.core.dependencies.BindingImpl;

/**
 * Accuracy test for TemplateArgumentImpl class.
 *
 * @author oodinary
 * @version 1.0
 */
public class TemplateArgumentImplAccuracyTest extends TestCase {

    /**
     * Private instance used for test.
     */
    private TemplateArgument templateArgument = null;

    /**
     * Sets up.
     */
    protected void setUp() {
    	templateArgument = new TemplateArgumentImpl();
    }

    /**
     * Tests inheritance of TemplateArgumentImpl.
     */
    public void testTemplateArgumentImplInherit() {
        assertTrue("TemplateArgumentImpl should inherit from TemplateArgument.",
        		templateArgument instanceof TemplateArgument);
    }

    /**
     * Tests TemplateArgumentImpl().
     */
    public void testTemplateArgumentImpl() {
        assertNull("modelElement should be set correctly.", templateArgument.getModelElement());
        assertNull("binding should be set correctly.", templateArgument.getBinding());
    }
    
    /**
     * Tests get/set binding.
     */
    public void testGetSetBinding() {
    	Binding binding = new BindingImpl();
    	templateArgument.setBinding(binding);
        assertEquals("binding should be set correctly.", binding, templateArgument.getBinding());
    }
   
    /**
     * Tests get/set ModelElement.
     */
    public void testGetSetModelElement() {
    	ModelElement modelElement = new CommentImpl();
    	templateArgument.setModelElement(modelElement);
        assertEquals("binding should be set correctly.", modelElement, templateArgument.getModelElement());
    }
    


    
}




	
	