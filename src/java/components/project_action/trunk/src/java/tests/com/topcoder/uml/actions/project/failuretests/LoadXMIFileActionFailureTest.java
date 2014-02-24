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
 * Failure test for <code>LoadXMIFileAction</code> class.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LoadXMIFileActionFailureTest extends TestCase {
    /**
     * The file used to construct LoadXMIFileAction.
     */
    private File xmiFile;
    
    /**
     * The modelManager used to construct LoadXMIFileAction.
     */
    private UMLModelManager modelManager;
    
    /**
     * The configManager used to construct LoadXMIFileAction.
     */
    private ProjectConfigurationManager configManager;
    
    /**
     * Set up for each test.
     * 
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        xmiFile = new File("./test_files/failure/uml.xmi");
        modelManager = UMLModelManager.getInstance();
        configManager = new ProjectConfigurationManager(modelManager);
    }
    
    /**
     * Test ctor LoadXMIFileAction(File xmiFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when xmiFile is null, IllegalArgumentException is expected.
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
     * Test ctor LoadXMIFileAction(File xmiFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when xmiFile do not existed, IllegalArgumentException is expected.
     */
    public void testCtor_FileNotExisted() {
        try {
            new LoadXMIFileAction(new File("./test_files/failure/location/notexisted.xmi"),
                    modelManager, configManager);
            fail("when xmiFile do not existed, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor LoadXMIFileAction(File xmiFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when xmiFile is a directory, IllegalArgumentException is expected.
     */
    public void testCtor_FileIsDirectory() {
        try {
            new LoadXMIFileAction(new File("./test_files/failure/location"),
                    modelManager, configManager);
            fail("when xmiFile is a directory, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor LoadXMIFileAction(File xmiFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when modelManager is null, IllegalArgumentException is expected.
     */
    public void testCtor_ModelManagerIsNull() {
        try {
            new LoadXMIFileAction(xmiFile, null, configManager);
            fail("when modelManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor LoadXMIFileAction(File xmiFile, UMLModelManager
     * modelManager, ProjectConfigurationManager configManager),
     * when configManager is null, IllegalArgumentException is expected.
     */
    public void testCtor_ConfigManagerIsNull() {
        try {
            new LoadXMIFileAction(xmiFile, modelManager, null);
            fail("when configManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
}