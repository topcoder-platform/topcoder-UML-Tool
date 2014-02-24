/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UtilTests extends TestCase {

    /**
     * <p>
     * UMLModelManager instance for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * ModelElement instance for testing.
     * </p>
     */
    private ModelElement element;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(ProjectConfigurationManager.class.getName(), "test_files/config.xml");
        TestHelper.loadSingleXMLConfig(ProjectConfigurationManager.class.getName() + ".objectfactory",
            "test_files/objectfactory.xml");

        manager = new UMLModelManager();
        element = new SimpleStateImpl();
        manager.setProjectLanguage("Java");
        ProjectConfigurationManager configManager = new ProjectConfigurationManager(manager);
        configManager.addInitialElementFormatter("Java", new MockInitialElementFormatter());
        manager.setProjectConfigurationManager(configManager);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        element = null;
        manager = null;

        TestHelper.clearConfigFile(ProjectConfigurationManager.class.getName());
        TestHelper.clearConfigFile(ProjectConfigurationManager.class.getName() + ".objectfactory");
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UtilTests.class);
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for accuracy.
     * </p>
     */
    public void testCheckNull() {
        Util.checkNull("", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullArg() {
        try {
            Util.checkNull(null, "test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for accuracy.
     * </p>
     */
    public void testCheckString() {
        Util.checkString("test", "test");
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_NullArg() {
        try {
            Util.checkString(null, "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_EmptyArg() {
        try {
            Util.checkString("", "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkTagDefinition(ModelElement,String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CheckTagDefinition is executed correctlyly when the state has not
     * the correct definition tag and value.
     * </p>
     */
    public void testCheckTagDefinition_False() {
        ModelElement state = new SimpleStateImpl();
        assertFalse("Failed to return the correct value.", Util.checkTagDefinition(state, "AcceptEventAction", "True"));
    }

    /**
     * <p>
     * Tests Util#checkTagDefinition(ModelElement,String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CheckTagDefinition is executed correctlyly when the state has
     * correct definition tag and value.
     * </p>
     */
    public void testCheckTagDefinition_True() {
        ModelElement state = new SimpleStateImpl();
        state.addTaggedValue(TestHelper.createTaggedValue("AcceptEventAction", "True"));
        assertTrue("Failed to return the correct value.", Util.checkTagDefinition(state, "AcceptEventAction", "True"));
    }

    /**
     * <p>
     * Tests Util#checkPseudostateKind(Pseudostate,PseudostateKind) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CheckPseudostateKind is correct.
     * </p>
     */
    public void testCheckPseudostateKind() {
        Pseudostate state = new PseudostateImpl();
        state.setKind(PseudostateKind.INITIAL);
        Util.checkPseudostateKind(state, PseudostateKind.INITIAL);
    }

    /**
     * <p>
     * Tests Util#checkPseudostateKind(Pseudostate,PseudostateKind) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state kind is not right and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckPseudostateKind_WrongKind() {
        Pseudostate state = new PseudostateImpl();
        try {
            Util.checkPseudostateKind(state, PseudostateKind.INITIAL);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#applyInitialFormatting(UMLModelManager,ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : ApplyInitialFormatting is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting() throws Exception {
        Util.applyInitialFormatting(manager, element);
        assertTrue("The model element should be formatted.", element.isSpecification());

    }

    /**
     * <p>
     * Tests Util#applyInitialFormatting(UMLModelManager,ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when ProjectConfigurationException occurs and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void ProjectConfigurationException() throws ProjectConfigurationException {

        System.setProperty("exception", "ProjectConfigurationException");

        try {
            Util.applyInitialFormatting(manager, element);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        } finally {
            System.clearProperty("exception");
        }
    }

    /**
     * <p>
     * Tests Util#getTop(ActivityGraph) for accuracy.
     * </p>
     *
     * <p>
     * Verify : GetTop is executed correctlyly.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testGetTop() throws ActionExecutionException {
        ActivityGraph activityGraph = new ActivityGraphImpl();
        CompositeState compositeState = new CompositeStateImpl();
        activityGraph.setTop(compositeState);

        assertEquals("Failed to return the correct value.", compositeState, Util.getTop(activityGraph));
    }

    /**
     * <p>
     * Tests Util#getTop(ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the top for the activity graph
     * is null and Expects ActionExecutionException.
     * </p>
     */
    public void testGetTop_NullTop() {
        ActivityGraph activityGraph = new ActivityGraphImpl();
        try {
            Util.getTop(activityGraph);
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getTop(ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the top for the activity graph is not
     * CompositeState type and Expects ActionExecutionException.
     * </p>
     */
    public void testGetTop_NotCompositeState() {
        ActivityGraph activityGraph = new ActivityGraphImpl();
        SimpleState state = new SimpleStateImpl();
        activityGraph.setTop(state);
        try {
            Util.getTop(activityGraph);
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkClassType(Object,Class) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CheckClassType is executed correctly.
     * </p>
     */
    public void testCheckClassType() {
        SimpleState content = new SimpleStateImpl();
        Util.checkClassType(content, SimpleState.class);
    }

    /**
     * <p>
     * Tests Util#checkClassType(Object,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when content is not CompositeState type
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckClassType_NullContent() {
        SimpleState content = new SimpleStateImpl();
        try {
            Util.checkClassType(content, CompositeState.class);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getSystemClipboard() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GetSystemClipboard is correct.
     * </p>
     */
    public void testGetSystemClipboard() {
        assertNotNull("Failed to get the system clipboard", Util.getSystemClipboard());
    }
}