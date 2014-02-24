/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.stresstests;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.reflect.Constructor;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.gridrenderers.SimpleGridRenderer;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for SimpleGridRenderer.
 * 
 * @author CoInitialize
 * @version 1.0
 */
public class SimpleGridRendererStressTest extends TestCase {

    /**
     * Prepare the test environment.
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add(StressHelper.CONFIG_FILE);
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
     * Stress Test of renderGrid method.<br>
     * Create a BufferedImage to get Graphics instance to draw on.<br>
     * Print the time interval for recording.
     * 
     * @throws Exception exception thrown to JUnit.
     */
    public void testRenderGrid() throws Exception {
        Constructor ctor = DiagramView.class.getDeclaredConstructor(Diagram.class,
                DiagramViewer.class);
        ctor.setAccessible(true);
        DiagramView diagramView = (DiagramView) ctor.newInstance(new Object[] {
                StressHelper.createDiagram(), new DiagramViewer() });

        StopWatch watch = new StopWatch();
        watch.start();

        SimpleGridRenderer renderer = new SimpleGridRenderer(1000);
        BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0; i < StressHelper.TEST_LOOP_COUNT; i++) {
            Graphics g = image.getGraphics();
            renderer.renderGrid(g, diagramView);
            g.dispose();
        }

        System.out.println(String
                .format("Running SimpleGridRenderer#renderGrid() method for"
                        + " %d times consumes %d milliseconds.", StressHelper.TEST_LOOP_COUNT,
                        watch.stop()));
    }
}
