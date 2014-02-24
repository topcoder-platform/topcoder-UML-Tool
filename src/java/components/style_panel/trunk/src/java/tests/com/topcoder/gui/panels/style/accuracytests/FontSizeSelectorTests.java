/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.gui.panels.style.accuracytests;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.NAMESPACE;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.gui.panels.style.FontSizeSelector;

/**
 * Unit test for <code>FontSizeSelector</code> class.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FontSizeSelectorTests extends TestCase {
    /**
     * Represents the FontSizeSelector selector used for test.
     */
    private FontSizeSelector selector = null;

    /**
     * Represents the String namespace used for test.
     */
    private String namespace = NAMESPACE;

    /**
     * Represents the List_Integer listFontSize used for test.
     */
    private List<Integer> listFontSize = null;

    /**
     * Represents the int defaultFontSize used for test.
     */
    private int defaultFontSize = 12;

    /**
     * Set up the test environment.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        selector = new FontSizeSelector();
        listFontSize = new ArrayList<Integer>();
        for (int i = 10; i <= 18; i += 2) {
            listFontSize.add(i);
        }
        selector.setListFontSize(listFontSize);
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
     * Accuracy test for the Constructor <code>FontSizeSelector()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testFontSizeSelectorAccuracy() throws Exception {
        FontSizeSelector selector1 = new FontSizeSelector();
        // verify
        assertNotNull("the object should be created", selector1);
    }

    /**
     * Accuracy test for the Constructor <code>FontSizeSelector(String namespace)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testFontSizeSelectorStringAccuracy() throws Exception {
        TestHelper.loadSingleConfigFile();
        FontSizeSelector selector1 = new FontSizeSelector(namespace);
        // verify
        assertNotNull("the object should be created", selector1);
    }

    /**
     * Accuracy test for the Method <code>List_Integer getListFontSize()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetListFontSizeAccuracy() throws Exception {
        selector.setListFontSize(listFontSize);
        List<Integer> l1 = selector.getListFontSize();
        // verify
        assertEquals("the value is wrong", listFontSize, l1);
    }

    /**
     * Accuracy test for the Method <code>int getDefaultFontSize()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetDefaultFontSizeAccuracy() throws Exception {
        selector.setDefaultFontSize(defaultFontSize);
        int int1 = selector.getDefaultFontSize();
        // verify
        assertEquals("the value is wrong", defaultFontSize, int1);
    }

}
