/**
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AccuracyMockAddAction;
import com.topcoder.uml.actions.model.classifiers.MockClassToolUtil;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * Accuracy tests for AddAction.
 *
 * @author superZZ
 * @version 1.0
 */
public class AddActionTest extends TestCase {
    /**
     * Load logging configuration.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(manager,
                ProjectConfigurationManager.class.getName());
        manager.setProjectConfigurationManager(projectConfigurationManager);
        manager.setProjectLanguage("Java");
    }

    /**
     * Unload logging configuration.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestUtil.unloadConfiguration();
    }

    /**
     * The ModelElement instance for the test.
     */
    private ModelElement modelElement = new DependencyImpl();

    /**
     * The ClassToolUtil instance for the test.
     */
    private MockClassToolUtil classToolUtil = new MockClassToolUtil();

    /**
     * The UMLModelManager instance for the test.
     */
    private UMLModelManager manager = new UMLModelManager();

    /**
     * The Namespace instance for the test.
     */
    private Namespace namespace = manager.getModel();

    /**
     * Test AddAction#AddAction(ModelElement, ClassToolUtil, UMLModelManager ,
     * Namespace)
     */
    public void testAddAction() {
        AccuracyMockAddAction addAction = new AccuracyMockAddAction(
                modelElement, classToolUtil, manager, namespace);

        assertEquals("Should return ModelElement instance.", modelElement,
                addAction.getModelElement());
        assertEquals("Should return ClassToolUtil instance.", classToolUtil,
                addAction.getClassToolUtil());
    }

    /**
     * Test AddAction#execute.
     *
     * @throws ActionExecutionException
     *             Exception to JUnit.
     *
     */
    public void testExecute() throws ActionExecutionException {
        AccuracyMockAddAction addAction = new AccuracyMockAddAction(
                modelElement, classToolUtil, manager, namespace);
        addAction.execute();

        assertTrue("The modelElement should be added to the namespace.",
                namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test AddAction#undo.
     *
     * @throws ActionExecutionException
     *             Exception to JUnit.
     *
     */
    public void testUndo() throws ActionExecutionException {
        AccuracyMockAddAction addAction = new AccuracyMockAddAction(
                modelElement, classToolUtil, manager, namespace);

        addAction.execute();
        assertTrue("The modelElement should be added to the namespace.",
                namespace.containsOwnedElement(modelElement));

        addAction.undo();
        assertFalse("The modelElement should be removed from the namespace.",
                namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test AddAction#redo.
     *
     * @throws ActionExecutionException
     *             Exception to JUnit.
     */
    public void testRedo() throws ActionExecutionException {
        AccuracyMockAddAction addAction = new AccuracyMockAddAction(
                modelElement, classToolUtil, manager, namespace);

        addAction.execute();
        addAction.undo();
        assertFalse("The modelElement should be removed from the namespace.",
                namespace.containsOwnedElement(modelElement));

        addAction.redo();
        assertTrue("The modelElement should be added to the namespace.",
                namespace.containsOwnedElement(modelElement));
    }
}