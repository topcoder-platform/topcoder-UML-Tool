/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.accuracytests;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import com.topcoder.gui.toolbars.elements.ElementSelectedListener;
import com.topcoder.gui.toolbars.elements.SectionPanel;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link SectionPanel}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class SectionPanelAccuracyTests extends TestCase {

    /**
     * <p>
     * Represents the <code>{@link SectionPanel}</code> instance used in tests.
     * </p>
     */
    private SectionPanel sectionPanel;

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
        AccuracyTestHelper.loadNamespaces();
        sectionPanel = new SectionPanel("accuracy", Color.BLUE, new String[] {"Btn1"},
            new ImageIcon[] {new ImageIcon()}, UIManager.getCrossPlatformLookAndFeelClassName());
    }

    /**
     * <p>
     * Tear down the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        AccuracyTestHelper.clearNamespaces();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link SectionPanel#SectionPanel(String, Color, String[], ImageIcon[], String)}</code>
     * constructor.
     * </p>
     */
    public void testSectionPanelFiveArgsAccuracy() {
        // case 1
        sectionPanel = new SectionPanel("accuracy", Color.BLUE, new String[] {"Btn1"},
            new ImageIcon[] {new ImageIcon()}, UIManager.getCrossPlatformLookAndFeelClassName());

        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "buttonsMap"));
        assertTrue(((Map) AccuracyTestHelper.getPrivateField(SectionPanel.class, sectionPanel, "buttonsMap")).size() == 1);
        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "listenersMap"));
        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "listener"));

        // case 2
        sectionPanel = new SectionPanel("", Color.BLUE, new String[] {"Btn1"}, new ImageIcon[] {new ImageIcon()},
            UIManager.getCrossPlatformLookAndFeelClassName());

        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "buttonsMap"));
        assertTrue(((Map) AccuracyTestHelper.getPrivateField(SectionPanel.class, sectionPanel, "buttonsMap")).size() == 1);
        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "listenersMap"));
        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "listener"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link SectionPanel#SectionPanel(String)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testSectionPanelStringAccuracy() throws Exception {
        sectionPanel = new SectionPanel("com.topcoder.gui.toolbars.elements.accuracy");
        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "buttonsMap"));
        assertTrue(((Map) AccuracyTestHelper.getPrivateField(SectionPanel.class, sectionPanel, "buttonsMap")).size() == 2);
        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "listenersMap"));
        assertNotNull("sectionPanel creation failed", AccuracyTestHelper.getPrivateField(SectionPanel.class,
            sectionPanel, "listener"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link SectionPanel#unselectButton(String)}</code> method.
     * </p>
     */
    public void testUnselectButtonAccuracy() {
        Map buttonsMap = (Map) AccuracyTestHelper.getPrivateField(SectionPanel.class, sectionPanel, "buttonsMap");
        JToggleButton btn1 = (JToggleButton) buttonsMap.get("Btn1");
        btn1.setSelected(true);

        sectionPanel.unselectButton("Btn1");

        assertFalse(btn1.isSelected());
    }

    /**
     * <p>
     * Accuracy test for <code>{@link SectionPanel#addElementSelectedListener(String, ElementSelectedListener)}</code>
     * method.
     * </p>
     */
    public void testAddElementSelectedListenerAccuracy() {
        ElementSelectedListener elementSelectedListener = new ElementSelectedListener() {
            public void elementSelected(JToggleButton button, SectionPanel sectionPanel) {
            }
        };

        Map listenersMap = (Map) AccuracyTestHelper.getPrivateField(SectionPanel.class, sectionPanel, "listenersMap");

        sectionPanel.addElementSelectedListener("Btn1", elementSelectedListener);

        assertTrue(((List) listenersMap.get("Btn1")).contains(elementSelectedListener));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link SectionPanel#RemoveElementSelectedListener(String, ElementSelectedListener)}</code> method.
     * </p>
     */
    public void testRemoveElementSelectedListenerAccuracy() {
        ElementSelectedListener elementSelectedListener = new ElementSelectedListener() {
            public void elementSelected(JToggleButton button, SectionPanel sectionPanel) {
            }
        };

        Map listenersMap = (Map) AccuracyTestHelper.getPrivateField(SectionPanel.class, sectionPanel, "listenersMap");
        sectionPanel.addElementSelectedListener("Btn1", elementSelectedListener);

        sectionPanel.removeElementSelectedListener("Btn1", elementSelectedListener);

        assertFalse(((List) listenersMap.get("Btn1")).contains(elementSelectedListener));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link SectionPanel#addListenerForAllButtons(ElementSelectedListener)}</code> method.
     * </p>
     */
    public void testAddListenerForAllButtonsAccuracy() {
        ElementSelectedListener elementSelectedListener = new ElementSelectedListener() {
            public void elementSelected(JToggleButton button, SectionPanel sectionPanel) {
            }
        };

        sectionPanel = new SectionPanel("accuracy", Color.BLUE, new String[] {"Btn1", "Btn2"}, new ImageIcon[] {
            new ImageIcon(), new ImageIcon()}, UIManager.getCrossPlatformLookAndFeelClassName());

        Map listenersMap = (Map) AccuracyTestHelper.getPrivateField(SectionPanel.class, sectionPanel, "listenersMap");

        sectionPanel.addListenerForAllButtons(elementSelectedListener);

        assertTrue(((List) listenersMap.get("Btn1")).contains(elementSelectedListener));
        assertTrue(((List) listenersMap.get("Btn2")).contains(elementSelectedListener));
    }
}
