/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.EdgeLayoutException;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.EdgeLayoutStrategy;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.Util;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegmentPropertyType;

/**
 * <p>
 * The default implementation of EdgeLayoutStrategy.
 * </p>
 * <p>
 * This implementation layouts edges as a chain,here will not be two edges drawn on the same level.
 * </p>
 * <p>
 * Thread-safety: This class is not thread-safe since it's mutable, invoking setEdgeSpace when
 * layout() can cause incorrect result, thread-safe can be achieved by synchronizing all methods.
 * </p>
 * <p>
 * This class needs configuration and here is a sample: &lt;Property
 * name=&quot;LayoutEdgeSpace&quot;&gt; &lt;Value&gt;10&lt;/Value&gt; &lt;/Property&gt;
 * </p>
 *
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 *
 * @since 1.1
 */
public class DefaultEdgeLayoutStrategy implements EdgeLayoutStrategy {
    /**
     * <p>
     * Represents the namespace in the configuration file to use for loading default variables.
     * </p>
     */
    private static final String CONFIG_NAMESPACE = "com.topcoder.gui.diagramviewer.uml."
            + "sequenceelements.edgelayout.defaultedgelayoutstrategy";

    /**
     * <p>
     * Represents the default space between edges.
     * </p>
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     */
    private static final int DEFAULT_EDGE_SPACE = 20;

    /**
     * <p>
     * Represents the name of edgeSpace in the config file.
     * </p>
     */
    private static final String ID_EDGE_SPACE = "LayoutEdgeSpace";


    /**
     * <p>
     * Represents the space between edges.
     * </p>
     * <p>
     * The variable is set in the constructor.
     * </p>
     * <p>
     * This variable is mutable and can be any positive value. Use related setter function to
     * mutate. The related getter function returns the current value of the variable.
     * </p>
     */
    private int edgeSpace;

    /**
     * <p>
     * Create a default instance.load the member variable from ConfManager or from the default.
     * </p>
     *
     */
    public DefaultEdgeLayoutStrategy() {
        Integer value = Util.parseIntegerProperty(CONFIG_NAMESPACE, ID_EDGE_SPACE);

        if (value == null) {
            this.edgeSpace = DEFAULT_EDGE_SPACE;
        } else {
            this.edgeSpace = value;

            if (this.edgeSpace <= 0) {
                this.edgeSpace = DEFAULT_EDGE_SPACE;
            }
        }
    }

    /**
     * <p>
     * Create an instance with the specified edge space.
     * </p>
     *
     * @param edgeSpace space between edges
     * @throws IllegalArgumentException if edgeSpace is 0 or negative.
     */
    public DefaultEdgeLayoutStrategy(int edgeSpace) {

        setEdgeSpace(edgeSpace);
    }

    /**
     * <p>
     * The setter method for the related class variable. See the variable description for the
     * details.
     * </p>
     *
     * @param edgeSpace the edge space
     *
     * @throws IllegalArgumentException if argument is 0 or
     * negative.
     */
    public synchronized void setEdgeSpace(int edgeSpace) {
        Util.checkInt_NegativeOrNil(edgeSpace, "edgeSpace");
        this.edgeSpace = edgeSpace;
    }

    /**
     * <p>
     * Layout the specified edges by setting their properties, returns generated LifelineSegments
     * that are corresponding to the edges.
     * </p>
     *
     * @param edges the edges to layout, can't be null, can't contain null element
     * @param edgeNodeMapping The edgeNodeMapping is used to find associated ObjectNode of each
     * edge.
     * <p>
     * The first elment represents the started node. The second elment represents the ended node
     *
     * @return a list of generated LifelineSegment, never be null but may be empty, never contain
     * null element
     *
     * @throws EdgeLayoutException if any error occurs during layout.
     * @throws IllegalArgumentException edges is null or contain null element,or
     * edgeNodeMapping is null or not under the constraints above.
     */
    public synchronized List<LifelineSegment> layout(List<SequenceEdge> edges,
            Map<SequenceEdge, ObjectNode[]> edgeNodeMapping) throws EdgeLayoutException {
        Util.checkNull(edges, "edges");
        Util.checkNull(edgeNodeMapping, "edgeNodeMapping");

        // Perform initialization
        List<LifelineSegment> lsList = new ArrayList<LifelineSegment>();
        if(edges.size() == 0) {
            return lsList;
        }

        int curY = 0; // current Y position
        LifelineSegment curLS = null;
        Point curPoint = new Point(); // Position of the Current LifelineSegment
        ObjectNode[] objNodes = null;
        ObjectNode parentNode = null;

        // The for loop,work from the first edges to the last edges.
        for (SequenceEdge edge : edges) {
            Util.checkNull(edge, "element in edges");

            // get the edge's associated ObjectNodes
            objNodes = getAssociateObjNodesHelper(edge, edgeNodeMapping);

            // Get the Rectangle bounds of the two objNodes.
            Rectangle curRect = objNodes[0].getSelectionBound();
            Rectangle nextRect = objNodes[1].getSelectionBound();

            if (curLS == null) {
                // Work with the first LifelineSegment

                // Set the position of the current LifelineSegment and curY
                curPoint.x = curRect.x + (curRect.width / 2);
                curPoint.y = curRect.y + curRect.height;
                curY = this.edgeSpace + curPoint.y;

                // Create a LifelineSegment and set the properties from the corresponding ObjectNode
                curLS = createLifelineSegment(getPropertyNameMapping(objNodes[0]),objNodes[0].getGraphNode());
            }

            // work with the edge
            Point leftPos = new Point(curPoint.x + objNodes[0].getX(), curY + objNodes[0].getY());
            Point rightPos = new Point(nextRect.x + objNodes[1].getX() + (nextRect.width / 2), curY + objNodes[1].getY());

            // Set the edge's EndingPoint and do some fix if these two EndingPoint are equal.
            calEdgeEndingHelper(edge, leftPos, rightPos);

            if ((edge instanceof AsynchronousMessageEdge) == false) {
                // Break LifelineSegment curLS,take the width of the segement into consideration.
                Rectangle bounds = new Rectangle(0, 0, curLS.getWidth(), curY - curPoint.y);

                // Set curLS's position and size
                curLS.setSelectionBound(bounds);
                curLS.setLocation(curPoint.x - curLS.getWidth() / 2, curPoint.y);
                curLS.setSize(new java.awt.Dimension(bounds.width + curLS.getShadowLength(), bounds.height + curLS.getShadowLength()));
                parentNode = objNodes[0];
                parentNode.add(curLS);
                parentNode = objNodes[1];
                lsList.add(curLS);
                // Create another LifelineSegment and set the properties from the Edge that starts it
                curLS = createLifelineSegment(getPropertyNameMapping(edge),edge.getGraphEdge());

                // Work with the curPoint
                curPoint.y = curY;
                curPoint.x = nextRect.x + (nextRect.width / 2);
            } else if( parentNode == null) {
                parentNode = objNodes[0];
            }
            //increase the curY by edgeSpace,and if the edge starts and ends at the same object,
            //increase it by edgespace again.sameEdgeSpace's value is either 0 or edgespace.
            curY += this.edgeSpace;
        }

        // end the final lifeline segment,,take the width of the segement into consideration.
        Rectangle bounds = new Rectangle(0, 0, curLS.getWidth(),curY - curPoint.y);
        curLS.setSelectionBound(bounds);
        curLS.setLocation(curPoint.x - curLS.getWidth() / 2, curPoint.y);
        curLS.setSize(new java.awt.Dimension(bounds.width + curLS.getShadowLength(), bounds.height + curLS.getShadowLength()));
        if(parentNode != null) {
            parentNode.add(curLS);
        }
        lsList.add(curLS);

        return lsList;
    }

    /**
     * <p>
     * The getter method for the related class variable. See the variable description for the
     * details.
     * </p>
     *
     * @return the edge space
     */
    public synchronized int getEdgeSpace() {
        return this.edgeSpace;
    }

    /**
     * <p>
     * Create a LifelineSegment instance with properties from the started Object(ObjectNode or SequenceEdge).
     * </p>
     *
     * @param propertyNameMapping the propertyNameMapping used to construct the LifelineSegment
     * @param graphElement of the ObjectNode's GraphNode instance or the SequenceEdge's GraphEdge instance
     *
     * @return a LifelineSegment instance created with properties from the started Object
     */
    private LifelineSegment createLifelineSegment(EnumMap<LifelineSegmentPropertyType, String>
                        propertyNameMapping, GraphElement graphElement) {
        //Get the GraphNode's properties from graphElement
        GraphNode node = new GraphNode();
        for (Property property : graphElement.getProperties()) {
            node.addProperty(property);
        }

        return  new LifelineSegment(node, new Point(0, 0), new Rectangle(0, 0, 1, 1),
                                propertyNameMapping);
    }


    /**
     * <p>
     * Get ObjectNode's name mapping value according to enumValue.
     * </p>
     *
     * @param objNode the ObjectNode instance used to get the value
     * @param enumValue the LifelineSegmentPropertyType used to get the value
     *
     * @return the mapped String value,null if not exists.
     */
    private String getObjectNodeMapValue(ObjectNode objNode, LifelineSegmentPropertyType enumValue){

        try{
            //Get the ObjectNodePropertyType which has the same name with enumValue
            ObjectNodePropertyType key = ObjectNodePropertyType.valueOf(enumValue.name());
            return objNode.getPropertyNameMappingElement(key);
        }catch(IllegalArgumentException e){
            return null;
        }
    }


    /**
     * <p>
     * Get SequenceEdge's name mapping value according to enumValue.
     * </p>
     *
     * @param edge the SequenceEdge instance used to get the value
     * @param enumValue the LifelineSegmentPropertyType used to get the value
     *
     * @return the mapped String value,null if not exists.
     */
    private String getObjectEdgeMapValue(SequenceEdge edge, LifelineSegmentPropertyType enumValue){

        try{
            //Get the ObjectNodePropertyType which has the same name with enumValue
            SequenceEdgePropertyType key = SequenceEdgePropertyType.valueOf(enumValue.name());
            return edge.getPropertyNameMappingElement(key);
        }catch(IllegalArgumentException e){
            return null;
        }
    }


    /**
     * <p>
     * Create LifelineSegment's propertyNameMapping from the properNameMapping of ObjectNode
     * or SequeceEdge.
     * </p>
     *
     * @param obj An instance of ObjectNode or SequeceEdge's sub-class used to retrieve propertyNameMapping
     *
     * @return the created EnumMap<LifelineSegmentPropertyType, String> instance used by LifelineSegment
     */
    private EnumMap<LifelineSegmentPropertyType, String> getPropertyNameMapping(Object obj){

        ObjectNode objNode = null;
        SequenceEdge edge = null;
        String value = null;

        //Set objNode or edge according to the concrete class of obj
        if(obj instanceof ObjectNode){
            objNode = (ObjectNode)obj;
        }else{
            edge = (SequenceEdge)obj;
        }

        //create the EnumMap<LifelineSegmentPropertyType, String> instance
        EnumMap<LifelineSegmentPropertyType, String> propertNameMaping = new
                            EnumMap<LifelineSegmentPropertyType, String>(LifelineSegmentPropertyType.class);

        //enumerate all the values of LifelinePropertyType to fill propertyNameMapping.
        LifelineSegmentPropertyType[] configEdgeEnums = LifelineSegmentPropertyType.values();
        for(int i = 0;i < configEdgeEnums.length;++i){

            if(objNode != null){
                //use ObjectNode's propertyNameMapping
                value = getObjectNodeMapValue(objNode,configEdgeEnums[i]);
            }else{
                //use SequenceEdge's propertyNameMapping
                value = getObjectEdgeMapValue(edge,configEdgeEnums[i]);
            }

            if(value != null){
                propertNameMaping.put(configEdgeEnums[i], value);
            }
        }

        if(propertNameMaping.size() == 0){
            //If after the look-up the LifelineSegmentPropertyType is still empty,add an entry into the map to make
            //sure it will not cause IllegalArgumentException.
            propertNameMaping.put(LifelineSegmentPropertyType.FILL_COLOR, "color");
        }
        return propertNameMaping;
    }


    /**
     * <p>
     * The helper method to set a edge's EndingPoint.
     * </p>
     * <p>
     * If the left and right represent the same position,then two waypoints are added into the
     * edge.And the two Endings are changed to have the same x coordinate,but different y
     * coordinate.
     * </p>
     * <p>
     * This method also sets the wayPoint.
     * </p>
     *
     * @param edge the SequenceEdge to work with
     * @param left the position of LeftEnding
     * @param right the position of rightEnding
     */
    private void calEdgeEndingHelper(SequenceEdge edge, Point left, Point right) {
        /*
         * Note: This method also sets the wayPoint.In v1.0,SequenceEdge is painted using the Edge's
         * wayPoints,not the GraphEdge's.But the wayPoint in Edge can not be modified.This method
         * work with the GraphEdge's wayPoint instead.
         */

//      the increase length of y coordinate
        int increase = 0;

        // work with the 2 waypoints
        GraphEdge graphEdge = edge.getGraphEdge();

        // set the 1st(left) waypoint
        Point oldWayPoint = new Point();
        oldWayPoint.x = (int) graphEdge.getWaypoints().get(0).getX();
        oldWayPoint.y = (int) graphEdge.getWaypoints().get(0).getY();

        com.topcoder.diagraminterchange.Point point;
        if (!oldWayPoint.equals(left)) {
            point = new com.topcoder.diagraminterchange.Point();
            point.setX(left.x);
            point.setY(left.y);
            graphEdge.setWaypoint(0, point);

            edge.notifyChangeWayPoint(0, oldWayPoint);
        }

        int index = graphEdge.getWaypoints().size() - 1;
        oldWayPoint.x = (int) graphEdge.getWaypoints().get(index).getX();
        oldWayPoint.y = (int) graphEdge.getWaypoints().get(index).getY();

        if (!oldWayPoint.equals(right)) {
            point = new com.topcoder.diagraminterchange.Point();
            point.setX(right.x);
            point.setY(right.y);
            graphEdge.setWaypoint(index, point);

            edge.notifyChangeWayPoint(index, oldWayPoint);
        }

        if ((left.x == right.x) && (left.y == right.y)) {
            increase = edgeSpace / 2;
            if (graphEdge.getWaypoints().size() == 2) {
                // add another 2 way points between left and right waypoint
                // add right top point
                point = new com.topcoder.diagraminterchange.Point();
                point.setX(left.x + increase);
                point.setY(left.y);
                graphEdge.addWaypoint(1, point);

                edge.notifyAddWayPoint(1);

                // add right bottom point
                point = new com.topcoder.diagraminterchange.Point();
                point.setX(left.x + increase);
                point.setY(right.y + increase);
                graphEdge.addWaypoint(2, point);

                edge.notifyAddWayPoint(2);
            } else {
                //change right top point
                oldWayPoint.x = (int) graphEdge.getWaypoints().get(1).getX();
                oldWayPoint.y = (int) graphEdge.getWaypoints().get(1).getY();
                if (!oldWayPoint.equals(new Point(left.x + increase, left.y))) {
                    point = new com.topcoder.diagraminterchange.Point();
                    point.setX(left.x + increase);
                    point.setY(left.y);
                    graphEdge.setWaypoint(1, point);

                    edge.notifyChangeWayPoint(1, oldWayPoint);
                }

                // change right top point
                oldWayPoint.x = (int) graphEdge.getWaypoints().get(2).getX();
                oldWayPoint.y = (int) graphEdge.getWaypoints().get(2).getY();
                if (!oldWayPoint.equals(new Point(left.x + increase, right.y + increase))) {
                    point = new com.topcoder.diagraminterchange.Point();
                    point.setX(left.x + increase);
                    point.setY(right.y + increase);
                    graphEdge.setWaypoint(2, point);

                    edge.notifyChangeWayPoint(2, oldWayPoint);
                }
            }
            //change the right waypoint's y coordinate
            point = new com.topcoder.diagraminterchange.Point();
            point.setX(right.x);
            point.setY(right.y + increase);
            graphEdge.setWaypoint(3, point);

            edge.notifyChangeWayPoint(3, right);
        }
    }

    /**
     * <p>
     * The helper method to get the edge's associated parameters.
     * </p>
     *
     * @param edge The instance of SequenceEdge's sub-class which need to get the association.
     * @param edgeNodeMapping The map this method used to lookup.
     *
     * @return the ObjectNode[] associated with the edge
     *
     * @throws IllegalArgumentException when associated ObjectNode[] is not under the constraint
     */
    private ObjectNode[] getAssociateObjNodesHelper(SequenceEdge edge, Map<SequenceEdge,
                ObjectNode[]> edgeNodeMapping) {
        // get the edge's associated ObjectNodes and check
        ObjectNode[] objNodes = edgeNodeMapping.get(edge);
        Util.checkNull(objNodes, "edge's associated ObjectNodes");

        if (objNodes.length != 2) {
            throw new IllegalArgumentException("he size of the associated " + "ObjectNode[] array must exactly be two");
        }

        // check the started ObjectNode
        Util.checkNull(objNodes[0], "associated ObjectNode");
        // check the ended ObjectNode
        Util.checkNull(objNodes[1], "associated ObjectNode");

        return objNodes;
    }
}
