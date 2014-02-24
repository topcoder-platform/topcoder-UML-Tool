/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.stresstests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for DiagramViewer.
 *
 * @author CoInitialize
 * @version 1.0
 */
public class DiagramViewerStressTest extends TestCase {

    /**
     * An instance of DiagramViewer used in tests.
     */
    private DiagramViewer diagramViewer;

    /**
     * Prepare the test environment.
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add(StressHelper.CONFIG_FILE);

        diagramViewer = new DiagramViewer();
    }

    /**
     * Clean the test environment.
     */
    protected void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }

    /**
     * Stress Test of createDiagramView method.<br>
     * Print the time interval for recording.
     *
     * @throws Exception exception thrown to JUnit.
     */
    public void testCreateDiagramView() throws Exception {
        StopWatch watch = new StopWatch();
        watch.start();

        for (int i = 0; i < StressHelper.TEST_LOOP_COUNT; i++) {
            Diagram diagram = new Diagram();
            Dimension dimension = new Dimension();
            dimension.setWidth(500.0);
            dimension.setHeight(500.0);
            diagram.setSize(dimension);

            Point point = new Point();
            point.setX(5);
            point.setY(5);
            diagram.setPosition(point);
            diagramViewer.createDiagramView(diagram);
        }
        System.out.println(String
                .format("Running DiagramViewer#createDiagramView() method for"
                        + " %d times consumes %d milliseconds.", StressHelper.TEST_LOOP_COUNT,
                        watch.stop()));
    }

    /**
     * Stress Test of openDiagramView method.<br>
     * Print the time interval for recording.
     *
     * @throws Exception exception thrown to JUnit.
     */
    public void testOpenDiagramView() throws Exception {
        StopWatch watch = new StopWatch();
        watch.start();

        for (int i = 0; i < StressHelper.TEST_LOOP_COUNT; i++) {
            Diagram diagram = new Diagram();
            Dimension dimension = new Dimension();
            dimension.setWidth(500.0);
            dimension.setHeight(500.0);
            diagram.setSize(dimension);

            Point point = new Point();
            point.setX(5);
            point.setY(5);
            diagram.setPosition(point);
            diagram.setName("Diagram " + i);
            diagramViewer.openDiagramView(diagram);
        }
        System.out.println(String
                .format("Running DiagramViewer#openDiagramView() method for"
                        + " %d times consumes %d milliseconds.", StressHelper.TEST_LOOP_COUNT,
                        watch.stop()));
    }

    /**
     * Stress Test of closeDiagramView method.<br>
     * Print the time interval for recording.
     *
     * @throws Exception exception thrown to JUnit.
     */
    public void testCloseDiagramView() throws Exception {
        // open TEST_LOOP_COUNT diagrams to close.
        List<Diagram> diagramList = new ArrayList<Diagram>();
        for (int i = 0; i < StressHelper.TEST_LOOP_COUNT; i++) {
            Diagram diagram = new Diagram();
            Dimension dimension = new Dimension();
            dimension.setWidth(500.0);
            dimension.setHeight(500.0);
            diagram.setSize(dimension);

            Point point = new Point();
            point.setX(5);
            point.setY(5);
            diagram.setPosition(point);
            diagram.setName("Diagram " + i);
            diagramList.add(diagram);
            diagramViewer.openDiagramView(diagram);
        }

        StopWatch watch = new StopWatch();
        watch.start();

        for (int i = 0; i < StressHelper.TEST_LOOP_COUNT; i++) {
            diagramViewer.closeDiagramView(diagramList.get(0));
        }
        System.out.println(String
                .format("Running DiagramViewer#closeDiagramView() method for"
                        + " %d times consumes %d milliseconds.", StressHelper.TEST_LOOP_COUNT,
                        watch.stop()));
    }
}
