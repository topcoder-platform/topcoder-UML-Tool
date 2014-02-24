package com.topcoder.uml.actions.diagram.elements.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.CopyDiagramElementAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * Test class for CopyDiagramElementAction
 *
 * @author radium
 * @version 1.0
 */
public class CopyDiagramElementActionAccuracyTest extends TestCase {
    /**
     * Sample CopyDiagramElementAction For testing.
     */
    private CopyDiagramElementAction cdea;

    /**
     * Sample DiagramElement for testing.
     */
    private DiagramElement de;

    /**
     * Sample Clipboard for testing.
     */
    private Clipboard cb;
    /**
     * Set up the environment for testing.
     */
    protected void setUp() throws Exception {
        de = new GraphNode();
        cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cdea = new CopyDiagramElementAction(de, null);
    }

    /**
     * Test method for CopyDiagramElementAction(DiagramElement, Clipboard) with
     * null clipboard.
     * @throws NoSuchFieldException
     * @throws Exception if error occurs.
     */
    public void testCopyDiagramElementActionDiagramElementClipboardNullClipboard() throws Exception, NoSuchFieldException {
        cdea = new CopyDiagramElementAction(de, cb);
        assertFalse("should be false.", cdea.getCurrentlyOwnsClipboard());
        assertNotNull("Should not be null.", cdea);
    }

    /**
     * Test method for CopyDiagramElementAction(DiagramElement, Clipboard) with
     * null clipboard.
     */
    public void testCopyDiagramElementActionDiagramElementClipboard() {
        cdea = new CopyDiagramElementAction(de, null);
        assertFalse("Should be false.", cdea.getCurrentlyOwnsClipboard());
        assertNotNull("Should not be null.", cdea);
    }

    /**
     * Test method for CopyDiagramElementAction(DiagramElement).
     */
    public void testCopyDiagramElementActionDiagramElement() {
        cdea = new CopyDiagramElementAction(de);
        assertFalse("Should be false.", cdea.getCurrentlyOwnsClipboard());
        assertNotNull("Should not be null.", cdea);
    }

    /**
     * Test method for execute().
     * @throws ActionExecutionException if error occurs.
     */
    public void testExecute() throws ActionExecutionException {
        cdea.execute();
        assertTrue("Should be true.", cdea.getCurrentlyOwnsClipboard());
    }

    /**
     * Test method for lostOwnership(Clipboard,
     * Transferable).
     * @throws ActionExecutionException if error occurs.
     */
    public void testLostOwnership() throws ActionExecutionException {
        cdea.execute();

        cdea.lostOwnership(cb, new Transferable() {
            public Object getTransferData(DataFlavor flavor)
                throws UnsupportedFlavorException, IOException {
                return null;
            }
            public DataFlavor[] getTransferDataFlavors() {
                return null;
            }
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return false;
            }
        });

        assertFalse("Should be false.", cdea.getCurrentlyOwnsClipboard());
    }
}
