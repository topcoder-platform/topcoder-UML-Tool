/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * /*
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for SaveTCUMLFileAction class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions /*
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SaveTCUMLFileActionUnitTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(SaveTCUMLFileActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>SaveTCUMLFileAction.SaveTCUMLFileAction(File tcUMLFile, boolean withDiagramData,
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
    public void test_accuracy_SaveTCUMLFileAction() throws Exception {
        assertNotNull("SaveTCUMLFileAction creation failed", new SaveTCUMLFileAction(new File("test"), true,
            TestHelper.MODELMANAGER));
    }

    /**
     * <p>
     * Accuracy test of
     * <code>SaveTCUMLFileAction.SaveTCUMLFileAction(File tcUMLFile, boolean withDiagramData,
     * UMLModelManager modelManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation. With withDiagramData as false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_SaveTCUMLFileAction1() throws Exception {
        assertNotNull("SaveTCUMLFileAction creation failed", new SaveTCUMLFileAction(new File("test"), false,
            TestHelper.MODELMANAGER));
    }

    /**
     * <p>
     * Failure test of <code>SaveTCUMLFileAction.SaveTCUMLFileAction(File tcUMLFile, boolean withDiagramData,
     * UMLModelManager modelManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                File tcUMLFile : null Value
     *                boolean withDiagramData : Valid Value
     *                UMLModelManager modelManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_SaveTCUMLFileAction() throws Exception {
        try {
            new SaveTCUMLFileAction(null, false, TestHelper.MODELMANAGER);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "tcUMLFile in SaveTCUMLFileAction#SaveTCUMLFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of <code>SaveTCUMLFileAction.SaveTCUMLFileAction(File tcUMLFile, boolean withDiagramData,
     * UMLModelManager modelManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                File tcUMLFile : Valid Value
     *                boolean withDiagramData : Valid Value
     *                UMLModelManager modelManager : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_SaveTCUMLFileAction1() throws Exception {
        try {
            new SaveTCUMLFileAction(new File("test"), false, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "modelManager in SaveTCUMLFileAction#SaveTCUMLFileAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test of <code>SaveTCUMLFileAction.execute()</code> method.
     * </p>
     * <p>
     * Calls the execute method, the value of the inner items of the file are not verified as the instances
     * are contained in itself. Though a print out is given for the withDiagramData that is been used to
     * create the SaveTCUMLFileAction. Ensuring that the method is called correctly.
     * </p>
     * <p>
     * This method also verifies whether the TCUML file is created correctly with one .xmi file.
     * </p>
     * <p>
     * File name with normal extension.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        File file = new File("test.zip");
        System.out.println("test_accuracy_execute for SaveTCUMLFileAction with withDiagramData true : ");
        new SaveTCUMLFileAction(file, true, TestHelper.MODELMANAGER).execute();
        if (!file.exists()) {
            fail("SaveTCUMLFileAction failed, TCUML file not created");
        }
        // check whether the file contains the xmi file
        assertTrue("SaveTCUMLFileAction failed, .xmi file not created properly", XMIfilePresence(file, "test.xmi"));
        file.delete();
    }

    /**
     * <p>
     * Accuracy test of <code>SaveTCUMLFileAction.execute()</code> method.
     * </p>
     * <p>
     * Calls the execute method, the value of the inner items are not verified as the instances are contained
     * in itself. Though a print out is given for the withDiagramData that is been used to create the
     * SaveTCUMLFileAction. Ensuring that the method is called correctly.
     * </p>
     * <p>
     * This method also verifies whether the TCUML file is created correctly with one .xmi file.
     * </p>
     * <p>
     * File name with normal extension.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute1() throws Exception {
        File file = new File("test.zip");
        System.out.println("test_accuracy_execute for SaveTCUMLFileAction with withDiagramData false : ");
        new SaveTCUMLFileAction(file, false, TestHelper.MODELMANAGER).execute();
        if (!file.exists()) {
            fail("SaveTCUMLFileAction failed, TCUML file not created");
        }
        // check whether the file contains the xmi file
        assertTrue("SaveTCUMLFileAction failed, .xmi file not created properly", XMIfilePresence(file, "test.xmi"));
        file.delete();
    }

    /**
     * <p>
     * Accuracy test of <code>SaveTCUMLFileAction.execute()</code> method.
     * </p>
     * <p>
     * Calls the execute method, the value of the inner items are not verified as the instances are contained
     * in itself. Though a print out is given for the withDiagramData that is been used to create the
     * SaveTCUMLFileAction. Ensuring that the method is called correctly.
     * </p>
     * <p>
     * This method also verifies whether the TCUML file is created correctly with one .xmi file.
     * </p>
     * <p>
     * File name with many extension.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute11() throws Exception {
        File file = new File("test.xxx.zip");
        System.out.println("test_accuracy_execute for SaveTCUMLFileAction with withDiagramData false : ");
        new SaveTCUMLFileAction(file, false, TestHelper.MODELMANAGER).execute();
        if (!file.exists()) {
            fail("SaveTCUMLFileAction failed, TCUML file not created");
        }
        // check whether the file contains the xmi file
        assertTrue("SaveTCUMLFileAction failed, .xmi file not created properly",
            XMIfilePresence(file, "test.xxx.xmi"));
        file.delete();
    }

    /**
     * <p>
     * Accuracy test of <code>SaveTCUMLFileAction.execute()</code> method.
     * </p>
     * <p>
     * Calls the execute method, the value of the inner items are not verified as the instances are contained
     * in itself. Though a print out is given for the withDiagramData that is been used to create the
     * SaveTCUMLFileAction. Ensuring that the method is called correctly.
     * </p>
     * <p>
     * This method also verifies whether the TCUML file is created correctly with one .xmi file.
     * </p>
     * <p>
     * File name without any extension.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute12() throws Exception {
        File file = new File("test");
        System.out.println("test_accuracy_execute for SaveTCUMLFileAction with withDiagramData false : ");
        new SaveTCUMLFileAction(file, false, TestHelper.MODELMANAGER).execute();
        if (!file.exists()) {
            fail("SaveTCUMLFileAction failed, TCUML file not created");
        }
        // check whether the file contains the xmi file
        assertTrue("SaveTCUMLFileAction failed, .xmi file not created properly", XMIfilePresence(file, "test.xmi"));
        file.delete();
    }

    /**
     * <p>
     * Failure test of <code>SaveTCUMLFileAction.execute()</code> method.
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
            new SaveTCUMLFileAction(new File("\\test_//.xmi\\"), false, TestHelper.MODELMANAGER).execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Checks whether the given filename is present in the given Zip file.
     * </p>
     *
     * @param file
     *            the zip file in which the filename has to be searched for
     * @param fileName
     *            the filename to be searched.
     * @return whether the given filename is present in the zipped file.
     * @throws Exception
     *             throw exception to JUnit.
     */
    private boolean XMIfilePresence(File file, String fileName) throws Exception {
        // create a zipfile object from the given file
        ZipFile zipFile = new ZipFile(file);
        // get all the files present inside the zipfile
        Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
        // run through each element
        while (enumeration.hasMoreElements()) {
            ZipEntry entry = enumeration.nextElement();
            // if a file with .xmi exists create a stream from that and exit the loop
            if (entry.getName().equals(fileName)) {
                zipFile.close();
                return true;
            }
        }
        zipFile.close();
        return false;
    }
}
