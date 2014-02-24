/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.failuretests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatter;

import junit.framework.TestCase;


/**
 * Unit tests for PropertyTemplateDiagramElementFormatter class.
 * @author crackme
 * @version 1.0
 */
public class TestPropertyTemplateDiagramElementFormatter extends TestCase {
    /**
     * A PropertyTemplateDiagramElementFormatter used to test.
     */
    private PropertyTemplateDiagramElementFormatter formatter;

    /**
     * Setup the environment for each testcase.
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigFile("test_files/failure/conf.xml");
        formatter = new PropertyTemplateDiagramElementFormatter(
                "PropertyTemplateDiagramElementFormatter.fail");
    }

    /**
     * Setup the environment for each testcase.
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfig();
    }

    /**
     * Tests PropertyTemplateDiagramElementFormatter(String namespace) method with null String namespace,
     * Expected IllegalArgumentException.
     */
    public void testPropertyTemplateDiagramElementFormatter_NullNamespace() {
        try {
            new PropertyTemplateDiagramElementFormatter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests PropertyTemplateDiagramElementFormatter(String namespace) method with empty String namespace,
     * Expected IllegalArgumentException.
     */
    public void testPropertyTemplateDiagramElementFormatter_EmptyNamespace() {
        try {
            new PropertyTemplateDiagramElementFormatter(" ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests format(DiagramElement element) method with null DiagramElement element,
     * Expected IllegalArgumentException.
     */
    public void testFormat_NullElement() {
        try {
            formatter.format(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests format(DiagramElement element) method with invalid DiagramElement element in configurable file,
     * Expected ProjectConfigurationException.
     */
    public void testFormat_InvalidConfElement() {
        try {
            formatter.format(new GraphNode());
            fail("ProjectConfigurationException should be thrown.");
        } catch (ProjectConfigurationException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }
}
