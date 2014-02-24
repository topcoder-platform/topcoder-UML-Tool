/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Actor;


/**
 * <p>
 * This class extends from RemoveAction and used for removing Actor instance from model or namespace. Its methods
 * provide only proper configuration and presentation of action. All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveActorAction extends RemoveAction {
    /**
     * <p>
     * Represent Actor instance for current action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Actor";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param actor Actor instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public RemoveActorAction(Actor actor) {
        super(actor, new ActorUtil());
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Remove Actor" - the presentationName attribute.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
