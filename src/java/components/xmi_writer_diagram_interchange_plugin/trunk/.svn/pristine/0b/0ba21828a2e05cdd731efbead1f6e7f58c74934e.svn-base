/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.BezierPoint;
import com.topcoder.diagraminterchange.CoreSemanticModelBridge;
import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.GraphicPrimitive;
import com.topcoder.diagraminterchange.Image;
import com.topcoder.diagraminterchange.LeafElement;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.BezierPointTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.CoreSemanticModelBridgeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramLinkTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DimensionTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.EllipseTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphConnectorTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphEdgeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphNodeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphicPrimitiveTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ImageTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.LeafElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PointTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PolylineTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ReferenceTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.SemanticModelBridgeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.SimpleSemanticModelElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.TextElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.Uml1SemanticModelBridgeTransformer;

/**
 * This class is a helper class for accuracy test.
 *
 * @author Chenhong
 * @version 1.0
 */
final class Util {

	/**
     * Private constructor.
     */
	private Util() {
		// Empty.
	}

	/**
     * Create a tag name mapping.
     *
     * @return a Map containing all tag name.
     */
	public static Map createTagNameMapping() {
		Map tagNameMapping = new HashMap();
		tagNameMapping.put(BezierPoint.class.getName(), "UML:BezierPoint");
		tagNameMapping.put(CoreSemanticModelBridge.class.getName(), "UML:CoreSemanticModelBridge");
		tagNameMapping.put(DiagramElement.class.getName(), "UML:DiagramElement");
		tagNameMapping.put(DiagramLink.class.getName(), "UML:DiagramLink");
		tagNameMapping.put(Diagram.class.getName(), "UML:Diagram");
		tagNameMapping.put(Dimension.class.getName(), "UML:Dimension");
		tagNameMapping.put(Ellipse.class.getName(), "UML:Ellipse");
		tagNameMapping.put(GraphConnector.class.getName(), "UML:GraphConnector");
		tagNameMapping.put(GraphEdge.class.getName(), "UML:GraphEdge");
		tagNameMapping.put(GraphElement.class.getName(), "UML:GraphElement");
		tagNameMapping.put(GraphicPrimitive.class.getName(), "UML:GraphicPrimitive");
		tagNameMapping.put(GraphNode.class.getName(), "UML:GraphNode");
		tagNameMapping.put(Image.class.getName(), "UML:Image");
		tagNameMapping.put(LeafElement.class.getName(), "UML:LeafElement");
		tagNameMapping.put(Point.class.getName(), "UML:Point");
		tagNameMapping.put(Polyline.class.getName(), "UML:Polyline");
		tagNameMapping.put(Property.class.getName(), "UML:Property");
		tagNameMapping.put(Reference.class.getName(), "UML:Reference");
		tagNameMapping.put(SemanticModelBridge.class.getName(), "UML:SemanticModelBridge");
		tagNameMapping.put(SimpleSemanticModelElement.class.getName(), "UML:SimpleSemanticModelElement");
		tagNameMapping.put(TextElement.class.getName(), "UML:TextElement");
		tagNameMapping.put(Uml1SemanticModelBridge.class.getName(), "UML:Uml1SemanticModelBridge");
		tagNameMapping.put(LinkImpl.class.getName(), "UML:LinkImpl");
		tagNameMapping.put(ModelImpl.class.getName(), "UML:ModelIImpl");

		return tagNameMapping;
	}

	/**
     * Create a trans map.
     */
	public static Map createTransMap() {
		Map transMap = new HashMap();
		transMap.put(BezierPoint.class.getName(), new BezierPointTransformer());
		transMap.put(CoreSemanticModelBridge.class.getName(), new CoreSemanticModelBridgeTransformer());
		transMap.put(DiagramElement.class.getName(), new DiagramElementTransformer());
		transMap.put(DiagramLink.class.getName(), new DiagramLinkTransformer());
		transMap.put(Diagram.class.getName(), new DiagramTransformer());
		transMap.put(Dimension.class.getName(), new DimensionTransformer());
		transMap.put(Ellipse.class.getName(), new EllipseTransformer());
		transMap.put(GraphConnector.class.getName(), new GraphConnectorTransformer());
		transMap.put(GraphEdge.class.getName(), new GraphEdgeTransformer());
		transMap.put(GraphElement.class.getName(), new GraphElementTransformer());
		transMap.put(GraphicPrimitive.class.getName(), new GraphicPrimitiveTransformer());
		transMap.put(GraphNode.class.getName(), new GraphNodeTransformer());
		transMap.put(Image.class.getName(), new ImageTransformer());
		transMap.put(LeafElement.class.getName(), new LeafElementTransformer());
		transMap.put(Point.class.getName(), new PointTransformer());
		transMap.put(Polyline.class.getName(), new PolylineTransformer());
		transMap.put(Property.class.getName(), new PropertyTransformer());
		transMap.put(Reference.class.getName(), new ReferenceTransformer());
		transMap.put(SemanticModelBridge.class.getName(), new SemanticModelBridgeTransformer());
		transMap.put(SimpleSemanticModelElement.class.getName(), new SimpleSemanticModelElementTransformer());
		transMap.put(TextElement.class.getName(), new TextElementTransformer());
		transMap.put(Uml1SemanticModelBridge.class.getName(), new Uml1SemanticModelBridgeTransformer());

		return transMap;

	}

	/**
     * Create a Diagram2XMITransformer instance for testing.
     *
     * @return Diagram2XMITransformer instance.
     *
     * @throws Exception
     *             to junit.
     */
	public static Diagram2XMITransformer createDiagram2XMITransformer() throws Exception {
		return new Diagram2XMITransformer(createTransMap(), createTagNameMapping());
	}
}