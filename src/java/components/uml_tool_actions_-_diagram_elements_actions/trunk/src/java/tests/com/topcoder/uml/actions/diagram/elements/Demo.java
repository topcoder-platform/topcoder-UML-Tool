/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;

/**
 * <P>
 * The demos for this component.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 *
 */
public class Demo extends TestCase {

    /**
     * <P>
     * The Diagram for the demos.
     * </P>
     */
    private Diagram diagram;

    /**
     * <P>
     * The DiagramElement used in the demos.
     * </P>
     *
     */
    private Ellipse ellipse;

    /**
     * <P>
     * The Clipboard used in the demos.
     * </P>
     *
     */
    private Clipboard clipboard;

    /**
     * <P>
     * The DataFlavor of the DiagramElemet.
     * </P>
     *
     */
    private DataFlavor flavor;

    /**
     * <P>
     * Set up for demos. Just initialize objects used in demos.
     * </P>
     *
     */
    protected void setUp() {
        diagram = new Diagram();
        ellipse = new Ellipse();
        clipboard = new Clipboard("clipboard");
        flavor = new DataFlavor(Ellipse.class, "ellipse flavor");
    }

    /**
     * <P>
     * Demo for CopyDiagramElementAction and PasteDiagramElementAction.
     * </P>
     *
     */
    public void testDemo1() {
        /*
         * Create a CopyDiagramElementAction by constructor. The clipboard can
         * be null then the system clipboard will used.
         */
        CopyDiagramElementAction copyAction = new CopyDiagramElementAction(
                ellipse, null);
        /*
         * Just give diagram will do the same thing. A system clipboard will be
         * used.
         */
        copyAction = new CopyDiagramElementAction(ellipse);
        // You can also specify the clipboard.
        copyAction = new CopyDiagramElementAction(ellipse, clipboard);
        // Execute the action by invoking execute.
        try {
            copyAction.execute();
        } catch (ActionExecutionException e) {
            // the execute method may throw ActionExecutionException
        }
        // After copy the DiagramElement you can paste it to a diagram.
        // First fetch the data from the clipboard.
        Transferable data = clipboard.getContents(this);
        // Check if the transferabe data is suitable for DiagramElement by
        // DiagramElementDataFlavorManager
        DiagramElementDataFlavorManager manager = new DiagramElementDataFlavorManager();
        // Check by invoking isSuitableForDiagramElement method.
        if (manager.isSuitableForDiagramElement(data)) {
            // Create a PasteDiagramElementAction by constructor.
            PasteDiagramElementAction pasteAction = new PasteDiagramElementAction(
                    data, diagram);
            // Execute the action by invoking execute.
            try {
                pasteAction.execute();
            } catch (ActionExecutionException e) {
                // The execution may throw ActionExecutionException too.
            }

            // To undo the paste action, just invoking undo
            pasteAction.undo();
            // To redo the paste action, just invoking redo
            pasteAction.redo();
        }
    }

    /**
     * <P>
     * This demo shows the usage of RemoveDiagramElementAction.
     * </P>
     *
     */
    public void testDemo2() {
        // The diagram should contains the element to be removed.
        // Otherwise executing a remove action will cause a
        // NoSuchElementException.
        diagram.addContained(ellipse);
        // Create a RemoveDiagramElementAction by constructor.
        RemoveDiagramElementAction removeAction = new RemoveDiagramElementAction(
                ellipse, diagram);
        // To remove the element from the diagram, just invoking the execute
        // method.
        try {
            removeAction.execute();
        } catch (ActionExecutionException e) {
            // This may throw ActionExecutionException if any error happened.
        }
        // To undo the removement invoking undo method.
        removeAction.undo();
        // To redo the removement invoking redo method.
        removeAction.redo();
    }

    /**
     * <P>
     * This demo shows the usage of CutDiagramElementAction.
     * </P>
     *
     */
    public void testDemo3() {
        diagram.addContained(ellipse);
        // Create a CutDiagramElementAction by constructor.
        // Like CopyDiagramElementAction, if you don't give the clipboard the
        // system clipboard will be used.
        CutDiagramElementAction cutAction = new CutDiagramElementAction(
                ellipse, diagram, null);
        // You also can specify the clipboard.
        cutAction = new CutDiagramElementAction(ellipse, diagram, clipboard);
        // To execute the action also invoke the execute method.
        try {
            cutAction.execute();
        } catch (ActionExecutionException e) {
            // Also ActionExecutionException would be thrown if any error
            // happened during the execution.
        }
        // To undo the action, invoke the undo method.
        cutAction.undo();
        // To redo the action, invoke the redo method.
        cutAction.redo();
    }
}
