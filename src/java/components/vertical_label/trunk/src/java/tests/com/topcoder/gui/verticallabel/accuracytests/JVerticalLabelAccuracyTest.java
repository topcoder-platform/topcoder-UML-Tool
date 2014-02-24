/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel.accuracytests;

import com.topcoder.gui.verticallabel.JVerticalLabel;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy Tests for {@link JVerticalLabel} class.
 * </p>
 *
 * @version 1.0
 * @author Littleken
 */
public class JVerticalLabelAccuracyTest extends TestCase {

    /**
     * <p>
     * Represents the path of logo image which is will be loaded in testing running for accuracy
     * tests.
     * </p>
     */
    private static final String IMAGE_PATH = "test_files/accuracy/logo.PNG";

    /**
     * <p>
     * Represents the text used for accuracy tests.
     * </p>
     */
    private static final String TEXT = "Accuracy test by Littleken";

    /**
     * <p>
     * Represents the icon used for accuracy tests.
     * </p>
     */
    private static Icon icon;

    /**
     * <p>
     * Represents the <code>JVerticalLabel</code> instance used for accuracy tests.
     * </p>
     */
    private JVerticalLabel label;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();

        icon = new ImageIcon(IMAGE_PATH);
    }

    /**
     * <p>
     * Tear down the testing environment.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        label = null;
        icon = null;
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel()}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructotAccuracy() throws Exception {
        label = new JVerticalLabel();

        assertNotNull("JVerticalLabel constructor should be created correctly.", label);
        assertFalse("JVerticalLabel constructor should be created correctly..", label.isFlipped());
        assertNull("JVerticalLabel constructor should be created correctly.", label.getIcon());
        assertEquals("JVerticalLabel constructor should be created correctly.", "", label.getText().trim());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEADING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Boolean_Accuracy() throws Exception {
        label = new JVerticalLabel(true);

        assertNotNull("JVerticalLabel constructor should be created correctly.", label);
        assertTrue("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertNull("JVerticalLabel constructor should be created correctly.", label.getIcon());
        assertEquals("JVerticalLabel constructor should be created correctly.", "", label.getText().trim());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEADING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon icon)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Accuracy() throws Exception {
        label = new JVerticalLabel(icon);

        assertNotNull("JVerticalLabel constructor should be created correctly.", label);
        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.CENTER, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Boolean_Accuracy1() throws Exception {
        label = new JVerticalLabel(icon, false);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.CENTER, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Boolean_Accuracy2() throws Exception {
        label = new JVerticalLabel(icon, true);

        assertTrue("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.CENTER, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Int_Accuracy1() throws Exception {
        label = new JVerticalLabel(icon, SwingConstants.CENTER);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.CENTER, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Int_Accuracy2() throws Exception {
        label = new JVerticalLabel(icon, SwingConstants.LEFT);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEFT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Int_Accuracy3() throws Exception {
        label = new JVerticalLabel(icon, SwingConstants.RIGHT);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.RIGHT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Int_Accuracy4() throws Exception {
        label = new JVerticalLabel(icon, SwingConstants.TRAILING);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.TRAILING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Int_Accuracy5() throws Exception {
        label = new JVerticalLabel(icon, SwingConstants.LEADING);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEADING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, int, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Int_Boolean_Accuracy1() throws Exception {
        label = new JVerticalLabel(icon, SwingConstants.LEFT, false);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEFT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(Icon, int, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_Icon_Int_Boolean_Accuracy2() throws Exception {
        label = new JVerticalLabel(icon, SwingConstants.RIGHT, true);

        assertTrue("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.RIGHT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Accuracy1() throws Exception {
        label = new JVerticalLabel(TEXT);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", TEXT, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEADING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Accuracy2() throws Exception {
        label = new JVerticalLabel("  ");

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", "  ", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEADING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Accuracy3() throws Exception {
        label = new JVerticalLabel("");

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", "", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEADING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Boolean_Accuracy() throws Exception {
        label = new JVerticalLabel(TEXT, true);

        assertTrue("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", TEXT, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEADING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Int_Accuracy1() throws Exception {
        label = new JVerticalLabel(TEXT, SwingConstants.CENTER);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", TEXT, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.CENTER, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Int_Accuracy2() throws Exception {
        label = new JVerticalLabel(" ", SwingConstants.LEFT);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", " ", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEFT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Int_Accuracy3() throws Exception {
        label = new JVerticalLabel("", SwingConstants.RIGHT);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", "", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.RIGHT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class
     * {@link JVerticalLabel#JVerticalLabel(String, int, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Int_Boolean_Accuracy1() throws Exception {
        label = new JVerticalLabel(TEXT, SwingConstants.CENTER, false);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", TEXT, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.CENTER, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class
     * {@link JVerticalLabel#JVerticalLabel(String, int, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Int_Boolean_Accuracy2() throws Exception {
        label = new JVerticalLabel("", SwingConstants.LEFT, true);

        assertTrue("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", "", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEFT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class
     * {@link JVerticalLabel#JVerticalLabel(String, int, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Int_Boolean_Accuracy3() throws Exception {
        label = new JVerticalLabel(" ", SwingConstants.RIGHT, true);

        assertTrue("JVerticalLabel constructor should be created correctly.", label.isFlipped());
        assertEquals("JVerticalLabel constructor should be created correctly.", null, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", " ", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.RIGHT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String, Icon, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Icon_Int_Accuracy1() throws Exception {
        label = new JVerticalLabel(TEXT, icon, SwingConstants.CENTER);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", TEXT, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.CENTER, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String, Icon, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Icon_Int_Accuracy2() throws Exception {
        label = new JVerticalLabel(" ", icon, SwingConstants.LEFT);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", " ", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEFT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#JVerticalLabel(String, Icon, int)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Icon_Int_Accuracy3() throws Exception {
        label = new JVerticalLabel("", icon, SwingConstants.RIGHT);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", "", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.RIGHT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class
     * {@link JVerticalLabel#JVerticalLabel(String, Icon, int, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Icon_Int_boolean_Accuracy1() throws Exception {
        label = new JVerticalLabel(TEXT, icon, SwingConstants.CENTER, false);

        assertFalse("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", TEXT, label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.CENTER, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class
     * {@link JVerticalLabel#JVerticalLabel(String, Icon, int, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Icon_Int_boolean_Accuracy2() throws Exception {
        label = new JVerticalLabel(" ", icon, SwingConstants.LEFT, true);

        assertTrue("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", " ", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.LEFT, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class
     * {@link JVerticalLabel#JVerticalLabel(String, Icon, int, boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelConstructot_String_Icon_Int_boolean_Accuracy3() throws Exception {
        label = new JVerticalLabel("", icon, SwingConstants.TRAILING, true);

        assertTrue("JVerticalLabel constructor should be created correctly.", label.isFlipped());

        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconHeight(), label.getIcon()
                .getIconHeight());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon.getIconWidth(), label.getIcon()
                .getIconWidth());
        assertEquals("JVerticalLabel constructor should be created correctly.", icon, label.getIcon());

        assertEquals("JVerticalLabel constructor should be created correctly.", "", label.getText());
        assertEquals("JVerticalLabel constructor should be created correctly.", SwingConstants.TRAILING, label
                .getHorizontalAlignment());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#isFlipped()}.
     * </p>
     * <p>
     * Default return value should be false.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelIsFlippedAccuracy1() throws Exception {
        label = new JVerticalLabel();

        assertFalse("JVerticalLabel method isFlipped should be returned correctly.", label.isFlipped());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#isFlipped()}.
     * </p>
     * <p>
     * After setting flipped value, return value should be true.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelIsFlippedAccuracy2() throws Exception {
        label = new JVerticalLabel(true);

        assertTrue("JVerticalLabel method isFlipped should be returned correctly.", label.isFlipped());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#setFlipped(boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelSetFlipped_Boolean_Accuracy1() throws Exception {
        label = new JVerticalLabel();

        label.setFlipped(false);
        assertFalse("JVerticalLabel method setFlipped should be calling correctly.", label.isFlipped());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link JVerticalLabel#setFlipped(boolean)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testJVerticalLabelSetFlipped_Boolean_Accuracy2() throws Exception {
        label = new JVerticalLabel();

        label.setFlipped(true);
        assertTrue("JVerticalLabel method setFlipped should be calling correctly.", label.isFlipped());
    }

    /**
     * <p>
     * Accuracy test of constructor class {@link VerticalLabelUI#getPreferredSize(JComponent)}.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testVerticalLabelUIGetPreferredSize_Accuracy() throws Exception {
        label = new JVerticalLabel(icon);

        int width = icon.getIconWidth();
        int height = icon.getIconHeight();

        Dimension dimension = label.getUI().getPreferredSize(label);

        assertEquals("VerticalLabelUI method getPreferredSize should be calling correctly.", width * 1.0, dimension
                .getHeight());
        assertEquals("VerticalLabelUI method getPreferredSize should be calling correctly.", height * 1.0, dimension
                .getWidth());
    }
}
