/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.accuracytests;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This is a test case for <code>StereotypeTextField</code> class.
 * </p>
 * @author moonli
 * @version 1.0
 */
public class StereotypeTextFieldTest extends TestCase {

    /**
     * <p>
     * Represents an instance of <code>StereotypeTextField</code> class.
     * </p>
     */
    private StereotypeTextField textField;

    /**
     * <p>
     * Represents the margin for displaying text.
     * </p>
     */
    private static int MARGIN = 4;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        textField = new StereotypeTextField(new GraphNode());
        textField.setStereotype("stereotype");
        ArrayList<StereotypeTextField> items = new ArrayList<StereotypeTextField>();
        items.add(textField);
        GroupTextField group = new GroupTextField(items);

        (new JPanel()).add(textField);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        textField = null;
    }

    /**
     * <p>
     * Aggregates all tests.
     * </p>
     * @return a test suite will be returned
     */
    public static Test suite() {
        return new TestSuite(StereotypeTextFieldTest.class);
    }

    /**
     * <p>
     * Test for <code>getPreferredSize()</code> method.
     * </p>
     * <p>
     * Tests it for accuracy, valid dimension should be returned.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testGetPreferredSizeAccuarcy() throws Exception {
        // set text of textField to 'This is a text node!'
        String text = "This is a text node.";
        textField.setText(text);
        // set stereotype text
        textField.stereotypeVisible(true);
        // gets font of the textField
        Font font = textField.getFont();
        FontMetrics metrics = textField.getFontMetrics(font);
        /*
         * BugFix: BUGID UML-8189
         * Description:
         * In measureSize, the preferred height is calculated as the sum of fontMetric's height and descent as
         * the preferred height.  This should only use fontMetric's height.
         * Solution:
         * Use fontMetric's height instead.
         */
        // old code
//        Dimension dim = new Dimension(SwingUtilities.computeStringWidth(metrics, "stereotype"
//            + text), metrics.getHeight() + metrics.getDescent());
        Dimension dim = new Dimension(SwingUtilities.computeStringWidth(metrics, "stereotype"
                + text) + MARGIN * 2, metrics.getHeight());

        assertEquals("PreferredSize mismatched.", dim, textField.getPreferredSize());
    }

    /**
     * <p>
     * Test for <code>getPreferredSize()</code> method.
     * </p>
     * <p>
     * Tests it for accuracy with stereotype invisible. Just text should be used for calculation.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testGetPreferredSizeAccuracyWithStereotypeInvisible() throws Exception {
        // set text of textField to 'This is a text node!'
        String text = "This is a text node.";
        textField.setText(text);
        // set stereotype text
        textField.stereotypeVisible(false);
        // gets font of the textField
        Font font = textField.getFont();
        FontMetrics metrics = textField.getFontMetrics(font);
        /*
         * BugFix: BUGID UML-8189
         * Description:
         * In measureSize, the preferred height is calculated as the sum of fontMetric's height and descent as
         * the preferred height.  This should only use fontMetric's height.
         * Solution:
         * Use fontMetric's height instead.
         */
        // old code
//        Dimension dim = new Dimension(SwingUtilities.computeStringWidth(metrics, text), metrics
//            .getHeight()
//            + metrics.getDescent());
        Dimension dim = new Dimension(SwingUtilities.computeStringWidth(metrics, text) + MARGIN * 2,
                metrics.getHeight());

        assertEquals("PreferredSize mismatched.", dim, textField.getPreferredSize());
    }

    /**
     * <p>
     * Test for <code>getStereotype()</code> method.
     * </p>
     * <p>
     * Tests it for accuracy, 'stereotype' string should be returned.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testGetStereotypeAccuracy() throws Exception {
        assertEquals("Stereotype mismatched.", textField.getStereotype(), "stereotype");
    }

    /**
     * <p>
     * Test for <code>stereotypeVisible(isStereotypeVisible)</code> method.
     * </p>
     * <p>
     * Tests it for accuracy with <code>true</code>.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testStereotypeVisible() throws Exception {
        textField.stereotypeVisible(true);
        assertTrue("True should be returned.", textField.isStereotypeVisible());
    }
}
