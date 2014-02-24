/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.model.usecases.UseCaseImpl;


/**
 * <p>
 * Unit tests for {@link CreateActivityDiagramAction}. It tests the constructor and <code>executeAction</code>,
 * <code>undoAction</code>, <code>redoAction</code> methods.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CreateActivityDiagramActionTest extends BaseTestCase {
    /**
     * <p>
     * String representing the name of the Diagram.
     * </p>
     */
    private static final String NAME = "name";

    /**
     * <p>
     * CreateActivityDiagramAction instance used for testing.
     * </p>
     */
    private CreateActivityDiagramAction action;

    /**
     * <p>
     * Element instance used for testing.
     * </p>
     */
    private Element owner;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(CreateActivityDiagramActionTest.class);
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
        owner = new TransitionImpl();
        action = new CreateActivityDiagramAction(owner, NAME);
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
        owner = null;
        action = null;
    }


    /**
     * <p>
     * Tests constructor for 'CreateActivityDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that CreateActivityDiagramAction(Element, String) is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testCreateActivityDiagramAction() throws Exception {
        assertNotNull("The CreateActivityDiagramAction instance should not be null.", action);
        action.executeAction();
        ActivityGraph activityGraph = UML_MODEL_MANAGER.getActivityGraphs().get(0);
        assertSame("The owner ModelElement should be the same", owner, activityGraph.getContext());
        State state = activityGraph.getTop();
        assertNotNull("The top state should not be null.", state);
        assertTrue("The top state should be of CompositeStateImpl type.", state instanceof CompositeStateImpl);
    }

    /**
     * <p>
     * Test constructor for 'CreateActivityDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the name is null and verify that CreateActivityDiagramAction(Element, String) is
     * correct.
     * </p>
     */
    public void testCreateActivityDiagramActionWithNullName() {
        CreateActivityDiagramAction activityAction = new CreateActivityDiagramAction(owner, null);
        assertNotNull("The CreateActivityDiagramAction instance should not be null.", activityAction);
        assertEquals("The presentation name is incorrect.",
                "Create activity diagram untitled",  activityAction.getPresentationName());
    }

    /**
     * <p>
     * Test constructor for 'CreateActivityDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that  the PresentationName is correct.
     * </p>
     */
    public void testCreateActivityDiagramActionForPresentationName() {
        assertEquals("The PresentationName is incorrect.",
                "Create activity diagram " + NAME, action.getPresentationName());
    }

    /**
     * <p>
     * Test constructor for 'CreateActivityDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the owner is null and verifies that CreateActivityDiagramAction(Element, String) is
     * correct. Set the context of the Activity Graph to a new use case element added directly to the Model.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCreateActivityDiagramActionWithNullOwner() throws Exception {
        action = new CreateActivityDiagramAction(null, NAME);
        action.executeAction();
        ModelElement element = UML_MODEL_MANAGER.getModel().getOwnedElements().iterator().next();
        assertTrue("The ModelElement should be of UseCaseImpl type.", element instanceof UseCaseImpl);
        ActivityGraph activityGraph = UML_MODEL_MANAGER.getActivityGraphs().get(0);
        assertSame("The ModelElement should be the same", element, activityGraph.getContext());
        State state = activityGraph.getTop();
        assertNotNull("The top state should not be null.", state);
        assertTrue("The top state should be of CompositeStateImpl type.", state instanceof CompositeStateImpl);
    }

    /**
     * <p>
     * Test constructor for 'CreateActivityDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the owner is not null and it is not of ModelElement type and expects
     *  IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCreateActivityDiagramActionWithNotNullNotOfModelElementOwner() throws Exception {
        try {
            new CreateActivityDiagramAction(new Element() { }, NAME);
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
     * Verify executeAction() will add the ActivityDiagram and the ActivityGraph to the UMLModelManager instance.
     * </p>
     * @throws Exception to Junit
     */
    public void testExecuteAction() throws Exception {
        action.executeAction();
        validateActivityDiagram();
    }

    /**
     * <p>
     * Test method for 'redoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify redoAction() will add again the ActivityDiagram and the ActivityGraph to the UMLModelManager instance.
     * </p>
     * @throws Exception to Junit
     */
    public void testRedoAction() throws Exception {
        action.executeAction();
        action.undoAction();
        action.redoAction();
        validateActivityDiagram();
    }


    /**
     * <p>
     * Test method for 'undoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify redoAction() will remove the ActivityDiagram and the ActivityGraph to the UMLModelManager instance.
     * </p>
     * @throws Exception to Junit
     */
    public void testUndoAction() throws Exception {
        action.executeAction();
        action.undoAction();
        assertTrue("The ActivityGraph list should be empty.", UML_MODEL_MANAGER.getActivityGraphs().isEmpty());
        assertTrue("The diagram list should be empty.", UML_MODEL_MANAGER.getDiagrams().isEmpty());
    }

    /**
     * <p>
     * Validate that the ActivityDiagram and the ActivityGraph are added to the UMLModelManager instance.
     * </p>
     */
    private void validateActivityDiagram() {
        ActivityGraph activityGraph = UML_MODEL_MANAGER.getActivityGraphs().get(0);
        assertNotNull("The ActivityGraph should not be null.", activityGraph);
        Diagram diagram = UML_MODEL_MANAGER.getDiagrams().get(0);
        assertNotNull("The diagram should not be null.", diagram);
        // check the owner
        Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) diagram.getOwner();
        assertNotNull("The Uml1SemanticModelBridge should not be null.", modelBridge);
        assertSame("The owner is incorrect.", activityGraph, modelBridge.getElement());
    }
}
