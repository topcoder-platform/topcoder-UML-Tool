/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.accuracytests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.topcoder.gui.toolbars.elements.SectionPanel;
import com.topcoder.gui.toolbars.elements.ToolBarMainPanelProducer;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link ToolBarMainPanelProducer}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ToolBarMainPanelProducerAccuracyTests extends TestCase {
    /**
     * <p>
     * Accuracy test for
     * <code>{@link ToolBarMainPanelProducer#ToolBarMainPanelProducer(int, int, String, Dimension, Dimension)}</code>
     * constructor.
     * </p>
     */
    public void testToolBarMainPanelProducerAccuracy() {
        String look = "javax.swing.plaf.metal.MetalLookAndFeel";
        Dimension preferredSize = new Dimension(200, 200);
        Dimension minimizedSize = new Dimension(50, 50);
        ToolBarMainPanelProducer toolBarMainPanelProducer = new ToolBarMainPanelProducer(2, 3, look, preferredSize,
            minimizedSize);

        assertEquals("row field not set correctly.", new Integer(2), AccuracyTestHelper.getPrivateField(
            ToolBarMainPanelProducer.class, toolBarMainPanelProducer, "row"));
        assertEquals("column field not set correctly.", new Integer(3), AccuracyTestHelper.getPrivateField(
            ToolBarMainPanelProducer.class, toolBarMainPanelProducer, "column"));
        GridBagConstraints constraints = (GridBagConstraints) AccuracyTestHelper.getPrivateField(
            ToolBarMainPanelProducer.class, toolBarMainPanelProducer, "constraints");
        assertNotNull("constaints field can not be null.", constraints);
        assertEquals(GridBagConstraints.BOTH, constraints.fill);
        assertEquals(0.5, constraints.weightx);
        assertEquals(0.5, constraints.weighty);

        JPanel mainPanel = (JPanel) AccuracyTestHelper.getPrivateField(ToolBarMainPanelProducer.class,
            toolBarMainPanelProducer, "mainPanel");
        assertNotNull(mainPanel);
        assertTrue(mainPanel.getLayout() instanceof GridBagLayout);
        assertEquals(preferredSize, mainPanel.getPreferredSize());
        assertEquals(minimizedSize, mainPanel.getMinimumSize());
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ToolBarMainPanelProducer#getToolBarMainPanel()}</code> method.
     * </p>
     */
    public void testGetToolBarMainPanelAccuracy() {
        ToolBarMainPanelProducer toolBarMainPanelProducer = new ToolBarMainPanelProducer(2, 3,
            "javax.swing.plaf.metal.MetalLookAndFeel", new Dimension(200, 200), new Dimension(50, 50));
        assertNotNull(toolBarMainPanelProducer.getToolBarMainPanel());
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link ToolBarMainPanelProducer#addNewSectionPanel(int, int, int, int, SectionPanel)}</code> method.
     * </p>
     */
    public void testAddNewSectionPanelAccuracy() {
        SectionPanel sectionPanel = new SectionPanel("text", Color.BLACK, new String[] {"button1", "button2"},
            new ImageIcon[] {new ImageIcon(), new ImageIcon()}, UIManager.getCrossPlatformLookAndFeelClassName());
        ToolBarMainPanelProducer toolBarMainPanelProducer = new ToolBarMainPanelProducer(2, 3,
            "javax.swing.plaf.metal.MetalLookAndFeel", new Dimension(200, 200), new Dimension(50, 50));
        toolBarMainPanelProducer.addNewSectionPanel(0, 0, 1, 1, sectionPanel);
        JPanel toolbarPanel = toolBarMainPanelProducer.getToolBarMainPanel();
        assertTrue(Arrays.asList(toolbarPanel.getComponents()).contains(sectionPanel));
    }
}
