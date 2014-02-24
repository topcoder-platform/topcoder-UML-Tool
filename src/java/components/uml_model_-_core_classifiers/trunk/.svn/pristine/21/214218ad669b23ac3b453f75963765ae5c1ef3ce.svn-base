/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.Class;


/**
 * <p>
 * Provides test for value variable in class of this component.
 * The test cases will be dynamically created in other test files.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ValueVariableTest extends TestCase {
    /**
     * Class under test.
     */
    private final Class classUnderTest;

    /**
     * Method name to invoke.
     */
    private final String methodName;

    /**
     * Class of parameter in the method.
     */
    private final Class paramClass;

    /**
     * Values used to test the method.
     */
    private final Object[] testValues;

    /**
     * Constructor with given parameter.
     *
     * @param name name of test.
     * @param classUnderTest class under test.
     * @param methodName method name.
     * @param paramClass parameter class.
     * @param testValues test values.
     */
    public ValueVariableTest(String name, Class classUnderTest, String methodName, Class paramClass,
        Object[] testValues) {
        super(name);
        this.classUnderTest = classUnderTest;
        this.methodName = methodName;
        this.paramClass = paramClass;
        this.testValues = testValues;
    }

    /**
     * Gets test suite for this class.
     *
     * @return test suite generated.
     */
    public TestSuite getSuite() {
        TestSuite suite = new TestSuite();

        // for each testValue, add tests to suite
        for (int i = 0; i < testValues.length; ++i) {
            suite.addTest(new ValueVariableTest("testSetMethodAccuracy", classUnderTest, methodName, paramClass,
                    new Object[] {testValues[i]}));
            suite.addTest(new ValueVariableTest("testGetMethodAccuracy", classUnderTest, methodName, paramClass,
                    new Object[] {testValues[i]}));
        }

        System.out.println("[VALUE-CLASS-METHOD]" + classUnderTest.getName() + "-" + methodName);

        return suite;
    }

    /**
     * Tests accuracy of method with signature setX(Y), where X is part of method name.
     * Y denotes type of parameter.
     *
     * @throws Exception Exception to JUnit.
     */
    public void testSetMethodAccuracy() throws Exception {
        // create object under test
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);

        // get test value
        Object testValue = testValues[0];

        // set value
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, "set" + methodName, new Class[] {paramClass},
            new Object[] {testValue});

        // get value
        Object returnValue = null;

        if (paramClass.equals(boolean.class)) {
            returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, "is" + methodName,
                    new Class[0], new Object[0]);
        } else {
            returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, "get" + methodName,
                    new Class[0], new Object[0]);
        }

        String description = "Please check " + classUnderTest.getName() + "#[get|set|is]" + methodName;

        // check for return value
        assertEquals("Return value should be correct." + description, testValue, returnValue);
    }

    /**
     * Tests accuracy of method with signature getX() or isX(), where X is part of method name.
     *
     * @throws Exception Exception to JUnit.
     */
    public void testGetMethodAccuracy() throws Exception {
        // create object under test
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);

        // get test value
        Object testValue = testValues[0];

        // set value
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, "set" + methodName, new Class[] {paramClass},
            new Object[] {testValue});

        // get value
        Object returnValue = null;

        if (paramClass.equals(boolean.class)) {
            returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, "is" + methodName,
                    new Class[0], new Object[0]);
        } else {
            returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, "get" + methodName,
                    new Class[0], new Object[0]);
        }

        String description = "Please check " + classUnderTest.getName() + "#[get|set|is]" + methodName;

        // check for return value
        assertEquals("Return value should be correct." + description, testValue, returnValue);
    }
}
