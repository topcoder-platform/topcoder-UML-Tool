/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;

/**
 * <p>A utility class for test purpose, only contains static methods.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {

    /**
     * <p>
     * Standard Element Name for documentation tag which is defined in
     * OMG UML Specification Version 1.5 formal/03-03-01.
     * </p>
     */
    public static final String DOCUMENTATION = "documentation";

    /**
     * <p>
     * Global options.
     * </p>
     */
    private static List < String > golbalOptions;

    /**
     * <p>
     * Options for <code>OperationImpl</code>.
     * </p>
     */
    private static List < String > operationOptions;

    /**
     * <p>
     * Options for <code>ClassImpl</code>.
     * </p>
     */
    private static List < String > classOptions;

    /**
     * <p>
     * Options for <code>ParameterImpl</code>.
     * </p>
     */
    private static List < String > parameterOptions;

    static {
        golbalOptions = new ArrayList < String >();
        operationOptions = new ArrayList < String >();
        classOptions = new ArrayList < String >();
        parameterOptions = new ArrayList < String >();

        golbalOptions.add("see");
        golbalOptions.add("since");
        golbalOptions.add("deprecated");

        operationOptions.addAll(golbalOptions);
        operationOptions.add("throws");
        operationOptions.add("exception");

        classOptions.addAll(golbalOptions);
        classOptions.add("author");
        classOptions.add("version");

        parameterOptions.addAll(golbalOptions);
    }
    /**
     * Empty constructor.
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Add configuration file into ConfigManager.
     * </p>
     *
     * @param file configuration file
     *
     * @throws Exception to JUnit
     */
    public static void addConfig(String file)
        throws Exception {

        ConfigManager cm = ConfigManager.getInstance();

        cm.add(file);
    }

    /**
     * <p>
     * Remove all namespaces from config manager.
     * </p>
     *
     * @throws ConfigManagerException to JUnit
     */
    public static void removeConfigManagerNS() throws ConfigManagerException {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();

        while (it.hasNext()) {
            cm.removeNamespace((String) it.next());
        }
    }
    /**
     * <p>
     * Get value of given <code>Field</code> of given <code>Object</code>.
     * </p>
     *
     * @param object instance to get field from
     * @param fieldName name of field
     *
     * @return value of field
     *
     * @throws Exception to JUnit
     */
    public static Object getField(Object object, String fieldName) throws Exception {
        Field f = object.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(object);
    }
    /**
     * <p>
     * Get <code>TaggedValue</code> whose <code>TagDefinition</code> is null.
     * </p>
     *
     * @return TaggedValue
     */
    public static TaggedValue getTaggedValueWithNullDefinition() {
        TaggedValue tv = new TaggedValueImpl();
        return tv;
    }
    /**
     * <p>
     * Get <code>TaggedValue</code> whose tag type is null.
     * </p>
     *
     * @return TaggedValue
     */
    public static TaggedValue getTaggedValueWithNullTagType() {
        TaggedValue tv = getTaggedValueWithNullDefinition();
        TagDefinition tg = new TagDefinitionImpl();
        tv.setType(tg);
        return tv;
    }
    /**
     * <p>
     * Get <code>TaggedValue</code> with desired tag type.
     * </p>
     *
     * @param tagType desired tag type.
     *
     * @return TaggedValue
     */
    public static TaggedValue getTaggedValueWithTagType(String tagType) {
        TaggedValue tv = getTaggedValueWithNullTagType();
        tv.getType().setTagType(tagType);
        return tv;
    }
    /**
     * <p>
     * Get global options.
     * </p>
     *
     * @return global options
     */
    public static List < String > getGlobalOptions() {
        return golbalOptions;
    }
    /**
     * <p>
     * Get global options for <code>OperationImpl</code>.
     * </p>
     *
     * @return options
     */
    public static List < String > getOperationOptions() {
        return operationOptions;
    }
    /**
     * <p>
     * Get options for <code>ClassImpl</code>.
     * </p>
     *
     * @return options
     */
    public static List < String > getClassOptions() {
        return classOptions;
    }
    /**
     * <p>
     * Get options for <code>ParameterImpl</code>.
     * </p>
     *
     * @return options
     */
    public static List < String > getParameterOptions() {
        return parameterOptions;
    }
}
