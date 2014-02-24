/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.diagraminterchange;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.DefaultXMIHandler;
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
 * This class is responsible for parsing out Diagram Interchange model elements.
 * </p>
 *
 * <p>
 * This handler uses the ModelElementFactory to instantiate the proper model class instance.
 * Basically as we parse the xml elements we use the element designation name (like UML:GraphConnector
 * for example) as a key to create an instance of a class in the Object Model which
 * represents the UML:GraphConnector which in our case (depending on configuration of course) would be
 * GraphConnector.
 * </p>
 *
 * <p>
 * The following uml elements will be handled by this handler.
 * <ul>
 * <li>UML:Property</li>
 * <li>UML:Reference</li>
 * <li>UML:DiagramLink</li>
 * <li>UML:GraphConnector</li>
 * <li>UML:Ellipse</li>
 * <li>UML:GraphEdge</li>
 * <li>UML:Point</li>
 * <li>UML:BezierPoint</li>
 * <li>UML:Dimension</li>
 * <li>UML:Polyline</li>
 * <li>UML:TextElement</li>
 * <li>UML:Image</li>
 * <li>UML:CoreSemanticModelBridge</li>
 * <li>UML:Uml1SemanticModelBridge</li>
 * <li>UML:SimpleSemanticModelElement</li>
 * <li>UML:GraphNode</li>
 * <li>UML:Diagram</li>
 * </ul>
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
public class DiagramInterchangeXMIHandler extends DefaultXMIHandler {
    /**
     * <p>
     * Represent the <b>true</b> value for boolean attribute.
     * </p>
     */
    private static final String FALSE = "false";

    /**
     * <p>
     * Represent the <b>false</b> value for boolean attribute.
     * </p>
     */
    private static final String TRUE = "true";

    /**
     * <p>
     * Represent the <b>XMI.field</b> tag element name in XMI file.
     * </p>
     */
    private static final String XMI_FIELD = "XMI.field";

    /**
     * <p>
     * Represent the <b>UML:Diagram</b> tag element name in XMI file.
     * </p>
     */
    private static final String UML_DIAGRAM = "UML:Diagram";

    /**
     * <p>
     * Represent the <b>xmi.id</b> attribute name in XMI file.
     * </p>
     */
    private static final String XMI_ID = "xmi.id";

    /**
     * <p>
     * Represent the <b>xmi.idref</b> attribute name in XMI file.
     * </p>
     */
    private static final String XMI_IDREF = "xmi.idref";

    /**
     * <p>
     * Represent the <b>xmi.value</b> attribute name in XMI file.
     * </p>
     */
    private static final String XMI_VALUE = "xmi.value";

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
     * Stores all the names of attributes that are ignored by the current implementation.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> IGNORED_ATTRIBUTES = new HashSet<String>();

    /**
     * <p>
     * Stores all the names of attributes that are of double type.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> DOUBLE_ATTRIBUTES = new HashSet<String>();

    /**
     * <p>
     * Stores all the names of elements that are of Point type.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> POINT_ELEMENTS = new HashSet<String>();

    /**
     * <p>
     * Stores all the names of elements that are of Dimension type.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> DIMENSION_ELEMENTS = new HashSet<String>();

    /**
     * <p>
     * Stores all the names of elements that are a collection and the type of each element
     * is Point.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> POINTS_ELEMENTS = new HashSet<String>();

    /**
     * <p>
     * This is a static constructor for this class.
     * </p>
     *
     * <p>
     * The IDREFS attribute names, ignored attribute names, double attribute names, point element names,
     * dimension element names and point collection element names are set in this constructor.
     * </p>
     */
    static {
        // for all the IDREFS attributes
        IDREFS_ATTR_NAMES.add("controls");
        IDREFS_ATTR_NAMES.add("element");
        IDREFS_ATTR_NAMES.add("viewport");
        IDREFS_ATTR_NAMES.add("diagramLink");
        IDREFS_ATTR_NAMES.add("reference");
        IDREFS_ATTR_NAMES.add("diagram");
        IDREFS_ATTR_NAMES.add("center");
        IDREFS_ATTR_NAMES.add("position");
        IDREFS_ATTR_NAMES.add("graphEdge");
        IDREFS_ATTR_NAMES.add("waypoints");
        IDREFS_ATTR_NAMES.add("anchor");
        IDREFS_ATTR_NAMES.add("position");
        IDREFS_ATTR_NAMES.add("size");
        IDREFS_ATTR_NAMES.add("referenced");

        // for all the ignored attributes
        IGNORED_ATTRIBUTES.add("xmi.uuid");
        IGNORED_ATTRIBUTES.add(XMI_ID);
        IGNORED_ATTRIBUTES.add(XMI_IDREF);
        IGNORED_ATTRIBUTES.add("xmi.label");
        IGNORED_ATTRIBUTES.add("href");

        // for all double attributes
        DOUBLE_ATTRIBUTES.add("x");
        DOUBLE_ATTRIBUTES.add("y");
        DOUBLE_ATTRIBUTES.add("zoom");
        DOUBLE_ATTRIBUTES.add("width");
        DOUBLE_ATTRIBUTES.add("height");
        DOUBLE_ATTRIBUTES.add("radiusX");
        DOUBLE_ATTRIBUTES.add("radiusY");
        DOUBLE_ATTRIBUTES.add("rotation");
        DOUBLE_ATTRIBUTES.add("startAngle");
        DOUBLE_ATTRIBUTES.add("endAngle");

        // for all point collection elements
        POINTS_ELEMENTS.add("controls");
        POINTS_ELEMENTS.add("waypoints");

        // for all point elements
        POINT_ELEMENTS.add("viewport");
        POINT_ELEMENTS.add("center");
        POINT_ELEMENTS.add("position");

        // for all dimension elements
        DIMENSION_ELEMENTS.add("size");
    }

    /**
     * <p>
     * Represents an object that can return the location of any SAX document event.
     * Is initialized through a dedicated setter.
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
     * Represents model factory used to create instances of model element instances based on xml element names.
     * </p>
     *
     * <p>
     * This is initialized through either the constructor or through a setter. It is modifiable through a setter as well.
     * Can be accessed through a dedicated getter.
     * </p>
     *
     * <p>
     * Note, it cannot be null.
     * </p>
     *
     */
    private ModelElementFactory modelElementFactory;

    /**
     * <p>
     * Represents model manager used to store the created activity graph.
     * </p>
     *
     * <p>
     * This is initialized through either the constructor or through a setter. It is modifiable through a setter as well.
     * Can be accessed through a dedicated getter.
     * </p>
     *
     * <p>
     * Note, it cannot be null.
     * </p>
     *
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
     * Represents the text value for the current <b>XMI.field</b> element.
     * </p>
     *
     * <p>
     * For example, &lt;XMI.field&gt;0.0&lt;/XMI.field&gt;, then the value 0.0 will be saved using
     * this variable.
     * </p>
     *
     * <p>
     * This variable is created in startElement() method, filled in characters() method and used in
     * endElement() method.
     * </p>
     *
     * <p>
     * The content of the <b>XMI.field</b> element may be splitted by the SAX parser and so the
     * characters() method can be invoked multiple times, so StringBuffer type is used for efficiency
     * consideration.
     * </p>
     */
    private StringBuffer xmiFieldValue;

    /**
     * <p>
     * Represents all the text values for the current <b>XMI.field</b> elements collection.
     * </p>
     *
     * <p>
     * For example,
     * &lt;XMI.field&gt;
     *     &lt;XMI.field&gt;0.0&lt;/XMI.field&gt;
     *     &lt;XMI.field&gt;1.0&lt;/XMI.field&gt;
     * &lt;/XMI.field&gt;
     * then the values 0.0 and 1.0 will be saved using this variable.
     * </p>
     *
     * <p>
     * This variable is created in characters() method and the value is used in endElement() method.
     * </p>
     */
    private List<StringBuffer> xmiFieldValues = new ArrayList<StringBuffer>();

    /**
     * <p>
     * Constructs a DiagramInterchangeXMIHandler instance without any parameters.
     * </p>
     *
     * <p>
     * Note, this constructor is mainly for XMIReader to instantiate a DiagramInterchangeXMIHandler
     * instance from configuration file.
     * </p>
     */
    public DiagramInterchangeXMIHandler() {
        modelElementFactory = new ModelElementFactory();
        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Constructs a DiagramInterchangeXMIHandler instance with a xmi reader, a model factory and
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
    public DiagramInterchangeXMIHandler(XMIReader reader, ModelElementFactory modelElementFactory,
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

    /**
     * <p>
     * Receive notification of the beginning of the document by clearing
     * the {@link UMLModelManager}'s {@link Diagram} list.
     * </p>
     *
     * @throws SAXException Any SAX exception, possibly
     *            wrapping another exception.
     */
    public void startDocument() throws SAXException {
        super.startDocument();
        this.modelManager.clearDiagrams();
    }

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
     * @throws SAXException Any SAX exception, possibly wrapping another exception, it may be caused by reflection,
     * incorrect configuration for ModelElementFactory class, etc.
     */
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        String elementName = ((qName != null) && (qName.trim().length() != 0)) ? qName : localName;

        // This object represents the current xml element
        Object obj = null;

        String idRef = (atts != null) ? atts.getValue(XMI_IDREF) : null;

        if (idRef != null) {
            // If this element is a reference element, get the object from XMIReader
            obj = getReferenceElement(idRef, elementName);
        } else {

            int dotIndex = elementName.indexOf(".");

            // There are two kinds of xml element : xml element for uml model element (no dot contained) and xml
            // element for uml model property (with dot contained)
            if (dotIndex < 0) {
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
                String id = (atts != null) ? atts.getValue(XMI_ID) : null;
                if (id != null) {
                    updateElement(id, obj);
                }

                // If the current element represents a Diagram instance, then it should be
                // added to model manager
                if (UML_DIAGRAM.equals(elementName)) {
                    this.modelManager.addDiagram((Diagram) obj);
                }

                if (this.getLastRefObject()instanceof GraphElement && obj instanceof DiagramElement) {
                    ((DiagramElement)obj).setContainer((GraphElement)this.getLastRefObject());
                }

                // update the model element using the attribute values
                if (atts != null) {
                    setAttributes(obj, elementName, atts);
                }
            } else if (XMI_FIELD.equals(elementName)) {
                // The associated object for XMI.field element is of int type, which means the
                // count of sub XMI.field elements.
                // When a new XMI.field element is found, then the count should be initialized to zero.
                obj = 0;

                xmiFieldValue = new StringBuffer();

                // If the parent element is XMI.field, then the count is updated
                if (XMI_FIELD.equals(this.getLastProperty())) {
                    int count = (Integer) this.getLastRefObject();
                    count++;
                    this.setLastRefObject(count);
                    this.lastRefObjectStack.pop();
                    this.lastRefObjectStack.push(count);
                }
            } else {
                // The element represents a uml model element property
                String propName = elementName.substring(dotIndex + 1);

                // Empty the XMI.field values for receiving the new XMI.field values for
                // the current element
                if (POINT_ELEMENTS.contains(propName) || POINTS_ELEMENTS.contains(propName)
                    || DIMENSION_ELEMENTS.contains(propName)) {
                    this.xmiFieldValues.clear();
                }

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
                String xmiValue = (atts != null) ? atts.getValue(XMI_VALUE) : null;
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
     * This method receives notification of the end of an element. The diagram interchange related
     * elements will be processed by this method.
     * </p>
     *
     * @param uri the Namespace URI;
     * @param localName The local name (without prefix), or the empty string if Namespace processing is
     * not being performed.
     * @param qName The qualified XML 1.0 name (with prefix), or the empty string if qualified names
     * are not available
     *
     * @throws SAXException Any SAX exception, possibly wrapping another exception, it may be caused
     * by reflection, etc.
     */
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String elementName = ((qName != null) && (qName.trim().length() != 0)) ? qName : localName;

        int dotIndex = elementName.indexOf(".");

        // if the element represents a uml model element and its parent element is a uml element property,
        // then to set the property value for the parent uml element
        if (dotIndex < 0) {
            // get the object for the current element
            Object curElementObject = getLastRefObject();

            // make the parent element name and object on the top of the stack
            // it is called before getParentHandler() method because the handler for the
            // element and the handler for parent element may be the same
            pop();

            XMIHandler handler = getParentHandler();

            if (handler != null) {
                String parentElementName = handler.getLastProperty();
                // the parent element represents a uml model property
                if (parentElementName != null && parentElementName.indexOf(".") >= 0) {

                    // update the uml model element property
                    // for example:
                    // <UML:GraphElement.semanticModel>
                    //     <UML:SimpleSemanticModelElement xmi.id = '......'/>
                    // </UML:GraphElement.semanticModel>
                    // The current element is "UML:SimpleSemanticModelElement", the parent element is
                    // "UML:GraphElement.semanticModel".
                    // Here, the semanticModel property of the corresponding GraphElement instance is set.
                    setElementProperty(handler.getLastRefObject(), parentElementName, curElementObject);
                }
            }
        } else {
            // get the property name
            // for example, get "semanticModel" from "UML:GraphElement.semanticModel"
            String propName = elementName.substring(dotIndex + 1);

            // If a XMI.field element ends, validate it and add the value to XMI.field values
            if (XMI_FIELD.equals(elementName)) {
                // Only zero or two sub XMI.field elements are allowed for each XMI.field element
                int count = (Integer) getLastRefObject();
                if (count != 0 && count != 2) {
                    throw new SAXException("One XMI.field element has " + count
                        + " child XMI.field elements, instead of 0 or 2.");
                }

                // If the current XMI.field element is an inner XMI.field element
                // for example, <XMI.field><XMI.field>0.0</XMI.field></XMI.field>
                // The first XMI.field is an outer element while the inner XMI.field element is an
                // inner element
                if (xmiFieldValue != null) {
                    this.xmiFieldValues.add(xmiFieldValue);
                    this.xmiFieldValue = null;
                }

            } else if (DIMENSION_ELEMENTS.contains(propName) || POINT_ELEMENTS.contains(propName)
                || POINTS_ELEMENTS.contains(propName)) {
                // The elements that may have XMI.field sub-elements
                if (!this.xmiFieldValues.isEmpty()) {
                    // Only two XMI.field sub-elements are allowed for the point or dimension elements
                    if (!POINTS_ELEMENTS.contains(propName) && this.xmiFieldValues.size() != 2) {
                        throw new SAXException("The " + elementName + " element contains " + this.xmiFieldValues.size()
                            + " XMI.field elements instead of two, only two is allowed.");
                    }

                    try {
                        if (DIMENSION_ELEMENTS.contains(propName)) {
                            // process the dimension element
                            // for example
                            // <UML:GraphNode.size>
                            //     <XMI.field>80.0776</XMI.field>
                            //     <XMI.field>15.0</XMI.field>
                            // </UML:GraphNode.size>
                            Dimension dimension = new Dimension();
                            dimension.setWidth(Double.valueOf(this.xmiFieldValues.get(0).toString()));
                            dimension.setHeight(Double.valueOf(this.xmiFieldValues.get(1).toString()));

                            this.setElementProperty(getLastRefObject(), elementName, dimension);
                        } else if (POINT_ELEMENTS.contains(propName)) {
                            // process the point element
                            // <UML:GraphElement.position>
                            //     <XMI.field>2.0</XMI.field>
                            //     <XMI.field>2.0</XMI.field>
                            // </UML:GraphElement.position>
                            Point point = new Point();
                            point.setX(Double.valueOf(this.xmiFieldValues.get(0).toString()));
                            point.setY(Double.valueOf(this.xmiFieldValues.get(1).toString()));

                            this.setElementProperty(getLastRefObject(), elementName, point);
                        } else {
                            // process the point collect element
                            // <UML:GraphEdge.waypoints>
                            //   <XMI.field>
                            //     <XMI.field>110.0</XMI.field>
                            //     <XMI.field>205.0</XMI.field>
                            //   </XMI.field>
                            //   <XMI.field>
                            //     <XMI.field>0.0</XMI.field>
                            //     <XMI.field>0.0</XMI.field>
                            //   </XMI.field>
                            //   ......
                            // </UML:GraphEdge.waypoints>
                            int len = this.xmiFieldValues.size();

                            // Add all the points
                            for (int i = 0; i < len / 2; i++) {
                                Point point = new Point();
                                point.setX(Double.valueOf(this.xmiFieldValues.get(2 * i).toString()));
                                point.setY(Double.valueOf(this.xmiFieldValues.get(2 * i + 1).toString()));

                                this.setElementProperty(getLastRefObject(), elementName, point);
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new SAXException("NumberFormatException occurs while converting string to double value.",
                            e);
                    }
                }
            }

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
     * @param length The number of characters to read from the array
     */
    public void characters(char[] ch, int start, int length) {
        if (XMI_FIELD.equals(this.getLastProperty())) {
            if (xmiFieldValue != null) {
                // fill the XMI.field content to the variable
                xmiFieldValue.append(ch, start, length);
            }
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
     * @param obj the associated uml model element instance
     */
    private void updateElement(String id, Object obj) {
        // Get all the forward references
        Map<String, List> map = this.getCurrentXMIReader().getElementProperties(id);
        if (map != null) {
            for (Map.Entry<String, List> entry : map.entrySet()) {
                List list = entry.getValue();
                if (list != null) {
                    // for each forward reference, update the uml model element
                    for (Object elementObj : list) {
                        setElementProperty(elementObj, entry.getKey(), obj);
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
                    // if the attribute is CDATA attribute
                } else if (setCDataAttribute(obj, attrName, attrValue)) {
                    // if the attribute is IDREFS attribute
                } else if (setIdRefsAttribute(obj, elementName, attrName, attrValue)) {
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
                // null or empty id is skipped
                if (id == null || id.trim().length() == 0) {
                    continue;
                }

                // The element is not yet defined
                Object value = getCurrentXMIReader().getElement(id);
                if (value == null) {
                    throw new SAXException("The attribute " + attrName + " element " + elementName
                        + " refers to an not yet defined element " + id);
                }

                setElementProperty(obj, attrName, value);
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
        List<String> names = getAvailableMethodNames(attrName);

        Object param = attrValue;

        // get the method instance for the property
        Method method = null;

        if (DOUBLE_ATTRIBUTES.contains(attrName)) {
            method = getMethod(obj, names, double.class);

            // convert the attribute value
            try {
                param = Double.valueOf(attrValue);
            } catch (NumberFormatException e) {
                throw new SAXException("NumberFormatException occurs while converting string to double value.", e);
            }

        } else {
            method = getMethod(obj, names, String.class);
        }

        // If the method can be found, then execute it
        if (method != null) {
            // execute the method if it is found
            executeMethod(method, obj, param);
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
     * The isXXX attributes fall to the enumeration attributes.
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
        // isXXX attribute
        if (TRUE.equals(attrValue) || FALSE.equals(attrValue)) {

            List<String> names = getAvailableMethodNames(attrName);

            // get the method instance
            Method method = getMethod(obj, names, boolean.class);

            if (method != null) {
                // set the property value
                executeMethod(method, obj, TRUE.equals(attrValue));
                return true;
            }
        }

        return false;
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
        // the class type for the given object
        Class type = obj.getClass();

        // try each name in the given method names
        for (String name : names) {
            try {
                // if the method is found, other method names will not be tried
                for (Method m : type.getMethods()) {
                    Class[] params = m.getParameterTypes();
                    if (m.getName().equalsIgnoreCase(name) && params.length==1 && params[0].equals(parameterType)) {
                        return m;
                    }
                }
            } catch (SecurityException e) {
                // ignore
            }
        }

        return null;
    }

    /**
     * <p>
     * Get all the possible setter method names for the given property name.
     * </p>
     *
     * <p>
     * For example,
     * &lt;UML:GraphElement.semanticModel&gt;
     *     ......
     * &lt;/UML:GraphElement.semanticModel&gt;
     * The property name is &quot;semanticModel&quot;.
     * </p>
     *
     * <p>
     * If the given property name is xXX, then the following method names will be generated:
     * <ul>
     * <li>setXXX</li>
     * <li>setX - if the property name starts with "is"</li>
     * <li>addXXX</li>
     * <li>addXX - if the property name ends with "s"</li>
     * </ul>
     * </p>
     *
     * @param name the property name
     *
     * @return all the possible setter method name for the given property name
     */
    private List<String> getAvailableMethodNames(String name) {
        List<String> names = new ArrayList<String>();

        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);

        // generate the possible method names that starts with "set"
        names.add("set" + name);

        // for boolean attribute
        if (name.startsWith("Is")) {
            names.add("set" + name.substring(2));
        }

        // generate the possible method names that starts with "add"
        names.add("add" + name);

        // remove two ending characters if the property name ends with 'es'
        if (name.endsWith("es")) {
            names.add("add" + name.substring(0, name.length() - 2));
        }

        // remove the ending character if the property name ends with 's'
        if (name.endsWith("s")) {
            names.add("add" + name.substring(0, name.length() - 1));
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
     * For example,
     * &lt;UML:GraphElement.semanticModel&gt;
     *     ......
     * &lt;/UML:GraphElement.semanticModel&gt;
     * The property name is &quot;semanticModel&quot; or &quot;UML:GraphElement.semanticModel&quot;.
     * </p>
     *
     * @param elementObj the uml model element instance
     * @param propName the property name
     * @param propObj the object for the sub-element
     */
    private void setElementProperty(Object elementObj, String propName, Object propObj) {
        if (elementObj == null || propObj == null) {
            return;
        }

        // get the property name
        // for example, get "semanticModel" from "UML:GraphElement.semanticModel"
        // If only "semanticModel" is given, then "semanticModel" will be got as the same
        propName = propName.substring(propName.indexOf(".") + 1);

        List<String> methodNames = getAvailableMethodNames(propName);

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
