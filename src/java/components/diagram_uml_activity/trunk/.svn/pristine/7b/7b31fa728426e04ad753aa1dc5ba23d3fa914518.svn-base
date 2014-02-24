/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedListener;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * This class provides the demo usage of <code>InitialNode</code> component.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {

    /** Parent node of this <code>EllipseConnector</code> for testing. */
    private InitialNode node;

    /** Radius of initial node's graph node shape. */
    private int radius = 20;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        Pseudostate state = new PseudostateImpl();
        state.setKind(PseudostateKind.INITIAL);
        // set nameCompartment text
        state.setName("NameCompartment");
        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");
        state.addStereotype(stereotypeOne);

        GraphNode graphNode = TestUtil.createGraphNodeForActivityNode(state);
        graphNode.setPosition(TestUtil.createPoint(100, 100));
        graphNode.setSize(TestUtil.createDimension(radius * 2, radius * 2));
        TestUtil.addPropertiesToGraphNode(graphNode);
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = new HashMap<String, String>();
        properties.put("FillColor", "fill_color");
        properties.put("StrokeColor", "stroke_color");
        properties.put("FontColor", "font_color");
        properties.put("FontFamily", "font_family");
        properties.put("FontStyle", "font_style");
        properties.put("FontSize", "font_size");

        Point position = new Point(SelectionCorner.DEFAULT_RADIUS * 2, SelectionCorner.DEFAULT_RADIUS * 2);

        node = new InitialNode(graphNode, properties, position, new Rectangle());

    }

    /**
     * <p>
     * A demo usage of <code>InitialNode</code> component. It should complete without any exception.
     * </p>
     * @throws Exception to jfcunit
     */
    public void testDemo() throws Exception {
        TextChangedListener listener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewValue());
            }
        };
        // register the listener
        node.getNameCompartment().addTextChangedListener(listener);

        // Then add the node to the container to show it
        node.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        Diagram diagram = new Diagram();
        diagram.setName("Activity Diagram");
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        DiagramView view = viewer.openDiagramView(diagram);
        view.add(node);

        JDialog dialog = new JDialog((JFrame) null, "Demo", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setVisible(true);
    }
}
