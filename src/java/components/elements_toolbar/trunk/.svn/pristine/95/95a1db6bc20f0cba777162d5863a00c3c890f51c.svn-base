/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * <p>
 * This class is used to produce the main panel of element toolbar, which contains many other SectionPanel
 * instances in GridBagLayout way.
 * </p>
 * <p>
 * The method &quot;addNewSectionPanel&quot; is used to add new SectionPanel instance into the main panel, whose
 * location and size are set by the arguments. The method &quot;getToolBarMainPanel&quot; is used to retrieve the
 * main panel of element toolbar.
 * </p>
 * <p>
 * Thread Safety: The members are immutable, but the method &quot;addNewSectionPanel&quot; isn't thread safe.
 * Hence, it is not thread safe.
 * </p>
 *
 * <p>
 * Code sample for creating a toolbar panel with 4 section panels (first creates elementsPanel, connectorsPanel,
 * nodesPanel, and empty Panel):
 * </p>
 *
 * <pre>
 * Dimension preferredSize = new Dimension(300, 300);
 * Dimension minimumSize = new Dimension(50, 50);
 * ToolBarMainPanelProducer producer = new ToolBarMainPanelProducer(2, 2, look, preferredSize, minimumSize);
 * producer.addNewSectionPanel(0, 0, 1, 1, elementsPanel);
 * producer.addNewSectionPanel(0, 1, 1, 1, connectorsPanel);
 * producer.addNewSectionPanel(1, 0, 1, 1, nodesPanel);
 * producer.addNewSectionPanel(1, 1, 1, 1, emptyPanel);
 *
 * // Get the main panel from the instance of ToolBarMainPanelProducer.
 * JPanel mainPanel = producer.getToolBarMainPanel();
 * </pre>
 *
 * @author wang_liang, enefem21
 * @version 1.0
 */
public class ToolBarMainPanelProducer {

    /** Constraint weight X value. */
    private static final double CONSTRAINT_WEIGHT_Y = 0.5;

    /** Constraint weight Y value. */
    private static final double CONSTRAINT_WEIGHT_X = 0.5;

    /** Represents the number of rows in GridBagLayout. Positive integer. Not changed after initialization. */
    private final int row;

    /** Represents the number of columns in GridBagLayout. Positive integer. Not changed after initialization. */
    private final int column;

    /**
     * Represents the constrains used in GridBagLayout. It is use to custom every section panel. Not null. Not
     * changed after initialization.
     */
    private final GridBagConstraints constraints;

    /**
     * Represents the main panel, which lays out SectionPanel instances in GridBagLayout way. Not null. Not changed
     * after initialization.
     */
    private final JPanel mainPanel;

    /**
     * <p>
     * Constructor with the number of rows and the number of columns. This constructor is called for the first time
     * when user wants to create a toolbar panel. User has to define the number of rows and columns and also the
     * look and feel class, preferred and minimum size of the panel.
     * </p>
     *
     * @param row
     *            the number of rows, which should be greater than zero.
     * @param column
     *            the number of columns, which should be greater than zero.
     * @param look
     *            the class name of look that the panel should be like. It should not be null.
     * @param preferredSize
     *            preferred size of the main panel
     * @param minimumSize
     *            minimum size of the main panel
     * @throws IllegalArgumentException
     *             if the number of rows or columns is not greater than zero. If look is null. If any exception
     *             happens when setLookAndFeel method is called, throw this exception. If the preferred size or
     *             minimum size is null, throw this exception.
     */
    public ToolBarMainPanelProducer(int row, int column, String look, Dimension preferredSize,
        Dimension minimumSize) {

        // argument check
        ArgumentCheckUtil.checkPositive("row", row);
        ArgumentCheckUtil.checkPositive("column", column);
        ArgumentCheckUtil.checkNotNullAndNotEmpty("look", look);
        ArgumentCheckUtil.checkNotNull("preferredSize", preferredSize);
        ArgumentCheckUtil.checkNotNull("minimumSize", minimumSize);

        // Copy the row and column argument to their relative members.
        this.row = row;
        this.column = column;

        // Initialize the member mainPanel.
        mainPanel = new JPanel();

        // Set the layout of mainPanel to be GridBagLayout.
        mainPanel.setLayout(new GridBagLayout());

        // Initialize the member constraints.
        constraints = new GridBagConstraints();

        // Set resizing behavior of constraints to be GridBagConstraints.BOTH.
        constraints.fill = GridBagConstraints.BOTH;

        // Set the member weightx and weighty of constraints to be 0.5.
        constraints.weightx = CONSTRAINT_WEIGHT_X;
        constraints.weighty = CONSTRAINT_WEIGHT_Y;

        // Set look of the SectionPanel.
        LookAndFeelUtil.setLookAndFeel(look);

        // Set preferredSize and minimumSize of the main panel.
        mainPanel.setPreferredSize(preferredSize);
        mainPanel.setMinimumSize(minimumSize);
    }

    /**
     * <p>
     * Add new SectionPanel instance into the main panel.
     * </p>
     *
     * @param gridx
     *            the cell containing the leading edge of the component's display area, which should be
     *            non-negative value. It also has to be less than column.
     * @param gridy
     *            the cell at the top of the component's display area, which should be non-negative value. It also
     *            has to be less than row.
     * @param gridWidth
     *            the number of cells in a row for the component's display area, which should be non-negative
     *            value. It also has to be less than or equal with column - gridx.
     * @param gridHeight
     *            the number of cells in a column for the component's display area, which should be non-negative
     *            value. It also has to be less than or equal with row - gridy.
     * @param panel
     *            the SectionPanel instance to be added, which should not be null.
     * @throws IllegalArgumentException
     *             if panel is null, or other arguments are negative or not valid.
     */
    public void addNewSectionPanel(int gridx, int gridy, int gridWidth, int gridHeight, SectionPanel panel) {

        // argument check
        ArgumentCheckUtil.checkInRange("gridx", gridx, 0, column);
        ArgumentCheckUtil.checkInRange("gridy", gridy, 0, row);
        ArgumentCheckUtil.checkInRange("gridWidth", gridWidth, 0, column - gridx + 1);
        ArgumentCheckUtil.checkInRange("gridHeight", gridHeight, 0, row - gridy + 1);
        ArgumentCheckUtil.checkNotNull("panel", panel);

        // Set constraints.gridx to be gridx.
        constraints.gridx = gridx;

        // Set constraints.gridy to be gridy.
        constraints.gridy = gridy;

        // Set constraints.gridwidth to be gridWidth.
        constraints.gridwidth = gridWidth;

        // Set constraints.gridheight to be gridHeight.
        constraints.gridheight = gridHeight;

        // Add panel into mainPanel
        mainPanel.add(panel, constraints);
    }

    /**
     * <p>
     * Retrieve the main panel of elements toolbar.
     * </p>
     *
     * @return the mainPanel instance.
     */
    public JPanel getToolBarMainPanel() {
        return mainPanel;
    }
}
