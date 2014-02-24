/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.gui.panels.style.styleobject.accuracytests;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.createProp;
import static com.topcoder.gui.panels.style.accuracytests.TestHelper.loadSingleConfigFile;
import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.panels.style.StyleNotSupportedException;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;

/**
 * Unit test for <code>PolylineStyleObjectAdapter</code> class.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PolylineStyleObjectAdapterTests extends TestCase {
    /**
     * Represents the PolylineStyleObjectAdapter adapter used for test.
     */
    private PolylineStyleObjectAdapter adapter = null;

    /**
     * Represents the Polyline polyline used for test.
     */
    private Polyline polyline = null;

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
        panel = new StylePanel();

        polyline = new Polyline();

        polyline.addProperty(createProp("width", "400"));
        polyline.addProperty(createProp("height", "150"));
        polyline.addProperty(createProp("x", "40"));
        polyline.addProperty(createProp("y", "50"));
        polyline.addProperty(createProp("fontName", "Arial"));
        polyline.addProperty(createProp("fontSize", "12"));
        polyline.addProperty(createProp("fillColor", "#00FF00"));
        polyline.addProperty(createProp("outlineColor", "#0000FF"));
        polyline.addProperty(createProp("textColor", "#000000"));

        adapter = new PolylineStyleObjectAdapter(polyline);
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
     * Accuracy test for the Constructor <code>PolylineStyleObjectAdapter(Polyline polyline)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testPolylineStyleObjectAdapterPolylineAccuracy() throws Exception {
        PolylineStyleObjectAdapter adapter1 = new PolylineStyleObjectAdapter(polyline);
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
        try {
            double double1 = adapter.getX();
            fail("should throw StyleNotSupportedException here");
        } catch (StyleNotSupportedException e) {
            // good
        }
    }

    /**
     * Accuracy test for the Method <code>double getY()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetYAccuracy() throws Exception {
        try {
            double double1 = adapter.getY();
            fail("should throw StyleNotSupportedException here");
        } catch (StyleNotSupportedException e) {
            // good
        }
    }

    /**
     * Accuracy test for the Method <code>String getFontName()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFontNameAccuracy() throws Exception {
        try {
            String string1 = adapter.getFontName();
            fail("should throw StyleNotSupportedException here");
        } catch (StyleNotSupportedException e) {
            // good
        }
    }

    /**
     * Accuracy test for the Method <code>int getFontSize()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFontSizeAccuracy() throws Exception {
        try {
            int int1 = adapter.getFontSize();
            fail("should throw StyleNotSupportedException here");
        } catch (StyleNotSupportedException e) {
            // good
        }
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
        try {
            String string1 = adapter.getTextColor();
            fail("should throw StyleNotSupportedException here");
        } catch (StyleNotSupportedException e) {
            // good
        }

    }

}
