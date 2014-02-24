/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.io.File;
import java.util.Iterator;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

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
     * The default namespace for this component.
     * </p>
     */
    public static final String NAMESPACE = "com.topcoder.gui.panels.properties";

    /**
     * <p>
     * The sample configuration file for this component.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files" + File.separator + "config.xml";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
        // empty
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
     * @throws UnknownNamespaceException if the namespace is unknown
     */
    public static void clearConfigFile(String namespace) throws UnknownNamespaceException {
        ConfigManager config = ConfigManager.getInstance();

        //clear the environment
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }
    }

    /**
     * <p>
     * Clears all the namespaces from the configuration manager.
     * </p>
     *
     * @throws UnknownNamespaceException to JUnit.
     */
    public static void clearConfig() throws UnknownNamespaceException {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }

    /**
     * <p>
     * Uses the given file to config the configuration manager.
     * </p>
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadXMLConfig(String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        config.add(file.getCanonicalPath());
    }

    /**
     * <p>
     * Loads all the normal configuration files for this component.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public static void loadConfigurations() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, CONFIG_FILE);
        TestHelper.loadXMLConfig("test_files" + File.separator + "uml_model.xml");
        TestHelper.loadXMLConfig("test_files" + File.separator + "sampleJavaFile.xml");
    }

    /**
     * <p>
     * This method creates a <code>UMLModelManager</code> instance for testing purpose.
     * </p>
     *
     * @return the <code>UMLModelManager</code> instance for testing purpose.
     *
     * @throws Exception to JUnit
     */
    public static UMLModelManager createUMLModelManager() throws Exception {
        UMLModelManager manager = UMLModelManager.getInstance();

        Model root = manager.getModel();
        root.setName("ModelDemo");

        Namespace ns = new PackageImpl();
        ns.setName("com.topcoder.util");
        root.addOwnedElement(ns);

        Class type = new ClassImpl();
        type.setName("TCUMLClass");
        type.setNamespace(ns);
        ns.addOwnedElement(type);

        ProjectConfigurationManager configManager = new ProjectConfigurationManager(manager);

        manager.setProjectConfigurationManager(configManager);
        manager.setProjectLanguage("Java");

        return manager;
    }
}
