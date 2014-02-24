/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.event.PopupMenuTrigger;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>PopupMenuTrigger</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class PopupMenuTriggerAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>PopupMenuTrigger</c> used for test.
     */
    private PopupMenuTrigger trigger;

    /**
     * Represent the instance of <c>MouseEvent</c> used for test.
     */
    private MouseEvent event;

    /**
     * Represent the instance of <c>DiagramView</c> used for test.
     */
    private DiagramView view;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfig(CONFIG);
        trigger = new PopupMenuTrigger();
        DiagramViewer viewer = new DiagramViewer();
        viewer.add(new JPopupMenu());

        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        view = new DiagramViewer().createDiagramView(diagram);

        event = new MouseEvent(view, 0, 0, 0, 0, 0, 0, true, MouseEvent.BUTTON2);
    }

    /**
     * <p>
     * Tear down test environment.
     * </p>
     *
     * @throws Exception
     *         if any error occurs when tear down
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>PopupMenuTrigger</code>. The instance of <code>PopupMenuTrigger</code>
     * should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of PopupMenuTrigger should be created", new PopupMenuTrigger());
    }

    /**
     * <p>
     * Accuracy test for the method <code>mouseClicked</code> The should be returned.
     * </p>
     */
    public void testmouseClickedAccuracy() {
        try {
            trigger.mouseClicked(event);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
