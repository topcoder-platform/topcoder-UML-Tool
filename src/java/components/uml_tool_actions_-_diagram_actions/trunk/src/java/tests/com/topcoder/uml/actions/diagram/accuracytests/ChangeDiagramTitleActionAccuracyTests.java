/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ ChangeDiagramTitleActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.actions.diagram.ChangeDiagramTitleAction;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>ChangeDiagramTitleAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>ChangeDiagramTitleAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class ChangeDiagramTitleActionAccuracyTests extends TestCase {
    /**
    * <p>
    * Represents an instance of <code>ChangeDiagramTitleAction</code> uses for accuracy tests.
    * </p>
    */
    private MockChangeDiagramTitleAction test = null;

    /**
     * <p>
     * Represents an instance of <code>Diagram</code> uses for accuracy tests.
     * </p>
     */
    private Diagram diagram = null;

    /**
     * <p>
     * Represents an array of <code>String</code> uses for accuracy tests.
     * </p>
     */
    private String[] names = null;

    /**
     * <p>
     * Test suite of <code>ChangeDiagramTitleActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>ChangeDiagramTitleActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(ChangeDiagramTitleActionAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        // clean the ConfigManager.
        TestHelper.clearConfig();
        // load the config file.
        TestHelper.loadLogFile();
        diagram = new Diagram();
        diagram.setName("old");
        names = new String[] {"acc1", "acc2", "acc3"};
        test = new MockChangeDiagramTitleAction(diagram, "new");
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
    }

    /**
     * <p>
     * Accuracy Test of the <code>ChangeDiagramTitleAction(Diagram, Double)</code>
     * constructor and executeAction() method.
     * </p>
     */
    public void testChangeDiagramTitleActionCtor_Basic() {
        // check for creating successful.
        assertNotNull("Create failed.", test);
        // check diagram's title here.
        assertEquals("Equal diagram's title expected.", "old", diagram.getName());

        // adjust diagram's title.
        test.executeAction();
        // check diagram's title here.
        assertEquals("Equal diagram's title expected.", "new", diagram.getName());
    }

    /**
     * <p>
     * Accuracy Test of the <code>ChangeDiagramTitleAction(Diagram, String)</code>
     * constructor and executeAction() method.
     * It tests this methods with different values.
     * </p>
     */
    public void testChangeDiagramTitleActionCtor_Times() {
        for (String name : names) {
            // creat a new Diagram.
            Diagram newDiagram = new Diagram();
            newDiagram.setName("old");

            test = new MockChangeDiagramTitleAction(newDiagram, name);
            // check for creating successful.
            assertNotNull("Create failed.", test);
            // check diagram's title here.
            assertEquals("Equal diagram's title expected.", "old",
                newDiagram.getName());

            // adjust diagram's title.
            test.executeAction();
            // check diagram's title here.
            assertEquals("Equal diagram's title expected.", name,
                newDiagram.getName());
        }
    }

    /**
     * <p>
     * Accuracy Test of the <code>executeAction()</code> method, <code>redoAction()</code> method,
     * and <code>undoAction()</code> method.
     * </p>
     */
    public void testAction_Operation() {
        // check for creating successful.
        assertNotNull("Create failed.", test);
        // check diagram's title here.
        assertEquals("Equal diagram's title expected.", "old", diagram.getName());

        // adjust diagram's title to a new value.
        test.executeAction();
        // check diagram's title here.
        assertEquals("Equal diagram's title expected.", "new", diagram.getName());

        // adjust diagram's title to original value.
        test.undoAction();
        // check diagram's title here.
        assertEquals("Equal diagram's title expected.", "old", diagram.getName());

        // adjust diagram's title to the new value again.
        test.redoAction();
        // check diagram's title here.
        assertEquals("Equal diagram's title expected.", "new", diagram.getName());
    }

    /**
     * <p>
     * Accuracy Test of the <code>executeAction()</code> method, <code>redoAction()</code> method,
     * and <code>undoAction()</code> method.
     * It tests this methods with different values.
     * </p>
     */
    public void testAction_Operation_Times() {
        for (String name : names) {
            // creat a new Diagram.
            Diagram newDiagram = new Diagram();
            newDiagram.setName("old");

            test = new MockChangeDiagramTitleAction(newDiagram, name);
            // check for creating successful.
            assertNotNull("Create failed.", test);
            // check diagram's title here.
            assertEquals("Equal diagram's title expected.", "old",
                newDiagram.getName());

            // adjust diagram's title to a new value.
            test.executeAction();
            // check diagram's title here.
            assertEquals("Equal diagram's title expected.", name,
                newDiagram.getName());

            // adjust diagram's title to original value.
            test.undoAction();
            // check diagram's title here.
            assertEquals("Equal diagram's title expected.", "old",
                newDiagram.getName());

            // adjust diagram's title to the new value again.
            test.redoAction();
            // check diagram's title here.
            assertEquals("Equal diagram's title expected.", name,
                newDiagram.getName());
        }
    }
}


/**
 * <p>
 * A inner class which extends the <code>ChangeDiagramTitleAction</code> class, used for
 * accuracy test only.
 * Here it make the protected method visiable.
 * </p>
 */
class MockChangeDiagramTitleAction extends ChangeDiagramTitleAction {
    /**
    * <p>
    * Creates an instance of <code>MockChangeDiagramTitleAction</code>.
    * </p>
    *
    * <p>
    * <strong>Note</strong>: It simply call <code>super</code> to make
    * the protected method visiable.
    * </p>
    *
    * @param diagram the diagram to change title.
    * @param name the new title name of the diagram.
    *
    * @throws IllegalArgumentException if the diagram is null.
    */
    public MockChangeDiagramTitleAction(Diagram diagram, String name) {
        super(diagram, name);
    }

    /**
     * <p>
     * Simply call <code>super</code> to make the protected method visiable.
     * </p>
     */
    public void executeAction() {
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
