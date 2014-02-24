/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.stresstests;

import java.io.File;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;

/**
 * Stress test helper.
 *
 * @author CoInitialize
 * @version 1.0
 */
public class StressHelper {

    /**
     * Path of the configuration file.
     */
    public static final String CONFIG_FILE = "stresstests" + File.separator+"StressConfig.xml";

    /**
     * Test loop count.
     */
    public static final int TEST_LOOP_COUNT = 1000;

    /**
     * Create a Diagram instance and set some of its inner value.
     *
     * @return A Diagram instance.
     */
    public static Diagram createDiagram() {
        Dimension dim = new Dimension();
        dim.setHeight(500);
        dim.setWidth(500);
        Point pt = new Point();
        pt.setX(0);
        pt.setY(0);

        Diagram diagram = new Diagram();
        diagram.setName("Diagram");
        diagram.setPosition(pt);
        diagram.setSize(dim);
        diagram.setViewport(pt);
        diagram.setVisible(true);
        diagram.setZoom(0);

        return diagram;
    }
}
