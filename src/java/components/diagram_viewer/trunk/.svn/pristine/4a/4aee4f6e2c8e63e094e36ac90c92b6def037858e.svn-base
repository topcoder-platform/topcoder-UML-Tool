/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.awt.event.MouseEvent;
import java.io.File;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.event.AddNewElementEvent;
import com.topcoder.gui.diagramviewer.event.AddNewElementHandler;
import com.topcoder.gui.diagramviewer.event.AddNewElementListener;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>AddNewElementHandler</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class AddNewElementHandlerAccuracyTests extends TestCase {

    /**
     * Represent a flag used for test.
     */
    private static boolean fired = false;

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>AddNewElementHandler</c> used for test.
     */
    private AddNewElementHandler handler;

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
        handler = new AddNewElementHandler();

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
        event = new MouseEvent(view, 0, 0, 0, 0, 0, 0, true);
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
     * Accuracy test for the constructor <code>AddNewElementHandler</code>. The instance of
     * <code>AddNewElementHandler</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of AddNewElementHandler should be created", new AddNewElementHandler());
    }

    /**
     * <p>
     * Accuracy test for the method <code>mouseClicked</code>, when the state is DRAGGING.
     * </p>
     */
    public void testmouseClickedAccuracy() {
        try {
            view.getViewer().setNewElementType(Node.class);
            view.getViewer().setState(
                    DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);

            view.getViewer().addAddNewElementListener(
                    new AddNewElementListener() {

                        public void addNewElement(AddNewElementEvent event) {
                            // set the method is fired
                            fired = true;
                        }
                    });
            handler.mouseClicked(event);
            assertFalse("the method should not be fired", fired);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>mouseClicked</code>, when the state is CLICK.
     * </p>
     */
    public void testmouseClickedAccuracy2() {
        try {
            view.getViewer().setNewElementType(Node.class);
            view.getViewer().setState(DiagramState.ADD_ELEMENT_BY_CLICK);
            view.getViewer().addAddNewElementListener(
                    new AddNewElementListener() {

                        public void addNewElement(AddNewElementEvent event) {
                            // set the method is fired
                            fired = true;

                        }
                    });
            handler.mouseClicked(event);
            assertTrue("the method should be fired", fired);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
