/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.failuretests;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.modelelementformatters.JavaExceptionElementFormatter;

import junit.framework.TestCase;


/**
 * Unit tests for JavaExceptionElementFormatter class.
 * @author crackme
 * @version 1.0
 */
public class TestJavaExceptionElementFormatter extends TestCase {
    /**
    * A UMLModelManager used to test.
    */
    private final UMLModelManager m = new UMLModelManager();

    /**
     * A JavaExceptionElementFormatter used to test.
     */
    private JavaExceptionElementFormatter formatter;

    /**
     * Setup the environment for each testcase.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigFile("test_files/failure/conf.xml");

        formatter = new JavaExceptionElementFormatter("JavaExceptionElementFormatter.acc",
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
     * Tests JavaExceptionElementFormatter(UMLModelManager umlModelManager, String
     * language) method with null UMLModelManager umlModelManager, Expected
     * IllegalArgumentException.
     */
    public void testJavaExceptionElementFormatter1_NullUmlModelManager() {
        try {
            new JavaExceptionElementFormatter(null, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests JavaExceptionElementFormatter(UMLModelManager umlModelManager, String
     * language) method with null String language, Expected IllegalArgumentException.
     */
    public void testJavaExceptionElementFormatter1_NullLanguage() {
        try {
            new JavaExceptionElementFormatter(m, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests JavaExceptionElementFormatter(UMLModelManager umlModelManager, String
     * language) method with empty String language, Expected IllegalArgumentException.
     */
    public void testJavaExceptionElementFormatter1_EmptyLanguage() {
        try {
            new JavaExceptionElementFormatter(m, " ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests JavaExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with null String namespace, Expected
     * IllegalArgumentException.
     */
    public void testJavaExceptionElementFormatter_NullNamespace() {
        try {
            new JavaExceptionElementFormatter(null, m, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests JavaExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with empty String namespace, Expected
     * IllegalArgumentException.
     */
    public void testJavaExceptionElementFormatter_EmptyNamespace() {
        try {
            new JavaExceptionElementFormatter(" ", m, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests JavaExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with null UMLModelManager umlModelManager,
     * Expected IllegalArgumentException.
     */
    public void testJavaExceptionElementFormatter_NullUmlModelManager() {
        try {
            new JavaExceptionElementFormatter("namespace", null, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests JavaExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with null String language, Expected
     * IllegalArgumentException.
     */
    public void testJavaExceptionElementFormatter_NullLanguage() {
        try {
            new JavaExceptionElementFormatter("namespace", m, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests JavaExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with empty String language, Expected
     * IllegalArgumentException.
     */
    public void testJavaExceptionElementFormatter_EmptyLanguage() {
        try {
            new JavaExceptionElementFormatter("namespace", m, " ");
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
}
