/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.accuracytests;

import java.util.List;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.standardclassloader.ClassDataLoaderStrategy;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link ClassDataLoaderStrategy}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ClassDataLoaderStrategyAccuracyTests extends TestCase {

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        AccuracyTestHelper.loadNamespaces();
    }

    /**
     * <p>
     * Tear down the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        AccuracyTestHelper.clearNamespaces();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ClassDataLoaderStrategy#ClassDataLoaderStrategy()}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testClassDataLoaderStrategyAccuracy() throws Exception {
        ClassDataLoaderStrategy classDataLoaderStrategy = new ClassDataLoaderStrategy();

        assertNotNull("instantiation fails", classDataLoaderStrategy);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ClassDataLoaderStrategy#ClassDataLoaderStrategy(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testClassDataLoaderStrategyStringAccuracy1() throws Exception {
        ClassDataLoaderStrategy classDataLoaderStrategy = new ClassDataLoaderStrategy(
            "com.topcoder.uml.standardclassloader.accuracy1");
        assertNotNull("instantiation fails", classDataLoaderStrategy);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ClassDataLoaderStrategy#ClassDataLoaderStrategy(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testClassDataLoaderStrategyStringAccuracy2() throws Exception {
        ClassDataLoaderStrategy classDataLoaderStrategy = new ClassDataLoaderStrategy(
            "com.topcoder.uml.standardclassloader.accuracy2");
        assertNotNull("instantiation fails", classDataLoaderStrategy);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ClassDataLoaderStrategy#ClassDataLoaderStrategy(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testClassDataLoaderStrategyStringAccuracy3() throws Exception {
        ClassDataLoaderStrategy classDataLoaderStrategy = new ClassDataLoaderStrategy(
            "com.topcoder.uml.standardclassloader.accuracy3");
        assertNotNull("instantiation fails", classDataLoaderStrategy);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ClassDataLoaderStrategy#getLanguages()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetLanguagesAccuracy1() throws Exception {
        ClassDataLoaderStrategy classDataLoaderStrategy = new ClassDataLoaderStrategy(
            "com.topcoder.uml.standardclassloader.accuracy1");

        assertNotNull("never return null", classDataLoaderStrategy.getLanguages());
        assertTrue("should be empty", classDataLoaderStrategy.getLanguages().size() == 0);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ClassDataLoaderStrategy#getLanguages()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetLanguagesAccuracy2() throws Exception {
        ClassDataLoaderStrategy classDataLoaderStrategy = new ClassDataLoaderStrategy(
            "com.topcoder.uml.standardclassloader.accuracy2");

        assertNotNull("never return null", classDataLoaderStrategy.getLanguages());
        assertTrue("should have one language.", classDataLoaderStrategy.getLanguages().size() == 1);
        assertTrue("should have one language.", classDataLoaderStrategy.getLanguages().contains("Java"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ClassDataLoaderStrategy#getLanguages()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetLanguagesAccuracy3() throws Exception {
        ClassDataLoaderStrategy classDataLoaderStrategy = new ClassDataLoaderStrategy(
            "com.topcoder.uml.standardclassloader.accuracy3");

        assertNotNull("never return null", classDataLoaderStrategy.getLanguages());
        assertTrue("should have one language.", classDataLoaderStrategy.getLanguages().size() == 2);
        assertTrue("should have one language.", classDataLoaderStrategy.getLanguages().contains("Java"));
        assertTrue("should have one language.", classDataLoaderStrategy.getLanguages().contains("CSharp"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ClassDataLoaderStrategy#getNamespaces(String)}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetNamespacesAccuracy() throws Exception {
        ClassDataLoaderStrategy classDataLoaderStrategy = new ClassDataLoaderStrategy(
            "com.topcoder.uml.standardclassloader.accuracy3");

        List<Namespace> namespaces = classDataLoaderStrategy.getNamespaces("Java");
        assertNotNull("never return null.", namespaces);
        assertTrue("should contains two elements.", namespaces.size() == 2);

        namespaces = classDataLoaderStrategy.getNamespaces("CSharp");
        assertNotNull("never return null.", namespaces);
        assertTrue("should be empty.", namespaces.size() == 0);
    }
}
