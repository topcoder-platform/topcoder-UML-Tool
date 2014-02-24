/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ CreateUseCaseDiagramActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.uml.actions.diagram.CreateUseCaseDiagramAction;
import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>CreateUseCaseDiagramAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>CreateUseCaseDiagramAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class CreateUseCaseDiagramActionAccuracyTests extends TestCase {

    /**
    * <p>
    * Represents an instance of <code>CreateUseCaseDiagramAction</code> uses for accuracy tests.
    * </p>
    */
    private CreateUseCaseDiagramAction test = null;

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
     * Test suite of <code>CreateUseCaseDiagramActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>CreateUseCaseDiagramActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(CreateUseCaseDiagramActionAccuracyTests.class);
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
        test = new CreateUseCaseDiagramAction(element, "title");
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
     * Accuracy Test of the <code>CreateUseCaseDiagramAction(Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateUseCaseDiagramActionCtor_Basic()
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
     * Accuracy Test of the <code>CreateUseCaseDiagramAction(Element, String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateUseCaseDiagramActionCtor_NullElement()
        throws Exception {
        test = new CreateUseCaseDiagramAction(null, "title");
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
     * Accuracy Test of the <code>CreateUseCaseDiagramAction</code> calss.
     * It tests class inheritance.
     * </p>
     */
    public void testInheritance() {
        // test class inheritance.
        assertTrue("This class should extend from CreateDiagramAction",
            test instanceof CreateDiagramAction);
    }
}
