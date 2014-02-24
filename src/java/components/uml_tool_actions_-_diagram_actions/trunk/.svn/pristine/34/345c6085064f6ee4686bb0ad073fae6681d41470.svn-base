/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.uml.actions.diagram.CreateActivityDiagramAction;
import com.topcoder.uml.model.core.Element;


/**
 * <p>This is a simple wrapper of the <code>CreateDiagramAction</code> abstract class. It is
 * used for stress test here.</p>
 *
 * @author zmg
 * @version 1.0
 */
final class CreateActivityDiagramActionWrapper extends CreateActivityDiagramAction {
/**
     * <p>
     * Creates an instance of <code>CreateActivityDiagramActionWrapper</code>.
     * </p>
     *
     * @param owner the possible null owner of the diagram
     * @param name the possible null, possible empty name of the diagram
     * @throws IllegalArgumentException if owner is not null and not of type ModelElement
     */
    public CreateActivityDiagramActionWrapper(Element owner, String name) {
        super(owner, name);
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
