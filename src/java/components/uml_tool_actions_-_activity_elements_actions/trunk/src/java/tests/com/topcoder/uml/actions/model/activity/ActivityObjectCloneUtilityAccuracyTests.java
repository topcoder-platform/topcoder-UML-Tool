/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

/**
 * <p>
 * This class aggregates accuracy tests for ActivityObjectCloneUtility package-private class.
 * </p>
 * <p>
 * Note: Since the tested class is package-private, this class is located under the same package as the tested
 * class.
 * </p>
 *
 * @author ch_music
 * @version 1.0
 */
public class ActivityObjectCloneUtilityAccuracyTests extends TestCase {

    /**
     * Tests clone(Pseudostate) method.
     *
     * @throws Exception to JUnit
     */
    public void testClonePseudostate() throws Exception {
        Pseudostate pseudostate = AccuracyTestHelper.createDecisionNode();
        Pseudostate clone = ActivityObjectCloneUtility.clone(pseudostate);
        assertNotSame("clone(Pseudostate) method fails.", pseudostate, clone);
    }

    /**
     * Tests clone(SimpleState) method.
     *
     * @throws Exception to JUnit
     */
    public void testCloneSimpleState() throws Exception {
        SimpleState simpleState = AccuracyTestHelper.createAcceptEventAction();
        SimpleState clone = ActivityObjectCloneUtility.clone(simpleState);
        assertNotSame("clone(SimpleState) method fails.", simpleState, clone);
    }

    /**
     * Tests clone(ActionState) method.
     *
     * @throws Exception to JUnit
     */
    public void testCloneActionState() throws Exception {
        ActionState actionState = AccuracyTestHelper.createActionState();
        ActionState clone = ActivityObjectCloneUtility.clone(actionState);
        assertNotSame("clone(ActionState) method fails.", actionState, clone);
    }

    /**
     * Tests clone(FinalState) method.
     *
     * @throws Exception to JUnit
     */
    public void testCloneFinalState() throws Exception {
        FinalState finalState = AccuracyTestHelper.createFinalNode();
        FinalState clone = ActivityObjectCloneUtility.clone(finalState);
        assertNotSame("clone(FinalState) method fails.", finalState, clone);
    }

    /**
     * Tests clone(Transition) method.
     *
     * @throws Exception to JUnit
     */
    public void testCloneTransition() throws Exception {
        Transition transition = new TransitionImpl();
        Transition clone = ActivityObjectCloneUtility.clone(transition);
        assertNotSame("clone(Transition) method fails.", transition, clone);
    }

    /**
     * Tests clone(ObjectFlowState) method.
     *
     * @throws Exception to JUnit
     */
    public void testCloneObjectFlowState() throws Exception {
        ObjectFlowState objectFlowState = AccuracyTestHelper.createObjectFlowState();
        ObjectFlowState clone = ActivityObjectCloneUtility.clone(objectFlowState);
        assertNotSame("clone(ObjectFlowState) method fails.", objectFlowState, clone);
    }

    /**
     * Tests whether clone method copies stereotype correctly.
     *
     * @throws Exception to JUnit
     */
    public void testClone1() throws Exception {
        ActionState state = AccuracyTestHelper.createActionState();
        Stereotype stereotype = new StereotypeImpl();
        state.addStereotype(stereotype);
        stereotype.addExtendedElement(state);

        ActionState clone = ActivityObjectCloneUtility.clone(state);

        assertNotSame("clone fails.", state, clone);
        assertEquals("clone fails to set stereotype correctly.", new ArrayList<Stereotype>(state.getStereotypes())
                .get(0), new ArrayList<Stereotype>(clone.getStereotypes()).get(0));
        assertTrue("clone fails to set bi-directional aggregation for stereotype.", stereotype
                .containsExtendedElement(clone));
    }

    /**
     * Tests whether clone method copies ReferenceTags correctly.
     *
     * @throws Exception to JUnit
     */
    public void testClone2() throws Exception {
        ActionState state = AccuracyTestHelper.createActionState();
        TaggedValue refTag = new TaggedValueImpl();
        state.addReferenceTag(refTag);
        refTag.addReferenceValue(state);

        ActionState clone = ActivityObjectCloneUtility.clone(state);

        assertNotSame("clone fails.", state, clone);
        assertEquals("clone fails to set referenceTags correctly.", new ArrayList<TaggedValue>(state
                .getReferenceTags()).get(0), new ArrayList<TaggedValue>(clone.getReferenceTags()).get(0));
        assertTrue("clone fails to set bi-directional aggregation for referenceTags.", refTag
                .containsReferenceValue(clone));
    }

    /**
     * Tests whether clone method copies TaggedValues correctly.
     *
     * @throws Exception to JUnit
     */
    public void testClone3() throws Exception {
        ActionState state = AccuracyTestHelper.createActionState();
        TaggedValue taggedValue = new TaggedValueImpl();
        state.addTaggedValue(taggedValue);

        ActionState clone = ActivityObjectCloneUtility.clone(state);

        assertNotSame("clone fails.", state, clone);
        assertEquals("clone fails to copy taggedValues.", 1, clone.getTaggedValues().size());
        assertNotSame("clone fails to clone taggedValues.", taggedValue, new ArrayList<TaggedValue>(clone
                .getTaggedValues()).get(0));
    }
}
