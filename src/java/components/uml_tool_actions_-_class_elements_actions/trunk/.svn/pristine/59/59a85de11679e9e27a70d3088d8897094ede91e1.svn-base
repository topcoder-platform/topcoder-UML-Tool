/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

/**
 * <p>
 * Unit test cases for class PasteAction. Since PasteAction is abstract class
 * the simple sub-class MockPasteAction will be used for testing. You can refer
 * to MockPasteAction for more detail.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteActionTest extends HelpTestCase {

    /**
     * A ModelElement instance used for test.
     */
    private ModelElement modelElement = new EnumerationImpl();

    /**
     * A ClassToolUtil instance used for test.
     */
    private ClassToolUtil classToolUtil = new EnumerationUtil();

    /**
     * A Transferable instance used for test.
     */
    private ClassElementsTransfer transferable = new ClassElementsTransfer((Enumeration) modelElement);

    /**
     * The Namespace instance for the test.
     */
    private Namespace namespace = new ModelImpl();

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
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
     * Test constructor, with correct transferable, dataFlavor, classToolUtil
     * and namespace.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor() throws Exception {
        PasteAction pasteAction = new MockPasteAction(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR,
                classToolUtil, namespace);

        assertEquals("Should return ModelElement instance.", modelElement, pasteAction.getModelElement());
        assertEquals("Should return ClassToolUtil instance.", classToolUtil, pasteAction.getClassToolUtil());
    }

    /**
     * Test constructor, with null transferable. IllegalArgumentException is
     * expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorWithNullTransferable() throws Exception {
        try {
            new MockPasteAction(null, ClassElementsTransfer.ENUMERATION_FLAVOR, classToolUtil, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null dataFlavor. IllegalArgumentException is
     * expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorWithNullDataFlavor() throws Exception {
        try {
            new MockPasteAction(transferable, null, classToolUtil, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null classToolUtil. IllegalArgumentException is
     * expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorWithNullUtil() throws Exception {
        try {
            new MockPasteAction(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR, null, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null modelElement. IllegalArgumentException is
     * expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorWithNullNamespace() throws Exception {
        try {
            new MockPasteAction(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR, classToolUtil, null);
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
        PasteAction pasteAction = new MockPasteAction(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR,
                classToolUtil, namespace);
        pasteAction.execute();

        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test undo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testUndo() throws Exception {
        PasteAction pasteAction = new MockPasteAction(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR,
                classToolUtil, namespace);

        pasteAction.execute();
        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));

        pasteAction.undo();
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
        PasteAction pasteAction = new MockPasteAction(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR,
                classToolUtil, namespace);
        pasteAction.undo();

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
        PasteAction pasteAction = new MockPasteAction(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR,
                classToolUtil, namespace);

        pasteAction.execute();
        pasteAction.undo();
        assertFalse("The modelElement should be removed from the namespace.", namespace
                .containsOwnedElement(modelElement));

        pasteAction.redo();
        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test redo, without undo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRedoNoUndo() throws Exception {
        PasteAction pasteAction = new MockPasteAction(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR,
                classToolUtil, namespace);
        pasteAction.redo();

        // confirm the contents of the outputFile
        assertTrue(confirmFileContents("Impossible provide redo paste action."));
    }
}