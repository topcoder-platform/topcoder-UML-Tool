/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.ConfigurationException;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TestHelper;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.Lifeline;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelinePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegmentPropertyType;


/**
 * <p>
 * A Util class to perform those common operations which are helpful for the test on the new class in v1.1.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 */
public class TestUtil {


    /**
     * <p>
     * Create a valid <code>EnumMap<LifelinePropertyType, String></code> instance for tesing use.
     * </p>
     *
     * @return  the <code>EnumMap<LifelinePropertyType, String></code> instance for tesing use
     */
    public static EnumMap<LifelinePropertyType, String> createLifelineProperties() {

          EnumMap<LifelinePropertyType, String> properties = new EnumMap<LifelinePropertyType, String>(
                           LifelinePropertyType.class);

      properties.put(LifelinePropertyType.BLANK_LENGTH, "blanklength");
      properties.put(LifelinePropertyType.DASH_LENGTH, "dashlength");
      properties.put(LifelinePropertyType.LIFELINE_LENGTH, "lifelinelength");
      properties.put(LifelinePropertyType.RENDER_SCHEME, "scheme");
      properties.put(LifelinePropertyType.SHADOW_COLOR, "shadowcolor");
      properties.put(LifelinePropertyType.SHADOW_LENGTH, "shadowlength");
      properties.put(LifelinePropertyType.STROKE_COLOR, "strokecolor");

          return properties;
        }


    /**
     * <p>
     * Create a valid <code>EnumMap<LifelinePropertyType, String></code> instance for tesing use.
     * This instance contains some properties,not all the properties.
     * </p>
     *
     * @return  the <code>EnumMap<LifelinePropertyType, String></code> instance for tesing use
     */
    public static EnumMap<LifelinePropertyType, String> createLifelineWithSomeProperties() {

          EnumMap<LifelinePropertyType, String> properties = new EnumMap<LifelinePropertyType, String>(
                           LifelinePropertyType.class);

      properties.put(LifelinePropertyType.RENDER_SCHEME, "scheme");
      properties.put(LifelinePropertyType.SHADOW_LENGTH, "shadowlength");
      properties.put(LifelinePropertyType.STROKE_COLOR, "strokecolor");

          return properties;
        }



    /**
     * <p>
     * Create a invalid <code>EnumMap<LifelinePropertyType, String></code> instance for tesing use.
     * </p>
     *
     * @return  the <code>EnumMap<LifelinePropertyType, String></code> instance for tesing use.
     */
    public static EnumMap<LifelinePropertyType, String> createInvalidLifelineProperties() {

          EnumMap<LifelinePropertyType, String> properties = new EnumMap<LifelinePropertyType, String>(
                           LifelinePropertyType.class);

       properties.put(LifelinePropertyType.BLANK_LENGTH, "");
       properties.put(LifelinePropertyType.DASH_LENGTH, "");
       properties.put(LifelinePropertyType.LIFELINE_LENGTH, "");
       properties.put(LifelinePropertyType.RENDER_SCHEME, "");
       properties.put(LifelinePropertyType.SHADOW_COLOR, "");
       properties.put(LifelinePropertyType.SHADOW_LENGTH, "");
       properties.put(LifelinePropertyType.STROKE_COLOR, "");

          return properties;
        }



    /**
     * <p>
     * Create an empty property <code>GraphEdge</code> instance.
     * </p>
     *
     *
     * @return the empty property <code>GraphEdge</code> instance for testing use.
     */
    public static GraphEdge createGraphEdge(){
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

        graphEdge.addWaypoint(new Point());
        graphEdge.addWaypoint(new Point());

        return graphEdge;
    }



    /**
     * <p>
     * Create a <code>GraphEdge</code> instance and add the properties for testing use.
     * </p>
     *
     *
     * @return the <code>GraphEdge</code> instance for testing use.
     */
    public static GraphEdge createGraphEdgeWithProperties(){

        GraphEdge graphedge = new GraphEdge();

        graphedge.addWaypoint(new Point());
        graphedge.addWaypoint(new Point());

        graphedge.addProperty(TestHelper.createProperty("blanklength", "8"));
        graphedge.addProperty(TestHelper.createProperty("dashlength","6"));
        graphedge.addProperty(TestHelper.createProperty("lifelinelength","90"));
        graphedge.addProperty(TestHelper.createProperty("scheme","0"));
        graphedge.addProperty(TestHelper.createProperty("shadowcolor","#303030"));
        graphedge.addProperty(TestHelper.createProperty("shadowlength","5"));
        graphedge.addProperty(TestHelper.createProperty("strokecolor","#707070"));
        return graphedge;
    }



    /**
     * <p>
     * Create a <code>GraphNode</code> instance and add the properties for testing use.
     * </p>
     *
     *
     * @return the <code>GraphNode</code> instance for testing use.
     */
    public static GraphNode createGraphNodeWithProperties(){

        GraphNode graphnode = new GraphNode();

        graphnode.addProperty(TestHelper.createProperty("fillcolor", "#101010"));
        graphnode.addProperty(TestHelper.createProperty("shadowcolor","#202020"));
        graphnode.addProperty(TestHelper.createProperty("strokecolor","#707070"));
        graphnode.addProperty(TestHelper.createProperty("height","16"));
        graphnode.addProperty(TestHelper.createProperty("width","8"));
        graphnode.addProperty(TestHelper.createProperty("minimumheight","4"));
        graphnode.addProperty(TestHelper.createProperty("minimumwidth","6"));
        graphnode.addProperty(TestHelper.createProperty("renderscheme","0"));
        graphnode.addProperty(TestHelper.createProperty("shadowlength","4"));

        return graphnode;
    }



    /**
     * <p>
     * Create a valid <code>EnumMap<LifelineSegmentPropertyType, String></code> instance for tesing use.
     * </p>
     *
     * @return  the <code>EnumMap<LifelineSegmentPropertyType, String></code> instance for tesing use
     */
    public static EnumMap<LifelineSegmentPropertyType, String> createLifelineSegmentProperties() {

          EnumMap<LifelineSegmentPropertyType, String> properties = new EnumMap<LifelineSegmentPropertyType, String>(
                          LifelineSegmentPropertyType.class);

      properties.put(LifelineSegmentPropertyType.FILL_COLOR, "fillcolor");
      properties.put(LifelineSegmentPropertyType.HEIGHT, "height");
      properties.put(LifelineSegmentPropertyType.MINIMUM_HEIGHT, "minimumheight");
      properties.put(LifelineSegmentPropertyType.MINIMUM_WIDTH, "minimumwidth");
      properties.put(LifelineSegmentPropertyType.RENDER_SCHEME, "renderscheme");
      properties.put(LifelineSegmentPropertyType.SHADOW_COLOR, "shadowcolor");
      properties.put(LifelineSegmentPropertyType.SHADOW_LENGTH, "shadowlength");
      properties.put(LifelineSegmentPropertyType.STROKE_COLOR, "strokecolor");
      properties.put(LifelineSegmentPropertyType.WIDTH, "width");

          return properties;
        }



    /**
     * <p>
     * Create a valid <code>EnumMap<LifelineSegmentPropertyType, String></code> instance for tesing use.
     * </p>
     *
     * <p>
     * This instance contains some properties,not all the properties.
     * </p>
     *
     * @return  the <code>EnumMap<LifelineSegmentPropertyType, String></code> instance for tesing use
     */
    public static EnumMap<LifelineSegmentPropertyType, String> createLifelineSegmentSomeProperties() {

          EnumMap<LifelineSegmentPropertyType, String> properties = new EnumMap<LifelineSegmentPropertyType, String>(
                          LifelineSegmentPropertyType.class);

      properties.put(LifelineSegmentPropertyType.FILL_COLOR, "fillcolor");
      properties.put(LifelineSegmentPropertyType.MINIMUM_WIDTH, "minimumwidth");
      properties.put(LifelineSegmentPropertyType.WIDTH, "width");

          return properties;
        }



    /**
     * <p>
     * Create a invalid <code>EnumMap<LifelineSegmentPropertyType, String></code> instance for tesing use.
     * </p>
     *
     * @return  the <code>EnumMap<LifelineSegmentPropertyType, String></code> instance for tesing use.
     */
    public static EnumMap<LifelineSegmentPropertyType, String> createInvalidLifelineSegmentProperties() {

          EnumMap<LifelineSegmentPropertyType, String> properties = new EnumMap<LifelineSegmentPropertyType, String>(
                        LifelineSegmentPropertyType.class);

          properties.put(LifelineSegmentPropertyType.FILL_COLOR, "");
      properties.put(LifelineSegmentPropertyType.HEIGHT, "");
      properties.put(LifelineSegmentPropertyType.MINIMUM_HEIGHT, "");
      properties.put(LifelineSegmentPropertyType.MINIMUM_WIDTH, "");
      properties.put(LifelineSegmentPropertyType.RENDER_SCHEME, "");
      properties.put(LifelineSegmentPropertyType.SHADOW_COLOR, "");
      properties.put(LifelineSegmentPropertyType.SHADOW_LENGTH, "");
      properties.put(LifelineSegmentPropertyType.STROKE_COLOR, "");
      properties.put(LifelineSegmentPropertyType.WIDTH, "width");

          return properties;
        }


    /**
     * <p>
     * Create an array of ObjectNode for testing use.
     * </p>
     *
     * @param number the number of the ObjectNodes created in the array.
     *
     * @return the ObjectNode[] created for testing use.
     */
    public static ObjectNode[] createObjectNodes(int number){

        ObjectNode[] objNodes = new ObjectNode[number];
        int x = 10;
        int y = 20;
        for(int i = 0;i < number;++i){
                EnumMap<ObjectNodePropertyType, String> propertyNameMapping = new
                                                  EnumMap<ObjectNodePropertyType, String>(ObjectNodePropertyType.class);

            propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "fillcolor");
            Collection<SelectionCornerType> corners = AccuracyTestHelper.createSelectionCorner();
            Rectangle bound = new Rectangle(x,y,30,20);
            java.awt.Point position = new java.awt.Point(x,y);
            GraphNode graphNode = new GraphNode();

            com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
            pos.setX(100);
            pos.setY(100);
            graphNode.setPosition(pos);
            com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
            size.setWidth(100);
            size.setHeight(50);
            graphNode.setSize(size);

            GraphConnector graphConnector = new GraphConnector();
            com.topcoder.uml.model.commonbehavior.instances.Object object = new ObjectImpl();
            object.setName("name");
            objNodes[i] = new ObjectNode(object, graphConnector, graphNode, position, bound, corners, propertyNameMapping);

            x += 60;

        }
        return objNodes;
    }


    /**
     * <p>
     * Create SequenceEdge List and the edges' association to ObjectNode for test.
     * <p>
     *
     * @param edgeNodeMapping the output association between edge and ObjectNode
     *
     * @return the generated SequenceEdge List
     */
    public static List<SequenceEdge> createSimpleSequnceEdgeAndAssociation
                         (Map<SequenceEdge,ObjectNode[]> edgeNodeMapping){

        List<SequenceEdge> edges = new ArrayList<SequenceEdge>();

        ObjectNode[] objNodes = createObjectNodes(4);

        //work with the first edge,a SynchronousMessageEdge from node 0 to node 1
        SequenceEdge edge = createSynchronousMessageEdge();
        ObjectNode[] nodes = new ObjectNode[2];
        nodes[0] = objNodes[0];
        nodes[1] = objNodes[1];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the second edge,a AsynchronousMessageEdge from node 1 to node 2
        edge = createAsynchronousMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[1];
        nodes[1] = objNodes[2];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the third edge,a SynchronousMessageEdge from node 1 to node 3
        edge = createSynchronousMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[1];
        nodes[1] = objNodes[3];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the 4th edge,a ReturnMessageEdge from node 3 to node 1
        edge = createReturnMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[3];
        nodes[1] = objNodes[1];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the 5th edge,a ReturnMessageEdge from node 3 to node 1
        edge = createReturnMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[1];
        nodes[1] = objNodes[0];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        return edges;
    }



    /**
     * <p>
     * Create SequenceEdge List and the edges' association to ObjectNode for test.
     * <p>
     *
     * <p>
     * This method is used for testing the layoutStrategy that Sequence edge started from a
     * nd ended at the same ObjectNode.
     * </p>
     *
     * @param edgeNodeMapping the output association between edge and ObjectNode
     *
     * @return the generated SequenceEdge List
     */
    public static List<SequenceEdge> createSequnceEdgeAndAssociationSameObjNodes
                         (Map<SequenceEdge,ObjectNode[]> edgeNodeMapping){

        List<SequenceEdge> edges = new ArrayList<SequenceEdge>();

        ObjectNode[] objNodes = createObjectNodes(3);

        //work with the first edge,a AsynchronousMessageEdge from node 0 to node 1
        SequenceEdge edge = createAsynchronousMessageEdge();
        ObjectNode[] nodes = new ObjectNode[2];
        nodes[0] = objNodes[0];
        nodes[1] = objNodes[1];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the second edge,a AsynchronousMessageEdge from node 0 to node 1
        edge = createAsynchronousMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[0];
        nodes[1] = objNodes[1];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the third edge,a CreateMessageEdge from node 0 to node 2
        edge = createCreateMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[0];
        nodes[1] = objNodes[2];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the 4th edge,a SynchronousMessageEdge from node 2 to node 2
        edge = createSynchronousMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[2];
        nodes[1] = objNodes[2];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the 5th edge,a SynchronousMessageEdge from node 2 to node 2
        edge = createSynchronousMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[2];
        nodes[1] = objNodes[2];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the 6th edge,a ReturnMessageEdge from node 2 to node 0
        edge = createReturnMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[2];
        nodes[1] = objNodes[0];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);
        return edges;
    }



    /**
     * <p>
     * Create SequenceEdge List and the edges' association to ObjectNode for test.
     * <p>
     *
     * <p>
     * This method is used for testing the layoutStrategy when the logic in  Sequence edge and
     * ObjectNodes is not correct.It means for some two successive edges,the ended Node of the former
     * edge is not the same as the started Node of the latter.
     * </p>
     *
     * @param edgeNodeMapping the output association between edge and ObjectNode
     *
     * @return the generated SequenceEdge List
     */
    public static List<SequenceEdge> createSequnceEdgeAndAssociationInvalid
                         (Map<SequenceEdge,ObjectNode[]> edgeNodeMapping){

        List<SequenceEdge> edges = new ArrayList<SequenceEdge>();

        ObjectNode[] objNodes = createObjectNodes(4);

        //work with the first edge,a AsynchronousMessageEdge from node 0 to node 2
        SequenceEdge edge = createAsynchronousMessageEdge();
        ObjectNode[] nodes = new ObjectNode[2];
        nodes[0] = objNodes[0];
        nodes[1] = objNodes[2];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the second edge,a AsynchronousMessageEdge from node 1 to node 2
        edge = createAsynchronousMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[1];
        nodes[1] = objNodes[2];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the third edge,a CreateMessageEdge from node 2 to node 3
        edge = createCreateMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[2];
        nodes[1] = objNodes[3];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the 4th edge,a SynchronousMessageEdge from node 3 to node 0
        edge = createSynchronousMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[3];
        nodes[1] = objNodes[0];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the 5th edge,a SynchronousMessageEdge from node 2 to node 2
        edge = createSynchronousMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[2];
        nodes[1] = objNodes[2];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);

        //work with the 6th edge,a ReturnMessageEdge from node 0 to node 0
        edge = createReturnMessageEdge();
        nodes = new ObjectNode[2];
        nodes[0] = objNodes[0];
        nodes[1] = objNodes[0];
        edgeNodeMapping.put(edge, nodes);
        edges.add(edge);
        return edges;
    }



    /**
     * <p>
     * create a SynchronousMessageEdge for test
     * </p>
     *
     * @return SynchronousMessageEdge for test
     */
    public static SynchronousMessageEdge createSynchronousMessageEdge(){

        GraphEdge graphEdge = createGraphEdge();
        return new SynchronousMessageEdge(new LinkImpl(), graphEdge, TestHelper.createEdgeEndingProperties(),
                TestHelper.createSequenceEdgeProperties());
    }


    /**
     * <p>
     * create a AsynchronousMessageEdge for test
     * </p>
     *
     * @return AsynchronousMessageEdge for test
     */
    public static AsynchronousMessageEdge createAsynchronousMessageEdge(){

        GraphEdge graphEdge = createGraphEdge();
        return new AsynchronousMessageEdge(new LinkImpl(), graphEdge, TestHelper.createEdgeEndingProperties(),
                TestHelper.createSequenceEdgeProperties());
    }


    /**
     * <p>
     * create a ReturnMessageEdge for test
     * </p>
     *
     * @return ReturnMessageEdge for test
     */
     public static ReturnMessageEdge createReturnMessageEdge(){

        GraphEdge graphEdge = createGraphEdge();
        return new ReturnMessageEdge(new LinkImpl(), graphEdge, TestHelper.createEdgeEndingProperties(),
                TestHelper.createSequenceEdgeProperties());
    }


     /**
      * <p>
      * create a CreateMessageEdge for test
      * </p>
      *
      * @return CreateMessageEdge for test
      */
      public static CreateMessageEdge createCreateMessageEdge(){

        GraphEdge graphEdge = createGraphEdge();
        return new CreateMessageEdge(new LinkImpl(), graphEdge, TestHelper.createEdgeEndingProperties(),
                 TestHelper.createSequenceEdgeProperties());
     }



      /**
       * <p>
       * Create a LifelineSegment for demo test
       * </p>
       */
      public static LifelineSegment createLifelineSegment(){

        EnumMap<LifelineSegmentPropertyType,String> property = new EnumMap<LifelineSegmentPropertyType,String>(LifelineSegmentPropertyType.class);
        property.put(LifelineSegmentPropertyType.HEIGHT, "height");
        LifelineSegment LS = new LifelineSegment(new GraphNode(),new java.awt.Point(0,0),new Rectangle(0,0,1,1),property);
                return LS;
      }


      /**
       * <p>
       * Create a DiagramViewer for demo test
       * </p>
       */
      public static Lifeline createLifeline(){

        GraphEdge graphedge = TestUtil.createGraphEdge();
        EnumMap<LifelinePropertyType,String> properties = TestUtil.createLifelineWithSomeProperties();

        Lifeline lifeline = new Lifeline(graphedge,properties);
        return lifeline;
      }

      public static DiagramViewer createDV(){
          DiagramViewer dv = null;
                try {
                        dv = new DiagramViewer();
                } catch (ConfigurationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
          return dv;
      }

}
