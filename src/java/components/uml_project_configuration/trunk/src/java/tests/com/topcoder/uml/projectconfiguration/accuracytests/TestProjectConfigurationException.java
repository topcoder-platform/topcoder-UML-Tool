/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;

/**
 * Contains the accuracy test cases for the ProjectConfigurationException class.
 *
 * @author TheCois
 */
public class TestProjectConfigurationException extends TestCase {
    /**
     * Value for textual tests
     */
    private final String someText = "just a value";

    /**
     * ProjectConfigurationException#ProjectConfigurationException(String)}
     *
     * Creates an instance and checks its instantiation.
     *
     * @throws Exception
     */
    public void test_Ctor1_1() throws Exception {
        ProjectConfigurationException projectConfigurationException = new ProjectConfigurationException(someText);

        assertNotNull("Constructor failed", projectConfigurationException);

        assertEquals("Attribute initialization failed", someText, projectConfigurationException.getMessage());
    }

    /**
     * ProjectConfigurationException#ProjectConfigurationException(String)}
     *
     * Creates an instance and checks its variables' initialization.
     *
     * @throws Exception
     */
    public void test_Ctor1_2() throws Exception {
        ProjectConfigurationException projectConfigurationException = new ProjectConfigurationException(someText);

        assertEquals("Attribute initialization failed", someText, projectConfigurationException.getMessage());
    }

    /**
     * ProjectConfigurationException#ProjectConfigurationException(String, Throwable) constructor.
     *
     * Creates an instance and checks its instantiation.
     *
     * @throws Exception
     */
    public void test_Ctor2_1() throws Exception {
        Throwable throwable = new Throwable();
        ProjectConfigurationException projectConfigurationException = new ProjectConfigurationException(someText,
            throwable);

        assertNotNull("Constructor failed", projectConfigurationException);
    }
    /**
     * ProjectConfigurationException#ProjectConfigurationException(String, Throwable) constructor.
     *
     * Creates an instance and checks its variables' initialization.
     *
     * @throws Exception
     */
    public void test_Ctor2_2() throws Exception {
        Throwable cause = new IllegalArgumentException();
        ProjectConfigurationException projectConfigurationException = new ProjectConfigurationException(someText,
            cause);

        assertTrue("Attribute initialization failed", projectConfigurationException.getMessage().startsWith(someText));
        assertEquals("Attribute initialization failed", cause, projectConfigurationException.getCause());
    }
}
