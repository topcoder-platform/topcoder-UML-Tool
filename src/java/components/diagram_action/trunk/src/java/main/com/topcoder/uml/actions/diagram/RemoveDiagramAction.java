/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;

/**
 * <p>
 * This class is an abstract subclass of <code>UndoableAbstractAction</code>.
 * </p>
 *
 * <p>
 * This action will support removing a class diagram, a use case diagram, a sequence diagram or an activity diagram.
 * </p>
 *
 * <p>
 * This class will be extended by {@link RemoveClassDiagramAction}, {@link RemoveUseCaseDiagramAction},
 * {@link RemoveSequenceDiagramAction} and {@link RemoveActivityDiagramAction}.
 * </p>
 *
 * <p>
 * The <code>redoAction</code> method is called to redo the action, while the <code>undoAction</code> method is called
 * to undo the action and the <code>executeAction</code> method is called to execute the action.
 * </p>
 *
 * <p>
 * <b>Usage demo:</b>
 * </p>
 * <pre>
 *  // Taken RemoveClassDiagramAction as example
 *  Diagram classDiagram = new Diagram();
 *  classDiagram.setName("Class Diagram");
 *
 *  // Assume classDiagram has been added.
 *  RemoveDiagramAction action = new RemoveClassDiagramAction(classDiagram);
 *
 *  // If execute an action is triggered by the user of UML Model Tool, it will be executed after created.
 *  // Execute the action
 *  action.execute();
 *
 *  // If undo an action is triggered by the user of UML Model Tool, it will be undone
 *  action.undo();
 *
 *  // If redo an action is triggered by the user of UML Model Tool, it will be redone
 *  action.redo();
 *
 *  // If redo an action when it is already redone, it is invalid
 *  action.redo();
 *
 *  // The log should be:
 *  // Remove diagram Class Diagram
 *  // Undo Remove diagram Class Diagram
 *  // Redo Remove diagram Class Diagram
 *  // Can't Redo Remove diagram Class Diagram current state is UNDOABLE
 * </pre>
 *
 * <p>
 * <b>Thread Safety:</b>
 * This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public abstract class RemoveDiagramAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the diagram to be removed.
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
     * Constructor of the remove diagram action.
     * </p>
     *
     * <p>
     * If the name of diagram is null, a 'untitled' string will be used to represent its name.
     * </p>
     *
     * @param diagram the non null diagram to be removed
     *
     * @throws IllegalArgumentException if the diagram is null
     */
    protected RemoveDiagramAction(Diagram diagram) {
        super("Remove diagram " + Helper.checkAndGetDiagramName(diagram));
        this.diagram = diagram;
    }

    /**
     * <p>
     * Executes this remove diagram action.
     * </p>
     *
     * <p>
     * It will remove the diagram from the <code>UMLModelManager</code> instance.
     * </p>
     */
    public void executeAction() {
        Helper.removeDiagramFromUMLModelManager(diagram);
    }

    /**
     * <p>
     * Re-applies the remove diagram action.
     * </p>
     *
     * <p>
     * It will remove the diagram from the <code>UMLModelManager</code> instance.
     * </p>
     */
    public void redoAction() {
        Helper.removeDiagramFromUMLModelManager(diagram);
    }

    /**
     * <p>
     * Undoes the remove diagram action that was made.
     * </p>
     *
     * <p>
     * It will add the diagram to the <code>UMLModelManager</code> instance.
     * </p>
     */
    public void undoAction() {
        Helper.addDiagramToUMLModelManager(diagram);
    }
}
