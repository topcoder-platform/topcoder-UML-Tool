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

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CSharpExceptionElementFormatter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CSharpExceptionElementFormatterTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace used for testing.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.uml.projectconfiguration."
        + "modelelementformatters.CSharpExceptionElementFormatter";

    /**
     * <p>
     * CSharpExceptionElementFormatter instance for testing.
     * </p>
     */
    private CSharpExceptionElementFormatter formatter;

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
        MockStandardClassDataLoader classDataLoader = new MockStandardClassDataLoader();
        StandardStereotypeLoader stereotypeLoader = new XMLStereotypeLoader(NAMESPACE);
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(umlModelManager,
            classDataLoader, stereotypeLoader, NAMESPACE);
        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);

        // set up the formatter instance for testing
        formatter = new CSharpExceptionElementFormatter(NAMESPACE, umlModelManager, "CSharp");

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
        return new TestSuite(CSharpExceptionElementFormatterTests.class);
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (String,UMLModelManager,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created CSharpExceptionElementFormatter instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new instance of CSharpExceptionElementFormatter.", formatter);
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter(String,UMLModelManager,String)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new CSharpExceptionElementFormatter(null, umlModelManager, "CSharp");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new CSharpExceptionElementFormatter("", umlModelManager, "CSharp");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullUmlModelManager() {
        try {
            new CSharpExceptionElementFormatter(NAMESPACE, null, "CSharp");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullLanguage() {
        try {
            new CSharpExceptionElementFormatter(NAMESPACE, umlModelManager, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyLanguage() {
        try {
            new CSharpExceptionElementFormatter(NAMESPACE, umlModelManager, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (UMLModelManager,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created CSharpExceptionElementFormatter instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new instance of CSharpExceptionElementFormatter.",
            new CSharpExceptionElementFormatter(umlModelManager, "CSharp"));
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullUmlModelManager() {
        try {
            new CSharpExceptionElementFormatter(null, "CSharp");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullLanguage() {
        try {
            new CSharpExceptionElementFormatter(umlModelManager, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CSharpExceptionElementFormatter#CSharpExceptionElementFormatter
     * (UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_EmptyLanguage() {
        try {
            new CSharpExceptionElementFormatter(umlModelManager, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CSharpExceptionElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : True should be returned and the necessary constructors are added.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        assertTrue("Failed to return correct value.", formatter.format(element));

        // Verify the added constructors
        List<Feature> features = element.getFeatures();
        assertEquals("Four operations should be added.", 4, features.size());

        // Verify the first constructor
        Operation operation = (Operation) features.get(0);
        assertEquals("Failed to get the correct operation name.", element.getName(), operation.getName());
        assertEquals("Failed to get the correct visibility kind.", VisibilityKind.PUBLIC, operation.getVisibility());
        assertEquals("Failed to get the correct parameters", 0, operation.getParameters().size());

        // Verify the second constructor
        operation = (Operation) features.get(1);
        assertEquals("Failed to get the correct operation name.", element.getName(), operation.getName());
        assertEquals("Failed to get the correct visibility kind.", VisibilityKind.PUBLIC, operation.getVisibility());
        assertEquals("Failed to get the correct parameters", 1, operation.getParameters().size());

        // Verify the third constructor
        operation = (Operation) features.get(2);
        assertEquals("Failed to get the correct operation name.", element.getName(), operation.getName());
        assertEquals("Failed to get the correct visibility kind.", VisibilityKind.PUBLIC, operation.getVisibility());
        assertEquals("Failed to get the correct parameters", 2, operation.getParameters().size());

        // Verify the fourth constructor
        operation = (Operation) features.get(3);
        assertEquals("Failed to get the correct operation name.", element.getName(), operation.getName());
        assertEquals("Failed to get the correct visibility kind.", VisibilityKind.PROTECTED, operation.getVisibility());
        assertEquals("Failed to get the correct parameters", 2, operation.getParameters().size());
    }

    /**
     * <p>
     * Tests CSharpExceptionElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the given element is not an exception class and expects false.
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
     * Tests CSharpExceptionElementFormatter#format(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the given model element is not a Class instance and expects false.
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
     * Tests CSharpExceptionElementFormatter#format(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
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
     * Tests CSharpExceptionElementFormatter#format(ModelElement) for failure.
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
     * Tests CSharpExceptionElementFormatter#format(ModelElement) for failure.
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
     * Tests CSharpExceptionElementFormatter#format(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the property is empty and expects ProjectConfigurationException.
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