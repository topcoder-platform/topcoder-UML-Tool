/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Helper class contains static methods for this package methods to check the arguments. It also contains some
 * common methods add or remove <code>ActivityGraph</code> and <code>Diagram</code> to <code>UMLModelManager</code>
 * instance.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b>
 * This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class Helper {
    /**
     * <p>
     * Represents the <code>UMLModelManager</code> instance used to add or remove <code>ActivityGraph</code> and
     * <code>Diagram</code>.
     * </p>
     */
    private static final UMLModelManager UMLMODELMANAGER = UMLModelManager.getInstance();

    /**
     * <p>
     * String representing the untitled name.
     * </p>
     */
    private static final String UNTITLED_NAME = "untitled";

    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private Helper() {
        // do nothing.
    }

    /**
     * <p>
     * Checks whether the given object is not null.
     * </p>
     *
     * @param obj the argument object to check
     * @param name the argument name. Used to give a meaningful error message.
     *
     * @throws IllegalArgumentException If the given object is null
     */
    static void checkNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException("[ " + name + " ] should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given string is not null and not empty.
     * </p>
     *
     * @param str the string to check
     * @param name the argument name. Used to give a meaningful error message.
     *
     * @throws IllegalArgumentException If the given string is null or empty.
     */
    static void checkString(String str, String name) {
        checkNotNull(str, name);
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("[ " + name + " ] should not be empty.");
        }
    }

    /**
     * <p>
     * Checks whether the diagram is not null and return its name.
     * </p>
     *
     * <p>
     * The name of the diagram will be return if the name is not null, otherwise a "untitled" string will be returned.
     * </p>
     *
     * @param diagram the Diagram instance to check
     *
     * @return the name of the diagram if the name is not null or a "untitled" string if the name is null.
     *
     * @throws IllegalArgumentException if diagram is null
     */
    static String checkAndGetDiagramName(Diagram diagram) {
        Helper.checkNotNull(diagram, "Diagram");
        return validateName(diagram.getName());
    }

    /**
     * <p>
     * Adds the Diagram instance to the <code>UMLModelManager</code>.
     * </p>
     *
     * @param diagram the Diagram instance to add
     */
    static void addDiagramToUMLModelManager(Diagram diagram) {
        UMLMODELMANAGER.addDiagram(diagram);
    }

    /**
     * <p>
     * Remove the Diagram instance from the <code>UMLModelManager</code>.
     * </p>
     *
     * @param diagram the Diagram instance to remove
     */
    static void removeDiagramFromUMLModelManager(Diagram diagram) {
        UMLMODELMANAGER.removeDiagram(diagram);
    }

    /**
     * <p>
     * Adds the ActivityGraph instance to the <code>UMLModelManager</code>.
     * </p>
     *
     * @param activityGraph the ActivityGraph instance to add
     */
    static void addActivityGraphToUMLModelManager(ActivityGraph activityGraph) {
        UMLMODELMANAGER.addActivityGraph(activityGraph);
    }

    /**
     * <p>
     * Remove the ActivityGraph instance from the <code>UMLModelManager</code>.
     * </p>
     *
     * @param activityGraph the ActivityGraph instance to remove
     */
    static void removeActivityGraphFromUMLModelManager(ActivityGraph activityGraph) {
        UMLMODELMANAGER.removeActivityGraph(activityGraph);
    }

    /**
     * <p>
     * Validates the name string. If the name is null, a 'untitled' string will be returned, otherwise the original
     * name string will be returned.
     * </p>
     *
     * @param name the name string to validate
     *
     * @return the original name string if name is not null or "untitled" string if name is null.
     */
    static String validateName(String name) {
        if (name == null) {
            return UNTITLED_NAME;
        }
        return name;
    }
}
