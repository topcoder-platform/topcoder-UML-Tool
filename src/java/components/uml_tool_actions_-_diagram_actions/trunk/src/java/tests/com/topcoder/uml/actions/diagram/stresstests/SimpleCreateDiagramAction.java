/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.uml.model.core.Element;


/**
 * <p>This is a simple mock class which extends the <code>CreateDiagramAction</code> abstract
 * class. It is used for stress test here.</p>
 *
 * @author zmg
 * @version 1.0
 */
final class SimpleCreateDiagramAction extends CreateDiagramAction {
/**
     * <p>
     * Creates an instance of <code>SimpleCreateDiagramAction</code>.
     * </p>
     *
     * @param type the type of the diagram
     * @param owner the possible null owner of the diagram
     * @param name the possible null, possible empty name of the diagram
     * @throws IllegalArgumentException if type is null or empty.
     * @throws IllegalStateException if error occurs while formatting the diagram
     */
    public SimpleCreateDiagramAction(String type, Element owner, String name) {
        super(type, owner, name);
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
