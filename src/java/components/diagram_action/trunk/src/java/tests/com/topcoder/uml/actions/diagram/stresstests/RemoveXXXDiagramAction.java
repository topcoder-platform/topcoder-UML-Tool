/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.actions.diagram.RemoveClassDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveSequenceDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveUseCaseDiagramAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This class tests all simple sub classes of <code>RemoveDiagramAction</code> class for
 * stress. This stress tests addresses the functionality provided by all simple sub classes of
 * <code>RemoveDiagramAction</code> class.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class RemoveXXXDiagramAction extends TestCase {
    /**
     * <p>The default config file path of <code>RemoveDiagramAction</code> for test.</p>
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
     * <p>The instance of <code>RemoveDiagramAction</code> for test.</p>
     */
    private RemoveDiagramAction action = null;

    /**
     * <p>Return test suite of <code>RemoveXXXDiagramAction</code>.</p>
     *
     * @return Test suite of <code>RemoveXXXDiagramAction</code>.
     */
    public static Test suite() {
        return new TestSuite(RemoveXXXDiagramAction.class);
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
     * <p>Basic stress test of all <code>RemoveXXXDiagramAction</code>'s constructor.</p>
     *
     * @throws Exception if any exception occurs when testing.
     */
    public void testCtor_RemoveXXXDiagramAction() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            // test RemoveUseCaseDiagramAction here.
            action = new RemoveUseCaseDiagramAction(diagram);
            assertNotNull("The RemoveUseCaseDiagramAction constructor is incorrect.", action);
            assertEquals("The RemoveUseCaseDiagramAction constructor is incorrect.",
                "Remove diagram " + diagram.getName(), action.getPresentationName());

            // test RemoveClassDiagramAction here.
            action = new RemoveClassDiagramAction(diagram);
            assertNotNull("The RemoveClassDiagramAction constructor is incorrect.", action);
            assertEquals("The RemoveClassDiagramAction constructor is incorrect.",
                "Remove diagram " + diagram.getName(), action.getPresentationName());

            // test RemoveSequenceDiagramAction here.
            action = new RemoveSequenceDiagramAction(diagram);
            assertNotNull("The RemoveSequenceDiagramAction constructor is incorrect.", action);
            assertEquals("The RemoveSequenceDiagramAction constructor is incorrect.",
                "Remove diagram " + diagram.getName(), action.getPresentationName());
        }
    }
}
