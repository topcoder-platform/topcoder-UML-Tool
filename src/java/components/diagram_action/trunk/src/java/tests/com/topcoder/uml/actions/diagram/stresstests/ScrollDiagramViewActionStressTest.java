/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Point;

import com.topcoder.uml.actions.diagram.ScrollDiagramViewAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This class tests the <code>ScrollDiagramViewAction</code> class for stress. This stress
 * tests addresses the functionality provided by the <code>ScrollDiagramViewAction</code> class.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class ScrollDiagramViewActionStressTest extends TestCase {
    /**
     * <p>The default config file path of <code>ScrollDiagramViewAction</code> for test.</p>
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
     * <p>The instance of <code>ScrollDiagramViewAction</code> for test.</p>
     */
    private ScrollDiagramViewAction action = null;

    /**
     * <p>Return test suite of <code>ScrollDiagramViewActionStressTest</code>.</p>
     *
     * @return Test suite of <code>ScrollDiagramViewActionStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(ScrollDiagramViewActionStressTest.class);
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

        Point newViewport = new Point();
        newViewport.setX(10.0);
        newViewport.setY(20.0);

        action = new ScrollDiagramViewAction(diagram, newViewport);
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
            assertEquals("The execute method is incorrect.", 10.0, diagram.getViewport().getX());
            assertEquals("The execute method is incorrect.", 20.0, diagram.getViewport().getY());
        }
    }
}
