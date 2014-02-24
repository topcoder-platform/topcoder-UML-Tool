/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
 * This Junit Test suite contains the accuracy and failure test cases for LoadTCUMLFileAction class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions /*
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LoadTCUMLFileActionUnitTest extends TestCase {

    /**
     * <p>
     * File to be used.
     * </p>
     */
    private File zipFile;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        zipFile = new File("test.zip");
        // create a ZipOutputStream
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
        // add a Zip entry with the filename extension .xmi
        zipOutputStream.putNextEntry(new ZipEntry(zipFile.getName() + ".xmi"));
        zipOutputStream.close();
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
        zipFile.delete();
        zipFile = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(LoadTCUMLFileActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>LoadTCUMLFileAction.LoadTCUMLFileAction(File tcUMLFile, UMLModelManager modelManager,
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
    public void test_accuracy_LoadTCUMLFileAction() throws Exception {
        UMLModelManager modelManager = new UMLModelManager();
        assertNotNull("LoadTCUMLFileAction creation failed", new LoadTCUMLFileAction(zipFile,
            TestHelper.MODELMANAGER, new ProjectConfigurationManager(modelManager)));
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadTCUMLFileAction.LoadTCUMLFileAction(File tcUMLFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File tcUMLFile : null Value
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
    public void test_failure_LoadTCUMLFileAction() throws Exception {
        try {
            UMLModelManager modelManager = new UMLModelManager();
            new LoadTCUMLFileAction(null, TestHelper.MODELMANAGER, new ProjectConfigurationManager(modelManager));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "tcUMLFile in LoadTCUMLFileAction#LoadTCUMLFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadTCUMLFileAction.LoadTCUMLFileAction(File tcUMLFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File tcUMLFile : File not existing
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
    public void test_failure_LoadTCUMLFileAction1() throws Exception {
        try {
            UMLModelManager modelManager = new UMLModelManager();
            new LoadTCUMLFileAction(new File("test.132"), TestHelper.MODELMANAGER,
                    new ProjectConfigurationManager(modelManager));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(), "The tcUMLFile passed does not exist");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadTCUMLFileAction.LoadTCUMLFileAction(File tcUMLFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File tcUMLFile : Valid Value
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
    public void test_failure_LoadTCUMLFileAction2() throws Exception {
        try {
            UMLModelManager modelManager = new UMLModelManager();
            new LoadTCUMLFileAction(zipFile, null, new ProjectConfigurationManager(modelManager));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "modelManager in LoadTCUMLFileAction#LoadTCUMLFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>LoadTCUMLFileAction.LoadTCUMLFileAction(File tcUMLFile, UMLModelManager modelManager,
     * ProjectConfigurationManager configManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File tcUMLFile : valid Value
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
    public void test_failure_LoadTCUMLFileAction3() throws Exception {
        try {
            new LoadTCUMLFileAction(zipFile, TestHelper.MODELMANAGER, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "configManager in LoadTCUMLFileAction#LoadTCUMLFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test of <code>LoadTCUMLFileAction.execute()</code> method.
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
        new LoadTCUMLFileAction(zipFile, modelManager, new ProjectConfigurationManager(modelManager)).execute();
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
     * Accuracy test of <code>LoadTCUMLFileAction.execute()</code> method.
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
        new LoadTCUMLFileAction(zipFile, modelManager, new ProjectConfigurationManager(modelManager)).execute();
        // check if the model manager is set with the value from the model
        assertEquals("execute Failed", "c++", modelManager.getProjectLanguage());
    }

    /**
     * <p>
     * Failure test of <code>LoadTCUMLFileAction.execute()</code> method.
     * </p>
     * <p>
     * Zipfile without .xmi file.
     * </p>
     * <p>
     * Expected ActionExecutionException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_execute() throws Exception {
        File zip = new File("test.zip");
        try {
            // create a ZipOutputStream
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zip));
            // add a Zip entry
            zipOutputStream.putNextEntry(new ZipEntry(zipFile.getName() + ".test"));
            zipOutputStream.close();
            UMLModelManager modelManager = new UMLModelManager();
            new LoadTCUMLFileAction(zipFile, TestHelper.MODELMANAGER,
                    new ProjectConfigurationManager(modelManager)).execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As Expected
        } finally {
            zip.delete();
        }
    }
}
