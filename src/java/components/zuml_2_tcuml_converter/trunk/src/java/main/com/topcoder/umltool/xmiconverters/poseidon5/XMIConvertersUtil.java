/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * <p>
 * This utility class is used to:
 * <p>
 * 1. Configure the XMIReader to add additional XMIHandler instances to convert poseidon
 * zuml file and add XMIConverter instances for existing XMIHandlers to do some convertions
 * before or after the handler processing.
 * </p>
 * <p>
 * 2. Adjust the Diagram size of zuml because it is always (0,0) and the TC UML Tool can't
 * display the diagram.
 * </p>
 * <p>
 * 3. Remove Diagram title node because TC UML Tool can't display it.
 * </p>
 * <p>
 * 4. Convert Diagram title node to text node so that TC UML Tool can display it.
 * </p>
 * <p>
 * 5. Replace the keys of properties in diagram element. Because the properties keys are
 * different between zuml and tcuml.
 * </p>
 * <p>
 * 6. Transform the values of properties in diagram element by given transformers.
 * </p>
 *
 * <p>
 * The application can only use config method to configure XMIReader so that the other processing
 * in TC UML Open Action remains the same. Or it can do the post reading tasks using the util
 * methods directly so that it doesn't need to configure the DiagramSizeConverter, DiagramTitleConverter
 * and GraphPropertiesConverter to XMIReader.
 * </p>
 *
 * <p>Here is sample config:</p>
 * <p>&lt;Property name="ObjectFactoryNamespace"&gt;</p>
 * <p>    &lt;Value&gt;object_factory_namespace&lt;/Value&gt;</p>
 * <p>&lt;/Property&gt;</p>
 * <p>&lt;Property name="AdditionalHandlers"&gt;</p>
 * <p>    &lt;Property name="XMI$header"&gt;</p>
 * <p>        &lt;Value&gt;handlers:xmiheader&lt;/Value&gt;</p>
 * <p>    &lt;/Property&gt;</p>
 * <p>&lt;/Property&gt;</p>
 * <p>&lt;Property name="Converters"&gt;</p>
 * <p>    &lt;Property name="UML:Diagram"&gt;</p>
 * <p>        &lt;Value&gt;converters:diagramtitle&lt;/Value&gt;</p>
 * <p>    &lt;/Property&gt;</p>
 * <p>&lt;/Property&gt;</p>
 * <p>Note: The value for AdditionalHandlers and Converters are keys in object factory's config.</p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is stateless and immutable, and all the used components (ObjectFactory and ConfigManager)
 * are thread-safe, so it is thread-safe.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class XMIConvertersUtil {
    /**
     * <p>
     * The constant represents the default namespace to configure the XMIReader,
     * the additional handlers and XMIConverters are configured in the namespace of ConfigManager.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * <p>The configuration property name of Object Factory.</p>
     */
    private static final String OBJECT_FACTORY = "ObjectFactoryNamespace";

    /**
     * <p>The configuration property name of addtional handlers.</p>
     */
    private static final String ADDTIONALHANDLERS = "AdditionalHandlers";

    /**
     * <p>The configuration property name of converters.</p>
     */
    private static final String CONVERTERS = "Converters";

    /**
     * <p>The typeInfo of title node in a Diagram.</p>
     */
    private static final String NAME_COMPARTMENT = "NameCompartment";

    /**
     * <p>The string value of TextNode in tuml.</p>
     */
    private static final String TEXT_NODE_VALUE = "FreeText";

    /**
     * <p>The hash map of prefixes.</p>
     */
    private static final Map<String, String> PREFIXMAP = new HashMap<String, String>();

    //Initialize the prefix map. This map is used in convertDiagramTitleToText().
    //The key in this map is the name of the diagram in the .zuml file, the value is
    //the corresponding prefix in the tcuml file.
    static {
        PREFIXMAP.put("ClassDiagram", "cd:");
        PREFIXMAP.put("UseCaseDiagram", "ud:");
        PREFIXMAP.put("StateDiagram", "sm:");
        PREFIXMAP.put("ActivityDiagram", "ad:");
        PREFIXMAP.put("CollaborationDiagram", "cld:");
        PREFIXMAP.put("SequenceDiagram", "sd:");
        PREFIXMAP.put("ComponentDiagram", "cd:");
        PREFIXMAP.put("DeploymentDiagram", "dd:");
    }

    /**
     * <p>The empty private constructor prevents the user constructing this class.</p>
     */
    private XMIConvertersUtil() {
    }

    /**
     * <p>
     * Configure the XMIReader instance with additional XMIHandlers and XMIConverters to existing
     * handlers. The namespace to configure is DEFAULT_NAMESPACE.
     * </p>
     *
     * @param reader the XMIReader instance to configure
     * @throws IllegalArgumentException if any argument is null
     * @throws XMIConverterConfigurationException if fails to configure the reader
     */
    public static void config(XMIReader reader)
        throws XMIConverterConfigurationException {
        config(reader, DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * Configure the XMIReader instance with additional XMIHandlers and XMIConverters to existing
     * handlers. All the handlers and converters are configured in the given nameSpace. Using configure
     * item 'ObjectFactoryNamespace' to create Object Factory, it's required. For each property under
     * AddtionalHandlers, property name is the type of XMIHandler to be added to the reader, the property
     * value is a key in object factory, represents a XMIHandler instance. For each property under
     * Converters, property name is the type of XMIHandler in the reader, the property value is a key in
     * object factory, represents which XMIConverter instance to be added to the specified handler.
     * </p>
     *
     * @param reader the XMI reader to configure
     * @param nameSpace the namespace to configure XMI reader
     * @throws IllegalArgumentException if any argument is null or any string is empty
     * @throws XMIConfigurationException if fails to configure the reader
     */
    public static void config(XMIReader reader, String nameSpace)
        throws XMIConverterConfigurationException {
        Helper.checkNull(reader, "reader");
        Helper.checkString(nameSpace, "nameSpace");

        ConfigManager manager = ConfigManager.getInstance();

        try {
            Property ofProperty = manager.getPropertyObject(nameSpace,
                    OBJECT_FACTORY);

            if ((ofProperty == null) || (ofProperty.getValue() == null)) {
                throw new XMIConverterConfigurationException(
                    "There should be a config item ObjectFactoryNamespace for object factory");
            }

            if(ofProperty.getValue().trim().length() == 0) {
                throw new XMIConverterConfigurationException("The namespace for Object Factory should not be empty.");
            }

            ObjectFactory of = new ObjectFactory(new ConfigManagerSpecificationFactory(
                        ofProperty.getValue().trim()));

            configHandlers(of, reader, nameSpace);
            configConverters(of, reader, nameSpace);
        } catch (UnknownNamespaceException e) {
            throw new XMIConverterConfigurationException("The namespace doesn't exist.",
                e);
        } catch (SpecificationConfigurationException e) {
            throw new XMIConverterConfigurationException("There are errors for object factory configuration",
                e);
        } catch (IllegalReferenceException e) {
            throw new XMIConverterConfigurationException("There are errors for object factory configuration",
                e);
        } catch (InvalidClassSpecificationException e) {
            throw new XMIConverterConfigurationException("Could not create object from object factory",
                e);
        }
    }

    /**
     * <p>
     * Read the configuration of AddtionalHandlers, each value of a handler is a key in the object factory.
     * Then create a XMIHandler instance from object factory using this key. Then add the handler to the
     * XMIReader, accociate to its name.
     * </p>
     *
     * @param of the object factory used to create handlers
     * @param reader the XMIReader to configure
     * @param nameSpace the namespace of configuration information
     * @throws UnknownNamespaceException if the namespace doesn't exist
     * @throws InvalidClassSpecificationException if the object factoy fail to create the handler
     * @throws XMIConverterConfigurationException if there is error in configuration for addtional handlers
     */
    private static void configHandlers(ObjectFactory of, XMIReader reader,
        String nameSpace)
        throws UnknownNamespaceException, InvalidClassSpecificationException,
            XMIConverterConfigurationException {
        //Read the configuration for AddtionalHandlers
        Property handlersProperty = ConfigManager.getInstance()
                                                 .getPropertyObject(nameSpace,
                ADDTIONALHANDLERS);

        if (handlersProperty != null) {
            Enumeration en = handlersProperty.propertyNames();

            //For each property in AddtionalHandlers
            while (en.hasMoreElements()) {
                String name = (String) en.nextElement();
                Property keyProperty = handlersProperty.getProperty(name);

                //Each handler item should has exaclty one value
                if ((keyProperty.getValue() == null) ||
                        (keyProperty.getValues().length != 1)) {
                    throw new XMIConverterConfigurationException(
                        "Each handler should have exactly one value.");
                }

                //Create the object specified by the key
                Object obj = Helper.createObject(of, keyProperty.getValue());

                //The handler instance should implements XMIHandler interface
                if (!(obj instanceof XMIHandler)) {
                    throw new XMIConverterConfigurationException(
                        "The handler should implements interface XMIHandler.");
                }

                //As character '.' is invalid in ConfigManager, we use '$' instead in the config file
                //Here we should change it back
                reader.addHandler(name.trim().replace('$', '.'),
                    (XMIHandler) obj);
            }
        }
    }

    /**
     * <p>
     * Read the configuration of converters. For each property, the property name is the handler's to
     * add the converter to. The property value is the converter's key in object factory. Using the key,
     * create a converter instance from object factory. Then add the converter to the specified handler.
     * If the handler is not XMIConverterHandler instance, wrap it in XMIConverterHandler first.
     * </p>
     *
     * @param of the object factory used to create converters
     * @param reader the reader to configure
     * @param nameSpace the namespace to read configuration information
     * @throws UnknownNamespaceException if the namespace doesn't exist
     * @throws InvalidClassSpecificationException if the object factory cannot create the object
     * @throws XMIConverterConfigurationException if there is error in configuration for converters
     */
    private static void configConverters(ObjectFactory of, XMIReader reader,
        String nameSpace)
        throws UnknownNamespaceException, InvalidClassSpecificationException,
            XMIConverterConfigurationException {
        //Get the config property object for Converters
        Property convertersProperty = ConfigManager.getInstance()
                                                   .getPropertyObject(nameSpace,
                CONVERTERS);

        if (convertersProperty != null) {
            Enumeration en = convertersProperty.propertyNames();

            while (en.hasMoreElements()) {
                String name = (String) en.nextElement();
                Property keyProperty = convertersProperty.getProperty(name);

                //Each item should have at least one converter
                if (keyProperty.getValue() == null) {
                    throw new XMIConverterConfigurationException(
                        "The config for converters, each pair should have at least one converter.");
                }

                //Each property's value is a key in object factory, create a XMIConverter specified by the key
                for (String key : keyProperty.getValues()) {
                    //Create the object specified by the key
                    Object obj = Helper.createObject(of, key);

                    if (!(obj instanceof XMIConverter)) {
                        throw new XMIConverterConfigurationException(
                            "The converter should implements interface XMIConverter.");
                    }

                    //The character '.' is invalid in ConfigManager, it's replaced by '$' in config file
                    //Here, we change it back
                    XMIHandler handler = reader.getHandler(name.trim()
                                                               .replace('$', '.'));

                    if (handler == null) {
                        throw new XMIConverterConfigurationException(
                            "Could not assign a converter for an unexisted handler: " +
                            name.trim().replace('$', '.'));
                    }

                    //In order to use converter, wrap the handler in XMIConverterHandler first
                    if (!(handler instanceof XMIConverterHandler)) {
                        handler = new XMIConverterHandler(handler, reader);
                    }

                    reader.addHandler(name, handler);

                    //Add converter to the XMIConverterHandler
                    ((XMIConverterHandler) handler).addConverter((XMIConverter) obj);
                }
            }
        }
    }

    /**
     * <p>
     * Adjust the size of the given graph node. It will default to configured empty size,
     * if the graph node has no children , or it will be computed using the size and position
     * of the direct contained graph nodes and the waypoints of the edges(the configured margin).
     * </p>
     *
     * @param graphNode the graph node to adjust size
     * @param emptyWidth the default empty width
     * @param emptyHeight the default empty height
     * @param margin the default margin
     *
     * @throws IllegalArgumentException
     *         if any argument is null or any double argument is negative or Double.NaN
     */
    public static void adjustGraphNodeSize(GraphNode graphNode,
        double emptyWidth, double emptyHeight, double margin) {
        Helper.checkNull(graphNode, "graphNode");
        Helper.checkNegativeAndNaN(emptyWidth, "emptyWidth");
        Helper.checkNegativeAndNaN(emptyHeight, "emptyHeight");
        Helper.checkNegativeAndNaN(margin, "margin");

        double maxWidth = 0;
        double maxHeight = 0;

        List<DiagramElement> elements = graphNode.getContaineds();

        //Calculate the max width and height from GraphNodes
        for (DiagramElement element : elements) {
            if (element instanceof GraphNode) {
                GraphNode node = (GraphNode) element;
                maxWidth = Math.max(maxWidth,
                        node.getPosition().getX() + node.getSize().getWidth());
                maxHeight = Math.max(maxHeight,
                        node.getPosition().getY() + node.getSize().getHeight());
            }
        }

        //Calculate the max width and height from GraphEdges
        for (DiagramElement element : elements) {
            if (element instanceof GraphEdge) {
                GraphEdge edge = (GraphEdge) element;

                for (Point point : edge.getWaypoints()) {
                    maxWidth = Math.max(maxWidth, point.getX());
                    maxHeight = Math.max(maxHeight, point.getY());
                }
            }
        }

        Dimension d = new Dimension();

        //If maxWidth and maxHeigh are 0, using default width and height
        if ((maxWidth == 0) && (maxHeight == 0)) {
            d.setHeight(emptyHeight);
            d.setWidth(emptyWidth);
        } else {
            d.setHeight(maxHeight + margin);
            d.setWidth(maxWidth + margin);
        }

        graphNode.setSize(d);
    }

    /**
     * <p>
     * Replace the keys of properties in the diagramElement and all the contained elements.
     * This method will be executed recursively to replace all the properties keys in the
     * contained elements.
     * </p>
     *
     * <p>
     * The key of toReplacePropertyKeys is the old keys of properties, and the value of
     * this map is the new keys of the properties.
     * </p>
     *
     * <p>
     * If a pair of keys is fill, FILL_COLOR, it will replace the property ('fill',
     * '#0000000') with ('FILL_COLOR', '#0000000'). This is needed because the properties
     * of the graph nodes from the .zuml have the same meaning as those from .tcuml, only
     * different keys or different format for the values.
     * </p>
     *
     *
     * @param diagramElement the diagram element where the properties should be replaced
     * @param toReplacePropertyKeys the oldkey-to-newkey pairs
     * @throws IllegalArgumentException
     *         if any argument is null or toReplacePropertyKeys is empty
     *         or it contains null or empty keys (The value can be null or empty)
     */
    public static void replacePropertyKeys(DiagramElement diagramElement,
        Map<String, String> toReplacePropertyKeys) {
        Helper.checkNull(diagramElement, "diagramElement");
        Helper.checkStringMap(toReplacePropertyKeys, "toReplacePropertyKeys");

        //Replace the properties that is in the map
        for (com.topcoder.diagraminterchange.Property property : diagramElement.getProperties()) {
            if (toReplacePropertyKeys.containsKey(property.getKey())) {
                property.setKey(toReplacePropertyKeys.get(property.getKey()));
            }
        }

        //Do the same thing to the child elements
        if (diagramElement instanceof GraphElement) {
            for (DiagramElement element : ((GraphElement) diagramElement).getContaineds()) {
                replacePropertyKeys(element, toReplacePropertyKeys);
            }
        }
    }

    /**
     * <p>
     * Transform the values of matched properties in the diagramElement and all the contained
     * elements. This method will be executed recursively to transform all the matched properties,
     * values in contained elements.
     * </p>
     *
     * @param diagramElement the diagram element where the properties' values will be transformed
     * @param transformers the property value transformers to transform the value of matched property
     * @throws IllegalArgumentException
     *         if any argument is null or transformers is empty or it contains null element
     */
    public static void transformPropertyValues(DiagramElement diagramElement,
        List<PropertyValueTransformer> transformers) {
        Helper.checkNull(diagramElement, "diagramElement");
        Helper.checkObjectList(transformers, "transformers");

        //Transform each property in the diagram element
        for (com.topcoder.diagraminterchange.Property property : diagramElement.getProperties()) {
            for (PropertyValueTransformer transformer : transformers) {
                if (transformer.match(property.getKey())) {
                    property.setValue(transformer.transform(property.getValue()));
                }
            }
        }

        //Transform its child elements' properties
        if (diagramElement instanceof GraphElement) {
            for (DiagramElement element : ((GraphElement) diagramElement).getContaineds()) {
                transformPropertyValues(element, transformers);
            }
        }
    }

    /**
     * <p>
     * Convert the title node in diagram to a text node. The position and size is not changed.
     * The text will be the displayed text in Poseidon.
     * </p>
     *
     * <p>
     * The zuml's diagrams have a node for diagram's title, The title node is a GraphNode with
     * SimpleSemanticModelElement with typeInfo="NameCompartment"
     * </p>
     * <p>The NameCompartment GraphNode contains</p>
     * <p>- a GraphNode with SimpleSemanticModelElement with typeInfo="DiagramNamePrefix"</p>
     * <p>- a GraphNode with SimpleSemanticModelElement with typeInfo="Name".</p>
     *
     * @param diagram the diagram which the title node should be converted
     * @param properties the properties of the converted text node. can be null, empty or contains null or empty
     * @throws IllegalArgumentException if diagram is null
     */
    public static void convertDiagramTitleToText(Diagram diagram,
        Map<String, String> properties) {
        Helper.checkNull(diagram, "diagram");

        GraphNode titleNode = getFirstTitleNode(diagram);

        if(titleNode != null) {
            SemanticModelBridge model = titleNode.getSemanticModel();

            //The title node's semantic model is instance of SimpleSemanticModelElement
            ((SimpleSemanticModelElement) model).setTypeInfo(TEXT_NODE_VALUE);
            titleNode.clearContaineds();

            if (properties != null) {
                //Add properties to the text node
                for (Entry<String, String> entry : properties.entrySet()) {
                    com.topcoder.diagraminterchange.Property property =
                        new com.topcoder.diagraminterchange.Property();
                    property.setKey(entry.getKey());
                    property.setValue(entry.getValue());
                    titleNode.addProperty(property);
                }
            }

            //Get the diagram the semantic model
            model = diagram.getSemanticModel();

            if (model instanceof SimpleSemanticModelElement) {
                String prefix;
                String name = diagram.getName();

                String typeInfo = ((SimpleSemanticModelElement) model).getTypeInfo();

                prefix = PREFIXMAP.get(typeInfo);

                //Create and add a TextElement to the title node
                TextElement text = new TextElement();
                text.setText(prefix + name);
                titleNode.addContained(text);
            }
        }
    }

    /**
     * <p>
     * Remove the title graph node in the diagram which generated by Poseidon.
     * The zuml's diagrams have a node for diagram's title. The title node is
     * a GraphNode with SimpleSemanticModelElement with typeInfo="NameCompartment".
     * The NameCompartment GraphNode contains
     * <p>- a GraphNode with SimpleSemanticModelElement with typeInfo="DiagramNamePrefix".</p>
     * <p>- a GraphNode with SimpleSemanticModelElement with typeInfo="Name".</p>
     *
     * @param diagram the diagram whose title node should be removed
     * @throws IllegalArgumentException if diagram is null
     */
    public static void removeDiagramTitle(Diagram diagram) {
        Helper.checkNull(diagram, "diagram");

        //Get the first title node of the diagram
        GraphNode titleNode = getFirstTitleNode(diagram);

        if(titleNode != null) {
            diagram.removeContained(titleNode);
        }
    }

    /**
     * <p>
     * Get the first title node of the Diagram. If the title node doesn't exist,
     * null is returned.
     * </p>
     *
     * @param diagram the Diagram to get title node from
     * @return the first title node of the diagram, return null if it doesn't exist
     */
    private static GraphNode getFirstTitleNode(Diagram diagram) {
        GraphNode titleNode = null;

        for (DiagramElement element : diagram.getContaineds()) {
            if (element instanceof GraphNode) {
                SemanticModelBridge model = ((GraphNode) element).getSemanticModel();

                //The title node should have a SimpleSemanticModelElement
                if (model instanceof SimpleSemanticModelElement) {
                    String typeInfo = ((SimpleSemanticModelElement) model).getTypeInfo();

                    //Check the typeInfo
                    if (NAME_COMPARTMENT.equals(typeInfo)) {
                        titleNode = (GraphNode)element;

                        break;
                    }
                }
            }
        }

        return titleNode;
    }
}
