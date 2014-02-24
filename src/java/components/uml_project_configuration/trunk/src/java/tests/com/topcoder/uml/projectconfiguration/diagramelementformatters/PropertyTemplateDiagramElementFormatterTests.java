/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.diagramelementformatters;

import java.io.File;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PropertyTemplateDiagramElementFormatter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PropertyTemplateDiagramElementFormatterTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace for this class.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.diagraminterchange.Reference";

    /**
     * <p>
     * PropertyTemplateDiagramElementFormatter instance for testing.
     * </p>
     */
    private PropertyTemplateDiagramElementFormatter formatter;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "PropertyTemplateDiagramElementFormatter.xml");
        formatter = new PropertyTemplateDiagramElementFormatter(NAMESPACE);
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
        return new TestSuite(PropertyTemplateDiagramElementFormatterTests.class);
    }

    /**
     * <p>
     * Tests ctor PropertyTemplateDiagramElementFormatter#PropertyTemplateDiagramElementFormatter(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created PropertyTemplateDiagramElementFormatter instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Fail to create a new instance of PropertyTemplateDiagramElementFormatter.",
            new PropertyTemplateDiagramElementFormatter(NAMESPACE));
    }

    /**
     * <p>
     * Tests ctor PropertyTemplateDiagramElementFormatter#PropertyTemplateDiagramElementFormatter(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new PropertyTemplateDiagramElementFormatter(null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertyTemplateDiagramElementFormatter#PropertyTemplateDiagramElementFormatter(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new PropertyTemplateDiagramElementFormatter(" ");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PropertyTemplateDiagramElementFormatter#PropertyTemplateDiagramElementFormatter() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created PropertyTemplateDiagramElementFormatter instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Fail to create a new instance of PropertyTemplateDiagramElementFormatter.",
            new PropertyTemplateDiagramElementFormatter());
    }

    /**
     * <p>
     * Tests PropertyTemplateDiagramElementFormatter#format(DiagramElement) for accuracy.
     * </p>
     *
     * <P>
     * It tests the case when the property is not contained and expects true.
     * </P>
     *
     * @throws Exception to JUnit
     */
    public void testFormat_True() throws Exception {
        // Set up the diagram element without any property
        DiagramElement element = new Reference();

        assertTrue("Failed to return correct value.", formatter.format(element));

        Property property1 = new Property();
        property1.setKey("property1");
        property1.setValue("value1");

        Property property2 = new Property();
        property2.setKey("property2");
        property2.setValue("value2");

    }

    /**
     * <p>
     * Tests PropertyTemplateDiagramElementFormatter#format(DiagramElement) for accuracy.
     * </p>
     *
     * <P>
     * It tests the case when the property is contained and expects false.
     * </P>
     *
     * @throws Exception to JUnit
     */
    public void testFormat_False() throws Exception {
        // Set up the DiagramElement instance with two properties
        DiagramElement element = new Reference();
        Property property1 = new Property();
        Property property2 = new Property();

        property1.setKey("property1");
        property1.setValue("value1");
        element.addProperty(property1);

        property2.setKey("property2");
        property2.setValue("value2");
        element.addProperty(property2);

        assertFalse("Failed to return correct value.", formatter.format(element));
    }

    /**
     * <p>
     * Tests PropertyTemplateDiagramElementFormatter#format(DiagramElement) for failure.
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
     * Tests PropertyTemplateDiagramElementFormatter#format(DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It test the namespace is not configed and expected ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_UnknownNamespace() throws Exception {
        TestHelper.clearConfigFile(NAMESPACE);

        try {
            formatter.format(new Reference());

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests PropertyTemplateDiagramElementFormatter#format(DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when no values for the &quot;com.topcoder.diagraminterchange.Reference&quot;
     * property and expected ProjectConfigurationException.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testFormat_NoPropertyValues() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator
            + "PropertyTemplateDiagramElementFormatterNoValue.xml");

        try {
            formatter.format(new Reference());

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }
}