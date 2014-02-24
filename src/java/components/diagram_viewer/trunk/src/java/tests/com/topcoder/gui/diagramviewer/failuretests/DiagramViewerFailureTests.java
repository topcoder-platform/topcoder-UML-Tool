/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests;

import java.awt.Rectangle;
import java.util.Iterator;

import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.gui.diagramviewer.ConfigurationException;

import junit.framework.TestCase;

/**
 * Failure tests for DiagramViewer class.
 *
 * @author Yeung
 * @version 1.0
 */
public class DiagramViewerFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private DiagramViewer viewer;

    /**
     * This instance is used in the test.
     */
    private DiagramView view;

    /**
     * Sets up the test environment.
     *
     * @throws Exception if any error occurred when set up
     */
    protected void setUp() throws Exception {
        tearDown();
        // get the config manager
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("failure/config.xml");

        viewer = new DiagramViewer();
    }

    /**
     * Tears down the test environment.
     *
     * @throws Exception if any error occurred when tear down
     */
    protected void tearDown() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator iter = manager.getAllNamespaces(); iter.hasNext();) {
            manager.removeNamespace((String) iter.next());
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with null namespace, expected
     * IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_NullNamespace() throws Exception {
        try {
            new DiagramViewer(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with empty namespace,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_EmptyNamespace1() throws Exception {
        try {
            new DiagramViewer("");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with empty namespace,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_EmptyNamespace2() throws Exception {
        try {
            new DiagramViewer(" \t \n ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace0() throws Exception {
        try {
            new DiagramViewer("invalid");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace1() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidObjectFactoryNamespace");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace3() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidMaxOpenTabs");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace4() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.NegativeMaxOpenTabs");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace5() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.ZeroMaxOpenTabs");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace6() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidBackgroundGridVisibility");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace7() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidTabTitleDisplayedInFullVersion");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace8() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidDiagramViewBackgroundColor");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace9() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidGridRenderer");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace10() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidDiagramViewGap");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace11() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidDiagramViewCache");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace12() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidZoomRotateIncrement");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace13() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidZoomInActionNamespace");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace14() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidZoomOutActionNamespace");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace15() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.InvalidCloseTabActionNamespace");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace16() throws Exception {
        try {
            new DiagramViewer("failuretests.InvalidTabShortenedTitleMaxLength");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace17() throws Exception {
        try {
            new DiagramViewer("failuretests.ZeroTabShortenedTitleMaxLength");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace18() throws Exception {
        try {
            new DiagramViewer("failuretests.NegativeTabShortenedTitleMaxLength");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor DiagramViewer(String) with invalid namespace,
     * expected ConfigurationException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCtor_InvalidNamespace19() throws Exception {
        try {
            new DiagramViewer("failuretests.DiagramViewer.NegativeDiagramViewGap");
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the method addSelectedElement(JComponent) with null element,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testAddSelectedElement_NullElement() throws Exception {
        try {
            viewer.addSelectedElement(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method createDiagramView(Diagram) with null diagram, expected
     * IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCreateDiagramView_NullDiagram() throws Exception {
        try {
            viewer.createDiagramView(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method createDiagramViews(Diagram) with null diagrams, expected
     * IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testCreateDiagramViews_NullDiagrams() throws Exception {
        try {
            viewer.createDiagramViews(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireNewElementAdded(DiagramView, Class) with null
     * diagramView, expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireNewElementAdded_NullDiagramView() throws Exception {
        try {
            viewer.fireNewElementAdded(null, Node.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireNewElementAdded(DiagramView, Class) with null type,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireNewElementAdded_NullType() throws Exception {
        try {
            viewer.fireNewElementAdded(view, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireNewElementAdded(DiagramView, Class) with invalid
     * type, expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireNewElementAdded_InvalidType() throws Exception {
        try {
            viewer.fireNewElementAdded(view, String.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireNewElementAdded(DiagramView, Class, Rectangle) with
     * null bounds, expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireNewElementAdded_NullBounds() throws Exception {
        try {
            viewer.fireNewElementAdded(view, Node.class, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireNewElementAdded(DiagramView, Class, Rectangle) with
     * null diagramView, expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireNewElementAdded_NullDiagramView2() throws Exception {
        try {
            viewer.fireNewElementAdded(null, Node.class, new Rectangle());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireNewElementAdded(DiagramView, Class, Rectangle) with
     * null type, expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireNewElementAdded_NullType2() throws Exception {
        try {
            viewer.fireNewElementAdded(view, null, new Rectangle());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireNewElementAdded(DiagramView, Class, Rectangle) with
     * invalid type, expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireNewElementAdded_InvalidType2() throws Exception {
        try {
            viewer.fireNewElementAdded(view, String.class, new Rectangle());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireScroll(JViewport, Diagram) with null viewport,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireScroll_NullViewport() throws Exception {
        try {
            viewer.fireScroll(null, new Diagram());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireScroll(JViewport, Diagram) with null diagram,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireScroll_NullDiagram() throws Exception {
        try {
            viewer.fireScroll(new JViewport(), null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireSelectionRectangleChange(DiagramView, Rectangle)
     * with null view, expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireSelectionRectagleChange_NullView() throws Exception {
        try {
            viewer.fireSelectionRectangleChange(null, new Rectangle());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireSelectionRectangleChange(DiagramView, Rectangle)
     * with null rectangle, expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireSelectionRectagleChange_NullRectangle() throws Exception {
        try {
            viewer.fireSelectionRectangleChange(view, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method fireZoom(int) with null zoomPane, expected
     * IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testFireSelectionRectagleChange_NullZoomPane() throws Exception {
        try {
            viewer.fireZoom(10);
            /*
        	 * BugFix: BUGID UML-7149
        	 * Description:
        	 * If there's no zoom panel selected, this method should not throw an
        	 * exception, instead it should do nothing. If the factor increment
        	 * will make the zoom factor not positive, it should be ignored.
        	 */
            // old code
//            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
        	/*
        	 * BugFix: BUGID UML-7149
        	 * Description:
        	 * If there's no zoom panel selected, this method should not throw an
        	 * exception, instead it should do nothing. If the factor increment
        	 * will make the zoom factor not positive, it should be ignored.
        	 */
            // old code
            // expect
        	fail(iae.getMessage());
        }
    }

    /**
     * Tests the method isElementSelected(JComponent) with null element,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testIsElementSelected_NullElement() throws Exception {
        try {
            viewer.isElementSelected(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method openDiagramView(Diagram) with null diagram, expected
     * IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testOpenDiagramView_NullDiagram() throws Exception {
        try {
            viewer.openDiagramView(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method removeSelectedElement(JComponent) with null element,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testRemoveSelectedElement_NullElement() throws Exception {
        try {
            viewer.removeSelectedElement(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setDiagramBackgroundColor(Color) with null color,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetDiagramBackgroundColor_NullColor() throws Exception {
        try {
            viewer.setDiagramBackgroundColor(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setGridRenderer(GridRenderer) with null gridRenderer,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetGridRenderer_NullGridRenderer() throws Exception {
        try {
            viewer.setGridRenderer(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setMaxOpenTabs(int) with zero maxOpenTabs, expected
     * IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetMaxOpenTabs_ZeroMaxOpenTabs() throws Exception {
        try {
            viewer.setMaxOpenTabs(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setMaxOpenTabs(int) with negative maxOpenTabs, expected
     * IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetMaxOpenTabs_NegativeMaxOpenTabs() throws Exception {
        try {
            viewer.setMaxOpenTabs(-1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setNewElementType(Class) with null newElementType,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetNewElementType_NullNewElementType() throws Exception {
        try {
            viewer.setNewElementType(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setState(DiagramState) with null state, expected
     * IllegalStateException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetState_NullState() throws Exception {
        try {
            viewer.setState(null);
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException ise) {
            // expect
        }
    }

    /**
     * Tests the method setState(DiagramState) with ADD_ELEMENT_BY_CLICK state
     * when newElementType is null, expected IllegalStateException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetState_NullNewElementType_AddElementByClickState() throws Exception {
        try {
            viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException ise) {
            // expect
        }
    }

    /**
     * Tests the method setState(DiagramState) with
     * ADD_ELEMENT_BY_DRAGGING_RECTANGLE state when newElementType is null,
     * expected IllegalStateException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetState_NullNewElementType_AddElementByDraggingRectangleState() throws Exception {
        try {
            viewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException ise) {
            // expect
        }
    }

    /**
     * Tests the method setTabShortenedTitleMaxLength(int) with zero length,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetTabShortenedTitleMaxLength_ZeroLength() throws Exception {
        try {
            viewer.setTabShortenedTitleMaxLength(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setTabShortenedTitleMaxLength(int) with negative length,
     * expected IllegalArgumentException.
     *
     * @throws Exception if any error occurred when set up
     */
    public void testSetTabShortenedTitleMaxLength_NegativeLength() throws Exception {
        try {
            viewer.setTabShortenedTitleMaxLength(-1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}
