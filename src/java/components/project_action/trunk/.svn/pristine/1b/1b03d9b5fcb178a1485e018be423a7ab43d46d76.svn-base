/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * /*
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for Helper class. The accuracy test
 * cases gives all valid inputs to the methods/constructors and checks for inconsistencies The failure test
 * cases gives all invalid inputs to the methods/constructors and checks for expected exceptions /*
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperUnitTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(HelperUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of <code>Helper.checkObjectNotNull(Object obj, String name)</code> method.
     * </p>
     * <p>
     * Check whether No exception is thrown when a valid value is given.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkObjectNotNull() throws Exception {
        Helper.checkObjectNotNull(new Object(), "check");
    }

    /**
     * <p>
     * Failure test of <code>Helper.checkObjectNotNull(Object obj, String name)</code> method.
     * For the following inputs:
     * </p>
     * <p>
     * Input
     *      Object obj : null Value
     *       String name : Valid Value
     * </p>
     * <p>
     * Expected
     *         IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkObjectNotNull() throws Exception {
        try {
            Helper.checkObjectNotNull(null, "Check");
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(), "Check should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test of <code>Helper.checkObjectListNotNull(List obj, String name)</code> method.
     * </p>
     * <p>
     * Checks whether no exception is occurred when a correct list is passed.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkObjectListNotNull() throws Exception {
        Helper.checkObjectListNotNull(Arrays.asList(new String[]{"a","b","c"}), "test");
    }

    /**
     * <p>
     * Failure test of <code>Helper.checkObjectListNotNull(List obj, String name)</code> method. For the
     * following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        List obj : null Value
     *        String name : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkObjectListNotNull() throws Exception {
        try {
            Helper.checkObjectListNotNull(null, "test");
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "test should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of <code>Helper.checkObjectListNotNull(List obj, String name)</code> method. For the
     * following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        List obj : Contains a null Value
     *        String name : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkObjectListNotNull1() throws Exception {
        try {
            Helper.checkObjectListNotNull(Arrays.asList(new String[]{"a","b",null}), "test");
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "Element inside list test should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of <code>Helper.checkObjectListNotNull(List obj, String name)</code> method. For the
     * following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        List obj : Contains a Empty string
     *        String name : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkObjectListNotNull2() throws Exception {
        try {
            Helper.checkObjectListNotNull(Arrays.asList(new String[]{"a","b","  "}), "test");
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "Element inside list test should not be empty.");
        }
    }

    /**
     * <p>
     * Accuracy test of <code>Helper.checkStringNotNullOrEmpty(String str, String name)</code> method.
     * </p>
     * <p>
     * Check whether No exception is thrown when a valid value is given.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkStringNotNullOrEmpty() throws Exception {
        Helper.checkStringNotNullOrEmpty("test","test");
    }

    /**
     * <p>
     * Failure test of <code>Helper.checkStringNotNullOrEmpty(String str, String name)</code> method. For
     * the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        String str : null Value
     *        String name : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkStringNotNullOrEmpty() throws Exception {
        try {
            Helper.checkStringNotNullOrEmpty(null,"test");
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "test should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of <code>Helper.checkStringNotNullOrEmpty(String str, String name)</code> method. For
     * the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        String str : Empty Value
     *        String name : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkStringNotNullOrEmpty1() throws Exception {
        try {
            Helper.checkStringNotNullOrEmpty("  ","test");
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "test should not be empty.");
        }
    }

    /**
     * <p>
     * Accuracy test of <code>Helper.loadXMIFile(UMLModelManager modelManager, InputStream stream,
     * ProjectConfigurationManager configManager)</code> method.
     * </p>
     * <p>
     * Checks whether values are correctly set. A valid UMLModelManager is passed, instead of a empty manager.
     * The model is empty for this model manager.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_loadXMIFile() throws Exception {
        File file = new File("test.xmi");
        file.createNewFile();
        UMLModelManager modelManager = new UMLModelManager();
        MockModel model = new MockModel();
        modelManager.setModel(model);
        FileInputStream fileInputStream = new FileInputStream(file);
        Helper.loadXMIFile(modelManager, fileInputStream, new ProjectConfigurationManager(modelManager));
        // check whether the model is populated with the values of the project language
        assertEquals("loadXmiFile Failed", "java", new ArrayList<TaggedValue>(model.getTaggedValues()).get(0)
            .getDataValue());
        assertEquals("loadXmiFile Failed", "ProjectLanguage",
            new ArrayList<TaggedValue>(model.getTaggedValues()).get(0).getType().getTagType());
        //check if the model manager is set with the default language
        assertEquals("loadXmiFile Failed", "java", modelManager.getProjectLanguage());
        fileInputStream.close();
        file.delete();
    }

    /**
     * <p>
     * Accuracy test of <code>Helper.loadXMIFile(UMLModelManager modelManager, InputStream stream,
     * ProjectConfigurationManager configManager)</code> method.
     * </p>
     * <p>
     * Checks whether values are correctly set. A valid UMLModelManager is passed, instead of a empty manager.
     * The model with a tagged value for the project language is added to the model manager.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_loadXMIFile1() throws Exception {
        File file = new File("test.xmi");
        file.createNewFile();
        UMLModelManager modelManager = new UMLModelManager();
        modelManager.setModel(TestHelper.getModel());
        FileInputStream fileInputStream = new FileInputStream(file);
        Helper.loadXMIFile(modelManager, fileInputStream, new ProjectConfigurationManager(modelManager));
        //check if the model manager is set with the value from the model
        assertEquals("loadXmiFile Failed", "c++", modelManager.getProjectLanguage());
        fileInputStream.close();
        file.delete();
    }
}
