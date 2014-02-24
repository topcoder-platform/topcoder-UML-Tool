/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests;

import com.topcoder.uml.actions.project.CreateNewProjectAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>CreateNewProjectAction</code> class.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CreateNewProjectActionFailureTest extends TestCase {
    /**
     * The model manager used in construct CreateNewProjectAction.
     */
    private UMLModelManager modelManager;
    
    /**
     * Create instance of UMLModelManager.
     * 
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        modelManager = UMLModelManager.getInstance();
    }
    
    /**
     * Test ctor CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager),
     * when projectLanguage is null, IllegalArgumentException is expected.
     */
    public void testCtor1_ProjectLanguageIsNull() {
        try {
            new CreateNewProjectAction(null, modelManager);
            fail("when projectLanguage is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager),
     * when projectLanguage is empty, IllegalArgumentException is expected.
     */
    public void testCtor1_ProjectLanguageIsEmpty() {
        try {
            new CreateNewProjectAction(" \t \r \n ", modelManager);
            fail("when projectLanguage is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager),
     * when modelManager is null, IllegalArgumentException is expected.
     */
    public void testCtor1_ModelManagerIsNull() {
        try {
            new CreateNewProjectAction("mock", null);
            fail("when modelManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
}
