/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.AWTError;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.Collection;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Helper class for the Activity Elements Actions component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class Util {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Util() {
        // empty
    }

    /**
     * <p>
     * Check whether the given Object is null.
     * </p>
     *
     * @param arg the argument to check
     * @param name the name of the argument to check
     *
     * @throws IllegalArgumentException if the given Object is null
     */
    static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Check whether the given String is null or empty.
     * </p>
     *
     * @param arg the String to check
     * @param name the name of the String argument to check
     *
     * @throws IllegalArgumentException if the given string is null or empty
     */
    static void checkString(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    /**
     * <p>
     * Return true if the given model element has the tagged value whose tag type and data value
     * are the specified type and value, otherwise false.
     * </p>
     *
     * @param element the model element to check its tagged values
     * @param type the tag type
     * @param value the data value for the tagged value
     *
     * @return true if the given model element has the tagged value whose tag type and data value
     * are the specified type and value, otherwise false
     */
    static boolean checkTagDefinition(ModelElement element, String type, String value) {
        Collection<TaggedValue> taggedValues = element.getTaggedValues();
        for (TaggedValue taggedValue : taggedValues) {
            TagDefinition tagDef = taggedValue.getType();
            if (tagDef != null && type.equals(tagDef.getTagType()) && value.equals(taggedValue.getDataValue())) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>
     * Check the kind of the state is the given kind.
     * </p>
     *
     * @param state the Pseudostate instance to check its kind
     * @param kind the expected Pseudostate kind
     *
     * @throws IllegalArgumentException if the kind of the state is not the given kind
     */
    static void checkPseudostateKind(Pseudostate state, PseudostateKind kind) {
        if (!(kind == state.getKind())) {
            throw new IllegalArgumentException("The state kind attribute doesn't equal to " + kind + ".");
        }
    }

    /**
     * <p>
     * Format the model element with the default project language.
     * </p>
     *
     * @param manager the given manager to get its project configuration manager
     * @param element the model element for formatting
     *
     * @throws IllegalArgumentException if fails to apply the initial formatting
     */
    static void applyInitialFormatting(UMLModelManager manager, ModelElement element) {
        try {
            ProjectConfigurationManager configurationManager = manager.getProjectConfigurationManager();
            configurationManager.applyInitialFormatting(manager.getProjectLanguage(), element);
        } catch (IllegalStateException ise) {
            throw new IllegalArgumentException("IllegalStateException occurs while getting the "
                + "ProjectConfigurationManager instance from UMLModelManager.", ise);
        } catch (ProjectConfigurationException e) {
            throw new IllegalArgumentException("ProjectConfigurationException occurs while applying the "
                + "initial formatting or getting the default project language.", e);
        }
    }

    /**
     * <p>
     * Return the system default clipboard.
     * </p>
     *
     * @return the system clipboard
     *
     * @throws IllegalArgumentException when AWTError or HeadlessException occurs when getting the
     * system default clipboard
     */
    static Clipboard getSystemClipboard() {
        try {
            return Toolkit.getDefaultToolkit().getSystemClipboard();
        } catch (AWTError error) {
            throw new IllegalArgumentException("AWTError occurs while getting the default tool kit.", error);
        } catch (HeadlessException e) {
            throw new IllegalArgumentException("HeadlessException occurs while getting the system clipboard.", e);
        }
    }

    /**
     * <p>
     * Return the top for activity graph, it must be CompositeState type.
     * </p>
     *
     * @param activityGraph the activity graph to get the top
     * @return the top for activity graph
     *
     * @throws ActionExecutionException if the top of the activity is not set
     * or the type of the top property is not CompositeState
     */
    static CompositeState getTop(ActivityGraph activityGraph) throws ActionExecutionException {
        State topState = activityGraph.getTop();

        // null top property
        if (topState == null) {
            throw new ActionExecutionException("The top for the activity graph should not be null.");
        }

        // not CompositeState type
        if (!(topState instanceof CompositeState)) {
            throw new ActionExecutionException(
                "The top for the activity graph should be of CompositeState type instead of "
                    + topState.getClass().getName());
        }

        return (CompositeState) topState;
    }

    /**
     * <p>
     * Check the given object is the expect class type or not.
     * </p>
     *
     * @param content the object to check its class type
     * @param type the expected class type
     */
    static void checkClassType(Object content, Class<?> type) {
        if (!(type.isAssignableFrom(content.getClass()))) {
            throw new IllegalArgumentException("The parameter named [content] is not of StateVertex type, it is "
                + content.getClass().getName());
        }
    }
}
