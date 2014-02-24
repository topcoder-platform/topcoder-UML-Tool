/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.stresstests;

import java.io.File;

import com.topcoder.gui.panels.style.FontSizeSelector;
import com.topcoder.gui.panels.style.StylePanel;
import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * Stress test case for FontSizeSelector clas.
 * </p>
 * 
 * @author cmax
 * @version 1.0
 */
public class FontSizeSelectorStressTest extends TestCase {
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
     * Stress test of FontSizeSelector constructor with namespace parameter.
     * </p>
     * 
     * @throws Exception to JUnit
     */
    public void testFontSizeSelector() throws Exception {
        int i;

        long start = System.currentTimeMillis();

        for (i = 0; i < SMALL; i++) {
            new FontSizeSelector(NAMESPACE);
        }

        System.out.println("Creating " + SMALL + " FontSizeSelectors with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < MIDDLE; i++) {
            new FontSizeSelector(NAMESPACE);
        }

        System.out.println("Creating " + MIDDLE + " FontSizeSelectors with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < LARGE; i++) {
            new FontSizeSelector(NAMESPACE);
        }

        System.out.println("Creating " + LARGE + " FontSizeSelectors with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

    }
    
    /**
     * <p>
     * Stress test for setListFontSize method.
     * </p>
     *
     */
    public void testSetListFontSize() {
        FontSizeSelector selector = new FontSizeSelector();
        
        int i;
        List<Integer> list = new ArrayList<Integer>();
        
        for (i = 1; i<= SMALL;i++)
        {
            list.add(new Integer(i));
        }
        
        long start = System.currentTimeMillis();
        selector.setListFontSize(list);
        System.out.println("Setting " + SMALL + " Font sizes will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        list.clear();
        
        for (i = 1; i<= MIDDLE;i++)
        {
            list.add(new Integer(i));
        }
        
        start = System.currentTimeMillis();
        selector.setListFontSize(list);
        System.out.println("Setting " + MIDDLE + " Font sizes will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        list.clear();
        
        for (i = 1; i<= LARGE;i++)
        {
            list.add(new Integer(i));
        }
        
        start = System.currentTimeMillis();
        selector.setListFontSize(list);
        System.out.println("Setting " + LARGE + " Font sizes will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

    }
}