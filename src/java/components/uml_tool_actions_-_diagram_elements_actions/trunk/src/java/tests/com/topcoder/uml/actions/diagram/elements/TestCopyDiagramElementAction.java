/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <P>
 * Tests for CopyDiagramElementAction.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestCopyDiagramElementAction extends
        DiagramElementsActionsTestCase {

    /**
     * <P>
     * The clipboard used in the tests.
     * </P>
     */
    private Clipboard simpleClipboard;

    /**
     * <P>
     * The CopyDiagramElementAction used in the tests.
     * </P>
     *
     */
    private CopyDiagramElementAction copyAction;

    /**
     * <P>
     * Sets up for the tests. Initialize the clipboard and the copyAction.
     * </P>
     *
     */
    protected void setUp() {
        simpleClipboard = new Clipboard("clipboard");
        copyAction = new CopyDiagramElementAction(SIMPLE_ELLIPSE,
                simpleClipboard);
    }

    /**
     * <P>
     * Tests the constructor with null as the element. IllegalArgumentException
     * is expected.
     * </P>
     *
     */
    public void test1stConstructorWithNullAsElement() {
        try {
            new CopyDiagramElementAction(null, SYSTEM_CLIPBOARD);
            fail("element" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the constructor with null as the clipboard. The system clipboard
     * should be used in this condition.
     * </P>
     *
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    public void test1stConstructorWithNullAsClipboard()
        throws NoSuchFieldException,
            IllegalAccessException {
        CopyDiagramElementAction simpleCopyAction = new CopyDiagramElementAction(
                SIMPLE_ELLIPSE, null);
        Clipboard clipboard = (Clipboard) reflectObjectField("clipboard",
                simpleCopyAction);
        assertTrue("The system clipboard is expected", clipboard == SYSTEM_CLIPBOARD);
    }

    /**
     * <P>
     * Tests the constructor with specified diagram element and clipboard.
     * </P>
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    public void test1stConstructor() throws
            NoSuchFieldException, IllegalAccessException {
        CopyDiagramElementAction createdAction = new CopyDiagramElementAction(
                SIMPLE_ELLIPSE, simpleClipboard);
        CopiedElement copiedElement = (CopiedElement) reflectObjectField(
                "copiedElement", createdAction);
        assertTrue("The SIMPLE_ELLIPSE is expected", copiedElement
                .getTransferData(SIMPLE_ELLIPSE_FLAVOR) == SIMPLE_ELLIPSE);
        Clipboard clipboard = (Clipboard) reflectObjectField("clipboard",
                createdAction);
        assertTrue("The simpleClipboard is expected",
                clipboard == simpleClipboard);
    }

    /**
     * <P>
     * Tests the second constructor with null as the diagram element.
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void test2ndConstructorWithNull() {
        try {
            new CopyDiagramElementAction(null);
            fail("element" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the second constructor with specified diagram element and clipboard.
     * </P>
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    public void test2ndConstructor() throws
            NoSuchFieldException, IllegalAccessException {
        CopyDiagramElementAction createdAction = new CopyDiagramElementAction(
                SIMPLE_ELLIPSE);
        CopiedElement copiedElement = (CopiedElement) reflectObjectField(
                "copiedElement", createdAction);
        assertTrue("The SIMPLE_ELLIPSE is expected",
                SIMPLE_ELLIPSE == copiedElement
                        .getTransferData(SIMPLE_ELLIPSE_FLAVOR));
        Clipboard clipboard = (Clipboard) reflectObjectField("clipboard",
                createdAction);
        assertEquals("The simpleClipboard is expected", SYSTEM_CLIPBOARD,
                clipboard);
    }

    /**
     * <P>
     * Tests the execute method. The element should be copied to the clipboard
     * and the action should get the ownership of the clipboard.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any error happened while executing the action
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     * @throws UnsupportedFlavorException
     *             if the clipboard not support the DataFlavor
     * @throws IOException
     *             if any io error happened
     */
    public void testExecute() throws ActionExecutionException,
            NoSuchFieldException, IllegalAccessException,
            UnsupportedFlavorException, IOException {
        copyAction.execute();

        assertTrue("The element is expected", simpleClipboard
                .getData(SIMPLE_ELLIPSE_FLAVOR) == SIMPLE_ELLIPSE);
        ClipboardOwner owner = (ClipboardOwner) reflectObjectField("owner",
                simpleClipboard);
        assertTrue("The owner of the clipboard should be copyAction",
                owner == copyAction);
        assertTrue("True should set to currentlyOwnsClipboard", copyAction
                .getCurrentlyOwnsClipboard());
    }

    /**
     * <P>
     * Tests execute method in the condition unknown error happened.
     * ActionExecutionException is expected.
     * </P>
     *
     */
    public void testExecuteErrorCondition() {
        Clipboard badClipboard = new BadClipboard("clipboard");
        CopyDiagramElementAction errorAction = new CopyDiagramElementAction(
                SIMPLE_ELLIPSE, badClipboard);
        try {
            errorAction.execute();
            fail("ActionExecutionException should be thrown");
        } catch (ActionExecutionException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the lostOwnerShip. The clipboard argument is null so
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testLostOwnerShipWithNullClipboard() {
        try {
            copyAction.lostOwnership(null, SIMPLE_ELLIPSE_ELEMENT);
            fail("clipboard" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the lostOwnerShip method. The content is null so
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testLostOwnerShipWithNullContent() {
        try {
            copyAction.lostOwnership(simpleClipboard, null);
            fail("contents" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the lostOwnerShip method.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any error happened while executing the action
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    public void testLostOwnerShipSuccess() throws ActionExecutionException,
            NoSuchFieldException, IllegalAccessException {
        copyAction.execute();
        copyAction.lostOwnership(simpleClipboard, SIMPLE_ELLIPSE_ELEMENT);
        assertFalse("currentlyOwnsClipboard should be set to false", copyAction
                .getCurrentlyOwnsClipboard());
    }

    /**
     * <P>
     * Tests the getCurrentlyOwnsClipboard method.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any error happened while executing the action.
     */
    public void testgetCurrentlyOwnsClipboard() throws ActionExecutionException {
        assertFalse("doesn't own clipboard", copyAction
                .getCurrentlyOwnsClipboard());
        copyAction.execute();
        assertTrue("owns clipboard", copyAction.getCurrentlyOwnsClipboard());
        copyAction.lostOwnership(simpleClipboard, SIMPLE_ELLIPSE_ELEMENT);
        assertFalse("lost ownership again", copyAction
                .getCurrentlyOwnsClipboard());
    }

    /**
     * <P>
     * A mock for Clipboard. This class will used to mock the error condition
     * while setting contents to the clipboard.
     * </P>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     *
     */
    class BadClipboard extends Clipboard {

        /**
         * <P>
         * Creates the instance of BadClipboard.
         * </P>
         *
         * @param name
         *            The name of the clipboard
         */
        public BadClipboard(String name) {
            super(name);
        }

        /**
         * <P>
         * The mock of setContents method to mock error while setting contents.
         * </P>
         *
         * @throws IllegalStateException
         *             it will just throw this exception
         */
        public void setContents(Transferable contents, ClipboardOwner owner) {
            throw new IllegalStateException("I just throw exception");
        }
    }
}
