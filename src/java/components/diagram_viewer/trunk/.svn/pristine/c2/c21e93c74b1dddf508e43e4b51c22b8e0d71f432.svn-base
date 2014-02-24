/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.event.AddNewElementListener;
import com.topcoder.gui.diagramviewer.event.ScrollListener;
import com.topcoder.gui.diagramviewer.event.SelectionHandler;
import com.topcoder.gui.diagramviewer.event.SelectionListener;
import com.topcoder.gui.diagramviewer.event.ZoomListener;

import junit.framework.TestCase;

import java.awt.Color;
import java.awt.Rectangle;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JViewport;


/**
 * <p>
 * Unit test cases for DiagramViewer.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DiagramViewerUnitTests extends TestCase {
    /**
     * The namespace for testing.
     */
    private String namespace1 = "DiagramViewer";

    /**
     * The namespace for testing.
     */
    private String namespace2 = "DiagramViewer_2";

    /**
     * The namespace for testing.
     */
    private String namespace3 = "DiagramViewer_3";

    /**
     * DiagramViewer instance for testing.
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
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the configuration
        UnitTestsHelper.loadConfig("config.xml");
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
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        UnitTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: DiagramViewer(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
    }

    /**
     * <p>
     * This is the accuracy test for constructor: DiagramViewer(String
     * namespace). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2() throws Exception {
        UnitTestsHelper.loadConfig("DiagramViewer.xml");
        viewer = new DiagramViewer(namespace1);
        assertNotNull("Failed to create DiagramViewer instance.", viewer);
        assertEquals("Failed to create DiagramViewer instance.",
            viewer.getMaxOpenTabs(), 50);
        assertEquals("Failed to create DiagramViewer instance.",
            viewer.getTabShortenedTitleMaxLength(), 100);
        assertEquals("Failed to create DiagramViewer instance.",
            viewer.getDiagramBackgroundColor(), Color.white);
    }

    /**
     * <p>
     * This is the failure test for constructor:CloseTabAction(String namespace,
     * DiagramViewer viewer). Failure condition: the namespace is unknown. <br>
     * Expected: ConfigurationException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2WithInValidNamespace() throws Exception {
        try {
            new DiagramViewer("INVALID_NAMESPACE");
            fail("ConfigurationException is excepted.");
        } catch (ConfigurationException e) {
            // pass.
        }

        try {
            UnitTestsHelper.loadConfig("DiagramViewer.xml");
            new DiagramViewer(namespace3);
            fail("ConfigurationException is excepted.");
        } catch (ConfigurationException e) {
            // pass.
        }

        try {
            UnitTestsHelper.loadConfig("DiagramViewer.xml");
            new DiagramViewer(namespace2);
            fail("ConfigurationException is excepted.");
        } catch (ConfigurationException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getMaxOpenTabs().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetMaxOpenTabsAccuracy() throws Exception {
        assertEquals("Fail to getMaxOpenTabs.", 5, this.viewer.getMaxOpenTabs());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setMaxOpenTabs(int maxOpenTabs).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetMaxOpenTabsAccuracy() throws Exception {
        viewer.setMaxOpenTabs(50);
        assertEquals("Fail to setMaxOpenTabs.", 50, this.viewer.getMaxOpenTabs());
    }

    /**
     * <p>
     * This is failure test for Method: setMaxOpenTabs(int maxOpenTabs). <br>
     * Failure condition: maxOpenTabs is non-positive. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetMaxOpenTabsWithNonPositiveMaxOpenTabs()
        throws Exception {
        try {
            this.viewer.setMaxOpenTabs(0);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.setMaxOpenTabs(-213);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: isTabTitleDisplayedInFullVersion().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testIsTabTitleDisplayedInFullVersion()
        throws Exception {
        assertFalse("Fail to call method: isTabTitleDisplayedInFullVersion.",
            viewer.isTabTitleDisplayedInFullVersion());
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * setTabTitleDisplayedInFullVersion().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTabTitleDisplayedInFullVersion()
        throws Exception {
        viewer.setTabTitleDisplayedInFullVersion(true);
        assertEquals("Fail to call method: setTabTitleDisplayedInFullVersion.",
            true, viewer.isTabTitleDisplayedInFullVersion());
        viewer.setTabTitleDisplayedInFullVersion(false);
        assertFalse("Fail to call method: setTabTitleDisplayedInFullVersion.",
            viewer.isTabTitleDisplayedInFullVersion());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getTabShortenedTitleMaxLength().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetTabShortenedTitleMaxLength() throws Exception {
        assertEquals("Fail to call method: getTabShortenedTitleMaxLength().",
            10, viewer.getTabShortenedTitleMaxLength());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setTabShortenedTitleMaxLength(int
     * length).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTabShortenedTitleMaxLength() throws Exception {
        viewer.setTabShortenedTitleMaxLength(24);
        assertEquals("Fail to call method: setTabShortenedTitleMaxLength().",
            24, viewer.getTabShortenedTitleMaxLength());
    }

    /**
     * <p>
     * This is failure test for Method: setTabShortenedTitleMaxLength(int
     * length). <br>
     * Failure condition: length is zero. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTabShortenedTitleMaxLengthWithZeroLength()
        throws Exception {
        try {
            this.viewer.setTabShortenedTitleMaxLength(0);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is failure test for Method: setTabShortenedTitleMaxLength(int
     * length). <br>
     * Failure condition: length is negative. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTabShortenedTitleMaxLengthWithNegativeLength()
        throws Exception {
        try {
            this.viewer.setTabShortenedTitleMaxLength(-21213);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: isBackgroundGridVisible().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testIsBackgroundGridVisible() throws Exception {
        assertTrue("Fail to call method: isBackgroundGridVisible().",
            viewer.isBackgroundGridVisible());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setBackgroundGridVisible().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetBackgroundGridVisible() throws Exception {
        this.viewer.setBackgroundGridVisible(false);
        assertFalse("Fail to call method: setBackgroundGridVisible().",
            viewer.isBackgroundGridVisible());
        this.viewer.setBackgroundGridVisible(true);
        assertTrue("Fail to call method: setBackgroundGridVisible().",
            viewer.isBackgroundGridVisible());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getGridRenderer().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetGridRenderer() throws Exception {
        assertTrue("Fail to call method: getGridRenderer().",
            viewer.getGridRenderer() instanceof GridRenderer);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setGridRenderer(GridRenderer
     * gridRenderer).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetGridRenderer() throws Exception {
        GridRenderer gr = new MockGridRenderer();
        viewer.setGridRenderer(gr);
        assertSame("Fail to call method:  setGridRenderer(GridRenderer gridRenderer).",
            gr, viewer.getGridRenderer());
    }

    /**
     * <p>
     * This is failure test for Method: setGridRenderer(GridRenderer
     * gridRenderer). <br>
     * Failure condition: length is non-positive. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetGridRendererWithNullGridRenderer()
        throws Exception {
        try {
            this.viewer.setGridRenderer(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getNewElementType().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetNewElementType() throws Exception {
        assertNull("Fail to call method: getNewElementType().",
            viewer.getNewElementType());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setNewElementType(Class
     * newElementType).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetNewElementType() throws Exception {
        viewer.setNewElementType(Node.class);
        assertEquals("Fail to call method: setNewElementType().",
            viewer.getNewElementType(), Node.class);
        viewer.setNewElementType(Edge.class);
        assertEquals("Fail to call method: setNewElementType().",
            viewer.getNewElementType(), Edge.class);
        viewer.setNewElementType(NodeContainer.class);
        assertEquals("Fail to call method: setNewElementType().",
            viewer.getNewElementType(), NodeContainer.class);
    }

    /**
     * <p>
     * This is failure test for Method: setNewElementType(Class newElementType).
     * <br>
     * Failure condition: newElementType is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetNewElementTypeWithNullValue() throws Exception {
        try {
            this.viewer.setNewElementType(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is failure test for Method: setNewElementType(Class newElementType).
     * <br>
     * Failure condition: newElementType is not the subclass of Node and Edge.
     * <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetNewElementTypeWithInValidType()
        throws Exception {
        try {
            this.viewer.setNewElementType(Map.class);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getState().
     * </p>
     *
     * @throws Exception when error occurs
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
     * @throws Exception when error occurs
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
            DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE, viewer.getState());
    }

    /**
     * <p>
     * This is failure test for Method: setState(DiagramState state). <br>
     * Failure condition: the state is null. <br>
     * Expected: IllegalStateException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetStateWithNullState() throws Exception {
        try {
            this.viewer.setState(null);
            fail("IllegalStateException is excepted.");
        } catch (IllegalStateException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is failure test for Method: setState(DiagramState state). <br>
     * Failure condition: the newElementType is null when new state is
     * ADD_ELEMENT_BY_CLICK or ADD_ELEMENT_BY_DRAG_RECTANGLE <br>
     * Expected: IllegalStateException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetStateWithNullNewElementType() throws Exception {
        try {
            this.viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
            fail("IllegalStateException is excepted.");
        } catch (IllegalStateException e) {
            // pass.
        }

        try {
            this.viewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
            fail("IllegalStateException is excepted.");
        } catch (IllegalStateException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramViewGap().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramViewGap() throws Exception {
        assertEquals("Fail to call method: getDiagramViewGap().",
            viewer.getDiagramViewGap(), 50);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomInAction().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetZoomInAction() throws Exception {
        assertTrue("Fail to call method: getZoomInAction().",
            viewer.getZoomInAction() instanceof ZoomAction);
        assertSame("Fail to call method: getZoomInAction().",
            viewer.getZoomInAction().getDiagramViewer(), viewer);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomOutAction().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetZoomOutAction() throws Exception {
        assertTrue("Fail to call method: getZoomOutAction().",
            viewer.getZoomOutAction() instanceof ZoomAction);
        assertSame("Fail to call method: getZoomOutAction().",
            viewer.getZoomOutAction().getDiagramViewer(), viewer);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getCloseTabAction().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetCloseTabAction() throws Exception {
        assertTrue("Fail to call method: getCloseTabAction().",
            viewer.getCloseTabAction() instanceof CloseTabAction);
        assertSame("Fail to call method: getCloseTabAction().",
            viewer.getCloseTabAction().getDiagramViewer(), viewer);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getBootomBar().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetBootomBar() throws Exception {
        assertTrue("Fail to call method: getBootomBar().",
            viewer.getBottomBar() instanceof JPanel);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getTextInputBox().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetTextInputBox() throws Exception {
        assertTrue("Fail to call method: getTextInputBox().",
            viewer.getTextInputBox() instanceof TextInputBox);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * addSelectionListener(SelectionListener listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAddSelectionListener() throws Exception {
        SelectionListener listener = new SelectionHandler();
        viewer.addSelectionListener(listener);
        assertEquals("Fail to call method: addSelectionListener(SelectionListener listener).",
            viewer.getListeners(SelectionListener.class)[0], listener);
        assertEquals("Fail to call method: addSelectionListener(SelectionListener listener).",
            viewer.getListeners(SelectionListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * removeSelectionListener(SelectionListener listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testRemoveSelectionListener() throws Exception {
        SelectionListener listener = new SelectionHandler();
        viewer.addSelectionListener(listener);
        assertEquals("Fail to call method: addSelectionListener(SelectionListener listener).",
            viewer.getListeners(SelectionListener.class)[0], listener);
        assertEquals("Fail to call method: addSelectionListener(SelectionListener listener).",
            viewer.getListeners(SelectionListener.class).length, 1);
        viewer.removeSelectionListener(listener);
        assertEquals("Fail to call method: addSelectionListener(SelectionListener listener).",
            viewer.getListeners(SelectionListener.class).length, 0);
        viewer.removeSelectionListener(listener);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * fireSelectionRectangleChange(DiagramView view, Rectangle rectangle).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireSelectionRectangleChange() throws Exception {
        for (int i = 0; i < 10; i++) {
            viewer.addSelectionListener(new SelectionHandler());
        }

        view = viewer.createDiagramView(diagram);

        Rectangle rectangle = new Rectangle();
        this.viewer.fireSelectionRectangleChange(view, rectangle);
        assertEquals("Fail to call method: addSelectionListener(SelectionListener listener).",
            viewer.getListeners(SelectionListener.class).length, 10);
    }

    /**
     * <p>
     * This is failure test for Method: fireSelectionRectangleChange(DiagramView
     * view, Rectangle rectangle). <br>
     * Failure condition: if any arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireSelectionRectangleChangeWithNullValue()
        throws Exception {
        view = viewer.createDiagramView(diagram);

        Rectangle rectangle = new Rectangle();

        try {
            this.viewer.fireSelectionRectangleChange(null, rectangle);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireSelectionRectangleChange(view, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireSelectionRectangleChange(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: addSrollListener(ScrollListener
     * listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAddScrollListener() throws Exception {
        ScrollListener listener = new MockScrollHander();
        viewer.addScrollListener(listener);
        assertEquals("Fail to call method: addScrollListener(ScrollListener listener).",
            viewer.getListeners(ScrollListener.class)[0], listener);
        assertEquals("Fail to call method: addScrollListener(ScrollListener listener).",
            viewer.getListeners(ScrollListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: removeScrollListener(ScrollListener
     * listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testRemoveScrollListener() throws Exception {
        ScrollListener listener = new MockScrollHander();
        viewer.addScrollListener(listener);
        assertEquals("Fail to call method: addScrollListener(ScrollListener listener).",
            viewer.getListeners(ScrollListener.class)[0], listener);
        assertEquals("Fail to call method: addScrollListener(ScrollListener listener).",
            viewer.getListeners(ScrollListener.class).length, 1);
        viewer.removeScrollListener(listener);
        assertEquals("Fail to call method: addScrollListener(ScrollListener listener).",
            viewer.getListeners(ScrollListener.class).length, 0);
        viewer.removeScrollListener(listener);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireScroll(JViewport viewport,
     * Diagram diagram).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireScroll() throws Exception {
        JViewport viewport = new JViewport();

        for (int i = 0; i < 10; i++) {
            viewer.addScrollListener(new MockScrollHander());
        }

        this.viewer.fireScroll(viewport, diagram);
    }

    /**
     * <p>
     * This is failure test for Method: fireScroll(JViewport viewport, Diagram
     * diagram). <br>
     * Failure condition: at least one of the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireScrollWithNullValue() throws Exception {
        JViewport viewport = new JViewport();

        try {
            this.viewer.fireScroll(null, diagram);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireScroll(viewport, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireScroll(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: addZoomListener(ZoomListener
     * listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAddZoomListener() throws Exception {
        ZoomListener listener = new MockZoomHander();
        viewer.addZoomListener(listener);
        assertEquals("Fail to call method: addZoomListener(ZoomListener listener).",
            viewer.getListeners(ZoomListener.class)[0], listener);
        assertEquals("Fail to call method: addZoomListener(ZoomListener listener).",
            viewer.getListeners(ZoomListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: removeZoomListener(ZoomListener
     * listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testRemoveZoomListener() throws Exception {
        ZoomListener listener = new MockZoomHander();
        viewer.addZoomListener(listener);
        assertEquals("Fail to call method: addZoomListener(ZoomListener listener).",
            viewer.getListeners(ZoomListener.class)[0], listener);
        assertEquals("Fail to call method: addZoomListener(ZoomListener listener).",
            viewer.getListeners(ZoomListener.class).length, 1);
        viewer.removeZoomListener(listener);
        assertEquals("Fail to call method: addZoomListener(ZoomListener listener).",
            viewer.getListeners(ZoomListener.class).length, 0);
        viewer.removeZoomListener(listener);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireZoom().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireZoom() throws Exception {
        for (int i = 0; i < 10; i++) {
            viewer.addZoomListener(new MockZoomHander());
        }

        this.viewer.fireZoom(122);
    }

    /**
     * <p>
     * This is failure test for Method: fireZoom. <br>
     * Failure condition: at least one of the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireZoomWithNullValue() throws Exception {
        try {
            new DiagramViewer().fireZoom(2);
            /*
        	 * BugFix: BUGID UML-7149
        	 * Description:
        	 * If there's no zoom panel selected, this method should not throw an
        	 * exception, instead it should do nothing. If the factor increment
        	 * will make the zoom factor not positive, it should be ignored.
        	 */
            // old code
//            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
        	/*
        	 * BugFix: BUGID UML-7149
        	 * Description:
        	 * If there's no zoom panel selected, this method should not throw an
        	 * exception, instead it should do nothing. If the factor increment
        	 * will make the zoom factor not positive, it should be ignored.
        	 */
            // old code
            // pass.
        	fail(e.getMessage());
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * addAddNewElementListener(AddNewElementListener listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAddAddNewElementListener() throws Exception {
        AddNewElementListener listener = new MockAddNewElementHander();
        viewer.addAddNewElementListener(listener);
        assertEquals("Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
            viewer.getListeners(AddNewElementListener.class)[0], listener);
        assertEquals("Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
            viewer.getListeners(AddNewElementListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * removeAddNewElementListener(AddNewElementListener listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testRemoveAddNewElementListener() throws Exception {
        AddNewElementListener listener = new MockAddNewElementHander();
        viewer.addAddNewElementListener(listener);
        assertEquals("Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
            viewer.getListeners(AddNewElementListener.class)[0], listener);
        assertEquals("Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
            viewer.getListeners(AddNewElementListener.class).length, 1);
        viewer.removeAddNewElementListener(listener);
        assertEquals("Fail to call method: addAddNewElementListener(AddNewElementListener listener).",
            viewer.getListeners(AddNewElementListener.class).length, 0);
        viewer.removeAddNewElementListener(listener);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireNewElementAdded(DiagramView
     * diagramView, Class type).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireNewElementAdded() throws Exception {
        for (int i = 0; i < 10; i++) {
            viewer.addAddNewElementListener(new MockAddNewElementHander());
        }

        this.viewer.fireNewElementAdded(view, Node.class);
    }

    /**
     * <p>
     * This is failure test for Method: fireNewElementAdded(DiagramView
     * diagramView, Class type). <br>
     * Failure condition: at least one of the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireNewElementAddedWithNullValue()
        throws Exception {
        Class type = Edge.class;

        try {
            this.viewer.fireNewElementAdded(null, type);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireNewElementAdded(view, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireNewElementAdded(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is failure test for Method: fireNewElementAdded(DiagramView
     * diagramView, Class type). <br>
     * Failure condition: The class type is invalid. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireNewElementAddedWithInvalidClass()
        throws Exception {
        try {
            this.viewer.fireNewElementAdded(view, Map.class);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireNewElementAdded(DiagramView
     * diagramView, Class type, Rectangle bounds).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireNewElementAdded2() throws Exception {
        for (int i = 0; i < 10; i++) {
            viewer.addAddNewElementListener(new MockAddNewElementHander());
        }

        this.viewer.fireNewElementAdded(view, Node.class);
    }

    /**
     * <p>
     * This is failure test for Method: fireNewElementAdded(DiagramView
     * diagramView, Class type, Rectangle bounds). <br>
     * Failure condition: at least one of the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireNewElementAdded2WithNullValue()
        throws Exception {
        Class type = Edge.class;
        Rectangle rectangle = new Rectangle();

        try {
            this.viewer.fireNewElementAdded(null, type, rectangle);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireNewElementAdded(view, null, rectangle);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireNewElementAdded(null, null, rectangle);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireNewElementAdded(view, type, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.viewer.fireNewElementAdded(null, null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is failure test for Method:fireNewElementAdded(DiagramView
     * diagramView, Class type, Rectangle bounds). <br>
     * Failure condition: The class type is invalid. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireNewElementAdded2WithInvalidClass()
        throws Exception {
        try {
            this.viewer.fireNewElementAdded(view, Map.class, new Rectangle());
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: createDiagramView(Diagram diagram).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCreateDiagramViewAccuary() throws Exception {
        for (int i = 0; i < 10; i++) {
            this.viewer.createDiagramView(diagram);
        }

        assertEquals("Fail to create DiagramView", view,
            this.viewer.createDiagramView(diagram));
    }

    /**
     * <p>
     * This is failure test for Method:createDiagramView(Diagram diagram). <br>
     * Failure condition: the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCreateDiagramViewWithNullValue() throws Exception {
        try {
            this.viewer.createDiagramView(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: createDiagramViews(Diagram[]
     * diagrams).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCreateDiagramView2Accuary1() throws Exception {
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

        assertEquals("Fail to test Method: createDiagramViews(Diagram[] diagrams).",
            10, (this.viewer.createDiagramViews(diagrams)).length);
        assertEquals("Fail to test Method: createDiagramViews(Diagram[] diagrams).",
            10, (this.viewer.createDiagramViews(diagrams)).length);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: createDiagramViews(Diagram[]
     * diagrams).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCreateDiagramView2Accuary2() throws Exception {
        assertEquals("Fail to test Method: createDiagramViews(Diagram[] diagrams).",
            0, (this.viewer.createDiagramViews(new Diagram[0])).length);
    }

    /**
     * <p>
     * This is failure test for Method: createDiagramViews(Diagram[] diagrams).
     * <br>
     * Failure condition: the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCreateDiagramView2WithNullValue() throws Exception {
        try {
            this.viewer.createDiagramViews(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is failure test for Method: createDiagramViews(Diagram[] diagrams).
     * <br>
     * Failure condition: the arg contains null elements. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCreateDiagramView2WithNullElement()
        throws Exception {
        Diagram[] diagrams = new Diagram[10];

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                diagrams[i] = null;
            } else {
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
        }

        try {
            this.viewer.createDiagramViews(diagrams);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: openDiagramView(Diagram diagram).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testOpenDiagramViewAccuary() throws Exception {
        viewer.setTabTitleDisplayedInFullVersion(true);
        assertEquals("Fail to test Method: openDiagramViews(Diagram[] diagrams).",
            view, this.viewer.openDiagramView(diagram));
    }

    /**
     * <p>
     * This is failure test for Method: openDiagramView(Diagram diagram). <br>
     * Failure condition: the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testOpenDiagramViewWithNullValue() throws Exception {
        try {
            this.viewer.openDiagramView(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: closeDiagramView(Diagram diagram).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCloseDiagramViewAccuary() throws Exception {
        this.viewer.openDiagramView(diagram);
        this.viewer.closeDiagramView(diagram);
    }

    /**
     * <p>
     * This is failure test for Method: closeDiagramView(Diagram diagram). <br>
     * Failure condition: the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCloseDiagramViewWithNullValue() throws Exception {
        try {
            this.viewer.openDiagramView(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: closeCurrentDiagramView().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCloseCurrentDiagramViewAccuary() throws Exception {
        this.viewer.closeCurrentDiagramView();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getCachedDiagramViews().
     * </p>
     *
     * @throws Exception when error occurs
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
        assertEquals("Fail to get cachedDiagramView", 11,
            (viewer.getCachedDiagramViews()).length);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: addSelectedElement(JComponent
     * element).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAddSelectedElementAccuary() throws Exception {
        JComponent element = new JScrollBar();
        this.viewer.addSelectedElement(element);
        this.viewer.addSelectedElement(element);
        assertEquals("Fail to Test Method: addSelectedElement(JComponent element)",
            1, this.viewer.getAllSelectedElements().size());
        assertEquals("Fail to Test Method: addSelectedElement(JComponent element)",
            element,
            (JScrollBar) (this.viewer.getAllSelectedElements().toArray()[0]));
    }

    /**
     * <p>
     * This is failure test for Method: addSelectedElement(JComponent element).
     * <br>
     * Failure condition: the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAddSelectedElementWithNullValue() throws Exception {
        try {
            this.viewer.addSelectedElement(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getAllSelectedElements().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetAllSelectedElementsAccuary() throws Exception {
        for (int i = 0; i < 10; i++) {
            this.viewer.addSelectedElement(new JScrollBar());
        }

        assertEquals("Fail to Test Method: addSelectedElement(JComponent element)",
            10, this.viewer.getAllSelectedElements().size());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: removeSelectedElement(JComponent
     * element).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testRemoveSelectedElementAccuary() throws Exception {
        JComponent element = new JScrollBar();
        this.viewer.addSelectedElement(element);
        assertEquals("Fail to Test Method: removeSelectedElement(JComponent element)",
            1, this.viewer.getAllSelectedElements().size());
        assertEquals("Fail to Test Method: removeSelectedElement(JComponent element)",
            element,
            (JScrollBar) (this.viewer.getAllSelectedElements().toArray()[0]));
        this.viewer.removeSelectedElement(element);
        this.viewer.removeSelectedElement(element);
        assertEquals("Fail to Test Method: removeSelectedElement(JComponent element)",
            0, this.viewer.getAllSelectedElements().size());
    }

    /**
     * <p>
     * This is failure test for Method: removeSelectedElement(JComponent
     * element). <br>
     * Failure condition: the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testRemoveSelectedElementWithNullValue()
        throws Exception {
        try {
            this.viewer.removeSelectedElement(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: isElementSelected(JComponent
     * element).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testIsSelectedElementAccuary() throws Exception {
        JComponent element = new JScrollBar();
        this.viewer.addSelectedElement(element);
        assertTrue("Fail to test Method:isElementSelected(JComponent element)",
            this.viewer.isElementSelected(element));
        this.viewer.removeSelectedElement(element);
        assertFalse("Fail to test Method:isElementSelected(JComponent element)",
            this.viewer.isElementSelected(element));
    }

    /**
     * <p>
     * This is failure test for Method: isElementSelected(JComponent element).
     * <br>
     * Failure condition: the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testIsSelectedElementWithNullValue() throws Exception {
        try {
            this.viewer.isElementSelected(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: showBottomBar().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testShowBottomBarAccuary() throws Exception {
        this.viewer.showBottomBar();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: hideBottomBar().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testHideBottomBarAccuary() throws Exception {
        this.viewer.hideBottomBar();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramBackgoundColor() .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramBackgoundColorAccuary() throws Exception {
        assertEquals("Fail to test Method: getDiagramBackgoundColor() ",
            this.viewer.getDiagramBackgroundColor(), new Color(0xFE, 0x01, 0xA9));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setDiagramBackgoundColor() .
     * </p>
     *
     * @throws Exception when error occurs
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
     * @throws Exception when error occurs
     */
    public void testGetZoomTextFieldActionAccuary() throws Exception {
        assertTrue("Fail to test Method: getZoomTextFieldAction() ",
            this.viewer.getZoomTextFieldAction() instanceof ZoomTextFieldAction);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomFactorForCurrentTab() .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetZoomFactorForCurrentTabAccuary()
        throws Exception {
        this.viewer.openDiagramView(diagram);
        assertEquals("Fail to test Method: getZoomRotateIncrement() ",
            this.viewer.getZoomFactorForCurrentTab(), 1.0);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getZoomRotateIncrement() .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetZoomRotateIncrementAccuary() throws Exception {
        assertEquals("Fail to test Method: getZoomRotateIncrement() ",
            this.viewer.getZoomRotateIncrement(), 5.0);
    }
}
