/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * Parent class of all the unit tests which handle the Configuration File.
 * </p>
 * <p>
 * This allows the subclass to swap its own configuration file with the main
 * config file for testing and modification purposes. This will allow tests to
 * modify their own test configuration files without having to worry about
 * damaging the existing User-defined configuration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelpTestCase extends TestCase {

    /**
     * File that will contain the data that is forwarded to System.err.
     */
    private static final String SYSTEM_OUT_FILE = "test_files/System.err.log";

    /**
     * A file that will be used to output the contents of System.err. Will be
     * used to verify that the contents of the file are logged.
     */
    private File outputFile;

    /**
     * Reference to the outputStream to the outputFile.
     */
    private FileOutputStream outputFileStream;

    /**
     * The reference to System.err.
     */
    private PrintStream originalOut = System.err;

    /**
     * A reference to the Configuration Manager.
     */
    private ConfigManager cm;

    /**
     * A XML file that uses for the conf.
     */
    private File xmlFile;

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        cm = ConfigManager.getInstance();
        for (Iterator itr = cm.getAllNamespaces(); itr.hasNext();) {
            cm.removeNamespace((String) itr.next());
        }

        xmlFile = prepareXMLFile();
        cm.add("com.topcoder.util.log", xmlFile.getAbsolutePath(), ConfigManager.CONFIG_XML_FORMAT);

        LogFactory.loadConfiguration();

        outputFile = new File(SYSTEM_OUT_FILE);
        outputFileStream = new FileOutputStream(outputFile);
        System.setErr(new PrintStream(outputFileStream));
    }

    /**
     * Teardown routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        for (Iterator itr = cm.getAllNamespaces(); itr.hasNext();) {
            cm.removeNamespace((String) itr.next());
        }
        cm = null;
        xmlFile.delete();

        System.setOut(originalOut);

        if (outputFileStream != null && outputFile != null) {
            outputFileStream.close();
            outputFile.delete();
        }
    }

    /**
     * Checks whether the file contains the specified String.
     *
     * @param matchString
     *            the String to verify.
     * @return whether the file contains the specified String.
     * @throws Exception
     *             to JUnit.
     */
    protected boolean confirmFileContents(String matchString) throws Exception {
        BufferedReader reader = null;

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile)));
        String line = reader.readLine();

        if (reader != null) {
            reader.close();
        }

        return line.equals(matchString);
    }

    /**
     * Prepares an xml config file, for the test.
     *
     * @return an xml config file
     * @throws Exception
     *             to JUnit
     */
    private File prepareXMLFile() throws Exception {
        File file = File.createTempFile("unittest", ".xml", new File("test_files"));
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.println("<?xml version=\"1.0\"?>");
        writer.println("<CMConfig>");
        writer.println("    <Property name=\"TestProperty\">");
        writer.println("        <Value>TestPropertyValue</Value>");
        writer.println("    </Property>");
        writer.println("    <Property name=\"basic\">");
        writer.println("        <Property name=\"log\">");
        writer.println("            <Property name=\"target\">");
        writer.println("                <Value>System.err</Value>");
        writer.println("            </Property>");
        writer.println("        </Property>");
        writer.println("    </Property>");
        writer.println("    <Property name=\"logClass\">");
        writer.println("        <Value>com.topcoder.util.log.basic.BasicLog</Value>");
        writer.println("    </Property>");
        writer.println("</CMConfig>");
        writer.close();

        return file;
    }
}