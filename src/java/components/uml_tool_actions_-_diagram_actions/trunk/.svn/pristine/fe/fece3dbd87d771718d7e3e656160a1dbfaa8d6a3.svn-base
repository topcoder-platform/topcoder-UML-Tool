/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ CreateClassDiagramActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.uml.actions.diagram.CreateClassDiagramAction;
import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>CreateClassDiagramAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>CreateClassDiagramAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class CreateClassDiagramActionAccuracyTests extends TestCase {

    /**
    * <p>
    * Represents an instance of <code>CreateClassDiagramAction</code> uses for accuracy tests.
    * </p>
    */
    private CreateClassDiagramAction test = null;

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
     * Test suite of <code>CreateClassDiagramActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>CreateClassDiagramActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(CreateClassDiagramActionAccuracyTests.class);
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
        test = new CreateClassDiagramAction(element, "title");
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
     * Accuracy Test of the <code>CreateClassDiagramAction(Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateClassDiagramActionCtor_Basic()
        throws Exception {
        // check for creating successful.
        assertNotNull("Create failed.", test);

        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());

        test.execute();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1,
            manager.getDiagrams().size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>CreateClassDiagramAction(Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateClassDiagramActionCtor_NullElement()
        throws Exception {
        test = new CreateClassDiagramAction(null, "title");
        // check for creating successful.
        assertNotNull("Create failed.", test);

        // check the number of the diagrams.
        assertEquals("The list should be empty.", 0,
            manager.getDiagrams().size());

        test.execute();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1,
            manager.getDiagrams().size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>CreateClassDiagramAction</code> calss.
     * It tests class inheritance.
     * </p>
     */
    public void testInheritance() {
        // test class inheritance.
        assertTrue("This class should extend from CreateDiagramAction",
            test instanceof CreateDiagramAction);
    }
}
