/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

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
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.MockXMITransformer;

/**
 * <p>
 * This is a helper TestCase class containing methods to verify attributes and child nodes.
 * All unit tests classes for the Transformers should extend this class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TransformerTestCase extends TestCase {

    /**
     * <p>
     * The DiagramElementTransformer instance used for testing.
     * </p>
     */
    protected DiagramInterchangeElementTransformer transformer;

    /**
     * <p>
     * Map< String, DiagramInterchangeElementTransformer> instance used for testing.
     * </p>
     */
    protected Map < String, DiagramInterchangeElementTransformer > transformers;

    /**
     * <p>
     * Map< String, String> instance used for testing.
     * </p>
     */
    protected Map < String, String > tagNameMaping;

    /**
     * <p>
     * Diagram2XMITransformer instance used for testing.
     * </p>
     */
    protected Diagram2XMITransformer d2XMITransformer;

    /**
     * <p>
     * Map< TransformerType, XMITransformer> used for testing.
     * </p>
     */
    protected Map < TransformerType, XMITransformer > xmiTransformers;

    /**
     * <p>
     * Document instance used for testing.
     * </p>
     */
    protected Document document;

    /**
     * <p>
     * XMIWriter used for testing.
     * </p>
     */
    protected XMIWriter xmiWriter;


    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    protected void setUp() throws Exception {
        transformers = new HashMap < String, DiagramInterchangeElementTransformer >();
        tagNameMaping = new HashMap < String, String >();
        d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMaping);
        xmiTransformers = new HashMap < TransformerType, XMITransformer >();
        xmiTransformers.put(TransformerType.Model,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.ActivityGraph,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.Diagram,  new MockXMITransformer());

        xmiWriter = new XMIWriter(new UMLModelManager(), xmiTransformers);
        d2XMITransformer.setXMIWriter(xmiWriter);
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        transformers = null;
        d2XMITransformer = null;
        document = null;
        xmiTransformers = null;
        xmiWriter = null;
    }

    /**
     * <p>
     * Check whether the (name, value) attribute exists in the node provided.
     * </p>
     *
     * @param node the Node to be check
     * @param name the name of the attribute
     * @param value the value of the attribute
     */
    protected void checkAttribute(Node node, String name, String value) {
        NamedNodeMap map = node.getAttributes();
        // check the attributes exist
        assertNotNull("The node contains no attributes.", map);
        Node attr = map.getNamedItem(name);
        // check the attribute specified by name exists
        assertNotNull("The '" + name + "' attribute doesn't exist.", attr);
        // check the value of the specified attribute
        assertEquals("The value of the attribute should be " + value , value, attr.getNodeValue());
    }

    /**
     * <p>
     * Check whether the (name, value) attribute doesn't exist in the node provided.
     * </p>
     *
     * @param node the Node to be check
     * @param name the name of the attribute
     */
    protected void checkAttributeNotExist(Node node, String name) {
        NamedNodeMap map = node.getAttributes();
        // if attributes doesn't exist, return
        if (map == null) {
            return;
        }
        Node attr = map.getNamedItem(name);
        // check the attribute specified by name is nonexistent
        assertNull("The '" + name + "' attribute should be nonexistent in the node.", attr);
    }

    /**
     * <p>
     * Check the tagName of the node.
     * </p>
     *
     * @param node the Node to be check
     * @param tagName the name of the node to check
     */
    protected void checkTagName(Node node, String tagName) {
        assertEquals("The name of the node should be " + tagName, tagName, node.getNodeName());
    }

    /**
     * <p>
     * Check whether the nodeName of the first child node of the node provided is the same as the tagName provided.
     * </p>
     *
     * @param node the Node to be check
     * @param tagName the tagName to check
     *
     * @return the child node at the specified position
     */
    protected Node checkChildNode(Node node, String tagName) {
        Node childNode = node.getFirstChild();
        // check the attribute at the position exists
        assertNotNull("The first child node doesn't exist.", childNode);
        // check the tagName
        assertEquals("The tagName is incorrect, it should be " + tagName, tagName, childNode.getNodeName());

        return childNode;
    }

    /**
     * <p>
     * Check whether the child node with the tagName provided doesn't exist in the node.
     * </p>
     *
     * @param node the Node to be check
     * @param tagName the tagName to check
     *
     */
    protected void checkChildNodeNotExist(Node node, String tagName) {
        Node fnode = node.getFirstChild();
        // if the first node is null, good, return
        if (fnode == null) {
            return;
        }
        // check the tagName.
        do {
            assertFalse("The child node with the '" + tagName + "' should be nonexistent in this node.",
                   tagName.equals(fnode.getLocalName()));
            fnode = fnode.getNextSibling();
        } while (fnode != null);
    }

    /**
     * <p>
     * Create a Property instance.
     * </p>
     *
     * @return a Property instance
     */
    protected Property createProperty() {
        transformers.put(Property.class.getName(), new PropertyTransformer());
        Property element = new Property();
        element.setKey("propertyKey");
        element.setValue("propertyValue");
        return element;
    }

    /**
     * <p>
     * Create a DiagramElement instance.
     * </p>
     *
     * @return a DiagramElement instance
     */
    protected DiagramElement createDiagramElement() {
        DiagramElement element = createEmptyDiagramElement();
        element.setVisible(false);
        // add the Property instance
        element.addProperty(createProperty());
        // add the Reference instance
        Reference ref = createEmptyReference();
        ref.setReferenced(createEmptyDiagramElement());
        element.addReference(ref);
        return element;
    }

    /**
     * <p>
     * Create a empty instance of DiagramElement.
     * </p>
     *
     * @return a empty instance of DiagramElement
     */
    protected DiagramElement createEmptyDiagramElement() {
        DiagramElement element = new DiagramElement() {
        };
        transformers.put(element.getClass().getName(), new DiagramElementTransformer());
        return element;
    }

    /**
     * <p>
     * Create a Reference instance.
     * </p>
     *
     * @return a Reference instance
     */
    protected Reference createReference() {
        Reference element = createEmptyReference();
        element.setIndividualRepresentation(false);
        element.setReferenced(createEmptyDiagramElement());
        // add elements belong to its super class
        element.addProperty(createProperty());
        element.addProperty(createProperty());
        return element;
    }

    /**
     * <p>
     * Create a empty instance of Reference.
     * </p>
     *
     * @return a empty instance of Reference
     */
    protected Reference createEmptyReference() {
        transformers.put(Reference.class.getName(), new ReferenceTransformer());
        return new Reference();
    }

    /**
     * <p>
     * Create an instance of DiagramLink.
     * </p>
     *
     * @return an instance of DiagramLink
     */
    protected DiagramLink createDiagramLink() {
        DiagramLink element = createEmptyDiagramLink();
        element.setZoom(100.0);
        // set its viewport
        element.setViewport(createEmptyPoint());
        // set its diagram
        element.setDiagram(createEmptyDiagram());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of DiagramLink.
     * </p>
     *
     * @return an empty instance of DiagramLink
     */
    protected DiagramLink createEmptyDiagramLink() {
        transformers.put(DiagramLink.class.getName(), new DiagramLinkTransformer());
        return new DiagramLink();
    }

    /**
     * <p>
     * Create an instance of GraphElement.
     * </p>
     *
     * @return an instance of GraphElement
     */
    protected GraphElement createGraphElement() {
        GraphElement element = createEmptyGraphElement();
        element.setVisible(false);
        // set its position.
        element.setPosition(createPoint());
        // add its anchorages and diagramElement,SemanticModel and the diagramLink
        element.addAnchorage(createEmptyGraphConnector());
        element.addAnchorage(createEmptyGraphConnector());
        element.addContained(createEmptyDiagramElement());
        element.addContained(createEmptyDiagramElement());
        element.setSemanticModel(createEmptySimpleSemanticModelElement());
        element.addLink(createEmptyDiagramLink());
        element.addLink(createEmptyDiagramLink());
        // add elements belong to its super class
        element.addProperty(createProperty());
        element.addReference(createEmptyReference());
        return element;
    }


    /**
     * <p>
     * Create an empty instance of GraphElement.
     * </p>
     *
     * @return an empty instance of GraphElement
     */
    protected GraphElement createEmptyGraphElement() {
        GraphElement element = new GraphElement() {
        };
        transformers.put(element.getClass().getName(), new GraphElementTransformer());
        return element;
    }

    /**
     * <p>
     * Create an instance of GraphElement.
     * </p>
     *
     * @return an instance of GraphElement
     */
    protected GraphNode createGraphNode() {
        GraphNode element =  createEmptyGraphNode();
        element.setVisible(false);
        // set size
        element.setSize(createDimension());
        // add elements belong to its super class
        element.addAnchorage(createEmptyGraphConnector());
        element.addContained(createEmptyDiagramElement());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of GraphNode.
     * </p>
     *
     * @return an empty instance of GraphNode
     */
    protected GraphNode createEmptyGraphNode() {
        transformers.put(GraphNode.class.getName(), new GraphNodeTransformer());
        return new GraphNode();
    }

    /**
     * <p>
     * Create an instance of GraphEdge.
     * </p>
     *
     * @return an instance of GraphEdge
     */
    protected GraphEdge createGraphEdge() {
        GraphEdge element = createEmptyGraphEdge();
        element.setVisible(false);
        // add the waypoint and the anchor
        element.addWaypoint(createPoint());
        element.addAnchor(createEmptyGraphConnector());
        element.addAnchor(createEmptyGraphConnector());
        // add elements belong to its super class
        element.addAnchorage(createEmptyGraphConnector());
        element.addContained(createEmptyDiagramElement());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of GraphEdge.
     * </p>
     *
     * @return an empty instance of GraphEdge
     */
    protected GraphEdge createEmptyGraphEdge() {
        transformers.put(GraphEdge.class.getName(), new GraphEdgeTransformer());
        return new GraphEdge();
    }

    /**
     * <p>
     * Create an instance of GraphConnector.
     * </p>
     *
     * @return an instance of GraphConnector
     */
    protected GraphConnector createGraphConnector() {
        GraphConnector element = createEmptyGraphConnector();
        // set the position and graphEdge
        element.setPosition(createEmptyPoint());
        element.addGraphEdge(createEmptyGraphEdge());
        element.addGraphEdge(createEmptyGraphEdge());

        return element;
    }

    /**
     * <p>
     * Create an empty instance of GraphConnector.
     * </p>
     *
     * @return an empty instance of GraphConnector
     */
    protected GraphConnector createEmptyGraphConnector() {
        transformers.put(GraphConnector.class.getName(), new GraphConnectorTransformer());
        return new GraphConnector();
    }

    /**
     * <p>
     * Create an instance of Diagram.
     * </p>
     *
     * @return an instance of Diagram
     */
    protected Diagram createDiagram() {
        Diagram element = createEmptyDiagram();
        element.setVisible(false);
        element.setName("name");
        element.setZoom(10.0);
        element.setViewport(createPoint());
        element.setOwner(createSemanticModelBridge());
        element.addLink(createEmptyDiagramLink());
        element.addLink(createEmptyDiagramLink());
        // add elements belong to its super class
        element.setSize(createDimension());
        return element;
    }


    /**
     * <p>
     * Create an empty instance of Diagram.
     * </p>
     *
     * @return an empty instance of Diagram
     */
    protected Diagram createEmptyDiagram() {
        transformers.put(Diagram.class.getName(), new DiagramTransformer());
        return new Diagram();
    }

    /**
     * <p>
     * Create an instance of SemanticModelBridge.
     * </p>
     *
     * @return an instance of SemanticModelBridge
     */
    protected SemanticModelBridge createSemanticModelBridge() {
        SemanticModelBridge element = createEmptySemanticModelBridge();
        element.setPresentation("semanticPresentation");
        return element;
    }


    /**
     * <p>
     * Create an empty instance of SemanticModelBridge.
     * </p>
     *
     * @return an empty instance of SemanticModelBridge
     */
    protected SemanticModelBridge createEmptySemanticModelBridge() {
        SimpleSemanticModelElement element = new SimpleSemanticModelElement() {
        };
        transformers.put(element.getClass().getName(), new SemanticModelBridgeTransformer());
        return element;
    }


    /**
     * <p>
     * Create an instance of SimpleSemanticModelElement.
     * </p>
     *
     * @return an instance of SimpleSemanticModelElement
     */
    protected SimpleSemanticModelElement createSimpleSemanticModelElement() {
        SimpleSemanticModelElement element = createEmptySimpleSemanticModelElement();
        element.setPresentation("semanticPresentation");
        /*
         * BugFix: UML-10106
         * Changed to setTypeInfo.
         */
        // old code
//        element.setTypeinfo("simpleTypeInfo");
        element.setTypeInfo("simpleTypeInfo");
        return element;
    }

    /**
     * <p>
     * Create an empty instance of SimpleSemanticModelElement.
     * </p>
     *
     * @return an empty instance of SimpleSemanticModelElement
     */
    protected SimpleSemanticModelElement createEmptySimpleSemanticModelElement() {
        transformers.put(SimpleSemanticModelElement.class.getName(), new SimpleSemanticModelElementTransformer());
        return new SimpleSemanticModelElement();
    }

    /**
     * <p>
     * Create an instance of Uml1SemanticModelBridge.
     * </p>
     *
     * @return an instance of Uml1SemanticModelBridge
     */
    protected Uml1SemanticModelBridge createUml1SemanticModelBridge() {
        Uml1SemanticModelBridge element = createEmptyUml1SemanticModelBridge();
        element.setPresentation("semanticPresentation");
        Element obj = new Element() {
        };
        tagNameMaping.put(obj.getClass().getName(), "UML:SampleElement");
        element.setElement(obj);
        return element;
    }

    /**
     * <p>
     * Create an empty instance of Uml1SemanticModelBridge.
     * </p>
     *
     * @return an empty instance of Uml1SemanticModelBridge
     */
    protected Uml1SemanticModelBridge createEmptyUml1SemanticModelBridge() {
        transformers.put(Uml1SemanticModelBridge.class.getName(), new Uml1SemanticModelBridgeTransformer());
        return new Uml1SemanticModelBridge();
    }

    /**
     * <p>
     * Create an instance of CoreSemanticModelBridge.
     * </p>
     *
     * @return an instance of CoreSemanticModelBridge
     */
    protected CoreSemanticModelBridge createCoreSemanticModelBridge() {
        CoreSemanticModelBridge element = createEmptyCoreSemanticModelBridge();
        element.setPresentation("coreSemanticPresentation");
        return element;
    }

    /**
     * <p>
     * Create an empty instance of CoreSemanticModelBridge.
     * </p>
     *
     * @return an empty instance of CoreSemanticModelBridge
     */
    protected CoreSemanticModelBridge createEmptyCoreSemanticModelBridge() {
        transformers.put(CoreSemanticModelBridge.class.getName(), new CoreSemanticModelBridgeTransformer());
        return new CoreSemanticModelBridge();
    }

    /**
     * <p>
     * Create an instance of LeafElement.
     * </p>
     *
     * @return an instance of LeafElement
     */
    protected LeafElement createLeafElement() {
        LeafElement element = createEmptyLeafElement();
        element.setVisible(false);
        // add elements belong to its super class
        element.addProperty(createProperty());
        element.addReference(createEmptyReference());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of LeafElement.
     * </p>
     *
     * @return an empty instance of LeafElement
     */
    protected LeafElement createEmptyLeafElement() {
        LeafElement element = new LeafElement() {
        };
        transformers.put(element.getClass().getName(), new LeafElementTransformer());
        return element;
    }

    /**
     * <p>
     * Create an instance of Image.
     * </p>
     *
     * @return an instance of Image
     */
    protected Image createImage() {
        Image element = createEmptyImage();
        element.setVisible(false);
        element.setUri("imageURL");
        element.setMimeType("imageMimeType");
        // add elements belong to its super class
        element.addProperty(createProperty());
        element.addReference(createEmptyReference());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of Image.
     * </p>
     *
     * @return an empty instance of Image
     */
    protected Image createEmptyImage() {
        transformers.put(Image.class.getName(), new ImageTransformer());
        return new Image();
    }

    /**
     * <p>
     * Create an instance of TextElement.
     * </p>
     *
     * @return an instance of TextElement
     */
    protected TextElement createTextElement() {
        TextElement element = createEmptyTextElement();
        element.setVisible(false);
        element.setText("textElement");
        // add elements belong to its super class
        element.addProperty(createProperty());
        element.addReference(createEmptyReference());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of TextElement.
     * </p>
     *
     * @return an empty instance of TextElement
     */
    protected TextElement createEmptyTextElement() {
        transformers.put(TextElement.class.getName(), new TextElementTransformer());
        return new TextElement();
    }

    /**
     * <p>
     * Create an instance of Dimension.
     * </p>
     *
     * @return an instance of Dimension
     */
    protected Dimension createDimension() {
        Dimension element = createEmptyDimension();
        element.setHeight(10.0);
        element.setWidth(100.0);
        return element;
    }

    /**
     * <p>
     * Create an empty instance of Dimension.
     * </p>
     *
     * @return an empty instance of Dimension
     */
    protected Dimension createEmptyDimension() {
        transformers.put(Dimension.class.getName(), new DimensionTransformer());
        return new Dimension();
    }

    /**
     * <p>
     * Create an instance of Point.
     * </p>
     *
     * @return an instance of Point
     */
    protected Point createPoint() {
        Point element = createEmptyPoint();
        element.setX(10.0);
        element.setY(100.0);
        return element;
    }

    /**
     * <p>
     * Create an empty instance of Point.
     * </p>
     *
     * @return an empty instance of Point
     */
    protected Point createEmptyPoint() {
        transformers.put(Point.class.getName(), new PointTransformer());
        return new Point();
    }

    /**
     * <p>
     * Create an instance of BezierPoint.
     * </p>
     *
     * @return an instance of BezierPoint
     */
    protected BezierPoint createBezierPoint() {
        BezierPoint element = createEmptyBezierPoint();
        element.setX(10.0);
        element.setY(100.0);
        element.addControl(createEmptyPoint());
        element.addControl(createEmptyPoint());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of BezierPoint.
     * </p>
     *
     * @return an empty instance of BezierPoint
     */
    protected BezierPoint createEmptyBezierPoint() {
        transformers.put(BezierPoint.class.getName(), new BezierPointTransformer());
        return new BezierPoint();
    }

    /**
     * <p>
     * Create an instance of GraphicPrimitive.
     * </p>
     *
     * @return an instance of GraphicPrimitive
     */
    protected GraphicPrimitive createGraphicPrimitive() {
        GraphicPrimitive element = createEmptyGraphicPrimitive();
        element.setVisible(false);
        // add elements belong to its super class
        element.addProperty(createProperty());
        element.addReference(createEmptyReference());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of GraphicPrimitive.
     * </p>
     *
     * @return an empty instance of GraphicPrimitive
     */
    protected GraphicPrimitive createEmptyGraphicPrimitive() {
        GraphicPrimitive element = new GraphicPrimitive() {
        };
        transformers.put(element.getClass().getName(), new GraphicPrimitiveTransformer());
        return element;
    }

    /**
     * <p>
     * Create an instance of Polyline.
     * </p>
     *
     * @return an instance of Polyline
     */
    protected Polyline createPolyline() {
        Polyline element = createEmptyPolyline();
        element.setVisible(false);
        element.setClosed(true);
        element.addWaypoint(createPoint());
        element.addWaypoint(createPoint());
        // add elements belong to its super class
        element.addProperty(createProperty());
        element.addReference(createEmptyReference());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of Polyline.
     * </p>
     *
     * @return an empty instance of Polyline
     */
    protected Polyline createEmptyPolyline() {
        transformers.put(Polyline.class.getName(), new PolylineTransformer());
        return new Polyline();
    }

    /**
     * <p>
     * Create an instance of Ellipse.
     * </p>
     *
     * @return an instance of Ellipse
     */
    protected Ellipse createEllipse() {
        Ellipse element = createEmptyEllipse();
        element.setVisible(false);
        element.setRadiusX(10.0);
        element.setRadiusY(100.0);
        element.setRotation(100.0);
        element.setStartAngle(92.0);
        element.setEndAngle(300.0);
        element.setCenter(createEmptyPoint());
        // ad elements belong to its super class
        element.addProperty(createProperty());
        element.addProperty(createProperty());
        element.addReference(createEmptyReference());
        element.addReference(createEmptyReference());
        return element;
    }

    /**
     * <p>
     * Create an empty instance of Ellipse.
     * </p>
     *
     * @return an empty instance of Ellipse
     */
    protected Ellipse createEmptyEllipse() {
        transformers.put(Ellipse.class.getName(), new EllipseTransformer());
        return new Ellipse();
    }

    /**
     * <p>
     * validate that a Uml1SemanticModelBridge instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateUml1SemanticModelBridge(Node node, Uml1SemanticModelBridge element) throws Exception {
        checkTagName(node, "UML:Uml1SemanticModelBridge");
        validateUml1SemanticModelBridgeForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a Uml1SemanticModelBridge instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateUml1SemanticModelBridgeForChildNode(Node node, Uml1SemanticModelBridge element)
        throws Exception {
        String presentation = element.getPresentation();
        if (presentation != null) {
            checkAttribute(node, "presentation", presentation);
        } else {
            checkAttributeNotExist(node, "presentation");
        }
        Element elt = element.getElement();
        if (elt != null) {
            Node iNode = checkChildNode(node, "UML:Uml1SemanticModelBridge.element");
            checkAttribute(checkChildNode(iNode, "UML:SampleElement"), "xmi.idref",
                    d2XMITransformer.resolveID(elt));
            node.removeChild(iNode);
        }

        // validate from its super class
        validateSemanticModelBridgeForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a SemanticModelBridge instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateSemanticModelBridge(Node node, SemanticModelBridge element) throws Exception {
        checkTagName(node, "UML:SemanticModelBridge");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        validateSemanticModelBridgeForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a SemanticModelBridge instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateSemanticModelBridgeForChildNode(Node node, SemanticModelBridge element)
        throws Exception {
        String presentation = element.getPresentation();
        if (presentation != null) {
            checkAttribute(node, "presentation", presentation);
        } else {
            checkAttributeNotExist(node, "presentation");
        }
    }

    /**
     * <p>
     * validate that a SimpleSemanticModelElement instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateSimpleSemanticModelElement(Node node, SimpleSemanticModelElement element) throws Exception {
        checkTagName(node, "UML:SimpleSemanticModelElement");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        validateSimpleSemanticModelElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a SimpleSemanticModelElement instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateSimpleSemanticModelElementForChildNode(Node node, SimpleSemanticModelElement element)
        throws Exception {
        String presentation = element.getPresentation();
        if (presentation != null) {
            checkAttribute(node, "presentation", presentation);
        } else {
            checkAttributeNotExist(node, "presentation");
        }
        /*
         * BugFix: UML-10106
         * Changed to getTypeInfo.
         */
        // old code
//        String typeinfo = element.getTypeinfo();
        String typeinfo = element.getTypeInfo();
        if (typeinfo != null) {
            checkAttribute(node, "typeInfo", typeinfo);
        } else {
            checkAttributeNotExist(node, "typeInfo");
        }
        // validate from its super class
        validateSemanticModelBridgeForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a CoreSemanticModelBridge instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateCoreSemanticModelBridge(Node node, CoreSemanticModelBridge element) throws Exception {
        checkTagName(node, "UML:CoreSemanticModelBridge");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        validateCoreSemanticModelBridgeForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a CoreSemanticModelBridge instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateCoreSemanticModelBridgeForChildNode(Node node, CoreSemanticModelBridge element)
        throws Exception {
        String presentation = element.getPresentation();
        if (presentation != null) {
            checkAttribute(node, "presentation", presentation);
        } else {
            checkAttributeNotExist(node, "presentation");
        }
        // validate from its super class
        validateSemanticModelBridgeForChildNode(node, element);
    }

    /**
     * <p>
     * validate that an Ellipse instance is consistent with the Node instance .
     * </p>
     * @param node  Node instance to validate
     * @param element Ellipse instance to validate
     * @throws Exception to Junit
     */
    protected void validateEllipse(Node node, Ellipse element) throws Exception {
        checkTagName(node, "UML:Ellipse");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        checkAttribute(node, "radiusX", String.valueOf(element.getRadiusX()));
        checkAttribute(node, "radiusY", String.valueOf(element.getRadiusY()));
        checkAttribute(node, "rotation", String.valueOf(element.getRotation()));
        checkAttribute(node, "startAngle", String.valueOf(element.getStartAngle()));
        checkAttribute(node, "endAngle", String.valueOf(element.getEndAngle()));
        validateEllipseForChildNode(node, element);
    }

    /**
     * <p>
     * validate that an Ellipse instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Ellipse instance to validate
     * @throws Exception to Junit
     */
    protected void validateEllipseForChildNode(Node node, Ellipse element) throws Exception {
        Point center = element.getCenter();
        if (center != null) {
            Node childNode = node.getFirstChild();
            checkTagName(childNode, "UML:Ellipse.center");
            validatePoint(childNode.getFirstChild(), center);
            // remove it.
            node.removeChild(childNode);
        } else {
            checkChildNodeNotExist(node, "UML:Ellipse.center");
        }

        // validate its super class
        validateGraphicPrimitiveForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a Polyline instance is consistent with the Node instance .
     * </p>
     * @param node  Node instance to validate
     * @param element Polyline instance to validate
     * @throws Exception to Junit
     */
    protected void validatePolyline(Node node, Polyline element) throws Exception {
        checkTagName(node, "UML:Polyline");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        checkAttribute(node, "closed", String.valueOf(element.isClosed()));
        validatePolylineForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a Polyline instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Polyline instance to validate
     * @throws Exception to Junit
     */
    protected void validatePolylineForChildNode(Node node, Polyline element) throws Exception {
        // validate the waypoints.
        Collection < Point > pList = element.getWaypoints();
        if (pList.size() > 0) {
            Node iNode = checkChildNode(node, "UML:Polyline.waypoints");
            for (Point point : pList) {
                if (point != null) {
                    Node childNode = iNode.getFirstChild();
                    validatePoint(childNode, point);
                    iNode.removeChild(childNode);
                }
            }
            // remove it
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:Polyline.waypoints");
        }

        // validate its super class
        validateGraphicPrimitiveForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a GraphicPrimitive instance is consistent with the Node instance.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element GraphicPrimitive instance to validate
     * @throws Exception to Junit
     */
    protected void validateGraphicPrimitive(Node node, GraphicPrimitive element) throws Exception {
        checkTagName(node, "UML:GraphicPrimitive");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        validateGraphicPrimitiveForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a GraphicPrimitive instance is consistent with the Node instance for the child nodes.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element GraphicPrimitive instance to validate
     * @throws Exception to Junit
     */
    protected void validateGraphicPrimitiveForChildNode(Node node, GraphicPrimitive element) throws Exception {
        // validate its super class
        validateLeafElementForChildNode(node, element);

    }

    /**
     * <p>
     * validate that a LeafElement instance is consistent with the Node instance.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element LeafElement instance to validate
     * @throws Exception to Junit
     */
    protected void validateLeafElement(Node node, LeafElement element) throws Exception {
        checkTagName(node, "UML:LeafElement");
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        validateLeafElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a LeafElement instance is consistent with the Node instance for the child nodes.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element LeafElement instance to validate
     * @throws Exception to Junit
     */
    protected void validateLeafElementForChildNode(Node node, LeafElement element) throws Exception {
        // validate its super class
        validateDiagramElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that an Image instance is consistent with the Node instance.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element Image instance to validate
     * @throws Exception to Junit
     */
    protected void validateImage(Node node, Image element) throws Exception {
        checkTagName(node, "UML:Image");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        String url = element.getUri();
        if (url != null) {
            checkAttribute(node, "url", url);
        } else {
            checkAttributeNotExist(node, "url");
        }
        String mimeType = element.getMimeType();
        if (mimeType != null) {
            checkAttribute(node, "mimeType", mimeType);
        } else {
            checkAttributeNotExist(node, "mimeType");
        }
        validateImageForChildNode(node, element);
    }

    /**
     * <p>
     * validate that an Image instance is consistent with the Node instance for the child nodes.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element Image instance to validate
     * @throws Exception to Junit
     */
    protected void validateImageForChildNode(Node node, Image element) throws Exception {
        // validate its super class
        validateLeafElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a TextElement instance is consistent with the Node instance.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element TextElement instance to validate
     * @throws Exception to Junit
     */
    protected void validateTextElement(Node node, TextElement element) throws Exception {
        checkTagName(node, "UML:TextElement");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        String text = element.getText();
        if (text != null) {
            checkAttribute(node, "text", text);
        } else {
            checkAttributeNotExist(node, "text");
        }
        validateTextElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a TextElement instance is consistent with the Node instance for the child nodes.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element TextElement instance to validate
     * @throws Exception to Junit
     */
    protected void validateTextElementForChildNode(Node node, TextElement element) throws Exception {
        // validate its super class
        validateLeafElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a DiagramElement instance is consistent with the Node instance.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element DiagramElement instance to validate
     * @throws Exception to Junit
     */
    protected void validateDiagramElement(Node node, DiagramElement element) throws Exception {
        checkTagName(node, "UML:DiagramElement");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        validateDiagramElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a DiagramElement instance is consistent with the Node instance for the child nodes.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element DiagramElement instance to validate
     * @throws Exception to Junit
     */
    protected void validateDiagramElementForChildNode(Node node, DiagramElement element) throws Exception {
        // validate the properties.
        Collection < Property > pList = element.getProperties();
        if (pList.size() > 0) {
            Node iNode = checkChildNode(node, "UML:DiagramElement.property");
            for (Property property : pList) {
                if (property != null) {
                    Node childNode = iNode.getFirstChild();
                    validateProperty(childNode, property);
                    iNode.removeChild(childNode);
                }
            }
            // remove it
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:DiagramElement.property");
        }
        // validate the reference.
        Collection < Reference > rList = element.getReferences();
        if (rList.size() > 0) {
            Node iNode = checkChildNode(node, "UML:DiagramElement.reference");
            for (Reference reference : rList) {
                if (reference != null) {
                    Node childNode = iNode.getFirstChild();
                    validateReference(childNode, reference);
                    iNode.removeChild(childNode);
                }
            }
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:DiagramElement.reference");
        }
    }

    /**
     * <p>
     * validate that a GraphElement instance is consistent with the Node instance.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element GraphElement instance to validate
     * @throws Exception to Junit
     */
    protected void validateGraphElement(Node node, GraphElement element) throws Exception {
        checkTagName(node, "UML:GraphElement");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        validateGraphElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a GraphElement instance is consistent with the Node instance for the child nodes.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element GraphElement instance to validate
     * @throws Exception to Junit
     */
    protected void validateGraphElementForChildNode(Node node, GraphElement element) throws Exception {
        // check position node
        Point point = element.getPosition();
        if (point != null) {
            // if exists, check the point node
            Node childNode = checkChildNode(node, "UML:GraphElement.position");
            validatePoint(childNode.getFirstChild(), point);
            node.removeChild(childNode);
        } else {
            // otherwise, check not exists
            checkChildNodeNotExist(node, "UML:GraphElement.position");
        }

        // validate the anchorages.
        Collection < GraphConnector > gList = element.getAnchorages();
        if (gList.size() > 0) {
            Node iNode = checkChildNode(node, "UML:GraphElement.anchorage");
            for (GraphConnector gConnector : gList) {
                if (gConnector != null) {
                    Node childNode = iNode.getFirstChild();
                    validateGraphConnector(childNode, gConnector);
                    iNode.removeChild(childNode);
                }
            }
            // remove it
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:GraphElement.anchorage");
        }

        // validate the DiagramElement contained.
        Collection < DiagramElement > dList = element.getContaineds();
        if (dList.size() > 0) {
            Node iNode = checkChildNode(node, "UML:GraphElement.contained");
            for (DiagramElement dElement : dList) {
                if (dElement != null) {
                    Node childNode = iNode.getFirstChild();
                    validateDiagramElement(childNode, dElement);
                    iNode.removeChild(childNode);
                }
            }
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:GraphElement.contained");
        }

        // validate the SemanticModelBridge.
        SimpleSemanticModelElement smb = (SimpleSemanticModelElement) element.getSemanticModel();
        if (smb != null) {
            Node iNode = checkChildNode(node, "UML:GraphElement.semanticModel");
            Node childNode = iNode.getFirstChild();
            validateSimpleSemanticModelElement(childNode, smb);
            iNode.removeChild(childNode);
            // remove it
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:GraphElement.semanticModel");
        }

        // validate the DiagramLink.
        Collection < DiagramLink > dkList = element.getLinks();
        if (dkList.size() > 0) {
            Node iNode = checkChildNode(node, "UML:GraphElement.link");
            for (DiagramLink dElement : dkList) {
                if (dElement != null) {
                    Node childNode = iNode.getFirstChild();
                    validateDiagramLink(childNode, dElement);
                    iNode.removeChild(childNode);
                }
            }
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:GraphElement.link");
        }

        // validate from its superclass
        validateDiagramElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a GraphNode instance is consistent with the Node instance.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element GraphNode instance to validate
     * @throws Exception to Junit
     */
    protected void validateGraphNode(Node node, GraphNode element) throws Exception {
        checkTagName(node, "UML:GraphNode");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        validateGraphNodeForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a GraphNode instance is consistent with the Node instance for the child nodes.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element GraphNode instance to validate
     * @throws Exception to Junit
     */
    protected void validateGraphNodeForChildNode(Node node, GraphNode element) throws Exception {
        // check position node
        Dimension size = element.getSize();
        if (size != null) {
            // if exists, check the point node
            Node childNode = checkChildNode(node, "UML:GraphNode.size");
            validateDimension(childNode.getFirstChild(), size);
            node.removeChild(childNode);
        } else {
            // otherwise, check not exists
            checkChildNodeNotExist(node, "UML:GraphNode.size");
        }

        // validate from super class
        validateGraphElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a GraphEdge instance is consistent with the Node instance.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element GraphEdge instance to validate
     * @throws Exception to Junit
     */
    protected void validateGraphEdge(Node node, GraphEdge element) throws Exception {
        checkTagName(node, "UML:GraphEdge");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        validateGraphEdgeForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a GraphEdge instance is consistent with the Node instance for the child nodes.
     * </p>
     *
     * @param node  Node instance to validate
     * @param element GraphEdge instance to validate
     * @throws Exception to Junit
     */
    protected void validateGraphEdgeForChildNode(Node node, GraphEdge element) throws Exception {
        // check waypoints nodes
        Collection < Point > pList = element.getWaypoints();
        if (pList.size() > 0) {
            Node iNode = checkChildNode(node, "UML:GraphEdge.waypoints");
            for (Point dElement : pList) {
                if (dElement != null) {
                    Node childNode = iNode.getFirstChild();
                    validatePoint(childNode, dElement);
                    iNode.removeChild(childNode);
                }
            }
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:GraphEdge.waypoints");
        }

        // validate the anchors.
        Collection < GraphConnector > gList = element.getAnchors();
        if (gList.size() == 0) {
            // if no GraphEdge, check not exists
            checkChildNodeNotExist(node, "UML:GraphEdge.anchor");
        } else {
            Node iNode = checkChildNode(node, "UML:GraphEdge.anchor");
            // otherwise check the GraphEdges.
            for (GraphConnector elt : gList) {
            // check the structure
                Node childNode = checkChildNode(iNode, "UML:GraphConnector");
                checkAttribute(childNode, "xmi.idref", d2XMITransformer.resolveID(elt));
                iNode.removeChild(childNode);
            }
            node.removeChild(iNode);
        }
        // validate from super class
        validateGraphElementForChildNode(node, element);
    }


    /**
     * <p>
     * validate that a GraphConnector instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateGraphConnector(Node node, GraphConnector element) throws Exception {
        checkTagName(node, "UML:GraphConnector");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        validateGraphConnectorForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a GraphConnector instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateGraphConnectorForChildNode(Node node, GraphConnector element) throws Exception {
        // check position node
        Point point = element.getPosition();
        if (point != null) {
            // if exists, check the point node
            Node childNode = checkChildNode(node, "UML:GraphConnector.position");
            validatePoint(childNode.getFirstChild(), point);
            node.removeChild(childNode);
        } else {
            // otherwise, check not exists
            checkChildNodeNotExist(node, "UML:GraphConnector.position");
        }
        // check  the GraphEdge.
        Collection < GraphEdge > eltList = element.getGraphEdges();
        if (eltList.size() == 0) {
            // if no GraphEdge, check not exists
            checkChildNodeNotExist(node, "UML:GraphConnector.graphEdge");
        } else {
            Node iNode = checkChildNode(node, "UML:GraphConnector.graphEdge");
            // otherwise check the GraphEdges.
            for (GraphEdge elt : eltList) {
            // check the structure
                Node childNode = checkChildNode(iNode, "UML:GraphEdge");
                checkAttribute(childNode, "xmi.idref", d2XMITransformer.resolveID(elt));
                iNode.removeChild(childNode);
            }
            node.removeChild(iNode);
        }
        // no check from its super class
    }

    /**
     * <p>
     * validate that a Point instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validatePoint(Node node, Point element) throws Exception {
        checkTagName(node, "UML:Point");
        checkAttribute(node, "x", String.valueOf(element.getX()));
        checkAttribute(node, "y", String.valueOf(element.getY()));
    }

    /**
     * <p>
     * validate that a Point instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validatePointForChildNode(Node node, Point element) throws Exception {
        // no child nodes.
    }

    /**
     * <p>
     * validate that a BezierPoint instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateBezierPoint(Node node, BezierPoint element) throws Exception {
        checkTagName(node, "UML:BezierPoint");
        checkAttribute(node, "x", String.valueOf(element.getX()));
        checkAttribute(node, "y", String.valueOf(element.getY()));
        validateBezierPointForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a BezierPoint instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateBezierPointForChildNode(Node node, BezierPoint element) throws Exception {
        Collection < Point > list = element.getControls();
        if (list.size() == 0) {
            // check the node with UML:BezierPoint.controls should not exist
            checkChildNodeNotExist(node, "UML:BezierPoint.controls");
        } else {
            // otherwise check its children
            Node iNode = node.getFirstChild();
            checkTagName(iNode, "UML:BezierPoint.controls");
            for (Point p : element.getControls()) {
                Node childNode = iNode.getFirstChild();
                validatePointForChildNode(childNode, p);
                iNode.removeChild(childNode);
            }
            node.removeChild(iNode);
        }
        // validate from its super class
        validatePointForChildNode(node, element);

    }

    /**
     * <p>
     * validate that a Property instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateProperty(Node node, Property element) throws Exception {
        checkTagName(node, "UML:Property");
        String key = element.getKey();
        String value = element.getValue();
        if (key != null) {
            checkAttribute(node, "key", key);
        } else {
            checkAttributeNotExist(node, "key");
        }
        if (value != null) {
            checkAttribute(node, "value", value);
        } else {
            checkAttributeNotExist(node, "value");

        }
        validatePropertyForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a Property instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validatePropertyForChildNode(Node node, Property element) throws Exception {
        // no child nodes
    }
    /**
     * <p>
     * validate that a Dimension instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateDimension(Node node, Dimension element) throws Exception {
        checkTagName(node, "UML:Dimension");
        checkAttribute(node, "width", String.valueOf(element.getWidth()));
        checkAttribute(node, "height", String.valueOf(element.getHeight()));
        validateDimensionForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a Dimension instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateDimensionForChildNode(Node node, Dimension element) throws Exception {
        // no child nodes
    }


    /**
     * <p>
     * validate that a Reference instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateReference(Node node, Reference element) throws Exception {
        checkTagName(node, "UML:Reference");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "isIndividualRepresentation", String.valueOf(element.isIndividualRepresentation()));
        validateReferenceForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a Reference instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateReferenceForChildNode(Node node, Reference element) throws Exception {
        // check the referenced diagramElement
        DiagramElement elt = element.getReferenced();
        if (elt == null) {
            checkChildNodeNotExist(node, "UML:DiagramLink.referenced");
        } else {
            // check the structure
            Node iNode = checkChildNode(node, "UML:DiagramLink.referenced");
            checkAttribute(checkChildNode(iNode, "UML:DiagramElement"),
                    "xmi.idref", d2XMITransformer.resolveID(elt));
            node.removeChild(iNode);
        }
        // check from its super class
        validateDiagramElementForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a DiagramLink instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateDiagramLink(Node node, DiagramLink element) throws Exception {
        checkTagName(node, "UML:DiagramLink");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "zoom", String.valueOf(element.getZoom()));
        validateDiagramLinkForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a DiagramLink instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateDiagramLinkForChildNode(Node node, DiagramLink element) throws Exception {
        // check the viewpoint
        Point point = element.getViewport();
        if (point != null) {
            Node iNode = checkChildNode(node, "UML:DiagramLink.viewport");
            validatePoint(iNode.getFirstChild(), point);
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:DiagramLink.viewport");
        }

        Diagram diagram = element.getDiagram();
        if (diagram != null) {
            Node iNode = checkChildNode(node, "UML:DiagramLink.diagram");
            checkAttribute(checkChildNode(iNode, "UML:Diagram"),
                    "xmi.idref", d2XMITransformer.resolveID(diagram));
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:DiagramLink.diagram");
        }
    }

    /**
     * <p>
     * validate that a Diagram instance is consistent with the Node instance.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateDiagram(Node node, Diagram element) throws Exception {
        checkTagName(node, "UML:Diagram");
        checkAttribute(node, "xmi.id", d2XMITransformer.resolveID(element));
        checkAttribute(node, "visible", String.valueOf(element.isVisible()));
        String name = element.getName();
        if (name != null) {
            checkAttribute(node, "name", name);
        } else {
            checkAttributeNotExist(node, "name");
        }
        checkAttribute(node, "zoom", String.valueOf(element.getZoom()));
        validateDiagramForChildNode(node, element);
    }

    /**
     * <p>
     * validate that a Diagram instance is consistent with the Node instance for the child nodes.
     * </p>
     * @param node  Node instance to validate
     * @param element Point instance to validate
     *
     * @throws Exception to Junit
     */
    protected void validateDiagramForChildNode(Node node, Diagram element) throws Exception {
        // check the viewpoint
        Point point = element.getViewport();
        if (point != null) {
            Node iNode = checkChildNode(node, "UML:Diagram.viewport");
            validatePoint(iNode.getFirstChild(), point);
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:Diagram.viewport");
        }

        // check the owner point
        SemanticModelBridge smb = element.getOwner();
        if (smb != null) {
            Node iNode = checkChildNode(node, "UML:Diagram.owner");
            validateSemanticModelBridge(iNode.getFirstChild(), smb);
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:Diagram.owner");
        }

        // check the diagramLink
        Collection < DiagramLink > list = element.getDiagramLinks();
        if (list.size() > 0) {
            Node iNode = checkChildNode(node, "UML:Diagram.diagramLink");
            for (DiagramLink link : element.getDiagramLinks()) {
                // check the structure of the diagramLink
                Node childNode = iNode.getFirstChild();
                checkAttribute(checkChildNode(childNode, "UML:DiagramLink"), "xmi.idref",
                       d2XMITransformer.resolveID(link));
                iNode.removeChild(childNode);
            }
            node.removeChild(iNode);
        } else {
            checkChildNodeNotExist(node, "UML:Diagram.diagramLink");
        }
        // check from its super class
        validateGraphNodeForChildNode(node, element);
    }

}
