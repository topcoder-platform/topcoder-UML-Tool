/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends BaseTestCase {

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * The Simple Demo of <b>Create Create/Remove Diagram Actions</b>.
     * </p>
     *
     * <p>
     * This Demo demonstrates how to create Create/Remove Diagram Actions.
     * </p>
     */
    public void testSimpleDemo() {
        // Assume all the Diagrams is valid and added to the UMLModelManager instance
        // If create/remove action is triggered by the user of UML Model Tool, the action will be created to be handled
        // Create a ChangeEntityNameAction, which will create and add a new class diagram named "New Class Diagram"
        UndoableAction action = new CreateClassDiagramAction(null, "New Class Diagram");

        // Create a CreateUseCaseDiagramAction, which will create and add a new use case diagram named
        // "New Use Case Diagram"
        action = new CreateUseCaseDiagramAction(null, "New Use Case Diagram");

        // Create a CreateSequenceDiagramAction, which will create and add a new sequence diagram named
        // "New Sequence Diagram"
        action = new CreateSequenceDiagramAction(null, "New Sequence Diagram");

        // Create a CreateActivityDiagramAction, which will create and add a new activity diagram named
        // "New Activity Diagram"
        action = new CreateActivityDiagramAction(null, "New Activity Diagram");

        // Create a RemoveClassDiagramAction, which will remove the class diagram classDiagram
        Diagram classDiagram = new Diagram();
        action = new RemoveClassDiagramAction(classDiagram);

        // Create a RemoveUseCaseDiagramAction, which will remove the use case diagram useCaseDiagram
        Diagram useCaseDiagram = new Diagram();
        action = new RemoveUseCaseDiagramAction(useCaseDiagram);

        // Create a RemoveSequenceDiagramAction, which will remove the sequence diagram sequenceDiagram
        Diagram sequenceDiagram = new Diagram();
        action = new RemoveSequenceDiagramAction(sequenceDiagram);

        Diagram activityDiagram = new Diagram();
        activityDiagram.setName("Name");
        Uml1SemanticModelBridge uml1SemanticModelBridge = new Uml1SemanticModelBridge();
        uml1SemanticModelBridge.setElement(new ActivityGraphImpl());
        activityDiagram.setOwner(uml1SemanticModelBridge);
        // Create a RemoveActivityDiagramAction, which will remove the activity diagram activityDiagram
        action = new RemoveActivityDiagramAction(activityDiagram);
        action.die();
    }

    /**
     * <p>
     * The Simple Demo of <b>Handle Action</b>.
     * </p>
     *
     * <p>
     * This Demo demonstrates how to handle <code>CreateClassDiagramAction</code>.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testSimpleDemoHandleAction() throws Exception {
        UndoableAction action = new CreateClassDiagramAction(null, "New Class Diagram");

        // If execute an action is triggered by the user of UML Model Tool, it will be executed after created.
        // Execute the action
        action.execute();

        // If undo an action is triggered by the user of UML Model Tool, it will be undone
        action.undo();

        // If redo an action is triggered by the user of UML Model Tool, it will be redone
        action.redo();

        // If redo an action when it is already redone, it is invalid
        action.redo();

        // The log is taken CreateClassDiagramAction as example
        // The log should be:
        // Create Class diagram New Class Diagram
        // Undo Create Class diagram New Class Diagram
        // Redo Create Class diagram New Class Diagram
        // Can't Redo Create Class diagram New Class Diagram. Current state is UNDOABLE.
    }

    /**
     * <p>
     * The Simple Demo of <b>Transient Actions</b>.
     * </p>
     *
     * <p>
     * This Demo demonstrates how to handle Transient Actions.
     * </p>
     */
    public void testSimpleDemoTransientActions() {
        Diagram diagram = new Diagram();
        // Create an adjust diagram zoom level action which will change zoom level of the diagram to 200%
        AdjustDiagramZoomLevelAction adjustDiagramZoomLevelAction = new AdjustDiagramZoomLevelAction(diagram, 2.0);
        // Execute the action
        adjustDiagramZoomLevelAction.execute();
        // check the zoom level
        assertEquals("The zoom level of the diagram is incorrect.", 0, Double.compare(2.0, diagram.getZoom()));

        // Create a new view port (10, 20)
        Point viewport = new Point();
        viewport.setX(10);
        viewport.setY(20);
        // Create a scroll diagram view action which will change view port of the diagram to (10,20)
        ScrollDiagramViewAction scrollDiagramViewAction = new ScrollDiagramViewAction(diagram, viewport);
        // Execute the action
        scrollDiagramViewAction.execute();
        // check the view port
        assertSame("The view port of the diagram is incorrect.", viewport, diagram.getViewport());
    }
}
