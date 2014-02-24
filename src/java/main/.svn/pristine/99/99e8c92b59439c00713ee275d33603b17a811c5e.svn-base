package com.topcoder.umltool.lnf;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;

/**
 * <p>
 * The custom component represents the header of the BottomPanel control. *
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>: It extends <code>JComponent</code> so it is not thread-safe as
 * <code>JComponent</code> is not thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class BottomHeader extends JComponent implements MouseListener {
    /**
     * <p>
     * Represents the button height
     * </p>
     */
    private final static int BUTTON_HEIGHT = 20;

    /**
     * <p>
     * Represents the button width
     * </p>
     */
    private final static int BUTTON_WIDTH = 20;

    /**
     * <p>
     * Represents the button top position
     * </p>
     */
    private final static int BUTTON_TOP = 3;

    private final JComponent overlap;

    /**
     * <p>
     * Represents the header button in control. It is initialized in constructor, and never changed later.
     * </p>
     */
    private final JButton[] buttons;

    public BottomHeader(JButton[] buttons, JComponent overlap) {
        this.buttons = buttons;
        this.addMouseListener(this);
        this.overlap = overlap;
    }

    /**
     * Paints this component.
     *
     * @param g
     *            the graphics context to use for painting
     */
    public void paint(Graphics g) {
        setSize(new Dimension(getWidth(), BUTTON_TOP * 2 + BUTTON_HEIGHT));

        // setBounds(getWidth(), 0, getWidth(), BUTTON_TOP*2+BUTTON_HEIGHT);
        for (int i = 0; i < buttons.length; i++) {
            int left = getWidth() - (buttons.length - i) * BUTTON_WIDTH;
            g.translate(left, BUTTON_TOP);
            buttons[i].setBorderPainted(false);
            buttons[i].setVisible(true);
            buttons[i].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            buttons[i].paint(g);
            g.translate(-left, -BUTTON_TOP);
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     */
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            int left = getWidth() - (buttons.length - i) * BUTTON_WIDTH;
            if (e.getX() >= left && e.getX() <= left + BUTTON_WIDTH && e.getY() >= BUTTON_TOP
                && e.getY() <= BUTTON_TOP + BUTTON_HEIGHT) {
                buttons[i].doClick();
            }
        }
        MouseEvent ee =
            new MouseEvent(overlap, e.getID(), (new Date()).getTime(), e.getModifiers(), e.getX(), e.getY(), e
                .getClickCount(), e.isPopupTrigger());

        overlap.dispatchEvent(ee);

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     */
    public void mousePressed(MouseEvent e) {
        MouseEvent ee =
            new MouseEvent(overlap, e.getID(), (new Date()).getTime(), e.getModifiers(), e.getX(), e.getY(), e
                .getClickCount(), e.isPopupTrigger());

        overlap.dispatchEvent(ee);
    }

    /**
     * Invoked when a mouse button has been released on a component.
     */
    public void mouseReleased(MouseEvent e) {
        MouseEvent ee =
            new MouseEvent(overlap, e.getID(), (new Date()).getTime(), e.getModifiers(), e.getX(), e.getY(), e
                .getClickCount(), e.isPopupTrigger());

        overlap.dispatchEvent(ee);
    }

    /**
     * Invoked when the mouse enters a component.
     */
    public void mouseEntered(MouseEvent e) {
        MouseEvent ee =
            new MouseEvent(overlap, e.getID(), (new Date()).getTime(), e.getModifiers(), e.getX(), e.getY(), e
                .getClickCount(), e.isPopupTrigger());

        overlap.dispatchEvent(ee);
    }

    /**
     * Invoked when the mouse exits a component.
     */
    public void mouseExited(MouseEvent e) {
        MouseEvent ee =
            new MouseEvent(overlap, e.getID(), (new Date()).getTime(), e.getModifiers(), e.getX(), e.getY(), e
                .getClickCount(), e.isPopupTrigger());

        overlap.dispatchEvent(ee);
    }
}
