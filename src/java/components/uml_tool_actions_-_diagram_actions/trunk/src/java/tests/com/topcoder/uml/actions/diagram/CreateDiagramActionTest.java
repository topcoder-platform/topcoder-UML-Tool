/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl;


/**
 * <p>
 * Unit tests for {@link CreateDiagramAction}. It tests the constructor and <code>executeAction</code>,
 * <code>undoAction</code>, <code>redoAction</code> methods.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CreateDiagramActionTest extends BaseTestCase {

    /**
     * <p>
     * String representing the type of the Diagram.
     * </p>
     */
    private static final String TYPE = "type";

    /**
     * <p>
     * String representing the name of the Diagram.
     * </p>
     */
    private static final String NAME = "name";

    /**
     * <p>
     * CreateDiagramAction instance used for testing.
     * </p>
     */
    private CreateDiagramAction action;

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
        return new TestSuite(CreateDiagramActionTest.class);
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
        owner = new EnumerationLiteralImpl();
        action = new MockCreateDiagramAction(TYPE, owner, NAME);
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
     * Tests constructor for 'CreateDiagramAction(String, Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that CreateDiagramAction(String, Element, String) is correct and the instance should not be null.
     * </p>
     */
    public void testCreateDiagramAction() {
        assertNotNull("The CreateDiagramAction instance should not be null.", action);
        action.executeAction();
        assertEquals("The presentation name is incorrect.",
                "Create " + TYPE + " diagram " + NAME, action.getPresentationName());
    }

    /**
     * <p>
     * Tests constructor for 'CreateDiagramAction(String, Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the name is null and verifies that CreateDiagramAction(String, Element, String) is
     * correct and the instance should not be null.
     * </p>
     */
    public void testCreateDiagramActionWithNullName() {
        MockCreateDiagramAction mockAction = new MockCreateDiagramAction(TYPE, owner, null);
        assertNotNull("The CreateDiagramAction instance should not be null.", mockAction);
        assertEquals("The presentation name is incorrect.",
                "Create " + TYPE + " diagram untitled",  mockAction.getPresentationName());
    }

    /**
     * <p>
     * Tests constructor for 'CreateDiagramAction(String, Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the name is empty and verifies that CreateDiagramAction(String, Element, String) is
     * correct and the instance should not be null.
     * </p>
     */
    public void testCreateDiagramActionWithEmptyName() {
        assertNotNull("The CreateDiagramAction instance should not be null.",
                new MockCreateDiagramAction(TYPE, owner, "  "));
    }

    /**
     * <p>
     * Tests constructor for 'CreateDiagramAction(String, Element, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the type is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateDiagramActionWithNullType() {
        try {
            new MockCreateDiagramAction(null, owner, NAME);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor for 'CreateDiagramAction(String, Element, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the type is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateDiagramActionWithEmptyType() {
        try {
            new MockCreateDiagramAction("  ", owner, NAME);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor for 'CreateDiagramAction(String, Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the owner is null and CreateDiagramAction(String, Element, String) is correct.
     * </p>
     */
    public void testCreateDiagramActionWithNullOwner() {
        MockCreateDiagramAction mockAction = new MockCreateDiagramAction(TYPE, null, NAME);
        mockAction.executeAction();
        // check the diagram created.
        Diagram diagram = UML_MODEL_MANAGER.getDiagrams().get(0);
        assertNotNull("The diagram should not be null.", diagram);
        // check the root Model(get by UMLModelManager)is the owner of the diagram
        Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) diagram.getOwner();
        assertNotNull("The Uml1SemanticModelBridge should not be null.", modelBridge);
        assertSame("The owner is incorrect.", UML_MODEL_MANAGER.getModel(), modelBridge.getElement());
    }

    /**
     * <p>
     * Tests constructor for 'CreateDiagramAction(String, Element, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the project language is null and expects IllegalStateException.
     * </p>
     */
    public void testCreateDiagramActionWithNullProjectLanguage() {
        UML_MODEL_MANAGER.setProjectLanguage(null);
        try {
            new MockCreateDiagramAction(TYPE, owner, NAME);
            fail("IllegalStateException is expected.");
        } catch (IllegalStateException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'undoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify undoAction() is correct. A newly created Diagram has been removed from the UMLModelManager.
     * </p>
     */
    public void testUndoAction() {
        action.executeAction();
        action.undoAction();
        // check the diagram created.
        assertTrue("The diagram should be removed from the UMLModelManager.",
                UML_MODEL_MANAGER.getDiagrams().isEmpty());
    }

    /**
     * <p>
     * Tests method for 'redoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify redoAction() is correct. A newly created Diagram has been added to the UMLModelManager.
     * </p>
     */
    public void testRedoAction() {
        action.redoAction();
        // check the diagram created.
        validateDiagram();
    }

    /**
     * <p>
     * Tests method for 'executeAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify executeAction() is correct. A newly created Diagram has been added to the UMLModelManager.
     * </p>
     */
    public void testExecuteAction() {
        action.executeAction();
        // check the diagram created.
        validateDiagram();
    }

    /**
     * <p>
     * Validate the Diagram newly created.
     * </p>
     */
    private void validateDiagram() {
        // check the diagram created.
        Diagram diagram = UML_MODEL_MANAGER.getDiagrams().get(0);
        assertNotNull("The diagram should not be null.", diagram);
        // check the typeInfo property
        /*
         * BugFix: UML-9507
         */
//        Property property = diagram.getProperties().iterator().next();
//        assertNotNull("The Property should not be null.", property);
//        assertEquals("The type is incorrect.", "typeInfo", property.getKey());
//        assertEquals("The type is incorrect.", TYPE, property.getValue());
        SimpleSemanticModelElement semanticModel = (SimpleSemanticModelElement) diagram.getSemanticModel();
        assertEquals("The type is incorrect.", TYPE, semanticModel.getTypeInfo());
        // check the owner
        Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) diagram.getOwner();
        assertNotNull("The Uml1SemanticModelBridge should not be null.", modelBridge);
        assertSame("The owner is incorrect.", owner, modelBridge.getElement());
        // check the diagram name
        assertEquals("The name of the diagram is incorrect.", NAME, diagram.getName());
        // check the viewport, size and position of the diagram, their x,y coordinate or width and height should be 0.0
        Point viewPort = diagram.getViewport();
        assertEquals("The X coordinate of the viewport is incorrect", 0, Double.compare(viewPort.getX(), 0.0));
        assertEquals("The Y coordinate of the viewport is incorrect", 0, Double.compare(viewPort.getY(), 0.0));
        Point position = diagram.getPosition();
        assertEquals("The X coordinate of the position is incorrect", 0, Double.compare(position.getX(), 0.0));
        assertEquals("The Y coordinate of the position is incorrect", 0, Double.compare(position.getY(), 0.0));
        Dimension size = diagram.getSize();
        assertEquals("The width of the size is incorrect", 0, Double.compare(size.getWidth(), 0.0));
        assertEquals("The height of the size is incorrect", 0, Double.compare(size.getHeight(), 0.0));
        // check the zoom
        assertEquals("The zoomLevel is incorrect.", 0, Double.compare(diagram.getZoom(), 1.0));
    }
}
