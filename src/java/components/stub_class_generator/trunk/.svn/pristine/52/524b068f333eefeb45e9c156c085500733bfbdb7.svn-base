/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Method;

import java.util.Iterator;


/**
 * <p>
 * This class provides some useful methods used in tests.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {
    /**
     * Line separator.
     */
    public static final String LINE_SEPARATOR = java.lang.System.getProperty("line.separator");

    /**
     * Private constructor.
     */
    private TestHelper() {
        // empty
    }

    /**
     * Creates a temporary directory.
     *
     * @return a temporary directory.
     * @throws IOException
     *             if an IO error occurs
     */
    public static File createTempDir() throws IOException {
        File file = File.createTempFile("directory", "tmp");
        file.delete();
        file.mkdir();
        file.deleteOnExit();

        return file;
    }

    /**
     * Creates a temporary file.
     *
     * @return a temporary file.
     * @throws IOException
     *             if an IO error occurs
     */
    public static File createTempFile() throws IOException {
        File file = File.createTempFile("file", "tmp");
        file.deleteOnExit();

        return file;
    }

    /**
     * Creates a directory in the specified directory.
     *
     * @param dir
     *            parent directory
     * @param name
     *            name of the new directory
     * @return a directory in the specified directory.
     */
    public static File createDirectoryInDir(File dir, String name) {
        File d = new File(dir, name);
        d.mkdir();
        d.deleteOnExit();

        return d;
    }

    /**
     * Creates a file in the specified directory.
     *
     * @param dir
     *            parent directory
     * @param name
     *            name of the new file
     * @return a file in the specified directory.
     * @throws IOException
     *             if an IO error occurs
     */
    public static File createFileInDir(File dir, String name)
        throws IOException {
        File f = new File(dir, name);
        f.deleteOnExit();

        FileWriter w = new FileWriter(f);
        w.write(123);
        w.close();

        return f;
    }

    /**
     * Reads in a file.
     *
     * @param f
     *            file to read in
     * @return the content of the file in a string
     * @throws IOException
     *             if an IO error occurs
     */
    public static String readFile(File f) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(f));
        StringBuilder builder = new StringBuilder();
        int c;

        while ((c = r.read()) != -1) {
            builder.append((char) c);
        }

        return builder.toString();
    }

    /**
     * Clears the {@link ConfigManager}'s name spaces.
     *
     * @throws UnknownNamespaceException
     *             to JUnit.
     */
    public static void clearConfigManager() throws UnknownNamespaceException {
        for (Iterator it = ConfigManager.getInstance().getAllNamespaces(); it.hasNext();) {
            ConfigManager.getInstance().removeNamespace((String) it.next());
        }
    }

    /**
     * Calls a private Method and returns the result.
     *
     * @param target
     *            target object.
     * @param name
     *            name of the method.
     * @param types
     *            types of the method.
     * @param params
     *            parameters of the call
     * @return the result of the call
     * @throws Exception
     *             to JUnit.
     */
    public static Object callPrivateMethod(Object target, String name, Class[] types, Object[] params)
        throws Exception {
        Method m = target.getClass().getDeclaredMethod(name, types);
        m.setAccessible(true);

        return m.invoke(target, params);
    }
}
