/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ CreateActivityDiagramActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.actions.diagram.CreateActivityDiagramAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Collection;
import java.util.List;


/**
 * <p>
 * The <code>CreateActivityDiagramAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>CreateActivityDiagramAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class CreateActivityDiagramActionAccuracyTests extends TestCase {
    /**
    * <p>
    * Represents an instance of <code>CreateActivityDiagramAction</code> uses for accuracy tests.
    * </p>
    */
    private MockCreateActivityDiagramAction test = null;

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
     * Test suite of <code>CreateActivityDiagramActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>CreateActivityDiagramActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(CreateActivityDiagramActionAccuracyTests.class);
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
        test = new MockCreateActivityDiagramAction(element, "title");
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
     * Accuracy Test of the <code>CreateActivityDiagramAction(Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateActivityDiagramActionCtor_Basic()
        throws Exception {
        test = new MockCreateActivityDiagramAction(null, "title");
        // check for creating successful.
        assertNotNull("Create failed.", test);

        //  check the owend element.
        Collection<ModelElement> elements = manager.getModel().getOwnedElements();
        // check the number of the ModelElements.
        assertEquals("The collection should have 1 element.", 1, elements.size());
        // check the type of the ModelElement
        assertTrue("The ModelElement should be intance of UseCase.",
            elements.iterator().next() instanceof UseCase);

        test.executeAction();

        // check the activityGraph.
        List<ActivityGraph> activityGraphs = manager.getActivityGraphs();
        // check the number of the activityGraphs.
        assertEquals("The list should have 1 element.", 1, activityGraphs.size());

        ActivityGraph activityGraph = activityGraphs.get(0);
        // check the context of the activityGraph.
        assertTrue("The context of the activityGraph should be intance of UseCase.",
            activityGraph.getContext() instanceof UseCase);
        // check the top of the activityGraph.
        assertTrue("The top of the activityGraph should be intance of CompositeStateImpl.",
            activityGraph.getTop() instanceof CompositeStateImpl);
    }

    /**
     * <p>
     * Accuracy Test of the <code>CreateActivityDiagramAction(Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateActivityDiagramActionCtor_Basic2()
        throws Exception {
        // check for creating successful.
        assertNotNull("Create failed.", test);

        test.executeAction();

        // check the activityGraph.
        List<ActivityGraph> activityGraphs = manager.getActivityGraphs();
        // check the number of the activityGraphs.
        assertEquals("The list should have 1 element.", 1, activityGraphs.size());

        ActivityGraph activityGraph = activityGraphs.get(0);
        // check the context of the activityGraph.
        assertSame("The context of the activityGraph should be same.", element,
            activityGraph.getContext());

        // check the top of the activityGraph.
        assertTrue("The top of the activityGraph should be intance of CompositeStateImpl.",
            activityGraph.getTop() instanceof CompositeStateImpl);
    }

    /**
     * <p>
     * Accuracy Test of the <code>CreateActivityDiagramAction(Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateActivityDiagramActionCtor_Detail()
        throws Exception {
        test.executeAction();

        // get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());

        Diagram diagram = diagrams.get(0);

        // get the owner.
        SemanticModelBridge owner = diagram.getOwner();
        // check the type of the owner.
        assertTrue("The type of the owner should be intance of Uml1SemanticModelBridge.",
            owner instanceof Uml1SemanticModelBridge);

        // convert it to Uml1SemanticModelBridge.
        Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) owner;

        // get the element in modelBridge.
        Element getElement = modelBridge.getElement();

        // get the activityGraph.
        ActivityGraph activityGraph = manager.getActivityGraphs().get(0);
        // check the activityGraph and the getElement.
        assertSame("The two Element should be same.", activityGraph, getElement);
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
        test.executeAction();

        // get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());
        // check the number of the activityGraphs.
        assertEquals("The list should have 1 element.", 1,
            manager.getActivityGraphs().size());

        test.undoAction();
        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should be empty.", 0,
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
        test.executeAction();

        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should have 1 element.", 1,
            manager.getActivityGraphs().size());

        test.undoAction();
        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should be empty.", 0,
            manager.getActivityGraphs().size());

        test.redoAction();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1,
            manager.getDiagrams().size());
        // check the number of the activityGraphs.
        assertEquals("The list should have 1 element.", 1,
            manager.getActivityGraphs().size());
    }
}


/**
 * <p>
 * A inner class which extends the <code>CreateActivityDiagramAction</code> class, used for
 * accuracy test only.
 * Here it make the protected method visiable.
 * </p>
 */
class MockCreateActivityDiagramAction extends CreateActivityDiagramAction {
    /**
    * <p>
    * Creates an instance of <code>MockCreateActivityDiagramAction</code>.
    * </p>
    *
    * <p>
    * <strong>Note</strong>: It simply call <code>super</code> to make
    * the protected method visiable.
    * </p>
    *
    * @param owner the owner of the diagram.
    * @param name the name of the diagram.
    */
    public MockCreateActivityDiagramAction(Element owner, String name) {
        super(owner, name);
    }

    /**
     * <p>
     * Simply call <code>super</code> to make the protected method visiable.
     * </p>
     *
     * @throws ActionExecutionException if any exception prevents this method from
     * completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        super.executeAction();
    }

    /**
     * <p>
     * Simply call <code>super</code> to make the protected method visiable.
     * </p>
     */
    public void redoAction() {
        super.redoAction();
    }

    /**
     * <p>
     * Simply call <code>super</code> to make the protected method visiable.
     * </p>
     */
    public void undoAction() {
        super.undoAction();
    }
}
