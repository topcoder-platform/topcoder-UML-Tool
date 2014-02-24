/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;

/**
 * <p>
 * This class is an abstract subclass of <code>UndoableAbstractAction</code>.
 * </p>
 *
 * <p>
 * This action will support creating a class diagram, a use case diagram, a sequence diagram or an activity diagram.
 * </p>
 *
 * <p>This class will be extended by {@link CreateClassDiagramAction}, {@link CreateUseCaseDiagramAction},
 * {@link CreateSequenceDiagramAction} and <code>CreateActivityDiagramHelperAction</code>.
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
 *  // Taken CreateClassDiagramAction as example
 *  CreateDiagramAction action = new CreateClassDiagramAction(null, "New Class Diagram");
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
 *  // Create Class diagram New Class Diagram
 *  // Undo Create Class diagram New Class Diagram
 *  // Redo Create Class diagram New Class Diagram
 *  // Can't Redo Create Class diagram New Class Diagram. Current state is UNDOABLE.
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
public abstract class CreateDiagramAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the diagram to be added.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable.
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>redoAction</code> <code>undoAction</code> and
     * <code>executeAction</code> methods.
     * </p>
     */
    private final Diagram diagram;

    /**
     * <p>
     * Constructor of the add diagram action.
     * </p>
     *
     * <p>
     * It will create the diagram and set the typeInfo property of the Diagram to type and set the owner property of
     * the Diagram to the owner. If owner is null, the root Model of <code>UMLModelManager</code> will be the owner.
     * It also set the diagram name to the name, set the viewport,size and position of the diagrams to (0.0,0.0) and
     * set the zoom attribute of the diagrams to 1.0. At last It will apply initial formatting for the diagram with
     * the project language and <code>ProjectConfigurationManager</code> from the <code>UMLModelManager</code>.
     * </p>
     *
     * <p>
     * If the name is null, a 'untitled' string will be used to represent the name.
     * </p>
     *
     * <p>
     * An IllegalArgumentException will be thrown if the type is null or empty.
     * </p>
     *
     * <p>
     * An IllegalStateException will be thrown if the diagram can't be created or can't be formatted.
     * </p>
     *
     * @param type the non null, non empty type of the diagram
     * @param owner the possible null owner of the diagram
     * @param name the possible null, possible empty name of the diagram
     *
     * @throws IllegalArgumentException If the type is null or empty
     * @throws IllegalStateException if the diagram can't be created or can't be formatted
     */
    protected CreateDiagramAction(String type, Element owner, String name) {
        super("Create " + validateType(type) + " diagram " + Helper.validateName(name));
        // create a new diagram
        diagram = new Diagram();
        /*
         * BugFix: UML-9507
         */
//        // set the diagram type (the typeInfo property of the Diagram) to type
//        Property property = new Property();
//        property.setKey("typeInfo");
//        property.setValue(type);
//        diagram.addProperty(property);
        // set the diagram type, using a simple semantic model element
        SimpleSemanticModelElement simpleElement = new SimpleSemanticModelElement();
        simpleElement.setTypeInfo(type);
        diagram.setSemanticModel(simpleElement);

        UMLModelManager manager = UMLModelManager.getInstance();
        // If owner is null, the root Model(get by UMLModelManager) will be the owner.
        if (owner == null) {
            owner = manager.getModel();
        }
        // set the owner property of the Diagram to the owner.
        Uml1SemanticModelBridge modelBridge  = new Uml1SemanticModelBridge();
        modelBridge.setElement(owner);
        diagram.setOwner(modelBridge);
        // set the diagram name (the name attribute of the Diagram) to the name
        diagram.setName(name);
        // set the viewport, size and position of the diagrams to (0.0,0.0). The X and Y coordinate of the Point is 0.0
        // by default and the width and height of the Dimension is 0.0 by default
        diagram.setViewport(new Point());
        diagram.setSize(new Dimension());
        diagram.setPosition(new Point());
        // set the zoom attribute of the diagrams to "1.0";
        diagram.setZoom(1.0);
        // apply initial formatting for the diagram with the project language and ProjectConfigurationManager
        String projectLanguage = manager.getProjectLanguage();
        // Note that an IllegalStateException will be thrown or the ProjectLanguage is null(it cannot be empty in
        // UMLModelManager).
        if (projectLanguage == null) {
            throw new IllegalStateException("The Language of the Project should not be null.");
        }
        try {
            // Note that in UMLModelManager an IllegalStateException will be thrown if the projectConfigurationManager
            // was not set yet
            manager.getProjectConfigurationManager().applyInitialFormatting(projectLanguage, diagram);
        } catch (ProjectConfigurationException e) {
            throw new IllegalStateException(
                    "Cannot apply initial formatting to the diagram according to the language.");
        }
    }

    /**
     * <p>
     * Executes this create diagram action.
     * </p>
     *
     * <p>
     * It will add the diagram to the <code>UMLModelManager</code> instance.
     * </p>
     */
    protected void executeAction() {
        Helper.addDiagramToUMLModelManager(diagram);
    }

    /**
     * <p>
     * Undo the create diagram action that was made.
     * </p>
     *
     * <p>
     * It will remove the diagram to the <code>UMLModelManager</code> instance.
     * </p>
     */
    protected void undoAction() {
        Helper.removeDiagramFromUMLModelManager(diagram);
    }

    /**
     * <p>
     * Re-applies create diagram action.
     * </p>
     *
     * <p>
     * It will add the diagram to the <code>UMLModelManager</code> instance.
     * </p>
     */
    protected void redoAction() {
        Helper.addDiagramToUMLModelManager(diagram);
    }

    /**
     * <p>
     * Checks whether the type string is null or empty and return it.
     * </p>
     *
     * <p>
     * An IllegalArgumentException will be thrown if the type is null or empty.
     * </p>
     *
     * @param type the type string to validate
     *
     * @return the original type string
     *
     * @throws IllegalArgumentException If the type is null or empty.
     */
    private static String validateType(String type) {
        Helper.checkString(type, "Type of Diagram to be created");
        return type;
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
        return diagram;
    }
}

