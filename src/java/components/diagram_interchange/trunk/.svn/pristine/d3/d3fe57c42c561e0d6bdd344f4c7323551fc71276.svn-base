/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.stresstests;

import com.topcoder.diagraminterchange.CoreSemanticModelBridge;
import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Image;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.Element;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>This class tests some simple data classes like <code>CoreSemanticModelBridge</code>
 * class, <code>DiagramLink</code>, <code>LeafElement</code> and etc. This stress tests addresses
 * the functionality provided by these classes.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class SimpleClassStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>Return test suite of <code>SimpleClassStressTest</code>.</p>
     *
     * @return Test suite of <code>SimpleClassStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(SimpleClassStressTest.class);
    }

    /**
     * <p>Basic stress test of <code>CoreSemanticModelBridge</code> class.</p>
     */
    public void testClassMethod_CoreSemanticModelBridge() {
        for (int i = 0; i < LOOPTIMES; i++) {
            CoreSemanticModelBridge bridge = new CoreSemanticModelBridge();

            // check the result here.
            assertNotNull("The CoreSemanticModelBridge class is incorrect.", bridge);
            assertTrue("The CoreSemanticModelBridge class is incorrect.",
                bridge instanceof SemanticModelBridge);
        }
    }

    /**
     * <p>Basic stress test of <code>DiagramLink</code> class.</p>
     */
    public void testClassMethod_DiagramLink() {
        for (int i = 0; i < LOOPTIMES; i++) {
            DiagramLink link = new DiagramLink();
            assertNotNull("The DiagramLink class is incorrect.", link);

            // test the getXXX and setXXX here.
            link.setZoom(10.1);
            assertEquals("The getZoom method is incorrect.", 10.1, link.getZoom());

            Point viewport = new Point();
            link.setViewport(viewport);
            assertEquals("The getViewport method is incorrect.", viewport, link.getViewport());

            GraphElement graphElement = new GraphNode();
            link.setGraphElement(graphElement);
            assertEquals("The getGraphElement method is incorrect.", graphElement,
                link.getGraphElement());

            Diagram diagram = new Diagram();
            link.setDiagram(diagram);
            assertEquals("The getDiagram method is incorrect.", diagram, link.getDiagram());
        }
    }

    /**
     * <p>Basic stress test of <code>Dimension</code> class.</p>
     */
    public void testClassMethod_Dimension() {
        for (int i = 0; i < LOOPTIMES; i++) {
            Dimension dimension = new Dimension();
            assertNotNull("The Dimension class is incorrect.", dimension);
            assertEquals("The getHeight method is incorrect.", 0.0, dimension.getHeight());
            assertEquals("The getWidth method is incorrect.", 0.0, dimension.getWidth());

            // test the getXXX and setXXX here.
            dimension.setHeight(100.123);
            assertEquals("The getHeight method is incorrect.", 100.123, dimension.getHeight());

            dimension.setWidth(50.02);
            assertEquals("The getWidth method is incorrect.", 50.02, dimension.getWidth());
        }
    }

    /**
     * <p>Basic stress test of <code>Ellipse</code> class.</p>
     */
    public void testClassMethod_Ellipse() {
        for (int i = 0; i < LOOPTIMES; i++) {
            Ellipse ellipse = new Ellipse();
            assertNotNull("The Ellipse class is incorrect.", ellipse);
            assertEquals("The getRadiusX method is incorrect.", 0.0, ellipse.getRadiusX());
            assertEquals("The getRadiusY method is incorrect.", 0.0, ellipse.getRadiusY());
            assertEquals("The getStartAngle method is incorrect.", 0.0, ellipse.getStartAngle());
            assertEquals("The getEndAngle method is incorrect.", 0.0, ellipse.getEndAngle());

            // test the getXXX and setXXX here.
            ellipse.setRadiusX(100.1);
            assertEquals("The getRadiusX method is incorrect.", 100.1, ellipse.getRadiusX());

            ellipse.setRadiusY(10.2);
            assertEquals("The getRadiusY method is incorrect.", 10.2, ellipse.getRadiusY());

            ellipse.setStartAngle(10.2);
            assertEquals("The getStartAngle method is incorrect.", 10.2, ellipse.getStartAngle());

            ellipse.setEndAngle(150.5);
            assertEquals("The getEndAngle method is incorrect.", 150.5, ellipse.getEndAngle());

            Point center = new Point();
            ellipse.setCenter(center);
            assertEquals("The getCenter method is incorrect.", center, ellipse.getCenter());
        }
    }

    /**
     * <p>Basic stress test of <code>Image</code> class.</p>
     */
    public void testClassMethod_Image() {
        for (int i = 0; i < LOOPTIMES; i++) {
            Image image = new Image();
            assertNotNull("The Image class is incorrect.", image);

            // test the getXXX and setXXX here.
            image.setVisible(true);
            assertTrue("The isVisible method is incorrect.", image.isVisible());

            image.setUri("www.topcoder.com");
            assertEquals("The getUri method is incorrect.", "www.topcoder.com", image.getUri());

            image.setMimeType("jpg");
            assertEquals("The getMimeType method is incorrect.", "jpg", image.getMimeType());
        }
    }

    /**
     * <p>Basic stress test of <code>Point</code> class.</p>
     */
    public void testClassMethod_Point() {
        for (int i = 0; i < LOOPTIMES; i++) {
            Point point = new Point();
            assertNotNull("The Point class is incorrect.", point);

            // test the getXXX and setXXX here.
            point.setX(10.1);
            assertEquals("The getX method is incorrect.", 10.1, point.getX());

            point.setY(100.2);
            assertEquals("The getY method is incorrect.", 100.2, point.getY());
        }
    }

    /**
     * <p>Basic stress test of <code>Polyline</code> class.</p>
     */
    public void testClassMethod_Polyline() {
        Polyline polyline = new Polyline();

        List<Point> waypoints = new ArrayList<Point>();

        for (int i = 0; i < LOOPTIMES; i++) {
            Point waypoint = new Point();
            polyline.addWaypoint(waypoint);
            waypoints.add(waypoint);

            // check the result here.
            assertTrue("The containsWaypoint method is incorrect.",
                polyline.containsWaypoint(waypoint));
            assertEquals("The countWaypoints method is incorrect.", i + 1, polyline.countWaypoints());

            List<Point> getWaypoints = polyline.getWaypoints();
            assertEquals("The getWaypoints method is incorrect.", i + 1, getWaypoints.size());
            assertTrue("The getGraphEdges method is incorrect.", waypoints.containsAll(getWaypoints));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            Point removed = polyline.removeWaypoint(i);
            assertEquals("The removeWaypoint method is incorrect.", LOOPTIMES - i - 1,
                polyline.countWaypoints());
            assertFalse("The removeWaypoint method is incorrect.",
                polyline.containsWaypoint(removed));
        }

        // clear all diagram links and test it.
        polyline.clearWaypoints();
        assertEquals("The clearWaypoints method is incorrect.", 0, polyline.countWaypoints());
    }

    /**
     * <p>Basic stress test of <code>Property</code> class.</p>
     */
    public void testClassMethod_Property() {
        for (int i = 0; i < LOOPTIMES; i++) {
            Property property = new Property();
            assertNotNull("The Property class is incorrect.", property);

            // test the getXXX and setXXX here.
            property.setKey("key");
            assertEquals("The getKey method is incorrect.", "key", property.getKey());

            property.setValue("value");
            assertEquals("The getValue method is incorrect.", "value", property.getValue());
        }
    }

    /**
     * <p>Basic stress test of <code>Reference</code> class.</p>
     */
    public void testClassMethod_Reference() {
        for (int i = 0; i < LOOPTIMES; i++) {
            Reference reference = new Reference();
            assertNotNull("The Reference class is incorrect.", reference);
            assertFalse("The Reference class is incorrect.", reference.isIndividualRepresentation());

            // test the getXXX and setXXX here.
            reference.setVisible(true);
            assertTrue("The isVisible method is incorrect.", reference.isVisible());

            reference.setIndividualRepresentation(false);
            assertFalse("The isIndividualRepresentation method is incorrect.",
                reference.isIndividualRepresentation());

            DiagramElement diagramElement = new Reference();
            reference.setReferenced(diagramElement);
            assertEquals("The getReferenced method is incorrect.", diagramElement,
                reference.getReferenced());
        }
    }

    /**
     * <p>Basic stress test of <code>SimpleSemanticModelElement</code> class.</p>
     */
    public void testClassMethod_SimpleSemanticModelElement() {
        for (int i = 0; i < LOOPTIMES; i++) {
            SimpleSemanticModelElement element = new SimpleSemanticModelElement();
            assertNotNull("The SimpleSemanticModelElement class is incorrect.", element);

            // test the getXXX and setXXX here.
            element.setTypeInfo("typeInfo");
            assertEquals("The getTypeInfo method is incorrect.", "typeInfo", element.getTypeInfo());
        }
    }

    /**
     * <p>Basic stress test of <code>TextElement</code> class.</p>
     */
    public void testClassMethod_TextElement() {
        for (int i = 0; i < LOOPTIMES; i++) {
            TextElement element = new TextElement();
            assertNotNull("The TextElement class is incorrect.", element);

            // test the getXXX and setXXX here.
            element.setText("text");
            assertEquals("The getText method is incorrect.", "text", element.getText());
        }
    }

    /**
     * <p>Basic stress test of <code>Uml1SemanticModelBridge</code> class.</p>
     */
    public void testClassMethod_Uml1SemanticModelBridge() {
        for (int i = 0; i < LOOPTIMES; i++) {
            Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
            assertNotNull("The Uml1SemanticModelBridge class is incorrect.", bridge);

            // test the getXXX and setXXX here.
            Element element = new SimpleMockElementImpl();
            bridge.setElement(element);
            assertEquals("The getElement method is incorrect.", element, bridge.getElement());
        }
    }
}
