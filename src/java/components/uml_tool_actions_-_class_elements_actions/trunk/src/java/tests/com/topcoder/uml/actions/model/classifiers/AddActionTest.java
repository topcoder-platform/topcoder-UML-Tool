/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Unit test cases for class AddAction. Since AddAction is abstract class the
 * simple sub-class MockAddAction will be used for testing. You can refer to
 * MockAddAction for more detail.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddActionTest extends HelpTestCase {

    /**
     * The ModelElement instance for the test.
     */
    private ModelElement modelElement = new DependencyImpl();

    /**
     * The ClassToolUtil instance for the test.
     */
    private ClassToolUtil classToolUtil = new MockClassToolUtil();

    /**
     * The UMLModelManager instance for the test.
     */
    private UMLModelManager manager = new UMLModelManager();

    /**
     * The Namespace instance for the test.
     */
    private Namespace namespace = manager.getModel();

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfig("test_files/config.xml");
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(manager,
                ProjectConfigurationManager.class.getName());
        manager.setProjectConfigurationManager(projectConfigurationManager);
        manager.setProjectLanguage("Java");
    }

    /**
     * Teardown routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * Test constructor, with correct modelElement, classToolUtil, manager and
     * namespace.
     */
    public void testCtor() {
        AddAction addAction = new MockAddAction(modelElement, classToolUtil, manager, namespace);

        assertEquals("Should return ModelElement instance.", modelElement, addAction.getModelElement());
        assertEquals("Should return ClassToolUtil instance.", classToolUtil, addAction.getClassToolUtil());
    }

    /**
     * Test constructor, with null modelElement. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullModelElement() {
        try {
            new MockAddAction(null, classToolUtil, manager, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null classToolUtil. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullClassToolUtil() {
        try {
            new MockAddAction(modelElement, null, manager, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null manager. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullUMLModelManager() {
        try {
            new MockAddAction(modelElement, classToolUtil, null, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null namespace. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullNamespace() {
        try {
            new MockAddAction(modelElement, classToolUtil, manager, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test execute.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testExecute() throws Exception {
        AddAction addAction = new MockAddAction(modelElement, classToolUtil, manager, namespace);
        addAction.execute();

        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test undo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testUndo() throws Exception {
        AddAction addAction = new MockAddAction(modelElement, classToolUtil, manager, namespace);

        addAction.execute();
        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));

        addAction.undo();
        assertFalse("The modelElement should be removed from the namespace.", namespace
                .containsOwnedElement(modelElement));
    }

    /**
     * Test undo, without execute.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testUndoNoExecute() throws Exception {
        modelElement.setNamespace(new ModelImpl());
        AddAction addAction = new MockAddAction(modelElement, classToolUtil, manager, namespace);
        addAction.undo();

        // confirm the contents of the outputFile
        assertTrue(confirmFileContents("Given element doesn't exist in the namespace."));
    }

    /**
     * Test redo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRedo() throws Exception {
        AddAction addAction = new MockAddAction(modelElement, classToolUtil, manager, namespace);

        addAction.execute();
        addAction.undo();
        assertFalse("The modelElement should be removed from the namespace.", namespace
                .containsOwnedElement(modelElement));

        addAction.redo();
        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test redo, without undo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRedoNoUndo() throws Exception {
        AddAction addAction = new MockAddAction(modelElement, classToolUtil, manager, namespace);
        addAction.redo();

        // confirm the contents of the outputFile
        assertTrue(confirmFileContents("Impossible provide redo add action."));
    }
}