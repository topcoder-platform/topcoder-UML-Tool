/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.stresstests;

import java.io.File;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AddAbstractionAction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for the class {@link AddAbstractionAction}.
 * @author urtks
 * @version 1.0
 */
public class AddActionTests extends TestCase {
    /**
     * Represents a ModelElement instance.
     */
    private AbstractionImpl modelElement;

    /**
     * Represents an UMLModelManager instance.
     */
    private UMLModelManager manager;

    /**
     * Sets up the test environment.
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        try {
            ConfigManager.getInstance().add("stresstests/logging_wrapper.xml");
            ConfigManager.getInstance().add(new File("test_files/stresstests/config.xml").getCanonicalPath());
        } catch (Exception e) {
        }

        modelElement = new AbstractionImpl();
        manager = new UMLModelManager();

        // FIXME
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(manager,
                ProjectConfigurationManager.class.getName());
        manager.setProjectConfigurationManager(projectConfigurationManager);
        manager.setProjectLanguage("Java");
    }

    /**
     * Stress test for the method {@link AddAbstractionAction#execute()}.
     * @throws Exception
     *             to JUnit
     */
    public void testExecute() throws Exception {
        AddAbstractionAction addAction = new AddAbstractionAction(modelElement, manager);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            addAction.execute();
        }
        System.out.println("Running AddAbstractionAction#execute for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    /**
     * Stress test for the methods {@link AddAbstractionAction#undo()} and
     * {@link AddAbstractionAction#redo()}.
     * @throws Exception
     *             to JUnit
     */
    public void testUndoAndRedo() throws Exception {
        AddAbstractionAction addAction = new AddAbstractionAction(modelElement, manager);

        addAction.execute();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            addAction.undo();
            addAction.redo();
        }
        System.out.println("Running AddAbstractionAction#undo and AddAbstractionAction#redo for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }
}