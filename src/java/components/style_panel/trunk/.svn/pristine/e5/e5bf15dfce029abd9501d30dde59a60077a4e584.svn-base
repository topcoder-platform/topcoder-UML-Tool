/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.stresstests;

import java.io.File;

import com.topcoder.gui.panels.style.FontFamilySelector;
import com.topcoder.gui.panels.style.StylePanel;
import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * Stress test case for FontFamilySelector class.
 * </p>
 * 
 * @author cmax
 * @version 1.0
 */
public class FontFamilySelectorStressTest extends TestCase {
    
    /**
     * <p>
     * The sample configuration file for this component.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files" + File.separator + "stresstests" + File.separator
            + "config.xml";

    /**
     * <p>
     * The namespace used for this component.
     * </p>
     */
    public static final String NAMESPACE = StylePanel.class.getName();
    
	/**
     * <p>
     * Represents the smal scale of stress test.
     * </p>
     */
    private final int SMALL = 10;

    /**
     * <p>
     * Represents the middle scale of stress test.
     * </p>
     */
    private final int MIDDLE = 100;

    /**
     * <p>
     * Represents the large scale of stress test.
     * </p>
     */
    private final int LARGE = 1000;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * 
     * @throws Exception to JUnit
     *  
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, CONFIG_FILE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * 
     * @throws Exception to JUnit
     *  
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(NAMESPACE);
    }

    /**
     * <p>
     * Stress test of FontFamilySelector constructor with namespace parameter.
     * </p>
     * 
     * @throws Exception to JUnit
     */
    public void testFontFamilySelector() throws Exception {
        int i;

        long start = System.currentTimeMillis();

        for (i = 0; i < SMALL; i++) {
            new FontFamilySelector(NAMESPACE);
        }

        System.out.println("Creating " + SMALL + " FontFamilySelectors with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < MIDDLE; i++) {
            new FontFamilySelector(NAMESPACE);
        }

        System.out.println("Creating " + MIDDLE + " FontFamilySelectors with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < LARGE; i++) {
            new FontFamilySelector(NAMESPACE);
        }

        System.out.println("Creating " + LARGE + " FontFamilySelectors with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

    }
    
    /**
     * <p>
     * Stress test for setListFontSize method.
     * </p>
     *
     */
    public void testSetListFontSize() {
        FontFamilySelector selector = new FontFamilySelector();
        
        int i;
        List<String> list = new ArrayList<String>();
        
        for (i = 1; i<= SMALL; i++) {
            list.add(i + "");
        }
        
        long start = System.currentTimeMillis();
        selector.setListFontFamily(list);
        System.out.println("Setting " + SMALL + " Font sizes will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        list.clear();
        
        for (i = 1; i<= MIDDLE; i++) {
            list.add(i + "");
        }
        
        start = System.currentTimeMillis();
        selector.setListFontFamily(list);
        System.out.println("Setting " + MIDDLE + " Font sizes will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        list.clear();
        
        for (i = 1; i<= LARGE; i++) {
            list.add(i + "");
        }
        
        start = System.currentTimeMillis();
        selector.setListFontFamily(list);
        System.out.println("Setting " + LARGE + " Font sizes will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

    }
}