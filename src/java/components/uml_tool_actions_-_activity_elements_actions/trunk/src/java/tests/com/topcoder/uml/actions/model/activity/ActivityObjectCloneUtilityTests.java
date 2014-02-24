/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ActivityObjectCloneUtility.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActivityObjectCloneUtilityTests extends TestCase {
    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActivityObjectCloneUtilityTests.class);
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(Pseudostate) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Clone is executed correctly, and the pseudostate is cloned correctly.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForPseudostate() throws ActivityObjectCloneException {
        Pseudostate pseudostate = new PseudostateImpl();
        pseudostate.setKind(PseudostateKind.SHALLOW_HISTORY);

        Pseudostate content = ActivityObjectCloneUtility.clone(pseudostate);
        assertNotNull("Failed to return the correct value.", content);
        assertNotSame("Expects the pseudostate is cloned", content != pseudostate);
        assertEquals("The kind attribute should be set.", PseudostateKind.SHALLOW_HISTORY, content.getKind());
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(Pseudostate) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForPseudostate_NullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((Pseudostate) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(Pseudostate) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the default constructor of the state is not defined and
     * expects ActivityObjectCloneException.
     * </p>
     */
    public void testCloneForPseudostate_ActivityObjectCloneException() {
        MockPseudostate state = new MockPseudostate("Test");
        try {
            ActivityObjectCloneUtility.clone(state);
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(SimpleState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Clone is executed correctly, and the simpleState is cloned correctly.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForSimpleState() throws ActivityObjectCloneException {
        SimpleState simpleState = new SimpleStateImpl();

        SimpleState content = ActivityObjectCloneUtility.clone(simpleState);
        assertNotNull("Failed to return the correct value.", content);
        assertTrue("Expects the simpleState is cloned", content != simpleState);
        assertNull("The state machine for the state should not be set.", content.getStateMachine());
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(SimpleState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForSimpleState_NullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((SimpleState) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(SimpleState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the default constructor of the state is not defined and
     * expects ActivityObjectCloneException.
     * </p>
     */
    public void testCloneForSimpleState_ActivityObjectCloneException() {
        MockObjectFlowState state = new MockObjectFlowState("Test");
        try {
            ActivityObjectCloneUtility.clone((SimpleState) state);
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(ActionState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Clone is executed correctly, and the actionState is cloned correctly.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForActionState() throws ActivityObjectCloneException {
        ActionState actionState = new ActionStateImpl();

        ActionState content = ActivityObjectCloneUtility.clone(actionState);
        assertNotNull("Failed to return the correct value.", content);
        assertTrue("Expects the actionState is cloned", content != actionState);
        assertNull("The state machine for the state should not be set.", content.getStateMachine());
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(ActionState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForActionState_NullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((ActionState) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(ActionState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the default constructor of the state is not defined and
     * expects ActivityObjectCloneException.
     * </p>
     */
    public void testCloneForActionState_ActivityObjectCloneException() {
        MockActionState state = new MockActionState("Test");
        try {
            ActivityObjectCloneUtility.clone(state);
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(FinalState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Clone is executed correctly, and the finalState is cloned correctly.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForFinalState() throws ActivityObjectCloneException {
        FinalState finalState = new FinalStateImpl();

        FinalState content = ActivityObjectCloneUtility.clone(finalState);
        assertNotNull("Failed to return the correct value.", content);
        assertTrue("Expects the finalState is cloned", content != finalState);
        assertNull("The state machine for the state should not be set.", content.getStateMachine());
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(FinalState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForFinalState_NullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((FinalState) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(FinalState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the default constructor of the state is not defined and
     * expects ActivityObjectCloneException.
     * </p>
     */
    public void testCloneForFinalState_ActivityObjectCloneException() {
        MockFinalState state = new MockFinalState("Test");
        try {
            ActivityObjectCloneUtility.clone(state);
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(Transition) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Clone is executed correctly, and the transition is cloned correctly.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForTransition() throws ActivityObjectCloneException {
        Transition transition = new TransitionImpl();

        StateVertex source = new SimpleStateImpl();
        StateVertex target = new SimpleStateImpl();
        Guard guard = new GuardImpl();
        transition.setSource(source);
        transition.setTarget(target);
        transition.setGuard(guard);

        Transition content = ActivityObjectCloneUtility.clone(transition);
        assertNotNull("Failed to return the correct value.", content);
        assertTrue("Expects the transition is cloned", content != transition);

        assertSame("The source should be set by reference.", source, content.getSource());
        assertSame("The target should be set by reference.", target, content.getTarget());
        assertNotSame("The guard should be set by clone", guard, content.getGuard());
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(Transition) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transition is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForTransition_NullTransition() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((Transition) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(Transition) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the default constructor of the state is not defined and
     * expects ActivityObjectCloneException.
     * </p>
     */
    public void testCloneForTransition_ActivityObjectCloneException() {
        MockTransition state = new MockTransition("Test");
        try {
            ActivityObjectCloneUtility.clone(state);
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(ObjectFlowState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Clone is executed correctly, and the objectFlowState is cloned correctly.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForObjectFlowState() throws ActivityObjectCloneException {
        ObjectFlowState objectFlowState = new ObjectFlowStateImpl();
        objectFlowState.setSynch(true);

        ObjectFlowState content = ActivityObjectCloneUtility.clone(objectFlowState);
        assertNotNull("Failed to return the correct value.", content);
        assertTrue("Expects the objectFlowState is cloned", content != objectFlowState);
        assertTrue("The synch attribute should be true.", content.isSynch());
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(ObjectFlowState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForObjectFlowState_NullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((ObjectFlowState) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(ObjectFlowState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the default constructor of the state is not defined and
     * expects ActivityObjectCloneException.
     * </p>
     */
    public void testCloneForObjectFlowState_ActivityObjectCloneException() {
        MockObjectFlowState state = new MockObjectFlowState("Test");
        try {
            ActivityObjectCloneUtility.clone(state);
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectCloneUtility#clone(StateVertex) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Clone is executed correctly, and the StateVertex is correctly cloned.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneForVertex() throws ActivityObjectCloneException {
        SimpleState state = createSimpleState();

        SimpleState content = ActivityObjectCloneUtility.clone(state);

        assertEquals("Failed to clone the StateVertex instance.", state.getName(), content.getName());
        assertEquals("Failed to clone the StateVertex instance.", state.getVisibility(), content.getVisibility());
        assertEquals("Failed to clone the StateVertex instance.", state.isSpecification(), content.isSpecification());

        assertEquals("Failed to clone the StateVertex instance.", 1, content.getStereotypes().size());
        assertSame("The stereotype should be set by reference.", state.getStereotypes().iterator().next(),
            content.getStereotypes().iterator().next());

        assertEquals("Failed to clone the StateVertex instance.", 1, content.getTaggedValues().size());
        assertNotSame("The tagged value should be set by clone.", state.getTaggedValues().iterator().next(),
            content.getTaggedValues().iterator().next());

        assertSame("The namespace should be set by reference.", state.getNamespace(), content.getNamespace());
        assertEquals("The parameter template should be set by reference.", state.getParameterTemplate(),
            content.getParameterTemplate());

        assertEquals("Failed to clone the StateVertex instance.", 1, content.getDefaultParameters().size());
        assertSame("The default parameters should be set by reference.",
            state.getDefaultParameters().iterator().next(), content.getDefaultParameters().iterator().next());

        assertEquals("Failed to clone the StateVertex instance.", 1, content.getTemplateParameters().size());
        assertNotSame("The template parameters should be set by clone.",
            state.getTemplateParameters().iterator().next(), content.getTemplateParameters().iterator().next());

        assertEquals("Failed to clone the StateVertex instance.", 1, content.getTemplateArguments().size());
        assertSame("The template arguments should be set by reference.",
            state.getTemplateArguments().iterator().next(), content.getTemplateArguments().iterator().next());

        assertEquals("Failed to clone the StateVertex instance.", 1, content.getElementImports().size());
        assertSame("The element imports should be set by reference.", state.getElementImports().iterator().next(),
            content.getElementImports().iterator().next());
    }

    /**
     * <p>
     * Creates a new SimpleState instance for testing.
     * </p>
     *
     * @return a new SimpleState instance for testing.
     */
    private SimpleState createSimpleState() {
        SimpleState state = new SimpleStateImpl();

        CompositeState container = new CompositeStateImpl();
        state.setContainer(container);

        state.setName("TestingSimpleState");
        state.setVisibility(VisibilityKind.PUBLIC);
        state.setSpecification(true);

        Stereotype stereotype = new StereotypeImpl();
        state.addStereotype(stereotype);

        TaggedValue taggedValue = new TaggedValueImpl();
        state.addTaggedValue(taggedValue);

        Namespace namespace = new PackageImpl();
        state.setNamespace(namespace);

        TemplateParameter tp = new TemplateParameterImpl();
        state.setParameterTemplate(tp);

        TemplateParameter defaultParameter = new TemplateParameterImpl();
        state.addDefaultParameter(defaultParameter);

        TemplateParameter templateParameter = new TemplateParameterImpl();
        state.addTemplateParameter(templateParameter);

        TemplateArgument templateArgument = new TemplateArgumentImpl();
        state.addTemplateArgument(templateArgument);

        ElementImport elementImport = new ElementImportImpl();
        state.addElementImport(elementImport);

        return state;
    }
}