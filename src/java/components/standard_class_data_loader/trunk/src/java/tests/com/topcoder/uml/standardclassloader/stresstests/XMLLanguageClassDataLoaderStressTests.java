/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.stresstests;

import java.util.Date;

import com.topcoder.uml.standardclassloader.implementations.XMLLanguageClassDataLoader;

import junit.framework.TestCase;

/**
 * Stress of XMLLanguageClassDataLoader class.
 *
 * @author King_Bette
 * @version 1.0
 */
public class XMLLanguageClassDataLoaderStressTests extends TestCase {
    /**
     * use a simple language file to getNamespace, run 5 times.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testGetNamespaces_SimpleLanguageFile_5_Times() throws Exception {
        testGetNamespace("test_files/stress/SimpleLanguageFile.xml", 5);
    }
    /**
     * use a simple language file to getNamespace, run 50 times.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testGetNamespaces_SimpleLanguageFile_50_Times() throws Exception {
        testGetNamespace("test_files/stress/SimpleLanguageFile.xml", 50);
    }
    /**
     * use a large language file to getNamespace, run 5 times.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testGetNamespaces_LargeLanguageFile_5_Times() throws Exception {
        testGetNamespace("test_files/stress/LargeLanguageFile.xml", 5);
    }
    /**
     * use a large language file to getNamespace, run 50 times.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testGetNamespaces_LargeLanguageFile_50_Times() throws Exception {
        testGetNamespace("test_files/stress/LargeLanguageFile.xml", 50);
    }
    /**
     * Run getNamespace with given fileName as many times as specified.
     *
     * @param fileName
     *            the name of language file
     * @param times
     *            the times to run
     * @throws Exception
     *             to JUnit
     */
    private void testGetNamespace(String fileName, int times) throws Exception {
        long startTime = new Date().getTime();
        for (int i = 0; i < times; i++) {
            XMLLanguageClassDataLoader xmlLanguageClassDataLoader = new XMLLanguageClassDataLoader(fileName);
            xmlLanguageClassDataLoader.getNamespaces();
        }
        long endTime = new Date().getTime();
        System.out.println("Run getNamespace " + times + " times with [" + fileName + "] file takes "
            + (endTime - startTime) + "ms.");
    }
}
