/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class is a subclass of <code>UndoableAbstractAction</code>.
 * </p>
 *
 * <p>
 * This action will create an activity diagram. It will create an activity graph and add it the model, while it will
 * use <code>CreateActivityDiagramHelperAction</code> to create diagram which is owned by this activity graph.
 * </p>
 *
 * <p>
 * This class will be created by application directly. The <code>redoAction</code> method is called to redo the action,
 * while the <code>undoAction</code> method is called to undo the action and the <code>executeAction</code> method is
 * called to execute the action.
 * </p>
 *
 * <p>
 * <b>Usage demo:</b>
 * </p>
 * <pre>
 *  CreateActivityDiagramAction action = new CreateActivityDiagramAction(null, "New Activity Diagram");
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
public class CreateActivityDiagramAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the action used to create the diagram.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>redoAction</code>, <code>undoAction</code> and
     * <code>executeAction</code> method.
     * </p>
     */
    private final CreateActivityDiagramHelperAction helpAction;

    /**
     * <p>
     * Represents the activity graph related with the diagram.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference).
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>redoAction</code>, <code>undoAction</code> and
     * <code>executeAction</code> method.
     * </p>
     */
    private final ActivityGraph activityGraph;

    /**
     * <p>
     * Constructor of the create activity diagram action.
     * </p>
     *
     * <p>
     * It will create an <code>ActivityGraph</code>, and if the owner is null, set the context to a new use case
     * element added directly to the <code>Model</code>, otherwise set the context property of the
     * <code>ActivityGraph</code> to the owner, and set the top attribute of the <code>ActivityGraph</code> to an
     * empty <code>CompositeState</code>. At last a <code>CreateActivityDiagramHelpAction</code> instance will be
     * created to create the diagram.
     * </p>
     *
     * <p>
     * If the name is null, a 'untitled' string will be used to represent the name.
     * </p>
     *
     * <p>
     * An IllegalArgumentException will be thrown if the owner is not null and is not of ModelElement type.
     * </p>
     *
     * @param owner the possible null owner of the diagram
     * @param name the possible null, possible empty name of the diagram
     *
     * @throws IllegalArgumentException if the owner is not null and is not of ModelElement type.
     */
    public CreateActivityDiagramAction(Element owner, String name) {
        super("Create activity diagram " + Helper.validateName(name));
        // create an ActivityGraph
        activityGraph = new ActivityGraphImpl();
        ModelElement modelElementOwner = null;
        // set the owner to a new use case element added directly to the Model if the owner is null
        if (owner == null) {
            modelElementOwner = new UseCaseImpl();
            UMLModelManager.getInstance().getModel().addOwnedElement(modelElementOwner);
        } else {
            if (!(owner instanceof ModelElement)) {
                throw new IllegalArgumentException("The owner should be of ModelElement type.");
            }
            modelElementOwner = (ModelElement) owner;
        }
        // set the context to the owner
        activityGraph.setContext(modelElementOwner);
        // create an empty CompositeState and set the top attribute of the ActivityGraph to it
        activityGraph.setTop(new CompositeStateImpl());
        // create the helpAction
        helpAction = new CreateActivityDiagramHelperAction(activityGraph, name);
    }

    /**
     * <p>
     * Executes this create activity diagram action.
     * </p>
     *
     * <p>
     * It will add the ActivityDiagram and the ActivityGraph to the <code>UMLModelManager</code> instance.
     * </p>
     *
     * @throws ActionExecutionException if any exception prevents this method from completing successfully
     */
    protected void executeAction() throws ActionExecutionException {
        helpAction.execute();
        Helper.addActivityGraphToUMLModelManager(activityGraph);
    }

    /**
     * <p>
     * Undoes the create activity diagram action that was made.
     * </p>
     *
     * <p>
     * It will remove the ActivityDiagram and the ActivityGraph to the <code>UMLModelManager</code> instance.
     * </p>
     */
    protected void undoAction() {
        helpAction.undo();
        Helper.removeActivityGraphFromUMLModelManager(activityGraph);
    }

    /**
     * <p>
     * Re-applies the create activity diagram action.
     * </p>
     *
     * <p>
     * It will add the ActivityDiagram and the ActivityGraph to the <code>UMLModelManager</code> instance.
     * </p>
     */
    protected void redoAction() {
        helpAction.redo();
        Helper.addActivityGraphToUMLModelManager(activityGraph);
    }

    /*
     * BugFix: UML-9930
     */
    /**
     * <p>
     * Getter of diagram field.
     * </p>
     */
    public Diagram getDiagram() {
        return helpAction.getDiagram();
    }
}
