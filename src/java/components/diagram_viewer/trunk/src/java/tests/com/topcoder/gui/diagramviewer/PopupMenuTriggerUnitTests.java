/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.event.PopupMenuTrigger;

/**
 * <p>
 * Unit test cases for PopupMenuTrigger.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PopupMenuTriggerUnitTests extends TestCase {

    /**
     * MouseEvent instance for testing.
     */
    private MouseEvent event;

    /**
     * MouseDragHandler instance for testing.
     */
    private PopupMenuTrigger pmt;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the valid configuration
        UnitTestsHelper.loadConfig("config.xml");
        pmt = new PopupMenuTrigger();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: PopupMenuTrigger(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create PopupMenuTrigger instance.", pmt);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: mouseClicked(MouseEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMouseClickedAccuracy() throws Exception {
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        DiagramViewer viewer = new DiagramViewer();
        viewer.add(new JPopupMenu());
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true, MouseEvent.BUTTON2);
        pmt.mouseClicked(event);

    }

}
