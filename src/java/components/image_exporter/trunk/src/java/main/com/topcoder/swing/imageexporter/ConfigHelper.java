/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;


/**
 * <p>Helper class used to process component configuration.</p>
 * <p>Thread-Safety: This class is thread safe since it's not mutable.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class ConfigHelper {
    /**
     * Private constructor preventing this class from being instantiated.
     */
    private ConfigHelper() {
        //does nothing
    }

    /**
     * Create ObjectFactory instance according to the config.
     *
     * @param namespace namespace of the config
     * @param propertyName property to read the namespace for ObjectFactory
     *
     * @return ObjectFactory the ObjectFactory instance created
     *
     * @throws ImageExporterConfigurationException property is missing or failed to create the instance
     */
    public static ObjectFactory createObjectFactory(String namespace, String propertyName)
        throws ImageExporterConfigurationException {
        String objectFactoryNamespace = ConfigHelper.getStringProperty(namespace, propertyName);

        //not null and not trimmed empty for this property
        if ((objectFactoryNamespace == null) || (objectFactoryNamespace.trim().length() == 0)) {
            throw new ImageExporterConfigurationException("property:" + propertyName + " in namespace:" + namespace
                    + " does not exist");
        }

        ObjectFactory objectFactory;

        try {
            objectFactory = new ObjectFactory(new ConfigManagerSpecificationFactory(objectFactoryNamespace));
        } catch (SpecificationConfigurationException e) {
            throw new ImageExporterConfigurationException("error occurred while creating ObjectFactory:"
                    + objectFactoryNamespace, e);
        } catch (IllegalReferenceException e) {
            throw new ImageExporterConfigurationException("error occurred while creating ObjectFactory:"
                    + objectFactoryNamespace, e);
        }

        return objectFactory;
    }

    /**
     * Read string array property value from given namespace.
     *
     * @param namespace namespace of the property
     * @param propertyName name of the property
     *
     * @return value of the string array property, not empty. If the property is missing, null will be returned
     *
     * @throws ImageExporterConfigurationException if property is missing
     */
    public static String[] getArrayProperty(String namespace, String propertyName)
        throws ImageExporterConfigurationException {
        String[] result;

        try {
            result = ConfigManager.getInstance().getStringArray(namespace, propertyName);
        } catch (UnknownNamespaceException e) {
            throw new ImageExporterConfigurationException("namespace:" + namespace + " is not found", e);
        }

        return result;
    }

    /**
     * Read string property value from given namespace.
     *
     * @param namespace namespace of the property
     * @param propertyName name of the property
     *
     * @return value the string value of this property, if the property is missing, null will be returned.
     *
     * @throws ImageExporterConfigurationException if the property is missing
     */
    public static String getStringProperty(String namespace, String propertyName)
        throws ImageExporterConfigurationException {
        String value;

        try {
            value = ConfigManager.getInstance().getString(namespace, propertyName);
        } catch (UnknownNamespaceException e) {
            throw new ImageExporterConfigurationException("namespace:" + namespace + " is not found", e);
        }

        return value;
    }
}
