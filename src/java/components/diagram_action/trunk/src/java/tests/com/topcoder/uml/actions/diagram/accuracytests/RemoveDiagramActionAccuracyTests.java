/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ RemoveDiagramActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.actions.diagram.RemoveDiagramAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * The <code>RemoveDiagramAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>RemoveDiagramAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class RemoveDiagramActionAccuracyTests extends TestCase {
    /**
    * <p>
    * Represents an instance of <code>RemoveDiagramAction</code> uses for accuracy tests.
    * </p>
    */
    private RemoveDiagramAction test = null;

    /**
     * <p>
     * Represents an instance of <code>Diagram</code> uses for accuracy tests.
     * </p>
     */
    private Diagram diagram = null;

    /**
     * <p>
     * Represents an instance of <code>UMLModelManager</code> uses for accuracy tests.
     * </p>
     */
    private UMLModelManager manager = null;

    /**
     * <p>
     * Test suite of <code>RemoveDiagramActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>RemoveDiagramActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(RemoveDiagramActionAccuracyTests.class);
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
        diagram = new Diagram();
        test = new MockRemoveDiagramAction(diagram);
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
        // clean the UMLModelManager for test.
        manager.clearActivityGraphs();
        manager.clearDiagrams();
    }

    /**
     * <p>
     * Accuracy Test of the <code>RemoveDiagramAction(Diagram)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testRemoveDiagramActionCtor_Basic() throws Exception {
        // check for creating successful.
        assertNotNull("Create failed.", test);

        //  get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have empty.", 0, diagrams.size());

        test.undoAction();
        // get all the diagrams.
        diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());

        Diagram getDiagram = diagrams.get(0);
        // check the diagram.
        assertSame("The diagram should besame.", diagram, getDiagram);
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
        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());

        test.executeAction();

        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());

        test.undoAction();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1,
            manager.getDiagrams().size());
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
        test.executeAction();

        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());

        test.undoAction();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1,
            manager.getDiagrams().size());

        test.redoAction();
        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());
    }
}


/**
 * <p>
 * A inner class which extends the <code>RemoveDiagramAction</code> class, used for
 * accuracy test only.
 * Here it make the protected method visiable.
 * </p>
 */
class MockRemoveDiagramAction extends RemoveDiagramAction {
    /**
       * <p>
       * Creates an instance of <code>MockRemoveDiagramAction</code>.
       * </p>
       *
       * <p>
       * <strong>Note</strong>: It simply call <code>super</code> to make
       * the protected method visiable.
       * </p>
       *
       * @param diagram the diagram to be removed.
    *
    * @throws IllegalArgumentException if the diagram is null
       */
    public MockRemoveDiagramAction(Diagram diagram) {
        super(diagram);
    }
}
