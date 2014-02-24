/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.stresstests;

import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.event.SelectionEvent;
import com.topcoder.gui.diagramviewer.event.SelectionHandler;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for SelectionHandler.
 * 
 * @author CoInitialize
 * @version 1.0
 */
public class SelectionHandlerStressTest extends TestCase {

    /**
     * An instance of SelectionHandler used in tests.
     */
    private SelectionHandler handler;

    /**
     * An instance of SelectionEvent used in tests.
     */
    private SelectionEvent event;

    /**
     * Prepare the test environment.
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add(StressHelper.CONFIG_FILE);

        Constructor ctor = DiagramView.class.getDeclaredConstructor(Diagram.class,
                DiagramViewer.class);
        ctor.setAccessible(true);
        DiagramView diagramView = (DiagramView) ctor.newInstance(new Object[] {
                StressHelper.createDiagram(), new DiagramViewer() });

        // insert 100 nodes into diagramView
        for (int i = 0; i < 100; i++) {
            diagramView.add(new MockNode(new GraphNode(), new Point(i * 10, i * 10), new Rectangle(
                    0, 0, 100, 100), new ArrayList<SelectionCornerType>()));
        }

        handler = new SelectionHandler();
        event = new SelectionEvent(diagramView, new Rectangle(0, 0, 1000, 1000));
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
     * Stress Test of selectionRectangleChanged method.<br>
     * Print the time interval for recording.
     */
    public void testSelectionRectangleChanged() {
        StopWatch watch = new StopWatch();
        watch.start();

        for (int i = 0; i < StressHelper.TEST_LOOP_COUNT; i++) {
            handler.selectionRectangleChanged(event);
        }
        System.out.println(String.format(
                "Running SelectionHandler#selectionRectangleChanged() method for"
                        + " %d times consumes %d milliseconds.", StressHelper.TEST_LOOP_COUNT,
                watch.stop()));
    }
}
