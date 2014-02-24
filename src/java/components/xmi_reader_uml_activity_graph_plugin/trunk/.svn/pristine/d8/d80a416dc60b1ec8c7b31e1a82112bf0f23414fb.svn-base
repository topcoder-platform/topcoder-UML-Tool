/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.activitygraph;

import java.io.File;
import java.util.Collection;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * <p>
     * XMIReader instance for demonstration purpose.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(XMIReader.class.getName(), "test_files" + File.separator + "reader_config.xml");
        TestHelper.loadSingleXMLConfig(ModelElementFactory.class.getName(), "test_files" + File.separator
            + "ModelElementFactoryConfig.xml");
        reader = new XMIReader();

        ActivityGraphXMIHandler handler = (ActivityGraphXMIHandler) reader.getHandler("UML:StateMachine");
        handler.setModelElementFactory(new ModelElementFactory(ModelElementFactory.class.getName()));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(XMIReader.class.getName());
        TestHelper.clearConfigFile(ModelElementFactory.class.getName());
        reader = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * <p>
     * This test case demonstrates the usage of XMIReader and ActivityGraphXMIHandler to
     * parse a xmi file which has State Machine diagram.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testStatemachineDemo() throws Exception {
        reader.parse(new File("test_files" + File.separator + "statemachine_sample.xmi"));

        // Get the StateMachine instance via xmi id
        StateMachine stateMachine = (StateMachine) reader.getElement("I10ad419m10729d8da08mm7f50");

        // Get the related uml elements from the StateMachine
        State state = stateMachine.getTop();
        Collection<Transition> transitions = stateMachine.getTransitions();
    }

    /**
     * <p>
     * This test case demonstrates the usage of XMIReader and ActivityGraphXMIHandler to
     * parse a xmi file which has Activity Graph diagram.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testActivityGraphDemo() throws Exception {
        reader.parse(new File("test_files" + File.separator + "activitygraph_sample.xmi"));

        // Get the ActivityGraph instance via xmi id
        ActivityGraph activityGraph = (ActivityGraph) reader.getElement("-64--88-1-88--4d34a780:"
            + "10f7b30207c:-8000:00000000000007EF");

        // Get the related uml elements from the ActivityGraph
        State state = activityGraph.getTop();
        Collection<Transition> transitions = activityGraph.getTransitions();
    }

    /**
     * <p>
     * This test case demonstrates the functionality of ModelElementFactory.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testModelElementFactoryDemo() throws Exception {
        // Create a default instance
        ModelElementFactory modelElementFactory = new ModelElementFactory();

        // Create an instance with configuration data
        modelElementFactory = new ModelElementFactory(ModelElementFactory.class.getName());

        // Adds a new mapping to the class
        modelElementFactory.addMapping("UML:StateMachine", "com.topcoder.uml.model.statemachines.StateMachineImpl");

        // Creates an actual instance maps to the specific xml element
        modelElementFactory.createModelElement("UML:StateMachine");

        // Gets the class name for the given xml element
        modelElementFactory.getMapping("UML:StateMachine");

        // Return the complete mapping
        modelElementFactory.getAllMappings();

        // Remove the xml element mapping
        modelElementFactory.removeMapping("UML:StateMachine");
    }
}
