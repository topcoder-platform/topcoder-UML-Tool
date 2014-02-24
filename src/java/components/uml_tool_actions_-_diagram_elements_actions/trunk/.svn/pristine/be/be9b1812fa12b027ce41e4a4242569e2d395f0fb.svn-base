package com.topcoder.uml.actions.diagram.elements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.RemoveDiagramElementAction;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.CompoundUndoableAction;

@SuppressWarnings("unused")
public class RemoveDiagramElementActionAccuracyTest extends TestCase {
    /**
     * Sample RemoveDiagramElement for testing.
     */
    private RemoveDiagramElementAction rde;
    /**
     * Sample Diagram for testing.
     */
    private Diagram dg;
    /**
     * Sample DiagramElement for testing.
     */
    private DiagramElement de;
    /**
     * Set up the environment for testing.
     */
    protected void setUp() throws Exception {
        de = new GraphNode();
        dg = new Diagram();
        dg.addContained(de);
        rde = new RemoveDiagramElementAction(de, dg);
    }

    /**
     * Test method for RemoveDiagramElementAction(DiagramElement, Diagram).
     */
    public void testRemoveDiagramElementAction() {
        assertNotNull("Should not be null.", rde);
    }

    /**
     * Test method for execute().
     * @throws ActionExecutionException if error occurs.
     */
    public void testExecute() throws ActionExecutionException {
        assertTrue("Should be true.", dg.containsContained(de));
        rde.execute();
        assertFalse("Should be false.", dg.containsContained(de));
    }

    /**
     * Test method for undo().
     * @throws ActionExecutionException if error occurs.
     */
    public void testUndo() throws ActionExecutionException {
        rde.execute();
        assertFalse("Should be false.", dg.containsContained(de));

        rde.undo();
        assertTrue("Should be true.", dg.containsContained(de));
    }

    /**
     * Test method Redo.
     * @throws ActionExecutionException if error occurs.
     */
    public void testRedo() throws ActionExecutionException {
        rde.execute();
        rde.undo();
        rde.redo();
        assertFalse("Should be false.", dg.containsContained(de));
    }

    /**
     * Test method for addEdit(UndoableEdit).
     */
    public void testAddEdit() {
        assertFalse("Should be false.", rde.addEdit(null));
    }

    /**
     * Test method for canUndo().
     */
    public void testCanUndo() {
        try {
            rde.canUndo();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // ok.
        }
    }

    /**
     * Test method for canRedo().
     */
    public void testCanRedo() {
        try {
            rde.canUndo();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // ok.
        }
    }

    /**
     * Test method for die().
     */
    public void testDie() {
        try {
            rde.die();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // ok.
        }
    }

    /**
     * Test method for getPresentationName().
     */
    public void testGetPresentationName() {
        assertEquals("Should be equal.", "RemoveDiagramElementAction", rde.getPresentationName());
    }

    /**
     * Test method for getUndoPresentationName().
     */
    public void testGetUndoPresentationName() {
        assertEquals("Should be equal.", "UndoRemoveDiagramElementAction", rde.getUndoPresentationName());
    }

    /**
     * Test method for getRedoPresentationName().
     */
    public void testGetRedoPresentationName() {
        assertEquals("Should be equal.", "RedoRemoveDiagramElementAction", rde.getRedoPresentationName());
    }

    /**
     * Test method for isSignificant().
     */
    public void testIsSignificant() {
        assertTrue("Should be true.", rde.isSignificant());
    }

    /**
     * Test method for replaceEdit(UndoableEdit).
     */
    public void testReplaceEdit() {
        assertFalse("Should be false.", rde.replaceEdit(new CompoundUndoableAction("undo")));
    }

}
