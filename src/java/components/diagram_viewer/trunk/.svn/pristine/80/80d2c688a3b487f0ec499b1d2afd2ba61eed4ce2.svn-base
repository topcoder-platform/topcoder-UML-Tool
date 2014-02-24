/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.CloseTabAction;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.GridRenderer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.ZoomAction;
import com.topcoder.gui.diagramviewer.ZoomTextFieldAction;
import com.topcoder.gui.diagramviewer.gridrenderers.SimpleGridRenderer;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.event.ScrollEvent;
import com.topcoder.gui.diagramviewer.event.ScrollListener;
import com.topcoder.gui.diagramviewer.event.SelectionHandler;
import com.topcoder.gui.diagramviewer.event.SelectionListener;
import com.topcoder.gui.diagramviewer.event.ZoomEvent;
import com.topcoder.gui.diagramviewer.event.ZoomListener;
import com.topcoder.gui.diagramviewer.event.AddNewElementEvent;
import com.topcoder.gui.diagramviewer.event.AddNewElementListener;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <c>DiagramViewer</c> class.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */

public class DiagramViewerAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents the DiagramViewer instance for testing.
     * </p>
     */
    private DiagramViewer viewer;

    /**
     * DiagramView instance for testing.
     */
    private DiagramView view;

    /**
     * Diagram instance for testing.
     */
    private Diagram diagram;

    /**
     * <p>
     * Sets up the testing environment.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    protected void setUp() throws Exception {
        // loads the configuration
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DefaultConfig);
        viewer = new DiagramViewer();
        diagram = new Diagram();
        diagram.setName("Mock Diagram");
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        Diagram diagram2 = new Diagram();
        diagram2.setName("Test");
        diagram2.setSize(dimension);
        diagram2.setPosition(point);
        diagram.setContainer(diagram2);
        this.viewer.openDiagramView(diagram);
        view = viewer.createDiagramView(diagram);
    }

    /**
     * <p>
     * Clears the testing environment.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.removeAllNamespaces();
        viewer = null;
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy1() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig1.xml");
        viewer = new DiagramViewer();
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
        assertEquals("The value of 'maxOpenTabs' is expected as 50.", viewer
                .getMaxOpenTabs(), 50);
        assertEquals(
                "The value of 'tabShortenedTitleMaxLength' is expected as 10.",
                viewer.getTabShortenedTitleMaxLength(), 100);
        assertEquals(
                "The value of 'diagramBackgoundColor' is expected as Color.white.",
                viewer.getDiagramBackgroundColor(), Color.white);
        assertFalse(
                "The value of 'tabTitleDisplayedInFullVersion' is expected as false.",
                viewer.isTabTitleDisplayedInFullVersion());
        assertTrue("The value of 'backgroundGridVisible' is expected true.",
                viewer.isBackgroundGridVisible());
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy2() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy3() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy4() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy5() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy6() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy7() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy8() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy9() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy10() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy11() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy12() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the normal accuracy test for constructor, all config value
     * present. The instance should be created successfully.
     * </p>
     *
     * @throws Exception
     *             exception to Junit.
     */
    public void testCtor_accuracy13() throws Exception {
        AccuracyTestsHelper.loadConfig("accuracyTests" + File.separatorChar
                + "ViewerConfig2.xml");
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setMaxOpenTabs(int maxOpenTabs).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetMaxOpenTabsAccuracy() throws Exception {
        viewer.setMaxOpenTabs(50);
        assertEquals("Fail to setMaxOpenTabs.", 50, this.viewer
                .getMaxOpenTabs());
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * setTabTitleDisplayedInFullVersion().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetTabTitleDisplayedInFullVersion() throws Exception {
        viewer.setTabTitleDisplayedInFullVersion(true);
        assertEquals("Fail to call method: setTabTitleDisplayedInFullVersion.",
                true, viewer.isTabTitleDisplayedInFullVersion());
        viewer.setTabTitleDisplayedInFullVersion(false);
        assertFalse("Fail to call method: setTabTitleDisplayedInFullVersion.",
                viewer.isTabTitleDisplayedInFullVersion());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setTabShortenedTitleMaxLength(int
     * length).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetTabShortenedTitleMaxLength() throws Exception {
        viewer.setTabShortenedTitleMaxLength(24);
        assertEquals("Fail to call method: setTabShortenedTitleMaxLength().",
                24, viewer.getTabShortenedTitleMaxLength());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setBackgroundGridVisible().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetBackgroundGridVisible() throws Exception {
        this.viewer.setBackgroundGridVisible(false);
        assertFalse("Fail to call method: setBackgroundGridVisible().", viewer
                .isBackgroundGridVisible());
        this.viewer.setBackgroundGridVisible(true);
        assertTrue("Fail to call method: setBackgroundGridVisible().", viewer
                .isBackgroundGridVisible());
    }

    /**
     * <p>
     * Accuracy test for Getter and Setter of gridRenderer via methods
     * getGridRenderer() and setGridRenderer(GridRenderer gridRenderer).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetGridRenderer() throws Exception {
        assertNotNull("It should be initialized in the ctor", viewer
                .getGridRenderer());
        GridRenderer gr = new SimpleGridRenderer(10);
        viewer.setGridRenderer(gr);
        assertSame(
                "Fail to call method:  setGridRenderer(GridRenderer gridRenderer).",
                gr, viewer.getGridRenderer());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getNewElementType().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetNewElementType() throws Exception {
        assertNull("Fail to call method: getNewElementType().", viewer
                .getNewElementType());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setNewElementType(Class
     * newElementType).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetNewElementType() throws Exception {
        viewer.setNewElementType(Node.class);
        assertEquals("Fail to call method: setNewElementType().", viewer
                .getNewElementType(), Node.class);
        viewer.setNewElementType(NodeContainer.class);
        assertEquals("Fail to call method: setNewElementType().", viewer
                .getNewElementType(), NodeContainer.class);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getState().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetState() throws Exception {
        assertEquals("Fail to call method: getState().",
                DiagramState.SELECT_ELEMENT, viewer.getState());
    }

    /**
     * <p>
     * This is the Accuracy test for Method:setState(DiagramState state).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetState() throws Exception {
        this.viewer.setNewElementType(Node.class);
        this.viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
        assertEquals("Fail to call method: setState().",
                DiagramState.ADD_ELEMENT_BY_CLICK, viewer.getState());
        this.viewer.setState(DiagramState.SELECT_ELEMENT);
        assertEquals("Fail to call method: setState().",
                DiagramState.SELECT_ELEMENT, viewer.getState());
        this.viewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
        assertEquals("Fail to call method: setState().",
                DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE, viewer
                        .getState());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramViewGap().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetDiagramViewGap() throws Exception {
        assertEquals("Fail to call method: getDiagramViewGap().", viewer
                .getDiagramViewGap(), 50);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomInAction().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetZoomInAction() throws Exception {
        assertTrue("Fail to call method: getZoomInAction().", viewer
                .getZoomInAction() instanceof ZoomAction);
        assertSame("Fail to call method: getZoomInAction().", viewer
                .getZoomInAction().getDiagramViewer(), viewer);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomOutAction().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetZoomOutAction() throws Exception {
        assertTrue("Fail to call method: getZoomOutAction().", viewer
                .getZoomOutAction() instanceof ZoomAction);
        assertSame("Fail to call method: getZoomOutAction().", viewer
                .getZoomOutAction().getDiagramViewer(), viewer);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getCloseTabAction().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetCloseTabAction() throws Exception {
        assertTrue("Fail to call method: getCloseTabAction().", viewer
                .getCloseTabAction() instanceof CloseTabAction);
        assertSame("Fail to call method: getCloseTabAction().", viewer
                .getCloseTabAction().getDiagramViewer(), viewer);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getBootomBar().
     * </p>
     *
     * @throws Exception
     *             when error occurs -/ public void testGetBootomBar() throws
     *             Exception { assertTrue("Fail to call method:
     *             getBootomBar().", viewer.getBottomBar() instanceof JPanel); }
     *
     * /**
     * <p>
     * This is the Accuracy test for Method: getTextInputBox().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetTextInputBox() throws Exception {
        assertTrue("Fail to call method: getTextInputBox().", viewer
                .getTextInputBox() instanceof TextInputBox);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * addSelectionListener(SelectionListener listener).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testAddSelectionListener() throws Exception {
        SelectionListener listener = new SelectionHandler();
        viewer.addSelectionListener(listener);
        assertEquals(
                "Fail to call method: addSelectionListener(SelectionListener listener).",
                viewer.getListeners(SelectionListener.class)[0], listener);
        assertEquals(
                "Fail to call method: addSelectionListener(SelectionListener listener).",
                viewer.getListeners(SelectionListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * removeSelectionListener(SelectionListener listener).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testRemoveSelectionListener() throws Exception {
        SelectionListener listener = new SelectionHandler();
        viewer.addSelectionListener(listener);
        assertEquals(
                "Fail to call method: addSelectionListener(SelectionListener listener).",
                viewer.getListeners(SelectionListener.class)[0], listener);
        assertEquals(
                "Fail to call method: addSelectionListener(SelectionListener listener).",
                viewer.getListeners(SelectionListener.class).length, 1);
        viewer.removeSelectionListener(listener);
        assertEquals(
                "Fail to call method: addSelectionListener(SelectionListener listener).",
                viewer.getListeners(SelectionListener.class).length, 0);
        viewer.removeSelectionListener(listener);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * fireSelectionRectangleChange(DiagramView view, Rectangle rectangle).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testFireSelectionRectangleChange() throws Exception {
        for (int i = 0; i < 10; i++) {
            viewer.addSelectionListener(new SelectionHandler());
        }
        view = viewer.createDiagramView(diagram);
        Rectangle rectangle = new Rectangle();
        this.viewer.fireSelectionRectangleChange(view, rectangle);
        assertEquals(
                "Fail to call method: addSelectionListener(SelectionListener listener).",
                viewer.getListeners(SelectionListener.class).length, 10);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: addSrollListener(ScrollListener
     * listener).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testAddScrollListener() throws Exception {
        ScrollListener listener = new ScrollListenerImpl();
        viewer.addScrollListener(listener);
        assertEquals(
                "Fail to call method: addScrollListener(ScrollListener listener).",
                viewer.getListeners(ScrollListener.class)[0], listener);
        assertEquals(
                "Fail to call method: addScrollListener(ScrollListener listener).",
                viewer.getListeners(ScrollListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: removeScrollListener(ScrollListener
     * listener).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testRemoveScrollListener() throws Exception {
        ScrollListener listener = new ScrollListenerImpl();
        viewer.addScrollListener(listener);
        assertEquals(
                "Fail to call method: addScrollListener(ScrollListener listener).",
                viewer.getListeners(ScrollListener.class)[0], listener);
        assertEquals(
                "Fail to call method: addScrollListener(ScrollListener listener).",
                viewer.getListeners(ScrollListener.class).length, 1);
        viewer.removeScrollListener(listener);
        assertEquals(
                "Fail to call method: addScrollListener(ScrollListener listener).",
                viewer.getListeners(ScrollListener.class).length, 0);
        viewer.removeScrollListener(listener);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireScroll(JViewport viewport,
     * Diagram diagram).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testFireScroll() throws Exception {
        JViewport viewport = new JViewport();
        for (int i = 0; i < 10; i++) {
            viewer.addScrollListener(new ScrollListenerImpl());
        }
        this.viewer.fireScroll(viewport, diagram);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: addZoomListener(ZoomListener
     * listener).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testAddZoomListener() throws Exception {
        ZoomListener listener = new ZoomListenerImpl();
        viewer.addZoomListener(listener);
        assertEquals(
                "Fail to call method: addZoomListener(ZoomListener listener).",
                viewer.getListeners(ZoomListener.class)[0], listener);
        assertEquals(
                "Fail to call method: addZoomListener(ZoomListener listener).",
                viewer.getListeners(ZoomListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: removeZoomListener(ZoomListener
     * listener).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testRemoveZoomListener() throws Exception {
        ZoomListener listener = new ZoomListenerImpl();
        viewer.addZoomListener(listener);
        assertEquals(
                "Fail to call method: addZoomListener(ZoomListener listener).",
                viewer.getListeners(ZoomListener.class)[0], listener);
        assertEquals(
                "Fail to call method: addZoomListener(ZoomListener listener).",
                viewer.getListeners(ZoomListener.class).length, 1);
        viewer.removeZoomListener(listener);
        assertEquals(
                "Fail to call method: addZoomListener(ZoomListener listener).",
                viewer.getListeners(ZoomListener.class).length, 0);
        viewer.removeZoomListener(listener);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireZoom().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testFireZoom() throws Exception {
        for (int i = 0; i < 10; i++) {
            viewer.addZoomListener(new ZoomListenerImpl());
        }
        this.viewer.fireZoom(122);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * addAddNewElementListener(AddNewElementListener listener).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testAddAddNewElementListener() throws Exception {
        AddNewElementListener listener = new AddNewElementListenerImpl();
        viewer.addAddNewElementListener(listener);
        assertEquals(
                "Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
                viewer.getListeners(AddNewElementListener.class)[0], listener);
        assertEquals(
                "Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
                viewer.getListeners(AddNewElementListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * removeAddNewElementListener(AddNewElementListener listener).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testRemoveAddNewElementListener() throws Exception {
        AddNewElementListener listener = new AddNewElementListenerImpl();
        viewer.addAddNewElementListener(listener);
        assertEquals(
                "Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
                viewer.getListeners(AddNewElementListener.class)[0], listener);
        assertEquals(
                "Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
                viewer.getListeners(AddNewElementListener.class).length, 1);
        viewer.removeAddNewElementListener(listener);
        assertEquals(
                "Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
                viewer.getListeners(AddNewElementListener.class).length, 0);
        viewer.removeAddNewElementListener(listener);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireNewElementAdded(DiagramView
     * diagramView, Class type).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testFireNewElementAdded() throws Exception {
        for (int i = 0; i < 10; i++) {
            viewer.addAddNewElementListener(new AddNewElementListenerImpl());
        }
        this.viewer.fireNewElementAdded(view, Node.class);

    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireNewElementAdded(DiagramView
     * diagramView, Class type, Rectangle bounds).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testFireNewElementAdded2() throws Exception {
        for (int i = 0; i < 10; i++) {
            viewer.addAddNewElementListener(new AddNewElementListenerImpl());
        }
        this.viewer.fireNewElementAdded(view, Node.class);

    }

    /**
     * <p>
     * This is the Accuracy test for Method: createDiagramView(Diagram diagram).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testCreateDiagramViewAccuary() throws Exception {
        for (int i = 0; i < 10; i++) {
            this.viewer.createDiagramView(diagram);
        }

        assertEquals("Fail to create DiagramView", view, this.viewer
                .createDiagramView(diagram));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: createDiagramViews(Diagram[]
     * diagrams).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testCreateDiagramView2Accuary() throws Exception {
        Diagram[] diagrams = new Diagram[10];
        for (int i = 0; i < 10; i++) {
            diagrams[i] = new Diagram();
            Dimension dimension = new Dimension();
            dimension.setWidth(500.0);
            dimension.setHeight(500.0);
            diagrams[i].setSize(dimension);

            Point point = new Point();
            point.setX(5);
            point.setY(5);
            diagrams[i].setPosition(point);
        }
        assertEquals(
                "Fail to test Method: createDiagramViews(Diagram[] diagrams).",
                10, (this.viewer.createDiagramViews(diagrams)).length);
        assertEquals(
                "Fail to test Method: createDiagramViews(Diagram[] diagrams).",
                10, (this.viewer.createDiagramViews(diagrams)).length);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: openDiagramView(Diagram diagram).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testOpenDiagramViewAccuary() throws Exception {
        viewer.setTabTitleDisplayedInFullVersion(true);
        assertEquals(
                "Fail to test Method: openDiagramViews(Diagram[] diagrams).",
                view, this.viewer.openDiagramView(diagram));

    }

    /**
     * <p>
     * This is the Accuracy test for Method: closeDiagramView(Diagram diagram).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testCloseDiagramViewAccuary() throws Exception {
        this.viewer.openDiagramView(diagram);
        this.viewer.closeDiagramView(diagram);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: closeCurrentDiagramView().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testCloseCurrentDiagramViewAccuary() throws Exception {
        this.viewer.closeCurrentDiagramView();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getCachedDiagramViews().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetCachedDiagramViewsAccuary() throws Exception {
        Diagram[] diagrams = new Diagram[10];
        for (int i = 0; i < 10; i++) {
            diagrams[i] = new Diagram();
            Dimension dimension = new Dimension();
            dimension.setWidth(500.0);
            dimension.setHeight(500.0);
            diagrams[i].setSize(dimension);

            Point point = new Point();
            point.setX(5);
            point.setY(5);
            diagrams[i].setPosition(point);
        }
        viewer.createDiagramViews(diagrams);
        assertEquals("Fail to get cachedDiagramView", 11, (viewer
                .getCachedDiagramViews()).length);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: addSelectedElement(JComponent
     * element).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testAddSelectedElementAccuary() throws Exception {
        JComponent element = new JScrollBar();
        this.viewer.addSelectedElement(element);
        this.viewer.addSelectedElement(element);
        assertEquals(
                "Fail to Test Method: addSelectedElement(JComponent element)",
                1, this.viewer.getAllSelectedElements().size());
        assertEquals(
                "Fail to Test Method: addSelectedElement(JComponent element)",
                element, (JScrollBar) (this.viewer.getAllSelectedElements()
                        .toArray()[0]));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getAllSelectedElements().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetAllSelectedElementsAccuary() throws Exception {
        for (int i = 0; i < 10; i++) {
            this.viewer.addSelectedElement(new JScrollBar());
        }
        assertEquals(
                "Fail to Test Method: addSelectedElement(JComponent element)",
                10, this.viewer.getAllSelectedElements().size());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: removeSelectedElement(JComponent
     * element).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testRemoveSelectedElementAccuary() throws Exception {
        JComponent element = new JScrollBar();
        this.viewer.addSelectedElement(element);
        assertEquals(
                "Fail to Test Method: removeSelectedElement(JComponent element)",
                1, this.viewer.getAllSelectedElements().size());
        assertEquals(
                "Fail to Test Method: removeSelectedElement(JComponent element)",
                element, (JScrollBar) (this.viewer.getAllSelectedElements()
                        .toArray()[0]));
        this.viewer.removeSelectedElement(element);
        this.viewer.removeSelectedElement(element);
        assertEquals(
                "Fail to Test Method: removeSelectedElement(JComponent element)",
                0, this.viewer.getAllSelectedElements().size());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: isElementSelected(JComponent
     * element).
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testIsSelectedElementAccuary() throws Exception {
        /*
         * JComponent element = new JScrollBar();
         * this.viewer.addSelectedElement(element); assertTrue("Fail to test
         * Method:isElementSelected(JComponent element)",
         * this.viewer.isElementSelected(element));
         * this.viewer.removeSelectedElement(element); assertFalse("Fail to test
         * Method:isElementSelected(JComponent element)",
         * this.viewer.isElementSelected(element));
         */
    }

    /**
     * <p>
     * This is the Accuracy test for Method: showBottomBar().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testShowBottomBarAccuary() throws Exception {
        this.viewer.showBottomBar();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: hideBottomBar().
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testHideBottomBarAccuary() throws Exception {
        this.viewer.hideBottomBar();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramBackgoundColor() .
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetDiagramBackgoundColorAccuary() throws Exception {
        assertEquals("Fail to test Method: getDiagramBackgoundColor() ",
                this.viewer.getDiagramBackgroundColor(), new Color(0x00, 0x00,
                        0x01));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setDiagramBackgoundColor() .
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testSetDiagramBackgoundColorAccuary() throws Exception {
        this.viewer.setDiagramBackgroundColor(Color.red);
        assertEquals("Fail to test Method: setDiagramBackgoundColor() ",
                this.viewer.getDiagramBackgroundColor(), Color.red);

        this.viewer.setDiagramBackgroundColor(Color.white);
        assertEquals("Fail to test Method: setDiagramBackgoundColor() ",
                this.viewer.getDiagramBackgroundColor(), Color.white);

    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomTextFieldAction() .
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetZoomTextFieldActionAccuary() throws Exception {
        assertTrue(
                "Fail to test Method: getZoomTextFieldAction() ",
                this.viewer.getZoomTextFieldAction() instanceof ZoomTextFieldAction);

    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomFactorForCurrentTab() .
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetZoomFactorForCurrentTabAccuary() throws Exception {
        this.viewer.openDiagramView(diagram);
        assertEquals("Fail to test Method: getZoomRotateIncrement() ",
                this.viewer.getZoomFactorForCurrentTab(), 1.0);

    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomRotateIncrement() .
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testGetZoomRotateIncrementAccuary() throws Exception {
        assertEquals("Fail to test Method: getZoomRotateIncrement() ",
                this.viewer.getZoomRotateIncrement(), 5.0);
    }

    /**
     * <p>
     * This class is an implement of <c>ScrollListener</c>, and it is used for
     * testing.
     * </p>
     *
     * @author tianniu
     */
    final class ScrollListenerImpl implements ScrollListener {
        /**
         * <p>
         * Handle the scroll event. The event tells which DiagramView is
         * scrolled.
         * </p>
         *
         * @param event
         *            the scroll event
         */
        public void diagramViewScrolled(ScrollEvent event) {
        }
    }

    /**
     * <p>
     * This class is an implement of <c>ZoomListener</c>, and it is used for testing.
     * </p>
     *
     * @author tianniu
     */
    final class ZoomListenerImpl implements ZoomListener {
        /**
         * <p>
         * Handle the zoom event. The event tells which DiagramView is zoomed, and
         * the new zoom factor.
         * </p>
         *
         * @param event the zoom event
         */
        public void diagramViewZoomed(ZoomEvent event) {
        }
    }

    /**
     * <p>
     * This class is an implement of <c>AddNewElementListener</c>, and it is used for testing.
     * </p>
     *
     * @author tianniu
     */
    final class AddNewElementListenerImpl implements AddNewElementListener {
        /**
         * <p>
         * Invoked when the DiagramViewer has prepared to add new element. Should
         * add the new element to the DiagramView.
         * </p>
         * <p>
         * The DiagramView can be retrieved by event.getSource(), and the type of
         * the new element can be retrieved by event.getNewElementType().
         * </p>
         *
         * @param event the AddNewElementEvent to be registered.
         */
        public void addNewElement(AddNewElementEvent event) {
        }
    }
}
