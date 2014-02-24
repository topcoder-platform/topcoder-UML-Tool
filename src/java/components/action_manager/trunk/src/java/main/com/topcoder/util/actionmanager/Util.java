/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.topcoder.util.log.Log;
import com.topcoder.util.log.Level;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Helper class for the Action Manager Component.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
final class Util {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Util() {
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     *
     * @param arg the argument to check
     * @param name the name of the argument to check
     *
     * @throws IllegalArgumentException if the given Object is null
     */
    static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given String is null or empty.
     * Here empty means the length of the given string is zero after trimmed.
     * </p>
     *
     * @param arg the String to check
     * @param name the name of the String argument to check
     *
     * @throws IllegalArgumentException if the given string is null or empty
     */
    static void checkString(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    /**
     * <p>
     * Return the value of the property.
     * </p>
     *
     * @param namespace the namespace to get
     * @param propertyName the name of property
     * @param required whether this property is required
     *
     * @return the value of the property
     *
     * @throws ActionManagerConfigurationException if fail to load the config values
     */
    static String getString(String namespace, String propertyName, boolean required)
        throws ActionManagerConfigurationException {
        try {
            String property = ConfigManager.getInstance().getString(namespace, propertyName);

            // Empty property value is not allowed
            if ((property != null) && (property.trim().length() == 0)) {
                throw new ActionManagerConfigurationException("Property " + propertyName + " is empty.");
            }

            // This property is missed
            if (required && (property == null)) {
                throw new ActionManagerConfigurationException("Property " + propertyName + " is missing.");
            }

            return property;
        } catch (UnknownNamespaceException e) {
            throw new ActionManagerConfigurationException(
                "UnknownNamespaceException occurs when accessing ConfigManager.", e);
        }
    }

    /**
     * <p>
     * Logs the information about the given exception in ERROR Level.
     * </p>
     *
     * <p>
     * The error message and the track information are logged.
     * </p>
     *
     * <p>
     * Note, if the logger is null or loggingLevel is OFF then no log is needed.
     * </p>
     *
     * @param logger the instance of Log to be used for performing the Logging
     * @param loggingLevel the level of the logging to be performed
     * @param e the exception to be logged
     */
    static void logErrorMsg(Log logger, Level loggingLevel, Exception e) {
        Util.checkNull(e, "e");

        if (logger == null || loggingLevel == Level.OFF) {
            return;
        }

        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        logger.log(Level.ERROR, "Track Information : \n" + sw.toString());
    }

    /**
     * <p>
     * Logs the given message about the given exception in WARN Level.
     * </p>
     *
     * <p>
     * Note, if the logger is null or loggingLevel is OFF then no log is needed.
     * If the loggingLevel is ERROR, then no log is needed.
     * </p>
     *
     * @param logger the instance of Log to be used for performing the Logging
     * @param loggingLevel the level of the logging to be performed
     * @param msg the message to be logged
     */
    static void logWarnMsg(Log logger, Level loggingLevel, String msg) {
        if (logger == null || loggingLevel == Level.OFF || loggingLevel == Level.ERROR) {
            return;
        }

        logger.log(Level.WARN, msg);
    }

    /**
     * <p>
     * Logs the given message about the given exception in INFO Level.
     * </p>
     *
     * <p>
     * Note, if the logger is null or loggingLevel is OFF then no log is needed.
     * If the loggingLevel is ERROR or WARN, then no log is needed.
     * </p>
     *
     * @param logger the instance of Log to be used for performing the Logging
     * @param loggingLevel the level of the logging to be performed
     * @param msg the message to be logged
     */
    static void logInfoMsg(Log logger, Level loggingLevel, String msg) {
        if (logger == null || loggingLevel == Level.OFF || loggingLevel == Level.ERROR || loggingLevel == Level.WARN) {
            return;
        }

        logger.log(Level.INFO, msg);
    }

    /**
     * <p>
     * Logs the given message about the given exception in DEBUG Level.
     * </p>
     *
     * <p>
     * Note, if the logger is null or loggingLevel is OFF then no log is needed.
     * If the loggingLevel is ERROR or WARN or INFO, then no log is needed.
     * </p>
     *
     * @param logger the instance of Log to be used for performing the Logging
     * @param loggingLevel the level of the logging to be performed
     * @param msg the message to be logged
     */
    static void logDebugMsg(Log logger, Level loggingLevel, String msg) {
        if (logger == null || loggingLevel == Level.OFF || loggingLevel == Level.ERROR || loggingLevel == Level.WARN
            || loggingLevel == Level.INFO) {
            return;
        }

        logger.log(Level.DEBUG, msg);
    }
}
