/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Unit test cases for class RemoveAction. Since RemoveAction is abstract class
 * the simple sub-class MockRemoveAction will be used for testing. You can refer
 * to MockRemoveAction for more detail.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveActionTest extends HelpTestCase {

    /**
     * The ModelElement instance for the test.
     */
    private ModelElement modelElement;

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
    private Namespace namespace;

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        namespace = manager.getModel();
        modelElement = new DependencyImpl();

        modelElement.setNamespace(namespace);
        namespace.addOwnedElement(modelElement);
    }

    /**
     * Teardown routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test constructor, with correct modelElement and classToolUtil.
     */
    public void testCtor() {
        RemoveAction removeAction = new MockRemoveAction(modelElement, classToolUtil);

        assertEquals("Should return ModelElement instance.", modelElement, removeAction.getModelElement());
        assertEquals("Should return ClassToolUtil instance.", classToolUtil, removeAction.getClassToolUtil());
    }

    /**
     * Test constructor, with null modelElement. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullModelElement() {
        try {
            new MockRemoveAction(null, classToolUtil);
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
            new MockRemoveAction(modelElement, null);
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
        RemoveAction removeAction = new MockRemoveAction(modelElement, classToolUtil);
        removeAction.execute();

        assertFalse("The modelElement should be removed from the namespace.", namespace
                .containsOwnedElement(modelElement));
    }

    /**
     * Test undo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testUndo() throws Exception {
        RemoveAction removeAction = new MockRemoveAction(modelElement, classToolUtil);

        removeAction.execute();
        assertFalse("The modelElement should be removed from the namespace.", namespace
                .containsOwnedElement(modelElement));

        removeAction.undo();
        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test undo, without execute.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testUndoNoExecute() throws Exception {
        RemoveAction removeAction = new MockRemoveAction(modelElement, classToolUtil);
        removeAction.undo();

        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test redo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRedo() throws Exception {
        RemoveAction removeAction = new MockRemoveAction(modelElement, classToolUtil);

        removeAction.execute();
        removeAction.undo();
        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));

        removeAction.redo();
        assertFalse("The modelElement should be removed from the namespace.", namespace
                .containsOwnedElement(modelElement));
    }

    /**
     * Test redo, without undo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRedoNoUndo() throws Exception {
        RemoveAction removeAction = new MockRemoveAction(modelElement, classToolUtil);
        removeAction.redo();

        // confirm the contents of the outputFile
        assertTrue(confirmFileContents("Impossible provide redo remove action."));
    }
}