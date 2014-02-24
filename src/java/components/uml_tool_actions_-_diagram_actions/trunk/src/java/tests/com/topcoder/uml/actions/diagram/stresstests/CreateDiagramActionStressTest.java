/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This class tests the <code>CreateDiagramAction</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>CreateDiagramAction</code> class.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class CreateDiagramActionStressTest extends TestCase {
    /**
     * <p>The default config file path of <code>CreateDiagramAction</code> for test.</p>
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
     * <p>The property of the diagram for test.</p>
     */
    private Property property = null;

    /**
     * <p>The instance of <code>SimpleCreateDiagramAction</code> for test.</p>
     */
    private SimpleCreateDiagramAction action = null;

    /**
     * <p>Return test suite of <code>CreateDiagramActionStressTest</code>.</p>
     *
     * @return Test suite of <code>CreateDiagramActionStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(CreateDiagramActionStressTest.class);
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

        // clear all diagrams here.
        UMLModelManager.getInstance().clearDiagrams();
    }

    /**
     * <p>Basic stress test of <code>CreateDiagramAction</code>'s constructor.</p>
     *
     * @throws Exception if any exception occurs when testing.
     */
    public void testCtor_CreateDiagramAction() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            // create instance here.
            String name = "Action#" + i;
            String type = "type#" + i;

            // set the property here.
            property = new Property();
            property.setKey("typeInfo");
            property.setValue(type);

            action = new SimpleCreateDiagramAction(type, owner, name);

            // check the attributes here.
            assertNotNull("The CreateDiagramAction constructor is incorrect.", action);

            // add the diagram into UMLModelManager.
            action.execute();

            // check the diagram here.
            Diagram diagram = UMLModelManager.getInstance().getDiagrams().get(0);
            assertEquals("The CreateDiagramAction constructor is incorrect.", diagram.getName(),
                name);

            Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) diagram.getOwner();
            assertEquals("The CreateDiagramAction constructor is incorrect.",
                modelBridge.getElement(), owner);
            /*
             * BugFix: UML-9507
             */
//            assertEquals("The CreateDiagramAction constructor is incorrect.",
//                StressTestHelper.findTypePropertyValue(diagram), type);
            assertEquals("The CreateDiagramAction constructor is incorrect.",
                    StressTestHelper.getTypeInfo(diagram), type);

            // check the viewport, size and position of the diagram, their x,y coordinate or width and height should be 0.0
            Point viewPort = diagram.getViewport();
            assertEquals("The X coordinate of the viewport is incorrect", 0,
                Double.compare(viewPort.getX(), 0.0));
            assertEquals("The Y coordinate of the viewport is incorrect", 0,
                Double.compare(viewPort.getY(), 0.0));

            Point position = diagram.getPosition();
            assertEquals("The X coordinate of the position is incorrect", 0,
                Double.compare(position.getX(), 0.0));
            assertEquals("The Y coordinate of the position is incorrect", 0,
                Double.compare(position.getY(), 0.0));

            Dimension size = diagram.getSize();
            assertEquals("The width of the size is incorrect", 0,
                Double.compare(size.getWidth(), 0.0));
            assertEquals("The height of the size is incorrect", 0,
                Double.compare(size.getHeight(), 0.0));

            // check the zoom
            assertEquals("The zoom is incorrect.", 0, Double.compare(diagram.getZoom(), 1.0));

            // remove the diagram from UMLModelManager.
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
        action = new SimpleCreateDiagramAction("type", owner, "Action");

        for (int i = 0; i < LOOPTIMES; i++) {
            action.executeAction();
            assertEquals("The executeAction method is incorrect.", 1,
                UMLModelManager.getInstance().countDiagrams());

            action.undoAction();
            assertEquals("The undoAction method is incorrect.", 0,
                UMLModelManager.getInstance().countDiagrams());

            action.redoAction();
            assertEquals("The redoAction method is incorrect.", 1,
                UMLModelManager.getInstance().countDiagrams());
        }
    }
}
