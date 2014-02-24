/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.modelmanager;

import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Mock class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class UMLModelManager {

    /**
     * <p>
     * Represents the instance name to be used for the singleton instance.
     * </p>
     */
    public static final String DEFAULT_INSTANCE_NAME = "Default";

    /**
     * <p>
     * Represents the name of this instance. Initialized in one of the
     * constructors and never changed afterwards. Can be retrieved by public
     * getInstanceName() method.
     * </p>
     */
    private final String instanceName;

    /**
     * <p>
     * Represents the project language. Initial it is set to null. Can be set in
     * the appropriate constructor (UMLModelManager(String, String,
     * ProjectConfigurationManager)) or by public setProjectLanguage(..) method
     * and retrieved by public getProjectLanguage() method. It is mutable.
     * </p>
     */
    private String projectLanguage = null;

    /**
     * <p>
     * Represents the static field used to keep an instance of this class:
     * UMLModelManager. Used from public static getInstance() method.
     * </p>
     */
    private static final UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * <p>
     * Represents the model instance. Initialized in one of the constructors
     * with default <em>new ModelImpl()</em> and never changed afterwards. Can
     * be retrieved by public getModel() method.
     * </p>
     */
    private final com.topcoder.uml.model.modelmanagement.Model model;

    /**
     * <p>
     * Represents the projectConfigurationManager instance. Initial is set to
     * null. Initialized in one of the constructors UMLModelManager(String,
     * ProjectConfigurationManager), UMLModelManager(String,
     * ProjectConfigurationManager, String) and never changed afterwards; can be
     * retrieved by public getProjectConfigurationManager() method.
     * </p>
     */
    private com.topcoder.uml.projectconfiguration.ProjectConfigurationManager projectConfigurationManager = null;

    /**
     * <p>
     * Default constructor. Initialize the model field with default empty
     * ModelImpl and instanceName field with default value
     * DEFAULT_INSTANCE_NAME.
     * </p>
     */
    public UMLModelManager() {
        this.model = new ModelImpl();
        this.instanceName = DEFAULT_INSTANCE_NAME;
    }

    /**
     * <p>
     * Constructor. Initialize the model field with default empty ModelImpl and
     * instanceName field with the given value (not null and not empty).
     * </p>
     *
     * @param instanceName
     *            the new instance name to use
     * @throws IllegalArgumentException
     *             if instanceName is null or empty
     */
    public UMLModelManager(String instanceName) {
        // your code here
        this.model = new ModelImpl();
        this.instanceName = instanceName;
    }

    /**
     * <p>
     * Simply returns the model field. Not null.
     * </p>
     *
     * @return the Model instance
     */
    public com.topcoder.uml.model.modelmanagement.Model getModel() {
        return this.model;
    }

    /**
     * <p>
     * Simply return the projectConfigurationManager field. If it was not set
     * (if it is null) throw a IllegalStateException.
     * </p>
     *
     * @return the ProjectConfigurationManager instance
     * @throws IllegalStateException
     *             if the projectConfigurationManager was not set yet
     */
    public com.topcoder.uml.projectconfiguration.ProjectConfigurationManager getProjectConfigurationManager() {
        return new ProjectConfigurationManager();
    }

    /**
     * <p>
     * Simply return the projectLanguage field. Possible null but can not be
     * empty string.
     * </p>
     *
     * @return the projectLanguage field
     */
    public String getProjectLanguage() {
        return this.projectLanguage;
    }
}
