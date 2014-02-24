/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatter;

/**
 * Contains accuracy tests for the PropertyTemplateDiagramElementFormatter class
 *
 * @author TheCois
 */
public class TestPropertyTemplateDiagramElementFormatter extends TestCase {
    /**
     * Represents the default namespace used to test.
     */
    private static final String testNamespace =
        "com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatter";

    /**
     * PropertyTemplateDiagramElementFormatter instance to be used for the testing.
     */
    private PropertyTemplateDiagramElementFormatter testObject = null;

    /**
     * Sets up the environment for the TestCase.
     *
     * @throws Exception
     */
    protected void setUp() throws Exception {
        Helper.loadConfigFile("accuracy/config.xml");
        testObject = new PropertyTemplateDiagramElementFormatter();
    }

    /**
     * Tears down the environment for the TestCase.
     *
     * @throws Exception
     */
    protected void tearDown() throws Exception {
        testObject = null;
        Helper.clearConfig();
    }

    /**
     * Makes sure PropertyTemplateDiagramElementFormatter#PropertyTemplateDiagramElementFormatter()
     * creates a proper object.
     */
    public void testCtor1_1() {
        assertNotNull("Constructor failed.",
            new PropertyTemplateDiagramElementFormatter());
    }

    /**
     * Makes sure PropertyTemplateDiagramElementFormatter#PropertyTemplateDiagramElementFormatter(String)
     * creates a proper object.
     */
    public void testCtor1_2() {
        assertNotNull("Constructor failed.",
            new PropertyTemplateDiagramElementFormatter(testNamespace));
    }

    /**
     * Makes sure PropertyTemplateDiagramElementFormatter#format(DiagramElement) method
     * works properly.
     *
     * @throws Exception
     */
    public void testFormat() throws Exception {
        GraphNode graphNode = new GraphNode();
        testObject.format(graphNode);

        assertEquals("Format does not add the appropriate number of properties", 1, graphNode.getProperties().size());

        Property elementProperty = new Property();
        elementProperty.setKey("property1");
        elementProperty.setValue("value1");

    }

    /**
     * Makes sure PropertyTemplateDiagramElementFormatter#format(DiagramElement) method
     * works properly.
     *
     * It tests that modifications are not done twice.
     * @throws Exception
     */
    public void testFormat_WhenModificationIsNotRequired() throws Exception {
        GraphNode graphNode = new GraphNode();
        testObject.format(graphNode);

        assertFalse("Format modifies the element twice", testObject.format(graphNode));
    }
}
