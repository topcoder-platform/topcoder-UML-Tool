/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
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
 * This class is responsible for parsing out all the uml model elements except for State Machine and
 * Activity Graph model elements.
 * </p>
 *
 * <p>
 * This handler uses the ModelElementFactory to instantiate the proper model class instance.
 * Basically as we parse the xml elements we use the element designation name (like UML:TagDefinition
 * for example) as a key to create an instance of a class in the Object Model which represents the
 * UML:TagDefinition which in our case (depending on configuration of course) would be TagDefinition.
 * </p>
 *
 * <p>
 * The following uml elements will be handled by this handler.
 * <ul>
 * <li>UML:Multiplicity</li>
 * <li>UML:MultiplicityRange</li>
 * <li>UML:Expression</li>
 * <li>UML:BooleanExpression</li>
 * <li>UML:MappingExpression</li>
 * <li>UML:ProcedureExpression</li>
 * <li>UML:TypeExpression</li>
 * <li>UML:Class</li>
 * <li>UML:DataType</li>
 * <li>UML:AssociationEnd</li>
 * <li>UML:Interface</li>
 * <li>UML:Association</li>
 * <li>UML:Attribute</li>
 * <li>UML:Operation</li>
 * <li>UML:Parameter</li>
 * <li>UML:Method</li>
 * <li>UML:Generalization</li>
 * <li>UML:AssociationClass</li>
 * <li>UML:Dependency</li>
 * <li>UML:Abstraction</li>
 * <li>UML:Usage</li>
 * <li>UML:Binding</li>
 * <li>UML:Comment</li>
 * <li>UML:TemplateParameter</li>
 * <li>UML:Primitive</li>
 * <li>UML:Enumeration</li>
 * <li>UML:EnumerationLiteral</li>
 * <li>UML:Stereotype</li>
 * <li>UML:TagDefinition</li>
 * <li>UML:TaggedValue</li>
 * <li>UML:ProgrammingLanguageDataType</li>
 * <li>UML:TemplateArgument</li>
 * <li>UML:Procedure</li>
 * <li>UML:Object</li>
 * <li>UML:Stimulus</li>
 * <li>UML:Link</li>
 * <li>UML:LinkEnd</li>
 * <li>UML:CallOperationAction</li>
 * <li>UML:SendSignalAction</li>
 * <li>UML:CreateObjectAction</li>
 * <li>UML:DestroyObjectAction</li>
 * <li>UML:Message</li>
 * <li>UML:CollaborationInstanceSet</li>
 * <li>UML:Collaboration</li>
 * <li>UML:ElementImport</li>
 * <li>UML:Package</li>
 * <li>UML:Subsystem</li>
 * <li>UML:Model</li>
 * <li>UML:Actor</li>
 * <li>UML:UseCase</li>
 * <li>UML:Include</li>
 * <li>UML:Extend</li>
 * </ul>
 * Their corresponding property elements will be handled by this handler too.
 * For example, UML:Extend.base, UML:Message.conformingStimulus, etc.
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
public class XMI2ModelHandler extends DefaultXMIHandler {
    /**
     * <p>
     * Holds the order of xmi.idrefs which are used in the document. At the end of the document
     * this map is used to sort the idrefs in the correct order.
     * </p>
     */
    private Map<Object, Map<String, IdrefOrder>> idrefOrders = new HashMap<Object, Map<String,IdrefOrder>>();

    /**
     * <p>
     * Stores all the IDREFS attribute names.
     * </p>
     *
     * <p>
     * In the DTD file, the corresponding type is #IDREFS.
     * </p>
     *
     * <p>
     * This variable is initialized when loading into JVM and never changed afterwards.
     * </p>
     */
    private static final Set<String> IDREFS_ATTR_NAMES = new HashSet<String>();

    /**
     * <p>
     * Stores all the names of attribute that are ignored by the current implementation.
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
     * The IDREFS attribute names, ignored attribute names and text element names are set in
     * this constructor.
     * </p>
     */
    static {
        loadIdRefsAttributes();

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
     * Represents an object that can return the location of any SAX document event.
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
     * Represents model factory used to create instances of model element instances based on xml element names.
     * </p>
     *
     * <p>
     * This is initialized through either the ctor or through a setter. It is modifiable through a setter as well.
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
     * This is initialized through either the ctor or through a setter. It is modifiable through a setter as well.
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
     * This stack represents all the active element xmi id values. It must be implemented as a Stack so that
     * when children are processed, they can access their ancestor's element names.
     * </p>
     *
     * <p>
     * Note, if an xml element doesn't have an id, then null will be used.
     * </p>
     *
     * <p>
     * Entries are pushed in the startElement method and popped in endElement. This stack will
     * never be null but may be empty.
     * </p>
     */
    private Stack<String> xmiIdStack = new Stack<String>();

    /**
     * <p>
     * The xmi id value for the current element in the startElement() or endElement() methods.
     * </p>
     *
     * <p>
     * Note, it may be null if the current xml element doesn't have an id defined.
     * </p>
     */
    private String curXmiId;

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
     * can be invoked multiple times, so StringBuffer type is used for efficiency consideration.
     * </p>
     */
    private StringBuffer textElementContent;
    
    /**
     * Represents number of level that should be ignored.
     * UML-559: SAXException when opening string_filter.zuml file; Need to specify UML:ActionExpression in XMIReader_config.xml
     */
    private int ignored = 0;

    /**
     * <p>
     * Constructs a XMI2ModelHandler instance without any parameters.
     * </p>
     *
     * <p>
     * Note, this constructor is mainly for XMIReader to instantiate a XMI2ModelHandler
     * instance from configuration file.
     * </p>
     */
    public XMI2ModelHandler() {
        modelElementFactory = new ModelElementFactory();
        modelManager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * Constructs a XMI2ModelHandler instance with a xmi reader, a model factory and
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
    public XMI2ModelHandler(XMIReader reader, ModelElementFactory modelElementFactory, UMLModelManager modelManager) {
        super(reader);
        Util.checkNull(modelElementFactory, "modelElementFactory");
        Util.checkNull(modelManager, "modelManager");

        this.modelElementFactory = modelElementFactory;
        this.modelManager = modelManager;
    }

    /**
     * <p>
     * This is a static method for this class.
     * </p>
     *
     * <p>
     * The IDREFS attribute names are set in this static method.
     * </p>
     */
    private static final void loadIdRefsAttributes() {
        // for all the IDREFS attributes
        IDREFS_ATTR_NAMES.add("multiplicity");
        IDREFS_ATTR_NAMES.add("namespace");
        IDREFS_ATTR_NAMES.add("clientDependency");
        IDREFS_ATTR_NAMES.add("client");
        IDREFS_ATTR_NAMES.add("constraint");
        IDREFS_ATTR_NAMES.add("targetFlow");
        IDREFS_ATTR_NAMES.add("sourceFlow");
        IDREFS_ATTR_NAMES.add("comment");
        IDREFS_ATTR_NAMES.add("stereotype");
        IDREFS_ATTR_NAMES.add("generalization");
        IDREFS_ATTR_NAMES.add("powertypeRange");
        IDREFS_ATTR_NAMES.add("owner");
        IDREFS_ATTR_NAMES.add("type");
        IDREFS_ATTR_NAMES.add("association");
        IDREFS_ATTR_NAMES.add("participant");
        IDREFS_ATTR_NAMES.add("specification");
        IDREFS_ATTR_NAMES.add("constrainedElement");
        IDREFS_ATTR_NAMES.add("associationEnd");
        IDREFS_ATTR_NAMES.add("behavioralFeature");
        IDREFS_ATTR_NAMES.add("child");
        IDREFS_ATTR_NAMES.add("parent");
        IDREFS_ATTR_NAMES.add("powertype");
        IDREFS_ATTR_NAMES.add("supplier");
        IDREFS_ATTR_NAMES.add("subject");
        IDREFS_ATTR_NAMES.add("deploymentLocation");
        IDREFS_ATTR_NAMES.add("implementation");
        IDREFS_ATTR_NAMES.add("deployedComponent");
        IDREFS_ATTR_NAMES.add("annotatedElement");
        IDREFS_ATTR_NAMES.add("target");
        IDREFS_ATTR_NAMES.add("source");
        IDREFS_ATTR_NAMES.add("resident");
        IDREFS_ATTR_NAMES.add("template");
        IDREFS_ATTR_NAMES.add("defaultElement");
        IDREFS_ATTR_NAMES.add("enumeration");
        IDREFS_ATTR_NAMES.add("container");
        IDREFS_ATTR_NAMES.add("modelElement");
        IDREFS_ATTR_NAMES.add("referenceValue");
        IDREFS_ATTR_NAMES.add("binding");
        IDREFS_ATTR_NAMES.add("classifier");
        IDREFS_ATTR_NAMES.add("linkEnd");
        IDREFS_ATTR_NAMES.add("componentInstance");
        IDREFS_ATTR_NAMES.add("attribute");
        IDREFS_ATTR_NAMES.add("value");
        IDREFS_ATTR_NAMES.add("instance");
        IDREFS_ATTR_NAMES.add("signal");
        IDREFS_ATTR_NAMES.add("argument");
        IDREFS_ATTR_NAMES.add("sender");
        IDREFS_ATTR_NAMES.add("receiver");
        IDREFS_ATTR_NAMES.add("communicationLink");
        IDREFS_ATTR_NAMES.add("dispatchAction");
        IDREFS_ATTR_NAMES.add("expression");
        IDREFS_ATTR_NAMES.add("method");
        IDREFS_ATTR_NAMES.add("context");
        IDREFS_ATTR_NAMES.add("procedure");
        IDREFS_ATTR_NAMES.add("action");
        IDREFS_ATTR_NAMES.add("operation");
        IDREFS_ATTR_NAMES.add("representedClassifier");
        IDREFS_ATTR_NAMES.add("representedOperation");
        IDREFS_ATTR_NAMES.add("constrainingElement");
        IDREFS_ATTR_NAMES.add("usedCollaboration");
        IDREFS_ATTR_NAMES.add("base");
        IDREFS_ATTR_NAMES.add("availableFeature");
        IDREFS_ATTR_NAMES.add("availableContents");
        IDREFS_ATTR_NAMES.add("conformingInstance");
        IDREFS_ATTR_NAMES.add("message");
        IDREFS_ATTR_NAMES.add("conformingLink");
        IDREFS_ATTR_NAMES.add("availableQualifier");
        IDREFS_ATTR_NAMES.add("interaction");
        IDREFS_ATTR_NAMES.add("activator");
        IDREFS_ATTR_NAMES.add("sender");
        IDREFS_ATTR_NAMES.add("receiver");
        IDREFS_ATTR_NAMES.add("communicationConnection");
        IDREFS_ATTR_NAMES.add("conformingStimulus");
        IDREFS_ATTR_NAMES.add("collaboration");
        IDREFS_ATTR_NAMES.add("participatingInstance");
        IDREFS_ATTR_NAMES.add("participatingLink");
        IDREFS_ATTR_NAMES.add("constrainingElement");
        IDREFS_ATTR_NAMES.add("package");
        IDREFS_ATTR_NAMES.add("importedElement");
        IDREFS_ATTR_NAMES.add("extend");
        IDREFS_ATTR_NAMES.add("include");
        IDREFS_ATTR_NAMES.add("extension");
        IDREFS_ATTR_NAMES.add("extensionPoint");
        IDREFS_ATTR_NAMES.add("addition");
        IDREFS_ATTR_NAMES.add("useCase");
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
     * Receive notification of the beginning of the document.
     * </p>
     * <p>
     * This method sets the {@link UMLModelManager}'s model to an empty instance
     * of {@link ModelImpl} to ensure that the old model is replaced by a new one
     * even if there is no model definition in the parsed XMI file.
     * </p>
     */
    public void startDocument() {
        this.modelManager.setModel(new ModelImpl());
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
     * This method receives notification of the beginning of an element. All the uml model elements except for
     * State Machine and Activity Graph model elements are handled by this method.
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

        // UML-559: SAXException when opening string_filter.zuml file; Need to specify UML:ActionExpression in XMIReader_config.xml
        if (ignored > 0) {
			ignored++;
		}
        
        // This object represents the current xml element
        Object obj = null;

        curXmiId = null;

        String idRef = (atts != null) ? atts.getValue("xmi.idref") : null;

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
                    // UML-559: SAXException when opening string_filter.zuml file; Need to specify UML:ActionExpression in XMIReader_config.xml
                	// throw new SAXException("Configuration for element " + elementName
                	// + " is missing in ModelElementFactory.");
                	ignored++;
                	return;
                }

                // get the xmi.id value for current element, it may be null
                curXmiId = (atts != null) ? atts.getValue("xmi.id") : null;

                // If the current element represents a Model instance, then it should be
                // set to model manager
                if ("UML:Model".equals(elementName)) {
                    this.modelManager.setModel((Model) obj);
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
                    // UML-559: SAXException when opening string_filter.zuml file; Need to specify UML:ActionExpression in XMIReader_config.xml
                    // throw new SAXException("Configuration for the parent element of " + elementName
                    //    + " element is missing in ModelElementFactory.");
                    ignored++;
                	return;
                }

                // if "xmi.value" attribute is contained, then it should be an enumeration property
                // for example, <ModelElement.isSpecification xmi.value='false' />
                String xmiValue = (atts != null) ? atts.getValue("xmi.value") : null;
                if (xmiValue != null) {
                    int index = elementName.indexOf(".");
                    setEnumerationAttribute(obj, elementName, elementName.substring(index + 1), xmiValue);
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
     * This method receives notification of the end of an element. All the uml model elements except for
     * State Machine and Activity Graph model elements are handled by this method.
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

        // UML-559: SAXException when opening string_filter.zuml file; Need to specify UML:ActionExpression in XMIReader_config.xml
        if (ignored > 0) {
			ignored--;
			return;
		}
        
        int dotIndex = elementName.indexOf(".");

        // if the element represents a uml model element and its parent element is a uml element property,
        // then to set the property value for the parent uml element
        if (dotIndex < 0) {
            // get the object for the current element
            Object curElementObject = getLastRefObject();

            // if xmi.id attribute is defined for the current element, then the forward references in XMIReader
            // should be updated
            if (this.curXmiId != null) {
                updateElement(curXmiId, elementName, curElementObject);
            }

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
                    // <UML:UseCase.include>
                    // <UML:Include xmi.idref = '...'/>
                    // </UML:UseCase.include>
                    // The current element is "UML:Include", the parent element is "UML:UseCase.include"
                    // Here, the include property of the corresponding UseCase instance is set.
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
     * Receive notification of the end of the document.
     * </p>
     * <p>
     * This method performs post processing of the UML model. To handle the order of
     * xmi.idref children the order in which the xmi.idres occured is saved while parsing
     * the document. At the end of the document the xmi.idref attributes need to be set
     * in the correct order, which is done in this method.
     * </p>
     *
     * @throws SAXException if there is an xmi.idref in the file which points to an unknown xmi.id
     */
    public void endDocument() throws SAXException {
        // go through all (elementObject -> property) mappings
        for(Entry<Object, Map<String, IdrefOrder>> propertyMapping : idrefOrders.entrySet()) {
            // the element object for which to correct the idref-order
            Object elementObject = propertyMapping.getKey();

            // go through all (property -> idrefOrder) mappings
            for(Entry<String, IdrefOrder> entry : propertyMapping.getValue().entrySet()) {
                // the idrefOrder
                IdrefOrder idrefOrder = entry.getValue();

                // we need to process only idrefOrders with more than one child element set
                if(idrefOrder.needsProcessing()) {
                    // get the child objects in the correct order using the xmi.idrefs from the idrefOrder
                    List<Object> orderedProperties = new ArrayList<Object>(idrefOrder.getIdrefs().size());
                    for(String refid : idrefOrder.getIdrefs()) {
                        Object prop = this.getCurrentXMIReader().getElement(refid);
                        if(prop == null) {
                            // UML-560: Supress SAXException when opening files
                            // a reference to an unknown xmi.id encountered
                            //throw new SAXException("The referenced REFID is not known: " + refid);
                        	continue;
                        }
                        orderedProperties.add(prop);
                    }

                    // clear the old property list
                    Method method = idrefOrder.getMethod();
                    if (method != null) {
                        this.clearProperties(elementObject, method, orderedProperties);
                    }

                    // now set the properties in the correct order
                    try {
                        for(Object prop : orderedProperties) {
                            idrefOrder.getMethod().invoke(elementObject, prop);
                        }
                    } catch (IllegalArgumentException e) {
                        // will not happen since it worked before in setElementPropertie
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // will not happen since it worked before in setElementPropertie
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        // will not happen since it worked before in setElementPropertie
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * <p>
     * This method removes the given properties in the props list from the given element object.
     * The name for the remove method is gathered using the name of the addMethod with which the
     * properties have been added before.
     * </p>
     * @param elementObject the element object from which to remove the properties
     * @param addMethod the method with which the properties have been added before.
     * @param props the properties.
     */
    @SuppressWarnings("unchecked")
    private void clearProperties(Object elementObject, Method addMethod, List<Object> props) {
        // from addXXX we get removeXXX
        String remMethName = "remove" + addMethod.getName().substring(3);

        // get all methods from the element object
        Method[] methods = elementObject.getClass().getMethods();
        for(Method m : methods) {
            Class[] paramTypes = m.getParameterTypes();
            // only use method with one parameter which is assignable from the properties type
            if (m.getName().contains(remMethName) && paramTypes.length == 1
                    && paramTypes[0].isAssignableFrom(props.get(0).getClass())) {
                try {
                    for (Object prop : props) {
                        m.invoke(elementObject, new Object[] {prop });
                    }
                    return;
                } catch (IllegalArgumentException e) {
                    // ignore, try the next method
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // ignore, try the next method
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // ignore, try the next method
                    e.printStackTrace();
                }
            }
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
    	// UML-559: SAXException when opening string_filter.zuml file; Need to specify UML:ActionExpression in XMIReader_config.xml
    	if (ignored > 0) {
			return;
		}
    	
        String content = new String(ch, start, length);
        if (content.trim().length() != 0) {
            if (this.textElementContent == null) {
                textElementContent = new StringBuffer();
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
     * Represents the Idref Order class.
     * </p>
     * @author TCSDEVELOPER
     * @version 1.0
     *
     */
    private class IdrefOrder {
        /**
         * <p>
         * The method used to set the attributed referenced by the idrefs.
         * </p>
         */
        private Method method;

        /**
         * <p>
         * The xmi.idrefs in the order they need to be added according to the XMI file.
         * </p>
         */
        private List<String> idrefs = new ArrayList<String>();

        /**
         * <p>
         * Checks if this {@link IdrefOrder} needs to be processed.
         * </p>
         * @return <code>true</code> if this {@link IdrefOrder} needs to be processed
         */
        public boolean needsProcessing() {
            return idrefs.size() > 1;
        }

        /**
         * <p>
         * Returns the method.
         * </p>
         * @return the method
         */
        public Method getMethod() {
            return this.method;
        }
        /**
         * <p>
         * Sets the method.
         * </p>
         * @param method the method to set
         */
        public void setMethod(Method method) {
            this.method = method;
        }

        /**
         * <p>
         * Returns the idrefs.
         * </p>
         * @return the idrefs
         */
        public List<String> getIdrefs() {
            return this.idrefs;
        }

        /**
         * <p>
         * Adds an idref.
         * </p>
         * @param idref the new idref.
         */
        public void addIdref(String idref) {
            this.idrefs.add(idref);
        }
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

            String property = handler.getLastProperty();
            Object lastRefObject = handler.getLastRefObject();

            if (property != null && lastRefObject != null) {
                // add the forward reference for the given xmi id
                this.getCurrentXMIReader().putElementProperty(idRef, property, lastRefObject);

                Map<String, IdrefOrder> prop2refidMapping = this.idrefOrders.get(lastRefObject);
                if(prop2refidMapping==null) {
                    prop2refidMapping = new HashMap<String, IdrefOrder>();
                    this.idrefOrders.put(lastRefObject, prop2refidMapping);
                }

                IdrefOrder idrefOrder = prop2refidMapping.get(property);
                if(idrefOrder==null) {
                    idrefOrder = new IdrefOrder();
                    prop2refidMapping.put(property, idrefOrder);
                }
                idrefOrder.addIdref(idRef);
            }
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
                if (setEnumerationAttribute(obj, elementName, attrName, attrValue)) {
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

                // set the property
                setElementProperty(obj, attrName, null, value);
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
        List<String> names = getAvailableMethodNames(attrName, null);

        Object param = attrValue;

        // get the method instance for the property
        Method method = getMethod(obj, names, String.class);

        // try the int type, for example, for the "zoom" attribute
        if (method == null) {
            method = getMethod(obj, names, int.class);
            if (method != null) {
                try {
                    param = Integer.parseInt(attrValue);
                } catch (NumberFormatException e) {
                    throw new SAXException("NumberFormatException occurs while converting string to int value.", e);
                }
            }
        }

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
     * The isXXX, visibility, aggregation, concurrency, changeability, ordering, kind, targetScope, ownerScope
     * attributes fall to the enumeration attributes.
     * </p>
     *
     * @param obj the uml model element instance
     * @param elementName the xmi element name
     * @param attrName the xmi attribute name
     * @param attrValue the xmi attribute value
     *
     * @return true if the attribute represents an enumeration attribute, false otherwise
     *
     * @throws SAXException if fails to set the enumeration property due to reflection.
     */
    private boolean setEnumerationAttribute(Object obj, String elementName, String attrName, String attrValue)
        throws SAXException {
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
            } else if ("aggregation".equals(attrName)) {
                // aggregation attribute
                parameterType = AggregationKind.class;
                parameterValue = convertAggregationKind(attrValue);
            } else if ("concurrency".equals(attrName)) {
                // concurrency attribute
                parameterType = CallConcurrencyKind.class;
                parameterValue = convertCallConcurrencyKind(attrValue);
            } else if ("changeability".equals(attrName)) {
                // changeability attribute
                parameterType = ChangeableKind.class;
                parameterValue = convertChangeableKind(attrValue);
            } else if ("ordering".equals(attrName)) {
                // ordering attribute
                parameterType = OrderingKind.class;
                parameterValue = convertOrderingKind(attrValue);
            } else if ("kind".equals(attrName)) {
                // kind attribute
                parameterType = ParameterDirectionKind.class;
                parameterValue = covertParameterDirectionKind(attrValue);
            } else if ("targetScope".equals(attrName) || "ownerScope".equals(attrName)  || "targetKind".equals(attrName)) {
                // If the element represents "AssociationEnd" and the attribute is "targetScope",
                // then the attribute name is reset to "targetKind"
                // There is only "setTargetKind()" method defined for AssociationEnd class
                if ("targetScope".equals(attrName) && elementName.indexOf("AssociationEnd") >= 0) {
                    attrName = "targetKind";
                }

                // targetScope or ownerScope
                parameterType = ScopeKind.class;
                parameterValue = covertScopeKind(attrValue);
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
     * Converts the given value to its corresponding ScopeKind instance.
     * </p>
     *
     * <p>
     * Null may be returned if the value doesn't represents a ScopeKind.
     * </p>
     *
     * @param attrValue the given value represents a ScopeKind instance
     *
     * @return the corresponding ScopeKind instance, null if none
     */
    private ScopeKind covertScopeKind(String attrValue) {
        if ("classifier".equals(attrValue)) {
            return ScopeKind.CLASSIFIER;
        } else if ("instance".equals(attrValue)) {
            return ScopeKind.INSTANCE;
        }

        return null;
    }

    /**
     * <p>
     * Converts the given value to its corresponding ParameterDirectionKind instance.
     * </p>
     *
     * <p>
     * Null may be returned if the value doesn't represents a ParameterDirectionKind.
     * </p>
     *
     * @param attrValue the given value represents a ParameterDirectionKind instance
     *
     * @return the corresponding ParameterDirectionKind instance, null if none
     */
    private ParameterDirectionKind covertParameterDirectionKind(String attrValue) {
        if ("in".equals(attrValue)) {
            return ParameterDirectionKind.IN;
        } else if ("inout".equals(attrValue)) {
            return ParameterDirectionKind.INOUT;
        } else if ("out".equals(attrValue)) {
            return ParameterDirectionKind.OUT;
        } else if ("return".equals(attrValue)) {
            return ParameterDirectionKind.RETURN;
        }

        return null;
    }

    /**
     * <p>
     * Converts the given value to its corresponding OrderingKind instance.
     * </p>
     *
     * <p>
     * Null may be returned if the value doesn't represents a OrderingKind.
     * </p>
     *
     * @param attrValue the given value represents a OrderingKind instance
     *
     * @return the corresponding OrderingKind instance, null if none
     */
    private OrderingKind convertOrderingKind(String attrValue) {
        if ("unordered".equals(attrValue)) {
            return OrderingKind.UNORDERED;
        } else if ("ordered".equals(attrValue)) {
            return OrderingKind.ORDERED;
        }

        return null;
    }

    /**
     * <p>
     * Converts the given value to its corresponding ChangeableKind instance.
     * </p>
     *
     * <p>
     * Null may be returned if the value doesn't represents a ChangeableKind.
     * </p>
     *
     * @param attrValue the given value represents a ChangeableKind instance
     *
     * @return the corresponding ChangeableKind instance, null if none
     */
    private ChangeableKind convertChangeableKind(String attrValue) {
        if ("changeable".equals(attrValue)) {
            return ChangeableKind.CHANGEABLE;
        } else if ("frozen".equals(attrValue)) {
            return ChangeableKind.FROZEN;
        } else if ("addOnly".equals(attrValue)) {
            return ChangeableKind.ADD_ONLY;
        }

        return null;
    }

    /**
     * <p>
     * Converts the given value to its corresponding CallConcurrencyKind instance.
     * </p>
     *
     * <p>
     * Null may be returned if the value doesn't represents a CallConcurrencyKind.
     * </p>
     *
     * @param attrValue the given value represents a CallConcurrencyKind instance
     *
     * @return the corresponding CallConcurrencyKind instance, null if none
     */
    private CallConcurrencyKind convertCallConcurrencyKind(String attrValue) {
        if ("sequential".equals(attrValue)) {
            return CallConcurrencyKind.SEQUENTIAL;
        } else if ("guarded".equals(attrValue)) {
            return CallConcurrencyKind.GUARDED;
        } else if ("concurrent".equals(attrValue)) {
            return CallConcurrencyKind.CONCURRENT;
        }

        return null;
    }

    /**
     * <p>
     * Converts the given value to its corresponding AggregationKind instance.
     * </p>
     *
     * <p>
     * Null may be returned if the value doesn't represents a AggregationKind.
     * </p>
     *
     * @param attrValue the given value represents a AggregationKind instance
     *
     * @return the corresponding AggregationKind instance, null if none
     */
    private AggregationKind convertAggregationKind(String attrValue) {
        if ("none".equals(attrValue)) {
            return AggregationKind.NONE;
        } else if ("aggregate".equals(attrValue)) {
            return AggregationKind.AGGREGATE;
        } else if ("composite".equals(attrValue)) {
            return AggregationKind.COMPOSITE;
        }

        return null;
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
     * @param attrValue the given value represents a VisibilityKind instance
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
     * &lt;UML:Multiplicity.range&gt;
     *     &lt;UML:MultiplicityRange ....../&gt;
     * &lt;/UML:Multiplicity.range&gt;
     * The property name is "range" while the additional property name is "MultiplicityRange".
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
     * &lt;UML:Multiplicity.range&gt;
     *     &lt;UML:MultiplicityRange ....../&gt;
     * &lt;/UML:Multiplicity.range&gt;
     * The property name is "range" while the additional property name is "MultiplicityRange".
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

        String oldPropName = propName;

        // get the property name
        // for example, get "range" from "UML:Multiplicity.range"
        propName = propName.substring(propName.indexOf(".") + 1);

        // get the additional property name
        // for example, get "MultiplicityRange" from "UML:MultiplicityRange"
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
                        methods[i].setAccessible(true);
                        methods[i].invoke(elementObj, new Object[] {
                            propObj
                        });
                        Map<String, IdrefOrder> prop2Idreforder = this.idrefOrders.get(elementObj);
                        if(prop2Idreforder!=null) {
                            IdrefOrder idreforder = prop2Idreforder.get(oldPropName);
                            if(idreforder!=null) {
                                idreforder.setMethod(methods[i]);
                            }
                        }
                        return;
                    } catch (IllegalArgumentException e) {
                        // ignore, try the next method
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // ignore, try the next method
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        // ignore, try the next method
                        e.printStackTrace();
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
     * Makes the current element name, its associated uml model element and the xmi.id value in stack.
     * </p>
     */
    private void push() {
        this.propertyStack.push(this.getLastProperty());
        this.lastRefObjectStack.push(this.getLastRefObject());
        this.xmiIdStack.push(this.curXmiId);
    }

    /**
     * <p>
     * Pops the current element name, its associated uml model element and the xmi.id value from stack.
     * </p>
     *
     * <p>
     * The parent element name and its associated uml model element will be set to
     * the current property name and reference object.
     * </p>
     *
     * <p>
     * The xmi.id value in the stack will update the current xmi.id variable as well.
     * </p>
     */
    private void pop() {
        // pops the stack
        this.propertyStack.pop();
        this.lastRefObjectStack.pop();
        this.xmiIdStack.pop();

        // updates the current property name and reference object
        if (this.propertyStack.isEmpty()) {
            this.setLastProperty(null);
            this.setLastRefObject(null);
            this.curXmiId = null;
        } else {
            this.setLastProperty(propertyStack.peek());
            this.setLastRefObject(this.lastRefObjectStack.peek());
            this.curXmiId = this.xmiIdStack.peek();
        }
    }

}