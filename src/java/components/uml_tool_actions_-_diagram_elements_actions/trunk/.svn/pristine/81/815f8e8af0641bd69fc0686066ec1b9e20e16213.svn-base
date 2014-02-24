/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.StringSelection;
import java.util.NoSuchElementException;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <P>
 * Tests for PasteDiagramElementAction.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 *
 */
public class TestPasteDiagramElementAction extends DiagramElementsActionsTestCase {

    /**
     * <P>
     * The diagram used in the tests.
     * </P>
     *
     */
    private Diagram diagram;

    /**
     * <P>
     * The PasteDiagramElementAction object used in the tests.
     * </P>
     *
     */
    private PasteDiagramElementAction pasteAction;

    /**
     * <P>
     * Sets up for the tests. Initialize the diagram and the pasteAction.
     * </P>
     *
     */
    protected void setUp() {
        diagram = new Diagram();
        pasteAction = new PasteDiagramElementAction(SIMPLE_ELLIPSE_ELEMENT, diagram);
    }

    /**
     * <P>
     * Tests the constructor. The transferable is null so IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorWithNullTransferable() {
        try {
            new PasteDiagramElementAction(null, EMPTY_DIAGRAM);
            fail("clipboardContent" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <P>
     * Tests the constructor. The diagram is null so IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorWithNullDiagram() {
        try {
            new PasteDiagramElementAction(SIMPLE_ELLIPSE_ELEMENT, null);
            fail("diagram" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <P>
     * Tests the constructor. The transferable passed in the constructor isn't an instance of CopiedElement.
     * So IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorNotCopiedElement() {
        try {
            new PasteDiagramElementAction(new StringSelection("string"), EMPTY_DIAGRAM);
            fail("StringSelection isn't CopiedElement");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <P>
     * Tests the constructor. The DiagramElement to be pasted and the given diagram should be set to the new instance.
     * </P>
     *
     * @throws NoSuchFieldException if any field not found
     * @throws IllegalAccessException if the class or its nullary constructor is not accessible
     */
    public void testConstructor() throws NoSuchFieldException, IllegalAccessException {
        PasteDiagramElementAction createdAction = new PasteDiagramElementAction(SIMPLE_ELLIPSE_ELEMENT, EMPTY_DIAGRAM);
        Diagram diagramInAction = (Diagram) reflectObjectField("diagram", createdAction);
        assertTrue("EMPTY_DIAGRAM should be set", diagramInAction == EMPTY_DIAGRAM);
        DiagramElement element = (DiagramElement) reflectObjectField("toBePasted", createdAction);
        assertTrue("SIMPLE_ELLIPSE is expected", element == SIMPLE_ELLIPSE);
    }

    /**
     * <P>
     * Tests the execute method. The ellipse should be pasted to the diagram.
     * </P>
     *
     * @throws ActionExecutionException if any error happened while pasting the diagram.
     */
    public void testExecute() throws ActionExecutionException {
        assertFalse("ellipse is not in the diagram before pasting", diagram.containsContained(SIMPLE_ELLIPSE));
        pasteAction.execute();
        assertTrue("ellipse should be pasted", diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the execute method. Error happened while pasting the element so ActionExecutionException is expected.
     * </P>
     *
     */
    public void testExecuteErrorCondition() {

        PasteDiagramElementAction errorAction = new PasteDiagramElementAction(
                SIMPLE_ELLIPSE_ELEMENT, new DiagramMock());

        try {
            errorAction.execute();
            fail("ActionExectionException is expected");
        } catch (ActionExecutionException e) {
            //success
        }
    }

    /**
     * <P>
     * Tests the undo method. The action isn't executed so CannotUndoException is expected.
     * </P>
     *
     */
    public void testUndoNotExecuted() {
        try {
            pasteAction.undo();
            fail("action is not executed");
        } catch (CannotUndoException e) {
            //success
        }
    }

    /**
     * <P>
     * Tests the undo method. Once the action is executed again the undo method can be invoked.
     * </P>
     *
     * @throws ActionExecutionException if any error happened while executing the action
     *
     */
    public void testUndoAfterExecuteAgain() throws ActionExecutionException {
        pasteAction.execute();
        pasteAction.undo();
        pasteAction.execute();
        assertTrue("ellipse is pasted", diagram.containsContained(SIMPLE_ELLIPSE));
        pasteAction.undo();
        assertFalse("ellipse is removed again", diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the undo method. The element is removed before undo the action.
     * NoSuchElementException is expected.
     * </P>
     *
     * @throws ActionExecutionException if any error happened while executing the action
     */
    public void testUndoButNoSuchElement() throws ActionExecutionException {
        pasteAction.execute();
        diagram.removeContained(SIMPLE_ELLIPSE);
        try {
            pasteAction.undo();
            fail("The diagram doesn't contain the element");
        } catch (NoSuchElementException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the undo method. The undo method should remove the element pasted.
     * </P>
     *
     * @throws ActionExecutionException if any RuntimeException happened while executing the action
     */
    public void testUndo() throws ActionExecutionException {
        pasteAction.execute();
        assertTrue("ellipse is pasted", diagram.containsContained(SIMPLE_ELLIPSE));
        pasteAction.undo();
        assertFalse("ellipse is removed", diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the redo method. The action isn't undone so CannotRedoException is expected.
     * </P>
     *
     */
    public void testRedoButNotUndone() {
        try {
            pasteAction.redo();
            fail("the action isn't undone");
        } catch (CannotRedoException e) {
            //success
        }
    }


    /**
     * <P>
     * Tests the redo method. The redo method should paste the element to the diagram again.
     * </P>
     *
     * @throws ActionExecutionException if any error happened while executing the action.
     */
    public void testRedo() throws ActionExecutionException {
        pasteAction.execute();
        pasteAction.undo();
        assertFalse("ellipse is removed", diagram.containsContained(SIMPLE_ELLIPSE));
        pasteAction.redo();
        assertTrue("ellipse is added again", diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the undo method. Undo method can be invoked again after redone.
     * </P>
     *
     * @throws ActionExecutionException if any error happened while executing the action.
     */
    public void testUndoAfterRedo() throws ActionExecutionException {
        pasteAction.execute();
        pasteAction.undo();
        pasteAction.redo();
        assertTrue("ellipse is added again", diagram.containsContained(SIMPLE_ELLIPSE));
        pasteAction.undo();
        assertFalse("ellipse is removed again", diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * It isn't supported now. UnsupportedOperationException is expected.
     * </P>
     *
     */
    public void testAddEdit() {
        PasteDiagramElementAction anEdit = new PasteDiagramElementAction(SIMPLE_ELLIPSE_ELEMENT, EMPTY_DIAGRAM);
        assertFalse("false is expected", pasteAction.addEdit(anEdit));
    }

    /**
     * <P>
     * It isn't supported now. UnsupportedOperationException is expected.
     * </P>
     *
     */
    public void testCanUndo() {
        try {
            pasteAction.canUndo();
            fail("is unsupported");
        } catch (UnsupportedOperationException e) {
            //success
        }
    }

    /**
     * <P>
     * It isn't supported now. UnsupportedOperationException is expected.
     * </P>
     *
     */
    public void testCanRedo() {
        try {
            pasteAction.canRedo();
            fail("is unsupported");
        } catch (UnsupportedOperationException e) {
            //success
        }
    }

    /**
     * <P>
     * It isn't supported now. UnsupportedOperationException is expected.
     * </P>
     *
     */
    public void testDie() {
        try {
            pasteAction.die();
            fail("is unsupported");
        } catch (UnsupportedOperationException e) {
            //success
        }
    }

    /**
     * <P>
     * Tests the getPresentationName method.
     * </P>
     *
     */
    public void testGetPresentationName() {
        String expectedName = "PasteDiagramElementAction";
        assertEquals("Presentation name is expected", expectedName, pasteAction.getPresentationName());
    }

    /**
     * <P>
     * Tests the getUndoPresentationName method.
     * </P>
     *
     */
    public void testGetUndoPresentationName() {
        String expectedName = "UndoPasteDiagramElementAction";
        assertEquals("Undo Presentation name is expected", expectedName, pasteAction.getUndoPresentationName());
    }

    /**
     * <P>
     * Tests the getRedoPresentationName method.
     * </P>
     *
     */
    public void testGetRedoPresentationName() {
        String expectedName = "RedoPasteDiagramElementAction";
        assertEquals("Redo Presentation name is expected", expectedName, pasteAction.getRedoPresentationName());
    }

    /**
     * <P>
     * Tests the isSignificant method. It's always significant.
     * </P>
     *
     */
    public void testIsSignificant() {
        assertTrue("It's Significant", pasteAction.isSignificant());
    }

    /**
     * <P>
     * Tests the replaceEdit method. False is epected.
     * </P>
     *
     */
    public void testReplaceEdit() {
        PasteDiagramElementAction anEdit = new PasteDiagramElementAction(SIMPLE_ELLIPSE_ELEMENT, EMPTY_DIAGRAM);
        assertFalse("false is expected", pasteAction.replaceEdit(anEdit));
    }

    /**
     * <P>
     * This is a mock class for Diagram. It will be used to mock error happened while executing the
     * action.
     * </P>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     *
     */
    class DiagramMock extends Diagram {
        /**
         * <P>
         * A mock of addContained method. This method just mocks the error happens while in addContained method.
         * </P>
         *
         * @param element the element to be added
         *
         * @throws IllegalArgumentException this method always throw this exception
         */
        public void addContained(DiagramElement element) {
            throw new IllegalStateException("just throw exception");
        }
    }

}
