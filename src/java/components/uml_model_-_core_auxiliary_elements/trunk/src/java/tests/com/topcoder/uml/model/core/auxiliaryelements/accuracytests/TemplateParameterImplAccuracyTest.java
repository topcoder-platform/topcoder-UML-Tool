/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;

/**
 * Accuracy test for TemplateParameterImpl class.
 *
 * @author oodinary
 * @version 1.0
 */
public class TemplateParameterImplAccuracyTest extends TestCase {

    /**
     * Private instance used for test.
     */
    private TemplateParameter templateParameter = null;

    /**
     * Sets up.
     */
    protected void setUp() {
    	templateParameter = new TemplateParameterImpl();
    }

    /**
     * Tests inheritance of TemplateParameterImpl.
     */
    public void testTemplateParameterImplInherit() {
        assertTrue("TemplateParameterImpl should inherit from TemplateParameter.",
        		templateParameter instanceof TemplateParameter);
    }

    /**
     * Tests TemplateParameterImpl().
     */
    public void testTemplateParameterImpl() {
        assertNull("parameter should be set correctly.", templateParameter.getParameter());
        assertNull("defaultElement should be set correctly.", templateParameter.getDefaultElement());
        assertNull("template should be set correctly.", templateParameter.getTemplate());
    }
    
    /**
     * Tests get/set parameter.
     */
    public void testGetSetParameter() {
    	ModelElement modelElement = new CommentImpl();
    	templateParameter.setParameter(modelElement);
        assertEquals("Parameter should be set correctly.", modelElement, templateParameter.getParameter());
    }
    
    /**
     * Tests get/set defaultElement.
     */
    public void testGetSetDefaultElement() {
    	ModelElement modelElement = new CommentImpl();
    	templateParameter.setDefaultElement(modelElement);
        assertEquals("DefaultElement should be set correctly.", modelElement, templateParameter.getDefaultElement());
    }
    
    /**
     * Tests get/set template.
     */
    public void testGetSetTemplate() {
    	ModelElement modelElement = new CommentImpl();
    	templateParameter.setTemplate(modelElement);
        assertEquals("Template should be set correctly.", modelElement, templateParameter.getTemplate());
    }
    
}




	
	