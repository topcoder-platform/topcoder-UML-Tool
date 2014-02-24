/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.stresstests;

import java.io.File;

import javax.swing.JComponent;
import javax.swing.JLabel;

import junit.framework.TestCase;

import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.uml.actions.project.CreateNewProjectAction;
import com.topcoder.uml.actions.project.ExportDiagramToImageAction;
import com.topcoder.uml.actions.project.ExportToXMIFileAction;
import com.topcoder.uml.actions.project.GenerateCodeAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;

/**
 * <p>
 * Stress test cases for component UML Project Actions.
 * </p>
 * <p>
 * There are no special algorithm for this component and the thread-safety is
 * not required, so only efficiency is tested here.
 * </p>
 * @author fuyun
 * @version 1.0
 */
public class ProjectActionsStressTest extends TestCase {

    /**
     * Stress test for class <code>CreateNewProjectAction</code>.
     * @throws Exception if there is any problem.
     */
    public void testCreateNewProjectActionStress() throws Exception {

        UMLModelManager manager = new UMLModelManager();
        for (int i = 0; i < 100; i++) {
            CreateNewProjectAction action = new CreateNewProjectAction("test",
                    manager);
            action.execute();
        }
    }

    /**
     * Stress test for class <code>ExportDiagramToImageAction</code>.
     * @throws Exception if there is any problem.
     */
    public void testExportDiagramToImageActionStress() throws Exception {

        JComponent component = new JLabel();
        ImageExporter exporter = new ImageExporter();

        for (int i = 0; i < 100; i++) {
            ExportDiagramToImageAction action = new ExportDiagramToImageAction(
                    component, "location", "fileName", "format", exporter);
            action.execute();
        }
    }

    /**
     * Stress test for class <code>ExportToXMIFileAction</code>.
     * @throws Exception if there is any problem.
     */
    public void testExportToXMIFileActionStress() throws Exception {
        UMLModelManager manager = new UMLModelManager();
        for (int i = 0; i < 100; i++) {
            ExportToXMIFileAction action = new ExportToXMIFileAction(new File(
                    "test_files/test.xmi"), true, manager);
            action.execute();
        }
    }

    /**
     * Stress test for class <code>GenerateCodeAction</code>.
     * @throws Exception if there is any problem.
     */
    public void testGenerateCodeActionStress() throws Exception {

        Classifier classifier = new MyClassifierImpl();
        CodeGenerator generator = new CodeGenerator();

        for (int i = 0; i < 100; i++) {
            GenerateCodeAction action = new GenerateCodeAction("language",
                    "location", classifier, generator);
            action.execute();
        }
    }

}
