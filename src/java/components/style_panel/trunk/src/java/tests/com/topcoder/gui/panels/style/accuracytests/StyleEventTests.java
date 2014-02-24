/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.gui.panels.style.accuracytests;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.createProp;
import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.panels.style.*;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;

/**
 * Unit test for <code>StyleEvent</code> class.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StyleEventTests extends TestCase {
    /**
     * Represents the StyleEvent event used for test.
     */
    private StyleEvent event = null;

    /**
     * Represents the StyleObject styleObject used for test.
     */
    private StyleObject styleObject = null;

    /**
     * Represents the String changedKey used for test.
     */
    private String changedKey = "fontName";

    /**
     * Represents the String oldValue used for test.
     */
    private String oldValue = "Arial";

    /**
     * Represents the String newValue used for test.
     */
    private String newValue = "Roman";

    /**
     * Set up the test environment.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        GraphEdge graphEdge = new GraphEdge();

        graphEdge.addProperty(createProp("width", "400"));
        graphEdge.addProperty(createProp("height", "150"));
        graphEdge.addProperty(createProp("x", "40"));
        graphEdge.addProperty(createProp("y", "50"));
        graphEdge.addProperty(createProp("fontName", "Arial"));
        graphEdge.addProperty(createProp("fontSize", "12"));
        graphEdge.addProperty(createProp("fillColor", "#00FF00"));
        graphEdge.addProperty(createProp("outlineColor", "#0000FF"));
        graphEdge.addProperty(createProp("textColor", "#000000"));

        styleObject = new GraphEdgeStyleObjectAdapter(graphEdge);
        event = new StyleEvent(styleObject, changedKey, oldValue, newValue);
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
     * <code>StyleEvent(StyleObject styleObject,String changedKey,String oldValue,String newValue)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testStyleEventStyleObjectStringStringStringAccuracy() throws Exception {
        StyleEvent event1 = new StyleEvent(styleObject, changedKey, oldValue, newValue);
        // verify
        assertNotNull("the object should be created", event1);
    }

    /**
     * Accuracy test for the Method <code>StyleObject getStyleObject()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetStyleObjectAccuracy() throws Exception {
        StyleObject object1 = event.getStyleObject();
        // verify
        assertEquals("the value is wrong", styleObject, object1);
    }

    /**
     * Accuracy test for the Method <code>String getChangedKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetChangedKeyAccuracy() throws Exception {
        String string1 = event.getChangedKey();
        // verify
        assertEquals("the value is wrong", changedKey, string1);
    }

    /**
     * Accuracy test for the Method <code>String getOldValue()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetOldValueAccuracy() throws Exception {
        String string1 = event.getOldValue();
        // verify
        assertEquals("the value is wrong", oldValue, string1);
    }

    /**
     * Accuracy test for the Method <code>String getNewValue()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetNewValueAccuracy() throws Exception {
        String string1 = event.getNewValue();
        // verify
        assertEquals("the value is wrong", newValue, string1);
    }

}
