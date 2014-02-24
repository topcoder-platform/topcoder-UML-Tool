/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit test cases for class CutAction. Since CutAction is abstract class the
 * simple sub-class MockCutAction will be used for testing. You can refer to
 * MockCutAction for more detail.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutActionTest extends HelpTestCase {

    /**
     * The ModelElement instance for the test.
     */
    private ModelElement modelElement;

    /**
     * The ClassToolUtil instance for the test.
     */
    private ClassToolUtil classToolUtil = new EnumerationUtil();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard;

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

        modelElement = new EnumerationImpl();
        namespace = manager.getModel();

        modelElement.setNamespace(namespace);
        namespace.addOwnedElement(modelElement);

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
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
     * Test constructor, with correct modelElement, classToolUtil and clipboard.
     */
    public void testCtor() {
        CutAction cutAction = new MockCutAction(modelElement, classToolUtil, clipboard);

        assertTrue("Should return CutAction instance.", cutAction instanceof CutAction);
    }

    /**
     * Test constructor, with null modelElement. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullModelElement() {
        try {
            new MockCutAction(null, classToolUtil, clipboard);
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
            new MockCutAction(modelElement, null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null clipboard. No IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullClipboard() {
        try {
            new MockCutAction(modelElement, classToolUtil, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }

    /**
     * Test execute.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testExecute() throws Exception {
        CutAction cutAction = new MockCutAction(modelElement, classToolUtil, clipboard);
        cutAction.execute();

        assertEquals("A new modelElement should be added to the clipboard.", ClassElementsTransfer.ENUMERATION_FLAVOR,
                clipboard.getContents(new Object()).getTransferDataFlavors()[0]);
        assertFalse("A new not the old modelElement should be added to the clipboard.", clipboard.getContents(
                new Object()).getTransferData(ClassElementsTransfer.ENUMERATION_FLAVOR).equals(modelElement));

        assertFalse("The old modelElement should be removed.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test execute with not proporly set modelElement. ActionExecutionException
     * is expected.
     */
    public void testExecuteExceptin() {
        try {
            namespace.removeOwnedElement(modelElement);
            CutAction cutAction = new MockCutAction(modelElement, classToolUtil, clipboard);
            cutAction.execute();
            fail("ActionExecutionException is expected.");
        } catch (ActionExecutionException aee) {
            // pass
        }
    }

    /**
     * Test undo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testUndo() throws Exception {
        CutAction cutAction = new MockCutAction(modelElement, classToolUtil, clipboard);
        cutAction.execute();

        assertFalse("The modelElement should be removed.", namespace.containsOwnedElement(modelElement));
        cutAction.undo();
        assertTrue("The modelElement should be added.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test undo, without execute.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testUndoNoExecute() throws Exception {
        CutAction cutAction = new MockCutAction(modelElement, classToolUtil, clipboard);

        cutAction.undo();
        assertTrue("The modelElement should be added.", namespace.containsOwnedElement(modelElement));
    }

    /**
     * Test redo.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRedo() throws Exception {
        CutAction cutAction = new MockCutAction(modelElement, classToolUtil, clipboard);

        cutAction.execute();
        cutAction.undo();
        assertTrue("The modelElement should be added to the namespace.", namespace.containsOwnedElement(modelElement));

        cutAction.redo();
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
        CutAction cutAction = new MockCutAction(modelElement, classToolUtil, clipboard);
        cutAction.redo();

        // confirm the contents of the outputFile
        assertTrue(confirmFileContents("Impossible provide redo cut action."));
    }
}