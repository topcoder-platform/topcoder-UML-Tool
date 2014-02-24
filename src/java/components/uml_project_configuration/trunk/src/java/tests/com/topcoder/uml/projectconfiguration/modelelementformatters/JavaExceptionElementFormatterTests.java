/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.modelelementformatters;

import java.io.File;
import java.util.List;

import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
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
 * Unit test cases for JavaExceptionElementFormatter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class JavaExceptionElementFormatterTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace used for testing.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.uml.projectconfiguration."
        + "modelelementformatters.JavaExceptionElementFormatter";

    /**
     * <p>
     * JavaExceptionElementFormatter instance for testing.
     * </p>
     */
    private JavaExceptionElementFormatter formatter;

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
        // set up the model manager and project configuration manager
        umlModelManager = new UMLModelManager();
        StandardClassDataLoader classDataLoader = new MockStandardClassDataLoader();
        StandardStereotypeLoader stereotypeLoader = new XMLStereotypeLoader(NAMESPACE);
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(umlModelManager,
            classDataLoader, stereotypeLoader, NAMESPACE);
        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);

        // set up the formatter instance for testing
        formatter = new JavaExceptionElementFormatter(NAMESPACE, umlModelManager, "Java");

        // set up the exception class
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("exception");
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
        return new TestSuite(JavaExceptionElementFormatterTests.class);
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
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
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new JavaExceptionElementFormatter(null, umlModelManager, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new JavaExceptionElementFormatter("", umlModelManager, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullUmlModelManager() {
        try {
            new JavaExceptionElementFormatter(NAMESPACE, null, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullLanguage() {
        try {
            new JavaExceptionElementFormatter(NAMESPACE, umlModelManager, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyLanguage() {
        try {
            new JavaExceptionElementFormatter(NAMESPACE, umlModelManager, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (UMLModelManager,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created Java14EnumElementFormatter instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new instance of Java14EnumElementFormatter.",
            new JavaExceptionElementFormatter(umlModelManager, "Java"));
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullUmlModelManager() {
        try {
            new JavaExceptionElementFormatter(null, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullLanguage() {
        try {
            new JavaExceptionElementFormatter(umlModelManager, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor JavaExceptionElementFormatter#JavaExceptionElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor2_EmptyLanguage() {
        try {
            new JavaExceptionElementFormatter(umlModelManager, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests JavaExceptionElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Expects true and the two constructors are added.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_True() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        assertTrue("Failed to return correct value.", formatter.format(element));

        // Verify the added constructors
        List<Feature> features = element.getFeatures();
        assertEquals("Four operations should be added.", 2, features.size());

        // Verify the first constructor
        Operation operation = (Operation) features.get(0);
        assertEquals("Failed to get the correct operation name.", element.getName(), operation.getName());
        assertEquals("Failed to get the correct visibility kind.", VisibilityKind.PUBLIC, operation.getVisibility());
        assertEquals("Failed to get the correct parameters", 1, operation.getParameters().size());

        // Verify the second constructor
        operation = (Operation) features.get(1);
        assertEquals("Failed to get the correct operation name.", element.getName(), operation.getName());
        assertEquals("Failed to get the correct visibility kind.", VisibilityKind.PUBLIC, operation.getVisibility());
        assertEquals("Failed to get the correct parameters", 2, operation.getParameters().size());
    }

    /**
     * <p>
     * Tests JavaExceptionElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the model element is not an exception class and expects false.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_NotExceptionClass() throws Exception {
        element.clearStereotypes();
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        assertFalse("Failed to return correct value.", formatter.format(element));
    }

    /**
     * <p>
     * Tests JavaExceptionElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the model element is not a Class instance and expects false.
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
     * Tests JavaExceptionElementFormatter#format(ModelElement) for failure.
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
     * Tests JavaExceptionElementFormatter#format(ModelElement) for failure.
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
     * Tests JavaExceptionElementFormatter#format(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the property is missing and expects ProjectConfigurationException.
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
     * Tests JavaExceptionElementFormatter#format(ModelElement) for failure.
     * Expects ProjectConfigurationException.
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