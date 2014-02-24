/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.failuretests;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.modelelementformatters.CSharpExceptionElementFormatter;

import junit.framework.TestCase;


/**
 * Unit tests for CSharpExceptionElementFormatter class.
 *
 * @author crackme
 * @version 1.0
 */
public class TestCSharpExceptionElementFormatter extends TestCase {
    /**
     * A UMLModelManager used to test.
     */
    private final UMLModelManager m = new UMLModelManager();

    /**
     * A CSharpExceptionElementFormatter used to test.
     */
    private CSharpExceptionElementFormatter formatter;

    /**
     * Setup the environment for each testcase.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigFile("test_files/failure/conf.xml");

        formatter = new CSharpExceptionElementFormatter("CSharpExceptionElementFormatter.acc",
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
     * Tests CSharpExceptionElementFormatter(UMLModelManager umlModelManager, String
     * language) method with null UMLModelManager umlModelManager, Expected
     * IllegalArgumentException.
     */
    public void testCSharpExceptionElementFormatter1_NullUmlModelManager() {
        try {
            new CSharpExceptionElementFormatter(null, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests CSharpExceptionElementFormatter(UMLModelManager umlModelManager, String
     * language) method with null String language, Expected IllegalArgumentException.
     */
    public void testCSharpExceptionElementFormatter1_NullLanguage() {
        try {
            new CSharpExceptionElementFormatter(m, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests CSharpExceptionElementFormatter(UMLModelManager umlModelManager, String
     * language) method with empty String language, Expected IllegalArgumentException.
     */
    public void testCSharpExceptionElementFormatter1_EmptyLanguage() {
        try {
            new CSharpExceptionElementFormatter(m, " ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests CSharpExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with null String namespace, Expected
     * IllegalArgumentException.
     */
    public void testCSharpExceptionElementFormatter_NullNamespace() {
        try {
            new CSharpExceptionElementFormatter(null, m, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests CSharpExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with empty String namespace, Expected
     * IllegalArgumentException.
     */
    public void testCSharpExceptionElementFormatter_EmptyNamespace() {
        try {
            new CSharpExceptionElementFormatter(" ", m, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests CSharpExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with null UMLModelManager umlModelManager,
     * Expected IllegalArgumentException.
     */
    public void testCSharpExceptionElementFormatter_NullUmlModelManager() {
        try {
            new CSharpExceptionElementFormatter("namespace", null, "java");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests CSharpExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with null String language, Expected
     * IllegalArgumentException.
     */
    public void testCSharpExceptionElementFormatter_NullLanguage() {
        try {
            new CSharpExceptionElementFormatter("namespace", m, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests CSharpExceptionElementFormatter(String namespace, UMLModelManager
     * umlModelManager, String language) method with empty String language, Expected
     * IllegalArgumentException.
     */
    public void testCSharpExceptionElementFormatter_EmptyLanguage() {
        try {
            new CSharpExceptionElementFormatter("namespace", m, " ");
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
