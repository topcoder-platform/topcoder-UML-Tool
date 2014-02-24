/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;

import java.awt.datatransfer.Transferable;


/**
 * <p>
 * This class extends from PasteAction and used for adding Actor instance to model or namespace from  clipboard. Its
 * methods provide only proper configuration and presentation of action. All logic  represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class PasteActorAction extends PasteAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Actor";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param transferable Transferable instance, should not be null.
     * @param namespace Namespace instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     * @throws InvalidDataContentException when transferable contain incorrect data flavor
     */
    public PasteActorAction(Transferable transferable, Namespace namespace)
        throws InvalidDataContentException {
        super(transferable, ModelTransfer.ACTOR_FLAVOR, new ActorUtil(), namespace);
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Paste Actor" - the presentationName attribute
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
