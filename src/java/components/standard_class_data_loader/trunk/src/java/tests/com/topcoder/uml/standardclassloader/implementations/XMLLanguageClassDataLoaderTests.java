/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.implementations;

import java.io.File;

import org.w3c.dom.Element;

import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.uml.standardclassloader.ClassDataLoaderConfigurationException;
import com.topcoder.uml.standardclassloader.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for XMLLanguageClassDataLoader.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMLLanguageClassDataLoaderTests extends TestCase {
    /**
     * <p>
     * This constant represents the file name to be used for testing.
     * </p>
     */
    private static final String FILENAME = "test_files" + File.separator + "sampleJavaFile.xml";

    /**
     * <p>
     * The XMLLanguageClassDataLoader instance for helping testing.
     * </p>
     */
    private XMLLanguageClassDataLoader loader;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        loader = new XMLLanguageClassDataLoader(FILENAME);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        loader = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(XMLLanguageClassDataLoaderTests.class);
    }

    /**
     * <p>
     * Tests ctor XMLLanguageClassDataLoader#XMLLanguageClassDataLoader(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created XMLLanguageClassDataLoader instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new XMLLanguageClassDataLoader instance.", loader);
    }

    /**
     * <p>
     * Tests ctor XMLLanguageClassDataLoader#XMLLanguageClassDataLoader(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when file name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullFilename() {
        try {
            new XMLLanguageClassDataLoader(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor XMLLanguageClassDataLoader#XMLLanguageClassDataLoader(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when file name is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyFilename() {
        try {
            new XMLLanguageClassDataLoader(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#getNamespaces() for accuracy.
     * </p>
     *
     * <p>
     * Verify : XMLLanguageClassDataLoader#getNamespaces() is correct.
     * </p>
     *
     * @throws ClassDataLoaderConfigurationException to JUnit
     */
    public void testGetNamespaces() throws ClassDataLoaderConfigurationException {
        assertEquals("Expected the size of the namespace list is four.", 5, loader.getNamespaces().size());
        assertEquals("Failed to get the correct namespace list.", "java", loader.getNamespaces().get(0).getName());
        assertEquals("Failed to get the correct namespace list.", "boolean", loader.getNamespaces().get(1).getName());
        assertEquals("Failed to get the correct namespace list.", "char", loader.getNamespaces().get(2).getName());
        assertEquals("Failed to get the correct namespace list.", "int", loader.getNamespaces().get(3).getName());
        assertEquals("Failed to get the correct namespace list.", "long", loader.getNamespaces().get(4).getName());
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#getNamespaces() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the file name is not exist and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testGetNamespaces_FileNameNotExist() {
        loader = new XMLLanguageClassDataLoader("test");
        try {
            loader.getNamespaces();
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#getNamespaces() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the root node is not StandardClassData
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testGetNamespaces_NotStandardClassData() {
        loader = new XMLLanguageClassDataLoader("test_files" + File.separator + "NotStandardClassDataFile.xml");
        try {
            loader.getNamespaces();
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#getNamespaces() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element is invalid and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testGetNamespaces_InvalidElement() {
        loader = new XMLLanguageClassDataLoader("test_files" + File.separator + "invalidElementJavaFile.xml");
        try {
            loader.getNamespaces();
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadNamespace(Element) for accuracy.
     * </p>
     *
     * <p>
     * Verify : XMLLanguageClassDataLoader#loadNamespace(Element) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadNamespace() throws Exception {
        String xmlFile = "test_files" + File.separator + "namespaceJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);
        Namespace namespace = loader.loadNamespace(elt);

        assertEquals("Expected the return namespace has 2 elements.", 2, namespace.getOwnedElements().size());
        assertEquals("Failed to return the correct namespace.", "java", namespace.getName());
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadNamespace(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testLoadNamespace_NullElt() {
        try {
            loader.loadNamespace(null);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadNamespace(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element has not the tag name Namespace
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadNamespace_NoNamespaceTag() throws Exception {
        String xmlFile = "test_files" + File.separator + "noNamespaceJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadNamespace(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadNamespace(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the attribute of the element is empty
     * and expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadNamespace_EmtptyNamespaceAttr() throws Exception {
        String xmlFile = "test_files" + File.separator + "emtptyNamespaceAttrJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadNamespace(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadNamespace(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element is invalid and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadNamespace_InavalidNamespace() throws Exception {
        String xmlFile = "test_files" + File.separator + "inavalidNamespaceJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadNamespace(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadInterface(Element) for accuracy.
     * </p>
     *
     * <p>
     * Verify : XMLLanguageClassDataLoader#loadInterface(Element) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadInterface() throws Exception {
        String xmlFile = "test_files" + File.separator + "interfaceJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);
        Interface interfaceImpl = loader.loadInterface(elt);

        // assert the features of interfaceImpl
        assertEquals("Expected the return interface has 1 feature.", 1, interfaceImpl.getFeatures().size());
        assertEquals("Failed to return the correct interface.", "Comparable", interfaceImpl.getName());
        assertEquals("Failed to return the correct interface.", "compareTo",
            interfaceImpl.getFeatures().iterator().next().getName());

        // assert the ownedElement of interfaceImpl
        assertEquals("Expected the return interface has 2 ownedElement.", 2, interfaceImpl.getOwnedElements().size());
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadInterface(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testLoadInterface_NullElt() {
        try {
            loader.loadInterface(null);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadInterface(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element has not the tag name Interface and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadInterface_NoInterfaceTag() throws Exception {
        String xmlFile = "test_files" + File.separator + "noInterfaceJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadInterface(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadInterface(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the attribute of the element is empty and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadInterface_EmptyInterfaceAttr() throws Exception {
        String xmlFile = "test_files" + File.separator + "emptyInterfaceAttrFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadInterface(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadInterface(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the attribute of the method is empty and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadInterface_EmptyMethodAttr() throws Exception {
        String xmlFile = "test_files" + File.separator + "emptyMethodAttrFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadInterface(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadInterface(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element of the interface is invalid and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadInterface_InvalidInterfaceElement() throws Exception {
        String xmlFile = "test_files" + File.separator + "invalidInterfaceJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadInterface(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadDataType(Element) for accuracy.
     * </p>
     *
     * <p>
     * Verify : XMLLanguageClassDataLoader#loadDataType(Element) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadDataType() throws Exception {
        String xmlFile = "test_files" + File.separator + "dataTypeJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        DataType dataType = loader.loadDataType(elt);

        assertEquals("Failed to return the correct data type.", "Deprecated", dataType.getName());
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadDataType(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testLoadDataType_NullElt() {
        try {
            loader.loadDataType(null);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadDataType(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element has not the tag name DataType and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadDataType_NoDataTypeTage() throws Exception {
        String xmlFile = "test_files" + File.separator + "noDataTypeJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadDataType(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadDataType(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the attribute of the element is empty and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadDataType_EmptyDataTypeAttr() throws Exception {
        String xmlFile = "test_files" + File.separator + "emptyDataTypeJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadDataType(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadEnumeration(Element) for accuracy.
     * </p>
     *
     * <p>
     * Verify : XMLLanguageClassDataLoader#loadEnumeration(Element) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadEnumeration() throws Exception {
        String xmlFile = "test_files" + File.separator + "enumerationJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        Enumeration enumeration = loader.loadEnumeration(elt);

        assertEquals("Failed to return the correct enumeration.", "Thread.State", enumeration.getName());
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadEnumeration(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testLoadEnumeration_NullElt() {
        try {
            loader.loadEnumeration(null);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadEnumeration(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element has not the tag name Enumeration and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadEnumeration_NoEnumerationTag() throws Exception {
        String xmlFile = "test_files" + File.separator + "noEnumerationJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadEnumeration(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadEnumeration(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the attribute of the element is empty and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadEnumeration_EmptyEnumerationAttr() throws Exception {
        String xmlFile = "test_files" + File.separator + "emptyEnumerationJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadEnumeration(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadPrimitive(Element) for accuracy.
     * </p>
     *
     * <p>
     * Verify : XMLLanguageClassDataLoader#loadPrimitive(Element) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadPrimitive() throws Exception {
        String xmlFile = "test_files" + File.separator + "primitiveJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        Primitive primitive = loader.loadPrimitive(elt);

        assertEquals("Failed to return the correct primitive.", "boolean", primitive.getName());
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadPrimitive(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testLoadPrimitive_NullElt() {
        try {
            loader.loadPrimitive(null);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadPrimitive(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element has not the tag name Primitive and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadPrimitive_NoPrimitiveTag() throws Exception {
        String xmlFile = "test_files" + File.separator + "noPrimitiveJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadPrimitive(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadPrimitive(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the attribute of the element is empty and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadPrimitive_EmptyPrimitiveAttr() throws Exception {
        String xmlFile = "test_files" + File.separator + "emptyPrimitiveJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadPrimitive(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadClass(Element) for accuracy.
     * </p>
     *
     * <p>
     * Verify : XMLLanguageClassDataLoader#loadClass(Element) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadClass() throws Exception {
        String xmlFile = "test_files" + File.separator + "classJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        Class classImpl = loader.loadClass(elt);

        // assert the features of classImpl
        assertEquals("Expected the return class has 5 features.", 5, classImpl.getFeatures().size());
        assertEquals("Failed to return the correct interface.", "Random", classImpl.getName());

        // assert the ownedElement of classImpl
        assertEquals("Expected the return class has 2 ownedElements.", 2, classImpl.getOwnedElements().size());
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadClass(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects ClassDataLoaderConfigurationException.
     * </p>
     */
    public void testLoadClass_NullElt() {
        try {
            loader.loadClass(null);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadClass(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element has not the tag name Class and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadClass_NoClassTag() throws Exception {
        String xmlFile = "test_files" + File.separator + "noClassJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadClass(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadClass(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the attribute of the element is empty and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadClass_EmptyClassAttr() throws Exception {
        String xmlFile = "test_files" + File.separator + "emptyClassJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadClass(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadClass(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the attribute of the method is empty and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadClass_EmptyMethodOfClassAttr() throws Exception {
        String xmlFile = "test_files" + File.separator + "emptyMethodOfClassJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadClass(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLLanguageClassDataLoader#loadClass(Element) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the class element is invalid and
     * expects ClassDataLoaderConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testLoadClass_InvalidClassElement() throws Exception {
        String xmlFile = "test_files" + File.separator + "invalidClassJavaFile.xml";
        Element elt = TestHelper.parseDOMDocument(xmlFile);

        try {
            loader.loadClass(elt);
            fail("ClassDataLoaderConfigurationException expected.");
        } catch (ClassDataLoaderConfigurationException e) {
            //good
        }
    }

}