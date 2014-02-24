/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel.failuretests;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.topcoder.gui.verticallabel.JVerticalLabel;

import junit.framework.TestCase;

/**
 * <p>
 * This is a failure test class for <code>JVerticalLabel</code> and its inner
 * class.
 * </p>
 *
 * @author hfx
 * @version 1.0
 */
public class JVerticalLabelFailureTests extends TestCase {
    /**
     * <p>
     * Test <code>JVerticalLabel(Icon, int)</code>
     * </p>
     * <p>
     * horizontalAlignment is invalid.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testCtor_Icon_int_IAE() {
        try {
            new JVerticalLabel(new ImageIcon(), 111);
            fail("IllegalArgumentException expected if horizontalAlignment is invalid.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test <code>JVerticalLabel(Icon, int, boolean)</code>
     * </p>
     * <p>
     * horizontalAlignment is invalid.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testCtor_Icon_int_boolean_IAE() {
        try {
            new JVerticalLabel(new ImageIcon(), 111, false);
            fail("IllegalArgumentException expected if horizontalAlignment is invalid.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test <code>JVerticalLabel(String, int)</code>
     * </p>
     * <p>
     * horizontalAlignment is invalid.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testCtor_String_int_IAE() {
        try {
            new JVerticalLabel("xxx", 111);
            fail("IllegalArgumentException expected if horizontalAlignment is invalid.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test <code>JVerticalLabel(String, int, boolean)</code>
     * </p>
     * <p>
     * horizontalAlignment is invalid.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testCtor_String_int_boolean_IAE() {
        try {
            new JVerticalLabel("xxx", 111, false);
            fail("IllegalArgumentException expected if horizontalAlignment is invalid.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test <code>JVerticalLabel(String, Icon, int)</code>
     * </p>
     * <p>
     * horizontalAlignment is invalid.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testCtor_String_Icon_int_IAE() {
        try {
            new JVerticalLabel("xx", new ImageIcon(), 111);
            fail("IllegalArgumentException expected if horizontalAlignment is invalid.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test <code>JVerticalLabel(String, Icon, int, boolean)</code>
     * </p>
     * <p>
     * horizontalAlignment is invalid.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testCtor_String_Icon_int_boolean_IAE() {
        try {
            new JVerticalLabel("xx", new ImageIcon(), 111, false);
            fail("IllegalArgumentException expected if horizontalAlignment is invalid.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test
     * <code>JVerticalLabel.VerticalLabelUI.getPreferredSize(JComponent)</code>
     * </p>
     * <p>
     * JComponent is null.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testVerticalLabelUI_getPreferredSize_nullIAE() {
        try {
            new JVerticalLabel().getUI().getPreferredSize(null);
            fail("IllegalArgumentException expected if JComponent is null.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test
     * <code>JVerticalLabel.VerticalLabelUI.getPreferredSize(JComponent)</code>
     * </p>
     * <p>
     * JComponent is not JVerticalLabel.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testVerticalLabelUI_getPreferredSize_invalidClassIAE() {
        try {
            new JVerticalLabel().getUI().getPreferredSize(new JLabel());
            fail("IllegalArgumentException expected if JComponent is not JVerticalLabel.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test
     * <code>JVerticalLabel.VerticalLabelUI.paint(Graphics, JComponent)</code>
     * </p>
     * <p>
     * Graphics is null.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testVerticalLabelUI_paint_Graphics_nullIAE() {
        try {
            new JVerticalLabel().getUI().paint(null, new JVerticalLabel());
            fail("IllegalArgumentException expected if Graphics is null.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test
     * <code>JVerticalLabel.VerticalLabelUI.paint(Graphics, JComponent)</code>
     * </p>
     * <p>
     * Graphics is not Graphics2D.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     *
    public void testVerticalLabelUI_paint_Graphics_invalidClassIAE() {
        try {
            new JVerticalLabel().getUI().paint(new DebugGraphics(),
                    new JVerticalLabel());
            fail("IllegalArgumentException expected if Graphics is not Graphics2D.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }*/

    /**
     * <p>
     * Test
     * <code>JVerticalLabel.VerticalLabelUI.paint(Graphics, JComponent)</code>
     * </p>
     * <p>
     * JComponent is null.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testVerticalLabelUI_paint_JComponent_nullIAE() {
        try {
            BufferedImage image = new BufferedImage(50, 50,
                    BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g = image.createGraphics();
            new JVerticalLabel().getUI().paint(g, null);
            fail("IllegalArgumentException expected if JComponent is null.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test
     * <code>JVerticalLabel.VerticalLabelUI.paint(Graphics, JComponent)</code>
     * </p>
     * <p>
     * JComponent is not JVerticalLabel.
     * </p>
     * <p>
     * IllegalArgumentException expected.
     * </p>
     */
    public void testVerticalLabelUI_paint_JComponent_invalidClassIAE() {
        try {
            BufferedImage image = new BufferedImage(50, 50,
                    BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g = image.createGraphics();
            new JVerticalLabel().getUI().paint(g, new JLabel());
            fail("IllegalArgumentException expected if JComponent is not JVerticalLabel.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }
}
