/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.relationships.Association;

/**
 * <p>
 * This class extends from CopyAction and used for copying Association instance
 * to clipboard. Its methods provide only proper configuration and presentation
 * of action. All logic represent into its super class.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CopyAssociationAction extends CopyAction {

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param association
     *            Association instance, null impossible
     * @throws IllegalArgumentException
     *             when association is null
     */
    public CopyAssociationAction(Association association) {
        super(association, new AssociationUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param association
     *            Association instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when association is null
     */
    public CopyAssociationAction(Association association, Clipboard clipboard) {
        super(association, new AssociationUtil(), clipboard);
    }
}