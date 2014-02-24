/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.failuretests;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.uml.standardclassloader.ClassDataLoaderConfigurationException;
import com.topcoder.uml.standardclassloader.implementations.XMLLanguageClassDataLoader;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * This class contains unit tests for XMLLanguageClassDataLoader class.
 *
 * @author qiucx0161
 * @version 1.0
 */
public class FailureTestXMLLanguageClassDataLoader extends TestCase {
    /**
     * The XMLLanguageClassDataLoader instance used to test.
     */
    private XMLLanguageClassDataLoader loader = null;

    /**
     * The CustomXMLLanguageClassDataLoader instance used to test.
     */
    private CustomXMLLanguageClassDataLoader custom = null;

    /**
     * Set Up the test environment before testing.
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        loader = new XMLLanguageClassDataLoader(
                "test_files/failure/JavaFile.xml");

        custom = new CustomXMLLanguageClassDataLoader(
                "test_files/failure/JavaFile.xml");
    }

    /**
     * Clean up the test environment after testing.
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Tests <code>XMLLanguageClassDataLoader(String filename)</code> method
     * for failure with null Filename.
     * IllegalArgumentException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testXMLLanguageClassDataLoaderNullFilename()
        throws Exception {
        try {
            new XMLLanguageClassDataLoader(null);
            fail("testXMLLanguageClassDataLoaderNullFilename is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>XMLLanguageClassDataLoader(String filename)</code> method
     * for failure with empty Filename,
     * IllegalArgumentException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testXMLLanguageClassDataLoaderEmptyFilename()
        throws Exception {
        try {
            new XMLLanguageClassDataLoader(" ");
            fail("testXMLLanguageClassDataLoaderEmptyFilename is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>getNamespaces()</code> method
     * for failure with invalid root element,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testGetNamespacesInvalid_StandardClassData()
        throws Exception {
        loader = new XMLLanguageClassDataLoader(
                "test_files/failure/xml/Invalid_StandardClassData.xml");

        try {
            loader.getNamespaces();
            fail("testGetNamespacesInvalid_StandardClassData is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadNamespace(Element elt)</code> method
     * for failure with invalid Namespace element : invalid tag,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadNamespaceInvalid_Namespace_InvalidTag()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Namespace_InvalidTag.xml");

        try {
            custom.loadNamespace(elt);
            fail("testLoadNamespaceInvalid_Namespace_InvalidTag is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadNamespace(Element elt)</code> method
     * for failure with invalid Namespace element : invalid child,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadNamespaceInvalid_Namespace_InvalidChild1()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Namespace_InvalidChild1.xml");

        try {
            custom.loadNamespace(elt);
            fail("testLoadNamespaceInvalid_Namespace_InvalidChild1 is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadNamespace(Element elt)</code> method
     * for failure with invalid Namespace element : invalid child,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadNamespaceInvalid_Namespace_InvalidChild2()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Namespace_InvalidChild2.xml");

        try {
            custom.loadNamespace(elt);
            fail("testLoadNamespaceInvalid_Namespace_InvalidChild2 is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadNamespace(Element elt)</code> method
     * for failure with invalid Namespace element : invalid child,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadNamespaceInvalid_Namespace_InvalidChild3()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Namespace_InvalidChild3.xml");

        try {
            custom.loadNamespace(elt);
            fail("testLoadNamespaceInvalid_Namespace_InvalidChild3 is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadNamespace(Element elt)</code> method
     * for failure with invalid Namespace element : invalid child,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadNamespaceInvalid_Namespace_InvalidChild4()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Namespace_InvalidChild4.xml");

        try {
            custom.loadNamespace(elt);
            fail("testLoadNamespaceInvalid_Namespace_InvalidChild4 is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadNamespace(Element elt)</code> method
     * for failure with invalid Namespace element : Missing name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadNamespaceInvalid_Namespace_InvalidName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Namespace_InvalidName.xml");

        try {
            custom.loadNamespace(elt);
            fail("testLoadNamespaceInvalid_Namespace_InvalidName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadNamespace(Element elt)</code> method
     * for failure with invalid Namespace element : Missing name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadNamespaceInvalid_Namespace_MissingName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Namespace_MissingName.xml");

        try {
            custom.loadNamespace(elt);
            fail("testLoadNamespaceInvalid_Namespace_MissingName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadNamespace(Element elt)</code> method
     * for failure with invalid Namespace element : Empty name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadNamespaceInvalid_Namespace_EmptyName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Namespace_EmptyName.xml");

        try {
            custom.loadNamespace(elt);
            fail("testLoadNamespaceInvalid_Namespace_EmptyName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadClass(Element elt)</code> method
     * for failure with invalid Class element : invalid tag,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadClassInvalid_Class_InvalidTag()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Class_InvalidTag.xml");

        try {
            custom.loadClass(elt);
            fail("testLoadClassInvalid_Class_InvalidTag is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadClass(Element elt)</code> method
     * for failure with invalid Class element : invalid child,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadClassInvalid_Class_InvalidChild1()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Class_InvalidChild1.xml");

        try {
            custom.loadClass(elt);
            fail("testLoadClassInvalid_Class_InvalidChild1 is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadClass(Element elt)</code> method
     * for failure with invalid Class element : invalid child,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadClassInvalid_Class_InvalidChild2()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Class_InvalidChild2.xml");

        try {
            custom.loadClass(elt);
            fail("testLoadClassInvalid_Class_InvalidChild2 is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadClass(Element elt)</code> method
     * for failure with invalid Class element : Missing name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadClassInvalid_Class_MissingName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Class_MissingName.xml");

        try {
            custom.loadClass(elt);
            fail("testLoadClassInvalid_Class_MissingName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadClass(Element elt)</code> method
     * for failure with invalid Class element : Empty name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadClassInvalid_Class_EmptyName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Class_EmptyName.xml");

        try {
            custom.loadClass(elt);
            fail("testLoadClassInvalid_Class_EmptyName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadInterface(Element elt)</code> method
     * for failure with invalid Interface element : invalid tag,
     * InterfaceDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadInterfaceInvalid_Interface_InvalidTag()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Interface_InvalidTag.xml");

        try {
            custom.loadInterface(elt);
            fail("testLoadInterfaceInvalid_Interface_InvalidTag is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadInterface(Element elt)</code> method
     * for failure with invalid Interface element : invalid child,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadInterfaceInvalid_Interface_InvalidChild1()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Interface_InvalidChild1.xml");

        try {
            custom.loadInterface(elt);
            fail("testLoadInterfaceInvalid_Interface_InvalidChild1 is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadInterface(Element elt)</code> method
     * for failure with invalid Interface element : invalid child,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadInterfaceInvalid_Interface_InvalidChild2()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Interface_InvalidChild2.xml");

        try {
            custom.loadInterface(elt);
            fail("testLoadInterfaceInvalid_Interface_InvalidChild2 is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadInterface(Element elt)</code> method
     * for failure with invalid Interface element : Missing name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadInterfaceInvalid_Interface_MissingName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Interface_MissingName.xml");

        try {
            custom.loadInterface(elt);
            fail("testLoadInterfaceInvalid_Interface_MissingName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadInterface(Element elt)</code> method
     * for failure with invalid Interface element : Empty name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadInterfaceInvalid_Interface_EmptyName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Interface_EmptyName.xml");

        try {
            custom.loadInterface(elt);
            fail("testLoadInterfaceInvalid_Interface_EmptyName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadDataType(Element elt)</code> method
     * for failure with invalid DataType element : invalid tag,
     * DataTypeDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadDataTypeInvalid_DataType_InvalidTag()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_DataType_InvalidTag.xml");

        try {
            custom.loadDataType(elt);
            fail("testLoadDataTypeInvalid_DataType_InvalidTag is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadDataType(Element elt)</code> method
     * for failure with invalid DataType element : Missing name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadDataTypeInvalid_DataType_MissingName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_DataType_MissingName.xml");

        try {
            custom.loadDataType(elt);
            fail("testLoadDataTypeInvalid_DataType_MissingName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadDataType(Element elt)</code> method
     * for failure with invalid DataType element : Empty name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadDataTypeInvalid_DataType_EmptyName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_DataType_EmptyName.xml");

        try {
            custom.loadDataType(elt);
            fail("testLoadDataTypeInvalid_DataType_EmptyName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadEnumeration(Element elt)</code> method
     * for failure with invalid Enumeration element : invalid tag,
     * EnumerationDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadEnumerationInvalid_Enumeration_InvalidTag()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Enumeration_InvalidTag.xml");

        try {
            custom.loadEnumeration(elt);
            fail(
                "testLoadEnumerationInvalid_Enumeration_InvalidTag is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadEnumeration(Element elt)</code> method
     * for failure with invalid Enumeration element : Missing name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadEnumerationInvalid_Enumeration_MissingName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Enumeration_MissingName.xml");

        try {
            custom.loadEnumeration(elt);
            fail(
                "testLoadEnumerationInvalid_Enumeration_MissingName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadEnumeration(Element elt)</code> method
     * for failure with invalid Enumeration element : Empty name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadEnumerationInvalid_Enumeration_EmptyName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Enumeration_EmptyName.xml");

        try {
            custom.loadEnumeration(elt);
            fail("testLoadEnumerationInvalid_Enumeration_EmptyName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadPrimitive(Element elt)</code> method
     * for failure with invalid Primitive element : invalid tag,
     * PrimitiveDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadPrimitiveInvalid_Primitive_InvalidTag()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Primitive_InvalidTag.xml");

        try {
            custom.loadPrimitive(elt);
            fail("testLoadPrimitiveInvalid_Primitive_InvalidTag is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadPrimitive(Element elt)</code> method
     * for failure with invalid Primitive element : Missing name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadPrimitiveInvalid_Primitive_MissingName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Primitive_MissingName.xml");

        try {
            custom.loadPrimitive(elt);
            fail("testLoadPrimitiveInvalid_Primitive_MissingName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * Tests <code>loadPrimitive(Element elt)</code> method
     * for failure with invalid Primitive element : Empty name,
     * ClassDataLoaderConfigurationException should be thrown.
     * @throws Exception to JUnit.
     */
    public void testLoadPrimitiveInvalid_Primitive_EmptyName()
        throws Exception {
        Element elt = FailureTestXMLLanguageClassDataLoader.getElement(
                "test_files/failure/xml/Invalid_Primitive_EmptyName.xml");

        try {
            custom.loadPrimitive(elt);
            fail("testLoadPrimitiveInvalid_Primitive_EmptyName is failure.");
        } catch (ClassDataLoaderConfigurationException iae) {
            // pass
        }
    }

    /**
     * It used to load the Element from xml file. the root node is "StandardClassData"
     * and there is only one sub element under root node, which will be used to test.
     * @param filename the xml file.
     * @return the sub element of root node.
     * @throws Exception to JUnit.
     */
    private static Element getElement(String filename)
        throws Exception {
        // Create an object of DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the file
        Document doc = builder.parse(filename);

        // Get the root node
        return doc.getDocumentElement();
    }

    /**
     * This class extends from XMLLanguageClassDataLoader used to test the protected methods
     * in XMLLanguageClassDataLoader.
     *
     */
    final class CustomXMLLanguageClassDataLoader
        extends XMLLanguageClassDataLoader {
        /**
             * create CustomXMLLanguageClassDataLoader instance with file name for parameter.
             * @param filename the file name.
             */
        public CustomXMLLanguageClassDataLoader(String filename) {
            super(filename);
        }

        /**
        * <p>
        * Loads a <code>Namespace</code> element from the given DOM Element.
        * </p>
        * <p>
        * A <code>Namespace</code> could have owned elements Namespace, Class,
        * Interface, DataType, Primitive and Enumeration.
        * </p>
        * @param elt
        *            The DOM Element to load from.
        * @return An instance of Namespace, with data from the given Element.
        * @throws ClassDataLoaderConfigurationException
        *             If the DOM Element is a wrong type (The tag is not
        *             "Namespace"), any child nodes cannot be parsed or the "name"
        *             attribute is missing/empty.
        */
        public Namespace loadNamespace(Element elt)
            throws ClassDataLoaderConfigurationException {
            return super.loadNamespace(elt);
        }

        /**
         * <p>
         * Loads a <code>Class</code> element from the given DOM Element.
         * </p>
         * <p>
         * A <code>Class</code> could have owned elements Namespace, Class,
         * Interface, DataType, Primitive, Enumeration and the feature Method.
         * </p>
         * @param elt
         *            The DOM Element to load from.
         * @return An instance of Class, with data from the given Element.
         * @throws ClassDataLoaderConfigurationException
         *             If the DOM Element is a wrong type (The tag is not "Class"),
         *             any child nodes cannot be parsed or the "name" attribute is
         *             missing/empty.
         */
        public Class loadClass(Element elt)
            throws ClassDataLoaderConfigurationException {
            return super.loadClass(elt);
        }

        /**
         * <p>
         * Loads a <code>Interface</code> element from the given DOM Element.
         * </p>
         * <p>
         * An <code>Interface</code> could have owned elements Namespace, Class,
         * Interface, DataType, Primitive, Enumeration and the feature Method.
         * </p>
         * @param elt
         *            The DOM Element to load from.
         * @return An instance of Interface, with data from the given Element.
         * @throws ClassDataLoaderConfigurationException
         *             If the DOM Element is a wrong type (The tag is not
         *             "Interface"), any child nodes cannot be parsed or the "name"
         *             attribute is missing/empty.
         */
        public Interface loadInterface(Element elt)
            throws ClassDataLoaderConfigurationException {
            return super.loadInterface(elt);
        }

        /**
         * Loads a datatype element from the given DOM Element.
         * @param elt
         *            The DOM Element to load the enumeration.
         * @return An instance of DataType, with data from the given Element.
         * @throws ClassDataLoaderConfigurationException
         *             If the DOM Element is a wrong type (The tag is not
         *             "Primitive") or the "name" attribute is missing/empty.
         */
        public DataType loadDataType(Element elt)
            throws ClassDataLoaderConfigurationException {
            return super.loadDataType(elt);
        }

        /**
         * Loads a enumeration element from the given DOM Element.
         * @param elt
         *            The DOM Element to load the enumeration.
         * @return An instance of Enumeration, with data from the given Element.
         * @throws ClassDataLoaderConfigurationException
         *             If the DOM Element is a wrong type (The tag is not
         *             "Primitive") or the "name" attribute is missing/empty.
         */
        public Enumeration loadEnumeration(Element elt)
            throws ClassDataLoaderConfigurationException {
            return super.loadEnumeration(elt);
        }

        /**
         * Loads a primitive element from the given DOM Element.
         * @param elt
         *            The DOM Element to load the primitive.
         * @return An instance of Primitive, with data from the given Element.
         * @throws ClassDataLoaderConfigurationException
         *             If the DOM Element is a wrong type (The tag is not
         *             "Primitive") or the "name" attribute is missing/empty.
         */
        public Primitive loadPrimitive(Element elt)
            throws ClassDataLoaderConfigurationException {
            return super.loadPrimitive(elt);
        }
    }
}
