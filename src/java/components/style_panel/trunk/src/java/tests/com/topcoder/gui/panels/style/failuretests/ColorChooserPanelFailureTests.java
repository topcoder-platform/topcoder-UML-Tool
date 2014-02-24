/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import java.io.File;

import javax.swing.JColorChooser;

import com.topcoder.gui.panels.style.ColorChooserPanel;
import com.topcoder.gui.panels.style.StylePanelConfigurationException;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link ColorChooserPanel}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ColorChooserPanelFailureTests extends TestCase {

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#ColorChooserPanel(String)}</code> constructor.
     * </p>
     */
    public void testColorChooserPanelNullNamespace() {
        try {
            new ColorChooserPanel(null);
            fail("expect throw IlegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#ColorChooserPanel(String)}</code> constructor.
     * </p>
     */
    public void testColorChooserPanelEmptyNamespace() {
        try {
            new ColorChooserPanel("");
            fail("expect throw IlegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#ColorChooserPanel(String)}</code> constructor.
     * </p>
     */
    public void testColorChooserPanelTrimmedEmptyNamespace() {
        try {
            new ColorChooserPanel("  ");
            fail("expect throw IlegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#installChooserPanel(JColorChooser)}</code> method.
     * </p>
     */
    public void testInstallChooserPanelRuntimeException() {
        JColorChooser jColorChooser = new JColorChooser();

        ColorChooserPanel colorChooserPanel = new ColorChooserPanel();
        colorChooserPanel.installChooserPanel(jColorChooser);

        try {
            colorChooserPanel.installChooserPanel(jColorChooser);
            fail("expect throw RuntimeException.");
        } catch (RuntimeException e) {
            // expected
        }
    }

    /**
     * <p>
     * assert that the build Chooser method throw StylePanelConfigurationException.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    private void assertBuildChooserStylePanelConfigurationException(String casename) throws Exception {
        FailureTestHelper.loadNamesapces("failuretests" + File.separator + "ColorChooserPanel" + File.separator
            + casename + ".xml");
        String namespace = "" + casename;
        ColorChooserPanel colorChooserPanel = new ColorChooserPanel(namespace);
        try {
            colorChooserPanel.buildChooser();
            fail("expect throw StylePanelConfigurationException.");
        } catch (StylePanelConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase1() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case1");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase2() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case2");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase3() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case3");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase4() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case4");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase5() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case5");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase6() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case6");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase7() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case7");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase8() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case8");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase9() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case9");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase10() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case10");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase11() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case11");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase12() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case12");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase13() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case13");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase14() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case14");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase15() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case15");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase16() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case16");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase17() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case17");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase18() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case18");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase19() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case19");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase20() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case20");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase21() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case21");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase22() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case22");
    }

    /**
     * <p>
     * Failure test for <code>{@link ColorChooserPanel#buildChooser()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testBuildChooserStylePanelConfigurationExceptionCase23() throws Exception {
        assertBuildChooserStylePanelConfigurationException("case23");
    }
}
