/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PropertiesPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PropertiesPanelTests extends TestCase {
    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * The UMLModelManager instance for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfigurations();

        manager = TestHelper.createUMLModelManager();
        propertiesPanel = new PropertiesPanel(TestHelper.NAMESPACE, manager);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        propertiesPanel = null;
        manager = null;

        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PropertiesPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created PropertiesPanel instance should not be null.
     * </p>
     * @throws PropertiesPanelConfigurationException to JUnit
     */
    public void testCtor1() throws PropertiesPanelConfigurationException {
        assertNotNull("Failed to create a new PropertiesPanel instance.", new PropertiesPanel(manager));
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     * @throws PropertiesPanelConfigurationException to JUnit
     */
    public void testCtor1_NullUmlModelManager() throws PropertiesPanelConfigurationException {
        try {
            new PropertiesPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created PropertiesPanel instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new PropertiesPanel instance.", propertiesPanel);
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created PropertiesPanel instance should not be null.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_LookAndFeelClassMissing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "LookAndFeelClassMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        assertNotNull("Failed to create a new PropertiesPanel instance.", new PropertiesPanel(TestHelper.NAMESPACE,
            manager));
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     * @throws PropertiesPanelConfigurationException to JUnit
     */
    public void testCtor2_NullNamespace() throws PropertiesPanelConfigurationException {
        try {
            new PropertiesPanel(null, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     * @throws PropertiesPanelConfigurationException to JUnit
     */
    public void testCtor2_EmptyNamespace() throws PropertiesPanelConfigurationException {
        try {
            new PropertiesPanel(" ", manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     * @throws PropertiesPanelConfigurationException to JUnit
     */
    public void testCtor2_NullUmlModelManager() throws PropertiesPanelConfigurationException {
        try {
            new PropertiesPanel(TestHelper.NAMESPACE, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when namespace is unknown and expects for PropertiesPanelConfigurationException.
     * </p>
     */
    public void testCtor2_UnkonwnNamespace() {
        try {
            new PropertiesPanel("UnknownNamspace", manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when LinkButtonImagePath property is missing and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_LinkButtonImagePathMissing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "LinkButtonImagePathMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when LinkButtonImagePath property is empty and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_LinkButtonImagePathEmpty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "LinkButtonImagePathEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when AddButtonImagePath property is missing and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_AddButtonImagePathMissing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "AddButtonImagePathMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when AddButtonImagePath property is empty and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_AddButtonImagePathEmpty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "AddButtonImagePathEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when DeleteButtonImagePath property is missing and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_DeleteButtonImagePathMissing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "DeleteButtonImagePathMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when DeleteButtonImagePath property is empty and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_DeleteButtonImagePathEmpty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "DeleteButtonImagePathEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when LookAndFeelClass property is empty and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_LookAndFeelClassEmpty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "LookAndFeelClassEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when LookAndFeelClass property is invalid and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_LookAndFeelClassNotFound() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "LookAndFeelClassNotFound.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when LookAndFeelClass property is invalid and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_LookAndFeelClassNotAccess() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "LookAndFeelClassNotAccess.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when Multiplicities property is missing and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_MultiplicitiesMissing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "MultiplicitiesMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when MultiplicityName property is missing and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_MultiplicityNameMissing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "MultiplicityNameMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case when RangeName property is missing and expects
     * for PropertiesPanelConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_RangeNameMissing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator + "RangeNameMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests property StereotypeMapping/Package for failure.
     * It tests the case when StereotypeMapping/Package property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Package_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingPackageMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests property StereotypeMapping/Interface for failure.
     * It tests the case when StereotypeMapping/Interface property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Interface_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingInterfaceMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Interface for failure.
     * It tests the case when StereotypeMapping/Interface property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Interface_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingInterfaceEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Class for failure.
     * It tests the case when StereotypeMapping/Class property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Class_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingClassMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Class for failure.
     * It tests the case when StereotypeMapping/Class property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Class_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingClassEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Enumeration for failure.
     * It tests the case when StereotypeMapping/Enumeration property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Enumeration_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingEnumerationMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Enumeration for failure.
     * It tests the case when StereotypeMapping/Enumeration property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Enumeration_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingEnumerationEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Attribute for failure.
     * It tests the case when StereotypeMapping/Attribute property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Attribute_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingAttributeMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Attribute for failure.
     * It tests the case when StereotypeMapping/Attribute property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Attribute_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingAttributeEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Operation for failure.
     * It tests the case when StereotypeMapping/Operation property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Operation_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingOperationMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Operation for failure.
     * It tests the case when StereotypeMapping/Operation property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Operation_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingOperationEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Parameter for failure.
     * It tests the case when StereotypeMapping/Parameter property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Parameter_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingParameterMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Parameter for failure.
     * It tests the case when StereotypeMapping/Parameter property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Parameter_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingParameterEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Dependency for failure.
     * It tests the case when StereotypeMapping/Dependency property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Dependency_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingDependencyMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Dependency for failure.
     * It tests the case when StereotypeMapping/Dependency property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Dependency_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingDependencyEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Generalization for failure.
     * It tests the case when StereotypeMapping/Generalization property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Generalization_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingGeneralizationMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Generalization for failure.
     * It tests the case when StereotypeMapping/Generalization property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Generalization_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingGeneralizationEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Abstraction for failure.
     * It tests the case when StereotypeMapping/Abstraction property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Abstraction_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingAbstractionMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Abstraction for failure.
     * It tests the case when StereotypeMapping/Abstraction property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Abstraction_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingAbstractionEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Association for failure.
     * It tests the case when StereotypeMapping/Association property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Association_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingAssociationMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Association for failure.
     * It tests the case when StereotypeMapping/Association property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Association_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingAssociationEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/AssociationEnd for failure.
     * It tests the case when StereotypeMapping/AssociationEnd property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_AssociationEnd_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingAssociationEndMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/AssociationEnd for failure.
     * It tests the case when StereotypeMapping/AssociationEnd property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_AssociationEnd_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingAssociationEndEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Actor for failure.
     * It tests the case when StereotypeMapping/Actor property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Actor_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingActorMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Actor for failure.
     * It tests the case when StereotypeMapping/Actor property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Actor_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingActorEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/UseCase for failure.
     * It tests the case when StereotypeMapping/UseCase property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_UseCase_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingUseCaseMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/UseCase for failure.
     * It tests the case when StereotypeMapping/UseCase property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_UseCase_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingUseCaseEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Subsystem for failure.
     * It tests the case when StereotypeMapping/Subsystem property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Subsystem_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingSubsystemMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Subsystem for failure.
     * It tests the case when StereotypeMapping/Subsystem property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Subsystem_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingSubsystemEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Include for failure.
     * It tests the case when StereotypeMapping/Include property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Include_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingIncludeMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Include for failure.
     * It tests the case when StereotypeMapping/Include property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Include_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingIncludeEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Extend for failure.
     * It tests the case when StereotypeMapping/Extend property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Extend_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingExtendMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Extend for failure.
     * It tests the case when StereotypeMapping/Extend property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Extend_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingExtendEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/SimpleState for failure.
     * It tests the case when StereotypeMapping/SimpleState property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_SimpleState_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingSimpleStateMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/SimpleState for failure.
     * It tests the case when StereotypeMapping/SimpleState property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_SimpleState_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingSimpleStateEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/ObjectFlowState for failure.
     * It tests the case when StereotypeMapping/ObjectFlowState property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_ObjectFlowState_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingObjectFlowStateMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/ObjectFlowState for failure.
     * It tests the case when StereotypeMapping/ObjectFlowState property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_ObjectFlowState_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingObjectFlowStateEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/FinalState for failure.
     * It tests the case when StereotypeMapping/FinalState property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_FinalState_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingFinalStateMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/FinalState for failure.
     * It tests the case when StereotypeMapping/FinalState property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_FinalState_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingFinalStateEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/ActionState for failure.
     * It tests the case when StereotypeMapping/ActionState property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_ActionState_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingActionStateMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/ActionState for failure.
     * It tests the case when StereotypeMapping/ActionState property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_ActionState_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingActionStateEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Pseudostate for failure.
     * It tests the case when StereotypeMapping/Pseudostate property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Pseudostate_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingPseudostateMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Pseudostate for failure.
     * It tests the case when StereotypeMapping/Pseudostate property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Pseudostate_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingPseudostateEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Transition for failure.
     * It tests the case when StereotypeMapping/Transition property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Transition_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingTransitionMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Transition for failure.
     * It tests the case when StereotypeMapping/Transition property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Transition_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingTransitionEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Object for failure.
     * It tests the case when StereotypeMapping/Object property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Object_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingObjectMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Object for failure.
     * It tests the case when StereotypeMapping/Object property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Object_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingObjectEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/CreateObjectAction for failure.
     * It tests the case when StereotypeMapping/CreateObjectAction property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_CreateObjectAction_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingCreateObjectActionMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/CreateObjectAction for failure.
     * It tests the case when StereotypeMapping/CreateObjectAction property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_CreateObjectAction_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingCreateObjectActionEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/CallOperationAction for failure.
     * It tests the case when StereotypeMapping/CallOperationAction property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_CallOperationAction_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingCallOperationActionMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/CallOperationAction for failure.
     * It tests the case when StereotypeMapping/CallOperationAction property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_CallOperationAction_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingCallOperationActionEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/SendSignalAction for failure.
     * It tests the case when StereotypeMapping/SendSignalAction property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_SendSignalAction_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingSendSignalActionMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/SendSignalAction for failure.
     * It tests the case when StereotypeMapping/SendSignalAction property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_SendSignalAction_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingSendSignalActionEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Stimulus for failure.
     * It tests the case when StereotypeMapping/Stimulus property
     * is missing and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Stimulus_Missing() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingStimulusMissing.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Stimulus for failure.
     * It tests the case when StereotypeMapping/Stimulus property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Stimulus_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingStimulusEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests property StereotypeMapping/Package for failure.
     * It tests the case when StereotypeMapping/Package property
     * is empty and expects PropertiesPanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testConfig_StereotypeMapping_Package_Empty() throws Exception {
        String configFile = "test_files" + File.separator + "config_tests" + File.separator
            + "StereotypeMappingPackageEmpty.xml";
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, configFile);

        try {
            new PropertiesPanel(TestHelper.NAMESPACE, manager);
            fail("PropertiesPanelConfigurationException expected.");
        } catch (PropertiesPanelConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests PropertiesPanel#configurePanel(List) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#configurePanel(List) is correct.
     * </p>
     */
    public void testConfigurePanel1() {
        Package packageObject = new PackageImpl();

        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        modelElements.add(packageObject);
        propertiesPanel.configurePanel(modelElements);

        JPanel leftPanel = (JPanel) propertiesPanel.getComponent(0);
        JPanel rightPanel = (JPanel) propertiesPanel.getComponent(1);

        assertEquals("Failed to configure the left panel.", 4, leftPanel.getComponentCount());
        assertEquals("Failed to configure the right panel.", 1, rightPanel.getComponentCount());
    }

    /**
     * <p>
     * Tests PropertiesPanel#configurePanel(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements is null and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigurePanel1_NullModelElements() {
        try {
            propertiesPanel.configurePanel((List<ModelElement>) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#configurePanel(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigurePanel1_EmptyModelElements() {
        try {
            propertiesPanel.configurePanel(new ArrayList<ModelElement>());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#configurePanel(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigurePanel1_NullInModelElements() {
        try {
            List<ModelElement> modelElements = new ArrayList<ModelElement>();
            modelElements.add(null);
            propertiesPanel.configurePanel(modelElements);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#configurePanel(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#configurePanel(ModelElement) is correct.
     * </p>
     */
    public void testConfigurePanel2() {
        Package packageObject = new PackageImpl();

        propertiesPanel.configurePanel(packageObject);

        JPanel leftPanel = (JPanel) propertiesPanel.getComponent(0);
        JPanel rightPanel = (JPanel) propertiesPanel.getComponent(1);

        assertEquals("Failed to configure the left panel.", 4, leftPanel.getComponentCount());
        assertEquals("Failed to configure the right panel.", 1, rightPanel.getComponentCount());
    }

    /**
     * <p>
     * Tests PropertiesPanel#configurePanel(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigurePanel2_NullModelElement() {
        try {
            propertiesPanel.configurePanel((ModelElement) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        Package packageObject = new PackageImpl();
        propertiesPanel.configurePanel(packageObject);

        propertiesPanel.refreshPanel();

        JPanel leftPanel = (JPanel) propertiesPanel.getComponent(0);
        JPanel rightPanel = (JPanel) propertiesPanel.getComponent(1);

        assertEquals("Failed to configure the left panel.", 4, leftPanel.getComponentCount());
        assertEquals("Failed to configure the right panel.", 1, rightPanel.getComponentCount());
    }

    /**
     * <p>
     * Tests PropertiesPanel#getUMLModelManager() for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#getUMLModelManager() is correct.
     * </p>
     */
    public void testGetUMLModelManager() {
        assertSame("Failed to get the UMLModelManager correctly.", manager, propertiesPanel.getUMLModelManager());
    }

    /**
     * <p>
     * Tests PropertiesPanel#configureProject(UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#configureProject(UMLModelManager) is correct.
     * </p>
     */
    public void testConfigureProject() {
        UMLModelManager umlModelManager = new UMLModelManager();
        propertiesPanel.configureProject(umlModelManager);

        assertSame("Failed to configure project correctly.", umlModelManager, propertiesPanel.getUMLModelManager());
    }

    /**
     * <p>
     * Tests PropertiesPanel#configureProject(UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigureProject_NullUmlModelManager() {
        try {
            propertiesPanel.configureProject(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#firePropertyChangeEvent(ModelElement,PropertyKind,
     * PropertyOperation,Object) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#firePropertyChangeEvent(ModelElement,PropertyKind,
     * PropertyOperation,Object) is correct.
     * </p>
     */
    public void testFirePropertyChangeEvent() {
        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);
        propertiesPanel.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ABSTRACT, PropertyOperation.ADD, "test");
        assertTrue("Failed to fire the event correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests PropertiesPanel#firePropertyChangeEvent(ModelElement,PropertyKind,
     * PropertyOperation,Object) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testFirePropertyChangeEvent_NullModelElement() {
        try {
            propertiesPanel.firePropertyChangeEvent(null, PropertyKind.ABSTRACT, PropertyOperation.ADD, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#firePropertyChangeEvent(ModelElement,PropertyKind,
     * PropertyOperation,Object) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when property is null and expects IllegalArgumentException.
     * </p>
     */
    public void testFirePropertyChangeEvent_NullProperty() {
        try {
            propertiesPanel.firePropertyChangeEvent(new GuardImpl(), null, PropertyOperation.ADD, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#firePropertyChangeEvent(ModelElement,PropertyKind,
     * PropertyOperation,Object) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when op is null and expects IllegalArgumentException.
     * </p>
     */
    public void testFirePropertyChangeEvent_NullOp() {
        try {
            propertiesPanel.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ABSTRACT, null, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#fireSelectionChangeEvent(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#fireSelectionChangeEvent(ModelElement) is correct.
     * </p>
     */
    public void testFireSelectionChangeEvent() {
        MockModelElementSelectionListener listener = new MockModelElementSelectionListener();
        propertiesPanel.addModelElementSelectionListener(listener);
        propertiesPanel.fireSelectionChangeEvent(new GuardImpl());
        assertTrue("Failed to fire the event correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests PropertiesPanel#fireSelectionChangeEvent(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testFireSelectionChangeEvent_NullModelElement() {
        try {
            propertiesPanel.fireSelectionChangeEvent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#addModelElementChangeListener(ModelElementChangeListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#addModelElementChangeListener(ModelElementChangeListener) is correct.
     * </p>
     */
    public void testAddModelElementChangeListener() {
        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);
        propertiesPanel.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ABSTRACT, PropertyOperation.ADD, "test");
        assertTrue("Failed to add the listener correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests PropertiesPanel#addModelElementChangeListener(ModelElementChangeListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddModelElementChangeListener_NullListener() {
        try {
            propertiesPanel.addModelElementChangeListener(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeModelElementChangeListener(ModelElementChangeListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#removeModelElementChangeListener(ModelElementChangeListener) is correct.
     * </p>
     */
    public void testRemoveModelElementChangeListener() {
        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);
        propertiesPanel.removeModelElementChangeListener(listener);
        propertiesPanel.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ABSTRACT, PropertyOperation.ADD, "test");
        assertFalse("Failed to remove the listener correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeModelElementChangeListener(ModelElementChangeListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveModelElementChangeListener_NullListener() {
        try {
            propertiesPanel.removeModelElementChangeListener(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeAllModelElementChangeListeners() for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#removeAllModelElementChangeListeners() is correct.
     * </p>
     */
    public void testRemoveAllModelElementChangeListeners() {
        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);
        propertiesPanel.removeAllModelElementChangeListeners();
        propertiesPanel.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ABSTRACT, PropertyOperation.ADD, "test");
        assertFalse("Failed to remove all the listeners correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests PropertiesPanel#addModelElementSelectionListener(ModelElementSelectionListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#addModelElementSelectionListener(ModelElementSelectionListener) is correct.
     * </p>
     */
    public void testAddModelElementSelectionListener() {
        MockModelElementSelectionListener listener = new MockModelElementSelectionListener();
        propertiesPanel.addModelElementSelectionListener(listener);
        propertiesPanel.fireSelectionChangeEvent(new GuardImpl());
        assertTrue("Failed to add the listener correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests PropertiesPanel#addModelElementSelectionListener(ModelElementSelectionListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddModelElementSelectionListener_NullListener() {
        try {
            propertiesPanel.addModelElementSelectionListener(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeModelElementSelectionListener(ModelElementSelectionListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#removeModelElementSelectionListener(ModelElementSelectionListener) is correct.
     * </p>
     */
    public void testRemoveModelElementSelectionListener() {
        MockModelElementSelectionListener listener = new MockModelElementSelectionListener();
        propertiesPanel.addModelElementSelectionListener(listener);
        propertiesPanel.removeModelElementSelectionListener(listener);
        propertiesPanel.fireSelectionChangeEvent(new GuardImpl());
        assertFalse("Failed to remove the listener correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeModelElementSelectionListener(ModelElementSelectionListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveModelElementSelectionListener_NullListener() {
        try {
            propertiesPanel.removeModelElementSelectionListener(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeAllModelElementSelectionListeners() for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#removeAllModelElementSelectionListeners() is correct.
     * </p>
     */
    public void testRemoveAllModelElementSelectionListeners() {
        MockModelElementSelectionListener listener = new MockModelElementSelectionListener();
        propertiesPanel.addModelElementSelectionListener(listener);
        propertiesPanel.removeAllModelElementSelectionListeners();
        propertiesPanel.fireSelectionChangeEvent(new GuardImpl());
        assertFalse("Failed to remove all the listener correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests PropertiesPanel#getStereotypes(Class) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertiesPanel#getStereotypes(Class) is correct.
     * </p>
     */
    public void testGetStereotypes() {
        List<Stereotype> stereotypes = propertiesPanel.getStereotypes(ClassImpl.class);

        assertEquals("Failed to load the stereotype.", 2, stereotypes.size());
    }

    /**
     * <p>
     * Tests PropertiesPanel#getStereotypes(Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElementClass is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetStereotypes_NullModelElementClass() {
        try {
            propertiesPanel.getStereotypes(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}