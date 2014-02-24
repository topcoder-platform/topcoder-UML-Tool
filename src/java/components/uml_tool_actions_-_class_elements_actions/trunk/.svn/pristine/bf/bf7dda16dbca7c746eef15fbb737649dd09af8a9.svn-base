/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.Interface;

/**
 * <p>
 * This class extends from RemoveAction and used for removing Interface instance
 * from model or namespace. Its methods provide only proper configuration and
 * presentation of action. All logic represent into its super class.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveInterfaceAction extends RemoveAction {

    /**
     * <p>
     * Represent human readable description of
     * action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Interface";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param interfaceElement
     *            Interface instance, null impossible
     * @throws IllegalArgumentException
     *             when interfaceElement is null
     */
    public RemoveInterfaceAction(Interface interfaceElement) {
        super(interfaceElement, new InterfaceUtil());
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