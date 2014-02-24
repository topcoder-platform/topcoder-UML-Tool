/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.gui.panels.style.styleobject.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.panels.style.StyleNotSupportedException;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.*;

/**
 * Unit test for <code>GraphEdgeStyleObjectAdapter</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphEdgeStyleObjectAdapterTests extends TestCase {
    /**
     * Represents the GraphEdgeStyleObjectAdapter adapter used for test.
     */
    private GraphEdgeStyleObjectAdapter adapter = null;

    /**
     * Represents the GraphEdge graphEdge used for test.
     */
    private GraphEdge graphEdge = null;

    /**
     * Represents the StylePanel panel used for test.
     */
    private StylePanel panel = null;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        loadSingleConfigFile();
        panel = new StylePanel(NAMESPACE);

        graphEdge = new GraphEdge();
        Point point = new Point();
        point.setX(40.0);
        point.setY(50.0);
        graphEdge.setPosition(point);
        graphEdge.addProperty(createProp("fontName", "Arial"));
        graphEdge.addProperty(createProp("fontSize", "12"));
        graphEdge.addProperty(createProp("fillColor", "#00FF00"));
        graphEdge.addProperty(createProp("outlineColor", "#0000FF"));
        graphEdge.addProperty(createProp("textColor", "#000000"));

        adapter = new GraphEdgeStyleObjectAdapter(graphEdge);
        adapter.setStylePanel(panel);
    }

    /**
     * Tear down the test environment.
     *
     * @throws Exception
     *             if any error occurred when tear down
     */
    public void tearDown() throws Exception {
    }

    /**
     * Accuracy test for the Constructor
     * <code>GraphEdgeStyleObjectAdapter(GraphEdge graphEdge)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGraphEdgeStyleObjectAdapterGraphEdgeAccuracy() throws Exception {
        GraphEdgeStyleObjectAdapter adapter1 = new GraphEdgeStyleObjectAdapter(graphEdge);
        // verify
        assertNotNull("the object should be created", adapter1);
    }

    /**
     * Accuracy test for the Method <code>double getHeight()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetHeightAccuracy() throws Exception {
        try {
            double double1 = adapter.getHeight();
            fail("should throw StyleNotSupportedException here");
        } catch (StyleNotSupportedException e) {
            // good
        }
    }

    /**
     * Accuracy test for the Method <code>double getWidth()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetWidthAccuracy() throws Exception {
        try {
            double double1 = adapter.getWidth();
            fail("should throw StyleNotSupportedException here");
        } catch (StyleNotSupportedException e) {
            // good
        }
    }

    /**
     * Accuracy test for the Method <code>double getX()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetXAccuracy() throws Exception {
        double double1 = adapter.getX();
        // verify
        assertEquals("the value is wrong", 40.0, double1);
    }

    /**
     * Accuracy test for the Method <code>double getY()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetYAccuracy() throws Exception {
        double double1 = adapter.getY();
        // verify
        assertEquals("the value is wrong", 50.0, double1);
    }

    /**
     * Accuracy test for the Method <code>String getFontName()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFontNameAccuracy() throws Exception {
        String string1 = adapter.getFontName();
        // verify
        assertEquals("the value is wrong", "Arial", string1);
    }

    /**
     * Accuracy test for the Method <code>int getFontSize()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFontSizeAccuracy() throws Exception {
        int int1 = adapter.getFontSize();
        // verify
        assertEquals("the value is wrong", 12, int1);
    }

    /**
     * Accuracy test for the Method <code>String getFillColor()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFillColorAccuracy() throws Exception {
        try {
            String string1 = adapter.getFillColor();
            fail("should throw StyleNotSupportedException here");
        } catch (StyleNotSupportedException e) {
            // good
        }
    }

    /**
     * Accuracy test for the Method <code>String getOutlineColor()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetOutlineColorAccuracy() throws Exception {
        String string1 = adapter.getOutlineColor();
        // verify
        assertEquals("the value is wrong", "#0000FF", string1);
    }

    /**
     * Accuracy test for the Method <code>String getTextColor()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetTextColorAccuracy() throws Exception {
        String string1 = adapter.getTextColor();
        // verify
        assertEquals("the value is wrong", "#000000", string1);
    }

}
