package com.topcoder.umltool.lnf;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.UIManager;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalTabbedPaneUI;

public class UMLToolTabbedPanelUI extends MetalTabbedPaneUI {

    // Background color for unselected tabs that don't have an explicitly
    // set color.
    private Color unselectedBackground;

    private Color unselectedFontColor;

    private Color selectedFontColor;

    private Font selectedFont;

    private Font unselectedFont;

    private boolean tabsOpaque = true;

    // Whether or not we're using ocean. This is cached as it is used
    // extensively during painting.
    private boolean ocean;

    private static int ARC = 4;

    protected void installDefaults() {
        super.installDefaults();
        tabAreaBackground = UIManager.getColor("TabbedPane.tabAreaBackground");
        selectColor = UIManager.getColor("TabbedPane.selected");
        selectHighlight = UIManager.getColor("TabbedPane.selectHighlight");
        tabsOpaque = true;
        UIManager.getBoolean("TabbedPane.tabsOpaque");
        unselectedBackground = UIManager.getColor("TabbedPane.unselectedBackground");
        unselectedFontColor = UIManager.getColor("TabbedPane.unselectedFontColor");
        selectedFontColor = UIManager.getColor("TabbedPane.selectedFontColor");
        selectedFont = UIManager.getFont("TabbedPane.selectedFont");
        unselectedFont = UIManager.getFont("TabbedPane.unselectedFont");

        ocean = false;

    }

    protected boolean shouldFillGap(int currentRun, int tabIndex, int x, int y) {
        boolean result = false;

        if (!tabsOpaque) {
            return false;
        }

        if (currentRun == runCount - 2) { // If it's the second to last row.
            Rectangle lastTabBounds = getTabBounds(tabPane, tabPane.getTabCount() - 1);
            Rectangle tabBounds = getTabBounds(tabPane, tabIndex);
            if (true) {
                int lastTabRight = lastTabBounds.x + lastTabBounds.width - 1;

                // is the right edge of the last tab to the right
                // of the left edge of the current tab?
                if (lastTabRight > tabBounds.x + 2) {
                    return true;
                }
            } else {
                int lastTabLeft = lastTabBounds.x;
                int currentTabRight = tabBounds.x + tabBounds.width - 1;

                // is the left edge of the last tab to the left
                // of the right edge of the current tab?
                if (lastTabLeft < currentTabRight - 2) {
                    return true;
                }
            }
        } else {
            // fill in gap for all other rows except last row
            result = currentRun != runCount - 1;
        }

        return result;
    }

    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex,
        String title, Rectangle textRect, boolean isSelected) {
        Color fontColor;
        Font paintFont;
        if (isSelected) {
            paintFont = selectedFont;
            fontColor = selectedFontColor;
        } else {
            paintFont = unselectedFont;
            fontColor = unselectedFontColor;
        }
        Graphics2D g2d = (Graphics2D) g;

        g2d.setFont(paintFont);
        g2d.setColor(fontColor);
        g2d.drawString(title, textRect.x, textRect.y + metrics.getHeight() - 4);

    }

    protected Color getColorForGap(int currentRun, int x, int y) {
        final int shadowWidth = 4;
        int selectedIndex = tabPane.getSelectedIndex();
        int startIndex = tabRuns[currentRun + 1];
        int endIndex = lastTabInRun(tabPane.getTabCount(), currentRun + 1);
        int tabOverGap = -1;
        // Check each tab in the row that is 'on top' of this row
        for (int i = startIndex; i <= endIndex; ++i) {
            Rectangle tabBounds = getTabBounds(tabPane, i);
            int tabLeft = tabBounds.x;
            int tabRight = (tabBounds.x + tabBounds.width) - 1;
            // Check to see if this tab is over the gap
            if (true) {
                if (tabLeft <= x && tabRight - shadowWidth > x) {

                    return selectedIndex == i ? selectColor : getUnselectedBackgroundAt(i);
                }
            } else {
                if (tabLeft + shadowWidth < x && tabRight >= x) {

                    return selectedIndex == i ? selectColor : getUnselectedBackgroundAt(i);
                }
            }
        }

        return tabPane.getBackground();
    }

    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
        boolean isSelected) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        w = w - 4;

        if (!isSelected)
            h = h - 2;
        if (tabPlacement == TOP) {
            if (isSelected) {
                GradientPaint gradient =
                    new GradientPaint(0, h, UIManager.getColor("Tab.colorStart"), 0, 0, UIManager
                        .getColor("Tab.colorEnd"));
                g2d.setPaint(gradient);
            } else {
                g2d.setColor(getUnselectedBackgroundAt(tabIndex));
            }
            g2d.fillRect(x + 1 + ARC, y, (w - 1) - ARC * 2, h);
            g2d.fillRect(x, y + ARC, w, h - ARC);
            g2d.fillArc(x + 1, y, ARC * 2, ARC * 2, 90, 90);
            g2d.fillArc(x + w - 1 - ARC * 2, y, ARC * 2, ARC * 2, 0, 90);

        } else {
            super.paintTabBackground(g, tabPlacement, tabIndex, x, y, w, h, isSelected);
        }
    }

    protected void paintTopTabBorder(int tabIndex, Graphics g, int x, int y, int w, int h, int btm, int rght,
        boolean isSelected) {

        w = w - 4;

        if (!isSelected)
            h = h - 2;

        int currentRun = getRunForTab(tabPane.getTabCount(), tabIndex);
        int lastIndex = lastTabInRun(tabPane.getTabCount(), currentRun);
        int firstIndex = tabRuns[currentRun];
        boolean leftToRight = true;// MetalUtils.isLeftToRight(tabPane);
        int selectedIndex = tabPane.getSelectedIndex();
        int bottom = h - 1;
        int right = w - 1;

        //
        // Paint Gap
        //
        /*
         * if (shouldFillGap(currentRun, tabIndex, x, y)) { g.translate(x, y);
         *
         * if (leftToRight) { g.setColor(getColorForGap(currentRun, x, y + 1)); g.fillRect(1, 0, 5, 3);
         * g.fillRect(1, 3, 2, 2); } else { g.setColor(getColorForGap(currentRun, x + w - 1, y + 1));
         * g.fillRect(right - 5, 0, 5, 3); g.fillRect(right - 2, 3, 2, 2); }
         *
         * g.translate(-x, -y); }
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.translate(x, y);

        //
        // Paint Border
        //

        g2d.setColor(UIManager.getColor("TabbedPane.borderColor"));

        // Paint slant
        // g.drawLine(1, 5, 6, 0);
        g2d.drawArc(0, 0, ARC * 2, ARC * 2, 90, 90);
        // Paint top
        g2d.drawLine(ARC + 1, 0, right - ARC, 0);
        g2d.drawArc(right - ARC * 2, 0, ARC * 2, ARC * 2, 0, 90);

        g2d.drawLine(right, ARC, right, bottom);
        g2d.drawLine(0, ARC, 0, bottom);

        g2d.translate(-x, -y);
    }

    /**
     * Returns the color to use for the specified tab.
     */
    private Color getUnselectedBackgroundAt(int index) {
        Color color = tabPane.getBackgroundAt(index);
        if (color instanceof UIResource) {
            if (unselectedBackground != null) {
                return unselectedBackground;
            }
        }
        return color;
    }

}
