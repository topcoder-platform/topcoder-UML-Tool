/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests;

import java.io.File;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.actions.project.ExportToXMIFileAction;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for ExportToXMIFileAction class.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExportToXMIFileActionFailureTest extends TestCase {
    /**
     * The file used in construct ExportToXMIFileAction.
     */
    private File xmiFile;
    
    /**
     * The modelManager used in construct ExportToXMIFileAction.
     */
    private UMLModelManager modelManager;
    
    /**
     * Set up for each test.
     * 
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        xmiFile = new File("./test_files/failure/uml.xmi");
        modelManager = UMLModelManager.getInstance();
    }
    
    /**
     * Test ctor ExportToXMIFileAction(File xmiFile, boolean withDiagramData, UMLModelManager modelManager),
     * when xmiFile is null, IllegalArgumentException is expected.
     */
    public void testCtor_XmiFileIsNull() {
        try {
            new ExportToXMIFileAction(null, true, modelManager);
            fail("when xmiFile is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }
    
    /**
     * Test ctor ExportToXMIFileAction(File xmiFile, boolean withDiagramData, UMLModelManager modelManager),
     * when modelManager is null, IllegalArgumentException is expected.
     */
    public void testCtor_ModelManagerIsNull() {
        try {
            new ExportToXMIFileAction(xmiFile, true, null);
            fail("when modelManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }
}
