/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.gui.panels.style.styleobject.accuracytests;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.createProp;
import static com.topcoder.gui.panels.style.accuracytests.TestHelper.loadSingleConfigFile;
import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.*;

/**
 * Unit test for <code>GraphNodeStyleObjectAdapter</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphNodeStyleObjectAdapterTests extends TestCase {
    /**
     * Represents the GraphNodeStyleObjectAdapter adapter used for test.
     */
    private GraphNodeStyleObjectAdapter adapter = null;

    /**
     * Represents the GraphNode graphNode used for test.
     */
    private GraphNode graphNode = null;

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

        graphNode = new GraphNode();
        Point point = new Point();
        point.setX(40.0);
        point.setY(50.0);
        graphNode.setPosition(point);
        Dimension dimension = new Dimension();
        dimension.setHeight(150.0);
        dimension.setWidth(400.0);
        graphNode.setSize(dimension);
        graphNode.addProperty(createProp("fontName", "Arial"));
        graphNode.addProperty(createProp("fontSize", "12"));
        graphNode.addProperty(createProp("fillColor", "#00FF00"));
        graphNode.addProperty(createProp("outlineColor", "#0000FF"));
        graphNode.addProperty(createProp("textColor", "#000000"));

        adapter = new GraphNodeStyleObjectAdapter(graphNode);
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
     * <code>GraphNodeStyleObjectAdapter(GraphNode graphNode)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGraphNodeStyleObjectAdapterGraphNodeAccuracy() throws Exception {
        GraphNodeStyleObjectAdapter adapter1 = new GraphNodeStyleObjectAdapter(graphNode);
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
        double double1 = adapter.getHeight();
        // verify
        assertEquals("the value is wrong", 150.0, double1);
    }

    /**
     * Accuracy test for the Method <code>double getWidth()</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetWidthAccuracy() throws Exception {
        double double1 = adapter.getWidth();
        // verify
        assertEquals("the value is wrong", 400.0, double1);
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
        String string1 = adapter.getFillColor();
        // verify
        assertEquals("the value is wrong", "#00FF00", string1);
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
