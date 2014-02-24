/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.failuretests;

import java.util.Arrays;
import java.util.Iterator;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.stubclassgenerator.CodeGenerationException;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;
import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure test for the <code>CodeGenerator</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class CodeGeneratorFailureTest extends TestCase {

    /**
     * Represents the <code>CodeGenerator</code> instance used to test against.
     */
    private CodeGenerator generator = null;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add("failure/config.xml");
        generator = new CodeGenerator();
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
     * Test the constructor <code>CodeGenerator(boolean, boolean, String)</code> with null namespace.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructorWithNullNamespace() throws Exception {
        try {
            new CodeGenerator(false, false, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CodeGenerator(boolean, boolean, String)</code> with empty namespace.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructorWithEmptyNamespace() throws Exception {
        try {
            new CodeGenerator(false, false, "  ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CodeGenerator(boolean, boolean, String)</code> with unknown namespace.
     * GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithUnknownNamespace() {
        try {
            new CodeGenerator(false, false, "unknown");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CodeGenerator(boolean, boolean, String)</code> with invalid namespace which misses C#
     * language property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissCSharpLanguage() {
        try {
            new CodeGenerator(false, false, "MissC#Language");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CodeGenerator(boolean, boolean, String)</code> with invalid namespace which contains
     * empty C# language property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyCSharpLanguage() {
        try {
            new CodeGenerator(false, false, "EmptyC#Language");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CodeGenerator(boolean, boolean, String)</code> with invalid namespace which misses
     * java language property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissJavaLanguage() {
        try {
            new CodeGenerator(false, false, "MissJavaLanguage");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>CodeGenerator(boolean, boolean, String)</code> with invalid namespace which contains
     * empty java language property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyJavaLanguage() {
        try {
            new CodeGenerator(false, false, "EmptyJavaLanguage");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Classifier)</code> with null language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeClassifierWithNullLanguage() throws Exception {
        try {
            generator.generateCode(null, "src/main", new InterfaceImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Classifier)</code> with empty language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeClassifierWithEmptyLanguage() throws Exception {
        try {
            generator.generateCode("  ", "src/main", new InterfaceImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Classifier)</code> with null location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeClassifierWithNullLocation() throws Exception {
        try {
            generator.generateCode("java", null, new InterfaceImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Classifier)</code> with empty location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeClassifierWithEmptyLocation() throws Exception {
        try {
            generator.generateCode("java", "  ", new InterfaceImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Classifier)</code> with null classifier.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeClassifierWithNullClassifier() throws Exception {
        try {
            generator.generateCode("java", "src/main", (Classifier) null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCode(String, String, Classifier)</code> with invalid language.
     * CodeGenerationException should be thrown.
     */
    public void testGenerateCodeClassifierWithInvalidLanguage() {
        try {
            generator.generateCode("invalid", "src/main", new InterfaceImpl());
            fail("CodeGenerationException should be thrown.");
        } catch (CodeGenerationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Package)</code> with null language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodePackageWithNullLanguage() throws Exception {
        try {
            generator.generateCode(null, "src/main", new PackageImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Package)</code> with empty language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodePackageWithEmptyLanguage() throws Exception {
        try {
            generator.generateCode("  ", "src/main", new PackageImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Package)</code> with null location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodePackageWithNullLocation() throws Exception {
        try {
            generator.generateCode("java", null, new PackageImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Package)</code> with empty location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodePackageWithEmptyLocation() throws Exception {
        try {
            generator.generateCode("java", "  ", new PackageImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>generateCode(String, String, Package)</code> with null classifier.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodePackageWithNullPackage() throws Exception {
        try {
            generator.generateCode("java", "src/main", (com.topcoder.uml.model.modelmanagement.Package) null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCode(String, String, Package)</code> with invalid language.
     * CodeGenerationException should be thrown.
     */
    public void testGenerateCodePackageWithInvalidLanguage() {
        try {
            generator.generateCode("invalid", "src/main", new PackageImpl());
            fail("CodeGenerationException should be thrown.");
        } catch (CodeGenerationException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForClassifiers(String, String, List)</code> with null language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForClassifiersWithNullLanguage() throws Exception {
        try {
            generator.generateCodeForClassifiers(null, "src/main",
                Arrays.asList(new Classifier[] {new InterfaceImpl()}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForClassifiers(String, String, List)</code> with empty language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForClassifiersWithEmptyLanguage() throws Exception {
        try {
            generator.generateCodeForClassifiers("  ", "src/main",
                Arrays.asList(new Classifier[] {new InterfaceImpl()}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForClassifiers(String, String, List)</code> with null location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForClassifiersWithNullLocation() throws Exception {
        try {
            generator.generateCodeForClassifiers("java", null, Arrays.asList(new Classifier[] {new InterfaceImpl()}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForClassifiers(String, String, List)</code> with empty location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForClassifiersWithEmptyLocation() throws Exception {
        try {
            generator.generateCodeForClassifiers("java", "  ", Arrays.asList(new Classifier[] {new InterfaceImpl()}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForClassifiers(String, String, List)</code> with null classifiers.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForClassifiersWithNullClassifiers() throws Exception {
        try {
            generator.generateCodeForClassifiers("java", "src/main", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForClassifiers(String, String, List)</code> with invalid classifiers.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForClassifiersWithInvalidClassifiers() throws Exception {
        try {
            generator.generateCodeForClassifiers("java", "src/main", Arrays.asList(new Classifier[] {null}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test <code>generateCodeForClassifiers(String, String, List)</code> with invalid language.
     * CodeGenerationException should be thrown.
     */
    public void testGenerateCodeForClassifiersWithInvalidLanguage() {
        try {
            generator.generateCodeForClassifiers("invalid", "src/main",
                Arrays.asList(new Classifier[] {new InterfaceImpl()}));
            fail("CodeGenerationException should be thrown.");
        } catch (CodeGenerationException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForPackages(String, String, List)</code> with null language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForPackagesWithNullLanguage() throws Exception {
        try {
            generator.generateCodeForPackages(null, "src/main",
                Arrays.asList(new com.topcoder.uml.model.modelmanagement.Package[] {new PackageImpl()}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForPackages(String, String, List)</code> with empty language.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForPackagesWithEmptyLanguage() throws Exception {
        try {
            generator.generateCodeForPackages("  ", "src/main",
                Arrays.asList(new com.topcoder.uml.model.modelmanagement.Package[] {new PackageImpl()}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForPackages(String, String, List)</code> with null location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForPackagesWithNullLocation() throws Exception {
        try {
            generator.generateCodeForPackages("java", null,
                Arrays.asList(new com.topcoder.uml.model.modelmanagement.Package[] {new PackageImpl()}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForPackages(String, String, List)</code> with empty location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForPackagesWithEmptyLocation() throws Exception {
        try {
            generator.generateCodeForPackages("java", "  ",
                Arrays.asList(new com.topcoder.uml.model.modelmanagement.Package[] {new PackageImpl()}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForPackages(String, String, List)</code> with null packages.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForPackagesWithNullPackages() throws Exception {
        try {
            generator.generateCodeForPackages("java", "src/main", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForPackages(String, String, List)</code> with invalid packages.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGenerateCodeForPackagesWithInvalidPackages() throws Exception {
        try {
            generator.generateCodeForPackages("java", "src/main",
                Arrays.asList(new com.topcoder.uml.model.modelmanagement.Package[] {null}));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>generateCodeForPackages(String, String, List)</code> with invalid language.
     * CodeGenerationException should be thrown.
     */
    public void testGenerateCodeForPackagesWithInvalidLanguage() {
        try {
            generator.generateCodeForPackages("invalid", "src/main",
                Arrays.asList(new com.topcoder.uml.model.modelmanagement.Package[] {new PackageImpl()}));
            fail("CodeGenerationException should be thrown.");
        } catch (CodeGenerationException e) {
            // success
        }
    }
}
