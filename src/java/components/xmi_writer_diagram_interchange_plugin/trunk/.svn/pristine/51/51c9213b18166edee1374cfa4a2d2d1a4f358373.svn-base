/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DimensionTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.EllipseTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphNodeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PointTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PolylineTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ReferenceTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.TextElementTransformer;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * Demonstration of <b>XMI Writer - Diagram Interchange Plugin 1.0 Component </b>.
     * </p>
     * <p>
     * To use the component, all that needs to be done is to construct an instance with valid element transformers,
     * then elements of known classes can be transformed.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testDemo() throws Exception {
        // Element Transformer setup:
        Map < String, DiagramInterchangeElementTransformer > transMap =
            new HashMap < String, DiagramInterchangeElementTransformer >();
        
        String base = "com.topcoder.diagraminterchange.";
        transMap.put(base + "Property",       new PropertyTransformer());
        transMap.put(base + "DiagramElement", new DiagramElementTransformer());
        transMap.put(base + "Reference",      new ReferenceTransformer());
        // ... etc.
        transMap.put(base + "Polyline",       new PolylineTransformer());
        transMap.put(base + "Ellipse",        new EllipseTransformer());
        transMap.put(base + "Diagram",        new DiagramTransformer());
        transMap.put(base + "Point",        new PointTransformer());
        transMap.put(base + "Dimension",        new DimensionTransformer());
        transMap.put(base + "GraphNode",        new GraphNodeTransformer());
        transMap.put(base + "TextElement",        new TextElementTransformer());

        // tagNameMappings setup:
        Map < String, String > tagNameMappings = new HashMap < String, String >();

        // XML Transformer setup:
        Transformer xmit = TransformerFactory.newInstance().newTransformer();
        xmit.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        xmit.setOutputProperty(OutputKeys.INDENT, "yes");

        // Component initialization:
        Diagram2XMITransformer trans
            = new Diagram2XMITransformer(transMap, tagNameMappings, xmit, true);
        // Due to defaults, this is the same as
        // new Diagram2XMITransformer(transMap);


        // use with XMI Writer:
        Map < TransformerType, XMITransformer > tMap = new HashMap < TransformerType, XMITransformer >();
        tMap.put(TransformerType.Diagram, trans);
        tMap.put(TransformerType.Model,  new MockXMITransformer());
        tMap.put(TransformerType.ActivityGraph,  new MockXMITransformer());
        UMLModelManager manager = new UMLModelManager();
        XMIWriter writer = new XMIWriter(manager, tMap);


        // check a few initial setups:
        // check PolylineTransformer could be found for the the Polyline class
        DiagramInterchangeElementTransformer polylineTr =
            trans.getElementTransformer(base + "Polyline");
        assertTrue("The polylineTr should be of PolylineTransformer type", polylineTr instanceof PolylineTransformer);
        // check if could not find a Transformer for a class, an UnknownElementException will be thrown
        try {
            trans.getElementTransformer("unrecognisedclass");
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException e) {
            // good
        }

        // set up some elements to be transformed
        // assume makePoint returns a Point with the given x/y
        // and makeProperty returns a property with the given key/value

        // make a Diagram:
        Diagram diag = new Diagram();
        diag.setName("Main Class Diagram");
        diag.setPosition(makePoint(0.0, 0.0));
        diag.setSize(makeDimension(250.0, 250.0));
        diag.setViewport(makePoint(0.0, 0.0));
        diag.setZoom(0.9);

        // make a text box to put in there, with Node container:
        TextElement txt = new TextElement();
        txt.setText("Title");
        GraphNode holder = new GraphNode();
        holder.addContained(txt);
        holder.setPosition(makePoint(120.0, 30.0));
        holder.setSize(makeDimension(40.0, 25.0));
        holder.addProperty(makeProperty("font-size", "20.0"));
        // add to diagram
        diag.addContained(holder);

        // make an ellipse:
        Ellipse els = new Ellipse();
        els.setRadiusX(22.0);
        els.setRadiusY(22.0);
        els.setRotation(0.0);
        els.setStartAngle(0.0);
        els.setEndAngle(6.283185307179586); // 2 pi
        els.setVisible(false);
        els.setCenter(makePoint(200.0, 30.0));
        els.addProperty(makeProperty("fill", "#0000ff"));
        // add to diagram
        diag.addContained(els);

        // transform
        try {
            // see provided sample.xmi for possible output - note that
            // it it��s a complete XMI file yet, so can��t be loaded
            trans.transform(diag, System.out);
        } catch (Exception e) {
            // this might occur, errors are not suppressed
            throw e;
        }
        // add this diagram
        manager.addDiagram(diag);
        // will write the diagram data to the sample file:
        writer.transform(new File("test_files/sample.xmi"), true);
        // the output is show below:
        /*
         * <UML:Diagram name="Main Class Diagram" visible="true" xmi.id="95605017-f101-4743-832d-298426acf5ab"
         *      zoom="0.9">
         *      <UML:Diagram.viewport>
         *          <UML:Point x="0.0" y="0.0"/>
         *       </UML:Diagram.viewport>
         *      <UML:GraphNode.size>
         *          <UML:Dimension height="250.0" width="250.0"/>
         *      </UML:GraphNode.size>
         *      <UML:GraphElement.position>
         *          <UML:Point x="0.0" y="0.0"/>
         *      </UML:GraphElement.position>
         *      <UML:GraphElement.contained>
         *          <UML:GraphNode visible="true" xmi.id="35ae2d8c-e6de-4c0c-bfc0-243dd29592ff">
         *              <UML:GraphNode.size>
         *                  <UML:Dimension height="25.0" width="40.0"/>
         *              </UML:GraphNode.size>
         *           <UML:GraphElement.position>
         *               <UML:Point x="120.0" y="30.0"/>
         *           </UML:GraphElement.position>
         *           <UML:GraphElement.contained>
         *               <UML:TextElement text="Title" visible="true" xmi.id="68cec23e-a960-4098-9add-70ec5f483cc0"/>
         *           </UML:GraphElement.contained>
         *           <UML:DiagramElement.property>
         *               <UML:Property key="font-size" value="20.0"/>
         *           </UML:DiagramElement.property>
         *          </UML:GraphNode>
         *          <UML:Ellipse endAngle="6.283185307179586" radiusX="22.0" radiusY="22.0" rotation="0.0"
         *              startAngle="0.0" visible="false" xmi.id="782936e7-5bc9-4cbb-874f-da654fcf2d7e">
         *              <UML:Ellipse.center>
         *                  <UML:Point x="200.0" y="30.0"/>
         *              </UML:Ellipse.center>
         *              <UML:DiagramElement.property>
         *                  <UML:Property key="fill" value="#0000ff"/>
         *              </UML:DiagramElement.property>
         *          </UML:Ellipse>
         *      </UML:GraphElement.contained>
         * </UML:Diagram>
         */

        // transform unregistered class:
        try {
            trans.transform(new Integer(0), System.out);
        } catch (UnknownElementException e) {
            // will get here - integers don��t have a transformer
        }

        // transform to node:
        try {
            // get document from builder
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Node node = trans.transform(diag, doc);
            assertTrue("The name of the node should be 'UML:Diagram'.", node.getNodeName().equals("UML:Diagram"));
        } catch (Exception e) {
            // shouldn��t get here
        }

        // suppress any exception
        trans.setWithExceptions(false);
        try {
            trans.transform(new Integer(0), System.out);
        } catch (UnknownElementException e) {
            // won��t get here - integers are unknown, but errors suppressed
        }
    }

    /**
     * <p>
     * Return a Point with the given x/y.
     * </p>
     * @param x X coordinate of this Point
     * @param y Y coordinate of this Point
     * @return a Point instance created
     */
    private Point makePoint(double x, double y) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        return point;
    }

    /**
     * <p>
     * Return a Dimension with the given width/height.
     * </p>
     * @param width the width of this Dimension
     * @param height the height of this Dimension
     * @return a Dimension created
     */
    private Dimension makeDimension(double width, double height) {
        Dimension dimension = new Dimension();
        dimension.setWidth(width);
        dimension.setHeight(height);
        return dimension;
    }

    /**
     * <p>
     * Return a Property with the given key/value.
     * </p>
     * @param key the key of this Property
     * @param value the value of this Property
     * @return a Property instance created
     */
    private Property makeProperty(String key, String value) {
        Property property = new Property();
        property.setKey(key);
        property.setValue(value);
        return property;
    }

}
