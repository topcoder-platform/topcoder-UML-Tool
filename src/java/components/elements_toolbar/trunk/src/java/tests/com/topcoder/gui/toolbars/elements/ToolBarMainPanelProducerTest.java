/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The unit test for <code>ToolBarMainPanelProducer</code>.
 *
 * @author enefem21
 * @version 1.0
 */
public class ToolBarMainPanelProducerTest extends TestCase {

    /** Number of rows used in the unit test. */
    private static final int ROW = 20;

    /** Number of columns used in the unit test. */
    private static final int COLUMN = 15;

    /** Preferred size of the section panel used in the unit test. */
    private static final Dimension PREFERRED_SIZE = new Dimension(100, 100);

    /** Minimum size of the section panel used in the unit test. */
    private static final Dimension MINIMUM_SIZE = new Dimension(50, 50);

    /** Unit under test. */
    private ToolBarMainPanelProducer producer;

    /** SectionPanel used in the unit under test. */
    private SectionPanel sectionPanel;

    /**
     * <p>
     * Creates a test suite of the tests contained in this class.
     * </p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(ToolBarMainPanelProducerTest.class);
    }

    /**
     * Sets the unit test up.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        producer =
            new ToolBarMainPanelProducer(ROW, COLUMN, UIManager.getSystemLookAndFeelClassName(), PREFERRED_SIZE,
                MINIMUM_SIZE);

        sectionPanel =
            new SectionPanel("sectionText", Color.WHITE, new String[] {"buttonName1", "buttonName2"},
                new ImageIcon[] {new ImageIcon("icon/jurnelles.png"), new ImageIcon("icon/loupe-black.png")},
                UIManager.getSystemLookAndFeelClassName());
    }

    /**
     * Tears the unit test down.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearNamespaces();

        producer = null;
        sectionPanel = null;

        super.tearDown();
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: row is zero. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerRowZero() {
        try {
            new ToolBarMainPanelProducer(0, 10, UIManager.getSystemLookAndFeelClassName(), new Dimension(10, 10),
                new Dimension(10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: row is negative. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerRowNegative() {
        try {
            new ToolBarMainPanelProducer(-5, 10, UIManager.getSystemLookAndFeelClassName(), new Dimension(10, 10),
                new Dimension(10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: column is zero. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerColumnZero() {
        try {
            new ToolBarMainPanelProducer(10, 0, UIManager.getSystemLookAndFeelClassName(), new Dimension(10, 10),
                new Dimension(10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: column is negative. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerColumnNegative() {
        try {
            new ToolBarMainPanelProducer(10, -6, UIManager.getSystemLookAndFeelClassName(), new Dimension(10, 10),
                new Dimension(10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: look is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerNullLook() {
        try {
            new ToolBarMainPanelProducer(10, 15, null, new Dimension(10, 10), new Dimension(10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: look is an empty string. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerEmptyStringLook() {
        try {
            new ToolBarMainPanelProducer(10, 15, "", new Dimension(10, 10), new Dimension(10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: look is not valid class. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerNotFoundLook() {
        try {
            new ToolBarMainPanelProducer(10, 15, "unknownLookClass", new Dimension(10, 10), new Dimension(10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: look is not a look and feel class.
     * Expect: <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerClassCastLook() {
        try {
            new ToolBarMainPanelProducer(10, 15, "java.lang.String", new Dimension(10, 10), new Dimension(10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: preferred size is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerNullPreferredSize() {
        try {
            new ToolBarMainPanelProducer(10, 15, UIManager.getSystemLookAndFeelClassName(), null, new Dimension(
                10, 10));
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor. Condition: minimum size is null. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testToolBarMainPanelProducerNullMinimumSize() {
        try {
            new ToolBarMainPanelProducer(10, 15, UIManager.getSystemLookAndFeelClassName(), new Dimension(10, 10),
                null);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>ToolBarMainPanelProducer</code> constructor for accuracy. Condition: normal. Expect: no
     * exception and all conditions are checked.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testToolBarMainPanelProducerAccuracy() throws Exception {
        ToolBarMainPanelProducer p =
            new ToolBarMainPanelProducer(10, 15, UIManager.getSystemLookAndFeelClassName(), new Dimension(10, 10),
                new Dimension(20, 25));

        JPanel panel = p.getToolBarMainPanel();

        assertEquals("The preferred size is not as expected", new Dimension(10, 10), panel.getPreferredSize());
        assertEquals("The minimum size is not as expected", new Dimension(20, 25), panel.getMinimumSize());
        assertTrue("The layout is not as expected", panel.getLayout() instanceof GridBagLayout);
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridX</code>. Condition: gridx is negative. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelNegativeGridX() {
        try {
            producer.addNewSectionPanel(-10, 5, 5, 5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridX</code>. Condition: gridx is too big (gridx == COLUMN). Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelTooBigGridX1() {
        try {
            producer.addNewSectionPanel(COLUMN, 5, 5, 5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridX</code>. Condition: gridx is too big (gridx > COLUMN). Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelTooBigGridX2() {
        try {
            producer.addNewSectionPanel(COLUMN + 2, 5, 5, 5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridY</code>. Condition: gridy is negative. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelNegativeGridY() {
        try {
            producer.addNewSectionPanel(5, -5, 5, 5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridY</code>. Condition: gridy is too big (gridy == ROW). Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelTooBigGridY1() {
        try {
            producer.addNewSectionPanel(5, ROW, 5, 5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridY</code>. Condition: gridy is too big (gridy > COLUMN). Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelTooBigGridY2() {
        try {
            producer.addNewSectionPanel(5, ROW + 2, 5, 5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridWidth</code>. Condition: gridWidth is negative. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelNegativeGridWidth() {
        try {
            producer.addNewSectionPanel(5, 5, -5, 5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridWidth</code>. Condition: gridWidth + gridx == COLUMN. Expect: no
     * exception.
     */
    public void testAddNewSectionPanelPassGridWidth() {
        producer.addNewSectionPanel(5, 5, COLUMN - 5, 5, sectionPanel);
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridWidth</code>. Condition: gridWidth too big (gridWidth + gridx >
     * COLUMN). Expect: <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelTooBigGridWidth() {
        try {
            producer.addNewSectionPanel(5, 5, COLUMN - 2, 5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridHeight</code>. Condition: gridHeight is negative. Expect:
     * <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelNegativeGridHeight() {
        try {
            producer.addNewSectionPanel(5, 5, 5, -5, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridHeight</code>. Condition: gridHeight + gridy == ROW. Expect: no
     * exception.
     */
    public void testAddNewSectionPanelPassGridHeight() {
        producer.addNewSectionPanel(5, 5, 5, ROW - 5, sectionPanel);

    }

    /**
     * Test <code>addNewSectionPanelNegativeGridHeight</code>. Condition: gridHeight too big (gridHeight + gridy >
     * ROW). Expect: <code>IllegalArgumentException</code>.
     */
    public void testAddNewSectionPanelTooBigGridHeight() {
        try {
            producer.addNewSectionPanel(5, 5, 5, ROW - 2, sectionPanel);
            fail("should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test <code>addNewSectionPanelNegativeGridHeight</code> for accuracy. Condition: normal. Expect: no
     * exception and al conditions are checked.
     */
    public void testAddNewSectionPanelAccuracy() {
        producer.addNewSectionPanel(1, 2, 3, 4, sectionPanel);

        JPanel panel = producer.getToolBarMainPanel();

        assertEquals("The preferred size is not as expected", PREFERRED_SIZE, panel.getPreferredSize());
        assertEquals("The minimum size is not as expected", MINIMUM_SIZE, panel.getMinimumSize());
        assertTrue("The layout is not as expected", panel.getLayout() instanceof GridBagLayout);
        assertEquals("The component is not as expected", sectionPanel, panel.getComponent(0));

        GridBagConstraints constraints = ((GridBagLayout) panel.getLayout()).getConstraints(sectionPanel);

        assertEquals("constraints' grid x is not as expected", 1, constraints.gridx);
        assertEquals("constraints' grid y is not as expected", 2, constraints.gridy);
        assertEquals("constraints' grid width is not as expected", 3, constraints.gridwidth);
        assertEquals("constraints' grid height is not as expected", 4, constraints.gridheight);
        assertEquals("constraints' weight x is not as expected", 0.5, constraints.weightx);
        assertEquals("constraints' weight y is not as expected", 0.5, constraints.weighty);
        assertEquals("constraints' fill is not as expected", GridBagConstraints.BOTH, constraints.fill);
    }

}
