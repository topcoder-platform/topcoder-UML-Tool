/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * Helper.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.configuration.ConfigurationAccessException;
import com.topcoder.configuration.ConfigurationObject;


/**
 * <p>
 * This class is used by this component only. Provide some common utility methods.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong> This class is thread-safe.
 * </p>
 *
 * @author morehappiness, TCSDEVELOPER
 * @version 1.0
 */
final class Helper {
/**
     * <p>Private constructor.</p>
     */
    private Helper() {
    }

    /**
     * <p>Get integer configuration field value.</p>
     *
     * @param config the configuration object
     * @param filedName the field name
     * @param required indicate this field is required or not
     * @param defaultValue the default value when the field is missing
     *
     * @return the field value
     *
     * @throws HTMLDocumentationEditorException if error occurs while getting property value
     */
    static int getPropInt(ConfigurationObject config, String filedName, boolean required, int defaultValue)
        throws HTMLDocumentationEditorException {
        try {
            Object value = config.getPropertyValue(filedName);

            if (value == null || (value.toString().trim().length() == 0)) {
                if (required) {
                    throw new HTMLDocumentationEditorException("Filed '" + filedName + "' is missing.");
                } else {
                    return defaultValue;
                }
            } else {
                try {
                    return Integer.valueOf(value.toString().trim());
                } catch (NumberFormatException e) {
                    throw new HTMLDocumentationEditorException("Filed '" + filedName + "' value is not an integer.");
                }
            }
        } catch (ConfigurationAccessException e) {
            throw new HTMLDocumentationEditorException("Error occurs while accessing configuration.", e);
        }
    }

    /**
     * <p>Get string configuration field value.</p>
     *
     * @param config the configuration object
     * @param filedName the field name
     * @param required indicate this field is required or not
     * @param defaultValue the default value when the field is missing
     *
     * @return the field value
     *
     * @throws HTMLDocumentationEditorException if error occurs while getting property value
     */
    static String getPropString(ConfigurationObject config, String filedName, boolean required, String defaultValue)
        throws HTMLDocumentationEditorException {
        try {
            Object value = config.getPropertyValue(filedName);

            if (value == null || (value.toString().trim().length() == 0)) {
                if (required) {
                    throw new HTMLDocumentationEditorException("Filed '" + filedName + "' is missing.");
                } else {
                    return defaultValue;
                }
            } else {
                return value.toString().trim();
            }
        } catch (ConfigurationAccessException e) {
            throw new HTMLDocumentationEditorException("Error occurs while accessing configuration.", e);
        }
    }

    /**
     * <p>Get configuration object field value.</p>
     *
     * @param config the configuration object
     * @param fieldName the field name
     *
     * @return the configuration object
     *
     * @throws HTMLDocumentationEditorException if error occurs while getting property value
     */
    static ConfigurationObject getPropConfigObject(ConfigurationObject config, String fieldName)
        throws HTMLDocumentationEditorException {
        try {
            ConfigurationObject configObject = config.getChild(fieldName);

            if (configObject == null) {
                throw new HTMLDocumentationEditorException("'" + fieldName + "' value should not be null.");
            }

            return configObject;
        } catch (ConfigurationAccessException e) {
            throw new HTMLDocumentationEditorException("Error occurs while accessing configuration.", e);
        }
    }
}
