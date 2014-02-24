/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.stresstests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * Helper class of Stress Test.
 *
 * @author yinzi
 * @version 1.0
 */
public class StressTestsHelper {

    /**
     * The general namespace used by the component tested.
     */
    public static final String NAMESPACE = "com.topcoder.uml.stubclassgenerator";

    /**
     * The config file for Stub Class Generator component.
     */
    public static final String CONFIGPATH = "stresstests\\generator.xml";

    /**
     * The namespace for Logging Wrapper component.
     */
    public static final String LOG_NAMESPACE = "com.topcoder.util.log";

    /**
     * The config file for Logging Wrapper component.
     */
    public static final String LOG_CONFIGPATH = "stresstests\\logging.xml";

    /**
     * Private constructor.
     */
    private StressTestsHelper() {
        // do nothing.
    }

    /**
     * Load config files.
     * @exception Exception when an
     */
    public static void loadConfig() throws Exception {
        ConfigManager.getInstance().add(LOG_NAMESPACE, LOG_CONFIGPATH, ConfigManager.CONFIG_XML_FORMAT);
        ConfigManager.getInstance().add(NAMESPACE, CONFIGPATH, ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * Removes all the loaded configuration from Configuration Manager.
     *
     * @throws Exception any error occur when delete generated files
     */
    public static void tearDownTest() throws Exception {
        Iterator iter = ConfigManager.getInstance().getAllNamespaces();
        while (iter.hasNext()) {
            ConfigManager.getInstance().removeNamespace(iter.next().toString());
        }

        if (ConfigManager.getInstance().existsNamespace(LOG_NAMESPACE)) {
            ConfigManager.getInstance().removeNamespace(LOG_NAMESPACE);
        }

        if (ConfigManager.getInstance().existsNamespace(NAMESPACE)) {
            ConfigManager.getInstance().removeNamespace(NAMESPACE);
        }

        File file = new File("test_files/com/google");
        file.delete();
        file = new File("test_files/com/topcoder");
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                f.delete();
            }
        }
    }

    /**
     * Creates a documentation TaggedValue.
     *
     * @param documentation the documentation text
     * @return a documentation TaggedValue
     */
    public static TaggedValue createDocumentationTaggedValue(String documentation) {
        return createTaggedValue("documentation", documentation);
    }

    /**
     * Creates a tagged documentation TaggedValue.
     *
     * @param tag the documentation's tag
     * @param documentation the documentation text
     * @return a tagged documentation TaggedValue
     */
    public static TaggedValue createTagDocumentationTaggedValue(String tag, String documentation) {
        return createTaggedValue("documentation#" + tag, documentation);
    }

    /**
     * Creates a TaggedValue of the given type and dataValue.
     *
     * @param type the type of the TaggedValue
     * @param dataValue the dataValue of the TaggedValue
     * @return a TaggedValue of the given type and dataValue
     */
    public static TaggedValue createTaggedValue(String type, String dataValue) {
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(type);

        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(dataValue);

        return taggedValue;
    }

    /**
     * Adds the given ModelElement to the namespace.
     *
     * @param element the element to be added
     * @param namespace the namespace target
     */
    public static void addModelElementToNamespace(ModelElement element, Namespace namespace) {
        element.setNamespace(namespace);
        namespace.addOwnedElement(element);
    }

    /**
     * Adds the given Classifier to a specific Package. The specific Package is
     * 'com.topcoder.uml.stubclassgenerator'.
     *
     * @param classifier classifier to add
     */
    public static void addClassifierToPackage(Classifier classifier) {
        Model model = new ModelImpl();

        Package pkg1 = new PackageImpl();
        pkg1.setName(NAMESPACE);
        addModelElementToNamespace(pkg1, model);

        addModelElementToNamespace(classifier, pkg1);
    }

    /**
     * Generates a class; used to test CodeGenerator.
     *
     * @return generated class for tests
     */
    public static Class generateClass() {
        Class classifier = new ClassImpl();
        classifier.setName("TestClass");
        addClassifierToPackage(classifier);
        classifier.addTaggedValue(createDocumentationTaggedValue("TestClass class doc."));
        classifier.setVisibility(VisibilityKind.PUBLIC);
        return classifier;
    }

    /**
     * Print the code file to the console.
     *
     * @param file code file to print out
     */
    public static void printFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            int ch = reader.read();
            while (ch != -1) {
                System.out.print((char) ch);
                ch = reader.read();
            }
        } catch (IOException e) {
            // ignore
        }
        System.out.print(System.getProperty("line.separator"));
    }
}