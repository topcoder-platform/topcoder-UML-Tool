/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.Class;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * <p>
 * Provides test for collection and list variable in class of this component.
 * The test cases will be dynamically created in other test files.
 * </p>
 * <p>
 * For a set of methods to test as following:
 * <pre>
 * addConnection(LinkEnd)
 * addConnections(Collection<LinkEnd>)
 * addConnection(int, LinkEnd)
 * addConnections(int, Collection<LinkEnd>)
 * setConnection(int, LinkEnd)
 * removeConnection(int)
 * removeConnection(LinkEnd)
 * removeConnections(Collection<LinkEnd>)
 * clearConnections()
 * countConnections()
 * getConnections()
 * containsConnection(LinkEnd)
 * indexOfConnection(LinkEnd)
 * </pre>
 * singularName will be Connection, pluralName will be Connections,
 * paramClass will be LinkEnd, paramConcreteClass should be some concrete class
 * which implements LinkEnd, if LinkEnd is interface.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CollectionVariableTest extends TestCase {
    /**
     * Class under test.
     */
    private final Class classUnderTest;

    /**
     * Singular name.
     */
    private final String singularName;

    /**
     * Plural name.
     */
    private final String pluralName;

    /**
     * Parameter class.
     */
    private final Class paramClass;

    /**
     * Class of parameter concrete class.
     */
    private final Class paramConcreteClass;

    /**
     * Mapping for invoke-method and parameter.
     */
    private Map<String, Class[]> invokeMethodParamMapping = new HashMap<String, Class[]>();

    /**
     * Mapping for test method and invoke-method.
     */
    private Map<String, String> testInvokeMethodMapping = new HashMap<String, String>();

    /**
     * Test method names.
     */
    private String[] testMethodNames;

    /**
     * Constructor with given information for the test.
     *
     * @param name test name.
     * @param classUnderTest class under test.
     * @param singularName singular name.
     * @param pluralName plural name.
     * @param paramClass parameter class.
     * @param paramConcreteClass parameter concrete class used.
     */
    public CollectionVariableTest(String name, Class classUnderTest, String singularName, String pluralName,
        Class paramClass, Class paramConcreteClass) {
        super(name);
        this.classUnderTest = classUnderTest;
        this.singularName = singularName;
        this.pluralName = pluralName;
        this.paramClass = paramClass;
        this.paramConcreteClass = paramConcreteClass;

        // initialize mapping
        setUpMapping_addX_Y();
        setUpMapping_addXs_Ys();
        setUpMapping_addX_int_Y();
        setUpMapping_addXs_int_Ys();
        setUpMapping_setX_int_Y();
        setUpMapping_removeX_int();
        setUpMapping_removeX_Y();
        setUpMapping_removeXs_Ys();
        setUpMapping_clearXs();
        setUpMapping_countXs();
        setUpMapping_containsX();
        setUpMapping_indexOfX();
        setUpMapping_getXs();

        // get test method names
        testMethodNames = testInvokeMethodMapping.keySet().toArray(new String[0]);

        // check each test method has mapping
        for (int i = 0; i < testMethodNames.length; ++i) {
            if (!testInvokeMethodMapping.containsKey(testMethodNames[i])) {
                throw new IllegalStateException(testMethodNames[i] + " mapping invoke-method is missing.");
            }
        }

        // check each invoke method has param-list mapping
        for (int i = 0; i < testMethodNames.length; ++i) {
            if (!invokeMethodParamMapping.containsKey(testInvokeMethodMapping.get(testMethodNames[i]))) {
                throw new IllegalStateException(testMethodNames[i]
                    + "'s invoke-method's param-list mapping is missing.");
            }
        }
    }

    /**
     * Sets up the mappings for methods with format getXs().
     *
     */
    private void setUpMapping_getXs() {
        String invokeMethodName = "get" + pluralName;
        // getXs()
        putInvokeMethodMapping(invokeMethodName,
            new String[] {"testGetPluralAccuracy1", "testGetPluralAccuracy2", "testGetPluralAccuracy3"});
        invokeMethodParamMapping.put(invokeMethodName, new Class[0]);
    }

    /**
     * Sets up the mappings for methods with format indexOfX().
     *
     */
    private void setUpMapping_indexOfX() {
        String invokeMethodName = "indexOf" + singularName;
        // indexOfX()
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testIndexOfSingularFailureNull", "testIndexOfSingularAccuracy1", "testIndexOfSingularAccuracy2",
                "testIndexOfSingularAccuracy3"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {paramClass});
    }

    /**
     * Sets up the mappings for methods with format containsX().
     *
     */
    private void setUpMapping_containsX() {
        String invokeMethodName = "contains" + singularName;
        // containsX()
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testContainsSingularFailureNull", "testContainsSingularAccuracy1", "testContainsSingularAccuracy2"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {paramClass});
    }

    /**
     * Sets up the mappings for methods with format countXs().
     *
     */
    private void setUpMapping_countXs() {
        String invokeMethodName = "count" + pluralName;
        // countXs()
        putInvokeMethodMapping(invokeMethodName, new String[] {"testCountPluralAccuracy1", "testCountPluralAccuracy2"});
        invokeMethodParamMapping.put(invokeMethodName, new Class[0]);
    }

    /**
     * Sets up the mappings for methods with format clearXs().
     *
     */
    private void setUpMapping_clearXs() {
        String invokeMethodName = "clear" + pluralName;
        // clearXs()
        putInvokeMethodMapping(invokeMethodName, new String[] {"testClearPluralAccuracy1", "testClearPluralAccuracy2"});
        invokeMethodParamMapping.put(invokeMethodName, new Class[0]);
    }

    /**
     * Sets up the mappings for methods with format removeX(Collection_Y_).
     *
     */
    private void setUpMapping_removeXs_Ys() {
        String invokeMethodName = "remove" + pluralName;
        // removeXs(Collection<Y>)
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testRemovePluralFailureNull", "testRemovePluralFailureContainNull", "testRemovePluralAccuracy1",
                "testRemovePluralAccuracyEmpty", "testRemovePluralAccuracyDuplicate1",
                "testRemovePluralAccuracyDuplicate2"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {Collection.class});
    }

    /**
     * Sets up the mappings for methods with format removeX(Y).
     *
     */
    private void setUpMapping_removeX_Y() {
        String invokeMethodName = "remove" + singularName;
        // removeX(Y)
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testRemoveSingularFailureNull", "testRemoveSingularAccuracy1", "testRemoveSingularAccuracy2",
                "testRemoveSingularAccuracyNoValue", "testRemoveSingularAccuracyDuplicate"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {paramClass});
    }

    /**
     * Sets up the mappings for methods with format removeX(int).
     *
     */
    private void setUpMapping_removeX_int() {
        String invokeMethodName = "remove" + singularName + "INT";
        // removeX(int)
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testRemoveSingularIntFailureIndexOutOfRange1", "testRemoveSingularIntFailureIndexOutOfRange2",
                "testRemoveSingularIntFailureIndexOutOfRange3", "testRemoveSingularIntAccuracy1",
                "testRemoveSingularIntAccuracy2"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {int.class});
    }

    /**
     * Sets up the mappings for methods with format setX(int, Y).
     *
     */
    private void setUpMapping_setX_int_Y() {
        String invokeMethodName = "set" + singularName + "INT";
        // setX(int, Y)
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testSetSingularIntFailureNull", "testSetSingularIntFailureIndexOutOfRange1",
                "testSetSingularIntFailureIndexOutOfRange2", "testSetSingularIntFailureIndexOutOfRange3",
                "testSetSingularIntAccuracy1", "testSetSingularIntAccuracy2"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {int.class, paramClass});
    }

    /**
     * Sets up the mappings for methods with format addXs(int, Collection_Y_).
     *
     */
    private void setUpMapping_addXs_int_Ys() {
        String invokeMethodName = "add" + pluralName + "INT";
        // addXs(int, Collection<Y>)
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testAddPluralIntFailureNull", "testAddPluralIntFailureContainNull",
                "testAddPluralIntFailureIndexOutOfRange1", "testAddPluralIntFailureIndexOutOfRange2",
                "testAddPluralIntAccuracy1", "testAddPluralIntAccuracy2", "testAddPluralIntAccuracy3"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {int.class, Collection.class});
    }

    /**
     * Sets up the mappings for methods with format addX(int, Y).
     *
     */
    private void setUpMapping_addX_int_Y() {
        String invokeMethodName = "add" + singularName + "INT";
        // addX(int, Y)
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testAddSingularIntFailureNull", "testAddSingularIntFailureIndexOutOfRange1",
                "testAddSingularIntFailureIndexOutOfRange2", "testAddSingularIntAccuracy1",
                "testAddSingularIntAccuracy2"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {int.class, paramClass});
    }

    /**
     * Sets up the mappings for methods with format addX(Collection_Y_).
     *
     */
    private void setUpMapping_addXs_Ys() {
        String invokeMethodName = "add" + pluralName;
        // addXs(Collection<Y>)
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testAddPluralFailureNull", "testAddPluralFailureContainNull", "testAddPluralAccuracy1",
                "testAddPluralAccuracyEmpty", "testAddPluralAccuracyDuplicate1", "testAddPluralAccuracyDuplicate2"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {Collection.class});
    }

    /**
     * Sets up the mappings for methods with format addX(Y).
     *
     */
    private void setUpMapping_addX_Y() {
        String invokeMethodName = "add" + singularName;
        // addX(Y)
        putInvokeMethodMapping(invokeMethodName,
            new String[] {
                "testAddSingularFailureNull", "testAddSingularAccuracy1", "testAddSingularAccuracy2",
                "testAddSingularAccuracyDuplicate1", "testAddSingularAccuracyDuplicate2"
            });
        invokeMethodParamMapping.put(invokeMethodName, new Class[] {paramClass});
    }

    /**
     * Puts given information to invoke-method map.
     *
     * @param methodName method name to invoke.
     * @param testMethods unit test method names.
     */
    private void putInvokeMethodMapping(String methodName, String[] testMethods) {
        for (int i = 0; i < testMethods.length; ++i) {
            testInvokeMethodMapping.put(testMethods[i], methodName);
        }
    }

    /**
     * Gets test suite for this class.
     *
     * @return test suite generated.
     */
    public TestSuite getSuite() {
        TestSuite suite = new TestSuite();
        Set<String> supportedMethods = new HashSet<String>();

        for (int i = 0; i < testMethodNames.length; ++i) {
            //if (type.getDeclaredMethod(name, parameterTypes))
            try {
                String invokeMethodName = testInvokeMethodMapping.get(testMethodNames[i]);

                try {
                    // try to get method
                    classUnderTest.getMethod(invokeMethodName.replaceAll("INT", ""),
                        invokeMethodParamMapping.get(invokeMethodName));

                    // after check method is gotten correctly, add unit test.
                    suite.addTest(new CollectionVariableTest(testMethodNames[i], classUnderTest, singularName,
                            pluralName, paramClass, paramConcreteClass));
                    supportedMethods.add(invokeMethodName);
                } catch (NoSuchMethodException nsme) {
                    // ignore this method, since there is no definition
                }
            } catch (Exception e) {
                // ignore here, output error message
                System.out.println("Cannot create suite for: " + classUnderTest.getName() + " : " + singularName);
            }
        }

        // log information to std-out
        System.out.println("[COLLECTION-CLASS-VARIABLE]" + classUnderTest.getName() + "-" + singularName);

        int supportedNumber = supportedMethods.size();

        // possible methods
        //addConnection(LinkEnd)
        //addConnections(Collection<LinkEnd>)
        //addConnection(int, LinkEnd)
        //addConnections(int, Collection<LinkEnd>)
        //setConnection(int, LinkEnd)
        //removeConnection(int)
        //removeConnection(LinkEnd)
        //removeConnections(Collection<LinkEnd>)
        //clearConnections()
        //countConnections()
        //getConnections()
        //containsConnection(LinkEnd)
        //indexOfConnection(LinkEnd)
        if ((supportedNumber != 6) && (supportedNumber != 8) && (supportedNumber != 10) && (supportedNumber != 13)) {
            System.out.println("[ERROR]supportedNumber may be wrong:" + supportedNumber);
        }

        System.out.print("" + supportedNumber);

        for (String method : supportedMethods) {
            System.out.print(" " + method);
        }

        System.out.println("");

        return suite;
    }

    /**
     * <p>
     * Tests failure of method with signature addX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Null argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddSingularFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature addX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be added correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularAccuracy1() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddSingularAccuracy1");

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});

        checkResultCollection(objectUnderTest, new Object[] {testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be added correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularAccuracy2() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddSingularAccuracy2");

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue2});

        checkResultCollection(objectUnderTest, new Object[] {testValue1, testValue2},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * To add duplicate values is ok.
     * Value should be added correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularAccuracyDuplicate1() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddSingularAccuracyDuplicate1");

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});

        checkResultCollection(objectUnderTest, new Object[] {testValue1, testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * To add duplicate values is ok.
     * Value should be added correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularAccuracyDuplicate2() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddSingularAccuracyDuplicate2");

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue2});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue2});

        checkResultCollection(objectUnderTest, new Object[] {testValue1, testValue2, testValue1, testValue2},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests failure of method with signature addXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Null argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddPluralFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature addXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Null value in collection argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralFailureContainNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddPluralFailureContainNull");

            // create test value
            Collection<Object> collection = new ArrayList<Object>();
            collection.add(null);

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature addXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralAccuracy1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddPluralAccuracy1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        Collection<Object> collection = new ArrayList<Object>();
        collection.add(testValue1);
        collection.add(testValue2);

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});

        checkResultCollection(objectUnderTest, new Object[] {testValue1, testValue2},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Empty collection argument is acceptable.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralAccuracyEmpty() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddPluralAccuracyEmpty");

        // create test value
        Collection<Object> collection = new ArrayList<Object>();

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});

        checkResultCollection(objectUnderTest, new Object[0],
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Duplicate values are acceptable.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralAccuracyDuplicate1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddPluralAccuracyDuplicate1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Collection<Object> collection = new ArrayList<Object>();
        collection.add(testValue1);
        collection.add(testValue1);

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});

        checkResultCollection(objectUnderTest, new Object[] {testValue1, testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Duplicate values are acceptable.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralAccuracyDuplicate2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddPluralAccuracyDuplicate2");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Collection<Object> collection = new ArrayList<Object>();
        collection.add(testValue1);

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});

        checkResultCollection(objectUnderTest, new Object[] {testValue1, testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests failure of method with signature addX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Null argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularIntFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddSingularIntFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature addX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularIntFailureIndexOutOfRange1()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddSingularIntFailureIndexOutOfRange1");

            // create test value
            Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {-1, testValue1});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature addX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularIntFailureIndexOutOfRange2()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddSingularIntFailureIndexOutOfRange2");

            // create test value
            Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {1, testValue1});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature addX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularIntAccuracy1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddSingularIntAccuracy1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, testValue1});

        checkResultCollection(objectUnderTest, new Object[] {testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddSingularIntAccuracy2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddSingularIntAccuracy2");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, testValue1});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, testValue2});

        checkResultCollection(objectUnderTest, new Object[] {testValue2, testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests failure of method with signature addXs(int, Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Null argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralIntFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddPluralIntFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature addXs(int, Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Null value in collection argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralIntFailureContainNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddPluralIntFailureContainNull");

            // create test value
            Collection<Object> collection = new ArrayList<Object>();
            collection.add(null);

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, collection});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature addXs(int, Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralIntFailureIndexOutOfRange1()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddPluralIntFailureIndexOutOfRange1");

            // create test value
            Collection<Object> collection = new ArrayList<Object>();

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {-1, collection});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature addXs(int, Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralIntFailureIndexOutOfRange2()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testAddPluralIntFailureIndexOutOfRange2");

            // create test value
            Collection<Object> collection = new ArrayList<Object>();

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {1, collection});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature addXs(int, Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralIntAccuracy1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddPluralIntAccuracy1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Collection<Object> collection = new ArrayList<Object>();
        collection.add(testValue1);

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, collection});

        checkResultCollection(objectUnderTest, new Object[] {testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addXs(int, Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralIntAccuracy2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddPluralIntAccuracy2");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Collection<Object> collection1 = new ArrayList<Object>();
        Collection<Object> collection2 = new ArrayList<Object>();
        collection1.add(testValue1);
        collection2.add(testValue2);

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, collection1});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, collection2});

        checkResultCollection(objectUnderTest, new Object[] {testValue2, testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature addXs(int, Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Value should be added.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testAddPluralIntAccuracy3() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testAddPluralIntAccuracy3");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Collection<Object> collection = new ArrayList<Object>();
        collection.add(testValue1);
        collection.add(testValue2);

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, collection});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {1, collection});

        checkResultCollection(objectUnderTest, new Object[] {testValue1, testValue1, testValue2, testValue2},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests failure of method with signature setX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Null argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testSetSingularIntFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testSetSingularIntFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature setX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testSetSingularIntFailureIndexOutOfRange1()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testSetSingularIntFailureIndexOutOfRange1");

            // create test value
            Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {-1, testValue1});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature setX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testSetSingularIntFailureIndexOutOfRange2()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testSetSingularIntFailureIndexOutOfRange2");

            // create test value
            Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, testValue1});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature setX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testSetSingularIntFailureIndexOutOfRange3()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testSetSingularIntFailureIndexOutOfRange3");

            // create test value
            Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {1, testValue1});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature setX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be set.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testSetSingularIntAccuracy1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testSetSingularIntAccuracy1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // add values
        addValues(objectUnderTest, new Object[] {testValue2});

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, testValue1});

        checkResultCollection(objectUnderTest, new Object[] {testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests accuracy of method with signature setX(int, Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be set.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testSetSingularIntAccuracy2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testSetSingularIntAccuracy2");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2});

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {1, testValue1});
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
            invokeMethodParamMapping.get(invokeMethodName), new Object[] {0, testValue2});

        checkResultCollection(objectUnderTest, new Object[] {testValue2, testValue1},
            "Please check " + classUnderTest.getName() + "#" + invokeMethodName);
    }

    /**
     * <p>
     * Tests failure of method with signature removeX(int) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularIntFailureIndexOutOfRange1()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularIntFailureIndexOutOfRange1");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {-1});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature removeX(int) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularIntFailureIndexOutOfRange2()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularIntFailureIndexOutOfRange2");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {1});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature removeX(int) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Index should be in correct range.
     * IndexOutOfBoundsException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularIntFailureIndexOutOfRange3()
        throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularIntFailureIndexOutOfRange3");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName.replaceAll("INT", ""),
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {0});
            fail("IndexOutOfBoundsException should have been thrown out.");
        } catch (IndexOutOfBoundsException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeX(int) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be removed.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularIntAccuracy1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularIntAccuracy1");

        // add values
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        addValues(objectUnderTest, new Object[] {testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest,
                invokeMethodName.replaceAll("INT", ""), invokeMethodParamMapping.get(invokeMethodName),
                new Object[] {0});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertSame("Return value should be correct." + description, testValue1, returnValue);

        checkResultCollection(objectUnderTest, new Object[0], description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeX(int) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be removed.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularIntAccuracy2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularIntAccuracy2");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest,
                invokeMethodName.replaceAll("INT", ""), invokeMethodParamMapping.get(invokeMethodName),
                new Object[] {1});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertSame("Return value should be correct." + description, testValue2, returnValue);

        checkResultCollection(objectUnderTest, new Object[] {testValue1}, description);
    }

    /**
     * <p>
     * Tests failure of method with signature removeX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Null argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be removed correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularAccuracy1() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularAccuracy1");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, true, returnValue);

        checkResultCollection(objectUnderTest, new Object[0], description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value should be removed correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularAccuracy2() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularAccuracy2");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue2});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, true, returnValue);

        checkResultCollection(objectUnderTest, new Object[] {testValue1}, description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Try to remove the value not in the collection will remove nothing.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularAccuracyNoValue() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularAccuracyNoValue");

        // add values
        addValues(objectUnderTest, new Object[] {testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, false, returnValue);

        checkResultCollection(objectUnderTest, new Object[] {testValue2}, description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * To add duplicate values is ok.
     * Value should be removed correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemoveSingularAccuracyDuplicate() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemoveSingularAccuracyDuplicate");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2, testValue1, testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, true, returnValue);

        checkResultCollection(objectUnderTest, new Object[] {testValue2, testValue1, testValue2}, description);
    }

    /**
     * <p>
     * Tests failure of method with signature removeXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Null argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemovePluralFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testRemovePluralFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests failure of method with signature removeXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Null value in collection argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemovePluralFailureContainNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testRemovePluralFailureContainNull");

            // create test value
            Collection<Object> collection = new ArrayList<Object>();
            collection.add(null);

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Value should be removed.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemovePluralAccuracy1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemovePluralAccuracy1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        Collection<Object> collection = new ArrayList<Object>();
        collection.add(testValue1);
        collection.add(testValue2);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, true, returnValue);

        checkResultCollection(objectUnderTest, new Object[0], description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Empty collection argument is acceptable.
     * Value should be removed.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemovePluralAccuracyEmpty() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemovePluralAccuracyEmpty");

        // create test value
        Collection<Object> collection = new ArrayList<Object>();

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, false, returnValue);

        checkResultCollection(objectUnderTest, new Object[0], description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Duplicate values are acceptable.
     * Value should be removed.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemovePluralAccuracyDuplicate1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemovePluralAccuracyDuplicate1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Collection<Object> collection = new ArrayList<Object>();
        collection.add(testValue1);
        collection.add(testValue1);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, true, returnValue);

        checkResultCollection(objectUnderTest, new Object[0], description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature removeXs(Collection_Y_) where X is part of method name,
     * and Y is the type of element in collection under test. Here Xs generally denotes the plural form
     * of the name.
     * Duplicate values are acceptable.
     * Value should be removed.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testRemovePluralAccuracyDuplicate2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testRemovePluralAccuracyDuplicate2");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Collection<Object> collection = new ArrayList<Object>();
        collection.add(testValue1);
        collection.add(testValue2);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {collection});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, true, returnValue);

        checkResultCollection(objectUnderTest, new Object[] {testValue1}, description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature clearXs() where X is part of method name.
     * Here Xs generally denotes the plural form of the name.
     * Value should be removed correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testClearPluralAccuracy1() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testClearPluralAccuracy1");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2});

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[0]);

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        checkResultCollection(objectUnderTest, new Object[0], description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature clearXs() where X is part of method name.
     * Here Xs generally denotes the plural form of the name.
     * Value should be removed correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testClearPluralAccuracy2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testClearPluralAccuracy2");

        // invoke the method to test
        UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
            invokeMethodParamMapping.get(invokeMethodName), new Object[0]);

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        checkResultCollection(objectUnderTest, new Object[0], description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature countXs() where X is part of method name.
     * Here Xs generally denotes the plural form of the name.
     * Value should be removed correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testCountPluralAccuracy1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testCountPluralAccuracy1");

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[0]);

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, 0, returnValue);

        checkResultCollection(objectUnderTest, new Object[0], description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature countXs() where X is part of method name.
     * Here Xs generally denotes the plural form of the name.
     * Value should be removed correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testCountPluralAccuracy2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testCountPluralAccuracy2");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[0]);

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, 2, returnValue);

        checkResultCollection(objectUnderTest, new Object[] {testValue1, testValue2}, description);
    }

    /**
     * <p>
     * Tests accuracy of method with signature containsX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value returned should be correct.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testContainsSingularFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testContainsSingularFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature containsX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value returned should be correct.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testContainsSingularAccuracy1() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testContainsSingularAccuracy1");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2, testValue1, testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, true, returnValue);
    }

    /**
     * <p>
     * Tests accuracy of method with signature containsX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value returned should be correct.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testContainsSingularAccuracy2() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testContainsSingularAccuracy2");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue2});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, false, returnValue);
    }

    /**
     * <p>
     * Tests failure of method with signature indexOfX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Null argument is illegal.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testIndexOfSingularFailureNull() throws Exception {
        try {
            // create object under test, and invoke name
            Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
            String invokeMethodName = testInvokeMethodMapping.get("testIndexOfSingularFailureNull");

            // invoke the method to test
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {null});
            fail("IllegalArgumentException should have been thrown out." + "Please check " + classUnderTest.getName()
                + "#" + invokeMethodName);
        } catch (IllegalArgumentException e) {
            // ok be here
        }
    }

    /**
     * <p>
     * Tests accuracy of method with signature indexOfX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value returned should be correct.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testIndexOfSingularAccuracy1() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testIndexOfSingularAccuracy1");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue2});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, -1, returnValue);
    }

    /**
     * <p>
     * Tests accuracy of method with signature indexOfX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value returned should be correct.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testIndexOfSingularAccuracy2() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testIndexOfSingularAccuracy2");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, 0, returnValue);
    }

    /**
     * <p>
     * Tests accuracy of method with signature indexOfX(Y) where X is part of method name,
     * and Y is the type of element in collection under test.
     * Value returned should be correct.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testIndexOfSingularAccuracy3() throws Exception {
        // create object under test, test values, and invoke name
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testIndexOfSingularAccuracy3");

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {testValue1});

        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, 0, returnValue);
    }

    /**
     * <p>
     * Tests accuracy of method with signature getXs() where X is part of method name,
     * Here Xs generally denotes the plural form of the name.
     * Value should be gotten correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testGetPluralAccuracy1() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testGetPluralAccuracy1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[0]);

        Object[] returnArray = ((Collection) returnValue).toArray();
        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, 2, returnArray.length);
        assertSame("Return value should be correct." + description, testValue1, returnArray[0]);
        assertSame("Return value should be correct." + description, testValue1, returnArray[1]);
    }

    /**
     * <p>
     * Tests accuracy of method with signature getXs() where X is part of method name,
     * Here Xs generally denotes the plural form of the name.
     * Value should be gotten correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testGetPluralAccuracy2() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testGetPluralAccuracy1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);
        Object testValue2 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1, testValue2});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[0]);

        Object[] returnArray = ((Collection) returnValue).toArray();
        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, 2, returnArray.length);
        assertSame("Return value should be correct." + description, testValue1, returnArray[0]);
        assertSame("Return value should be correct." + description, testValue2, returnArray[1]);
    }

    /**
     * <p>
     * Tests accuracy of method with signature getXs() where X is part of method name,
     * Here Xs generally denotes the plural form of the name.
     * Value should be gotten correctly.
     * </p>
     *
     * @throws Exception Exception to JUnit.
     */
    public void testGetPluralAccuracy3() throws Exception {
        // create object under test, and invoke name
        Object objectUnderTest = UnitTestHelper.createInstance(classUnderTest, new Class[0], new Object[0]);
        String invokeMethodName = testInvokeMethodMapping.get("testGetPluralAccuracy1");

        // create test value
        Object testValue1 = UnitTestHelper.createInstance(paramConcreteClass, new Class[0], new Object[0]);

        // add values
        addValues(objectUnderTest, new Object[] {testValue1});

        // invoke the method to test
        Object returnValue = UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[0]);

        Collection returnCollection = (Collection) returnValue;
        String description = "Please check " + classUnderTest.getName() + "#" + invokeMethodName;

        // check for return value
        assertEquals("Return value should be correct." + description, 1, returnCollection.size());

        // try to modify returned collection
        try {
            returnCollection.clear();

            Collection newReturnValue = (Collection) UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest,
                    invokeMethodName, invokeMethodParamMapping.get(invokeMethodName), new Object[0]);
            // check for return value
            assertEquals("Return value should be correct." + description, 1, newReturnValue.size());
        } catch (UnsupportedOperationException uoe) {
            // ok be here
        }
    }

    /**
     * Adds values to collection under test to given object under test.
     *
     * @param objectUnderTest Object under test.
     * @param values Values to add to collection.
     * @throws Exception Exception to JUnit.
     */
    private void addValues(Object objectUnderTest, Object[] values)
        throws Exception {
        // use AddSignular invoke method
        String invokeMethodName = testInvokeMethodMapping.get("testAddSingularAccuracyDuplicate1");

        for (int i = 0; i < values.length; ++i) {
            // invoke the method to add value
            UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest, invokeMethodName,
                invokeMethodParamMapping.get(invokeMethodName), new Object[] {values[i]});
        }
    }

    /**
     * Checks if the values in result collection are same with expected.
     *
     * @param objectUnderTest Object under test.
     * @param expected expected values array.
     * @param description Method under test description, to make things clear.
     * @throws Exception Exception to JUnit.
     */
    private void checkResultCollection(Object objectUnderTest, Object[] expected, String description)
        throws Exception {
        Collection result = (Collection) UnitTestHelper.invokeMethod(objectUnderTest, classUnderTest,
                "get" + pluralName, new Class[0], new Object[0]);
        assertEquals("Number of elements should be correct." + description, expected.length, result.size());

        Object[] resultArray = result.toArray();

        for (int i = 0; i < expected.length; ++i) {
            assertSame("Value of elements should be correct." + description, expected[i], resultArray[i]);
        }
    }
}
