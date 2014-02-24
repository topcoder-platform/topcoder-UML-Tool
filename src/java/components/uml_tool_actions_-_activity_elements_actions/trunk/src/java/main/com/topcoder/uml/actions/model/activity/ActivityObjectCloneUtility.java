/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.util.Collection;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * ActivityObjectCloneUtility is a utility class, it provides method to clone the activity model
 * object for the cut/copy actions.
 * </p>
 *
 * <p>
 * Thread safety: This class is stateless and thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
class ActivityObjectCloneUtility {
    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    private ActivityObjectCloneUtility() {
        // empty
    }

    /**
     * <p>
     * Clone the Pseudostate object.
     * </p>
     *
     * @param state the Pseudostate object to clone.
     * @return the cloned Pseudostate object.
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    public static Pseudostate clone(Pseudostate state) throws ActivityObjectCloneException {
        Pseudostate clonedState = (Pseudostate) clone((StateVertex) state);

        // set the kind property
        clonedState.setKind(state.getKind());

        return clonedState;
    }

    /**
     * <p>
     * Clone the SimpleState object.
     * </p>
     *
     * @param state the SimplState object to clone.
     * @return the cloned SimplState object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    public static SimpleState clone(SimpleState state) throws ActivityObjectCloneException {
        return (SimpleState) clone((StateVertex) state);
    }

    /**
     * <p>
     * Clone the ActionState object.
     * </p>
     *
     * @param state the ActionState object to clone.
     * @return the cloned ActionState object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    public static ActionState clone(ActionState state) throws ActivityObjectCloneException {
        return (ActionState) clone((SimpleState) state);
    }

    /**
     * <p>
     * Clone the FinalState object.
     * </p>
     *
     * @param state the FinalState object to clone.
     * @return the cloned FinalState object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    public static FinalState clone(FinalState state) throws ActivityObjectCloneException {
        return (FinalState) clone((StateVertex) state);
    }

    /**
     * <p>
     * Clone the ObjectFlowState object.
     * </p>
     *
     * @param state the ObjectFlowState object to clone
     * @return the cloned ObjectFlowState object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails.
     */
    public static ObjectFlowState clone(ObjectFlowState state) throws ActivityObjectCloneException {
        ObjectFlowState clonedState = (ObjectFlowState) clone((SimpleState) state);

        clonedState.setSynch(state.isSynch());

        return clonedState;
    }

    /**
     * <p>
     * Clone the given Transition object.
     * </p>
     *
     * <p>
     * Note, the state machine (parent reference) associated with the transition is not set.
     * </p>
     *
     * @param transition the Transition object to clone
     * @return the cloned Transition object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    public static Transition clone(Transition transition) throws ActivityObjectCloneException {
        Transition clonedTransition = (Transition) clone((ModelElement) transition);

        clonedTransition.setSource(transition.getSource());
        clonedTransition.setTarget(transition.getTarget());

        // composite property
        Guard guard = transition.getGuard();
        if (guard != null) {
            clonedTransition.setGuard(clone(guard));
        }

        return clonedTransition;
    }

    /**
     * <p>
     * Clone the given Guard object.
     * </p>
     *
     * @param guard the Guard object to clone.
     * @return the cloned Guard object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    private static Guard clone(Guard guard) throws ActivityObjectCloneException {
        Guard clonedGuard = (Guard) clone((ModelElement) guard);

        clonedGuard.setExpression(guard.getExpression());
        clonedGuard.setTransition(guard.getTransition());

        return clonedGuard;
    }

    /**
     * <p>
     * Clone the given StateVertex object.
     * </p>
     *
     * @param state the StateVertex object to clone.
     * @return the cloned StateVertex object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    private static StateVertex clone(StateVertex state) throws ActivityObjectCloneException {
        StateVertex clonedState = (StateVertex) clone((ModelElement) state);

        // set the container property, no clone because the relationship is not a composite
        clonedState.setContainer(state.getContainer());

        return clonedState;
    }

    /**
     * <p>
     * Clone the given ModelElement object.
     * </p>
     *
     * <p>
     * Note, only the tagged values (composite relationship) are cloned, other properties of the ModelElement
     * class are set by reference.
     * </p>
     *
     * @param modelElement the ModelElement object to clone.
     * @return the cloned ModelElement object.
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails.
     */
    private static ModelElement clone(ModelElement modelElement) throws ActivityObjectCloneException {
        Util.checkNull(modelElement, "modelElement");

        ModelElement clonedElement;
        try {
            clonedElement = modelElement.getClass().newInstance();
        } catch (IllegalArgumentException e) {
            throw new ActivityObjectCloneException("IllegalArgumentException occurs while instantiating class "
                + modelElement.getClass() + " using default constructor.", e);
        } catch (SecurityException e) {
            throw new ActivityObjectCloneException("SecurityException occurs while instantiating class "
                + modelElement.getClass() + " using default constructor.", e);
        } catch (InstantiationException e) {
            throw new ActivityObjectCloneException("InstantiationException occurs while instantiating class "
                + modelElement.getClass() + " using default constructor.", e);
        } catch (IllegalAccessException e) {
            throw new ActivityObjectCloneException("IllegalAccessException occurs while instantiating class "
                + modelElement.getClass() + " using default constructor.", e);
        }

        // simple attributes
        clonedElement.setName(modelElement.getName());
        clonedElement.setVisibility(modelElement.getVisibility());
        clonedElement.setSpecification(modelElement.isSpecification());

        // add the behaviors
        for (StateMachine stateMachine : modelElement.getBehaviors()) {
            clonedElement.addBehavior(stateMachine);
        }

        // add the stereotypes, no clone because the relationship is not a composite
        for (Stereotype stereotype : modelElement.getStereotypes()) {
            clonedElement.addStereotype(stereotype);
            stereotype.addExtendedElement(clonedElement);
        }

        // add the tagged values, composite relationship so clone is done
        for (TaggedValue taggedValue : modelElement.getTaggedValues()) {
            clonedElement.addTaggedValue(clone(taggedValue));
        }

        // add the reference tags, no clone because the relationship is not a composite
        for (TaggedValue taggedValue : modelElement.getReferenceTags()) {
            clonedElement.addReferenceTag(taggedValue);
            taggedValue.addReferenceValue(clonedElement);
        }

        // set the namespace, no clone because the relationship is not a composite
        clonedElement.setNamespace(modelElement.getNamespace());

        // set the parameter template, no clone because the relationship is not a composite
        clonedElement.setParameterTemplate(modelElement.getParameterTemplate());

        // add the default parameters, no clone because the relationship is not a composite
        for (TemplateParameter tp : modelElement.getDefaultParameters()) {
            clonedElement.addDefaultParameter(tp);
        }

        // add the template parameters, composite relationship so clone is done
        for (TemplateParameter tp : modelElement.getTemplateParameters()) {
            clonedElement.addTemplateParameter(clone(tp));
        }

        // add the template arguments, no clone because the relationship is not a composite
        for (TemplateArgument ta : modelElement.getTemplateArguments()) {
            clonedElement.addTemplateArgument(ta);
        }

        // add the element imports, no clone because the relationship is not a composite
        for (ElementImport elemnetImport : modelElement.getElementImports()) {
            clonedElement.addElementImport(elemnetImport);
        }

        return clonedElement;
    }

    /**
     * <p>
     * Clone the given TemplateParameter object.
     * </p>
     *
     * @param tp the TemplateParameter object to clone.
     * @return the cloned TemplateParameter object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    private static TemplateParameter clone(TemplateParameter tp) throws ActivityObjectCloneException {
        TemplateParameter clonedTemplateParameter;
        try {
            clonedTemplateParameter = tp.getClass().newInstance();
        } catch (IllegalArgumentException e) {
            throw new ActivityObjectCloneException("IllegalArgumentException occurs while instantiating class "
                + tp.getClass() + " using default constructor.", e);
        } catch (SecurityException e) {
            throw new ActivityObjectCloneException("SecurityException occurs while instantiating class "
                + tp.getClass() + " using default constructor.", e);
        } catch (InstantiationException e) {
            throw new ActivityObjectCloneException("InstantiationException occurs while instantiating class "
                + tp.getClass() + " using default constructor.", e);
        } catch (IllegalAccessException e) {
            throw new ActivityObjectCloneException("IllegalAccessException occurs while instantiating class "
                + tp.getClass() + " using default constructor.", e);
        }

        if (clonedTemplateParameter.getParameter() != null) {
            clonedTemplateParameter.setParameter(clone(clonedTemplateParameter.getParameter()));
        }

        clonedTemplateParameter.setDefaultElement(clonedTemplateParameter.getDefaultElement());
        clonedTemplateParameter.setTemplate(clonedTemplateParameter.getTemplate());

        return clonedTemplateParameter;
    }

    /**
     * <p>
     * Clone the given TaggedValue object.
     * </p>
     *
     * @param taggedValue the TaggedValue object to clone.
     * @return the cloned TaggedValue object
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    private static TaggedValue clone(TaggedValue taggedValue) throws ActivityObjectCloneException {
        TaggedValue clonedTaggedValue = (TaggedValue) clone((ModelElement) taggedValue);

        // set the data value
        clonedTaggedValue.setDataValue(taggedValue.getDataValue());

        // set the tag type, no clone because the relationship is not a composite
        clonedTaggedValue.setType(taggedValue.getType());

        // set the model element, no clone because the relationship is not a composite
        clonedTaggedValue.setModelElement(taggedValue.getModelElement());

        // add all the reference values, no clone because the relationship is not a composite
        for (ModelElement element : taggedValue.getReferenceValues()) {
            clonedTaggedValue.addReferenceValue(element);
        }

        return clonedTaggedValue;
    }
}
