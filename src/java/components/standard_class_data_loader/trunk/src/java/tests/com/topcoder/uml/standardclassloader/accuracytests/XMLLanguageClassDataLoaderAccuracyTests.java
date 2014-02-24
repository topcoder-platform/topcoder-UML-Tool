/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.accuracytests;

import java.io.File;
import java.util.List;
import java.util.jar.Attributes.Name;

import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.uml.standardclassloader.LanguageClassDataLoader;
import com.topcoder.uml.standardclassloader.implementations.XMLLanguageClassDataLoader;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link XMLLanguageClassDataLoader}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class XMLLanguageClassDataLoaderAccuracyTests extends TestCase {

    /**
     * <p>
     * Represents the xml file that contains the standard java language class data.
     * </p>
     */
    private static final String JAVA_CLASS_DATA = "test_files" + File.separator + "accuracytests" + File.separator
        + "JavaClassData.xml";

    /**
     * <p>
     * Represents the xml file that contains the no class data.
     * </p>
     */
    private static final String EMPTY_CLASS_DATA = "test_files" + File.separator + "accuracytests" + File.separator
        + "EmptyClassData.xml";

    /**
     * <p>
     * Accuracy test for <code>{@link XMLLanguageClassDataLoader#getNamespaces()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetNamespacesAccuracy() throws Exception {
        List<Namespace> namespaces = new XMLLanguageClassDataLoader(JAVA_CLASS_DATA).getNamespaces();
        assertNotNull("will never return null.", namespaces);
        assertTrue("it should contains 5 elements.", namespaces.size() == 5);

        // find the java namespace
        Namespace javaNamespace = null;
        for (Namespace namespace : namespaces) {
            if ("java".equals(namespace.getName())) {
                javaNamespace = namespace;
                break;
            }

            if ("boolean".equals(namespace.getName())) {
                assertTrue("expect Primitive Type.", namespace instanceof Primitive);
            }
        }

        assertNotNull("there should exist a javaNamespace", javaNamespace);
        assertNotNull("javaNamespace should have two sub namespace", javaNamespace.getOwnedElements().size() == 2);

        Namespace langNamespace = null;
        Namespace utilNamespace = null;
        for (ModelElement element : javaNamespace.getOwnedElements()) {
            if ("lang".equals(element.getName())) {
                langNamespace = (Namespace) element;
            }

            if ("util".equals(element.getName())) {
                utilNamespace = (Namespace) element;
            }
        }

        assertNotNull("lang namespace should exist.", langNamespace);
        assertSame("setNamespace should be called", javaNamespace, langNamespace.getNamespace());
        assertNotNull("util namespace should exist.", utilNamespace);
        assertSame("setNamespace should be called", javaNamespace, utilNamespace.getNamespace());

        assertLangNamespace(langNamespace);
        assertUtilNamespace(utilNamespace);
    }

    /**
     * <p>
     * Assert the util namespace.
     * </p>
     * @param utilNamespace
     *            the util namespace.
     */
    private void assertUtilNamespace(Namespace utilNamespace) {
        assertTrue("should have 13 elements.", utilNamespace.getOwnedElements().size() == 13);

        Class randomClass = null;

        // validation setNamespace is called.
        for (ModelElement modelElement : utilNamespace.getOwnedElements()) {
            assertSame("setNamespace method is called", utilNamespace, modelElement.getNamespace());

            if ("Random".equals(modelElement.getName())) {
                assertTrue(modelElement instanceof Class);
                randomClass = (Class) modelElement;
            }

            if ("regex".equals(modelElement.getName())) {
                assertTrue("expect Namespace instance", modelElement instanceof Namespace);
            }
        }

        assertNotNull("Random class not found.", randomClass);
        assertTrue("randomClass should have 10 methods.", randomClass.getFeatures().size() == 10);

        for (Feature feature : randomClass.getFeatures()) {
            assertTrue("should be Method type.", feature instanceof Method);
            assertSame("setOwner method should be called.", feature.getOwner(), randomClass);
        }
    }

    /**
     * <p>
     * Assert the lang sub-namespace.
     * </p>
     * @param langNamespace
     *            the lang namespace instance.
     */
    private void assertLangNamespace(Namespace langNamespace) {
        assertTrue("should have 7 elements.", langNamespace.getOwnedElements().size() == 7);

        // find the Comparable interface.
        Interface comparableInterface = null;
        // validation setNamespace is called.
        for (ModelElement modelElement : langNamespace.getOwnedElements()) {
            assertSame("setNamespace method is called", langNamespace, modelElement.getNamespace());

            if ("Comparable".equals(modelElement.getName())) {
                assertTrue(modelElement instanceof Interface);
                comparableInterface = (Interface) modelElement;
            }

            if ("Thread.State".equals(modelElement.getName())) {
                assertTrue("expect Enumeration instance", modelElement instanceof Enumeration);
            }

            if ("Deprecated".equals(modelElement.getName())) {
                assertTrue("expect DataType instance", modelElement instanceof DataType);
            }
        }

        assertNotNull("Comparable interface should be defined.", comparableInterface);

        // validate the interface.
        assertTrue("contains nothing.", comparableInterface.getOwnedElements().size() == 0);
        assertTrue("contains one feature.", comparableInterface.getFeatures().size() == 1);
        Feature feature = comparableInterface.getFeatures().get(0);
        assertTrue("it should be Method instance.", feature instanceof Method);
        assertEquals("method name is incorrect.", "compareTo", feature.getName());
        assertSame("setOwner method should be called.", feature.getOwner(), comparableInterface);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link XMLLanguageClassDataLoader#getNamespaces()}</code> with empty data file.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetNamespacesAccuracyEmptyClassDataFile() throws Exception {
        LanguageClassDataLoader languageClassDataLoader = new XMLLanguageClassDataLoader(EMPTY_CLASS_DATA);

        List<Namespace> namespaces = languageClassDataLoader.getNamespaces();
        assertTrue("the list should be empty.", namespaces.isEmpty());
    }
}
