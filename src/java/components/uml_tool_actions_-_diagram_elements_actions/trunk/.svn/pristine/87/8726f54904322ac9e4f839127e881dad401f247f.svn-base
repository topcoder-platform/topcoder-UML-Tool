/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <P>
 * Tests for CutDiagramElementAction.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 *
 */
public class TestCutDiagramElementAction extends DiagramElementsActionsTestCase {

    /**
     * <P>
     * The CutDiagramElementAction in the tests.
     * </P>
     *
     */
    private CutDiagramElementAction cutAction;

    /**
     * <P>
     * The Diagram in the tests.
     * </P>
     *
     */
    private Diagram diagram;

    /**
     * <P>
     * The clipboard used in the tests.
     * </P>
     *
     */
    private Clipboard clipboard;

    /**
     * <P>
     * Sets up for the tests. Initialize the clipboard, diagram and the cutAction for the tests.
     * </P>
     *
     */
    protected void setUp() {
        clipboard = new Clipboard("clipboard");
        diagram = new Diagram();
        cutAction = new CutDiagramElementAction(SIMPLE_ELLIPSE, diagram,
                clipboard);
    }

    /**
     * <P>
     * Tests the constructor with null as the element. So
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorWithNullElement() {
        try {
            new CutDiagramElementAction(null, EMPTY_DIAGRAM, SYSTEM_CLIPBOARD);
            fail("element" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the constructor with null as diagram. So IllegalArgumentException is
     * expected.
     * </P>
     *
     *
     */
    public void testConstructorWithNullDiagram() {
        try {
            new CutDiagramElementAction(SIMPLE_ELLIPSE, null, SYSTEM_CLIPBOARD);
            fail("diagram" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the constructor with null as clipboard. The clipboard can be null so
     * no Exception should be thrown.
     * </P>
     *
     */
    public void testConstructorWithNullClipboard() {
        try {
            new CutDiagramElementAction(SIMPLE_ELLIPSE, EMPTY_DIAGRAM, null);
        } catch (IllegalArgumentException e) {
            fail("no exception should be thrown");
        }
    }

    /**
     * <P>
     * Tests the execute method. The element isn't in the diagram so the remove
     * action will throw no such element exception. The exception will be
     * wrapped to ActionExecutionException in the CutDiagramElementException. So an
     * ActionExecutionException is expected.
     * </P>
     *
     */
    public void testExecuteWithoutElementInDiagram() {
        try {
            cutAction.execute();
            fail("ActionExecutionException should be thrown");
        } catch (ActionExecutionException e) {
            // success
        }

    }

    /**
     * <P>
     * Tests the execute method. The element should be cut from the diagram.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any error happened while executing the action
     * @throws UnsupportedFlavorException
     *             if SIMPLE_ELLIPSE_FLAVOR is not supported by the clipboard
     * @throws IOException
     *             if any io error happened
     */
    public void testExecute() throws ActionExecutionException,
            UnsupportedFlavorException, IOException {
        diagram.addContained(SIMPLE_ELLIPSE);
        cutAction.execute();
        DiagramElement content = (DiagramElement) clipboard
                .getData(SIMPLE_ELLIPSE_FLAVOR);
        assertTrue("the content of clipboard should be SIMPLE_ELLIPSE",
                content == SIMPLE_ELLIPSE);
        assertFalse("the ellipse should be removed", diagram
                .containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the undo method but the acion isn't executed. CannotUndoException is expected.
     * </P>
     */
    public void testUndoWithoutExecuted() {
        assertException(null);
        cutAction.undo();
        assertException(CannotUndoException.class);
    }

    /**
     * <P>
     * Tests the undo method. The action is already undone. CannotUndoException is expected.
     * </P>
     *
     * @throws ActionExecutionException if any error happened while executing the action
     */
    public void testUndoButUndone() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        cutAction.execute();
        cutAction.undo();
        assertException(null);
        cutAction.undo();
        assertException(CannotUndoException.class);
    }

    /**
     * <P>
     * Tests the undo method. The element removed by this action should be added back.
     * </P>
     *
     * @throws ActionExecutionException if any error happened while executing the action.
     */
    public void testUndo() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        cutAction.execute();
        assertFalse("the element should be removed", diagram.containsContained(SIMPLE_ELLIPSE));
        cutAction.undo();
        assertTrue("the element should be added back", diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the redo method. The action is not undone. CannotRedoException is expected.
     * </P>
     *
     */
    public void testRedoWithoutUndone() {
        assertException(null);
        cutAction.redo();
        assertException(CannotRedoException.class);
    }

    /**
     * <P>
     * Tests the redo method. The action is redone. CannotRedoException is expected.
     * </P>
     *
     * @throws ActionExecutionException if any runtime exception happened while executing the action
     */
    public void testRedoButRedone() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        cutAction.execute();
        cutAction.undo();
        cutAction.redo();
        assertException(null);
        cutAction.redo();
        assertException(CannotRedoException.class);
    }

    /**
     * <P>
     * Tests the redo method. Remove the element before redo. The CannotRedoException is expected.
     * </P>
     *
     * @throws ActionExecutionException if any runtime exception happened while executing the action
     */
    public void testRedoButNoSuchElement() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        cutAction.execute();
        cutAction.undo();
        diagram.removeContained(SIMPLE_ELLIPSE);
        assertException(null);
        cutAction.redo();
        assertException(CannotRedoException.class);
    }
    /**
     * <P>
     * Tests the redo method. The redo method should
     * </P>
     * @throws ActionExecutionException if any error happened while executing the action
     */
    public void testRedo() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        cutAction.execute();
        cutAction.undo();
        assertTrue(diagram.containsContained(SIMPLE_ELLIPSE));
        cutAction.redo();
        assertFalse(diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the undo method after redo the action.
     * </P>
     *
     * @throws ActionExecutionException if any runtime exception happened while executing the action
     */
    public void testUndoAfterRedo() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        cutAction.execute();
        cutAction.undo();
        cutAction.redo();
        cutAction.undo();
        assertTrue(diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the addEdit method. False is expected.
     * </P>
     *
     */
    public void testAddEdit() {
        assertFalse("the request should be refused", cutAction.addEdit());
    }

    /**
     * <P>
     * Tests the replaceEdit method. False is expected.
     * </P>
     *
     */
    public void testReplaceEdit() {
        CutDiagramElementAction anEdit = new CutDiagramElementAction(SIMPLE_ELLIPSE, EMPTY_DIAGRAM, null);
        assertFalse("false is expected", cutAction.replaceEdit(anEdit));
    }

    /**
     * <P>
     * Tests the canUndo method. This method is no supported. So UnsupportedOperationException is expected.
     * </P>
     *
     */
    public void testCanUndo() {
        try {
            cutAction.canUndo();
            fail("UnsupportedOperationException should be thrown");
        } catch (UnsupportedOperationException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the canUndo method. This method is no supported. So UnsupportedOperationException is expected.
     * </P>
     *
     */
    public void testCanRedo() {
        try {
            cutAction.canRedo();
            fail("UnsupportedOperationException is expected");
        } catch (UnsupportedOperationException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the die method. This method is no supported. So UnsupportedOperationException is expected.
     * </P>
     *
     */
    public void testDie() {
        try {
            cutAction.die();
            fail("UnsupportedOperationException is expected");
        } catch (UnsupportedOperationException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the isSignificant method. True is expected.
     * </P>
     *
     */
    public void testIsSignificant() {
        assertTrue("The cut action is significant", cutAction.isSignificant());
    }

    /**
     * <P>
     * Gets the last exception from cut action and asserts if it is the expected one.
     * </P>
     *
     * @param expected the expected exception.
     */
    private void assertException(Class expected) {
        Exception lastException = cutAction.getLastException();
        if (expected == null) {
            assertNull("lastException is expected to be null", lastException);
        } else {
            assertEquals("lastException should be an expected exception", expected,
                lastException.getClass());
        }
    }
}
