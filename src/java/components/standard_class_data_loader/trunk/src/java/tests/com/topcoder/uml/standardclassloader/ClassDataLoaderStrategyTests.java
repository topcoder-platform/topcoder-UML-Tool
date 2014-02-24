/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import java.io.File;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ClassDataLoaderStrategy.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassDataLoaderStrategyTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace to be used for testing.
     * </p>
     */
    private static final String NAMESPACE = "strategyClassDataLoader";

    /**
     * <p>
     * The ClassDataLoaderStrategy instance for helping testing.
     * </p>
     */
    private ClassDataLoaderStrategy strategy;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to jUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "sampleConfig.xml");
        strategy = new ClassDataLoaderStrategy(NAMESPACE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        strategy = null;
        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ClassDataLoaderStrategyTests.class);
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ClassDataLoaderStrategy instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new ClassDataLoaderStrategy instance.", strategy);
        assertEquals("Expected the size of map is one.", 1, strategy.getLanguages().size());
        assertEquals("Expected the language is Java.", "Java", strategy.getLanguages().get(0));
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the languages is missing and the size
     * of the loaders map is zero.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_MissLanguages() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "languagesMissConfig.xml");

        strategy = new ClassDataLoaderStrategy(NAMESPACE);
        assertNotNull("Failed to create a new ClassDataLoaderStrategy instance.", strategy);
        assertEquals("Expected the size of map is zero.", 0, strategy.getLanguages().size());
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new ClassDataLoaderStrategy(null);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new ClassDataLoaderStrategy(" ");
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is unknown and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testCtor1_UnknownNamespace() {
        try {
            new ClassDataLoaderStrategy("test");
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the objectFactoryNamespace is missing and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_MissObjectFactoryNamespace() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "objectFactoryNamespaceMissConfig.xml");
        try {
            new ClassDataLoaderStrategy(NAMESPACE);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the objectFactoryNamespace contains empty property
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_EmptyPropertyObjectFactoryNamespace() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "emptyObjectFactoryNamespaceConfig.xml");
        try {
            new ClassDataLoaderStrategy(NAMESPACE);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the create object is not LanguageClassDataLoader type
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_NotLanguageClassDataLoaderType() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "NotLanguageClassDataLoaderTypeConfig.xml");
        try {
            new ClassDataLoaderStrategy(NAMESPACE);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the config data for XMLLanguageClassDataLoader is invalid and expects
     * ClassDataLoaderConfigurationException.
     * Note, the parameters configuration for XMLLanguageClassDataLoader in the configuration file
     * for Object Factory is wrong.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InCorrectXMLLanguageClassDataLoader() throws Exception {
        // incorrect parameters for XMLLanguageClassDataLoader
        TestHelper.loadXMLConfig("test_files" + File.separator + "incorrectParametersConfig.xml");
        try {
            new ClassDataLoaderStrategy(NAMESPACE);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the languages contains empty property
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_EmptyPropertyLanguages() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "emptyLanguagesConfig.xml");
        try {
            new ClassDataLoaderStrategy(NAMESPACE);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ClassDataLoaderStrategy instance should not be null.
     * </p>
     *
     * @throws ClassDataLoaderConfigurationException to JUnit
     */
    public void testCtor2() throws ClassDataLoaderConfigurationException {
        assertNotNull("Failed to create a new ClassDataLoaderStrategy instance.", new ClassDataLoaderStrategy());
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the languages is missing and the size
     * of the loaders map is zero.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2_MissLanguages() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "languagesMissConfig.xml");

        strategy = new ClassDataLoaderStrategy(NAMESPACE);
        assertNotNull("Failed to create a new ClassDataLoaderStrategy instance.", strategy);
        assertEquals("Expected the size of map is zero.", 0, strategy.getLanguages().size());
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the objectFactoryNamespace is missing and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2_MissObjectFactoryNamespace() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "objectFactoryNamespaceMissConfig.xml");
        try {
            new ClassDataLoaderStrategy();
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the objectFactoryNamespace contains empty property
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2_EmptyPropertyObjectFactoryNamespace() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "emptyObjectFactoryNamespaceConfig.xml");
        try {
            new ClassDataLoaderStrategy();
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the create object is not LanguageClassDataLoader type
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2_NotLanguageClassDataLoaderType() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "NotLanguageClassDataLoaderTypeConfig.xml");
        try {
            new ClassDataLoaderStrategy();
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the config data for XMLLanguageClassDataLoader is invalid and expects
     * ClassDataLoaderConfigurationException.
     * Note, the parameters configuration for XMLLanguageClassDataLoader in the configuration file
     * for Object Factory is wrong.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2_InCorrectXMLLanguageClassDataLoader() throws Exception {
        // incorrect parameters for XMLLanguageClassDataLoader
        TestHelper.loadXMLConfig("test_files" + File.separator + "incorrectParametersConfig.xml");
        try {
            new ClassDataLoaderStrategy();
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassDataLoaderStrategy#ClassDataLoaderStrategy() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the languages contains empty property
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2_EmptyPropertyLanguages() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "emptyLanguagesConfig.xml");
        try {
            new ClassDataLoaderStrategy();
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassDataLoaderStrategy#getNamespaces(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : ClassDataLoaderStrategy#getNamespaces(String) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetNamespaces() throws Exception {
        // pass the Java language and the return list contains five Namespace.
        assertEquals("Expected the size of the list is five.", 5, strategy.getNamespaces("Java").size());
        assertEquals("Failed to get the correct list.", "java", strategy.getNamespaces("Java").get(0).getName());
        assertEquals("Failed to get the correct list.", "boolean", strategy.getNamespaces("Java").get(1).getName());
        assertEquals("Failed to get the correct list.", "char", strategy.getNamespaces("Java").get(2).getName());
        assertEquals("Failed to get the correct list.", "int", strategy.getNamespaces("Java").get(3).getName());
        assertEquals("Failed to get the correct list.", "long", strategy.getNamespaces("Java").get(4).getName());
    }

    /**
     * <p>
     * Tests ClassDataLoaderStrategy#getNamespaces(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects UnknownLanguageException.
     * </p>
     *
     * @throws ClassDataLoaderConfigurationException to JUnit
     */
    public void testGetNamespaces_NullLanguage() throws ClassDataLoaderConfigurationException {
        try {
            strategy.getNamespaces(null);
            fail("UnknownLanguageException expected.");
        } catch (UnknownLanguageException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassDataLoaderStrategy#getNamespaces(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ClassDataLoaderConfigurationException to JUnit
     */
    public void testGetNamespaces_EmptyLanguage() throws ClassDataLoaderConfigurationException {
        try {
            strategy.getNamespaces(" ");
            fail("UnknownLanguageException expected.");
        } catch (UnknownLanguageException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassDataLoaderStrategy#getNamespaces(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the language does not exist and expects UnknownLanguageException.
     * </p>
     *
     * @throws ClassDataLoaderConfigurationException to JUnit
     */
    public void testGetNamespaces_UnknownLanguageException() throws ClassDataLoaderConfigurationException {
        try {
            strategy.getNamespaces("CSharp");
            fail("UnknownLanguageException expected.");
        } catch (UnknownLanguageException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassDataLoaderStrategy#getLanguages() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ClassDataLoaderStrategy#getLanguages() is correct.
     * </p>
     */
    public void testGetLanguages() {
        assertEquals("Expected the size of the language list is one.", 1, strategy.getLanguages().size());
        assertEquals("Failed to return the correct list.", "Java", strategy.getLanguages().get(0));
    }

}