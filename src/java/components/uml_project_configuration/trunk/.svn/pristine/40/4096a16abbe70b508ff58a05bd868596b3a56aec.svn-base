/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import java.io.File;
import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.modelelementformatters.JavaExceptionElementFormatter;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ProjectConfigurationManager.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ProjectConfigurationManagerTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace to be used by this component.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.uml.projectconfiguration.ProjectConfigurationManager";

    /**
     * <p>
     * This constant represents the namespace to be used by the object factory component.
     * </p>
     */
    private static final String OBJECT_FACTORY_NAMESPACE = NAMESPACE + ".objectfactory";

    /**
     * <p>
     * The ProjectConfigurationManager instance for testing.
     * </p>
     */
    private ProjectConfigurationManager configurationManager;

    /**
     * <p>
     * The MockStandardClassDataLoader instance for helping testing.
     * </p>
     */
    private MockStandardClassDataLoader classDataLoader;

    /**
     * <p>
     * The UMLModelManager instance for helping testing.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * The StandardStereotypeLoader instance for helping testing.
     * </p>
     */
    private StandardStereotypeLoader stereotypeLoader;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     *
     */
    protected void setUp() throws ProjectConfigurationException {
        classDataLoader = new MockStandardClassDataLoader();
        umlModelManager = new UMLModelManager();
        stereotypeLoader = new XMLStereotypeLoader(NAMESPACE);
        configurationManager = new ProjectConfigurationManager(umlModelManager, classDataLoader, stereotypeLoader,
            NAMESPACE);

        // set up the connection of the uml model manager and project configuration manager
        umlModelManager.setProjectConfigurationManager(configurationManager);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        configurationManager = null;
        stereotypeLoader = null;
        umlModelManager = null;
        classDataLoader = null;

        // clears the necessary namespaces
        TestHelper.clearConfigFile(OBJECT_FACTORY_NAMESPACE);
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
        return new TestSuite(ProjectConfigurationManagerTests.class);
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created ProjectConfigurationManager instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1() throws Exception {
        TestHelper.loadSingleXMLConfig(OBJECT_FACTORY_NAMESPACE, "test_files" + File.separator
            + "projectconfiguration.xml");
        assertNotNull("Failed to create a new ProjectConfigurationManager instance.", new ProjectConfigurationManager(
            umlModelManager, NAMESPACE));
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,String) for failure.
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testCtor1_NullUmlModelManager() throws ProjectConfigurationException {
        try {
            new ProjectConfigurationManager(null, NAMESPACE);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,String) for failure.
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testCtor1_NullNamespace() throws ProjectConfigurationException {
        try {
            new ProjectConfigurationManager(umlModelManager, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,String) for failure.
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testCtor1_EmptyNamespace() throws ProjectConfigurationException {
        try {
            new ProjectConfigurationManager(umlModelManager, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace for object factory is not configed and expects
     * ProjectConfigurationException success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_UnknownNamespace() throws Exception {
        // the namespace for the object factory is not configed
        try {
            new ProjectConfigurationManager(umlModelManager, NAMESPACE);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the config data for StereotypeLoader is invalid and expects
     * ProjectConfigurationException.
     * Note, the parameters configuration for XMLStereotypeLoader in the configuration file for Object Factory
     * is wrong.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InCorectStereotypeLoader() throws Exception {
        // incorrect parameters for XMLStereotypeLoader
        TestHelper.loadSingleXMLConfig(OBJECT_FACTORY_NAMESPACE, "test_files" + File.separator
            + "InvalidStereotypeLoader.xml");

        try {
            new ProjectConfigurationManager(umlModelManager, NAMESPACE);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the config data for StandardClassLoader is invalid and expects
     * ProjectConfigurationException.
     * Note, the parameters configuration for StandardClassLoader in the configuration file for Object Factory
     * is wrong.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InCorrectStandardClassLoader() throws Exception {
        // incorrect parameters for StandardClassLoader
        TestHelper.loadSingleXMLConfig(OBJECT_FACTORY_NAMESPACE, "test_files" + File.separator
            + "InvalidStandardClassLoader.xml");

        try {
            new ProjectConfigurationManager(umlModelManager, NAMESPACE);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,
     * StandardClassDataLoader,StandardStereotypeLoader,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created ProjectConfigurationManager instance should not be null.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testCtor2() throws ProjectConfigurationException {
        assertNotNull("Failed to create a new ProjectConfigurationManager instance.", configurationManager);
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,
     * StandardClassDataLoader,StandardStereotypeLoader,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullUmlModelManager() {
        try {
            new ProjectConfigurationManager(null, classDataLoader, stereotypeLoader, NAMESPACE);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,
     * StandardClassDataLoader,StandardStereotypeLoader,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when classDataLoader is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullClassDataLoader() {
        try {
            new ProjectConfigurationManager(umlModelManager, null, stereotypeLoader, NAMESPACE);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,
     * StandardClassDataLoader,StandardStereotypeLoader,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when stereotypeLoader is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullStereotypeLoader() {
        try {
            new ProjectConfigurationManager(umlModelManager, classDataLoader, null, NAMESPACE);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,
     * StandardClassDataLoader,StandardStereotypeLoader,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullNamespace() {
        try {
            new ProjectConfigurationManager(umlModelManager, classDataLoader, stereotypeLoader, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,
     * StandardClassDataLoader,StandardStereotypeLoader,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_EmptyNamespace() {
        try {
            new ProjectConfigurationManager(umlModelManager, classDataLoader, stereotypeLoader, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created ProjectConfigurationManager should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor3() throws Exception {
        TestHelper.loadSingleXMLConfig(OBJECT_FACTORY_NAMESPACE, "test_files" + File.separator
            + "projectconfiguration.xml");

        assertNotNull("Failed to create a new instance of ProjectConfigurationManager",
            new ProjectConfigurationManager(umlModelManager));

    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testCtor3_NullUmlModelManager() throws ProjectConfigurationException {
        try {
            new ProjectConfigurationManager(null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace for object factory is not configed and expects
     * ProjectConfigurationException success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor3_UnknownNamespace() throws Exception {
        try {
            new ProjectConfigurationManager(umlModelManager);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the config data for StereotypeLoader is invalid and expects
     * ProjectConfigurationException.
     * </p>
     *
     * <p>
     * Note, the parameters configuration for XMLStereotypeLoader in the configuration file for Object Factory
     * is wrong.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor3_InCorrectStereotypeLoader() throws Exception {
        TestHelper.loadSingleXMLConfig(OBJECT_FACTORY_NAMESPACE, "test_files" + File.separator
            + "InvalidStereotypeLoader.xml");
        try {
            new ProjectConfigurationManager(umlModelManager);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests ctor ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager) for failure.
     * Expects for ProjectConfigurationException.
     * </p>
     *
     * <p>
     * It tests the case when the config data for StandardClassLoader is invalid and expects
     * ProjectConfigurationException.
     * Note, the parameters configuration for StandardClassLoader in the configuration file for Object Factory
     * is wrong.
     * </p>
     *
     * @throws Exception
     */
    public void testCtor3_IncorrectStandardClassLoader() throws Exception {
        TestHelper.loadSingleXMLConfig(OBJECT_FACTORY_NAMESPACE, "test_files" + File.separator
            + "InvalidStandardClassLoader.xml");
        try {
            new ProjectConfigurationManager(umlModelManager);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardStereotypes(String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : All the stereotypes are returned correctly.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetStandardStereotypes() throws Exception {
        // config the namespace for XMLStereotypeLoader
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "StandardStereotypes.xml");

        List<Stereotype> stereotypes = configurationManager.getStandardStereotypes("Java", "Class");

        assertEquals("The return list length was wrong.", 2, stereotypes.size());
        assertEquals("The return list contain wrong value.", "exception", stereotypes.get(0).getName());
        assertEquals("The return list contain wrong value.", "abstract", stereotypes.get(1).getName());

    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardStereotypes(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetStandardStereotypes_NullLanguage() throws ProjectConfigurationException {
        try {
            configurationManager.getStandardStereotypes(null, "Class");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardStereotypes(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetStandardStereotypes_EmptyLanguage() throws ProjectConfigurationException {
        try {
            configurationManager.getStandardStereotypes(" ", "Class");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardStereotypes(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when elementType is null and expects IllegalArgumentException.
     * </p>
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetStandardStereotypes_NullElementType() throws ProjectConfigurationException {
        try {
            configurationManager.getStandardStereotypes("Java", null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardStereotypes(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when elementType is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetStandardStereotypes_EmptyElementType() throws ProjectConfigurationException {
        try {
            configurationManager.getStandardStereotypes("Java", " ");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardStereotypes(String,String) for failure.
     * </p>
     *
     * <p>
     * It test the namespace for XMLStandardClassLoader is not configed and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit
     */
    public void testGetStandardStereotypes_UnknownNamespace() throws Exception {
        try {
            configurationManager.getStandardStereotypes("Java", "Class");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardStereotypes(String,String) for failure.
     * </p>
     *
     * <p>
     * It test the case when StereotypeLoader throws ProjectConfigurationException and expects
     * ProjectConfigurationException for this method.
     * </P>
     *
     * @throws Exception to JUnit
     */
    public void testGetStandardStereotypesForProjectConfigurationException() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "StandardStereotypesNoClass.xml");

        try {
            configurationManager.getStandardStereotypes("Java", "Class");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardNamespaces(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The namespaces returned are correct.
     * </p>
     */
    public void testGetStandardNamespaces() {
        Namespace namespace = new PackageImpl();
        classDataLoader.addNamespace("Java", namespace);
        classDataLoader.addNamespace("Java", namespace);

        List<Namespace> namespaces = configurationManager.getStandardNamespaces("Java");

        assertEquals("Expects only two namespace.", 2, namespaces.size());
        assertEquals("Failed to return correct namespace value.", namespace, namespaces.get(0));

    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardNamespaces(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetStandardNamespaces_NullLanguage() {
        try {
            configurationManager.getStandardNamespaces(null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getStandardNamespaces(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testGetStandardNamespaces_EmptyLanguage() {
        try {
            configurationManager.getStandardNamespaces(" ");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the diagram element should be modified.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting1_True() throws Exception {
        DiagramElement element = new Reference();

        // create a formatter and config its namespace
        InitialDiagramElementFormatter formatter = new PropertyTemplateDiagramElementFormatter(NAMESPACE);
        configurationManager.addInitialDiagramFormatter("Java", formatter);
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "PropertyTemplateDiagramElementFormatter.xml");

        assertTrue("Failed to return true.", configurationManager.applyInitialFormatting("Java", element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the diagram element should not be modified.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting1_False() throws Exception {
        // create a DiagramElement instance and set up the necessary properties
        DiagramElement element = new Reference();

        Property property1 = new Property();
        property1.setKey("property1");
        property1.setValue("value1");
        element.addProperty(property1);

        Property property2 = new Property();
        property2.setKey("property2");
        property2.setValue("value2");
        element.addProperty(property2);

        // create a formatter and config its namespace
        // All the properties to be added exist in the element
        InitialDiagramElementFormatter formatter = new PropertyTemplateDiagramElementFormatter(NAMESPACE);
        configurationManager.addInitialDiagramFormatter("Java", formatter);
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "PropertyTemplateDiagramElementFormatter.xml");

        assertFalse("Failed to return false.", configurationManager.applyInitialFormatting("Java", element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when no formatter is contained in the project configuration manager and expects the diagram
     * element should not be modified.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting1_NoFormatter() throws Exception {
        // create a DiagramElement instance and set up the necessary properties
        DiagramElement element = new Reference();

        assertFalse("Failed to return false.", configurationManager.applyInitialFormatting("Java", element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testApplyInitialFormatting1_NullLanguage() throws ProjectConfigurationException {
        DiagramElement element = new Reference();

        try {
            configurationManager.applyInitialFormatting(null, element);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testApplyInitialFormatting1_EmptyLanguage() throws ProjectConfigurationException {
        DiagramElement element = new Reference();

        try {
            configurationManager.applyInitialFormatting(" ", element);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testApplyInitialFormatting1_NullElement() throws ProjectConfigurationException {
        try {
            configurationManager.applyInitialFormatting("Java", (DiagramElement) null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,DiagramElement) for failure.
     * Expects ProjectConfigurationException.
     * </p>
     *
     * <p>
     * It tests the case when the formatter throws ProjectConfigurationException and expects
     * ProjectConfigurationException for this method.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting1ForProjectConfigurationException() throws Exception {
        // the namespace for the PropertyTemplateDiagramElementFormatter is not configed
        DiagramElement element = new Reference();
        InitialDiagramElementFormatter formatter = new PropertyTemplateDiagramElementFormatter(NAMESPACE);
        configurationManager.addInitialDiagramFormatter("Java", formatter);

        try {
            configurationManager.applyInitialFormatting("Java", element);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The model element should be modified.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting2_True() throws Exception {
        // set up a model element to represents an exception class
        ModelElement element = new ClassImpl();
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("exception");
        element.addStereotype(stereotype);
        element.setName("ExceptionModelElement");

        // set up the formatter and config the namespace
        InitialElementFormatter formatter = new JavaExceptionElementFormatter(NAMESPACE, umlModelManager, "Java");
        configurationManager.addInitialElementFormatter("Java", formatter);
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        assertTrue("Failed to return true.", configurationManager.applyInitialFormatting("Java", element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The model element should not be modified.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting2_False() throws Exception {
        // set up a model element which does not represent a Java exception class
        ModelElement element = new ClassImpl();

        // set up the formatter and config the namespace
        InitialElementFormatter formatter = new JavaExceptionElementFormatter(NAMESPACE, umlModelManager, "Java");
        configurationManager.addInitialElementFormatter("Java", formatter);
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        assertFalse("Failed to return False.", configurationManager.applyInitialFormatting("Java", element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests case when no formatter is contained in the project configuration manager and
     * expects the model element should not be modified.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting2_NoFormatter() throws Exception {
        ModelElement element = new ClassImpl();

        assertFalse("Failed to return False.", configurationManager.applyInitialFormatting("Java", element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testApplyInitialFormatting2_NullLanguage() throws ProjectConfigurationException {
        ModelElement element = new ClassImpl();
        try {
            configurationManager.applyInitialFormatting(null, element);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testApplyInitialFormatting2_EmptyLanguage() throws ProjectConfigurationException {
        ModelElement element = new ClassImpl();
        try {
            configurationManager.applyInitialFormatting("", element);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     * @throws ProjectConfigurationException
     */
    public void testApplyInitialFormatting2_NullElement() throws ProjectConfigurationException {
        try {
            configurationManager.applyInitialFormatting("Java", (ModelElement) null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#applyInitialFormatting(String,ModelElement) for failure.
     * </p>
     *
     * <p>
     * It test the case when the formatter throws ProjectConfigurationException and expects
     * ProjectConfigurationException is thrown by this method.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testApplyInitialFormatting2ForProjectConfigurationException() throws Exception {
        // set up a model element to represents an exception class
        ModelElement element = new ClassImpl();
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("exception");
        element.addStereotype(stereotype);
        element.setName("ModelElement");

        // set up the formatter without namespace configed
        InitialElementFormatter formatter = new JavaExceptionElementFormatter(NAMESPACE, umlModelManager, "Java");
        configurationManager.addInitialElementFormatter("Java", formatter);

        try {
            configurationManager.applyInitialFormatting("Java", element);

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getDefaultProjectLanguage() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The default project language in configuration file should be returned.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDefaultProjectLanguage() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "StandardStereotypes.xml");

        assertEquals("Failed to return correct language.", "Java", configurationManager.getDefaultProjectLanguage());
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getDefaultProjectLanguage() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is not configed and expects
     * ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDefaultProjectLanguage_UnknownNamespace() throws Exception {
        try {
            configurationManager.getDefaultProjectLanguage();

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getDefaultProjectLanguage() for failure.
     * </p>
     *
     * <p>
     * It tests the &quot;defaultProjectLanguage&quot; property is missing and expects
     * ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDefaultProjectLanguage_MissingDefaultProjectLanguage() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "StandardStereotypesNoLanguage.xml");
        try {
            configurationManager.getDefaultProjectLanguage();

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#getDefaultProjectLanguage() for failure.
     * </p>
     *
     * <p>
     * It tests the &quot;defaultProjectLanguage&quot; property is empty and expects
     * ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDefaultProjectLanguage_EmptyProjectDefaultLanguage() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "StandardStereotypesEmptyLanguage.xml");

        try {
            configurationManager.getDefaultProjectLanguage();

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#addInitialElementFormatter(String,InitialElementFormatter)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : the formatter should be added.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testAddInitialElementFormatter() throws ProjectConfigurationException {
        InitialElementFormatter formatter = new MockInitialElementFormatter();
        ModelElement element = new ClassImpl();

        configurationManager.addInitialElementFormatter("Java", formatter);

        // If the formatter is added, then the applyInitialFormatting() should return true
        assertTrue("Failed to add InitialElementFormatter.", configurationManager.applyInitialFormatting("Java",
            element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#addInitialElementFormatter(String,InitialElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddInitialElementFormatter_NullLanguage() {
        InitialElementFormatter formatter = new MockInitialElementFormatter();

        try {
            configurationManager.addInitialElementFormatter(null, formatter);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#addInitialElementFormatter(String,InitialElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testAddInitialElementFormatter_EmptyLanguage() {
        InitialElementFormatter formatter = new MockInitialElementFormatter();
        try {
            configurationManager.addInitialElementFormatter("", formatter);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#addInitialElementFormatter(String,InitialElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when formatter is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddInitialElementFormatter_NullFormatter() {
        try {
            configurationManager.addInitialElementFormatter("Java", null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#addInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : The formatter should be added.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testAddInitialDiagramFormatter() throws ProjectConfigurationException {
        InitialDiagramElementFormatter formatter = new MockInitialDiagramElementFormatter();
        DiagramElement element = new Reference();

        configurationManager.addInitialDiagramFormatter("Java", formatter);

        // If the formatter is added, then the applyInitialFormatting() should return true
        assertTrue("Failed to add InitialDiagramElementFormatter.", configurationManager.applyInitialFormatting("Java",
            element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#addInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddInitialDiagramFormatter_NullLanguage() {
        InitialDiagramElementFormatter formatter = new MockInitialDiagramElementFormatter();
        try {
            configurationManager.addInitialDiagramFormatter(null, formatter);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#addInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testAddInitialDiagramFormatter_EmptyLanguage() {
        InitialDiagramElementFormatter formatter = new MockInitialDiagramElementFormatter();
        try {
            configurationManager.addInitialDiagramFormatter("", formatter);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#addInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when formatter is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddInitialDiagramFormatter_NullFormatter() {
        try {
            configurationManager.addInitialDiagramFormatter("Java", null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#removeInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : The formatter should be removed.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testRemoveInitialDiagramFormatter() throws ProjectConfigurationException {
        InitialDiagramElementFormatter formatter = new MockInitialDiagramElementFormatter();
        DiagramElement element = new Reference();
        configurationManager.addInitialDiagramFormatter("Java", formatter);

        configurationManager.removeInitialDiagramFormatter("Java", formatter);

        // If the formatter is removed, then the applyInitialFormatting() return false
        assertFalse("Failed to remove InitialDiagramElementFormatter.", configurationManager.applyInitialFormatting(
            "Java", element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#removeInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveInitialDiagramFormatter_NullLanguage() {
        InitialDiagramElementFormatter formatter = new MockInitialDiagramElementFormatter();
        try {
            configurationManager.removeInitialDiagramFormatter(null, formatter);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#removeInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveInitialDiagramFormatter_EmptyLanguage() {
        InitialDiagramElementFormatter formatter = new MockInitialDiagramElementFormatter();
        try {
            configurationManager.removeInitialDiagramFormatter("", formatter);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#removeInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when formatter is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveInitialDiagramFormatter_NullFormatter() {
        try {
            configurationManager.removeInitialDiagramFormatter("Java", null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#removeInitialElementFormatter(String,InitialElementFormatter)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : The formatter should be removed.
     * </p>
     *
     * @throws ProjectConfigurationException
     */
    public void testRemoveInitialElementFormatter() throws ProjectConfigurationException {
        InitialElementFormatter formatter = new MockInitialElementFormatter();
        ModelElement element = new ClassImpl();
        configurationManager.addInitialElementFormatter("Java", formatter);

        configurationManager.removeInitialElementFormatter("Java", formatter);

        // If the formatter is removed, then the applyInitialFormatting() should return false
        assertFalse("Failed to remove InitialDiagramElementFormatter.", configurationManager.applyInitialFormatting(
            "Java", element));
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#removeInitialElementFormatter(String,InitialElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveInitialElementFormatter_NullLanguage() {
        InitialElementFormatter formatter = new MockInitialElementFormatter();
        try {
            configurationManager.removeInitialElementFormatter(null, formatter);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#removeInitialElementFormatter(String,InitialElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveInitialElementFormatter_EmptyLanguage() {
        InitialElementFormatter formatter = new MockInitialElementFormatter();
        try {
            configurationManager.removeInitialElementFormatter(" ", formatter);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ProjectConfigurationManager#removeInitialElementFormatter(String,InitialElementFormatter)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when formatter is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveInitialElementFormatter_NullFormatter() {
        try {
            configurationManager.removeInitialElementFormatter("Java", null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}