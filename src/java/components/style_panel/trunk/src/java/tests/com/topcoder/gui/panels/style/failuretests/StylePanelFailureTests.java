/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.style.StyleListener;
import com.topcoder.gui.panels.style.StyleObject;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.StylePanelConfigurationException;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link StylePanel}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class StylePanelFailureTests extends TestCase {

    /**
     * <p>
     * Represents the cases directory.
     * </p>
     */
    private final String CASE_DIR = "failuretests" + File.separator + "StylePanel" + File.separator;

    /**
     * <p>
     * Represents the {@link StylePanel} instance used in tests.
     * </p>
     */
    private StylePanel stylePanel;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        stylePanel = new StylePanel();
        FailureTestHelper.clearNamespaces();
        FailureTestHelper.loadNamesapces(CASE_DIR + "case0.xml");
        new StylePanel("com.topcoder.gui.panels.style.failuretests.StylePanelFailureTests.case0");
    }

    /**
     * <p>
     * Tear down the testing environment.
     * </p>
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        FailureTestHelper.clearNamespaces();
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     */
    public void testStylePanelStringNullParam() {
        try {
            new StylePanel(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     */
    public void testStylePanelStringEmptyParam() {
        try {
            new StylePanel("");
            fail("expec throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     */
    public void testStylePanelStringTrimmedEmptyParam() {
        try {
            new StylePanel("   ");
            fail("expec throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Assertion for StylePanel constructor.
     * </p>
     * @param casename
     *            the case name
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    private void assertStylePanelConfigurationException(String casename) throws Exception {
        FailureTestHelper.loadNamesapces(CASE_DIR + casename + ".xml");
        try {
            new StylePanel("com.topcoder.gui.panels.style.failuretests.StylePanelFailureTests." + casename);
            fail("expect throw StylePanelConfigurationException");
        } catch (StylePanelConfigurationException e) {
            // expected
        }

    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase1() throws Exception {
        assertStylePanelConfigurationException("case1");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase2() throws Exception {
        assertStylePanelConfigurationException("case2");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase3() throws Exception {
        assertStylePanelConfigurationException("case3");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase4() throws Exception {
        assertStylePanelConfigurationException("case4");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase5() throws Exception {
        assertStylePanelConfigurationException("case5");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase6() throws Exception {
        assertStylePanelConfigurationException("case6");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase7() throws Exception {
        assertStylePanelConfigurationException("case7");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase8() throws Exception {
        assertStylePanelConfigurationException("case8");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase9() throws Exception {
        assertStylePanelConfigurationException("case9");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase10() throws Exception {
        assertStylePanelConfigurationException("case10");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase11() throws Exception {
        assertStylePanelConfigurationException("case11");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase12() throws Exception {
        assertStylePanelConfigurationException("case12");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase13() throws Exception {
        assertStylePanelConfigurationException("case13");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase14() throws Exception {
        assertStylePanelConfigurationException("case14");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase15() throws Exception {
        assertStylePanelConfigurationException("case15");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase16() throws Exception {
        assertStylePanelConfigurationException("case16");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase17() throws Exception {
        assertStylePanelConfigurationException("case17");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase18() throws Exception {
        assertStylePanelConfigurationException("case18");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase19() throws Exception {
        assertStylePanelConfigurationException("case19");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase20() throws Exception {
        assertStylePanelConfigurationException("case20");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase21() throws Exception {
        assertStylePanelConfigurationException("case21");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase22() throws Exception {
        assertStylePanelConfigurationException("case22");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase23() throws Exception {
        assertStylePanelConfigurationException("case23");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase24() throws Exception {
        assertStylePanelConfigurationException("case24");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase25() throws Exception {
        assertStylePanelConfigurationException("case25");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase26() throws Exception {
        assertStylePanelConfigurationException("case26");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase27() throws Exception {
        assertStylePanelConfigurationException("case27");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase28() throws Exception {
        assertStylePanelConfigurationException("case28");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase29() throws Exception {
        assertStylePanelConfigurationException("case29");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase30() throws Exception {
        assertStylePanelConfigurationException("case30");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase31() throws Exception {
        assertStylePanelConfigurationException("case31");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase32() throws Exception {
        assertStylePanelConfigurationException("case32");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase33() throws Exception {
        assertStylePanelConfigurationException("case33");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase34() throws Exception {
        assertStylePanelConfigurationException("case34");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase35() throws Exception {
        assertStylePanelConfigurationException("case35");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase36() throws Exception {
        assertStylePanelConfigurationException("case36");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase37() throws Exception {
        assertStylePanelConfigurationException("case37");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase38() throws Exception {
        assertStylePanelConfigurationException("case38");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase39() throws Exception {
        assertStylePanelConfigurationException("case39");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#StylePanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testStylePanelStringStylePanelConfigurationExceptionCase40() throws Exception {
        assertStylePanelConfigurationException("case40");
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#addStyleListener(StyleListener)}</code> method.
     * </p>
     */
    public void testAddStyleListenerNullListener() {
        try {
            stylePanel.addStyleListener(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setStyleObject(StyleObject)}</code> method.
     * </p>
     */
    public void testSetStyleObjectNullStyleObject() {
        try {
            stylePanel.setStyleObject(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setStyleObjectList(java.util.List)}</code> method.
     * </p>
     */
    public void testSetStyleObjectListNullList() {
        try {
            stylePanel.setStyleObjectList(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setStyleObjectList(java.util.List)}</code> method.
     * </p>
     */
    public void testSetStyleObjectListListContainsNull() {
        List<StyleObject> styleObjectList = new ArrayList<StyleObject>();
        styleObjectList.add(null);
        try {
            stylePanel.setStyleObjectList(styleObjectList);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setFont(java.awt.Font)}</code> method.
     * </p>
     */
    public void testSetFontNullFont() {
        try {
            stylePanel.setFont(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setFontFamilyStyle(String)}</code> method.
     * </p>
     */
    public void testSetFontFamilyStyleNullFontFamilyStyle() {
        try {
            stylePanel.setFontFamilyStyle(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setFontFamilyStyle(String)}</code> method.
     * </p>
     */
    public void testSetFontFamilyStyleEmptyFontFamilyStyle() {
        try {
            stylePanel.setFontFamilyStyle("");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setFontFamilyStyle(String)}</code> method.
     * </p>
     */
    public void testSetFontFamilyStyleTrimmedEmptyFontFamilyStyle() {
        try {
            stylePanel.setFontFamilyStyle("  ");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setFontSizeStyle(int)}</code> method.
     * </p>
     */
    public void testSetFontSizeStyleZeroSize() {
        try {
            stylePanel.setFontSizeStyle(0);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setFontSizeStyle(int)}</code> method.
     * </p>
     */
    public void testSetFontSizeStyleNegativeSize() {
        try {
            stylePanel.setFontSizeStyle(-1);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setFillColorStyle(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetFillColorStyleNullColor() {
        try {
            stylePanel.setFillColorStyle(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setOutlineColorStyle(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetOutlineColorStyleNullColor() {
        try {
            stylePanel.setOutlineColorStyle(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setTextColorStyle(Color)}</code> method.
     * </p>
     */
    public void testSetTextColorStyleNullColor() {
        try {
            stylePanel.setTextColorStyle(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setPositionStyle(Point)}</code> method.
     * </p>
     */
    public void testSetPositionStyleNullPosition() {
        try {
            stylePanel.setPositionStyle(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setPositionStyle(Point)}</code> method.
     * </p>
     */
    public void testSetPositionStyleInvalidX1() {
        Point point = new Point(0, 1);
        try {
            stylePanel.setPositionStyle(point);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setPositionStyle(Point)}</code> method.
     * </p>
     */
    public void testSetPositionStyleInvalidX2() {
        Point point = new Point(-1, 1);
        try {
            stylePanel.setPositionStyle(point);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setPositionStyle(Point)}</code> method.
     * </p>
     */
    public void testSetPositionStyleInvalidY1() {
        Point point = new Point(1, 0);
        try {
            stylePanel.setPositionStyle(point);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setPositionStyle(Point)}</code> method.
     * </p>
     */
    public void testSetPositionStyleInvalidY2() {
        Point point = new Point(1, -1);
        try {
            stylePanel.setPositionStyle(point);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setSizeStyle(Dimension)}</code> method.
     * </p>
     */
    public void testSetSizeStyleNullDimension() {
        try {
            stylePanel.setSizeStyle(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setSizeStyle(Dimension)}</code> method.
     * </p>
     */
    public void testSetSizeStyleInvalidX1() {
        Dimension dimension = new Dimension(0, 1);
        try {
            stylePanel.setSizeStyle(dimension);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setSizeStyle(Dimension)}</code> method.
     * </p>
     */
    public void testSetSizeStyleInvalidX2() {
        Dimension dimension = new Dimension(-1, 1);
        try {
            stylePanel.setSizeStyle(dimension);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setSizeStyle(Dimension)}</code> method.
     * </p>
     */
    public void testSetSizeStyleInvalidY1() {
        Dimension dimension = new Dimension(1, 0);
        try {
            stylePanel.setSizeStyle(dimension);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StylePanel#setSizeStyle(Dimension)}</code> method.
     * </p>
     */
    public void testSetSizeStyleInvalidY2() {
        Dimension dimension = new Dimension(1, -1);
        try {
            stylePanel.setSizeStyle(dimension);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
