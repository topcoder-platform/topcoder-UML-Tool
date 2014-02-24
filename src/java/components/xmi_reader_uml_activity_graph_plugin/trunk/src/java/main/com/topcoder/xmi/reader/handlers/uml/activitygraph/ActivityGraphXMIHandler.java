/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.activitygraph;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.DefaultXMIHandler;
import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ElementCreationException;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

/**
 * <p>
 * This is a concrete (but indirect) implementation of the ContentHandler interface.
 * </p>
 *
 * <p>
 * This class extends the DefaultXMIHandler abstract class, which implements some convenience
 * methods that deal with XMIReader.
 * This is important since we need to utilize XMIReader instance in the actual implementation.
 * </p>
 *
 * <p>
 * This class is responsible for parsing out State Machine as well as Activity Graph model elements.
 * Note that since Activity Graph is extended from State Machine this is a natural fit and there is
 * no need to split the handler into two separate entities.
 * </p>
 *
 * <p>
 * This handler uses the ModelElementFactory to instantiate the proper model class instance.
 * Basically as we parse the xml elements we use the element designation name (like UML:ActivityGraph
 * for example) as a key to create an instance of a class in the Object Model which represents
 * the UML:ActivityGraph which in our case (depending on configuration of course) would be ActivityGraph.
 * </p>
 *
 * <p>
 * The following uml elements will be handled by this handler.
 * <ul>
 * <li>UML:StateMachine</li>
 * <li>UML:Transition</li>
 * <li>UML:Guard</li>
 * <li>UML:Pseudostate</li>
 * <li>UML:CompositeState</li>
 * <li>UML:SimpleState</li>
 * <li>UML:FinalState</li>
 * <li>UML:ActivityGraph</li>
 * <li>UML:ActionState</li>
 * <li>UML:CallState</li>
 * <li>UML:ObjectFlowState</li>
 * </ul>
 * Their corresponding property elements will be handled by this handler too.
 * For example, UML:StateMachine.top, UML:Transition.guard, etc.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and so is not thread safe. As this class is only intended to
 * be used inside the XMIReader component, the thread safety should be handled by XMIReader component.
 * </p>
 *
 * @author AleaActaEst, biotrail
 * @version 1.0
 */
public class ActivityGraphXMIHandler extends DefaultXMIHandler {
    /**
     * <p>
     * Stores all the IDREFS attribute names.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> IDREFS_ATTR_NAMES = new HashSet<String>();

    /**
     * <p>
     * Stores all the attribute names that are ignored by the current implementation.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> IGNORED_ATTRIBUTES = new HashSet<String>();

    /**
     * <p>
     * Stores all the name of elements that may have text content.
     * </p>
     *
     * <p>
     * In the DTD file, the corresponding type is #PCDATA.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> TEXT_ELEMENTS = new HashSet<String>();


    /**
     * <p>
     * This is a static constructor for this class.
     * </p>
     *
     * <p>
     * The IDREFS attribute names and ignored attribute names are set in this constructor.
     * </p>
     */
    static {
        // for all the IDREFS attributes
        IDREFS_ATTR_NAMES.add("namespace");
        IDREFS_ATTR_NAMES.add("clientDependency");
        IDREFS_ATTR_NAMES.add("constraint");
        IDREFS_ATTR_NAMES.add("targetFlow");
        IDREFS_ATTR_NAMES.add("sourceFlow");
        IDREFS_ATTR_NAMES.add("comment");
        IDREFS_ATTR_NAMES.add("stereotype");
        IDREFS_ATTR_NAMES.add("context");
        IDREFS_ATTR_NAMES.add("submachineState");
        IDREFS_ATTR_NAMES.add("trigger");
        IDREFS_ATTR_NAMES.add("source");
        IDREFS_ATTR_NAMES.add("target");
        IDREFS_ATTR_NAMES.add("statemachine");
        IDREFS_ATTR_NAMES.add("transition");
        IDREFS_ATTR_NAMES.add("deferrableEvent");
        IDREFS_ATTR_NAMES.add("container");
        IDREFS_ATTR_NAMES.add("outgoing");
        IDREFS_ATTR_NAMES.add("incoming");
        IDREFS_ATTR_NAMES.add("parameter");
        IDREFS_ATTR_NAMES.add("type");

        // for all the ignored attributes
        IGNORED_ATTRIBUTES.add("xmi.uuid");
        IGNORED_ATTRIBUTES.add("xmi.id");
        IGNORED_ATTRIBUTES.add("xmi.idref");
        IGNORED_ATTRIBUTES.add("xmi.label");
        IGNORED_ATTRIBUTES.add("href");

        // for text elements
        TEXT_ELEMENTS.add("lower");
        TEXT_ELEMENTS.add("upper");
        TEXT_ELEMENTS.add("language");
        TEXT_ELEMENTS.add("body");
        TEXT_ELEMENTS.add("name");
        TEXT_ELEMENTS.add("discriminator");
        TEXT_ELEMENTS.add("icon");
        TEXT_ELEMENTS.add("baseClass");
        TEXT_ELEMENTS.add("tagType");
        TEXT_ELEMENTS.add("dataValue");
        TEXT_ELEMENTS.add("specification");
        TEXT_ELEMENTS.add("encoding");
        TEXT_ELEMENTS.add("bound");
        TEXT_ELEMENTS.add("referenceState");
        TEXT_ELEMENTS.add("alias");
        TEXT_ELEMENTS.add("location");
    }

    /**
     * <p>
     * Represents  an object that can return the location of any SAX document event.
     * initialized through a dedicated setter.
     * </p>
     *
     * <p>
     * Can not be accessed outside. Can be null.
     * </p>
     *
     * <p>
     * Note, this variable is not used in the current implementation. It is for future version.
     * </p>
     */
    private Locator locator;

    /**
     * <p>
     * Represents the text value for the element whose type is #PCDATA.
     * </p>
     *
     * <p>
     * This variable is created in characters() method and the value is used in endElement() method.
     * </p>
     *
     * <p>
     * The content of an element may be splitted by the SAX parser and so the characters() method
     * can be invoked multiple times, so StringBuilder type is used for efficiency consideration.
     * </p>
     */
    private StringBuilder textElementContent;

    /**
     * <p>
     * Represents model factory used to create instances of model element instances based on xml element
     * names.
     * </p>
     * <p>
     * This is initialized through either the constructor or through a setter. It is modifiable through a
     * setter as well. Can be accessed through a dedicated getter.
     * </p>
     * <p>
     * Note, it cannot be null.
     * </p>
     */
    private ModelElementFactory modelElementFactory;

    /**
     * <p>
     * Represents model manager used to store the created activity graph.
     * </p>
     * <p>
     * This is initialized through either the constructor or through a setter. It is modifiable through a
     * setter as well. Can be accessed through a dedicated getter.
     * </p>
     * <p>
     * Note, it cannot be null.
     * </p>
     */
    private UMLModelManager modelManager;

    /**
     * <p>
     * This stack represents all the active element names. It must be implemented as a Stack so that
     * when children are processed, they can access their ancestor's element names.
     * </p>
     *
     * <p>
     * Entries are pushed in the startElement method and popped in endElement. This stack will
     * never be null but may be empty.
     * </p>
     */
    private Stack<String> propertyStack = new Stack<String>();

    /**
     * <p>
     * This stack represents all the active element objects. It must be implemented as a Stack so that
     * when children are processed, they can access their ancestor's element object.
     * </p>
     *
     * <p>
     * Entries are pushed in the startElement method and popped in endElement. This stack will
     * never be null but may be empty.
     * </p>
     */
    private Stack<Object> lastRefObjectStack = new Stack<Object>();

    /**
     * <p>
     * Constructs a ActivityGraphXMIHandler instance without any parameters.
     * </p>
     *
     * <p>
     * Note, this constructor is mainly for XMIReader to instantiate a ActivityGraphXMIHandler
     * instance from configuration file.
     * </p>
     */
    public ActivityGraphXMIHandler() {
        modelElementFactory = new ModelElementFactory();
        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Constructs a ActivityGraphXMIHandler instance with a xmi reader, a model factory and
     * a uml model manager specified.
     * </p>
     *
     * @param reader the XMIReader instance to attach to this handler
     * @param modelElementFactory model factory used to create instances of model element instances
     * based on xml element names
     * @param modelManager an Instance of UMLmodelManager to be used by this handler
     *
     * @throws IllegalArgumentException if reader, factory, or manager is null.
     */
    public ActivityGraphXMIHandler(XMIReader reader, ModelElementFactory modelElementFactory,
        UMLModelManager modelManager) {
        super(reader);
        Util.checkNull(modelElementFactory, "modelElementFactory");
        Util.checkNull(modelManager, "modelManager");

        this.modelElementFactory = modelElementFactory;
        this.modelManager = modelManager;

    }

    /**
     * <p>
     * Sets the model factory used to create instances of model element instances based on
     * xml element names.
     * </p>
     *
     * @param modelElementFactory model factory used to create instances of model element
     * instances based on xml element names
     *
     * @throws IllegalArgumentException if factory is null
     */
    public void setModelElementFactory(ModelElementFactory modelElementFactory) {
        Util.checkNull(modelElementFactory, "modelElementFactory");

        this.modelElementFactory = modelElementFactory;

    }

    /**
     * <p>
     * Gets the currently set model factory used to create instances of model element
     * instances based on xml element names.
     * </p>
     *
     * @return currently set model factory used to create instances of model element
     * instances based on xml element names
     */
    public ModelElementFactory getModelElementFactory() {
        return this.modelElementFactory;
    }

    /**
     * <p>
     * This method implements the setDocumentLocator(Locator) in ContentHandler interface.
     * </p>
     *
     * <p>
     * Note, null value is allowed
     * </p>
     *
     * @param locator An object that can return the location of any SAX document event
     */
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    /**
     * <p>
     * Sets the uml model manager used to store the created activity graph.
     * </p>
     *
     * @param modelManager uml model manager. The result of parsing is placed in the
     * ActivityGraphs instance in this class
     *
     * @throws IllegalArgumentException if manager is null.
     */
    public void setUmlModelManager(UMLModelManager modelManager) {
        Util.checkNull(modelManager, "modelManager");

        this.modelManager = modelManager;
    }

    /**
     * <p>
     * Gets the currently set model manager used to store the created activity graph.
     * </p>
     *
     * @return the currently set uml model manager
     */
    public UMLModelManager getUmlModelManager() {
        return this.modelManager;
    }

    /*
     * BugFix : BUGID009 clear activity graphs with new document
     * clearing the activity graphs when a new document is started.
     * Solution: added the startDocument method and cleared activity graphs in it
     */
    /**
     * <p>
     * Receive notification of the beginning of the document by clearing
     * the {@link UMLModelManager}'s {@link ActivityGraph} list.
     * </p>
     *
     * @throws SAXException Any SAX exception, possibly
     *            wrapping another exception.
     */
    public void startDocument() throws SAXException {
        super.startDocument();
        this.modelManager.clearActivityGraphs();
    }
    // end of bugfix

    /**
     * <p>
     * This method implements the startElement(String,String,String,Attributes) in ContentHandler interface.
     * </p>
     *
     * <p>
     * This component is a plugin of XMIReader component and this method is intended to be invoked by XMIReader
     * class.
     * </p>
     *
     * <p>
     * This method receives notification of the beginning of an element. Only the activity graph related elements
     * will be processed by this method.
     * </p>
     *
     * @param uri the Namespace URI;
     * @param localName The local name (without prefix), or the empty string if Namespace processing is not
     * being performed.
     * @param qName The qualified name (with prefix), or the empty string if qualified names are not available.
     * @param atts The attributes attached to the element. If there are no attributes, it shall be an empty
     * Attributes object.
     *
     * @throws IllegalStateException if the reader is not set
     * @throws SAXException Any SAX exception, possibly wrapping another exception, it may be caused by reflection,
     * incorrect configuration for ModelElementFactory class, etc.
     */
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        String elementName = ((qName != null) && (qName.trim().length() != 0)) ? qName : localName;

        // This object represents the current xml element
        Object obj = null;

        String idRef = atts.getValue("xmi.idref");

        if (idRef != null) {
            // If this element is a reference element, get the object from XMIReader
            obj = getReferenceElement(idRef, elementName);
        } else {

            // There are two kinds of xml element : xml element for uml model element (no dot contained) and xml
            // element for uml model property (with dot contained)
            if (elementName.indexOf(".") < 0) {
                // The current element represents a uml model element

                // Creates the model element using ModelElementFactory
                try {
                    obj = getModelElementFactory().createModelElement(elementName);
                } catch (ElementCreationException e) {
                    throw new SAXException(
                        "ElementCreationException occurs while creating the model element instance for " + elementName,
                        e);
                }

                // If fails, then it should be configuration problem
                if (obj == null) {
                    throw new SAXException("Configuration for element " + elementName
                        + " is missing in ModelElementFactory.");
                }

                // If the "xmi.id" attribute is contained, then the forward references in XMIReader
                // should be updated
                String id = atts.getValue("xmi.id");
                if (id != null) {
                    updateElement(id, elementName, obj);
                }

                // If the current element represents a ActivityGraph instance, then it should be
                // added to model manager
                if ("UML:ActivityGraph".equals(elementName)) {
                    try {
                        this.modelManager.addActivityGraph((ActivityGraph) obj);
                    } catch (ClassCastException e) {
                        throw new SAXException("ClassCastException occurs while casting to ActivityGraph type.", e);
                    }
                }

                // update the model element using the attribute values
                if (atts != null) {
                    setAttributes(obj, elementName, atts);
                }
            } else {
                // The element represents a uml model element property

                // The parent element must be handled by this handler too according
                // to the XMIReader component
                // If the object for the parent element is missing, then it should
                // be configuration problem
                if (this.lastRefObjectStack.isEmpty()) {
                    throw new SAXException("Configuration for element " + elementName
                        + " is missing in ModelElementFactory.");
                }

                // set the object to the object for the parent element
                obj = this.lastRefObjectStack.peek();

                // The object for parent element must not be null, it is treated as
                // object for the current element too, because current element is a
                // property of the parent element
                if (obj == null) {
                    throw new SAXException("Configuration for the parent element of " + elementName
                        + " element is missing in ModelElementFactory.");
                }

                // if "xmi.value" attribute is contained, then it should be an enumeration property
                // for example, <ModelElement.isSpecification xmi.value='false' />
                String xmiValue = atts.getValue("xmi.value");
                if (xmiValue != null) {
                    int index = elementName.indexOf(".");
                    setEnumerationAttribute(obj, elementName.substring(index + 1), xmiValue);
                }
            }
        }

        // save the element name and its associated object in stack
        setLastRefObject(obj);
        setLastProperty(elementName);
        push();
    }

    /**
     * <p>
     * This method implements the endElement(String,String,String) method in ContentHandler interface.
     * </p>
     *
     * <p>
     * This component is a plugin of XMIReader component and this method is intended to be invoked
     * by XMIReader class.
     * </p>
     *
     * <p>
     * This method receives notification of the end of an element. Only the activity graph related
     * elements will be processed by this method.
     * </p>
     *
     * @param uri the Namespace URI;
     * @param localName The local name (without prefix), or the empty string if Namespace processing is
     * not being performed.
     * @param qName The qualified XML 1.0 name (with prefix), or the empty string if qualified names
     * are not available
     *
     * @throws IllegalStateException if the reader is not set
     * @throws SAXException Any SAX exception, possibly wrapping another exception, it may be caused
     * by reflection, etc.
     */
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String elementName = ((qName != null) && (qName.trim().length() != 0)) ? qName : localName;

        // if the element represents a uml model element and its parent element is a uml element property,
        // then to set the property value for the parent uml element
        int dotIndex = elementName.indexOf(".");
        if (dotIndex < 0) {
            // get the object for the current element
            Object curElementObject = getLastRefObject();

            // make the parent element name and object because on the top of the stack
            // it is called before getParentHandler() method because the handler for the
            // element and the handler for parent element may be
            pop();

            XMIHandler handler = getParentHandler();

            if (handler != null) {
                String parentElementName = handler.getLastProperty();
                // the parent element represents a uml model property
                if (parentElementName != null && parentElementName.indexOf(".") >= 0) {

                    // update the uml model element property
                    // for example:
                    // <UML:StateMachine.top>
                    //     <UML:CompositeState .../>
                    // </UML:StateMachine.top>
                    // The current element is "UML:CompositeState", the parent element is "UML:StateMachine.top"
                    // Here, the top property of the corresponding StateMachine instance is set.
                    setElementProperty(handler.getLastRefObject(), parentElementName, elementName, curElementObject);
                }
            }
        } else {
            String propName = elementName.substring(dotIndex + 1);

            // If the current element is a #PCDATA element and the content is non-null and non-empty,
            // then update the corresponding property using the text content.
            // For example,
            // <UML:Stereotype ......>
            //    <UML:Stereotype.baseClass>Package</UML:Stereotype.baseClass>
            // </UML:Stereotype>
            // Here, the text content "Package" is used to update the baseClass property for Stereotype class
            if (TEXT_ELEMENTS.contains(propName)) {
                if (textElementContent != null && textElementContent.toString().trim().length() != 0) {
                    this.setCDataAttribute(this.getLastRefObject(), propName, textElementContent.toString());
                }
            }

            // make the variable works for next text element
            textElementContent = null;

            // make the parent element name and object because on the top of the stack
            // the name and object for the current element will be discarded
            pop();
        }
    }

    /**
     * <p>
     * This method implements the characters(char[],int,int) method in ContentHandler interface.
     * </p>
     *
     * <p>
     * This component is a plugin of XMIReader component and this method is intended to be invoked
     * by XMIReader class.
     * </p>
     *
     * <p>
     * This method receives notification of character data.
     * </p>
     *
     * @param ch The characters from the XML document.
     * @param start The start position in the array.
     * @param length The number of characters to read from the array.
     */
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        if (content.trim().length() != 0) {
            if (this.textElementContent == null) {
                textElementContent = new StringBuilder();
            }
            // fill the content of the current element to the variable
            textElementContent.append(content);
        }
    }

    /**
     * <p>
     * Retrieves the current XMIReader instance associated with this handler.
     * </p>
     *
     * @return the current XMIReader instance associated with this handler
     *
     * @throws IllegalStateException if the XMIReader instance has not been set.
     */
    private XMIReader getCurrentXMIReader() {
        XMIReader reader = super.getXMIReader();

        if (reader == null) {
            throw new IllegalStateException("The XMI Reader is null, "
                + "which is not allowed during parsing the xmi file.");
        }

        return reader;
    }

    /**
     * <p>
     * Updates the forward references to the given xmi id in XMIReader.
     * </p>
     *
     * @param id the xmi id for an xmi element
     * @param name the name of the xmi element
     * @param obj the associated uml model element instance
     */
    private void updateElement(String id, String name, Object obj) {
        // Get all the forward references
        Map<String, List> map = this.getCurrentXMIReader().getElementProperties(id);
        if (map != null) {
            for (Map.Entry<String, List> entry : map.entrySet()) {
                List list = entry.getValue();
                if (list != null) {
                    // for each forward reference, update the uml model element
                    for (Object elementObj : list) {
                        setElementProperty(elementObj, entry.getKey(), name, obj);
                    }
                }
            }
        }

        // the uml element is save to XMIReader as a found element
        this.getCurrentXMIReader().putElement(id, obj);
    }

    /**
     * <p>
     * Retrieves the referenced element in the current XMIReader instance.
     * </p>
     *
     * <p>
     * Note, null may be returned if it is a forward reference. If it is the case, it is
     * added to the forward reference.
     * </p>
     *
     * @param idRef the xmi id refers to an element which may be or may be not stored in XMIReader instance
     * @param elementName the xmi element name
     * @return the referenced element in the current XMIReader instance, or null if it is a forward reference
     *
     * @throws SAXException if parent handler is null, or the parent element name or its associated object
     * is null
     */
    private Object getReferenceElement(String idRef, String elementName) throws SAXException {
        // get the object from found elements
        Object obj = this.getCurrentXMIReader().getElement(idRef);

        // if it is not found, then add the forward reference
        if (obj == null) {
            XMIHandler handler = getParentHandler();

            // the parent handler is required
            if (handler == null) {
                throw new SAXException("The handler for the parent element of " + elementName + " is null.");
            }

            // the parent element name is required
            if (handler.getLastProperty() == null) {
                throw new SAXException("The parent element name of " + elementName + " is null.");
            }

            // the object for the parent element is required
            if (handler.getLastRefObject() == null) {
                throw new SAXException("The associated object for element " + handler.getLastProperty() + "  is null.");
            }

            // add the forward reference for the given xmi id
            this.getCurrentXMIReader().putElementProperty(idRef, handler.getLastProperty(), handler.getLastRefObject());
        }

        return obj;
    }

    /**
     * <p>
     * This method sets the properties of a uml model element.
     * </p>
     *
     * <p>
     * The properties presents as attributes of the xmi element.
     * </p>
     *
     * @param obj the uml model element instance
     * @param elementName the xmi element name
     * @param atts The attributes attached to the element. If there are no attributes, it shall be
     * an empty Attributes object.
     *
     * @throws SAXException if fails to set the properties of the uml model element, it may be
     * caused by reflection, or the IDREFS attribute refers to a not yet defined element
     */
    private void setAttributes(Object obj, String elementName, Attributes atts) throws SAXException {
        int len = atts.getLength();
        for (int i = 0; i < len; i++) {
            String attrName = atts.getLocalName(i);
            String attrValue = atts.getValue(i);
            // some attributes are ignored, for example, xmi.label
            if (!IGNORED_ATTRIBUTES.contains(attrName)) {
                // if the attribute is an enumeration attribute
                if (setEnumerationAttribute(obj, attrName, attrValue)) {
                    continue;
                    // if the attribute is CDATA attribute
                } else if (setCDataAttribute(obj, attrName, attrValue)) {
                    continue;
                    // if the attribute is IDREFS attribute
                } else if (setIdRefsAttribute(obj, elementName, attrName, attrValue)) {
                    continue;
                } else {
                    // the attribute is not in the model, then ignore it
                }
            }
        }
    }

    /**
     * <p>
     * This method handles the IDREFS attribute.
     * </p>
     *
     * <p>
     * All the ids in an IDREFS attribute is separated with a blank.
     * </p>
     *
     * @param obj the uml model element instance
     * @param elementName the xmi element name
     * @param attrName the xmi attribute name
     * @param attrValue the xmi attribute value
     *
     * @return true if the attribute represents an IDREFS attribute, false otherwise
     *
     * @throws SAXException if the IDREFS attribute refers to a not yet defined element
     */
    private boolean setIdRefsAttribute(Object obj, String elementName, String attrName, String attrValue)
        throws SAXException {

        // IDREFS_ATTR_NAMES variable stores all the IDREFS attribute names
        if (IDREFS_ATTR_NAMES.contains(attrName)) {

            // blank is the separator
            String[] ids = attrValue.split(" ");

            for (String id : ids) {
                // empty id is skipped
                if (id.trim().length() == 0) {
                    continue;
                }

                // The element is not yet defined
                Object value = getCurrentXMIReader().getElement(id);
                if (value == null) {
                    throw new SAXException("The attribute " + attrName + " element " + elementName
                        + " refers to an not yet defined element " + id);
                }

                // set the property
                // note, "outgoing" and "incoming" are handled specially, because "Transition"
                // is required when setting the corresponding properties
                if ("outgoing".equals(attrName) || "incoming".equals(attrName)) {
                    setElementProperty(obj, attrName, "Transition", value);
                } else {
                    setElementProperty(obj, attrName, null, value);
                }
            }

            return true;
        }

        return false;
    }

    /**
     * <p>
     * This method handles the CDATA attribute.
     * </p>
     *
     * @param obj the uml model element instance
     * @param attrName the xmi attribute name
     * @param attrValue the xmi attribute value
     *
     * @return true if the attribute represents a CDATA attribute, false otherwise
     *
     * @throws SAXException if fails to set the string property due to reflection.
     */
    private boolean setCDataAttribute(Object obj, String attrName, String attrValue) throws SAXException {
        // get the method instance for the property
        Method method = getMethod(obj, getAvailableMethodNames(attrName, null), String.class);

        if (method != null) {
            // execute the method if it is found
            executeMethod(method, obj, attrValue);
            return true;
        }

        return false;
    }

    /**
     * <p>
     * This method handles the enumeration attribute.
     * </p>
     *
     * <p>
     * The isXXX, visibility and kind attributes fall to the enumeration attributes.
     * </p>
     *
     * @param obj the uml model element instance
     * @param attrName the xmi attribute name
     * @param attrValue the xmi attribute value
     *
     * @return true if the attribute represents an enumeration attribute, false otherwise
     *
     * @throws SAXException if fails to set the enumeration property due to reflection.
     */
    private boolean setEnumerationAttribute(Object obj, String attrName, String attrValue) throws SAXException {
        // the parameter type
        Class parameterType = null;

        // the parameter value
        Object parameterValue = null;

        // isXXX attribute
        if ("true".equals(attrValue) || "false".equals(attrValue)) {
            parameterType = boolean.class;
            parameterValue = "true".equals(attrValue);
        } else {
            if ("visibility".equals(attrName)) {
                // visibility attribute
                parameterType = VisibilityKind.class;
                parameterValue = convertVisibility(attrValue);
            } else if ("kind".equals(attrName)) {
                // kind attribute
                parameterType = PseudostateKind.class;
                parameterValue = covertPseudostateKind(attrValue);
            }
        }

        if (parameterType != null && parameterValue != null) {
            // generate all the possible method names
            List<String> names = getAvailableMethodNames(attrName, null);

            // get the method instance
            Method method = getMethod(obj, names, parameterType);
            if (method != null) {
                // set the property value
                executeMethod(method, obj, parameterValue);
                return true;
            }
        }

        return false;
    }

    /**
     * <p>
     * Converts the given value to its corresponding VisibilityKind instance.
     * </p>
     *
     * <p>
     * Null may be returned if the value doesn't represents a VisibilityKind.
     * </p>
     *
     * @param value the given value represents a VisibilityKind instance
     *
     * @return the corresponding VisibilityKind instance, null if none
     */
    private VisibilityKind convertVisibility(String value) {
        if ("public".equals(value)) {
            return VisibilityKind.PUBLIC;
        } else if ("protected".equals(value)) {
            return VisibilityKind.PROTECTED;
        } else if ("private".equals(value)) {
            return VisibilityKind.PRIVATE;
        } else if ("package".equals(value)) {
            return VisibilityKind.PACKAGE;
        }
        return null;
    }

    /**
     * <p>
     * Converts the given value to its corresponding PseudostateKind instance.
     * </p>
     *
     * <p>
     * Null may be returned if the value doesn't represents a PseudostateKind.
     * </p>
     *
     * @param attrValue the given value represents a PseudostateKind instance
     *
     * @return the corresponding PseudostateKind instance, null if none
     */
    private PseudostateKind covertPseudostateKind(String attrValue) {
        if ("choice".equals(attrValue)) {
            return PseudostateKind.CHOICE;
        } else if ("deepHistory".equals(attrValue)) {
            return PseudostateKind.DEEP_HISTORY;
        } else if ("fork".equals(attrValue)) {
            return PseudostateKind.FORK;
        } else if ("initial".equals(attrValue)) {
            return PseudostateKind.INITIAL;
        } else if ("join".equals(attrValue)) {
            return PseudostateKind.JOIN;
        } else if ("junction".equals(attrValue)) {
            return PseudostateKind.JUNCTION;
        } else if ("shallowHistory".equals(attrValue)) {
            return PseudostateKind.SHALLOW_HISTORY;
        }
        return null;
    }

    /**
     * <p>
     * Executes the given method using reflection.
     * </p>
     *
     * @param method the method instance to be executed
     * @param obj the object the underlying method is invoked from
     * @param param the parameter used for the method call
     *
     * @throws SAXException if fails to execute the method successfully
     */
    private void executeMethod(Method method, Object obj, Object param) throws SAXException {
        try {
            method.invoke(obj, new Object[] {
                param
            });
        } catch (IllegalArgumentException e) {
            throw new SAXException("IllegalArgumentException occurs while executing method " + method, e);
        } catch (IllegalAccessException e) {
            throw new SAXException("IllegalAccessException occurs while executing method " + method, e);
        } catch (InvocationTargetException e) {
            throw new SAXException("InvocationTargetException occurs while executing method " + method, e);
        }
    }

    /**
     * <p>
     * Retrieves the method instance if the given has one method that has the same name
     * as one of the given method names and the given parameter type.
     * </p>
     *
     * @param obj the object the underlying method is invoked from
     * @param names all the possible method names
     * @param parameterType the parameter type of the method (only one parameter for the method)
     *
     * @return the desired Method instance, null if none is found
     */
    private Method getMethod(Object obj, List<String> names, Class parameterType) {
        Method method = null;

        // the class type for the given object
        Class type = obj.getClass();

        // try each name in the given method names
        for (String name : names) {
            try {
                // if the method is found, other method names will not be tried
                method = type.getMethod(name, parameterType);
                if (method != null) {
                    break;
                }
            } catch (SecurityException e) {
                // ignore
            } catch (NoSuchMethodException e) {
                // ignore
            }
        }

        return method;
    }

    /**
     * <p>
     * Get all the possible setter method names for the given property name and additional
     * property name.
     * </p>
     *
     * <p>
     * For example,
     * &lt;UML:StateVertex.outgoing&gt;
     *     &lt;UML:Transition ....../&gt;
     * &lt;/UML:StateVertex.outgoing&gt;
     * The property name is "outgoing" while the additional property name is "Transition".
     * </p>
     *
     * <p>
     * If the given property name is xXX and the additional property name is yYY,
     * Then the following method names will be generated:
     * <ul>
     * <li>setXXX</li>
     * <li>setXXXYYY - if the additional property name is not null</li>
     * <li>setX - if the property name starts with "is"</li>
     * <li>addXXX</li>
     * <li>addXX - if the property name ends with "s"</li>
     * <li>addXXXYYY - if the additional property name is not null</li>
     * <li>addXXYYY - if the property name ends with "s" and the additional property name is not null</li>
     * </ul>
     * </p>
     *
     * @param name the property name
     * @param extraName the additional property name
     *
     * @return all the possible setter method name for the given property name and additional
     * property name
     */
    private List<String> getAvailableMethodNames(String name, String extraName) {
        List<String> names = new ArrayList<String>();

        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        if (extraName != null) {
            extraName = Character.toUpperCase(extraName.charAt(0)) + extraName.substring(1);
        }
        // generate the possible method names that starts with "set"
        names.add("set" + name);
        if (extraName != null) {
            names.add("set" + name + extraName);
        }
        if (name.startsWith("Is")) {
            names.add("set" + name.substring(2));
        }

        // generate the possible method names that starts with "add"
        names.add("add" + name);

        if (name.endsWith("s")) {
            names.add("add" + name.substring(0, name.length() - 1));
        }

        if (extraName != null) {
            names.add("add" + name + extraName);
            if (name.endsWith("s")) {
                names.add("add" + name.substring(0, name.length() - 1) + extraName);
            }
        }

        return names;
    }

    /**
     * <p>
     * This method sets the property of a uml model element.
     * </p>
     *
     * <p>
     * The property presents as sub-element of the xmi element.
     * </p>
     *
     * <p>
     * For example,
     * &lt;UML:StateVertex.outgoing&gt;
     *     &lt;UML:Transition ....../&gt;
     * &lt;/UML:StateVertex.outgoing&gt;
     * The property name is "outgoing" while the additional property name is "Transition".
     * </p>
     *
     * @param elementObj the uml model element instance
     * @param propName the property name
     * @param extraPropName the additional property name
     * @param propObj the object for the sub-element
     */
    private void setElementProperty(Object elementObj, String propName, String extraPropName, Object propObj) {
        if (elementObj == null || propObj == null) {
            return;
        }

        // get the property name
        // for example, get "outgoing" from "UML:StateVertex.outgoing"
        propName = propName.substring(propName.indexOf(".") + 1);

        // get the additional property name
        // for example, get "Transition" from "UML:Transition"
        if (extraPropName != null) {
            extraPropName = extraPropName.substring(extraPropName.indexOf(":") + 1);
        }

        List<String> methodNames = getAvailableMethodNames(propName, extraPropName);

        // store all the possible method names in Set representation for efficiency
        Set<String> names = new HashSet<String>();
        for (String methodName : methodNames) {

            names.add(methodName.toLowerCase());
        }

        // Get all the public methods defined for the element object
        Method[] methods = elementObj.getClass().getMethods();

        for (int i = 0; i < methods.length; i++) {
            // the method should only have one parameter
            if (methods[i].getParameterTypes().length == 1) {
                // compare the method name
                if (names.contains(methods[i].getName().toLowerCase())) {
                    try {
                        // execute the method, if it is invoked successfully, then this method
                        // will be returned, otherwise the next method will be tried
                        methods[i].invoke(elementObj, new Object[] {
                            propObj
                        });
                        return;
                    } catch (IllegalArgumentException e) {
                        // ignore, try the next method
                    } catch (IllegalAccessException e) {
                        // ignore, try the next method
                    } catch (InvocationTargetException e) {
                        // ignore, try the next method
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Retrieve the XMIHandler for the parent element
     * </p>
     *
     * <p>
     * Note, it may be null.
     * </p>
     *
     * @return the XMIHandler for the parent element
     */
    private XMIHandler getParentHandler() {
        // get all the active handlers from XMIReader instance
        List<XMIHandler> handlers = this.getCurrentXMIReader().getActiveHandlers();

        XMIHandler handler = null;

        // the handler in the top of the stack should be the handler for the current element
        // the next element from the stack top should be the handler for the parent element
        if (handlers.size() >= 2) {
            handler = handlers.get(handlers.size() - 2);
        }

        return handler;
    }

    /**
     * <p>
     * Makes the current element name and its associated uml model element in stack.
     * </p>
     */
    private void push() {
        this.propertyStack.push(this.getLastProperty());
        this.lastRefObjectStack.push(this.getLastRefObject());
    }

    /**
     * <p>
     * Pops the current element name and its associated uml model element from stack.
     * </p>
     *
     * <p>
     * The parent element name and its associated uml model element will be set to
     * the current property name and reference object.
     * </p>
     */
    private void pop() {
        // pops the stack
        this.propertyStack.pop();
        this.lastRefObjectStack.pop();

        // updates the current property name and reference object
        if (this.propertyStack.isEmpty()) {
            this.setLastProperty(null);
            this.setLastRefObject(null);
        } else {
            this.setLastProperty(propertyStack.peek());
            this.setLastRefObject(this.lastRefObjectStack.peek());
        }
    }

}
