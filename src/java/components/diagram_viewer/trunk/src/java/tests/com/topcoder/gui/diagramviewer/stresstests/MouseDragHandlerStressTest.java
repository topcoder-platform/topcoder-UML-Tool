/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.stresstests;

import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.event.MouseDragHandler;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for MouseDragHandler.
 * 
 * @author CoInitialize
 * @version 1.0
 */
public class MouseDragHandlerStressTest extends TestCase {

    /**
     * An instance of MouseEvent used in tests.
     */
    private MouseEvent event;

    /**
     * An instance of MouseDragHandler used in tests.
     */
    private MouseDragHandler handler;

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

        handler = new MouseDragHandler();
        event = new MouseEvent(diagramView, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
                (int) MouseEvent.MOUSE_EVENT_MASK, 10, 10, 1, false);
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
     * Stress Test of mouseDragged method.<br>
     * Print the time interval for recording.
     */
    public void testMouseDragged() {
        StopWatch watch = new StopWatch();
        watch.start();

        for (int i = 0; i < StressHelper.TEST_LOOP_COUNT; i++) {
            handler.mouseDragged(event);
        }
        System.out.println(String
                .format("Running MouseDragHandler#mouseDragged() method for"
                        + " %d times consumes %d milliseconds.", StressHelper.TEST_LOOP_COUNT,
                        watch.stop()));
    }
}
