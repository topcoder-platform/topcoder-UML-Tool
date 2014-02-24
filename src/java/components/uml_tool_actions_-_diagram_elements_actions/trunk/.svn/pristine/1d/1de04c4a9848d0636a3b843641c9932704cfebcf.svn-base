package com.topcoder.uml.actions.diagram.elements.accuracytests;

import java.awt.datatransfer.DataFlavor;
import java.lang.ref.Reference;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;
/**
 * Accuracy test for CopiedElement.
 * @author radium
 * @version 1.0
 *
 */
public class CopiedElementAccuracyTest extends TestCase {
    /**
     * Sample CopiedElement for testing.
     */
    private CopiedElement ce;
    /**
     * Sample DiagramElement for testing.
     */
    private DiagramElement de;
    /**
     * Sample graphNodeFlavor for testing.
     */
    private DataFlavor graphNodeFlavor = new DataFlavor(GraphNode.class, GraphNode.class
        .getName());
    /**
     * Sample referenceFlavor for testing.
     */
    private DataFlavor referenceFlavor = new DataFlavor(Reference.class, Reference.class
        .getName());
    /**
     * Sample DataFlavor for testing.
     */
    private DataFlavor[] df = {graphNodeFlavor, referenceFlavor};
    /**
     * Setup the environment.
     */
    protected void setUp() throws Exception {
        de = new GraphNode();
        ce = new CopiedElement(de, df);
    }

    /**
     * Test method for CopiedElement(DiagramElement, DataFlavor[]).
     */
    public void testCopiedElement() {
        ce = new CopiedElement(de, df);
        assertEquals("Should be equal.", de, ce.getTransferData(df[0]));
        assertEquals("Should be equal.", de, ce.getTransferData(df[1]));
        assertEquals("Should be equal.", df.length, ce.getTransferDataFlavors().length);
        assertEquals("Should be equal.", df[0], ce.getTransferDataFlavors()[0]);
    }

    /**
     * Test method for getTransferData(DataFlavor) with null return.
     */
    public void testGetTransferDataNull() {
        assertNull("Should be null.", ce.getTransferData(new DataFlavor()));
    }
    /**
     * Test method for getTransferData(DataFlavor) with normal return.
     */
    public void testGetTransferDataNormal() {
        assertEquals("Should be equal.", de, ce.getTransferData(df[0]));
    }

    /**
     * Test method for getTransferDataFlavors().
     */
    public void testGetTransferDataFlavors() {
        assertEquals("Should be equal.", df.length, ce.getTransferDataFlavors().length);
        assertEquals("Should be equal.", df[0], ce.getTransferDataFlavors()[0]);
    }

    /**
     * Test method for isDataFlavorSupported(DataFlavor).
     */
    public void testIsDataFlavorSupported() {
        DataFlavor[] df = {graphNodeFlavor, referenceFlavor};
        ce = new CopiedElement(de, df);

        assertFalse("Should be false.", ce.isDataFlavorSupported(new DataFlavor()));
        assertTrue("Should be true.", ce.isDataFlavorSupported(graphNodeFlavor));
        assertTrue("Should be true.", ce.isDataFlavorSupported(referenceFlavor));
    }
}
