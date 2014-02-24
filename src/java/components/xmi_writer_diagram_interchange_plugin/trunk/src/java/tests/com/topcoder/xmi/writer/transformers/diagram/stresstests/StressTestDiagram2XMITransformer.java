package com.topcoder.xmi.writer.transformers.diagram.stresstests;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

import junit.framework.TestCase;

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
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
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
import com.topcoder.xmi.writer.transformers.xmiheader.XMIHeaderTransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;


/**
 * Stress tests for the Diagram2XMITransformer class.
 *
 * @author slion
 * @version 1.0
 *
 */
public class StressTestDiagram2XMITransformer extends TestCase {
    /**
     * Represents the scale of processing the operation.
     */
    private static final int TOTAL_ITERATION = 10000;
    
    /**
     * Represents the Diagram2XMITransformer instance.
     */
    private Diagram2XMITransformer transformer = null;
    
    /**
     * Represents the elements to be transformed.
     */
    private static final Object[] ELEMENTS =
        new Object[]{new BezierPoint(), new CoreSemanticModelBridge(), new Diagram(),
            new DiagramLink(), new Dimension(), new Ellipse(),
            new GraphConnector(), new GraphEdge(),
            new GraphNode(), new Image(), new Point(), new Polyline(),
            new Property(), new Reference(), new SimpleSemanticModelElement(),
            new TextElement(), new Uml1SemanticModelBridge()};
    /**
     * Setup the test environment.
     */
    protected void setUp() throws Exception {
        transformer = new Diagram2XMITransformer(createTransformers(), createTagNameMappings(),
                createXMLTransformer(), false);
        transformer.setXMIWriter(createXMIWriter());
    }

    /**
     * Teardown the test environment.
     */
    protected void tearDown() throws Exception {
        transformer = null;
    }

    /**
     * Benchmark the 1st Constructor.
     * @throws TransformerConfigurationException to JUnit.
     *
     */
    public void testCtor1() throws TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            transformer = new Diagram2XMITransformer(createTransformers(), createTagNameMappings());
            assertNotNull("Fail to create Diagram2XMITransformer instance.", transformer);
        }
        System.out.println("Creating " + TOTAL_ITERATION
                + " Diagram2XMITransformer instances" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the 2nd Constructor.
     * @throws TransformerConfigurationException to JUnit.
     *
     */
    public void testCtor2() throws TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            transformer = new Diagram2XMITransformer(createTransformers(), createTagNameMappings(),
                    createXMLTransformer(), false);
            assertNotNull("Fail to create Diagram2XMITransformer instance.", transformer);
        }
        System.out.println("Creating " + TOTAL_ITERATION
                + " Diagram2XMITransformer instances" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the transform(Object, PrintStream) method.
     * @throws FileNotFoundException to JUnit.
     * @throws XMITransformException to JUnit.
     * @throws UnknownElementException to JUnit.
     */
    public void testTransformObjectPrintStream() throws UnknownElementException,
    XMITransformException, FileNotFoundException {
        // set up some elements to be transformed
        Diagram diagram = new Diagram();
        diagram.setName("Main Class Diagram");
        diagram.setPosition(createPoint(0.0, 0.0));
        diagram.setSize(createDimension(250.0, 250.0));
        diagram.setViewport(createPoint(0.0, 0.0));
        diagram.setZoom(0.9);

        // make a text box to put in there, with Node container
        TextElement txt = new TextElement();
        txt.setText("Title");
        GraphNode holder = new GraphNode();
        holder.addContained(txt);
        holder.setPosition(createPoint(120.0, 30.0));
        holder.setSize(createDimension(40.0, 25.0));
        holder.addProperty(createProperty("font-size", "20.0"));
        diagram.addContained(holder); // add to diagram

        // make an ellipse
        Ellipse els = new Ellipse();
        els.setRadiusX(22.0);
        els.setRadiusY(22.0);
        els.setRotation(0.0);
        els.setStartAngle(0.0);
        els.setEndAngle(6.283185307179586); // 2 pi
        els.setVisible(false);
        els.setCenter(createPoint(200.0, 30.0));
        els.addProperty(createProperty("fill", "#0000ff"));
        diagram.addContained(els); // add to diagram
        
        Image image = new Image();
        image.addProperty(createProperty("width", "100"));
        image.addProperty(createProperty("height", "100"));
        diagram.addContained(image);
        
        Reference ref = new Reference();
        ref.setReferenced(image);
        diagram.addReference(ref);
        
        DiagramLink link = new DiagramLink();
        link.setDiagram(diagram);
        link.setGraphElement(holder);
        link.setViewport(createPoint(10, 10));
        link.setZoom(1);
        diagram.addDiagramLink(link);
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            transformer.transform(diagram, new PrintStream("test_files/stress/output.xmi"));
        }

        System.out.println("Transforming " + TOTAL_ITERATION
                + " diagrams in stream" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the transform(Object, Document) method.
     * @throws ParserConfigurationException to JUnit.
     * @throws XMITransformException to JUnit.
     * @throws UnknownElementException to JUnit.
     */
    public void testTransformObjectDocument() throws UnknownElementException, XMITransformException, ParserConfigurationException {
//      set up some elements to be transformed
        Diagram diagram = new Diagram();
        diagram.setName("Main Class Diagram");
        diagram.setPosition(createPoint(0.0, 0.0));
        diagram.setSize(createDimension(250.0, 250.0));
        diagram.setViewport(createPoint(0.0, 0.0));
        diagram.setZoom(0.9);

        // make a text box to put in there, with Node container
        TextElement txt = new TextElement();
        txt.setText("Title");
        GraphNode holder = new GraphNode();
        holder.addContained(txt);
        holder.setPosition(createPoint(120.0, 30.0));
        holder.setSize(createDimension(40.0, 25.0));
        holder.addProperty(createProperty("font-size", "20.0"));
        diagram.addContained(holder); // add to diagram

        // make an ellipse
        Ellipse els = new Ellipse();
        els.setRadiusX(22.0);
        els.setRadiusY(22.0);
        els.setRotation(0.0);
        els.setStartAngle(0.0);
        els.setEndAngle(6.283185307179586); // 2 pi
        els.setVisible(false);
        els.setCenter(createPoint(200.0, 30.0));
        els.addProperty(createProperty("fill", "#0000ff"));
        diagram.addContained(els); // add to diagram
        
        Image image = new Image();
        image.addProperty(createProperty("width", "100"));
        image.addProperty(createProperty("height", "100"));
        diagram.addContained(image);
        
        Reference ref = new Reference();
        ref.setReferenced(image);
        diagram.addReference(ref);
        
        DiagramLink link = new DiagramLink();
        link.setDiagram(diagram);
        link.setGraphElement(holder);
        link.setViewport(createPoint(10, 10));
        link.setZoom(1);
        diagram.addDiagramLink(link);
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            transformer.transform(diagram,
                    DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        }

        System.out.println("Transforming " + TOTAL_ITERATION
                + " diagrams in document" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the resolveID(Object) method.
     * @throws XMITransformException to JUnit.
     */
    public void testResolveID() throws XMITransformException {
        long start = System.currentTimeMillis();
        for (Object element : ELEMENTS) {
            for (int i = 0; i < TOTAL_ITERATION; i++) {
                transformer.resolveID(element);
            }
        }

        System.out.println("Calling " + TOTAL_ITERATION
                + " times resolveID(object) " + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getXMLTransformer() method.
     * @throws TransformerConfigurationException to JUnit.
     */
    public void testGetXMLTransformer() throws TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertNotNull(transformer.getXMLTransformer());
        }
        System.out.println("Getting " + TOTAL_ITERATION
                + " XMLTransformers using getXMLTransformer()" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer1() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertNull(transformer.getElementTransformer("unknown"));
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with null return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer2() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Dimension")
                    instanceof DimensionTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with DimensionTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer3() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Diagram")
                    instanceof DiagramTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with DiagramTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer4() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.BezierPoint")
                    instanceof BezierPointTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with BezierPointTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer5() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.CoreSemanticModelBridge")
                    instanceof CoreSemanticModelBridgeTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with CoreSemanticModelBridgeTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer6() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.DiagramElement")
                    instanceof DiagramElementTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with DiagramElementTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer7() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.DiagramLink")
                    instanceof DiagramLinkTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with DiagramLinkTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer8() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Ellipse")
                    instanceof EllipseTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with EllipseTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer9() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.GraphConnector")
                    instanceof GraphConnectorTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with GraphConnectorTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer10() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.GraphEdge")
                    instanceof GraphEdgeTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with GraphEdgeTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer11() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.GraphElement")
                    instanceof GraphElementTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with GraphElementTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer12() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.GraphicPrimitive")
                    instanceof GraphicPrimitiveTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with GraphicPrimitiveTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer13() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.GraphNode")
                    instanceof GraphNodeTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with GraphNodeTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer14() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Image")
                    instanceof ImageTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with ImageTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer15() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.LeafElement")
                    instanceof LeafElementTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with LeafElementTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer16() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Point")
                    instanceof PointTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with PointTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer17() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Polyline")
                    instanceof PolylineTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with PolylineTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer18() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Property")
                    instanceof PropertyTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with PropertyTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer19() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Reference")
                    instanceof ReferenceTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with ReferenceTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer20() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.SemanticModelBridge")
                    instanceof SemanticModelBridgeTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with SemanticModelBridgeTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer21() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.SimpleSemanticModelElement")
                    instanceof SimpleSemanticModelElementTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with SimpleSemanticModelElementTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer22() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.TextElement")
                    instanceof TextElementTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with TextElementTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getElementTransformer(String) method.
     * @throws TransformerConfigurationException to JUnit.
     * @throws UnknownElementException to JUNit.
     */
    public void testGetElementTransformer23() throws UnknownElementException, TransformerConfigurationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(transformer.getElementTransformer("com.topcoder.diagraminterchange.Uml1SemanticModelBridge")
                    instanceof Uml1SemanticModelBridgeTransformer);
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformer(String) with Uml1SemanticModelBridgeTransformer return" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getElementTransformers() method.
     */
    public void testGetElementTransformers() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertEquals(transformer.getElementTransformers().size(), createTransformers().size());
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getElementTransformers()" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Benchmark the getTagName(String) method.
     * @throws UnknownElementException to JUnit.
     */
    public void testGetTagName_NullReturn() throws UnknownElementException {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertNull(transformer.getTagName("unknown"));
        }
        System.out.println("Calling " + TOTAL_ITERATION
                + " getTagName(String)" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }
    
    /**
     * Benchmark the getTagName(String) method.
     * @throws UnknownElementException to JUnit.
     */
    public void testGetTagName() throws UnknownElementException {
        long start = System.currentTimeMillis();
        Map<String, String> tagNameMappings = createTagNameMappings();
        Iterator it = tagNameMappings.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            for (int i = 0; i < TOTAL_ITERATION; i++) {
                assertEquals(transformer.getTagName(key), tagNameMappings.get(key));
            }
        }
        System.out.println("Calling " + TOTAL_ITERATION * tagNameMappings.size()
                + " getTagName(String)" + " costs:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Creates the tagNameMappings for testing usage.
     *
     * @return the created tagNameMappings.
     */
    private Map<String, String> createTagNameMappings() {
        Map<String, String> tagNameMappings = new HashMap<String, String>();
        tagNameMappings.put(BezierPoint.class.getName(), "UML:BezierPoint");
        tagNameMappings.put(CoreSemanticModelBridge.class.getName(),
            "UML:CoreSemanticModelBridge");
        tagNameMappings.put(Diagram.class.getName(), "UML:Diagram");
        tagNameMappings.put(DiagramElement.class.getName(), "UML:DiagramElement");
        tagNameMappings.put(DiagramLink.class.getName(), "UML:DiagramLink");
        tagNameMappings.put(Dimension.class.getName(), "UML:Dimension");
        tagNameMappings.put(Ellipse.class.getName(), "UML:Ellipse");
        tagNameMappings.put(GraphConnector.class.getName(), "UML:GraphConnector");
        tagNameMappings.put(GraphEdge.class.getName(), "UML:GraphEdge");
        tagNameMappings.put(GraphElement.class.getName(), "UML:GraphElement");
        tagNameMappings.put(GraphicPrimitive.class.getName(),
            "UML:GraphicPrimitive");
        tagNameMappings.put(GraphNode.class.getName(), "UML:GraphNode");
        tagNameMappings.put(Image.class.getName(), "UML:Image");
        tagNameMappings.put(LeafElement.class.getName(), "UML:LeafElement");
        tagNameMappings.put(Point.class.getName(), "UML:Point");
        tagNameMappings.put(Polyline.class.getName(), "UML:Polyline");
        tagNameMappings.put(Property.class.getName(), "UML:Property");
        tagNameMappings.put(Reference.class.getName(), "UML:Reference");
        tagNameMappings.put(SemanticModelBridge.class.getName(),
            "UML:SemanticModelBridge");
        tagNameMappings.put(SimpleSemanticModelElement.class.getName(),
            "UML:SimpleSemanticModelElement");
        tagNameMappings.put(TextElement.class.getName(), "UML:TextElement");
        tagNameMappings.put(Uml1SemanticModelBridge.class.getName(),
            "UML:Uml1SemanticModelBridge");

        return tagNameMappings;
    }

    /**
     * Creates the transformers map for testing usage.
     *
     * @return the created transformers map.
     */
    private Map<String, DiagramInterchangeElementTransformer> createTransformers() {
        Map<String, DiagramInterchangeElementTransformer> transformers =
            new HashMap<String, DiagramInterchangeElementTransformer>();
        String base = "com.topcoder.diagraminterchange.";

        transformers.put(base + "BezierPoint", new BezierPointTransformer());
        transformers.put(base + "CoreSemanticModelBridge",
            new CoreSemanticModelBridgeTransformer());
        transformers.put(base + "Diagram", new DiagramTransformer());
        transformers.put(base + "DiagramElement",
            new DiagramElementTransformer());
        transformers.put(base + "DiagramLink", new DiagramLinkTransformer());
        transformers.put(base + "Dimension", new DimensionTransformer());
        transformers.put(base + "Ellipse", new EllipseTransformer());
        transformers.put(base + "GraphConnector",
            new GraphConnectorTransformer());
        transformers.put(base + "GraphEdge", new GraphEdgeTransformer());
        transformers.put(base + "GraphElement", new GraphElementTransformer());
        transformers.put(base + "GraphicPrimitive",
            new GraphicPrimitiveTransformer());
        transformers.put(base + "GraphNode", new GraphNodeTransformer());
        transformers.put(base + "Image", new ImageTransformer());
        transformers.put(base + "LeafElement", new LeafElementTransformer());
        transformers.put(base + "Point", new PointTransformer());
        transformers.put(base + "Polyline", new PolylineTransformer());
        transformers.put(base + "Property", new PropertyTransformer());
        transformers.put(base + "Reference", new ReferenceTransformer());
        transformers.put(base + "SemanticModelBridge",
            new SemanticModelBridgeTransformer());
        transformers.put(base + "SimpleSemanticModelElement",
            new SimpleSemanticModelElementTransformer());
        transformers.put(base + "TextElement", new TextElementTransformer());
        transformers.put(base + "Uml1SemanticModelBridge",
            new Uml1SemanticModelBridgeTransformer());

        return transformers;
    }
    
    /**
     * Creates the XMLTransformer instance for testing usage.
     * @return the created XMLTransformer object.
     */
    private Transformer createXMLTransformer() throws TransformerConfigurationException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }
    
    /**
     * Creates a XMI writer.
     *
     * @return the writer
     */
    private XMIWriter createXMIWriter() {
        Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();
        transformers.put(TransformerType.Model, new MockXMITransformer());
        transformers.put(TransformerType.ActivityGraph, new MockXMITransformer());
        transformers.put(TransformerType.Diagram, new MockXMITransformer());
        transformers.put(TransformerType.Header, new XMIHeaderTransformer("TCUML", "1.0", "1.2"));
        XMIWriter writer = new XMIWriter(new UMLModelManager(), transformers);
        return writer;
    }
    
    /**
     * Creates a Property.
     * @param key the key of the property.
     * @param value the value of the property.
     * @return the property.
     */
    private Property createProperty(String key, String value) {
        Property property = new Property();
        property.setKey(key);
        property.setValue(value);
        return property;
    }

    /**
     * Creates a Dimension
     * @param width the width of the dimension
     * @param height the height of the dimension
     * @return the dimension.
     */
    private Dimension createDimension(double width, double height) {
        Dimension dimension = new Dimension();
        dimension.setHeight(height);
        dimension.setWidth(width);
        return dimension;
    }

    /**
     * Creates a Point.
     * @param x the x of Point
     * @param y the y of Point
     * @return the point.
     */
    private Point createPoint(double x, double y) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        return point;
    }

}
