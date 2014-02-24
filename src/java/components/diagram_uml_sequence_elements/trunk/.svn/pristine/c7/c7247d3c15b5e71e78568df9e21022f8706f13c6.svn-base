/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.MockSequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.EmptyArrowEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelinePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegmentPropertyType;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This is the helper class for unit tests.
 * </p>
 *
 * @author littleken
 * @version 1.0
 */
final class StressTestsHelper {

    /**
     * <p>
     * The number of times each method will be run.
     * </p>
     */
    public static final int RUN_TIMES = 100;

    /**
     * Private constructor to prevent this class being instantiated.
     */
    private StressTestsHelper() {
        // Does nothing.
    }

    /**
     * Removes all namespaces.
     *
     * @throws Exception
     *             when error occurs
     */
    public static void removeAllNamespaces() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator it = manager.getAllNamespaces(); it.hasNext();) {
            manager.removeNamespace((String) it.next());
        }
    }

    /**
     * loads the configuration file.
     *
     * @param filename
     *            the filename to load the configuration from
     * @throws Exception
     *             when error occurs
     */
    public static void loadConfig(String filename) throws Exception {
        removeAllNamespaces();
        // ConfigManager.getInstance().add("DBConnectionFactoryImpl.xml");
        ConfigManager.getInstance().add(filename);
    }

    /**
     * Get Sequence edge list .
     *
     * @return the required edge list.
     */
    public static List<SequenceEdge> getEdges() {
        List<SequenceEdge> edges = new ArrayList<SequenceEdge>();
        for (int i = 0; i < 5; ++i) {
            Diagram diagram = new Diagram();
            GraphEdge graphEdge = new GraphEdge();
            graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
            graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
            graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
            diagram.addContained(graphEdge);

            EnumMap<SequenceEdgePropertyType, String> propertyNameMapping = new EnumMap<SequenceEdgePropertyType, String>(
                    SequenceEdgePropertyType.class);
            propertyNameMapping.put(SequenceEdgePropertyType.FILL_COLOR, "red");

            EnumMap<ConfiguredEdgeEndingPropertyType, String> mapping = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
                    ConfiguredEdgeEndingPropertyType.class);
            mapping.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "value");

            EmptyArrowEdgeEnding rightEnding = new EmptyArrowEdgeEnding(mapping);
            EmptyArrowEdgeEnding leftEnding = new EmptyArrowEdgeEnding(mapping);
            LineStyle lineStyle = new LineStyle(2, 2);
            Link link = new LinkImpl();

            SequenceEdge edge = new MockSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding,
                    propertyNameMapping);

            edges.add(edge);
        }
        return edges;
    }

    /**
     * <p>
     * Get the Edge Node mapping.
     * </p>
     *
     * @param allEdges
     *            the sequenceEdge to be used.
     * @return the Edge node map.
     */
    public static Map<SequenceEdge, ObjectNode[]> getEdgeNodeMapping(List<SequenceEdge> allEdges) {
        Map<SequenceEdge, ObjectNode[]> mapping = new HashMap<SequenceEdge, ObjectNode[]>();

        for (SequenceEdge edge : allEdges) {
            mapping.put(edge, new ObjectNode[] {TestHelper.createObjectNode(), TestHelper.createObjectNode()});
        }

        return mapping;

    }

    /**
     * <p>
     * This method creates a lifeline segment property name map for testing
     * lifeline.
     * </p>
     *
     * @return a lifeline segment propety name map.
     */
    public static EnumMap<LifelineSegmentPropertyType, String> createLifelineSegmentPropertyNameMapping() {
        EnumMap<LifelineSegmentPropertyType, String> propertyNameMapping = new EnumMap<LifelineSegmentPropertyType, String>(
                LifelineSegmentPropertyType.class);
        propertyNameMapping.put(LifelineSegmentPropertyType.WIDTH, "WIDTH");
        propertyNameMapping.put(LifelineSegmentPropertyType.HEIGHT, "HEIGHT");
        propertyNameMapping.put(LifelineSegmentPropertyType.MINIMUM_WIDTH, "MINIMUM_WIDTH");
        propertyNameMapping.put(LifelineSegmentPropertyType.MINIMUM_HEIGHT, "MINIMUM_HEIGHT");
        propertyNameMapping.put(LifelineSegmentPropertyType.SHADOW_LENGTH, "SHADOW_LENGTH");
        propertyNameMapping.put(LifelineSegmentPropertyType.STROKE_COLOR, "STROKE_COLOR");
        propertyNameMapping.put(LifelineSegmentPropertyType.SHADOW_COLOR, "SHADOW_COLOR");
        propertyNameMapping.put(LifelineSegmentPropertyType.FILL_COLOR, "FILL_COLOR");
        propertyNameMapping.put(LifelineSegmentPropertyType.RENDER_SCHEME, "RENDER_SCHEME");
        return propertyNameMapping;
    }

    /**
     * <p>
     * This method creates a <code>GraphEdge</code> for testing.
     * </p>
     *
     * @return a <code>GraphEdge</code> for testing.
     */
    static GraphEdge createGraphEdge() {
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
        graphEdge.addWaypoint(createInterchangePoint(100, 100));
        graphEdge.addWaypoint(createInterchangePoint(100, 200));
        return graphEdge;
    }

    /**
     * <p>
     * This method creates a lifeline property name map for testing lifeline.
     * </p>
     *
     * @return a lifeline propety name map.
     */
    public static EnumMap<LifelinePropertyType, String> createLifelinePropertyNameMapping() {
        EnumMap<LifelinePropertyType, String> propertyNameMapping = new EnumMap<LifelinePropertyType, String>(
                LifelinePropertyType.class);
        propertyNameMapping.put(LifelinePropertyType.DASH_LENGTH, "DASH_LENGTH");
        propertyNameMapping.put(LifelinePropertyType.BLANK_LENGTH, "BLANK_LENGTH");
        propertyNameMapping.put(LifelinePropertyType.SHADOW_LENGTH, "SHADOW_LENGTH");
        propertyNameMapping.put(LifelinePropertyType.LIFELINE_LENGTH, "LIFELINE_LENGTH");
        propertyNameMapping.put(LifelinePropertyType.STROKE_COLOR, "STROKE_COLOR");
        propertyNameMapping.put(LifelinePropertyType.SHADOW_COLOR, "SHADOW_COLOR");
        propertyNameMapping.put(LifelinePropertyType.RENDER_SCHEME, "RENDER_SCHEME");
        return propertyNameMapping;
    }

    /**
     * <p>
     * Creates a graph node for object node.
     * </p>
     * @return the created graph node
     */
    static GraphNode createGraphNode() {
        GraphNode graphNode = new GraphNode();

        com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
        pos.setX(100);
        pos.setY(100);

        graphNode.setPosition(pos);

        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setWidth(100);
        size.setHeight(50);

        graphNode.setSize(size);
        return graphNode;
    }

    /**
     * <p>
     * create corner selection for object node
     * </p>
     * @return corner selection
     */
    static Collection<SelectionCornerType> createSelectionCorner() {
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
     * This method creates a <code>com.topcoder.diagraminterchange.Point</code>
     * for testing.
     * </p>
     *
     * @param x
     *            x position in point
     * @param y
     *            y position in point
     * @return the a <code>com.topcoder.diagraminterchange.Point</code> for
     *         testing.
     */
    private static com.topcoder.diagraminterchange.Point createInterchangePoint(int x, int y) {
        com.topcoder.diagraminterchange.Point point = new com.topcoder.diagraminterchange.Point();
        point.setX(x);
        point.setY(y);
        return point;
    }

}