/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.swing.print.impl.DefaultPrintFormatRetriever;

/**
 * This class aggregates accuracy tests for DefaultPrintFormatRetriever class.
 *
 * @author ch_music
 * @version 1.0
 */
public class DefaultPrintFormatRetrieverAccuracyTests extends JFCTestCase {

    /**
     * The name for the 'Page Format Setting' button.
     */
    private static String PAGE_FORMAT_SETTING_BUTTON = "PageFormatSettingButton";

    /**
     * The name for the 'Fit In Page' radio button.
     */
    private static String FIT_IN_PAGE_RADIO_BUTTON = "FitInPageRadio";

    /**
     * The name for the 'Split In Grid' radio button.
     */
    private static String SPLIT_IN_GRID_RADIO_BUTTON = "SplitInGridRadio";

    /**
     * The name for the scaling factor text field.
     */
    private static String SCALING_FACTOR_TEXT_FIELD = "ScalingFactorTextField";

    /**
     * The name for the 'OK' button.
     */
    private static String OK_BUTTON = "OkButton";

    /**
     * The DefaultPrintFormatRetriever instance for testing.
     */
    private DefaultPrintFormatRetriever test;

    /**
     * The JFCTestHelper used for testing.
     */
    TestHelper testHelper;

    /**
     * Sets up testing environment.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        test = new DefaultPrintFormatRetriever();
        testHelper = new JFCTestHelper();
    }

    /**
     * Tests that all component required exists.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever1() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, PAGE_FORMAT_SETTING_BUTTON);
        JButton btnPageFormat = (JButton) finder.find(test, 0);
        assertNotNull("The page format button is missing.", btnPageFormat);
    }

    /**
     * Tests that all component required exists.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever2() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, SCALING_FACTOR_TEXT_FIELD);
        JTextField txtScaleFactor = (JTextField) finder.find(test, 0);
        assertNotNull("The scale factor text field is missing.", txtScaleFactor);
    }

    /**
     * Tests that all component required exists.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever3() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, FIT_IN_PAGE_RADIO_BUTTON);
        JRadioButton rdoFitInPage = (JRadioButton) finder.find(test, 0);
        assertNotNull("The fit in page radio button is missing.", rdoFitInPage);
    }

    /**
     * Tests that all component required exists.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever4() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, SPLIT_IN_GRID_RADIO_BUTTON);
        JRadioButton rdoSplitInGrid = (JRadioButton) finder.find(test, 0);
        assertNotNull("The split in grid radio button is missing.", rdoSplitInGrid);
    }

    /**
     * Tests that all component required exists.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever5() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, OK_BUTTON);
        JButton btnOk = (JButton) finder.find(test, 0);
        assertNotNull("The OK button is missing.", btnOk);
    }

    /**
     * Tests that when 'OK' button is pressed, the setting is entered into the instance.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever_DataEnteredCorrectly1() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, FIT_IN_PAGE_RADIO_BUTTON);
        JRadioButton rdoFitInPage = (JRadioButton) finder.find(test, 0);

        testHelper.enterClickAndLeave(new MouseEventData(this, rdoFitInPage));

        finder.setName(SCALING_FACTOR_TEXT_FIELD);
        JTextField txtScaleFactor = (JTextField) finder.find(test, 0);

        txtScaleFactor.setText("1.5");
        txtScaleFactor.requestFocus();
        pressOkButton();

        assertTrue("Fails to set FitInPage to true.", test.isFitSinglePage());
    }

    /**
     * Tests that when 'OK' button is pressed, the setting is entered into the instance.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever_DataEnteredCorrectly2() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, SPLIT_IN_GRID_RADIO_BUTTON);
        JRadioButton rdoSplitInGrid = (JRadioButton) finder.find(test, 0);

        testHelper.enterClickAndLeave(new MouseEventData(this, rdoSplitInGrid));

        finder.setName(SCALING_FACTOR_TEXT_FIELD);
        JTextField txtScaleFactor = (JTextField) finder.find(test, 0);

        txtScaleFactor.setText("1.5");
        txtScaleFactor.requestFocus();
        pressOkButton();

        assertEquals("Fails to set ScaleFactor to correct value.", 1.5, test.getScaleFactor(), 1e-6);
    }

    /**
     * Tests that when 'OK' button is pressed, the setting is entered into the instance.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever_DataEnteredCorrectly3() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, SPLIT_IN_GRID_RADIO_BUTTON);
        JRadioButton rdoSplitInGrid = (JRadioButton) finder.find(test, 0);

        testHelper.enterClickAndLeave(new MouseEventData(this, rdoSplitInGrid));

        finder.setName(SCALING_FACTOR_TEXT_FIELD);
        JTextField txtScaleFactor = (JTextField) finder.find(test, 0);

        txtScaleFactor.setText("1.5");
        txtScaleFactor.requestFocus();
        pressOkButton();

        assertFalse("Fails to set FitInPage to false.", test.isFitSinglePage());
    }

    /**
     * Tests that when 'OK' button is pressed, the setting is entered into the instance.
     *
     * @throws Exception to JUnit
     */
    public void testDefaultPrintFormatRetriever_DataEnteredCorrectly4() throws Exception {
        test.setModal(false);
        test.retrievePrintFormat();

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, SPLIT_IN_GRID_RADIO_BUTTON);
        JRadioButton rdoSplitInGrid = (JRadioButton) finder.find(test, 0);

        testHelper.enterClickAndLeave(new MouseEventData(this, rdoSplitInGrid));

        finder.setName(SCALING_FACTOR_TEXT_FIELD);
        JTextField txtScaleFactor = (JTextField) finder.find(test, 0);

        txtScaleFactor.requestFocusInWindow();
        txtScaleFactor.setText("1.5");
        pressOkButton();

        assertNotNull("Fails to set pageFormat.", test.getPageFormat());
    }

    /**
     * Presses the 'OK' button.
     *
     * @throws Exception to JUnit
     */
    private void pressOkButton() throws Exception {
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, OK_BUTTON);
        JButton btnOk = (JButton) finder.find(test, 0);
        testHelper.enterClickAndLeave(new MouseEventData(this, btnOk));
    }
}
