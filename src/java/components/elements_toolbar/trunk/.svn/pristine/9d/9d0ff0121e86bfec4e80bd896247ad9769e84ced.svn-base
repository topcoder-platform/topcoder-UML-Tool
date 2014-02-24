/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.failuretests;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import junit.framework.TestCase;

import com.topcoder.gui.toolbars.elements.SectionPanel;
import com.topcoder.gui.toolbars.elements.ToolBarMainPanelProducer;

/**
 * <p>
 * This class aggregates failure tests for ToolbarMainPanelProducer.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class ToolBarMainPanelProducerFailureTests extends TestCase {

    /**
     * Look and feel class name for unit testing.
     */
    private static final String LOOK_AND_FEEL_CLASS_NAME = UIManager.getCrossPlatformLookAndFeelClassName();

    /**
     * The number of columns in the GridBagLayout.
     */
    private static int COLUMNS = 10;

    /**
     * The number of rows in the GridBagLayout.
     */
    private static int ROWS = 5;

    /**
     * A placeholder for ToolBarMainPanelProducer instance.
     */
    private ToolBarMainPanelProducer test;

    /**
     * A SectionPanel instance.
     */
    private SectionPanel panel;

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        test = new ToolBarMainPanelProducer(ROWS, COLUMNS, LOOK_AND_FEEL_CLASS_NAME, new Dimension(),
                new Dimension());

        panel = new SectionPanel("sectionPanel", Color.black, new String[] {"btnName"},
                new ImageIcon[] {new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);
    }

    /**
     * Tests ToolBarMainPanelProducer constructor with 0 as row argument. IllegalArgumentException is expected.
     */
    public void testToolBarMainPanelProducer_Row0() {
        try {
            new ToolBarMainPanelProducer(0, 1, LOOK_AND_FEEL_CLASS_NAME, new Dimension(), new Dimension());
            fail("Did not throw IllegalArgumentException with 0 as row argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests ToolBarMainPanelProducer constructor with -1 as row argument. IllegalArgumentException is expected.
     */
    public void testToolBarMainPanelProducer_RowMinus1() {
        try {
            new ToolBarMainPanelProducer(-1, 1, LOOK_AND_FEEL_CLASS_NAME, new Dimension(), new Dimension());
            fail("Did not throw IllegalArgumentException with -1 as row argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests ToolBarMainPanelProducer constructor with 0 as column argument. IllegalArgumentException is expected.
     */
    public void testToolBarMainPanelProducer_Column0() {
        try {
            new ToolBarMainPanelProducer(1, 0, LOOK_AND_FEEL_CLASS_NAME, new Dimension(), new Dimension());
            fail("Did not throw IllegalArgumentException with 0 as column argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests ToolBarMainPanelProducer constructor with -1 as column argument. IllegalArgumentException is expected.
     */
    public void testToolBarMainPanelProducer_ColumnMinus1() {
        try {
            new ToolBarMainPanelProducer(1, -1, LOOK_AND_FEEL_CLASS_NAME, new Dimension(), new Dimension());
            fail("Did not throw IllegalArgumentException with -1 as column argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests ToolBarMainPanelProducer constructor with null argument. IllegalArgumentException is expected.
     */
    public void testToolBarMainPanelProducer_NullArgument1() {
        try {
            new ToolBarMainPanelProducer(1, 1, null, new Dimension(), new Dimension());
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests ToolBarMainPanelProducer constructor with null argument. IllegalArgumentException is expected.
     */
    public void testToolBarMainPanelProducer_NullArgument2() {
        try {
            new ToolBarMainPanelProducer(1, 1, LOOK_AND_FEEL_CLASS_NAME, null, new Dimension());
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests ToolBarMainPanelProducer constructor with null argument. IllegalArgumentException is expected.
     */
    public void testToolBarMainPanelProducer_NullArgument3() {
        try {
            new ToolBarMainPanelProducer(1, 1, LOOK_AND_FEEL_CLASS_NAME, new Dimension(), null);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests ToolBarMainPanelProducer constructor with wrong look and feel argument. This testcase tests the
     * wrapping of exception when UIManager#setLookAndFeel() called by the method throws exception.
     * IllegalArgumentException is expected.
     */
    public void testToolBarMainPanelProducer_InvalidLookArgument() {
        try {
            new ToolBarMainPanelProducer(1, 1, "InvalidClassName", new Dimension(), new Dimension());
            fail("Did not throw IllegalArgumentException with invalid look and feel argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addNewSectionPanel method with negative argument. IllegalArgumentException is expected.
     */
    public void testAddNewSectionPanel_NegativeArgument1() {
        try {
            test.addNewSectionPanel(-1, 0, 1, 1, panel);
            fail("Did not throw IllegalArgumentException with negative argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addNewSectionPanel method with negative argument. IllegalArgumentException is expected.
     */
    public void testAddNewSectionPanel_NegativeArgument2() {
        try {
            test.addNewSectionPanel(0, -1, 1, 1, panel);
            fail("Did not throw IllegalArgumentException with negative argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addNewSectionPanel method with negative argument. IllegalArgumentException is expected.
     */
    public void testAddNewSectionPanel_NegativeArgument3() {
        try {
            test.addNewSectionPanel(0, 0, -1, 1, panel);
            fail("Did not throw IllegalArgumentException with negative argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addNewSectionPanel method with negative argument. IllegalArgumentException is expected.
     */
    public void testAddNewSectionPanel_NegativeArgument4() {
        try {
            test.addNewSectionPanel(0, 0, 1, -1, panel);
            fail("Did not throw IllegalArgumentException with negative argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addNewSectionPanel method with null panel argument. IllegalArgumentException is expected.
     */
    public void testAddNewSectionPanel_NullPanel() {
        try {
            test.addNewSectionPanel(0, 0, 1, 1, null);
            fail("Did not throw IllegalArgumentException with negative argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * <p>
     * Tests addNewSectionPanel method with invalid value combination. IllegalArgumentException is expected.
     * </p>
     * <p>
     * Note that gridx + gridwidth &lt;= columns and gridy + gridheight &lt;= rows.
     * </p>
     */
    public void testAddNewSectionPanel_InvalidValueCombination1() {
        try {
            test.addNewSectionPanel(0, 0, COLUMNS + 1, 1, panel);
            fail("Did not throw IllegalArgumentException with invalid value combination.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * <p>
     * Tests addNewSectionPanel method with invalid value combination. IllegalArgumentException is expected.
     * </p>
     * <p>
     * Note that gridx + gridwidth &lt;= columns and gridy + gridheight &lt;= rows.
     * </p>
     */
    public void testAddNewSectionPanel_InvalidValueCombination2() {
        try {
            test.addNewSectionPanel(0, 0, 1, ROWS + 1, panel);
            fail("Did not throw IllegalArgumentException with invalid value combination.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * <p>
     * Tests addNewSectionPanel method with invalid value combination. IllegalArgumentException is expected.
     * </p>
     * <p>
     * Note that gridx + gridwidth &lt;= columns and gridy + gridheight &lt;= rows.
     * </p>
     */
    public void testAddNewSectionPanel_InvalidValueCombination3() {
        try {
            test.addNewSectionPanel(1, 0, COLUMNS, 1, panel);
            fail("Did not throw IllegalArgumentException with invalid value combination.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * <p>
     * Tests addNewSectionPanel method with invalid value combination. IllegalArgumentException is expected.
     * </p>
     * <p>
     * Note that gridx + gridwidth &lt;= columns and gridy + gridheight &lt;= rows.
     * </p>
     */
    public void testAddNewSectionPanel_InvalidValueCombination4() {
        try {
            test.addNewSectionPanel(0, 1, 1, ROWS, panel);
            fail("Did not throw IllegalArgumentException with invalid value combination.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * <p>
     * Tests addNewSectionPanel method with invalid value combination. IllegalArgumentException is expected.
     * </p>
     * <p>
     * Note that gridx + gridwidth &lt;= columns and gridy + gridheight &lt;= rows.
     * </p>
     */
    public void testAddNewSectionPanel_InvalidValueCombination5() {
        try {
            test.addNewSectionPanel(2, 0, COLUMNS - 1, 1, panel);
            fail("Did not throw IllegalArgumentException with invalid value combination.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * <p>
     * Tests addNewSectionPanel method with invalid value combination. IllegalArgumentException is expected.
     * </p>
     * <p>
     * Note that gridx + gridwidth &lt;= columns and gridy + gridheight &lt;= rows.
     * </p>
     */
    public void testAddNewSectionPanel_InvalidValueCombination6() {
        try {
            test.addNewSectionPanel(0, 2, 1, ROWS - 1, panel);
            fail("Did not throw IllegalArgumentException with invalid value combination.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * <p>
     * Tests addNewSectionPanel method with invalid value combination. IllegalArgumentException is expected.
     * </p>
     * <p>
     * Note that gridx + gridwidth &lt;= columns and gridy + gridheight &lt;= rows.
     * </p>
     */
    public void testAddNewSectionPanel_InvalidValueCombination7() {
        try {
            test.addNewSectionPanel(COLUMNS, 0, 1, 1, panel);
            fail("Did not throw IllegalArgumentException with invalid value combination.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * <p>
     * Tests addNewSectionPanel method with invalid value combination. IllegalArgumentException is expected.
     * </p>
     * <p>
     * Note that gridx + gridwidth &lt;= columns and gridy + gridheight &lt;= rows.
     * </p>
     */
    public void testAddNewSectionPanel_InvalidValueCombination8() {
        try {
            test.addNewSectionPanel(0, ROWS, 1, 1, panel);
            fail("Did not throw IllegalArgumentException with invalid value combination.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }
}
