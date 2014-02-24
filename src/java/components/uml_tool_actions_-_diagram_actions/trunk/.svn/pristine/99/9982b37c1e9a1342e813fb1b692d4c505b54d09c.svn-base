/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;

/**
 * <p>
 * This class is a subclass of <code>UndoableAbstractAction</code>.
 * </p>
 *
 * <p>
 * This action will change the title of a diagram.
 * </p>
 *
 * <p>
 * This class will be created by application directly. The <code>redoAction</code> method is called to redo the action,
 * while the <code>undoAction</code> method is called to undo the action and the <code>executeAction</code> method is
 * called to execute the action.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b>
 * This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public class ChangeDiagramTitleAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the diagram to change the title.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>redoAction</code>, <code>undoAction</code> and
     * <code>executeAction</code> methods.
     * </p>
     */
    private final Diagram diagram;

    /**
     * <p>
     * Represents the new title will change to. This variable is set in the constructor, is immutable (the reference).
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>redoAction</code> and <code>executeAction</code> methods.
     * </p>
     */
    private final String newName;

    /**
     * <p>
     * Represents the old title before change. This variable is set in the constructor, is immutable (the reference).
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>undoAction</code> method.
     * </p>
     */
    private final String oldName;

    /**
     * <p>
     * Constructor of the change diagram action.
     * </p>
     *
     * <p>
     * If the name of diagram is null, a 'untitled' string will be used to represent its name.
     * </p>
     *
     * <p>
     * An IllegalArgumentException will be thrown if the diagram is null.
     * </p>
     *
     * @param diagram the non null diagram to change title
     * @param name the new name(title) of the diagram
     *
     * @throws IllegalArgumentException if the diagram is null
     */
    public ChangeDiagramTitleAction(Diagram diagram, String name) {
        super("Change Diagram Title " + Helper.checkAndGetDiagramName(diagram));
        this.diagram = diagram;
        newName = name;
        oldName = diagram.getName();
    }

    /**
     * <p>
     * Executes this change diagram title action.
     * </p>
     *
     * <p>
     * Change the title to the new name.
     * </p>
     */
    protected void executeAction() {
        diagram.setName(newName);
    }

    /**
     * <p>
     * Re-applies the change diagram title action.
     * </p>
     *
     * <p>
     * Change the title to the new name.
     * </p>
     */
    protected void redoAction() {
        diagram.setName(newName);
    }

    /**
     * <p>
     * Undoes the change diagram title action that was made.
     * </p>
     *
     * <p>
     * Restore the title to the old name.
     * </p>
     */
    protected void undoAction() {
        diagram.setName(oldName);
    }
}
