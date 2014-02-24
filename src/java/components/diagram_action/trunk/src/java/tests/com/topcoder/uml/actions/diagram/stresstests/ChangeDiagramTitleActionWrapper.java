/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.actions.diagram.ChangeDiagramTitleAction;


/**
 * <p>This is a simple wrapper of the <code>ChangeDiagramTitleAction</code> abstract class. It
 * is used for stress test here.</p>
 *
 * @author zmg
 * @version 1.0
 */
final class ChangeDiagramTitleActionWrapper extends ChangeDiagramTitleAction {
/**
     * <p>
     * Creates an instance of <code>ChangeDiagramTitleActionWrapper</code>.
     * </p>
     *
     * @param diagram the non null diagram to change title.
     * @param name the new name(title) of the diagram.
     * @throws IllegalArgumentException if the diagram is null.
     */
    public ChangeDiagramTitleActionWrapper(Diagram diagram, String name) {
        super(diagram, name);
    }

    /**
     * <p>Executes this create diagram action.</p>
     */
    public void executeAction() {
        try {
            super.executeAction();
        } catch (Exception e) {
            // do nothing here.
        }
    }

    /**
     * <p>Undo the create diagram action that was made.</p>
     */
    public void undoAction() {
        try {
            super.undoAction();
        } catch (Exception e) {
            // do nothing here.
        }
    }

    /**
     * <p>Re-apply create diagram action.</p>
     */
    public void redoAction() {
        try {
            super.redoAction();
        } catch (Exception e) {
            // do nothing here.
        }
    }
}
