package com.topcoder.uml.actions.diagram.elements.accuracytests;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;
import com.topcoder.uml.actions.diagram.elements.DiagramElementDataFlavorManager;

public class DiagramElementDataFlavorManagerAccuracyTest extends TestCase {
    /**
     * Sample DiagramElementDataFlavorManager for testing.
     */
    private DiagramElementDataFlavorManager def;
    /**
     * Sample Graph_DataFlavor for testing.
     */
    private DataFlavor graphData = new DataFlavor(GraphNode.class, GraphNode.class.getName());
    /**
     * Sample Graph_EdgeFlavor for testing.
     */
    private DataFlavor edgeData = new DataFlavor(GraphEdge.class, GraphEdge.class.getName());
    /**
     * Set up the environment for testing.
     */
    protected void setUp() throws Exception {
        def = new DiagramElementDataFlavorManager();
    }

    /**
     * Test method for DiagramElementDataFlavorManager().
     */
    public void testDiagramElementDataFlavorManager() {
        def = new DiagramElementDataFlavorManager();
        assertTrue("Should be true.", def.isSuitableForDiagramElement(graphData));
        assertTrue("Should be true.", def.isSuitableForDiagramElement(edgeData));
    }
    /**
     * Test method for DiagramElementDataFlavorManager.isSuitableForDiagramElement(DataFlavor).
     */
    public void testIsSuitableForDiagramElementDataFlavor() {
        assertTrue("Should be true.", def.isSuitableForDiagramElement(new DataFlavor(GraphNode.class, GraphNode.class.getName())));
        assertTrue("Should be true.", def.isSuitableForDiagramElement(new DataFlavor(GraphEdge.class, GraphEdge.class.getName())));
    }

    /**
     * Test method for isSuitableForDiagramElement(Transferable).
     */
    public void testIsSuitableForDiagramElementTransferable() {
        DataFlavor[] df = {new DataFlavor(GraphNode.class, GraphNode.class.getName())};
        Transferable tb = new CopiedElement(new GraphNode(), df);
        assertTrue("Should be true.", def.isSuitableForDiagramElement(tb));
    }

    /**
     * Test method for getDataFlavor(DiagramElement).
     */
    public void testGetDataFlavor() {
        assertEquals("Should be equal.", graphData, def.getDataFlavor(new GraphNode()));
    }
}
