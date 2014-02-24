package com.topcoder.umltool.deploy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

import com.topcoder.gui.sectionlayout.Helper;
import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionHeader;
import com.topcoder.gui.sectionlayout.dock.DragInitListener;
import com.topcoder.gui.sectionlayout.ui.SectionHeaderUI;

public class GradSectionHeaderUI extends SectionHeaderUI implements MouseListener {

    /**
     * <p>
     * Represents the section header. Initialized in installUI method, released in uninstallUI.
     * </p>
     */
    private SectionHeader header;

    /**
     * <p>
     * Represents the height of this section header. Set in installUI method. Should be positive. Release in
     * uninstallUI method.
     * </p>
     */
    private int height;

    /**
     * <p>
     * Represents the foreground color when the section expanded. Set in installUI method. Can't be null. Release
     * in uninstallUI method.
     * </p>
     */
    private Color expandedHeaderForeGroundColor;

    /**
     * <p>
     * Represents the foreground color when the section contracted. Set in installUI method. Can't be null. Release
     * in uninstallUI method.
     * </p>
     */
    private Color contractedHeaderForeGroundColor;

    /**
     * <p>
     * Represents the x of upper-left point of drag area. Set in installUI method. Should be positive or zero.
     * Release in uninstallUI method.
     * </p>
     */
    private int dragAreaLeftX;

    /**
     * <p>
     * Represents the y of upper-left point of drag area. Set in installUI method. Should be positive or zero.
     * Release in uninstallUI method.
     * </p>
     */
    private int dragAreaUpperY;

    /**
     * <p>
     * Represents the width of drag area. Set in installUI method. Should be positive. Release in uninstallUI
     * method.
     * </p>
     */
    private int dragAreaWidth;

    /**
     * <p>
     * Represents the height of drag area. Set in installUI method. Should be positive. Release in uninstallUI
     * method.
     * </p>
     */
    private int dragAreaHeight;

    /**
     * <p>
     * Represents the icon placed in the header when the section is expanded. Set in installUI method. Should not
     * be null. Release in uninstallUI method.
     * </p>
     */
    private Icon expandedIcon;

    /**
     * <p>
     * Represents the icon placed in the header when the section is contracted. Set in installUI method. Should not
     * be null. Release in uninstallUI method.
     * </p>
     */
    private Icon contractedIcon;

    /**
     * <p>
     * Represents the x of the upper-left point to the expand/contract icon. Set in installUI method. Should be
     * positive or zero. Release in uninstallUI method.
     * </p>
     */
    private int iconX;

    /**
     * <p>
     * Represents the Y of the upper-left point to the expand/contract icon. Set in installUI method. Should be
     * positive or zero. Release in uninstallUI method.
     * </p>
     */
    private int iconY;

    /**
     * <p>
     * Represents the x of the upper-left point to the title. Set in installUI method. Should be positive or zero.
     * Release in uninstallUI method.
     * </p>
     */
    private int titleX;

    /**
     * <p>
     * Represents the Y of the upper-left point to the title. Set in installUI method. Should be positive or zero.
     * Release in uninstallUI method.
     * </p>
     */
    private int titleY;

    /**
     * <p>
     * Represents the drag area. Set in installUI method. Release in uninstallUI method.
     * </p>
     */
    private Rectangle dragArea;

    /**
     * <p>
     * Represents the expand/contract icon area. Set in installUI method. Release in uninstallUI method.
     * </p>
     */
    private Rectangle iconArea;

    /**
     * <p>
     * The timestamp of the last mouse click in the icon area. Set in mouseClicked method.
     * </p>
     */
    private long lastIconClickTimeStamp = 0;

    private Color expandedBgColorStart;

    private Color expandedBgColorEnd;

    private Color contractedBgColorStart;

    private Color contractedBgColorEnd;

    private final static int ARC = 5;

    public GradSectionHeaderUI() {
    }

    /**
     * <p>
     * Creates the CompontUI for SectionHeader component.
     * </p>
     *
     * @param c
     *            the JComponent instance
     * @return the UI instance
     */
    public static ComponentUI createUI(JComponent c) {
        return new GradSectionHeaderUI();
    }

    /**
     * <p>
     * Install the UI instance for the SectionHeader component.
     * </p>
     *
     * @param component
     *            the SectionHeader component
     * @throws IllegalArgumentException
     *             if component is not a SectionHeader instance, or any property is missing, Note that if int
     *             properties is not set, it will be 0, IAE will not thrown.
     */
    public void installUI(JComponent component) {
        checkSectionHeader(component);

        // add this instance as a mouse listener to the component
        component.addMouseListener(this);
        component.setOpaque(false);

        // initialize header
        header = (SectionHeader) component;
        header.setFont(getFont("SectionHeader.font"));
        component.setBackground(getColor("SectionHeader.backgroundColor"));

        // initialize every property in this instance from UIManager
        height = getIntPositive("SectionHeader.height");
        expandedHeaderForeGroundColor = getColor("SectionHeader.expandedHeaderForeGroundColor");
        contractedHeaderForeGroundColor = getColor("SectionHeader.contractedHeaderForeGroundColor");
        dragAreaLeftX = getIntNotNegative("SectionHeader.dragAreaLeftX");
        dragAreaUpperY = getIntNotNegative("SectionHeader.dragAreaUpperY");
        dragAreaWidth = getIntPositive("SectionHeader.dragAreaWidth");
        dragAreaHeight = getIntPositive("SectionHeader.dragAreaHeight");
        expandedIcon = getIcon("SectionHeader.expandedIcon");
        contractedIcon = getIcon("SectionHeader.contractedIcon");
        iconX = getIntNotNegative("SectionHeader.iconX");
        iconY = getIntNotNegative("SectionHeader.iconY");
        titleX = getIntNotNegative("SectionHeader.titleX");
        titleY = getIntNotNegative("SectionHeader.titleY");
        dragArea = new Rectangle(dragAreaLeftX, dragAreaUpperY, dragAreaWidth, dragAreaHeight);
        iconArea = new Rectangle(iconX, iconY, expandedIcon.getIconWidth(), expandedIcon.getIconHeight());
        this.contractedBgColorEnd = getColor("SectionHeader.contractedBgColorEnd");
        this.contractedBgColorStart = getColor("SectionHeader.contractedBgColorStart");

        this.expandedBgColorEnd = getColor("SectionHeader.expandedBgColorEnd");
        this.expandedBgColorStart = getColor("SectionHeader.expandedBgColorStart");
    }

    /**
     * <p>
     * Uninstall the UI instance for the SectionHeader component.
     * </p>
     *
     * @param component
     *            the SectionHeader component
     * @throws IllegalArgumentException
     *             if component is not a SectionHeader instance
     */
    public void uninstallUI(JComponent component) {
        checkSectionHeader(component);

        // remove this instance as a mouse listener to the component
        component.removeMouseListener(this);
        header = null;

        // clear all the properties
        height = -1;
        expandedHeaderForeGroundColor = null;
        contractedHeaderForeGroundColor = null;
        dragAreaLeftX = -1;
        dragAreaUpperY = -1;
        dragAreaWidth = -1;
        dragAreaHeight = -1;
        expandedIcon = null;
        contractedIcon = null;
        iconX = -1;
        iconY = -1;
        titleX = -1;
        titleY = -1;

        dragArea = null;
        iconArea = null;
        this.contractedBgColorEnd = null;
        this.contractedBgColorStart = null;

        this.expandedBgColorEnd = null;
        this.expandedBgColorStart = null;
    }

    /**
     * <p>
     * Paint the SectionHeader.
     * </p>
     *
     * @param g
     *            the Graphics instance to draw
     * @param c
     *            the SectionHeader component
     * @throws IllegalArgumentException
     *             if component is not a SectionHeader instance
     */
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        checkSectionHeader(c);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // We don't want to paint inside of the insets or borders
        Insets insets = c.getInsets();
        g2d.translate(insets.left, insets.top);

        // set height
        c.setSize(new Dimension(c.getWidth(), height));

        int paintWidth = c.getWidth() - insets.left - insets.right;

        if (header.getModel().isExpanded()) { // expanded
            // set foreground color
            c.setForeground(expandedHeaderForeGroundColor);
            Color oldcolor = g.getColor();
            g2d.setColor(getColor("SectionHeader.backgroundColor"));
            g2d.fillRect(0, 0, c.getWidth(), height);
            g2d.setColor(getColor("SectionBorderColor"));

            // Paint slant
            // g.drawLine(1, 5, 6, 0);
            g2d.drawArc(0, 0, ARC * 2, ARC * 2, 90, 90);
            // Paint top
            g2d.drawLine(ARC + 1, 0, c.getWidth() - ARC, 0);
            g2d.drawArc(c.getWidth() - ARC * 2 - 1, 0, ARC * 2, ARC * 2, 0, 90);
            g2d.drawLine(0, ARC, 0, height - 1);
            g2d.drawLine(c.getWidth() - 1, ARC, c.getWidth() - 1, height - 1);
            g2d.drawLine(0, height - 2, c.getWidth(), height - 2);

            GradientPaint gradient = new GradientPaint(0, height, expandedBgColorStart, 0, 0, expandedBgColorEnd);
            g2d.setPaint(gradient);
            g2d.fillArc(1, 1, ARC * 2, ARC * 2, 90, 90);

            g2d.fillArc(c.getWidth() - ARC * 2 - 1, 1, ARC * 2, ARC * 2, 0, 90);
            g2d.fillRect(ARC + 1, 1, c.getWidth() - ARC * 2 - 2, height - 3);
            g2d.fillRect(1, ARC, ARC * 2, height - ARC - 2);
            g2d.fillRect(c.getWidth() - ARC * 2 - 1, ARC, ARC * 2, height - ARC - 2);
            g2d.setColor(oldcolor);
            // in the drag area, draw the points matrix
            if (!header.getModel().isFloating()) {
                // if it is not in floating state, paint the expanded icon
                expandedIcon.paintIcon(c, g, iconX, iconY);
            }
        } else { // contracted
            // set foreground color
            c.setForeground(contractedHeaderForeGroundColor);
            Color oldcolor = g.getColor();

            g2d.setColor(getColor("SectionHeader.backgroundColor"));
            g2d.fillRect(0, 0, c.getWidth(), height);
            g2d.setColor(getColor("SectionBorderColor"));

            // Paint slant
            // g.drawLine(1, 5, 6, 0);
            g2d.drawArc(0, 0, ARC * 2, ARC * 2, 90, 90);
            // Paint top
            g2d.drawLine(ARC + 1, 0, c.getWidth() - ARC, 0);
            g2d.drawArc(c.getWidth() - ARC * 2 - 1, 0, ARC * 2, ARC * 2, 0, 90);
            g2d.drawLine(0, ARC, 0, height - 2);
            g2d.drawLine(c.getWidth() - 1, ARC, c.getWidth() - 1, height - 2);
            g2d.drawLine(0, height - 2, c.getWidth(), height - 2);

            GradientPaint gradient =
                new GradientPaint(0, height, contractedBgColorStart, 0, 0, contractedBgColorEnd);
            g2d.setPaint(gradient);
            g2d.fillArc(1, 1, ARC * 2, ARC * 2, 90, 90);

            g2d.fillArc(c.getWidth() - ARC * 2 - 1, 1, ARC * 2, ARC * 2, 0, 90);
            g2d.fillRect(ARC + 1, 1, c.getWidth() - ARC * 2 - 2, height - 3);
            g2d.fillRect(1, ARC, ARC * 2, height - ARC - 2);
            g2d.fillRect(c.getWidth() - ARC * 2 - 1, ARC, ARC * 2, height - ARC - 2);
            g2d.setColor(oldcolor);
            // paint the drag area
            // in the drag area, draw the points matrix
            if (!header.getModel().isFloating()) {
                // if it is not in floating state, paint the contracted icon
                contractedIcon.paintIcon(c, g, iconX, iconY);
            }
        }

        // draw the title
        g2d.drawString(header.getModel().getTitle(), titleX, titleY);

        g2d.translate(-insets.left, -insets.top);
    }

    private int calcMidColor(int c1, int c2, int x, int x1, int x2) {
        return (c1 * (x - x1) + c2 * (x2 - x)) / (x2 - x1);
    }

    private Color calcMidColor(Color c1, Color c2, int x, int x1, int x2) {
        int r = calcMidColor(c1.getRed(), c2.getRed(), x, x1, x2);
        int g = calcMidColor(c1.getGreen(), c2.getGreen(), x, x1, x2);
        int b = calcMidColor(c1.getBlue(), c2.getBlue(), x, x1, x2);
        return new Color(r, g, b);
    }

    private int calcArcWidth(int h) {
        if (h > ARC)
            return 0;
        int w1 = ARC - h;
        double w2 = Math.sqrt(ARC * ARC - w1 * w1);
        return ARC - (int) w2;
    }

    /**
     * <p>
     * This method will be invoked when the mouse enter into the section header component.
     * </p>
     *
     * @param e
     *            the mouse event
     */
    public void mouseEntered(MouseEvent e) {
        // do nothing
    }

    /**
     * <p>
     * This method will be invoked when the mouse exits from the section header component.
     * </p>
     *
     * @param e
     *            the mouse event
     */
    public void mouseExited(MouseEvent e) {
        // do nothing
    }

    /**
     * <p>
     * This method will be invoked when the mouse released in the section header component.
     * </p>
     *
     * @param e
     *            the mouse event
     */
    public void mouseReleased(MouseEvent e) {
        // do nothing
    }

    /**
     * <p>
     * Gets the Color property from UIManager.
     * </p>
     *
     * @param key
     *            the property key
     * @return the Color
     * @throws IllegalArgumentException
     *             if the property is missing
     */
    private Color getColor(Object key) {
        Color color = null;
        color = UIManager.getColor(key);
        if (color == null) {
            throw new IllegalArgumentException("The property [" + key + "] should be set.");
        }
        return color;
    }

    /**
     * <p>
     * Gets the Font property from UIManager.
     * </p>
     *
     * @param key
     *            the property key
     * @return the Font
     * @throws IllegalArgumentException
     *             if the property is missing
     */
    private Font getFont(Object key) {
        Font font = null;
        font = UIManager.getFont(key);
        if (font == null) {
            throw new IllegalArgumentException("The property [" + key + "] should be set.");
        }
        return font;
    }

    /**
     * <p>
     * Gets the Icon property from UIManager.
     * </p>
     *
     * @param key
     *            the property key
     * @return the Icon
     * @throws IllegalArgumentException
     *             if the property is missing
     */
    private Icon getIcon(Object key) {
        Icon icon = null;
        icon = UIManager.getIcon(key);
        if (icon == null) {
            throw new IllegalArgumentException("The property [" + key + "] should be set.");
        }
        return icon;
    }

    /**
     * <p>
     * Gets the int property from UIManager.
     * </p>
     *
     * @param key
     *            the property key
     * @return the int property value
     * @throws IllegalArgumentException
     *             if the property is not positive
     */
    private int getIntPositive(Object key) {
        int value = -1;
        value = UIManager.getInt(key);
        Helper.checkNotPositive(value, key.toString());
        return value;
    }

    /**
     * <p>
     * Gets the int property from UIManager.
     * </p>
     *
     * @param key
     *            the property key
     * @return the int property value
     * @throws IllegalArgumentException
     *             if the property is negative
     */
    private int getIntNotNegative(Object key) {
        int value = -1;
        value = UIManager.getInt(key);
        Helper.checkNegative(value, key.toString());
        return value;
    }

    /**
     * <p>
     * Checks whether the component is a SectionHeader instance.
     * </p>
     *
     * @param component
     *            The component to be checked
     * @throws IllegalArgumentException
     *             if the component is not a SectionHeader instance
     */
    private void checkSectionHeader(JComponent component) {
        if (!(component instanceof SectionHeader)) {
            throw new IllegalArgumentException("The component should be a SectionHeader instance.");
        }
    }

    /**
     * <p>
     * This method will be invoked when the mouse clicked on the section header component.
     * </p>
     *
     * @param e
     *            the mouse event
     */
    public void mouseClicked(MouseEvent e) {
        // if mouse clicked in iconArea
        if (iconArea.contains(e.getPoint())) {
            // if there are more than 100ms between recently two mouse clicked
            if ((e.getWhen() - lastIconClickTimeStamp) > 100) {
                Section section = header.getSection();
                boolean expanded = section.isExpanded();
                // if the section is expanded, set it to contracted, otherwise set it to expanded
                section.setExpanded(!expanded);
                // set the time stamp
                lastIconClickTimeStamp = e.getWhen();
            }
            e.consume();
        }
    }

    /**
     * <p>
     * This method will be invoked when the mouse pressed on the section header component.
     * </p>
     *
     * @param e
     *            the mouse event
     */
    public void mousePressed(MouseEvent e) {
        // if mouse pressed in dragArea
        if (dragArea.contains(e.getPoint())) {
            Section section = header.getSection();
            DragInitListener dragInitListener = section.getDragInitListener();
            if (dragInitListener != null) {
                // initialize drag
                dragInitListener.dragInitialized(e, section);
            }
            e.consume();
        }
    }
}
