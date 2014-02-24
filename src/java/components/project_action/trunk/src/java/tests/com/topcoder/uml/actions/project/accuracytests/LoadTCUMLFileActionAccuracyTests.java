/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import java.io.File;

import com.topcoder.uml.actions.project.LoadTCUMLFileAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link LoadTCUMLFileAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class LoadTCUMLFileActionAccuracyTests extends TestCase {
    /**
     * <p>
     * Accuracy test for
     * <code>{@link LoadTCUMLFileAction#LoadTCUMLFileAction(File, UMLModelManager, ProjectConfigurationManager)}</code>
     * construcotr.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        File file = new File("test_files/out.zip");
        file.createNewFile();
        UMLModelManager manager = new UMLModelManager();
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(manager);
        LoadTCUMLFileAction loadTCUMLFileAction = new LoadTCUMLFileAction(file, manager, projectConfigurationManager);

        // verify
        assertEquals("tcUMLFile field not set.", file, AccuracyTestHelper.getFieldValue(loadTCUMLFileAction,
            "tcUMLFile"));
        assertEquals("modelManager field not set.", manager, AccuracyTestHelper.getFieldValue(loadTCUMLFileAction,
            "modelManager"));
        assertEquals("configManager field not set.", projectConfigurationManager, AccuracyTestHelper.getFieldValue(
            loadTCUMLFileAction, "configManager"));
        file.delete();
    }
}
