/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AccuracyPasteAction;
import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.MockClassToolUtil;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

/**
 * Accuracy tests for PasteAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();

        modelElement = new EnumerationImpl();
        classToolUtil = new MockClassToolUtil();
        transferable = new ClassElementsTransfer((Enumeration) modelElement);
        namespace = new ModelImpl();
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
    private ModelElement modelElement;

    /**
     * ClassToolUtil instance for test.
     */
    private MockClassToolUtil classToolUtil;

    /**
     * Transferable instance for test.
     */
    private ClassElementsTransfer transferable;

    /**
     * Namespace instance for test.
     */
    private Namespace namespace;

    /**
     * Test PasteAction#PasteAction(Transferable, DataFlavor, ClassToolUtil,
     * Namespace)
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor() throws Exception {
        AccuracyPasteAction pasteAction = new AccuracyPasteAction(transferable,
                ClassElementsTransfer.ENUMERATION_FLAVOR, classToolUtil,
                namespace);

        assertEquals("ModelElement is incorrect.", modelElement, pasteAction
                .getModelElement());
        assertEquals("ClassToolUtil is incorrect.", classToolUtil, pasteAction
                .getClassToolUtil());
    }

    /**
     * Test PasteAction#execute().
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testExecute() throws Exception {
        AccuracyPasteAction pasteAction = new AccuracyPasteAction(transferable,
                ClassElementsTransfer.ENUMERATION_FLAVOR, classToolUtil,
                namespace);
        pasteAction.execute();

        assertTrue("ModelElement should have been added to namespace.",
                namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test PasteAction#undo().
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testUndo() throws Exception {
        AccuracyPasteAction pasteAction = new AccuracyPasteAction(transferable,
                ClassElementsTransfer.ENUMERATION_FLAVOR, classToolUtil,
                namespace);

        pasteAction.execute();
        assertTrue("ModelElement should have been added to namespace.",
                namespace.containsOwnedElement(modelElement));

        pasteAction.undo();
        assertFalse(
                "The modelElement should have been removed from the namespace.",
                namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test PasteAction#redo().
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testRedo() throws Exception {
        AccuracyPasteAction pasteAction = new AccuracyPasteAction(transferable,
                ClassElementsTransfer.ENUMERATION_FLAVOR, classToolUtil,
                namespace);

        pasteAction.execute();
        pasteAction.undo();
        assertFalse(
                "The modelElement should have been removed from the namespace.",
                namespace.containsOwnedElement(modelElement));

        pasteAction.redo();
        assertTrue("ModelElement should have been restored to namespace.",
                namespace.containsOwnedElement(modelElement));
    }

}