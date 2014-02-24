/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.modelelementformatters;

import java.io.File;
import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.MockStandardClassDataLoader;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.StandardStereotypeLoader;
import com.topcoder.uml.projectconfiguration.TestHelper;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;
import com.topcoder.uml.standardclassloader.StandardClassDataLoader;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Java14EnumElementFormatter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Java14EnumElementFormatterTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace used for testing.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.uml.projectconfiguration."
        + "modelelementformatters.Java14EnumElementFormatter";

    /**
     * <p>
     * Java14EnumElementFormatter instance for testing.
     * </p>
     */
    private Java14EnumElementFormatter formatter;

    /**
     * <p>
     * UMLModelManager instance for helping testing.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * Class instance for helping testing.
     * </p>
     */
    private Class element;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        // Set up the model manager and project configuration manager
        StandardClassDataLoader classDataLoader = new MockStandardClassDataLoader();
        StandardStereotypeLoader stereotypeLoader = new XMLStereotypeLoader(NAMESPACE);
        umlModelManager = new UMLModelManager();
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(umlModelManager,
            classDataLoader, stereotypeLoader, NAMESPACE);
        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);

        // Set up the formatter for testing
        formatter = new Java14EnumElementFormatter(NAMESPACE, umlModelManager, "Java");

        // Set up the enum class
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("enum");
        element = new ClassImpl();
        element.addStereotype(stereotype);
        element.setName("ModelElement");

    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        element = null;
        formatter = null;
        umlModelManager = null;

        TestHelper.clearConfigFile(NAMESPACE);
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(Java14EnumElementFormatterTests.class);
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (String,UMLModelManager,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created Java14EnumElementFormatter instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new instance of Java14EnumElementFormatter.", formatter);
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new Java14EnumElementFormatter(null, umlModelManager, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new Java14EnumElementFormatter("", umlModelManager, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullUmlModelManager() {
        try {
            new Java14EnumElementFormatter(NAMESPACE, null, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullLanguage() {
        try {
            new Java14EnumElementFormatter(NAMESPACE, umlModelManager, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyLanguage() {
        try {
            new Java14EnumElementFormatter(NAMESPACE, umlModelManager, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (UMLModelManager,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created Java14EnumElementFormatter instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new instance of Java14EnumElementFormatter.", new Java14EnumElementFormatter(
            umlModelManager, "Java"));
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullUmlModelManager() {
        try {
            new Java14EnumElementFormatter(null, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullLanguage() {
        try {
            new Java14EnumElementFormatter(umlModelManager, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Java14EnumElementFormatter#Java14EnumElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_EmptyLanguage() {
        try {
            new Java14EnumElementFormatter(umlModelManager, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Java14EnumElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Expects true and the private constructor and generalization are added.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_True() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        assertTrue("Failed to return correct value.", formatter.format(element));

        // Verify the added constructors
        List<Feature> features = element.getFeatures();
        assertEquals("One operations should be added.", 1, features.size());

        // Verify the constructor
        Operation operation = (Operation) features.get(0);
        assertEquals("Failed to get the correct operation name.", element.getName(), operation.getName());
        assertEquals("Failed to get the correct visibility kind.", VisibilityKind.PRIVATE, operation.getVisibility());
        assertEquals("Failed to get the correct parameters", 0, operation.getParameters().size());

        // Verify the generalization
        Collection<Generalization> relations = element.getGeneralizations();
        assertEquals("One generalization should be added.", 1, relations.size());
        Generalization relation = relations.iterator().next();
        assertEquals("Failed to get correct generalization.", element, relation.getChild());
        assertEquals("Failed to get correct generalization.", "Enum", relation.getParent().getName());
    }

    /**
     * <p>
     * Tests Java14EnumElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the model element is not Class instance and expects false.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_NotClass() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        assertFalse("Failed to return correct value.", formatter.format(new PackageImpl()));
    }

    /**
     * <p>
     * Tests Java14EnumElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the model element is not an enum Class and expects false.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_NotEnumClass() throws Exception {
        element.clearStereotypes();
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        assertFalse("Failed to return correct value.", formatter.format(element));
    }

    /**
     * <p>
     * Tests Java14EnumElementFormatter#format(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testFormat_NullElement() throws ProjectConfigurationException {
        try {
            formatter.format(null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Java14EnumElementFormatter#format(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is not configed and expects
     * ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_UnknownNamespace() throws Exception {
        try {
            formatter.format(element);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Java14EnumElementFormatter#format(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the property is missing and expects ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_MissingProperty() throws Exception {

        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "AbstractElementFormatterNoValue.xml");

        try {
            formatter.format(element);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Java14EnumElementFormatter#format(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the property value is empty and expects ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_EmptyPropertyValue() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "AbstractElementFormatterEmptyValue.xml");

        try {
            formatter.format(element);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }
}