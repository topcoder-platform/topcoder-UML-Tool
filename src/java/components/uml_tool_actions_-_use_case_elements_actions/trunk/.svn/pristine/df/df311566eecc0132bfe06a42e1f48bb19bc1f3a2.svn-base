/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.modelmanager.UMLModelManager;


/**
 * <p>
 * This class extends from AddAction and used for adding Subsystem instance to model or namespace. Its methods provide
 * only proper configuration and presentation of action. All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class AddSubsystemAction extends AddAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Subsystem";

    /**
     * <p>
     * Constructor which provides configuration for current action. It also response for setting correct namespace.
     * </p>
     *
     * @param subsystem Subsystem instance, should not be null.
     * @param manager UMLModelManager instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public AddSubsystemAction(Subsystem subsystem, UMLModelManager manager) {
        super(subsystem, new SubsystemUtil(), manager, (manager == null) ? null : manager.getModel());
    }

    /**
     * <p>
     * Constructor which provides configuration for current action. It also response for setting correct namespace.
     * </p>
     *
     * @param subsystem Subsystem instance, should not be null.
     * @param manager UMLModelManager instance, should not be null.
     * @param namespace Namespace instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public AddSubsystemAction(Subsystem subsystem, UMLModelManager manager, Namespace namespace) {
        super(subsystem, new SubsystemUtil(), manager, namespace);
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Add Subsystem" - the presentationName attribute
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
