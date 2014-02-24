/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.event.AddNewElementEvent;
import com.topcoder.gui.diagramviewer.event.AddNewElementListener;
import com.topcoder.gui.diagramviewer.event.ScrollEvent;
import com.topcoder.gui.diagramviewer.event.ScrollListener;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.event.TextInputListener;
import com.topcoder.gui.diagramviewer.event.ZoomEvent;
import com.topcoder.gui.diagramviewer.event.ZoomListener;
import com.topcoder.gui.panels.zoom.ZoomPanel;

import junit.framework.TestCase;

/**
 * <p>
 * Demo for this component.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the configuration
        UnitTestsHelper.loadConfig("config.xml");
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        UnitTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * <p>
     * Demo test.
     * </p>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testDemo() throws Exception {
        JPanel panel = new JPanel();
        // 2. Using DiagramViewer
        // Create a JFrame
        JFrame frame = new JFrame();
        // Create a DiagramViewer
        DiagramViewer viewer = new DiagramViewer();
        // Add the viewer to frame
        frame.add(viewer);
        // 3. Creating a DiagramView for a specified Diagram:
        // Obtain the Diagram
        Diagram diagram = new Diagram();
        diagram.setName("Mock Diagram");
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);

        DiagramView view = viewer.createDiagramView(diagram);

        // 4. Opening a diagram view tab in DiagramViewer:
        viewer.openDiagramView(diagram);

        // 5. Registering a popup menu for the DiagramView:
        // Create a JPopupMenu
        JPopupMenu popup = new JPopupMenu();
        view.setComponentPopupMenu(popup);
        // Show the popup menu for the view
        // view.getComponentPopupMenu().show(view, 0, 0);

        // 5. Show the text input control:
        // Create something needs to use the text input control
        //Node node = new ActorNode();
        // Get the text input
        TextInputBox box = viewer.getTextInputBox();
        // Register the listener to process text input event
        TextInputListener listener = new TextInputListener() {
            public void textEntered(TextInputEvent event) {
                System.out.println("enter text:" + event.getText());
            }

            public void textCancelled(TextInputEvent event) {
                System.out.println("cancel text:" + event.getText());
            }
        };
        box.addTextInputListener(listener);
        // Show the ti for the component
        //box.show(node, 0, 0);

        // 6. Registering for AddNewElementEvent:
        // Create an implementation of AddNewElementListener
        AddNewElementListener newListener = new AddNewElementListener() {
            public void addNewElement(AddNewElementEvent event) {
                DiagramView view = (DiagramView) event.getSource();
                Class newElementType = event.getNewElementType();
                // assumes the type is for a concrete Node
                Node node = null;
                try {
                    node = (Node) newElementType.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                // Add the new element to view
                view.add(node);
            }
        };
        // Register the listener
        viewer.addAddNewElementListener(newListener);

        // 7. Registering for a ScrollEvent:
        // Create an implementation of ScrollListener
        ScrollListener scrollListener = new ScrollListener() {
            public void diagramViewScrolled(ScrollEvent event) {
                // Obtain the viewport
                JViewport viewport = (JViewport) event.getSource();
                // Obtain the diagram
                Diagram diagram = event.getDiagram();
            }
        };
        // Register the listener
        viewer.addScrollListener(scrollListener);

        // 8. Registering for a ZoomEvent:
        // Create an implementation of ZoomListener
        ZoomListener zoomListener = new ZoomListener() {
            public void diagramViewZoomed(ZoomEvent event) {
                // Obtain the ZoomPanel
                ZoomPanel pane = (ZoomPanel) event.getSource();
                // Obtain the new zoom factor
                double factor = event.getNewZoomFactor();
            }
        };
        // Register the listener
        viewer.addZoomListener(zoomListener);

        // 9. Showing and hiding the background grid:
        // Show the background grid
        viewer.setBackgroundGridVisible(true);
        viewer.revalidate();
        // Hide the background grid
        viewer.setBackgroundGridVisible(false);
        viewer.revalidate();

        // 10. Custom the background grid:
        // Create an implementation of GridRenderer
        GridRenderer myRenderer = new GridRenderer() {
            public void renderGrid(Graphics graphics, DiagramView view) {
                // the grid size is 5
                for (int i = 0; i < view.getWidth(); i += 5) {
                    graphics.drawLine(i, 0, i, view.getHeight());
                }
                for (int i = 0; i < view.getHeight(); i += 5) {
                    graphics.drawLine(0, i, view.getWidth(), i);
                }
            }
        };
        // Register the renderer
        viewer.setGridRenderer(myRenderer);
        // Repaint
        viewer.revalidate();
        Thread.sleep(2000);
    }
}