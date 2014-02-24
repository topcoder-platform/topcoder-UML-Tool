/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * <p>
 * This is the main class of the XMI Reader component. It manages a map of XMIHandlers: <br>
 * 1) The XMIHandlers process the XMI elements as they are parsed using a SAX parser. <br>
 * 2) An XMI element name can be mapped to a single XMIHandler; a handler can also handle more than
 * one element name. <br>
 * 3) The XMIHandlers can either be set up in the configuration file or manually via the
 * add/remove/getHandler methods. <br>
 * </p>
 * <p>
 * <b>Sample Configuration:</b>
 * </p>
 *
 * <pre>
 *  &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
 *    &lt;Property name=&quot;reuse&quot;&gt;
 *        &lt;Value&gt;true&lt;/Value&gt;
 *    &lt;/Property&gt;
 *    &lt;Property name=&quot;handlers&quot;&gt;
 *       &lt;Property name=&quot;UML:Class&quot;&gt;
 *           &lt;Value&gt;com.topcoder.xmi.reader.handlers.ClassHandler&lt;/Value&gt;
 *      &lt;/Property&gt;
 *      &lt;!-- since reuse is true, it should not instantiate another ClassHandler. --&gt;
 *      &lt;Property name=&quot;UML:Interface&quot;&gt;
 *           &lt;Value&gt;com.topcoder.xmi.reader.handlers.ClassHandler&lt;/Value&gt;
 *      &lt;/Property&gt;
 *      &lt;Property name=&quot;UML:Stereotype&quot;&gt;
 *          &lt;Value&gt;com.topcoder.xmi.reader.handlers.StereotypeHandler&lt;/Value&gt;
 *      &lt;/Property&gt;
 *    &lt;/Property&gt;
 *  &lt;/Config&gt;
 * </pre>
 *
 * <p>
 * This class uses the SAX parser for parsing, giving it a DelegatingHandler, which is the
 * ContentHandler actually passed into the parser. For each element encountered: <br>
 * 1) If a handler has been set up in this class, the DelegatingHandler will pass the processing to
 * that element. <br>
 * 2) If no handler was set up, the "current handler" will be used instead. <br>
 * This creates a stack of handlers, which can also be accessed from this class.
 * </p>
 * <p>
 * Each XMIHandler has access to this XMIReader instance. This is so that the XMIReader can be a
 * central clearinghouse of the various identified elements within the XMI file, in the
 * 'foundElements' map. Forward references are available as well; as attributes of those forward
 * references are established, they are updated in the 'fowardReferences' map. When the actual
 * object is finally found, and put into the foundElements map, the XMIHandlers will automatically
 * remove it from the forwardReferences map.
 * </p>
 * <p>
 * <b>Methods usage:</b>
 * </p>
 *
 * <pre>
 *  +------------------+                parse(1)                  +------------------------+
 *  |     XMIReader    | ---------------------------------------&gt; |        SAX parser      |
 *  +------------------+      give inner DelegatingHandler        +------------------------+
 *          /|\                                                               |
 *           |                                                                |
 *           | operates                                                       | handles
 *           | elements                                                       | events
 *           |   (2)                                                          |
 *           |                                                                |
 *           |                                                               \|/
 *  +------------------+          delegate events                 +------------------------+
 *  | XMIHandler in Map| &lt;--------------------------------------- | inner DelegatingHandler|
 *  +------------------+           by suitable type               +------------------------+
 *
 *  The methods for (1): all the parse methods and parseZipFile;
 *  The methods for (2): putElementProperty,getElementProperties,removeElement,putElement,getElement;
 *  XMIHandler will be operated by: getHandler, removeHandler, addHandler.
 * </pre>
 *
 * <p>
 * <strong>Thread Safety:</strong> This class is thread safe. Each method is synchronized. This was
 * done since while parsing, we do not want another thread to modify the internal state of the
 * object: the handlers, foundElements or forwardReferences. If that were to happen, the behavior
 * that the thread that started the parse would be different than expected.
 * </p>
 *
 * @author dplass, magicpig
 * @version 1.0
 */
public class XMIReader {
    /**
     * <p>
     * This is the default namespace used by the no-argument constructor. It is provided as a public
     * attribute so that the namespace can be set up before calling the no-argument constructor if
     * so desired.
     * </p>
     * <p>
     * A sample configuration is provided in class document.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.xmi.reader.XMIReader";

    /**
     * <p>
     * Hard-coded String for "reuse", which will be used to read the configuration file for "reuse"
     * property.
     * </p>
     */
    private static final String REUSE = "reuse";

    /**
     * <p>
     * Hard-coded String for "true", which will be used to compare the reuse flag.
     * </p>
     */
    private static final String TRUE = "true";

    /**
     * <p>
     * Hard-coded String for "handlers", which will be used to read the configuration file for
     * "handlers" property.
     * </p>
     */
    private static final String HANDLERS = "handlers";

    /**
     * <p>
     * The hard-coded String for "http://xml.org/sax/features/namespaces". It will be used in method
     * parse(InputSource) to set the namespace feature.
     * </p>
     */
    private static final String NAMESPACE_FEATURE = "http://xml.org/sax/features/namespaces";

    /**
     * <p>
     * The suffix of zip file, which will be used in method parseZipFile to judge the XMI file.
     * </p>
     */
    private static final String SUFFIX_OF_ZIPFILE = ".xmi";

    /**
     * <p>
     * This map represents the elements found in the XMI file as it is being parsed. It maps the id
     * (as a String) to the actual element (as an Object).
     * </p>
     * <p>
     * This map will never be null, and its keys or values will never be null. Keys will never be
     * empty after trimmed. It is modified by putElement and removeElement, and accessed by
     * getElement. When the parse method is called, this map will be cleared.
     * </p>
     */
    private final Map<String, Object> foundElements = new HashMap<String, Object>();

    /**
     * <p>
     * This inner class is the actual ContentHandler that will be passed into the SAX parser by the
     * parse method of XMIReader, the enclosing class.
     * </p>
     * <p>
     * The various methods of this class will be called by the SAX parser. Each of the methods will
     * reference the enclosing class's 'handlers' map to determine which XMIHandler implementation
     * to call for that particular element. If there is no handler for that element, the
     * 'currentHandler' will be used. A stack of active handlers is also maintained, in case a child
     * node needs information that only an enclosing node has. The 'currentHandler' will be always
     * the top handler in the stack.
     * </p>
     * <p>
     * This class only implements a subset of the methods in the DefaultHandler. The methods that it
     * does implement, it conditionally delegates to one or more XMIHandler implementations. The
     * methods that it does not implement are not considered useful for parsing XMI files, such as
     * start/endPrefixMapping and skippedEntity.
     * </p>
     * <p>
     * <strong>Thread Safety:</strong> This class is not thread-safe since the SAX parser is not
     * thread-safe.
     * </p>
     *
     * @author dplass, magicpig
     * @version 1.0
     */
    public class DelegatingHandler extends DefaultHandler {
        /**
         * <p>
         * This stack represents all the active handlers. It must be implemented as a Stack so that
         * when children are processed, they can access their ancestor's data.
         * </p>
         * <p>
         * Entries are pushed in the startElement method and popped in endElement. This stack will
         * never be null but may be empty.
         * </p>
         */
        private final Stack<XMIHandler> activeHandlers = new Stack<XMIHandler>();

        /**
         * <p>
         * This represents the "current" handler.
         * </p>
         * <p>
         * It is set in the startElement method, if there is a corresponding XMIHandler in the
         * 'handlers' map for the given qname(localName if qname is empty or null). This is also the
         * top of the 'activeHandlers' stack. It is also changed in the endElement method when the
         * stack is popped.
         * </p>
         */
        private XMIHandler currentHandler = null;

        /**
         * <p>
         * Default constructor to create this object.
         * </p>
         */
        public DelegatingHandler() {
            // does nothing
        }

        /**
         * <p>
         * Returns the stack of active handlers, as a List. May be an empty list but will never be
         * null.
         * </p>
         *
         * @return the stack of active handlers, as a List
         */
        public List<XMIHandler> getActiveHandlers() {
            return activeHandlers;
        }

        /**
         * <p>
         * Processes the startDocument SAX event by calling 'startDocument' on all the handlers in
         * the enclosing class's 'handlers' map. Every unique handler is called only once.
         * </p>
         * <p>
         * This method should only ever be called by the SAX parser.
         * </p>
         *
         * @throws SAXException if any exception was thrown by any of the handlers. This will
         *             possibly wrap an underlying exception.
         */
        public void startDocument() throws SAXException {
            Set<XMIHandler> alreadyCalled = new HashSet<XMIHandler>();
            for (XMIHandler handler : handlers.values()) {
                if(!alreadyCalled.contains(handler)) {
                    handler.startDocument();
                    alreadyCalled.add(handler);
                }
            }
        }

        /**
         * <p>
         * Processes the startElement SAX event by calling 'startElement' on the appropriate
         * handler, which will match 'qname' (if not null or empty) or the 'localName' (if qname is
         * null or empty) from the enclosing class's 'handlers' map. It may modify the
         * activeHandlers stack and the currentHandler if the appropriate handler is found.
         * currentHandler will at last be delegated for the main operation.
         * </p>
         * <p>
         * This method should only ever be called by the SAX parser, which is configured for
         * namespace processing to be enabled.
         * </p>
         *
         * @param uri the Namespace URI, or the empty string if the element has no Namespace URI or
         *            if Namespace processing is not being performed
         * @param localName the local name (without prefix), or the empty string if Namespace
         *            processing is not being performed
         * @param qname the qualified name (with prefix), or the empty string if qualified names are
         *            not available
         * @param atts the attributes attached to the element. This method does not use the
         *            attributes, but passes them unchanged into the currentHandler, if there is
         *            one.
         * @throws SAXException if any exception was thrown by any of the handlers. This will
         *             possibly wrap an underlying exception.
         * @throws IllegalArgumentException if both localName and qname are null or empty after
         *             trimmed; if the uri is null.
         */
        public void startElement(String uri, String localName, String qname, Attributes atts)
            throws SAXException {
            ReaderHelper.validateNotNull(uri, "uri");
            XMIHandler tempHandler = handlers.get(ReaderHelper.validateLocalnameAndQname(localName,
                qname));
            if (tempHandler != null) {
                // pushes the handler onto the stack
                activeHandlers.push(tempHandler);
                // marks it as the current handler
                currentHandler = tempHandler;
            }

            // delegates such event to currentHandler.startElement if there is a currentHandler
            if (currentHandler != null) {
                currentHandler.startElement(uri, localName, qname, atts);
            }

        }

        /**
         * <p>
         * Processes the endElement SAX event by calling 'endElement' on the current handler if it
         * exists. Also, if the current handler was also the defined handler for the current node,
         * it means we have to pop the stack.
         * </p>
         * <p>
         * This method should only ever be called by the SAX parser, which is configured for
         * namespace processing to be enabled.
         * </p>
         *
         * @param uri the Namespace URI, or the empty string if the element has no Namespace URI or
         *            if Namespace processing is not being performed
         * @param localName the local name (without prefix), or the empty string if Namespace
         *            processing is not being performed
         * @param qname the qualified name (with prefix), or the empty string if qualified names are
         *            not available
         * @throws SAXException if any exception was thrown by any of the handlers. This will
         *             possibly wrap an underlying exception.
         * @throws IllegalArgumentException if both localName and qname are null or empty after
         *             trimmed; if the uri is null.
         */
        public void endElement(String uri, String localName, String qname) throws SAXException {
            ReaderHelper.validateNotNull(uri, "uri");
            XMIHandler tempHandler = handlers.get(ReaderHelper.validateLocalnameAndQname(localName,
                qname));
            // if there is a currentHandler, delegates such event to currentHandler.endElement
            if (currentHandler != null) {
                currentHandler.endElement(uri, localName, qname);
            }
            // if the current handler was also the defined handler for the current node
            // pops the stack and modifies currentHandler
            if (tempHandler != null) {
                activeHandlers.pop();
                currentHandler = activeHandlers.size() > 0 ? activeHandlers.peek() : null;
            }
        }

        /**
         * <p>
         * Processes the ignorableWhitespace SAX event by calling 'ignorableWhitespace' method on
         * that currentHandler with the given arguments, if it is not null.
         * </p>
         * <p>
         * This method should only ever be called by the SAX parser.
         * </p>
         *
         * @param ch the characters from the XML document
         * @param start the start position in the array
         * @param length the number of characters to read from the array
         * @throws SAXException if any exception was thrown by any of the handlers. This will
         *             possibly wrap an underlying exception.
         * @throws IllegalArgumentException if ch is null or if start or length is negative or would
         *             go off the end of the ch array
         */
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            ReaderHelper.validaChaArrayAndBoundArgument(ch, start, length);

            // delegates such event to currentHandler.ignorableWhitespace
            // if there is a currentHandler
            if (currentHandler != null) {
                currentHandler.ignorableWhitespace(ch, start, length);
            }
        }

        /**
         * <p>
         * Processes the processingInstruction SAX event by calling 'processingInstruction' method
         * on currentHandler with the given arguments, if it is not null.
         * </p>
         * <p>
         * This method should only ever be called by the SAX parser.
         * </p>
         *
         * @param target the processing instruction target
         * @param data the processing instruction data, or null if none was supplied. The data does
         *            not include any whitespace separating it from the target
         * @throws SAXException if any exception was thrown by any of the handlers. This will
         *             possibly wrap an underlying exception.
         * @throws IllegalArgumentException if target is null (data is allowed to be null)
         */
        public void processingInstruction(String target, String data) throws SAXException {
            ReaderHelper.validateNotNull(target, "target");
            // delegates such event to currentHandler.processingInstruction
            // if there is a currentHandler
            if (currentHandler != null) {
                currentHandler.processingInstruction(target, data);
            }
        }

        /**
         * <p>
         * Processes the characters SAX event by calling 'characters' method on that currentHandler
         * with the given arguments, If the it is not null.
         * </p>
         * <p>
         * This method should only ever be called by the SAX parser.
         * </p>
         *
         * @param ch the characters from the XML document
         * @param start the start position in the array
         * @param length the number of characters to read from the array
         * @throws SAXException if any exception was thrown by any of the handlers. This will
         *             possibly wrap an underlying exception.
         * @throws IllegalArgumentException if ch is null or if start or length is negative or would
         *             go off the end of the ch array
         */
        public void characters(char[] ch, int start, int length) throws SAXException {
            ReaderHelper.validaChaArrayAndBoundArgument(ch, start, length);
            // delegates such event to currentHandler.characters if there is a currentHandler
            if (currentHandler != null) {
                currentHandler.characters(ch, start, length);
            }
        }

        /**
         * <p>
         * Processes the endDocument SAX event by calling 'endDocument' on all the handlers in the
         * 'handlers' map in the enclosing class. Every unique handler in the map is only called once.
         * </p>
         * <p>
         * This method should only ever be called by the SAX parser.
         * </p>
         *
         * @throws SAXException if any exception was thrown by any of the handlers. This will
         *             possibly wrap an underlying exception.
         */
        public void endDocument() throws SAXException {
            Set<XMIHandler> alreadyCalled = new HashSet<XMIHandler>();
            for (XMIHandler handler : handlers.values()) {
                if(!alreadyCalled.contains(handler)) {
                    handler.endDocument();
                    alreadyCalled.add(handler);
                }
            }
        }
    }

    /**
     * <p>
     * Represents the properties of elements that have not actually been found yet, but have been
     * referenced before they are defined. Therefore, we have to keep track of the properties that
     * were found, and the values of those properties (the objects). This map maps the XMI id of the
     * object found (as a String), to a map; the second map maps the property name (as a String) to
     * a list of the objects attached to the id under that property name.
     * </p>
     * <p>
     * This map is never null; neither keys nor values will ever be null. Neither the keys nor the
     * values on the sub-map will never be null, nor will any entries on the Lists on the submaps.
     * None of the keys will ever be empty after trimmed either. This attribute is modified in
     * putElementProperty and accessed by getElementProperties. Also, when the element is actually
     * found, and put into the foundElements map, it is removed from this map. When the parse method
     * is called, this map should be cleared.
     * </p>
     */
    private final Map<String, Map<String, List>> forwardReferences = new HashMap<String, Map<String, List>>();

    /**
     * <p>
     * This maps element names (as Strings) to the XMIHandler that can process that element type.
     * </p>
     * <p>
     * This map will never be null and neither keys nor values will never be null. Keys will never
     * be empty after trimmed. This map is modified by addHandler and removeHandler, and accessed by
     * getHandler. In addition, this map is used by the DelegatingHandler to find the appropriate
     * handler in its startElement and endElement methods.
     * </p>
     */
    private final Map<String, XMIHandler> handlers = new HashMap<String, XMIHandler>();

    /**
     * <p>
     * This object is created by parse(InputSource) and only lives while the parsing is still in
     * progress. Before and after parsing, this attribute is null. During parsing this attribute is
     * only used in the getActiveHandlers method, to retrieve the active handlers from the
     * DelegatingHandler.
     * </p>
     */
    private DelegatingHandler currentDelegatingHandler = null;

    /**
     * <p>
     * Creates this XMIReader object. If the default namespace exist, it will read the given
     * namespace and attempt to create XMIHandler instances from it.
     * </p>
     *
     * @throws XMIReaderConfigException if any of the objects in the default namespace could not be
     *             instantiated (wrong class or no appropriate constructor)
     */
    public XMIReader() throws XMIReaderConfigException {
        if (ConfigManager.getInstance().existsNamespace(DEFAULT_NAMESPACE)) {
            createXMIHandlerFromConfig(DEFAULT_NAMESPACE);
        }
    }

    /**
     * <p>
     * Creates this XMIReader object. Reads the given namespace and attempts to create XMIHandler
     * instances from it.
     * </p>
     *
     * @param namespace the ConfigManager namespace from which to retrieve the handlers.
     * @throws IllegalArgumentException if namespace is null or empty after trimmed
     * @throws XMIReaderConfigException if the namespace doesn't exist or if any of the objects
     *             could not be instantiated (wrong class or no appropriate constructor)
     */
    public XMIReader(String namespace) throws XMIReaderConfigException {
        ReaderHelper.validateString(namespace, "namespace");
        createXMIHandlerFromConfig(namespace);
    }

    /**
     * <p>
     * Adds the given handler to the handlers map with the given element type as the key. If another
     * handler already handled this type, the new handler replaces the old handler in the map.
     * </p>
     *
     * @param type the element type that this handler handles. Must be the full-qualified name
     *            (e.g., "UML:Class")
     * @param handler the handler that will handle this element type.
     * @throws IllegalArgumentException if either argument is null or if type is empty after
     *             trimmed.
     * @throws IllegalStateException if a parse is currently in progress (currentDelegatingHandler
     *             is not null)
     */
    public synchronized void addHandler(String type, XMIHandler handler) {
        ReaderHelper.validateString(type, "type");
        ReaderHelper.validateNotNull(handler, "handler");
        assertParseNotInProgress();
        handlers.put(type, handler);
    }

    /**
     * <p>
     * Removes the handler for the given type. If there was no handler for this element type,
     * nothing happens. Also, if the same handler handles more than one element type, only the
     * element type specified in the 'type' parameter will be removed.
     * </p>
     *
     * @param type the element type that this handler handled. Must be the full-qualified name
     *            (e.g., "UML:Class")
     * @throws IllegalArgumentException if either argument is null or if type is empty after
     *             trimmed.
     * @throws IllegalStateException if a parse is currently in progress (currentDelegatingHandler
     *             is not null)
     */
    public synchronized void removeHandler(String type) {
        ReaderHelper.validateString(type, "type");
        assertParseNotInProgress();
        handlers.remove(type);
    }

    /**
     * <p>
     * Retrieves a handler for the given element type from the handlers map.
     * </p>
     *
     * @return the handler that handles this type, or null if none found.
     * @param type the element type whose handler to find. Must be the full-qualified name (e.g.,
     *            "UML:Class")
     * @throws IllegalArgumentException if type is null or empty after trimmed.
     */
    public synchronized XMIHandler getHandler(String type) {
        ReaderHelper.validateString(type, "type");
        return handlers.get(type);
    }

    /**
     * <p>
     * Retrieves the element with the given id from the foundElements map. If the element was not
     * found, null is returned.
     * </p>
     *
     * @return the element reference as stored by putElement.
     * @param xmiId the id of the element to retrieve.
     * @throws IllegalArgumentException if xmiId is null or empty after trimmed.
     */
    public synchronized Object getElement(String xmiId) {
        ReaderHelper.validateString(xmiId, "xmiId");
        return foundElements.get(xmiId);
    }

    /**
     * <p>
     * Puts the given element into the foundElements map with the given id as the key. If there was
     * already an element in the map with the given id, the new element overwrites the old element.
     * </p>
     *
     * @param xmiId the id of the element to put into the map.
     * @param element the element to put into the map.
     * @throws IllegalArgumentException if either argument is null or if xmiId empty after trimmed.
     */
    public synchronized void putElement(String xmiId, Object element) {
        ReaderHelper.validateString(xmiId, "xmiId");
        ReaderHelper.validateNotNull(element, "element");
        foundElements.put(xmiId, element);
    }

    /**
     * <p>
     * Removes the element with the given id from the foundElements map. If it is not found in the
     * map, nothing happens.
     * </p>
     *
     * @param xmiId the ID of the element to remove from the foundElements map.
     * @throws IllegalArgumentException if xmiId is null or empty after trimmed.
     */
    public synchronized void removeElement(String xmiId) {
        ReaderHelper.validateString(xmiId, "xmiId");
        foundElements.remove(xmiId);
    }

    /**
     * <p>
     * Returns information about the forward reference. Given an element ID, returns a map which
     * maps property names to a list of objects which were attached to the given xmiId. If the id
     * was not found in the map, returns null.
     * </p>
     * <p>
     * Note that if the object is found in the foundElements map, it will not be found in the
     * forwardReferences map. It is the responsibility of the calling class to use the proper
     * method.
     * </p>
     *
     * @return the map of properties of that element ,and the list of objects which were attached to
     *         the given xmiId under that property name, or null if not found.
     * @param xmiId the id of the element whose properties are being requested
     * @throws IllegalArgumentException if xmiId is null or empty after trimmed.
     */
    public synchronized Map<String, List> getElementProperties(String xmiId) {
        ReaderHelper.validateString(xmiId, "xmiId");
        return forwardReferences.get(xmiId);
    }

    /**
     * <p>
     * Captures information about a forward reference. Given an element ID, updates the map of
     * properties of that element, by adding the refObject to the list of objects attached to the
     * element under that property name. If the xmiId doesn't exist yet, adds it to the
     * forwardReferences map. If the property doesn't exist in the property map for the id, adds it.
     * Note that the same refObject can be on the list for a given property for a given id more than
     * one time.
     * </p>
     *
     * @param xmiId the id of the element to add the property to
     * @param property the property of that element to add
     * @param refObject the object attached to the given id with the given property name
     * @throws IllegalArgumentException if any argument is null or if the String arguments are empty
     *             after trimmed
     * @throws IllegalStateException if xmiId represents an element which exists in the
     *             foundElements map
     */
    @SuppressWarnings("unchecked")
    public synchronized void putElementProperty(String xmiId, String property, Object refObject) {
        ReaderHelper.validateString(xmiId, "xmiId");
        ReaderHelper.validateString(property, "property");
        ReaderHelper.validateNotNull(refObject, "refObject");
        if (foundElements.containsKey(xmiId)) {
            throw new IllegalStateException(
                "xmiId represents an element which exists in the foundElements map.");
        }

        // finds the existing property map
        Map<String, List> properties = forwardReferences.get(xmiId);

        // if not there, creates it and adds to the forward references map
        if (properties == null) {
            properties = new HashMap<String, List>();
            forwardReferences.put(xmiId, properties);
        }

        // gets the list of refs for this property
        List refs = properties.get(property);

        // if not there, creates a new list
        if (refs == null) {
            refs = new ArrayList();
            properties.put(property, refs);
        }

        // adds the current referrer to the list of referrers for this property.
        refs.add(refObject);
    }

    /**
     * <p>
     * Returns the list (really a Stack) of XMIHandlers which are currently "active". This is used
     * by other XMIHandler objects to retrieve parent objects in the case of a nested node which
     * needs information about a parent node. The list of XMIHandlers will be automatically updated
     * by the DelegatingHandler. The list returned is un-modifiable.
     * </p>
     *
     * @return the current list of active XMIHandlers, maybe empty list if none are active now
     * @throws IllegalStateException if parsing is not currently occurring (i.e.,
     *             currentDelegatingHandler is null)
     */
    public synchronized List<XMIHandler> getActiveHandlers() {
        assertParseInProgress();
        return Collections.unmodifiableList(currentDelegatingHandler.getActiveHandlers());
    }

    /**
     * <p>
     * Parses the given input file using the current handlers.
     * </p>
     *
     * @param inputFile the file to parse.
     * @throws IllegalArgumentException if file is null, or if it doesn't exist or is not a file
     * @throws XMIReaderParseException if any exception occurs during the actual parsing; it will
     *             wrap the underlying exception.
     * @throws XMIReaderIOException if the file could not be opened for reading; if closing file
     *             reading stream fails after successfully executing all operations.
     * @throws XMIReaderConfigException if the SAX parser or org.xml.sax.XMLReader could not be
     *             configured
     * @throws IllegalStateException if a parse is currently in progress (currentDelegatingHandler
     *             is not null)
     */
    public synchronized void parse(File inputFile) throws XMIReaderIOException,
        XMIReaderConfigException, XMIReaderParseException {
        // validates the argument: not null, exist as a file
        ReaderHelper.validateNotNull(inputFile, "inputFile");
        if (!inputFile.isFile()) {
            throw new IllegalArgumentException("The [inputFile] doesn't exist or is not a file");
        }

        // makes sure the parse is not currently in progress
        // it is brought here for quick check
        assertParseNotInProgress();

        // creates FileInputStream for inputFile
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(inputFile);
        } catch (FileNotFoundException fnfe) {
            throw new XMIReaderIOException("Can not create [FileInputStream] for [inputFile].",
                fnfe);
        }

        // flag to denote whether exception is thrown from parse(InputStream)
        boolean execptionThrow = true;
        try {
            parse(inputStream);
            // all is done, no exception
            execptionThrow = false;
        } finally {
            releasesResource(inputStream, !execptionThrow);
        }
    }

    /**
     * <p>
     * Parses the given inputStream using the current handlers.
     * </p>
     *
     * @param inputStream the stream to parse.
     * @throws IllegalArgumentException if inputStream is null
     * @throws XMIReaderParseException if any exception occurs during the actual parsing; it will
     *             wrap the underlying exception
     * @throws XMIReaderConfigException if the SAX parser or org.xml.sax.XMLReader could not be
     *             configured
     * @throws IllegalStateException if a parse is currently in progress (currentDelegatingHandler
     *             is not null)
     */
    public synchronized void parse(InputStream inputStream) throws XMIReaderConfigException,
        XMIReaderParseException {
        ReaderHelper.validateNotNull(inputStream, "inputStream");

        // just delegates checking parsing in progress to parse(InputSource)
        parse(new InputSource(inputStream));
    }

    /**
     * <p>
     * Unzip the file and parse the XMI content inside(Only one of the XMI file inside is unzipped)
     * </p>
     *
     * @param filename the name of a ZIP file, with an XMI file inside, to parse as XMI content
     * @throws IllegalArgumentException if filename is null or empty after trimmed,or if file for
     *             filename doesn't exist or is not a file.
     * @throws XMIReaderParseException if the XMI inside the zip could not be parsed or if the zip
     *             doesn't contain an XMI file
     * @throws XMIReaderIOException if the zip file could not be unzipped; if fail to open the
     *             zipFile for reading; if closing inner ZipFile fails after successfully executing
     *             all operations
     * @throws XMIReaderConfigException if the SAX parser or org.xml.sax.XMLReader could not be
     *             configured
     * @throws IllegalStateException if a parse is currently in progress
     */
    public synchronized void parseZipFile(String filename) throws XMIReaderIOException,
        XMIReaderConfigException, XMIReaderParseException {
        ReaderHelper.validateString(filename, "filename");

        if (!new File(filename).isFile()) {
            throw new IllegalArgumentException("The [filename] does not represent a existing file.");
        }

        // makes sure the parse is not currently in progress
        // it is brought here for quick check
        assertParseNotInProgress();

        // unzips the file
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(filename);
        } catch (IOException ioe) {
            throw new XMIReaderIOException("The zip file could not be unzipped", ioe);
        }

        // flag to denote whether exception is thrown from parse(InputStream)
        boolean execptionThrow = true;
        // flag to denote whether a xmi file inside zip file is found
        boolean fileFound = false;
        Enumeration enumeration = zipFile.entries();
        try {
            // parses the first zip file
            while (enumeration.hasMoreElements() && !fileFound) {
                ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
                if (zipEntry.getName().toLowerCase().endsWith(SUFFIX_OF_ZIPFILE)) {
                    fileFound = true;
                    parse(zipFile.getInputStream(zipEntry));
                }
            }
            if (!fileFound) {
                throw new XMIReaderParseException("The zip file doesn't contain an XMI file.");
            }
            // all is done, no exception
            execptionThrow = false;
        } catch (IOException ioe) {
            throw new XMIReaderIOException("Error occurs while reading XMI file in zip file", ioe);
        } finally {
            releasesResource(zipFile, !execptionThrow);
        }

    }

    /**
     * <p>
     * Parses data at the given URI using the current handlers.
     * </p>
     *
     * @param uri the URI of the resource to parse.
     * @throws IllegalArgumentException if uri is null, or empty after trimmed
     * @throws XMIReaderParseException if any exception occurs during the actual parsing; it will
     *             wrap the underlying exception.
     * @throws XMIReaderIOException if the data in the given uri can not read or the stream for
     *             reading it can not be closed after successfully executing all operations
     * @throws XMIReaderConfigException if the uri is Malformed; if the SAX parser or
     *             org.xml.sax.XMLReader could not be configured
     * @throws IllegalStateException if a parse is currently in progress (currentDelegatingHandler
     *             is not null
     */
    public synchronized void parse(String uri) throws XMIReaderConfigException,
        XMIReaderIOException, XMIReaderParseException {
        ReaderHelper.validateString(uri, "uri");

        // makes sure the parse is not currently in progress
        // it is brought here for quick check
        assertParseNotInProgress();

        InputStream inputStream;
        try {
            // creates an URL from the uri
            URL url = new URL(uri);
            // gets input stream for the url
            inputStream = url.openStream();
        } catch (MalformedURLException murle) {
            throw new XMIReaderConfigException("Failed to Create URL from the given uri[" + uri
                + "]", murle);
        } catch (IOException ioe) {
            throw new XMIReaderIOException("Failed to open stream from the URL(created by the uri["
                + uri + "]", ioe);
        }

        // flag to denote whether exception is thrown from parse(InputStream)
        boolean execptionThrow = true;
        try {
            parse(inputStream);
            // all is done, no exception
            execptionThrow = false;
        } finally {
            releasesResource(inputStream, !execptionThrow);
        }
    }

    /**
     * <p>
     * This method does the actual parsing for the InputSource.
     * </p>
     *
     * @param source the input source to be parsed
     * @throws IllegalArgumentException if source is null
     * @throws XMIReaderParseException if any exception occurs during the actual parsing; it will
     *             wrap the underlying exception
     * @throws XMIReaderConfigException if the SAX parser or org.xml.sax.XMLReader could not be
     *             configured
     * @throws IllegalStateException if a parse was currently in progress (currentDelegatingHandler
     *             is not null)
     */
    private void parse(InputSource source) throws XMIReaderConfigException, XMIReaderParseException {

        ReaderHelper.validateNotNull(source, "source");

        assertParseNotInProgress();

        // clears the forwardReferences and foundElements maps
        forwardReferences.clear();
        foundElements.clear();

        XMLReader reader;
        try {
            // gets the XMLReader
            reader = XMLReaderFactory.createXMLReader();
            // we should be using namespaces
            reader.setFeature(NAMESPACE_FEATURE, true);
        } catch (SAXNotRecognizedException saxnre) {
            throw new XMIReaderConfigException("The namespace feature can not be recognized",
                saxnre);
        } catch (SAXNotSupportedException saxnse) {
            throw new XMIReaderConfigException("The namespace feature is not supported", saxnse);
        } catch (SAXException saxe) {
            throw new XMIReaderConfigException("The XMLReader can not be retrieved", saxe);
        }

        // creates a new delegating handler as the ContentHandler for the parser
        currentDelegatingHandler = new DelegatingHandler();

        reader.setContentHandler(currentDelegatingHandler);

        try {
            // starts the parsing
            reader.parse(source);
        } catch (IOException ioe) {
            throw new XMIReaderParseException("IOException occurs during parsing", ioe);
        } catch (SAXException saxe) {
            // tests if there is an underlying exception and use the underlying exception
            // to create XMIReaderParseException if there is any
            Exception e = saxe.getException();
            if (e == null) {
                throw new XMIReaderParseException("SAXException occurs during parsing", saxe);
            } else {
                throw new XMIReaderParseException(saxe.getMessage(), e);
            }
        } finally {
            // cleans up
            currentDelegatingHandler = null;
        }
    }

    /**
     * <p>
     * This method help to read and create all the configured XMIHandlers. The names with the
     * corresponding XMIHandlers will be stored in handlers map.
     * </p>
     *
     * @param namespace the ConfigManager namespace from which to retrieve the handlers.
     * @throws XMIReaderConfigException if the namespace doesn't exist or if any of the objects
     *             could not be instantiated (wrong class or no appropriate constructor)
     */
    private void createXMIHandlerFromConfig(String namespace) throws XMIReaderConfigException {
        try {
            ConfigManager cm = ConfigManager.getInstance();
            String reuseFlag = cm.getString(namespace, REUSE);

            boolean reuse = ((reuseFlag == null) || (TRUE.equalsIgnoreCase(reuseFlag)));

            // maps from class name to XMIHandler object. They are re-used if
            // the 'reuse' flag is set.
            Map<String, XMIHandler> instantiatedClasses = new HashMap<String, XMIHandler>();

            // retrieves the property of handlers
            Property property = cm.getPropertyObject(namespace, HANDLERS);
            if (property == null) {
                // no property 'handlers', just returns
                return;
            }

            // loops through all the sub-properties of the "handlers" property.
            Enumeration names = property.propertyNames();

            while (names.hasMoreElements()) {
                // name/value pairs
                String elementType = (String) names.nextElement();
                String className = property.getValue(elementType);
                // creates or retrieves this handler
                XMIHandler handler = null;

                if (reuse && instantiatedClasses.containsKey(className)) {
                    handler = instantiatedClasses.get(className);
                } else {
                    // retrieves the class for configured className
                    Class theClass = Class.forName(className);
                    Constructor ctor = null;
                    Object[] argument = new Object[0];

                    // first, tries to get the default constructor of ��className��
                    try {
                        ctor = theClass.getConstructor();
                    } catch (NoSuchMethodException nsme) {
                        // does nothing
                    }
                    // if the default constructor of 'className' doesn't exist
                    if (ctor == null) {
                        // tries to get the one-argument constructor that takes
                        // XMIReader as argument
                        ctor = theClass.getConstructor(XMIReader.class);
                        argument = new Object[]{this };
                    }
                    // creates XMIHandler
                    handler = (XMIHandler) ctor.newInstance(argument);
                    // if use the default constructor, we need to set XMIReader
                    if (argument.length == 0) {
                        handler.setXMIReader(this);
                    }
                    instantiatedClasses.put(className, handler);
                }

                // puts into handlers map
                handlers.put(elementType, handler);
            }

        } catch (UnknownNamespaceException une) {
            throw new XMIReaderConfigException("The namespace is unknown", une);
        } catch (ClassNotFoundException cnfe) {
            throw new XMIReaderConfigException("The class can not be found", cnfe);
        } catch (SecurityException se) {
            throw new XMIReaderConfigException("Security problems occurs", se);
        } catch (InstantiationException ie) {
            throw new XMIReaderConfigException(
                "The class that declares the underlying constructor represents an abstract class",
                ie);
        } catch (IllegalAccessException iae) {
            throw new XMIReaderConfigException("Illegal Access Exception occurs", iae);
        } catch (InvocationTargetException ite) {
            throw new XMIReaderConfigException("The underlying constructor throws an exception",
                ite);
        } catch (NoSuchMethodException nse) {
            throw new XMIReaderConfigException("A matching method is not found", nse);
        } catch (ClassCastException cce) {
            throw new XMIReaderConfigException("The class created is not of the XMIHandler type",
                cce);
        }
    }

    /**
     * <p>
     * This method will assert a parse is not currently in progress. IllegalStateException will be
     * thrown if a parse is currently in progress.
     * </p>
     *
     * @throws IllegalStateException if a parse is currently in progress (currentDelegatingHandler
     *             is not null)
     */
    private void assertParseNotInProgress() {
        if (currentDelegatingHandler != null) {
            throw new IllegalStateException("A parse is currently in progress.");
        }
    }

    /**
     * <p>
     * This method will assert a parse is currently in progress. IllegalStateException will be
     * thrown if a parse is not currently in progress.
     * </p>
     *
     * @throws IllegalStateException if a parse is not currently in progress
     *             (currentDelegatingHandler is null)
     */
    private void assertParseInProgress() {
        if (currentDelegatingHandler == null) {
            throw new IllegalStateException("A parse is not currently in progress.");
        }
    }

    /**
     * <p>
     * Closes the given resource which is either zipFile or InputStream.
     * </p>
     *
     * @param resource the resource to be closed
     * @param allowFlag flag to denote whether to thrown XMIReaderIOException when closing fails
     * @throws XMIReaderIOException if closing fails and the allowFlag is true
     */
    private void releasesResource(Object resource, boolean allowFlag) throws XMIReaderIOException {
        if (resource instanceof InputStream) {
            try {
                ((InputStream) resource).close();
            } catch (IOException ioe) {
                if (allowFlag) {
                    throw new XMIReaderIOException("Closing input stream failed", ioe);
                }
            }
        } else {
            try {
                ((ZipFile) resource).close();
            } catch (IOException ioe) {
                if (allowFlag) {
                    throw new XMIReaderIOException("Closing zipFile failed", ioe);
                }
            }
        }
    }
}
