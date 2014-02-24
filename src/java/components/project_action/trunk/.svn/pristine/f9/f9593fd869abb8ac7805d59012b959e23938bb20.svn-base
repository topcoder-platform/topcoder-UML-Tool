/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests;

import java.io.File;

import com.topcoder.uml.actions.project.LoadTCUMLFileAction;
import com.topcoder.uml.actions.project.LoadXMIFileAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>LoadTCUMLFileAction</code> class.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LoadTCUMLFileActionFailureTest extends TestCase {
    /**
     * The file used to construct LoadTCUMLFileAction.
     */
    private File tcUMLFile;
    
    /**
     * The modelManager used to construct LoadTCUMLFileAction.
     */
    private UMLModelManager modelManager;
    
    /**
     * The configManager used to construct LoadTCUMLFileAction.
     */
    private ProjectConfigurationManager configManager;
    
    /**
     * Set up for each test.
     * 
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        tcUMLFile = new File("./test_files/failure/uml.uml");
        modelManager = UMLModelManager.getInstance();
        configManager = new ProjectConfigurationManager(modelManager);
    }
    
    /**
     * Test ctor LoadTCUMLFileAction(File tcUMLFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when tcUMLFile is null, IllegalArgumentException is expected.
     * 
     */
    public void testCtor_FileIsNull() {
        try {
            new LoadTCUMLFileAction(null, modelManager, configManager);
            fail("when tcUMLFile is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor LoadTCUMLFileAction(File tcUMLFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when tcUMLFile do not existed, IllegalArgumentException is expected.
     * 
     */
    public void testCtor_FileNotExisted() {
        try {
            new LoadTCUMLFileAction(new File("./test_files/failure/location/notexisted.uml"),
                    modelManager, configManager);
            fail("when tcUMLFile do not existed, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor LoadTCUMLFileAction(File tcUMLFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when tcUMLFile is a directory, IllegalArgumentException is expected.
     */
    public void testCtor_FileIsDirectory() {
        try {
            new LoadXMIFileAction(new File("./test_files/failure/location"),
                    modelManager, configManager);
            fail("when tcUMLFile is a directory, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor LoadTCUMLFileAction(File tcUMLFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when modelManager is null, IllegalArgumentException is expected.
     * 
     */
    public void testCtor_ModelManagerIsNull() {
        try {
            new LoadTCUMLFileAction(tcUMLFile, null, configManager);
            fail("when modelManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor LoadTCUMLFileAction(File tcUMLFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when configManager is null, IllegalArgumentException is expected.
     * 
     */
    public void testCtor_ConfigManagerIsNull() {
        try {
            new LoadTCUMLFileAction(tcUMLFile, modelManager, null);
            fail("when configManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
}
