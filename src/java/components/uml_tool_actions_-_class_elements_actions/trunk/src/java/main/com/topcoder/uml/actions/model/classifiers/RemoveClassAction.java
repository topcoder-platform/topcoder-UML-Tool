/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

/**
 * <p>
 * This c1ass extends from ClassAction and provide functionality to remove Class
 * instance from model or namespace. Also it has ability to use redo and undo of
 * removing.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveClassAction extends RemoveAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Class";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param classElement
     *            Class instance, null impossible
     * @throws IllegalArgumentException
     *             when classElement is null
     */
    public RemoveClassAction(com.topcoder.uml.model.core.classifiers.Class classElement) {
        super(classElement, new ClassUtil());
    }

    /**
     * <p>
     * Return PRESENTATION_NAME attribute - human readable description of
     * action.
     * </p>
     *
     * @return PRESENTATION_NAME attribute
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}