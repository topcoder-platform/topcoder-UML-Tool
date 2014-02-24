/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * <p>
 * This class extends from CutAction and used for cutting (copy + remove)
 * Generalization instance from model or namespace to clipboard. Its methods
 * provide only proper configuration and presentation of action. All logic
 * represent into its super class.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CutGeneralizationAction extends CutAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Generalization";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param generalization
     *            Generalization instance, null impossible
     * @throws IllegalArgumentException
     *             when generalization is null
     */
    public CutGeneralizationAction(Generalization generalization) {
        super(generalization, new GeneralizationUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param generalization
     *            Generalization instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when generalization is null
     */
    public CutGeneralizationAction(Generalization generalization, Clipboard clipboard) {
        super(generalization, new GeneralizationUtil(), clipboard);
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