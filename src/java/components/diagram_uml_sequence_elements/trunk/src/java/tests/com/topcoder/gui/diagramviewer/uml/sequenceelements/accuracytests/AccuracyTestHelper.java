/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This class provides helper method for the accuracy tests.
 * </p>
 * <p>
 * This class is made public as the accuracy tests classes are located in different packages.
 * </p>
 *
 * @author ch_music
 * @version 1.0
 */
public final class AccuracyTestHelper {

    /**
     * The namespace for the configuration.
     */
    public static final String NAMESPACE = "com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests";

    /**
     * The config file.
     */
    public static final String CONFIGPATH = "test_files/AccuracyTests.xml";

    /**
     * Private constructor to prevent instantiation.
     */
    private AccuracyTestHelper() {
    }

    /**
     * Loads a configuration in the given file into the given namespace with Configuration Manager.
     *
     * @param namespace the namespace target
     * @param fileName the path of the configuration file
     * @throws Exception if any exception occurs
     */
    public static void loadConfig(String namespace, String fileName) throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();
        File file = new File(fileName);

        if (configManager.existsNamespace(namespace)) {
            configManager.removeNamespace(namespace);
        }

        configManager.add(namespace, file.getCanonicalPath(), ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * Removes all the loaded configuration from Configuration Manager.
     *
     * @param namespace the namespace to be removed from Configuration Manager
     * @throws Exception if any exception occurs
     */
    public static void tearConfig() throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator i = configManager.getAllNamespaces(); i.hasNext();) {
            String namespace = (String) i.next();

            if (configManager.existsNamespace(namespace)) {
                configManager.removeNamespace(namespace);
            }
        }
    }

    /**
     * Creates an ObjectNode instance.
     *
     * @return an ObjectNode instance
     */
    public static ObjectNode createObjectNode() {
        Object object = new ObjectImpl();
        GraphConnector graphConnector = new GraphConnector();
        GraphNode graphNode = new GraphNode();

        com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
        pos.setX(100);
        pos.setY(100);

        graphNode.setPosition(pos);

        Dimension size = new Dimension();
        size.setWidth(100);
        size.setHeight(50);

        graphNode.setSize(size);

        Point position = new Point();
        Rectangle bound = new Rectangle();
        Collection<SelectionCornerType> corners = createSelectionCorner();

        EnumMap<ObjectNodePropertyType, String> propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(
                ObjectNodePropertyType.class);
        propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "FFFFFF");

        return new ObjectNode(object, graphConnector, graphNode, position, bound, corners, propertyNameMapping);
    }

    /**
     * Creates an EnumMap&lt;ObjectNodePropertyType, String&gt; instance for testing.
     *
     * @return an EnumMap&lt;ObjectNodePropertyType, String&gt; instance
     */
    public static EnumMap<ObjectNodePropertyType, String> createObjectNodeProperties() {
        EnumMap<ObjectNodePropertyType, String> properties = new EnumMap<ObjectNodePropertyType, String>(
                ObjectNodePropertyType.class);

        properties.put(ObjectNodePropertyType.STROKE_COLOR, "STROKE_COLOR");
        properties.put(ObjectNodePropertyType.FILL_COLOR, "FILL_COLOR");
        properties.put(ObjectNodePropertyType.FILL_COLOR2, "FILL_COLOR2");
        properties.put(ObjectNodePropertyType.SHADOW_COLOR, "SHADOW_COLOR");
        properties.put(ObjectNodePropertyType.FONT_COLOR, "FONT_COLOR");
        properties.put(ObjectNodePropertyType.WIDTH, "WIDTH");
        properties.put(ObjectNodePropertyType.HEIGHT, "HEIGHT");
        properties.put(ObjectNodePropertyType.ROUNDING_RADIUS, "ROUNDING_RADIUS");
        properties.put(ObjectNodePropertyType.SHADOW_LENGTH, "SHADOW_LENGTH");
        properties.put(ObjectNodePropertyType.FONT_FAMILY, "FONT_FAMILY");
        properties.put(ObjectNodePropertyType.FONT_STYLE, "FONT_STYLE");
        properties.put(ObjectNodePropertyType.FONT_SIZE, "FONT_SIZE");
        properties.put(ObjectNodePropertyType.MINIMUM_WIDTH, "MINIMUM_WIDTH");
        properties.put(ObjectNodePropertyType.MINIMUM_HEIGHT, "MINIMUM_HEIGHT");
        properties.put(ObjectNodePropertyType.RENDER_SCHEME, "RENDER_SCHEME");

        return properties;
    }

    /**
     * <p>
     * Creates an EnumMap&lt;ConfiguredEdgeEndingPropertyType, String&gt; instance.
     * </p>
     *
     * @return an EnumMap&lt;ConfiguredEdgeEndingPropertyType, String&gt; instance
     */
    public static EnumMap<ConfiguredEdgeEndingPropertyType, String> createEdgeEndingProperties() {
        EnumMap<ConfiguredEdgeEndingPropertyType, String> properties = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
                ConfiguredEdgeEndingPropertyType.class);

        properties.put(ConfiguredEdgeEndingPropertyType.STROKE_COLOR, "STROKE_COLOR");
        properties.put(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "FILL_COLOR");
        properties.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "ARROW_X_LENGTH");
        properties.put(ConfiguredEdgeEndingPropertyType.ARROW_Y_LENGTH, "ARROW_Y_LENGTH");
        properties.put(ConfiguredEdgeEndingPropertyType.RENDER_SCHEME, "RENDER_SCHEME");

        return properties;
    }

    /**
     * <p>
     * Creates an EnumMap&lt;SequenceEdgePropertyType, String&gt; instance.
     * </p>
     *
     * @return an EnumMap&lt;SequenceEdgePropertyType, String&gt; instance
     */
    public static EnumMap<SequenceEdgePropertyType, String> createSequenceEdgeProperties() {
        EnumMap<SequenceEdgePropertyType, String> properties = new EnumMap<SequenceEdgePropertyType, String>(
                SequenceEdgePropertyType.class);

        properties.put(SequenceEdgePropertyType.STROKE_COLOR, "STROKE_COLOR");
        properties.put(SequenceEdgePropertyType.FILL_COLOR, "FILL_COLOR");
        properties.put(SequenceEdgePropertyType.FILL_COLOR2, "FILL_COLOR2");
        properties.put(SequenceEdgePropertyType.SHADOW_COLOR, "SHADOW_COLOR");
        properties.put(SequenceEdgePropertyType.DASH_LENGTH, "DASH_LENGTH");
        properties.put(SequenceEdgePropertyType.BLANK_LENGTH, "BLANK_LENGTH");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_STROKE_COLOR, "TEXT_BOX_STROKE_COLOR");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR, "TEXT_BOX_FILL_COLOR");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR2, "TEXT_BOX_FILL_COLOR2");
        properties.put(SequenceEdgePropertyType.FONT_FAMILY, "FONT_FAMILY");
        properties.put(SequenceEdgePropertyType.FONT_STYLE, "FONT_STYLE");
        properties.put(SequenceEdgePropertyType.FONT_SIZE, "FONT_SIZE");
        properties.put(SequenceEdgePropertyType.FONT_COLOR, "FONT_COLOR");
        properties.put(SequenceEdgePropertyType.RENDER_SCHEME, "RENDER_SCHEME");

        return properties;
    }

    /**
     * Creates a Diagram Interchange point.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the point instance defined in Diagram Interchange component
     */
    public static com.topcoder.diagraminterchange.Point createDIPoint(int x, int y) {
        com.topcoder.diagraminterchange.Point point = new com.topcoder.diagraminterchange.Point();
        point.setX(x);
        point.setY(y);

        return point;
    }

    /**
     * <p>
     * Creates a graph edge which contains a stereotype graph node and a name graph node.
     * </p>
     *
     * @return the graph edge
     */
    public static GraphEdge createGraphEdge() {
        GraphEdge graphEdge = new GraphEdge();
        GraphNode stereotype = new GraphNode();
        GraphNode name = new GraphNode();
        graphEdge.addContained(stereotype);
        graphEdge.addContained(name);
        stereotype.setContainer(graphEdge);
        name.setContainer(graphEdge);

        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(new LinkImpl());
        graphEdge.setSemanticModel(semanticModel);

        return graphEdge;
    }

    /**
     * <p>
     * create corner selection for object node
     * </p>
     * @return corner selection
     */
    public static Collection<SelectionCornerType> createSelectionCorner() {
        Collection<SelectionCornerType> corners = new HashSet<SelectionCornerType>();
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.NORTH);
        corners.add(SelectionCornerType.NORTHEAST);
        corners.add(SelectionCornerType.NORTHWEST);
        corners.add(SelectionCornerType.SOUTH);
        corners.add(SelectionCornerType.SOUTHEAST);
        corners.add(SelectionCornerType.SOUTHWEST);
        corners.add(SelectionCornerType.WEST);
        return corners;
    }
}
