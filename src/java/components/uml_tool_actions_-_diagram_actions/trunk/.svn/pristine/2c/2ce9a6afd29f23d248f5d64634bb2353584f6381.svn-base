/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ RemoveActivityDiagramActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.actions.diagram.CreateActivityDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveActivityDiagramAction;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * The <code>RemoveActivityDiagramAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>RemoveActivityDiagramAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class RemoveActivityDiagramActionAccuracyTests extends TestCase {
    /**
    * <p>
    * Represents an instance of <code>RemoveActivityDiagramAction</code> uses for accuracy tests.
    * </p>
    */
    private RemoveActivityDiagramAction test = null;

    /**
     * <p>
     * Represents an instance of <code>Element</code> uses for accuracy tests.
     * </p>
     */
    private Element element = null;

    /**
     * <p>
     * Represents an instance of <code>UMLModelManager</code> uses for accuracy tests.
     * </p>
     */
    private UMLModelManager manager = null;

    /**
     * <p>
     * Test suite of <code>RemoveActivityDiagramActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>RemoveActivityDiagramActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(RemoveActivityDiagramActionAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        manager = UMLModelManager.getInstance();
        TestHelper.configUMLModelManager();
        TestHelper.loadLogFile();
        element = new MethodImpl();

        CreateActivityDiagramAction action = new CreateActivityDiagramAction(element,
                "title");
        action.execute();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // clean the ConfigManager.
        TestHelper.clearConfig();
        //  clean the UMLModelManager for test.
        manager.clearActivityGraphs();
        manager.clearDiagrams();
    }

    /**
     * <p>
     * Accuracy Test of the <code>RemoveActivityDiagramAction(Diagram)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testRemoveActivityDiagramActionCtor_Basic()
        throws Exception {
        //  get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());

        Diagram diagram = diagrams.get(0);
        // check the number of the activityGraphs.
        assertEquals("The list should have 1 element.", 1,
            manager.getActivityGraphs().size());

        // creat a RemoveActivityDiagramAction
        test = new RemoveActivityDiagramAction(diagram);
        // check for creating successful.
        assertNotNull("Create failed.", test);

        test.executeAction();
        //  check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should be empty.", 0,
            manager.getActivityGraphs().size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>executeAction()</code> and <code>undoAction()</code>
     * methods.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAction_Operation_Basic() throws Exception {
        // get the diagram from the manager.
        Diagram diagram = manager.getDiagrams().get(0);
        // creat a RemoveActivityDiagramAction
        test = new RemoveActivityDiagramAction(diagram);
        // check for creating successful.
        assertNotNull("Create failed.", test);

        test.executeAction();
        //  check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should be empty.", 0,
            manager.getActivityGraphs().size());

        test.undoAction();
        // check the number of the diagrams.
        assertEquals("The list should be empty.", 1,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should be empty.", 1,
            manager.getActivityGraphs().size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>executeAction()</code>, <code>redoAction()</code>
     * and <code>undoAction()</code> methods.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAction_Operation_Detail() throws Exception {
        // get the diagram from the manager.
        Diagram diagram = manager.getDiagrams().get(0);
        // creat a RemoveActivityDiagramAction
        test = new RemoveActivityDiagramAction(diagram);
        // check for creating successful.
        assertNotNull("Create failed.", test);

        test.executeAction();
        //  check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should be empty.", 0,
            manager.getActivityGraphs().size());

        test.undoAction();
        // check the number of the diagrams.
        assertEquals("The list should be empty.", 1,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should be empty.", 1,
            manager.getActivityGraphs().size());

        test.redoAction();
        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should be empty.", 0,
            manager.getActivityGraphs().size());
    }
}
