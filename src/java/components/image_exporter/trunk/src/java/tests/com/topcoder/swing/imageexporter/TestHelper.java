/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.UnknownNamespaceException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.net.URL;

import java.util.Iterator;


/**
 * Helper class for loading and clearing config.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class TestHelper {
    /**
     * Private ctor preventing this class from being instantiated.
     */
    private TestHelper() {
    }

    /**
     * Backups the specified file.
     *
     * @param filename file to backup
     *
     * @throws IOException if write error
     */
    public static void backupConfig(String filename) throws IOException {
        copyFile(filename, filename + ".backup");
    }

    /**
     * Clear all namespace.
     *
     * @throws UnknownNamespaceException if any error occurs
     */
    public static void clearConfig() throws UnknownNamespaceException {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator iter = cm.getAllNamespaces();

        while (iter.hasNext()) {
            cm.removeNamespace((String) iter.next());
        }
    }

    /**
     * Return the output directory for the generated result, default is set to .\\test_files\\output\\.
     *
     * @return .\\test_files\\output\\
     */
    public static String getOutputPath() {
        String result = System.getenv("output_path");

        if (result == null) {
            result = ".\\test_files\\output\\";
        }

        System.out.println("output result is set to '" + result + "'");

        return result;
    }

    /**
     * Load the specified config given with the config file name.
     *
     * @param name name of the config file
     *
     * @throws ConfigManagerException if any error occurs
     */
    public static void loadConfig(String name) throws ConfigManagerException {
        ConfigManager cm = ConfigManager.getInstance();
        cm.add(name);
    }

    /**
     * Remove the specified property from given namespace and commit it.
     *
     * @param namespace namespace
     * @param property property to be removed
     *
     * @throws ConfigManagerException if any error occurs
     */
    public static void removeProperty(String namespace, String property)
        throws ConfigManagerException {
        ConfigManager cm = ConfigManager.getInstance();
        cm.createTemporaryProperties(namespace);
        cm.removeProperty(namespace, property);
        cm.commit(namespace, "testhelper");
        cm.refresh(namespace);
    }

    /**
     * Restore the backup file.
     *
     * @param filename name of the file
     *
     * @throws IOException if any error occurs while restoring
     */
    public static void restoreConfig(String filename) throws IOException {
        String backupFile = filename + ".backup";
        copyFile(backupFile, filename);
        new File(TestHelper.class.getClassLoader().getResource(backupFile).getFile()).delete();

        ConfigManager.getInstance().refreshAll();
    }

    /**
     * Set the property to a new value.
     *
     * @param namespace namespace of the property
     * @param property the property name
     * @param value the new value
     *
     * @throws ConfigManagerException if any error occurs
     */
    public static void setProperty(String namespace, String property, String value)
        throws ConfigManagerException {
        ConfigManager cm = ConfigManager.getInstance();
        cm.createTemporaryProperties(namespace);
        cm.setProperty(namespace, property, value);
        cm.commit(namespace, "testhelper");
        cm.refresh(namespace);
    }

    /**
     * copy file from the src to dest.
     *
     * @param src source file
     * @param dest destination
     *
     * @throws IOException if any error occurs
     */
    private static void copyFile(String src, String dest)
        throws IOException {
        URL url = TestHelper.class.getClassLoader().getResource(src);
        String path = url.getFile().replace(src, "");
        File destFile = new File(path + File.separator + dest);

        BufferedReader br = new BufferedReader(new FileReader(url.getFile()));
        String line = br.readLine();

        PrintWriter pw = new PrintWriter(destFile);

        while (line != null) {
            pw.println(line);
            line = br.readLine();
        }

        pw.close();
        br.close();
    }
}
