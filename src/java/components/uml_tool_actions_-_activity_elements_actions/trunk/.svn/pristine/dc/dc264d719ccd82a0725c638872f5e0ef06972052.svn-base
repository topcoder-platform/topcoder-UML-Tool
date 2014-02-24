/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.io.File;

import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {
    /**
     * <p>
     * Represents the namespace for Logging Wrapper component.
     * </p>
     */
    public static final String LOG_NAMESPACE = "com.topcoder.util.log";

    /**
     * <p>
     * Represents the path of config file for Logging Wrapper component.
     * </P>
     */
    public static final String LOG_CONFIGFILE = "test_files/Logging.xml";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Set up the ProjectConfiguration class runtime environment.
     * </P>
     *
     * @throws Exception to JUnit
     */
    public static void configProjectConfiguration() throws Exception {
        loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
        loadSingleXMLConfig(ProjectConfigurationManager.class.getName(), "test_files/config.xml");
        loadSingleXMLConfig(ProjectConfigurationManager.class.getName() + ".objectfactory",
            "test_files/objectfactory.xml");
    }

    /**
     * <p>
     * Clear the ProjectConfiguration class runtime environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public static void clearProjectConfiguration() throws Exception {
        clearConfigFile(ProjectConfigurationManager.class.getName());
        clearConfigFile(ProjectConfigurationManager.class.getName() + ".objectfactory");
        clearConfigFile(TestHelper.LOG_NAMESPACE);
    }

    /**
     * <p>
     * Create a tag value with the given type and data value. It is used to
     * add a taggedValue to a state.
     * </P>
     *
     * @param type the tagDefinition type
     * @param dataValue the tag value
     * @return a taggedValue with the given type and value
     */
    public static TaggedValue createTaggedValue(String type, String dataValue) {
        TaggedValue taggedValue = new TaggedValueImpl();
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(type);
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(dataValue);

        return taggedValue;
    }

    /**
     * <P>
     * set a ProjectConfigurationManager instance to the UMLModelManager.
     * </p>
     *
     * @return the manager which have set up the projectConfiguration manager
     *
     * @throws Exception to JUnit
     */
    public static UMLModelManager setUpModelManager() throws Exception {
        UMLModelManager manager = new UMLModelManager();
        ProjectConfigurationManager configManager = new ProjectConfigurationManager(manager);
        configManager.addInitialElementFormatter(configManager.getDefaultProjectLanguage(),
            new MockInitialElementFormatter());
        manager.setProjectConfigurationManager(configManager);
        manager.setProjectLanguage("Java");
        return manager;
    }

    /**
     * <p>
     * Use the given file to config the given namespace the format of the config file is
     * ConfigManager.CONFIG_XML_FORMAT.
     * </p>
     *
     * @param namespace use the namespace to load config information to ConfigManager
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadSingleXMLConfig(String namespace, String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        //config namespace
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }

        config.add(namespace, file.getCanonicalPath(), ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * <p>
     * Remove the given namespace in the ConfigManager.
     * </p>
     *
     * @param namespace namespace use to remove the config information in ConfigManager
     *
     * @throws Exception when any exception occurs
     */
    public static void clearConfigFile(String namespace) throws Exception {
        ConfigManager config = ConfigManager.getInstance();

        //clear the environment
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }
    }
}
