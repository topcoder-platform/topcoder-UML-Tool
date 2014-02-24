/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure test for the <code>GeneratorFactory</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class GeneratorFactoryFailureTest extends TestCase {

    /**
     * Represents the <code>CodeGenerator</code> instance used to test against.
     */
    private CodeGenerator codeGenerator = null;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add("failure/config.xml");
        codeGenerator = new CodeGenerator();
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
     * Test the method <code>getGeneratorInstance(String, CodeGenerator, String)</code> with null language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetGeneratorInstanceWithNullLanguage() throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance(null, codeGenerator, "stub_class_generator");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getGeneratorInstance(String, CodeGenerator, String)</code> with empty language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetGeneratorInstanceWithEmptyLanguage() throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("  ", codeGenerator, "stub_class_generator");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getGeneratorInstance(String, CodeGenerator, String)</code> with invalid language.
     * CodeGenerationException should be thrown.
     */
    public void testGetGeneratorInstanceWithInvalidLanguage() {
        try {
            GeneratorFactory.getGeneratorInstance("invalid", codeGenerator, "stub_class_generator");
            fail("CodeGenerationException should be thrown.");
        } catch (CodeGenerationException e) {
            // success
        }
    }

    /**
     * Test the method <code>getGeneratorInstance(String, CodeGenerator, String)</code> with null codeGenerator.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetGeneratorInstanceWithNullCodeGenerator() throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("java", null, "stub_class_generator");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getGeneratorInstance(String, CodeGenerator, String)</code> with null namespace.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetGeneratorInstanceWithNullNamespace() throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("java", codeGenerator, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getGeneratorInstance(String, CodeGenerator, String)</code> with empty namespace.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetGeneratorInstanceWithEmptyNamespace() throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("java", codeGenerator, "  ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getExtension(String, CodeGenerator)</code> with null language. IllegalArgumentException
     * should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetExtensionWithNullLanguage() throws Exception {
        try {
            GeneratorFactory.getExtension(null, codeGenerator);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getExtension(String, CodeGenerator)</code> with empty language. IllegalArgumentException
     * should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetExtensionWithEmptyLanguage() throws Exception {
        try {
            GeneratorFactory.getExtension("  ", codeGenerator);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getExtension(String, CodeGenerator)</code> with invalid language. CodeGenerationException
     * should be thrown.
     */
    public void testGetExtensionWithInvalidLanguage() {
        try {
            GeneratorFactory.getExtension("invalid", codeGenerator);
            fail("CodeGenerationException should be thrown.");
        } catch (CodeGenerationException e) {
            // success
        }
    }

    /**
     * Test the method <code>getExtension(String, CodeGenerator)</code> with null codeGenerator.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetExtensionInstanceWithNullCodeGenerator() throws Exception {
        try {
            GeneratorFactory.getExtension("java", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
