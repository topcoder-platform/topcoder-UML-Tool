/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.ui;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionHeader;
import com.topcoder.gui.sectionlayout.TestHelper;
import com.topcoder.gui.sectionlayout.dock.MockDragInitListener;
import com.topcoder.gui.sectionlayout.model.DefaultSectionModel;
import com.topcoder.gui.sectionlayout.model.SectionModel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>DefaultSectionHeaderUI</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultSectionHeaderUITests extends TestCase {

    /**
     * <p>
     * The DefaultSectionHeaderUI instance for helping testing.
     * </p>
     */
    private DefaultSectionHeaderUI ui;

    /**
     * <p>
     * The SectionModel instance for helping testing.
     * </p>
     */
    private SectionModel model;

    /**
     * <p>
     * The Section instance for helping testing.
     * </p>
     */
    private Section section;

    /**
     * <p>
     * The SectionHeader instance for helping testing.
     * </p>
     */
    private SectionHeader header;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.configUIManager();

        ui = new DefaultSectionHeaderUI();
        model = new DefaultSectionModel();
        section = new Section(new JPanel());
        section.setDragInitListener(new MockDragInitListener());
        header = new SectionHeader(section, model);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        ui = null;
        model = null;
        section = null;
        header = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultSectionHeaderUITests.class);
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#DefaultSectionHeaderUI() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionHeaderUI#DefaultSectionHeaderUI() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created DefaultSectionHeaderUI should not be null.", ui);
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#createUI(JComponent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionHeaderUI#createUI(JComponent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateUI() throws Exception {
        assertNotNull("The ui should not be null.", DefaultSectionHeaderUI.createUI(header));
        assertTrue("The ui should be a DefaultSectionHeaderUI instance.",
                DefaultSectionHeaderUI.createUI(header) instanceof DefaultSectionHeaderUI);
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionHeaderUI#installUI(JComponent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI() throws Exception {
        JFrame frame = new JFrame();
        ui.installUI(header);
        frame.getContentPane().add(header);
        frame.pack();
        frame.setVisible(true);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when component is not a SectionHeader instance and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_Component_NotSectionHeader() throws Exception {
        try {
            ui.installUI(new JPanel());
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.height property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_Height_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.height", 0);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.font property is missing and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_Font_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.font", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.expandedHeaderForeGroundColor property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ExpandedHeaderForeGroundColor_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.expandedHeaderForeGroundColor", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.contractedHeaderForeGroundColor property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ContractedHeaderForeGroundColor_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.contractedHeaderForeGroundColor", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.dragAreaLeftX property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_DragAreaLeftX_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.dragAreaLeftX", -1);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.dragAreaUpperY property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_DragAreaUpperY_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.dragAreaUpperY", -1);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.dragAreaWidth property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_DragAreaWidth_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.dragAreaWidth", 0);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.dragAreaHeight property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_DragAreaHeight_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.dragAreaHeight", 0);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.expandedIcon property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ExpandedIcon_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.expandedIcon", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.contractedIcon property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ContractedIcon_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.contractedIcon", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.iconX property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_IconX_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.iconX", -1);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.iconY property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_IconY_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.iconY", -1);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.titleX property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_TitleX_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.titleX", -1);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.titleY property is invalid
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_TitleY_Invalid() throws Exception {
        try {
            UIManager.put("SectionHeader.titleY", -1);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.expandedBgLeftIcon property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ExpandedBgLeftIcon_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.expandedBgLeftIcon", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.expandedBgRightIcon property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ExpandedBgRightIcon_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.expandedBgRightIcon", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.expandedBgMidIcon property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ExpandedBgMidIcon_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.expandedBgMidIcon", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.contractedBgLeftIcon property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ContractedBgLeftIcon_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.contractedBgLeftIcon", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.contractedBgRightIcon property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ContractedBgRightIcon_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.contractedBgRightIcon", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#installUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when SectionHeader.contractedBgMidIcon property is missing
     * and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallUI_ContractedBgMidIcon_Missing() throws Exception {
        try {
            UIManager.put("SectionHeader.contractedBgMidIcon", null);
            ui.installUI(header);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#uninstallUI(JComponent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionHeaderUI#uninstallUI(JComponent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUninstallUI() throws Exception {
        ui.installUI(header);
        ui.uninstallUI(header);
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#uninstallUI(JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when component is not a SectionHeader instance and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUninstallUI_Component_NotSectionHeader() throws Exception {
        try {
            ui.uninstallUI(new JPanel());
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#paint(Graphics, JComponent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionHeaderUI#paint(Graphics, JComponent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaint_Expanded() throws Exception {
        JFrame frame = new JFrame();
        header.getModel().setExpanded(true);
        ui.installUI(header);
        frame.getContentPane().add(header);
        frame.pack();
        frame.setVisible(true);

        // ui.paint(header.getGraphics(), header);
        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#paint(Graphics, JComponent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionHeaderUI#paint(Graphics, JComponent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaint_Contracted() throws Exception {
        JFrame frame = new JFrame();
        header.getModel().setExpanded(false);
        ui.installUI(header);
        frame.getContentPane().add(header);
        frame.pack();
        frame.setVisible(true);

        // ui.paint(header.getGraphics(), header);
        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#paint(Graphics, JComponent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when component is not a SectionHeader instance and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaint_Component_NotSectionHeader() throws Exception {
        try {
            ui.paint(header.getGraphics(), new JPanel());
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#mouseClicked(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : DefaultSectionHeaderUI#mouseClicked(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMouseClicked() throws Exception {
        JFrame frame = new JFrame();
        ui.installUI(header);
        frame.getContentPane().add(header);
        frame.pack();
        frame.setVisible(true);

        Field field = DefaultSectionHeaderUI.class.getDeclaredField("iconArea");
        field.setAccessible(true);
        field.set(ui, new Rectangle(5, 5, 10, 10));
        MouseEvent mouseEvent = new MouseEvent(header, 0, 1000, 0, 10, 10, 1, true);
        ui.mouseClicked(mouseEvent);
        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#mouseEntered(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : DefaultSectionHeaderUI#mouseEntered(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMouseEntered() throws Exception {
        ui.installUI(header);
        MouseEvent mouseEvent = new MouseEvent(header, 0, 0, 0, 10, 10, 1, true);
        ui.mouseEntered(mouseEvent);
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#mouseExited(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : DefaultSectionHeaderUI#mouseExited(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMouseExited() throws Exception {
        ui.installUI(header);
        MouseEvent mouseEvent = new MouseEvent(header, 0, 0, 0, 0, 0, 1, true);
        ui.mouseExited(mouseEvent);
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#mousePressed(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : DefaultSectionHeaderUI#mousePressed(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMousePressed() throws Exception {
        JFrame frame = new JFrame();
        ui.installUI(header);
        frame.getContentPane().add(header);
        frame.pack();
        frame.setVisible(true);

        MouseEvent mouseEvent = new MouseEvent(header, 0, 0, 0, 10, 10, 1, true);
        ui.mousePressed(mouseEvent);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests DefaultSectionHeaderUI#mouseReleased(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : DefaultSectionHeaderUI#mouseReleased(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMouseReleased() throws Exception {
        ui.installUI(header);
        MouseEvent mouseEvent = new MouseEvent(header, 0, 0, 0, 0, 0, 1, true);
        ui.mouseReleased(mouseEvent);
    }
}
