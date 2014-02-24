/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * /*
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for ExportToXMIFileAction
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and
 * checks for expected exceptions /*
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExportToXMIFileActionUnitTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ExportToXMIFileActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>ExportToXMIFileAction.ExportToXMIFileAction(File xmiFile, boolean withDiagramData,
     * UMLModelManager modelManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation. With withDiagramData as true.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ExportToXMIFileAction() throws Exception {
        assertNotNull("ExportToXMIFileAction creation failed", new ExportToXMIFileAction(new File("test"), true,
                TestHelper.MODELMANAGER));
    }

    /**
     * <p>
     * Accuracy test of
     * <code>ExportToXMIFileAction.ExportToXMIFileAction(File xmiFile, boolean withDiagramData,
     * UMLModelManager modelManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation. With withDiagramData as false.
     * </p>
     *
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ExportToXMIFileAction1() throws Exception {
        assertNotNull("ExportToXMIFileAction creation failed", new ExportToXMIFileAction(new File("test"), false,
                TestHelper.MODELMANAGER));
    }

    /**
     * <p>
     * Failure test of
     * <code>ExportToXMIFileAction.ExportToXMIFileAction(File xmiFile, boolean withDiagramData,
     * UMLModelManager modelManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File xmiFile : null Value
     *          boolean withDiagramData : Valid Value
     *          UMLModelManager modelManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportToXMIFileAction() throws Exception {
        try {
            new ExportToXMIFileAction(null, false, TestHelper.MODELMANAGER);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                    "xmiFile in ExportToXMIFileAction#ExportToXMIFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>ExportToXMIFileAction.ExportToXMIFileAction(File xmiFile, boolean withDiagramData,
     * UMLModelManager modelManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *          File xmiFile : Valid Value
     *          boolean withDiagramData : Valid Value
     *          UMLModelManager modelManager : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportToXMIFileAction1() throws Exception {
        try {
            new ExportToXMIFileAction(new File("test"), false, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                    "modelManager in ExportToXMIFileAction#ExportToXMIFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test of <code>ExportToXMIFileAction.execute()</code> method.
     * detail
     * </p>
     * <p>
     * Calls the execute method, the value of the inner items are not verified as the instances are contained
     * in itself.
     * Though a print out is given for the withDiagramData that is been used to create the ExportToXMIFileAction.
     * Ensuring that the method is called correctly.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        File file = new File("test.xmi");
        System.out.println("test_accuracy_execute for ExportToXMIFileAction with withDiagramData true : ");
        new ExportToXMIFileAction(file, true,
                TestHelper.MODELMANAGER).execute();
        file.delete();
    }

    /**
     * <p>
     * Accuracy test of <code>ExportToXMIFileAction.execute()</code> method.
     * detail
     * </p>
     * <p>
     * Calls the execute method, the value of the inner items are not verified as the instances are contained
     * in itself.
     * Though a print out is given for the withDiagramData that is been used to create the ExportToXMIFileAction.
     * Ensuring that the method is called correctly.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute1() throws Exception {
        File file = new File("test.xmi");
        System.out.println("test_accuracy_execute for ExportToXMIFileAction with withDiagramData false : ");
        new ExportToXMIFileAction(file, false,
                TestHelper.MODELMANAGER).execute();
        file.delete();
    }

    /**
     * <p>
     * Failure test of <code>ExportToXMIFileAction.execute()</code> method.
     * </p>
     * <p>
     * A file is created with invalid characters, to simulate the exception.
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
            new ExportToXMIFileAction(new File("\\test_//.xmi\\"), false,
                    TestHelper.MODELMANAGER).execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // as expected
        }
    }
}
