/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <P>
 * Tests for RemoveDiagramElementAction.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 *
 */
public class TestRemoveDiagramElementAction extends
        DiagramElementsActionsTestCase {

    /**
     * <P>
     * The Diagram object used in the tests.
     * </P>
     *
     */
    private Diagram diagram;

    /**
     * <P>
     * The RemoveDiagramElementAction object used in the tests.
     * </P>
     *
     */
    private RemoveDiagramElementAction removeElementAction;

    /**
     * <P>
     * Sets up for tests. Create the diagram and the removeElementAction.
     * </P>
     *
     */
    public void setUp() {
        diagram = new Diagram();
        removeElementAction = new RemoveDiagramElementAction(SIMPLE_ELLIPSE,
                diagram);
    }

    /**
     * <P>
     * Tests the constructor with null as the element argument. So
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorWithNullAsElement() {
        try {
            new RemoveDiagramElementAction(null, EMPTY_DIAGRAM);
            fail("element" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the constructor with null as the diagram argument. So
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorWithNullAsDiagram() {
        try {
            new RemoveDiagramElementAction(SIMPLE_ELLIPSE, null);
            fail("diagram" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the constructor. The diagram and the element should be set to the
     * object created by the constructor.
     * </P>
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    public void testConstructor() throws NoSuchFieldException,
            IllegalAccessException {
        RemoveDiagramElementAction removeAction = new RemoveDiagramElementAction(
                SIMPLE_ELLIPSE, EMPTY_DIAGRAM);
        assertTrue("element should be set", SIMPLE_ELLIPSE
                == reflectObjectField("element", removeAction));
        assertTrue("diagram should be set", EMPTY_DIAGRAM
                == reflectObjectField("diagram", removeAction));
    }

    /**
     * <P>
     * Tests the execute method. The element to be removed isn't in the diagram.
     * So ActionExecutionException is expected.
     * </P>
     *
     */
    public void testExecuteWithNoSuchElement() {
        try {
            removeElementAction.execute();
            fail("ActionExecutionException is expected");
        } catch (ActionExecutionException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the execute method. This test show the error condition of execute
     * method. The removeContained method of DiagramMock will always throw a
     * runtime exception. So an ActionExecutionException is expected in this
     * test.
     * </P>
     *
     */
    public void testExecuteErrorCondition() {
        try {
            RemoveDiagramElementAction removeAction = new RemoveDiagramElementAction(
                    SIMPLE_ELLIPSE, new DiagramMock());
            removeAction.execute();
            fail("ActionExecutionException should be thrown");
        } catch (ActionExecutionException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the execute method. The element should be removed after execution.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any RuntimeException happened while removing the element
     */
    public void testExecuteSuccess() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.execute();
        assertFalse(diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the undo method. The action wasn't executed. So CannotUndoException
     * is expected.
     * </P>
     *
     */
    public void testUndoNotExecuted() {
        try {
            removeElementAction.undo();
            fail("not executed. CannotUndoException is expected");
        } catch (CannotUndoException e) {
            // success
        }
    }


    /**
     * <P>
     * Tests the undo method. The removed element should be added back to the
     * Diagram.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any RuntimeException happened while removing the element
     */
    public void testUndo() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.execute();
        assertFalse("ellipse should be deleted", diagram
                .containsContained(SIMPLE_ELLIPSE));
        removeElementAction.undo();
        assertTrue("ellipse should be back again", diagram
                .containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the undo method. As the designer's explain of undo the undo can be
     * invoked multiple times without redo.
     * </P>
     *
     * @throws ActionExecutionException if any RuntimeException happened while executing the action
     */
    public void testUndoMultipleTimes() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.execute();
        removeElementAction.undo();
        removeElementAction.undo();
        assertTrue("the diagram should contain the element", diagram.containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the undo method. The undo method can be invoked again after the
     * execution.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any RuntimeException happened while execute the action
     */
    public void testUndoAfterExecuteAgain() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.execute();
        removeElementAction.undo();
        removeElementAction.execute();
        assertFalse("the element should be removed", diagram
                .containsContained(SIMPLE_ELLIPSE));
        removeElementAction.undo();
        assertTrue("the element should be added back", diagram
                .containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the redo method. The action isn't undone. So CannotRedoException is
     * expected.
     * </P>
     *
     */
    public void testRedoNotUndone() {
        try {
            removeElementAction.redo();
            fail("the action isn't undone. CannotRedoException is expected");
        } catch (CannotRedoException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the redo method. The element is removed from the diagram so CannotRedoException
     * is expected.
     * </P>
     *
     * @throws ActionExecutionException if any RuntimeException happened while executing the action
     */
    public void testRedoButNoSuchElement() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.execute();
        removeElementAction.undo();
        diagram.removeContained(SIMPLE_ELLIPSE);
        try {
            removeElementAction.redo();
            fail("The element is removed");
        } catch (CannotRedoException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the redo method. The element should be removed again after redone.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any RuntimeException happened while removing the element
     */
    public void testRedo() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.execute();
        removeElementAction.undo();
        assertTrue("ellipse should in the diagram", diagram
                .containsContained(SIMPLE_ELLIPSE));
        removeElementAction.redo();
        assertFalse("ellipse should be removed again", diagram
                .containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the redo method after added the element to the diagram again.
     * As the designer's explain of redo the action can be redone now.
     * </P>
     * @throws ActionExecutionException if any RuntimeException happened
     */
    public void testRedoAfterAddedElement() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.execute();
        removeElementAction.undo();
        removeElementAction.redo();
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.redo();
        assertFalse("the ellipse should be removed", diagram.containsContained(SIMPLE_ELLIPSE));
    }


    /**
     * <P>
     * This test test the undo method after redone. The element should be added
     * back again.
     * </P>
     *
     * @throws ActionExecutionException
     *             if any RuntimeException happened while removing the element
     */
    public void testUndoAfterRedo() throws ActionExecutionException {
        diagram.addContained(SIMPLE_ELLIPSE);
        removeElementAction.execute();
        removeElementAction.undo();
        removeElementAction.redo();
        assertFalse("ellipse should be removed again", diagram
                .containsContained(SIMPLE_ELLIPSE));
        removeElementAction.undo();
        assertTrue("ellipse should be added back again", diagram
                .containsContained(SIMPLE_ELLIPSE));
    }

    /**
     * <P>
     * Tests the add edit method. This method should always return false.
     * </P>
     *
     */
    public void testAddEdit() {
        RemoveDiagramElementAction anEdit = new RemoveDiagramElementAction(SIMPLE_ELLIPSE, EMPTY_DIAGRAM);
        assertFalse("false is expected", removeElementAction.addEdit(anEdit));
    }

    /**
     * <P>
     * It isn't supported now. UnsupportedOperationException is expected.
     * </P>
     *
     */
    public void testCanUndo() {
        try {
            removeElementAction.canUndo();
            fail("is unsupported");
        } catch (UnsupportedOperationException e) {
            // success
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
            removeElementAction.canRedo();
            fail("is unsupported");
        } catch (UnsupportedOperationException e) {
            // success
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
            removeElementAction.die();
            fail("is unsupported");
        } catch (UnsupportedOperationException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the getPresentationName method. The presentation name is expected.
     * </P>
     *
     */
    public void testGetPresentationName() {
        String expectedName = "RemoveDiagramElementAction";
        assertEquals("Name is expected", expectedName, removeElementAction
                .getPresentationName());
    }

    /**
     * <P>
     * Tests the getUndoPresentationName method. The undo presentation name is
     * expected.
     * </P>
     *
     */
    public void testGetUndoPresentationName() {
        String expectedName = "UndoRemoveDiagramElementAction";
        assertEquals("Undo name is expected", expectedName, removeElementAction
                .getUndoPresentationName());
    }

    /**
     * <P>
     * Tests the getRedoPresentationName method. The redo presentation name is
     * expected.
     * </P>
     *
     */
    public void testGetRedoPresentationName() {
        String expectedName = "RedoRemoveDiagramElementAction";
        assertEquals("Redo name is expected", expectedName, removeElementAction
                .getRedoPresentationName());
    }

    /**
     * <P>
     * Tests the isSignificant method. It's always significant.
     * </P>
     *
     */
    public void testIsSignificant() {
        assertTrue("It's Significant", removeElementAction.isSignificant());
    }

    /**
     * <P>
     * Tests the replaceEdit method. Remove action always refuse this.
     * </P>
     *
     */
    public void testReplaceEdit() {
        RemoveDiagramElementAction anotherRemoveAction = new RemoveDiagramElementAction(
                SIMPLE_ELLIPSE, EMPTY_DIAGRAM);
        assertFalse("replaceEdit always return false", removeElementAction
                .replaceEdit(anotherRemoveAction));
    }

    /**
     * <P>
     * A mock class for Diagram. The removeContained method is overrided. It
     * will always throw a RuntimException. This class is used to mock the error
     * condition.
     * </P>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    static class DiagramMock extends Diagram {

        /**
         * <P>
         * A mock for removeContained method. This method will only throw
         * RuntimeException.
         * </P>
         *
         * @param element
         *            the element to be removed
         * @return true if removed the element successfully, false otherwise
         */
        public boolean removeContained(DiagramElement element) {
            throw new IllegalStateException("Just throw Exception");
        }
    }
}
