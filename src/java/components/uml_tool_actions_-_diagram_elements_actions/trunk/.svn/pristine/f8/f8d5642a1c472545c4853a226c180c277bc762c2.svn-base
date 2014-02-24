/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.stresstests;

import java.awt.datatransfer.DataFlavor;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;
import com.topcoder.uml.actions.diagram.elements.CopyDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.CutDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.PasteDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.RemoveDiagramElementAction;

import junit.framework.TestCase;

/**
 * <p>
 * Stress tests for <code>{@link CopyDiagramElementAction}</code> class.
 * </p>
 * @author
 */
public class DiagramElementActionStressTests extends TestCase {

    /**
     * <p>
     * Represents the loop size for stress testing.
     * </p>
     */
    private static final int TIMES = 10000;

    /**
     * <p>
     * Stress test for <code>{@link CopyDiagramElementAction}</code> class.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCopyDiagramElementActionStress() throws Exception {
        CopyDiagramElementAction copyDiagramElementAction = new CopyDiagramElementAction(new StressDiagramElement());

        long start = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            copyDiagramElementAction.execute();
        }

        long end = System.currentTimeMillis();

        System.out.println("Run CopyDiagramElementAction#execute " + TIMES + " times takes " + (end - start)
            + " millseconds.");
    }

    /**
     * <p>
     * Stress test for <code>{@link CutDiagramElementAction}</code> class.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCutDiagramElementActionStress() throws Exception {
        DiagramElement diagramElement = new StressDiagramElement();
        Diagram diagram = new Diagram();
        diagram.addContained(diagramElement);

        CutDiagramElementAction cutDiagramElementAction = new CutDiagramElementAction(diagramElement, diagram, null);

        cutDiagramElementAction.execute();
        long start = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            cutDiagramElementAction.undo();
            cutDiagramElementAction.redo();
        }

        long end = System.currentTimeMillis();

        System.out.println("Run CutDiagramElementAction#execute, undo, redo " + TIMES + " times takes " + (end - start)
            + " millseconds.");
    }

    /**
     * <p>
     * Stress test for <code>{@link PasteDiagramElementAction}</code> class.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testPasteDiagramElementActionStress() throws Exception {
        PasteDiagramElementAction pasteDiagramElementAction = new PasteDiagramElementAction(new CopiedElement(
            new StressDiagramElement(), new DataFlavor[] {new DataFlavor(StressDiagramElement.class,
                StressDiagramElement.class.getName())}), new Diagram());

        pasteDiagramElementAction.execute();
        long start = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            pasteDiagramElementAction.undo();
            pasteDiagramElementAction.redo();
        }

        long end = System.currentTimeMillis();

        System.out.println("Run PasteDiagramElementAction#execute, undo, redo " + TIMES + " times takes "
            + (end - start) + " millseconds.");
    }

    /**
     * <p>
     * Stress test for <code>{@link RemoveDiagramElementAction}</code> class.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRemoveDiagramElementActionStress() throws Exception {
        DiagramElement diagramElement = new StressDiagramElement();
        Diagram diagram = new Diagram();

        diagram.addContained(diagramElement);
        RemoveDiagramElementAction removeDiagramElementAction = new RemoveDiagramElementAction(diagramElement, diagram);

        removeDiagramElementAction.execute();
        long start = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            removeDiagramElementAction.undo();
            removeDiagramElementAction.redo();
        }

        long end = System.currentTimeMillis();

        System.out.println("Run RemoveDiagramElementAction#execute, undo, redo " + TIMES + " times takes "
            + (end - start) + " millseconds.");
    }

}
