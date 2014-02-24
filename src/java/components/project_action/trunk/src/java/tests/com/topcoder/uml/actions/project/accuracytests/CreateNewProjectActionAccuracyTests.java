/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import com.topcoder.uml.actions.project.CreateNewProjectAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link CreateNewProjectAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CreateNewProjectActionAccuracyTests extends TestCase {
    /**
     * <p>
     * Accuracy test for <code>{@link CreateNewProjectAction#CreateNewProjectAction(String, UMLModelManager)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        String projectLanguage = "Java";
        UMLModelManager manager = new UMLModelManager();

        CreateNewProjectAction createNewProjectAction = new CreateNewProjectAction(projectLanguage, manager);

        // verify
        assertEquals("projectLanguage field not set correctly.", projectLanguage, AccuracyTestHelper.getFieldValue(
            createNewProjectAction, "projectLanguage"));
        assertSame("manager field not set correctly.", manager, AccuracyTestHelper.getFieldValue(
            createNewProjectAction, "manager"));
    }
}
