/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import java.io.File;

import com.topcoder.uml.actions.project.LoadXMIFileAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link LoadXMIFileAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class LoadXMIFileActionAccuracyTests extends TestCase {
    /**
     * <p>
     * Accuracy test for
     * <code>{@link LoadXMIFileAction#LoadXMIFileAction(File, UMLModelManager, ProjectConfigurationManager)}</code>
     * construcotr.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        File file = new File("test_files/out.xmi");
        file.createNewFile();
        UMLModelManager manager = new UMLModelManager();
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(manager);
        LoadXMIFileAction loadXMIFileAction = new LoadXMIFileAction(file, manager, projectConfigurationManager);

        // verify
        assertEquals("xmiFile field not set.", file, AccuracyTestHelper.getFieldValue(loadXMIFileAction, "xmiFile"));
        assertEquals("modelManager field not set.", manager, AccuracyTestHelper.getFieldValue(loadXMIFileAction,
            "modelManager"));
        assertEquals("configManager field not set.", projectConfigurationManager, AccuracyTestHelper.getFieldValue(
            loadXMIFileAction, "configManager"));
        file.delete();
    }
}
