/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.failuretests.csharp;

import java.util.Iterator;

import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;
import com.topcoder.uml.stubclassgenerator.csharp.CSharpGenerator;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure test for the <code>CSharpGenerator</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class CSharpGeneratorFailureTest extends TestCase {

    /**
     * Represents the <code>CSharpGenerator</code> instance used to test against.
     */
    private CSharpGenerator generator = null;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add("failure/config.xml");
        generator = new CSharpGenerator("com.topcoder.uml.stubclassgenerator");
    }

    /**
     * Tears down the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator iter = manager.getAllNamespaces(); iter.hasNext();) {
            manager.removeNamespace((String) iter.next());
        }
    }

    /**
     * Test the constructor <code>CSharpGenerator(String)</code> with null namespace. IllegalArgumentException should
     * be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructorWithNullNamespace() throws Exception {
        try {
            new CSharpGenerator(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CSharpGenerator(String)</code> with empty namespace. IllegalArgumentException should
     * be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructorWithEmptyNamespace() throws Exception {
        try {
            new CSharpGenerator("  ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CSharpGenerator(String)</code> with unknown namespace. GeneratorConfigurationException
     * should be thrown.
     */
    public void testConstructorWithUnknownNamespace() {
        try {
            new CSharpGenerator("unknown");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CSharpGenerator(String)</code> with invalid namespace which misses documentation
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissDocumentation() {
        try {
            new CSharpGenerator("MissDocumentation");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CSharpGenerator(String)</code> with invalid namespace which contains empty
     * documentation property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyDocumentation() {
        try {
            new CSharpGenerator("EmptyDocumentation");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CSharpGenerator(String)</code> with invalid namespace which misses tagsDocumentation
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissTagsDocumentation() {
        try {
            new CSharpGenerator("MissTagsDocumentation");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CSharpGenerator(String)</code> with invalid namespace which contains empty
     * tagsDocumentation property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyTagsDocumentation() {
        try {
            new CSharpGenerator("EmptyTagsDocumentation");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the method <code>createClassifierCode(Classifier)</code> with null classifier. IllegalArgumentException
     * should be thrown.
     */
    public void testCreateClassifierCodeWithNullClassifier() {
        try {
            generator.createClassifierCode(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
