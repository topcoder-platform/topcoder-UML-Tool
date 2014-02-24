/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.modelmanager.UMLModelManager;


/**
 * <p>
 * This class extends from AddAction and used for adding Actor instance to model or namespace. Its methods provide only
 * proper configuration and presentation of action. All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class AddActorAction extends AddAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Actor";

    /**
     * <p>
     * Constructor which provide configuration for current action. It also response for setting correct namespace.
     * </p>
     *
     * @param actor Actor instance, should not be null.
     * @param manager UMLModelManager instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public AddActorAction(Actor actor, UMLModelManager manager) {
        super(actor, new ActorUtil(), manager, (manager == null) ? null : manager.getModel());
    }

    /**
     * <p>
     * Constructor which provides configuration for current action. It also response for setting correct namespace.
     * </p>
     *
     * @param actor Actor instance, should not be null.
     * @param manager UMLModelManager instance, should not be null.
     * @param namespace Namespace instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    public AddActorAction(Actor actor, UMLModelManager manager, Namespace namespace) {
        super(actor, new ActorUtil(), manager, namespace);
    }

    /**
     * <p>
     * Return presentationName attribute: the human readable description of action.
     * </p>
     *
     * @return "Add Actor" the presentationName attribute
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
