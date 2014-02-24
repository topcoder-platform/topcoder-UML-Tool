/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Class_Edges Version 1.0 StressTest.
 *
 * @ PaintComponentStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.classedges.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.classedges.Aggregation;
import com.topcoder.gui.diagramviewer.uml.classedges.AggregationBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.ClosedArrow;
import com.topcoder.gui.diagramviewer.uml.classedges.Composition;
import com.topcoder.gui.diagramviewer.uml.classedges.CompositionBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.classedges.OpenArrow;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JFrame;


/**
 * <p>
 * This class tests the <code>paintComponent</code> method of every class
 * for stress. This stress tests create each class to look.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class PaintComponentStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 360;

    /**
     * <p>Return test suite of <code>PaintComponentStressTest</code>.</p>
     *
     * @return Test suite of <code>PaintComponentStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(PaintComponentStressTest.class);
    }

    /**
     * <p>Basic stress test of <code>paintComponent(Graphics g)</code> method
     * for each class.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testMethod_paintComponent() throws Exception {
        // creat a frame.
        JFrame frame = new JFrame();

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(3, 4));

        // create some GraphNode here.
        GraphNode node1 = new GraphNode();
        GraphNode node2 = new GraphNode();

        // create Aggregation here.
        Aggregation aggregation = new Aggregation(new TextField(node1),
                new TextField(node2));
        aggregation.setEndingPoint(new Point(100, 100));

        // create AggregationBiDirectional here.
        AggregationBiDirectional aggregationBiDirectional = new AggregationBiDirectional(new TextField(
                    node1), new TextField(node2));
        aggregationBiDirectional.setEndingPoint(new Point(100, 100));

        // create Composition here.
        Composition composition = new Composition(new TextField(node1),
                new TextField(node2));
        composition.setEndingPoint(new Point(100, 100));

        // create CompositionBiDirectional here.
        CompositionBiDirectional compositionBiDirectional = new CompositionBiDirectional(new TextField(
                    node1), new TextField(node2));
        compositionBiDirectional.setEndingPoint(new Point(100, 100));

        // create NoArrow here.
        NoArrow noArrow = new NoArrow(new TextField(node1), new TextField(node2));
        noArrow.setEndingPoint(new Point(100, 100));

        // create ClosedArrow here.
        ClosedArrow closedArrow = new ClosedArrow();
        closedArrow.setEndingPoint(new Point(100, 100));

        // create OpenArrow here.
        OpenArrow openArrow = new OpenArrow();
        openArrow.setEndingPoint(new Point(100, 100));

        container.add(aggregation);
        container.add(aggregationBiDirectional);
        container.add(composition);

        container.add(noArrow);
        container.add(closedArrow);
        container.add(openArrow);
        container.add(compositionBiDirectional);

        frame.pack();
        frame.setVisible(true);

        // rotate the arrow 360 degree.
        for (int i = 0; i < LOOPTIMES; i++) {
            aggregation.setAngle((Math.PI * i) / LOOPTIMES);
            aggregationBiDirectional.setAngle((Math.PI * i) / LOOPTIMES);
            composition.setAngle((Math.PI * i) / LOOPTIMES);
            compositionBiDirectional.setAngle((Math.PI * i) / LOOPTIMES);
            noArrow.setAngle((Math.PI * i) / LOOPTIMES);
            closedArrow.setAngle((Math.PI * i) / LOOPTIMES);
            openArrow.setAngle((Math.PI * i) / LOOPTIMES);

            aggregation.setVisible(true);
            aggregationBiDirectional.setVisible(true);
            composition.setVisible(true);
            compositionBiDirectional.setVisible(true);
            noArrow.setVisible(true);
            closedArrow.setVisible(true);
            openArrow.setVisible(true);

            // sleep a while here.
            Thread.sleep(5);

            aggregation.setVisible(false);
            aggregationBiDirectional.setVisible(false);
            composition.setVisible(false);
            compositionBiDirectional.setVisible(false);
            noArrow.setVisible(false);
            closedArrow.setVisible(false);
            openArrow.setVisible(false);
        }
    }
}
