/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ CreateDiagramActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;


/**
 * <p>
 * The <code>CreateDiagramAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>CreateDiagramAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class CreateDiagramActionAccuracyTests extends TestCase {
    /**
    * <p>
    * Represents an instance of <code>CreateDiagramAction</code> uses for accuracy tests.
    * </p>
    */
    private MockCreateDiagramAction test = null;

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
     * Test suite of <code>CreateDiagramActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>CreateDiagramActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(CreateDiagramActionAccuracyTests.class);
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
        test = new MockCreateDiagramAction("class", element, "title");
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
     * Accuracy Test of the <code>CreateDiagramAction(String, Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateDiagramActionCtor_Basic() throws Exception {
        test = new MockCreateDiagramAction("class", null, "title");
        // check for creating successful.
        assertNotNull("Create failed.", test);

        //  get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have empty.", 0, diagrams.size());

        test.executeAction();
        // get all the diagrams.
        diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());

        Diagram diagram = diagrams.get(0);

        //  get the owner.
        SemanticModelBridge owner = diagram.getOwner();
        // check the type of the owner.
        assertTrue("The type of the owner should be intance of Uml1SemanticModelBridge.",
            owner instanceof Uml1SemanticModelBridge);

        /*
         * BugFix: UML-9507
         */
//        // get the properties.
//        Collection<Property> properties = diagram.getProperties();
//        // check the number of the properties.
//        assertEquals("The collection should have 1 element.", 1,
//            properties.size());
//
//        Property typeInfo = properties.iterator().next();
//        // check the key of the typeInfo.
//        assertEquals("The key of the typeInfo should be equal.", "typeInfo",
//            typeInfo.getKey());
//        // check the value of the typeInfo.
//        assertEquals("The value of the typeInfo should be equal.", "class",
//            typeInfo.getValue());
        SimpleSemanticModelElement semanticModel = (SimpleSemanticModelElement) diagram.getSemanticModel();
        assertEquals("The value of the typeInfo should be equal.", "class",
            semanticModel.getTypeInfo());
    }

    /**
     * <p>
     * Accuracy Test of the <code>CreateDiagramAction(String, Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateDiagramActionCtor_Detail() throws Exception {
        // check for creating successful.
        assertNotNull("Create failed.", test);

        // get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have empty.", 0, diagrams.size());

        test.executeAction();
        // get all the diagrams.
        diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());

        Diagram diagram = diagrams.get(0);

        //  get the owner.
        SemanticModelBridge owner = diagram.getOwner();
        // check the type of the owner.
        assertTrue("The type of the owner should be intance of Uml1SemanticModelBridge.",
            owner instanceof Uml1SemanticModelBridge);

        //  convert it to Uml1SemanticModelBridge.
        Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) owner;

        // get the element in modelBridge.
        Element getElement = modelBridge.getElement();

        // check the activityGraph and the getElement.
        assertSame("The two Element should be same.", element, getElement);
    }

    /**
     * <p>
     * Accuracy Test of the <code>CreateDiagramAction(String, Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateDiagramActionCtor_DiagramDetail()
        throws Exception {
        // check for creating successful.
        assertNotNull("Create failed.", test);

        test.executeAction();

        // get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());

        Diagram diagram = diagrams.get(0);

        // get the point to test the diagram.
        Point point = diagram.getPosition();
        // check the point.
        assertEquals("The point should at (0, 0).", 0.0, point.getX());
        assertEquals("The point should at (0, 0).", 0.0, point.getY());

        // get the zoom to test the diagram.
        double zoom = diagram.getZoom();
        // check the zoom.
        assertEquals("The zoom should be 1.0.", 1.0, zoom);

        // get the size to test the diagram.
        Dimension dimension = diagram.getSize();
        // check the dimension.
        assertEquals("The height of dimension should be 0.", 0.0,
            dimension.getHeight());
        assertEquals("The width of dimension should be 0.", 0.0,
            dimension.getWidth());

        // get the viewpoint to test the diagram.
        Point viewpoint = diagram.getViewport();
        // check the viewpoint.
        assertEquals("The viewpoint should at (0, 0).", 0.0, viewpoint.getX());
        assertEquals("The viewpoint should at (0, 0).", 0.0, viewpoint.getY());
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
        // get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have empty.", 0, diagrams.size());

        test.executeAction();
        // get all the diagrams.
        diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());
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
        //  get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have empty.", 0, diagrams.size());

        test.executeAction();
        // get all the diagrams.
        diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());

        test.undoAction();
        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());

        test.redoAction();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1,
            manager.getDiagrams().size());
    }
}
