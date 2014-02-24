/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * <p>
 * Base test case that provides some common assertion functionality for testing.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class BaseTestCase extends TestCase {

    /**
     * The reference to System.err.
     */
    private PrintStream originalOut = System.err;

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
     * File that will contain the data that is forwarded to System.err.
     */
    private static final String SYSTEM_OUT_FILE = "test_files" + File.separator + "accuracytests" + File.separator
            + "accuracy.log";

    /**
     * <p>
     * setup the testing environment.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();

        for (Iterator iter = ConfigManager.getInstance().getAllNamespaces(); iter.hasNext();) {
            ConfigManager.getInstance().removeNamespace((String) iter.next());
        }
        ConfigManager.getInstance().add("accuracytests/accuracy.xml");

        outputFile = new File(SYSTEM_OUT_FILE);
        outputFileStream = new FileOutputStream(outputFile);
        System.setErr(new PrintStream(outputFileStream));
    }

    /**
     * <p>
     * Tear down the testing environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        for (Iterator iter = ConfigManager.getInstance().getAllNamespaces(); iter.hasNext();) {
            ConfigManager.getInstance().removeNamespace((String) iter.next());
        }

        System.setErr(originalOut);

        if (outputFileStream != null && outputFile != null) {
            outputFileStream.close();
            outputFile.delete();
        }
    }

    /**
     * Checks whether the file contains the specified String.
     *
     * @param matchString the String to verify.
     * @return whether the file contains the specified String.
     */
    protected boolean confirmFileContents(String matchString) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile)));
            String line = reader.readLine();

            return line != null && line.contains(matchString);
        } catch (Exception e) {
            e.printStackTrace(originalOut);
            throw new RuntimeException("Cannot access redirected output file.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
