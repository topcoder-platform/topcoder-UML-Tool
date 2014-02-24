/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.implementations;

import com.topcoder.uml.model.core.classifiers.Primitive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Enumeration;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.classifiers.PrimitiveImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.standardclassloader.LanguageClassDataLoader;
import com.topcoder.uml.standardclassloader.ClassDataLoaderConfigurationException;

/**
 * <p>
 * This class implements the LanguageClassDataLoader interface and
 * is used to load data from an XML file.
 * </p>
 *
 * <p>
 * This class loads the namespaces data from an xml file.
 * The file is created on construction and parsed into a DOM document and transforms to
 * a set of NameSpace instances when the namespaces are asked.
 * </p>
 *
 * <p>
 * Sample xml file :
 * &lt;StandardClassData&gt;
 *   &lt;!-- java package --&gt;
 *   &lt;Namespace name=&quot;java&quot;&gt;
 *       &lt;!-- nested lang package --&gt;
 *      &lt;Namespace name=&quot;lang&quot;&gt;
 *           &lt;!-- example of interface method usage --&gt;
 *           &lt;Interface name=&quot;Comparable&quot;&gt;
 *               &lt;Method name=&quot;compareTo&quot; /&gt;
 *           &lt;/Interface&gt;
 *           &lt;Interface name=&quot;Cloneable&quot; /&gt;
 *           &lt;!-- methods are optional though, they can be omitted: --&gt;
 *           &lt;Class name=&quot;Boolean&quot; /&gt;
 *           &lt;Class name=&quot;Character&quot; /&gt;
 *           &lt;Class name=&quot;Class&quot; /&gt;
 *           &lt;Class name=&quot;String&quot; /&gt;
 *           &lt;Enumeration name=&quot;Thread.State&quot; /&gt;
 *           &lt;DataType name=&quot;Deprecated&quot; /&gt;
 *       &lt;/Namespace&gt;
 *   &lt;/Namespace&gt;
 *   &lt;!-- primitives --&gt;
 *   &lt;Primitive name=&quot;boolean&quot; /&gt;
 *   &lt;Primitive name=&quot;char&quot; /&gt;
 *   &lt;Primitive name=&quot;int&quot; /&gt;
 *   &lt;Primitive name=&quot;long&quot; /&gt;
 *  &lt;/StandardClassData&gt;
 * </p>
 *
 * <p>
 * Thread safety : This class handles its own thread safety to the greatest
 * extent it can - after construction, its state never changes. The only
 * method that can be called post construction is a getter which only
 * returns a copy of the single member.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public class XMLLanguageClassDataLoader implements LanguageClassDataLoader {
    /**
     * <p>
     * Represent the tag name for <b>Method</b> element.
     * </p>
     */
    private static final String METHOD_TAG = "Method".intern();

    /**
     * <p>
     * Represent the tag name for <b>Primitive</b> element.
     * </p>
     */
    private static final String PRIMITIVE_TAG = "Primitive".intern();

    /**
     * <p>
     * Represent the tag name for <b>Enumeration</b> element.
     * </p>
     */
    private static final String ENUMERATION_TAG = "Enumeration".intern();

    /**
     * <p>
     * Represent the tag name for <b>DataType</b> element.
     * </p>
     */
    private static final String DATA_TYPE_TAG = "DataType".intern();

    /**
     * <p>
     * Represent the tag name for <b>Interface</b> element.
     * </p>
     */
    private static final String INTERFACE_TAG = "Interface".intern();

    /**
     * <p>
     * Represent the tag name for <b>Class</b> element.
     * </p>
     */
    private static final String CLASS_TAG = "Class".intern();

    /**
     * <p>
     * Represent the tag name for <b>Namespace</b> element.
     * </p>
     */
    private static final String NAMESPACE_TAG = "Namespace".intern();

    /**
     * <p>
     * Represent the tag name for <b>StandardClassData</b> element.
     * </p>
     */
    private static final String STANDARD_CLASS_DATA_TAG = "StandardClassData".intern();

    /**
     * <p>
     * Represent the name for <b>name</b> attribute.
     * </p>
     */
    private static final String NAME_ATTR = "name".intern();

    /**
     * <p>
     * Represent the local list of namespaces.
     * </p>
     *
     * <p>
     * This variable is null initially and set when the first time the namespaces is asked.
     * </p>
     *
     * <p>
     * The content of the list is from the xml file given when constructed.
     * </p>
     *
     * <p>
     * Note, the list is unmodifiable after it is set.
     * </p>
     */
    private volatile List<Namespace> namespaces;

    /**
     * <p>
     * The file location for data to be loaded from.
     * </p>
     *
     * <p>
     * This is set on construction, and immutable thereafter.
     * </p>
     *
     * <p>
     * The file represented by this file will be used to load the namespaces the first time when
     * the namespaces is asked.
     * </p>
     */
    private final String fileName;

    /**
     * <p>
     * Construct a new XML Language class data loader by caching the file name.
     * </p>
     *
     * <p>
     * Note, the namespaces data in the given file is not loaded in the constructor,
     * but in the first time when the namespaces is asked.
     * </p>
     *
     * @param fileName The name of the XML file containing all the namespace data for this loader to store.
     *
     * @throws IllegalArgumentException if fileName is null or empty
     */
    public XMLLanguageClassDataLoader(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("The file name should not be null.");
        }

        if (fileName.trim().length() == 0) {
            throw new IllegalArgumentException("The file name should not be empty.");
        }

        this.fileName = fileName;
    }

    /**
     * <p>
     * Return all the namespace instances loaded by this language-specific loader.
     * </p>
     *
     * <p>
     * Note, the first time this is called, namespace will be null - when that happens,
     * the file name is used to load and parse the namespaces into a new list, which
     * is then made unmodifiable. From then on, the namespaces are simply returned
     * from the list member.
     * </p>
     *
     * @return all the namespace instances loaded by this language-specific loader
     *
     * @throws ClassDataLoaderConfigurationException If there are any problems forming
     * the document or parsing in any of the namespace data
     */
    public List<Namespace> getNamespaces() throws ClassDataLoaderConfigurationException {
        if (namespaces == null) {
            synchronized (this) {
                // just judge the namespaces again before loading
                if (namespaces == null) {
                    Element root = parseStandardClassDataElement(fileName);
                    this.namespaces = Collections.unmodifiableList(loadSubNamespaces(root));
                }
            }
        }

        return namespaces;
    }

    /**
     * <p>
     * Load a Namespace element from the given DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     *
     * @return An instance of Namespace, with data from the Element given.
     *
     * @throws ClassDataLoaderConfigurationException If the element
     * does not have the required parameters.
     */
    protected Namespace loadNamespace(Element elt) throws ClassDataLoaderConfigurationException {
        // get the name attribute from the element
        String packageName = this.loadNameAttribute(elt, NAMESPACE_TAG);

        Package packageImpl = new PackageImpl();

        // set the name to packageImpl
        packageImpl.setName(packageName);

        for (Namespace subNamespace : loadSubNamespaces(elt)) {
            // the direction is bi-direction
            packageImpl.addOwnedElement(subNamespace);
            subNamespace.setNamespace(packageImpl);
        }

        return packageImpl;
    }

    /**
     * <p>
     * Create a namespace list which is loaded from the DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     *
     * @return a namespace list which is loaded from the DOM Element
     *
     * @throws ClassDataLoaderConfigurationException if some elements are unknown.
     */
    private List<Namespace> loadSubNamespaces(Element elt) throws ClassDataLoaderConfigurationException {
        // create a namespace list to save the namespaces
        List<Namespace> subNamespaces = new ArrayList<Namespace>();

        NodeList childNodes = elt.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element child = (Element) node;
                // get the tag name of the child
                String childTagName = child.getTagName().intern();
                if (NAMESPACE_TAG == childTagName) {
                    subNamespaces.add(loadNamespace(child));
                } else if (CLASS_TAG == childTagName) {
                    subNamespaces.add(loadClass(child));
                } else if (INTERFACE_TAG == childTagName) {
                    subNamespaces.add(loadInterface(child));
                } else if (DATA_TYPE_TAG == childTagName) {
                    subNamespaces.add(loadDataType(child));
                } else if (ENUMERATION_TAG == childTagName) {
                    subNamespaces.add(loadEnumeration(child));
                } else if (PRIMITIVE_TAG == childTagName) {
                    subNamespaces.add(loadPrimitive(child));
                } else {
                    throw new ClassDataLoaderConfigurationException("The element [" + childTagName + "] is unknown.");
                }
            }
        }

        return subNamespaces;
    }

    /**
     * <p>
     * Load a Class element from the given DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     *
     * @return An instance of Class, with data from the Element given.
     *
     * @throws ClassDataLoaderConfigurationException If the element
     * does not have the required parameters.
     */
    protected Class loadClass(Element elt) throws ClassDataLoaderConfigurationException {
        // get the name attribute from the element
        String className = loadNameAttribute(elt, CLASS_TAG);

        Class classImpl = new ClassImpl();

        // set the name to classImpl
        classImpl.setName(className);

        // set the classImpl attribute which reading from the DOM Element
        loadClassifier(elt, classImpl);

        return classImpl;
    }

    /**
     * <p>
     * Load an Interface element from the given DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     *
     * @return An instance of Interface, with data from the Element given.
     *
     * @throws ClassDataLoaderConfigurationException If the element
     * does not have the required parameters.
     */
    protected Interface loadInterface(Element elt) throws ClassDataLoaderConfigurationException {
        // get the name attribute from the element
        String interfaceName = loadNameAttribute(elt, INTERFACE_TAG);

        Interface interfaceImpl = new InterfaceImpl();

        // set the name to interfaceImpl
        interfaceImpl.setName(interfaceName);

        // set the interfaceImpl attribute which reading from the DOM Element
        loadClassifier(elt, interfaceImpl);

        return interfaceImpl;
    }

    /**
     * <p>
     * Load element to Classifier(Interface or Class) from the given DOM Element.
     * </p>
     *
     * @param elt the DOM Element to load from.
     * @param type the Classifier instance loads the elements
     *
     * @throws ClassDataLoaderConfigurationException if some elements are unknown.
     */
    private void loadClassifier(Element elt, Classifier type) throws ClassDataLoaderConfigurationException {
        NodeList childNodes = elt.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element child = (Element) node;
                String childTagName = child.getTagName().intern();
                if (NAMESPACE_TAG == childTagName) {
                    // the Namespace direction is bi-direction
                    Namespace namespace = loadNamespace(child);
                    type.addOwnedElement(namespace);
                    namespace.setNamespace(type);
                } else if (CLASS_TAG == childTagName) {
                    // the Class direction is bi-direction
                    Class subClass = loadClass(child);
                    type.addOwnedElement(subClass);
                    subClass.setNamespace(subClass);
                } else if (INTERFACE_TAG == childTagName) {
                    // the Interface direction is bi-direction
                    Interface subInterface = loadInterface(child);
                    type.addOwnedElement(subInterface);
                    subInterface.setNamespace(type);
                } else if (DATA_TYPE_TAG == childTagName) {
                    // the DataType direction is bi-direction
                    DataType subDataType = loadDataType(child);
                    type.addOwnedElement(subDataType);
                    subDataType.setNamespace(type);
                } else if (ENUMERATION_TAG == childTagName) {
                    // the Enumeration direction is bi-direction
                    Enumeration subEnumeration = loadEnumeration(child);
                    type.addOwnedElement(subEnumeration);
                    subEnumeration.setNamespace(type);
                } else if (PRIMITIVE_TAG == childTagName) {
                    // the Primitive direction is bi-direction
                    Primitive subPrimitive = loadPrimitive(child);
                    type.addOwnedElement(subPrimitive);
                    subPrimitive.setNamespace(type);
                } else if (METHOD_TAG == childTagName) {
                    // the Method direction is bi-direction
                    Method subMethod = loadMethod(child);
                    type.addFeature(subMethod);
                    subMethod.setOwner(type);
                } else {
                    throw new ClassDataLoaderConfigurationException("The element [" + childTagName + "] is unknown.");
                }
            }
        }
    }

    /**
     * <p>
     * Load a DataType element from the given DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     *
     * @return An instance of DataType, with data from the Element given.
     *
     * @throws ClassDataLoaderConfigurationException If the element
     * does not have the required parameters.
     */
    protected DataType loadDataType(Element elt) throws ClassDataLoaderConfigurationException {
        // get the name attribute from the element
        String value = loadNameAttribute(elt, DATA_TYPE_TAG);

        DataType dataTypeImpl = new DataTypeImpl();

        // set the name to dataTypeImpl
        dataTypeImpl.setName(value);

        return dataTypeImpl;
    }

    /**
     * <p>
     * Load an Enumeration element from the given DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     *
     * @return An instance of Enumeration, with data from the Element given.
     *
     * @throws ClassDataLoaderConfigurationException If the element
     * does not have the required parameters.
     */
    protected Enumeration loadEnumeration(Element elt) throws ClassDataLoaderConfigurationException {
        // get the name attribute from the element
        String enumerationName = loadNameAttribute(elt, ENUMERATION_TAG);

        Enumeration enumerationImpl = new EnumerationImpl();

        // set the name to enumerationImpl
        enumerationImpl.setName(enumerationName);

        return enumerationImpl;
    }

    /**
     * <p>
     * Load a primitive element from the given DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     *
     * @return An instance of Primitive, with data from the Element given.
     *
     * @throws ClassDataLoaderConfigurationException If the element
     * does not have the required parameters.
     */
    protected Primitive loadPrimitive(Element elt) throws ClassDataLoaderConfigurationException {
        // get the name attribute from the element
        String primitiveName = this.loadNameAttribute(elt, PRIMITIVE_TAG);

        Primitive primitiveImpl = new PrimitiveImpl();

        // set the name to primitiveImpl
        primitiveImpl.setName(primitiveName);

        return primitiveImpl;
    }

    /**
     * <p>
     * Load a Method element from the given DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     *
     * @return An instance of Method, with data from the Element given.
     *
     * @throws ClassDataLoaderConfigurationException If the element
     * does not have the required parameters.
     */
    private Method loadMethod(Element elt) throws ClassDataLoaderConfigurationException {
        // get the name attribute from the element
        String methodName = loadNameAttribute((Element) elt, METHOD_TAG);

        Method methodImpl = new MethodImpl();

        // set the name to methodImpl
        methodImpl.setName(methodName);

        return methodImpl;
    }

    /**
     * <p>
     * Load a name attribute from the given DOM Element.
     * </p>
     *
     * @param elt The DOM Element to load from.
     * @param tagName the tag name to check the Element.
     *
     * @return a name attribute from the given DOM Element
     *
     * @throws ClassDataLoaderConfigurationException If the element
     * does not have the required parameters.
     */
    private String loadNameAttribute(Element elt, String tagName) throws ClassDataLoaderConfigurationException {
        if (elt == null) {
            throw new ClassDataLoaderConfigurationException("The elt should not be null.");
        }

        if (tagName != elt.getTagName()) {
            throw new ClassDataLoaderConfigurationException("The element must have the tag name [" + tagName + "].");
        }

        String value = elt.getAttribute(NAME_ATTR);
        if (value.trim().length() == 0) {
            throw new ClassDataLoaderConfigurationException("The attribute of the [" + tagName + "] element is empty.");
        }

        return value;
    }

    /**
     * <p>
     * Parsing the given file and returns a DOM Element using DOM Parser.
     * </p>
     *
     * @param filename the given file to parse
     *
     * @return a DOM Element which represents the given xml file
     *
     * @throws ClassDataLoaderConfigurationException when fails to parsing the given xml file
     */
    private Element parseStandardClassDataElement(String filename) throws ClassDataLoaderConfigurationException {
        // Parse the file using DOM API
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // The namespace feature is used while we ignore the validation feature
        factory.setNamespaceAware(true);
        factory.setValidating(false);

        InputStream is = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            is = new FileInputStream(filename);
            // parse the stream
            Element root = builder.parse(is).getDocumentElement();

            if (STANDARD_CLASS_DATA_TAG != root.getTagName().intern()) {
                throw new ClassDataLoaderConfigurationException("The root node must be called [StandardClassData].");
            }

            return root;
        } catch (ParserConfigurationException e) {
            throw new ClassDataLoaderConfigurationException(
                "ParserConfigurationException occurs when parsing stream using DOM.", e);
        } catch (FileNotFoundException e) {
            throw new ClassDataLoaderConfigurationException(
                "FileNotFoundException occurs when parsing stream using DOM.", e);
        } catch (SAXException e) {
            throw new ClassDataLoaderConfigurationException("SAXException occurs when parsing stream using DOM.", e);
        } catch (IOException e) {
            throw new ClassDataLoaderConfigurationException("IOException occurs when parsing stream using DOM.", e);
        } finally {
            closeInputStream(is);
        }

    }

    /**
     * <p>
     * This method closes an InputStream silently.
     * </p>
     *
     * @param is the InputStream to close
     */
    private void closeInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}
