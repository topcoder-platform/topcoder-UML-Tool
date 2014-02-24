/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * <p>
 * Title panel for panels in main frame.
 * </p>
 * <p>
 * Contains a component and add a title label for it.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class TitlePanel extends JPanel {
    /**
     * <p>
     * The serial id.
     * <p>
     */
    private static final long serialVersionUID = 5988424666241633398L;

    /**
     * <p>
     * Represents the title of the panel.
     * </p>
     */
    private final String title;

    /**
     * <p>
     * Represents the JLabel to display the title string.
     * </p>
     */
    private final JLabel label;

    /**
     * <p>
     * Represents the contained component.
     * </p>
     */
    private final JComponent content;

    /**
     * <p>
     * Represents whether the title panel is collapsed.
     * </p>
     */
    private boolean collapsed = false;

    /**
     * <p>
     * Creates an instance of title panel.
     * </p>
     *
     * @param title
     *            title string of the component
     * @param content
     *            the contained component
     */
    public TitlePanel(String title, JComponent content) {
        this.title = title;
        this.content = content;

        this.setLayout(new BorderLayout());
        label = new JLabel(title);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.GRAY);
        label.setOpaque(true);
        label.setBorder(new EmptyBorder(0, 10, 2, 2));

        this.add(label, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
    }

    /**
     * <p>
     * Gets the title string.
     * </p>
     *
     * @return the title string.
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>
     * Gets the contained component.
     * </p>
     *
     * @return the contained component.
     */
    public JComponent getContent() {
        return content;
    }

    /**
     * <p>
     * Gets whether the title panel is collapsed.
     * </p>
     *
     * @return whether the title panel is collapsed.
     */
    public boolean isCollapsed() {
        return collapsed;
    }

    /**
     * <p>
     * Sets the title panel to collapse or not.
     * </p>
     *
     * @param collapsed
     *            collapse or not
     */
    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }

    /**
     * <p>
     * Removes the contained component.
     * </p>
     */
    public void removeContent() {
        this.remove(content);
    }

    /**
     * <p>
     * Adds the contained component.
     * </p>
     */
    public void addContent() {
        this.add(content, BorderLayout.CENTER);
    }

    /**
     * <p>
     * Adds the mouse listener for collapsing.
     * </p>
     *
     * @param collapseMouseListener
     *            mouse listener for collapsing
     */
    public void addCollapseMouseListener(MouseListener collapseMouseListener) {
        label.addMouseListener(collapseMouseListener);
    }
}
