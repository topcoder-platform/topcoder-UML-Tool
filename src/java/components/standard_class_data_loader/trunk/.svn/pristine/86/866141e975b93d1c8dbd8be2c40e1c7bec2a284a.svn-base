/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.failuretests;

import com.topcoder.uml.standardclassloader.ClassDataLoaderConfigurationException;
import com.topcoder.uml.standardclassloader.ClassDataLoaderStrategy;
import com.topcoder.uml.standardclassloader.UnknownLanguageException;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import junit.framework.TestCase;

import java.io.File;

import java.util.Iterator;


/**
 * This class contains unit tests for ClassDataLoaderStrategy class.
 *
 * @author qiucx0161
 * @version 1.0
 */
public class FailureTestClassDataLoaderStrategy extends TestCase {
    /**
     * The ConfigManager instance used to test.
     */
    private ConfigManager cm = ConfigManager.getInstance();

    /**
     * The ClassDataLoaderStrategy instance used to test.
     */
    private ClassDataLoaderStrategy strategy = null;

    /**
     * Set Up the test environment before testing.
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        removeNamespaces();
        cm.add(new File("test_files/failure/fail.xml").getAbsolutePath());
        strategy = new ClassDataLoaderStrategy();
    }

    /**
     * Remove all the namespace in this component.
     *
     */
    private void removeNamespaces() {
        for (Iterator iter = cm.getAllNamespaces(); iter.hasNext();) {
            String ns = (String) iter.next();

            if (cm.existsNamespace(ns)) {
                try {
                    cm.removeNamespace(ns);
                } catch (UnknownNamespaceException e) {
                    System.err.println("error occurs in removing namespace : " +
                        ns);
                }
            }
        }
    }

    /**
     * Clean up the test environment after testing.
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        removeNamespaces();
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with null Namespace.
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyNullNamespace()
        throws Exception {
        try {
            new ClassDataLoaderStrategy(null);
            fail("testClassDataLoaderStrategyNullNamespace is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with empty Namespace,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyEmptyNamespace()
        throws Exception {
        try {
            new ClassDataLoaderStrategy(" ");
            fail("testClassDataLoaderStrategyEmptyNamespace is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with missing ObjectFactoryNamespace,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyMissingObjectFactoryNamespace()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("MissingObjectFactoryNamespace");
            fail(
                "testClassDataLoaderStrategyMissingObjectFactoryNamespace is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with empty ObjectFactoryNamespace,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyEmptyObjectFactoryNamespace()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("EmptyObjectFactoryNamespace");
            fail(
                "testClassDataLoaderStrategyEmptyObjectFactoryNamespace is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with invalid ObjectFactoryNamespace,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyInvalidObjectFactoryNamespace()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("InvalidObjectFactoryNamespace");
            fail(
                "testClassDataLoaderStrategyInvalidObjectFactoryNamespace is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with missing Languages,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyMissingLanguages()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("MissingLanguages");
            fail("testClassDataLoaderStrategyMissingLanguages is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with empty Languages,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyEmptyLanguages()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("EmptyLanguages");
            fail("testClassDataLoaderStrategyEmptyLanguages is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with invalid Languages,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyInvalidLanguages()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("InvalidLanguages");
            fail("testClassDataLoaderStrategyInvalidLanguages is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with missing Key,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyMissingKey()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("MissingKey");
            fail("testClassDataLoaderStrategyMissingKey is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with empty Key,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyEmptyKey() throws Exception {
        try {
            new ClassDataLoaderStrategy("EmptyKey");
            fail("testClassDataLoaderStrategyEmptyKey is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with invalid Key,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyInvalidKey()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("InvalidKey");
            fail("testClassDataLoaderStrategyInvalidKey is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>ClassDataLoaderStrategy(String namespace)</code> method
     * for failure with invalid loader,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testClassDataLoaderStrategyInvalidLoader()
        throws Exception {
        try {
            new ClassDataLoaderStrategy("InvalidLoader");
            fail("testClassDataLoaderStrategyInvalidKey is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>getNamespaces(String language)</code> method
     * for failure with null Language.
     * UnknownLanguageException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testGetNamespacesNullLanguage() throws Exception {
        try {
            strategy.getNamespaces(null);
            fail("testGetNamespacesNullLanguage is failure.");
        } catch (UnknownLanguageException iae) {
            // pass
        }
    }

    /**
     * Tests <code>getNamespaces(String language)</code> method
     * for failure with empty Language,
     * UnknownLanguageException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testGetNamespacesEmptyLanguage() throws Exception {
        try {
            strategy.getNamespaces(" ");
            fail("testGetNamespacesEmptyLanguage is failure.");
        } catch (UnknownLanguageException iae) {
            // pass
        }
    }

    /**
     * Tests <code>getNamespaces(String language)</code> method
     * for failure with invalid Language,
     * UnknownLanguageException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testGetNamespacesInvalidLanguage() throws Exception {
        try {
            strategy.getNamespaces("vb.net");
            fail("testGetNamespacesInvalidLanguage is failure.");
        } catch (UnknownLanguageException iae) {
            // pass
        }
    }
}
