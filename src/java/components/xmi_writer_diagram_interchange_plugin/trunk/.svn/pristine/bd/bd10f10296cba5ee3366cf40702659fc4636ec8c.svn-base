/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram;

import java.io.PrintStream;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.topcoder.xmi.writer.AbstractXMITransformer;
import com.topcoder.xmi.writer.ElementAlreadyExistsException;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.XMIWriter;


/**
 * <p>
 * The <code>Diagram2XMITransformer</code> is the communication point between the XMI Writer component, and the
 * underlying strategies provided to transform XMI Document Interchange elements into valid XMI.
 * </p>
 * <p>
 * The main entry point into the system is the <code>transform(element, stream)</code> method, inherited from the
 * XMITransformer interface. This takes a DocumentInterchange element and writes its XMI to an output stream. Within
 * the component, this is done by converting the element to an XML Node first, then writing this to the stream.
 * </p>
 * <p>
 * The XML transformation is performed by calling the other <code>transform(element, document)</code> method.
 * This can also be called publicly if the application needs the XMI as a Node, rather than written to a stream.
 * Each of these transform methods match the element to an element transformer and delegate the Node creation,
 * possibly involving recursive <code>transform()</code> calls.
 * </p>
 * <p>
 * In addition, this provides a flag to determine whether exceptions should be thrown or suppressed. In the
 * case of suppression, when an error is encountered the method simply stops and the processing is forgotten, null
 * returned if required.
 * </p>
 * <p><b>Thread-safety:</b>
 * This class does not guarantee thread safety - the transformations use non thread-safe transformer instances, and
 * there's nothing to stop multiple classes altering the withExceptions flag during execution of other methods.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public class Diagram2XMITransformer extends AbstractXMITransformer {
    /**
     * <p>
     * Represents a boolean flag state.
     * </p>
     * <p>
     * <ul>
     * <li>
     * if it is true, exceptions are thrown by the constructors and the following methods:
     *       <ol>
     *           <li>transform(Object, PrintStream)</li>
     *           <li>transform(Object, Document)</li>
     *           <li>resolveID(Object)</li>
     *           <li>getElementTransformer(String)</li>
     *           <li>getTagName(String)</li>
     *       </ol>
     * </li>
     * <li>
     * if it is false, the constructors and the following methods suppress their exceptions are suppressed, instead do
     * nothing or return null if an error occurs.
     *      <ol>
     *          <li>transform(Object, PrintStream) writes nothing to the PrintStream</li>
     *          <li>transform(Object, Document) returns null</li>
     *          <li>resolveID(Object) returns null</li>
     *          <li>getElementTransformer(String) returns null</li>
     *          <li>getTagName(String) returns null</li>
     *      </ol>
     * </li>
     * </ul>
     * </p>
     * <p>
     * The flag is initially true, can be set on construction, and get/set methods are also provided.
     * </p>
     */
    private boolean withExceptions = true;

    /**
     * <p>
     * The XML transformer that is used to write an XML Node of XMI data out to the given output stream.
     * </p>
     * <p>
     * This is initialized on construction, either to a given parameter, or using the default.
     * <p>
     * <p>
     * It is immutable and can be null only if fail in construction but withExceptions is false.
     * It can be obtained through calling <code>getXMLTransformer()</code> method.
     * </p>
     */
    private final Transformer xmlTransformer;

    /**
     * <p>
     * Map of transformers known by this instance.
     * </p>
     * <p>
     * It maps:
     * <ol>
     * <li>
     * Keys = Strings, names of element classes that can be transformed (non-null, cannot be empty strings).
     * </li>
     * <li>
     * Values = <code>DiagramInterchangeElementTransformer</code> implementations (non-null).
     * </li>
     * </ol>
     * </p>
     * <p>
     * Whenever an element is to be transformed, it's class is used to search the map, and the matching element
     * transformer is then used to convert the element into a Node.
     * </p>
     * <p>
     * This member must be set on construction via a parameter, and immutable thereafter.
     * It is immutable and can be null only if fail in construction but withExceptions is false.
     * Its contents are accessible, either singularly or complete, through <code>getElementTransformers()</code>
     * method.
     * </p>
     */
    private final Map < String, DiagramInterchangeElementTransformer > transformers;

    /**
     * <p>
     * Map of tag name mappings known by this instance.
     * </p>
     * <p>
     * It maps:
     * <ol>
     * <li>
     * Keys = Strings, names of element classes whose XMI tag names are known. It cannot be null, cannot be empty
     *     strings.
     * </li>
     * <li>
     * Values = The names of the XMI tags to use for each given class. It cannot be null, cannot be empty strings.
     * </li>
     * </ol>
     * </p>
     * <p>
     * Whenever an element is to be written to XMI, but its tag's name is not immediately obvious from the context
     * (such as a UML1 Semantic bridge element), this map is used to look up the correct tag name to use.
     * It is immutable and can be null only if fail in construction but withExceptions is false.
     * Its contents are singularly accessible through the getTagName(String) method.
     * </p>
     */
    private final Map < String, String > tagNameMappings;

    /**
     * <p>
     * Constructor for the transformer that takes the (non-null) mapping of element class names to their transformers,
     * and the (non-null) mapping of the element class names to their XML tag names. withExceptions remains at its
     * default value of true, and xmlTransformer is initialized to its default.
     * </p>
     * <p>
     * The transformers map cannot be null, null values are not allowed for the keys or values inside the map, and
     * empty strings are not allowed for its keys if any are found an exception is thrown.
     * </p>
     * <p>
     * The tagNameMappings cannot be null, and null or empty strings values are not allowed for the keys or values
     * inside the map, if any are found an exception is thrown.
     * </p>
     *
     * @param transformers
     *      Mapping of class name strings to <code>DiagramInterchangeElementTransformer</code> instances to use.
     * @param tagNameMappings
     *      Mapping of class name strings to XML tag names. this parameter is used to initialize the tagNameMappings
     *      map. It may not be null, and none of its key or values stored within may be null.
     *
     * @throws TransformerConfigurationException
     *      Thrown if it is not possible to create a <code>Transformer</code> instance.
     * @throws TransformerFactoryConfigurationError thrown if the TransformerFactory implementation is not available
     *      or cannot be instantiated.
     * @throws IllegalArgumentException
     *      if the transformers map is null, or it contains any null key or value, or it contains any empty strings
     *      for its keys, or the tagNameMappings is null, or it contains null or empty strings values for its keys or
     *      values
     */
    public Diagram2XMITransformer(Map < String, DiagramInterchangeElementTransformer > transformers,
            Map < String, String > tagNameMappings)throws TransformerConfigurationException {
        // check whether the transformer map is null or it contains null values for its keys or values or  it contains
        // empty strings for its keys.
        checkTransformersMap(transformers);
        //check whether the tagNameMappings is null or it contains null or empty strings values for its keys or values.
        checkTagNameMappings(tagNameMappings);
        this.transformers = transformers;
        this.tagNameMappings = tagNameMappings;
        // create and initialize a new transformer
        xmlTransformer = TransformerFactory.newInstance().newTransformer();
        xmlTransformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        xmlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
    }

    /**
     * <p>
     * Constructor for the transformer that takes the (non-null) mapping of element class names to their transformers.
     * as well as an initial value for the exception-suppression state, XML transformer used to write the resulting
     * nodes to a stream and the (non-null) mapping of the element class names to their XML tag names.
     * </p>
     * <p>
     * This constructor simply sets each member to its corresponding parameter, where the object parameters cannot be
     * null.
     * </p>
     * <p>
     * The transformers map cannot be null, null values are not allowed for the keys or values inside the map, and
     * empty strings are not allowed for its keys, if any are found an exception is thrown.
     * </p>
     * <p>
     * The tagNameMappings cannot be null, and null or empty strings values are not allowed for the keys or values
     * inside the map, if any are found an exception is thrown.
     * </p>
     * <p>
     * Any errors are thrown/wrapped if withExceptions is true, or suppressed if withExceptions is false. All the
     * corresponding members will be set to be null if the suppression occurs.
     * </p>
     *
     * @param transformers
     *      Mapping of class name strings to <code>DiagramInterchangeElementTransformer</code> instances to use.
     * @param tagNameMappings
     *      Mapping of class name strings to XML tag names.
     * @param xmlTransformer
     *      XML transformer that is used to write an XML Node of XMI data out to the given output stream.
     * @param withExceptions
     *      A boolean flag state indicating whether the exceptions should be thrown if any exception occurs
     *
     * @throws IllegalArgumentException
     *      If either object parameter is null or the transformers map contains any null key or value, or it contains
     *      any empty strings for its keys. or the tagNameMappings contains null or empty strings values for its keys
     *      or values
     */
    public Diagram2XMITransformer(Map < String, DiagramInterchangeElementTransformer > transformers,
            Map < String, String > tagNameMappings, Transformer xmlTransformer, boolean withExceptions) {
        this.withExceptions = withExceptions;
        try {
            // check whether the transformer map is null or it contains null values for its keys or values or  it
            // contains empty strings for its keys.
            checkTransformersMap(transformers);
            // check whether the tagNameMappings is null or it contains null or empty strings values for its keys
            // or values.
            checkTagNameMappings(tagNameMappings);
            if (xmlTransformer == null) {
                throw new IllegalArgumentException("The xmlTransformer can not be null.");
            }
        } catch (IllegalArgumentException e) {
            // handle the IllegalArgumentException determined by withExceptions flag
            handleIllegalArgumentException(e);
            // if the withExceptions is false, member values are initialized to null, and the object becomes,
            // in effect, a no-op writer.
            this.tagNameMappings = null;
            this.transformers = null;
            this.xmlTransformer = null;
            return;
        }
        this.tagNameMappings = tagNameMappings;
        this.transformers = transformers;
        this.xmlTransformer = xmlTransformer;
    }

    /**
     * <p>
     * Transform the given element into its XMI representation, and writes the result to a given stream.
     * </p>
     * <p>
     * If any exceptions are raised, then either they are wrapped/thrown again, or suppressed and nothing is written
     * to the stream, depending on the value of the withExceptions flag.
     * </p>
     *
     * @param element Element to be written into its XMI representation.
     * @param out Output stream to write the XMI to
     *
     * @throws IllegalArgumentException If either parameter is null.
     * @throws UnknownElementException If the the element is not-null, but a
     *      <code>DiagramInterchangeElementTransformer</code> cannot be obtained for its class.
     * @throws XMITransformException
     *      If any XMI problems occur in creating the document or writing to the xmiTransformer.
     */
    public void transform(Object element, PrintStream out) throws UnknownElementException, XMITransformException {
        if (element == null) {
            throwIllegalArgumentException("The Element to be written into its XMI representation can not be null.");
            // return silently
            return;
        }
        if (out == null) {
            throwIllegalArgumentException("The Output stream for writing the XMI should not be null.");
            // return silently
            return;
        }
        // create a new XML Document
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            // handles the exception determined by the withExceptions flag
            handleException("The DocumentBuilder cannot be created which satisfies the configuration requested.", e);
            return;
        }
        // convert the given element into its XMI representation, returning an XML Node
        Node node = transform(element, document);

        // if some exceptions silently occur in transform(element, document), return simply
        if (node == null) {
            return;
        }
        // append the XML Node to the document
        try {
            document.appendChild(node);
        } catch (DOMException de) {
            // if some errors occur, handle;
            handleException("Could not append the child node caused by " + de.getMessage(), de);
            return;
        }
        // transform the document (as a DOMSource) to the output stream (as a StreamResult)
        try {
            xmlTransformer.transform(new DOMSource(document), new StreamResult(out));
        } catch (TransformerException e) {
            // handles the exception determined by the withExceptions flag
            handleException("An unrecoverable error occurs during the course of the transformation.", e);
            return;
        }
    }

    /**
     * <p>
     * Convert the given element into its XMI representation, returning an XML Node.
     * </p>
     * <p>
     * First, the element's class is used to obtain the right <code>DiagramInterchangeElementTransformer</code>
     * instance. Then, the instance's transform() method is called, and results returned back to the user.
     * </p>
     * <p>
     * Any errors are thrown/wrapped if withExceptions is true, or suppressed if withExceptions is false.
     * </p>
     *
     * @param element Element to be written into its XMI representation.
     * @param document Document which the Node is to come from.
     *
     * @return XML Node containing the XMI representation of the given element or null if an error
     *      occurs in the case of suppression.
     *
     * @throws IllegalArgumentException
     *      if the element or the document is null, or the element's transformer throws an IllegalArgumentException.
     * @throws UnknownElementException
     *      if the element is not-null, but a <code>DiagramInterchangeElementTransformer</code> cannot be obtained for
     *      its class.
     * @throws XMITransformException If the element's transformer throws an XMITransformException,
     *      or the element is not the right type to transform.
     */
    public Node transform(Object element, Document document) throws UnknownElementException, XMITransformException {
        if (element == null) {
            throwIllegalArgumentException("Element to be written into XMI representation should not be null.");
            // return null silently
            return null;
        }
        if (document == null) {
            throwIllegalArgumentException("Document which the Node is to come from should not be null.");
            // return null silently
            return null;
        }
        // get the DiagramInterchangeElementTransformer for the element's class
        String className = element.getClass().getName();
        // get the right <code>DiagramInterchangeElementTransformer</code> instance
        DiagramInterchangeElementTransformer transformer = getElementTransformer(className);
        // if some exceptions silently occur in getElementTransformer(String), simply return;
        if (transformer == null) {
            return null;
        }
        try {
            return transformer.transform(element, document, this);
        } catch (ClassCastException ce) {
            // handle the ClassCastException determined by the withExceptions flag
            handleException("The element provided isn't of the right type.", ce);
        } catch (XMITransformException xe) {
            // throw it if the withExceptions is true
            handleXMITransformException(xe);
        }
        // otherwise returns null simply
        return null;
    }

    /**
     * <p>
     * Return the xmi.id value for the given object, possibly creating a new one if no current ID is stored.
     * </p>
     * <p>
     * If there are any problems creating the ID {i.e. on IDsExhausted or IDGeneratorException} then these are to be
     * wrapped as an XMITransformException and thrown if withExceptions is true.
     * </p>
     *
     * @param element element whose ID is to be obtained
     *
     * @return XMI ID used to uniquely identify the given element or null if an error occurs in the case of
     *      suppression.
     *
     * @throws XMITransformException if there are problems obtaining the ID
     * @throws IllegalArgumentException if the element is null
     */
    public String resolveID(Object element) throws XMITransformException {
        if (element == null) {
            throwIllegalArgumentException("The Element whose ID is to be obtained should not be null.");
            // return null silently
            return null;
        }
        XMIWriter writer = getXMIWriter();
        if (writer == null) {
            throw new XMITransformException("The XMIWriter should not be null.");
        }
        try {
            return writer.getElementId(element);
        } catch (UnknownElementException e) {
            // there is no xmiId for the given element, create a new one
            String xmiId = "TC_UML_" + UUID.randomUUID().toString();
            // put the xmiId for the element in the writer
            try {
                writer.putElementId(element, xmiId);
            } catch (ElementAlreadyExistsException e1) {
                // if the element already exists
                handleException("The element already exists.", e);
                // return null silently
                return null;
            }
            return xmiId;
        }
    }

    /**
     * <p>
     * Return whether the instance is currently throwing (by returning true) or suppressing (by returning false)
     * errors.
     * </p>
     *
     * @return A boolean flag indicating whether the exception is thrown.
     */
    public boolean isWithExceptions() {
        return withExceptions;
    }

    /**
     * <p>
     * Set whether this instance will suppress errors, by setting the internal flag.
     * <p>
     * <ul>
     * <li>
     * if it's true, no suppression takes place, errors may be thrown.
     * </li>
     * <li>
     * otherwise false, errors are suppressed.
     * </li>
     * </ul>
     * </p>
     *
     * @param noSuppress flag state indicating whether the exceptions should be thrown or not
     */
    public void setWithExceptions(boolean noSuppress) {
        withExceptions = noSuppress;
    }

    /**
     * <p>
     * Return the transformer used to write XML nodes out to streams.
     * </p>
     * <p>
     * The returned value will never be null.
     * </p>
     *
     * @return transformer used to write XML nodes out to streams
     */
    public Transformer getXMLTransformer() {
        return xmlTransformer;
    }

    /**
     * <p>
     * Using the class name as a key, this method performs a lookup inside the transformers map, returning the
     * matching transformer value.
     * </p>
     * <p>
     * If the className is null or empty, or doesn't appear as a key in the map, exception is thrown.
     * Any errors are thrown/wrapped if withExceptions is true, or suppressed if withExceptions is false.
     * </p>
     * <p>
     * In the case of suppression, when an error is encountered the method simply return null.
     * </p>
     *
     * @param className Name of class to retrieve element transformer for.
     *
     * @return DiagramInterchangeElementTransformer instance used to transform the given class, or null if an error
     *      occurs in the case of suppression
     *
     * @throws IllegalArgumentException If the input parameter is null or empty.
     * @throws UnknownElementException If the given class name does not exist as a key inside the transformers map.
     */
    public DiagramInterchangeElementTransformer getElementTransformer(String className)
        throws UnknownElementException {
        return (DiagramInterchangeElementTransformer) getValueFromMap(transformers, "transformers", className);
    }


    /**
     * <p>
     * Return the transformers map.
     * </p>
     *
     * @return map of element transformer data.
     */
    public Map < String, DiagramInterchangeElementTransformer > getElementTransformers() {
        // return the map directly is fine
        return transformers;
    }

    /**
     * <p>
     * Using the class name as a key, this method performs a lookup inside the tagNameMappings map, returning the
     * matching XML tag name value.
     * </p>
     * <p>
     * If the className is null or empty, or doesn't appear as a key in the map, exception is thrown.
     * Any errors are thrown/wrapped if withExceptions is true, or suppressed if withExceptions is false.
     * </p>
     * <p>
     * In the case of suppression, when an error is encountered the method simply return null.
     * </p>
     *
     * @param className Name of class to retrieve element XML tag name for.
     *
     * @return a string representing the XML tagName for the given className, or null if an error occurs in the case
     *          of suppression
     *
     * @throws IllegalArgumentException If the className is null or empty.
     * @throws UnknownElementException If the given class name does not exist as a key inside the tagNameMappings map.
     */
    public String getTagName(String className) throws UnknownElementException {
        return (String) getValueFromMap(tagNameMappings, "tagNameMappings", className);
    }


    /**
     * <p>
     * Using the class name as a key, this method performs a lookup inside the map, returning the matching value.
     * </p>
     * <p>
     * If the className is null or empty, or doesn't appear as a key in the map, exception is thrown.
     * Any errors are thrown/wrapped if withExceptions is true, or suppressed if withExceptions is false.
     * </p>
     * <p>
     * In the case of suppression, when an error is encountered the method simply return null.
     * </p>
     *
     * @param map Map containing no null key or value
     * @param mapName Name of the map, it should not be null
     * @param className Name of class to retrieve element value for.
     *
     * @return object associated with the className in the map, or null if the className doesn't appear as a
     *      key in the map and the withException is false
     *
     * @throws UnknownElementException If the given class name does not exist as a key inside the map.
     * @throws IllegalArgumentException If the className is null or empty.
     */
    private Object getValueFromMap(Map map, String mapName, String className) throws UnknownElementException {
        if (className == null) {
            throwIllegalArgumentException("The name of class should not be null.");
            return null;
        }
        if (className.trim().length() == 0) {
            throwIllegalArgumentException("The name of class should not be empty.");
            return null;
        }
        // since the map contains no null keys or value, we use get(key) to determine whether
        // the className exists as a key inside the map
        Object obj = map.get(className);
        if (obj == null) {
            UnknownElementException e = new UnknownElementException("The given class name- " + className
                    + " does not exist as a key inside the " + mapName + " map", className);
            handleUnknownElementException(e);
        }
        return obj;
    }

    /**
     * <p>
     * Check whether the  map is null or it contains null values for its keys or values.
     * </p>
     *
     * @param map Instance of Map to be checked
     * @param mapName Name of the map
     *
     * @throws IllegalArgumentException if the map is null, or it contains null values for its keys or values.
     */
    private void checkMapNotNull(Map map, String mapName) {
        if (map == null) {
            throw new IllegalArgumentException("The " + mapName + " should not be null.");
        }
        // check whether the map contains null key or null value
        try {
            if (map.containsKey(null)) {
                throw new IllegalArgumentException("The " + mapName + " should not contain null keys.");
            }
            if (map.containsValue(null)) {
                throw new IllegalArgumentException("The " + mapName + " should not contain null values.");
            }
        } catch (NullPointerException e) {
            // it is OK here, since the key/value is null and this map does not permit null keys/values
        }

    }

    /**
     * <p>
     * Check whether the transformers map is null or it contains null values for its keys or values, or it contains
     * empty strings for its keys.
     * </p>
     * @param transformers the transformers map to be checked
     *
     * @throws IllegalArgumentException if the map is null, or it contains null values for its keys or values,or it
     *       contains empty strings for its keys
     */
    private void checkTransformersMap(Map < String, DiagramInterchangeElementTransformer > transformers) {
        checkMapNotNull(transformers, "transformers map");
        Set<String> set = transformers.keySet();
        for(String key : set) {
            if(key.trim().length() == 0) {
                throw new IllegalArgumentException("The transformers should not contain empty strings for its keys.");
            }
        }
    }

    /**
     * <p>
     * Check whether the tagNameMappings map is null or it contains null or empty strings values for its keys or values.
     * </p>
     * @param transformers the transformers map to be checked
     *
     * @throws IllegalArgumentException if the map is null, or it contains null or empty strings values for its keys or
     *       values
     */
    private void checkTagNameMappings(Map < String, String > tagNameMappings) {
        checkMapNotNull(tagNameMappings, "tagNameMappings");
        Set<Entry<String, String>> set = tagNameMappings.entrySet();
        for(Entry<String, String> entry : set) {
            if(entry.getKey().trim().length() == 0) {
                throw new IllegalArgumentException(
                        "The tagNameMappings should not contain empty strings for its keys.");
            }
            if(entry.getValue().trim().length() == 0) {
                throw new IllegalArgumentException(
                        "The tagNameMappings should not contain empty strings for its values.");
            }
        }
    }

    /**
     * <p>
     * Handle an exception determined by the withExceptions flag.
     * An XMITransformException will be thrown if withExceptions is true.
     * Ignore the exception by doing nothing if withExceptions is false.
     * </p>
     *
     * @param description a string representing the description of the execption
     * @param e the exception to be handled
     *
     * @throws XMITransformException if withExceptions is true
     */
    private void handleException(String description, Exception e) throws XMITransformException {
        if (withExceptions) {
            //wrap it into an XMITransformException
            throw new XMITransformException(description, e);
        }
    }

    /**
     * <p>
     * Handle the XMITransformException determined by the withExceptions flag.
     * The XMITransformException will be thrown if withExceptions is true.
     * Ignore the XMITransformException by doing nothing if withExceptions is false.
     * </p>
     *
     * @param e the exception to be handled
     *
     * @throws XMITransformException if withExceptions is true
     */
    private void handleXMITransformException(XMITransformException e) throws XMITransformException {
        // throw it if withExceptions is true.
        if (withExceptions) {
            throw e;
        }
    }

    /**
     * <p>
     * Handle the UnknownElementException determined by the withExceptions flag.
     * The UnknownElementException will be thrown if withExceptions is true.
     * Ignore the UnknownElementException by doing nothing if withExceptions is false.
     * </p>
     *
     * @param e the exception to be handled
     *
     * @throws UnknownElementException if withExceptions is true
     */
    private void handleUnknownElementException(UnknownElementException e) throws UnknownElementException {
        // thrown if withExceptions is true.
        if (withExceptions) {
            throw e;
        }
    }

    /**
     * <p>
     * Handle the IllegalArgumentException determined by the withExceptions flag.
     * </p>
     * <p>
     * The IllegalArgumentException will be thrown if withExceptions is true.
     * Ignore the IllegalArgumentException by doing nothing if withExceptions is false.
     * </p>
     *
     * @param e the IllegalArgumentException to be handled
     *
     * @throws IllegalArgumentException if withExceptions is true
     */
    private void handleIllegalArgumentException(IllegalArgumentException e) {
        // throw it if withExceptions is true.
        if (withExceptions) {
            throw e;
        }
    }

    /**
     * <p>
     * Throw the IllegalArgumentException created by the description provided, if withExceptions is true.
     * </p>
     * <p>
     * It is determined by the withExceptions flag.
     * If withExceptions is true, An IllegalArgumentException created by the description will be thrown,
     * otherwise, ignore it and return simply.
     * </p>
     *
     * @param description a string used to create an IllegalArgumentException to be handled
     *
     * @throws IllegalArgumentException if withExceptions is true
     */
    private void throwIllegalArgumentException(String description) {
        // throw it if withExceptions is true.
        if (withExceptions) {
            throw new IllegalArgumentException(description);
        }
    }
}
