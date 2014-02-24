/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.core.Namespace;

/**
 * <p>
 * This class extends from PasteAction and used for adding Enumeration instance
 * to model or namespace from clipboard. Its methods provide only proper
 * configuration and presentation of action. All logic represent into its super
 * class.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class PasteEnumerationAction extends PasteAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Enumeration";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param transferable
     *            Transfarable instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws InvalidDataContentException
     *             if requested data flavor is not supported
     * @throws IllegalArgumentException
     *             when transferable or namespace is null
     */
    public PasteEnumerationAction(Transferable transferable, Namespace namespace) throws InvalidDataContentException {
        super(transferable, ClassElementsTransfer.ENUMERATION_FLAVOR, new EnumerationUtil(), namespace);
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