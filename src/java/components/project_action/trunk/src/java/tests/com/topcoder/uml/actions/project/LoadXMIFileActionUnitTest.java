/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * /*
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for LoadXMIFileAction class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions /*
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LoadXMIFileActionUnitTest extends TestCase {

    /**
     * <p>
     * File to be used.
     * </p>
     */
    private File xmiFile;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        xmiFile = new File("test.xmi");
        xmiFile.createNewFile();
    }

    /**
     * <p>
     * Tears down the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        xmiFile.delete();
        xmiFile = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(LoadXMIFileActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>LoadXMIFileAction.LoadXMIFileAction(File xmiFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_LoadXMIFileAction() throws Exception {
        UMLModelManager modelManager = new UMLModelManager();
        assertNotNull("LoadXMIFileAction creation failed", new LoadXMIFileAction(xmiFile,
            TestHelper.MODELMANAGER, new ProjectConfigurationManager(modelManager)));
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadXMIFileAction.LoadXMIFileAction(File xmiFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File xmiFile : null Value
     *          UMLModelManager modelManager : Valid Value
     *          ProjectConfigurationManager configManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_LoadXMIFileAction() throws Exception {
        try {
            UMLModelManager modelManager = new UMLModelManager();
            new LoadXMIFileAction(null, TestHelper.MODELMANAGER,
                    new ProjectConfigurationManager(modelManager));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "xmiFile in LoadXMIFileAction#LoadXMIFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadXMIFileAction.LoadXMIFileAction(File xmiFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File xmiFile : File not existing
     *          UMLModelManager modelManager : Valid Value
     *          ProjectConfigurationManager configManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_LoadXMIFileAction1() throws Exception {
        try {
            UMLModelManager modelManager = new UMLModelManager();
            new LoadXMIFileAction(new File("test.1233"), TestHelper.MODELMANAGER,
                    new ProjectConfigurationManager(modelManager));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "xmiFile does not exist or it is not a file");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadXMIFileAction.LoadXMIFileAction(File xmiFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File xmiFile : File is directory
     *          UMLModelManager modelManager : Valid Value
     *          ProjectConfigurationManager configManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_LoadXMIFileAction10() throws Exception {
        File file = new File("test.22236");
        try {
            file.mkdir();
            UMLModelManager modelManager = new UMLModelManager();
            new LoadXMIFileAction(file, TestHelper.MODELMANAGER,
                    new ProjectConfigurationManager(modelManager));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "xmiFile does not exist or it is not a file");
        } finally {
            file.delete();
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadXMIFileAction.LoadXMIFileAction(File xmiFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File xmiFile : Valid Value
     *          UMLModelManager modelManager : null Value
     *          ProjectConfigurationManager configManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_LoadXMIFileAction2() throws Exception {
        try {
            UMLModelManager modelManager = new UMLModelManager();
            new LoadXMIFileAction(xmiFile, null, new ProjectConfigurationManager(modelManager));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "modelManager in LoadXMIFileAction#LoadXMIFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadXMIFileAction.LoadXMIFileAction(File xmiFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File xmiFile : valid Value
     *          UMLModelManager modelManager : Valid Value
     *          ProjectConfigurationManager configManager : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_LoadXMIFileAction3() throws Exception {
        try {
            new LoadXMIFileAction(xmiFile, TestHelper.MODELMANAGER, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "configManager in LoadXMIFileAction#LoadXMIFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test of <code>LoadXMIFileAction.execute()</code> method.
     * </p>
     * <p>
     * Checks whether values are correctly set. A valid UMLModelManager is passed, instead of a empty manager.
     * The model is empty for this model manager.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {

        UMLModelManager modelManager = new UMLModelManager();
        MockModel model = new MockModel();
        modelManager.setModel(model);
        new LoadXMIFileAction(xmiFile, modelManager, new ProjectConfigurationManager(modelManager)).execute();
        // check whether the model is populated with the values of the project language
        assertEquals("execute Failed", "java", new ArrayList<TaggedValue>(model.getTaggedValues()).get(0)
            .getDataValue());
        assertEquals("execute Failed", "ProjectLanguage", new ArrayList<TaggedValue>(model.getTaggedValues())
            .get(0).getType().getTagType());
        // check if the model manager is set with the default language
        assertEquals("execute Failed", "java", modelManager.getProjectLanguage());
    }

    /**
     * <p>
     * Accuracy test of <code>LoadXMIFileAction.execute()</code> method.
     * </p>
     * <p>
     * Checks whether values are correctly set. A valid UMLModelManager is passed, instead of a empty manager.
     * The model with a tagged value for the project language is added to the model manager.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute1() throws Exception {
        UMLModelManager modelManager = new UMLModelManager();
        modelManager.setModel(TestHelper.getModel());
        new LoadXMIFileAction(xmiFile, modelManager, new ProjectConfigurationManager(modelManager)).execute();
        // check if the model manager is set with the value from the model
        assertEquals("execute Failed", "c++", modelManager.getProjectLanguage());
    }

    /**
     * <p>
     * Failure test of <code>LoadXMIFileAction.execute()</code> method. For the following inputs:
     * </p>
     * <p>
     * Expected ActionExecutionException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_execute() throws Exception {
        try {
            UMLModelManager modelManager = new UMLModelManager();
            new LoadXMIFileAction(xmiFile, TestHelper.MODELMANAGER,
                    new ProjectConfigurationManager(modelManager)).execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As Expected
        }
    }
}
