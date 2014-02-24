/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.failuretests;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.modelelementformatters.Java14EnumElementFormatter;

import junit.framework.TestCase;


/**
 * Unit tests for Java14EnumElementFormatter class.
 *
 * @author crackme
 * @version 1.0
 */
public class TestJava14EnumElementFormatter extends TestCase {
    /** A UMLModelManager used to test. */
    private final UMLModelManager m = new UMLModelManager();

    /** A Java14EnumElementFormatter used to test. */
    private Java14EnumElementFormatter formatter;

    /**
     * Setup the environment for each testcase.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigFile("test_files/failure/conf.xml");

        formatter = new Java14EnumElementFormatter("Java14EnumElementFormatter.acc",
                m, "java");
    }

    /**
     * Setup the environment for each testcase.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfig();
    }

    /**
     * Tests Java14EnumElementFormatter(UMLModelManager umlModelManager, String language)
     * method with null UMLModelManager umlModelManager, Expected IllegalArgumentException.
     */
    public void testJava14EnumElementFormatter1_NullUmlModelManager() {
        try {
            new Java14EnumElementFormatter(null, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests Java14EnumElementFormatter(UMLModelManager umlModelManager, String language)
     * method with null String language, Expected IllegalArgumentException.
     */
    public void testJava14EnumElementFormatter1_NullLanguage() {
        try {
            new Java14EnumElementFormatter(m, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests Java14EnumElementFormatter(UMLModelManager umlModelManager, String language)
     * method with empty String language, Expected IllegalArgumentException.
     */
    public void testJava14EnumElementFormatter1_EmptyLanguage() {
        try {
            new Java14EnumElementFormatter(m, " ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests Java14EnumElementFormatter(String namespace, UMLModelManager umlModelManager,
     * String language) method with null String namespace, Expected IllegalArgumentException.
     */
    public void testJava14EnumElementFormatter_NullNamespace() {
        try {
            new Java14EnumElementFormatter(null, m, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests Java14EnumElementFormatter(String namespace, UMLModelManager umlModelManager,
     * String language) method with empty String namespace, Expected IllegalArgumentException.
     */
    public void testJava14EnumElementFormatter_EmptyNamespace() {
        try {
            new Java14EnumElementFormatter(" ", m, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests Java14EnumElementFormatter(String namespace, UMLModelManager umlModelManager,
     * String language) method with null UMLModelManager umlModelManager, Expected
     * IllegalArgumentException.
     */
    public void testJava14EnumElementFormatter_NullUmlModelManager() {
        try {
            new Java14EnumElementFormatter("namespace", null, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests Java14EnumElementFormatter(String namespace, UMLModelManager umlModelManager,
     * String language) method with null String language, Expected IllegalArgumentException.
     */
    public void testJava14EnumElementFormatter_NullLanguage() {
        try {
            new Java14EnumElementFormatter("namespace", m, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests Java14EnumElementFormatter(String namespace, UMLModelManager umlModelManager,
     * String language) method with empty String language, Expected IllegalArgumentException.
     */
    public void testJava14EnumElementFormatter_EmptyLanguage() {
        try {
            new Java14EnumElementFormatter("namespace", m, " ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests format(ModelElement element) method with null ModelElement element, Expected
     * IllegalArgumentException.
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
     * Tests format(ModelElement element) method with invalid configurable file, Expected
     * ProjectConfigurationException.
     */
    public void testFormat_Invalid1() {
        Java14EnumElementFormatter f = new Java14EnumElementFormatter("Java14EnumElementFormatter.fail1",
                m, "Java");

        try {
            f.format(new ClassImpl());
            fail("ProjectConfigurationException should be thrown.");
        } catch (ProjectConfigurationException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests format(ModelElement element) method with invalid configurable file, Expected
     * ProjectConfigurationException.
     */
    public void testFormat_Invalid2() {
        Java14EnumElementFormatter f = new Java14EnumElementFormatter("Java14EnumElementFormatter.fail2",
                m, "Java");

        try {
            f.format(new ClassImpl());
            fail("ProjectConfigurationException should be thrown.");
        } catch (ProjectConfigurationException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }
}
