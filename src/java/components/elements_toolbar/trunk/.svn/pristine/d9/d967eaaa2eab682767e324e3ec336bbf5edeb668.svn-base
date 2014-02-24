/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.stresstests;

import com.topcoder.gui.toolbars.elements.ElementSelectedListener;
import com.topcoder.gui.toolbars.elements.SectionPanel;
import com.topcoder.gui.toolbars.elements.ToolBarMainPanelProducer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress tests for this components.
 * </p>
 *
 * @author fanse
 * @version 1.0
 */
public class ToolBarStressTests extends TestCase {

    /**
     * <p>
     * Represents the directory where image icons resides.
     * </p>
     */
    final String IMAGE_ICONS_DIR = "test_files" + File.separator + "toolbarButtonGraphics" + File.separator
        + "images" + File.separator;

    /**
     * <p>
     * Represents the numeric constant <code>0</code>.
     * </p>
     */
    final int ZERO = 0;

    /**
     * <p>
     * Represents the positive number <code>1</code>.
     * </p>
     */
    final int ONE = 1;

    /**
     * <p>
     * Represents the valid <code>LookAndFeel</code> class name.
     * </p>
     */
    final String LOOK_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";

    /**
     * <p>
     * Represents the <code>LookAndFeel</code> class name which would throw
     * <code>InstantiationException</code>.
     * </p>
     */
    final String INSTANTIATION_LOOK_FEEL = "com.topcoder.gui.toolbars.elements.SectionPanel";

    /**
     * <p>
     * Represents the array of button names in the section panel.
     * </p>
     */
    private String[] buttonNames;

    /**
     * <p>
     * Represents the array of image icons for the corresponding button names.
     * </p>
     */
    private ImageIcon[] icons;

    /**
     * <p>
     * Instance of <code>ElementSelectedListener</code> for test.
     * </p>
     */
    private ElementSelectedListener listener;

    /**
     * <p>
     * Represents the number of requests to process, used in stress tests.
     * </p>
     */
    private static final int MAX_COUNT = 1000;

    /**
     * <p>
     * Represents the default namespace for <code>SectionPanel</code>.
     * </p>
     */
    private final String DEFAULT_NAMESPACE = "com.topcoder.gui.toolbars.elements.SectionPanel";

    /**
     * <p>
     * Instance of <code>SectionPanel</code> used in demo of the component.
     * </p>
     */
    private SectionPanel nodesPanel;

    /**
     * <p>
     * Represents the time tick used to test.
     * </p>
     */
    private long timeTick;

    /**
     * <p>
     * Sets up the environment before each TestCase.
     * </p>
     *
     * @throws Exception
     *         throws exception if any.
     */
    protected void setUp() throws Exception {
        StressTestsHelper.loadSingleFile(System.getProperty("user.dir") + File.separator + "test_files"
            + File.separator + "stress" + File.separator + "stressConfig.xml");
        nodesPanel = new SectionPanel(DEFAULT_NAMESPACE);
        timeTick = System.currentTimeMillis();
    }

    /**
     * <p>
     * Tears down the environment after execution of each TestCase.
     * </p>
     */
    protected void tearDown() {
        StressTestsHelper.configClear();
        nodesPanel = null;
    }

    /**
     * <p>
     * Stress test for <c>SectionPanel</c>.
     * </p>
     *
     * @throws Exception
     *         exception to Junit.
     */
    public void testSectionPanel1() throws Exception {
        String sectionText = "test section panel";
        Color backgroundColor = Color.MAGENTA;
        // initialize array of button names;
        buttonNames = new String[] { "left", "right" };

        // array of image icons. Each element i here corresponds to element i in buttonNames;
        icons = new ImageIcon[] { new ImageIcon(IMAGE_ICONS_DIR + "left.gif"),
            new ImageIcon(IMAGE_ICONS_DIR + "right.gif") };

        for (int i = 0; i < MAX_COUNT; i++) {
            SectionPanel sectionPanel = new SectionPanel(sectionText, backgroundColor, buttonNames, icons,
                LOOK_FEEL);
            // The section panel is composed of a section text panel and buttons panel.
            // Tests the count of components in secton panel.
            assertEquals("The composition of panel is incorrect", 2, sectionPanel.getComponentCount());

            // Retrieves the text panel associated with the section panel
            JPanel sectionTextPanel = (JPanel) sectionPanel.getComponent(ZERO);

            // The section text panel should contain a single component which is the label
            assertEquals("The composition of section text panel is incorrect", ONE, sectionTextPanel
                .getComponentCount());

            // Tests for the layout of section text panel. The layout should be set to FlowLayout
            assertTrue("Failed to set the layout of the section text panel to FlowLayout", sectionTextPanel
                .getLayout() instanceof FlowLayout);

            // Tests for the back ground color
            assertEquals("Failed to set the back ground color of the section text panel", backgroundColor,
                sectionTextPanel.getBackground());

            // Retrieves the section text label from section Panel
            JLabel label = (JLabel) sectionTextPanel.getComponent(ZERO);

            // Tests for the section text panel
            assertEquals("Failed to set the section text panel properly", sectionText, label.getText());

            // Retrieves the buttons panel associated with section panel
            JPanel buttonsPanel = (JPanel) sectionPanel.getComponent(ONE);

            // Tests for the layout of the buttons panel. The layout should be set to FlowLayOut
            assertTrue("Failed to set the layout of the buttons panel to FlowLayout", buttonsPanel
                .getLayout() instanceof FlowLayout);

            // The buttons panel should contain two buttons
            assertEquals("The composition of buttons panel is incorrect", 2, buttonsPanel.getComponentCount());

            // Retrieves the buttons present in buttons panel and checks for its names and icons
            JToggleButton button1 = (JToggleButton) buttonsPanel.getComponent(ZERO);
            JToggleButton button2 = (JToggleButton) buttonsPanel.getComponent(ONE);

            // Tests for the buttons name
            assertEquals("Failed to set the name of the button properly", buttonNames[0], button1
                .getActionCommand());
            assertEquals("Failed to set the name of the button properly", buttonNames[1], button2
                .getActionCommand());

            // Tests for the image icons
            assertEquals("Failed to set the image icon of the button properly", icons[0], button1.getIcon());
            assertEquals("Failed to set the image icon of the button properly", icons[1], button2.getIcon());

            // Tests for the buttonsMap
            Map<String, JToggleButton> buttonsMap = (Map<String, JToggleButton>) StressTestsHelper
                .getClassAttribute(sectionPanel, "buttonsMap");

            assertEquals("The private field buttonsMap is not populated properly", button1, buttonsMap
                .get(button1.getActionCommand()));
            assertEquals("The private field buttonsMap is not populated properly", button2, buttonsMap
                .get(button2.getActionCommand()));

            // Tests for the associated listeners with the button
            ActionListener[] actionListeners = button1.getActionListeners();

            // Tests the action listeners for button 1
            assertEquals("On creation of button just a single listener should be associated", 1,
                actionListeners.length);

            assertEquals("Failed to set the action listener for the button",
                "com.topcoder.gui.toolbars.elements.SectionPanel$SectionPanelListener", actionListeners[0]
                    .getClass().getName());

            // Tests the action listeners for button 2
            actionListeners = button2.getActionListeners();

            assertEquals("On creation of button just a single listener should be associated", 1,
                actionListeners.length);

            assertEquals("Failed to set the action listener for the button",
                "com.topcoder.gui.toolbars.elements.SectionPanel$SectionPanelListener", actionListeners[0]
                    .getClass().getName());

            // Tests for the UIManager's look and feel
            assertEquals("Failed to set the look and feel of UIManager", "Metal", UIManager.getLookAndFeel()
                .getName());
        }
        stop();
    }

    /**
     * <p>
     * Stress tests on oprations of section panel.
     * </p>
     *
     * @throws Exception
     *         exception to Junit.
     */
    public void testOperationOnSectionPanel() throws Exception {
        listener = new MockAllListeners();
        // initialize array of button names;
        buttonNames = new String[] { "left", "right" };
        for (int i = 0; i < MAX_COUNT * 300; i++) {
            // Retrieves the buttons panel associated with section panel
            JPanel buttonsPanel = (JPanel) nodesPanel.getComponent(ONE);

            // Retrieves the button present in buttons panel
            JToggleButton button = (JToggleButton) buttonsPanel.getComponent(ZERO);

            // The button is now selected
            button.setSelected(true);

            // Do an unselect of the button
            nodesPanel.unselectButton(button.getActionCommand());

            // Tests whether the button is unselected or not
            assertFalse("The unselection of button is not implemented properly", button.isSelected());

            // Add the listener to button names
            nodesPanel.addElementSelectedListener(buttonNames[0], listener);
            Map<String, List<ElementSelectedListener>> listenersMap = (Map<String, List<ElementSelectedListener>>) StressTestsHelper
                .getClassAttribute(nodesPanel, "listenersMap");
            if (listenersMap == null) {
                System.out.println("listenersMap == null");
            }
            // Tests whether the listener is added to the button
            List<ElementSelectedListener> listenersList = listenersMap.get(buttonNames[0]);
            assertTrue("The private field listenersMap is not populated properly", listenersList
                .contains(listener));

            // The listener added for the button is being removed
            nodesPanel.removeElementSelectedListener(buttonNames[0], listener);

            // The listener map should not contain this listener
            // Tests for the listeners map is empty
            assertTrue("The private field listenersMap is not populated properly", listenersList.isEmpty());
        }
        stop();
    }

    /**
     * <p>
     * Stress test for <c>ToolBarMainPanelProducer</c>.
     * </p>
     *
     * @throws Exception
     *         exception to Junit.
     */
    public void testToolBarMainPanelProducer() throws Exception {
        int row = 2;
        int column = 2;
        Dimension preferredSize = new Dimension(300, 300);
        Dimension minimumSize = new Dimension(50, 50);

        for (int i = 0; i < MAX_COUNT; i++) {
            ToolBarMainPanelProducer toolBarMainPanelProducer = new ToolBarMainPanelProducer(row, column,
                LOOK_FEEL, preferredSize, minimumSize);
            nodesPanel = new SectionPanel(SectionPanel.class.getName());
            // Tests for instantiation
            assertNotNull("Failed to create ToolBarMainPanelProducer", toolBarMainPanelProducer);

            // Tests whether the attribute row is set properly or not
            assertEquals("Failed to set the row in ToolBarMainPanelProducer", row, StressTestsHelper
                .getClassAttribute(toolBarMainPanelProducer, "row"));

            // Tests whether the attribute column is set properly or not
            assertEquals("Failed to set the row in ToolBarMainPanelProducer", column, StressTestsHelper
                .getClassAttribute(toolBarMainPanelProducer, "column"));

            // Tests whether the main panel is created properly
            JPanel panel = toolBarMainPanelProducer.getToolBarMainPanel();

            // The panel should not be null
            assertNotNull("Failed to create a new panel", panel);

            // The layout of the main panel should be GridBagLayOut
            assertTrue("Failed to set the layout of the panel to GridBagLayOut",
                panel.getLayout() instanceof GridBagLayout);

            // Tests the preferred size of the main panel
            assertEquals("Failed to get the dimension of the preferred size of the panel", preferredSize,
                panel.getPreferredSize());

            // Tests the minimum size of the main panel
            assertEquals("Failed to get the dimension of the minimum size of the panel", minimumSize, panel
                .getMinimumSize());

            // Tests the look and feel of the UIManager
            assertEquals("Failed to set the look and feel of UIManager", "Metal", UIManager.getLookAndFeel()
                .getName());

            toolBarMainPanelProducer.addNewSectionPanel(ZERO, ZERO, ONE, ONE, nodesPanel);

            // The main panel should be the parent component of this nodesPanel
            assertEquals("Failed to add the nodesPanel to ToolBarMainPanelProducer", nodesPanel.getParent(),
                panel);

            // Since this is the only section panel added the total components in panel must be one
            assertEquals("The number of components in the panel doesn't match", ONE, panel
                .getComponentCount());
        }
        stop();
    }

    /**
     * <p>
     * Tick the system time.
     * </p>
     */
    private void stop() {
        timeTick = System.currentTimeMillis() - timeTick;
        System.out.println(timeTick + "ms");
        if (timeTick >= 10000) {
            fail("Time out!");
        }
    }

    /**
     * <p>
     * Mock implementation of <code>ElementSelectedListener</code>.
     * </p>
     */
    private final class MockAllListeners implements ElementSelectedListener {

        /**
         * <p>
         * The method to be called when an specified element is selected. Just does a console output saying
         * the listener is invoked.
         * </p>
         *
         * @param button
         *        The <code>ToggleButton</code> instance that is registered by this listener.
         * @param sectionPanel
         *        The <code>SectionPanel</code> instance that the button is added into.
         * @see ElementSelectedListener#elementSelected(JToggleButton, SectionPanel)
         */
        public void elementSelected(JToggleButton button, SectionPanel sectionPanel) {
            System.out.println("elementSelected of AllElementSelectedListeners is invoked");
        }
    }
}
