/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.stresstests;

import junit.framework.TestCase;
import java.io.File;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import java.awt.Dimension;
import java.awt.Point;

/**
 * <p>
 * Stress test case for StylePane clas.
 * </p>
 * 
 * @author cmax
 * @version 1.0
 */
public class StylePaneStressTest extends TestCase {

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
     * Stress test of StylePane constructor with namespace parameter.
     * </p>
     * 
     * @throws Exception to JUnit
     */
    public void testStylePane() throws Exception {
        int i;

        long start = System.currentTimeMillis();

        for (i = 0; i < SMALL; i++) {
            new StylePanel(NAMESPACE);
        }

        System.out.println("Creating " + SMALL + " StylePanes with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < MIDDLE; i++) {
            new StylePanel(NAMESPACE);
        }

        System.out.println("Creating " + MIDDLE + " StylePanes with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < LARGE; i++) {
            new StylePanel(NAMESPACE);
        }

        System.out.println("Creating " + LARGE + " StylePanes with namespace will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

    }

    /**
     * <p>
     * Stress test of setStyleObject method.
     * </p>
     *  
     */
    public void testSetStyleObject() {
        StylePanel stylePanel = new StylePanel(NAMESPACE);

        int i;

        long start = System.currentTimeMillis();

        for (i = 0; i < SMALL; i++) {
            stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(TestHelper.createGraphNode(stylePanel)));
        }

        System.out.println("Setting " + SMALL + " style objects will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < MIDDLE; i++) {
            stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(TestHelper.createGraphNode(stylePanel)));
        }

        System.out.println("Setting " + MIDDLE + " style objects will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < LARGE; i++) {
            stylePanel.setStyleObject(new GraphNodeStyleObjectAdapter(TestHelper.createGraphNode(stylePanel)));
        }

        System.out.println("Setting " + LARGE + " style objects will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");

    }

    /**
     * <p>
     * Stress test for the setSizeStyle method.
     * </p>
     *
     */
    public void testSetSizeStyle() {
        StylePanel stylePanel = new StylePanel(NAMESPACE);

        int i;

        for (i = 0; i < 100;i ++){
            stylePanel.addStyleListener(new StyleListenerImpl());
        }
        
        long start = System.currentTimeMillis();

        for (i = 1; i <= SMALL; i++) {
            stylePanel.setSizeStyle(new Dimension(i, i));
        }

        System.out.println("Setting " + SMALL + " Dimension will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 1; i <= MIDDLE; i++) {
            stylePanel.setSizeStyle(new Dimension(i, i));
        }

        System.out.println("Setting " + MIDDLE + " Dimension will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");
        
        start = System.currentTimeMillis();

        for (i = 1; i <= LARGE; i++) {
            stylePanel.setSizeStyle(new Dimension(i, i));
        }

        System.out.println("Setting " + LARGE + " Dimension will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");
    }
    
    /**
     * <p>
     * Stress test for the setPositionStyle method.
     * </p>
     *
     */
    public void testSetPositionStyle() {
        StylePanel stylePanel = new StylePanel(NAMESPACE);

        int i;

        for (i = 0; i < 100;i ++){
            stylePanel.addStyleListener(new StyleListenerImpl());
        }
        
        long start = System.currentTimeMillis();

        for (i = 1; i <= SMALL; i++) {
            stylePanel.setPositionStyle(new Point(i, i));
        }

        System.out.println("Setting " + SMALL + " Position will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 1; i <= MIDDLE; i++) {
            stylePanel.setPositionStyle(new Point(i, i));
        }

        System.out.println("Setting " + MIDDLE + " Position will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");
        
        start = System.currentTimeMillis();

        for (i = 1; i <= LARGE; i++) {
            stylePanel.setPositionStyle(new Point(i, i));
        }

        System.out.println("Setting " + LARGE + " Position will cost " + (System.currentTimeMillis() - start)
                + " milliseconds.");
    }
}