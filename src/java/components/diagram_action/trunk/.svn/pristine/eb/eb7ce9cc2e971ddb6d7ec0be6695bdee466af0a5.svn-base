/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.actions.diagram.AdjustDiagramZoomLevelAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This class tests the <code>AdjustDiagramZoomLevelAction</code> class for stress. This
 * stress tests addresses the functionality provided by the
 * <code>AdjustDiagramZoomLevelAction</code> class.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class AdjustDiagramZoomLevelActionStressTest extends TestCase {
    /**
     * <p>The default config file path of <code>AdjustDiagramZoomLevelAction</code> for
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
     * <p>The instance of <code>AdjustDiagramZoomLevelAction</code> for test.</p>
     */
    private AdjustDiagramZoomLevelAction action = null;

    /**
     * <p>Return test suite of <code>AdjustDiagramZoomLevelActionStressTest</code>.</p>
     *
     * @return Test suite of <code>AdjustDiagramZoomLevelActionStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(AdjustDiagramZoomLevelActionStressTest.class);
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

        action = new AdjustDiagramZoomLevelAction(diagram, new Double(10.0));
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
     * <p>Basic stress test of <code>execute()</code> method.</p>
     *
     * @throws Exception if any exception occurs when testing.
     */
    public void testMethod_execute() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            action.execute();
            assertEquals("The execute method is incorrect.", 10.0, diagram.getZoom());
        }
    }
}
