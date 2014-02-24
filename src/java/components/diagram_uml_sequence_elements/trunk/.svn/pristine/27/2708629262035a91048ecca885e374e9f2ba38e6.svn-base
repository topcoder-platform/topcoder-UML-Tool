/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.EmptyArrowEdgeEnding;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class TestHelper {
    /**
     * <p>
     * The sample configuration file for this component.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files" + File.separator + "config.xml";

    /**
     * <p>
     * The sample configuration file for this component with negative int value.
     * </p>
     */
    public static final String CONFIG_NEGATIVE_FILE = "test_files" + File.separator + "negative_config.xml";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Uses the given file to config the configuration manager.
     * </p>
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadXMLConfig(String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        config.add(file.getCanonicalPath());
    }

    /**
     * <p>
     * Clears all the namespaces from the configuration manager.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }

    /**
     * <p>
     * Creates an <code>EnumMap&lt;ObjectNodePropertyType, String&gt;</code> instance for testing.
     * </p>
     *
     * @return an <code>EnumMap&lt;ObjectNodePropertyType, String&gt;</code> instance for testing.
     */
    public static EnumMap<ObjectNodePropertyType, String> createObjectNodeProperties() {
        EnumMap<ObjectNodePropertyType, String> properties = new EnumMap<ObjectNodePropertyType, String>(
            ObjectNodePropertyType.class);

        properties.put(ObjectNodePropertyType.STROKE_COLOR, "color");
        properties.put(ObjectNodePropertyType.FILL_COLOR, "color");
        properties.put(ObjectNodePropertyType.FILL_COLOR2, "color");
        properties.put(ObjectNodePropertyType.SHADOW_COLOR, "color");
        properties.put(ObjectNodePropertyType.FONT_COLOR, "color");
        properties.put(ObjectNodePropertyType.FONT_FAMILY, "family");
        properties.put(ObjectNodePropertyType.FONT_STYLE, "style");
        properties.put(ObjectNodePropertyType.FONT_SIZE, "size");
        properties.put(ObjectNodePropertyType.WIDTH, "width");
        properties.put(ObjectNodePropertyType.HEIGHT, "height");
        properties.put(ObjectNodePropertyType.ROUNDING_RADIUS, "radius");
        properties.put(ObjectNodePropertyType.SHADOW_LENGTH, "shadow");
        properties.put(ObjectNodePropertyType.MINIMUM_WIDTH, "width");
        properties.put(ObjectNodePropertyType.MINIMUM_HEIGHT, "height");
        properties.put(ObjectNodePropertyType.RENDER_SCHEME, "scheme");

        return properties;
    }

    /**
     * <p>
     * This method creates a <code>Property</code> defined in Diagram Interchange component.
     * </p>
     *
     * @param key the property key
     * @param value the property value
     *
     * @return the property instance
     */
    public static Property createProperty(String key, String value) {
        Property prop = new Property();
        prop.setKey(key);
        prop.setValue(value);

        return prop;
    }

    /**
     * <p>
     * This method creates a <code>GraphNode</code> for testing.
     * </p>
     *
     * @return a <code>GraphNode</code> for testing.
     */
    public static GraphNode createGraphNode() {
        GraphNode node = new GraphNode();

        com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
        pos.setX(100);
        pos.setY(100);

        node.setPosition(pos);

        Dimension size = new Dimension();
        size.setWidth(100);
        size.setHeight(50);

        node.setSize(size);

        node.addProperty(createProperty("color", "#555555"));
        node.addProperty(createProperty("family", "Dialog"));
        node.addProperty(createProperty("style", "1"));
        node.addProperty(createProperty("size", "13"));
        node.addProperty(createProperty("width", "200"));
        node.addProperty(createProperty("height", "200"));
        node.addProperty(createProperty("shadow", "23"));
        node.addProperty(createProperty("radius", "13"));
        node.addProperty(createProperty("scheme", "1"));

        return node;
    }

    /**
     * <p>
     * Creates an <code>EnumMap&lt;ObjectNodePropertyType, String&gt;</code> instance for testing.
     * </p>
     *
     * @return an <code>EnumMap&lt;ObjectNodePropertyType, String&gt;</code> instance for testing.
     */
    public static EnumMap<ObjectNodePropertyType, String> createInvalidObjectNodeProperties() {
        EnumMap<ObjectNodePropertyType, String> properties = new EnumMap<ObjectNodePropertyType, String>(
            ObjectNodePropertyType.class);

        properties.put(ObjectNodePropertyType.STROKE_COLOR, "");
        properties.put(ObjectNodePropertyType.FILL_COLOR, "");
        properties.put(ObjectNodePropertyType.FILL_COLOR2, "");
        properties.put(ObjectNodePropertyType.SHADOW_COLOR, "");
        properties.put(ObjectNodePropertyType.FONT_COLOR, "");
        properties.put(ObjectNodePropertyType.FONT_FAMILY, "");
        properties.put(ObjectNodePropertyType.FONT_STYLE, "");
        properties.put(ObjectNodePropertyType.FONT_SIZE, "");
        properties.put(ObjectNodePropertyType.WIDTH, "");
        properties.put(ObjectNodePropertyType.HEIGHT, "");
        properties.put(ObjectNodePropertyType.ROUNDING_RADIUS, "");
        properties.put(ObjectNodePropertyType.SHADOW_LENGTH, "");
        properties.put(ObjectNodePropertyType.MINIMUM_WIDTH, "");
        properties.put(ObjectNodePropertyType.MINIMUM_HEIGHT, "");
        properties.put(ObjectNodePropertyType.RENDER_SCHEME, "");

        return properties;
    }

    /**
     * <p>
     * Creates an <code>EnumMap&lt;SequenceEdgePropertyType, String&gt;</code> instance for testing.
     * </p>
     *
     * @return an <code>EnumMap&lt;SequenceEdgePropertyType, String&gt;</code> instance for testing.
     */
    public static EnumMap<SequenceEdgePropertyType, String> createSequenceEdgeProperties() {
        EnumMap<SequenceEdgePropertyType, String> properties = new EnumMap<SequenceEdgePropertyType, String>(
            SequenceEdgePropertyType.class);

        properties.put(SequenceEdgePropertyType.STROKE_COLOR, "color");
        properties.put(SequenceEdgePropertyType.FILL_COLOR, "color");
        properties.put(SequenceEdgePropertyType.FILL_COLOR2, "color");
        properties.put(SequenceEdgePropertyType.SHADOW_COLOR, "color");
        properties.put(SequenceEdgePropertyType.FONT_COLOR, "color");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_STROKE_COLOR, "color");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR, "color");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR2, "color");
        properties.put(SequenceEdgePropertyType.FONT_FAMILY, "family");
        properties.put(SequenceEdgePropertyType.FONT_STYLE, "style");
        properties.put(SequenceEdgePropertyType.FONT_SIZE, "size");
        properties.put(SequenceEdgePropertyType.DASH_LENGTH, "length");
        properties.put(SequenceEdgePropertyType.BLANK_LENGTH, "length");
        properties.put(SequenceEdgePropertyType.RENDER_SCHEME, "scheme");

        return properties;
    }


    /**
     * <p>
     * This method fill GraphEdge with properties for testing.
     * </p>
     *
     * @param edge the GraphEdge to fill.
     */
    public static void fillGraphEdgeProperties(GraphEdge edge) {

        edge.clearProperties();
        edge.addProperty(createProperty("color", "#555555"));
        edge.addProperty(createProperty("family", "Dialog"));
        edge.addProperty(createProperty("style", "1"));
        edge.addProperty(createProperty("size", "13"));
        edge.addProperty(createProperty("length", "15"));
        edge.addProperty(createProperty("scheme", "1"));
    }
    /**
     * <p>
     * Creates an <code>EnumMap&lt;SequenceEdgePropertyType, String&gt;</code> instance for testing.
     * </p>
     *
     * @return an <code>EnumMap&lt;SequenceEdgePropertyType, String&gt;</code> instance for testing.
     */
    public static EnumMap<SequenceEdgePropertyType, String> createInvalidSequenceEdgeProperties() {
        EnumMap<SequenceEdgePropertyType, String> properties = new EnumMap<SequenceEdgePropertyType, String>(
            SequenceEdgePropertyType.class);

        properties.put(SequenceEdgePropertyType.STROKE_COLOR, "");
        properties.put(SequenceEdgePropertyType.FILL_COLOR, "");
        properties.put(SequenceEdgePropertyType.FILL_COLOR2, "");
        properties.put(SequenceEdgePropertyType.SHADOW_COLOR, "");
        properties.put(SequenceEdgePropertyType.FONT_COLOR, "");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_STROKE_COLOR, "");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR, "");
        properties.put(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR2, "");
        properties.put(SequenceEdgePropertyType.FONT_FAMILY, "");
        properties.put(SequenceEdgePropertyType.FONT_STYLE, "");
        properties.put(SequenceEdgePropertyType.FONT_SIZE, "");
        properties.put(SequenceEdgePropertyType.DASH_LENGTH, "");
        properties.put(SequenceEdgePropertyType.BLANK_LENGTH, "");
        properties.put(SequenceEdgePropertyType.RENDER_SCHEME, "");

        return properties;
    }

    /**
     * <p>
     * Creates an <code>EnumMap&lt;ConfiguredEdgeEndingPropertyType, String&gt;</code> instance for testing.
     * </p>
     *
     * @return an <code>EnumMap&lt;ConfiguredEdgeEndingPropertyType, String&gt;</code> instance for testing.
     */
    public static EnumMap<ConfiguredEdgeEndingPropertyType, String> createEdgeEndingProperties() {
        EnumMap<ConfiguredEdgeEndingPropertyType, String> properties = new EnumMap<
            ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);

        properties.put(ConfiguredEdgeEndingPropertyType.STROKE_COLOR, "777777");
        properties.put(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "777777");
        properties.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "13");
        properties.put(ConfiguredEdgeEndingPropertyType.ARROW_Y_LENGTH, "13");
        properties.put(ConfiguredEdgeEndingPropertyType.RENDER_SCHEME, "1");

        return properties;
    }

    /**
     * <p>
     * Creates an <code>EnumMap&lt;ConfiguredEdgeEndingPropertyType, String&gt;</code> instance for testing.
     * </p>
     *
     * @return an <code>EnumMap&lt;ConfiguredEdgeEndingPropertyType, String&gt;</code> instance for testing.
     */
    public static EnumMap<ConfiguredEdgeEndingPropertyType, String> createInvalidEdgeEndingProperties() {
        EnumMap<ConfiguredEdgeEndingPropertyType, String> properties = new EnumMap<
            ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);

        properties.put(ConfiguredEdgeEndingPropertyType.STROKE_COLOR, "");
        properties.put(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "");
        properties.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "");
        properties.put(ConfiguredEdgeEndingPropertyType.ARROW_Y_LENGTH, "");
        properties.put(ConfiguredEdgeEndingPropertyType.RENDER_SCHEME, "");

        return properties;
    }

    /**
     * <p>
     * Creates an <code>ObjectNode</code> instance for testing.
     * </p>
     *
     * @return an <code>ObjectNode</code> instance for testing.
     */
    public static ObjectNode createObjectNode() {
        EnumMap<ObjectNodePropertyType, String> propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(
            ObjectNodePropertyType.class);
        propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "333333");
        Collection<SelectionCornerType> corners = createSelectionCorner();
        Rectangle bound = new Rectangle();
        Point position = new Point();
        GraphNode graphNode = new GraphNode();

        com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
        pos.setX(100);
        pos.setY(100);

        graphNode.setPosition(pos);

        Dimension size = new Dimension();
        size.setWidth(100);
        size.setHeight(50);

        graphNode.setSize(size);

        GraphConnector graphConnector = new GraphConnector();
        Object object = new ObjectImpl();

        return new ObjectNode(object, graphConnector, graphNode, position, bound, corners, propertyNameMapping);
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

    /**
     * <p>
     * Creates an <code>SequenceEdge</code> instance for testing.
     * </p>
     *
     * @return an <code>SequenceEdge</code> instance for testing.
     */
    public static SequenceEdge createCorrectSequeceEdge() {

        Diagram diagram = new Diagram();
        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
        diagram.addContained(graphEdge);

        graphEdge.addContained(new GraphNode());
        graphEdge.addContained(new GraphNode());

        EnumMap<ConfiguredEdgeEndingPropertyType, String> mapping = new EnumMap<
            ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);
        mapping.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "value");

        return new MockSequenceEdge(new LinkImpl(), graphEdge, new LineStyle(2, 2), new EmptyArrowEdgeEnding(mapping),
                new EmptyArrowEdgeEnding(mapping), createSequenceEdgeProperties());
    }

    /**
     * <p>
     * This method creates a Point instance defined in Diagram Interchange component.
     * </p>
     *
     * @param x the x-coordinate position of the point
     * @param y the y-coordinate position of the points
     *
     * @return the point instance defined in Diagram Interchange component with the given x and y coordinate value.
     */
    public static com.topcoder.diagraminterchange.Point createDiagramInterchangePoint(int x, int y) {
        com.topcoder.diagraminterchange.Point pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(x);
        pt.setY(y);

        return pt;
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
}
