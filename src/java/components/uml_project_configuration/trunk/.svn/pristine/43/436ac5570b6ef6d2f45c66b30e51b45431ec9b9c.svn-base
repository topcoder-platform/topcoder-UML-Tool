/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.modelelementformatters;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.InitialElementFormatter;
import com.topcoder.uml.projectconfiguration.MockInitialElementFormatter;
import com.topcoder.uml.projectconfiguration.MockStandardClassDataLoader;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.TestHelper;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AbstractElementFormatter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractElementFormatterTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace used for testing.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.uml.projectconfiguration."
        + "modelelementformatters.AbstractElementFormatter";

    /**
     * <p>
     * AbstractElementFormatter instance for testing.
     * </p>
     */
    private AbstractElementFormatter formatter;

    /**
     * <p>
     * UMLModelManager instance for helping testing.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * ProjectConfigurationManager instance for helping testing.
     * </p>
     */
    private ProjectConfigurationManager projectConfigurationManager;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        umlModelManager = new UMLModelManager();

        // create a project configuration manager instance
        MockStandardClassDataLoader classDataLoader = new MockStandardClassDataLoader();
        XMLStereotypeLoader stereotypeLoader = new XMLStereotypeLoader(NAMESPACE);
        projectConfigurationManager = new ProjectConfigurationManager(umlModelManager, classDataLoader,
            stereotypeLoader, NAMESPACE);

        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);

        formatter = new MockElementFormatter(NAMESPACE, umlModelManager, "Java");

        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        formatter = null;
        projectConfigurationManager = null;
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
        return new TestSuite(AbstractElementFormatterTests.class);
    }

    /**
     * <p>
     * Tests ctor AbstractElementFormatter#AbstractElementFormatter(String,UMLModelManager,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created AbstractElementFormatter should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new instance of AbstractElementFormatter.", formatter);
    }

    /**
     * <p>
     * Tests ctor AbstractElementFormatter#AbstractElementFormatter(String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new MockElementFormatter(null, umlModelManager, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractElementFormatter#AbstractElementFormatter(String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyNamespace() {
        try {
            new MockElementFormatter("", umlModelManager, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractElementFormatter#AbstractElementFormatter(String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when umlModelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullUmlModelManager() {
        try {
            new MockElementFormatter(NAMESPACE, null, "Java");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractElementFormatter#AbstractElementFormatter(String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullLanguage() {
        try {
            new MockElementFormatter(NAMESPACE, umlModelManager, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractElementFormatter#AbstractElementFormatter(String,UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyLanguage() {
        try {
            new MockElementFormatter(NAMESPACE, umlModelManager, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getNamespace() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The correct namespace should be returned.
     * </p>
     */
    public void testGetNamespace() {
        assertEquals("Failed to get create namespace.", NAMESPACE, formatter.getNamespace());
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#validateClassByStereotypeName(String,Class) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Expects true.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testValidateClassByStereotypeName_True() throws Exception {
        // set up a Class instance that represents a Java exception class
        Class classType = new ClassImpl();
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("exception");
        classType.addStereotype(stereotype);

        assertTrue("Failed to return the correct value.", formatter.validateClassByStereotypeName(
            "exceptionStereotypeName", classType));

    }

    /**
     * <p>
     * Tests AbstractElementFormatter#validateClassByStereotypeName(String,Class) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Expects false.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testValidateClassByStereotypeName_False() throws Exception {
        // set up a class which does not represents a Java exception class
        Class classType = new ClassImpl();

        assertFalse("Failed to return the correct value.", formatter.validateClassByStereotypeName(
            "exceptionStereotypeName", classType));
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#validateClassByStereotypeName(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when keyOfStereotypeName is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testValidateClassByStereotypeName_NullKeyOfStereotypeName() throws ProjectConfigurationException {
        try {
            formatter.validateClassByStereotypeName(null, new ClassImpl());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#validateClassByStereotypeName(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when keyOfStereotypeName is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testValidateClassByStereotypeName_EmptyKeyOfStereotypeName() throws ProjectConfigurationException {
        try {
            formatter.validateClassByStereotypeName(" ", new ClassImpl());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#validateClassByStereotypeName(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when classType is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testValidateClassByStereotypeName_NullClassType() throws ProjectConfigurationException {
        try {
            formatter.validateClassByStereotypeName("exceptionStereotypeName", null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#validateClassByStereotypeName(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is not configed and expects ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testValidateClassByStereotypeName_UnknownNamespace() throws Exception {
        TestHelper.clearConfigFile(NAMESPACE);

        try {
            formatter.validateClassByStereotypeName("exceptionStereotypeName", new ClassImpl());

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#validateClassByStereotypeName(String,Class) for failure.
     * Expects ProjectConfigurationException.
     * </p>
     *
     * <p>
     * It tests the &quot;exceptionStereotypeName&quot; property is missing and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testValidateClassByStereotypeName_MissingExceptionStereotypeName() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "AbstractElementFormatterNoValue.xml");

        try {
            formatter.validateClassByStereotypeName("exceptionStereotypeName", new ClassImpl());

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#validateClassByStereotypeName(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the &quot;exceptionStereotypeName&quot; property value is empty and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testValidateClassByStereotypeName_EmptyExceptionStereotypeName() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "AbstractElementFormatterEmptyValue.xml");

        try {
            formatter.validateClassByStereotypeName("exceptionStereotypeName", new ClassImpl());

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }

    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getOperationStereotypeByName(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : It tests the case when the stereotype has been contained in the model and
     * expects it should be returned.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetOperationStereotypeByName() throws Exception {
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("exception");
        stereotype.setBaseClass("BaseException");
        umlModelManager.getModel().addStereotype(stereotype);

        Stereotype newStereotype = formatter.getOperationStereotypeByName("exceptionStereotypeName");

        assertEquals("Failed to get the correct stereotype.", stereotype.getName(), newStereotype.getName());
        assertEquals("Failed to get the correct stereotype.", stereotype.getBaseClass(), newStereotype.getBaseClass());
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getOperationStereotypeByName(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : It tests the case when the stereotype is not contained in the model and
     * expects it should be created and returned.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetOperationStereotypeByName_NewlyCreated() throws Exception {
        projectConfigurationManager.addInitialElementFormatter("Java", new MockInitialElementFormatter());
        Stereotype stereotype = formatter.getOperationStereotypeByName("exceptionStereotypeName");

        assertEquals("Failed to get the correct stereotype.", "exception", stereotype.getName());
        assertEquals("Failed to get the correct stereotype.", "operation", stereotype.getBaseClass());
        // verify the model element has been initially formatted
        assertTrue("Expects the stereotype is initially formatted.", isFormatted(stereotype,
            "Modified by MockInitialElementFormatter"));
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getOperationStereotypeByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when keyOfStereotypeName is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetOperationStereotypeByName_NullKeyOfStereotypeName() throws ProjectConfigurationException {
        try {
            formatter.getOperationStereotypeByName(null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getOperationStereotypeByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when project configuration manager was not set yet
     * and expects IllegalStateException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetOperationStereotypeByName_NotSetProjectConfigurationManager()
        throws ProjectConfigurationException {
        umlModelManager = new UMLModelManager();
        formatter = new MockElementFormatter(NAMESPACE, umlModelManager, "Java");
        try {
            formatter.getOperationStereotypeByName("exceptionStereotypeName");

            fail("IllegalStateException expected.");
        } catch (IllegalStateException ise) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getOperationStereotypeByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when keyOfStereotypeName is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetOperationStereotypeByName_EmptyKeyOfStereotypeName() throws ProjectConfigurationException {
        try {
            formatter.getOperationStereotypeByName(" ");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getOperationStereotypeByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is not configed and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetOperationStereotypeByName_UnknownNamespace() throws Exception {
        TestHelper.clearConfigFile(NAMESPACE);

        try {
            formatter.getOperationStereotypeByName("exceptionStereotypeName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getOperationStereotypeByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the &quot;exceptionStereotypeName&quot; property is missing and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetOperationStereotypeByName_MissingExceptionStereotypeName() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "AbstractElementFormatterNoValue.xml");

        try {
            formatter.getOperationStereotypeByName("exceptionStereotypeName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getOperationStereotypeByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the &quot;exceptionStereotypeName&quot; property is empty and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetOperationStereotypeByName_EmptyExceptionStereotypeName() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "AbstractElementFormatterEmptyValue.xml");

        try {
            formatter.getOperationStereotypeByName("exceptionStereotypeName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getClassByName(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : It tests the case when the class is contained in the model and
     * expects it should be returned.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetClassByName() throws Exception {
        Class type = new ClassImpl();
        type.setName("String");
        umlModelManager.getModel().addOwnedElement(type);

        Class stringClass = formatter.getClassByName("stringClassName");

        assertEquals("Failed to get the correct stereotype.", "String", stringClass.getName());
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getClassByName(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : It tests the case when the class is not contained in the model and
     * expects it should be created and returned.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetClassByName_NewlyCreated() throws Exception {
        projectConfigurationManager.addInitialElementFormatter("Java", new MockInitialElementFormatter());
        Class stringClass = formatter.getClassByName("stringClassName");

        assertEquals("Failed to get the correct stereotype.", "String", stringClass.getName());

        // verify the model element has been initially formatted
        assertTrue("Expects the stereotype is initially formatted", isFormatted(stringClass,
            "Modified by MockInitialElementFormatter"));
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getClassByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when keyOfClassName is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetClassByName_NullKeyOfClassName() throws ProjectConfigurationException {
        try {
            formatter.getClassByName(null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getClassByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when project configuration manager was not set yet
     * and expects IllegalStateException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testtestGetClassByName_NotSetProjectConfigurationManager()
        throws ProjectConfigurationException {
        umlModelManager = new UMLModelManager();
        formatter = new MockElementFormatter(NAMESPACE, umlModelManager, "Java");
        try {
            formatter.getClassByName("enumClassName");

            fail("IllegalStateException expected.");
        } catch (IllegalStateException ise) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getClassByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when keyOfClassName is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetClassByName_EmptyKeyOfClassName() throws ProjectConfigurationException {
        try {
            formatter.getClassByName(" ");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getClassByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is not configed and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit
     */
    public void testGetClassByName_UnknownNamespace() throws Exception {
        TestHelper.clearConfigFile(NAMESPACE);

        try {
            formatter.getClassByName("stringClassName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getClassByName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the &quot;stringClassName&quot; property is missing and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetClassByName_StringClassNameMissing() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "AbstractElementFormatterNoValue.xml");

        try {
            formatter.getClassByName("stringClassName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getClassByName(String) for failure.
     * Expects ProjectConfigurationException.
     * </p>
     *
     * <p>
     * It tests the case when &quot;stringClassName&quot; property value is empty and expects
     * ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetClassByName_EmptyStringClassName() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "AbstractElementFormatterEmptyValue.xml");

        try {
            formatter.getClassByName("stringClassName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#createParameter(String,Class) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The parameter should be created and returned.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testCreateParameter() throws ProjectConfigurationException {
        Class type = new ClassImpl();
        Parameter parameter = formatter.createParameter("parameter", type);

        assertEquals("Failed to return the correct parameter.", "parameter", parameter.getName());
        assertSame("Failed to return the correct parameter.", type, parameter.getType());
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#createParameter(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testCreateParameter_NullName() throws ProjectConfigurationException {
        try {
            formatter.createParameter(null, new ClassImpl());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#createParameter(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testCreateParameter_EmptyName() throws ProjectConfigurationException {
        try {
            formatter.createParameter(" ", new ClassImpl());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#createParameter(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when type is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testCreateParameter_NullType() throws ProjectConfigurationException {
        try {
            formatter.createParameter("parameter", null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#createParameter(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when project configuration manager was not set yet
     * and expects IllegalStateException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testCreateParameter_NotSetProjectconfigurationManager()
        throws ProjectConfigurationException {
        umlModelManager = new UMLModelManager();
        Class type = new ClassImpl();
        formatter = new MockElementFormatter(NAMESPACE, umlModelManager, "Java");

        try {
            formatter.createParameter("parameter", type);

            fail("IllegalStateException expected.");
        } catch (IllegalStateException ise) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#createParameter(String,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the applyInitialFormatting() method throws ProjectConfigurationException
     * and expects the ProjectConfigurationException is thrown by this method too.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCreateParameter_ProjectConfigurationException() throws Exception {
        InitialElementFormatter initialFormatter = new MockInitialElementFormatter();
        projectConfigurationManager.addInitialElementFormatter("Java", initialFormatter);

        // set up the system property to make the initialFormatter throw exception
        // in its format() method
        System.setProperty("exception", "ProjectConfigurationException");

        try {
            formatter.createParameter("parameter", new ClassImpl());

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        } finally {
            // clear the system property
            System.clearProperty("exception");
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The operation is added correctly.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testAddOperation() throws ProjectConfigurationException {
        Set<Stereotype> stereotypes = new HashSet<Stereotype>();
        List<Parameter> parameters = new ArrayList<Parameter>();
        Class classType = new ClassImpl();

        boolean isAdded = formatter.addOperation("operation", VisibilityKind.PUBLIC,
            stereotypes, parameters, classType);

        assertTrue("Failed to add operation.", isAdded);
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     * @throws ProjectConfigurationException to JUnit
     */
    public void testAddOperation_NullName() throws ProjectConfigurationException {
        Class classType = new ClassImpl();

        try {
            formatter.addOperation(null, VisibilityKind.PUBLIC, null, null, classType);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     * @throws ProjectConfigurationException
     */
    public void testAddOperation_EmptyName() throws ProjectConfigurationException {
        try {
            formatter.addOperation("", VisibilityKind.PUBLIC, null, null, new ClassImpl());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when visibility is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testAddOperation_NullVisibility() throws ProjectConfigurationException {
        try {
            formatter.addOperation("operation", null, null, null, new ClassImpl());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when classType is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testAddOperation_NullClassType() throws ProjectConfigurationException {
        try {
            formatter.addOperation("operation", VisibilityKind.PUBLIC, null, null, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when project configuration manager was not set yet
     * and expects IllegalStateException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testAddOperation_NotSetProjectConfigurationManager() throws ProjectConfigurationException {
        umlModelManager = new UMLModelManager();
        Class classType = new ClassImpl();
        formatter = new MockElementFormatter(NAMESPACE, umlModelManager, "Java");

        try {
            formatter.addOperation("operation", VisibilityKind.PUBLIC, null, null, classType);

            fail("IllegalStateException expected.");
        } catch (IllegalStateException ise) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when stereotypes contains null element and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testAddOperation_ContainNullStereotype() throws ProjectConfigurationException {
        Set<Stereotype> stereotypes = new HashSet<Stereotype>();
        stereotypes.add(null);

        try {
            formatter.addOperation("operation", VisibilityKind.PUBLIC, stereotypes, null, new ClassImpl());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when parameters contains null element and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testAddOperation_ContainNullParameter() throws ProjectConfigurationException {
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(null);

        try {
            formatter.addOperation("operation", VisibilityKind.PUBLIC, null, parameters, new ClassImpl());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#addOperation(String,VisibilityKind,Set,List,Class) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the applyInitialFormatting() method throws ProjectConfigurationException
     * and expects the ProjectConfigurationException is thrown by this method too.
     * </p>
     */
    public void testAddOperation_ProjectConfigurationException() {
        // set up the system property to make the initialFormatter throw exception
        // in its format() method
        System.setProperty("exception", "ProjectConfigurationException");

        Set<Stereotype> stereotypes = new HashSet<Stereotype>();
        List<Parameter> parameters = new ArrayList<Parameter>();

        InitialElementFormatter format = new MockInitialElementFormatter();
        projectConfigurationManager.addInitialElementFormatter("Java", format);

        try {
            formatter.addOperation("operation", VisibilityKind.PUBLIC, stereotypes, parameters, new ClassImpl());

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        } finally {
            // clear the system property
            System.clearProperty("exception");
        }
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getUMLModelManager() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The same UML model manager should be returned.
     * </p>
     */
    public void testGetUMLModelManager() {
        assertSame("Failed to return correct value.", umlModelManager, formatter.getUMLModelManager());
    }

    /**
     * <p>
     * Tests AbstractElementFormatter#getLanguage() for accuracy.
     * </p>
     *
     * <p>
     * Verify : &quot;Java&quot; should be returned.
     * </p>
     */
    public void testGetLanguage() {
        assertEquals("Failed to return correct value.", "Java", formatter.getLanguage());
    }

    /**
     * <p>
     * Return true if the given modelElement has a comment with the given name
     * </p>
     *
     * @param modelElement the given modelElement to check
     * @param name the comment name
     *
     * @return true if the given modelElement has a comment with the given name,
     * otherwise false
     */
    private boolean isFormatted(ModelElement modelElement, String name) {
        Collection<Comment> commnets = modelElement.getComments();
        for (Comment comment : commnets) {
            if (name.equals(comment.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * This is a mock implementation of AbstractElementFormatter.
     * </p>
     *
     * <p>
     * It is only used for testing.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public final class MockElementFormatter extends AbstractElementFormatter {
        /**
         * <p>
         * Constructor.
         * </p>
         *
         * @param namespace the namespace used by AbstractElementFormatter
         * @param umlModelManager the UML model manager used by AbstractElementFormatter
         * @param language the language used by AbstractElementFormatter
         */
        protected MockElementFormatter(String namespace, UMLModelManager umlModelManager, String language) {
            super(namespace, umlModelManager, language);
        }

    }

}