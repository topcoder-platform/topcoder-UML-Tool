/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.accuracytests;

import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
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
import com.topcoder.uml.projectconfiguration.accuracytests.MockObjects.MockClassLoader;
import com.topcoder.uml.projectconfiguration.accuracytests.MockObjects.MockModelElementFormatter;
import com.topcoder.uml.projectconfiguration.accuracytests.MockObjects.MockDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.*;

import junit.framework.TestCase;

/**
 * Contains accuracy tests for the ProjectConfigurationManager class.
 *
 * @author TheCois
 */
public class TestProjectConfigurationManager extends TestCase {
    /**
     * This constant represents the namespace used by this component for normal tests.
     */
    private static final String testNamespace = "com.topcoder.uml.projectconfiguration.ProjectConfigurationManager";

    /**
     * This constant represents the namespace used by this component for diagram element formatter tests.
     */
    private static final String testPropertyTemplateNamespace = "com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatter";

    /**
     * This constant represents the namespace used by this component for Java exception formatter tests.
     */
    private static final String testJavaFormatterNamespace = "com.topcoder.uml.projectconfiguration.modelelementformatters.JavaExceptionElementFormatter";

    /**
     * The ProjectConfigurationManager instance for testing.
     */
    private ProjectConfigurationManager testObject;

    /**
     * The StandardClassDataLoader instance used for testing.
     */
    private MockClassLoader classDataLoader;

    /**
     * <p>
     * The UMLModelManager instance for helping testing.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * Setup test environment.
     *
     * @throws Exception
     *
     */
    protected void setUp() throws Exception {
        Helper.loadConfigFile("accuracy/config.xml");
        classDataLoader = new MockClassLoader();
        umlModelManager = new UMLModelManager();
        StandardStereotypeLoader stereotypeLoader = new XMLStereotypeLoader(testNamespace);
        testObject = new ProjectConfigurationManager(umlModelManager, classDataLoader, stereotypeLoader,
            testNamespace);

        // set up the connection of the uml model manager and project configuration manager
        umlModelManager.setProjectConfigurationManager(testObject);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        testObject = null;
        umlModelManager = null;
        classDataLoader = null;

        // clears the necessary namespaces
        Helper.clearConfig();
    }

    /**
     * ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager,String)
     *
     * Makes sure a proper object is produced.
     *
     * @throws Exception
     */
    public void testCtor1() throws Exception {
        assertNotNull("Constructor failed.", new ProjectConfigurationManager(
            umlModelManager, testNamespace));
    }

    /**
     * ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager, StandardClassDataLoader,StandardStereotypeLoader,String)
     *
     * Makes sure a proper object is produced.
     *
     * @throws Exception
     */
    public void testCtor2() throws Exception {
        assertNotNull("Constructor failed.", testObject);
    }

    /**
     * ProjectConfigurationManager#ProjectConfigurationManager(UMLModelManager)
     *
     * Makes sure a proper object is produced.
     *
     * @throws Exception
     */
    public void testCtor3() throws Exception {
        assertNotNull("Constructor failed.", new ProjectConfigurationManager(umlModelManager));
    }

    /**
     * ProjectConfigurationManager#getStandardStereotypes(String,String)
     *
     * Makes sure all stereotypes are returned correctly.
     *
     * @throws Exception
     */
    public void testGetStandardStereotypes() throws Exception {
        List<Stereotype> stereotypes = testObject.getStandardStereotypes("Java", "Class");

        assertEquals("stereotype list length was wrong.", 2, stereotypes.size());
        assertEquals("first stereotype element is wrong.", "exception", stereotypes.get(0).getName());
        assertEquals("second stereotype element is wrong.", "abstract", stereotypes.get(1).getName());
    }

    /**
     * ProjectConfigurationManager#getStandardNamespaces(String)
     *
     * Makes sure the returned namespaces are the correct ones
     *
     * @throws Exception
     */
    public void testGetStandardNamespaces() throws Exception    {
        Namespace namespace = new PackageImpl();
        classDataLoader.addNamespace("Java", namespace);
        classDataLoader.addNamespace("Java", namespace);

        List<Namespace> namespaces = testObject.getStandardNamespaces("Java");

        assertEquals("Expects only two namespace.", 2, namespaces.size());
        assertEquals("Failed to return correct namespace value.", namespace, namespaces.get(0));

    }

    /**
     * ProjectConfigurationManager#applyInitialFormatting(String,DiagramElement)
     *
     * Makes sure the diagram element is modified
     *
     * @throws Exception
     */
    public void testApplyInitialFormatting_DiagramElement_Effect() throws Exception {
        DiagramElement element = new Reference();

        InitialDiagramElementFormatter formatter = new PropertyTemplateDiagramElementFormatter(testPropertyTemplateNamespace);
        testObject.addInitialDiagramFormatter("Java", formatter);

        assertTrue("Formatting did not take place.", testObject.applyInitialFormatting("Java", element));
    }

    /**
     * ProjectConfigurationManager#applyInitialFormatting(String, ModelElement)
     *
     * Makes sure the model element is modified.
     *
     * @throws Exception
     */
    public void testApplyInitialFormatting_ModelElement_Effect() throws Exception {
        ModelElement element = new ClassImpl();
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("exception");
        element.addStereotype(stereotype);
        element.setName("ExceptionModelElement");

        InitialElementFormatter formatter = new JavaExceptionElementFormatter(testJavaFormatterNamespace, umlModelManager, "Java");
        testObject.addInitialElementFormatter("Java", formatter);

        assertTrue("Formatting did not take place.", testObject.applyInitialFormatting("Java", element));
    }

    /**
     * ProjectConfigurationManager#getDefaultProjectLanguage()
     *
     * Makes sure the correct default project language is returned.
     *
     * @throws Exception
     */
    public void testGetDefaultProjectLanguage() throws Exception {
        assertEquals("Failed to return correct language.", "Java", testObject.getDefaultProjectLanguage());
    }

    /**
     * ProjectConfigurationManager#addInitialElementFormatter(String,InitialElementFormatter)
     *
     * Makes sure the formatter is added (by trying to apply it)
     *
     * @throws com.topcoder.uml.projectconfiguration.ProjectConfigurationException
     */
    public void testAddInitialElementFormatter() throws ProjectConfigurationException {
        InitialElementFormatter formatter = new MockModelElementFormatter();
        ModelElement element = new ClassImpl();

        testObject.addInitialElementFormatter("Java", formatter);

        // If the formatter is added, then the applyInitialFormatting() should return true
        assertTrue("Failed to add InitialElementFormatter.", testObject.applyInitialFormatting("Java",
            element));
    }

    /**
     * ProjectConfigurationManager#addInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     *
     * Makes sure the formatter is added (by trying to apply it)
     * @throws ProjectConfigurationException to JUnit
     */
    public void testAddInitialDiagramFormatter() throws ProjectConfigurationException {
        InitialDiagramElementFormatter formatter = new MockDiagramElementFormatter();
        DiagramElement element = new Reference();

        testObject.addInitialDiagramFormatter("Java", formatter);

        assertTrue("Failed to add InitialDiagramElementFormatter.", testObject.applyInitialFormatting("Java",
            element));
    }

    /**
     * ProjectConfigurationManager#removeInitialDiagramFormatter(String,InitialDiagramElementFormatter)
     *
     * Makes sure the formatter is removed (by trying to apply it and seeing it fail)
     * @throws ProjectConfigurationException
     */
    public void testRemoveInitialDiagramFormatter() throws ProjectConfigurationException {
        InitialDiagramElementFormatter formatter = new MockDiagramElementFormatter();
        DiagramElement element = new Reference();
        testObject.addInitialDiagramFormatter("Java", formatter);

        testObject.removeInitialDiagramFormatter("Java", formatter);

        assertFalse("Failed to remove InitialDiagramElementFormatter.", testObject.applyInitialFormatting(
            "Java", element));
    }

    /**
     * ProjectConfigurationManager#removeInitialElementFormatter(String,InitialElementFormatter)
     *
     * Makes sure the formatter is removed (by trying to apply it and seeing it fail)
     *
     * @throws ProjectConfigurationException
     */
    public void testRemoveInitialElementFormatter() throws ProjectConfigurationException {
        InitialElementFormatter formatter = new MockModelElementFormatter();
        ModelElement element = new ClassImpl();
        testObject.addInitialElementFormatter("Java", formatter);

        testObject.removeInitialElementFormatter("Java", formatter);

        assertFalse("Failed to remove InitialDiagramElementFormatter.", testObject.applyInitialFormatting(
            "Java", element));
    }
}