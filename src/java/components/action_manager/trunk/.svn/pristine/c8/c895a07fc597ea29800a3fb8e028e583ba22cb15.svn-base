/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.accuracytests;

import com.topcoder.util.config.ConfigManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.lang.reflect.Field;

import java.util.Iterator;


/**
 * <p>
 * Helper class for accuracy test.
 * </p>
 *
 * @author hackerzhut
 * @version 1.0
 */
class Helper {
    /**
     * Private constructor.
     */
    private Helper() {
    }

    /**
    * <p>
    * Returns the value of the given field in the given Object using Reflection.
    * </p>
    *
    * @param obj the given Object instance to get the field value.
    * @param fieldName the name of the filed to get value from the obj.
    * @return the field value in the obj.
    */
    public static Object getObjectFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            return field.get(obj);
        } catch (SecurityException e) {
            //ignore the exception and return null.
        } catch (NoSuchFieldException e) {
            //ignore the exception and return null.
        } catch (IllegalArgumentException e) {
            //ignore the exception and return null.
        } catch (IllegalAccessException e) {
            //ignore the exception and return null.
        }

        return null;
    }

    /**
     * Reads all data from file.
     *
     * @param file the file to be read
     * @return the file content
     * @exception IOException if an I/O error occurs while reading from the
     *            reader
     */
    public static String readStringFromFile(File file)
        throws IOException {
        Reader reader = new FileReader(file);
        if (reader == null) {
            throw new IllegalArgumentException("The argument is null.");
        }

        StringBuffer string = new StringBuffer();
        char[] buffer = new char[1024];

        int n = 0;
        while ((n = reader.read(buffer)) != -1) {
            string.append(buffer, 0, n);
        }

        return new String(string);
    }

    /**
     * <p>Loads all configurations from files.</p>
     *
     * @param fileName the config file name to be loaded.
     * @throws Exception if any errors happened.
     */
    public static void loadConfigFromFile(String fileName) throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        cm.add(new File("test_files/accuracytest/" + fileName).getAbsolutePath());
    }

    /**
     * <p>unloads all configurations from files.</p>
     *
     * @throws Exception if any errors happened.
     */
    public static void unloadConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator it = cm.getAllNamespaces(); it.hasNext();) {
            cm.removeNamespace((String) it.next());
        }
    }
}
