package com.topcoder.umltool.deploy;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI;
import com.topcoder.umltool.lnf.UMLToolTabbedPanelUI;

public class UMLToolLookAndFeel extends MetalLookAndFeel {

    /**
     * <p>
     * Logo file name for contract icon.
     * <p>
     */
    private static final String CONTRACT_ICON_FILE_NAME = "/images/section_layout/contract.gif";

    /**
     * <p>
     * Logo file name for expand icon.
     * <p>
     */
    private static final String EXPAND_ICON_FILE_NAME = "/images/section_layout/expand.gif";

    /**
     * <p>
     * Logo file name for min button icon in bottom panel.
     * <p>
     */
    private static final String BOTTOM_MIN_ICON_FILE_NAME = "/images/bottom_panel/min.jpg";

    /**
     * <p>
     * Logo file name for full screen button icon in bottom panel.
     * <p>
     */
    private static final String BOTTOM_FULL_ICON_FILE_NAME = "/images/bottom_panel/fullscreen.jpg";

    /**
     * <p>
     * Logo file name for restore button icon in bottom panel.
     * <p>
     */
    private static final String BOTTOM_RESTORE_ICON_FILE_NAME = "/images/bottom_panel/restore.jpg";

    /**
     * <p>
     * Logo file name for expand button icon in side menu.
     * <p>
     */
    private static final String SIDEMENU_EXPAND_ICON_FILE_NAME = "/images/side_menu/expandIcon.jpg";

    /**
     * <p>
     * Logo file name for collapse button icon in side menu.
     * <p>
     */
    private static final String SIDEMENU_COLLAPSE_ICON_FILE_NAME = "/images/side_menu/collapseIcon.jpg";

    /**
     * <p>
     * Logo file name for pin button icon in side menu.
     * <p>
     */
    private static final String SIDEMENU_PIN_ICON_FILE_NAME = "/images/side_menu/pinIcon.jpg";

    /**
     * <p>
     * Logo file x button icon closetab.
     * <p>
     */
    private static final String CLOSETAB_X_ICON_FILE_NAME = "/images/close_tab/x1.gif";

    private static final Color TCUML_GRAY = (new Color(194, 194, 194));

    @Override
    public String getDescription() {
        return "The UMLTool Look and Feel";
    }

    @Override
    public String getID() {
        return "UMLTool L&F";
    }

    @Override
    public String getName() {
        return "UMLTool L&F";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    protected void initClassDefaults(UIDefaults table) {

        super.initClassDefaults(table);

    }

    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);
        try {
            UIManager.put("SectionHeaderUI", "com.topcoder.umltool.deploy.GradSectionHeaderUI");

            UIManager.put("MainFrame.backgroundColor", new Color(110, 110, 110));
            UIManager.put("UMLTabbedPanelUI", new UMLToolTabbedPanelUI());
            UIManager.put("SectionBorderColor", new Color(62, 62, 62));
            UIManager.put(DefaultSectionHeaderUI.class, GradSectionHeaderUI.class.getDeclaredMethod("createUI",
                JComponent.class));
            UIManager.put("SectionHeader.font", new Font("Arial", Font.BOLD, 12));
            UIManager.put("SectionHeader.height", new Integer(20));
            UIManager.put("SectionHeader.expandedHeaderForeGroundColor", Color.white);
            UIManager.put("SectionHeader.contractedHeaderForeGroundColor", Color.black);
            UIManager.put("SectionHeader.dragAreaLeftX", new Integer(20));
            UIManager.put("SectionHeader.dragAreaUpperY", new Integer(0));
            UIManager.put("SectionHeader.dragAreaWidth", new Integer(400));
            UIManager.put("SectionHeader.dragAreaHeight", new Integer(30));
            UIManager.put("SectionHeader.expandedIcon", new ImageIcon(getClass()
                .getResource(EXPAND_ICON_FILE_NAME)));
            UIManager.put("SectionHeader.contractedIcon", new ImageIcon(getClass().getResource(
                CONTRACT_ICON_FILE_NAME)));
            UIManager.put("SectionHeader.iconX", new Integer(5));
            UIManager.put("SectionHeader.iconY", new Integer(5));
            UIManager.put("SectionHeader.titleX", new Integer(25));
            UIManager.put("SectionHeader.titleY", new Integer(15));
            /*
             * UIManager.put("SectionHeader.expandedBgLeftIcon", new ImageIcon(
             * getClass().getResource(EXPAND_LEFT_FILE_NAME))); UIManager.put("SectionHeader.expandedBgRightIcon",
             * new ImageIcon( getClass().getResource(EXPAND_RIGHT_FILE_NAME)));
             * UIManager.put("SectionHeader.expandedBgMidIcon", new ImageIcon(
             * getClass().getResource(EXPAND_FILL_FILE_NAME))); UIManager.put("SectionHeader.contractedBgLeftIcon",
             * new ImageIcon( getClass().getResource(CONTRACT_LEFT_FILE_NAME)));
             * UIManager.put("SectionHeader.contractedBgRightIcon", new ImageIcon(
             * getClass().getResource(CONTRACT_RIGHT_FILE_NAME)));
             * UIManager.put("SectionHeader.contractedBgMidIcon", new ImageIcon(
             * getClass().getResource(CONTRACT_FILL_FILE_NAME)));
             */

            UIManager.put("SectionHeader.contractedBgColorEnd", new Color(253, 253, 253));
            UIManager.put("SectionHeader.contractedBgColorStart", new Color(161, 179, 191));

            UIManager.put("SectionHeader.expandedBgColorEnd", new Color(149, 190, 219));
            UIManager.put("SectionHeader.expandedBgColorStart", new Color(0, 65, 148));

            UIManager.put("ButtomPanel.minIcon", new ImageIcon(getClass().getResource(BOTTOM_MIN_ICON_FILE_NAME)));
            UIManager.put("ButtomPanel.fullIcon",
                new ImageIcon(getClass().getResource(BOTTOM_FULL_ICON_FILE_NAME)));
            UIManager.put("ButtomPanel.restoreIcon", new ImageIcon(getClass().getResource(
                BOTTOM_RESTORE_ICON_FILE_NAME)));

            UIManager.put("SideMenu.expandIcon", new ImageIcon(getClass().getResource(
                SIDEMENU_EXPAND_ICON_FILE_NAME)));
            UIManager.put("SideMenu.collapseIcon", new ImageIcon(getClass().getResource(
                SIDEMENU_COLLAPSE_ICON_FILE_NAME)));
            UIManager.put("SideMenu.pinIcon", new ImageIcon(getClass().getResource(SIDEMENU_PIN_ICON_FILE_NAME)));

            UIManager.put("DockContainerPanel.backgroundColor", TCUML_GRAY);
            UIManager.put("Section.backgroundColor", TCUML_GRAY);
            UIManager.put("SectionHeader.backgroundColor", TCUML_GRAY);

            UIManager.put("SideMenu.expandedColor", TCUML_GRAY);
            UIManager.put("SideMenu.collapsedColor", TCUML_GRAY);
            UIManager.put("SideMenu.backgroundColor", TCUML_GRAY);
            UIManager.put("SideMenu.borderColor", new Color(59, 59, 59));
            UIManager.put("BottomPane.borderColor", new Color(59, 59, 59));
            UIManager.put("BottomPane.backgroundColor", TCUML_GRAY);

            UIManager.put("SplitPanel.borderColor", new Color(110, 110, 110));
            UIManager.put("SplitPanel.backgroundColor", new Color(110, 110, 110));

            UIManager.put("DiagramViewer.borderColor", new Color(110, 110, 110));
            UIManager.put("DiagramViewer.backgroundColor", new Color(110, 110, 110));

            UIManager.put("DiagramView.borderColor", new Color(0, 65, 148));

            UIManager.put("DiagramView.diagramNameFont", new Font("Arial", Font.BOLD, 18));
            UIManager.put("DiagramView.diagramNameBackgroundColor", new Color(219, 229, 241));
            UIManager.put("DiagramView.diagramNameForegroundColor", new Color(54, 95, 145));

            UIManager.put("LogoPane.backgroundColor", new Color(110, 110, 110));
            UIManager.put("ZoomPanel.backgroundColor", new Color(110, 110, 110));

            UIManager.put("Tab.colorStart", new Color(200, 221, 242));
            UIManager.put("Tab.colorEnd", new Color(255, 255, 255));
            UIManager.put("TabbedPane.unselectedBackground", new Color(138, 138, 138));
            UIManager.put("TabbedPane.borderColor", new Color(59, 59, 59));

            UIManager.put("TabbedPane.selectedFont", new Font("Arial", Font.BOLD, 12));

            UIManager.put("TabbedPane.selectedFontColor", new Color(59, 59, 59));

            UIManager.put("TabbedPane.unselectedFont", new Font("Arial", Font.PLAIN, 12));

            UIManager.put("TabbedPane.unselectedFontColor", new Color(238, 238, 238));

            UIManager.put("SideMenu.pinIcon", new ImageIcon(getClass().getResource(SIDEMENU_PIN_ICON_FILE_NAME)));

            UIManager.put("CloseTab.xIcon", CLOSETAB_X_ICON_FILE_NAME);

        } catch (SecurityException e) {
            DeployHelper.logException(e);

        } catch (NoSuchMethodException e) {
            DeployHelper.logException(e);
        }
    }

}
