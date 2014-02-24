package com.topcoder.uml.actions.diagram.elements.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.CutDiagramElementAction;

public class CutDiagramElementActionAccuracyTest extends TestCase {
    /**
     * Sample CutDiagramElementAction for testing.
     */
    private CutDiagramElementAction cea;
    /**
     * Sample Element for testing.
     */
    private DiagramElement element;
    /**
     * Sample Diagram for testing.
     */
    private Diagram diagram;
    /**
     * Sample Clipboard for testing.
     */
    private Clipboard clipboard;
    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        element = new GraphNode();
        diagram = new Diagram();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Test method for CutDiagramElementAction(DiagramElement, Diagram, Clipboard) with null clipboard.
     */
    public void testCutDiagramElementAction1() {
        cea = new CutDiagramElementAction(element, diagram, null);
        assertNotNull("Should not be null.", cea);
    }
    /**
     * Test method for CutDiagramElementAction(DiagramElement, Diagram, Clipboard).
     */
    public void testCutDiagramElementAction2() {
        cea = new CutDiagramElementAction(element, diagram, clipboard);
        assertNotNull("Should not be null.", cea);
    }
}
