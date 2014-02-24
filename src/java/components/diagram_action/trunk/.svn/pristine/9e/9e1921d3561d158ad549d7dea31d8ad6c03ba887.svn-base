/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Unit tests of the {@link Helper} class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperTest extends TestCase {
    /**
     * <p>
     * UMLModelManager instance used for testing.
     * </p>
     */
    private final UMLModelManager umlModelManager = UMLModelManager.getInstance();

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(HelperTest.class);
    }

    /**
     * <p>
     * Tear Down environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    protected void tearDown() throws Exception {
        umlModelManager.clearActivityGraphs();
        umlModelManager.clearDiagrams();
    }

    /**
     * <p>
     * Tests method for 'checkNotNull(Object, String)' for accuracy.
     * </p>
     *
     * <p>
     * It verifies checkNotNull(Object, String) is correct.
     * </p>
     */
    public void testCheckNotNull() {
        Helper.checkNotNull(new Object(), "test");
    }

    /**
     * <p>
     * Tests method for 'checkNotNull(Object, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the object is null and verifies an IllegalArgumentException will be thrown.
     * </p>
     */
    public void testCheckNotNullWithNull() {
        try {
            Helper.checkNotNull(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'checkString(String, String)' for accuracy.
     * </p>
     */
    public void testCheckString() {
        // good
        Helper.checkString("Not Null", "test");
    }

    /**
     * <p>
     * Tests method for 'checkString(String, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the String to check is null and verifies an IllegalArgumentException will be thrown.
     * </p>
     */
    public void testCheckStringWithNullString() {
        try {
            Helper.checkString(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'checkString(String, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the String to check is empty and verifies an IllegalArgumentException will be thrown.
     * </p>
     */
    public void testCheckStringWithEmptyString() {
        try {
            Helper.checkString("   ", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'checkAndGetDiagramName(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify the checkAndGetDiagramName(Diagram) is correct.
     * </p>
     */
    public void testCheckAndGetDiagramName() {
        Diagram diagram = new Diagram();
        diagram.setName("Not Null");
        assertEquals("The name is incorrect.", diagram.getName(), Helper.checkAndGetDiagramName(diagram));
    }


    /**
     * <p>
     * Tests method for 'checkAndGetDiagramName(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that Diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckAndGetDiagramNameWithNullDiagram() {
        try {
            Helper.checkAndGetDiagramName(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'addDiagramToUMLModelManager(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify the addDiagramToUMLModelManager(Diagram) is correct.
     * </p>
     */
    public void testAddDiagramToUMLModelManager() {
        Diagram diagram = new Diagram();
        Helper.addDiagramToUMLModelManager(diagram);
        assertTrue("The diagram should exist in the UMLModelManager", umlModelManager.containsDiagram(diagram));
    }

    /**
     * <p>
     * Tests method for 'removeDiagramFromUMLModelManager(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify the removeDiagramFromUMLModelManager(Diagram) is correct.
     * </p>
     */
    public void testRemoveDiagramFromUMLModelManager() {
        Diagram diagram = new Diagram();
        Helper.addDiagramToUMLModelManager(diagram);
        Helper.removeDiagramFromUMLModelManager(diagram);
        assertFalse("The diagram should exist in the UMLModelManager", umlModelManager.containsDiagram(diagram));
    }

    /**
     * <p>
     * Tests method for 'addActivityGraphToUMLModelManager(ActivityGraph)' for accuracy.
     * </p>
     *
     * <p>
     * Verify the addActivityGraphToUMLModelManager(ActivityGraph) is correct.
     * </p>
     */
    public void testAddActivityGraphToUMLModelManager() {
        ActivityGraph activityGraph = new ActivityGraphImpl();
        Helper.addActivityGraphToUMLModelManager(activityGraph);
        assertTrue("The diagram should exist in the UMLModelManager",
                umlModelManager.containsActivityGraph(activityGraph));
    }

    /**
     * <p>
     * Tests method for 'removeActivityGraphFromUMLModelManager(ActivityGraph)' for accuracy.
     * </p>
     *
     * <p>
     * Verify the removeActivityGraphFromUMLModelManager(ActivityGraph) is correct.
     * </p>
     */
    public void testRemoveActivityGraphFromUMLModelManager() {
        ActivityGraph activityGraph = new ActivityGraphImpl();
        Helper.addActivityGraphToUMLModelManager(activityGraph);
        Helper.removeActivityGraphFromUMLModelManager(activityGraph);
        assertFalse("The diagram should exist in the UMLModelManager",
                umlModelManager.containsActivityGraph(activityGraph));
    }

    /**
     * <p>
     * Tests method for 'validateName(String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify the validateName(String) is correct.
     * </p>
     */
    public void testValidateName() {
        assertEquals("The name is incorrect.", "Name", Helper.validateName("Name"));
    }

    /**
     * <p>
     * Tests method for 'validateName(String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify the validateName(String) is correct.
     * </p>
     */
    public void testValidateNameWithNullName() {
        assertEquals("The name is incorrect.", "untitled", Helper.validateName(null));
    }
}