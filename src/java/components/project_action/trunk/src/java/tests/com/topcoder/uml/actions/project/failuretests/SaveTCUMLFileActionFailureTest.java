/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests;

import java.io.File;

import com.topcoder.uml.actions.project.SaveTCUMLFileAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>SaveTCUMLFileAction</code> class.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SaveTCUMLFileActionFailureTest extends TestCase {    
    /**
     * The model manager used to construct SaveTCUMLFileAction.
     */
    private UMLModelManager manager;
    
    /**
     * Set up for each test.
     * 
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        manager = UMLModelManager.getInstance();
    }
    
    /**
     * Test ctor SaveTCUMLFileAction(File tcUMLFile, boolean withDiagramData,
     * UMLModelManager modelManager) , when tcUMLFile is null,
     * IllegalArgumentException is expected.
     */
    public void testCtor_TcUMLFileIsNull() {
        try {
            new SaveTCUMLFileAction(null, true, manager);
            fail("when tcUMLFile is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor SaveTCUMLFileAction(File tcUMLFile, boolean withDiagramData,
     * UMLModelManager modelManager) , when modelManager is null,
     * IllegalArgumentException is expected.
     */
    public void testCtor_ModelManagerIsNull() {
        try {
            new SaveTCUMLFileAction(new File("./test_files/tc.xmi"), true, null);
            fail("when modelManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor SaveTCUMLFileAction(File tcUMLFile, boolean withDiagramData,
     * UMLModelManager modelManager) , when tcUMLFile is a directory,
     * ActionExecutionException is expected.
     */
    public void testExecute_UMLFileInvaid() {
        try {
            new SaveTCUMLFileAction(new File("./test_files/failure/location"), 
                    true, manager).execute();
            fail("when tcUMLFile is a directory, ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // ok
        }
    }
}