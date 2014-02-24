/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.gridrenderers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.gui.diagramviewer.DVHelper;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.GridRenderer;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;

/**
 * <p>
 * A simple implementation of the GridRender interface. The grid in the active
 * area is painted differently (lighter) than the grid outside the active area.
 * The grid size can be configured by accessing field gridSize.
 * </p>
 * <p>
 * Thread safety: this class is mutable and not thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class SimpleGridRenderer implements GridRenderer {

    /**
     * <p>
     * Represents the size of the grid.
     * </p>
     * <p>
     * Initialized in ctor, must be positive. Can be accessed by
     * getter and setter.
     * </p>
     */
    private int gridSize;

    /**
     * <p>
     * Default empty ctor.
     * </p>
     * @param gridSize the gridSize of the grid.
     */
    public SimpleGridRenderer(int gridSize) {
        DVHelper.validatePositive(gridSize, "gridSize");
        this.gridSize = gridSize;
    }

    /**
     * <p>
     * Render background grid for the given DiagramView.
     * </p>
     *
     * @param graphics the graphics context
     * @param diagramView the DiagramView for which the grid is rendered
     * @throws IllegalArgumentException if any of the args is null
     */
    public void renderGrid(Graphics graphics, DiagramView diagramView) {
        DVHelper.validateNotNull(graphics, "graphics");
        DVHelper.validateNotNull(diagramView, "diagramView");
        // Record the original color:
        Color originalColor = graphics.getColor();
        // Compute the number of rows and columns of the grid:
        int row = diagramView.getHeight() / gridSize;
        int columns = diagramView.getWidth() / gridSize;
        // Draw grid as the whole area is inactive:
        graphics.setColor(Color.gray);
        // for each row draw a horizontal line;
        // for each columns draw a vertical line;
        for (int i = 0; i <= row; i++) {
            graphics.drawLine(0, i * gridSize, diagramView.getWidth(), i * gridSize);

        }
        for (int i = 0; i <= columns; i++) {
            graphics.drawLine(i * gridSize, 0, i * gridSize, diagramView.getHeight());
        }
        graphics.setColor(originalColor);

        // Compute the active area, using diagramView.getDiagram() and
        // diagramView.getPrefferedDiagramSize():
        Rectangle activeArea = new Rectangle(diagramView.getPreferredDiagramSize());

        double x = 0;
        double y = 0;
        GraphElement node = diagramView.getDiagram();
        while (node.getContainer() != null) {
            x += node.getPosition().getX();
            y += node.getPosition().getY();
            node = node.getContainer();
        }
        activeArea.setLocation((int) Math.round(x) - SelectionCorner.DEFAULT_RADIUS, (int) Math.round(y)
                - SelectionCorner.DEFAULT_RADIUS);

        // Set color to black:

        graphics.setColor(Color.black);
        // Draw grid in the active area as step 1, 2.

        row = (int) (activeArea.getHeight() / gridSize);
        columns = (int) (activeArea.getWidth() / gridSize);
        // Draw grid as the whole area is inactive:

        graphics.setColor(Color.gray);
        // for each row draw a horizontal line;
        // for each columns draw a vertical line;

        for (int i = 0; i <= row; i++) {
            graphics.drawLine(0, i * gridSize, diagramView.getWidth(), i * gridSize);

        }
        for (int i = 0; i <= columns; i++) {
            graphics.drawLine(i * gridSize, 0, i * gridSize, diagramView.getHeight());
        }
        // Restore the color
        graphics.setColor(originalColor);

    }

    /**
     * <p>
     * Getter of gridSize, see field doc for explanation.
     * </p>
     *
     * @return the grid size
     */
    public int getGridSize() {
        return gridSize;
    }

    /**
     * <p>
     * Setter of gridSize, see field doc for explanation.
     * </p>
     *
     * @param gridSize the new grid size
     * @throws IllegalArgumentException if the arg is non-positive
     */
    public void setGridSize(int gridSize) {
        this.gridSize = DVHelper.validatePositive(gridSize, "gridSize");
    }
}
