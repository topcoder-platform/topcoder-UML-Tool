/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import java.io.File;
import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.modelelementformatters.CSharpExceptionElementFormatter;
import com.topcoder.uml.projectconfiguration.modelelementformatters.Java14EnumElementFormatter;
import com.topcoder.uml.projectconfiguration.modelelementformatters.JavaExceptionElementFormatter;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * <p>
 * The usage of ProjectConfigurationManager and all the formatters provided in the implementation
 * are shown.
 * </p>
 *
 * <p>
 * The sample configuration file for this component is provided too.
 * Please consult Config.xml file in the test_files directory.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace to be used by this demo.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.uml.projectconfiguration.DemoTests";

    /**
     * <p>
     * The MockStandardClassDataLoader instance for helping testing.
     * </p>
     */
    private MockStandardClassDataLoader classDataLoader;

    /**
     * <p>
     * The XMLStereotypeLoader instance for helping testing.
     * </p>
     */
    private XMLStereotypeLoader stereotypeLoader;

    /**
     * <p>
     * The UMLModelManager instance for helping testing.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "Config.xml");
        TestHelper.loadSingleXMLConfig(NAMESPACE + ".objectfactory", "test_files" + File.separator + "Config.xml");

        classDataLoader = new MockStandardClassDataLoader();
        stereotypeLoader = new XMLStereotypeLoader(NAMESPACE);
        umlModelManager = new UMLModelManager();

    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        umlModelManager = null;
        stereotypeLoader = null;
        classDataLoader = null;

        TestHelper.clearConfigFile(NAMESPACE + ".objectfactory");
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
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * This method shows execute the UML Project Configuration component function.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testDemo() throws ProjectConfigurationException {
        //create a project configuration manager
        ProjectConfigurationManager configurationManager = new ProjectConfigurationManager(umlModelManager,
            classDataLoader, stereotypeLoader, NAMESPACE);

        //set the conffigurationManager to umlModelManager
        umlModelManager.setProjectConfigurationManager(configurationManager);

        //Get the standard stereotypes for java class
        List<Stereotype> javaClassStereotypes = configurationManager.getStandardStereotypes("Java", "Class");

        //Get the standard namespace for java
        List<Namespace> javaNamespace = configurationManager.getStandardNamespaces("Java");

        //Add validator for the CreateDiagramAction
        InitialElementFormatter formatter = new JavaExceptionElementFormatter(NAMESPACE, umlModelManager, "Java");
        configurationManager.addInitialElementFormatter("Java", formatter);
        configurationManager.addInitialElementFormatter("CSharp", new CSharpExceptionElementFormatter(NAMESPACE,
            umlModelManager, "CSharp"));
        configurationManager.addInitialElementFormatter("Java14", new Java14EnumElementFormatter(NAMESPACE,
            umlModelManager, "Java"));
        configurationManager.addInitialDiagramFormatter("Java14",
            new PropertyTemplateDiagramElementFormatter(NAMESPACE));

        //Apply initial formatting for model element
        ModelElement exception = new ClassImpl();
        configurationManager.applyInitialFormatting("Java", exception);

        //Apply initial formatting for diagram element
        DiagramElement diagram = new Reference();
        configurationManager.applyInitialFormatting("Java", diagram);

        //Get default project language
        String defaultPoejectLanguage = configurationManager.getDefaultProjectLanguage();
    }

}
