/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AccuracyMockRemoveAction;
import com.topcoder.uml.actions.model.classifiers.MockClassToolUtil;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

/**
 * <p>
 * Unit test cases for class RemoveAction. Since RemoveAction is abstract class
 * the simple sub-class MockRemoveAction will be used for testing. You can refer
 * to MockRemoveAction for more detail.
 * </p>
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
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
     * ModelElement instance for test.
     */
    private ModelElement modelElement = new AbstractionImpl();

    /**
     * ClassToolUtil instance for test.
     */
    private MockClassToolUtil classToolUtil = new MockClassToolUtil();

    /**
     * Test RemoveAction#RemoveAction(ModelElement, ClassToolUtil)
     */
    public void testRemoveAction() {
        AccuracyMockRemoveAction removeAction = new AccuracyMockRemoveAction(
                modelElement, classToolUtil);

        assertEquals("ModelElement is incorrect.", modelElement, removeAction
                .getModelElement());
        assertEquals("ClassToolUtil is incorrect.", classToolUtil, removeAction
                .getClassToolUtil());
    }

    /**
     * Test RemoveAction#execute().
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testExecute() throws Exception {
        Namespace namespace = TestUtil.getInstance().getNamespace();
        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);

        AccuracyMockRemoveAction removeAction = new AccuracyMockRemoveAction(
                modelElement, classToolUtil);
        removeAction.execute();

        assertFalse(
                "ModelElement should have been removed from the namespace.",
                namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test RemoveAction#undo().
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testUndo() throws Exception {
        Namespace namespace = TestUtil.getInstance().getNamespace();
        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);

        AccuracyMockRemoveAction removeAction = new AccuracyMockRemoveAction(
                modelElement, classToolUtil);

        removeAction.execute();
        assertFalse(
                "ModelElement should have been removed from the namespace.",
                namespace.containsOwnedElement(modelElement));

        removeAction.undo();
        assertTrue("ModelElement should have been restored to the namespace.",
                namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test RemoveAction#redo().
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testRedo() throws Exception {
        Namespace namespace = TestUtil.getInstance().getNamespace();
        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);

        AccuracyMockRemoveAction removeAction = new AccuracyMockRemoveAction(
                modelElement, classToolUtil);

        removeAction.execute();
        removeAction.undo();
        removeAction.redo();

        assertFalse(
                "The modelElement should have been removed from the namespace.",
                namespace.containsOwnedElement(modelElement));
    }
}