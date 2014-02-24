/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.actions.diagram.CreateActivityDiagramAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This class tests the <code>CreateActivityDiagramAction</code> class for stress. This
 * stress tests addresses the functionality provided by the
 * <code>CreateActivityDiagramAction</code> class.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class CreateActivityDiagramActionStressTest extends TestCase {
    /**
     * <p>The default config file path of <code>CreateActivityDiagramAction</code> for
     * test.</p>
     */
    private static final String CONFIG_FILE = "stresstests/config.xml";

    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The owner of the diagram for test.</p>
     */
    private Element owner = new ParameterImpl();

    /**
     * <p>The instance of <code>CreateActivityDiagramAction</code> for test.</p>
     */
    private CreateActivityDiagramAction action = null;

    /**
     * <p>Return test suite of <code>CreateActivityDiagramActionStressTest</code>.</p>
     *
     * @return Test suite of <code>CreateActivityDiagramActionStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(CreateActivityDiagramActionStressTest.class);
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
        UMLModelManager.getInstance().setProjectLanguage("JAVA");
        UMLModelManager.getInstance()
                       .setProjectConfigurationManager(new ProjectConfigurationManager(
                UMLModelManager.getInstance()));
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
     * <p>Basic stress test of <code>CreateActivityDiagramAction</code>'s constructor.</p>
     *
     * @throws Exception if any exception occurs when testing.
     */
    public void testCtor_CreateActivityDiagramAction()
        throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            String name = "Action#" + i;

            // test with nonnull owner here.
            action = new CreateActivityDiagramAction(owner, name);

            // check the attributes here.
            assertNotNull("The CreateActivityDiagramAction constructor is incorrect.", action);

            // add the activity graph into UMLModelManager.
            action.execute();

            ActivityGraph activityGraph = UMLModelManager.getInstance().getActivityGraphs().get(0);
            assertEquals("The CreateActivityDiagramAction constructor is incorrect.", owner,
                activityGraph.getContext());
            assertTrue("The CreateActivityDiagramAction constructor is incorrect.",
                activityGraph.getTop() instanceof CompositeState);

            // remove the activity graph from UMLModelManager.
            action.undo();

            // test with null owner here.
            action = new CreateActivityDiagramAction(null, name);

            // check the attributes here.
            assertNotNull("The CreateActivityDiagramAction constructor is incorrect.", action);

            // add the activity graph into UMLModelManager.
            action.execute();

            activityGraph = UMLModelManager.getInstance().getActivityGraphs().get(0);
            assertTrue("The CreateActivityDiagramAction constructor is incorrect.",
                activityGraph.getContext() instanceof UseCaseImpl);
            assertTrue("The CreateActivityDiagramAction constructor is incorrect.",
                activityGraph.getTop() instanceof CompositeState);

            // remove the activity graph from UMLModelManager.
            action.undo();
        }
    }

    /**
     * <p>Basic stress test of <code>executeAction()</code>, <code>undoAction()</code> and
     * <code>redoAction()</code> method.</p>
     *
     * @throws Exception if any exception occurs when testing.
     */
    public void testMethod_Action() throws Exception {
        // create instance here.
        CreateActivityDiagramActionWrapper actionWrapper = new CreateActivityDiagramActionWrapper(owner,
                "Action");

        for (int i = 0; i < LOOPTIMES; i++) {
            // test executeAction method here.
            actionWrapper.executeAction();
            assertEquals("The executeAction method is incorrect.", 1,
                UMLModelManager.getInstance().countActivityGraphs());
            assertEquals("The executeAction method is incorrect.", 1,
                UMLModelManager.getInstance().countDiagrams());

            // check the diagram from CreateActivityDiagramHelperAction here.
            Diagram diagram = UMLModelManager.getInstance().getDiagrams().get(0);
            Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) diagram.getOwner();
            ActivityGraph activityGraph = (ActivityGraph) modelBridge.getElement();
            assertEquals("The executeAction method is incorrect.", activityGraph.getContext(), owner);

            // test undoAction method here.
            actionWrapper.undoAction();
            assertEquals("The undoAction method is incorrect.", 0,
                UMLModelManager.getInstance().countActivityGraphs());
            assertEquals("The undoAction method is incorrect.", 0,
                UMLModelManager.getInstance().countDiagrams());

            // test redoAction method here.
            actionWrapper.redoAction();
            assertEquals("The redoAction method is incorrect.", 1,
                UMLModelManager.getInstance().countActivityGraphs());
            assertEquals("The redoAction method is incorrect.", 1,
                UMLModelManager.getInstance().countDiagrams());
        }
    }
}
