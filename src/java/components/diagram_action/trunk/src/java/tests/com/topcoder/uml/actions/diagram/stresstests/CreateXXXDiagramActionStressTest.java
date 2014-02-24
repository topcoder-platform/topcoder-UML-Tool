/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.actions.diagram.CreateClassDiagramAction;
import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.uml.actions.diagram.CreateSequenceDiagramAction;
import com.topcoder.uml.actions.diagram.CreateUseCaseDiagramAction;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This class tests all simple sub classes of <code>CreateDiagramAction</code> class for
 * stress. This stress tests addresses the functionality provided by all simple sub classes of
 * <code>CreateDiagramAction</code> class.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class CreateXXXDiagramActionStressTest extends TestCase {
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
     * <p>The instance of <code>SimpleCreateDiagramAction</code> for test.</p>
     */
    private CreateDiagramAction action = null;

    /**
     * <p>Return test suite of <code>CreateXXXDiagramActionStressTest</code>.</p>
     *
     * @return Test suite of <code>CreateXXXDiagramActionStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(CreateXXXDiagramActionStressTest.class);
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
                       .setProjectConfigurationManager(new ProjectConfigurationManager(UMLModelManager.getInstance()));
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
     * <p>Basic stress test of all <code>CreateXXXAction</code>'s constructor.</p>
     *
     * @throws Exception if any exception occurs when testing.
     */
    public void testCtor_CreateXXXDiagramAction() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            // create instance here.
            String name = "Action#" + i;

            // check the CreateSequenceDiagramAction here.
            action = new CreateSequenceDiagramAction(owner, name);
            checkCreateDiagramAction(action, name, "SequenceDiagram");

            // check the CreateClassDiagramAction here.
            action = new CreateClassDiagramAction(owner, name);
            checkCreateDiagramAction(action, name, "ClassDiagram");

            // check the CreateUseCaseDiagramAction here.
            action = new CreateUseCaseDiagramAction(owner, name);
            checkCreateDiagramAction(action, name, "UseCaseDiagram");
        }
    }

    /**
     * <p>This method will check the action's name and type value.</p>
     *
     * @param action the action instance to be checked.
     * @param name the name of action.
     * @param type the type of action.
     *
     * @throws Exception if any exception occurs when testing.
     */
    private void checkCreateDiagramAction(CreateDiagramAction action, String name, String type)
        throws Exception {
        // check the attributes here.
        assertNotNull("The CreateDiagramAction constructor is incorrect.", action);

        // add the diagram into UMLModelManager.
        action.execute();

        // check the diagram here.
        Diagram diagram = UMLModelManager.getInstance().getDiagrams().get(0);
        assertEquals("The CreateDiagramAction constructor is incorrect.", diagram.getName(), name);

        Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) diagram.getOwner();
        assertEquals("The CreateDiagramAction constructor is incorrect.", modelBridge.getElement(),
            owner);
        /*
         * BugFix: UML-9507
         */
//        assertEquals("The CreateDiagramAction constructor is incorrect.",
//            StressTestHelper.findTypePropertyValue(diagram), type);
        assertEquals("The CreateDiagramAction constructor is incorrect.",
                StressTestHelper.getTypeInfo(diagram), type);

        // remove the diagram from UMLModelManager.
        action.undo();
    }
}
