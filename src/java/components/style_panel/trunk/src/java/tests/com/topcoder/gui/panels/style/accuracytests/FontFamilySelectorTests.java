/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.gui.panels.style.accuracytests;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.NAMESPACE;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.gui.panels.style.FontFamilySelector;

/**
 * Unit test for <code>FontFamilySelector</code> class.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FontFamilySelectorTests extends TestCase {
    /**
     * Represents the FontFamilySelector selector used for test.
     */
    private FontFamilySelector selector = null;

    /**
     * Represents the String namespace used for test.
     */
    private String namespace = NAMESPACE;

    /**
     * Represents the List_String listFontFamily used for test.
     */
    private List<String> listFontFamily;

    /**
     * Represents the String defaultFontFamily used for test.
     */
    private String defaultFontFamily = "Arial";

    /**
     * Set up the test environment.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        listFontFamily = new ArrayList<String>();
        listFontFamily.add("Arial");
        listFontFamily.add("Morden");
        listFontFamily.add("Times");
        listFontFamily.add("Roman");

        selector = new FontFamilySelector();
        selector.setListFontFamily(listFontFamily);

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
     * Accuracy test for the Constructor <code>FontFamilySelector()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testFontFamilySelectorAccuracy() throws Exception {
        FontFamilySelector selector1 = new FontFamilySelector();
        // verify
        assertNotNull("the object should be created", selector1);
    }

    /**
     * Accuracy test for the Constructor <code>FontFamilySelector(String namespace)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testFontFamilySelectorStringAccuracy() throws Exception {
        TestHelper.loadSingleConfigFile();
        FontFamilySelector selector1 = new FontFamilySelector(namespace);
        // verify
        assertNotNull("the object should be created", selector1);
    }

    /**
     * Accuracy test for the property <code>List_String ListFontFamily</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetListFontFamilyAccuracy() throws Exception {
        selector.setListFontFamily(listFontFamily);
        List<String> l1 = selector.getListFontFamily();
        // verify
        assertEquals("the value is wrong", listFontFamily, l1);
    }

    /**
     * Accuracy test for the property <code>String DefaultFontFamily</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetDefaultFontFamilyAccuracy() throws Exception {
        selector.setDefaultFontFamily(defaultFontFamily);
        String string1 = selector.getDefaultFontFamily();
        // verify
        assertEquals("the value is wrong", defaultFontFamily, string1);
    }

}
