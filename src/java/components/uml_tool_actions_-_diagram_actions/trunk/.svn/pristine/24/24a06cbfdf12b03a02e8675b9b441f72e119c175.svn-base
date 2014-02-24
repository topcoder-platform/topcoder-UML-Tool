/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.actions.diagram.RemoveActivityDiagramAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This class tests the <code>RemoveActivityDiagramAction</code> class for stress. This
 * stress tests addresses the functionality provided by the
 * <code>RemoveActivityDiagramAction</code> class.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class RemoveActivityDiagramActionStressTest extends TestCase {
    /**
     * <p>The default config file path of <code>RemoveActivityDiagramAction</code> for
     * test.</p>
     */
    private static final String CONFIG_FILE = "stresstests/config.xml";

    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The <code>Diagram</code> instance for test.</p>
     */
    private Diagram diagram = null;

    /**
     * <p>The <code>ActivityGraph</code> instance used for test.</p>
     */
    private ActivityGraph activityGraph = new ActivityGraphImpl();

    /**
     * <p>The instance of <code>RemoveActivityDiagramAction</code> for test.</p>
     */
    private RemoveActivityDiagramAction action = null;

    /**
     * <p>Return test suite of <code>RemoveActivityDiagramActionStressTest</code>.</p>
     *
     * @return Test suite of <code>RemoveActivityDiagramActionStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(RemoveActivityDiagramActionStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     *
     * @throws Exception if any exception occurs when setting.
     */
    protected void setUp() throws Exception {
        // clear all namespaces here.
        StressTestHelper.clearNamespace();

        ConfigManager cm = ConfigManager.getInstance();

        // load config files.
        cm.add(CONFIG_FILE);
        cm.add("Config.xml");

        // set the model manager here.
        UMLModelManager.getInstance().clearActivityGraphs();
        UMLModelManager.getInstance().clearDiagrams();

        // create diagram here.
        diagram = new Diagram();
        diagram.setName("diagram");

        Uml1SemanticModelBridge uml1SemanticModelBridge = new Uml1SemanticModelBridge();
        uml1SemanticModelBridge.setElement(activityGraph);
        diagram.setOwner(uml1SemanticModelBridge);
    }

    /**
     * <p>Clean the stress test environment.</p>
     *
     * @throws Exception if any exception occurs when setting.
     */
    protected void tearDown() throws Exception {
        // clear all namespaces.
        StressTestHelper.clearNamespace();

        // clear all activity graph here.
        UMLModelManager.getInstance().clearActivityGraphs();
        UMLModelManager.getInstance().clearDiagrams();
    }

    /**
     * <p>Basic stress test of <code>RemoveActivityDiagramAction</code>'s constructor.</p>
     *
     * @throws Exception if any exception occurs when testing.
     */
    public void testCtor_RemoveActivityDiagramAction()
        throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            action = new RemoveActivityDiagramAction(diagram);

            // check the attributes here.
            assertNotNull("The RemoveActivityDiagramAction constructor is incorrect.", action);
            assertEquals("The RemoveActivityDiagramAction constructor is incorrect.",
                "Remove diagram " + diagram.getName(), action.getPresentationName());
        }
    }

    /**
     * <p>Basic stress test of <code>executeAction()</code>, <code>undoAction()</code> and
     * <code>redoAction()</code> method.</p>
     *
     * @throws Exception if any exception occurs when testing.
     */
    public void testMethod_Action() throws Exception {
        action = new RemoveActivityDiagramAction(diagram);

        for (int i = 0; i < LOOPTIMES; i++) {
            // test executeAction method here.
            action.executeAction();
            assertFalse("The executeAction method is incorrect",
                UMLModelManager.getInstance().containsDiagram(diagram));
            assertFalse("The executeAction method is incorrect",
                UMLModelManager.getInstance().containsActivityGraph(activityGraph));

            // test undoAction method here.
            action.undoAction();
            assertTrue("The undoAction method is incorrect",
                UMLModelManager.getInstance().containsDiagram(diagram));
            assertTrue("The undoAction method is incorrect",
                UMLModelManager.getInstance().containsActivityGraph(activityGraph));

            // test redoAction method here.
            action.redoAction();
            assertFalse("The redoAction method is incorrect",
                UMLModelManager.getInstance().containsDiagram(diagram));
            assertFalse("The redoAction method is incorrect",
                UMLModelManager.getInstance().containsActivityGraph(activityGraph));
        }
    }
}
