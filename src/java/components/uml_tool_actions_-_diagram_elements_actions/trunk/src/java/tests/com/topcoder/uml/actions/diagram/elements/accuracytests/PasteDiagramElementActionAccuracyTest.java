package com.topcoder.uml.actions.diagram.elements.accuracytests;

import java.awt.datatransfer.DataFlavor;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;
import com.topcoder.uml.actions.diagram.elements.PasteDiagramElementAction;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.CompoundUndoableAction;

public class PasteDiagramElementActionAccuracyTest extends TestCase {
    /**
     * Sample PasteDiagramElementAction for testing.
     */
    private PasteDiagramElementAction pde;
    /**
     * Sample DiagramElement for testing.
     */
    private DiagramElement de;
    /**
     * Sample CopiedElement for testing.
     */
    private CopiedElement ce;
    /**
     * Sample DataFlavors for testing.
     */
    private DataFlavor[] df = {new DataFlavor(GraphNode.class, GraphNode.class.getName())};
    /**
     * Sample Diagram for testing.
     */
    private Diagram dg;
    /**
     * Set up the environment for testing.
     */
    protected void setUp() throws Exception {
        de = new GraphNode();
        ce = new CopiedElement(de, df);
        dg = new Diagram();
        dg.addContained(de);
        pde = new PasteDiagramElementAction(ce, dg);
    }

    /**
     * Test method for PasteDiagramElementAction(Transferable, Diagram).
     */
    public void testPasteDiagramElementAction() {
        pde = new PasteDiagramElementAction(ce, dg);
        assertNotNull("Should not be null.", pde);
    }
    /**
     * Test method for undo().
     * @throws ActionExecutionException if error occurs.
     */
    public void testUndo() throws ActionExecutionException {
        pde.execute();
        pde.undo();
        assertTrue("Should be true.", dg.containsContained(de));
    }

    /**
     * Test method for redo()
     * @throws ActionExecutionException if error occurs.
     */
    public void testRedo() throws ActionExecutionException {
        pde.execute();
        pde.undo();
        pde.redo();
        assertTrue("Should be true.", dg.containsContained(de));
    }

    /**
     * Test method for addEdit(UndoableEdit).
     */
    public void testAddEdit() {
        assertFalse("Should be false.", pde.addEdit(null));
    }

    /**
     * Test method for canUndo().
     */
    public void testCanUndo() {
        try {
            pde.canRedo();
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
            pde.canRedo();
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
            pde.die();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // ok.
        }
    }

    /**
     * Test method for getPresentationName().
     */
    public void testGetPresentationName() {
        assertEquals("Should be equal.", "PasteDiagramElementAction", pde.getPresentationName());
    }

    /**
     * Test method for getUndoPresentationName().
     */
    public void testGetUndoPresentationName() {
        assertEquals("Should be equal.", "UndoPasteDiagramElementAction", pde.getUndoPresentationName());
    }

    /**
     * Test method for getRedoPresentationName().
     */
    public void testGetRedoPresentationName() {
        assertEquals("Should be equal.", "RedoPasteDiagramElementAction", pde.getRedoPresentationName());
    }

    /**
     * Test method for isSignificant().
     */
    public void testIsSignificant() {
        assertTrue("Should be true.", pde.isSignificant());
    }

    /**
     * Test method for replaceEdit(UndoableEdit).
     */
    public void testReplaceEdit() {
        assertFalse("Should be false.", pde.replaceEdit(new CompoundUndoableAction("undo")));
    }

}
