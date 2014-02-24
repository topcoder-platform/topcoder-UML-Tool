/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.awt.Button;
import java.awt.Component;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JComponent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * This class gives a demo of all the functionality this component offers.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * <p>
     * File to be used.
     * </p>
     */
    private File xmiFile;

    /**
     * <p>
     * File to be used.
     * </p>
     */
    private File tcUMLFile;

    /**
     * <p>
     * ProjectConfigurationManager to be used.
     * </p>
     */
    private ProjectConfigurationManager configurationManager;

    /**
     * <p>
     * codeGenerator to be used.
     * </p>
     */
    private MockCodeGenerator codeGenerator;

    /**
     * <p>
     * PrintManager to be used.
     * </p>
     */
    private MockPrintManager printManager;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        UMLModelManager modelManager = new UMLModelManager();
        configurationManager = new ProjectConfigurationManager(modelManager);
        codeGenerator = new MockCodeGenerator();
        printManager = new MockPrintManager();
        xmiFile = new File("test.xmi");
        xmiFile.createNewFile();
        tcUMLFile = new File("test.zuml");
        // create a ZipOutputStream
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(tcUMLFile));
        // add a Zip entry with the filename extension .xmi
        zipOutputStream.putNextEntry(new ZipEntry(xmiFile.getName() + ".xmi"));
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
        configurationManager = null;
        codeGenerator = null;
        printManager = null;
        xmiFile.delete();
        xmiFile = null;
        tcUMLFile.delete();
        tcUMLFile = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * <p>
     * Demo as in CS 4.3.1.
     * </p>
     * <p>
     * Executing CreateNewProjectAction.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDemo1() throws Exception {
        // create a new action
        CreateNewProjectAction action1 = new CreateNewProjectAction("java", TestHelper.MODELMANAGER);
        // a new empty project is created
        action1.execute();
    }

    /**
     * <p>
     * Demo as in CS 4.3.2.
     * </p>
     * <p>
     * Executing LoadXMIFileAction.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDemo2() throws Exception {
        // setting the model for the demo purpose
        UMLModelManager modelManager = new UMLModelManager();
        modelManager.setModel(TestHelper.getModel());
        // create a new action
        LoadXMIFileAction action2 = new LoadXMIFileAction(xmiFile, modelManager, configurationManager);
        // load the content of xmi file into TestHelper.MODELMANAGER
        action2.execute();

    }

    /**
     * <p>
     * Demo as in CS 4.3.3.
     * </p>
     * <p>
     * Executing LoadTCUMLFileAction.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDemo3() throws Exception {
        // setting the model for the demo purpose
        UMLModelManager modelManager = new UMLModelManager();
        modelManager.setModel(TestHelper.getModel());
        // create a new action
        LoadTCUMLFileAction action3 = new LoadTCUMLFileAction(tcUMLFile, modelManager,
            configurationManager);

        // execute the action to load the xmi data from action.zuml
        action3.execute();

    }

    /**
     * <p>
     * Demo as in CS 4.3.4.
     * </p>
     * <p>
     * Executing SaveTCUMLFileAction.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDemo4() throws Exception {
        // create a new action
        SaveTCUMLFileAction action4 = new SaveTCUMLFileAction(tcUMLFile, true, TestHelper.MODELMANAGER);

        // save the model into the action.zuml file with diagram data
        action4.execute();

        // create a new action to save model without the diagram data
        action4 = new SaveTCUMLFileAction(tcUMLFile, false, TestHelper.MODELMANAGER);
        action4.execute();
    }

    /**
     * <p>
     * Demo as in CS 4.3.5.
     * </p>
     * <p>
     * Executing ExportToXMIFileAction.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDemo5() throws Exception {
        // create a new action
        ExportToXMIFileAction action5 = new ExportToXMIFileAction(xmiFile, true, TestHelper.MODELMANAGER);

        // save the model into the action.xmi file with diagram data
        action5.execute();

        // create a new action to save model without the diagram data
        action5 = new ExportToXMIFileAction(xmiFile, false, TestHelper.MODELMANAGER);
        action5.execute();

    }

    /**
     * <p>
     * Demo as in CS 4.3.6.
     * </p>
     * <p>
     * Executing GenerateCodeAction.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDemo6() throws Exception {
        // create Classifier objects for test
        Classifier classifier1 = new MockClassifier();
        // classifier1.setName("Test");
        Classifier classifier2 = new MockClassifier();
        // classifier2.setName("Boo");

        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(classifier1);
        classifiers.add(classifier2);

        // create Package objects for test
        com.topcoder.uml.model.modelmanagement.Package package1 = new MockPackage();
        package1.setName("com.foo");
        com.topcoder.uml.model.modelmanagement.Package package2 = new MockPackage();
        package2.setName("com.bar");

        List<com.topcoder.uml.model.modelmanagement.Package> packages =
                new ArrayList<com.topcoder.uml.model.modelmanagement.Package>();
        packages.add(package1);
        packages.add(package2);

        // the location to store generated code
        String location = "project/test";

        // java file is only generated for "Test" class
        GenerateCodeAction action6 = new GenerateCodeAction("java", location, classifier1, codeGenerator);
        action6.execute();

        // java files are generated for all entities in "com.foo" package
        action6 = new GenerateCodeAction("java", location, package1, codeGenerator);
        action6.execute();

        // java files are generated for both "Test" and "Boo" classes
        action6 = new GenerateCodeAction("java", location, classifiers, codeGenerator);
        action6.execute();

        // java files are generated for entities in both "com.foo" and "com.bar"
        // packages
        action6 = new GenerateCodeAction("java", location, codeGenerator, packages);
        action6.execute();

    }

    /**
     * <p>
     * Demo as in CS 4.3.7.
     * </p>
     * <p>
     * Executing PrintDiagramAction.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDemo7() throws Exception {
        // assume both comp1 & comp2 objects below are provided
        // by the application
        // button is used as an example
        Component comp1 = new Button();
        Component comp2 = new Button();

        List<Component> comps = new ArrayList<Component>();
        comps.add(comp1);
        comps.add(comp2);

        // assume both rect1 & rect2 objects below are provided
        // by the application
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle();

        List<Rectangle> rects = new ArrayList<Rectangle>();
        rects.add(rect1);
        rects.add(rect2);

        // print a single diagram without viewport
        PrintDiagramAction action7 = new PrintDiagramAction(comp1, printManager);
        action7.execute();

        // print a single diagram with viewport
        action7 = new PrintDiagramAction(comp1, rect1, printManager);
        action7.execute();

        // print a list of diagrams without viewports
        action7 = new PrintDiagramAction(comps, printManager);
        action7.execute();

        // print a list of diagrams with viewports
        action7 = new PrintDiagramAction(comps, rects, printManager);
        action7.execute();

    }

    /**
     * <p>
     * Demo as in CS 4.3.8.
     * </p>
     * <p>
     * Executing ExportDiagramToImageAction.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDemo8() throws Exception {
        // assume both comp1 & comp2 objects below are provided
        // by the application
        // button is used as an example
        JComponent comp1 = new JButton();
        JComponent comp2 = new JButton();

        List<JComponent> comps = new ArrayList<JComponent>();
        comps.add(comp1);
        comps.add(comp2);

        // assume both rect1 & rect2 objects below are provided
        // by the application
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle();

        List<Rectangle> rects = new ArrayList<Rectangle>();
        rects.add(rect1);
        rects.add(rect2);

        // the location to store the generated images
        String location = "project/test";

        // file names for the generated image files
        String fileName1 = "class-diagram1.gif";
        String fileName2 = "class-diagram2.gif";
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName1);
        fileNames.add(fileName2);
        MockImageExporter imageExporter = new MockImageExporter();
        // export a single diagram without viewport
        ExportDiagramToImageAction action8 = new ExportDiagramToImageAction(comp1, location, fileName1, "gif",
            imageExporter);
        action8.execute();

        // export a single diagram with viewport
        action8 = new ExportDiagramToImageAction(comp1, rect1, location, fileName1, "gif", imageExporter);
        action8.execute();

        // export multiple diagrams without viewport
        action8 = new ExportDiagramToImageAction(comps, location, fileNames, "gif", imageExporter);
        action8.execute();

        // export multiple diagrams with viewport
        action8 = new ExportDiagramToImageAction(comps, rects, location, fileNames, "gif", imageExporter);
        action8.execute();
    }
}
