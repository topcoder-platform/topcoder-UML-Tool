/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Actor;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from CopyAction and used for copying Actor instance to clipboard. Its methods provide only proper
 * configuration and presentation of action. All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CopyActorAction extends CopyAction {
    /**
     * <p>
     * constructor which provides configuration for current action. And also use parameter manager to initialize
     * ActorUtil.
     * </p>
     *
     * @param actor Actor instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public CopyActorAction(Actor actor) {
        super(actor, new ActorUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action. And also use parameter manager to initialize
     * ActorUtil.
     * </p>
     *
     * @param actor Actor instance, should not be null.
     * @param clipboard Clipboard instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public CopyActorAction(Actor actor, Clipboard clipboard) {
        super(actor, new ActorUtil(), clipboard);
        Helper.checkNull("clipboard", clipboard);
    }
}
