/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Actor;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from CutAction and used for cutting (copy + remove) Actor instance from model or namespace to
 * clipboard. Its methods provide only proper configuration and presentation of action. All logic represent into its
 * super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CutActorAction extends CutAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Actor";

    /**
     * <p>
     * Constructor which provides configuration for current action and set actor attribute. And also use parameter
     * manager to initialize ActorUtil.
     * </p>
     *
     * @param actor Actor instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public CutActorAction(Actor actor) {
        super(actor, new ActorUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action and sets actor and clipboard attributes. And also use
     * parameter manager to initialize ActorUtil.
     * </p>
     *
     * @param actor Actor instance, should not be null.
     * @param clipboard Clipboard instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public CutActorAction(Actor actor, Clipboard clipboard) {
        super(actor, new ActorUtil(), clipboard);
        Helper.checkNull("clipboard", clipboard);
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Cut Actor" - the presentationName attribute.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
