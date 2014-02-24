/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.MockSequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.EmptyArrowEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.Lifeline;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelinePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegmentPropertyType;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

/**
 * <p>
 * Helper class for failure testing.
 * </p>
 *
 * @author FireIce,kaqi072821
 * @version 1.1
 */
class FailureTestHelper {

    /**
     * <p>
     * private constructor preventing instantiation.
     * </p>
     */
    private FailureTestHelper() {
    }

    /**
     * <p>
     * Create an instance of <code>{@link ObjectNode}</code>.
     * </p>
     */
    static ObjectNode createObjectNode() {
        EnumMap<ObjectNodePropertyType, String> propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(
            ObjectNodePropertyType.class);
        propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "red");
        Object object = new ObjectImpl();
        object.setName("name");

        GraphNode graphNode = createGraphNode();

        return new ObjectNode(object, new GraphConnector(), graphNode, new Point(), new Rectangle(),
            createSelectionCorner(), propertyNameMapping);
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
     * Creates a graph edge which contains a stereotype graph node and a name graph node.
     * </p>
     *
     * @return the graph edge
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

        return graphEdge;
    }

    /**
     * <p>
     * This method creates a Point instance defined in Diagram Interchange component.
     * </p>
     *
     * @param x the x-coordinate position of the point
     * @param y the y-coordinate position of the points
     * @return the point instance defined in Diagram Interchange component with the given x and y coordinate value.
     */
    static com.topcoder.diagraminterchange.Point createDiagramInterchangePoint(int x, int y) {
        com.topcoder.diagraminterchange.Point pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(x);
        pt.setY(y);

        return pt;
    }

    /**
     * Creates a list of edges. These edges are used in the failure test.
     *
     * @return a List containing 5 edges.
     */
    static List<SequenceEdge> getEdges() {
        List<SequenceEdge> edges = new ArrayList<SequenceEdge>();
        for (int i = 0; i < 5; ++i) {
            Diagram diagram = new Diagram();
            GraphEdge graphEdge = createGraphEdge();
            graphEdge.addWaypoint(createDiagramInterchangePoint(100, 100));
            graphEdge.addWaypoint(createDiagramInterchangePoint(200, 200));
            graphEdge.addWaypoint(createDiagramInterchangePoint(300, 400));
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
     * Creates a edge-node mapping, which is used in the failure test.
     *
     * @param allEdges the edges which need to create map
     * @return the map for all the edges
     */
    static Map<SequenceEdge, ObjectNode[]> getEdgeNodeMapping(List<SequenceEdge> allEdges) {
        Map<SequenceEdge, ObjectNode[]> mapping = new HashMap<SequenceEdge, ObjectNode[]>();

        for (SequenceEdge edge : allEdges) {
            mapping.put(edge, new ObjectNode[] { createObjectNode(), createObjectNode() });
        }

        return mapping;
    }
}