/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.modelfactory;

import java.io.File;
import java.util.Map;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.CallState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ModelElementFactory.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ModelElementFactoryTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace to be used by this component.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.xmi.reader.handlers.uml.activitygraph.ModelElementFactory";

    /**
     * <p>
     * This constant represents the namespace to be used for testing.
     * </p>
     */
    private static final String NAMESPACE_TEST = NAMESPACE + ".Test";

    /**
     * <p>
     * The ModelElementFactory instance for testing.
     * </p>
     */
    private ModelElementFactory modelElementFactory;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "ModelElementFactoryConfig.xml");
        modelElementFactory = new ModelElementFactory(NAMESPACE);

    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(NAMESPACE);
        modelElementFactory = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ModelElementFactoryTests.class);
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created ModelElementFactory instance should not be null
     * and the mapping is loaded from configuration file successfully.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new ModelElementFactory instance.", modelElementFactory);

        assertEquals("Except the map has 11 xml elements.", 11, modelElementFactory.getAllMappings().size());

        assertEquals("Failed to set the correct class name.", "com.topcoder.uml.model.statemachines.StateMachineImpl",
            modelElementFactory.getMapping("UML:StateMachine"));
        assertEquals("Failed to set the correct class name.", "com.topcoder.uml.model.statemachines.TransitionImpl",
            modelElementFactory.getMapping("UML:Transition"));
        assertEquals("Failed to set the correct class name.", "com.topcoder.uml.model.statemachines.GuardImpl",
            modelElementFactory.getMapping("UML:Guard"));
        assertEquals("Failed to set the correct class name.", "com.topcoder.uml.model.statemachines.PseudostateImpl",
            modelElementFactory.getMapping("UML:Pseudostate"));
        assertEquals("Failed to set the correct class name.",
            "com.topcoder.uml.model.statemachines.CompositeStateImpl",
            modelElementFactory.getMapping("UML:CompositeState"));
        assertEquals("Failed to set the correct class name.", "com.topcoder.uml.model.statemachines.SimpleStateImpl",
            modelElementFactory.getMapping("UML:SimpleState"));
        assertEquals("Failed to set the correct class name.", "com.topcoder.uml.model.statemachines.FinalStateImpl",
            modelElementFactory.getMapping("UML:FinalState"));
        assertEquals("Failed to set the correct class name.",
            "com.topcoder.uml.model.activitygraphs.ActivityGraphImpl",
            modelElementFactory.getMapping("UML:ActivityGraph"));
        assertEquals("Failed to set the correct class name.", "com.topcoder.uml.model.activitygraphs.ActionStateImpl",
            modelElementFactory.getMapping("UML:ActionState"));
        assertEquals("Failed to set the correct class name.", "com.topcoder.uml.model.activitygraphs.CallStateImpl",
            modelElementFactory.getMapping("UML:CallState"));
        assertEquals("Failed to set the correct class name.",
            "com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl",
            modelElementFactory.getMapping("UML:ObjectFlowState"));
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ConfigurationException to JUnit
     */
    public void testCtor1_NullNamespace() throws ConfigurationException {
        try {
            new ModelElementFactory(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ConfigurationException to JUnit
     */
    public void testCtor1_EmptyNamespace() throws ConfigurationException {
        try {
            new ModelElementFactory(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace for object factory is not configed and expects
     * ConfigurationException.
     * </p>
     */
    public void testCtor1_UnknownNamespace() {
        // the namespace for the object factory is not configed
        try {
            new ModelElementFactory(NAMESPACE_TEST);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the property is missed and expects
     * ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor1_MissedProperty() throws Exception {
        // Missed property
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "ModelElementFactoryConfigNoProperty.xml");
        try {
            new ModelElementFactory(NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when no values for data for xml_to_element_mapping and expects
     * ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor1_NoValues() throws Exception {
        // no values for xml_to_element_mapping
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "ModelElementFactoryConfigNoValues.xml");
        try {
            new ModelElementFactory(NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when contain empty values for data for xml_to_element_mapping and expects
     * ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor1_ContainEmptyValues() throws Exception {
        // contain empty values for xml_to_element_mapping
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "ModelElementFactoryConfigEmptyValues.xml");
        try {
            new ModelElementFactory(NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when values did not followed the format [xml element name,class name] and expects
     * ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor1_WrongForamt() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "ModelElementFactoryConfigWrongFormat.xml");
        try {
            new ModelElementFactory(NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when xml element name does not exist and expects
     * ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor1_ElementNoExist() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "ModelElementFactoryConfigElementNoExist.xml");
        try {
            new ModelElementFactory(NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when class name for xml element name does not exist and expects
     * ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor1_ClassNameNoExist() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "ModelElementFactoryConfigNameNoExist.xml");
        try {
            new ModelElementFactory(NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ModelElementFactory#ModelElementFactory() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created ModelElementFactory instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new ModelElementFactory instance.", new ModelElementFactory());
    }

    /**
     * <p>
     * Tests ModelElementFactory#getAllMappings() for accuracy.
     * </p>
     *
     * <p>
     * Verify : All the mapping should be returned correctly.
     * </p>
     */
    public void testGetAllMappings() {
        Map<String, String> copyOfMap = modelElementFactory.getAllMappings();

        assertEquals("Expect the copyOfMap has 11 values.", 11, copyOfMap.size());

        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.statemachines.StateMachineImpl",
            copyOfMap.get("UML:StateMachine"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.statemachines.TransitionImpl",
            copyOfMap.get("UML:Transition"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.statemachines.GuardImpl",
            copyOfMap.get("UML:Guard"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.statemachines.PseudostateImpl",
            copyOfMap.get("UML:Pseudostate"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.statemachines.CompositeStateImpl",
            copyOfMap.get("UML:CompositeState"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.statemachines.SimpleStateImpl",
            copyOfMap.get("UML:SimpleState"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.statemachines.FinalStateImpl",
            copyOfMap.get("UML:FinalState"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.activitygraphs.ActivityGraphImpl",
            copyOfMap.get("UML:ActivityGraph"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.activitygraphs.ActionStateImpl",
            copyOfMap.get("UML:ActionState"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.activitygraphs.CallStateImpl",
            copyOfMap.get("UML:CallState"));
        assertEquals("Failed to get the mappings.", "com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl",
            copyOfMap.get("UML:ObjectFlowState"));
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an StateMachine instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForStateMachine() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:StateMachine");
        assertNotNull("Failed to create an StateMachine instance.", object);
        assertTrue("Failed to create an StateMachine instance.", object instanceof StateMachine);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an Transition instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForTransition() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:Transition");
        assertNotNull("Failed to create an Transition instance.", object);
        assertTrue("Failed to create an Transition instance.", object instanceof Transition);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an Guard instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForGuard() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:Guard");
        assertNotNull("Failed to create an Guard instance.", object);
        assertTrue("Failed to create an Guard instance.", object instanceof Guard);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an Pseudostate instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForPseudostate() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:Pseudostate");
        assertNotNull("Failed to create an Pseudostate instance.", object);
        assertTrue("Failed to create an Pseudostate instance.", object instanceof Pseudostate);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an CompositeState instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForCompositeState() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:CompositeState");
        assertNotNull("Failed to create an CompositeState instance.", object);
        assertTrue("Failed to create an CompositeState instance.", object instanceof CompositeState);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an SimpleState instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForSimpleState() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:SimpleState");
        assertNotNull("Failed to create an SimpleState instance.", object);
        assertTrue("Failed to create an SimpleState instance.", object instanceof SimpleState);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an FinalState instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForFinalState() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:FinalState");
        assertNotNull("Failed to create an FinalState instance.", object);
        assertTrue("Failed to create an FinalState instance.", object instanceof FinalState);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an ActivityGraph instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForActivityGraph() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:ActivityGraph");
        assertNotNull("Failed to create an ActivityGraph instance.", object);
        assertTrue("Failed to create an ActivityGraph instance.", object instanceof ActivityGraph);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an ActionState instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForActionState() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:ActionState");
        assertNotNull("Failed to create an ActionState instance.", object);
        assertTrue("Failed to create an ActionState instance.", object instanceof ActionState);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an CallState instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForCallState() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:CallState");
        assertNotNull("Failed to create an CallState instance.", object);
        assertTrue("Failed to create an CallState instance.", object instanceof CallState);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when creating an ObjectFlowState instance of the class
     * which maps to the specific xml element.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElementForObjectFlowState() throws ElementCreationException {
        Object object = modelElementFactory.createModelElement("UML:ObjectFlowState");
        assertNotNull("Failed to create an ObjectFlowState instance.", object);
        assertTrue("Failed to create an ObjectFlowState instance.", object instanceof ObjectFlowState);
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the mapping is not found and a null is returned.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElement_NoMapping() throws ElementCreationException {
        assertNull("Expect a null object was returned.", modelElementFactory.createModelElement("UML:Test"));
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when xmlElement is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElement_NullXmlElement() throws ElementCreationException {
        try {
            modelElementFactory.createModelElement(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when xmlElement is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ElementCreationException to JUnit
     */
    public void testCreateModelElement_EmptyXmlElement() throws ElementCreationException {
        try {
            modelElementFactory.createModelElement(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the class can not be located and expects
     * ElementCreationException.
     * </p>
     *
     */
    public void testCreateModelElement_ClassNotFound() {
        modelElementFactory.addMapping("UML:Test", "Test");
        try {
            modelElementFactory.createModelElement("UML:Test");
            fail("ElementCreationException expected.");
        } catch (ElementCreationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the class can not be instanced and expects
     * ElementCreationException.
     * </p>
     *
     */
    public void testCreateModelElement_InstantiationFailed() {
        modelElementFactory.addMapping("UML:AbstractStateImpl",
            "com.topcoder.uml.model.statemachines.AbstractStateImpl");

        try {
            modelElementFactory.createModelElement("UML:AbstractStateImpl");
            fail("ElementCreationException expected.");
        } catch (ElementCreationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#createModelElement(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the class can not be accessed and expects
     * ElementCreationException.
     * </p>
     *
     */
    public void testCreateModelElement_ClassNotAccessed() {
        modelElementFactory.addMapping("UML:TestHelper",
            "com.topcoder.xmi.reader.handlers.uml.activitygraph.TestHelper");

        try {
            modelElementFactory.createModelElement("UML:TestHelper");
            fail("ElementCreationException expected.");
        } catch (ElementCreationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#removeMapping(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The mapping is removed successfully.
     * </p>
     */
    public void testRemoveMapping() {
        modelElementFactory.removeMapping("UML:StateMachine");

        assertFalse("Failed to remove the xml element mapping.", modelElementFactory.getAllMappings().containsKey(
            "UML:StateMachine"));

        // it does nothing when the mapping is not found
        modelElementFactory.removeMapping("UML:Help");
    }

    /**
     * <p>
     * Tests ModelElementFactory#removeMapping(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when xmlElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveMapping_NullXmlElement() {
        try {
            modelElementFactory.removeMapping(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#removeMapping(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when xmlElement is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveMapping_EmptyXmlElement() {
        try {
            modelElementFactory.removeMapping(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#addMapping(String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The mapping is added successfully.
     * </p>
     */
    public void testAddMapping() {
        modelElementFactory.addMapping("UML:Test", "Test");

        assertTrue("Failed to add the xml element mapping.", modelElementFactory.getAllMappings().containsKey(
            "UML:Test"));
    }

    /**
     * <p>
     * Tests ModelElementFactory#addMapping(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when xmlElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddMapping_NullXmlElement() {
        try {
            modelElementFactory.addMapping(null, "Test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#addMapping(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when xmlElement is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testAddMapping_EmptyXmlElement() {
        try {
            modelElementFactory.addMapping(" ", "Test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#addMapping(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when className is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddMapping_NullClassName() {
        try {
            modelElementFactory.addMapping("UML:Test", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#addMapping(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when className is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testAddMapping_EmptyClassName() {
        try {
            modelElementFactory.addMapping("UML:Test", " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#getMapping(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The mapping is returned correctly.
     * </p>
     */
    public void testGetMapping() {
        // the mapping is found
        assertEquals("Failed to get the xml element mapping.", "com.topcoder.uml.model.statemachines.StateMachineImpl",
            modelElementFactory.getMapping("UML:StateMachine"));

        // the mapping is not found
        assertNull("Expects no mapping.", modelElementFactory.getMapping("UML:Help"));
    }

    /**
     * <p>
     * Tests ModelElementFactory#getMapping(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when xmlElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetMapping_NullXmlElement() {
        try {
            modelElementFactory.getMapping(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ModelElementFactory#getMapping(String) for failure.
     * It tests the case that when xmlElement is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testGetMapping_EmptyXmlElement() {
        try {
            modelElementFactory.getMapping(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}