/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.Action;

/**
 * /*
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for CreateNewProjectAction class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions /*
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CreateNewProjectActionUnitTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CreateNewProjectActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>CreateNewProjectAction.CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CreateNewProjectAction() throws Exception {
        CreateNewProjectAction projectAction = new CreateNewProjectAction("Java", TestHelper.MODELMANAGER);
        // check for instantiation
        assertNotNull("CreateNewProjectAction creation failed", projectAction);
        // check for inheritance
        assertTrue("CreateNewProjectAction creation failed", projectAction instanceof Action);
    }

    /**
     * <p>
     * Failure test of
     * <code>CreateNewProjectAction.CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *    String projectLanguage : Valid Value
     *    UMLModelManager modelManager : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CreateNewProjectAction() throws Exception {
        try {
            new CreateNewProjectAction("Java", null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "modelManager in CreateNewProjectAction#CreateNewProjectAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>CreateNewProjectAction.CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *    String projectLanguage : null Value
     *    UMLModelManager modelManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CreateNewProjectAction1() throws Exception {
        try {
            new CreateNewProjectAction(null, TestHelper.MODELMANAGER);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "projectLanguage in CreateNewProjectAction#CreateNewProjectAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>CreateNewProjectAction.CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *    String projectLanguage : Empty Value
     *    UMLModelManager modelManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CreateNewProjectAction2() throws Exception {
        try {
            new CreateNewProjectAction("", TestHelper.MODELMANAGER);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "projectLanguage in CreateNewProjectAction#CreateNewProjectAction should not be empty.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>CreateNewProjectAction.CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *    String projectLanguage : Empty Value with spaces
     *    UMLModelManager modelManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CreateNewProjectAction3() throws Exception {
        try {
            new CreateNewProjectAction("   ", TestHelper.MODELMANAGER);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "projectLanguage in CreateNewProjectAction#CreateNewProjectAction should not be empty.");
        }
    }

    /**
     * <p>
     * Accuracy test of <code>CreateNewProjectAction.execute()</code> method.
     * </p>
     * <p>
     * Creates a new MockModel sets the model to the manager and calls the execute. Checks whether all the
     * variables are cleared and properly initialized.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        UMLModelManager modelManager = new UMLModelManager();
        CreateNewProjectAction projectAction = new CreateNewProjectAction("Java", modelManager);
        MockModel model = new MockModel();
        modelManager.setModel(model);
        // add some graph to the model manager
        modelManager.addActivityGraph(new MockActivityGraph());
        modelManager.addActivityGraph(new MockActivityGraph());

        // add some diagram to the model manager
        modelManager.addDiagram(new MockDiagram());
        modelManager.addDiagram(new MockDiagram());

        projectAction.execute();

        // check whether the activity graphs are cleared from the model manager
        assertEquals("execute failed", 0, modelManager.getActivityGraphs().size());

        // check whether the diagrams are cleared from the model manager
        assertEquals("execute failed", 0, modelManager.getDiagrams().size());

        // check whether all the attributes/List are cleared from the model
        assertTrue("execute failed", model.clearElementImportStatus());
        assertTrue("execute failed", model.clearBehaviorStatus());
        assertTrue("execute failed", model.clearClientDependencieStatus());
        assertTrue("execute failed", model.clearCommentStatus());
        assertTrue("execute failed", model.clearDefaultParameterStatus());
        assertTrue("execute failed", model.clearGeneralizationStatus());
        assertTrue("execute failed", model.clearOwnedElementStatus());
        assertTrue("execute failed", model.clearReferenceTagStatus());
        assertTrue("execute failed", model.clearSpecializationStatus());
        assertTrue("execute failed", model.clearStereoTypeStatus());
        assertTrue("execute failed", model.clearSupplierDependencieStatus());
        assertTrue("execute failed", model.clearTaggedValueStatus());
        assertTrue("execute failed", model.clearTemplateArgumentStatus());
        assertTrue("execute failed", model.clearTemplateParameterStatus());

        // check whether the project language is set properly
        assertEquals("execute failed", "Java", modelManager.getProjectLanguage());
    }
}
