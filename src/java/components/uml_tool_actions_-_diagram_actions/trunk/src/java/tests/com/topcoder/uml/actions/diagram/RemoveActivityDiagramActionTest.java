/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;


/**
 * <p>
 * Unit tests for {@link RemoveActivityDiagramAction}. It tests the constructor and <code>executeAction</code>,
 * <code>undoAction</code>, <code>redoAction</code> methods.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveActivityDiagramActionTest extends BaseTestCase {
    /**
     * <p>
     * RemoveActivityDiagramAction instance used for testing.
     * </p>
     */
    private RemoveActivityDiagramAction action;

    /**
     * <p>
     * Diagram instance used for testing.
     * </p>
     */
    private Diagram diagram;

    /**
     * <p>
     * ActivityGraph instance used for testing.
     * </p>
     */
    private ActivityGraph activityGraph = new ActivityGraphImpl();

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(RemoveActivityDiagramActionTest.class);
    }

    /**
     * <p>
     * Sets up environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void setUp() throws Exception {
        super.setUp();
        diagram = new Diagram();
        diagram.setName("Name");
        Uml1SemanticModelBridge uml1SemanticModelBridge = new Uml1SemanticModelBridge();
        uml1SemanticModelBridge.setElement(activityGraph);
        diagram.setOwner(uml1SemanticModelBridge);
        action = new RemoveActivityDiagramAction(diagram);
        UML_MODEL_MANAGER.addDiagram(diagram);
        UML_MODEL_MANAGER.addActivityGraph(activityGraph);
    }

    /**
     * <p>
     * Tears down environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void tearDown() throws Exception {
        super.tearDown();
        diagram = null;
        action = null;
    }

    /**
     * <p>
     * Tests constructor for 'RemoveActivityDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that RemoveActivityDiagramAction(Diagram) is correct and the instance should not be null.
     * </p>
     */
    public void testRemoveActivityDiagramAction() {
        assertNotNull("The RemoveActivityDiagramAction instance should not be null.", action);
        assertEquals("The presentation name is incorrect.",
                "Remove diagram " + diagram.getName(), action.getPresentationName());
    }

    /**
     * <p>
     * Test constructor for 'RemoveActivityDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that RemoveActivityDiagramAction is a subclass of RemoveDiagramAction.
     * </p>
     */
    public void testRemoveActivityDiagramActionForInheritance() {
        assertNotNull("The RemoveActivityDiagramAction should be a subclass of RemoveDiagramAction",
                action instanceof RemoveDiagramAction);
    }

    /**
     * <p>
     * Test constructor for 'RemoveActivityDiagramAction(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the Diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveActivityDiagramActionWithNullDiagram() {
        try {
            new RemoveActivityDiagramAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'RemoveActivityDiagramAction(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the owner of the Diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveActivityDiagramActionWithNullOwnerOfDiagram() {
        try {
            new RemoveActivityDiagramAction(new Diagram());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'RemoveActivityDiagramAction(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the owner of the Diagram is not null and not of Uml1SemanticModelBridge type and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveActivityDiagramActionWithNotNullInvalidOwnerOfDiagram() {
        Diagram newDiagram = new Diagram();
        newDiagram.setOwner(new SimpleSemanticModelElement());
        try {
            new RemoveActivityDiagramAction(newDiagram);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'RemoveActivityDiagramAction(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the owner of the Diagram holds a null element expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveActivityDiagramActionWithNullElementOfOwnerOfDiagram() {
        Diagram newDiagram = new Diagram();
        newDiagram.setOwner(new Uml1SemanticModelBridge());
        try {
            new RemoveActivityDiagramAction(newDiagram);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'RemoveActivityDiagramAction(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the owner of the Diagram holds a invalid element expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveActivityDiagramActionWithInvalidElementOfOwnerOfDiagram() {
        Diagram newDiagram = new Diagram();
        Uml1SemanticModelBridge uml1SemanticModelBridge = new Uml1SemanticModelBridge();
        uml1SemanticModelBridge.setElement(new AssociationEndImpl());
        newDiagram.setOwner(uml1SemanticModelBridge);
        try {
            new RemoveActivityDiagramAction(newDiagram);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'executeAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify executeAction() will remove the activity graph diagram from the UMLModelManager instance.
     * </p>
     */
    public void testExecuteAction() {
        action.executeAction();
        // check whether the diagram is removed
        assertFalse("The diagram should be removed.", UML_MODEL_MANAGER.containsDiagram(diagram));
        // check whether the activityGraph is removed.
        assertFalse("The activityGraph should be removed.", UML_MODEL_MANAGER.containsActivityGraph(activityGraph));
    }

    /**
     * <p>
     * Test method for 'redoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify redoAction() remove the activity graph diagram from the UMLModelManager instance.
     * </p>
     */
    public void testRedoAction() {
        action.redoAction();
        // check whether the diagram is removed
        assertFalse("The diagram should be removed.", UML_MODEL_MANAGER.containsDiagram(diagram));
        // check whether the activityGraph is removed.
        assertFalse("The activityGraph should be removed.", UML_MODEL_MANAGER.containsActivityGraph(activityGraph));
    }

    /**
     * <p>
     * Test method for 'undoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify undoAction() will add the activity graph diagram to the UMLModelManager instance.
     * </p>
     */
    public void testUndoAction() {
        action.executeAction();
        action.undoAction();
        // check whether the diagram is added again
        assertTrue("The diagram should be added again.", UML_MODEL_MANAGER.containsDiagram(diagram));
        // check whether the activityGraph is added again.
        assertTrue("The activityGraph should be added again.", UML_MODEL_MANAGER.containsActivityGraph(activityGraph));
    }
}
